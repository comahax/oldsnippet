package com.asisinfo.common.pager;

import java.util.List;

public class Page implements IPage {

	protected int pageNo = 1;

	protected int pageSize = 10;

	protected int total = -1;
	
	protected List rows;

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getLastPageNo() {
		if (getTotalNumberOfElements() == 0)
			return 1;
		else
			return getTotalNumberOfElements() % getPageSize() == 0 ? getTotalNumberOfElements()
					/ getPageSize()
					: getTotalNumberOfElements() / getPageSize() + 1;
	}

	public int getNextPageNo() {
		return getThisPageNo() + 1;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPreviousPageNo() {
		return getThisPageNo() - 1;
	}

	public int getThisPageFirstElementNo() {
		return (getThisPageNo() - 1) * getPageSize() + 1;
	}

	public int getThisPageLastElementNo() {
		int fullPage = getThisPageFirstElementNo() + getPageSize() - 1;
		return getTotalNumberOfElements() < fullPage ? getTotalNumberOfElements()
				: fullPage;
	}

	public int getThisPageNo() {
		if (pageNo > getLastPageNo()) {
			pageNo = getLastPageNo();
		}
		return pageNo;
	}

	public int getTotalNumberOfElements() {
		return total;
	}

	public int getTotalNumberOfPages() {
		if(total==0)return 0;
		if(total%pageSize==0)return total/pageSize;
		return total/pageSize+1;
	}

	public boolean hasNextPage() {
		return getLastPageNo() > getThisPageNo();
	}
	
	public boolean hasPreviousPage() {
		return getThisPageNo() > 1;
	}
	
	public boolean isFirstPage() {
		return getThisPageNo() == 1;
	}
	
	public boolean isLastPage() {
		return getThisPageNo() >= getLastPageNo();
	}

	public List<?> getThisPageElements() {
		return rows;
	}

	public void setThisPageElements(List<?> list) {
		this.rows = list;		
	}
}
