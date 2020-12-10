//@RequestMapping("/index")==>input 에 값 입력 ==> 입력 값을 가지고 @RequestMapping(method=RequestMethod.GET, value="/student") 로 
	//index 의 <form action="student"method="GET"> 이므로 , form 에서 경로가 student 이기때문에
	//index에서 전달한 데이터를 student 에 전송하면서 실행이된다.
	//가지고 감 
 
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	//get 방식 ==> .../student?student_id=xxx
	@RequestMapping(method=RequestMethod.GET, value="/student")
	public String getID(@RequestParam("student_id") String sid,Model model) {
		model.addAttribute("student_id",sid);
		return "student";
	}