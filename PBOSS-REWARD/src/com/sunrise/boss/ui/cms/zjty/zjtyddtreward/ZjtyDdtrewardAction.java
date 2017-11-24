/**
 * auto-generated code
 * Tue Jul 07 16:26:52 CST 2009
 */
package com.sunrise.boss.ui.cms.zjty.zjtyddtreward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.zjty.zjtyddtreward.persistent.ZjtyDdtrewardVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ZjtyDdtrewardAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyDdtrewardAction extends BaseAction {
	public ZjtyDdtrewardAction() {
		setVoClass(ZjtyDdtrewardVO.class);
		// TODO: 给出主键的名字数组
		this.pkNameArray = new String[1];
		pkNameArray[0] = "seqid";
	}
	
	/**
	 * 自建他营酬金扣减保存
	 * 
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
		ZjtyDdtrewardForm form = (ZjtyDdtrewardForm) actionForm;
		ZjtyDdtrewardVO contentVO = new ZjtyDdtrewardVO();
		setSaveVO(contentVO, actionForm);
		WayListVO waylistvo = new WayListVO();
		WayDelegate wayDelegate = new WayDelegate();
		DataPackage dp;

		try {
			if (null != contentVO.getWayid()
					&& !"".equals(contentVO.getWayid())) {
				if (!wayDelegate.isWayExist(contentVO.getWayid(), user)) {
					request.setAttribute(
							WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
							WebConstant.COMMAND_STRING_EDIT);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"保存失败,渠道代码不存在");
					return (actionMapping.findForward("content"));
				}
			}

			waylistvo.set_se_wayid(form.getWayid());
			waylistvo.set_se_waytype("AG");
			waylistvo.set_se_waysubtype("ZJTY");
			waylistvo.set_ne_runmode("1");
			waylistvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user
					.getCityid()));
			dp = wayDelegate.doQuery(waylistvo, user);
			if (dp.getDatas().size() == 0) {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
						WebConstant.COMMAND_STRING_EDIT);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"保存失败,该渠道不是本地市的自建他营的渠道!");
				return (actionMapping.findForward("content"));
			}

			return super.doSave(actionMapping, actionForm, request, response,
					user);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("content"));
		}
	}
}
