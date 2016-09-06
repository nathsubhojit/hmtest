package com.hm.services.number.sort.bean;

public class SortResponse<T> {

	T[] outputList;
	Integer swapCount;
	
	long sortTime;
		
	public long getSortTime() {
		return sortTime;
	}
	public void setSortTime(long sortTime) {
		this.sortTime = sortTime;
	}
	public T[] getOutputList() {
		return outputList;
	}
	public void setOutputList(T[] outputList) {
		this.outputList = outputList;
	}
	public Integer getSwapCount() {
		return swapCount;
	}
	public void setSwapCount(Integer swapCount) {
		this.swapCount = swapCount;
	}
}
