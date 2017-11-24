/**
 * auto-generated code
 * Tue Jun 05 08:32:39 CST 2012
 */
 package com.gmcc.pboss.web.channel.checkedapplystat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyDBParam;
import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyVO;
import com.gmcc.pboss.business.channel.checkedapply.ViewCDDetailVO;
import com.gmcc.pboss.business.channel.checkedapply.ViewCDVO;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailDBParam;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.checkedapply.Checkedapply;
import com.gmcc.pboss.control.channel.checkedapply.CheckedapplyBO;
import com.gmcc.pboss.control.channel.checkedapplydetail.Checkedapplydetail;
import com.gmcc.pboss.control.channel.checkedapplydetail.CheckedapplydetailBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: CheckedapplyAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class CheckedapplyStatAction extends BaseAction{
	private static final Long APPSTATUS_SYSID = 83L;
	private static final String APPSTATUS_SYSTYPE = "channel";
	public CheckedapplyStatAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new CheckedapplyForm());
		this.setParam(new CheckedapplyDBParam());

        //指定VO类
        setClsVO(CheckedapplyVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"applyno"};
		this.setClsControl(Checkedapply.class);
		this.setClsQueryParam(CheckedapplyDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	private boolean hasMutilAppstauts()throws Exception{
		Sysparam sysBO = (Sysparam)BOFactory.build(SysparamBO.class, this.getDBAccessUser());
		String sysvalue = sysBO.doFindByID(APPSTATUS_SYSID, APPSTATUS_SYSTYPE);
		if(sysvalue!=null && "1".equals(sysvalue.trim())){
			//当系统参数为（systemid=83, paramtype=’channel’)并且值为1时，申请状态固定参数用【CH_APPSTATUS_GZ】
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		try{
			Checkedapply checkedapplyBO = (Checkedapply) BOFactory.build(CheckedapplyBO.class, getDBAccessUser());
			CheckedapplyDBParam checkedapplyDBParam = (CheckedapplyDBParam)getParam();
			if(this.hasMutilAppstauts()){//当系统参数为（systemid=83, paramtype=’channel’)并且值为1时，申请状态固定参数用【CH_APPSTATUS_GZ】				
				checkedapplyDBParam.setAPPSTATUS_MULTI(true);
			}else{
				checkedapplyDBParam.setAPPSTATUS_MULTI(false);
			}
			checkedapplyDBParam.set_se_cityid(this.getDBAccessUser().getCityid());//仅能查询工号所属地市数据
			//默认按当天的起始时间查询
			if(null == checkedapplyDBParam.get_dnl_aptime() )
				checkedapplyDBParam.set_dnl_aptime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00");
			if(null == checkedapplyDBParam.get_dnm_aptime() )
				checkedapplyDBParam.set_dnm_aptime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 23:59:59");
			
			DataPackage temPackage = checkedapplyBO.doQueryCheckedapplyStat(checkedapplyDBParam);
			
			this.setDp(temPackage);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return WEB_RESULT_LIST;
	}
	
	public String doListdetail() throws Exception {
		CheckedapplyDBParam checkedapplyDBParam = (CheckedapplyDBParam)this.getParam();		
		WayDBParam wayDBParam = new WayDBParam();
		BeanUtils.copyProperties(wayDBParam, checkedapplyDBParam);
		
		String queryRange = checkedapplyDBParam.getQueryRange();
		DataPackage temPackage = null;
		
		if(checkedapplyDBParam.isExcel()){
			wayDBParam.setQueryAll(true);
		}else{
			wayDBParam.set_pagesize("20");
		}
		wayDBParam.getQueryConditions().put("cityid", getDBAccessUser().getCityid());
		Checkedapply checkedapplyBO = (Checkedapply) BOFactory.build(CheckedapplyBO.class, getDBAccessUser());
		if("all".equals(queryRange)){//全部
			temPackage = checkedapplyBO.doQueryByNamedSqlQueryWay("queryQueryRangeAll",wayDBParam);
		}else if("add".equals(queryRange)){//新增
			//wayDBParam.setSelectFieldsString("wayid");CheckedapplydetailBO
			Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
			CheckedapplydetailDBParam checkedapplydetailDBParam = new CheckedapplydetailDBParam();
			checkedapplydetailDBParam.setQueryAll(true);
			DataPackage cadDP = checkedapplydetailBO.doQuery(checkedapplydetailDBParam);
			ArrayList<String> wayidList = new ArrayList<String>();
			Map<String, String> wayidMap = new HashMap<String, String>();
			if(cadDP != null && !"".equals(cadDP)){
				List datas = cadDP.getDatas();
				
				if(datas != null && !"".equals(datas) && datas.size()>0){
					for(int i=0 ; i<datas.size() ; i++){
						CheckedapplydetailVO checkedapplydetailVO = (CheckedapplydetailVO)datas.get(i);
						String wayid = checkedapplydetailVO.getWayid();
						if(!wayidMap.containsKey(wayid)){
							wayidList.add(wayid);
							wayidMap.put(wayid, wayid);
						}
					}
				}
			}
			wayDBParam.set_sin_wayid(wayidList);
			
			temPackage = checkedapplyBO.doQueryByNamedSqlQueryWay("queryQueryRangeAll",wayDBParam);
		}
		
		setDp(temPackage);
		return WEB_RESULT_CONTENT;
	}
	
	//导出Excel
	public String doExportExcel(){
		try{
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			
			super.getParam().setQueryAll(true);
			export.setFileName("授权网点统计");
			
			export.voClassArray = new Class[] {ViewCDVO.class};
			export.queryMethodName = "doQueryCheckedapplyStat";
			
			export.addOutputProperty("cityid", "地市公司",export.CODE2NAME,"#CITYCOMPANY");
			export.addOutputProperty("applytype", "申请类型",export.CODE2NAME,"$CH_CHECKTYPE");
			if(this.hasMutilAppstauts()){//当系统参数为（systemid=83, paramtype=’channel’)并且值为1时，申请状态固定参数用【CH_APPSTATUS_GZ】				
				export.addOutputProperty("status", "申请状态",export.CODE2NAME,"$CH_APPSTATUS_GZ");
			}else{
				export.addOutputProperty("status", "申请状态",export.CODE2NAME,"$CH_APPSTATUS");
			}			
			export.addOutputProperty("istopstat", "目标渠道数");
			export.addOutputProperty("nettypestat", "省级核心连锁数");
			export.addOutputProperty("nettype1stat", "有潜力网点数");
			export.addOutputProperty("statstat", "合计");
			
			//export.wri
			this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			super.doExcel();
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	//导出Excel明细
	public String doExportExcelDetail(){
		try{
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			
			super.getParam().setQueryAll(true);
			export.setFileName("导出Excel明细");
			
			export.voClassArray = new Class[] {ViewCDDetailVO.class};
			export.queryMethodName = "doQueryCheckedapplyDetail";
			
			export.addOutputProperty("cityid", "地市公司",export.CODE2NAME,"#CITYCOMPANY");
			export.addOutputProperty("applytype", "申请类型",export.CODE2NAME,"$CH_CHECKTYPE");
			if(this.hasMutilAppstauts()){//当系统参数为（systemid=83, paramtype=’channel’)并且值为1时，申请状态固定参数用【CH_APPSTATUS_GZ】				
				export.addOutputProperty("status", "申请状态",export.CODE2NAME,"$CH_APPSTATUS_GZ");
			}else{
				export.addOutputProperty("status", "申请状态",export.CODE2NAME,"$CH_APPSTATUS");
			}		
			export.addOutputProperty("istop", "网点类型");
			export.addOutputProperty("wayid", "渠道编码");
			export.addOutputProperty("wayname", "渠道名称");
			export.addOutputProperty("countyid", "分公司编码");
			export.addOutputProperty("oprtime", "审核时间");
			export.addOutputProperty("oprcode2", "审核人");
			if(this.hasMutilAppstauts()){//当系统参数为（systemid=83, paramtype=’channel’)并且值为1时，网点审核状态固定参数用【$CH_WAYSTATUS_GZ】				
				export.addOutputProperty("waystatus", "网点审核状态",export.CODE2NAME,"$CH_WAYSTATUS_GZ");
			}else{
				export.addOutputProperty("waystatus", "网点审核状态",export.CODE2NAME,"$CH_WAYSTATUS");
			}
			export.addOutputProperty("oprcode", "申请工号");
			//export.addOutputProperty("wtype", "网点类型",export.CODE2NAME,"$CH_WTYPE");
			export.addOutputProperty("chktype", "考核方式",export.CODE2NAME,"$CH_ASSESSMTHD");
						
			//export.wri
			this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			super.doExcel();
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	public String doQueryCheckedapplyDetail() throws Exception {
		try {
			CheckedapplyDBParam checkedapplyDBParam = (CheckedapplyDBParam)getParam();
			
			//全量查询
			checkedapplyDBParam.setQueryAll(true);
			
			Checkedapply checkedapplyBO = (Checkedapply) BOFactory.build(CheckedapplyBO.class, getDBAccessUser());
			DataPackage temPackage = checkedapplyBO.doQueryCheckedapplyDetail(checkedapplyDBParam);
			
			setDp(temPackage);
		} catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
		}
		return "list";
	}
	
	public String doQueryCheckedapplyStat() throws Exception {
		try {
			CheckedapplyDBParam checkedapplyDBParam = (CheckedapplyDBParam)getParam();
			
			//全量查询
			checkedapplyDBParam.setQueryAll(true);
			
			Checkedapply checkedapplyBO = (Checkedapply) BOFactory.build(CheckedapplyBO.class, getDBAccessUser());
			DataPackage temPackage = checkedapplyBO.doQueryCheckedapplyStat(checkedapplyDBParam);
			
			setDp(temPackage);
		} catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
		}
		return "list";
	}
	
	public String doExportExcelWay(){
		try{
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			
			super.getParam().setQueryAll(true);
			export.setFileName("查看已授权网点数据");
			
			export.voClassArray = new Class[] {WayVO.class};
			export.queryMethodName = "doListdetail";
			CheckedapplyDBParam checkedapplyDBParam = (CheckedapplyDBParam)this.getParam();
			//全量查询
			checkedapplyDBParam.setExcel(true);
			
			export.addOutputProperty("wayid", "渠道编码");
			export.addOutputProperty("wayname", "渠道名称");
			export.addOutputProperty("waysubtype", "零售渠道类别",export.CODE2NAME,"WAYSUBTYPE");
			export.addOutputProperty("upperwayid", "上级渠道",export.CODE2NAME,"#WAY");
			export.addOutputProperty("latitude", "地理纬度");
			
			export.addOutputProperty("longtitude", "地理经度");
			export.addOutputProperty("starlevel", "星级",export.CODE2NAME,"$CH_STARLEVEL");
			export.addOutputProperty("pt", "排他性",export.CODE2NAME,"$CH_PT");
			export.addOutputProperty("isstraitprd", "是否直供",export.CODE2NAME,"$CH_STRAITPRD");
			export.addOutputProperty("catetype", "连锁性质",export.CODE2NAME,"$CH_CATETYPE");
			export.addOutputProperty("cityid", "地市公司",export.CODE2NAME,"#CITYCOMPANY");
			
			export.addOutputProperty("countyid", "分公司",export.CODE2NAME,"#CNTYCOMPANY");
			export.addOutputProperty("svccode", "服务销售中心",export.CODE2NAME,"#SERVCENT");
			export.addOutputProperty("mareacode", "微区域",export.CODE2NAME,"#MICROAREA");
			export.addOutputProperty("adtypecode", "区域类型",export.CODE2NAME,"$CH_ADTYPE");
			export.addOutputProperty("adacode", "行政区划",export.CODE2NAME,"#ADIMAREA");
			export.addOutputProperty("formtype", "业态类型",export.CODE2NAME,"$CH_FORMTYPE");
			
			export.addOutputProperty("starttime", "申请时间");
			export.addOutputProperty("logiscode", "所属物流商");
			export.addOutputProperty("waymagcode", "所属渠道经理");
			export.addOutputProperty("bchlevel", "分级",export.CODE2NAME,"$CH_BCHLEVEL");
			export.addOutputProperty("waystate", "渠道状态",export.CODE2NAME,"$CH_WAYSTATE");
			export.addOutputProperty("address", "详细地址");
			
			/*export.addOutputProperty("cityid", "地市公司",export.CODE2NAME,"#CITYCOMPANY");
			export.addOutputProperty("applytype", "申请类型",export.CODE2NAME,"$CH_CHECKTYPE");
			export.addOutputProperty("status", "申请状态",export.CODE2NAME,"$CH_APPSTATUS");
			export.addOutputProperty("istopstat", "目标渠道数");
			export.addOutputProperty("nettypestat", "省级核心连锁数");
			export.addOutputProperty("nettype1stat", "有潜力网点数");
			export.addOutputProperty("statstat", "合计");*/
			
			//export.wri
			this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			super.doExcel();
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
}