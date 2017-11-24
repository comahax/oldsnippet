/**
* auto-generated code
* Sun Mar 06 16:14:54 CST 2011
*/
package com.sunrise.boss.ui.cms.empconfirm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.empconfirm.persistent.EmpconfirmListVO;
import com.sunrise.boss.business.cms.empconfirm.persistent.EmpconfirmVO;
import com.sunrise.boss.business.cms.empconfirm.persistent.VempconfirmVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.empconfirm.EmpconfirmDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: EmpconfirmAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
public class EmpconfirmAction extends BaseAction {
    public EmpconfirmAction() {
            setVoClass(EmpconfirmVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "confirmid"; 
    }
    
    /**
	 * 查询
	 */
	public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		EmpconfirmListVO listVO = new EmpconfirmListVO();
		setListVO(listVO, actionForm); // 设置好listVO，作Ordinary为查询条件
		EmpconfirmDelegate delegate = new EmpconfirmDelegate();
		DataPackage dp = delegate.doQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("list"));
	}

    
}
