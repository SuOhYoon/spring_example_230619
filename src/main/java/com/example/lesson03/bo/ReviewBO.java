package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {
	@Autowired	
	private ReviewMapper reviewMapper;
	// input
	// output: Review(단건)
	public Review selectReview(int id) {
		return reviewMapper.selectReview(id);
	}
	
	// input: Review(단건)
	// output: int(성공된 행의 개수)
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
	// addReviewAsField(4, "콤비네이션R", "김바다", 5.0, "역시 맛있다!!!");
	public int addReviewAsField(int storeId, String menu, String userName, Double point, String review) {
		return reviewMapper.insertReviewAsField(storeId, menu, userName, point, review);
	}
}
