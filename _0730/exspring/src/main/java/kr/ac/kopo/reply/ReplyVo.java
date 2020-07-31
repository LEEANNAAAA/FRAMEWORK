package kr.ac.kopo.reply;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReplyVo {
	private int repNo; // 댓글번호
	private String repContent; // 댓글내용
	private String repWriter; // 댓글작성자아이디
	//Jackson 라이브러리가 JSON으로 변환시 지정한 패턴에 맞는 문자열로 변환하도록 지정
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private Date repDate; // 댓글작성일
	
	private int repBbsNo; // 댓글이속한게시글번호

	public int getRepNo() {
		return repNo;
	}

	public void setRepNo(int repNo) {
		this.repNo = repNo;
	}

	public String getRepContent() {
		return repContent;
	}

	public void setRepContent(String repContent) {
		this.repContent = repContent;
	}

	public String getRepWriter() {
		return repWriter;
	}

	public void setRepWriter(String repWriter) {
		this.repWriter = repWriter;
	}

	public Date getRepDate() {
		return repDate;
	}

	public void setRepDate(Date repDate) {
		this.repDate = repDate;
	}

	public int getRepBbsNo() {
		return repBbsNo;
	}

	public void setRepBbsNo(int repBbsNo) {
		this.repBbsNo = repBbsNo;
	}
}
