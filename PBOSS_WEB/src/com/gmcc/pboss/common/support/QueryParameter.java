package com.gmcc.pboss.common.support;

import java.io.Serializable;

public class QueryParameter implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8111296875687254162L;
	
	/**
	 * 子业务类型:-100表示无子业务类型
	 */
	private int operation = -100;

	/**
	 * 页码
	 */
	private int no = CommonConstants.PAGE_NO;

	/**
	 * 页面大小
	 */
	private int size = CommonConstants.PAGE_SIZE;
	
	/**
	 * 初始化页面(如首页)要显示的总记录数
	 */
	private int all_size = CommonConstants.ALL_SIZE;
	
	/**
	 * 翻页查询
	 */
	private int pageQuery = 0;

	private int action = QueryAction.SECTION;
	
	/**
	 * 是否需要排序 true表示需要排序 false表示不需要排序
	 */
	private boolean _orderby;
	/**
	 * "0"为升序，"1"为降序
	 */
	private String _desc;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public int getAll_size() {
		return all_size;
	}

	public void setAll_size(int all_size) {
		this.all_size = all_size;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	/**
	 * @return the pageQuery
	 */
	public int getPageQuery() {
		return pageQuery;
	}

	/**
	 * @param pageQuery the pageQuery to set
	 */
	public void setPageQuery(int pageQuery) {
		this.pageQuery = pageQuery;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public boolean is_orderby() {
		return _orderby;
	}

	public void set_orderby(boolean _orderby) {
		this._orderby = _orderby;
	}

	public String get_desc() {
		return _desc;
	}

	public void set_desc(String _desc) {
		this._desc = _desc;
	}
	

}
