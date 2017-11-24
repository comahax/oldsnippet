package com.gmcc.pboss.biz.info.salesCardsTotal.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.regactInfo.service.RegactInfoService;
import com.gmcc.pboss.biz.info.salesCardsTotal.service.MagRegistersimService;
import com.gmcc.pboss.biz.info.salesCardsTotal.service.SalesCardsTotalService;
import com.gmcc.pboss.biz.info.salesCardsTotal.support.SalesCardsTotalQueryParameter;
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

public class SalesCardsTotalAction extends AbstractAction {

	private SalesCardsTotalQueryParameter parameter ;
	
	private SalesCardsTotalService service;
	
	private MagRegistersimService detailservice;
	private Map conItem; // �ֹ�˾
	private ConstantService constantService;
	// ȡ�û���ҳ�洫�ݵĲ���
	private String _se_wayid;
	private String _se_countyid;
	private String _se_starlevel;
	private String _se_startoprtime;
	private String _se_endoprtime;
	private String _se_startactivedate;
	private String _se_endactivedate;
	private String _se_svccode;
	private String _se_brand;
	
	
	
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
	
	private void setDetailParam() {
		getParameter();
		LoginMember logMem = this.getMember();
//		parameter.setWayid(logMem.getWayid());
//		//�ֹ�˾�����۷��������Ǽ�������,�����ٴθ�ֵ
//		parameter.setCountyid(logMem.getChannel().getCountyid());
//		parameter.setSvccode(logMem.getChannel().getSvccode());
		
		//�ֹ�˾�����۷��������Ǽ�������,�����ٴθ�ֵ
//		if("".equals(parameter.getCountyid()))
//			parameter.setCountyid(logMem.getChannel().getCountyid());
//		if("".equals(parameter.getSvccode()))
//			parameter.setSvccode(logMem.getChannel().getSvccode());
		
		//�Ծ���Ĺ�����Ϊ�������������
		parameter.setWaymagcode(logMem.getEmployeeid());
		
		//cityid����,�õ�opnnameʱҪ�õ���
		parameter.setCityid(logMem.getCityid());
		if (get_se_wayid() != null&& !("".equals(get_se_wayid()))) 
			parameter.setWayid(get_se_wayid());
		if (get_se_countyid() != null && !("".equals(get_se_countyid())))
			parameter.setCountyid(get_se_countyid());
		if (get_se_starlevel() != null  && !("".equals(get_se_starlevel())))
			parameter.setStarlevel(get_se_starlevel());
		if (get_se_startoprtime() != null && !("".equals(get_se_startoprtime())))
			parameter.setStartoprtimes(get_se_startoprtime());
		if (get_se_endoprtime() != null && !("".equals(get_se_endoprtime())))
			parameter.setEndoprtimes(get_se_endoprtime());
		if(get_se_startactivedate()!= null&& !("".equals(get_se_startactivedate())))
			parameter.setStartactivedates(get_se_startactivedate());
		if((get_se_endactivedate()!= null) && !("".equals(get_se_endactivedate())))
			parameter.setEndactivedates(get_se_endactivedate());
		if ((get_se_svccode()) != null && !("".equals(get_se_svccode())))
			parameter.setSvccode(get_se_svccode());
		if ((get_se_brand() != null)&& !("".equals(get_se_brand())))
			parameter.setBrand(get_se_brand());
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
	
	@Override
	public QueryParameter getParameter() {
		parameter = parameter == null ? new SalesCardsTotalQueryParameter() : parameter;
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С
		LoginMember member = getMember();

//		parameter.setWayid(member.getWayid());
		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public String doList() {

		this.setTitle(PageLoction.CardsTotalQuery);
		parameter = new SalesCardsTotalQueryParameter();
		// ��ʼ���Ǽ�ʱ��
		Date d = new Date();
		parameter.setEndoprtime(d);
		parameter.setStartoprtime(d);
//		parameter.setStartactivedate(d);
//		parameter.setEndactivedate(d);
		this.setConItem(getCntyComd());
		LoginMember logMem = this.getMember();
//		parameter.setWayid(logMem.getWayid());
		
		//�ֹ�˾�����۷��������Ǽ�������,�����ٴθ�ֵ
//		parameter.setCountyid(logMem.getChannel().getCountyid());
//		parameter.setSvccode(logMem.getChannel().getSvccode());
		
		parameter.setWaymagcode(logMem.getEmployeeid());
		//cityid����
		parameter.setCityid(logMem.getCityid());
		return super.doList();
	}
	
	public String doShow() {
//		this.setTitle(PageLoction.RegisternewcntQuery);
		this.setTitle(PageLoction.CardsTotalQuery);
		setDetailParam();
		return super.doList();
	}
	
	/*
	 * �׿����ۻ��ܲ�ѯ
	 */
	public String doQuery() {

		LoginMember member = getMember();
		this.getParameter();
//		parameter.setWayid(member.getWayid());
		
		//�ֹ�˾�����۷��������Ǽ�������,�����ٴθ�ֵ
//		if("".equals(parameter.getCountyid()))
//			parameter.setCountyid(member.getChannel().getCountyid());
//		if("".equals(parameter.getSvccode()))
//			parameter.setSvccode(member.getChannel().getSvccode());
		
		parameter.setWaymagcode(member.getEmployeeid());
		//cityid����
		parameter.setCityid(member.getCityid());
		ServiceResult result = this.getService().transact(member, this.getParameter(), ServiceType.QUERY);
//		result.getRetResult().getPage().setRows(result.getRetResult().getData().size());
		// ��дJSON
		this.writeJSONServicePage(result, getsetCols());

		return null;
		
//		return SUCCESS;
		
	}
	
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
	 * ������ϸ����ʾ�ı��
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
	
	
	
	public List getsetCols() {

		List setCols = new ArrayList();
		setCols.add(new ColumnSet("wayid", "�������"));
		setCols.add(new ColumnSet("wayname", "��������"));
		setCols.add(new ColumnSet("countyid"));//���ش��ݲ���
		setCols.add(new ColumnSet("strcountyid", "�ֹ�˾"));
		setCols.add(new ColumnSet("strstarlevel", "�Ǽ�"));
		setCols.add(new ColumnSet("total", "����"));
		setCols.add(new ColumnSet("starlevel"));
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
//		QueryParameter param = getParameter();
		parameter.setWaymagcode(member.getEmployeeid());
		//cityid����
		parameter.setCityid(member.getCityid());
		parameter.setAction(QueryAction.ALL);
		ServiceResult result = this.getService().transact(member, getParameter(), ServiceType.QUERY);
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
		cols.add(new ExcelColumn("wayid","�������",10));
		cols.add(new ExcelColumn("wayname", "��������",10));
//		cols.add(new ExcelColumn("countyid", "�ֹ�˾",10));
		cols.add(new ExcelColumn("strcountyid", "�ֹ�˾",10));
		cols.add(new ExcelColumn("strstarlevel", "�Ǽ�",10));
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

	public MagRegistersimService getDetailservice() {
		return detailservice;
	}

	public void setDetailservice(MagRegistersimService detailservice) {
		this.detailservice = detailservice;
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
