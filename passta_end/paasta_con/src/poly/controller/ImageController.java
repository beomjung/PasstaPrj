package poly.controller;

import static poly.util.CmmUtil.nvl;

import java.io.File;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import poly.dto.OcrDTO;
import poly.service.IImgService;
import poly.util.DateUtil;
import poly.util.FileUtil;

@Controller
public class ImageController {

	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "ImgService")
	IImgService imgService;

	// 프로필 이미지가 업로드되는 파일이 저장되는 기본폴더 설정(자바에서 경로는 /로 표현함)
	final private String USERFILE_UPLOAD_SAVE_PATH = "/img/userimg"; // C:\\upload 폴더에 저장 /upload
	// 스터디 이미지가 업로드되는 기본폴더 설정
	final private String STUDYFILE_UPLOAD_SAVE_PATH = "/img/studyimg"; // C:\\upload 폴더에 저장 /upload

	// 프로필 이미지파일 업로드 (ajax로 구현)
	@RequestMapping(value = "FileUplod")
	@ResponseBody
	public void UserFileUpload(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "fileUplod") MultipartFile mf, HttpSession session) throws Exception {
		log.info("UserFileUpload start");

		int res = 0;
		// 이미지 파일 저장하는 사용자 ID
		String user_id = (String) session.getAttribute("user_id");

		// 임의로 정의된 파일명을 원래대로 만들어주기 위한 목적
		String originalFileName = mf.getOriginalFilename();

		// 파일 확장자 가져오기
		String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1, originalFileName.length())
				.toLowerCase();

		// 이미지 파일만 실행되도록 함
		if (ext.equals("jpeg") || ext.equals("jpg") || ext.equals("gif") || ext.equals("png")) {

			// 웹서버에 저장되는 파일이름 (영어, 숫자로 파일명 변경)
			String saveFileName = DateUtil.getDateTime("24hhmmss") + "." + ext;

			// 웹서버에 업로드한 파일 저장하는 물리적 경로
			/* String saveFilePath = USERFILE_UPLOAD_SAVE_PATH; */
			String saveFilePath = FileUtil.mkdirForDate(USERFILE_UPLOAD_SAVE_PATH);
			/*
			 * http:\\/\\/13.125.99.115"+
			 */
			String fullFileInfo = saveFilePath + "/" + saveFileName;
			System.out.println("saveFilePath : " + saveFilePath);
			System.out.println("fullFileInfo : " + fullFileInfo);
			System.out.println("USERFILE_UPLOAD_SAVE_PATH : " + USERFILE_UPLOAD_SAVE_PATH);

			// 정상적으로 값이 생성되었는지 로그에 찍어서 확인
			log.info("ext : " + ext);
			log.info("originalFileName : " + originalFileName);
			log.info("saveFileName : " + saveFileName);
			log.info("saveFilePath : " + saveFilePath);
			log.info("fullFileInfo : " + fullFileInfo);

			String path = request.getSession().getServletContext().getRealPath(saveFilePath);
			System.out.println(path);

			// 업로드 되는 파일을 서버에 저장
			File targetFile = new File(path, saveFileName);
			System.out.println(targetFile.toString());

			if (!targetFile.isDirectory()) {
				targetFile.mkdirs();
			}

			targetFile.setReadable(true, false);
			targetFile.setWritable(true, false);
			targetFile.setExecutable(true, false);

			mf.transferTo(targetFile);

			// 이미지 경로 DB에 저장
			OcrDTO pDTO = new OcrDTO();
			pDTO.setSave_file_name(saveFileName);
			pDTO.setSave_file_path(saveFilePath);
			pDTO.setOrg_file_name(originalFileName);
			pDTO.setExt(ext);
			pDTO.setChg_id(user_id);
			pDTO.setChg_dt(DateUtil.getDateTime("yyyy-MM-dd-hh:mm:ss"));

			log.info("imgService start!!");
			res = imgService.InsertImage(pDTO);
			log.info("imgService end!!");

		}
	}

	// 스터디 이미지파일 업로드 (ajax로 구현)
	@RequestMapping(value = "FileUplod2")
	@ResponseBody
	public void StudyFileUpload(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "fileUplod2") MultipartFile mf, HttpSession session) throws Exception {
		// ###################################################################
		// ###################################################################
		// 스터디 이미지 파일 업로드 시작
		log.info("fileUplod2 start");
		int studyImg = 0;

		Map<String, String> rMap = new HashMap<String, String>();
		// 이미지 파일 저장하는 스터디이름
		String study_name = nvl(request.getParameter("study_name"));

		// 임의로 정의된 파일명을 원래대로 만들어주기 위한 목적
		String originalFileName = mf.getOriginalFilename();

		// 파일 확장자 가져오기
		String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1, originalFileName.length())
				.toLowerCase();

		// 이미지 파일만 실행되도록 함
		if (ext.equals("jpeg") || ext.equals("jpg") || ext.equals("gif") || ext.equals("png")) {

			// 웹서버에 저장되는 파일이름 (영어, 숫자로 파일명 변경)
			String saveFileName = DateUtil.getDateTime("24hhmmss") + "." + ext;

			// 웹서버에 업로드한 파일 저장하는 물리적 경로
			String saveFilePath = FileUtil.mkdirForDate(STUDYFILE_UPLOAD_SAVE_PATH);
			String fullFileInfo = saveFilePath + "/" + saveFileName;

			rMap.put("path", fullFileInfo);

			// 정상적으로 값이 생성되었는지 로그에 찍어서 확인
			log.info("ext : " + ext);
			log.info("originalFileName : " + originalFileName);
			log.info("saveFileName : " + saveFileName);
			log.info("saveFilePath : " + saveFilePath);
			log.info("fullFileInfo : " + fullFileInfo);

			String path = request.getSession().getServletContext().getRealPath(saveFilePath);
			System.out.println(path);
			// 업로드 되는 파일을 서버에 저장
			File targetFile = new File(path, saveFileName);
			System.out.println(targetFile.toString());

			if (!targetFile.isDirectory()) {
				targetFile.mkdirs();
			}

			targetFile.setReadable(true, false);
			targetFile.setWritable(true, false);
			targetFile.setExecutable(true, false);

			mf.transferTo(targetFile);

			// 이미지 경로 DB에 저장
			OcrDTO pDTO = new OcrDTO();
			pDTO.setSave_file_name(saveFileName);
			pDTO.setSave_file_path(saveFilePath);
			pDTO.setOrg_file_name(originalFileName);
			pDTO.setExt(ext);
			pDTO.setChg_id(study_name);
			pDTO.setChg_dt(DateUtil.getDateTime("yyyy-MM-dd-hh:mm:ss"));

			log.info("imgService start!!");
			studyImg = imgService.StudyInsertImage(pDTO);
			log.info("imgService end!!");
		}
		log.info("StudyFileUplod end!!");
		// ###################################################################
		// 스터디 이미지 파일 업로드 끝

	}

	@RequestMapping(value = "/getImage", method = RequestMethod.GET)
	public String getImage(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			@RequestParam(value = "user_id") String user_id) throws Exception {

		log.info("user_id : " + user_id);

		// 가장 최근에 등록한 프로필 사진 정보가져오기
		log.info("getImgList start! ");
		Map<String, String> pMap = imgService.getImgList(user_id);
		log.info("getImgList end! ");
		if (pMap == null) {
			pMap = new HashMap<String, String>();
		}
		String realFile = nvl(pMap.get("SAVE_FILE_PATH") + "/"); // 파일이 저장된 경로 : /usr/local/images/userimg/0000/00/00/
		String fileNm = nvl(pMap.get("SAVE_FILE_NAME")); // 파일명 : 000000.jpg 000000.png
		String ext = nvl(pMap.get("EXT")); // 파일 확장자
		log.info("realFile : " + realFile);
		log.info("fileNm : " + fileNm);
		log.info("ext : " + ext);

		if (!ext.equals("")) {
			return "/img" + realFile + fileNm;
		} else {
			return "/img/basicimg2.jpg";
		}

	}

	// 스터디 이미지 불러오기 ( InputStream으로 파일 불러옴 )
	@RequestMapping(value = "/getStudyImage", method = RequestMethod.GET)
	public String getStudyImage(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			@RequestParam(value = "study_name") String study_name) throws Exception {

		log.info("study_name : " + study_name);

		// 가장 최근에 등록한 프로필 사진 정보가져오기
		log.info("getStudyImgList start! ");
		Map<String, String> pMap = imgService.getStudyImgList(study_name);
		log.info("getStudyImgList end! ");

		if (pMap == null) {
			pMap = new HashMap<String, String>();
		}
		String realFile = nvl(pMap.get("SAVE_FILE_PATH") + "/"); // 파일이 저장된 경로 : /usr/local/images/studyimg/0000/00/00/
		String fileNm = nvl(pMap.get("SAVE_FILE_NAME")); // 파일명
		String ext = nvl(pMap.get("EXT")); // 파일 확장자
		log.info("realFile : " + realFile);
		log.info("fileNm : " + fileNm);
		log.info("ext : " + ext);

		if (!ext.equals("")) {
			return "/img" + realFile + fileNm;
		} else {
			return "/img/study.jpg";
		}
	}
}