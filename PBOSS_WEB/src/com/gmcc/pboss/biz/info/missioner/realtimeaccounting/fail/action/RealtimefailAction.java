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
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С  
		
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
	 * ��ñ�ͷ
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();	
		//s.oprcode,s.wayid,s.mobile,o.name,s.opnid,s.oprtime
		setCols.add(new ColumnSet("oprcode", "�Ƽ�����"));
		setCols.add(new ColumnSet("wayid", "��������"));
		setCols.add(new ColumnSet("mobile", "���Ƽ�����"));
		setCols.add(new ColumnSet("opnname", "�Ƽ�ҵ������"));
		setCols.add(new ColumnSet("opnid", "ҵ��Ƴ����"));
		setCols.add(new ColumnSet("oprtime", "ҵ���Ƽ�����ʱ��"));
		return setCols;
	}
	/**
	 * ����ҳ����ʾ��Ч��
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
