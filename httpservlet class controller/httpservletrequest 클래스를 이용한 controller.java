package com.myf74.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Http {
	@RequestMapping(value="/!!!",method = RequestMethod.GET)//경로(route 이름)
	public String Http(HttpServletRequest req, Model model) {
		//제곱 근 구하기 //
		//1)정수 2개 필요//
		int result = 1; 
		int x = 2;
		int y= 10;
		for(int i = 1; i<=y; i++) {
			result = result *x;
		}
		int result2 = (int) Math.pow(2, 10);
		model.addAttribute("result", result);
		model.addAttribute("result2", result2);
		return "!!";
		
	}
	
	
}
