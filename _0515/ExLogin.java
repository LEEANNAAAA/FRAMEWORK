package kr.ac.kopo.exapp;

import java.util.Scanner;

public class ExLogin {

	public static void main(String[] args) {
		//"ID를 입력하세요"라고 출력하고, id를 입력받고,
		//"비밀전호를 입력하세요"라고 출력하고 비밀번호를 입력받고,
		//입력한 ID가 "a001"이 아니면, 존재하지 않는 ID입니다."라고 출력
		//입력한 ID가"a001"이고 비밀번호가 "1234"이면,"로그인 성공"이라고 출력
		//입력한 ID가"a001"이고 비밀번호가 "1234"아니면,"로그인 실패"이라고 출력
			
		Scanner sc = new Scanner(System.in);
	
		System.out.println("ID를 입력하세요");
		String ID = sc.nextLine();		
		System.out.println("비밀번호를 입력하세요");
		String PW = sc.nextLine();	
				
		//문자열 비교
		if(ID.equals("a001") ) {//입력받은 id 값이 "a001"인 경우
			
			if(PW.equals("1234")) {//입력받은 pw 값 1234인 경우
				System.out.println("로그인 성공.");
			}else{
			System.out.println("로그인 실패.");
			}	
		}else {//입력받은 id 값이 a001이 아닌 경우
			System.out.println("존재하지 않는 ID입니다.");
		
		}

	}

}
