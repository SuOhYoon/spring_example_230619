package com.example.lesson02;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.domain.UsedGoods;

@RestController
public class Lesson02Ex01RestController {

	// 요청 URL : http://localhost:8080/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01(){
		List<UsedGoods> usedGoodsList = ;
		return usedGoodsList; // json
	}
}
