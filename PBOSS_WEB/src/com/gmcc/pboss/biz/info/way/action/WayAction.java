package com.gmcc.pboss.biz.info.way.action;

import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.biz.info.way.service.WayService;
import com.gmcc.pboss.biz.info.way.support.WayQueryParameter;
import com.gmcc.pboss.biz.info.way.support.WaySingle;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;

public class WayAction extends AbstractAction {

	private WayQueryParameter parameter;
	private WayService service;
	
	public QueryParameter getParameter() {
		parameter = parameter == null ? new WayQueryParameter() : parameter;
		
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
		LoginMember member = getMember();

		parameter.setUpperwayid(member.getWayid());
		parameter.setCityid(member.getCityid());
		parameter.setWaymagcode(member.getEmployeeid());

		return parameter;
	}
	
	public void prepare() throws Exception {
	}
	
	/*
	 * 网点明细
	 */
	public String doQuery() {

		LoginMember member = getMember();
		ServiceResult result = this.getService().transact(member, this.getParameter(), ServiceType.QUERY);

		// 回写JSON
		if (result.isSuccess()) {
			if (result.getRetResult().getData().size() == 0) {
				WaySingle way = new WaySingle("","空值");
				ArrayList<WaySingle> list = new ArrayList<WaySingle>();
				list.add(way);
				result.getRetResult().setData(list);
			}
		}
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}

	public String doList() {
		this.setTitle(PageLoction.RegactInfoQuery);
		return super.doList();
	}
	
	public List getsetCols() {

		List setCols = new ArrayList();
		setCols.add(new ColumnSet("wayid", "网点编码"));
		setCols.add(new ColumnSet("wayname", "网点名称"));
		return setCols;
	}

	public WayService getService() {
		return service;
	}

	public void setService(WayService service) {
		this.service = service;
	}
	
}
