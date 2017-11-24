/**
 * auto-generated code
 * Fri Aug 25 11:16:40 CST 2006
 */
package com.sunrise.boss.ui.cms.cntycompany;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyListVO;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.cntycompany.CntycompanyDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: CntycompanyAction
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
 * @author yjr
 * @version 1.0
 */
public class CntycompanyAction extends BaseDelegateAction {
	public CntycompanyAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(CntycompanyVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[1];
		pkNameArray[0] = "countycompid";
	}

	public void onDuplicatePk(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) {
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
				"��ͬ������ع�˾�Ѿ�����, ��������������");
	}

	/**
	 * ��ѯ
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			CntycompanyListVO listvo = new CntycompanyListVO();
			setListVO(listvo, actionForm); // ���ú�listVO����Ϊ��ѯ����
			CntycompanyDelegate delegate = new CntycompanyDelegate();
			DataPackage pack = delegate.doQueryByOprcode(listvo, user);
			pack.setPageSize(20);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("list"));
	}

	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CntycompanyVO cntycompanyvo = new CntycompanyVO();
		setSaveVO(cntycompanyvo, actionForm); // �ڴ˸�ʽ������� vo �Ա���
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		CntycompanyDelegate delegate = new CntycompanyDelegate();
		String adacode = ((CntycompanyForm) actionForm).getAdacode();
		String orgcode = ((CntycompanyForm) actionForm).getCountycompid();
		String confirmorgcode = delegate.doGetOrgcode(adacode, user);

		try {
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				delegate.doUpdate(cntycompanyvo, user);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
				if (adacode != null && !adacode.equals("")) {
					try {
						if (delegate.doIfOrgcodenull(adacode, user)) {
//							delegate.doUpdateOrgcode(adacode, orgcode, user);
						}
					} catch (BusinessException e) {
						if (e.getCode().equals("CMS-915")) {
							request.setAttribute("affirm", "false");
							request.setAttribute("adacode", adacode);
							request.setAttribute("confirmorgcode",
									confirmorgcode);
							((BaseActionForm) actionForm)
									.setCmdState(WebConstant.COMMAND_STRING_EDIT);
							return (actionMapping.findForward("content"));
						}
					}
				}
			} else {
				delegate.doCreate(cntycompanyvo, user);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
				if (adacode != null && !adacode.equals("")) {
					try {
						if (delegate.doIfOrgcodenull(adacode, user)) {
							delegate.doUpdateOrgcode(adacode, orgcode, user);
						}
					} catch (BusinessException e) {
						if (e.getCode().equals("CMS-915")) {
							request.setAttribute("affirm", "false");
							request.setAttribute("adacode", adacode);
							request.setAttribute("confirmorgcode",
									confirmorgcode);
							((BaseActionForm) actionForm)
									.setCmdState(WebConstant.COMMAND_STRING_EDIT);
							return (actionMapping.findForward("content"));
						}
					}
				}
			}
			BeanUtils.copyProperties(actionForm, cntycompanyvo); // �Ѹ��º��ֵ����form������web��ʾ
			((BaseActionForm) actionForm)
					.setCmdState(WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("content"));
	}

	public ActionForward doChangeorg(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CntycompanyDelegate delegate = new CntycompanyDelegate();
		String adacode = ((CntycompanyForm) actionForm).getAdacode();
		String orgcode = ((CntycompanyForm) actionForm).getCountycompid();
		delegate.doUpdateOrgcode(adacode, orgcode, user);
		return (actionMapping.findForward("content"));
	}
}
