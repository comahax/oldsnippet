/**
* auto-generated code
* Thu Oct 09 13:08:46 CST 2008
*/
package com.sunrise.boss.ui.cms.iodaudit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.cms.regnewwayemp.RegNewWayEmpForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.business.cms.iodaudit.persistent.IodauditListVO;
import com.sunrise.boss.business.cms.iodaudit.persistent.IodauditVO;
import com.sunrise.boss.business.cms.regnewwayemp.persistent.RegNewWayEmpListVO;
import com.sunrise.boss.business.cms.regnewwayemp.persistent.RegNewWayEmpVO;
import com.sunrise.boss.business.cms.reward.operationsms.persistent.OperationsmsListVO;
import com.sunrise.boss.business.cms.reward.operationsms.persistent.OperationsmsVO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.iodaudit.IodauditDelegate;
import com.sunrise.boss.delegate.cms.regnewwayemp.RegNewWayEmpDelegate;
import com.sunrise.boss.delegate.cms.reward.operationsms.OperationsmsDelegate;
import com.sunrise.pub.tools.PublicUtils;

/**
 * <p>Title: IodauditAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class IodauditAction extends BaseDelegateAction {
    public IodauditAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(IodauditVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq";
    }
    
    public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		((IodauditForm) actionForm).set_dnl_iodtime(PublicUtils.formatUtilDate(new Date((new Date()).getTime()-24*3600*1000),"yyyy-MM-dd")+" 00:00:00");
		((IodauditForm) actionForm).set_dnm_iodtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 23:59:59");
		
		return doList(actionMapping, actionForm, request, response, user);
	}
    
    public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception{		
    	IodauditForm param = (IodauditForm)actionForm;
    	
		String starttimeStr = param.get_dnl_iodtime();
		String endtimeStr = param.get_dnm_iodtime();
		
		
		// 时间间隔不能超出31天
		if(!StringUtils.isEmpty(starttimeStr)&&!StringUtils.isEmpty(endtimeStr))
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date startdate = format.parse(starttimeStr);
			Date enddate = format.parse(endtimeStr);
			int diff = operationDate(enddate, startdate);
			if(diff>30)
			{
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "时间间隔不能超出31天。");
				return (actionMapping.findForward("list"));
			}
		}
		
		return super.doList(actionMapping, actionForm, request, response, user);
		
	}
    
    public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("IOD平台短信稽核明细查询");
		export.addOutputProperty("seq");
		export.addOutputProperty("adtcontent");
		export.addOutputProperty("mobile");
//		export.addOutputProperty("opnid");
		export.addOutputProperty("iodtime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("sucess", CommonExportBean.CODE2NAME, "$IB_SUCCFLAG");
		export.addOutputProperty("officetel");
		export.addOutputProperty("adtcode", CommonExportBean.CODE2NAME, "#CH_ADT_RULEREL_VALID");
		export.addOutputProperty("adtremark");
		export.addOutputProperty("compare", CommonExportBean.CODE2NAME, "$CH_COMPARE");
		export.addOutputProperty("mendflag", CommonExportBean.CODE2NAME, "$CH_MENDFLAG");
		export.addOutputProperty("mendtime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
//		export.addOutputProperty("opnid");

		export.voClassArray = new Class[] { IodauditVO.class };
		
		response.setCharacterEncoding("GBK");
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain;charset=gbk");
//		export.writeTxtTitle(response.getOutputStream(), new String[] {
//				"标识", "稽核内容", "套卡号码","简码", "时间", "短信状态码", "店员手机号", "稽核结果", "稽核结果描述",
//				"核对结果","业务编码"});
		export.writeTxtTitle(response.getOutputStream(), new String[] {
			"标识", "稽核内容", "套卡号码", "时间", "短信状态码", "店员手机号", "稽核结果", "稽核结果描述",
			"核对结果","补登标识","补登记处理时间"});
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
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
