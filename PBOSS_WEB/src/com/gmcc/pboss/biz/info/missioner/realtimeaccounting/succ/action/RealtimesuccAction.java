package com.gmcc.pboss.biz.info.missioner.realtimeaccounting.succ.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.missioner.realtimeaccounting.succ.service.RealtimesuccService;
import com.gmcc.pboss.biz.info.missioner.realtimeaccounting.succ.support.RealtimesuccQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;

public class RealtimesuccAction extends AbstractAction {
	
	private RealtimesuccService realtimesuccService;
	private RealtimesuccQueryParameter parameter;
	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter==null?new RealtimesuccQueryParameter():parameter;
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小  
		
		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	
	public String doList(){
		this.setTitle(PageLoction.RealTimeAccountingSucc);
		return "list";
	}
	
	public String doAjax(){
		ServiceResult result = isLogin();
		if(result.isSuccess()){
			result = this.realtimesuccService.transact(getMember(), getParameter(), ServiceType.QUERY);
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
	
	public void setRealtimesuccService(RealtimesuccService realtimesuccService) {
		this.realtimesuccService = realtimesuccService;
	}
}
