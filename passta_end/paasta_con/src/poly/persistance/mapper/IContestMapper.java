package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.ContestDTO;

@Mapper("ContestMapper")
public interface IContestMapper {

	int saveJsonCrawl(ContestDTO pDTO) throws Exception;

	List<ContestDTO> getTenContest() throws Exception;

	ContestDTO getContestDetail(String contest_seq) throws Exception;

	List<ContestDTO> getAreaContest(String contest_area) throws Exception;

}
