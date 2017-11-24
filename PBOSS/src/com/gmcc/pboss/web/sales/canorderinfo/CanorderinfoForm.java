/**
 * auto-generated code
 * Wed Aug 10 10:50:17 CST 2011
 */
package com.gmcc.pboss.web.sales.canorderinfo;

import java.util.List;

import com.gmcc.pboss.business.sales.canorderinfo.CanorderinfoVO;
import com.gmcc.pboss.business.sales.comorder.OrderEmptyCardVO;

/**
 * <p>Title: canorderinfoForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class CanorderinfoForm extends CanorderinfoVO {
	
	private List<OrderEmptyCardVO> orderEmptyCardVOList;

	public List<OrderEmptyCardVO> getOrderEmptyCardVOList() {
		return orderEmptyCardVOList;
	}

	public void setOrderEmptyCardVOList(List<OrderEmptyCardVO> orderEmptyCardVOList) {
		this.orderEmptyCardVOList = orderEmptyCardVOList;
	}
	

}
