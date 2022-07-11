package poly.service;

import poly.dto.FaceDTO;

public interface IFaceService {
	
	// Face경로 저장
	int FaceInsertImage(FaceDTO pDTO);
		
}
