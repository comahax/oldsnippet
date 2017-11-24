/**
* auto-generated code
* Tue Nov 24 10:54:37 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.exmnperiod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.examine.examine.persistent.ExamineVO;
import com.sunrise.boss.business.cms.examine.exmnperiod.persistent.ExmnperiodVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightListVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.delegate.cms.examine.examine.ExamineDelegate;
import com.sunrise.boss.delegate.cms.examine.exmnperiod.ExmnperiodDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ExmnperiodAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnperiodAction extends BaseDelegateAction {
    public ExmnperiodAction() {
            setVoClass(ExmnperiodVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seqid"; 
    }
    
	protected ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		CommonDelegate comdelegate = new CommonDelegate(ProvincialrightVO.class);
        ProvincialrightListVO provincialrightList=new ProvincialrightListVO();
        provincialrightList.set_se_proopr(user.getOpercode());
        provincialrightList.set_se_rightid("CH_PROFOREXAMINE");
        if(comdelegate.doQuery(provincialrightList, user).getDatas().size()>0){
        	request.setAttribute("provincialright", "YES");
        }
        ExmnperiodForm form =(ExmnperiodForm) actionForm;
        ExamineDelegate examineDelegate=new ExamineDelegate();
        
        ExamineVO examineVO=examineDelegate.doFindByPk(Long.valueOf(form.get_ne_exmnid()+""), user) ;
        request.setAttribute("exmncityid", examineVO.getCityid());
		return super.doList(actionMapping, actionForm, request, response, user);
	}

	protected ActionForward doEdit(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		CommonDelegate comdelegate = new CommonDelegate(ProvincialrightVO.class);
        ProvincialrightListVO provincialrightList=new ProvincialrightListVO();
        provincialrightList.set_se_proopr(user.getOpercode());
        provincialrightList.set_se_rightid("CH_PROFOREXAMINE");
        if(comdelegate.doQuery(provincialrightList, user).getDatas().size()>0){
        	request.setAttribute("provincialright", "YES");
        }
        getContentVO(request, user, actionForm);
        ExmnperiodForm form =(ExmnperiodForm) actionForm;
        ExamineDelegate examineDelegate=new ExamineDelegate();
        
        ExamineVO examineVO=examineDelegate.doFindByPk(Long.valueOf(form.get_ne_exmnid()+""), user) ;
        request.setAttribute("exmncityid", examineVO.getCityid());
		return super.doEdit(actionMapping, actionForm, request, response, user);
	}

	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		ExmnperiodDelegate delegate = (ExmnperiodDelegate)getDelegate();
		ExmnperiodForm form =(ExmnperiodForm) actionForm;
		ExmnperiodVO vo =new ExmnperiodVO();
        BeanUtils.copyProperties(vo, form);
		if(delegate.doCheckBeingPeriod(vo, user)){//存在考核周期的交集
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "该范围内的考核周期已存在");
			return (actionMapping.findForward("content"));
		}
		return super.doSave(actionMapping, actionForm, request, response, user);
	}
    
}
