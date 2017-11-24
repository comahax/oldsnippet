package com.sunrise.boss.ui.cms.bchcontact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactListVO;
import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.bchcontact.BchcontactDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;

/**
 * AGBchcontactAction <br>
 * Description: 社会渠道：联系资料专用Action
 * 
 * <br>
 * Company: Sunrise,Guangzhou</br>
 * 
 * @author yijianrong
 * @since 1.0
 * @version 1.0 2007-4-5
 */
public class AGBchcontactAction extends BaseDelegateAction {
	public AGBchcontactAction() {
		setVoClass(BchcontactVO.class);
		this.pkNameArray = new String[1];
		pkNameArray[0] = "wayid";
	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			String waysubtype = request.getParameter("WAYSUBTYPE");
			String wayid = request.getParameter("WAYID");
			BchcontactForm form = (BchcontactForm) actionForm;
			Page.setPageSize(request, form);
			if (wayid != null && !wayid.trim().equals("")) {
				form.set_se_wayid(wayid);
			}

			BchcontactListVO listVO = new BchcontactListVO();
			setListVO(listVO, form);

			if (listVO.getSubtype() == null
					|| listVO.getSubtype().trim().equals("")) {
				listVO.setSubtype(waysubtype);
			}

			BchcontactDelegate delegate = new BchcontactDelegate();
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

	/**
	 * 保存
	 */
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		try {
			BchcontactForm form = (BchcontactForm) actionForm;
			// 为了不影响已有的业务，再此调用BEAN的判断方法
			WayDelegate waydelegate = new WayDelegate();
			if (!waydelegate.isAGWay(form.getWayid(), form.getSubtype(), user)) {
				throw new BusinessException("AGWAY_ERR01", "渠道编码："
						+ form.getWayid() + "；该渠道不属于社会渠道或对应的子渠道类型不正确，请重新选择渠道");
			}

			BchcontactDelegate delegate = new BchcontactDelegate();
			BchcontactVO contentVO = new BchcontactVO();
			setSaveVO(contentVO, form);

			BchcontactVO existObj = null;
			existObj = delegate.doFindByPk(form.getWayid(), user);

			String cmdState = form.getCmdState();
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				if (existObj!=null){
					org.apache.commons.beanutils.BeanUtils.copyProperties(existObj,
							contentVO);
					contentVO = existObj;		
				}
				delegate.doUpdate(contentVO, user);
			} else {
				if (existObj != null) {
					request.setAttribute(
							WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
							WebConstant.COMMAND_STRING_EDIT);
					throw new BusinessException("", "已经存在该渠道编码："
							+ form.getWayid() + "的记录，请重新选择");
				} else {
					delegate.doCreate(contentVO, user);
				}
			}
			BeanUtils.copyProperties(actionForm, contentVO);
			form.setCmdState(WebConstant.COMMAND_STRING_EDIT);
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
	 * 编辑
	 */
	public ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		try {
			BchcontactForm form = (BchcontactForm) actionForm;
			getContentVO(request, form, user);

			String command = getCommandString(request);
			form.setCmdState(command);
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					WebConstant.COMMAND_STRING_EDIT);
		} catch (BusinessException be) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, be
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("content"));
	}

	/**
	 * getContentVO
	 * 
	 * @param request
	 * @param form
	 * @param user
	 * @throws Exception
	 */
	private void getContentVO(HttpServletRequest request, BchcontactForm form,
			User user) throws Exception {
		String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		if (pk == null)
			throw new NullPointerException("pk is required.");
		Object contentVO = getContentVO(request, user);

		if (contentVO == null) {
			form.setWayid(pk);
		} else {
			BeanUtils.copyProperties(form, contentVO);
		}
	}
}
