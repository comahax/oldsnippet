package com.gmcc.pboss.biz.info.salesDetail.action;

import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;

import net.sf.json.JSONArray;

import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.BaseModel;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.CodeReverseKey;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.ExcelColumn;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.manager.model.WayReversed;
import com.gmcc.pboss.biz.info.node.model.Way;
import com.gmcc.pboss.biz.info.salesDetail.service.RegisternewService;
import com.gmcc.pboss.biz.info.salesDetail.support.RegisternewQueryParameter;
import com.gmcc.pboss.biz.info.salesDetail.service.OperationsmsService;
import com.gmcc.pboss.biz.info.salesDetail.support.OperationsmsParameter;
import com.gmcc.pboss.biz.info.salesDetail.model.ChPwOperationsms;
import com.gmcc.pboss.biz.info.salesDetail.model.OperationInfo;;

public class RegisternewAction extends AbstractAction {

	/*
	 * ��ȡ��ѯ����
	 */
	//��Ա����-����
	private String oprcode;
	public void setOprcode(String oprcode){
		this.oprcode = oprcode;
	}
	public String getOprcode(){
		return this.oprcode;
	}
	//ҵ�����
	private String opnid;
	public void setOpnid(String opnid){
		this.opnid = opnid;
	}
	public String getOpnid(){
		return this.opnid;
	}
	//Ʒ��
	private String brand;
	public void setBrand(String b){
		this.brand = b;
	}
	public String getBrand(){
		return this.brand;
	}
	//��ʼʱ��
	private Date timeFrom;
	public void setTimeFrom(Date timeFrom){
		this.timeFrom = timeFrom;
	}
	public Date getTimeFrom(){
		return this.timeFrom;
	}
	//����ʱ��
	private Date timeTo;
	public void setTimeTo(Date timeTo){
		this.timeTo = timeTo;
	}
	public Date getTimeTo(){			
		return this.timeTo;
	}
	
	/*
	 * ��ҵ��������Ϣ��ѯservice
	 */
	private RegisternewService registernewServie;
	public void setRegisternewService(RegisternewService registernewServie){
		this.registernewServie = registernewServie;
	}
	public RegisternewService getRegisternewService(){
		return this.registernewServie;
	}
	// ��ȡҵ����������
	private OperationsmsService operationsmsService;
	public void setOperationsmsService(OperationsmsService operationsmsService){
		this.operationsmsService = operationsmsService;
	}
	public OperationsmsService getOperationsmsService(){
		return this.operationsmsService;
	}
	
	/*
	 *������ҵ��������Ϣ��ѯ�б�
	 */
	public String doList(){
		this.setTitle(PageLoction.NEW_BUSI_SALE_DETAIL_QUERY);
		return SUCCESS;
	}
	
	public String doAjax(){
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = registernewServie.transact(getMember(), getParameter(), ServiceType.QUERY);
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	
	
	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		RegisternewQueryParameter parameter = new RegisternewQueryParameter();
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С  
		
		LoginMember logMem = this.getMember();
		parameter.setCityid(logMem.getCityid());
		parameter.setWayid(logMem.getWayid());
		if(logMem.getIsnet()==0){
			parameter.setOprcode(logMem.getEmployeeid());
		}
		else{
			if (this.getOprcode()!=null){
				parameter.setOprcode(this.getOprcode());
			}
		}
		
		parameter.setCountyid(logMem.getChannel().getCountyid());
		parameter.setSvccode(logMem.getChannel().getSvccode());
		if(this.getOpnid()!=null)
			parameter.setOpnid(this.getOpnid());
		if(this.getBrand()!=null)
			parameter.setBrand(this.getBrand());
		if(this.getTimeFrom()!=null){
			parameter.setStartDate(this.getTimeFrom());
		}
		if(this.getTimeTo()!=null){
			parameter.setEndDate(this.getTimeTo());
		}
		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		//Date d = new Date();
		//this.setTimeFrom(d);
		//this.setTimeTo(DateUtils.addDays(d, 3));
	}
	
	/**
	 * ����Excel
	 */
	public String doExportExcel(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL);
		ServiceResult result = registernewServie.transact(member, param, ServiceType.QUERY);
		if (result.isSuccess() && result.getRetResult() != null && result.getRetResult().getData() != null && result.getRetResult().getData().size() > 0) {
			int size = result.getRetResult().getData().size();
			if( size>0 && size<=65536 )//�����������ݲ��ܳ���65536�У�����Excel2003��֧��
				this.exportExcel(result.getRetResult().getData());
		}
		return null;
	}
	/**
	 * ���ص���Excel�ļ�������
	 */
	protected String getExcelTitle(){
		return "��ҵ��������ϸ�嵥";
	}
	/**
	 * ���ص���excel���е���Ϣ
	 * @return
	 */
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> cols = new ArrayList<ExcelColumn>();
		cols.add(new ExcelColumn("wayid","�������",10));
		cols.add(new ExcelColumn("wayname", "��������",15));
		cols.add(new ExcelColumn("strcountyid", "�ֹ�˾",15));
		cols.add(new ExcelColumn("strstarlevel", "�Ǽ�",15));
		cols.add(new ExcelColumn("employeename", "��Ա",15));
		cols.add(new ExcelColumn("officetel", "�����ֻ�����",15));
		cols.add(new ExcelColumn("mobile", "�û�����",15));
		cols.add(new ExcelColumn("brandName", "Ʒ��",10));
		cols.add(new ExcelColumn("opnid", "ҵ�����",10));
		cols.add(new ExcelColumn("opnname", "ҵ������",15));
		cols.add(new ExcelColumn("oprtime", "�Ǽ�ʱ��",15,"yyyy-MM-dd HH:mm"));
		return cols;
	}
	/**
	 * ����txt
	 */
	public String doExportTxt(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL );
		ServiceResult result = registernewServie.transact(member, param, ServiceType.QUERY);
		if (result.isSuccess() && result.getRetResult() != null && result.getRetResult().getData() != null && result.getRetResult().getData().size() > 0) {
			this.exportTxt(result.getRetResult().getData());
		}
		return null;
	}
	
	/**
	 * ��ñ�ͷ
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("wayid", "�������"));
		setCols.add(new ColumnSet("wayname", "��������"));
		setCols.add(new ColumnSet("strcountyid", "�ֹ�˾"));
		setCols.add(new ColumnSet("strstarlevel", "�Ǽ�"));
		setCols.add(new ColumnSet("employeename", "��Ա"));
		setCols.add(new ColumnSet("officetel", "�����ֻ�����"));
		setCols.add(new ColumnSet("mobile", "�û�����"));
		setCols.add(new ColumnSet("brandName", "Ʒ��"));
		setCols.add(new ColumnSet("opnid", "ҵ�����"));
		setCols.add(new ColumnSet("opnname", "ҵ������"));
		setCols.add(new ColumnSet("oprtime", "�Ǽ�ʱ��"));
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
	
	/**
	 * ��ȡƷ������
	 */
	public Map getBrandType(){
		Map t = new LinkedHashMap();
		t.put("", "��ѡ��");
		Map brandType = Constant.getConstantsMap(CodeReverseKey.SIMBRAND);
		t.putAll(brandType);
		return t;
	}
	/**
	 * ��ȡҵ�����������б�
	 */
	public Map getOpnInfo(){
		Map t = new LinkedHashMap();
		t.put("", "��ѡ��");
		Map result = this.operationsmsService.getOpnInfo(getMember().getCityid());
		t.putAll(result);
		return t;
	}
	//�ֹ�˾
	public String getStrCountyid(){
		String countyid = this.getMember().getChannel().getCountyid();
		String strCountyid = Constant.getCountyidchName(countyid);
		return strCountyid;
	}
}
