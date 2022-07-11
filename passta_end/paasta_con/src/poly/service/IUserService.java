package poly.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import poly.dto.UserDTO;

public interface IUserService {

	UserDTO getUserInfo(UserDTO uDTO) throws Exception;

	int insertUserInfo(UserDTO uDTO) throws Exception;

	UserDTO idCheck(String userId) throws Exception;

	int updateJoinStudy(Map<String, String> sMap) throws Exception;

	int updateLeaveStudy(Map<String, String> pMap) throws Exception;

	int updateUserMbti(UserDTO pDTO) throws Exception;

	List<String> getUserMbti(List<String> list) throws Exception;

	UserDTO getUserKakao(HashMap<String, String> pMap);

	HashMap<String, Integer> getMbtiCount();

	UserDTO getFaceInfo(HashMap<String, String> pMap);

	//비멀번호 변경
	int updateUserPwd(UserDTO pDTO)throws Exception;
	
	//회원 탚퇴
	int deleteUserInfo(UserDTO pDTO)throws Exception;
	
	//아이디 찾기
	UserDTO findUserid(UserDTO pDTO) throws Exception;
	
	//비밀번호 찾기
	int findUserPwd(UserDTO pDTO) throws Exception;
	
	//로그인
	UserDTO userLogin(UserDTO uDTO) throws Exception;
	
	//회원 탈퇴시 업로드 파일, 스터디 게시판, 스터디, 유저 이미지, faceimg삭제
	void delboardfile(UserDTO pDTO) throws Exception;
	void delstudyboard(UserDTO pDTO) throws Exception;
	void delstudyinfo(UserDTO pDTO) throws Exception;
	void deluserface(UserDTO pDTO) throws Exception;
	void deluserimg(UserDTO pDTO) throws Exception;
}
