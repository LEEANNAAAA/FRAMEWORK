package com.exam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class MyAdvice {
	public void log(JoinPoint jp) {
		Object target = jp.getTarget();	//실행대상 메서드가 속한 객체
		Signature sig = jp.getSignature();	//실행대상 메서드
		Object[] args = jp.getArgs();	//실행대상 메서드에 전달되는 메서드 (어떤 파라미터 값이 들어있는지 보여주는 역할)>여기서는 사용 안됨
		System.out.println("실행전 로그: " + target.getClass().getSimpleName()
				+ ":" + sig.getName());
	}
}
