package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// C U D
	// Create(insert)
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "윤수오";
		String phoneNumber = "01011115555";
		String email = "dbstndh12@gmail.com";
		String dreamJob = "백엔드 개발자";
		
		// 지금 들어간 id값도 바로 꺼낼 수 있다. -> getId();
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
		
	}
	
	// U(Update)
	@GetMapping("/2")
	public StudentEntity update() {
		// id:2 dreamJob을 변경
		// JSON
		return studentBO.updateStudentDreamJobById(2, "사형수");
	}
	
	//D(Delete)
	@GetMapping("/3")
	public String delete() {
		studentBO.deleteStudentById(3);
		return "삭제 완료";
	}
}
