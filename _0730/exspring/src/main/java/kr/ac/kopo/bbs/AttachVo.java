package kr.ac.kopo.bbs;

public class AttachVo {
	private int attNo;//첨부파일번호
	private String attOrgName; //원래 파일명
	private String attNewName ;//서버에 저장한 파일명
	private int attBbsNo;//첨부파일이 속한 게시글의 글번호
	
	public int getAttNo() {
		return attNo;
	}
	public void setAttNo(int attNo) {
		this.attNo = attNo;
	}
	public String getAttOrgName() {
		return attOrgName;
	}
	public void setAttOrgName(String attOrgName) {
		this.attOrgName = attOrgName;
	}
	public String getAttNewName() {
		return attNewName;
	}
	public void setAttNewName(String attNewName) {
		this.attNewName = attNewName;
	}
	public int getAttBbsNo() {
		return attBbsNo;
	}
	public void setAttBbsNo(int attBbsNo) {
		this.attBbsNo = attBbsNo;
	}
	
}
