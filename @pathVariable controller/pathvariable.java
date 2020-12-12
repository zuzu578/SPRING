package com.myf74.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathVariableClass {
	@RequestMapping("/hell/{hell}")
	public String hell(@PathVariable int hell,Model model) {
		model.addAttribute("hell", hell);
		
		return "Path";
	}
}
