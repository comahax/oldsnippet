/**
* auto-generated code
* Sat Nov 28 17:53:15 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.itemgraded;

import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.admin.operator.persistent.OperatorListVO;
import com.sunrise.boss.business.cms.examine.itemgraded.persistent.ItemgradedListVO;
import com.sunrise.boss.business.cms.examine.itemgraded.persistent.ItemgradedVO;
import com.sunrise.boss.business.cms.examine.itemgraded.persistent.VItemgradedWayVO;
import com.sunrise.boss.business.cms.examine.oprnwayid.persistent.OprnwayidListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.operator.OperatorDelegate;
import com.sunrise.boss.delegate.cms.examine.exmnaudit.ExmnauditDelegate;
import com.sunrise.boss.delegate.cms.examine.itemgraded.ItemgradedDelegate;
import com.sunrise.boss.delegate.cms.examine.oprnwayid.OprnwayidDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ItemgradedAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ItemgradedAction extends BaseDelegateAction {
	public ItemgradedAction() {
        setVoClass(ItemgradedVO.class);
    // TODO: ������������������
       this.pkNameArray = new String[1]; 
       pkNameArray[0] = "seqid"; 
	}
    protected ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	getContentVO(request, user, actionForm);
		String command = getCommandString(request);
		((ItemgradedForm) actionForm).setCmdState(command);
		WayDelegate wayDelegate = new WayDelegate();
		WayVO wayVo=wayDelegate.doFindByPk(((ItemgradedForm) actionForm).getWayid(), user);
		if(wayVo!=null){
			((ItemgradedForm) actionForm).setAdtypecode(wayVo.getAdtypecode().toString());
			((ItemgradedForm) actionForm).setStarlevel(wayVo.getStarlevel().toString());
		}
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
    	
	}

	
    
    protected ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	ItemgradedDelegate delegate=new ItemgradedDelegate();
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		ItemgradedVO vo=null;
		for(int i=0;i<selectArray.length;i++){
			vo=delegate.doFindByPk(Long.valueOf(selectArray[i]), user);
			if(vo!=null){
				delegate.doRemoveJoinExmnaudit(vo, user);
			}
		}
		
		return doList(actionMapping, actionForm, request, response, user);
	}
	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
    	CommonDelegate comdelegate = new CommonDelegate(SysparamVO.class);
    	Serializable pkVO=new SysparamVO();
		BeanUtils.setProperty(pkVO, "systemid","60");
		BeanUtils.setProperty(pkVO, "paramtype","channel");
		SysparamVO sysparamVO=(SysparamVO)comdelegate.doFindByPk(pkVO, user);
		request.setAttribute("paramvalue", sysparamVO.getParamvalue());
		ItemgradedForm form =(ItemgradedForm)actionForm;
		if(form.get_se_registercode()==null )
			form.set_se_registercode(user.getOpercode());
		return super.doList(actionMapping, actionForm, request, response, user);
	}
    
	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ItemgradedForm form =(ItemgradedForm)actionForm;
		if(form.getRegistercode()==null ||"".equals(form.getRegistercode())){
			form.setRegistercode(user.getOpercode());
		}
		CommonDelegate comdelegate = new CommonDelegate(SysparamVO.class);
		Serializable pkVO=new SysparamVO();
		BeanUtils.setProperty(pkVO, "systemid","60");
		BeanUtils.setProperty(pkVO, "paramtype","channel");
		SysparamVO sysparamVO=(SysparamVO)comdelegate.doFindByPk(pkVO, user);
		if("0".equals(sysparamVO.getParamvalue()))
			form.setState("1");
		else
			form.setState("99");
		return super.doSave(actionMapping, actionForm, request, response, user);
	}

	public ActionForward doGetwayinfo(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	PrintWriter writer  = null;
		try{
			writer = response.getWriter();
			WayDelegate delegate=new WayDelegate();
			String wayid=request.getParameter("wayid");
			CommonDelegate comdelegate = new CommonDelegate(SysparamVO.class);
	    	Serializable pkVO=new SysparamVO();
			BeanUtils.setProperty(pkVO, "systemid","8");
			BeanUtils.setProperty(pkVO, "paramtype","pboss");
			SysparamVO sysparamVO=(SysparamVO)comdelegate.doFindByPk(pkVO, user);
			//���������ֵ[PARAMVALUE]��Ϊ1����ֻ���ڡ�����������Ȩ[CH_PW_OPRNWAYID]�����д���ӳ���ϵ�Ÿ��������֣�������������
			if("1".equals(sysparamVO.getParamvalue())){
				OprnwayidDelegate oprnwaydelegate=new OprnwayidDelegate();
				OprnwayidListVO oprnwayListVO=new OprnwayidListVO();
				oprnwayListVO.set_se_operid(user.getOpercode());
				oprnwayListVO.set_se_wayid(wayid);
				if(oprnwaydelegate.doQuery(oprnwayListVO, user).getDatas().size()<=0){
					writer.write("nooprnway");
					return null;
				}
			}
			WayVO vo=delegate.doFindByPk(wayid, user);
			writer.write(vo.getAdtypecode()+","+vo.getStarlevel());
		}catch(Exception e){
			writer = response.getWriter();
			writer.write("NO");
			
		}
    	return null;
    }
    public ActionForward doAuditingrolelist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	ItemgradedForm form =(ItemgradedForm)actionForm;
    	//����ϵͳ��ʶ=61,��������==channel����ϵͳ��������
    	CommonDelegate comdelegate = new CommonDelegate(SysparamVO.class);
    	Serializable pkVO=new SysparamVO();
		BeanUtils.setProperty(pkVO, "systemid","61");
		BeanUtils.setProperty(pkVO, "paramtype","channel");
		SysparamVO sysparamVO=(SysparamVO)comdelegate.doFindByPk(pkVO, user);
		
    	OperatorListVO param = new OperatorListVO();
		DataPackage dp = new DataPackage();
		if(sysparamVO!=null){
			String paramvalue= sysparamVO.getParamvalue();
			OperatorDelegate operatorDelegate = new OperatorDelegate();
			param.set_pagesize("10");
			param.set_sk_opername(form.get_sk_opername());
			param.set_se_operid(form.get_se_operid());
			param.set_desc(form.get_desc());
			param.set_orderby(form.get_orderby());
			if(form.get_pageno()==null || "".equals(form.get_pageno()))
				param.set_pageno("1");
			else
				param.set_pageno(form.get_pageno());
			dp=operatorDelegate.doQueryOperatorList(paramvalue, param, user);
			form.set_pageno(param.get_pageno());
			form.set_pagesize("10");
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("auditingRoleList"));
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
    	ItemgradedDelegate delegate=new ItemgradedDelegate();
    	String[] selectArray=null;
    	if("all".equals(submitType)){
    		List list=delegate.doFindAllSubmitSeqid(user);
			if(list==null||list.size()<=0){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "û���ύ����Ŀ!");
 				return this.doList(actionMapping, actionForm, request, response, user);
			}
			selectArray=new String[list.size()];
			int n=0;
			Iterator it=list.iterator();
			while(it.hasNext()){
				selectArray[n]=(String)it.next();
				n++;
			}
    	}else{
    		 selectArray = ((ItemgradedForm) actionForm).get_selectitem();
    		 if(selectArray == null) {
    			 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�޷���ȡѡ����Ŀ");
 				return this.doList(actionMapping, actionForm, request, response, user);
 			}
    	}
    	String auditor=((ItemgradedForm) actionForm).getOperid();
    	//request.getParameter("auditor");
		String curauditor=((ItemgradedForm) actionForm).getOpername();
		//request.getParameter("curauditor");
		delegate.doSubmitAuditInfo(selectArray, auditor, curauditor, user);
    	return this.doList(actionMapping, actionForm, request, response, user);
    }
    public ActionForward doCallback(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	String callbackType=request.getParameter("callbackType");
    	ItemgradedDelegate delegate=new ItemgradedDelegate();
    	ExmnauditDelegate exmnauditDelegate=new ExmnauditDelegate();
		String[] selectArray=null;
		if("all".equals(callbackType)){
			List list=exmnauditDelegate.doFindAllCallbackItemgradeds(user);//�������з��ϻ��������Ŀ��������ֱ�ʶ����
			if(list==null||list.size()<=0){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "û�л��յ���Ŀ!");
 				return this.doList(actionMapping, actionForm, request, response, user);
			}
			selectArray=new String[list.size()];
			int n=0;
			Iterator it=list.iterator();
			while(it.hasNext()){
				selectArray[n]=(String)it.next();
				n++;
			}
			
		}else{
			selectArray = ((ItemgradedForm) actionForm).get_selectitem();
   		 	if(selectArray == null) {
   		 		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�޷���ȡѡ����Ŀ");
				return this.doList(actionMapping, actionForm, request, response, user);
			}
	   		 /**
		     * ���ݿ��˵Ǽ�ID�����ѯ��֤�ܷ��ջ�,���ز��ܱ����յĿ��˵ǼǱ�ʶ����
		     */
			List noCallbackIds=exmnauditDelegate.doValidateCallbackInfo(selectArray,user);
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
		delegate.doCallbackInfo(selectArray,user);//ִ�л�����ز���(ɾ����ؿ�����Ϣ�����Ϣ,���¿�����������Ϣ)
    	return this.doList(actionMapping, actionForm, request, response, user);
    }
    public ActionForward doShowexmnpage(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	//����ϵͳ��ʶ=61,��������==channel����ϵͳ��������
    	CommonDelegate comdelegate = new CommonDelegate(SysparamVO.class);
    	Serializable pkVO=new SysparamVO();
		BeanUtils.setProperty(pkVO, "systemid","60");
		BeanUtils.setProperty(pkVO, "paramtype","channel");
		SysparamVO sysparamVO=(SysparamVO)comdelegate.doFindByPk(pkVO, user);
		request.setAttribute("sysparamvalue", sysparamVO.getParamvalue());
		return (actionMapping.findForward("frame"));
    }
    public ActionForward doExcel(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	CommonExportBean commonExportBean = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		commonExportBean.setFileName("������������");
		commonExportBean.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		commonExportBean.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
		commonExportBean.addOutputProperty("wayid", "��������");
		commonExportBean.addOutputProperty("wayname", "��������");
		commonExportBean.addOutputProperty("adtypecode", "����");
		commonExportBean.addOutputProperty("starlevel", "�Ǽ�");
		commonExportBean.addOutputProperty("exmnid", "���˱�ʶ");
		commonExportBean.addOutputProperty("exmnname", "��������");
		commonExportBean.addOutputProperty("exmnstdid", "ָ���ʶ");
		commonExportBean.addOutputProperty("exmnstdname", "ָ������");
		commonExportBean.addOutputProperty("isvoted", "�����");
		commonExportBean.addOutputProperty("exmnscore", "ָ������");
		commonExportBean.voClassArray = new Class[] { VItemgradedWayVO.class };
		commonExportBean.queryMethodName = "doGetItemgradedWayInfo";
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, commonExportBean);
		if (commonExportBean.headtitle == null) {
			commonExportBean.headtitle = commonExportBean.getFileName();
		}
		commonExportBean.buildExcelPage(actionMapping, actionForm, request, response, user, this);
		return actionMapping.findForward(null);
    }
    /**
	 * �鿴��Ϣ
	 */
	public ActionForward doGetItemgradedWayInfo(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		ItemgradedDelegate delegate=new ItemgradedDelegate();
		ItemgradedListVO listvo = new ItemgradedListVO();
		BaseActionForm baseActionForm = (BaseActionForm) actionForm;
		listvo.set_pageno(baseActionForm.get_pageno());
		listvo.set_pagesize(baseActionForm.get_pagesize());
		
		//setListVO(listvo, actionForm);
		DataPackage pack =delegate.doGetItemgradedWayInfo(listvo, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		return null;
	}
}
