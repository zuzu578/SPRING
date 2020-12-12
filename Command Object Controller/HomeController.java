package com.myf74.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
//command object ==> class(object) 를 이용한 model 방법//
public class HomeController {

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input() {
		return "input";
	}
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String home(Studentinfo studentinfo) {
		return "home";
		
	}
	
}

