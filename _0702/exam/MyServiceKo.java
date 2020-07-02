package com.exam;

import org.springframework.stereotype.Component;

@Component("msko")
public class MyServiceKo implements MyService{

	@Override
	public String getHelloMsg() {
		return "안녕하세요!";
	}

	@Override
	public String getByeMsg() {
		return "안녕히가세요!";
	}

}
