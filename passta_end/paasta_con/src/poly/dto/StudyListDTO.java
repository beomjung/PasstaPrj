package poly.dto;

/**
 * @author 이협건
 * @version 1.1 공지사항 DTO
 */
public class StudyListDTO {

	private String study_seq;
	private String study_dt;
	private String study_field;
	private String study_name;
	private String study_member;
	private String study_title;
	private String study_contents;
	private String exists_yn; // 중복가입 방지를 위한 가상의 컬럼
	private String study_notify; // 게시판 알림
	private String study_creator; // 개설자
	
	public String getStudy_seq() {
		return study_seq;
	}
	public void setStudy_seq(String study_seq) {
		this.study_seq = study_seq;
	}
	public String getStudy_dt() {
		return study_dt;
	}
	public void setStudy_dt(String study_dt) {
		this.study_dt = study_dt;
	}
	public String getStudy_field() {
		return study_field;
	}
	public void setStudy_field(String study_field) {
		this.study_field = study_field;
	}
	public String getStudy_name() {
		return study_name;
	}
	public void setStudy_name(String study_name) {
		this.study_name = study_name;
	}
	public String getStudy_member() {
		return study_member;
	}
	public void setStudy_member(String study_member) {
		this.study_member = study_member;
	}
	public String getStudy_title() {
		return study_title;
	}
	public void setStudy_title(String study_title) {
		this.study_title = study_title;
	}
	public String getStudy_contents() {
		return study_contents;
	}
	public void setStudy_contents(String study_contents) {
		this.study_contents = study_contents;
	}
	public String getExists_yn() {
		return exists_yn;
	}
	public void setExists_yn(String exists_yn) {
		this.exists_yn = exists_yn;
	}
	public String getStudy_notify() {
		return study_notify;
	}
	public void setStudy_notify(String study_notify) {
		this.study_notify = study_notify;
	}
	public String getStudy_creator() {
		return study_creator;
	}
	public void setStudy_creator(String study_creator) {
		this.study_creator = study_creator;
	}
	
}
