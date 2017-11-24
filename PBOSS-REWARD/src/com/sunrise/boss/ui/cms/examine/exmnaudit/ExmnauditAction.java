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
        // TODO: ������������������
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
		cal.add(Calendar.MONTH, -1);    //�õ�ǰһ���� 
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
    	setListVO(listVO, form); //���ú�listVO����Ϊ��ѯ����
    	DataPackage dp=exmnauditDelegate.doQueryExmnauditList(listVO, user);
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("list"));
	}
	public ActionForward doAuditlist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{
		ExmnauditDelegate exmnauditDelegate=new ExmnauditDelegate();
		ExmnauditListVO listVO = (ExmnauditListVO)getListVO(); 
    	setListVO(listVO, actionForm); //���ú�listVO����Ϊ��ѯ����
    	listVO.set_orderby("submissiontime");
    	DataPackage dp=exmnauditDelegate.doQuery(listVO, user);
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("infolist"));
	}
	
	 /**
     * �ύ���
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
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "û���ύ����Ŀ!");
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
    			 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�޷���ȡѡ����Ŀ");
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
     * ������Ϣ��˻���
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
    		List list=exmnauditDelegate.doFindAllCallbackItemgradeds(user);//�������з��ϻ��������Ŀ��������ֱ�ʶ����
			if(list==null||list.size()<=0){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "û���ջص���Ŀ!");
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
	   			 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�޷���ȡѡ����Ŀ");
					return this.doList(actionMapping, actionForm, request, response, user);
				}
	   		 itemgradedids=new String[selectArray.length];
			for(int i=0;i<selectArray.length;i++){
				itemgradedids[i]=selectArray[i].split(",")[1];
			}
			 /**
		     * ���ݿ��˵Ǽ�ID�����ѯ��֤�ܷ��ջ�,���ز��ܱ����յĿ��˵ǼǱ�ʶ����
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
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ѡ�е����["+values+"]���ܱ�����,������ѡ��Ҫ���ռ�¼��");
				return this.doList(actionMapping, actionForm, request, response, user);
			}
    	}
    	exmnauditDelegate.doCallbackInfo(itemgradedids,user);//ִ�л�����ز���(ɾ����ؿ�����Ϣ�����Ϣ,���¿�����������Ϣ)
    	return this.doList(actionMapping, actionForm, request, response, user);
    }
    /**
     * ������Ϣ��˻���
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
			List list=exmnauditDelegate.doFindAllAuditExmnaudits(user);//�������п���˵Ŀ�����Ϣ��˱�ʶ��Ϣ
			if(list==null||list.size()<=0){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "û����˵���Ŀ!");
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
	   			 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�޷���ȡѡ����Ŀ");
					return this.doList(actionMapping, actionForm, request, response, user);
				}
	   		exmnauditId=new String[selectArray.length];
			for(int i=0;i<selectArray.length;i++){
				exmnauditId[i]=selectArray[i].split(",")[0];
			}
		}
		exmnauditDelegate.doAuditInfo(exmnauditId,state,auditopinion,user);//ִ�������ز���(���¿��������ֱ�Ϳ�����Ϣ���е�״̬Ϊ��ѡ��״̬,�ͱ���������)
		return this.doList(actionMapping, actionForm, request, response, user);
    }
    /**
     * AJAX��֤�жϡ�������Ϣ�Ǽǡ��ġ�״̬[STATE]��δͨ�������жϸõ�ǰ���Ƿ�á�������Ϣ�Ǽǡ������������
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
