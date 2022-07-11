package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.BoardDTO;
import poly.dto.OcrDTO;
import poly.persistance.mapper.IBoardMapper;
import poly.service.IBoardService;

@Service("BoardService")
public class BoardService implements IBoardService{
	
	@Resource(name="BoardMapper")
	private IBoardMapper boardMapper;

	@Override
	public List<BoardDTO> getBoardList(String study_seq) throws Exception {
		return boardMapper.getBoardList(study_seq);
	}

	@Override
	public int InsertBoardInfo(BoardDTO pDTO) throws Exception {
		return boardMapper.InsertBoardInfo(pDTO);
	}

	@Override
	public BoardDTO getBoardInfo(BoardDTO pDTO) throws Exception {
		return boardMapper.getBoardInfo(pDTO);
	}

	@Override
	public void updateBoardReadCnt(BoardDTO pDTO) throws Exception {
		boardMapper.updateBoardReadCnt(pDTO);
	}

	@Override
	public void updateBoardInfo(BoardDTO pDTO) throws Exception {
		boardMapper.updateBoardInfo(pDTO);
	}

	@Override
	public void deleteBoardInfo(BoardDTO pDTO) throws Exception {
		boardMapper.deleteBoardInfo(pDTO);
	}

	@Override
	public BoardDTO getNotiSeq(BoardDTO pDTO) throws Exception {
		return boardMapper.getNotiSeq(pDTO);
	}

	@Override
	public List<OcrDTO> getFileList(String notice_seq) throws Exception {
		return boardMapper.getFileList(notice_seq);
	}

	@Override
	public void delBoardFile(BoardDTO dDTO) throws Exception {
		boardMapper.delBoardFile(dDTO);
	}

}
