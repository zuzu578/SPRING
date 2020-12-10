package com.mybbb.bbb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController2 {
	@RequestMapping(value="/helloworld60", method = RequestMethod.GET)
	//RequestParam 방법 //
	//==>장점: 코드가 간결하다. httpServletClass에서 사용했던 getParameter()를 사용하지않는다//
	//parseInt를 해줄필요가 없다 (int 형과 String 형이 가능하다)==> 매개변수가 int , String 둘다 지원//
	public String newnew05(@RequestParam("x") int x,@RequestParam("y")int y, Model model) {
		int result = x+y;
		model.addAttribute("x",x);
		model.addAttribute("y",y);
		model.addAttribute("result",result);
		return "home";
	}
}
