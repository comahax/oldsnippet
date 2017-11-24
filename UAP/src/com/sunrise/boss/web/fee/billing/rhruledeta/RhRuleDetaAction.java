/**
 * auto-generated code
 * Tue Mar 18 11:36:17 CST 2008
 */
package com.sunrise.boss.web.fee.billing.rhruledeta;

import org.apache.commons.beanutils.BeanUtils;


import com.sunrise.boss.business.fee.acccounting.control.AccountingUtils;

import com.sunrise.boss.business.fee.billing.rhruledeta.control.RhRuleDeta;
import com.sunrise.boss.business.fee.billing.rhruledeta.persistent.RhRuleDetaDBParam;
import com.sunrise.boss.business.fee.billing.rhruledeta.persistent.RhRuleDetaVO;
import com.sunrise.boss.business.fee.common.FEEUtils;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.common.commoncontrol.CommonBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;


/**
 * <p>
 * Title: RhRuleDetaAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author wkx
 * @version 1.0
 */
public class RhRuleDetaAction extends BaseAction {
	
	public RhRuleDetaAction() {
		
		super.setForm(new RhRuleDetaForm());
		super.setParam(new RhRuleDetaDBParam());
		
		super.setClsVO(RhRuleDetaVO.class);		
		super.setClsControl(RhRuleDeta.class);		
		
		// TODO: 给出主键的名字数组
		this.pkNameArray = new String[] { "ruleid" };
		
		setDbFlag(DBConstant.DB_FLAG_BILL);
	}

	/**
	 *  查询
	 */
	public String doList() throws Exception {
		User user = (User) super.getDBAccessUser();
		RhRuleDetaForm form = (RhRuleDetaForm) super.getForm();
		if(form.get_ne_region()==null){
			form.set_ne_region(user.getCityid());
		}
		try {
			/*
			if (!FEEUtils.chkPurView("ACCOUNTING", user)) {
				request.setAttribute("_PURVIEW", "FALSE");
				form.setCityid(!user.isProvinceUser() ? AccountingUtils
						.getCityCompid(user.getCityid()) : null);
			}

			if (null != form.getCityid() && !"".equals(form.getCityid())) {
				user = FEEUtils.getNewUser(user, AccountingUtils.getCityid(form
						.getCityid()));
				request.setAttribute("_CITYID", user.getCityid());
				super.doList(actionMapping, actionForm, request, response,user);
			}
			*/
			
			//校验是否具有出账权限
//			if (!FEEUtils.chkPurView("ACCOUNTING", user)) {
//				request.setAttribute("_PURVIEW", "FALSE");
//			}else{
				if(!user.isProvinceUser() && !form.get_ne_region().equals(user.getCityid())){
					form.set_ne_region(user.getCityid());
//					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, " 只能查看当前用户所在地市的信息！");
					super.setActionMessage("只能查看当前用户所在地市的信息！");
				}
				super.doList();
//			}
			
			
		} catch (Exception ex) {
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
			super.setActionMessage(ex.getMessage());
			ex.printStackTrace();
		}
		return "list";
	}

	/**
	 *  查询
	 */
	public String doShow() throws Exception {
		RhRuleDetaForm form = (RhRuleDetaForm) super.getForm();
		User user = (User) super.getDBAccessUser();
		/*
		if (!FEEUtils.chkPurView("ACCOUNTING", user)) {
			request.setAttribute("_PURVIEW", "FALSE");
			form.setCityid(!user.isProvinceUser() ? AccountingUtils
					.getCityCompid(user.getCityid()) : null);
		}
		if (null != form.getCityid() && !"".equals(form.getCityid())) {
			user = FEEUtils.getNewUser(user, AccountingUtils.getCityid(form
					.getCityid()));
		}*/
		
		////校验是否具有出账权限
//		if (!FEEUtils.chkPurView("ACCOUNTING", user)) {
//			request.setAttribute("_PURVIEW", "FALSE");
//		}else{
			if(!user.isProvinceUser() && !form.get_ne_region().equals(user.getCityid())){
				form.set_ne_region(user.getCityid());				
//				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "只能查看当前用户所在地市的信息！");
				super.setActionMessage("只能查看当前用户所在地市的信息！");
			}
//		}

		RhRuleDetaDBParam listvo=new RhRuleDetaDBParam();
//		setListVO(listvo, form); 
		CommonBO delegate = (CommonBO) BOFactory.build(CommonBO.class, user);
		delegate.setVoClass(RhRuleDetaDBParam.class);
		
//		CommonDelegate delegate = new CommonDelegate(voClass);
		DataPackage dp=delegate.doQuery(listvo);
		if(dp!=null&&dp.getDatas()!=null&&dp.getDatas().iterator().hasNext()){
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
			super.setDp(dp);
		}else{
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"没有对应的异常信息。");
			super.setActionMessage("没有对应的异常信息。");
		}
		
		return "show";
	}
	
	
	
//	public static void main(String[] arg) throws Exception{
//		RhRuleDetaListVO listvo=new RhRuleDetaListVO();
//		
//		CommonDelegate delegate = new CommonDelegate(RhRuleDetaVO.class);
//		
//		User user = new User();
//		user.setCityid( "756" );   //
//		user.setOpercode("testcode");
//		user.setOpername("test");
//		user.setWayid( "ZH" );
//		
//		DataPackage dp = delegate.doQuery(listvo,user);
//	}
}
