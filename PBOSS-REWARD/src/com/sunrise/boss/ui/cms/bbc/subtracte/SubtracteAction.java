package com.sunrise.boss.ui.cms.bbc.subtracte;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.subtract.persistent.SubtractListVO;
import com.sunrise.boss.business.cms.bbc.subtract.persistent.SubtractVO;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.bbc.subtract.SubtractDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.cms.bbc.subtracti.SubtractiForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;


/**
 * <p>
 * Title: SubtractAction
 * </p>
 * <p>
 * Description: 内部员工号码设置
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author Yangdaren
 * @version 1.0 2008-08-26
 */
public class SubtracteAction extends BaseDelegateAction {

	public SubtracteAction() {
		setVoClass(SubtractVO.class);
		this.pkNameArray = new String[1];
		pkNameArray[0] = "seq";
	}	
	
	/**
	 * 查询
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		SubtracteForm form = (SubtracteForm)actionForm;
		Page.setPageSize(request, form);
		
		SubtractDelegate delegate = new SubtractDelegate();
		SubtractListVO params = new SubtractListVO();
		BeanUtils.copyProperties(params, form);
		String sql = " empmobile is not null ";//查询内部员工号码数据
		params.set_sql_subcondition(sql);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, delegate.doQuery(params, user));
		
		return actionMapping.findForward("list");
	}
}