package poly.dto;

/**
 * @author 이재훈
 * @version 1.1 SpoilBroth
 */
public class UserDTO {

	private String user_seq; // 기본키, 순번
	private String user_auth; // 유저 권한
	private String user_id; // 아이디
	private String user_name; // 이름
	private String user_email; // 이메일
	private String user_pwd; // 비밀번호
	private String user_age; // 나이
	private String user_dept; // 학과
	private String user_mbti; // MBTI
	private String user_study; // 가입한 스터디그룹
	private String join_dt; // 가입일
	private String exists_yn; // 중복가입 방지를 위한 가상의 컬럼

	public String getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(String user_seq) {
		this.user_seq = user_seq;
	}

	public String getUser_auth() {
		return user_auth;
	}

	public void setUser_auth(String user_auth) {
		this.user_auth = user_auth;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_age() {
		return user_age;
	}

	public void setUser_age(String user_age) {
		this.user_age = user_age;
	}

	public String getUser_dept() {
		return user_dept;
	}

	public void setUser_dept(String user_dept) {
		this.user_dept = user_dept;
	}

	public String getUser_mbti() {
		return user_mbti;
	}

	public void setUser_mbti(String user_mbti) {
		this.user_mbti = user_mbti;
	}

	public String getUser_study() {
		return user_study;
	}

	public void setUser_study(String user_study) {
		this.user_study = user_study;
	}

	public String getJoin_dt() {
		return join_dt;
	}

	public void setJoin_dt(String join_dt) {
		this.join_dt = join_dt;
	}

	public String getExists_yn() {
		return exists_yn;
	}

	public void setExists_yn(String exists_yn) {
		this.exists_yn = exists_yn;
	}

}
