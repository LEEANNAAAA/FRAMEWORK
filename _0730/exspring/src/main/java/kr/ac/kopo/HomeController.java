package kr.ac.kopo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
//@Controller의 @RequestMapping 메서드는 실행결과로서 스프링에게 모델과 뷰 정보를 알려줘야 한다
//모델 : 응답에 포함되어야하는 데이터(JSP에서 꺼내서 사용할 데이터)
//뷰 : 응답 화면 출력을 담당하는 객체 (어떤 JSP로 이동할 것인지에 대한 정보)

@Controller	//웹 요청을 받아서 실행되는 클래스임을 표시(서블릿과 유사한 역할)
public class HomeController {
	//로그 출력을 위한 로거 객체 가녀오기
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
//	@RequestMapping으로 어떤 주소와 요청방식으로 요청이 왔을 때 실행될 메서드인지를 설정
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)//"/home.do"로 GET	방식 요청이 오면 이 메서드를 실행
	public String home(Locale locale, Model model) {
		//로그 출력
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();	//현재 시간을 담은 객체 생성
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);	//날짜/시간을 현재 로케일에 맞는 형태의 문자열로 변환
		
		//모델에 "serverTime"라는 이름으로 formattedDate 변수 값을 저장
		//JSP에서는 ${serverTime}라는 표현으로 formattedDate 변수값을 사용가능
		model.addAttribute("serverTime", formattedDate );
		
		//화면출력을 위해 이동해야 할 뷰(JSP)의 이름을 반환
		return "home";	//"WEB-INF/views/home.jsp"
	}
	
//	http://localhost:8001/kopo/test.do 주소로 요청을 보내면,
//	test.jsp 화면이 나오도록 구현
	
//	@RequestMapping("/test.do")	//value라는 속성이 여러개인 경우 안써줘도 된다.
//	@RequestMapping(value="/test.do")	//method를 생략하면 요청방식에 상관없이 실행
	@RequestMapping(value="/test.do", method = RequestMethod.GET)
	public String test(	//http://localhost:8001/kopo/test.do?myNo=123 주소창에 칠 때
			@RequestParam("myNo") String no,	//"myNo"라는 이름의 파라미터 값을 변수에 저장 
			int myNo,	//변수명이 파라미터명과 같은 경우에는 @RequestParam 생략가능 (자동형변환가능)
			@ModelAttribute("mvo") MyVo mv,	//사용자가 정의한 객체의 변수에는 동일한 이름의 파라미터 값이 자동저장
			//@ModelAttribute를 사용하여 모델에 지정한 이름으로 추가 가능
			MyVo vo, //파라미터를 받기 위한 객체는 자동으로 모델에 추가
			//모델에 저장되는 이름은 타임(클래스명)의 첫글자만 소문자로 바꾼 이름을 사용
			Model model, ModelMap modelMap, Map map) {	//셋 중 하나 본인이 선호하는 것을 사용하면 된다. Map을 더 선호
		System.out.println("myNo1 : "+ no);
		System.out.println("myNo2 : "+ myNo);
		System.out.println("mv의 myNo : "+ mv.getMyNo());
		System.out.println("mv의 myId : "+ mv.getMyId());

		String s = "Hello, Spring!";
		
		//모델에 데이터를 추가(저장)하는 방법
		//인자로 받은 Model, ModelMap, Map 객체에 데이터를 저장
		
		model.addAttribute("modelVal", s);
		modelMap.addAttribute("modelMapVal", s);
		map.put("mapVal", s);
//		map.put("mvo",mv);
		
		return "test";
	}
	
	@RequestMapping("/clock.do")
	public String clock() {
		return "clock";
	}
	
	@RequestMapping("/data.do")
	@ResponseBody //메서드의 반환값 자체가 응답 데이터로 전송되어야 함을 표시
	public Map<String,Object> data() {
		
		Date d = new Date();
		String ds = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
		int n = (int) (Math.random() * 10);
		
//		now:ds, num:n
//		
//		-XML형식
//		<item>
//			<now>2020-07-22 11:42:42</now>
//			<num>7</num>
//		</item>
//		
//		-JSON형식: 자바스크립트 객체표현과 동일하고, 2가지 다른점 존재
//		1. 속성이름을 문자열로 표현
//		2. 문자열은 반드시 쌍따옴표만 사용
//		
//			var obj = { now : '2020-07-22 11:42:42', num:7}; //자바스크립트객체
//			{"now" : "2020-07-22 11:42:42", "num" : 7} JSON문자열
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("now", ds);
		map.put("num", n);
		
		return map;
//		return "{\"now\" : \"" + ds + "\", \"num\" : " + n + "}";
	}
	
	
}
