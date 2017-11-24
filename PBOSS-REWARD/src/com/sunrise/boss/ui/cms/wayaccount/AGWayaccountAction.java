package com.sunrise.boss.ui.cms.wayaccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountListVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.wayaccount.WayaccountDelegate;

/**
 * AGWayaccountAction <br>
 * Description: 社会渠道：帐户资料专用Action
 * 
 * <br>
 * Company: Sunrise,Guangzhou</br>
 * 
 * @author yijianrong
 * @since 1.0
 * @version 1.0 2007-4-5
 */
public class AGWayaccountAction extends BaseDelegateAction {
	public AGWayaccountAction() {
		setVoClass(WayaccountVO.class);
		this.pkNameArray = new String[2];
		pkNameArray[0] = "accid";
		pkNameArray[1] = "wayid";
	}

	public void onDuplicatePk(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) {
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
				"相同账户标识和渠道编码已经存在, 请输入其他标识");

	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		try {
			String waysubtype = request.getParameter("WAYSUBTYPE");
			String wayid = request.getParameter("WAYID");
			WayaccountForm form = (WayaccountForm) actionForm;
			Page.setPageSize(request, form);
			if (wayid != null && !wayid.trim().equals("")) {
				form.set_se_wayid(wayid);
			}

			WayaccountListVO listVO = new WayaccountListVO();
			setListVO(listVO, form);

			if (listVO.getSubtype() == null
					|| listVO.getSubtype().trim().equals("")) {
				listVO.setSubtype(waysubtype);
			}

			WayaccountDelegate delegate = new WayaccountDelegate();
			DataPackage dp = delegate.queryByOprcodeAndType(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (BusinessException be) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, be
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("list"));
	}

	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		try {
			WayaccountForm form = (WayaccountForm) actionForm;
			// 为了不影响已有的业务，再此调用BEAN的判断方法
			WayDelegate delegate = new WayDelegate();
			if (!delegate.isAGWay(form.getWayid(), form.getSubtype(), user)) {
				throw new BusinessException("AGWAY_ERR01", "渠道编码："
						+ form.getWayid() + "；该渠道不属于社会渠道或对应的子渠道类型不正确，请重新选择渠道");
			}
			return super.doSave(actionMapping, actionForm, request, response,
					user);
		} catch (BusinessException be) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, be
					.getMessage());
			return (actionMapping.findForward("content"));
		} catch (Exception e) {
			throw e;
		}

	}
}
