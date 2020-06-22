package kr.ac.kopo.comm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {

//		오라클 JDBC 드라이버 클래스를 메모리에 로드
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

	}

}
