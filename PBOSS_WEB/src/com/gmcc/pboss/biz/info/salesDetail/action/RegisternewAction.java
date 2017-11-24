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
	 * 获取查询参数
	 */
	//店员姓名-工号
	private String oprcode;
	public void setOprcode(String oprcode){
		this.oprcode = oprcode;
	}
	public String getOprcode(){
		return this.oprcode;
	}
	//业务编码
	private String opnid;
	public void setOpnid(String opnid){
		this.opnid = opnid;
	}
	public String getOpnid(){
		return this.opnid;
	}
	//品牌
	private String brand;
	public void setBrand(String b){
		this.brand = b;
	}
	public String getBrand(){
		return this.brand;
	}
	//开始时间
	private Date timeFrom;
	public void setTimeFrom(Date timeFrom){
		this.timeFrom = timeFrom;
	}
	public Date getTimeFrom(){
		return this.timeFrom;
	}
	//结束时间
	private Date timeTo;
	public void setTimeTo(Date timeTo){
		this.timeTo = timeTo;
	}
	public Date getTimeTo(){			
		return this.timeTo;
	}
	
	/*
	 * 新业务销售信息查询service
	 */
	private RegisternewService registernewServie;
	public void setRegisternewService(RegisternewService registernewServie){
		this.registernewServie = registernewServie;
	}
	public RegisternewService getRegisternewService(){
		return this.registernewServie;
	}
	// 提取业务编码和名称
	private OperationsmsService operationsmsService;
	public void setOperationsmsService(OperationsmsService operationsmsService){
		this.operationsmsService = operationsmsService;
	}
	public OperationsmsService getOperationsmsService(){
		return this.operationsmsService;
	}
	
	/*
	 *进入新业务销售信息查询列表
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
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小  
		
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
	 * 导出Excel
	 */
	public String doExportExcel(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL);
		ServiceResult result = registernewServie.transact(member, param, ServiceType.QUERY);
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
		cols.add(new ExcelColumn("oprtime", "登记时间",15,"yyyy-MM-dd HH:mm"));
		return cols;
	}
	/**
	 * 导出txt
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
	 * 提取业务编码和名称列表
	 */
	public Map getOpnInfo(){
		Map t = new LinkedHashMap();
		t.put("", "请选择");
		Map result = this.operationsmsService.getOpnInfo(getMember().getCityid());
		t.putAll(result);
		return t;
	}
	//分公司
	public String getStrCountyid(){
		String countyid = this.getMember().getChannel().getCountyid();
		String strCountyid = Constant.getCountyidchName(countyid);
		return strCountyid;
	}
}
