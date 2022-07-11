package poly.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.mortbay.log.Log;
import org.springframework.stereotype.Service;

import poly.dto.MovieDTO;
import poly.persistance.mapper.IMovieMapper;
import poly.persistance.redis.IRedisMovieMapper;
import poly.service.IMovieRankService;
import poly.service.IMovieService;
import poly.util.DateUtil;

@Service("MovieRankService")
public class MovieRankService implements IMovieRankService{
	
	@Resource(name="MovieService")
	private IMovieService movieService; // 크롤링을 위한 service
	
	@Resource(name="MovieMapper")
	private IMovieMapper oraclemovieMapper; // 오라클 데이터 제어용 Mapper

	@Resource(name="RedisMovieMapper")
	private IRedisMovieMapper redisMovieMapper; // redisDB 데이터 제어용 Mapper
	
	
	@Override
	public List<MovieDTO> getMovieRank(MovieDTO pDTO) throws Exception {
	
		Log.info(this.getClass().getName() + ".getMovieRank start!!");
		
		List<MovieDTO> rList = null; // redis와 오라클로부터 조회된 데이터가 저장될 객체
		
		// redis DB에 저장될 키
		String key = "CGV_RANK_" + DateUtil.getDateTime("yyyyMMdd");
		
		// 캐시로 활용될 Redis에 CGV순위 정보가 존재하는지 체크함
		if(redisMovieMapper.getExists(key)) { // redisDB에 데이터가 있으면
			
			// 데이터 가져오기
			rList = redisMovieMapper.getMovieRank(key);
			
			// NULL 에러 방지용
			if(rList == null) {
				rList = new ArrayList<MovieDTO>();
			}
			
			// 최근 호출된 데이터이기 때문에 저장유효시간(TTL) 연장하기
			redisMovieMapper.setTimeOutHour(key, 1);
		
		} else { // redisDB에 데이터가 없으면
			Log.info("레디스에 데이터없어, 오라클에서 가져올꺼야");
			// 오라클 DB에서 데이터 가져오기
			Log.info("pDTO : " + pDTO.getRank_check_time());
			rList = oraclemovieMapper.getMovieInfo(pDTO);
			Log.info("오라클에서 조회" + rList);
			// NULL 에러방지용
			if(rList == null) {
				rList = new ArrayList<MovieDTO>();
			}
			
			// 오라클에도 데이터가 존재하지 않으면 크롤링 시작
			if (rList.size() == 0) {
				
				Log.info("오라클에도 데이터가 존재하지 않음");
				// CGV 웹사이트에서 크롤링 시작
				movieService.getMovieInfoFromWEB();
				
				// 크롤링을 통해 오라클 DB에 저장된 영화 순위정보를 다시 조회하기
				rList = oraclemovieMapper.getMovieInfo(pDTO);
				Log.info("rList : " + rList);
				// NULL 에러 방지용
				if(rList == null) {
					rList = new ArrayList<MovieDTO>();
				}
			}	
			
			/**
			 * 오라클 데이터는 존재하지만, Redis에 존재하지 않기 때문에 Redis에 저장하고, 저장유효시간을 1시간으로 설정함
			 */
				// 데이터가 존재한다면, Redis에 저장
			if(rList.size() > 0) {
				redisMovieMapper.setMovieRank(key, rList);
				
				// 최근 호출된 데이터이기 때문에 저장유효시간(TTL) 연장하기
				redisMovieMapper.setTimeOutHour(key, 1);
				
			}
			
		}
		
		Log.info(this.getClass().getName() + ".getMovieRank end!!");
		
		return rList;
	}

}
