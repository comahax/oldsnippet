/**
* auto-generated code
* Thu May 27 10:43:08 CST 2010
*/
package com.sunrise.boss.ui.cms.emprole;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.emprole.persistent.EmproleVO;
import com.sunrise.boss.delegate.cms.emprole.EmproleDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: EmproleAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimyy
 * @version 1.0
 */
public class EmproleAction extends BaseDelegateAction {
    public EmproleAction() {
            setVoClass(EmproleVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "ekey"; 
           pkNameArray[1] = "employeeid"; 
    }
    /**
	 * 保存
	 */
	protected ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		try{
		EmproleVO contentVO = new EmproleVO();
		setSaveVO(contentVO, actionForm); // 在此格式化处理好 vo 以保存

		EmproleDelegate delegate = new EmproleDelegate();
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
			delegate.doUpdate(contentVO, user);
			BeanUtils.copyProperties(actionForm, contentVO); // 把更新后的值赋给form，用于web显示
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		} else {// 新增
			Object vo = null;
			if (pkNameArray.length == 1) { // 单一主键
				Object pk = PropertyUtils.getNestedProperty(contentVO, pkNameArray[0]);
				// Object pk = BeanUtils.getProperty(contentVO, pkNameArray[0]);
				// 这里返回的是String类型
				if (pk != null) {
					vo = delegate.doFindByPk((Serializable) pk, user);
				}
			} else {// 复合主建
				Object pkVO = voClass.newInstance();
				BeanUtils.copyProperties(pkVO, contentVO);
				vo = delegate.doFindByPk((Serializable) pkVO, user);
			}
			if (vo == null) {
				delegate.doCreate(contentVO, user);
				BeanUtils.copyProperties(actionForm, contentVO); // 把更新后的值赋给form，用于web显示
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
			} else {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "主键重复");
				onDuplicatePk(actionMapping, actionForm, request, response, user);
			}
		}
		}catch(Exception ex)
		{
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
			return (actionMapping.findForward("content"));
		}
		return (actionMapping.findForward("content"));
	}
}
