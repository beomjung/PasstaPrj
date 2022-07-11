package poly.service.impl;

import static poly.util.CmmUtil.nvl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mortbay.log.Log;
import org.springframework.stereotype.Service;

import poly.dto.StudyListDTO;
import poly.persistance.mapper.IStudyMapper;
import poly.service.IStudyService;

@Service("StudyService")
public class StudyService implements IStudyService {

	@Resource(name = "StudyMapper")
	private IStudyMapper studyMapper;

	@Override
	public List<StudyListDTO> getAllStudyList() {

		return studyMapper.getAllStudyList();
	}

	@Override
	public int insertStudyInfo(StudyListDTO sDTO) {
		// 회원가입 성공 :1, 스터디이름 중복으로 인한 취소 : 2, 기타에러발생 :0
		int res = 0;

		if (sDTO == null) {
			sDTO = new StudyListDTO();
		}

		// 회원가입 중복 장지를 위해 DB에서 데이터 조회
		Log.info("getStudyExists start");
		StudyListDTO rDTO = studyMapper.getStudyExists(sDTO);
		Log.info("getStudyExists end");

		// mapper에서 값이 정상적으로 못 넘어오는 경우를 대비
		if (rDTO == null) {
			rDTO = new StudyListDTO();
		}

		// 중복된 스터디 정보가 있는경우, 결과값을 2로 변경하고, 더 이상 작업 진행하지 않음
		if (nvl(rDTO.getExists_yn()).equals("Y")) {
			res = 2;
		} else {
			// 화원가입
			Log.info("insertStudyService start");
			int success = studyMapper.insertStudyInfo(sDTO);
			Log.info("insertStudyService end");

			// db에 데이터가 등록되었다면,
			if (success > 0) {
				res = 1;
			} else {
				res = 0;
			}

		}
		Log.info("StudyService res : " + res);
		return res;
	}

	@Override
	public StudyListDTO getStudyInfo(String study_name) {
		return studyMapper.getStudyInfo(study_name);
	}

	@Override
	public List<StudyListDTO> getJoinStudyList(List<String> aList) {
		return studyMapper.getJoinStudyList(aList);
	}

	@Override
	public int updateJoinUser(Map<String, String> sMap) {
		return studyMapper.updateJoinUser(sMap);
	}

	@Override
	public int updateLeaveUser(Map<String, String> pMap) {
		return studyMapper.updateLeaveUser(pMap);
	}

	@Override
	public int deleteStudy(String study_name) {
		return studyMapper.deleteStudy(study_name);
	}

	@Override
	public String getStudyName(String study_seq) {
		return studyMapper.getStudyName(study_seq);
	}

	@Override
	public List<StudyListDTO> getfieldStudyList(String study_field) {
		return studyMapper.getfieldStudyList(study_field);
	}

	@Override
	public String getStudySeq(String study_name) {
		return studyMapper.getStudySeq(study_name);
	}

	@Override
	public int modifyNotice(Map<String, Object> pMap) {
		return studyMapper.modifyNotice(pMap);
	}

}
