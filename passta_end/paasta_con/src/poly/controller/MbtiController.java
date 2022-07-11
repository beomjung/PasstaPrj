package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dto.MbtiDTO;
import poly.dto.UserDTO;
import poly.service.IMbtiService;
import poly.service.IUserService;
import poly.util.CmmUtil;




@Controller
public class MbtiController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="UserService")
	IUserService userService;
	
	@Resource(name="MbtiService")
	IMbtiService mbtiService;
	// MBTI 학습전
	@RequestMapping(value = "mbti/mbtimain")
	public String mbtimain(HttpServletRequest request, HttpSession session, ModelMap model) throws Exception{
		log.info(this.getClass().getClass().getName() + "mbtimain start!!");
		
		String user_id = (String)session.getAttribute("user_id");
		if (user_id == null) {
	         return "/user/login";
	      }
		// 사용자 정보 조회
		UserDTO rDTO = new UserDTO();
		rDTO.setUser_id(user_id);
		rDTO = userService.getUserInfo(rDTO);
		if(rDTO== null) {
			rDTO = new UserDTO();
		}
		// MBTI 정보 조회
		MbtiDTO mDTO = new MbtiDTO();
		mDTO.setMbti_name(rDTO.getUser_mbti());
		log.info(rDTO.getUser_mbti());
		
		mDTO = mbtiService.getMbtiInfo(mDTO);
		if(mDTO == null) {
			mDTO = new MbtiDTO();
		}
		
		log.info("MBTI : " + mDTO.getMbti_name());
		
		model.addAttribute("mDTO", mDTO); // mbti 정보
		model.addAttribute("rDTO", rDTO); // 유저 정보
		
		mDTO = null;
		rDTO = null;
		log.info(this.getClass().getClass().getName() + "mbtimain end!!");
		return "mbti/mbtimain";
	}
	
	// MBTI 학습후
	@RequestMapping(value = "mbti/mbtimain2")
	public String mbtimain2(HttpServletRequest request, HttpSession session) {
		log.info(this.getClass().getClass().getName() + "mbtimain start!!");

		return "mbti/mbtimain2";
	}
	
	// MBTI 검사화면
	@RequestMapping(value = "mbti/mbtianalysis")
	public String mbtiexamine(HttpServletRequest request, HttpSession session) {
		log.info(this.getClass().getClass().getName() + "mbtimain start!!");

		return "mbti/mbtianalysis";
	}
	
	// MBTI 저장
		@RequestMapping(value = "mbti/updateUserMbti", method=RequestMethod.GET)
		public String updateUserMbti(HttpServletRequest request, HttpSession session, ModelMap model) throws Exception {
			log.info(this.getClass().getClass().getName() + "saveUserMbti start!!");
			
			String user_id = (String)session.getAttribute("user_id");
			String user_mbti = CmmUtil.nvl(request.getParameter("user_mbti"));
			log.info("user_id : " + user_id);
			log.info("user_mbti : " + user_mbti);
			
			String url = "";
			String msg = "";
			
			UserDTO pDTO = new UserDTO();
			pDTO.setUser_id(user_id);
			pDTO.setUser_mbti(user_mbti);
			
			int res = userService.updateUserMbti(pDTO);
			if(res == 1) {
				url = "/mbti/mbtimain.do";
				msg = "MBTI 업데이트가 완료되었습니다.";
			}
			
			model.addAttribute("url", url);
			model.addAttribute("msg", msg);
			log.info(this.getClass().getClass().getName() + "updateUserMbti End!!");
			return "/redirect";
		}
	
}
