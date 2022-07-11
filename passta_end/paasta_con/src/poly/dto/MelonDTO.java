package poly.dto;

/**
 * @author 이재훈
 * @version 1.1 MelonDTO
 */
public class MelonDTO {

	private String collect_time; // 입력시간
	private String seq; // 순번
	private String song; // 노래제목
	private String singer; // 가수이름
	private int sigerCnt; // 가수순위
	
	public String getCollect_time() {
		return collect_time;
	}
	public void setCollect_time(String collect_time) {
		this.collect_time = collect_time;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public int getSigerCnt() {
		return sigerCnt;
	}
	public void setSigerCnt(int sigerCnt) {
		this.sigerCnt = sigerCnt;
	}
	
		
}
