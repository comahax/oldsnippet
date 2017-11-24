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
	private Map conItem; // 分公司
	private ConstantService constantService;
	// 取得汇总页面传递的参数
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
//		//分公司和销售服务中心是检索条件,不能再次赋值
//		parameter.setCountyid(logMem.getChannel().getCountyid());
//		parameter.setSvccode(logMem.getChannel().getSvccode());
		
		//分公司和销售服务中心是检索条件,不能再次赋值
//		if("".equals(parameter.getCountyid()))
//			parameter.setCountyid(logMem.getChannel().getCountyid());
//		if("".equals(parameter.getSvccode()))
//			parameter.setSvccode(logMem.getChannel().getSvccode());
		
		//以经理的工号作为经理的所有数据
		parameter.setWaymagcode(logMem.getEmployeeid());
		
		//cityid过滤,得到opnname时要用到的
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
	
	@Override
	public QueryParameter getParameter() {
		parameter = parameter == null ? new SalesCardsTotalQueryParameter() : parameter;
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
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
		// 初始化登记时间
		Date d = new Date();
		parameter.setEndoprtime(d);
		parameter.setStartoprtime(d);
//		parameter.setStartactivedate(d);
//		parameter.setEndactivedate(d);
		this.setConItem(getCntyComd());
		LoginMember logMem = this.getMember();
//		parameter.setWayid(logMem.getWayid());
		
		//分公司和销售服务中心是检索条件,不能再次赋值
//		parameter.setCountyid(logMem.getChannel().getCountyid());
//		parameter.setSvccode(logMem.getChannel().getSvccode());
		
		parameter.setWaymagcode(logMem.getEmployeeid());
		//cityid过滤
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
	 * 套卡销售汇总查询
	 */
	public String doQuery() {

		LoginMember member = getMember();
		this.getParameter();
//		parameter.setWayid(member.getWayid());
		
		//分公司和销售服务中心是检索条件,不能再次赋值
//		if("".equals(parameter.getCountyid()))
//			parameter.setCountyid(member.getChannel().getCountyid());
//		if("".equals(parameter.getSvccode()))
//			parameter.setSvccode(member.getChannel().getSvccode());
		
		parameter.setWaymagcode(member.getEmployeeid());
		//cityid过滤
		parameter.setCityid(member.getCityid());
		ServiceResult result = this.getService().transact(member, this.getParameter(), ServiceType.QUERY);
//		result.getRetResult().getPage().setRows(result.getRetResult().getData().size());
		// 回写JSON
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
	 * 这是明细的显示的表格
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
	
	
	
	public List getsetCols() {

		List setCols = new ArrayList();
		setCols.add(new ColumnSet("wayid", "网点编码"));
		setCols.add(new ColumnSet("wayname", "网点名称"));
		setCols.add(new ColumnSet("countyid"));//隐藏传递参数
		setCols.add(new ColumnSet("strcountyid", "分公司"));
		setCols.add(new ColumnSet("strstarlevel", "星级"));
		setCols.add(new ColumnSet("total", "数量"));
		setCols.add(new ColumnSet("starlevel"));
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
//		QueryParameter param = getParameter();
		parameter.setWaymagcode(member.getEmployeeid());
		//cityid过滤
		parameter.setCityid(member.getCityid());
		parameter.setAction(QueryAction.ALL);
		ServiceResult result = this.getService().transact(member, getParameter(), ServiceType.QUERY);
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
		cols.add(new ExcelColumn("wayid","网点编码",10));
		cols.add(new ExcelColumn("wayname", "网点名称",10));
//		cols.add(new ExcelColumn("countyid", "分公司",10));
		cols.add(new ExcelColumn("strcountyid", "分公司",10));
		cols.add(new ExcelColumn("strstarlevel", "星级",10));
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
