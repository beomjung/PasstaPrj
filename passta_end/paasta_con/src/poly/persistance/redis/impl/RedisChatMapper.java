package poly.persistance.redis.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import poly.dto.ChatJsonDTO;
import poly.persistance.redis.IRedisChatMapper;
import poly.util.DateUtil;

@Component("RedisChatMapper")
public class RedisChatMapper implements IRedisChatMapper {

	@Autowired
	public RedisTemplate<String, Object> redisDB;
	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * 채팅 정보가 존재하는지 체크
	 */
	@Override
	public boolean getExists(String key) throws Exception {

		log.info(this.getClass().getName() + ".getExists start!!");

		return redisDB.hasKey(key);
	}

	/**
	 * 채팅 정보 가져오기
	 */
	@Override
	public List<List<ChatJsonDTO>> getChatInfo(List<String> keys) throws Exception {

		log.info(this.getClass().getName() + "getChatInfo start!!");

		
		List<List<ChatJsonDTO>> rList = new ArrayList<List<ChatJsonDTO>>(); // redisDB로 부터 조회된 데이터를 저장할 객체
		redisDB.setKeySerializer(new StringRedisSerializer());
		redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(ChatJsonDTO.class));

		log.info("keys : " + keys.get(0));
		log.info("keys : " + keys.get(1));
		// 레디스에 키값이 존재하면 전부 가져옴
		int i = 0 ;
		for (String key : keys) {
			List<ChatJsonDTO> pList = new ArrayList<ChatJsonDTO>(); // redisDB로 부터 조회된 데이터를 저장할 객체
			if (redisDB.hasKey(key)) {
				pList = (List) redisDB.opsForList().range(key, 0, -1);
				rList.add(pList);
			}
			pList = null;
			i++;
		}
		log.info(this.getClass().getName() + "getChatInfo end!!");
		return rList;
	}

	/**
	 * 채팅 정보 저장하기
	 */
	@Override
	public void setChatInfo(ChatJsonDTO chatJson) throws Exception {

		String redisKey = chatJson.getStudy_name() + DateUtil.getDateTime("yyMMdd");
		log.info(this.getClass().getName() + ".setChatInfo start!!");

		redisDB.setKeySerializer(new StringRedisSerializer());
		redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(ChatJsonDTO.class));

		// 기존 키값이 존재하면, 기존 컬렉션에 데이터만 추가함
		if (this.getExists(redisKey)) {

			// 7일동안의 유효시간을 가짐
			redisDB.expire(redisKey, 7, TimeUnit.DAYS);
			// redisDB에 데이터 저장하기
			redisDB.opsForList().rightPush(redisKey, chatJson);
			log.info(this.getClass().getName() + ".(값만 추가) setChatInfo end!!");

			// 기존 키값이 존재하지 않으면, 컬렉션 생성하고 데이터 추가
		} else {

			// 7일동안의 유효시간을 가짐
			redisDB.expire(redisKey, 7, TimeUnit.DAYS);
			// redisDB에 데이터 저장하기
			redisDB.opsForList().rightPush(redisKey, chatJson);
			chatJson = null;
			log.info(this.getClass().getName() + ".(키값 생성) setChatInfo end!!");
		}
		log.info(this.getClass().getName() + ".setChatInfo end!!");
	}

	/**
	 * TTL 설정
	 */
	@Override
	public boolean setTimeOutHour(String roomkey, int hours) throws Exception {

		log.info(this.getClass().getName() + ".setTimeOutHour start!!");

		return redisDB.expire(roomkey, hours, TimeUnit.HOURS);
	}

}
