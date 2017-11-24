/**
* auto-generated code
* Wed Dec 07 14:34:03 CST 2011
*/
package com.sunrise.boss.ui.cms.bbc.unvrcfailday;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.unvrcfailday.persistent.UnvrcfaildayVO;
import com.sunrise.boss.business.cms.bbc.unvrcfailday.persistent.VUnvrcfaildayVO;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.unvrcfailday.persistent.UnvrcfaildayListVO;
import com.sunrise.boss.delegate.cms.bbc.unvrcfailday.UnvrcfaildayDelegate;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: UnvrcfaildayAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class UnvrcfaildayAction extends BaseDelegateAction  {
    public UnvrcfaildayAction() {
            setVoClass(UnvrcfaildayVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "failid"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping,
    		ActionForm actionForm, HttpServletRequest request,
    		HttpServletResponse response, User user) throws Exception {
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	try{
    		UnvrcfaildayForm form = (UnvrcfaildayForm)actionForm;
        	UnvrcfaildayListVO listvo = new UnvrcfaildayListVO();
        	this.setListVO(listvo, form);
        	if(listvo.get_dnl_rcdate()!=null && !("".equals(listvo.get_dnl_rcdate()))){
        		listvo.set_dnl_rcdate(listvo.get_dnl_rcdate()+" 00:00:00");
        	}       		
			if(listvo.get_dnm_rcdate()!=null && !("".equals(listvo.get_dnm_rcdate()))){
				listvo.set_dnm_rcdate(listvo.get_dnm_rcdate()+" 23:59:59");
			}				
        	listvo.set_orderby("failid");
        	UnvrcfaildayDelegate delegate = new UnvrcfaildayDelegate();
        	DataPackage dp = delegate.doQueryWithEmpinfo(listvo, user);
        	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);    
    	}catch(Exception e){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
    	}
    		
    	return actionMapping.findForward("list");
    }
    
    public ActionForward doTxt(ActionMapping actionMapping,
    		ActionForm actionForm, HttpServletRequest request,
    		HttpServletResponse response, User user) throws Exception {
    	CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("创薪联盟数据业务推荐失败明细查询");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date(System.currentTimeMillis())) });
		//export.addOutputProperty("failid","序号");
		export.addOutputProperty("rcno","专员号码");
		export.addOutputProperty("mobileno","客户号码");
		export.addOutputProperty("opnid","业务编码");
		export.addOutputProperty("opnname","业务名称");
		export.addOutputProperty("rcmonth","推荐月份");
		export.addOutputProperty("rcdate", "推荐时间", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("reason","失败原因");
		export.addOutputProperty("ossrc","业务平台来源", CommonExportBean.CODE2NAME, "#CH_UNV_OSSRC");
		export.addOutputProperty("wayid","渠道编码");
		export.addOutputProperty("wayname","渠道名称");
		export.addOutputProperty("empattr2", "成员属性", CommonExportBean.CODE2NAME, "$CH_EMPATTR2");		
		export.voClassArray = new Class[]{VUnvrcfaildayVO.class};
		export.queryMethodName="doList";
		response.setCharacterEncoding("GBK");
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain;charset=gbk");
		
		export.writeTxtTitle(response.getOutputStream(), new String[] {"专员号码","客户号码",
			"业务编码","业务名称","推荐月份","推荐时间","失败原因","业务平台来源","渠道编码",
			"渠道名称","成员属性"});
		
		super.ExportQuery(actionMapping, actionForm, request, response,	user, export);
		return actionMapping.findForward(null);
    }
    
    /**
	 * 导出Excel文件
	 * 在界面加入下面代码就可导出EXCEL
	 * <input type="button" class="button_4" onmouseover="buttonover(this);" onclick="doExport('TOEXCEL')" 
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
		export.addOutputProperty("rcno","专员号码");
		export.addOutputProperty("mobileno","客户号码");
		export.addOutputProperty("opnid","业务编码");
		export.addOutputProperty("opnname","业务名称");
		export.addOutputProperty("rcmonth","推荐月份");
		export.addOutputProperty("rcdate", "推荐时间", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("reason","失败原因");
		export.addOutputProperty("ossrc","业务平台来源", CommonExportBean.CODE2NAME, "#CH_UNV_OSSRC");
		export.addOutputProperty("wayid","渠道编码");
		export.addOutputProperty("wayname","渠道名称");
		export.addOutputProperty("empattr2", "成员属性", CommonExportBean.CODE2NAME, "$CH_EMPATTR2");
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[]{VUnvrcfaildayVO.class};
		export.queryMethodName = "doList";
		if(export.headtitle==null){
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
		
		return actionMapping.findForward(null);
	}
}
