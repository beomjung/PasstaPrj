package poly.dto;

/**
 * @author 이재훈
 * @version 1.1 ChatJsonDTO 
 */
public class ChatJsonDTO {

	private String chat_id; // 유저 아이디
	private String chat_dt; // 채팅시간
	private String chat_contents; // 채팅시간
	private String study_seq; // 스터디 고유번호
	private String study_name; // 키값으로 사용할 스터디이름
	
	public String getChat_id() {
		return chat_id;
	}
	public void setChat_id(String chat_id) {
		this.chat_id = chat_id;
	}
	public String getChat_dt() {
		return chat_dt;
	}
	public void setChat_dt(String chat_dt) {
		this.chat_dt = chat_dt;
	}
	public String getChat_contents() {
		return chat_contents;
	}
	public void setChat_contents(String chat_contents) {
		this.chat_contents = chat_contents;
	}
	public String getStudy_seq() {
		return study_seq;
	}
	public void setStudy_seq(String study_seq) {
		this.study_seq = study_seq;
	}
	public String getStudy_name() {
		return study_name;
	}
	public void setStudy_name(String study_name) {
		this.study_name = study_name;
	}
	
}