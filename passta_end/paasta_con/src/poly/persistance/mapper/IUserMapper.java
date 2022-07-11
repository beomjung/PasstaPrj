package poly.persistance.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import config.Mapper;
import poly.dto.UserDTO;

@Mapper("UserMapper")
public interface IUserMapper {

	// 회원가입 하기 ( 회원정보 등록하기 )
	int insertUserInfo(UserDTO uDTO) throws Exception;
	
	// 회원가입 전 중복체크하기 ( DB 조회히기)
	UserDTO getUserExists(UserDTO uDTO) throws Exception;
	
	// 회원정보 불러오기
	UserDTO getUserInfo(UserDTO uDTO) throws Exception;

	UserDTO idCheck(String userId) throws Exception;

	int updateJoinStudy(Map<String, String> sMap) throws Exception;

	int updateLeaveStudy(Map<String, String> pMap) throws Exception;

	int updateUserMbti(UserDTO pDTO) throws Exception;

	List<String> getUserMbti(List<String> list) throws Exception;

	UserDTO getUserKakao(HashMap<String, String> pMap);

	List<String> getMbtiCount();

	UserDTO getFaceInfo(HashMap<String, String> pMap);
	
	//비멀번호 변경
	int updateUserPwd(UserDTO pDTO)throws Exception;
		
	//회원 탈퇴
	int deleteUserInfo(UserDTO pDTO)throws Exception;
	
	//아이디 찾기
	UserDTO findUserid(UserDTO pDTO) throws Exception;
	
	//비밀번호 찾기
	UserDTO findUserPwd(UserDTO pDTO) throws Exception;
	
	//로그인
	UserDTO userLogin(UserDTO uDTO) throws Exception;
	
	//회원 탈퇴시 업로드 파일, 스터디 게시판, 스터디, 유저 이미지, faceimg삭제
	void delboardfile(UserDTO pDTO) throws Exception;
	void delstudyboard(UserDTO pDTO) throws Exception;
	void delstudyinfo(UserDTO pDTO) throws Exception;
	void deluserface(UserDTO pDTO) throws Exception;
	void deluserimg(UserDTO pDTO) throws Exception;

	
}
