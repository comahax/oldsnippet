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
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小

		LoginMember logMem = this.getMember();
		parameter.setWayid(logMem.getWayid());
		parameter.setCountyid(logMem.getChannel().getCountyid());
		parameter.setSvccode(logMem.getChannel().getSvccode());
		parameter.setCityid(logMem.getCityid());
		if(logMem.getIsnet()==0){//店员时
			parameter.setOprcode(logMem.getEmployeeid());
		}

		//进来时是否要添加查询条件
		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public String doList() {

		this.setTitle(PageLoction.SalesCardsTotalQuery);
		parameter = new SalesCardsTotalQueryParameter();
		// 初始化登记时间
		Date d = new Date();
		parameter.setEndoprtime(d);
		parameter.setStartoprtime(d);
		return super.doList();
	}
	
	/*
	 * 新业务销售汇总查询
	 */
	public String doQuery() {

		LoginMember member = getMember();
		ServiceResult result = this.getService().transact(member, this.getParameter(), ServiceType.QUERY);

		// 回写JSON
		this.writeJSONServicePage(result, getsetCols());

		return null;
		
//		return SUCCESS;
		
	}
	
	public List getsetCols() {

		List setCols = new ArrayList();
		setCols.add(new ColumnSet("employeename", "店员姓名"));
		setCols.add(new ColumnSet("employeeid"));//隐藏传递参数,通过employeeid来查询明细
		setCols.add(new ColumnSet("officetel", "捆绑手机号码"));
//		setCols.add(new ColumnSet("brand", "品牌"));
		setCols.add(new ColumnSet("brandName", "品牌"));
		setCols.add(new ColumnSet("brand"));//隐藏传递参数
		//setCols.add(new ColumnSet("opnid", "业务编码"));
		//setCols.add(new ColumnSet("opnname", "业务名称"));
		setCols.add(new ColumnSet("total", "数量"));
		setCols.add(new ColumnSet("commond", "操作"));
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
	 * 导出Excel
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
		return "套卡销售汇总";
	}
	
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> cols = new ArrayList<ExcelColumn>();
		cols.add(new ExcelColumn("employeename", "店员姓名",10));
		cols.add(new ExcelColumn("officetel", "捆绑手机号码",10));
		cols.add(new ExcelColumn("brandName", "品牌",10));
		//cols.add(new ExcelColumn("opnid", "业务编码",10));
		//cols.add(new ExcelColumn("opnname", "业务名称",10));
		cols.add(new ExcelColumn("total", "数量",10));
		return cols;
	}
	
	/**
	 * 提取品牌类型
	 */
	public Map getBrandType(){
		Map t = new LinkedHashMap();
		t.put("", "请选择");
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
//		//cityid,过滤sms表中的数据
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
	 * 显示明细的表头
	 * 获得表头
	 * @return
	 */
	public List<ColumnSet> getsetCols1() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("wayid", "网点编码"));
		setCols.add(new ColumnSet("wayname", "网点名称"));
//		setCols.add(new ColumnSet("countyid", "分公司"));
		setCols.add(new ColumnSet("strcountyid", "分公司"));
//		setCols.add(new ColumnSet("starlevel", "星级"));
		setCols.add(new ColumnSet("strstarlevel", "星级"));
		setCols.add(new ColumnSet("employeename", "店员"));
		setCols.add(new ColumnSet("officetel", "捆绑手机号码"));
		setCols.add(new ColumnSet("mobile", "套卡号码"));//套卡号码
//		setCols.add(new ColumnSet("brand", "品牌"));
		setCols.add(new ColumnSet("brandName", "品牌"));
		setCols.add(new ColumnSet("comname", "子品牌"));
		setCols.add(new ColumnSet("comtype", "商品类型"));
		setCols.add(new ColumnSet("comclassid", "商品类别"));
		setCols.add(new ColumnSet("comprice", "商品价格(元)"));
		setCols.add(new ColumnSet("flag", "补登标识"));
		setCols.add(new ColumnSet("oprtime", "登记时间"));
		setCols.add(new ColumnSet("activedate", "激活时间"));
		//setCols.add(new ColumnSet("oper", "操作",true));
		return setCols;
	}

	//取得汇总页面传递的参数
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
