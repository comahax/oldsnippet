package com.gmcc.pboss.biz.basic.dictItem.model;

import com.gmcc.pboss.common.bean.Code;

public class DictItem extends Code{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * 构造函数
	 * @param code
	 * @param name
	 */
	public DictItem(String code, String name) {
		super(code,name);
	}//DictItem(String , String ) 
	
	/**
	 * 构造函数
	 * @param code
	 * @param name
	 * @param type
	 */
	public DictItem(String code, String name,String type) {
		super(code,name);
		this.type = type;
	}//DictItem(String , String ,String)
}
