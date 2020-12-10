package com.mycompany.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//커맨드 객체를 이용한 방법
@Controller
public class Controller2 {
	//커맨드 객체 이용을 하면 주석처리 한것 보다 더 짧게 코드를 쓸수있다//
	@RequestMapping(value="/member/join",method = RequestMethod.GET)
	public String joinData(//@RequestParam("name")String name,
						   //@RequestParam("id")String id,
						   //@RequestParam("pw")String pw,
						   //@RequestParam("email")String email,Model model) {
							Member member,Model model) {
		//Member member,Model model 이것을 커맨드 객체 라고한다//
		//데이터를 전송해야하는 것이 많을때 사용한다.//
		//Member member = new Member();
		//member.setName(name);
		//member.setPw(pw);
		//member.setId(id);
		//member.setEmail(email);
		model.addAttribute("memberinfo",member);
		return "board/join";
		
		
}
}
	

