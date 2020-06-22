package kr.ac.kopo.comm;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//리스너(Listener) : 특정 사건(이벤트)이 발생하면, 자동으로 실행
//	- 요청객체, 세션객체, 서블릿컨텍스트객체가 생성 또는 소멸될 때
//	- 요청객체, 세션객체, 서블릿컨텍스트객체가 속성을 추가, 수정, 삭제할 때
//	- 기타 등등

//리스너 등록 방법
//	- (1) 리스너 클래스에 @WebListener 적용
//	- (2) web.xml 에 등록 > 이 방법으로 할거임

//@WebListener
public class InitListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 서블릿컨텍스트 객체가 처음 생성된 후 딱 한번 실행 = 웹 애플리케이션이 처음 실행될 때 / 어떤것보다도 먼저 실행
		System.out.println("InitListener : contextInitialized 실행");
		
//		web.xml에 <context-param>으로 등록한 초기화파라미터값 가져오기
		String driver = sce.getServletContext().getInitParameter("driverClass");
		
		//		오라클 JDBC 드라이버 클래스를 메모리에 로드
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 서블릿컨텍스트 객체가 처음 소멸되기 직전에 딱 한번 실행 = 웹 애플리케이션이 종료될 때
		System.out.println("InitListener : contextDestroyed 실행");

	}

}
