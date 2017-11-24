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
	// 取得汇总页面传递的参数
	private String _se_wayid;
	private String _se_countyid;
	private String _se_starlevel;
	private String _se_startoprtime;
	private String _se_endoprtime;
	private String _se_svccode;
	private String _se_brand;
	private Map conItem; // 分公司
	private ConstantService constantService;
	
	public QueryParameter getParameter() {
		parameter = parameter == null ? new RegisternewcntQueryParameter() : parameter;
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
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
		// 初始化登记时间
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
	 * 分公司信息加载
	 * @return
	 */
	public Map<String,String> getCntyComd() {
		//提取当然登录用户信息
		LoginMember member = this.getMember();
		LinkedHashMap<String, String> rtn = new LinkedHashMap<String, String>();
		rtn.put("", "请选择");	
		Map<String, ChPwCntycompany> map = this.constantService.getBranchCntyComps(member.getCityid());		
		//分公司信息不存在时，直接返回原来的MAP
		if (map == null) return rtn;
		//遍历Map
		Iterator<String> allKey = map.keySet().iterator();
		while (allKey.hasNext()){
			String key = allKey.next();
			ChPwCntycompany value = map.get(key);
			rtn.put(key, value.getCountycompname());
		}
		return rtn;
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
	 * 新业务销售汇总查询(经理)
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
	 * 新业务销售明细查询(经理)
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
	
	/**
	 * 导出EXCEL文件
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
		setCols.add(new ColumnSet("wayid", "网点编码"));
		setCols.add(new ColumnSet("wayname", "网点名称"));
		setCols.add(new ColumnSet("countyid"));
		setCols.add(new ColumnSet("countyName","分公司"));
		setCols.add(new ColumnSet("starlevel"));
		setCols.add(new ColumnSet("strstarlevel","星级"));
		setCols.add(new ColumnSet("cnt","数量"));
		setCols.add(new ColumnSet("oper","操作",true));
		return setCols;
	}
	
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> cols = new ArrayList<ExcelColumn>();
		cols.add(new ExcelColumn("wayid","网点编码",10));
		cols.add(new ExcelColumn("wayname", "网点名称",30));
		cols.add(new ExcelColumn("countyName", "分公司",30));
		cols.add(new ExcelColumn("strstarlevel", "星级",14));
		cols.add(new ExcelColumn("cnt", "数量",15));
		return cols;
	}
	
	protected String getExcelTitle(){
		return "新业务销售汇总单";
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
