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
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(YxplanpresntVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[3];
		pkNameArray[0] = "yxplanid";
		pkNameArray[1] = "acctid";
		pkNameArray[2] = "presentinterval";
	}

	/**
	 * 选择时侯调用.
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
			// 不做处理
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
	 * 保存
	 */
	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			YxplanpresntVO contentVO = new YxplanpresntVO();
			setSaveVO(contentVO, actionForm); // 在此格式化处理好 vo 以保存
			YxplanpresntDelegate delegate = new YxplanpresntDelegate();
			String cmdState = ((BaseActionForm) actionForm).getCmdState();
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
				delegate.doUpdate(contentVO, user);
				BeanUtils.copyProperties(actionForm, contentVO); // 把更新后的值赋给form，用于web显示
				request
						.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
								"保存成功");
			} else {// 新增
				Object vo = null;
				if (pkNameArray.length == 1) {
					// 单一主键
				} else {// 复合主建
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
					BeanUtils.copyProperties(actionForm, contentVO); // 把更新后的值赋给form，用于web显示
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"保存成功");
				} else {
					request.setAttribute(
							WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
							WebConstant.COMMAND_STRING_EDIT);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"新增失败，当前要保存的记录已存在");
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
	 * 保存
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
								"删除失败:删除多条记录时应删除[目标帐单科目标识]一致的所有记录");
				}
			} else if (selectArray.length == 1) {
				String[] items = StringUtils.split(selectArray[0], "|");
				DataPackage dp = getDescVO(items[0], items[1], user);
				if (dp != null) {
					if (!items[2].equals(String.valueOf(getFirstVO(dp, user)
							.getPresentinterval()))) {
						throw new BusinessException("",
								"删除出错:要删除的记录被后来新增的其他记录所关联，请先删除其他记录");
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
		// 按倒序排
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
