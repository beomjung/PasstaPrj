package poly.persistance.mapper;

import config.Mapper;
import poly.dto.MbtiDTO;

@Mapper("MbtiMapper")
public interface IMbtiMapper {

	MbtiDTO getMbtiInfo(MbtiDTO mDTO) throws Exception;

	
	
}
