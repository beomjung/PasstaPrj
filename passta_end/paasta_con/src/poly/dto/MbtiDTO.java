package poly.dto;

/**
 * @author 이협건
 * @version 1.1 공지사항 DTO
 */
public class MbtiDTO {

	private String mbti_name; // mbti이름
	private String mbti_img_path; // mbti 이미지 경로
	private String mbti_content; // mbti 기본정보
	
	
	public String getMbti_name() {
		return mbti_name;
	}
	public void setMbti_name(String mbti_name) {
		this.mbti_name = mbti_name;
	}
	public String getMbti_img_path() {
		return mbti_img_path;
	}
	public void setMbti_img_path(String mbti_img_path) {
		this.mbti_img_path = mbti_img_path;
	}
	public String getMbti_content() {
		return mbti_content;
	}
	public void setMbti_content(String mbti_content) {
		this.mbti_content = mbti_content;
	}
	
}
