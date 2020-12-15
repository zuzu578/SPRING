package com.javalec.practice.controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.practice.BDao.BDao;
import com.javalec.practice.BDto.BDto;
import com.javalec.practice.util.Constant;

@Controller
public class BController {
	//1) JDBC template 을 이용한 Spring CRUD 게시판 
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
		
	}
	
	
	
	
	//orm ==> 테이블과 클래스를 매핑시킴  ==> DTO 에서 테이블 레코드 이름과 DTO클래스의 필드 이름이 동일하게 함//
							//Read//
					//==> 글 목록 읽어오기 <==//
	@RequestMapping("/list")
	
	public String list(Model model) {
		//1) dao 객체에 접근 ==> sql 실행을 위함//
		//2) dto 객체에 접근 ==> dao 에서 꺼네온 data들을 dto 객체를 이용해서 setter( ) , getter( ) , constructor( ) 를 통해 설정 //
		//3) 잘 설정된 dto에 담긴 data를 model 객체에 담아서 view 에 전송  (최종목적)//
		System.out.println("list()");
		BDao dao = new BDao();
		//==>dao의 (sql을 이용을) 통해서 dto에 데이터를 전달 ==> dto(ORM)의 getter, setter ,constructor 를 통해 데이터를 초기화작업 (설정해줌)
		//list 자료형을 사용한이유는 여러개의 값을 넣기위함//
		ArrayList<BDto>dtos = dao.list();
		model.addAttribute("dtos",dtos);//==>이 내용을 list.jsp 에 던져준다.//
		dtos.get(1);
		return "list";
	}
	//create 화면 나오게 하기//
	@RequestMapping("/write_view") // 새글 쓰기  화면 나오게 하기 
	public String write_view(HttpServletRequest req, Model model) {
		System.out.println("write_view()");
		System.out.println("글쓰기 ");
		return "write_view";
	}
		//create//
		@RequestMapping(value="/write",method=RequestMethod.POST) //게시글 저장(등록)//
		public String write(HttpServletRequest req, Model model) {
			//view(write_view) 에서 던져준 데이터를(Method ="POST")  받아서 
			//==>HttpServletRequest ==> getParameter( ) 를 사용하겠다는 의미 //
			String bId = req.getParameter("bId");
			String bName = req.getParameter("bName");
			String bTitle = req.getParameter("bTitle");
			String bContent = req.getParameter("bContent");
			//dao 객체에 접근
			BDao dao = new BDao();
			//dao 에서 받아서 sql 실행
			//dao의 write 라는 메서드 를 통해서 getParameter( ) 했던 데이터들을 전달해준다 ==> 매개변수를 통해서 전달 ==>sql에 넘겨줌 //
			dao.write(bName,bTitle,bContent);
			//==> dao 객체에서 sql 작업이 끝나면 ,list.jsp(글목록을 보여주는 페이지) 로 redirect하게된다.//
			return "redirect:list";
			//새글 저장//
			
		}
		//read//
		//클릭한 게시물의 게시물 내용을 읽어오기//
		@RequestMapping("/content_view")
		public String content_view(HttpServletRequest req, Model model) {
			System.out.println("content_view()");
			//특정 bId인 게시글 읽어오기 (조회)
			 //list.jsp 에서 <a href="content_view?bId=${dto.bId}"> 에 의해서 간접적으로 해당게시물을 클릭했을때 bId를 쿼리스트링에 남기게됨//
			//getParameter()사용 ==> queryString 에서 해당 게시물의 index(bId)값을 가져오게됨//
			//==> bId를 읽어와야하므로 HttpServletRequest 사용 ==>getParameter( ) 를 이용해서 값을 전달 받음 //
			
			int bId=Integer.parseInt(req.getParameter("bId"));
			//ParseInt 사용 이유 : getParameter( ) queryString ==> 자료형 타입:String 
			//getParameter 를 한 데이터를 dao 에 전달하여 sql문을 실행 시키기 위해서는 dao 객체를 인스턴스화 할 필요가 있다.//
			BDao dao = new BDao();
			//dao 객체의 contentView라는 메서드 에 매개변수를 통해서 getParameter 했던 bId 값 을  전달한다
			//bId 값을 dto 에 담아서 dto에서 setter, getter , constructor 를 통해 초기화 , 설정을 해준다.//
			BDto dto = dao.contentView(bId);
			model.addAttribute("content_view",dto);
			
			return "content_view";
			
		}
		
		//update//
		@RequestMapping("/modify_view")
		//==> 선택된 페이지를 수정하기 위한 method//
		//==> Mapping : "/modify_view" ==> 수정 페이지를 보여준다./
		//==> 참고로 content_view.jsp 에서 <a href="modify_view?bId=${content_view.bId }"> 로인해서 간접적으로 쿼리스트링에 bId를 남기게
		//==> 되므로, 쿼리스트링에 bId인 게시물을 기준으로 update 를 실행 해주면 된다,//
		public String modify_view(HttpServletRequest req, Model model) {
			System.out.println("content_view()");
			//==> queryString ==> bId 데이터 값을 getParameter( ) 를 이용해서 전달을 받아줘야한다.//
			//==> queryString , getParameter( ) == > queryString data 자료형이 String == > Casting 필요 // 
			int bId=Integer.parseInt(req.getParameter("bId"));
			
			BDao dao = new BDao();
			//dao에 있는 cotentView라는 메서드에다가 getParameter 를 통해 전달 받은 데이터 값을 매개변수로 전달 ,해준다음 //
			//dao 에서 sql 작업을 끝낸후 ,dto 에 전달 //
			BDto dto = dao.contentView(bId);
			model.addAttribute("modify_view",dto);
			return "modify_view";

		}
		@RequestMapping(value="/modify",method=RequestMethod.POST)
		public String modify(HttpServletRequest req, Model model) {
			System.out.println("modify()");
			//클릭한 게시물의 modify_view 페이지 에서 전송된 값 (data == > form(POST))을 
			//getParameter( ) 를 이용해서 받아온다.//
			String bId=req.getParameter("bId");
			String bName =req.getParameter("bName");
			String bTitle=req.getParameter("bTitle");
			String bContent=req.getParameter("bContent");
			BDao dao = new BDao();
			//==> dao 객체에 전달을 해준다 ==> sql 실행//
			//==> dao.modify(  ) ==> 매개변수를 받아서 sql 실행//
			dao.modify(Integer.parseInt(bId),bName,bTitle,bContent);
			//==>작업 종료시 list (path(mapping))로 redirect 
			return "redirect:list";
		}
		//delete//
		@RequestMapping(value="/delete")
		public String delete(HttpServletRequest req, Model model) {
			//게시물을 삭제 ==> 클릭한 게시물의 내용을 삭제 하기 ==> 클릭한 게시물의 고유의 bId 가 있어야 하는것 
			//<a href="delete?bId=${content_view.bId }"> 이렇게 content_view.jsp 에서 ==> 즉 , 내가 클릭한 content_view.jsp에서
			//삭제 버튼을 눌렀을때 간접적으로 클릭한 (현재 보여지는 게시물) 의 bId를 queryString 에 간접적으로 노출함
			//때문에 간접적으로 노출된 queryString 을 getParameter( ) 를 이용해서 dao 값을 전달해주면된다.//
			//==> 결론은 내가 현재 머물고있는 content_view.jsp 의 bId를 기준으로 삭제 , 수정을 해주는 작업을 하게 되는것이다.//
			
			System.out.println("delete()");
			//==>queryString 에서 간접적으로 노출된 bId 값을 받아온다.(getParameter( ))//
			String bId= req.getParameter("bId");
			BDao dao = new BDao();
			//dao객체에 있는 delete( ) 매개변수로 전달 //
			dao.delete(Integer.parseInt(bId));
			//==> 삭제후 목록으로 돌아가기<== //
			return "redirect:list";
		}
		
		@RequestMapping("/reply_view")//댓글 쓰기 화면 표시/
		public String reply_view(HttpServletRequest req, Model model) {
			System.out.println("reply_view()");
			return "reply_view";
		}
		@RequestMapping("/reply")//댓글 저장//
		public String reply(HttpServletRequest req, Model model) {
			System.out.println("reply()");
			String bId = req.getParameter("bId");
			String bName = req.getParameter("bName");
			String bTitle = req.getParameter("bTitle");
			String bContent = req.getParameter("bContent");
			String bGroup = req.getParameter("bGroup");
			String bStep = req.getParameter("bStep");
			String bIndent = req.getParameter("bIndent");
			BDao dao = new BDao();
			dao.reply(bId,bName,bTitle,bContent,bGroup,bStep,bIndent);
			return "redirect:list";
		}
	}
	

