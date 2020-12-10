package com.javalec.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
   

   @RequestMapping(value = "/home",method=RequestMethod.GET)
   public String home(Locale locale, Model model) {
      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale);
      String formattedDate = dateFormat.format(date);
      model.addAttribute("serverTime",formattedDate);
      return "home";
      
   }
   @RequestMapping(value = "/login")
   public String doLogin() {
      return "login";
      
}    
   @RequestMapping(value = "/tryLogin",method=RequestMethod.POST)
   public String tryLogin(@RequestParam("userid")String userid,
                     @RequestParam("userid")String passwd,Model model) {
      if(userid.equals("lee") && !passwd.equals("1234")) {
         return "redirect:home";//(redirect 시 route를 쓴다) jsp 파일 이아님 
      }else {
         return "redirect:login";
      }
      
   }
   
}