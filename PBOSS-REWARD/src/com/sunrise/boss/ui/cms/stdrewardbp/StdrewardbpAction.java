/** 
 * auto-generated code
 * Fri Feb 01 18:09:59 CST 2008
 */
package com.sunrise.boss.ui.cms.stdrewardbp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardListVO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.business.cms.stdrewardbp.persistent.StdrewardbpListVO;
import com.sunrise.boss.business.cms.stdrewardbp.persistent.StdrewardbpVO;
import com.sunrise.boss.business.cms.stdrewardbp.persistent.StdrewardbpdVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.stdreward.StdrewardDelegate;
import com.sunrise.boss.delegate.cms.stdrewardbp.StdrewardbpDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: StdrewardbpAction
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
public class StdrewardbpAction extends BaseDelegateAction {
	public StdrewardbpAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(StdrewardbpVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[2];
		// pkNameArray[0] = "region";
		pkNameArray[0] = "rewardid";
	}

	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("list");
	}  
	
	// ����
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		StdrewardbpDelegate delegate = new StdrewardbpDelegate();
		StdrewardbpVO stdrewardbpVO = new StdrewardbpVO();
		StdrewardVO stdrewardVO = new StdrewardVO();
		StdrewardbpdVO stdrewardbpdVO = new StdrewardbpdVO();
		try {
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					stdrewardbpVO, actionForm);
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					stdrewardVO, actionForm);
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				stdrewardbpdVO.setStdrewardbpVO(stdrewardbpVO);
				stdrewardbpdVO.setStdrewardVO(stdrewardVO);
				delegate.doUpdate(stdrewardbpdVO, user);
				BeanUtils.copyProperties(actionForm, stdrewardbpVO);
				BeanUtils.copyProperties(actionForm, stdrewardVO);// �Ѹ��º��ֵ����form������web��ʾ
				request
						.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
								"����ɹ�");
			} else {
				stdrewardVO.setRewardtype(new Short((short) 8));
				stdrewardbpVO.setRegion("999");
				stdrewardbpdVO.setStdrewardbpVO(stdrewardbpVO);
				stdrewardbpdVO.setStdrewardVO(stdrewardVO);
				delegate.doCreate(stdrewardbpdVO, user);

				BeanUtils.copyProperties(actionForm, stdrewardVO); // �Ѹ��º��ֵ����form������web��ʾ
				BeanUtils.copyProperties(actionForm, stdrewardbpVO); // �Ѹ��º��ֵ����form������web��ʾ
				request
						.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
								"����ɹ�");
			}
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
		}
		String str = request.getParameter("STR");
		return (actionMapping.findForward(str));
	}

	// ����
	public ActionForward doSavestar(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		StdrewardbpDelegate delegate = new StdrewardbpDelegate();
		StdrewardbpVO stdrewardbpVO = new StdrewardbpVO();
		StdrewardbpVO stdrewardbpVO1 = new StdrewardbpVO();
		StdrewardVO stdrewardVO = new StdrewardVO();
		StdrewardbpdVO stdrewardbpdVO = new StdrewardbpdVO();
		try {
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					stdrewardbpVO, actionForm);
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					stdrewardVO, actionForm);
			stdrewardbpVO1.setRewardid(stdrewardbpVO.getRewardid());
			stdrewardbpVO1.setRegion("999");
			stdrewardbpdVO.setStdrewardbpVO(stdrewardbpVO);
			stdrewardbpdVO.setStdrewardVO(stdrewardVO);
			if(delegate.doFindByPkstar(stdrewardbpVO1, user).getRewardstd().floatValue()< stdrewardbpVO.getRewardstd().floatValue()){
				throw new BusinessException("",
				"�й�˾�ĳ���׼Ӧ�ò�����ʡ��˾�ĳ���׼!");
			}else{
				delegate.doUpdate1(stdrewardbpdVO, user);
				BeanUtils.copyProperties(actionForm, stdrewardbpVO);
				BeanUtils.copyProperties(actionForm, stdrewardVO);// �Ѹ��º��ֵ����form������web��ʾ
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
			}
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
		}
		String str = request.getParameter("STR");
		return (actionMapping.findForward(str));
	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// Page.setPageSize(request, (BaseActionForm) actionForm);
		try {
			StdrewardDelegate delegate = new StdrewardDelegate();
			Page.setPageSize(request, (BaseActionForm) actionForm);
			StdrewardListVO listVO = new StdrewardListVO();
			setListVO(listVO, actionForm); // ���ú�listVO����Ϊ��ѯ����
			listVO.set_ne_rewardtype("8");
			DataPackage pack = (DataPackage) delegate.doQuery(listVO, user);

			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("list"));
	}

	public ActionForward doShowframe(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		String command = request.getParameter("truecmd");
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, command);
		request.setAttribute("rewardid", request.getParameter("PK"));

		return (actionMapping.findForward("frame"));
	}

	protected ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		setNewForm(actionForm);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
				WebConstant.COMMAND_STRING_EDIT);
		String str = request.getParameter("str");
		return (actionMapping.findForward(str));
	}

	protected ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		StdrewardbpDelegate delegate = new StdrewardbpDelegate();
		StdrewardbpdVO stdrewardbpdVO = new StdrewardbpdVO();
		StdrewardbpVO stdrewardbpVO = new StdrewardbpVO();
		StdrewardVO stdrewardVO = new StdrewardVO();
		String pk = request.getParameter("PK");
		stdrewardbpVO.setRegion("999");
		stdrewardbpVO.setRewardid(new Long(pk));
		String str = request.getParameter("str");
		if ("content1".equals(str)) {
			StdrewardbpListVO listvo = new StdrewardbpListVO();
			listvo.set_ne_rewardid(pk.toString());
			listvo.set_se_region(user.getCityid());
			DataPackage pack = new DataPackage();
			pack = delegate.doQuery(listvo, user);
			if (pack.getDatas().size() > 0) {
				stdrewardbpVO.setRegion(user.getCityid());
			} else {
				stdrewardbpVO.setRegion("999");
			}
		}
		stdrewardVO.setRewardid(new Long(pk));
		stdrewardbpdVO.setStdrewardbpVO(stdrewardbpVO);
		stdrewardbpdVO.setStdrewardVO(stdrewardVO);
		stdrewardbpdVO = delegate.doFindByPk(stdrewardbpdVO, user);
		BeanUtils.copyProperties(actionForm, stdrewardbpdVO.getStdrewardVO());
		BeanUtils.copyProperties(actionForm, stdrewardbpdVO.getStdrewardbpVO());
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
				WebConstant.COMMAND_STRING_EDIT);

		return (actionMapping.findForward(str));
	}

	protected ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			StdrewardbpdVO stdrewardbpdVO = new StdrewardbpdVO();
			StdrewardVO stdrewardVO = new StdrewardVO();
			StdrewardbpVO stdrewardbpVO = new StdrewardbpVO();
			String[] selectArray = ((StdrewardbpForm) actionForm)
					.get_selectitem();
			StdrewardbpDelegate delegate = new StdrewardbpDelegate();
			for (int i = 0; i < selectArray.length; i++) {
				stdrewardVO.setRewardid(new Long(selectArray[i]));
				stdrewardbpVO.setRewardid(new Long(selectArray[i]));
				// stdrewardbpVO.setRegion("999");
				stdrewardbpdVO.setStdrewardbpVO(stdrewardbpVO);
				stdrewardbpdVO.setStdrewardVO(stdrewardVO);
				if (selectArray[0].indexOf('|') == -1) { // ��һ����
					delegate.doRemove(stdrewardbpdVO, user);
				}

			}
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ɾ��ʧ��:"
					+ ex.getMessage());
		}
		return doList(actionMapping, actionForm, request, response, user);
	}

}
