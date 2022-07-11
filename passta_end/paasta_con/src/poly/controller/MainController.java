package poly.controller;

import static poly.util.CmmUtil.nvl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import poly.dto.StudyListDTO;
import poly.dto.UserDTO;
import poly.service.IImgService;
import poly.service.IStudyService;
import poly.service.IUserService;
import poly.util.MbtiUtil;

@Controller
public class MainController {

	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "UserService")
	IUserService userService;

	@Resource(name = "ImgService")
	IImgService imgService;

	@Resource(name = "StudyService")
	IStudyService studyService;

	// MyStudy 메인화면
	@RequestMapping(value = "spoilbroth/mystudy")
	public String mystudy(HttpServletRequest request, HttpSession session, ModelMap model) throws Exception {

		log.info(this.getClass().getClass().getName() + "spoilbroth/mystudy start!!");

		String id = (String) session.getAttribute("user_id");
		String pwd = (String) session.getAttribute("user_pwd");
		if (id == null) {
			return "/user/login";
		}
		System.out.println("user_id : " + id);
		System.out.println("user_pwd : " + pwd);

		UserDTO uDTO = new UserDTO();
		uDTO.setUser_id(id);
		uDTO.setUser_pwd(pwd);

		// 사용자 정보 조회
		UserDTO rDTO = new UserDTO();
		rDTO = userService.getUserInfo(uDTO);

		model.addAttribute("user_id", nvl(rDTO.getUser_id()));
		model.addAttribute("user_name", nvl(rDTO.getUser_name()));
		model.addAttribute("user_email", nvl(rDTO.getUser_email()));
		model.addAttribute("user_dept", nvl(rDTO.getUser_dept()));
		model.addAttribute("user_mbti", nvl(rDTO.getUser_mbti()));
		model.addAttribute("user_study", nvl(rDTO.getUser_study()));

		String[] jrr = rDTO.getUser_study().split(",");

		List<String> aList = new ArrayList<String>();
		for (String j : jrr) {
			aList.add(j);
		}

		// 가입한 스터디 조회 (가입한 스터디를 list로 넘겨서 스터디 정보 가져오기)
		List<StudyListDTO> pList = studyService.getJoinStudyList(aList);
		aList = null;
		model.addAttribute("pList", pList);

		// 스터디에 가입된 유저 MBTI 가져오기
		List<List<String>> mLists = new ArrayList<List<String>>();

		for (StudyListDTO sDTO : pList) {
			List<String> mList = new ArrayList<String>();
			String[] arr = sDTO.getStudy_member().split(",");
			List<String> list = new ArrayList<String>(Arrays.asList(arr));
			log.info("getUserMbti start");
			mList = userService.getUserMbti(list);
			mLists.add(mList);
			list = null;
			mList = null;
			log.info("getUserMbti end");
		}
		for (List<String> dd : mLists) {
			log.info("dd : " + dd);
		}
		// MBTI 점수 분석
		String my_mbti = nvl(rDTO.getUser_mbti());

		log.info("getAnalysis start");
		List<String> mbti_scores = MbtiUtil.getAnalysis(my_mbti, mLists);
		log.info("getAnalysis end");

		for (String str : mbti_scores) {
			log.info("mbti_scores : " + str);
		}
		model.addAttribute("mbti_scores", mbti_scores);
		log.info(this.getClass().getClass().getName() + "spoilbroth/mystudy end!!");

		// 사용자 이미지 불러오기
		// 가장 최근에 등록한 프로필 사진 정보가져오기
		log.info("getImgList start! ");
		Map<String, String> pMap = imgService.getImgList(id);
		log.info("getImgList end! ");
		if (pMap == null) {
			pMap = new HashMap<String, String>();
		}
		String realFile = nvl(pMap.get("SAVE_FILE_PATH") + "/"); // 파일이 저장된 경로 : /usr/local/images/userimg/0000/00/00/
		String fileNm = nvl(pMap.get("SAVE_FILE_NAME")); // 파일명 : 000000.jpg 000000.png
		log.info("realFile : " + realFile);
		log.info("fileNm : " + fileNm);
		if (!fileNm.equals("")) {
			model.addAttribute("user_img", realFile + fileNm);
		} else {
			model.addAttribute("user_img", "/img/basicimg2.jpg");
		}

		// 가입한 스터디 이미지 불러오기
		List<String> iList = new ArrayList<String>();
		for (StudyListDTO iDTO : pList) {
			// 가장 최근에 등록한 스터디 사진 정보가져오기
			log.info("getStudyImgList start! ");
			Map<String, String> iMap = imgService.getStudyImgList(iDTO.getStudy_name());
			if (iMap == null) {
				iMap = new HashMap<String, String>();
			}
			String studyrealFile = nvl(iMap.get("SAVE_FILE_PATH") + "/"); // 파일이 저장된 경로 : /img/studyimg/0000/00/00/
			String studyfileNm = nvl(iMap.get("SAVE_FILE_NAME")); // 파일명

			if (studyfileNm.equals("")) {
				studyrealFile = "/img/";
				studyfileNm = "study.jpg";
			}
			// 가입한 스터디이미지 리스트에 담기
			iList.add(studyrealFile + studyfileNm);
			log.info("getStudyImgList end! ");
		}

		model.addAttribute("iList", iList);
		iList = null;
		
		// 워드 클라우드 가져오기
		HashMap<String, Integer> wMap = new HashMap<String, Integer>();
		log.info("getMbtiCount start ");
		wMap = userService.getMbtiCount();
		log.info("getMbtiCount end ");

		model.addAttribute("wMap", wMap);

		return "spoilbroth/mystudy";
	}

	@RequestMapping(value = "spoilbroth/main")
	public String main(HttpServletRequest request, HttpSession session, ModelMap model) throws Exception {
		log.info(this.getClass().getClass().getName() + "user/login start!!");

		UserDTO uDTO = new UserDTO();
		String id = (String) session.getAttribute("user_id");
		String pwd = (String) session.getAttribute("user_pwd");
		if (id == null) {
			return "/user/login";
		}
		System.out.println("user_id : " + id);
		System.out.println("user_pwd : " + pwd);
		uDTO.setUser_id(id);
		uDTO.setUser_pwd(pwd);

		UserDTO rDTO = new UserDTO();
		rDTO = userService.getUserInfo(uDTO);

		model.addAttribute("user_seq", rDTO.getUser_seq());
		model.addAttribute("user_id", rDTO.getUser_id());
		model.addAttribute("user_pwd", rDTO.getUser_pwd());
		model.addAttribute("user_email", rDTO.getUser_email());
		model.addAttribute("user_age", rDTO.getUser_age());
		model.addAttribute("user_dept", rDTO.getUser_dept());
		model.addAttribute("user_auth", rDTO.getUser_email());
		model.addAttribute("join_dt", rDTO.getJoin_dt());

		return "spoilbroth/main";
	}

}
