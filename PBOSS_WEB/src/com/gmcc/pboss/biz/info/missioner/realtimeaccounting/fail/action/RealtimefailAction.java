package com.gmcc.pboss.biz.info.missioner.realtimeaccounting.fail.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.missioner.realtimeaccounting.fail.service.RealtimefailService;
import com.gmcc.pboss.biz.info.missioner.realtimeaccounting.fail.support.RealtimefailQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;

public class RealtimefailAction extends AbstractAction {
	
	private RealtimefailService realtimefailService;
	private RealtimefailQueryParameter parameter;
	

	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter==null?new RealtimefailQueryParameter():parameter;
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小  
		
		return parameter;
	}
	
	public String doList(){
		this.setTitle(PageLoction.RealTimeAccountingFail);
		return "list";
	}
	
	public String doAjax(){
		ServiceResult result = isLogin();
		if(result.isSuccess()){
			result = this.realtimefailService.transact(getMember(), getParameter(), ServiceType.QUERY);
		}
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	
	/**
	 * 获得表头
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();	
		//s.oprcode,s.wayid,s.mobile,o.name,s.opnid,s.oprtime
		setCols.add(new ColumnSet("oprcode", "推荐号码"));
		setCols.add(new ColumnSet("wayid", "渠道编码"));
		setCols.add(new ColumnSet("mobile", "被推荐号码"));
		setCols.add(new ColumnSet("opnname", "推荐业务名称"));
		setCols.add(new ColumnSet("opnid", "业务计酬代码"));
		setCols.add(new ColumnSet("oprtime", "业务推荐办理时间"));
		return setCols;
	}
	/**
	 * 返回页面显示的效果
	 * @return the colSet
	 */
	public String getShowCols(){
		return JSONArray.fromObject(getsetCols()).toString();
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

	public void setRealtimefailService(RealtimefailService realtimefailService) {
		this.realtimefailService = realtimefailService;
	}
}
