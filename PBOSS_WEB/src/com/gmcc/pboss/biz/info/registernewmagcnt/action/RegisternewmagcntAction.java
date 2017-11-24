package com.gmcc.pboss.biz.info.registernewmagcnt.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.registernewmagcnt.service.RegisternewService;
import com.gmcc.pboss.biz.info.registernewmagcnt.service.RegisternewmagcntService;
import com.gmcc.pboss.biz.info.registernewmagcnt.support.RegisternewmagcntQueryParameter;
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

public class RegisternewmagcntAction extends AbstractAction {

	private RegisternewmagcntQueryParameter parameter;
	private RegisternewmagcntService service;
	private RegisternewService registernewServie;
	// ȡ�û���ҳ�洫�ݵĲ���
	private String _se_startoprtime;
	private String _se_endoprtime;
	private String _se_brand;
	private String _se_employeename;
	private String _se_officetel;
	private String _se_opnid;
	
	public QueryParameter getParameter() {
		parameter = parameter == null ? new RegisternewmagcntQueryParameter() : parameter;
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С
		LoginMember member = this.getMember();
		parameter.setCityid(member.getCityid());
		parameter.setWayid(member.getWayid());
		return parameter;
	}
	
	public void prepare() throws Exception {
		
	}

	public RegisternewmagcntService getService() {
		return service;
	}

	public void setService(RegisternewmagcntService service) {
		this.service = service;
	}
	
	public String doList() {
		this.setTitle(PageLoction.RegisternewcntQuery);
		parameter = new RegisternewmagcntQueryParameter();
		// ��ʼ���Ǽ�ʱ��
		Date d = new Date();
		parameter.setEndoprtime(d);
		parameter.setStartoprtime(d);
		LoginMember member = getMember();
		Long isnet = member.getIsnet();
		if (isnet == 1) {
			parameter.setFlg("show");
		} else {
			parameter.setFlg("unshow");
			parameter.setEmployeename(member.getEmployeename());
		}
		
		return super.doList();
	}
	
	public String doShow() {
		this.setTitle(PageLoction.RegisternewcntQuery);
		setDetailParam();
		return super.doList();
	}
	
	/**
	 * Ʒ����Ϣ����
	 * @return
	 */
	public Map getBrandType(){
		Map t = new LinkedHashMap();
		t.put("", "��ѡ��");
		Map brandType = Constant.getConstantsMap(CodeReverseKey.SIMBRAND);
		t.putAll(brandType);
		return t;
	}
	
	/**
	 * ȡ�û���ҳ�洫�����Ĳ������趨������������
	 */
	private void setDetailParam() {
		getParameter();
		if (get_se_employeename() != null) 
			parameter.setEmployeename(get_se_employeename());
		if (get_se_officetel() != null)
			parameter.setOfficetel(get_se_officetel());
		if (get_se_opnid() != null)
			parameter.setOpnid(get_se_opnid());
		if (get_se_startoprtime() != null)
			parameter.setDateFrom(get_se_startoprtime());
		if (get_se_endoprtime() != null)
			parameter.setDateTo(get_se_endoprtime());
		if (get_se_brand() != null)
			parameter.setBrand(get_se_brand());
	}
	
	/*
	 * ��ҵ�����ۻ��ܲ�ѯ(��Ա/����)
	 */
	public String doQuery() {

		LoginMember member = getMember();
		this.getParameter();
		if (member.getIsnet() == 0) {
			parameter.setEmployeename(member.getEmployeename());
		}
		ServiceResult result = this.getService().transact(member, parameter, ServiceType.QUERY);
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	
	/*
	 * 
	 */
	public String getShowStCols() {
		// TODO Auto-generated method stub
		return JSONArray.fromObject(getsetCols1()).toString();
	}
	
	/**
	 * ��ҵ��������ϸ��ѯ(��Ա/����)
	 * @return
	 */
	public String doQuery2(){
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = registernewServie.transact(getMember(), getParameter(), ServiceType.QUERY);
		this.writeJSONServicePage(result, getsetCols1());
		return null;
	}
	
	/**
	 * ��ñ�ͷ
	 * @return
	 */
	public List<ColumnSet> getsetCols1() {
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
		setCols.add(new ColumnSet("oprtime", "�Ǽ���"));
		return setCols;
	}
	
	public String doExportExcel(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL);
		ServiceResult result = this.getService().transact(member, param,ServiceType.QUERY);
		
		if (result.isSuccess() && result.getRetResult() != null
				&& result.getRetResult().getData() != null
				&& result.getRetResult().getData().size() > 0) {
			exportExcel(result.getRetResult().getData());
		}
		return null;
	}
	
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> cols = new ArrayList<ExcelColumn>();
		cols.add(new ExcelColumn("employeename","��Ա����",30));
		cols.add(new ExcelColumn("officetel", "�������",11));
		cols.add(new ExcelColumn("brandName", "Ʒ��",14));
		cols.add(new ExcelColumn("opnid", "ҵ�����",14));
		cols.add(new ExcelColumn("opnname", "ҵ������",30));
		cols.add(new ExcelColumn("cnt", "����",15));
		return cols;
	}
	
	protected String getExcelTitle(){
		return "��ҵ�����ۻ��ܵ�";
	}
	
	public List getsetCols() {

		List setCols = new ArrayList();
		setCols.add(new ColumnSet("employeename", "��Ա����"));
		setCols.add(new ColumnSet("officetel", "�������"));
		setCols.add(new ColumnSet("brand"));
		setCols.add(new ColumnSet("brandName", "Ʒ��"));
		setCols.add(new ColumnSet("opnid","ҵ�����"));
		setCols.add(new ColumnSet("opnname","ҵ������"));
		setCols.add(new ColumnSet("cnt","����"));
		setCols.add(new ColumnSet("oper","����",true));
		return setCols;
	}

	public RegisternewService getRegisternewServie() {
		return registernewServie;
	}

	public void setRegisternewServie(RegisternewService registernewServie) {
		this.registernewServie = registernewServie;
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

	public String get_se_brand() {
		return _se_brand;
	}

	public void set_se_brand(String _se_brand) {
		this._se_brand = _se_brand;
	}

	public String get_se_employeename() {
		return _se_employeename;
	}

	public void set_se_employeename(String _se_employeename) {
		this._se_employeename = _se_employeename;
	}

	public String get_se_officetel() {
		return _se_officetel;
	}

	public void set_se_officetel(String _se_officetel) {
		this._se_officetel = _se_officetel;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public void setParameter(RegisternewmagcntQueryParameter parameter) {
		this.parameter = parameter;
	}
}
