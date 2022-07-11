package poly.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.dto.UserDTO;
import poly.service.IKakaoService;
import poly.service.IUserService;

@Controller
public class KakaoLoginController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="KakaoService")
	private IKakaoService kakaoService;
	
	@Resource(name="UserService")
	IUserService userService;
	
	@RequestMapping("/kakaoLogin")
	public String kakaoLogin(@RequestParam(value="code", required = false) String code, HttpSession session, ModelMap model)throws Exception{
		log.info("kakao login start!!");
		// 엑세스 토큰 받음
		String access_Token = kakaoService.getAccessToken(code);
		// 카카오 로그인한 유저 정보 가져오기
		HashMap<String, Object> userInfo = kakaoService.getUserInfo(access_Token);
		
		log.info("access_Token : " + access_Token);
		log.info("email : " + userInfo.get("email"));
        log.info("nickname : " + userInfo.get("nickname"));
        log.info("profile_image : " + userInfo.get("profile_image"));
		
        log.info("user/KakaologinProc Start!!");
		String email = (String) userInfo.get("email");
		String nickname = (String) userInfo.get("nickname");
		
		HashMap<String, String> pMap = new HashMap<String, String>();
		pMap.put("email", email);
		
		// 카카오 유저정보로 사용자 정보 가져오기
		UserDTO rDTO = new UserDTO();
		rDTO = userService.getUserKakao(pMap);
		
		String msg = "";
		String url = "";
		// 사용자 정보가 없으면 간편 회원가입 진행
		if(rDTO == null) {
			log.info("rDTO == null?"+(rDTO==null));
			
			model.addAttribute("email", email);
			model.addAttribute("nickname", nickname);
			
			return "/user/signup";
		}else {
			log.info("데이터 조회완료");
			
			session.setAttribute("user_id", rDTO.getUser_id());
			session.setAttribute("user_pwd", rDTO.getUser_pwd());
			session.setAttribute("join_dt", rDTO.getJoin_dt());
			
			msg = "환영합니다.";
			url = "/spoilbroth/mystudy.do";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		log.info("user/KakaologinProc End!!");
		return "/redirect";
	}
}
