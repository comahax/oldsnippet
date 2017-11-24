package com.gmcc.pboss.biz.basic.goods.supper;

import javax.servlet.http.HttpSession;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class GoodsListQueryParameter extends QueryParameter {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	public GoodsListQueryParameter() {
		setAction(QueryAction.ALL);// 不分页
	}

	private String query;
	/**
	 * 商品种类
	 */
	private String comType;
	/**
	 * 订购套数
	 */
	private int orderCount=-1;
	
	private int limit = 10;
	
	/**
	 * 用户级别Session
	 */
	private HttpSession session;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * @return the comType
	 */
	public String getComType() {
		return comType;
	}

	/**
	 * @param comType the comType to set
	 */
	public void setComType(String comType) {
		this.comType = comType;
	}

	/**
	 * @return the orderCount
	 */
	public int getOrderCount() {
		return orderCount;
	}

	/**
	 * @param orderCount the orderCount to set
	 */
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}

}
