package com.myproject01.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class LoginForm {
	@RequestMapping("/helloworld")
	public String Login(){
		
		return "LoginForm";
	}
	@RequestMapping("/TryLogin")
	public String TryLogin(HttpServletRequest httpServletRequest,Model model) {
		String id = httpServletRequest.getParameter("id");
		String password = httpServletRequest.getParameter("password");
		String email = httpServletRequest.getParameter("email");
		if(id.equals("dlwnghks12")&&password.equals("123qwe")&&email.equals("dlwnghks6821@naver.com")) {
			
		model.addAttribute("id",id);
		model.addAttribute("password",password);
		model.addAttribute("email",email);
		return "SuccessLogin";
		}else {
			return "redirect:helloworld";
		}
	}
}
