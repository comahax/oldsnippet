package com.gmcc.pboss.biz.info.reward.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.biz.info.reward.service.FailService;
import com.gmcc.pboss.biz.info.reward.support.RewardFailQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.ExcelColumn;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class RewardVerifiedAction extends AbstractAction {
	RewardFailQueryParameter parameter;

	private FailService service;
	/**
	 * @param parameter the parameter to set
	 */
	public void setParameter(RewardFailQueryParameter parameter) {
		this.parameter = parameter;
	}
	public QueryParameter getParameter() {
		parameter = parameter == null ? new RewardFailQueryParameter() : parameter;
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С
		
		LoginMember member = getMember();
		parameter.setWayid(member.getWayid());
		return parameter;
	}
	/**
	 * Ajax����
	 */
	public String doQuery() {

		LoginMember member = getMember();
		// ������ѯ
		ServiceResult result = getService().transact(member, getParameter(), ServiceType.QUERY);
		// ��дJSON
		this.writeJSONServicePage(result, getsetCols());

		return null;
	}
	/**
	 * ����ҳ��
	 */
	public String doList() {

		setTitle(PageLoction.RewardVerifiedList);
		return SUCCESS;
	}

	public List getsetCols() {

		List setCols = new ArrayList();
//		setCols.add(new ColumnSet("seq","����"));
		setCols.add(new ColumnSet("rewardtypeName","�������"));
		setCols.add(new ColumnSet("calcmonth","�����·�"));
		setCols.add(new ColumnSet("opnname","ҵ������"));
		setCols.add(new ColumnSet("mobile","ҵ�����ֻ���"));
		setCols.add(new ColumnSet("oprtime","ҵ����ʱ��"));
		setCols.add(new ColumnSet("remark","ʧ��ԭ��"));
		
		return setCols;
	}

	public Map getRewareType(){
		Map rtn = new LinkedHashMap();
		rtn.put("", "��ѡ��");
		Map consMap = Constant.getConstantsMap(ConstantsType.SOCIETY_REWARDVERIFIED_TPYPE);
		if (consMap!=null) rtn.putAll(consMap);
		return rtn;
		
	}
	
	/**
	 * ����Excel
	 */
	public String doExcelExport(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL);
		// ������ѯ
		ServiceResult result = getService().transact(member, param, ServiceType.QUERY);
		if (result.isSuccess() && result.getRetResult() != null && result.getRetResult().getData() != null && result.getRetResult().getData().size() > 0) {
			this.exportExcel(result.getRetResult().getData());
		}		
		return null;
	}
	/**
	 * ���ص���Excel�ļ�������
	 */
	protected String getExcelTitle(){
		String type = ((RewardFailQueryParameter)getParameter()).getType();
		return Constant.getConstantName(ConstantsType.SOCIETY_REWARDVERIFIED_TPYPE,type);
	}
	/**
	 * ���ص���excel���е���Ϣ
	 * @return
	 */
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> cols = new ArrayList<ExcelColumn>();
		cols.add(new ExcelColumn("rewardtypeName","�������",20));
		cols.add(new ExcelColumn("calcmonth","�����·�",8));
		cols.add(new ExcelColumn("opnname","ҵ������",15));
		cols.add(new ExcelColumn("mobile","ҵ�����ֻ���",13));
		cols.add(new ExcelColumn("oprtime","ҵ����ʱ��",13,"yyyy-MM-dd"));
		cols.add(new ExcelColumn("remark","ʧ��ԭ��",50));		
		return cols;
	}
	
	/**
	 * @return the service
	 */
	public FailService getService() {
		return service;
	}
	/**
	 * @param service the service to set
	 */
	public void setService(FailService service) {
		this.service = service;
	}
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
