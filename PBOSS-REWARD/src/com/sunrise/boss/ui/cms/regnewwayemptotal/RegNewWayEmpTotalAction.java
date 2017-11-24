/**
* auto-generated code
* Thu Feb 24 15:31:21 CST 2011
*/
package com.sunrise.boss.ui.cms.regnewwayemptotal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.regnewwayemp.persistent.RegNewWayEmpListVO;
import com.sunrise.boss.business.cms.regnewwayemp.persistent.RegNewWayEmpVO;
import com.sunrise.boss.business.cms.regnewwayemptotal.persistent.RegNewWayEmpTotalListVO;
import com.sunrise.boss.business.cms.regnewwayemptotal.persistent.RegNewWayEmpTotalVO;
import com.sunrise.boss.business.cms.reward.operationsms.persistent.OperationsmsListVO;
import com.sunrise.boss.business.cms.reward.operationsms.persistent.OperationsmsVO;
import com.sunrise.boss.business.cms.reward.registersimvw.persistent.RegistersimvwListVO;
import com.sunrise.boss.business.cms.reward.registersimvw.persistent.RegistersimvwVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.regnewwayemp.RegNewWayEmpDelegate;
import com.sunrise.boss.delegate.cms.regnewwayemptotal.RegNewWayEmpTotalDelegate;
import com.sunrise.boss.delegate.cms.reward.operationsms.OperationsmsDelegate;
import com.sunrise.boss.delegate.cms.reward.registersimvw.RegistersimvwDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.cms.regnewwayemp.RegNewWayEmpForm;
import com.sunrise.boss.ui.cms.reward.registersimcnt.RegistersimcntForm;
import com.sunrise.boss.ui.cms.reward.registersimvw.RegistersimvwForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.pub.tools.PublicUtils;

/**
 * <p>Title: RegNewWayEmpTotalAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class RegNewWayEmpTotalAction extends BaseAction {
    public RegNewWayEmpTotalAction() {
            setVoClass(RegNewWayEmpTotalVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[3]; 
           pkNameArray[0] = "countyid"; 
           pkNameArray[1] = "starlevel"; 
           pkNameArray[2] = "wayid"; 
    }
    
    public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		((RegNewWayEmpTotalForm) actionForm).set_dnl_oprtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00");
		((RegNewWayEmpTotalForm) actionForm).set_dnm_oprtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 23:59:59");
		
		return doList(actionMapping, actionForm, request, response, user);
	}
    
    @Override
	public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception{		
    	RegNewWayEmpTotalForm param=(RegNewWayEmpTotalForm)actionForm;
		
		// 从明细返回参数处理
		if (request.getParameter("flg") != null 
				&& "true".equals(request.getParameter("flg"))) {
			//list页面没有starlevel的查询条件,所以没有必要置空.
			param.set_orderby(null);
			param.set_se_wayid(null);
			param.set_se_countyid(null);
		}
		
		String starttimeStr = param.get_dnl_oprtime();
		String endtimeStr = param.get_dnm_oprtime();
		
		// 登记起始时间＆登记结束时间不能超出３１天
		if(!StringUtils.isEmpty(starttimeStr)&&!StringUtils.isEmpty(endtimeStr))
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date startdate = format.parse(starttimeStr);
			Date enddate = format.parse(endtimeStr);
			int diff = operationDate(enddate, startdate);
			if(diff>30)
			{
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "登记起始时间＆登记结束时间不能超出31天。");
				return (actionMapping.findForward("list"));
			}
		}
		
		
		
		DataPackage dp = null;
		try{
			RegNewWayEmpTotalDelegate empTotal=new RegNewWayEmpTotalDelegate();
			RegNewWayEmpTotalListVO empTotalListVO =new RegNewWayEmpTotalListVO();
			setListVO(empTotalListVO,actionForm);
			dp = empTotal.doQuery(empTotalListVO,user);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("list"));
	}
    
    
    
    public ActionForward doSelectlist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{		
		RegNewWayEmpTotalForm param = (RegNewWayEmpTotalForm)actionForm;
		RegNewWayEmpForm paramvw = new RegNewWayEmpForm();
		BeanUtils.copyProperties(paramvw, param);
		if (request.getParameter("wayid") != null) {
			paramvw.set_se_wayid(request.getParameter("wayid"));
		}
		if (request.getParameter("countyid") != null) {
			paramvw.set_se_countyid(request.getParameter("countyid"));
		}
		if (request.getParameter("starlevel") != null) {
			paramvw.set_ne_starlevel(request.getParameter("starlevel"));
		}
		BeanUtils.copyProperties(param, paramvw);
		if (request.getParameter("flg") != null 
				&& "false".equals(request.getParameter("flg"))) {
			paramvw.set_orderby(null);
			paramvw.set_pageno("1");
		}
		
		DataPackage dp = null;
		try{
			RegNewWayEmpDelegate regNewWayEmpDelegate = new RegNewWayEmpDelegate();
			RegNewWayEmpListVO listvo = new RegNewWayEmpListVO();
			setListVO(listvo,paramvw);
			dp = regNewWayEmpDelegate.doQuery(listvo,user);
			// 解包
			Iterator it = dp.getDatas().iterator();
			// 取得业务编码名称
			while (it.hasNext()) {
				RegNewWayEmpVO revo = (RegNewWayEmpVO)(it.next());
				String opnid = revo.getOpnid();
				OperationsmsDelegate operationsmsdlg = new OperationsmsDelegate();
				OperationsmsListVO optParam = new OperationsmsListVO();
				optParam.set_se_opntype("2");
				optParam.set_se_smsno("10086111");
//				optParam.set_se_cityid(user.getCityid());
				optParam.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
				optParam.set_se_opnid(opnid);
				DataPackage dp2 = operationsmsdlg.doQuery(optParam,user);
				// 解包
				Iterator itor = dp2.getDatas().iterator();
				while (itor.hasNext()) {
					OperationsmsVO opvo = (OperationsmsVO)(itor.next());
					String opnidname = opvo.getOpnname();
					if (StringUtils.isEmpty(opnidname) || opnidname == null) {
						revo.setOpnname(opnid);
					} else {
						revo.setOpnname(opnidname);
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("selectlist"));
	}
    
    
    
    /**
	 * 导出Excel文件
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("新业务登记汇总");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:",format.format(new Date()) });
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("countyid", "分公司",export.CODE2NAME, "#CNTYCOMPANY");
		//星级
		export.addOutputProperty("starlevel", "星级",export.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("amt", "数量");
					
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		
		export.voClassArray = new Class[] { voClass };
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
		
		return actionMapping.findForward(null);
	}
    
    
    /**
	 * 日期相加、减操作
	 * 
	 * 所返回结果单位为:天数
	 */
	public static int operationDate(Date date, Date diffDate) {
		long diff = getMillis(date) - getMillis(diffDate);
		return (int) (diff / (24 * 3600 * 1000));
	}
	
	/**
	 * 获取指定日期的毫秒数
	 */
	public static long getMillis(Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}
    
}
