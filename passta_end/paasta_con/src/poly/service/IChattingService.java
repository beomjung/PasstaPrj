package poly.service;

import java.util.List;

import poly.dto.ChatJsonDTO;

public interface IChattingService {
	
	// 채팅 내용 저장하기
	void setChatInfo(ChatJsonDTO chatJson) throws Exception;
	
	// 이전 채팅내용 가져오기
	List<List<ChatJsonDTO>> getChatInfo(List<String> key) throws Exception;
	
}
