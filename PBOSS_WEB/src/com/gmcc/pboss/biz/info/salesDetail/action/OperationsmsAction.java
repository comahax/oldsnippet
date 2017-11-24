package com.gmcc.pboss.biz.info.salesDetail.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.salesDetail.model.ChPwOperationsms;
import com.gmcc.pboss.biz.info.salesDetail.model.OperationInfo;
import com.gmcc.pboss.biz.info.salesDetail.service.OperationsmsService;
import com.gmcc.pboss.biz.info.salesDetail.support.OperationsmsParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class OperationsmsAction extends AbstractAction {

	//ҵ���������
	private short opntype;
	public short getOpntype() {
		return opntype;
	}
	public void setOpntype(short opntype) {
		this.opntype = opntype;
	}
	//ҵ�����
	private String opnid;
	public String getOpnid() {
		return opnid;
	}
	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}
	//ҵ������
	private String opnname;
	public String getOpnname() {
		return opnname;
	}
	public void setOpnname(String opnname) {
		this.opnname = opnname;
	}
	// ��ȡҵ����������
	private OperationsmsService operationsmsService;
	public void setOperationsmsService(OperationsmsService operationsmsService){
		this.operationsmsService = operationsmsService;
	}
	public OperationsmsService getOperationsmsService(){
		return this.operationsmsService;
	}
	
	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		return null;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ��ȡҵ���������ƣ����ڵ���������ʾ
	 */
	public String doOpnSelect(){
		return SUCCESS;
	}
	public String doOpnAjax(){
		LoginMember logMem = this.getLogMember();
		QueryParameter param = this.getOpnParameter();
		ServiceResult result = this.operationsmsService.transact(logMem, param, ServiceType.QUERY);
		List rtnList = result.getRetResult().getData();
		if(rtnList.size()>0){
			List reversedList = this.resultReverse(rtnList);
			result.setRetResult(new QueryResult(result.getRetResult().getPage(), reversedList));
		}
		this.writeJSONServicePage(result, getsetColsOpn());		
		return null;
	}
	private List resultReverse(List list){
		Iterator iter = list.iterator();
		List result = new ArrayList<OperationInfo>();
		while(iter.hasNext()){
			ChPwOperationsms item = (ChPwOperationsms)iter.next();
			OperationInfo o = new OperationInfo(item);
			result.add(o);
		}
		return result;
	}
	public QueryParameter getOpnParameter(){
		OperationsmsParameter parameter = new OperationsmsParameter();
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С  
		
		LoginMember logMem = this.getMember();
		parameter.setCityid(logMem.getCityid());
		if(this.getOpntype()!=0){
			parameter.setOpntype(this.getOpntype());
		}
		if(StringUtils.isNotEmpty(this.getOpnid())){
			parameter.setOpnid(this.getOpnid());
		}
		if(StringUtils.isNotEmpty(this.getOpnname())){
			parameter.setOpnname(this.getOpnname());
		}
		return parameter;
	}
	/**
	 * ��ñ�ͷ--ҵ������б�
	 * @return
	 */
	public List<ColumnSet> getsetColsOpn() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("opnid", "ҵ�����"));
		setCols.add(new ColumnSet("opnname", "ҵ������"));
		//setCols.add(new ColumnSet("oper", "����",true));
		return setCols;
	}
	 /**
	 * ����ҳ����ʾ��Ч��--ҵ������б�
	 * @return the colSet
	 */
	public String getShowColsOpn() {
		return JSONArray.fromObject(getsetColsOpn()).toString();
	}

}
