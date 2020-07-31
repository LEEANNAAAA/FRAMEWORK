package com.exam;

import org.springframework.stereotype.Component;

//@Component("msen")
//@Component("myService")
public class MyServiceEn implements MyService{

	@Override
	public String getHelloMsg() {
		return "Hello, Anna!";
	}

	@Override
	public String getByeMsg() {
		return "Okay.. Bye!";
	}

}
