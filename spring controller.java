package com.mycompany.myapp;
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
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//RequestMapping ==> controller 에서 
	//@RequestMapping(value = "/", method = RequestMethod.GET) 시에 아래 내용을 호출한다.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		int sum = 0;
		for(int i = 0 ; i <= 100; i++) {
			sum = sum+i;
		}
		int n = 20;
		int k = 40;
		int recursive  = 0;
		int myMobile=5512213;
		int result = n+k;
		String myName="Lee";
		C c1 = new C();
		recursive = c1.Running(100);
		model.addAttribute("myName",myName);
		model.addAttribute("result",result);
		model.addAttribute("sum",sum);
		model.addAttribute("my_mobile",myMobile);
		model.addAttribute("recursive",recursive);
		return "home";//home.jsp 호출//
	}
	@RequestMapping(value="/howareyou", method = RequestMethod.GET)
	public String howareyou(Locale locale, Model model) {
		String greeting = "im fine thanks you and you?";
		model.addAttribute("answer",greeting);
		return "howareyou";
	}
	// /myworld ==> route임.//
	//route 가 /myworld 일때 동작한다 ==> 그리고 동작하면 String myworld(Locale locale,Model model)를 호출 
	@RequestMapping(value="/myworld", method = RequestMethod.GET)
	public String myworld(Locale locale, Model model) {
		D d1 = new D();
		E e1 = new E();
		int result2 = e1.Running3(10);
		int result = d1.Running2(5);
		String addr = "cheonan";
		model.addAttribute("cheonan",addr);
		model.addAttribute("result",result);
		model.addAttribute("result2",result2);
		return "myworld";
	}
	//@RequestMapping ==> 요청경로 (path)//
	//return "board/view";==> 뷰페이지 이름//
	//attribute 의 기본속성은 문자열이다.//
	//때문에 int 를 사용시 자동으로 문자열로 변환되게된다.//
	@RequestMapping(value="/board/content", method = RequestMethod.GET)
		public String content(Locale locale, Model model) {
		int id = 30;
		
		model.addAttribute("id",id);
		return "board/content";
	}
}

class C{
	protected int Running(int x) {
		if(x==1) {
			return x;
		}else {
			return x + Running(x-1);
		}
	}
}
class D{
	protected int Running2(int k) {
		if(k==1) {
			return k;
		}else {
			return k * Running2(k-1);
		}
	}
}
class E{
	protected int Running3(int y) {
		if(y==0) {
			return 0;
		}else if(y==1) {
			return 1;
		}else {
			return Running3(y-1)+Running3(y-2);
		}
	}
}
