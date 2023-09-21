package com.example.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.domain.UsedGoods;

@Repository
public interface UsedGoodsMapper {
	
	// input(BO-Service 요청) : X
	// output(BO-Service 결과 돌려줌) : List<UsedGoods>
	public List<UsedGoods> selectUsedGoodsList();
	
}
