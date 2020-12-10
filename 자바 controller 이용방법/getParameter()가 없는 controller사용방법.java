package com.mybbb.bbb;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController3 {
	//queryString 을 이용하지않고 ControllerMethod단에서 데이터를 설정해주는 방법//
	//특징1)getParameter() 가 없다 
	//특징2)Controller를 작성할때 Parameter 가 자동으로 수집이 된다
	@RequestMapping(value="/helloworld25234",method = RequestMethod.GET)
	public String newnew02(HttpServletRequest req, Model model) {
		
		int x = 40;
		int y = 20;
		int result = x+y;
		model.addAttribute("x",x);
		model.addAttribute("y",y);
		model.addAttribute("result", result);
		
		return "board/newnew02";
		
	}
}
