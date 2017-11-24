/**
 * auto-generated code
 * Wed Nov 18 10:31:12 CST 2009
 */
package com.sunrise.boss.ui.cms.examine.oprnwayid;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.examine.oprnwayid.persistent.OprnwayidListVO;
import com.sunrise.boss.business.cms.examine.oprnwayid.persistent.OprnwayidVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.examine.oprnwayid.OprnwayidDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: OprnwayidAction
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
 * @author LiZhaoLiang
 * @version 1.0
 */
public class OprnwayidAction extends BaseDelegateAction {
	public OprnwayidAction() {
		setVoClass(OprnwayidVO.class);
		// TODO: 给出主键的名字数组
		this.pkNameArray = new String[2];
		pkNameArray[0] = "operid";
		pkNameArray[1] = "wayid";
	}

	public ActionForward doEdittransf(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return (actionMapping.findForward("transfcontent"));
	}
	
	/**
	 * 权限交接
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doTransf(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String oldoperid = request.getParameter("oldoperid");
		String newoperid = request.getParameter("newoperid");
		OprnwayidDelegate delegate = new OprnwayidDelegate();
		try {
			delegate.doTransf(oldoperid, newoperid, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"渠道评分授权交接成功");
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return (actionMapping.findForward("transfcontent"));
	}

	/**
	 * 保存时系统参数判定, 一个被评分渠道只允许关联一个评分工号
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			OprnwayidForm form = (OprnwayidForm) actionForm;
			OprnwayidDelegate opndelegate = new OprnwayidDelegate();
			OprnwayidListVO opnlistvo = new OprnwayidListVO();
			SysparamDelegate sysdelegate = new SysparamDelegate();
			SysparamVO sysvo = new SysparamVO();
			sysvo.setSystemid(new Long(9));
			sysvo.setParamtype("pboss");
			sysvo = (SysparamVO) sysdelegate.doFindByPk(sysvo, user);
			if (sysvo != null && sysvo.getParamvalue().equals("1")) {
				opnlistvo.set_se_wayid(form.getWayid());
				DataPackage dp = opndelegate.doQuery(opnlistvo, user);
				if (dp != null && dp.getDatas().size() > 0) {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"新增失败, 一个被评分渠道只允许关联一个评分工号!");
				}else{
					return super.doSave(actionMapping, actionForm, request,
							response, user);
				}
			} else {
				return super.doSave(actionMapping, actionForm, request,
						response, user);
			}
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return actionMapping.findForward("content");
	}
}
