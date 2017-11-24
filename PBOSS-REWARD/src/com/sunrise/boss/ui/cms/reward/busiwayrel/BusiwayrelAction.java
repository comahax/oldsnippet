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
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(BusiwayrelVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[2];
		pkNameArray[0] = "opnid";
		pkNameArray[1] = "wayid";
	}

	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BusiwayrelForm form = (BusiwayrelForm) actionForm;
		BusiwayrelVO contentVO = new BusiwayrelVO();
		setSaveVO(contentVO, actionForm); // 在此格式化处理好 vo 以保存
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
							"保存失败,渠道代码["+form.getWayid()+"]不存在!");
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
						"保存失败,["+form.getWayid()+"]不是本地市的社会渠道或不存在!");
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
							"保存失败,该记录在系统已存在!");}
				else{
					wayreldelegate.doCreate(contentVO, user);
					BeanUtils.copyProperties(actionForm, contentVO); // 把更新后的值赋给form，用于web显示
					request
						.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
								"保存成功!");
				}
			} else {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
						WebConstant.COMMAND_STRING_NEW);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"保存失败，该业务[" + form.getOpnid() + "]未在本地市上架，请先进行业务上架操作!");
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
