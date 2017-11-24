/**
 * auto-generated code
 * Fri Feb 15 15:25:15 CST 2008
 */
package com.sunrise.boss.ui.cms.reward.busiwayrel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.business.cms.busicityload.persistent.BusicityloadListVO;

import com.sunrise.boss.business.cms.reward.busiwayrel.persistent.BusiwayrelVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.busicityload.BusicityloadDelegate;
import com.sunrise.boss.delegate.cms.reward.busiwayrel.BusiwayrelDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;

/**
 * <p>
 * Title: BusiwayrelAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2009
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author li zhaoliang
 * @version 1.0
 */
public class BusiwayrelAction extends BaseDelegateAction {
	public BusiwayrelAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(BusiwayrelVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[2];
		pkNameArray[0] = "opnid";
		pkNameArray[1] = "wayid";
	}

	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BusiwayrelForm form = (BusiwayrelForm) actionForm;
		BusiwayrelVO contentVO = new BusiwayrelVO();
		setSaveVO(contentVO, actionForm); // �ڴ˸�ʽ������� vo �Ա���
		BusicityloadDelegate citydelegate = new BusicityloadDelegate();
		BusiwayrelDelegate wayreldelegate = new BusiwayrelDelegate();
		WayListVO waylistvo = new WayListVO();
		WayDelegate wayDelegate = new WayDelegate();
		DataPackage dp;
		DataPackage dp1;
		try {
			if (null != contentVO.getWayid()
					&& !"".equals(contentVO.getWayid())) {
				if (!wayDelegate.isWayExist(contentVO.getWayid(), user)) {
					request.setAttribute(
							WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
							WebConstant.COMMAND_STRING_NEW);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"����ʧ��,��������["+form.getWayid()+"]������!");
					return (actionMapping.findForward("content"));
				}
			}
			waylistvo.set_se_wayid(form.getWayid());
			waylistvo.set_se_waytype("AG");
			dp = wayDelegate.doQuery(waylistvo, user);
			if (dp.getDatas().size() <= 0){
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
						WebConstant.COMMAND_STRING_EDIT);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"����ʧ��,["+form.getWayid()+"]���Ǳ����е���������򲻴���!");
				return (actionMapping.findForward("content"));
			}
			
			BusicityloadListVO listVO = new BusicityloadListVO();
			listVO.set_se_opnid(form.getOpnid());
			listVO.set_se_cityid(user.getCityid());
			
			dp1 = citydelegate.doQuery(listVO, user);
			BusiwayrelVO tmpvo = wayreldelegate.doFindByPk(contentVO, user);
			
			if (dp1.getDatas().size() > 0) {
				if(tmpvo!=null){
					request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
							WebConstant.COMMAND_STRING_EDIT);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"����ʧ��,�ü�¼��ϵͳ�Ѵ���!");}
				else{
					wayreldelegate.doCreate(contentVO, user);
					BeanUtils.copyProperties(actionForm, contentVO); // �Ѹ��º��ֵ����form������web��ʾ
					request
						.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
								"����ɹ�!");
				}
			} else {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
						WebConstant.COMMAND_STRING_NEW);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"����ʧ�ܣ���ҵ��[" + form.getOpnid() + "]δ�ڱ������ϼܣ����Ƚ���ҵ���ϼܲ���!");
				onDuplicatePk(actionMapping, actionForm, request, response,
						user);
			}
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
		}
		return (actionMapping.findForward("content"));
	}
}
