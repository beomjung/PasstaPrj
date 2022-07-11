package poly.dto;

/**
 * @author 이재훈
 * @version 1.1 스터디 그룹별 게시판 DTO
 */
public class FaceDTO {

	private String user_id; // 유저 아이디
	private String save_file_path; // 이미지파일 저장경로
	private String save_model_path; // 학습모델 저장경로
	private String reg_dt; // 등록일
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getSave_file_path() {
		return save_file_path;
	}
	public void setSave_file_path(String save_file_path) {
		this.save_file_path = save_file_path;
	}
	public String getSave_model_path() {
		return save_model_path;
	}
	public void setSave_model_path(String save_model_path) {
		this.save_model_path = save_model_path;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	
}
