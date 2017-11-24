/**
* auto-generated code
* Sun Nov 29 14:15:38 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.coefficient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.examine.coefficient.persistent.CoefficientListVO;
import com.sunrise.boss.business.cms.examine.coefficient.persistent.CoefficientVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.examine.coefficient.CoefficientDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: CoefficientAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CoefficientAction extends BaseAction {
    public CoefficientAction() {
            setVoClass(CoefficientVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[3]; 
           pkNameArray[0] = "exmnid"; 
           pkNameArray[1] = "exmnperiod"; 
           pkNameArray[2] = "wayid"; 
    }
    
    
    protected ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	// TODO Auto-generated method stub
    	CoefficientForm form = (CoefficientForm) actionForm;
    	CoefficientListVO listvo = new CoefficientListVO();
    	Page.setPageSize(request, form);
    	setListVO(listvo, form);
    	CoefficientDelegate delegate = new CoefficientDelegate();
    	
    	DataPackage dp = delegate.doQuery(listvo, user);
    	
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    	return actionMapping.findForward("list"); 
    }
}
