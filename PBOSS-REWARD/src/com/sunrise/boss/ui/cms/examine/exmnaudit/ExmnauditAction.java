/**
* auto-generated code
* Sat Nov 28 17:57:55 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.exmnaudit;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditListVO;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditVO;
import com.sunrise.boss.business.cms.examine.itemgraded.persistent.ItemgradedListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.examine.exmnaudit.ExmnauditDelegate;
import com.sunrise.boss.delegate.cms.examine.itemgraded.ItemgradedDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.cms.examine.itemgraded.ItemgradedForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ExmnauditAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnauditAction extends BaseDelegateAction {
    public ExmnauditAction() {
            setVoClass(ExmnauditVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seqid"; 
    }

	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ExmnauditDelegate exmnauditDelegate=new ExmnauditDelegate();
		ExmnauditListVO listVO = (ExmnauditListVO)getListVO(); 
		ExmnauditForm form=(ExmnauditForm) actionForm;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.SECOND, 0); 
		cal.set(Calendar.MINUTE, 0); 
		cal.set(Calendar.HOUR_OF_DAY, 0); 
		cal.set(Calendar.DATE, 1);    
		cal.add(Calendar.MONTH, -1);    //得到前一个月 
		if(form.get_dnl_submissiontime()==null){
			form.set_dnl_submissiontime(format.format(cal.getTime()));
		}
		cal.add(Calendar.MONTH, 1); 
		cal.add(Calendar.DATE, -1);
		if(form.get_dnm_submissiontime()==null){
			form.set_dnm_submissiontime(format.format(cal.getTime()));
		}
		if(form.getAuditor()==null || "".equals(form.getAuditor()))
			form.set_se_auditor(user.getOpercode());
    	setListVO(listVO, form); //设置好listVO，作为查询条件
    	DataPackage dp=exmnauditDelegate.doQueryExmnauditList(listVO, user);
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("list"));
	}
	public ActionForward doAuditlist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{
		ExmnauditDelegate exmnauditDelegate=new ExmnauditDelegate();
		ExmnauditListVO listVO = (ExmnauditListVO)getListVO(); 
    	setListVO(listVO, actionForm); //设置好listVO，作为查询条件
    	listVO.set_orderby("submissiontime");
    	DataPackage dp=exmnauditDelegate.doQuery(listVO, user);
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("infolist"));
	}
	
	 /**
     * 提交审核
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     */
    public ActionForward doSubmitaudit(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	String submitType=request.getParameter("submitType");
    	ItemgradedDelegate itemgradedDelegate=new ItemgradedDelegate();
    	ExmnauditDelegate exmnauditDelegate=new ExmnauditDelegate();
    	String[] itemgradedids=null;
    	if("all".equals(submitType)){
    		List list=exmnauditDelegate.doFindAllSubmitSeqid(user);
			if(list==null||list.size()<=0){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "没有提交的项目!");
 				return this.doList(actionMapping, actionForm, request, response, user);
			}
			itemgradedids=new String[list.size()];
			int n=0;
			Iterator it=list.iterator();
			while(it.hasNext()){
				itemgradedids[n]=(String)it.next();
				n++;
			}
    	}else{
    		String[] selectArray = ((ExmnauditForm) actionForm).get_selectitem();
    		 if(selectArray == null) {
    			 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "无法获取选中项目");
 				return this.doList(actionMapping, actionForm, request, response, user);
 			}
    		 itemgradedids=new String[selectArray.length];
 			for(int i=0;i<selectArray.length;i++){
 				itemgradedids[i]=selectArray[i].split(",")[1];
 			}
    	}
    	String auditor=((ExmnauditForm) actionForm).getOperid();
		String curauditor=((ExmnauditForm) actionForm).getOpername();
		itemgradedDelegate.doSubmitAuditInfo(itemgradedids, auditor, curauditor, user);
    	return this.doList(actionMapping, actionForm, request, response, user);
    }
    /**
     * 考核信息审核回收
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     */
    public ActionForward doCallback(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	String callbackType=request.getParameter("callbackType");
    	ExmnauditDelegate exmnauditDelegate=new ExmnauditDelegate();
    	String[] itemgradedids=null;
    	if("all".equals(callbackType)){
    		List list=exmnauditDelegate.doFindAllCallbackItemgradeds(user);//查找所有符合回收条件的考核项评分标识集合
			if(list==null||list.size()<=0){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "没有收回的项目!");
 				return this.doList(actionMapping, actionForm, request, response, user);
			}
			itemgradedids=new String[list.size()];
			int n=0;
			Iterator it=list.iterator();
			while(it.hasNext()){
				itemgradedids[n]=(String)it.next();
				n++;
			}
    	}else{
    		String[] selectArray = ((ExmnauditForm) actionForm).get_selectitem();
	   		 if(selectArray == null) {
	   			 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "无法获取选中项目");
					return this.doList(actionMapping, actionForm, request, response, user);
				}
	   		 itemgradedids=new String[selectArray.length];
			for(int i=0;i<selectArray.length;i++){
				itemgradedids[i]=selectArray[i].split(",")[1];
			}
			 /**
		     * 根据考核登记ID数组查询验证能否被收回,返回不能被回收的考核登记标识集合
		     */
			List noCallbackIds=exmnauditDelegate.doValidateCallbackInfo(itemgradedids,user);
			if(noCallbackIds!=null &&noCallbackIds.size()>0){
				String values="";
				Iterator it=noCallbackIds.iterator();
				while(it.hasNext()){
					if("".equals(values))
		    			values=(String)it.next();
		    		else
		    			values+=","+(String)it.next();;
				}
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "你所选中的序号["+values+"]不能被回收,请重新选择要回收记录！");
				return this.doList(actionMapping, actionForm, request, response, user);
			}
    	}
    	exmnauditDelegate.doCallbackInfo(itemgradedids,user);//执行回收相关操作(删除相关考核信息审核信息,更新考核项评分信息)
    	return this.doList(actionMapping, actionForm, request, response, user);
    }
    /**
     * 考核信息审核回收
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     */
    public ActionForward doAudit(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	String auditType=request.getParameter("auditType");
		String state=request.getParameter("state");
		String auditopinion=request.getParameter("auditopinion");
		String[] exmnauditId=null;
		ExmnauditDelegate exmnauditDelegate=new ExmnauditDelegate();
		if("all".equals(auditType)){
			List list=exmnauditDelegate.doFindAllAuditExmnaudits(user);//查找所有可审核的考核信息审核标识信息
			if(list==null||list.size()<=0){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "没有审核的项目!");
 				return this.doList(actionMapping, actionForm, request, response, user);
			}
			exmnauditId=new String[list.size()];
			int n=0;
			Iterator it=list.iterator();
			while(it.hasNext()){
				exmnauditId[n]=(String)it.next();
				n++;
			}
		}else{
			String[] selectArray = ((ExmnauditForm) actionForm).get_selectitem();
	   		 if(selectArray == null) {
	   			 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "无法获取选中项目");
					return this.doList(actionMapping, actionForm, request, response, user);
				}
	   		exmnauditId=new String[selectArray.length];
			for(int i=0;i<selectArray.length;i++){
				exmnauditId[i]=selectArray[i].split(",")[0];
			}
		}
		exmnauditDelegate.doAuditInfo(exmnauditId,state,auditopinion,user);//执行审核相关操作(更新考核项评分表和考核信息表中的状态为所选的状态,和保存审核意见)
		return this.doList(actionMapping, actionForm, request, response, user);
    }
    /**
     * AJAX验证判断“考核信息登记”的“状态[STATE]”未通过，并判断该当前人是否该“考核信息登记”的最新审核人
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     */
    public ActionForward doSubmitvalidate(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	PrintWriter writer  = null;
		
		try{
			writer = response.getWriter();
			ItemgradedDelegate itemgradedDelegate=new ItemgradedDelegate();
	    	ExmnauditDelegate exmnauditDelegate=new ExmnauditDelegate();
			String selectitems=request.getParameter("selectitems");
			//
			String[] selectArray=StringUtils.splitPreserveAllTokens(selectitems, "|");
			List itemgradedids=new ArrayList();
			String[] itemgradedidArray=new String[selectArray.length];
			String[] reqidArray=new String[selectArray.length];
			for(int i=0;i<selectArray.length;i++){
				itemgradedids.add(selectArray[i].split(",")[1]);
				reqidArray[i]=selectArray[i].split(",")[0];
				itemgradedidArray[i]=selectArray[i].split(",")[1];
			}
			ItemgradedListVO itemgradedListVO=new ItemgradedListVO();
			itemgradedListVO.set_se_state("1");
			itemgradedListVO.set_sin_seqid(itemgradedids);
			DataPackage data=itemgradedDelegate.doQuery(itemgradedListVO, user);
			if(data.getDatas().size()==itemgradedids.size()){
				List list=exmnauditDelegate.doValidateNewAuditor(reqidArray, itemgradedidArray,user);
				if(list.size()==itemgradedids.size())
					writer.write("YES");
				else
					writer.write("NO");
			}else
				writer.write("NO");
			
		}catch(Exception e){
			writer.write("NO");
			e.printStackTrace();
			
		}
		return null;
    }
    
}
