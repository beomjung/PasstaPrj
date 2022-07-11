package poly.persistance.mapper;

import java.util.List;
import java.util.Map;

import config.Mapper;
import poly.dto.StudyListDTO;

@Mapper("StudyMapper")
public interface IStudyMapper {

	List<StudyListDTO> getAllStudyList();

	StudyListDTO getStudyExists(StudyListDTO sDTO);

	int insertStudyInfo(StudyListDTO sDTO);

	StudyListDTO getStudyInfo(String study_name);

	List<StudyListDTO> getJoinStudyList(List<String> aList);

	int updateJoinUser(Map<String, String> sMap);

	int updateLeaveUser(Map<String, String> pMap);

	int deleteStudy(String study_name);

	String getStudyName(String study_seq);

	List<StudyListDTO> getfieldStudyList(String study_field);

	String getStudySeq(String study_name);

	int modifyNotice(Map<String, Object> pMap);

}
