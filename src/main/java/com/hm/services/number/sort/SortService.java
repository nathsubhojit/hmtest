package com.hm.services.number.sort;

import com.hm.services.number.sort.bean.SortRequest;
import com.hm.services.number.sort.bean.SortResponse;

public interface SortService {
	
	public SortResponse sortNumbers(SortRequest randomNumbers);
	
}
