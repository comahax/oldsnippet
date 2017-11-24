/**
 * auto-generated code
 * Tue Aug 10 16:43:27 CST 2010
 */
package com.gmcc.pboss.web.resource.stkalarmct;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.stkalarmct.StkalarmctDBParam;
import com.gmcc.pboss.business.resource.stkalarmct.StkalarmctVO;
import com.gmcc.pboss.business.resource.wayrcstat.WayrcstatDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.stkalarmct.Stkalarmct;
import com.gmcc.pboss.control.resource.wayrcstat.Wayrcstat;
import com.gmcc.pboss.control.resource.wayrcstat.WayrcstatBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>
 * Title: StkalarmctAction
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author zhangsiwei
 * @version 1.0
 */
public class StkalarmctAction extends BaseAction {

	public StkalarmctAction() {
		super();

		// 以下几个方法是必须的
		this.setForm(new StkalarmctForm());
		this.setParam(new StkalarmctDBParam());

		// 指定VO类
		setClsVO(StkalarmctVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "seqid" };
		this.setClsControl(Stkalarmct.class);
		this.setClsQueryParam(StkalarmctDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	/**
	 * 导出Excel - By LiZhaoLiang
	 */
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("分公司库存预警");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("seqid", "序号");
		export.addOutputProperty("statdate", "统计日期", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "分公司", export.CODE2NAME,
				"#CNTYCOMPANY");
		export.addOutputProperty("brand", "品牌", export.CODE2NAME,
				"$FX_SMPBRAND");
		export.addOutputProperty("kcamount", "库存量");
		export.addOutputProperty("realstock", "网点实际库存");
		export.addOutputProperty("greenstock", "网点绿色库存");
		export.addOutputProperty("yellowstock", "网点黄色库存");
		export.addOutputProperty("redstock", "网点红色库存");
		export.addOutputProperty("greengap", "绿色缺口");
		export.addOutputProperty("yellowgap", "黄色缺口");
		export.addOutputProperty("redgap", "红色缺口");
		export.addOutputProperty("saleamt", "前"+this.getDay()+"领货量");
		export.addOutputProperty("supportday", "支撑天数");
		export.addOutputProperty("greenstock", "网点绿色库存");
		export.addOutputProperty("isalarm", "是否预警", export.CODE2NAME,
				"$IM_YESNO10");

		export.voClassArray = new Class[] { StkalarmctVO.class };
		StkalarmctDBParam params = (StkalarmctDBParam) super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	/**
	 * 导出TXT - By LiZhaoLiang
	 */
	public String doTxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("分公司库存预警");
		export.addOutputProperty("seqid", "序号");
		export.addOutputProperty("statdate", "统计日期", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "分公司", export.CODE2NAME,
				"#CNTYCOMPANY");
		export.addOutputProperty("brand", "品牌", export.CODE2NAME,
				"$FX_SMPBRAND");
		export.addOutputProperty("kcamount", "库存量");
		export.addOutputProperty("realstock", "网点实际库存");
		export.addOutputProperty("greenstock", "网点绿色库存");
		export.addOutputProperty("yellowstock", "网点黄色库存");
		export.addOutputProperty("redstock", "网点红色库存");
		export.addOutputProperty("greengap", "绿色缺口");
		export.addOutputProperty("yellowgap", "黄色缺口");
		export.addOutputProperty("redgap", "红色缺口");
		export.addOutputProperty("saleamt", "前"+this.getDay()+"领货量");
		export.addOutputProperty("supportday", "支撑天数");
		export.addOutputProperty("greenstock", "网点绿色库存");
		export.addOutputProperty("isalarm", "是否预警", export.CODE2NAME,
				"$IM_YESNO10");
		export.voClassArray = new Class[] { StkalarmctVO.class };
		prepareResponse(export.getFileName());
		StkalarmctDBParam params = (StkalarmctDBParam) super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		export.writeTxtTitle(getResponse().getOutputStream(),
				new String[] { "序号", "统计日期", "分公司", "品牌", "库存量", "网点实际库存","网点绿色库存","网点黄色库存","网点红色库存","绿色缺口","黄色缺口","红色缺口","前"+this.getDay()+"领货量","支撑天数","网点绿色库存", "是否预警" });
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	
	//转list页面但不查询数据
	public String toList() throws Exception{
	
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					getDBAccessUser());
			Serializable pkVO = new SysparamVO();
			BeanUtils.setProperty(pkVO, "systemid", "65");// 系统标识=63
			BeanUtils.setProperty(pkVO, "paramtype", "pboss_fx");// 参数类型==pboss_fx
			SysparamVO vo = sysparam.doFindByPk(pkVO);
			
			User user = (User) getDBAccessUser();
			String wayid = user.getWayid();
			Way way = (Way) BOFactory.build(WayBO.class, user);
			WayVO wayvo = way.doFindByPk(wayid);	
			request.setAttribute("countyidd",  wayvo.getCountyid());
			
			if(vo == null){
				vo = new SysparamVO();
			}
			if (vo != null && !StringUtils.isEmpty(vo.getParamvalue())) {
				String paramvalue = vo.getParamvalue();
				
			}else{
				vo.setParamvalue("7");
			}
			request.setAttribute("paramvalue", vo.getParamvalue());
		} catch (Exception ex) {
			setActionMessage(ex.getMessage());
		}
		
		StkalarmctDBParam params =	(StkalarmctDBParam)this.getParam();
	
		
		if(StringUtils.isEmpty(params.get_dnl_statdate())&&StringUtils.isEmpty(params.get_dnm_statdate())){
			String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyy-MM-dd")+" 00:00:00";
			String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyy-MM-dd")+" 23:59:59";
			params.set_dnl_statdate(stockdate);
			params.set_dnm_statdate(currdate);
		}
		
		
		return WEB_RESULT_LIST;
	}

	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					getDBAccessUser());
			Serializable pkVO = new SysparamVO();
			BeanUtils.setProperty(pkVO, "systemid", "65");// 系统标识=63
			BeanUtils.setProperty(pkVO, "paramtype", "pboss_fx");// 参数类型==pboss_fx
			SysparamVO vo = sysparam.doFindByPk(pkVO);
			if(vo == null){
				vo = new SysparamVO();
			}
			if (vo != null && !StringUtils.isEmpty(vo.getParamvalue())) {
				String paramvalue = vo.getParamvalue();
			}else{
				vo.setParamvalue("7");
			}
			request.setAttribute("paramvalue", vo.getParamvalue());
		} catch (Exception ex) {
			setActionMessage(ex.getMessage());
		}
		
		StkalarmctDBParam params =	(StkalarmctDBParam)this.getParam();
	
		if(params.get_dnl_statdate()==null||params.get_dnl_statdate().equals("")||params.get_dnm_statdate()==null||params.get_dnm_statdate().equals("")){
			
			setActionMessage("库存时间不能为空！");
			return WEB_RESULT_LIST;
		}
		
		
		if(StringUtils.isEmpty(params.get_dnl_statdate())&&StringUtils.isEmpty(params.get_dnm_statdate())){
//			String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyy-MM-dd")+" 00:00:00";
//			String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyy-MM-dd")+" 23:59:59";
//			params.set_dnl_statdate(stockdate);
//			params.set_dnm_statdate(currdate);
		}else{
			Date ldate = new Date();
			Date mdate = new Date();
			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
			ldate = myformat.parse(params.get_dnl_statdate());
			mdate = myformat.parse(params.get_dnm_statdate());
			Long day = (mdate.getTime() - ldate.getTime())/(1000*60*60*24);
			if(day>30){
				setActionMessage("库存时间间隔不能超过30天。");
				return WEB_RESULT_LIST;
			}
		}
//		String s = super.doList();
//		DataPackage dp = this.getDp();
		return super.doList();
	}
	
	private Date queryStockTimeCurrent() throws Exception {
		Calendar stocktime = Calendar.getInstance();
		stocktime.add(Calendar.DAY_OF_MONTH, 00);
		stocktime.set(Calendar.HOUR_OF_DAY, 00);
		stocktime.set(Calendar.MINUTE, 00);
		stocktime.set(Calendar.SECOND, 00);
		return stocktime.getTime();
	}
	
	private Date queryStockTime() throws Exception {
		Calendar stocktime = Calendar.getInstance();
		stocktime.add(Calendar.DAY_OF_MONTH,00);
		stocktime.set(Calendar.HOUR_OF_DAY, 23);
		stocktime.set(Calendar.MINUTE, 59);
		stocktime.set(Calendar.SECOND, 59);
		return stocktime.getTime();
	}
	
	//获取库存领货量
	private int getDay() throws Exception{
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					getDBAccessUser());
			Serializable pkVO = new SysparamVO();
			BeanUtils.setProperty(pkVO, "systemid", "65");// 系统标识=63
			BeanUtils.setProperty(pkVO, "paramtype", "pboss_fx");// 参数类型==pboss_fx
			SysparamVO vo = sysparam.doFindByPk(pkVO);
			if(vo == null){
				return 7;
			}
			if (vo != null && !StringUtils.isEmpty(vo.getParamvalue())) {
				return Integer.parseInt(vo.getParamvalue());
				
			}else{
				return 7;
			}
	}
}