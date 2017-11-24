/**
 * auto-generated code
 * Tue Jul 27 12:08:11 CST 2010
 */
 package com.gmcc.pboss.web.resource.stkalarmstat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.resource.stkalarmstat.StkalarmstatDBParam;
import com.gmcc.pboss.business.resource.stkalarmstat.StkalarmstatVO;
import com.gmcc.pboss.business.resource.stkalarmstat.StkalarmstatshowVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.resource.stkalarmstat.Stkalarmstat;
import com.gmcc.pboss.control.resource.stkalarmstat.StkalarmstatBO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: StkalarmstatAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class StkalarmstatAction extends BaseAction{
	
	public StkalarmstatAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new StkalarmstatForm());
		this.setParam(new StkalarmstatWebParam());

        //指定VO类
        setClsVO(StkalarmstatVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Stkalarmstat.class);
		this.setClsQueryParam(StkalarmstatDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	//网点预警信息明细查询
	public String doListdetail() throws Exception {
		// TODO Auto-generated method stub
		StkalarmstatDBParam param = (StkalarmstatDBParam) getParam();
		StkalarmstatForm form = (StkalarmstatForm) getForm();
		if(StringUtils.isBlank(form.getIsgiveup()))
			form.setIsgiveup("0");
		Stkalarmstat stkalarmstat = (Stkalarmstat) BOFactory.build(
				StkalarmstatBO.class, getDBAccessUser());
		DataPackage dp = new DataPackage();
		List<StkalarmstatVO> stkalarmstatList = new ArrayList<StkalarmstatVO>();
		if ("1".equals(form.getIsgiveup())) {
			dp = stkalarmstat.doQueryDetails1(param);
			List<StkalarmstatVO> list = dp.getDatas();
			for (StkalarmstatVO vo : list) {
				vo.setIsgiveup("1");
				stkalarmstatList.add(vo);
			}
		} else if ("0".equals(form.getIsgiveup())) {
			dp = stkalarmstat.doQueryDetails2(param);
			List<StkalarmstatVO> list = dp.getDatas();
			for (StkalarmstatVO vo : list) {
				vo.setIsgiveup("0");
				stkalarmstatList.add(vo);
			}
		}
		dp.setDatas(stkalarmstatList);
		setDp(dp);
		setForm(form);
		return "list";
	}
	
	//网点预警信息明细导出Excel
	public String doExceldetail() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		export.setFileName("网点预警信息明细");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间",format.format(new Date()) });
		export.addOutputProperty("seqid", "序号");
		export.addOutputProperty("alarmdate", "预警日期",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("wayid", "分销商标识");
		export.addOutputProperty("wayid", "分销商名称",export.CODE2NAME, "#WAY");
		export.addOutputProperty("brand", "品牌",export.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("alarmlevel", "预警级别",export.CODE2NAME, "$FX_STOCKALARMLEVEL");
		export.addOutputProperty("crtstock", "当时库存");
		export.addOutputProperty("orderid", "订单编号");
		export.addOutputProperty("isgiveup", "主动放弃", export.CODE2NAME, "$IM_YESNO10");
		export.voClassArray = new Class[] { StkalarmstatVO.class };
		export.queryMethodName = "doListdetail";
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		StkalarmstatDBParam param=(StkalarmstatDBParam)super.getParam();
		param.set_pagesize("0");
		super.setParam(param);
		return super.doExcel();
	}
	
	//网点预警信息明细导出txt
	public String doTxtdetail() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点预警信息明细");
		export.addOutputProperty("seqid", "序号");
		export.addOutputProperty("alarmdate", "预警日期",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("wayid", "分销商标识");
		export.addOutputProperty("wayid", "分销商名称",export.CODE2NAME, "#WAY");
		export.addOutputProperty("brand", "品牌",export.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("alarmlevel", "预警级别",export.CODE2NAME, "$FX_STOCKALARMLEVEL");
		export.addOutputProperty("crtstock", "当时库存");
		export.addOutputProperty("orderid", "订单编号");
		export.addOutputProperty("isgiveup", "主动放弃", export.CODE2NAME, "$IM_YESNO10");
		export.voClassArray = new Class[] { StkalarmstatVO.class };
		export.queryMethodName = "doListdetail";
		
		prepareResponse(export.getFileName());
		StkalarmstatDBParam param=(StkalarmstatDBParam)super.getParam();
		param.set_pagesize("0");
		super.setParam(param);
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"序号","预警日期","分销商标识", "分销商名称", "品牌", "预警级别" ,"当时库存","订单编号","主动放弃"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	//网点预警信息统计
	public String doListstat() throws Exception {
		try {
			StkalarmstatDBParam params = (StkalarmstatDBParam) getParam();
			StkalarmstatForm form = (StkalarmstatForm)getForm();
			Stkalarmstat stkalarmstat = (Stkalarmstat) BOFactory.build(
					StkalarmstatBO.class, getDBAccessUser());
			DataPackage dp = stkalarmstat.doQueryStat(params);
			setDp(dp);
			Long totalred = 0L;
			Long totalyellow = 0L;
			List<StkalarmstatshowVO> list = dp.getDatas();
			for(StkalarmstatshowVO vo : list){
				Long redalarm = vo.getRedalarm();
				Long yelalarm = vo.getYelalarm();
				totalred = totalred + redalarm;
				totalyellow = totalyellow + yelalarm;
			}
			form.setTotalred(totalred);
			form.setTotalyellow(totalyellow);
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		return "stat";
	}
	
	//网点预警信息统计导出Excel
	public String doExcelstat() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		export.setFileName("网点预警信息统计");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间",format.format(new Date()) });
		//export.addOutputProperty("seqid", "序号");
		export.addOutputProperty("countyid", "分公司",export.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "微区域",export.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("redalarm", "红色预警");
		export.addOutputProperty("yelalarm", "黄色预警");
		export.voClassArray = new Class[] { StkalarmstatshowVO.class };
		export.queryMethodName = "doListstat";
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		StkalarmstatDBParam param=(StkalarmstatDBParam)super.getParam();
		param.set_pagesize("0");
		super.setParam(param);
		return super.doExcel();
	}
	
	//网点预警信息统计导出txt
	public String doTxtstat() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("网点预警信息统计");
		//export.addOutputProperty("seqid", "序号");
		export.addOutputProperty("countyid", "分公司",export.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "微区域",export.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("redalarm", "红色预警");
		export.addOutputProperty("yelalarm", "黄色预警");
		export.voClassArray = new Class[] { StkalarmstatshowVO.class };
		export.queryMethodName = "doListstat";
		
		prepareResponse(export.getFileName());
		StkalarmstatDBParam param=(StkalarmstatDBParam)super.getParam();
		param.set_pagesize("0");
		super.setParam(param);
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"分公司","微区域","红色预警", "黄色预警"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
}