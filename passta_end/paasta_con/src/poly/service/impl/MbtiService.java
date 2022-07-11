package poly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.MbtiDTO;
import poly.persistance.mapper.IMbtiMapper;
import poly.service.IMbtiService;

@Service("MbtiService")
public class MbtiService implements IMbtiService{
	
	@Resource(name="MbtiMapper")
	private IMbtiMapper mbtiMapper;

	@Override
	public MbtiDTO getMbtiInfo(MbtiDTO mDTO) throws Exception {
		return mbtiMapper.getMbtiInfo(mDTO);
	}

}
