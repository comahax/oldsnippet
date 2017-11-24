/**
 * auto-generated code
 * Wed Sep 08 16:30:03 CST 2010
 */
 package com.gmcc.pboss.web.sales.waystocksnpt;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.activedetail.ActivedetailVO;
import com.gmcc.pboss.business.sales.comrescarddetail.ComrescarddetailVO;
import com.gmcc.pboss.business.sales.comressdetail.ComressdetailVO;
import com.gmcc.pboss.business.sales.waystocksnpt.RWaystocksnptVO;
import com.gmcc.pboss.business.sales.waystocksnpt.SWaystocksnptVO;
import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptDBParam;
import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.sales.activedetail.Activedetail;
import com.gmcc.pboss.control.sales.activedetail.ActivedetailBO;
import com.gmcc.pboss.control.sales.comrescarddetail.Comrescarddetail;
import com.gmcc.pboss.control.sales.comrescarddetail.ComrescarddetailBO;
import com.gmcc.pboss.control.sales.comressdetail.Comressdetail;
import com.gmcc.pboss.control.sales.comressdetail.ComressdetailBO;
import com.gmcc.pboss.control.sales.waystocksnpt.Waystocksnpt;
import com.gmcc.pboss.control.sales.waystocksnpt.WaystocksnptBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: WaystocksnptAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class WaystocksnptAction extends BaseAction{
	
	public WaystocksnptAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new WaystocksnptForm());
		this.setParam(new WaystocksnptDBParam());

        //指定VO类
        setClsVO(WaystocksnptVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Waystocksnpt.class);
		this.setClsQueryParam(WaystocksnptDBParam.class) ;

	}
	
	private String stocklistsmpFlag = "true";
	
	/**
	 * 网点库存量统计
	 * @return
	 * @throws Exception
	 */
	public String doStocklistsmp() throws Exception {
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		if(StringUtils.isEmpty(params.get_dnl_stocktime())&&StringUtils.isEmpty(params.get_dnm_stocktime())){
			String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyy-MM-dd")+" 00:00:00";
			String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyy-MM-dd")+" 23:59:59";
			params.set_dnl_stocktime(stockdate);
			params.set_dnm_stocktime(currdate);
		}
		if(this.isQuery){ 
		Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
		String _se_restype = params.get_se_restype();
		if("COMRESSMP".equals(_se_restype)){
			stocklistsmpFlag = "true";
		}else{
			stocklistsmpFlag = "false";
		}
		Date ldate = new Date();
		Date mdate = new Date();
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		ldate = myformat.parse(params.get_dnl_stocktime());
		mdate = myformat.parse(params.get_dnm_stocktime());
		Long day = (mdate.getTime() - ldate.getTime())/(1000*60*60*24);
		if(day>30){
			setActionMessage("库存时间间隔不能超过30天。");
			return "stocksmplist";
		} 
		DataPackage dp = snptbo.doQuery(params);
		this.setDp(dp);
		}
		return "stocksmplist";
	}
	
	/**
	 * 网点充值卡库存量统计
	 * @return
	 * @throws Exception
	 */
//	public String doStocklistcard() throws Exception {
//		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
//		Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
//		params.set_se_restype("COMRESCARD");
//		if(StringUtils.isEmpty(params.get_dnl_stocktime())&&StringUtils.isEmpty(params.get_dnm_stocktime())){
//			String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyy-MM-dd")+" 00:00:00";
//			String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyy-MM-dd")+" 23:59:59";
//			params.set_dnl_stocktime(stockdate);
//			params.set_dnm_stocktime(currdate);
//		}
//		DataPackage dp = snptbo.doQuery(params);
//		this.setDp(dp);
//		return "stockcardlist";
//	}
	
	/**
	 * 网点套卡库存量明细
	 * @return
	 * @throws Exception
	 */
	public String doStockrecordsmp() throws Exception{
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
		DataPackage dp = snptbo.doQueryStockSmpRecord(params);
		this.setDp(dp);
		return "stockrecordsmp";
	}
	
	/**
	 * 网点充值卡库存量明细
	 * @return
	 * @throws Exception
	 */
//	public String doStockrecordcard() throws Exception{
//		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
//		Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
//		DataPackage dp = snptbo.doQueryStockCardRecord(params);
//		this.setDp(dp);
//		return "stockrecordcard";
//	}
	
	/**
	 * 网点套卡销售量统计
	 * @return
	 * @throws Exception
	 */
	public String doSalesmplist() throws Exception{
		if (this.isQuery){
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
		
		
		//只能查询今天以前的数据
		if(StringUtils.isEmpty(params.get_dnm_createtime())){
			this.setActionMessage("销售时间<=:不可为空!");
			return "salesmplist";
		}else{
			String stockdate = PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00";
			Date ldate = PublicUtils.UtilStrToDate(params.get_dnm_createtime()+" 23:59:59");
			Date curdate = PublicUtils.UtilStrToDate(stockdate);
			if(curdate.before(ldate)){
				this.setActionMessage("只能查询今天以前的数据,[销售时间<=:]的值不能取今天!");
				return "salesmplist";
			}
		}
		
		
		DataPackage dp = snptbo.doQuerySalesSmplist(params);
		this.setDp(dp);
		}
		return "salesmplist";
	}
	
	/**
	 * 网点充值卡销售量统计
	 * @return
	 * @throws Exception
	 */
	public String doSalecardlist() throws Exception{
		if (this.isQuery) {
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
		
		//只能查询今天以前的数据
		
		if(StringUtils.isEmpty(params.get_dnm_createtime())){
			this.setActionMessage("销售时间<=:不可为空!");
			return "salecardlist";
		}else{
			String stockdate = PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00";
			Date ldate = PublicUtils.UtilStrToDate(params.get_dnm_createtime()+" 23:59:59");
			Date curdate = PublicUtils.UtilStrToDate(stockdate);
			if(curdate.before(ldate)){
				this.setActionMessage("只能查询今天以前的数据,[销售时间<=:]的值不能取今天!");
				return "salecardlist";
			}
		}
		
		DataPackage dp = snptbo.doQuerySalesCardlist(params);
		this.setDp(dp);
		}
		return "salecardlist";
	}
	
	/**
	 * 网点套卡销售量明细
	 * @return
	 * @throws Exception
	 */
	public String doSalerecordsmp() throws Exception{
		//Comressdetail
		//以下几个方法是必须的
		//this.setParam(new ComressdetailDBParam());

        //指定VO类
        setClsVO(ComressdetailVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        //this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Comressdetail.class);
		//this.setClsQueryParam(ComressdetailDBParam.class) ;
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
//		ComressdetailDBParam params = (ComressdetailDBParam) getParam();
//		Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
		Comressdetail snptbo = (Comressdetail) BOFactory.build(ComressdetailBO.class, getDBAccessUser());
		String _se_comresid = params.get_se_comresid();
		if ((_se_comresid == null || "".equals(_se_comresid))
				&& StringUtils.isEmpty(params.get_dnl_stocktime())
				&& StringUtils.isEmpty(params.get_dnm_stocktime())) {
			String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyy-MM-dd")+" 00:00:00";
			String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyy-MM-dd")+" 23:59:59";
			params.set_dnl_stocktime(stockdate);
			params.set_dnm_stocktime(currdate);
		}
		if (this.isQuery){
			if (_se_comresid == null || "".equals(_se_comresid)) {
				Date ldate = new Date();
				Date mdate = new Date();
				SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
				ldate = myformat.parse(params.get_dnl_stocktime());
				mdate = myformat.parse(params.get_dnm_stocktime());
				Long day = (mdate.getTime() - ldate.getTime())/(1000*60*60*24);
				if(day>30){
					setActionMessage("销售时间间隔不能超过30天。");
					return "salerecordsmp";
				}else{
					params.set_dnl_stocktime(myformat.format(ldate)+" 00:00:00");
					params.set_dnm_stocktime(myformat.format(mdate)+" 23:59:59");
				}
			} else {
				params.set_dnl_stocktime(null);
				params.set_dnm_stocktime(null);
			}
//			DataPackage dp = snptbo.doQuerySalesSmpRecord(params);
			DataPackage dp = snptbo.doQuery(params);
			this.setDp(dp);
		}
		return "salerecordsmp";
	}
	
	/**
	 * 网点充值卡销售量明细
	 * @return
	 * @throws Exception
	 */
	public String doSalerecordcard() throws Exception{
		
		 //指定VO类
        setClsVO(ComrescarddetailVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.setClsControl(Comrescarddetail.class);
		
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		Comrescarddetail snptbo = (Comrescarddetail) BOFactory.build(ComrescarddetailBO.class, getDBAccessUser());
		String _se_comresid = params.get_se_comresid();
		if ((_se_comresid == null || "".equals(_se_comresid))
				&& StringUtils.isEmpty(params.get_dnl_stocktime())
				&& StringUtils.isEmpty(params.get_dnm_stocktime())) {
			String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyy-MM-dd")+" 00:00:00";
			String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyy-MM-dd")+" 23:59:59";
			params.set_dnl_stocktime(stockdate);
			params.set_dnm_stocktime(currdate);
		}
		if(this.isQuery){
			if (_se_comresid == null || "".equals(_se_comresid)) {
				Date ldate = new Date();
				Date mdate = new Date();
				SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
				ldate = myformat.parse(params.get_dnl_stocktime());
				mdate = myformat.parse(params.get_dnm_stocktime());
				Long day = (mdate.getTime() - ldate.getTime())/(1000*60*60*24);
				if(day>30){
					setActionMessage("销售时间间隔不能超过30天。");
					return "salerecordcard";
				}else{
					params.set_dnl_stocktime(myformat.format(ldate)+" 00:00:00");
					params.set_dnm_stocktime(myformat.format(mdate)+" 23:59:59");
				}
			} else {
				params.set_dnl_stocktime(null);
				params.set_dnm_stocktime(null);
			}
//			DataPackage dp = snptbo.doQuerySalesCardRecord(params);
			DataPackage dp = snptbo.doQuery(params);
			this.setDp(dp);
		}
		return "salerecordcard";
	}
	/**
	 * 网点套卡激活统计LIST
	 * @return
	 * @throws Exception
	 */
	public String doActivelistsmplist() throws Exception{
		//if (this.isQuery) {
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam(); 
		if(StringUtils.isEmpty(params.get_dnl_acttime())&&StringUtils.isEmpty(params.get_dnm_acttime())){
			String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyy-MM-dd")+" 00:00:00";
			String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyy-MM-dd")+" 23:59:59";
			params.set_dnl_acttime(stockdate);
			params.set_dnm_acttime(currdate);
		}  
		//}
		return "activesmplist";
	}
	
	/**
	 * 网点套卡激活统计
	 * @return
	 * @throws Exception
	 */
	public String doActivelistsmp() throws Exception{
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());  
		Date ldate = new Date();
		Date mdate = new Date();
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd"); 
		ldate = myformat.parse(params.get_dnl_acttime());
		mdate = myformat.parse(params.get_dnm_acttime());
		Long day = (mdate.getTime() - ldate.getTime())/(1000*60*60*24);
		if(StringUtils.isEmpty(params.get_dnl_acttime()) || StringUtils.isEmpty(params.get_dnm_acttime())){ 
			setActionMessage("激活时间间隔不能超过30天且不能为空"); 
			return "activesmplist";
			
		}else if (day<0){
			setActionMessage("结束时间必须大于开始时间");
			return "activesmplist";
			
		}else { 
			
		if(day>30){
			setActionMessage("激活时间间隔不能超过30天");
			return "activesmplist";
		}else{
				String stockdate = PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00";
				Date lldate = PublicUtils.UtilStrToDate(params.get_dnm_acttime());
				Date curdate = PublicUtils.UtilStrToDate(stockdate);
				if(curdate.before(lldate)){
					this.setActionMessage("只能查询今天以前的数据,[激活时间<=:]的值不能取今天!");
					return "activesmplist";
				}else{
					params.set_dnm_acttime(myformat.format(mdate)+" 23:59:59");
				}
					params.set_dnl_acttime(myformat.format(ldate)+" 00:00:00");
		}
		}
		DataPackage dp = snptbo.doQueryActiveSmpList(params);  
		this.setDp(dp);
		return "activesmplist";
	}
	
	/**
	 * 网点套卡激活统计2---用于导出
	 * @return
	 * @throws Exception
	 */
	public String doActivelistsmp2() throws Exception{
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
		DataPackage dp = snptbo.doQueryActiveSmpList2(params);
		this.setDp(dp);
		return "activesmplist";
	}
	
	/**
	 * 网点套卡激活明细
	 * @return
	 * @throws Exception
	 */
	public String doActivesmprecord() throws Exception{
		 //指定VO类
        setClsVO(ActivedetailVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.setClsControl(Activedetail.class);
		
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		Activedetail snptbo = (Activedetail) BOFactory.build(ActivedetailBO.class, getDBAccessUser());
		String _se_comresid = params.get_se_comresid();
		if ((_se_comresid == null || "".equals(_se_comresid))
				&& StringUtils.isEmpty(params.get_dnl_acttime())
				&& StringUtils.isEmpty(params.get_dnm_acttime())) {
			String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyy-MM-dd")+" 00:00:00";
			String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyy-MM-dd")+" 23:59:59";
			params.set_dnl_acttime(stockdate);
			params.set_dnm_acttime(currdate);
		}
		if (this.isQuery){
			if (_se_comresid == null || "".equals(_se_comresid)) {
				Date ldate = new Date();
				Date mdate = new Date();
				SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
				ldate = myformat.parse(params.get_dnl_acttime());
				mdate = myformat.parse(params.get_dnm_acttime());
				Long day = (mdate.getTime() - ldate.getTime())/(1000*60*60*24);
				if(day>30){
					setActionMessage("激活时间间隔不能超过30天。");
					return "activerecordsmp";
				}else{
					params.set_dnl_acttime(myformat.format(ldate)+" 00:00:00");
					params.set_dnm_acttime(myformat.format(mdate)+" 23:59:59");
				}
			} else {
				params.set_dnl_acttime(null);
				params.set_dnm_acttime(null);
			}
//			DataPackage dp = snptbo.doQueryActiveSmpRecord(params);
			DataPackage dp = snptbo.doQuery(params);
			this.setDp(dp);
		}
		return "activerecordsmp";
	}
	
	/**
	 * 网点空白SIM卡销售量统计
	 * @return
	 * @throws Exception
	 */
	public String doSalestatistic() throws Exception {
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		if (this.isQuery) {
			Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
			DataPackage dp = snptbo.doQuerySaleStatistic(params);
			this.setDp(dp);
		} else {
			params.set_dnm_createtime(PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd"));
		}
		return "salestatistic";
	}
	
	/**
	 * 网点空白SIM卡销售量明细
	 * @return
	 * @throws Exception
	 */
	public String doSalerecord() throws Exception {
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		if (this.isQuery) {
			setClsVO(SWaystocksnptVO.class);
			Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
			DataPackage dp = snptbo.doQuerySaleRecord(params);
			this.setDp(dp);
		} else {
			params.set_dnm_stocktime(PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd"));
		}
		return "salerecord";
	}
	
	/**
	 * 网点空白SIM卡使用量统计
	 * @return
	 * @throws Exception
	 */
	public String doUsedstatistic() throws Exception {
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		if (this.isQuery) {
			Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
			DataPackage dp = snptbo.doQueryUsedStatistic(params);
			this.setDp(dp);
		} else {
			params.set_dnm_changetime(PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd"));
		}
		return "usedstatistic";
	}
	
	/**
	 * 网点空白SIM卡使用量明细
	 * @return
	 * @throws Exception
	 */
	public String doUsedrecord() throws Exception {
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		if (this.isQuery) {
			setClsVO(SWaystocksnptVO.class);
			Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
			DataPackage dp = snptbo.doQueryUsedRecord(params);
			this.setDp(dp);
		} else {
			params.set_dnm_changetime(PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd"));
		}
		return "usedrecord";
	}
	
	/**
	 * 网点套卡库存统计EXCEL导出
	 * @return
	 * @throws Exception
	 */
	public String doExportstocksmplist() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点库存统计");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","服务销售中心", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","订单编码");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel","星级", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		String _se_restype = params.get_se_restype();
		if("COMRESSMP".equals(_se_restype)){
			export.addOutputProperty("brand", "品牌", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		}else{
			
		}
		
		export.addOutputProperty("comcategory","商品种类", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum","库存数量");
		export.addOutputProperty("stocktime","库存时间",export.DATE,
				"yyyy-MM-dd");
		
		// 设置VO类
		export.voClassArray = new Class[] { WaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doStocklistsmp";
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	/**
	 * 网点套卡库存统计TXT导出
	 * @return
	 * @throws Exception
	 */
	public String doExportstocksmplistTxt() throws Exception {
		// TODO coding...
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("网点库存统计");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
//		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","服务销售中心", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","订单编码");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel","星级", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		String _se_restype = params.get_se_restype();
		if("COMRESSMP".equals(_se_restype)){
			export.addOutputProperty("brand", "品牌", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		}else{
			
		}
		
		export.addOutputProperty("comcategory","商品种类", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum","库存数量");
		export.addOutputProperty("stocktime","库存时间",export.DATE,
				"yyyy-MM-dd");
		
		// 设置VO类
		export.voClassArray = new Class[] { WaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doStocklistsmp";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		if("COMRESSMP".equals(_se_restype)){
			export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				 "分公司", "服务销售中心", "微区域", "订单编码" ,"网点编码","网点名称","星级","品牌","商品种类","库存数量","库存时间"});
		}else {
			export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				 "分公司", "服务销售中心", "微区域", "订单编码" ,"网点编码","网点名称","星级","商品种类","库存数量","库存时间"});
		}
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	/**
	 * 网点套卡库存明细EXCEL导出
	 * @return
	 * @throws Exception
	 */
	public String doExportstocksmprecord() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点套卡库存明细");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });
		export.addOutputProperty("comresid","套卡号码");
		export.addOutputProperty("stocktime","订购时间",export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","服务销售中心", CommonExportBean.CODE2NAME,"#SERVCENT");		
		
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","订单编码");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel","星级", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("brand", "品牌", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("comcategory","商品种类", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		
		// 设置VO类
		export.voClassArray = new Class[] { RWaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doStockrecordsmp";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	/**
	 * 网点充值卡库存统计EXCEL导出
	 * @return
	 * @throws Exception
	 */
	public String doExportstocklistcard() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点充值卡库存统计");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });		
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","服务销售中心", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","订单编码");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel","星级", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("comcategory","商品种类", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum","库存数量");
		export.addOutputProperty("stocktime","库存时间",export.DATE,
				"yyyy-MM-dd");
		
		// 设置VO类
		export.voClassArray = new Class[] { WaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doStocklistcard";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	/**
	 * 网点充值卡库存明细EXCEL导出
	 * @return
	 * @throws Exception
	 */
	public String doExportstockcardrecord() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点充值卡库存明细");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });
		export.addOutputProperty("comresid","套卡号码");
		export.addOutputProperty("stocktime","订购时间",export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","服务销售中心", CommonExportBean.CODE2NAME,"#SERVCENT");		
		
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","订单编码");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel","星级", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("comcategory","商品种类", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		
		// 设置VO类
		export.voClassArray = new Class[] { RWaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doStockrecordcard";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	/**
	 * 网点套卡销售量统计
	 * @return
	 * @throws Exception
	 */
	public String doExportsalelistsmp() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点套卡销售量统计");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });		
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","服务销售中心", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel","星级", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("brand", "品牌", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");		
		export.addOutputProperty("comcategory","商品种类", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum","销售数量");
		export.addOutputProperty("upperwayid","上级渠道",CommonExportBean.CODE2NAME,"#WAY");
		export.addOutputProperty("waymagcode","所属渠道经理");
		
		// 设置VO类
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doSalesmplist";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	/**
	 * 网点套卡销售量统计导出Txt
	 * @return
	 * @throws Exception
	 */
	public String doExportsalelistsmpTxt() throws Exception {
		this.getRequest().getSession().setAttribute("currenttime", System.currentTimeMillis());
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("网点套卡销售量统计");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
//		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });		
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","服务销售中心", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel","星级", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("brand", "品牌", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");		
		export.addOutputProperty("comcategory","商品种类", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum","销售数量");
		export.addOutputProperty("upperwayid","上级渠道",CommonExportBean.CODE2NAME,"#WAY");
		export.addOutputProperty("waymagcode","所属渠道经理");
		
		// 设置VO类
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doSalesmplist";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"分公司", "服务销售中心", "微区域", "网点编码" ,"网点名称","星级","品牌","商品种类","销售数量","上级渠道","所属渠道经理"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		
		return null;
	}
	
	/**
	 * 网点套卡销售量明细EXCEL导出
	 * @return
	 * @throws Exception
	 */
	public String doExportsalesmprecord() throws Exception {
		 //指定VO类
        setClsVO(ComressdetailVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.setClsControl(Comressdetail.class);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点套卡销售量明细");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });
		export.addOutputProperty("comresid","套卡号码");
		export.addOutputProperty("stocktime","销售时间",export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","服务销售中心", CommonExportBean.CODE2NAME,"#SERVCENT");		
		
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","订单编码");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel","星级", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("brand", "品牌", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("comcategory","商品种类", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("iccid","SIM卡号");
		export.addOutputProperty("upperwayid","上级渠道",CommonExportBean.CODE2NAME,"#WAY");
		export.addOutputProperty("waymagcode","所属渠道经理");
		// 设置VO类
//		export.voClassArray = new Class[] { RWaystocksnptVO.class };
		export.voClassArray = new Class[] { ComressdetailVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doSalerecordsmp";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		params.set_pagesize("10000");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	
	/**
	 * 网点套卡销售量明细Txt导出
	 * @return
	 * @throws Exception
	 */
	public String doExportsalesmprecordTxt() throws Exception {

		User user = (User) getDBAccessUser();
				CommonExportBean export = new CommonExportBean(user);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				export.setFileName("网点套卡销售量明细");
//				export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
//				export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });
				export.addOutputProperty("comresid","套卡号码");
				export.addOutputProperty("stocktime","销售时间",export.DATE,
						"yyyy-MM-dd HH:mm:ss");
				export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
				export.addOutputProperty("svccode","服务销售中心", CommonExportBean.CODE2NAME,"#SERVCENT");		
				
				export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
				export.addOutputProperty("orderid","订单编码");
				export.addOutputProperty("wayid", "网点编码");
				export.addOutputProperty("wayname", "网点名称");
				export.addOutputProperty("starlevel","星级", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
				export.addOutputProperty("brand", "品牌", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
				export.addOutputProperty("comcategory","商品种类", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
				export.addOutputProperty("iccid","SIM卡号");
				export.addOutputProperty("upperwayid","上级渠道",CommonExportBean.CODE2NAME,"#WAY");
				export.addOutputProperty("waymagcode","所属渠道经理");
				// 设置VO类
				//export.voClassArray = new Class[] { RWaystocksnptVO.class };
				export.voClassArray = new Class[] { ComressdetailVO.class };
				
				// 设置查询方法
				export.queryMethodName = "doSalerecordsmp";

				prepareResponse(export.getFileName());
				getParam().set_pagesize("0");
				export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
						"套卡号码", "销售时间","分公司","服务销售中心","微区域","订单编码","网点编码","网点名称","星级","品牌","商品种类","SIM卡号","上级渠道","所属渠道"});
				super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
				return null;

	}
	
	
	
	
	/**
	 * 网点充值卡销售量统计EXCEL导出
	 * @return
	 * @throws Exception
	 */
	public String doExportsalelistcard() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点充值卡销售量统计");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });		
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","服务销售中心", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel","星级", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("comcategory","商品种类", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum","销售数量");
		
		// 设置VO类
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doSalecardlist";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	/**
	 * 网点充值卡销售量统计Txt导出
	 * @return
	 * @throws Exception
	 */
	public String doExportsalelistcardTxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点充值卡销售量统计");
//		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
//		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });		
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","服务销售中心", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel","星级", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("comcategory","商品种类", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum","销售数量");
		
		// 设置VO类
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doSalecardlist";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"分公司", "服务销售中心", "微区域", "网点编码" ,"网点名称","星级","商品种类","销售数量"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	/**
	 * 网点充值卡销量明细EXCEL导出
	 * @return
	 * @throws Exception
	 */
	public String doExportsalecardrecord() throws Exception {
		
		 //指定VO类
        setClsVO(ComrescarddetailVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.setClsControl(Comrescarddetail.class);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点充值卡销售量明细");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });
		export.addOutputProperty("comresid","套卡号码");
		export.addOutputProperty("stocktime","销售时间",export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","服务销售中心", CommonExportBean.CODE2NAME,"#SERVCENT");		
		
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","订单编码");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel","星级", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("comcategory","商品种类", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		
		// 设置VO类
//		export.voClassArray = new Class[] { RWaystocksnptVO.class };
		export.voClassArray = new Class[] { ComrescarddetailVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doSalerecordcard";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	
	/**
	 * 网点充值卡销量明细Txt导出
	 * @return
	 * @throws Exception
	 */
	public String doExportsalecardrecordTxt() throws Exception {
		 //指定VO类
        setClsVO(ComrescarddetailVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.setClsControl(Comrescarddetail.class);
		
		User user = (User) getDBAccessUser();
				CommonExportBean export = new CommonExportBean(user);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				export.setFileName("网点充值卡销售量明细");
//				export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
//				export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });
				export.addOutputProperty("comresid","套卡号码");
				export.addOutputProperty("stocktime","销售时间",export.DATE,
						"yyyy-MM-dd HH:mm:ss");
				export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
				export.addOutputProperty("svccode","服务销售中心", CommonExportBean.CODE2NAME,"#SERVCENT");		
				
				export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
				export.addOutputProperty("orderid","订单编码");
				export.addOutputProperty("wayid", "网点编码");
				export.addOutputProperty("wayname", "网点名称");
				export.addOutputProperty("starlevel","星级", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
				export.addOutputProperty("comcategory","商品种类", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
				
				// 设置VO类
				export.voClassArray = new Class[] { ComrescarddetailVO.class };
				
				// 设置查询方法
				export.queryMethodName = "doSalerecordcard";

				prepareResponse(export.getFileName());
				getParam().set_pagesize("0");
				export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
						"套卡号码", "销售时间",  "分公司" ,"服务销售中心","微区域","订单编码","网点编码","网点名称","星级","商品种类"});
				super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
				return null;
	}
	
	
	
	/**
	 * 网点套卡激活量统计EXCEL导出
	 * @return
	 * @throws Exception
	 */
	public String doExportactivesmplist() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点套卡激活量统计");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","服务销售中心", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel","星级", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("brand", "品牌", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("comcategory","商品种类", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum","激活数量");
		export.addOutputProperty("actrate", "激活率", CommonExportBean.RATE,"0.00");
		export.addOutputProperty("upperwayid","上级渠道",CommonExportBean.CODE2NAME,"#WAY");
		// 设置VO类
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doActivelistsmp2";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		params.set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	/**
	 * 网点套卡激活量统计Txt导出
	 * @return
	 * @throws Exception
	 */
	public String doExportactivesmplistTxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点套卡激活量统计");
//		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
//		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","服务销售中心", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel","星级", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("brand", "品牌", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("comcategory","商品种类", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum","激活数量");
		export.addOutputProperty("actrate", "激活率", CommonExportBean.RATE,"0.00");
		export.addOutputProperty("upperwayid","上级渠道",CommonExportBean.CODE2NAME,"#WAY");
		// 设置VO类
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doActivelistsmp2";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"分公司", "服务销售中心", "微区域", "网点编码" ,"网点名称","星级","品牌","商品种类","激活数量","激活率","上级渠道"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	
	
	/**
	 * 网点套卡激活量明细EXCEL导出
	 * @return
	 * @throws Exception
	 */
	public String doExportactivesmprecord() throws Exception {
		 //指定VO类
        setClsVO(ActivedetailVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.setClsControl(Activedetail.class);
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点套卡激活量明细");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });
		export.addOutputProperty("comresid","商品资源编号");
		export.addOutputProperty("acttime","激活时间",export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","服务销售中心", CommonExportBean.CODE2NAME,"#SERVCENT");		
		
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","订单编码");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel","星级", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("brand", "品牌", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("comcategory","商品种类", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("upperwayid","上级渠道",CommonExportBean.CODE2NAME,"#WAY");
		
		// 设置VO类
		export.voClassArray = new Class[] { ActivedetailVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doActivesmprecord";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		params.set_pagesize("10000");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	/**
	 * 网点套卡激活量明细Txt导出
	 * @return
	 * @throws Exception
	 */
	public String doExportactivesmprecordTxt() throws Exception {
		 //指定VO类
        setClsVO(ActivedetailVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.setClsControl(Activedetail.class);
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点套卡激活量明细");
//		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
//		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });
		export.addOutputProperty("comresid","商品资源编号");
		export.addOutputProperty("acttime","激活时间",export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","服务销售中心", CommonExportBean.CODE2NAME,"#SERVCENT");		
		
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","订单编码");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel","星级", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("brand", "品牌", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("comcategory","商品种类", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("upperwayid","上级渠道",CommonExportBean.CODE2NAME,"#WAY");
		
		// 设置VO类
		export.voClassArray = new Class[] { ActivedetailVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doActivesmprecord";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"商品资源编号", "激活时间", "分公司" ,"服务销售中心","微区域","订单编码","网点编码","网点名称","星级","品牌","商品种类","上级渠道"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	/**
	 * 网点空白SIM卡销售量统计导出Excel
	 * @return
	 * @throws Exception
	 */
	public String doExportsalestatistic() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点空白SIM卡销售量统计");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date())});
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode", "服务销售中心", CommonExportBean.CODE2NAME, "#SERVCENT");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel", "星级", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("comcategory", "商品种类", CommonExportBean.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum", "数量");
		export.addOutputProperty("upperwayid", "上级渠道",CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("waymagcode", "所属渠道经理");
		
		// 设置VO类
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doSalestatistic";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	/**
	 * 网点空白SIM卡销售量统计导出Txt
	 * @return
	 * @throws Exception
	 */
	public String doExportsalestatisticTxt() throws Exception {
		this.getRequest().getSession().setAttribute("currenttime", System.currentTimeMillis());
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("网点空白SIM卡销售量统计");
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode", "服务销售中心", CommonExportBean.CODE2NAME, "#SERVCENT");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel", "星级", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("comcategory", "商品种类", CommonExportBean.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum", "数量");
		export.addOutputProperty("upperwayid", "上级渠道",CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("waymagcode", "所属渠道经理");
		
		// 设置VO类
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doSalestatistic";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"分公司", "服务销售中心", "微区域", "网点编码", "网点名称", "星级", 
				"商品种类", "数量", "上级渠道", "所属渠道经理" });
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	/**
	 * 网点空白SIM卡销售量明细导出Excel
	 * @return
	 * @throws Exception
	 */
	public String doExportsalerecord() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点空白SIM卡销售量明细");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date())});
		export.addOutputProperty("emptyno", "空白卡序列号");
		export.addOutputProperty("stocktime", "销售时间", export.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode", "服务销售中心", CommonExportBean.CODE2NAME, "#SERVCENT");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid", "订单编码");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel", "星级", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("comcategory", "商品种类", CommonExportBean.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("upperwayid", "上级渠道",CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("waymagcode", "所属渠道经理");
		
		// 设置VO类
		export.voClassArray = new Class[] { RWaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doSalerecord";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	/**
	 * 网点空白SIM卡销售量明细导出Txt
	 * @return
	 * @throws Exception
	 */
	public String doExportsalerecordTxt() throws Exception {
		this.getRequest().getSession().setAttribute("currenttime", System.currentTimeMillis());
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("网点空白SIM卡销售量明细");
		export.addOutputProperty("emptyno", "空白卡序列号");
		export.addOutputProperty("stocktime", "销售时间", export.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode", "服务销售中心", CommonExportBean.CODE2NAME, "#SERVCENT");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid", "订单编码");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel", "星级", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("comcategory", "商品种类", CommonExportBean.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("upperwayid", "上级渠道", CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("waymagcode", "所属渠道经理");
		
		// 设置VO类
		export.voClassArray = new Class[] { RWaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doSalerecord";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
			"空白卡序列号", "销售时间", "分公司", "服务销售中心", "微区域", "订单编码", 
			"网点编码", "网点名称", "星级", "商品种类", "上级渠道", "所属渠道经理"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	/**
	 * 网点空白SIM卡使用量统计导出Excel
	 * @return
	 * @throws Exception
	 */
	public String doExportusedstatistic() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点空白SIM卡使用量统计");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date())});
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode", "服务销售中心", CommonExportBean.CODE2NAME, "#SERVCENT");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid", "订单编码");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel", "星级", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("comcategory", "商品种类", CommonExportBean.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum", "数量");
		export.addOutputProperty("upperwayid", "上级渠道", CommonExportBean.CODE2NAME, "#WAY");
		
		// 设置VO类
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doUsedstatistic";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	/**
	 * 网点空白SIM卡使用量统计导出Txt
	 * @return
	 * @throws Exception
	 */
	public String doExportusedstatisticTxt() throws Exception {
		this.getRequest().getSession().setAttribute("currenttime", System.currentTimeMillis());
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("网点空白SIM卡使用量统计");
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode", "服务销售中心", CommonExportBean.CODE2NAME, "#SERVCENT");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid", "订单编码");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel", "星级", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("comcategory", "商品种类", CommonExportBean.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum", "数量");
		export.addOutputProperty("upperwayid", "上级渠道", CommonExportBean.CODE2NAME, "#WAY");
		
		// 设置VO类
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doUsedstatistic";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
			"分公司", "服务销售中心", "微区域", "订单编码", "网点编码", 
			"网点名称", "星级", "商品种类", "数量", "上级渠道"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	/**
	 * 网点空白SIM卡使用量明细导出Excel
	 * @return
	 * @throws Exception
	 */
	public String doExportusedrecord() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点空白SIM卡使用量明细");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date())});
		export.addOutputProperty("emptyno", "空白卡序列号");
		export.addOutputProperty("changetime", "状态变更时间", export.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode", "服务销售中心", CommonExportBean.CODE2NAME, "#SERVCENT");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid", "订单编码");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel", "星级", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("comcategory", "商品种类", CommonExportBean.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("state", "状态", CommonExportBean.CODE2NAME, "$FX_CHANGESTATE");
		export.addOutputProperty("upperwayid", "上级渠道", CommonExportBean.CODE2NAME, "#WAY");
		
		// 设置VO类
		export.voClassArray = new Class[] { RWaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doUsedrecord";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	/**
	 * 网点空白SIM卡使用量明细导出Txt
	 * @return
	 * @throws Exception
	 */
	public String doExportusedrecordTxt() throws Exception {
		this.getRequest().getSession().setAttribute("currenttime", System.currentTimeMillis());
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("网点空白SIM卡使用量明细");
		export.addOutputProperty("emptyno", "空白卡序列号");
		export.addOutputProperty("changetime", "状态变更时间", export.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode", "服务销售中心", CommonExportBean.CODE2NAME, "#SERVCENT");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid", "订单编码");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel", "星级", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("comcategory", "商品种类", CommonExportBean.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("state", "状态", CommonExportBean.CODE2NAME, "$FX_CHANGESTATE");
		export.addOutputProperty("upperwayid", "上级渠道", CommonExportBean.CODE2NAME, "#WAY");
		
		// 设置VO类
		export.voClassArray = new Class[] { RWaystocksnptVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doUsedrecord";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"空白卡序列号", "状态变更时间", "分公司", "服务销售中心", "微区域", "订单编码", 
				"网点编码", "网点名称", "星级", "商品种类", "状态", "上级渠道"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	private Date queryStockTimeCurrent() throws Exception {
		Calendar stocktime = Calendar.getInstance();
		stocktime.add(Calendar.DAY_OF_MONTH, -1);
		stocktime.set(Calendar.HOUR_OF_DAY, 00);
		stocktime.set(Calendar.MINUTE, 00);
		stocktime.set(Calendar.SECOND, 00);
		return stocktime.getTime();
	}
	
	private Date queryStockTime() throws Exception {
		Calendar stocktime = Calendar.getInstance();
		stocktime.add(Calendar.DAY_OF_MONTH, -1);
		stocktime.set(Calendar.HOUR_OF_DAY, 23);
		stocktime.set(Calendar.MINUTE, 59);
		stocktime.set(Calendar.SECOND, 59);
		return stocktime.getTime();
	}
	private boolean isQuery;// 是否统计标识，默认不查询

	public boolean getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(boolean isQuery) {
		this.isQuery = isQuery;
	}

	public String getStocklistsmpFlag() {
		return stocklistsmpFlag;
	}

	public void setStocklistsmpFlag(String stocklistsmpFlag) {
		this.stocklistsmpFlag = stocklistsmpFlag;
	}
}