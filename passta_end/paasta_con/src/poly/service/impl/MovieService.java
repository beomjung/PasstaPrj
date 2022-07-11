package poly.service.impl;

import java.util.Iterator;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import poly.dto.MovieDTO;
import poly.persistance.mapper.IMovieMapper;
import poly.service.IMovieService;
import poly.util.CmmUtil;
import poly.util.DateUtil;

@Service("MovieService")
public class MovieService implements IMovieService {

	@Resource(name = "MovieMapper")
	private IMovieMapper movieMapper;

	// 로그 찍기
	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * JSOUP 라이브러리를 통한 CGV 영화순위 정보 가져오기
	 */
	@Override
	public int getMovieInfoFromWEB() throws Exception {

		log.info(this.getClass().getName() + ".getMovieInfoFromWEB start!!");

		int res = 0; // 크롤링 결과 (0보다 크면 크롤링 성공)

		// CGV 영화 순위 정보 가져올 사이트 주소
		String url = "http://www.cgv.co.kr/movies/";

		// JSOUP 라이브러리를 통해 사이트 접속되면, 그사이트의 전체 HTML소스 저장할 변수
		Document doc = null;

		// 사이트 접속 (http프로토콜만 가능, https 프로토콜은 보안상 안됨
		doc = Jsoup.connect(url).get();

		// CGV 웹페이지의 전체 소스 중 일부 태그를 선택하기 위해 사용
		// <div class="sect-movie-chart"> 이 태그 내에 있는 HTML소스만 element에 저장됨
		Elements element = doc.select("div.sect-movie-chart");

		// Iterator를 사용하여 영화 순위 정보를 가져오기
		// 영화순위는 기본적으로 1개 이상의 영화가 존재하기 때문에 태그의 반복이 존재할 수 밖에 없음
		Iterator<Element> movie_rank = element.select("strong.rank").iterator(); // 영화순위
		Iterator<Element> movie_name = element.select("strong.title").iterator(); // 영화이름
		Iterator<Element> movie_reserve = element.select("strong.percent span").iterator(); // 영화예매율
		Iterator<Element> score = element.select("span.percent").iterator(); // 점수
		Iterator<Element> open_day = element.select("span.txt-info").iterator(); // 개봉일

		MovieDTO pDTO = null;

		// 수집된 데이터 DB에 저장하기
		while (movie_rank.hasNext()) {

			pDTO = new MovieDTO(); // 수집된 영화정보를 DTO에 저장하기 위해 메모리에 올리기

			// 수집시간을 기본키(pk)로 사용
			pDTO.setRank_check_time(DateUtil.getDateTime("yyyyMMdd"));
			// 영화순위 (trim 함수 추가이유 : trim 함수는 글자의 앞뒤 공백 삭제 역할을 수행, 데이터 수집시 홈페이지 개발자들이 앞뒤 공백
			// 집어넣을 수 있어서 추가)
			String rank = CmmUtil.nvl(movie_rank.next().text()).trim(); // NO.1 들어옴
			pDTO.setMovie_rank(rank.substring(3, rank.length())); // NO. 제거

			// 영화 제목
			pDTO.setMovie_nm(CmmUtil.nvl(movie_name.next().text()).trim());

			// 영화 예매율
			pDTO.setMovie_reserve(CmmUtil.nvl(movie_reserve.next().text()).trim());

			// 영화 점수
			pDTO.setScore(CmmUtil.nvl(score.next().text()).trim());

			// 수집되는 데이터가 '2021.10.23 개봉' 이기 때문에 앞에 10자리(2021.10.23)만 저장
			pDTO.setOpen_day(CmmUtil.nvl(open_day.next().text()).trim().substring(0, 10));

			// 등록자
			pDTO.setReg_id("jaehoon");
			
			
			log.info("time : " + pDTO.getRank_check_time());
			log.info("Movierank : " + pDTO.getMovie_rank());
			log.info("Moviename : " + pDTO.getMovie_nm());
			log.info("getMovie_reserve : " + pDTO.getMovie_reserve());
			log.info("getScore : " + pDTO.getScore());
			log.info("getOpen_day : " + pDTO.getOpen_day());
			
			// 영화 한개씩추가
			res += movieMapper.InsertMovieInfo(pDTO);
			log.info("영화 추가2 + : " + res);
		}
		
		
		log.info(this.getClass().getName()+ ".getMovieInfoFromWEB end!!");
		
		return res;
	}

}
