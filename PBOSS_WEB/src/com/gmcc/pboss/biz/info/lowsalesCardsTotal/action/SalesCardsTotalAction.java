package com.gmcc.pboss.biz.info.lowsalesCardsTotal.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.lowsalesCardsTotal.service.MagRegistersimService;
import com.gmcc.pboss.biz.info.lowsalesCardsTotal.service.SalesCardsTotalService;
import com.gmcc.pboss.biz.info.lowsalesCardsTotal.support.SalesCardsTotalQueryParameter;
import com.gmcc.pboss.biz.info.registernewcnt.support.RegisternewcntQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
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

public class SalesCardsTotalAction extends AbstractAction {

	private SalesCardsTotalQueryParameter parameter ;
	
	private SalesCardsTotalService service;
	
	public QueryParameter getParameter() {
		parameter = parameter == null ? new SalesCardsTotalQueryParameter() : parameter;
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С

		LoginMember logMem = this.getMember();
		parameter.setWayid(logMem.getWayid());
		parameter.setCountyid(logMem.getChannel().getCountyid());
		parameter.setSvccode(logMem.getChannel().getSvccode());
		parameter.setCityid(logMem.getCityid());
		if(logMem.getIsnet()==0){//��Աʱ
			parameter.setOprcode(logMem.getEmployeeid());
		}

		//����ʱ�Ƿ�Ҫ��Ӳ�ѯ����
		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public String doList() {

		this.setTitle(PageLoction.SalesCardsTotalQuery);
		parameter = new SalesCardsTotalQueryParameter();
		// ��ʼ���Ǽ�ʱ��
		Date d = new Date();
		parameter.setEndoprtime(d);
		parameter.setStartoprtime(d);
		return super.doList();
	}
	
	/*
	 * ��ҵ�����ۻ��ܲ�ѯ
	 */
	public String doQuery() {

		LoginMember member = getMember();
		ServiceResult result = this.getService().transact(member, this.getParameter(), ServiceType.QUERY);

		// ��дJSON
		this.writeJSONServicePage(result, getsetCols());

		return null;
		
//		return SUCCESS;
		
	}
	
	public List getsetCols() {

		List setCols = new ArrayList();
		setCols.add(new ColumnSet("employeename", "��Ա����"));
		setCols.add(new ColumnSet("employeeid"));//���ش��ݲ���,ͨ��employeeid����ѯ��ϸ
		setCols.add(new ColumnSet("officetel", "�����ֻ�����"));
//		setCols.add(new ColumnSet("brand", "Ʒ��"));
		setCols.add(new ColumnSet("brandName", "Ʒ��"));
		setCols.add(new ColumnSet("brand"));//���ش��ݲ���
		//setCols.add(new ColumnSet("opnid", "ҵ�����"));
		//setCols.add(new ColumnSet("opnname", "ҵ������"));
		setCols.add(new ColumnSet("total", "����"));
		setCols.add(new ColumnSet("commond", "����"));
		return setCols;
	}

	public SalesCardsTotalService getService() {
		return service;
	}

	public void setService(SalesCardsTotalService service) {
		this.service = service;
	}

	public void setParameter(SalesCardsTotalQueryParameter parameter) {
		this.parameter = parameter;
	}
	
	/**
	 * ����Excel
	 */
	public String doExportExcel(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL);
		ServiceResult result = this.getService().transact(member, param, ServiceType.QUERY);
		if (result.isSuccess() && result.getRetResult() != null && result.getRetResult().getData() != null && result.getRetResult().getData().size() > 0) {
			this.exportExcel(result.getRetResult().getData());
		}
		return null;
	}
	
	
	protected String getExcelTitle(){
		return "�׿����ۻ���";
	}
	
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> cols = new ArrayList<ExcelColumn>();
		cols.add(new ExcelColumn("employeename", "��Ա����",10));
		cols.add(new ExcelColumn("officetel", "�����ֻ�����",10));
		cols.add(new ExcelColumn("brandName", "Ʒ��",10));
		//cols.add(new ExcelColumn("opnid", "ҵ�����",10));
		//cols.add(new ExcelColumn("opnname", "ҵ������",10));
		cols.add(new ExcelColumn("total", "����",10));
		return cols;
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
	
	public String doShow() {
		this.setTitle(PageLoction.SalesCardsTotalQuery);
		setDetailParam();
		return super.doList();
	}
	
	private void setDetailParam() {
		getParameter();
		LoginMember logMem = this.getMember();
//		parameter.setWayid(logMem.getWayid());
//		parameter.setCountyid(logMem.getChannel().getCountyid());
//		//cityid,����sms���е�����
//		parameter.setCityid(logMem.getCityid());
		if (get_se_startoprtime() != null)
			parameter.setStartoprtimes(get_se_startoprtime());
		if (get_se_endoprtime() != null)
			parameter.setEndoprtimes(get_se_endoprtime());
		if(get_se_startactivedate()!= null)
			parameter.setStartactivedates(get_se_startactivedate());
		if(get_se_endactivedate()!= null)
			parameter.setEndactivedates(get_se_endactivedate());
//		if (get_se_svccode() != null)
//			parameter.setSvccode(get_se_svccode());
		if (get_se_brand() != null)
			parameter.setBranddtl(get_se_brand());
		if (get_se_officetel() != null)
			parameter.setOfficetel(get_se_officetel());
		if (get_se_employeeid() != null)
			parameter.setEmployeeid(get_se_employeeid());
	}
	private MagRegistersimService detailservice;
	public String doQuery2(){
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = detailservice.transact(getMember(), getParameter(), ServiceType.QUERY);
		this.writeJSONServicePage(result, getsetCols1());
		return null;
	}
	
	public String getShowStCols() {
		// TODO Auto-generated method stub
		return JSONArray.fromObject(getsetCols1()).toString();
	}
	
	/**
	 * ��ʾ��ϸ�ı�ͷ
	 * ��ñ�ͷ
	 * @return
	 */
	public List<ColumnSet> getsetCols1() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("wayid", "�������"));
		setCols.add(new ColumnSet("wayname", "��������"));
//		setCols.add(new ColumnSet("countyid", "�ֹ�˾"));
		setCols.add(new ColumnSet("strcountyid", "�ֹ�˾"));
//		setCols.add(new ColumnSet("starlevel", "�Ǽ�"));
		setCols.add(new ColumnSet("strstarlevel", "�Ǽ�"));
		setCols.add(new ColumnSet("employeename", "��Ա"));
		setCols.add(new ColumnSet("officetel", "�����ֻ�����"));
		setCols.add(new ColumnSet("mobile", "�׿�����"));//�׿�����
//		setCols.add(new ColumnSet("brand", "Ʒ��"));
		setCols.add(new ColumnSet("brandName", "Ʒ��"));
		setCols.add(new ColumnSet("comname", "��Ʒ��"));
		setCols.add(new ColumnSet("comtype", "��Ʒ����"));
		setCols.add(new ColumnSet("comclassid", "��Ʒ���"));
		setCols.add(new ColumnSet("comprice", "��Ʒ�۸�(Ԫ)"));
		setCols.add(new ColumnSet("flag", "���Ǳ�ʶ"));
		setCols.add(new ColumnSet("oprtime", "�Ǽ�ʱ��"));
		setCols.add(new ColumnSet("activedate", "����ʱ��"));
		//setCols.add(new ColumnSet("oper", "����",true));
		return setCols;
	}

	//ȡ�û���ҳ�洫�ݵĲ���
	private String _se_wayid;
	private String _se_countyid;
//	private String _se_starlevel;
	private String _se_startoprtime;
	private String _se_endoprtime;
	private String _se_startactivedate;
	private String _se_endactivedate;
	private String _se_svccode;
	private String _se_brand;
	private String _se_opnid;
	private String _se_officetel;
	private String _se_employeename;
	private String _se_employeeid;

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_se_countyid() {
		return _se_countyid;
	}

	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}

	public String get_se_startoprtime() {
		return _se_startoprtime;
	}

	public void set_se_startoprtime(String _se_startoprtime) {
		this._se_startoprtime = _se_startoprtime;
	}

	public String get_se_endoprtime() {
		return _se_endoprtime;
	}

	public void set_se_endoprtime(String _se_endoprtime) {
		this._se_endoprtime = _se_endoprtime;
	}

	public String get_se_startactivedate() {
		return _se_startactivedate;
	}

	public void set_se_startactivedate(String _se_startactivedate) {
		this._se_startactivedate = _se_startactivedate;
	}

	public String get_se_endactivedate() {
		return _se_endactivedate;
	}

	public void set_se_endactivedate(String _se_endactivedate) {
		this._se_endactivedate = _se_endactivedate;
	}

	public String get_se_svccode() {
		return _se_svccode;
	}

	public void set_se_svccode(String _se_svccode) {
		this._se_svccode = _se_svccode;
	}

	public String get_se_brand() {
		return _se_brand;
	}

	public void set_se_brand(String _se_brand) {
		this._se_brand = _se_brand;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_se_officetel() {
		return _se_officetel;
	}

	public void set_se_officetel(String _se_officetel) {
		this._se_officetel = _se_officetel;
	}

	public String get_se_employeename() {
		return _se_employeename;
	}

	public void set_se_employeename(String _se_employeename) {
		this._se_employeename = _se_employeename;
	}

	public MagRegistersimService getDetailservice() {
		return detailservice;
	}

	public void setDetailservice(MagRegistersimService detailservice) {
		this.detailservice = detailservice;
	}

	public String get_se_employeeid() {
		return _se_employeeid;
	}

	public void set_se_employeeid(String _se_employeeid) {
		this._se_employeeid = _se_employeeid;
	}
	
	
	
}
