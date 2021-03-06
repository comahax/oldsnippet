/**
* auto-generated code
* Mon Feb 21 10:20:07 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.registersimvw;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.operationsms.persistent.OperationsmsListVO;
import com.sunrise.boss.business.cms.reward.operationsms.persistent.OperationsmsVO;
import com.sunrise.boss.business.cms.reward.registersimvw.persistent.RegistersimvwListVO;
import com.sunrise.boss.business.cms.reward.registersimvw.persistent.RegistersimvwVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.reward.operationsms.OperationsmsDelegate;
import com.sunrise.boss.delegate.cms.reward.registersimvw.RegistersimvwDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.cms.bbc.bbcrewardrecord.BbcRewardrecordForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.pub.tools.PublicUtils;

/**
 * <p>Title: RegistersimvwAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class RegistersimvwAction extends BaseDelegateAction {
    public RegistersimvwAction() {
            setVoClass(RegistersimvwVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seqid"; 
//           pkNameArray[1] = "employeeid"; 
    }
    
	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		((RegistersimvwForm) actionForm).set_dnl_oprtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00");
		((RegistersimvwForm) actionForm).set_dnm_oprtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 23:59:59");
		
//		return doList(actionMapping, actionForm, request, response, user);
		request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		return (actionMapping.findForward("list"));
	}
	
    public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception{		
    	RegistersimvwForm param = (RegistersimvwForm)actionForm;
    	
		String starttimeStr = param.get_dnl_oprtime();
		String endtimeStr = param.get_dnm_oprtime();
		String starttimeStr1 = param.get_dnl_activedate();
		String endtimeStr1 = param.get_dnm_activedate();
		
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
		
		// 激活起始时间＆激活结束时间不能超出31天
		if(!StringUtils.isEmpty(starttimeStr1)&&!StringUtils.isEmpty(endtimeStr1))
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date startdate = format.parse(starttimeStr1);
			Date enddate = format.parse(endtimeStr1);
			int diff = operationDate(enddate, startdate);
			if(diff>30)
			{
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "激活起始时间＆激活结束时间不能超出31天。");
				return (actionMapping.findForward("list"));
			}
		} else if (!StringUtils.isEmpty(starttimeStr1) || !StringUtils.isEmpty(endtimeStr1)) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "激活起始时间＆激活结束时间不能超出31天。");
			return (actionMapping.findForward("list"));
		}
		
		DataPackage dp = null;
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		try{
			RegistersimvwDelegate registersimvwDelegate = new RegistersimvwDelegate();
			RegistersimvwListVO listvo = new RegistersimvwListVO();
			setListVO(listvo, actionForm);
			listvo.getQueryConditions().put("CITYID", cityid);
			listvo.getQueryConditions().put("STARTIME", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(starttimeStr));
			listvo.getQueryConditions().put("ENDTIME", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(endtimeStr));
			dp = registersimvwDelegate.doQuery(listvo,user);
//			// 解包
//			Iterator it = dp.getDatas().iterator();
//			// 取得业务编码名称
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
//				// 解包
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
		return (actionMapping.findForward("list"));
	}
    
    /**
	 * 导出Excel文件
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("套卡登记明细查询");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:",format.format(new Date()) });
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("waymagcode", "所属渠道经理",export.CODE2NAME, "#CH_EMPLOYEE");
		export.addOutputProperty("countyid", "分公司",export.CODE2NAME, "#CNTYCOMPANY");
		//星级
		export.addOutputProperty("starlevel", "星级",export.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("employeename", "店员");
		export.addOutputProperty("officetel", "捆绑号码");
		export.addOutputProperty("mobile", "套卡号码");
		export.addOutputProperty("brand", "品牌",export.CODE2NAME,"$CH_SIMBRAND");
		export.addOutputProperty("comname", "子品牌");
		export.addOutputProperty("comtype", "商品类型",export.CODE2NAME,"$IM_COMTYPE");
		export.addOutputProperty("comclassid", "商品类别",export.CODE2NAME,"$IM_COMCLASS");
		export.addOutputProperty("comprice", "商品价格");
		export.addOutputProperty("oprtime", "登记时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("activedate", "激活时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("mendfalg", "补登标识",export.CODE2NAME,"$CH_MFLAG");
					
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		// 设置取出所有查询到的数据
		RegistersimvwForm form = (RegistersimvwForm)actionForm;
		RegistersimvwListVO registersimvwDBParam = new RegistersimvwListVO();
		setListVO(registersimvwDBParam,form);
		
		// 超过Excel 2003允许导出最大行数65536给出提示信息
		DataPackage dp = null;
		RegistersimvwDelegate registersimvwdlg = new RegistersimvwDelegate();
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		String starttimeStr = form.get_dnl_oprtime();
		String endtimeStr = form.get_dnm_oprtime();
		registersimvwDBParam.getQueryConditions().put("CITYID", cityid);
		registersimvwDBParam.getQueryConditions().put("STARTIME", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(starttimeStr));
		registersimvwDBParam.getQueryConditions().put("ENDTIME", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(endtimeStr));
		dp = registersimvwdlg.doQuery(registersimvwDBParam,user);
		if (dp.getDatas().size() > 65536) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "记录数超过Excel允许的最大行数，请转为文本方式导出!");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
			return actionMapping.findForward("list");
		}
		export.voClassArray = new Class[] { voClass };
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
		
		return actionMapping.findForward(null);
	}
	
	/**
	 * 导出txt文件
	 * @return
	 */
	public ActionForward doExporttxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		CommonExportBean export = new CommonExportBean(user);
			export.setFileName("套卡登记明细查询导出");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayname");
		export.addOutputProperty("waymagcode",export.CODE2NAME, "#CH_EMPLOYEE");
		export.addOutputProperty("countyid",export.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("starlevel",export.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("employeename");
		export.addOutputProperty("officetel");
		export.addOutputProperty("mobile");
		export.addOutputProperty("brand",export.CODE2NAME,"$CH_SIMBRAND");
		export.addOutputProperty("comname");
		export.addOutputProperty("comtype",export.CODE2NAME,"$IM_COMTYPE");
		export.addOutputProperty("comclassid",export.CODE2NAME,"$IM_COMCLASS");
		export.addOutputProperty("comprice");
		export.addOutputProperty("oprtime",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("activedate",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("mendfalg",export.CODE2NAME,"$CH_MFLAG");
		export.voClassArray = new Class[] { RegistersimvwVO.class };

		export.queryMethodName="doList";
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] {
				"网点编码", "网点名称", "所属渠道经理", "分公司" ,"星级","店员","捆绑号码","套卡号码","品牌","子品牌","商品类型","商品类别","商品价格","登记时间","激活时间","补登标识"});
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
