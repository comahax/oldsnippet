package com.gmcc.pboss.web.resource.wayrcstat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.resource.wayrcstat.WayrcstatDBParam;
import com.gmcc.pboss.business.resource.wayrcstat.WayrcstatVO;
import com.gmcc.pboss.business.resource.wayrcstat.WayrcstatVO2;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.resource.wayrcstat.Wayrcstat;
import com.gmcc.pboss.control.resource.wayrcstat.WayrcstatBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * 此Action类对应了两个界面操作: 1.网点资源信息统计(实时) 2.网点资源信息统计(历史)
 * 
 * 此Action未设置VO类, 因为没有CRUD操作, 只有查询, 并且是关联查询;
 * 在导出时, 需要设置相应的doList方法, 并设置相应的VO类
 * 
 * @author liang.qichao
 * @since 20100817
 *
 */
public class WayrcstatAction extends BaseAction {

	public WayrcstatAction() {
		super();

		//以下几个方法是必须的
//		this.setForm(new WayrcstatForm());
		this.setParam(new WayrcstatDBParam());

        //指定VO类
//        setClsVO(WayrcstatVO.class);
//        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
//        this.pkNameArray=new String[]{"seqid"};
//		this.setClsControl(Stkalarmstat.class);
//		this.setClsQueryParam(StkalarmstatDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	// 实时数据统计
	public String doReallist() throws Exception {
		if(this.isQuery){
		Wayrcstat bo = (Wayrcstat) BOFactory.build(WayrcstatBO.class, getDBAccessUser());
		DataPackage dp = bo.doQueryreal(getParam());
		this.setDp(dp);
		}
		return "reallist";
	}
	
	// 历史数据统计
	public String doHistorylist() throws Exception {
		WayrcstatDBParam params = (WayrcstatDBParam) this.getParam();
		if (this.isQuery) {
			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
			Date ldate = myformat.parse(params.get_dnl_statdate());
			Date mdate = myformat.parse(params.get_dnm_statdate());
			Long day = (mdate.getTime() - ldate.getTime()) / (1000 * 60 * 60 * 24);
			if (day > 30) {
				setActionMessage("快照日期间隔不能超过30天。");
				return "historylist";
			}
			Wayrcstat bo = (Wayrcstat) BOFactory.build(WayrcstatBO.class, getDBAccessUser());
			DataPackage dp = bo.doQueryhistory(getParam());
			this.setDp(dp);
		} else {
			String stockdate = PublicUtils.utilDateToStr(queryStockTimeCurrent());
			String currdate = PublicUtils.utilDateToStr(queryStockTime());
			params.set_dnl_statdate(stockdate);
			params.set_dnm_statdate(currdate);
		}
		return "historylist";
	}
	
	// 导出实时数据txt
	public String doExportrealtxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("网点资源信息统计导出(实时)");
		
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "合作商编码");
		export.addOutputProperty("wayname", "合作商名称");
		export.addOutputProperty("brand", "品牌", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("cnt1", "库存量");
		export.addOutputProperty("cnt2", "领货量");
		export.addOutputProperty("cnt3", "激活量");
		
		// 设置VO类
		export.voClassArray = new Class[] { WayrcstatVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doReallist";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"分公司", "微区域", "合作商编码", "合作商名称", "品牌" ,"库存量","领货量","激活量"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	// 导出实时数据xls
	public String doExportrealxls() throws Exception {
		
		// 设置VO类
		//this.setClsVO(WayrcstatVO.class);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		export.setFileName("网点资源信息统计导出(实时)");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });
		
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "合作商编码");
		export.addOutputProperty("wayname", "合作商名称");
		export.addOutputProperty("brand", "品牌", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("cnt1", "库存量");
		export.addOutputProperty("cnt2", "领货量");
		export.addOutputProperty("cnt3", "激活量");
		
		// 设置VO类
		export.voClassArray = new Class[] { WayrcstatVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doReallist";
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		getParam().set_pagesize("0");
		
		return super.doExcel();
	}
	
	// 导出历史数据txt
	public String doExporthistorytxt() throws Exception {
		WayrcstatDBParam params = (WayrcstatDBParam) this.getParam();
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Date ldate = myformat.parse(params.get_dnl_statdate());
		Date mdate = myformat.parse(params.get_dnm_statdate());
		Long day = (mdate.getTime() - ldate.getTime()) / (1000 * 60 * 60 * 24);
		if (day > 30) {
			setActionMessage("快照日期间隔不能超过30天。");
			return "historylist";
		}
		// TODO coding...
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("网点资源信息统计导出(历史)");
		
		export.addOutputProperty("statdate", "快照日期");
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("waymagcode", "渠道经理");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel", "星级",CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("brand", "品牌", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("cnt3", "激活量");		
		export.addOutputProperty("cnt2", "领货量");
		export.addOutputProperty("cnt1", "库存量");
		export.addOutputProperty("maxstock", "最高库存");
		export.addOutputProperty("redvalue", "红色阀值");
		export.addOutputProperty("yelvalue", "黄色阀值");
		export.addOutputProperty("alarmlevel", "预警级别",CommonExportBean.CODE2NAME, "$FX_STOCKALARMLEVEL");
		
		// 设置VO类
		export.voClassArray = new Class[] { WayrcstatVO2.class };
		
		// 设置查询方法
		export.queryMethodName = "doHistorylist";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"快照日期", "分公司", "微区域","渠道经理","网点编码","网点名称","星级","品牌", "激活量", "领货量", "库存量" ,"最高库存","红色阀值","黄色阀值","预警级别"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	// 导出历史数据xls
	public String doExporthistoryxls() throws Exception {
		WayrcstatDBParam params = (WayrcstatDBParam) this.getParam();
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Date ldate = myformat.parse(params.get_dnl_statdate());
		Date mdate = myformat.parse(params.get_dnm_statdate());
		Long day = (mdate.getTime() - ldate.getTime()) / (1000 * 60 * 60 * 24);
		if (day > 30) {
			setActionMessage("快照日期间隔不能超过30天。");
			return "historylist";
		}
		// TODO coding...
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		export.setFileName("网点资源信息统计导出(历史)");
		export.addOutputProperty("statdate", "快照日期");
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("waymagcode", "渠道经理");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel", "星级",CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("brand", "品牌", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("cnt3", "激活量");		
		export.addOutputProperty("cnt2", "领货量");
		export.addOutputProperty("cnt1", "库存量");
		export.addOutputProperty("maxstock", "最高库存");
		export.addOutputProperty("redvalue", "红色阀值");
		export.addOutputProperty("yelvalue", "黄色阀值");
		export.addOutputProperty("alarmlevel", "预警级别",CommonExportBean.CODE2NAME, "$FX_STOCKALARMLEVEL");
		
		// 设置VO类
		export.voClassArray = new Class[] { WayrcstatVO2.class };
		
		// 设置查询方法
		export.queryMethodName = "doHistorylist";
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		getParam().set_pagesize("0");
		
		return super.doExcel();
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
	
}
