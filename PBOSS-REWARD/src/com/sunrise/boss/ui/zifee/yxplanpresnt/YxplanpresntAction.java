/**
 * auto-generated code
 * Tue Sep 18 15:52:13 CST 2007
 */
package com.sunrise.boss.ui.zifee.yxplanpresnt;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxanywhere.AAUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.zifee.yxplanpresnt.persistent.YxplanpresntListVO;
import com.sunrise.boss.business.zifee.yxplanpresnt.persistent.YxplanpresntVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.zifee.yxplanpresnt.YxplanpresntDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: YxplanpresntAction
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
public class YxplanpresntAction extends BaseDelegateAction {
	public YxplanpresntAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(YxplanpresntVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[3];
		pkNameArray[0] = "yxplanid";
		pkNameArray[1] = "acctid";
		pkNameArray[2] = "presentinterval";
	}

	/**
	 * ѡ��ʱ�����.
	 */
	public ActionForward doSelect(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String yxplanid = null;
		String acctid = null;
		YxplanpresntForm formValue = (YxplanpresntForm) actionForm;
		yxplanid = formValue.getYxplanid().toString();

		if (formValue.getAcctid() != null
				&& !"".equals(formValue.getAcctid().toString().trim())) {
			acctid = String.valueOf(formValue.getAcctid());
		} else {
			// ��������
		}
		DataPackage dp = getDescVO(yxplanid, acctid, user);
		if (dp.getRowCount() > 0) {
			YxplanpresntVO vo = getFirstVO(dp, user);

			int sum = vo.getPresentinterval().intValue()
					+ vo.getPresentcycles().intValue();
			request.setAttribute("DATA", new Integer(sum));
		} else {
			request.setAttribute("VALUE", "0");
		}
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "zonePresentcycles");
		}
		return (actionMapping.findForward("content"));
	}

	/**
	 * ����
	 */
	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			YxplanpresntVO contentVO = new YxplanpresntVO();
			setSaveVO(contentVO, actionForm); // �ڴ˸�ʽ������� vo �Ա���
			YxplanpresntDelegate delegate = new YxplanpresntDelegate();
			String cmdState = ((BaseActionForm) actionForm).getCmdState();
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// ����
				delegate.doUpdate(contentVO, user);
				BeanUtils.copyProperties(actionForm, contentVO); // �Ѹ��º��ֵ����form������web��ʾ
				request
						.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
								"����ɹ�");
			} else {// ����
				Object vo = null;
				if (pkNameArray.length == 1) {
					// ��һ����
				} else {// ��������
					YxplanpresntVO pkVO = new YxplanpresntVO();
					BeanUtils.copyProperties(pkVO, contentVO);
					vo = delegate.doFindByPk((Serializable) pkVO, user);
				}
				if (vo == null) {
					try {
						delegate.doCreate(contentVO, user);
					} catch (Exception ex) {
						request.setAttribute(
								WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
								WebConstant.COMMAND_STRING_EDIT);
						request.setAttribute(
								WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
										.getMessage());
						return (actionMapping.findForward("content"));
					}
					BeanUtils.copyProperties(actionForm, contentVO); // �Ѹ��º��ֵ����form������web��ʾ
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"����ɹ�");
				} else {
					request.setAttribute(
							WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
							WebConstant.COMMAND_STRING_EDIT);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"����ʧ�ܣ���ǰҪ����ļ�¼�Ѵ���");
					onDuplicatePk(actionMapping, actionForm, request, response,
							user);
				}
			}
			return (actionMapping.findForward("content"));
		} catch (Exception ex) {
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					WebConstant.COMMAND_STRING_NEW);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
			return (actionMapping.findForward("content"));
		}
	}

	protected void setListVO(Object listVO, final ActionForm listForm) {
		try {
			BeanUtils.copyProperties(listVO, listForm);
			String _desc = ((BaseActionForm) listForm).get_desc();
			String _orderby = ((BaseActionForm) listForm).get_orderby();
			if ("".equals(_desc) && "".equals(_orderby) || _desc == null
					&& _orderby == null) {
				((YxplanpresntListVO) listVO)
						.set_orderby("acctid,presentinterval");
				((YxplanpresntListVO) listVO).set_desc("asc,asc");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����
	 */
	public ActionForward doCheckfordelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			String[] selectArray = ((BaseActionForm) actionForm)
					.get_selectitem();
			if (selectArray.length > 1) {
				String acctid = StringUtils.substring(selectArray[0],
						StringUtils.indexOf(selectArray[0], '|') + 1,
						StringUtils.lastIndexOf(selectArray[0], '|'));
				for (int i = 1; i < selectArray.length; i++) {
					String tempAcctid = StringUtils.substring(selectArray[i],
							StringUtils.indexOf(selectArray[i], '|') + 1,
							StringUtils.lastIndexOf(selectArray[i], '|'));
					if (tempAcctid.equals(acctid))
						continue;
					else
						throw new BusinessException("",
								"ɾ��ʧ��:ɾ��������¼ʱӦɾ��[Ŀ���ʵ���Ŀ��ʶ]һ�µ����м�¼");
				}
			} else if (selectArray.length == 1) {
				String[] items = StringUtils.split(selectArray[0], "|");
				DataPackage dp = getDescVO(items[0], items[1], user);
				if (dp != null) {
					if (!items[2].equals(String.valueOf(getFirstVO(dp, user)
							.getPresentinterval()))) {
						throw new BusinessException("",
								"ɾ������:Ҫɾ���ļ�¼������������������¼������������ɾ��������¼");
					}
				}

			}
			return super.doDelete(actionMapping, actionForm, request, response,
					user);
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
			return super.doList(actionMapping, actionForm, request, response,
					user);
		}
	}

	private DataPackage getDescVO(String yxplanid, String acctid, User user)
			throws Exception {
		if ((yxplanid == null || "".equals(yxplanid) || (acctid == null || ""
				.equals(acctid)))) {
			throw new Exception("need two params");
		}
		YxplanpresntDelegate delegate = new YxplanpresntDelegate();
		YxplanpresntListVO listVO = new YxplanpresntListVO();
		listVO.set_ne_yxplanid(yxplanid);
		listVO.set_ne_acctid(acctid);
		// ��������
		listVO.set_desc("1");
		listVO.set_orderby("presentinterval");
		return delegate.doQuery(listVO, user);
	}

	private YxplanpresntVO getFirstVO(DataPackage dp, User user)
			throws Exception {
		Collection col = dp.getDatas();
		Iterator it = col.iterator();
		if (it.hasNext()) {
			return (YxplanpresntVO) it.next();
		} else {
			throw new Exception("empty DataPackage");
		}
	}

}
