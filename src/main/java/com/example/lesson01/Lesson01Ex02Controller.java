package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // jsp를 뿌릴 떄는 @ResponseBody가 없는 @Controller를 사용해야 한다.
public class Lesson01Ex02Controller {
	
	// 요청 URL : http://localhost:8080/lesson01/ex02
	@RequestMapping("/lesson01/ex02")
	public String ex02() {
		// jsp 경로를 리턴함
		// return "/WEB-INF/jsp/lesson01/ex02.jsp";
		//  /WEB-INF/jsp/ 중간 경로 .jsp	
		return "lesson01/ex02";
	}
}
