package poly.controller;

import static poly.util.CmmUtil.nvl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.MailDTO;
import poly.dto.UserDTO;
import poly.service.IMailService;
import poly.service.IUserService;
import poly.util.CmmUtil;
import poly.util.DateUtil;
import poly.util.EncryptUtil;

@Controller
public class UserInfoController {

	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "UserService")
	IUserService userService;
	
	@Resource(name = "MailService")
	private IMailService mailService;

	// 로그인
	@RequestMapping(value = "user/login")
	public String login(HttpServletRequest request, HttpSession session) {
		log.info(this.getClass().getClass().getName() + "user/login start!!");
		session.invalidate();

		return "user/login";
	}

	@RequestMapping(value = "user/loginProc", method = RequestMethod.POST)
	public String loginProc(HttpServletRequest request, HttpSession session, ModelMap model) throws Exception {

		log.info("user/loginProc Start!!");
		String id = nvl(request.getParameter("user_id"));
		String pwd = nvl(request.getParameter("user_pwd"));
		
		log.info("id : " + id);
		log.info("pwd : " + pwd);
		
		UserDTO uDTO = new UserDTO();
		
		uDTO.setUser_id(id);
		uDTO.setUser_pwd(EncryptUtil.encHashSHA256(pwd));
		
		UserDTO rDTO = new UserDTO();
		rDTO = userService.userLogin(uDTO);
		
		String msg = "";
		String url = "";
		if(rDTO == null) {
			log.info("rDTO == null?"+(rDTO==null));
			msg = "아이디 비밀번호를 확인해주세요";
			url = "/user/login.do";
			
		}else {
			log.info("데이터 조회완료");
			
			session.setAttribute("user_id", rDTO.getUser_id());
			//session.setAttribute("user_pwd", rDTO.getUser_pwd());
			session.setAttribute("join_dt", rDTO.getJoin_dt());
			
			msg = "환영합니다.";
			url = "/spoilbroth/mystudy.do";
		
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		log.info("user/loginproc End!!");
		return "/redirect";
	}

	@RequestMapping(value = "/user/logOut")
	public String logOut(HttpSession session, ModelMap model) throws Exception {
		log.info(this.getClass().getName() + "user/logOut start!!");

		String msg = "";
		String url = "";

		msg = "로그아웃 성공";

		session.invalidate();
		url = "/user/login.do";

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		log.info(this.getClass().getName() + "user/logOut end!!");
		return "/redirect";
	}

	// 회원가입
	@RequestMapping(value = "user/signup")
	public String signup(HttpServletRequest request, HttpSession session) {
		log.info(this.getClass().getClass().getName() + "user/signup start!!");

		return "user/signup";
	}

	@RequestMapping(value = "user/inserUserInfo")
	public String inserUserInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {

		log.info(this.getClass().getName() + "inserUserInfo Start!!");

		// 회원가입 결과에 대한 메시지 전달할 변수
		String msg = "";
		String url = "";

		// 웹에서 받는 정보를 저장할 변수
		UserDTO pDTO = null;

		try {

			String user_id = nvl(request.getParameter("user_id"));
			String user_name = nvl(request.getParameter("user_name"));
			String user_email = nvl(request.getParameter("user_email"));
			String user_pwd = nvl(request.getParameter("user_pwd"));
			String user_dept = nvl(request.getParameter("user_dept"));
			String user_age = nvl(request.getParameter("user_age"));
			String user_study = "";
			String user_mbti = "";

			log.info("user_id : " + user_id);
			log.info("user_email : " + user_email);
			log.info("user_pwd : " + user_pwd);
			log.info("user_dept : " + user_dept);
			log.info("user_age : " + user_age);

			pDTO = new UserDTO();

			pDTO.setUser_id(user_id);
			pDTO.setUser_name(user_name);
			//pDTO.setUser_email(user_email);
			// 이메일은 AES128-CBC로 암호화
			pDTO.setUser_email(EncryptUtil.encAES128CBC(user_email));
			//pDTO.setUser_pwd(user_pwd);
			
			// 비밀번호는 절대로 복호화 되지않도록 해시알고리즘으로 암호화
			pDTO.setUser_pwd(EncryptUtil.encHashSHA256(user_pwd));

			pDTO.setUser_dept(user_dept);
			pDTO.setUser_age(user_age);
			pDTO.setUser_mbti(user_mbti);
			pDTO.setUser_study(user_study);
			pDTO.setJoin_dt(DateUtil.getDateTime("yyyy-MM-dd-hh:mm:ss"));
			log.info("date : " + pDTO.getJoin_dt());

			/**
			 * 회원가입
			 */
			int res = userService.insertUserInfo(pDTO);

			if (res == 1) {
				msg = "회원가입이 되었습니다.";
				url = "/user/login.do";
			} else if (res == 2) {
				msg = "이미 가입된 이메일 주소 입니다.";
				url = "/user/signup.do";
			} else {
				msg = "오류로 인해  회원가입이 실패 하였습니다.";
				url = "/user/signup.do";
			}
		} catch (Exception e) {
			// 저장이 실패되면 사용자에세 보여줄 메시지
			msg = "실패하였습니다. : " + e.toString();
			log.info(e.toString());
			e.printStackTrace();
		} finally {
			log.info(this.getClass().getName() + "inserUserInfo End!!");

			// 회원가입 여부 결과 메시지 전달하기
			model.addAttribute("msg", msg);
			model.addAttribute("url", url);
			// 회원가입 여부 결과 메시지 전달하기
			model.addAttribute("pDTO", pDTO);

			// 변수 초기화
			pDTO = null;
		}

		return "/redirect";
	}

	// 아이디 중복확인
	@ResponseBody
	@RequestMapping(value = "/user/idCheck", method = RequestMethod.POST)
	public int idCheck(HttpServletRequest request) throws Exception {
		log.info("idCheck 시작");

		String userId = request.getParameter("userId");

		log.info("TheService.idCheck 시작");
		UserDTO idCheck = userService.idCheck(userId);
		log.info("TheService.idCheck 종료");

		int res = 0;

		log.info("if 시작");
		if (idCheck != null)
			res = 1;

		log.info("result : " + res);
		log.info("if 종료");

		log.info("idCheck 종료");
		return res;
	}

	@RequestMapping(value="user/findId")
	public String findId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info(this.getClass().getClass().getName() + "user/id start!!");
		return "/user/findId";
	}
	
	
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "user/findIdProc")
	public String fidId(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		log.info(this.getClass().getClass().getName() + "user/idchange start!!");

		String msg = "";
		String url = "";

		UserDTO pDTO = null;

		try {
			String user_name = nvl(request.getParameter("user_name"));
			String user_email = nvl(request.getParameter("user_email"));

			pDTO = new UserDTO();

			pDTO.setUser_name(user_name);
			//pDTO.setUser_email(user_email);
			
			pDTO.setUser_email(EncryptUtil.encAES128CBC(user_email));

			UserDTO rDTO = userService.findUserid(pDTO);
			
			String userid = rDTO.getUser_id();

			if (rDTO != null) {
				msg = user_name+"님의 ID는"+userid+"입니다.";
				url = "/user/login.do";
			} else {
				msg = "이름과 이메일을 다시한번 확인해 주세요";
				url = "/user/findId.do";
			}
		} catch (Exception e) {
			// 저장이 실패되면 사용자에세 보여줄 메시지
			msg = "이름과 이메일을 다시한번 확인해 주세요";
			url = "/user/findId.do";
			log.info(e.toString());
			e.printStackTrace();
		} finally {
			log.info(this.getClass().getName() + "findUserID End!!");

			// 회원가입 여부 결과 메시지 전달하기
			model.addAttribute("msg", msg);
			model.addAttribute("url", url);

			// 변수 초기화
			pDTO = null;
		}

		return "/redirect";

	}

	@RequestMapping(value = "user/findPw")
	public String findpwd(HttpServletRequest request) {
		log.info(this.getClass().getClass().getName() + "user/pwdchange start!!");

		return "/user/findPw";
	}
	
	
	@RequestMapping(value = "user/findPwProc")
	public String findpwdProc(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		log.info(this.getClass().getClass().getName() + "user/pwdchange start!!");
		
		String msg="";
		String url="";
		
		UserDTO pDTO = null;
		
		try {
		
		String user_id = CmmUtil.nvl(request.getParameter("user_id"));
		String user_email = CmmUtil.nvl(request.getParameter("user_email"));
		
		pDTO = new UserDTO();
		
		pDTO.setUser_id(user_id);
		//pDTO.setUser_email(user_email);
		pDTO.setUser_email(EncryptUtil.encAES128CBC(user_email));
		
	
		int res = userService.findUserPwd(pDTO);
		if(res == 1) {
		 String toMail = user_email;
		 log.info("SMTP로 보낼 메일 주소" + toMail);
		 String contents = RandomStringUtils.randomAlphanumeric(10);
	
		 MailDTO mDTO = new MailDTO();
		 
		 mDTO.setToMail(toMail);
		 mDTO.setTitle("임시 비밀번호 입니다.");
		 mDTO.setContents(contents+"\n로그인 후 마이페이지에서 비밀번호를 변경해주세요.");
		 
		 log.info("SMTP로 보낼 임시 비밀번호 설정 로직 실행");
		 log.info("랜덤으로 생성된 임시 비밀번호 : " + contents);
		 
		 UserDTO rDTO = new UserDTO();
		 
		 rDTO.setUser_id(user_id);
		 //rDTO.setUser_pwd(contents);
		 rDTO.setUser_pwd(EncryptUtil.encHashSHA256(contents));
		 
		 int res1 = userService.updateUserPwd(rDTO);
		 
		 if (res1==1) {
			 int res2 = mailService.doSendmail(mDTO);
			 
			 if(res2==1) {
				 msg = user_id+"님의 이메일로 임시 비밀번호가 발급되었습니다";
				url = "/user/login.do";
			 }else {
				 msg = user_id+"님의 이메일을 다시 확인해 주세요";
				 url = "/user/findPw.do";
			 }
		 }
		}else {
			 msg = "아이디와 이메일을 다시 확인해 주세요";
			 url = "/user/findPw.do";
		}
		
		} catch (Exception e) {
			// 저장이 실패되면 사용자에세 보여줄 메시지
			msg = "실패하였습니다. : " + e.toString();
			log.info(e.toString());
			e.printStackTrace();
		} finally {
			log.info(this.getClass().getName() + "findUserID End!!");

			// 회원가입 여부 결과 메시지 전달하기
			model.addAttribute("msg", msg);
			model.addAttribute("url", url);

			// 변수 초기화
			pDTO = null;
		}

		return "/redirect";

	
	}


}
