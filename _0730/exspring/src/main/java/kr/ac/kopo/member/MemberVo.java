package kr.ac.kopo.member;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//일반적으로 데이터베이스 테이블의 레코드(row) 1개를 저장할 수 있는 vo클래스를 정의
public class MemberVo {
		
	@NotEmpty //null 또는 빈문자열 저장 금지
	@Size(min=2, max=50)	//문자열길이가 1~50 사이
	private String memId;
	@NotEmpty //null 또는 빈문자열 저장 금지
	@Size(min=2, max=50)	//문자열길이가 1~50 사이
	private String memPass;
	@NotEmpty //null 또는 빈문자열 저장 금지
	@Size(min=2, max=50)	//문자열길이가 1~50 사이
	private String memName;
	@Min(0) //0이상의 갑만 저장가능
	private int memPoint;
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public int getMemPoint() {
		return memPoint;
	}
	public void setMemPoint(int memPoint) {
		this.memPoint = memPoint;
	}
	
	
}
