package com.gmcc.pboss.biz.info.rewardcard.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.biz.info.rewardcard.support.CardrewdetQueryParameter;
import com.gmcc.pboss.biz.info.rewardcard.service.CardrewdetService;

public class CardrewdetAction extends AbstractAction {

	private CardrewdetQueryParameter parameter;
	private CardrewdetService cardrewdetService;
	
	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter==null?new CardrewdetQueryParameter():parameter;
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
		
		parameter.setWayid(this.getLogMember().getWayid());		
		return parameter;
	}
	public void setParameter(CardrewdetQueryParameter param){
		this.parameter = param;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
	}
	
	public String doList(){
		this.setTitle(PageLoction.Cardrewdet);		
		return SUCCESS;
	}
	
	public String doAjax(){
		ServiceResult result = isLogin();
		if(result.isSuccess()){
			result = this.cardrewdetService.transact(getMember(), getParameter(), ServiceType.QUERY);
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
		setCols.add(new ColumnSet("wayid", "网点编码"));
		setCols.add(new ColumnSet("wayname", "网点名称"));
		setCols.add(new ColumnSet("mobile", "号码"));
		setCols.add(new ColumnSet("activetime", "激活时间"));
		setCols.add(new ColumnSet("rechargenum", "充值金额"));
		setCols.add(new ColumnSet("rechargetime", "充值时间"));
		setCols.add(new ColumnSet("rewardnum", "结算金额"));
		setCols.add(new ColumnSet("cmonth", "计酬发生月"));
		//setCols.add(new ColumnSet("oper", "操作",true));
		return setCols;
	}
	 /**
	 * 返回页面显示的效果
	 * @return the colSet
	 */
	public String getShowCols(){
		return JSONArray.fromObject(getsetCols()).toString();
	}
	
	
	public CardrewdetService getCardrewdetService() {
		return cardrewdetService;
	}
	public void setCardrewdetService(CardrewdetService cardrewdetService) {
		this.cardrewdetService = cardrewdetService;
	}		
	

}
