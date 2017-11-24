/**
 * auto-generated code
 * Tue Feb 05 10:11:13 CST 2008
 */
package com.sunrise.boss.ui.cms.busicityload;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.busicityload.persistent.BusicityloadListVO;
import com.sunrise.boss.business.cms.busicityload.persistent.BusicityloadVO;
import com.sunrise.boss.business.cms.reward.busiload.persistent.BusiloadListVO;
import com.sunrise.boss.business.cms.reward.busiload.persistent.BusiloadVO;
import com.sunrise.boss.business.cms.reward.stdrewardbj.persistent.StdrewardbjListVO;
import com.sunrise.boss.business.cms.reward.stdrewardbj.persistent.StdrewardbjVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.busicityload.BusicityloadDelegate;
import com.sunrise.boss.delegate.cms.reward.busiload.BusiloadDelegate;
import com.sunrise.boss.delegate.cms.reward.stdrewardbj.StdrewardbjDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: BusicityloadAction
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
public class BusicityloadAction extends BaseDelegateAction {
	public BusicityloadAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(BusicityloadVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[2];
		pkNameArray[0] = "cityid";
		pkNameArray[1] = "opnid";
	}

	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		((BusicityloadForm)actionForm).setCityid(user.getCityid());
		return actionMapping.findForward("list");
	}
	
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		if (((BusicityloadForm)actionForm).get_se_cityid()!=null) {
			((BusicityloadForm)actionForm).setCityid(((BusicityloadForm)actionForm).get_se_cityid());
			((BusicityloadForm)actionForm).set_se_cityid(((BusicityloadForm)actionForm).get_se_cityid());
		}else {
				((BusicityloadForm)actionForm).setCityid(user.getCityid());
				((BusicityloadForm)actionForm).set_se_cityid(user.getCityid());
		}
		String opnid=((BusicityloadForm)actionForm).getOpnids();
		String se_opnid=((BusicityloadForm)actionForm).get_se_opnid();
		if(StringUtils.isEmpty(se_opnid) && StringUtils.isNotEmpty(opnid)){
			((BusicityloadForm)actionForm).set_se_opnid(opnid);
		}
		super.doList(actionMapping, actionForm, request, response, user);
		((BusicityloadForm)actionForm).set_se_opnid("");
		return actionMapping.findForward("list");
	}

	// 新增
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		BusicityloadForm form = (BusicityloadForm) actionForm;
		BusicityloadDelegate delegate = new BusicityloadDelegate();
		try {
			BusicityloadVO busicityloadVO = new BusicityloadVO();
			BusicityloadListVO busicityloadListVO = new BusicityloadListVO();
			BusicityloadListVO busicityloadListVO1 = new BusicityloadListVO();
			StdrewardbjListVO listvo = new StdrewardbjListVO();
			StdrewardbjDelegate stddelegate = new StdrewardbjDelegate();
			
			DataPackage list;
			DataPackage list1;
			DataPackage dp;
			
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					busicityloadVO, actionForm);

			busicityloadListVO1.set_se_cityid(user.getCityid());
			busicityloadListVO1.set_se_simcode(busicityloadVO.getSimcode());
			list1 = delegate.doQuery(busicityloadListVO1, user);

			busicityloadVO.setCreatetime(new Date());
			
			listvo.set_se_opnid(form.getOpnid());
			listvo.set_se_region("999");
			
			dp = stddelegate.doQuery(listvo, user);
			
			Iterator it = dp.getDatas().iterator();
			String bjRuleid = null;
			
			while(it.hasNext()){
				StdrewardbjVO bjvo = (StdrewardbjVO)it.next();
				bjRuleid = bjvo.getRuleid();
				if(StringUtils.isNotEmpty(bjRuleid)){
					break;
				}
			}
			
			if(StringUtils.isEmpty(bjRuleid)){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "上架失败，该业务无定义对应校验规则，请先定义校验规则（省公司).");
				return (actionMapping.findForward("content"));
			
				}else{
					if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
						delegate.doUpdate(busicityloadVO, user);
						BeanUtils.copyProperties(actionForm, busicityloadVO); // 把更新后的值赋给form，用于web显示
						request
								.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
										"保存成功");
					} else {
						busicityloadListVO.set_se_opnid(busicityloadVO.getOpnid());
						busicityloadListVO.set_se_cityid(busicityloadVO.getCityid());
						list = delegate.doQuery(busicityloadListVO, user);
						if (list.getDatas().size() < 1) {
							delegate.doCreate(busicityloadVO, user);
							BeanUtils.copyProperties(actionForm, busicityloadVO); // 把更新后的值赋给form，用于web显示
							request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
									"保存成功");
						} else {
							request.setAttribute(
									WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
									WebConstant.COMMAND_STRING_EDIT);
							request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
									"含有相同全省业务编码和地市标识的记录已经存在, 请输入其它信息");
							onDuplicatePk(actionMapping, actionForm, request, response,
									user);
						}
					}
				}
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
		}
		return (actionMapping.findForward("content"));
	}

	public ActionForward doSelcity(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			BusicityloadForm busicityloadForm = (BusicityloadForm) actionForm;
			DataPackage list;
			List formList = new ArrayList();
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					busicityloadForm, actionForm);
			BusiloadListVO listvo = new BusiloadListVO();
			BusiloadDelegate del = new BusiloadDelegate();
			listvo.set_se_loadtype("CITY");
			listvo.set_se_opnid(busicityloadForm.getOpnid());
			list = del.doQuery(listvo, user);
			if (list.getDatas().size() == 1) {
				formList = list.toList(BusiloadVO.class);
				Iterator it = formList.iterator();
				while (it.hasNext()) {
					BusiloadVO ob = (BusiloadVO) it.next();
					busicityloadForm.setCityid(ob.getLoadinfo());
				}
			} else {
				busicityloadForm.setCityid(user.getCityid());
			}
			BeanUtils.copyProperties(actionForm, busicityloadForm); // 把更新后的值赋给form，用于web显示

		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
		}
		return (actionMapping.findForward("content"));
	}

	/**
	 * 新建时,设置Form的默认值
	 */
	public void setNewForm(ActionForm actionForm) {
		BusicityloadForm theForm=(BusicityloadForm)actionForm;
		theForm.setState(new Short("1"));
		theForm.setCalcflag(new Short("1"));
	}

}
