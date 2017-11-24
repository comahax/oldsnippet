package com.gmcc.pboss.biz.info.registernewcnt.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.registernewcnt.service.RegisternewcntService;
import com.gmcc.pboss.biz.info.registernewcnt.support.RegisternewcntQueryParameter;
import com.gmcc.pboss.biz.info.registernewcnt.service.RegisternewService;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.constant.service.ConstantService;
import com.gmcc.pboss.common.dictionary.CodeReverseKey;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.ExcelColumn;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.model.constant.ChPwCntycompany;

public class RegisternewcntAction extends AbstractAction {

	private RegisternewcntQueryParameter parameter;
	private RegisternewcntService service;
	private RegisternewService registernewServie;
	// ȡ�û���ҳ�洫�ݵĲ���
	private String _se_wayid;
	private String _se_countyid;
	private String _se_starlevel;
	private String _se_startoprtime;
	private String _se_endoprtime;
	private String _se_svccode;
	private String _se_brand;
	private Map conItem; // �ֹ�˾
	private ConstantService constantService;
	
	public QueryParameter getParameter() {
		parameter = parameter == null ? new RegisternewcntQueryParameter() : parameter;
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С
		LoginMember member = this.getMember();
		parameter.setCityid(member.getCityid());
		parameter.setEmployeeid(member.getEmployeeid());
		return parameter;
	}

	public void prepare() throws Exception {
		
	}

	/**
	 * @return the service
	 */
	public RegisternewcntService getService() {
		return service;
	}

	/**
	 * the service to set
	 * @param service
	 */
	public void setService(RegisternewcntService service) {
		this.service = service;
	}

	public String doList() {
		this.setTitle(PageLoction.MagRegNewSaleStatistics);
		parameter = new RegisternewcntQueryParameter();
		// ��ʼ���Ǽ�ʱ��
		Date d = new Date();
		parameter.setEndoprtime(d);
		parameter.setStartoprtime(d);
		this.setConItem(getCntyComd());
		return super.doList();
	}
	
	public String doShow() {
		this.setTitle(PageLoction.MagRegNewSaleStatistics);
		setDetailParam();
		return super.doList();
	}
	
	/**
	 * �ֹ�˾��Ϣ����
	 * @return
	 */
	public Map<String,String> getCntyComd() {
		//��ȡ��Ȼ��¼�û���Ϣ
		LoginMember member = this.getMember();
		LinkedHashMap<String, String> rtn = new LinkedHashMap<String, String>();
		rtn.put("", "��ѡ��");	
		Map<String, ChPwCntycompany> map = this.constantService.getBranchCntyComps(member.getCityid());		
		//�ֹ�˾��Ϣ������ʱ��ֱ�ӷ���ԭ����MAP
		if (map == null) return rtn;
		//����Map
		Iterator<String> allKey = map.keySet().iterator();
		while (allKey.hasNext()){
			String key = allKey.next();
			ChPwCntycompany value = map.get(key);
			rtn.put(key, value.getCountycompname());
		}
		return rtn;
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
		if (get_se_wayid() != null) 
			parameter.setWayid(get_se_wayid());
		if (get_se_countyid() != null)
			parameter.setCountyid(get_se_countyid());
		if (get_se_starlevel() != null)
			parameter.setStarlevel(get_se_starlevel());
		if (get_se_startoprtime() != null)
			parameter.setDateFrom(get_se_startoprtime());
		if (get_se_endoprtime() != null)
			parameter.setDateTo(get_se_endoprtime());
		if (get_se_svccode() != null)
			parameter.setSvccode(get_se_svccode());
		if (get_se_brand() != null)
			parameter.setBrand(get_se_brand());
	}
	
	/*
	 * ��ҵ�����ۻ��ܲ�ѯ(����)
	 */
	public String doQuery() {

		LoginMember member = getMember();
		ServiceResult result = this.getService().transact(member, getParameter(), ServiceType.QUERY);
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
	 * ��ҵ��������ϸ��ѯ(����)
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
	
	/**
	 * ����EXCEL�ļ�
	 * @return
	 */
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
	
	public List getsetCols() {

		List setCols = new ArrayList();
		setCols.add(new ColumnSet("wayid", "�������"));
		setCols.add(new ColumnSet("wayname", "��������"));
		setCols.add(new ColumnSet("countyid"));
		setCols.add(new ColumnSet("countyName","�ֹ�˾"));
		setCols.add(new ColumnSet("starlevel"));
		setCols.add(new ColumnSet("strstarlevel","�Ǽ�"));
		setCols.add(new ColumnSet("cnt","����"));
		setCols.add(new ColumnSet("oper","����",true));
		return setCols;
	}
	
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> cols = new ArrayList<ExcelColumn>();
		cols.add(new ExcelColumn("wayid","�������",10));
		cols.add(new ExcelColumn("wayname", "��������",30));
		cols.add(new ExcelColumn("countyName", "�ֹ�˾",30));
		cols.add(new ExcelColumn("strstarlevel", "�Ǽ�",14));
		cols.add(new ExcelColumn("cnt", "����",15));
		return cols;
	}
	
	protected String getExcelTitle(){
		return "��ҵ�����ۻ��ܵ�";
	}

	public RegisternewService getRegisternewServie() {
		return registernewServie;
	}

	public void setRegisternewServie(RegisternewService registernewServie) {
		this.registernewServie = registernewServie;
	}

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

	public String get_se_starlevel() {
		return _se_starlevel;
	}

	public void set_se_starlevel(String _se_starlevel) {
		this._se_starlevel = _se_starlevel;
	}

	public String get_se_startoprtime() {
		return _se_startoprtime;
	}

	public void set_se_startoprtime(String _se_startoprtime) {
		this._se_startoprtime = _se_startoprtime;
	}

	public String get_se_svccode() {
		return _se_svccode;
	}

	public void set_se_svccode(String _se_svccode) {
		this._se_svccode = _se_svccode;
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

	public Map getConItem() {
		return conItem;
	}

	public void setConItem(Map conItem) {
		this.conItem = conItem;
	}

	public ConstantService getConstantService() {
		return constantService;
	}

	public void setConstantService(ConstantService constantService) {
		this.constantService = constantService;
	}
}
