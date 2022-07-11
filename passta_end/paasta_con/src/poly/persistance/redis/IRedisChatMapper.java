package poly.persistance.redis;

import java.util.List;

import poly.dto.ChatJsonDTO;

public interface IRedisChatMapper {
	
	/**
	 *  채팅 정보가 존재하는지 체크
	 *  @param key RedisDB에 저장된 키
	 */
	public boolean getExists(String key) throws Exception;
	
	/**
	 *  스터디 채팅 정보가져오기
	 *  @param key RedisDB에 저장된 키
	 */
	public List<List<ChatJsonDTO>> getChatInfo(List<String> key) throws Exception;
	
	
	/**
	 *  스터디 채팅 정보 저장될 시간(TTL) 설정
	 *  @param key RedisDB에 저장된 키
	 */
	public boolean setTimeOutHour(String key, int hours) throws Exception;
	
	/**
	 *  스터디 채팅 정보 저장하기
	 *  @param key RedisDB에 저장된 키
	 */
	public void setChatInfo(ChatJsonDTO chatJson) throws Exception;
	
}
