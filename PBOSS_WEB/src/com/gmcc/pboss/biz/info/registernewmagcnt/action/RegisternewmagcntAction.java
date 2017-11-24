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
	// 取得汇总页面传递的参数
	private String _se_startoprtime;
	private String _se_endoprtime;
	private String _se_brand;
	private String _se_employeename;
	private String _se_officetel;
	private String _se_opnid;
	
	public QueryParameter getParameter() {
		parameter = parameter == null ? new RegisternewmagcntQueryParameter() : parameter;
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
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
		// 初始化登记时间
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
	 * 品牌信息加载
	 * @return
	 */
	public Map getBrandType(){
		Map t = new LinkedHashMap();
		t.put("", "请选择");
		Map brandType = Constant.getConstantsMap(CodeReverseKey.SIMBRAND);
		t.putAll(brandType);
		return t;
	}
	
	/**
	 * 取得汇总页面传过来的参数并设定到参数对象中
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
	 * 新业务销售汇总查询(店员/店主)
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
	 * 新业务销售明细查询(店员/店主)
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
	 * 获得表头
	 * @return
	 */
	public List<ColumnSet> getsetCols1() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("wayid", "网点编码"));
		setCols.add(new ColumnSet("wayname", "网点名称"));
		setCols.add(new ColumnSet("strcountyid", "分公司"));
		setCols.add(new ColumnSet("strstarlevel", "星级"));
		setCols.add(new ColumnSet("employeename", "店员"));
		setCols.add(new ColumnSet("officetel", "捆绑手机号码"));
		setCols.add(new ColumnSet("mobile", "用户号码"));
		setCols.add(new ColumnSet("brandName", "品牌"));
		setCols.add(new ColumnSet("opnid", "业务编码"));
		setCols.add(new ColumnSet("opnname", "业务名称"));
		setCols.add(new ColumnSet("oprtime", "登记日"));
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
		cols.add(new ExcelColumn("employeename","店员姓名",30));
		cols.add(new ExcelColumn("officetel", "捆绑号码",11));
		cols.add(new ExcelColumn("brandName", "品牌",14));
		cols.add(new ExcelColumn("opnid", "业务编码",14));
		cols.add(new ExcelColumn("opnname", "业务名称",30));
		cols.add(new ExcelColumn("cnt", "数量",15));
		return cols;
	}
	
	protected String getExcelTitle(){
		return "新业务销售汇总单";
	}
	
	public List getsetCols() {

		List setCols = new ArrayList();
		setCols.add(new ColumnSet("employeename", "店员姓名"));
		setCols.add(new ColumnSet("officetel", "捆绑号码"));
		setCols.add(new ColumnSet("brand"));
		setCols.add(new ColumnSet("brandName", "品牌"));
		setCols.add(new ColumnSet("opnid","业务编码"));
		setCols.add(new ColumnSet("opnname","业务名称"));
		setCols.add(new ColumnSet("cnt","数量"));
		setCols.add(new ColumnSet("oper","操作",true));
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
