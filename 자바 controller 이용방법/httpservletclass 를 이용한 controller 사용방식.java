package com.mybbb.bbb;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	//1)mapping ==> 경로를 지정해줌 ==> 경로를 지정해줌으로써 아래있는 메서드를 실행하게 된다.//
	//ex) 사용자가 주소에 mapping 된 경로를 입력하게되면 서버단에서 mapping 되어있는 메서드가 실행이 된다.//
	
	//2)getParameter() 가 있는 컨트롤러 즉 (httpServletRequest 클래스를 이용하는 컨트롤러 방법)
	//==> getParameter()는 queryString 에 데이터를 삽입하는 방식 
	@RequestMapping(value="/MapMap",method = RequestMethod.GET)
	public String home(HttpServletRequest httpServletRequest,Model model) {
		//http://localhost:8181/bbb/MapMap?x=20&y=10 이런식으로 쿼리스트링에 값을 전달하게 된다.//
		int x = Integer.parseInt(httpServletRequest.getParameter("x"));
		int y = Integer.parseInt(httpServletRequest.getParameter("y"));
		int result = x+y;
		//model ==> 데이터를 담아서 view 에 전달해주는 역할을 한다(mvc 패턴중 m(model)에 해당함)//
		model.addAttribute("x", x);
		model.addAttribute("y", y);
		model.addAttribute("result", result);
		//return ==> jsp 파일 단에 (view)에 던저주는 역할 
	    return "home";
		
	}
	
}
