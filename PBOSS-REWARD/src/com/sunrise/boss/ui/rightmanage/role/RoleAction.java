/**
 * auto-generated code
 * Fri Oct 20 22:27:37 CST 2006
 */
package com.sunrise.boss.ui.rightmanage.role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.rightmanage.role.persistent.RoleListVO;
import com.sunrise.boss.business.rightmanage.role.persistent.RoleVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.rightmanage.role.RoleDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
/**
 * <p>
 * Title: RoleAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class RoleAction extends BaseAction {
	public RoleAction() {
		this.voClass = RoleVO.class;
		// TODO: 给出主键的名字数组
		this.pkNameArray = new String[] { "roleid" };
	}

	protected ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	RoleForm form = (RoleForm)actionForm;
    	Page.setPageSize(request, form);
		RoleDelegate delegate = new RoleDelegate();
    	RoleListVO listVO = new RoleListVO();
    	setListVO(listVO, form);
    	if(listVO.get_se_orgid() == null){
    		listVO.set_se_orgid(user.getWayid());
    	}
    	DataPackage dp = delegate.doQuery(listVO, user);
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    	return actionMapping.findForward("list");
    }
}
