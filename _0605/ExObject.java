package kr.ac.kopo.exapp;

import java.util.ArrayList;

public class ExObject {
	public static void main(String[] args) {
		// ExList 클래스의 내용을 참고하여 다음과 같은 기능을 수행하는 프로그램을 작성
		// 1. 음식이름을 저장할 수 있는 목록을 생성
		// 2. 좋아하는 음식 이름 3개 목록에 저장
		// 3. 저장한 음식 이름을 순서대로 출력

		ArrayList<String> list = new ArrayList<String>();

		list.add("피자");
		list.add("치킨");
		list.add("햄버거");

		System.out.println(list);
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
//		System.out.println(list.get(2));

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// 4. 음식의 이름과 가격을 함께 저장하려면 어떻게 해야할지를 고민
		ArrayList<Food> foodList = new ArrayList<Food>();
		// 이름은 "피자", 가격은 "10000"원인 음식을 추가
		Food f1 = new Food(); // 실제 공간이 생김
		f1.setName("피자");	//f1.name = "피자";
		f1.setPrice(10000);	//	f1.price = 10000;
		foodList.add(f1);

		// 이름은 "스파게티", 가격은 "5000"원인 음식을 추가
		Food f2 = new Food();
		f2.setName("스파게티");	//		f2.name = "스파게티";
		f2.setPrice(5000);	//		f2.price = 5000;
		foodList.add(f2);

		// 이름은 "햄버거", 가격은 "2000"원인 음식을 추가
		Food f3 = new Food();
		f3.setName("햄버거");		//		f3.name = "햄버거";
		f3.setPrice(2000);	//		f3.price = 2000;
		foodList.add(f3);

		// 저장한 음식 이름과 가격을 순서대로 출력
		for (int i = 0; i < foodList.size(); i++) {
			Food f = foodList.get(i);
//			System.out.println(f.name+","+f.price);
			System.out.println(f.getName()+","+f.getPrice());
		}
		System.out.println();
		
		//한 회원의 아이디, 이름, 포인트를 저장할 수 있는 Member라는 데이터 타입(클래스)를 정의
		//여러명의 회원 정보를 저장할 수 있는 목록을 생성
		//아이디 "a001", 이름 "고길동", 포인트 100 인 회원 정보를 목록에 저장 
		//아이디 "a002", 이름 "마이콜", 포인트 200 인 회원 정보를 목록에 저장 
		//아이디 "a003", 이름 "도우너", 포인트 300 인 회원 정보를 목록에 저장
		//회원 목록에 저장된 전체 회원의 아이디, 이름, 포인트를 출력
		
		ArrayList<Member> MemberList = new ArrayList<Member>();
		
		//Member라는 저장공간을 만들어놨음
		
		Member m1 = new Member();
		m1.setId ("a001");
		m1.setName("고길동");
		m1.setPoint(100);
		MemberList.add(m1);
		
		Member m2 = new Member();
		m2.setId ("a002");
		m2.setName ("마이콜");
		m2.setPoint(200);
		MemberList.add(m2);
		
		Member m3 = new Member();
		m3.setId ("a003");
		m3.setName ("도우너");
		m3.setPoint (300);
		MemberList.add(m3);
		
		System.out.println("회원목록");
		for (int i = 0; i < MemberList.size(); i++) {
			Member m =MemberList.get(i);
//			System.out.println(m.id+","+m.name+","+m.point);
			//값을 읽어오는 것이 get, 값을 설정하는 것이 set
			System.out.println(m.getId()+","+m.getName()+","+m.getPoint());
		}
	}
}
