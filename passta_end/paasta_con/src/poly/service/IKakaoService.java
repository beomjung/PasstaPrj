package poly.service;

import java.util.HashMap;

public interface IKakaoService {

	String getAccessToken(String code);
	// 보안 토큰 성공 후 로그인 하면 정보 받아오는 메서드

	HashMap<String, Object> getUserInfo(String access_Token);
	// 보안 토큰으로 카카오에서 유저 정보 가져오기
}
