package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {
	
	public Review selectReview(int id);
	
	// return int(MyBatis가 성공된 행의 개수를 리턴해줌)
	public int insertReview(Review review);
	
	public int insertReviewAsField(
			// 파라미터 2개 이상이면 map으로 만든다(@Param)
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
	
	public int updateReviewById(
			@Param("id")int id, 
			@Param("review")String review);
	
	public void deleteReviewById(int id);
}
