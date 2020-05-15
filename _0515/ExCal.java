package kr.ac.kopo.exapp;

import java.util.Scanner;

public class ExCal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 숫자를 입력하세요");			
		int num1 = sc.nextInt();
		
		System.out.println("두번째 숫자를 입력하세요");	
		int num2 = sc.nextInt();
		
		System.out.println("연산자를 입력하세요");	
		String Cal = sc.next();
		
		 int result = 0;
		switch(Cal) {
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
		}
			
		System.out.println(num1+Cal+num2+"="+result);
		
	}

}
