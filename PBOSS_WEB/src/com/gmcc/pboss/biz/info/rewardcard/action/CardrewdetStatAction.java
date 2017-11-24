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
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С
		
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
	 * ��ñ�ͷ
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("wayid", "�������"));
		setCols.add(new ColumnSet("wayname", "��������"));
		setCols.add(new ColumnSet("rewardtype", "�������"));
		setCols.add(new ColumnSet("rechmonth", "��ֵ������"));
		setCols.add(new ColumnSet("activemonth", "�������"));
		setCols.add(new ColumnSet("cmonth", "�Ʒ������"));
		setCols.add(new ColumnSet("sum", "�����"));
		//setCols.add(new ColumnSet("oper", "����",true));
		return setCols;
	}
	/**
	 * ����ҳ����ʾ��Ч��
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
