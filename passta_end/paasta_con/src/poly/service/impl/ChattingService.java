package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.ChatJsonDTO;
import poly.persistance.redis.IRedisChatMapper;
import poly.service.IChattingService;

@Service("ChattingService")
public class ChattingService implements IChattingService{
	
	// 로그 찍기
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="RedisChatMapper")
	private IRedisChatMapper redisChatMapper; // redisDB 데이터 제어용 Mapper

	@Override
	public void setChatInfo(ChatJsonDTO chatJson) throws Exception {
		
		log.info(this.getClass().getName() + ".setChatInfo Start!!");
		
		redisChatMapper.setChatInfo(chatJson);
		
		log.info(this.getClass().getName() + ".setChatInfo End!!");
		
	}

	@Override
	public List<List<ChatJsonDTO>> getChatInfo(List<String> key) throws Exception {
		
		log.info(this.getClass().getName() + ".getChatInfo Start!!");
		
		List<List<ChatJsonDTO>> rList = redisChatMapper.getChatInfo(key);
		
		log.info(this.getClass().getName() + ".getChatInfo End!!");
		
		return rList;
	}

}
