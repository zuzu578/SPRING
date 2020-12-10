package com.mybbb.bbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//Command 를 이용해서 Controller 사용하기 (data전송하기)
public class Comand {
	//==>1) 데이터를 입력받는 form 이있는 jsp 경로를 Mapping한다
	 @RequestMapping(value = "/studentinput")
	public String studentinput() {
	//이 메소드는 form 이있는 jsp를 불러오는 메서드
      return "studentinput";
	   }
	 //클라이언트 단에서 입력받은 Data 를 form 을이용해서 전송하고 그 전송한 데이터 값을 객체에서 받아서 
	 //==>클래스(객체)에서 데이터를 getter(),setter()를 이용해서 데이터를 입력받는다.//
	 //그래서 크게 3가지가 필요한데
	 //1) 데이터를 입력하는 JSP(view) 
	 //2) 데이터를 설정할수있는 class(객체,==>즉 커맨드 객체)(Controller)
	 //3) 데이터를 보여주는 JSP(view)
	 @RequestMapping(value = "/studentView", method = RequestMethod.GET)
	   public String studentView(StudentInformation studentInformation) {
	      return "studentView";
	   }
}
