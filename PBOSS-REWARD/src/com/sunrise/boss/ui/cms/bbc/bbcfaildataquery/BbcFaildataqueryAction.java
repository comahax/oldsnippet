/**
* auto-generated code
* Mon Dec 08 10:50:04 CST 2008
*/
package com.sunrise.boss.ui.cms.bbc.bbcfaildataquery;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.bbcfaildataquery.persistent.BbcFaildataqueryVO;
import com.sunrise.boss.business.cms.reward.adtcode.persistent.AdtcodeListVO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.reward.adtcode.AdtcodeDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: BbcFaildataqueryAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: SUNRISE Tech Ltd.</p>
 * @author Li Zhaoliang
 * @version 1.0
 */
public class BbcFaildataqueryAction extends BaseDelegateAction {
    public BbcFaildataqueryAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(BbcFaildataqueryVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
    public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	BbcFaildataqueryForm form = (BbcFaildataqueryForm) actionForm;
    	//form.set_pagesize("300");
    	form.set_se_rewardtype("9");
    	super.doList(actionMapping, actionForm, request, response, user);
		return actionMapping.findForward("list");
    }
    
    /**
     * 失败原因查询弹出框
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     */
    public ActionForward doSelect(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	BbcFaildataqueryForm form = (BbcFaildataqueryForm) actionForm;
    	String adttype = request.getParameter("adttype");
    	
    	AdtcodeListVO adtlistvo = new AdtcodeListVO();
    	try {
			Page.setPageSize(request, form);
			setListVO(adtlistvo, form); // 设置好listVO，作为查询条件
			if(StringUtils.isNotEmpty(adttype)){
				ArrayList list = new ArrayList();
				list.add("COMM");
				list.add(adttype);
				adtlistvo.set_sin_adttype(list);
			}
			AdtcodeDelegate delegate = new AdtcodeDelegate();
			DataPackage dp = delegate.doQuery(adtlistvo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return (actionMapping.findForward("select"));
	}
    
    public ActionForward doTxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("B2M网站酬金有效性校验失败数据查询");
		
		export.addOutputProperty("seq");
		export.addOutputProperty("rewardtype");
		export.addOutputProperty("calcmonth");
		export.addOutputProperty("opnid");
//		export.addOutputProperty("name");
		export.addOutputProperty("opnid", CommonExportBean.CODE2NAME,	"#BBC_OPERATION");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayname");
		export.addOutputProperty("oprcode");
		export.addOutputProperty("mobile");
		export.addOutputProperty("oprtime", CommonExportBean.DATE,"yyyy-MM-dd");
		export.addOutputProperty("creattime", CommonExportBean.DATE,"yyyy-MM-dd");
		export.addOutputProperty("ruleid");
		export.addOutputProperty("adtflag", CommonExportBean.CODE2NAME,	"#CH_ADTFLAG");
		export.addOutputProperty("adtcode");
		export.addOutputProperty("adtremark");
		export.addOutputProperty("ossrc", CommonExportBean.CODE2NAME,"#CH_BBC_OSSRC");
		export.addOutputProperty("batchno");

		export.voClassArray = new Class[] { BbcFaildataqueryVO.class };
		export.queryMethodName="doQueryexport";
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] {
			"流水号","酬金类型","结算月份","全省业务编码","业务名称","业务发生渠道编码","业务发生渠道名称","业务发生工号","业务发生手机号","业务发生时间","校验时间","校验规则编码","校验结果","失败原因编码","失败原因","业务平台来源","批次号"});
		
		BaseActionForm baseActionForm = (BaseActionForm) actionForm;
		baseActionForm.set_orderby("seq");
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
	}
    /**
	 * 导出为EXCEL格式。
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("B2M网站酬金有效性校验失败数据查询");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("seq","流水号");
		export.addOutputProperty("rewardtype","酬金类型");
		export.addOutputProperty("calcmonth","结算月份");
		export.addOutputProperty("opnid","全省业务编码");
//		export.addOutputProperty("name","业务名称");
		export.addOutputProperty("opnid","业务名称", CommonExportBean.CODE2NAME,	"#BBC_OPERATION");
		export.addOutputProperty("wayid","业务发生渠道编码");
		export.addOutputProperty("wayname","业务发生渠道名称");
		export.addOutputProperty("oprcode","业务发生工号");
		export.addOutputProperty("mobile","业务发生手机号");
		export.addOutputProperty("oprtime","业务发生时间",CommonExportBean.DATE,"yyyy-MM-dd");
		export.addOutputProperty("creattime","校验时间",CommonExportBean.DATE,"yyyy-MM-dd");
		export.addOutputProperty("ruleid","校验规则编码");
		export.addOutputProperty("adtflag","校验结果", CommonExportBean.CODE2NAME,	"#CH_ADTFLAG");
		export.addOutputProperty("adtcode","失败原因编码");
		export.addOutputProperty("adtremark","失败原因");
		export.addOutputProperty("ossrc","业务平台来源", CommonExportBean.CODE2NAME,"#CH_BBC_OSSRC");
		export.addOutputProperty("batchno","批次号");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		
		BaseActionForm baseActionForm = (BaseActionForm) actionForm;
		baseActionForm.set_orderby("seq");
//		return super
//				.doExcel(actionMapping, actionForm, request, response, user);
		export.voClassArray = new Class[] { voClass };
		export.queryMethodName = "doQueryexport";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
		return actionMapping.findForward(null);
	}
	public ActionForward doQueryexport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
        	Page.setPageSize(request, (BaseActionForm) actionForm);        	
        	BaseListVO listVO = getListVO(); 
        	setListVO(listVO, actionForm); //设置好listVO，作为查询条件
        	
        	Object delegate = getDelegate();
            
            String methodName = "doQuery2";
            DataPackage pack = (DataPackage)invokeDelegateMethod(delegate,methodName,new Object[]{listVO, user});
            request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
        }catch(BusinessException e) {
        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
        }catch(Exception e) {
        	throw e;
        } 
		return actionMapping.findForward(null);
	} 
}
