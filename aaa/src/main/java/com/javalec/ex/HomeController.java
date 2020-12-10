package com.javalec.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/Success", method = RequestMethod.GET)
	public String Success(@RequestParam("first_name") String first_name,@RequestParam("last_name") String last_name,@RequestParam("email") String email,@RequestParam("password") String password,Model model) {
		model.addAttribute("first_name",first_name);
		model.addAttribute("last_name",last_name);
		model.addAttribute("email",email);
		model.addAttribute("password",password);
		return "Success";
		
	}
	
	 @RequestMapping(value = "/",method = RequestMethod.GET)
	   public String doLogin() {
	      return "login";

	}  
	 @RequestMapping(value = "/Signup",method = RequestMethod.GET)
	   public String Signup() {
	      return "Signup";

	}  
	 @RequestMapping(value = "/tryLogin",method=RequestMethod.GET)
	 public String tryLogin(@RequestParam("userid")String userid,
             	@RequestParam("passwd")String passwd,Model model) {
		if(userid.equals("lee") && passwd.equals("1234")) {
			return "redirect:home";
		}else {
			return "redirect:/";
}

	
	 }
}
