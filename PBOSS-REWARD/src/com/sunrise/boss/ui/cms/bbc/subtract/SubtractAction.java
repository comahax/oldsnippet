package com.sunrise.boss.ui.cms.bbc.subtract;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.subtract.persistent.SubtractListVO;
import com.sunrise.boss.business.cms.bbc.subtract.persistent.SubtractVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.bbc.subtract.SubtractDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;


/**
 * <p>
 * Title: SubtractAction
 * </p>
 * <p>
 * Description: 一次性支付酬金业务设置
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
public class SubtractAction extends BaseDelegateAction {

	public SubtractAction() {
		setVoClass(SubtractVO.class);
		this.pkNameArray = new String[1];
		pkNameArray[0] = "seq";
	}
	
	/**
	 * 保存
	 */
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		SubtractForm form = (SubtractForm)actionForm;
		SubtractVO vo = new SubtractVO();
		setSaveVO(vo,form);
		
		SubtractDelegate delegate = new SubtractDelegate();
		
		try {
			String cmdState = form.getCmdState();
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				vo = delegate.doUpdate(vo, user);
			} else {
				OperationDelegate opdelegate=new OperationDelegate();
				OperationVO nvo = opdelegate.doFindByPk(vo.getOnceopnid(), user);
				if (nvo == null) {
					request.setAttribute(
							WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
							WebConstant.COMMAND_STRING_EDIT);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "[一次性支付酬金业务编码]不存在");
					return (actionMapping.findForward("content"));
				} else {
					vo = delegate.doCreate(vo, user);
				}
			}
			BeanUtils.copyProperties(actionForm, vo);
			((BaseActionForm) actionForm)
					.setCmdState(WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			throw e;
		}
		
		return (actionMapping.findForward("content"));
	}
	
	/**
	 * 查询
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		SubtractForm form = (SubtractForm)actionForm;
		Page.setPageSize(request, form);
		
		SubtractDelegate delegate = new SubtractDelegate();
		SubtractListVO params = new SubtractListVO();
		BeanUtils.copyProperties(params, form);
		String sql = " onceopnid is not null ";//查询一次性支付酬金业务数据
		params.set_sql_subcondition(sql);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, delegate.doQuery(params, user));
		
		return actionMapping.findForward("list");
	}
}