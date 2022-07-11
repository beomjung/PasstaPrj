package poly.controller;

import static poly.util.CmmUtil.nvl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.ChatJsonDTO;
import poly.service.IChattingService;
import poly.service.IStudyService;
import poly.util.DateUtil;

@Controller
public class ChatController {

	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "ChattingService")
	IChattingService chattingSerivice;

	@Resource(name = "StudyService")
	IStudyService studyService;

	// 채팅 페이지
	@RequestMapping(value = "/chat/chatting", method = RequestMethod.GET)
	public String chatting(HttpSession session, ModelMap model, HttpServletRequest request) throws Exception {

		log.info(this.getClass().getName() + ".chatting start!");

		String user_id = nvl((String) session.getAttribute("user_id"));
		String study_name = nvl((String) request.getParameter("study_name"));
		String study_seq = studyService.getStudySeq(study_name);

		log.info("user_id : " + user_id);
		log.info("study_name : " + study_name);

		if (user_id.equals("")) {
			model.addAttribute("msg", "로그인이 필요합니다.");
			model.addAttribute("url", "/user/login.do");
			return "/redirect";
		}

		model.addAttribute("study_name", study_name);
		model.addAttribute("study_seq", study_seq);
		return "/chat/chatting";
	}

	// Redis로 채팅 내용 저장
	@RequestMapping(value = "/chat/messageeForRedis", method = RequestMethod.POST)
	@ResponseBody
	public String messageeForRedis(@ModelAttribute ChatJsonDTO chatJson, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("chat_id : " + chatJson.getChat_id() + " | chat_dt : " + chatJson.getChat_dt() + " | study_seq : "
				+ chatJson.getStudy_seq() + " | study_name : " + chatJson.getStudy_name() + " | chat_contents : "
				+ chatJson.getChat_contents());
		chattingSerivice.setChatInfo(chatJson);

		return "succees";
	}

	// Redis에서 채팅 내용 가져오기
	@RequestMapping(value = "/chat/messageeFromRedis")
//	@ResponseBody
	public String messageeFromRedis(HttpServletRequest request, ModelMap model, HttpServletResponse response) throws Exception {

		String study_name = request.getParameter("study_name");
		
		log.info("study_name : " + study_name );
		
		// 일주일전 데이터 모두 가져오기
		int date00 = Integer.parseInt(DateUtil.getDateTime("yyMMdd"));
		int date01 = Integer.parseInt(DateUtil.getDateTime("yyMMdd"))-1;
		int date02 = date01 - 1;
		int date03 = date01 - 2;
		int date04 = date01 - 3;
		int date05 = date01 - 4;
		int date06 = date01 - 5;
		int date07 = date01 - 6;
		log.info("today : " + DateUtil.getDateTime("yyMMdd"));
		log.info("study_name + date01 : " + study_name + date01);
		log.info("study_name + date02 : " + study_name + date02);
		
		List<String> key = new ArrayList<String>();
		key.add(study_name + date00);
		key.add(study_name + date01);
		key.add(study_name + date02);
		key.add(study_name + date03);
		key.add(study_name + date04);
		key.add(study_name + date05);
		key.add(study_name + date06);
		key.add(study_name + date07);
		
		
		List<List<ChatJsonDTO>> rList = null;
		log.info(".getChatInfo start!");
		rList = chattingSerivice.getChatInfo(key);
		log.info(".getChatInfo end!");

		if (rList == null) {
			rList = new ArrayList<List<ChatJsonDTO>>();
		}
		
		model.addAttribute("rList", rList);
		//rList
		return "chat/chatting2";
	}
	
		

}
