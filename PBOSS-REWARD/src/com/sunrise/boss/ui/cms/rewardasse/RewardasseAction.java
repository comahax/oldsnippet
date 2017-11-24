/**
 * auto-generated code
 * Thu Jan 31 15:08:13 CST 2008
 */
package com.sunrise.boss.ui.cms.rewardasse;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.rewardasse.persistent.RewardasseVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.delegate.cms.rewardasse.RewardasseDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: RewardasseAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xiangyin
 * @version 1.0
 */
public class RewardasseAction extends BaseDelegateAction {
	public RewardasseAction() {
		//以下几个方法是必须的 
		//指定VO类 
		setVoClass(RewardasseVO.class);
		//指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
		this.pkNameArray = new String[3];
		pkNameArray[0] = "assemonth";
		pkNameArray[1] = "rewardtype";
		pkNameArray[2] = "wayid";
	}

	/**
	 * 查询
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			Serializable pkVO = new SysparamVO();
			CommonDelegate comdelegate = new CommonDelegate(SysparamVO.class);
			BeanUtils.setProperty(pkVO, "systemid", "1");
			BeanUtils.setProperty(pkVO, "paramtype", "pboss_kh");
			SysparamVO sysparamVO = (SysparamVO) comdelegate.doFindByPk(pkVO,
					user);
			if ("1".equals(sysparamVO.getParamvalue())) {
				request.setAttribute("invalid", "A");
			}
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return super.doList(actionMapping, actionForm, request, response, user);
	}
	
	/**
	 * 保存
	 */
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			boolean cando = false;
			RewardasseForm form = (RewardasseForm) actionForm;
			RewardasseDelegate delegate = new RewardasseDelegate();
			cando = delegate.doQueryRewardtype(form.getRewardtype(), user);
			if (cando) {
				return super.doSave(actionMapping, actionForm, request,
						response, user);
			} else {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"参数值不正确, 不允许新增该类型的考核系数！");
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_SAVE);
				return actionMapping.findForward("content");
			}
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return actionMapping.findForward("content");
	}
}
