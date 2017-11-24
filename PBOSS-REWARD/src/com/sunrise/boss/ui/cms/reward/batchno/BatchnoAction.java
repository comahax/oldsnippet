package com.sunrise.boss.ui.cms.reward.batchno;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.batchno.persistent.BatchnoListVO;
import com.sunrise.boss.business.cms.reward.batchno.persistent.BatchnoVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.reward.batchno.BatchnoDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: AdtcodeAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2008
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author LiZhaoliang
 * @version 1.0
 */
public class BatchnoAction extends BaseDelegateAction {
	public BatchnoAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(BatchnoVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[2];
		pkNameArray[0] = "batchno";
		pkNameArray[1] = "batchtype";
	}

	public ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			BatchnoVO vo = new BatchnoVO();
			BatchnoForm form = (BatchnoForm) actionForm;
			BatchnoDelegate delegate = new BatchnoDelegate();

			String[] pk = request.getParameter("PK").toString().split(",");
			vo.setBatchno(pk[0]);
			vo.setBatchtype(pk[1]);

			BatchnoVO cvo = delegate.doFindByPk(vo, user);
			if (cvo != null) {
				if (vo.getBatchtype().equals("AG")) {
					vo.setBatchtype("����������");
				} else if (vo.getBatchtype().equals("B2M")) {
					vo.setBatchtype("B2M��վ���");
				} else if (vo.getBatchtype().equals("UNPB")) {
					vo.setBatchtype("ȫԱ������");
				}
				BeanUtils.copyProperties(form, cvo);
			} else {
				if (vo.getBatchtype().equals("AG")) {
					vo.setBatchtype("����������");
				} else if (vo.getBatchtype().equals("B2M")) {
					vo.setBatchtype("B2M��վ���");
				} else if (vo.getBatchtype().equals("UNPB")) {
					vo.setBatchtype("ȫԱ������");
				}
				BeanUtils.copyProperties(form, vo);
				form.setCmdState(WebConstant.COMMAND_STRING_NEW);
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
						WebConstant.COMMAND_STRING_NEW);
				return actionMapping.findForward("content");
			}
			form.setCmdState(WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					WebConstant.COMMAND_STRING_EDIT);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return actionMapping.findForward("content");
	}

	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			BatchnoForm form = (BatchnoForm) actionForm;
			if (form.getBatchtype().equals("����������")) {
				form.setBatchtype("AG");
			} else if (form.getBatchtype().equals("B2M��վ���")) {
				form.setBatchtype("B2M");
			} else if (form.getBatchtype().equals("ȫԱ������")) {
				form.setBatchtype("UNPB");
			}
			super.doSave(actionMapping, actionForm, request, response, user);
			if (form.getBatchtype().equals("AG")) {
				form.setBatchtype("����������");
			} else if (form.getBatchtype().equals("B2M")) {
				form.setBatchtype("B2M��վ���");
			} else if (form.getBatchtype().equals("UNPB")) {
				form.setBatchtype("ȫԱ������");
			}
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return actionMapping.findForward("content");
	}
	
	public ActionForward doSelectbatchno(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm)actionForm);
		try{
			BatchnoListVO listvo = new BatchnoListVO();
			setListVO(listvo, actionForm);
			BatchnoDelegate delegate = new BatchnoDelegate();
			DataPackage dp = delegate.doQueryBySelectBatchno(listvo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST,dp);
		}catch (Exception e) {
			// TODO: handle exception
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		return actionMapping.findForward("selectbatchno");
	}
}
