package poly.controller;

import static poly.util.CmmUtil.nvl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.ContestDTO;
import poly.service.IContestService;
import poly.util.DateUtil;
import poly.util.UrlUtil;


@Controller
public class CrawlingController {
	
	@Resource(name = "ContestService")
	IContestService contestService;
	private Logger log = Logger.getLogger(this.getClass());

	// 파이썬 셀리니움 크롤링
	/**
	 * @param session
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/crawling")
	public String chatting(HttpSession session, ModelMap model, HttpServletRequest request) throws Exception {

		log.info(this.getClass().getName() + ".chatting start!");
		int save = 0;
		UrlUtil uu = new UrlUtil();

//		String url = "http://127.0.0.1:5000";
		String url = "http://localhost:8000";
		String api = "/crawlingAPI";

		// 호출 URL
		// http://13.125.99.115/crawlingAPI?get=all
		// pText가 한글이면 인코딩 필요 + URLEncoder.encode(pText, "UTF-8")
		String res = uu.urlReadforString(url + api);
		uu = null;
		// JSON JSONArray 파싱
		JSONParser jsonParse = new JSONParser();
		JSONArray jsonArray = (JSONArray)jsonParse.parse(res);    // json 파일을 읽어서 JSONArray에 저장
		
		ContestDTO pDTO = new ContestDTO();
		for (int i = 0; i < jsonArray.size(); ++i) {
		    JSONObject jo = (JSONObject)jsonArray.get(i);                        // 첫번째 list를 꺼낸다

		    JSONArray arrays = (JSONArray)jo.get("rlist");                       // list 안의 list를 가져온다
		    for (Object obj : arrays) {
		       JSONObject childObj = (JSONObject)obj;
		       pDTO = new ContestDTO();
		       
		       pDTO.setContest_name(nvl((String)childObj.get("contest_name")));
		       pDTO.setContest_img(nvl((String)childObj.get("contest_img")));
		       pDTO.setContest_host(nvl((String)childObj.get("contest_host")));
		       pDTO.setContest_area(nvl((String)childObj.get("contest_area")));
		       System.out.println(pDTO.getContest_area());
		       pDTO.setContest_day(nvl((String)childObj.get("contest_day"))); 
		       pDTO.setContest_prize(nvl((String)childObj.get("contest_prize")));
		       pDTO.setContest_addr(nvl((String)childObj.get("contest_addr")));
		       pDTO.setContest_contents(nvl((String)childObj.get("contest_contents")));
		       pDTO.setReg_dt(nvl((String)DateUtil.getDateTime("yyyyMMdd")));
		       
		       if(pDTO == null) {
		    	   pDTO = new ContestDTO();
		       }
		       save += contestService.saveJsonCrawl(pDTO);
		       pDTO = null;
		    }
		}
		model.addAttribute("save", save);		 
		return "/crawling";
	}
}
