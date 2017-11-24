/**
* auto-generated code
* Tue Sep 12 17:06:59 CST 2006
*/
package com.sunrise.boss.ui.cms.wayhierarchy;

import javax.servlet.http.*;

import org.apache.struts.action.*;

import com.sunrise.boss.business.cms.wayhierarchy.persistent.WayhierarchyVO;
import com.sunrise.boss.common.exception.business.*;
import com.sunrise.boss.delegate.cms.wayhierarchy.*;
import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.*;

/**
 * <p>Title: WayhierarchyAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayhierarchyAction extends BaseDelegateAction {
    public WayhierarchyAction() {
        this.voClass = WayhierarchyVO.class;       
        this.pkNameArray=new String[]{"parwayid","subwayid"};        
    }
    
    /**
     * 检查渠道层次关系完整性
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     */
    public ActionForward doCheck(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {    	
    	WayhierarchyDelegate delegate = new WayhierarchyDelegate();
    	try {
    		WayhierarchyForm form = (WayhierarchyForm)actionForm;
    		String baseWayId = form.getBaseWayId();
    		delegate.check(baseWayId, user);
    		
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "渠道层次完整.");
    	}catch(BusinessException e) {
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
    	}    	    		
    	return doList(actionMapping, actionForm, request, response, user);
    }	
    
    /**
     * 构建渠道层次关系完整性
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     */
    public ActionForward doBuild(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	WayhierarchyDelegate delegate = new WayhierarchyDelegate();
    	try { 
    		WayhierarchyForm form = (WayhierarchyForm)actionForm;
    		String baseWayId = form.getBaseWayId();
    		delegate.build(baseWayId,user);
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "构建或检查渠道层次完整性完毕.");
    	}catch(BusinessException e) {
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "构建或检查渠道层次完整性失败." + e.getMessage());
    	}    	
    	return doList(actionMapping, actionForm, request, response, user);
    }
}
