package poly.service;

import java.util.List;

import poly.dto.BoardDTO;
import poly.dto.OcrDTO;

public interface IBoardService {
	
		// 게시판 리스트
		List<BoardDTO> getBoardList(String study_seq) throws Exception;
		
		// 게시판 글 등록
		int InsertBoardInfo(BoardDTO pDTO) throws Exception;
		
		// 게시판 상세보기
		BoardDTO getBoardInfo(BoardDTO pDTO) throws Exception;
		
		// 게시판 조회수 업데이트
		void updateBoardReadCnt(BoardDTO pDTO) throws Exception;
		
		// 게시판 글 수정
		void updateBoardInfo(BoardDTO pDTO) throws Exception;
		
		// 게시판 글 삭제
		void deleteBoardInfo(BoardDTO pDTO) throws Exception;

		//파일 업로드시 notice_seq 가져와서 저장
		BoardDTO getNotiSeq(BoardDTO pDTO) throws Exception;
		
		//게시판 상세 보기시 파일 보여주기
		List<OcrDTO> getFileList(String notice_seq) throws Exception;
		
		//수정시 게시판 파일 삭제
		void delBoardFile(BoardDTO dDTO) throws Exception;
}
