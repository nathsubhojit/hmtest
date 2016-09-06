package com.hm.services.number.sort;

import org.springframework.stereotype.Service;

import com.hm.services.number.sort.bean.SortRequest;
import com.hm.services.number.sort.bean.SortResponse;

@Service("sortService")
public class SortServiceImpl implements SortService {
	
	@Override
    public SortResponse<Integer> sortNumbers(SortRequest sortRequest) {
    	//Bubble sort algorithm to sort in ascending order
    	
		int bubbleSwaps = 0;
		long startTime = System.currentTimeMillis();
    	Integer[] randomNumbers = sortRequest.getInputList();
    	int length = randomNumbers.length;
	    for (int iteration = 1; iteration < length; iteration++) {
	    	for (int index = 0; index < length - iteration; index++) {
	    		Comparable<Integer> compElem = (Comparable<Integer>) randomNumbers[index];
	    		if (compElem.compareTo(randomNumbers[index + 1]) > 0) {
	    			Integer temp = randomNumbers[index];
	    			randomNumbers[index] = randomNumbers[index + 1];
	    			randomNumbers[index + 1] = temp;
	    			bubbleSwaps++;
	    		}
	    	}
	    }
	    long endTime = System.currentTimeMillis();
	    System.out.println("Starttime="+startTime+"  "+ "endtime="+endTime+"  "+"dur="+(endTime-startTime));
	    SortResponse<Integer> sortResponse = new SortResponse<>();
	    sortResponse.setOutputList(randomNumbers);
	    sortResponse.setSwapCount(bubbleSwaps);
	    sortResponse.setSortTime(endTime - startTime);
	    return sortResponse;
    }
}
