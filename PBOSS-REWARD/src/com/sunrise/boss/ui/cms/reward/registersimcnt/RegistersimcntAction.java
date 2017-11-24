/**
* auto-generated code
* Mon Feb 21 10:37:21 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.registersimcnt;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.registersimcnt.persistent.RegistersimcntListVO;
import com.sunrise.boss.business.cms.reward.registersimcnt.persistent.RegistersimcntVO;
import com.sunrise.boss.business.cms.reward.registersimvw.persistent.RegistersimvwListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.reward.registersimcnt.RegistersimcntDelegate;
import com.sunrise.boss.delegate.cms.reward.registersimvw.RegistersimvwDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.cms.reward.registersimvw.RegistersimvwForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.pub.tools.PublicUtils;

/**
 * <p>Title: RegistersimcntAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class RegistersimcntAction extends BaseDelegateAction {
    public RegistersimcntAction() {
            setVoClass(RegistersimcntVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seqid"; 
    }
    
	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		((RegistersimcntForm) actionForm).set_dnl_oprtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00");
		((RegistersimcntForm) actionForm).set_dnm_oprtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 23:59:59");
		
//		return doList(actionMapping, actionForm, request, response, user);
		request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		return (actionMapping.findForward("list"));
	}
	
	public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception{		
		RegistersimcntForm param = (RegistersimcntForm)actionForm;
		String starttimeStr = param.get_dnl_oprtime();
		String endtimeStr = param.get_dnm_oprtime();
		String starttimeStr1 = param.get_dnl_activedate();
		String endtimeStr1 = param.get_dnm_activedate();
		// ����ϸ���ز�������
		if (request.getParameter("flg") != null 
				&& "true".equals(request.getParameter("flg"))) {
			param.set_orderby(null);
			param.set_se_wayid(null);
			param.set_se_countyid(null);
			param.set_pageno("1");
		}
		
		// �Ǽ���ʼʱ�䣦�Ǽǽ���ʱ�䲻�ܳ���������
		if(!StringUtils.isEmpty(starttimeStr)&&!StringUtils.isEmpty(endtimeStr))
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date startdate = format.parse(starttimeStr);
			Date enddate = format.parse(endtimeStr);
			int diff = operationDate(enddate, startdate);
			if(diff>30)
			{
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�Ǽ���ʼʱ�䣦�Ǽǽ���ʱ�䲻�ܳ���31�졣");
				return (actionMapping.findForward("list"));
			}
		}
		
		// ������ʼʱ�䣦�������ʱ�䲻�ܳ���31��
		if(!StringUtils.isEmpty(starttimeStr1)&&!StringUtils.isEmpty(endtimeStr1))
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date startdate = format.parse(starttimeStr1);
			Date enddate = format.parse(endtimeStr1);
			int diff = operationDate(enddate, startdate);
			if(diff>30)
			{
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "������ʼʱ�䣦�������ʱ�䲻�ܳ���31�졣");
				return (actionMapping.findForward("list"));
			}
		} else if (!StringUtils.isEmpty(starttimeStr1) || !StringUtils.isEmpty(endtimeStr1)) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "������ʼʱ�䣦�������ʱ�䲻�ܳ���31�졣");
			return (actionMapping.findForward("list"));
		}
		
		DataPackage dp = null;
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		try{
			RegistersimcntDelegate registersimcntDelegate = new RegistersimcntDelegate();
			RegistersimcntListVO listvo = new RegistersimcntListVO();
			setListVO(listvo, actionForm);
			listvo.getQueryConditions().put("CITYID", cityid);
			listvo.getQueryConditions().put("STARTIME", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(starttimeStr));
			listvo.getQueryConditions().put("ENDTIME", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(endtimeStr));
			dp = registersimcntDelegate.doQuery(listvo,user);		
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
		RegistersimcntForm param = (RegistersimcntForm)actionForm;
		RegistersimvwForm paramvw = new RegistersimvwForm();
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
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		try{
			RegistersimvwDelegate registersimvwBO = new RegistersimvwDelegate();
			RegistersimvwListVO reList = new RegistersimvwListVO();
			setListVO(reList,paramvw);
			String starttimeStr = param.get_dnl_oprtime();
			String endtimeStr = param.get_dnm_oprtime();
			reList.getQueryConditions().put("CITYID", cityid);
			reList.getQueryConditions().put("STARTIME", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(starttimeStr));
			reList.getQueryConditions().put("ENDTIME", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(endtimeStr));
			dp = registersimvwBO.doQuery(reList,user);
			// ���
//			Iterator it = dp.getDatas().iterator();
//			// ȡ��ҵ���������
//			while (it.hasNext()) {
//				RegistersimvwVO revo = (RegistersimvwVO)(it.next());
//				String opnid = revo.getOpnid();
//				OperationsmsDelegate operationsmsdlg = new OperationsmsDelegate();
//				OperationsmsListVO optParam = new OperationsmsListVO();
//				optParam.set_se_opntype("1");
//				optParam.set_se_smsno("10086111");
//				optParam.set_se_cityid(cityid);
//				optParam.set_se_opnid(opnid);
//				DataPackage dp2 = operationsmsdlg.doQuery(optParam,user);
//				// ���
//				Iterator itor = dp2.getDatas().iterator();
//				while (itor.hasNext()) {
//					OperationsmsVO opvo = (OperationsmsVO)(itor.next());
//					String opnidname = opvo.getOpnname();
//					if (StringUtils.isEmpty(opnidname) || opnidname == null) {
//						revo.setOpnname(opnid);
//					} else {
//						revo.setOpnname(opnidname);
//					}
//				}
//			}
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		request.setAttribute("cityid", cityid);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("selectlist"));
	}
	
	/**
	 * ����Excel�ļ�
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�׿��Ǽǻ���");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:",format.format(new Date()) });
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("countyid", "�ֹ�˾",export.CODE2NAME, "#CNTYCOMPANY");
		//�Ǽ�
		export.addOutputProperty("starlevel", "�Ǽ�",export.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("cnt", "����");
					
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
	 * ������ӡ�������
	 * 
	 * �����ؽ����λΪ:����
	 */
	public static int operationDate(Date date, Date diffDate) {
		long diff = getMillis(date) - getMillis(diffDate);
		return (int) (diff / (24 * 3600 * 1000));
	}
	
	/**
	 * ��ȡָ�����ڵĺ�����
	 */
	public static long getMillis(Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}
}
