package kr.ac.kopo.comm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	private String enc;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
//		String enc = 현재 필터의 설정정보에서 encoding 초기화 파라미터 값 가져오기;
		enc = filterConfig.getInitParameter("encoding");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		request.setCharacterEncoding(enc); // POST방식 한글 파라미터 값을 위해서 (서블릿 실행 전에)

		chain.doFilter(request, response); // 이후 실행될 필터 또는 서블릿 실행
		// response를 이용하여 응답의 필터링 작업 수행
	}

}
