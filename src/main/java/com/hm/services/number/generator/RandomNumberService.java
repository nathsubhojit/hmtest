package com.hm.services.number.generator;

import java.util.List;

import com.hm.domain.RandomNumber;

public interface RandomNumberService {

	public RandomNumber generateRandomNumbers(Integer number);
	public List<RandomNumber> listRandomNumbers();

}
