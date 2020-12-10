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

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
   
   
   @RequestMapping(value = "/studentinput")
   public String studentinput() {
      return "studentinput";
   }
   //Ä¿¸Çµå °´Ã¼//
   @RequestMapping(value = "/studentView", method = RequestMethod.GET)
   public String studentView(StudentInformation studentInformation) {
      return "studentView";
   }
   
}