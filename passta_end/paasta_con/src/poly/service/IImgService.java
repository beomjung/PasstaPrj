package poly.service;

import java.util.Map;

import poly.dto.OcrDTO;

public interface IImgService {
	
	/**
	 * 유저 이미지 정보
	 * @param pDTO
	 */
	// 프로필 이미지 정보 저장하기
	public int InsertImage(OcrDTO pDTO) throws Exception;
	
	// 프로필 이미지 정보 가져오기
	public Map<String, String> getImgList(String id) throws Exception;
	
	/**
	 * 스터디 이미지 정보
	 * @param pDTO
	 */
	// 스터디 이미지 정보 저장하기
	public int StudyInsertImage(OcrDTO pDTO) throws Exception;
	
	// 스터디 이미지 정보 가져오기
	public Map<String, String> getStudyImgList(String study_name) throws Exception;
	
	//게시판 파일 업로드
	public int insertFilePath(OcrDTO fDTO) throws Exception;
	
	
}
