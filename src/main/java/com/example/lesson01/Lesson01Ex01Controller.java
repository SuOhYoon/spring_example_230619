package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01")
@Controller // Spring Bean 등록
public class Lesson01Ex01Controller {
	
	// String 출력
	// 요청 URL : http://localhost:8080/lesson01/ex01/1
	@RequestMapping("/1") // 주소 매핑
	@ResponseBody
	public String ex01_1() {
		return "<h1>문자열을 response body로 보내는 예제</h1>";
	}
	
	// Map -> JSON String 출력
	// 요청 URL : http://localhost:8080/lesson01/ex01/2
	@RequestMapping("/2") // 주소 매핑
	@ResponseBody
	public Map<String, Object> ex01_2(){
		Map<String, Object> map = new HashMap<>();
		map.put("사과", 33);
		map.put("포도", 21);
		map.put("바나나", 145);
		
		// map을 리턴하면 JSON으로 변경되어 출력됨
		// Web starter에 Jackson이라는 라이브러리가 포함되어 있기 때문
		return map;
	}
}
