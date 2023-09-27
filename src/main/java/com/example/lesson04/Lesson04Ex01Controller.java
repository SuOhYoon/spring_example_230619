package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;

@RequestMapping("/lesson04/ex01")
@Controller // jsp로 보낼 때는 @ResponseBody가 없어야 함.
public class Lesson04Ex01Controller {
	
	@Autowired
	private UserBO userBO;
	
	// 회원가입 페이지
	// http://localhost:8080/lesson04/ex01/sign-up-view
	@RequestMapping(path = "/sign-up-view", method = RequestMethod.GET)
	public String signUpView() {
		return "lesson04/signUp"; // jsp view 경로
	}
	
	// 회원가입 수행(db insert) 후 결과 페이지로 이동
	// http://localhost:8080/lesson04/ex01/sign-up
	@PostMapping("/sign-up")
	public String signUp(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value="introduce", required=false) String introduce) {
		
		// DB Insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		return "lesson04/signUpResult";
	}
	
	// 최신 가입자 한명 가져오는 페이지
	// http://localhost:8080/lesson04/ex01/get-latest-user-view
	@GetMapping("/get-latest-user-view")
	public String getLatestUserView(Model model) {
		// DB select 조회
		User user = userBO.getLatestUser();
		model.addAttribute("result", user);
		model.addAttribute("title", "최신 유저 정보");
		
		return "lesson04/getLatestUser";
	}
}
