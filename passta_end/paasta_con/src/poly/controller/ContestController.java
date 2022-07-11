package poly.controller;

import static poly.util.CmmUtil.nvl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.ContestDTO;
import poly.service.IContestService;

@Controller
public class ContestController {

	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "ContestService")
	IContestService contestService;
	
	@RequestMapping(value = "study/contest")
	public String contest(HttpServletRequest request, HttpSession session, ModelMap model) throws Exception {
		log.info(this.getClass().getClass().getName() + "study/contest start!!");
		String user_id = (String)session.getAttribute("user_id");
		if(user_id == null) {
			return "/user/login";
		}
		// 전체 카테고리별로 10개씩 가져오기
		List<ContestDTO> rList = contestService.getTenContest();
		String contest_area = rList.get(0).getContest_area();
		log.info("contest_seq : " + contest_area);
		
		model.addAttribute("rList", rList);
		log.info(this.getClass().getClass().getName() + "study/contest end!!");
		return "study/contest";
	}
	
	@RequestMapping(value = "study/contest2")
	public String contest2(HttpServletRequest request, HttpSession session, ModelMap model) throws Exception {
		log.info(this.getClass().getClass().getName() + "study/contest start!!");
		String user_id = (String)session.getAttribute("user_id");
		if(user_id == null) {
			return "/user/login";
		}
		String contest_area = nvl((String)request.getParameter("contest_area"));
		
		// 선택한 분야의 공모전 정보 가져오기
		List<ContestDTO> rList = contestService.getAreaContest(contest_area);
		
		model.addAttribute("rList", rList);
		log.info(this.getClass().getClass().getName() + "study/contest end!!");

		return "study/contest";
	}

	@RequestMapping(value = "study/contestdetail")
	public String contestdetail(HttpServletRequest request, HttpSession session, ModelMap model) throws Exception {
		log.info(this.getClass().getClass().getName() + "study/contestdetail start!!");
		String contest_seq = (String)request.getParameter("contest_seq");
		
		ContestDTO rDTO = new ContestDTO();
		
		rDTO = contestService.getContestDetail(contest_seq);
		
		model.addAttribute("rDTO", rDTO);
		log.info(this.getClass().getClass().getName() + "study/contestdetail end!!");
		return "study/contestdetail";
	}
	
}
