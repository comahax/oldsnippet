/**
* auto-generated code
* Tue Aug 21 10:43:23 CST 2012
*/
package com.sunrise.boss.ui.cms.kdkhzl.chpwregisterbroad;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.BeanUtils;

import com.sunrise.boss.business.cms.employee.persistent.EmployeeListVO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeVO;
import com.sunrise.boss.business.cms.kdkhzl.chpwbroadaccount.persistent.ChPwBroadaccountVO;
import com.sunrise.boss.business.cms.kdkhzl.chpwregisterbroad.persistent.ChPwRegisterbroadListVO;
import com.sunrise.boss.business.cms.kdkhzl.chpwregisterbroad.persistent.ChPwRegisterbroadVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.employee.EmployeeDelegate;
import com.sunrise.boss.delegate.cms.kdkhzl.chpwbroadaccount.ChPwBroadaccountDelegate;
import com.sunrise.boss.delegate.cms.kdkhzl.chpwregisterbroad.ChPwRegisterbroadDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChPwRegisterbroadAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
public class ChPwRegisterbroadAction extends BaseAction {
    public ChPwRegisterbroadAction() {
            setVoClass(ChPwRegisterbroadVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "broadid"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		
		ChPwRegisterbroadForm form = (ChPwRegisterbroadForm)actionForm;
		ChPwRegisterbroadDelegate chPwRegisterbroadDelegate = new ChPwRegisterbroadDelegate();
		ChPwRegisterbroadListVO chPwRegisterbroadListVO = new ChPwRegisterbroadListVO();
		
		//结束时间往后一天
		String dnm = form.get_dnm_regdate();
		if(dnm != null && !"".equals(dnm) && dnm.length() >= 10){
			dnm = dnm.substring(0,10) + " 23:59:59";
			form.set_dnm_regdate(dnm);
		}
		
		form.set_orderby("regdate");
		form.set_desc("asc");
		
    	setListVO(chPwRegisterbroadListVO, form);
		
    	DataPackage dp = (DataPackage)chPwRegisterbroadDelegate.doQuery(chPwRegisterbroadListVO, user);
    	
		if(dp != null && dp.getDatas() != null){
    		List<ChPwRegisterbroadForm> list = new ArrayList<ChPwRegisterbroadForm>();
    		for(ChPwRegisterbroadVO chPwRegisterbroadVO :(List<ChPwRegisterbroadVO>)dp.getDatas()){
    			ChPwRegisterbroadForm form1 = new ChPwRegisterbroadForm();
    			BeanUtils.copyProperties(chPwRegisterbroadVO, form1);
    			
    			if(form1.getOpnid()!=null && !"".equals(form1.getOpnid())){
    				OperationDelegate operationDelegate = new OperationDelegate();
					OperationVO operationVO = new OperationVO();
					operationVO = operationDelegate.doFindByPk(form1.getOpnid(), user);
					if(operationVO!=null){
						form1.setOpnname(operationVO.getName());
					}else{
						form1.setOpnname(form1.getOpnid());
					}
    			}
    			
    			if(form1.getState() != null){
    				if(form1.getState() == 0){
    					form1.setStatename("登记");
    				}else if(form1.getState() == 1){
    					form1.setStatename("作废");
    				}else if(form1.getState() == 2){
    					form1.setStatename("已补录");
    				}else{
    					form1.setStatename(""+form1.getState());
    				}
    			}
    			
    			list.add(form1);
    		}
    		dp.setDatas(list);
		}
		//去掉先前加的时分秒
		if(dnm != null && !"".equals(dnm) && dnm.length() >= 10){
			form.set_dnm_regdate(dnm.substring(0,10));
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return actionMapping.findForward("list");
    }
    
    public ActionForward doNew(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	ChPwRegisterbroadForm form = (ChPwRegisterbroadForm)actionForm;
    	form.setIsNew(WebConstant.COMMAND_STRING_NEW);
    	form.setIsEdit(WebConstant.COMMAND_STRING_EDIT);
		return super.doNew(actionMapping, actionForm, request, response, user);
	}
    
    public ActionForward doEdit(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	ChPwRegisterbroadForm form = (ChPwRegisterbroadForm)actionForm;
    	form.setIsNew(WebConstant.COMMAND_STRING_EDIT);
    	form.setIsEdit(WebConstant.COMMAND_STRING_EDIT);
		return super.doEdit(actionMapping, actionForm, request, response, user);
	}
    
    public ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	String cmdState = ((BaseActionForm) actionForm).getCmdState();
    	ChPwRegisterbroadForm form = (ChPwRegisterbroadForm)actionForm;
    	
    	String telephone = form.getTelephone();
    	String wayid = "";
    	if(telephone == null || "".equals(telephone)){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "公务机号码不能为空");
    		
    		form.setIsEdit(WebConstant.COMMAND_STRING_EDIT);
    		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
    			form.setIsNew(WebConstant.COMMAND_STRING_EDIT);
    		}else{
    			form.setIsNew(WebConstant.COMMAND_STRING_NEW);
    		}
    		return (actionMapping.findForward("content"));
    	}else{
    		EmployeeDelegate employeeDelegate = new EmployeeDelegate();
			EmployeeListVO employeeListVO = new EmployeeListVO();
			EmployeeVO employeeVO = new EmployeeVO();
			employeeListVO.set_se_officetel(telephone);
			employeeListVO.set_ne_empstatus("0");
			employeeListVO.set_nne_isnet("2");
			DataPackage eDataPackage = employeeDelegate.doQuery(employeeListVO, user);
			if(eDataPackage == null || eDataPackage.getDatas() == null
					|| eDataPackage.getDatas().size() <= 0){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"公务机号码在人员表中不存在");
				
				form.setIsEdit(WebConstant.COMMAND_STRING_EDIT);
	    		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
	    			form.setIsNew(WebConstant.COMMAND_STRING_EDIT);
	    		}else{
	    			form.setIsNew(WebConstant.COMMAND_STRING_NEW);
	    		}
	    		return (actionMapping.findForward("content"));
			}else{
				Iterator iterator =eDataPackage.getDatas().iterator();
				if(iterator.hasNext())
					employeeVO = (EmployeeVO)iterator.next();
				
				wayid = employeeVO.getWayid();
				if(wayid == null || "".equals(wayid)){
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"公务机号码无对应渠道编码");
					
					form.setIsEdit(WebConstant.COMMAND_STRING_EDIT);
		    		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
		    			form.setIsNew(WebConstant.COMMAND_STRING_EDIT);
		    		}else{
		    			form.setIsNew(WebConstant.COMMAND_STRING_NEW);
		    		}
		    		return (actionMapping.findForward("content"));
				}
				
			}
    	}
    	
    	String mobile = form.getMobile();
    	if(mobile == null || "".equals(mobile)){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "联系电话不能为空");
    		
    		form.setIsEdit(WebConstant.COMMAND_STRING_EDIT);
    		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
    			form.setIsNew(WebConstant.COMMAND_STRING_EDIT);
    		}else{
    			form.setIsNew(WebConstant.COMMAND_STRING_NEW);
    		}
    		return (actionMapping.findForward("content"));
    	}
    	
    	Short broadnum = form.getBroadnum();
    	if(broadnum == null || "".equals(broadnum)){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "宽带数量不能为空");
    		
    		form.setIsEdit(WebConstant.COMMAND_STRING_EDIT);
    		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
    			form.setIsNew(WebConstant.COMMAND_STRING_EDIT);
    		}else{
    			form.setIsNew(WebConstant.COMMAND_STRING_NEW);
    		}
    		return (actionMapping.findForward("content"));
    	}
    	
    	String opnid = form.getOpnid();
    	if(opnid == null || "".equals(opnid)){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "业务编码不能为空");
    		
    		form.setIsEdit(WebConstant.COMMAND_STRING_EDIT);
    		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
    			form.setIsNew(WebConstant.COMMAND_STRING_EDIT);
    		}else{
    			form.setIsNew(WebConstant.COMMAND_STRING_NEW);
    		}
    		return (actionMapping.findForward("content"));
    	}
    	
    	String wayidinput = form.getWayid();
    	if(wayidinput == null || "".equals(wayidinput)){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "渠道编码不能为空");
    		
    		form.setIsEdit(WebConstant.COMMAND_STRING_EDIT);
    		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
    			form.setIsNew(WebConstant.COMMAND_STRING_EDIT);
    		}else{
    			form.setIsNew(WebConstant.COMMAND_STRING_NEW);
    		}
    		return (actionMapping.findForward("content"));
    	}else{
    		if(!wayid.equals(wayidinput)){
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "输入的渠道编码:["+wayidinput+"]，和公务机对应的渠道编码["+wayid+"]，不相同");
        		
        		form.setIsEdit(WebConstant.COMMAND_STRING_EDIT);
        		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
        			form.setIsNew(WebConstant.COMMAND_STRING_EDIT);
        		}else{
        			form.setIsNew(WebConstant.COMMAND_STRING_NEW);
        		}
        		return (actionMapping.findForward("content"));
    		}
    	}
    	
		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
			
		}else{// 新增
			
			form.setRegdate(new Date());
		}
    	return super.doSave(actionMapping, actionForm, request, response, user);
    }
    
    public ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	ChPwRegisterbroadDelegate chPwRegisterbroadDelegate = new ChPwRegisterbroadDelegate();
    	ChPwBroadaccountDelegate chPwBroadaccountDelegate = new ChPwBroadaccountDelegate();
    	
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		for (int i = 0; i < selectArray.length; i++) {
			Long broadid = new Long(selectArray[i]);
			
			ChPwRegisterbroadVO chPwRegisterbroadVO = new ChPwRegisterbroadVO();
			chPwRegisterbroadVO.setBroadid(broadid);
			chPwRegisterbroadDelegate.doRemove(chPwRegisterbroadVO, user);
			
			ChPwBroadaccountVO ChPwBroadaccountVO = new ChPwBroadaccountVO();
			ChPwBroadaccountVO.setBroadid(broadid);
			chPwBroadaccountDelegate.doRemove(ChPwBroadaccountVO, user);
		}
		
		return doList(actionMapping, actionForm, request, response, user);
    }
}
