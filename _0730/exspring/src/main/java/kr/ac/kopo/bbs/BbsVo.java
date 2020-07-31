package kr.ac.kopo.bbs;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BbsVo {
	private int bbsNo; // long이 훨씬 좋음
	private String bbsTitle;
	private String bbsContent;
	private String bbsWriter;
	private Date bbsRegDate;
	private int bbsCount;

	private List<AttachVo> attachList;	//첨부파일 하나가 아니라 여러개이므로 List붙여주기(한개일 경우 그냥 AttachVo만 써주면 된다)
	
	public List<AttachVo> getAttachList() {
		return attachList;
	}

	public void setAttachList(List<AttachVo> attachList) {
		this.attachList = attachList;
	}

	// 스프링의 MultipartResolver 를 통해서 업로드된 파일을 받을 때는
	// 하나의 파일이 하나의 MultipartFile 객체로 받는다
	private List<MultipartFile> upfileList;

	public List<MultipartFile> getUpfileList() {
		return upfileList;
	}

	public void setUpfileList(List<MultipartFile> upfileList) {
		this.upfileList = upfileList;
	}

	public int getBbsNo() {
		return bbsNo;
	}

	public void setBbsNo(int bbsNo) {
		this.bbsNo = bbsNo;
	}

	public String getBbsTitle() {
		return bbsTitle;
	}

	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}

	public String getBbsContent() {
		return bbsContent;
	}

	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}

	public String getBbsWriter() {
		return bbsWriter;
	}

	public void setBbsWriter(String bbsWriter) {
		this.bbsWriter = bbsWriter;
	}

	public Date getBbsRegDate() {
		return bbsRegDate;
	}

	public void setBbsRegDate(Date bbsRegDate) {
		this.bbsRegDate = bbsRegDate;
	}

	public int getBbsCount() {
		return bbsCount;
	}

	public void setBbsCount(int bbsCount) {
		this.bbsCount = bbsCount;
	}

}
