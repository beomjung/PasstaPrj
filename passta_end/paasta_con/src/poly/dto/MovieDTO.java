package poly.dto;

/**
 * @author 이재훈
 * @version 1.1 Movie DTO
 */

public class MovieDTO {

	private String rank_check_time; // 시간,순번 복합키 
	private String seq; // 순번
	private String movie_rank; // 순위
	private String movie_nm; // 제목
	private String movie_reserve; // 예매율
	private String score; //  
	private String open_day; // 개봉일
	private String reg_id; // 등록자 아이디
	private String reg_dt; // 등록일
	private String chg_id; // 수정자 아이디
	private String chg_dt; // 수정일
	
	
	
	public String getRank_check_time() {
		return rank_check_time;
	}
	public void setRank_check_time(String rank_check_time) {
		this.rank_check_time = rank_check_time;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getMovie_rank() {
		return movie_rank;
	}
	public void setMovie_rank(String movie_rank) {
		this.movie_rank = movie_rank;
	}
	public String getMovie_nm() {
		return movie_nm;
	}
	public void setMovie_nm(String movie_nm) {
		this.movie_nm = movie_nm;
	}
	public String getMovie_reserve() {
		return movie_reserve;
	}
	public void setMovie_reserve(String movie_reserve) {
		this.movie_reserve = movie_reserve;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getOpen_day() {
		return open_day;
	}
	public void setOpen_day(String open_day) {
		this.open_day = open_day;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getChg_id() {
		return chg_id;
	}
	public void setChg_id(String chg_id) {
		this.chg_id = chg_id;
	}
	public String getChg_dt() {
		return chg_dt;
	}
	public void setChg_dt(String chg_dt) {
		this.chg_dt = chg_dt;
	}
	

}
