package com.gmcc.pboss.biz.info.salesRpt.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.biz.basic.dictItem.service.DictItemService;
import com.gmcc.pboss.biz.basic.dictItem.support.DictItemQueryParameter;
import com.gmcc.pboss.biz.info.salesRpt.service.SalesRptService;
import com.gmcc.pboss.biz.info.salesRpt.support.SalesHistoryQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;

public class SalesHistoryAction extends AbstractAction {

	private SalesHistoryQueryParameter parameter;

	private SalesRptService service;

	//商品种类查询
	private DictItemService dictItemService;
	private Map dictItem;
	public QueryParameter getParameter() {

		parameter = parameter == null ? new SalesHistoryQueryParameter() : parameter;
		// parameter.setStartMonth("200905");
		// parameter.setEndMonth("200908");
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
		LoginMember member = getMember();

		parameter.setWayid(member.getWayid());

		return parameter;
	}

	/**
	 * @param parameter the parameter to set
	 */
	public void setParameter(SalesHistoryQueryParameter parameter) {
		this.parameter = parameter;
	}

	/**
	 * @return the service
	 */
	public SalesRptService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(SalesRptService service) {
		this.service = service;
	}

	/**
	 * @return the dictItemService
	 */
	public DictItemService getDictItemService() {
		return dictItemService;
	}

	/**
	 * @param dictItemService the dictItemService to set
	 */
	public void setDictItemService(DictItemService dictItemService) {
		this.dictItemService = dictItemService;
	}

	/**
	 * @param dictItem the dictItem to set
	 */
	public void setDictItem(Map dictItem) {
		this.dictItem = dictItem;
	}

	public void prepare() throws Exception {

	}

	public String doQuery() {

		LoginMember member = getMember();
		ServiceResult result = service.transact(member, getParameter(), ServiceType.QUERY);
		// 回写JSON
		this.writeJSONServicePage(result, getsetCols());
		
		return null;
	}

	public String doList() {
		this.setTitle(PageLoction.SalesHistory);//商品订购历史查询
		//提取商品类型
		Map c =(Map)dictItemService.transact(this.getMember(), new DictItemQueryParameter(), ServiceType.QUERY).getRetObject();
		//(null, getParameter()).getRetObject();
		this.setDictItem(c);
		return super.doList();
	}//doList

	public List getsetCols() {
		List setCols = new ArrayList();
		setCols.add(new ColumnSet("comcategoryName", "商品种类"));
		setCols.add(new ColumnSet("brandName", "套卡品牌"));
		setCols.add(new ColumnSet("comresid", "套卡/充值卡号码"));
		setCols.add(new ColumnSet("createtime", "订单完成时间"));
		return setCols;
	}//getsetCols

	/**
	 * 提取商品类型
	 * @return
	 */
	public Map getDictItem() {
		Map t = new LinkedHashMap();
		t.put("", "请选择");
		t.putAll(dictItem);
		return t;
	}

}
