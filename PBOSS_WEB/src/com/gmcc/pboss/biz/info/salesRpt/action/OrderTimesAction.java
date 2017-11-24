package com.gmcc.pboss.biz.info.salesRpt.action;

import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.biz.info.salesRpt.service.OrderTimesService;
public class OrderTimesAction extends AbstractAction {

	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		return null;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	
	private OrderTimesService orderTimesService;
	public OrderTimesService getOrderTimesService(){
		return this.orderTimesService;
	}
	public void setOrderTimesService(OrderTimesService orderTimesService){
		this.orderTimesService = orderTimesService;
	}
	
	public String countOrders(){
		this.setTitle(PageLoction.SalesOrderTimes);//订购次数信息查询
		int[] a = this.orderTimesService.searchOrderCount(this.getMember());
		max = a[0];
		count = a[1];
		if(max!=0)
			remain = max - count;
		else
			remain = 0;
		return SUCCESS;
	}
	
	int max, count, remain;
	public int getMax(){
		return this.max;
	}
	public void setMax(int a ){
		this.max = a;
	}
	public int getCount(){
		return this.count;
	}
	public void setCount(int a){
		this.count = a;
	}
	public int getRemain(){
		return this.remain;
	}
	public void setRemain(int a){
		this.remain = a ;
	}
}
