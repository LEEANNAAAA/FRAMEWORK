package kr.ac.kopo.exapp;

import java.util.Scanner;

public class Cal2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번쨰 숫자 입력");
		String n1 = sc.nextLine();
		System.out.println("두번쨰 숫자 입력");
		String n2 = sc.nextLine();
		System.out.println("연산자 입력하세요 ( +,-,*,/)");
		String op = sc.nextLine();
		//하나의 값을 동등비교 할떄는 swith가 편함!
		
		double num1 = Double.parseDouble(n1);
		double num2 = Double.parseDouble(n2);
		
		double result = 0; // 변수의 초기값을 지정해 주고 변수를 사용해야함
		
		
		switch (op) {
		case "+":
			result = num1 + num2;
		break;
		
		case "-":
			result = num1 - num2;
		break;
			
		case "*":
			result = num1 * num2;
		break;
			
		case "/":
			result = num1 / num2;
		break;
			
		default:
			System.out.println("알 수 없는 연산자");
			return;
		}	
	
			
		System.out.println(n1 + op + n2+ "=" + result); // 실행되기 떄문에 값이 나온다.
						
	}

}
