/**
* auto-generated code
* Sat Dec 03 10:12:28 CST 2011
*/
package com.sunrise.boss.ui.cms.bbc.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationListVO;
import com.sunrise.boss.business.cms.bbc.service.persistent.ServiceVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.bbc.operation.BBCoperationDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ServiceAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class ServiceAction extends BaseDelegateAction {
    public ServiceAction() {
            setVoClass(ServiceVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "opnid"; 
    }
    
    protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	ServiceForm serviceForm= (ServiceForm)actionForm;
    	BBCoperationDelegate operationDelegate =new BBCoperationDelegate();
		BBCoperationListVO coperationListVO=new BBCoperationListVO();
		coperationListVO.set_se_opnid(serviceForm.getOpnid());
		DataPackage dp=operationDelegate.doQuery(coperationListVO, user);
		if(dp.getRowCount()==0){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"业务编码不正确");
			return (actionMapping.findForward("content"));
		}
		return super.doSave(actionMapping, serviceForm, request, response, user);
    }
    
}
