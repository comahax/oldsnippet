package com.gmcc.pboss.biz.info.salesDetail.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.commons.lang.time.DateUtils;

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
import com.gmcc.pboss.biz.info.salesDetail.service.RegistersimService;
import com.gmcc.pboss.biz.info.salesDetail.support.RegistersimQueryParameter;

public class RegistersimAction extends AbstractAction {

	/*
	 * 获取查询参数
	 */
	//店员姓名-人员编码，套卡表中oprcode字段对应人员表employeeid
	private String oprcode;
	public void setOprcode(String oprcode){
		this.oprcode = oprcode;
	}
	public String getOprcode(){
		return this.oprcode;
	}
	//套卡号码
	private String mobile;
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	public String getMobile(){
		return this.mobile;
	}
	//品牌
	private String brand;
	public void setBrand(String b){
		this.brand = b;
	}
	public String getBrand(){
		return this.brand;
	}
	//登记方式
	private String flag;	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	//商品类型
	private String type;		
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	//登记开始时间
	private Date timeFrom;
	public void setTimeFrom(Date timeFrom){
		this.timeFrom = timeFrom;
	}
	public Date getTimeFrom(){
		return this.timeFrom;
	}
	//登记结束时间
	private Date timeTo;
	public void setTimeTo(Date timeTo){
		this.timeTo = timeTo;
	}
	public Date getTimeTo(){			
		return this.timeTo;
	}
	//激活起始时间
	private Date activeFrom;
	public void setActiveFrom(Date from){
		this.activeFrom = from;
	}
	public Date getActiveFrom(){
		return this.activeFrom;
	}
	//激活结束时间
	private Date activeTo;
	public void setActiveTo(Date to){
		this.activeTo = to;
	}
	public Date getActiveTo(){
		return this.activeTo;
	}
	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		RegistersimQueryParameter parameter = new RegistersimQueryParameter();
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小  
		
		LoginMember logMem = this.getMember();
		parameter.setCityid(logMem.getCityid());
		parameter.setWayid(logMem.getWayid());
		if(logMem.getIsnet()==0){//店员
			parameter.setOprcode(logMem.getEmployeeid());
		}
		else{//店主
			if (this.getOprcode()!=null){
				parameter.setOprcode(this.getOprcode());
			}
		}
		parameter.setCountyid(logMem.getChannel().getCountyid());
		parameter.setSvccode(logMem.getChannel().getSvccode());
		if(this.getMobile()!=null)
			parameter.setMobile(this.getMobile());
		if(this.getBrand()!=null)
			parameter.setBrand(this.getBrand());
		if(this.getFlag()!=null && !"".equals(this.getFlag())){
			parameter.setFlag(this.getFlag());
		}
		if(this.getType()!=null && !"".equals(this.getType())){
			parameter.setType(this.getType());
		}
		if(this.getTimeFrom()!=null && this.getTimeTo()!=null){
			parameter.setStartDate(this.getTimeFrom());
			parameter.setEndDate(this.getTimeTo());
		}
		if(this.getActiveFrom()!=null && this.getActiveTo()!=null){
			parameter.setActiveFrom(this.getActiveFrom());
			parameter.setActiveTo(this.getActiveTo());
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
	 * 店员店主-套卡业务查询的service
	 */
	private RegistersimService registersimService;
	public void setRegistersimService(RegistersimService registersimService){
		this.registersimService = registersimService;
	}
	public RegistersimService getRegistersimService(){
		return this.registersimService;
	}
	
	/*
	 *进入套卡销售信息查询列表
	 */
	public String doList(){
		this.setTitle(PageLoction.CARD_SALE_DETAIL_QUERY);
		RegistersimQueryParameter parameter = (RegistersimQueryParameter)this.getParameter();
		Date d = new Date();
		this.setTimeFrom(d);
		this.setTimeTo(d);
		return SUCCESS;
	}
	
	public String doAjax(){
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = registersimService.transact(getMember(), getParameter(), ServiceType.QUERY);
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
		ServiceResult result = registersimService.transact(member, param, ServiceType.QUERY);
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
		return "套卡销售明细清单";
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
		cols.add(new ExcelColumn("strstarlevel", "星级",10));
		cols.add(new ExcelColumn("employeename", "店员",10));
		cols.add(new ExcelColumn("officetel", "捆绑手机号码",15));
		cols.add(new ExcelColumn("mobile", "套卡号码",15));//套卡号码
		cols.add(new ExcelColumn("brandName", "品牌",10));
		cols.add(new ExcelColumn("comname", "子品牌",10));
		cols.add(new ExcelColumn("comtype", "商品类型",10));
		cols.add(new ExcelColumn("comclassid", "商品类别",10));
		cols.add(new ExcelColumn("comprice", "商品价格(元)",15));
		cols.add(new ExcelColumn("flag", "补登标识",10));
		cols.add(new ExcelColumn("oprtime", "登记时间",20,"yyyy-MM-dd HH:mm:ss"));
		cols.add(new ExcelColumn("activedate", "激活时间",20,"yyyy-MM-dd HH:mm:ss"));
		return cols;
	}
	/**
	 * 导出txt
	 */
	public String doExportTxt(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL );
		ServiceResult result = registersimService.transact(member, param, ServiceType.QUERY);
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
		setCols.add(new ColumnSet("mobile", "套卡号码"));//套卡号码
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
	 * 提取套卡登记方式
	 */
	public Map getMendFlag(){
		Map t = new LinkedHashMap();
		t.put("", "");
		Map mendFlag = Constant.getConstantsMap(CodeReverseKey.CH_MFLAG);
		t.putAll(mendFlag);
		return t;
	}
	
	/**
	 * 提取商品类型
	 */
	public Map getComType(){
		Map t = new LinkedHashMap();
		t.put("", "");
		Map comType = Constant.getConstantsMap(CodeReverseKey.IM_COMTYPE);
		t.putAll(comType);
		return t;
	}
	
	//分公司
	public String getStrCountyid(){
		String countyid = this.getMember().getChannel().getCountyid();
		String strCountyid = Constant.getCountyidchName(countyid);
		return strCountyid;
	}
}
