package poly.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.MelonDTO;
import poly.dto.MovieDTO;
import poly.service.IMelonService;
import poly.service.IMovieRankService;
import poly.util.CmmUtil;
import poly.util.DateUtil;

/*
 * Controller 선언해야만 Spring 프레임워크에서 Controller인지 인식가능
 * 자바 서블릭 역할 수행
 */
@Controller
public class MovieRankController {

	private Logger log = Logger.getLogger(this.getClass());

	/*
	 * 비즈니스 로직(중요로직을 수행하기 위해 사용되는 서비스를 메모리에 적재(싱글톤 패턴 적용)
	 * 
	 */
	@Resource(name = "MovieRankService")
	private IMovieRankService movieRankService;
	
	@Resource(name = "MelonService")
	private IMelonService melonService;
	
	
	/**
	 * 멜론 노래 리스트 저장하기
	 */
	@RequestMapping(value="melon/collectMelonSong")
	@ResponseBody
	public String collectMelonRank(HttpServletRequest request, HttpServletResponse response)
		throws Exception{
		
		log.info(this.getClass().getName() + ".collectMelonSong Start!!");
		
		melonService.collectMelonSong();
		
		log.info(this.getClass().getName() + ".collectMelonSong End!!");
		
		return "success";
	}
	
	/**
	 * 오늘 수집된 멜론 노래리스트 가져오기
	 */
	@RequestMapping(value="melon/getSongList")
	@ResponseBody
	public List<MelonDTO> getSongList(HttpServletRequest request, HttpServletResponse response)
		throws Exception{
		log.info(this.getClass().getName() + ".getSongList start!!");
		
		List<MelonDTO> rList = melonService.getSongList();
		
		log.info(this.getClass().getName() + ".getSongList End!!");
		
		return rList;
	}
	
	/**
	 * 가수별 수집된 노래의 수 가져오기
	 */
	@RequestMapping(value="melon/getSingerSongcnt")
	@ResponseBody
	public List<Map<String, Object>> getSingerSongCnt(HttpServletRequest request, HttpServletResponse response)
		throws Exception{
		log.info(this.getClass().getName() + ".getSingerSongCnt start!!");
		
		List<Map<String, Object>> rList = melonService.getSingerSongCnt();
		
		log.info(this.getClass().getName() + ".getSingerSongCnt end!!");
		
		return rList;
	}
	
	
	
	
	
	
	
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
	/**
	 * 음성 명령 첫화면
	 */
	@RequestMapping(value = "rank/index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.info("rank/index start");

		log.info("rank/index end");

		return "/rank/index";
	}

	/**
	 * CGV 영화 순위 가져오기
	 */
	@RequestMapping(value = "rank/movie")
	@ResponseBody
	public List<MovieDTO> rank(HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.info(this.getClass().getName() + "rank start!!!");

		List<MovieDTO> rList = null;

		// 음성 명령
		String send_msg = CmmUtil.nvl(request.getParameter("send_msg"));
		log.info("send_msg: " + send_msg);

		// 영화, 순위와 비슷한 단어가 존재하면 CGV 영화 순위 가져오기 수행
		// 조건1. 영화 or 영하 or 연하 or 연화; 조건2. 순위 or 순이 ; 조건3. 조건1과 조건2가 만족;

		if (((send_msg.indexOf("영화") > -1) || (send_msg.indexOf("영하") > -1) || (send_msg.indexOf("연하") > -1))
				|| (send_msg.indexOf("연화") > -1) && (send_msg.indexOf("순위") > -1) || (send_msg.indexOf("순이") > -1)) {

			MovieDTO pDTO = new MovieDTO();
			
			
			pDTO.setRank_check_time(DateUtil.getDateTime("yyyyMMdd"));
			log.info("ranktime = " + pDTO.getRank_check_time());
			

			rList = movieRankService.getMovieRank(pDTO);
			log.info("rList = " + rList);
			if (rList == null) {
				rList = new ArrayList<MovieDTO>();

			}
		}

		log.info(this.getClass().getName() + "rank end!!!");

		return rList;
	}

}
