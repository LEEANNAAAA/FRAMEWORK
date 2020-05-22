package kr.ac.kopo.exapp;

import java.util.ArrayList;
import java.util.Scanner;

public class ExList2 {
	
	//"1.목록 2.추가 3.삭제 4.종료" 라고 메뉴를 출력
	//번호를 입력받는다
	//"1"을 입력한 경우, 현재까지 입력한 값들을 모두 출력
	//"2"을 입력한 경우, "좋아하는 음식을 입력하세요"라고 출력하고,
	//음식 이름을 입력 받아서 리스트에 저장
	//"3"을 입력한 경우, "삭제할 음식의 번호를 입력하세요"라고 출력하고,
	//입력한 번호의 음식을 리스트에서 삭제
	//"4"을 입력한 경우, 프로그램을 종료
		
	//위 작업을 무한 반복
		
		public static void main(String[]args) {
			
			boolean run = true;
			
			Scanner sc = new Scanner(System.in);
			
			ArrayList<String> list = new ArrayList<String>();
			list.add("바삭바삭 치킨");
			list.add("달콤달콤 치킨");
			list.add("허니콤보 치킨");
			list.add("간장간장 치킨");
			
			while(run) {
				System.out.println("--------------------------------------------");
				System.out.println("1.목록 | 2.추가 | 3.삭제 | 4.종료");
				System.out.println("--------------------------------------------");
				System.out.println("선택 > ");
				
				String menu = sc.nextLine();
				
				switch(menu) {
				case "1":
					for(int i=0;i<list.size();i++) {
						System.out.println((i+1)+" : "+list.get(i));
					}
					break;
				case "2":
					System.out.println("좋아하는 음식을 입력하세요");
					String food = sc.nextLine();
					list.add(food);
					break;
				case "3":
					System.out.println("삭제할 음식의 번호를 입력하세요");
					String num = sc.nextLine();
					int n = Integer.parseInt(num);
					list.remove(n);
					break;
				case "4":
					run = false;
					break;
				default :
					break;
				}
			}
			
			System.out.println("프로그램 종료");
			
			
		}
	}


