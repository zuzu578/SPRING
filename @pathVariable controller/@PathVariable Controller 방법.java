package com.mybbb.bbb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Pass {
//@PathVariable 어노테이션으로 경로에 변수를 넣어서 요청메서드에서 파라미터로 이용할수 있게하는 방법이다.//
@RequestMapping("/student/{studentId}")
public String getStudent(@PathVariable String studentId, Model model) {
	model.addAttribute("studentId",studentId);
	return "student";
	
}
}
