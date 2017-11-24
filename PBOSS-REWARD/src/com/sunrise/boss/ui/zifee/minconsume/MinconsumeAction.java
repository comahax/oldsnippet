/**
 * auto-generated code
 * Fri Aug 08 14:58:15 CST 2008
 */
package com.sunrise.boss.ui.zifee.minconsume;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.business.zifee.minconsume.persistent.MinconsumeListVO;
import com.sunrise.boss.business.zifee.minconsume.persistent.MinconsumeVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.delegate.zifee.minconsume.MinconsumeDelegate;

/**
 * <p>
 * Title: MinconsumeAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class MinconsumeAction extends BaseDelegateAction {
	private MinconsumeDelegate delegate;

	public MinconsumeAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(MinconsumeVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[2];
		pkNameArray[0] = "effectiveinterval";
		pkNameArray[1] = "yxplanid";
	}

	public MinconsumeDelegate getDelegate2() throws Exception {
		if (delegate == null) {
			return new MinconsumeDelegate();
		} else {
			return delegate;
		}
	}

	protected ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		MinconsumeForm formForm = (MinconsumeForm) actionForm;
		MinconsumeListVO listVO = new MinconsumeListVO();
		BeanUtils.copyProperties(listVO, actionForm);
		if (getDelegate2().doQuery(listVO, user).getRowCount() > 0) {
			int result = getDelegate2().calcResult(formForm.get_ne_yxplanid(),
					user);
			formForm.setEffectiveinterval(new Integer(result));
		}
		return super.doNew(actionMapping, actionForm, request, response, user);
	}

	/**
	 * 删除
	 */
	protected ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		String pks[] = selectArray[0].split("\\|");
		if (new MinconsumeDelegate().canRemove(pks[1], pks[0], user)) {
			throw new BusinessException("", "要删除的记录被后来新增的其他记录所关联，请先删除其他记录");
		}
		MinconsumeVO vo = new MinconsumeVO();
		vo.setYxplanid(new Long(pks[1]));
		vo.setEffectiveinterval(new Integer(pks[0]));
		getDelegate2().doRemove(getDelegate2().doFindByPk(vo, user), user);
		return super.doList(actionMapping, actionForm, request, response, user);
	}

	/**
	 * 保存
	 */
	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			MinconsumeVO contentVO = new MinconsumeVO();
			setSaveVO(contentVO, actionForm); // 在此格式化处理好 vo 以保存

			MinconsumeDelegate delegate = new MinconsumeDelegate();
			String cmdState = ((BaseActionForm) actionForm).getCmdState();
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
				delegate.doUpdate(contentVO, user);
				BeanUtils.copyProperties(actionForm, contentVO); // 把更新后的值赋给form，用于web显示
				request
						.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
								"保存成功");
			} else {
				// 新增
				Object vo = null;
				Object pkVO = voClass.newInstance();
				BeanUtils.copyProperties(pkVO, contentVO);
				vo = delegate.doFindByPk((Serializable) pkVO, user);
				if (vo == null) {
					delegate.doCreate(contentVO, user);
					BeanUtils.copyProperties(actionForm, contentVO); // 把更新后的值赋给form，用于web显示
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"保存成功");
				} else {
					request.setAttribute(
							WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
							WebConstant.COMMAND_STRING_EDIT);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"主键重复");
					onDuplicatePk(actionMapping, actionForm, request, response,
							user);
				}
			}
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存失败:"
					+ ex.getMessage());
			request.setAttribute("EDIT", "TRUE");
			return (actionMapping.findForward("content"));
		}

		return (actionMapping.findForward("content"));
	}

}
