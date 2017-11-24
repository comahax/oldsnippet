package com.gmcc.pboss.biz.info.salesDetail.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import com.gmcc.pboss.common.constant.service.ConstantService;
import com.gmcc.pboss.biz.info.salesDetail.service.MagRegisternewService;
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
import com.gmcc.pboss.biz.info.salesDetail.support.MagRegisternewQueryParameter;

public class MagRegisternewAction extends AbstractAction {

	/**
	 * 查询参数
	 */
	MagRegisternewQueryParameter parameter;
	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		//MagRegisternewQueryParameter parameter = new MagRegisternewQueryParameter();
		parameter = parameter==null ? new MagRegisternewQueryParameter() : parameter;
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
		parameter.setCityid(this.getMember().getCityid());
		if(!StringUtils.isNotEmpty(parameter.getWayid())){
			//查询条件未限定网点编码，则以经理下属所有网点为范围；如果这里不限制，查询结果会放大
			parameter.setWaymagcode(this.getMember().getEmployeeid());
		}
		return parameter;
	}
	public void setParameter(MagRegisternewQueryParameter p){
		this.parameter = p;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		//Date d = new Date();
		//this.setTimeFrom(d);
		//this.setTimeTo(DateUtils.addDays(d, 5));
	}
	
	/*
	 * 新业务销售信息查询service
	 */
	private MagRegisternewService magRegisternewServie;
	public void setMagRegisternewService(MagRegisternewService magRegisternewServie){
		this.magRegisternewServie = magRegisternewServie;
	}
	public MagRegisternewService getMagRegisternewService(){
		return this.magRegisternewServie;
	}
	
	/**
	 * 固定参数Service
	 */
	private ConstantService constantService;
	public ConstantService getConstantService() {
		return constantService;
	}
	public void setConstantService(ConstantService constantService) {
		this.constantService = constantService;
	}
	
	/*
	 *进入新业务销售信息查询列表
	 */
	public String doList(){
		this.setTitle(PageLoction.MAG_REG_NEW_SALE_DETAIL_QUERY);
		return SUCCESS;
	}
	public String doAjax(){
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = magRegisternewServie.transact(getMember(), getParameter(), ServiceType.QUERY);
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	
	/**
	 * 导出Excel
	 */
	public String doExportExcel(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL);
		ServiceResult result = magRegisternewServie.transact(member, param, ServiceType.QUERY);
		if (result.isSuccess() && result.getRetResult() != null && result.getRetResult().getData() != null && result.getRetResult().getData().size() > 0) {
			int size = result.getRetResult().getData().size();
			if( size>0 && size<=65536 )//待导出的数据不能超过65536行，否则Excel2003不支持
				this.exportExcel(result.getRetResult().getData());
		}
		return null;
	}
	/**
	 * 返回导出Excel文件的名称
	 */
	protected String getExcelTitle(){
		return "新业务销售明细清单";
	}
	/**
	 * 返回导出excel的列的信息
	 * @return
	 */
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> cols = new ArrayList<ExcelColumn>();
		cols.add(new ExcelColumn("wayid","网点编码",10));
		cols.add(new ExcelColumn("wayname", "网点名称",15));
		cols.add(new ExcelColumn("strcountyid", "分公司",15));
		cols.add(new ExcelColumn("strstarlevel", "星级",15));
		cols.add(new ExcelColumn("employeename", "店员",15));
		cols.add(new ExcelColumn("officetel", "捆绑手机号码",15));
		cols.add(new ExcelColumn("mobile", "用户号码",15));
		cols.add(new ExcelColumn("brandName", "品牌",10));
		cols.add(new ExcelColumn("opnid", "业务编码",10));
		cols.add(new ExcelColumn("opnname", "业务名称",15));
		cols.add(new ExcelColumn("oprtime", "登记时间",15,"yyyy-MM-dd HH:mm:ss"));
		return cols;
	}
	/**
	 * 导出txt
	 */
	public String doExportTxt(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL );
		ServiceResult result = magRegisternewServie.transact(member, param, ServiceType.QUERY);
		if (result.isSuccess() && result.getRetResult() != null && result.getRetResult().getData() != null && result.getRetResult().getData().size() > 0) {
			this.exportTxt(result.getRetResult().getData());
		}
		return null;
	}
	
	/**
	 * 获得表头
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
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
		setCols.add(new ColumnSet("oprtime", "登记时间"));
		//setCols.add(new ColumnSet("oper", "操作",true));
		return setCols;
	}
	 /**
	 * 返回页面显示的效果
	 * @return the colSet
	 */
	public String getShowCols(){
		return JSONArray.fromObject(getsetCols()).toString();
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

}
