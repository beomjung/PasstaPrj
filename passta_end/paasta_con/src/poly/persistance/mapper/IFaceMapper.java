package poly.persistance.mapper;

import config.Mapper;
import poly.dto.FaceDTO;

@Mapper("FaceMapper")
public interface IFaceMapper {

	int FaceInsertImage(FaceDTO pDTO);
}
