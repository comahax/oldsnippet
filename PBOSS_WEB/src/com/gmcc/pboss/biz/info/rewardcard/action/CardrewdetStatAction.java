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
import com.gmcc.pboss.biz.info.rewardcard.service.CardrewdetService;
import com.gmcc.pboss.biz.info.rewardcard.support.CardrewdetStatParameter;

public class CardrewdetStatAction extends AbstractAction {
	private CardrewdetStatParameter parameter;
	private CardrewdetService cardrewdetService;
	
	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter==null?new CardrewdetStatParameter():parameter;
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
		
		parameter.setWayid(this.getLogMember().getWayid());	
		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	
	public String doList(){
		this.setTitle(PageLoction.CardrewdetStat);
		return SUCCESS;
	}	
	
	/**
	 * 获得表头
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("wayid", "网点编码"));
		setCols.add(new ColumnSet("wayname", "网点名称"));
		setCols.add(new ColumnSet("rewardtype", "酬金类型"));
		setCols.add(new ColumnSet("rechmonth", "充值发生月"));
		setCols.add(new ColumnSet("activemonth", "激活发生月"));
		setCols.add(new ColumnSet("cmonth", "计发酬金月"));
		setCols.add(new ColumnSet("sum", "酬金金额"));
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
	
	public String doAjax(){
		ServiceResult result = isLogin();
		if(result.isSuccess()){
			result = this.cardrewdetService.transact(getMember(), getParameter(), ServiceType.OTHER);
		}
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	
	public CardrewdetService getCardrewdetService() {
		return cardrewdetService;
	}
	public void setCardrewdetService(CardrewdetService cardrewdetService) {
		this.cardrewdetService = cardrewdetService;
	}	

}
