package com.mycompany.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controller3 {
	//1)RequestParam 방법
	//2) queryString 을 통해서 매개변수를 전달할때 사용하는 방법
	//아래에 있는 (HttpServletRequest)클래스 를 이용한 방법의 축약 버전이라고 볼수있다. 간결하게 코드를 작성한다.//
	//이 방법이 좋은이유는 String 과 int 둘다 쿼리스트링을 작성할시에 사용할수있어서 ParseInt를 사용하지않아도 된다는 점이 좋다.//
	@RequestMapping(value="/helloworld", method = RequestMethod.GET)
	public String newnew05(@RequestParam("x") int x,@RequestParam("y")int y, Model model) {
		int result = x+y;
		model.addAttribute("x",x);
		model.addAttribute("y",y);
		model.addAttribute("result",result);
		return "board/newnew02";
	}
	
	//3)일반적인 (getParameter 가 없는 방법)//
	//4)==>그냥 일반적으로 route에다가 쿼리스트링을 이용하여 매개변수를 주지않고, 변수를 미리 설정하여  사용할수도있음//
	//이 방법은 getParameter 가 없는 방법이기때문에 가능함.//
	@RequestMapping(value="/helloworld2",method = RequestMethod.GET)//경로(route 이름)
	public String newnew02(HttpServletRequest req, Model model) {
		//이런식으로 변수를 미리 설정해줄수도있고 
		int x = 40;
		int y = 20;
		int result = x+y;
		model.addAttribute("x",x);
		model.addAttribute("y",y);
		model.addAttribute("result", result);
		return "board/newnew02";
			//jsp 파일 이름임 //
	}
	//5)getParameter 방법//
	//이방법은 (HttpServletRequest) 클래스를 이용하여 쿼리스트링에 직접 입력 데이터를 전송하는 방법중하나이다.//
	//이방법은 위의 방법과 동일하지만 코드의 길이가 길다.//
	//이방법은 (HttpServletRequest) 클래스를 이용하며, 전송할 내용의 데이터를 쿼리스트링에서 getParameter 해주는 방식이다.//
	
	@RequestMapping(value="/helloworld3",method = RequestMethod.GET)
	public String newnew03(HttpServletRequest httpServletRequest,Model model) {
		//특징 ==> getParameter 에서 쿼리스트링에 들어가는 parameter 값은 String 이다 때문에 //
		//ParseInt과정을 거쳐줘야한다 (만약정수라면)//
		int x = Integer.parseInt(httpServletRequest.getParameter("x"));
		int y = Integer.parseInt(httpServletRequest.getParameter("y"));
		int result = x+y;
		model.addAttribute("x", x);
		model.addAttribute("y", y);
		model.addAttribute("result", result);
	    return "board/newnew02";
	}
	
}