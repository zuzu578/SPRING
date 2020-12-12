package com.myf74.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
	public class FormController {
		@RequestMapping("/UserLogin")
		public String Login() {
			return "UserLogin";
		}
		@RequestMapping("/SuccessLogin")
		public String SuccessLogin(HttpServletRequest httpServletRequest,Model model) {
			String userid = httpServletRequest.getParameter("userid");
			String userpassword = httpServletRequest.getParameter("userpassword");
			model.addAttribute("userid",userid);
			model.addAttribute("userpassword",userpassword);
			return "SuccessLogin";
		}
	
	@RequestMapping(method=RequestMethod.GET, value="/UserTryLogin")
	public String UserTryLogin(@RequestParam("userid") String userid,
			@RequestParam("userpassword") String userpassword,Model model) {
		if(userid.equals("dlwnghks6821")&& userpassword.equals("123qwe")) {
			model.addAttribute("userid",userid);
			model.addAttribute("userpassword",userpassword);
			//==> login ==> 로그인 내역을(userid , userpassword 를 model객체에 담아서)
			//==>redirect 를 하게되면 직접적으로 SuccessLogin에 전달은 못하지만 //
			//==> querystring에도 남아있으므로 SuccessLogin path 에 위치한 메서드 안에서
			//==>UserTryLogin메서드에서 전달한 쿼리스트링을 이용해서 httpServletRequest클래스
			//를 이용해서 getParameter 통해 model 객체에 데이터를 담아서 view 에 던저줄수있다.//
			//단점 ==> post 방식으로는 안됨 ==> post 는 queryString 에 데이터가 보이지않기때문//
			
			return "redirect:SuccessLogin";//==>로그인에 성공했을 경우 path 를 redirect한다//
		}else {
			return "redirect:UserLogin";//==> 로그인에 실패했을경우 path를 UserLogin(다시로그인하게끔)redirect한다.//
			
		}
	}
}
