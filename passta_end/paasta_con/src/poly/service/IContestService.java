package poly.service;

import java.util.List;

import poly.dto.ContestDTO;

public interface IContestService {

	int saveJsonCrawl(ContestDTO pDTO) throws Exception;

	List<ContestDTO> getTenContest() throws Exception;

	ContestDTO getContestDetail(String contest_seq) throws Exception;

	List<ContestDTO> getAreaContest(String contest_area) throws Exception;
	
}
