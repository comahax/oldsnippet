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
    // TODO: 给出主键的名字数组
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
			//如果“参数值[PARAMVALUE]”为1，则只有在“渠道评分授权[CH_PW_OPRNWAYID]”表中存在映射关系才给进行评分；否则跳过限制
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
    	//根据系统标识=61,参数类型==channel查找系统参数对象
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
    	ItemgradedDelegate delegate=new ItemgradedDelegate();
    	String[] selectArray=null;
    	if("all".equals(submitType)){
    		List list=delegate.doFindAllSubmitSeqid(user);
			if(list==null||list.size()<=0){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "没有提交的项目!");
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
    			 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "无法获取选中项目");
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
			List list=exmnauditDelegate.doFindAllCallbackItemgradeds(user);//查找所有符合回收条件的考核项评分标识集合
			if(list==null||list.size()<=0){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "没有回收的项目!");
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
   		 		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "无法获取选中项目");
				return this.doList(actionMapping, actionForm, request, response, user);
			}
	   		 /**
		     * 根据考核登记ID数组查询验证能否被收回,返回不能被回收的考核登记标识集合
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
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "你所选中的序号["+values+"]不能被回收,请重新选择要回收记录！");
				return this.doList(actionMapping, actionForm, request, response, user);
			}
		}
		delegate.doCallbackInfo(selectArray,user);//执行回收相关操作(删除相关考核信息审核信息,更新考核项评分信息)
    	return this.doList(actionMapping, actionForm, request, response, user);
    }
    public ActionForward doShowexmnpage(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	//根据系统标识=61,参数类型==channel查找系统参数对象
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
		commonExportBean.setFileName("评分渠道导出");
		commonExportBean.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		commonExportBean.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });
		commonExportBean.addOutputProperty("wayid", "渠道代码");
		commonExportBean.addOutputProperty("wayname", "渠道名称");
		commonExportBean.addOutputProperty("adtypecode", "区域");
		commonExportBean.addOutputProperty("starlevel", "星级");
		commonExportBean.addOutputProperty("exmnid", "考核标识");
		commonExportBean.addOutputProperty("exmnname", "考核名称");
		commonExportBean.addOutputProperty("exmnstdid", "指标标识");
		commonExportBean.addOutputProperty("exmnstdname", "指标名称");
		commonExportBean.addOutputProperty("isvoted", "否决项");
		commonExportBean.addOutputProperty("exmnscore", "指标满分");
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
	 * 查看信息
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
