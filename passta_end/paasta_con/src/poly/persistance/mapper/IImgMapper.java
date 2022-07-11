package poly.persistance.mapper;

import java.util.Map;

import config.Mapper;
import poly.dto.OcrDTO;

@Mapper("ImgMapper")
public interface IImgMapper {
	
	// 유저 프로필 이미지 저장하기
	int InsertImage(OcrDTO pDTO) throws Exception;
	
	// 프로필 이미지 가져오기
	Map<String, String> getImgList(String id) throws Exception;
	
	// 스터디그룹 이미지 저장하기
	int StudyInsertImage(OcrDTO pDTO) throws Exception;
	
	// 스터디그룹 이미지 가져오기
	Map<String, String> getStudyImgList(String study_name) throws Exception;

	//스터디 게시판 파일 저장하기
	public int insertFilePath(OcrDTO fDTO) throws Exception;
		
	Map<String, String> getBoardFile(String notice_seq) throws Exception;
	

}
