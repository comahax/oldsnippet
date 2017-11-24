/**
* auto-generated code
* Fri Dec 09 10:35:29 CST 2011
*/
package com.sunrise.boss.ui.cms.bbc.allsalesday;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.allsalesday.persistent.AllsalesdayVO;
import com.sunrise.boss.business.cms.bbc.allsalesday.persistent.AllsalesdayListVO;
import com.sunrise.boss.business.cms.bbc.allsalesday.persistent.VAllsalesdayVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.bbc.allsalesday.AllsalesdayDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.cms.bbc.allsalesday.AllsalesdayForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: AllsalesdayAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class AllsalesdayAction extends BaseDelegateAction {
    public AllsalesdayAction() {
            setVoClass(AllsalesdayVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	try{
    		AllsalesdayForm form =  (AllsalesdayForm)actionForm;
    		AllsalesdayListVO listvo = new AllsalesdayListVO();
    		this.setListVO(listvo, form);
    		if(listvo.get_dnl_oprtime()!=null && !"".equals(listvo.get_dnl_oprtime())){
    			listvo.set_dnl_oprtime(listvo.get_dnl_oprtime() + " 00:00:00");
    		}
    		if(listvo.get_dnm_oprtime()!=null && !"".equals(listvo.get_dnm_oprtime())){
    			listvo.set_dnm_oprtime(listvo.get_dnm_oprtime() + " 23:59:59");
    		}
    		listvo.set_orderby("seq");
    		AllsalesdayDelegate delegate = new AllsalesdayDelegate();
    		DataPackage dp = delegate.doQueryWithEmpinfo(listvo, user);
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);    		
    	}catch(Exception e){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		return actionMapping.findForward("list");
    }
    
    /*
     * 统计：业务总量、有业务的网点数、有业务的专员数
     */
    public ActionForward doStatistic(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	try{
    		AllsalesdayForm form =  (AllsalesdayForm)actionForm;
    		AllsalesdayListVO listvo = new AllsalesdayListVO(); 
    		
    		if(form.get_dnl_oprtime()!=null && !"".equals(form.get_dnl_oprtime())){
    			String start = form.get_dnl_oprtime() + " 000000";
    			listvo.getQueryConditions().put("startdate", start);
    		}else{
    			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    			String fmtdate = fmt.format(new Date(System.currentTimeMillis()));
    			form.set_dnl_oprtime(fmtdate);
    			String start = fmtdate+"000000";
    			listvo.getQueryConditions().put("startdate", start);
    		}
    		if(form.get_dnm_oprtime()!=null && !"".equals(form.get_dnm_oprtime())){
    			String end = form.get_dnm_oprtime() + " 235959";
    			listvo.getQueryConditions().put("enddate", end);
    		}else{
    			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    			String fmtdate = fmt.format(new Date(System.currentTimeMillis()));
    			form.set_dnm_oprtime(fmtdate);
    			String end = fmtdate+"235959";
    			listvo.getQueryConditions().put("enddate", end);    			
    		}
    		
    		AllsalesdayDelegate delegate = new AllsalesdayDelegate();
    		Map statistic = delegate.doStatistic(listvo, user);
    		request.setAttribute("STATISTIC", statistic);    		
    	}catch(Exception e){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
    	}
    	return actionMapping.findForward("statistic");
    }
    
    /*
     * 统计：各业务对应总量
     */
    public ActionForward doStatisticbusidetail(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	try{
    		AllsalesdayForm form =  (AllsalesdayForm)actionForm;
    		AllsalesdayListVO listvo = new AllsalesdayListVO(); 
    		this.setListVO(listvo, form);
    		if(form.get_dnl_oprtime()!=null && !"".equals(form.get_dnl_oprtime())){
    			String start = form.get_dnl_oprtime() + " 000000";
    			listvo.getQueryConditions().put("startdate", start);
    			listvo.set_dnl_oprtime("");
    		}else{
    			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    			String fmtdate = fmt.format(new Date(System.currentTimeMillis()));
    			form.set_dnl_oprtime(fmtdate);
    			String start = fmtdate+"000000";
    			listvo.getQueryConditions().put("startdate", start);
    		}
    		if(form.get_dnm_oprtime()!=null && !"".equals(form.get_dnm_oprtime())){
    			String end = form.get_dnm_oprtime() + " 235959";
    			listvo.getQueryConditions().put("enddate", end);
    			listvo.set_dnm_oprtime("");
    		}else{
    			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    			String fmtdate = fmt.format(new Date(System.currentTimeMillis()));
    			form.set_dnm_oprtime(fmtdate);
    			String end = fmtdate+"235959";
    			listvo.getQueryConditions().put("enddate", end);    			
    		}
    		
    		AllsalesdayDelegate delegate = new AllsalesdayDelegate();
    		DataPackage statistic = delegate.doStatisticBusiDetail(listvo, user);
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, statistic);    		
    	}catch(Exception e){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
    	}
    	return actionMapping.findForward("stat_busi");
    }
    
    /*
     *统计：各网点个业务总量
     */
    public ActionForward doStatisticwaybusidetail(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	try{
    		AllsalesdayForm form =  (AllsalesdayForm)actionForm;
    		AllsalesdayListVO listvo = new AllsalesdayListVO(); 
    		this.setListVO(listvo, form);
    		if(form.get_dnl_oprtime()!=null && !"".equals(form.get_dnl_oprtime())){
    			String start = form.get_dnl_oprtime() + " 000000";
    			listvo.getQueryConditions().put("startdate", start);
    			listvo.set_dnl_oprtime("");
    		}else{
    			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    			String fmtdate = fmt.format(new Date(System.currentTimeMillis()));
    			form.set_dnl_oprtime(fmtdate);
    			String start = fmtdate+"000000";
    			listvo.getQueryConditions().put("startdate", start);
    		}
    		if(form.get_dnm_oprtime()!=null && !"".equals(form.get_dnm_oprtime())){
    			String end = form.get_dnm_oprtime() + " 235959";
    			listvo.getQueryConditions().put("enddate", end);
    			listvo.set_dnm_oprtime("");
    		}else{
    			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    			String fmtdate = fmt.format(new Date(System.currentTimeMillis()));
    			form.set_dnm_oprtime(fmtdate);
    			String end = fmtdate+"235959";
    			listvo.getQueryConditions().put("enddate", end);    			
    		}
    		
    		AllsalesdayDelegate delegate = new AllsalesdayDelegate();
    		DataPackage statistic = delegate.doStatisticWayBusiDetail(listvo, user);
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, statistic);    		
    	}catch(Exception e){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
    	}
    	return actionMapping.findForward("stat_waybusi");
    }
    
    public ActionForward doTxt(ActionMapping actionMapping,
    		ActionForm actionForm, HttpServletRequest request,
    		HttpServletResponse response, User user) throws Exception {
    	CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("创薪联盟数据业务推荐成功明细查询");
		//export.addOutputProperty("seq", "序号");
		export.addOutputProperty("ruleid", "校验规则");
		export.addOutputProperty("opnid", "发生业务编码");
		export.addOutputProperty("opnname", "发生业务名称");
		export.addOutputProperty("calcopnid", "结算业务编码");
		export.addOutputProperty("calopnname", "结算业务名称");
		export.addOutputProperty("calcmonth", "结算月份");
		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("wayname", "渠道名称");
		export.addOutputProperty("oprtime", "业务发生时间", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("oprcode", "专员号码");
		export.addOutputProperty("mobile", "业务发生号码");
		export.addOutputProperty("busivalue", "业务量");
		export.addOutputProperty("rewardtype", "酬金类型", CommonExportBean.CODE2NAME, "$CH_BBCREWARDTYPE");
		export.addOutputProperty("ossrc", "业务来源", CommonExportBean.CODE2NAME, "#CH_UNV_OSSRC");
		export.addOutputProperty("empattr2", "成员属性", CommonExportBean.CODE2NAME, "$CH_EMPATTR2");
		export.addOutputProperty("srcseq", "源数据流水号");
		export.queryMethodName="doList";
		export.voClassArray = new Class[]{VAllsalesdayVO.class};
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] {"校验规则", "发生业务编码",
			"发生业务名称", "结算业务编码", "结算业务名称", "结算月份", "渠道编码", "渠道名称", "业务发生时间",
			"专员号码", "业务发生号码", "业务量", "酬金类型", "业务来源", "成员属性", "源数据流水号"});
		
		super.ExportQuery(actionMapping, actionForm, request, response,	user, export);
		return actionMapping.findForward(null);
    }
    
    /**
	 * 导出Excel文件
	 * 在界面加入下面代码就可导出EXCEL
	 *<input type="button" class="button_4" onmouseover="buttonover(this);" onclick="doExport('TOEXCEL')" 
             onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
             value="<bean:message bundle="public" key="button_export_excel"/>" />
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("创薪联盟数据业务推荐失败明细查询");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date(System.currentTimeMillis())) });
		export.addOutputProperty("ruleid", "校验规则");
		export.addOutputProperty("opnid", "发生业务编码");
		export.addOutputProperty("opnname", "发生业务名称");
		export.addOutputProperty("calcopnid", "结算业务编码");
		export.addOutputProperty("calopnname", "结算业务名称");
		export.addOutputProperty("calcmonth", "结算月份");
		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("wayname", "渠道名称");
		export.addOutputProperty("oprtime", "业务发生时间", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("oprcode", "专员号码");
		export.addOutputProperty("mobile", "业务发生号码");
		export.addOutputProperty("busivalue", "业务量");
		export.addOutputProperty("rewardtype", "酬金类型", CommonExportBean.CODE2NAME, "$CH_BBCREWARDTYPE");
		export.addOutputProperty("ossrc", "业务来源", CommonExportBean.CODE2NAME, "#CH_UNV_OSSRC");
		export.addOutputProperty("empattr2", "成员属性", CommonExportBean.CODE2NAME, "$CH_EMPATTR2");
		export.addOutputProperty("srcseq", "源数据流水号");
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[]{VAllsalesdayVO.class};
		export.queryMethodName = "doList";
		if(export.headtitle==null){
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
		
		return actionMapping.findForward(null);
	}
}
