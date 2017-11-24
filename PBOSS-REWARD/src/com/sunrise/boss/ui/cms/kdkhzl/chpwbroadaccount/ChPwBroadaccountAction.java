/**
* auto-generated code
* Tue Aug 21 10:45:16 CST 2012
*/
package com.sunrise.boss.ui.cms.kdkhzl.chpwbroadaccount;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.BeanUtils;

import com.sunrise.boss.business.cms.kdkhzl.chpwbroadaccount.persistent.ChPwBroadaccountVO;
import com.sunrise.boss.business.cms.kdkhzl.chpwregisterbroad.persistent.ChPwRegisterbroadListVO;
import com.sunrise.boss.business.cms.kdkhzl.chpwregisterbroad.persistent.ChPwRegisterbroadVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.kdkhzl.chpwbroadaccount.ChPwBroadaccountDelegate;
import com.sunrise.boss.delegate.cms.kdkhzl.chpwregisterbroad.ChPwRegisterbroadDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.cms.kdkhzl.chpwregisterbroad.ChPwRegisterbroadForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChPwBroadaccountAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
public class ChPwBroadaccountAction extends BaseAction {
    public ChPwBroadaccountAction() {
            setVoClass(ChPwBroadaccountVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "broadid"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		
		//ChPwRegisterbroadForm form = new ChPwRegisterbroadForm();
		ChPwBroadaccountForm form = (ChPwBroadaccountForm)actionForm;
		
		//结束时间往后一天
		String dnm = form.get_dnm_regdate();
		if(dnm != null && !"".equals(dnm) && dnm.length() >= 10){
			dnm = dnm.substring(0,10) + " 23:59:59";
			form.set_dnm_regdate(dnm);
		}
		
		ChPwRegisterbroadDelegate chPwRegisterbroadDelegate = new ChPwRegisterbroadDelegate();
		ChPwRegisterbroadListVO chPwRegisterbroadListVO = new ChPwRegisterbroadListVO();
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
    
    public ActionForward doCancel(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		String pk = request.getParameter("PK");
		ChPwRegisterbroadDelegate chPwRegisterbroadDelegate = new ChPwRegisterbroadDelegate();
		
		ChPwRegisterbroadVO chPwRegisterbroadVO = chPwRegisterbroadDelegate.doFindByPk(Long.parseLong(pk), user);
		chPwRegisterbroadVO.setState(Short.parseShort("1"));
		
		chPwRegisterbroadDelegate.doUpdate(chPwRegisterbroadVO, user);
		
		return this.doList(actionMapping, actionForm, request, response, user);
    }
    
    public ActionForward doTosave(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	String pk = request.getParameter("PK");
		ChPwRegisterbroadDelegate chPwRegisterbroadDelegate = new ChPwRegisterbroadDelegate();
		
		ChPwRegisterbroadVO chPwRegisterbroadVO = chPwRegisterbroadDelegate.doFindByPk(Long.parseLong(pk), user);
		ChPwBroadaccountForm form = (ChPwBroadaccountForm)actionForm;
		form.setBroadid(chPwRegisterbroadVO.getBroadid());
		form.setTelephone(chPwRegisterbroadVO.getTelephone());
		
		ChPwBroadaccountDelegate chPwBroadaccountDelegate = new ChPwBroadaccountDelegate();
    	ChPwBroadaccountVO chPwBroadaccountVO = chPwBroadaccountDelegate.doFindByPk(Long.parseLong(pk), user);
    	if(chPwBroadaccountVO != null){
    		form.setAccount(chPwBroadaccountVO.getAccount());
    	}
		    	
    	return (actionMapping.findForward("content"));
    }
    
    public ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	ChPwBroadaccountForm form = (ChPwBroadaccountForm)actionForm;
    	Long broadid = form.getBroadid();
    	//1
    	ChPwBroadaccountDelegate chPwBroadaccountDelegate = new ChPwBroadaccountDelegate();
    	ChPwBroadaccountVO chPwBroadaccountVO = chPwBroadaccountDelegate.doFindByPk(broadid, user);
    	if(chPwBroadaccountVO == null){
    		chPwBroadaccountVO = new ChPwBroadaccountVO();
    		chPwBroadaccountVO.setBroadid(broadid);
    		chPwBroadaccountVO.setAccount(form.getAccount());
    		
    		chPwBroadaccountDelegate.doCreate(chPwBroadaccountVO, user);
    	}else{
    		chPwBroadaccountVO.setAccount(form.getAccount());
    		
        	chPwBroadaccountDelegate.doUpdate(chPwBroadaccountVO, user);
    	}
    	
    	//2
    	ChPwRegisterbroadDelegate chPwRegisterbroadDelegate = new ChPwRegisterbroadDelegate();		
		ChPwRegisterbroadVO chPwRegisterbroadVO = chPwRegisterbroadDelegate.doFindByPk(broadid, user);
		chPwRegisterbroadVO.setState(Short.parseShort("2"));		
		chPwRegisterbroadDelegate.doUpdate(chPwRegisterbroadVO, user);
    	
    	return (actionMapping.findForward("content"));
    }
}
