/**
 * auto-generated code
 * Thu Jan 26 11:26:19 CST 2012
 */
 package com.gmcc.pboss.web.sales.sellnotice;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.sellnotice.SellnoticeDBParam;
import com.gmcc.pboss.business.sales.sellnotice.SellnoticeVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.sales.sellnotice.Sellnotice;
import com.gmcc.pboss.control.sales.sellnotice.SellnoticeBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: SellnoticeAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class SellnoticeAction extends BaseAction{
	
	public SellnoticeAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new SellnoticeForm());
		this.setParam(new SellnoticeDBParam());

        //指定VO类
        setClsVO(SellnoticeVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Sellnotice.class);
		this.setClsQueryParam(SellnoticeDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	//网点销售进度查询
	public String doWayList() {
		try{
			super.doList();
			DataPackage tmp = super.getDp();
			
			Sellnotice sellnoticeBO = (SellnoticeBO)BOFactory.build(SellnoticeBO.class,this.getDBAccessUser());
			tmp = sellnoticeBO.doWayList(tmp);
			
			this.setDp(tmp);
		}catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return "wayList";
	}
	
	//渠道经理销售进度查询
	public String doWayMagList() {
		try{
			param.setDataOnly(true);
			param.set_pagesize("0");
			super.doList();
			DataPackage tmp = super.getDp();
			
			Sellnotice sellnoticeBO = (SellnoticeBO)BOFactory.build(SellnoticeBO.class,this.getDBAccessUser());
			tmp = sellnoticeBO.doWayMagList(tmp);
			
			this.setDp(tmp);
		}catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return "wayMagList";
	}
	
	//微区域销售进度查询
	public String doMareacodeList() {
		try{
			param.setDataOnly(true);
			param.set_pagesize("0");
			super.doList();
			DataPackage tmp = super.getDp();
			
			Sellnotice sellnoticeBO = (SellnoticeBO)BOFactory.build(SellnoticeBO.class,this.getDBAccessUser());
			tmp = sellnoticeBO.doMareacodeList(tmp);
			
			this.setDp(tmp);
		}catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return "mareacodeList";
	}
	
	//分公司销售进度查询
	public String doCountyList() {
		try{
			param.setDataOnly(true);
			param.set_pagesize("0");
			super.doList();
			DataPackage tmp = super.getDp();
			
			Sellnotice sellnoticeBO = (SellnoticeBO)BOFactory.build(SellnoticeBO.class,this.getDBAccessUser());
			tmp = sellnoticeBO.doCountyList(tmp);
			
			this.setDp(tmp);
		}catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return "countyList";
	}
	
	public String doWayExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", PublicUtils.utilDateToStr(new Date()) });
		
		export.queryMethodName = "doWayList";
		
		export.setFileName("网点销售进度查询");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayid", "网点名称", export.CODE2NAME,
			"#WAYIDINFO");
		export.addOutputProperty("countyid", "分公司", export.CODE2NAME,
			"#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "微区域", export.CODE2NAME,
			"#MICROAREA");
		export.addOutputProperty("starlevel", "星级", export.CODE2NAME,
			"$CH_STARLEVEL");
		export.addOutputProperty("sellcount", "销售量");
		export.addOutputProperty("salesstd", "考核值");
		export.addOutputProperty("comrate", "完成率（%）");
		
		export.voClassArray = new Class[] { SellnoticeVO.class };
		SellnoticeDBParam params = (SellnoticeDBParam) super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	public String doWayMagExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", PublicUtils.utilDateToStr(new Date()) });
		
		export.queryMethodName = "doWayMagList";
		
		export.setFileName("渠道经理销售进度查询");
		export.addOutputProperty("countyid", "分公司", export.CODE2NAME,
			"#CNTYCOMPANY");
		export.addOutputProperty("waymagcode", "渠道经理", export.CODE2NAME,
			"#EMPLOYEE");
		export.addOutputProperty("sellcount", "销售量");
		export.addOutputProperty("salesstd", "考核值");
		export.addOutputProperty("comrate", "完成率（%）");
		
		export.voClassArray = new Class[] { SellnoticeVO.class };
		SellnoticeDBParam params = (SellnoticeDBParam) super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	public String doMareacodeExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", PublicUtils.utilDateToStr(new Date()) });
		
		export.queryMethodName = "doMareacodeList";
		
		export.setFileName("微区域销售进度查询");
		export.addOutputProperty("countyid", "分公司", export.CODE2NAME,
			"#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "微区域", export.CODE2NAME,
			"#MICROAREA");
		export.addOutputProperty("sellcount", "销售量");
		export.addOutputProperty("salesstd", "考核值");
		export.addOutputProperty("comrate", "完成率（%）");
		
		export.voClassArray = new Class[] { SellnoticeVO.class };
		SellnoticeDBParam params = (SellnoticeDBParam) super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	public String doCountyExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", PublicUtils.utilDateToStr(new Date()) });
		
		export.queryMethodName = "doCountyList";
		
		export.setFileName("分公司销售进度查询");
		export.addOutputProperty("countyid", "分公司", export.CODE2NAME,
			"#CNTYCOMPANY");
		export.addOutputProperty("sellcount", "销售量");
		export.addOutputProperty("salesstd", "考核值");
		export.addOutputProperty("comrate", "完成率（%）");
		
		export.voClassArray = new Class[] { SellnoticeVO.class };
		SellnoticeDBParam params = (SellnoticeDBParam) super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
}