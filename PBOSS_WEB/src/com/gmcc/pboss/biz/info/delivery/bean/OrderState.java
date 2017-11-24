package com.gmcc.pboss.biz.info.delivery.bean;

import com.gmcc.pboss.common.bean.CodeReverse;

/**
 * 从兴公司营账部
 * @author yuwenjun
 * @date 2009-10-3
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：订单商品统计信息
 */
public class OrderState extends CodeReverse {
	/**
	 * 商品类型编码
	 */
	private String dictitem;
	/**
	 * 套数
	 */
	private Long num = new Long(0);
	
	/**
	 * @return the dictitem
	 */
	public String getDictitem() {
		return dictitem;
	}
	/**
	 * @param dictitem the dictitem to set
	 */
	public void setDictitem(String dictitem) {
		this.dictitem = dictitem;
	}
	/**
	 * @return the num
	 */
	public Long getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(Long num) {
		this.num = num;
	}
	

}
