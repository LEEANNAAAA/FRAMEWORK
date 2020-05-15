package kr.ac.kopo.exapp;//패키지:클래스 파일이 저장되는 폴더

import java.util.Scanner;

//일반적으로 도메인을 거꾸로 사용함;

//자바 프로그램: 클래스 단위로 작성하고 실행
public class ExamOut {
	//클래스를 실행 == 클래스 내부의 main 메소드(명령어 묶음)에 정의된 명령문들을 순서대로 실행
	public static void main(String[] args) {	
	//표준입력(키보드)로 부터 데이터를 읽을 수 있는 스캐너 객체 생성
	Scanner sc = new Scanner(System.in);	
	//엔터키를 입력할 때 까지 입력한 문자열을 가져와 변수에 저장	
	
	//이름을 입력하세요 라고 출력하고,
	//이름을 입력받고, "Hello,입력한 이름을 출력"
	
	System.out.println("입력을 입력하세요.");
	String A = sc.nextLine(); // 한줄을 입력받아 저장함
	System.out.println("Hello,"+A);
	
}

}