package poly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.FaceDTO;
import poly.persistance.mapper.IFaceMapper;
import poly.service.IFaceService;

@Service("FaceService")
public class FaceService implements IFaceService{
	
	@Resource(name="FaceMapper")
	private IFaceMapper faceMapper;

	@Override
	public int FaceInsertImage(FaceDTO pDTO) {
		return faceMapper.FaceInsertImage(pDTO);
	}

}
