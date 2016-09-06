package com.hm.services.number.generator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.domain.RandomNumber;
import com.hm.services.number.sort.SortService;
import com.hm.services.number.sort.bean.SortRequest;
import com.hm.services.number.sort.bean.SortResponse;
import com.hm.util.DateUtil;

@Service("randomNumberService")
public class RandomNumberServiceImpl implements RandomNumberService {
    
	@Autowired
	SortService sortService;
	
	
    @Override
    public RandomNumber generateRandomNumbers(Integer number) {
                
        Integer[] list = new Integer[3];
        
        list[0] = (int) (Math.floor(Math.random() * 90000) + 10000);
        list[1] = (int) (Math.floor(Math.random() * 90000) + 10000);
        list[2] = (int) (Math.floor(Math.random() * 90000) + 10000);
        
        SortRequest sortRequest = new SortRequest();
        sortRequest.setInputList(list);
        
        SortResponse sortResponse = sortService.sortNumbers(sortRequest);
        list = (Integer[])sortResponse.getOutputList();
        RandomNumber randomNumber = new RandomNumber();
        randomNumber.setApp_Number1(list[0]);
        randomNumber.setApp_Number2(list[1]);
        randomNumber.setApp_Number3(list[2]);
        randomNumber.setTimeTaken(sortResponse.getSortTime());
        randomNumber.setSwaps(sortResponse.getSwapCount());
        return randomNumber;
    }
    
    @Override
    public List<RandomNumber> listRandomNumbers() {
        List<RandomNumber> listRandoms = new ArrayList<RandomNumber>();
    	RandomNumber random = new RandomNumber();
        
        listRandoms.add(random);
        return listRandoms;
    }
}
