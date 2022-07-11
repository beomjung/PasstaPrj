package poly.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.OcrDTO;
import poly.persistance.mapper.IImgMapper;
import poly.service.IImgService;

@Service("ImgService")
public class ImgService implements IImgService{
	
	@Resource(name="ImgMapper")
	private IImgMapper imgMapper;

	@Override
	public int InsertImage(OcrDTO pDTO) throws Exception {
		return imgMapper.InsertImage(pDTO);
	}

	@Override
	public Map<String, String> getImgList(String id) throws Exception {
		return imgMapper.getImgList(id);
	}

	@Override
	public int StudyInsertImage(OcrDTO pDTO) throws Exception {
		return imgMapper.StudyInsertImage(pDTO);
	}

	@Override
	public Map<String, String> getStudyImgList(String study_name) throws Exception {
		return imgMapper.getStudyImgList(study_name);
	}

	@Override
	public int insertFilePath(OcrDTO fDTO) throws Exception {
		return imgMapper.insertFilePath(fDTO);
	}

}
