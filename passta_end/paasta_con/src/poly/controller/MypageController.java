package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.UserDTO;
import poly.service.IUserService;
import poly.util.CmmUtil;
import poly.util.EncryptUtil;

@Controller
public class MypageController {

	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name="UserService")
	private IUserService userService;
	
	@RequestMapping(value = "index")
	public String Index() {
		log.info(this.getClass());

		return "/index";
	}
	
	@RequestMapping(value = "mypage/setting")
	public String setting(HttpServletRequest request, HttpSession session) {
		log.info("mypage/setting\" start!!");
		
		String user_id = (String)session.getAttribute("user_id");
		if (user_id == null) {
			return "/user/login";
		}
		log.info("mypage/setting\" end!!");
		return "mypage/setting";
	}
	
	@RequestMapping(value = "mypage/mbtiModify")
	public String mbtiModify(HttpServletRequest request, HttpSession session, ModelMap model) throws Exception {
		log.info(this.getClass());
		String user_id = (String)session.getAttribute("user_id");
		
		if (user_id == null) {
			return "/user/login";
		}
		
		UserDTO uDTO = new UserDTO();
		uDTO.setUser_id(user_id);
		
		UserDTO pDTO = new UserDTO();
		pDTO = userService.getUserInfo(uDTO);
		
		model.addAttribute("pDTO", pDTO);
		
		return "/mypage/mbtiModify";
	}
	
	@RequestMapping(value = "mypage/userCorrection")
	public String userCorrection(HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelMap model)throws Exception {
		log.info(this.getClass().getName()+"userCorrection Controller Start!!");
		
		String user_id = (String)session.getAttribute("user_id");
		if (user_id == null) {
			return "/user/login";
		}
		
		UserDTO uDTO = null;
		
		uDTO = new UserDTO();
		uDTO.setUser_id(user_id);
		
		UserDTO rDTO = userService.getUserInfo(uDTO);
		
		String user_name = CmmUtil.nvl((String) rDTO.getUser_name());
		String user_email = CmmUtil.nvl((String) rDTO.getUser_email());
		//String user_gender = CmmUtil.nvl((String) rDTO.getUser_gender());
		String user_dept = CmmUtil.nvl((String) rDTO.getUser_dept());
		String user_age = CmmUtil.nvl((String) rDTO.getUser_age());
		
		log.info(user_name);
		log.info(user_email);
		//log.info(user_gender);
		log.info(user_dept);
		log.info(user_age);
		
		model.addAttribute("user_name",user_name);
		model.addAttribute("user_email",user_email);
		//model.addAttribute(user_gender);
		model.addAttribute("user_dept",user_dept);
		model.addAttribute("user_age",user_age);
		
		log.info(this.getClass().getName()+"userCorrection Controller End!!");
		
		return "/mypage/userCorrection";
	}
	
	@RequestMapping(value = "mypage/passWordChange")
	public String passWordChange(HttpServletRequest request, HttpSession session) {
		
		log.info(this.getClass().getName()+"비밀번호 변경 페이지!!!");
		
		String user_id = (String)session.getAttribute("user_id");
		if (user_id == null) {
			return "/user/login";
		}
		
		return "/mypage/passWordChange";
	}
	
	@RequestMapping("mypage/passWordChangeProc")
	public String updateUserPassword(HttpServletRequest request, HttpServletResponse response, HttpSession session,  ModelMap model)throws Exception{
		
	log.info(this.getClass().getName()+"비밀번호 변경 컨트롤러 시작!!!");
		
		String user_id = (String)session.getAttribute("user_id");
		if (user_id == null) {
			return "/user/login";
		}
		
		String user_pwd = CmmUtil.nvl(request.getParameter("pwd"));
		
		log.info("user_id : " + user_id );
		log.info("user_pwd " + user_pwd);
		
		String url = "";
		String msg = "";

		UserDTO pDTO = null;
		pDTO = new UserDTO();
		
		pDTO.setUser_id(user_id);
		pDTO.setUser_pwd(EncryptUtil.encHashSHA256(user_pwd));
		
		int res = userService.updateUserPwd(pDTO);
		
		if(res==1) {
			url = "/user/login.do";
			msg = "비밀번호 변경이 완료되었습니 다시 로그인 해주세요.";
		}else {
			url = "/mypage/passWordChange.do";
			msg = "비밀번호 변경에 실패하였습니다 다시 시도해주세요.";
		}
		
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		
		return "/redirect";

	}
	
	
	@RequestMapping(value = "mypage/userDelete")
	public String userDelete(HttpServletRequest request, HttpSession session) throws Exception {
		log.info(this.getClass());
		String user_id = (String)session.getAttribute("user_id");
		if (user_id == null) {
			return "/user/login";
		}
		
		return "/mypage/userDelete";
	}
	
	@RequestMapping(value = "mypage/userDeleteProc")
	public String userDeleteInfo(HttpServletRequest request, HttpSession session, ModelMap model)throws Exception{
		
		log.info(this.getClass().getName()+"유저 정보 삭제 컨트롤러 시작!!!");
		String user_id = (String)session.getAttribute("user_id");
		if (user_id == null) {
			return "/user/login";
		}
		String del_user= CmmUtil.nvl(request.getParameter("delete_user"));
		log.info("user_id : " + user_id);
		log.info("del_user: " + del_user);
		
		String url = "";
		String msg = "";
		
		
		UserDTO pDTO = new UserDTO();
		pDTO.setUser_id(user_id);
		
		userService.delboardfile(pDTO);
		userService.deleteUserInfo(pDTO);
		userService.delstudyboard(pDTO);
		userService.delstudyinfo(pDTO);
		
		int res = userService.deleteUserInfo(pDTO);
		log.info(pDTO);
		if(res == 1) {
		
			url = "/user/login.do";
			msg = "회원탈퇴가 완료되었습니다.";
		
		}else {
			url = "/mypage/userDelete.do";
			msg = "다시 입력해주세요.";
		}
	
		
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		
		log.info(this.getClass().getClass().getName() + "유저 정보 삭제 컨트롤러 종료!!!");
		
		return "/redirect";
		
	}
	
}
