package com.mycompany.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controller3 {
	//1)RequestParam 방법
	//2) queryString 을 통해서 매개변수를 전달할때 사용하는 방법
	@RequestMapping(value="/helloworld", method = RequestMethod.GET)
	public String newnew05(@RequestParam("x") int x,@RequestParam("y")int y, Model model) {
		
		int result = x+y;
		model.addAttribute("x",x);
		model.addAttribute("y",y);
		model.addAttribute("result",result);
		return "board/newnew02";
		
	
	}
	
	//3)HttpServletRequest class 를 이용한 일반적인방법//
	//4)==>그냥 일반적으로 route에다가 쿼리스트링을 이용하여 매개변수를 주지않고, 변수를 미리 설정할때 사용//
	@RequestMapping(value="/helloworld2",method = RequestMethod.GET)//경로(route 이름)
	public String newnew02(HttpServletRequest req, Model model) {
		int x = 40;
		int y = 20;
		int result = x+y;
		model.addAttribute("x",x);
		model.addAttribute("y",y);
		model.addAttribute("result", result);
	
		return "board/newnew02";
			//jsp 파일 이름임 //
	}
}
