package poly.dto;

/**
 * @author 이재훈
 * @version 1.1 MyJsonDTO
 */
public class ContestDTO {
	
	private String contest_seq; // 공모전 고유번호
	private String contest_name; // 공모전 이름
	private String contest_area; // 분야
	private String contest_host; // 주최
	private String contest_img; // 이미지 주소
	private String contest_addr; // 홈페이지 주소
	private String contest_prize; // 총상금
	private String contest_day; // 기간
	private String contest_contents; // 상세내용
	private String reg_dt; // 등록일
	public String getContest_name() {
		return contest_name;
	}
	public void setContest_name(String contest_name) {
		this.contest_name = contest_name;
	}
	public String getContest_area() {
		return contest_area;
	}
	public void setContest_area(String contest_area) {
		this.contest_area = contest_area;
	}
	public String getContest_host() {
		return contest_host;
	}
	public void setContest_host(String contest_host) {
		this.contest_host = contest_host;
	}
	public String getContest_img() {
		return contest_img;
	}
	public void setContest_img(String contest_img) {
		this.contest_img = contest_img;
	}
	public String getContest_addr() {
		return contest_addr;
	}
	public void setContest_addr(String contest_addr) {
		this.contest_addr = contest_addr;
	}
	public String getContest_prize() {
		return contest_prize;
	}
	public void setContest_prize(String contest_prize) {
		this.contest_prize = contest_prize;
	}
	public String getContest_day() {
		return contest_day;
	}
	public void setContest_day(String contest_day) {
		this.contest_day = contest_day;
	}
	public String getContest_contents() {
		return contest_contents;
	}
	public void setContest_contents(String contest_contents) {
		this.contest_contents = contest_contents;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getContest_seq() {
		return contest_seq;
	}
	public void setContest_seq(String contest_seq) {
		this.contest_seq = contest_seq;
	}
	
}