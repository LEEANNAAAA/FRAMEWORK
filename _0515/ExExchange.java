package kr.ac.kopo.exapp;

import java.util.Scanner;

public class ExExchange {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("달러 금액을 입력하세요");
		String money = sc.nextLine();
		
		double num =Double.parseDouble(money);
		double result = num * 1216.90;
				
		System.out.println(result + "원");
		
		
		System.out.println("현찰 사실때" + (num * 1238.19) +"원");	
		System.out.println("현찰 파실때"+(num * 11965.61)+"원"); //1238.19		
		System.out.println("송금 보내실떄"+(num * 1228.80) +"원"); //1238.19		
		System.out.println("송금 보내 받으실때"+(num * 1205.00)+"원"); //1238.19			
	
		

			

	}

}
