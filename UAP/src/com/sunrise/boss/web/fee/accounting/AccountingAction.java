/**
 * 
 */
package com.sunrise.boss.web.fee.accounting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import org.dom4j.Element;

import com.sunrise.boss.business.fee.acccounting.control.Accounting;
import com.sunrise.boss.business.fee.acccounting.control.AccountingBO;
import com.sunrise.boss.business.fee.acccounting.control.AccountingUtils;
import com.sunrise.boss.business.fee.acccounting.persistent.AccountingVO;
import com.sunrise.boss.business.fee.billing.bltouchrule.control.BlTouchRule;
import com.sunrise.boss.business.fee.billing.bltouchrule.control.BlTouchRuleBO;
import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleVO;
import com.sunrise.boss.business.fee.common.FEEUtils;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.common.utils.lang.StringSplit;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

 
/**
 * Title: CompanyDelegate Description: Copyright: Copyright (c) 2006 Company:
 * sunrise Tech Ltd.
 * 
 * @author Hanny Yeung,mys
 * @version 1.0
 */
public class AccountingAction extends BaseAction {
	
	private Map errmap = new HashMap();
	
	public AccountingAction() {
		super.setForm(new AccountingForm());		
		
		super.setClsControl(Accounting.class);		
		super.setClsVO(AccountingVO.class);
		
		super.pkNameArray =new String[]{};
	}

	public String doJustset() throws Exception {
		User user = (User) super.getDBAccessUser();
		AccountingForm form = (AccountingForm) super.getForm();

//		if (!FEEUtils.chkPurView("ACCOUNTING", user)) {
//			super.getRequest().setAttribute("_PURVIEW", "FALSE");
//			form.setRegiongroup(!user.isProvinceUser() ? AccountingUtils
//					.getCityCompid(user.getCityid()) : null);
//		}

		super.getRequest().setAttribute("_se_batchnum", form.get_se_batchnum());
		super.getRequest().setAttribute("_ne_validbillcyc", form.get_ne_validbillcyc());
		super.getRequest().setAttribute("regiongroup", form.getRegiongroup());

		return "justset";
	}

	public String doList() throws Exception {

		AccountingForm form = (AccountingForm) super.getForm();
		
//		if (!FEEUtils.chkPurView("ACCOUNTING", user)) {
//			form.setRegiongroup(!user.isProvinceUser() ? AccountingUtils
//					.getCityCompid(user.getCityid()) : null);
//		}
		User user = (User) super.getDBAccessUser();
		if (null != form.get_ne_validbillcyc()
				&& !"".equals(form.get_ne_validbillcyc())
				&& null != form.get_se_batchnum()
				&& !"".equals(form.get_se_batchnum())
				&& null != form.getRegiongroup()
				&& !"".equals(form.getRegiongroup())) {
			try{
				AccountingVO listVO = new AccountingVO();
//				setListVO(listVO, form);
				BeanUtils.copyProperties(listVO, form);
				Accounting delegate = (Accounting) BOFactory.build(AccountingBO.class, super.getDBAccessUser());
//				AccountingDelegate delegate = new AccountingDelegate();
				List list = delegate.doAccounting(listVO, user);
	
				if (null != list && list.size() > 0) {
					super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, list);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
			}
		}
		return "list";
	}
	
	
	public String doTjlist() throws Exception {

		AccountingForm form = (AccountingForm) super.getForm();

//		if (!FEEUtils.chkPurView("ACCOUNTING", user)) {
//			form.setRegiongroup(!user.isProvinceUser() ? AccountingUtils
//					.getCityCompid(user.getCityid()) : null);
//		}

		if (null != form.get_ne_validbillcyc() && !"".equals(form.get_ne_validbillcyc())
				&& null != form.get_se_batchnum() && !"".equals(form.get_se_batchnum())
				&& null != form.getRegiongroup() && !"".equals(form.getRegiongroup())) {
			
			try{
				AccountingVO listVO = new AccountingVO();
//				setListVO(listVO, form);
				BeanUtils.copyProperties(listVO, form);
				Accounting delegate = (Accounting) BOFactory.build(AccountingBO.class, super.getDBAccessUser());
//				AccountingDelegate delegate = new AccountingDelegate();
				User user = (User) super.getDBAccessUser();
				List list = delegate.doTJAccounting(listVO, user);
	
				if (null != list && list.size() > 0) {
					super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, list);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
			}
		}
		return "list1";
	}


	public String doStartup() throws Exception {

		AccountingForm listform = (AccountingForm) super.getForm();

		AccountingVO listVO = new AccountingVO();
		BeanUtils.copyProperties(listVO, listform);

		listVO.setCityid(AccountingUtils.getCityid(super.getRequest().getParameter("_CITYID")));
		listVO.setStepKey(super.getRequest().getParameter("_KEY"));
		listVO.setStartrsn(super.getRequest().getParameter("_STARTRSN"));
		
		try {
//			if (FEEUtils.chkPurView("ACCOUNTING", user)
//					|| FEEUtils.chkPurView(user, listVO.getCityid())) {
//				;
//			} else {
//				throw new Exception(listVO.getCityid() + ":  你没权限操作");
//			}
			
			User user = (User) super.getDBAccessUser();

			BlTouchRuleVO btrvo = getBtrVO(super.getParam().get_pk(), listVO.getCityid(), user);
					
			if (null == btrvo) {
				throw new Exception(listVO.getCityid() + ":  找不到出帐触发规则");
			} else {
				listVO.setBtrvo(btrvo);

				Accounting delegate = (Accounting) BOFactory.build(AccountingBO.class, super.getDBAccessUser());
				delegate.doStartUp(listVO, user);
				super.addActionMessage("启动成功!");				
			}
		} catch (Exception ex) {
			ex.printStackTrace();

			super.addActionMessage(ex.getMessage());
		}

		return doList();
	}

	public String doBatchstartup() throws Exception {

		AccountingForm listform = (AccountingForm) super.getForm();
		String stepKey = super.getRequest().getParameter("_KEY");
		String[] selectArray = getSelectArray(listform, stepKey);
		User user = (User) super.getDBAccessUser();
		AccountingVO listVO = new AccountingVO();
		BeanUtils.copyProperties(listVO, listform);

		listVO.setStartrsn(super.getRequest().getParameter("_STARTRSN"));
		listVO.setStepKey(stepKey);
		Accounting delegate = (Accounting) BOFactory.build(AccountingBO.class, super.getDBAccessUser());

		StringBuffer message = new StringBuffer();

		for (int i = 0; i < selectArray.length; i++) {
			try {
				String[] item = StringSplit.split(selectArray[i], "|");
				listVO.setCityid(AccountingUtils.getCityid(item[1]));
				

//				if (FEEUtils.chkPurView("ACCOUNTING", user)
//						|| FEEUtils.chkPurView(user, listVO.getCityid())) {
//					;
//				} else {
//					throw new Exception(listVO.getCityid() + ": 你没权限操作");
//				}

				BlTouchRuleVO btrvo = getBtrVO(item[0], item[1], user);
				if (null == btrvo) {
					message.append(i + "," + item[1] + "  找不到出帐触发规则!<br>");
					continue;
				}
				listVO.setBtrvo(btrvo);
				delegate.doBatchStartUp(listVO, user);
				message.append(i + "," + item[1] + " 启动成功!<br>");
			} catch (Exception ex) {
				ex.printStackTrace();
				message.append(i + "," + listVO.getCityid() + ex.getMessage() + "<br>");
			}
		}
		super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, message
				.toString());

		return doList();
	}

	public String doShowlog() throws Exception {
		
		String validbillcyc = super.getRequest().getParameter("_VALIDBILLCYC");
		String batchnum = super.getRequest().getParameter("_BATCHNUM");
		String cityid = super.getRequest().getParameter("_CITYID");
				
		String billingphase = super.getRequest().getParameter("_BILLINGPHASE");
		String ruleid = super.getRequest().getParameter("_RULEID");
		
		if (null != validbillcyc && !"".equals(validbillcyc) && null != cityid
				&& !"".equals(cityid) && null != batchnum
				&& !"".equals(batchnum) && null != billingphase
				&& !"".equals(billingphase)) {			
			
//			Page.setPageSize(request, (BaseActionForm) actionForm);
			AccountingVO listVO = new AccountingVO();
			

			BeanUtils.copyProperties(listVO, super.getForm());

			listVO.set_ne_validbillcyc(validbillcyc);
			listVO.set_se_batchnum(batchnum);
			listVO.setCityid(cityid);
			listVO.set_se_billingphase("1010".equals(billingphase) ? "101" : billingphase);
			User user = (User) super.getDBAccessUser();
			
			Accounting delegate = (Accounting) BOFactory.build(AccountingBO.class, super.getDBAccessUser());
			
			List list = delegate.doShowLog(listVO, user);		
			
			super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, list);
			super.getRequest().setAttribute("BILLINGPHASE", billingphase);
			///////////////2013-12-17
			super.getRequest().setAttribute("_BRTVO", getBtrVO(ruleid, cityid, user));
		
			super.getRequest().setAttribute("_CITYID", cityid);

		}

		return "billinglog";
	}

	private User getNewUser(User user, String cityid) {
		User newUser = new User();
		try {
			BeanUtils.copyProperties(newUser, user);
			newUser.setCityid(cityid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newUser;
	}

	private String[] getSelectArray(AccountingForm listform, String stepKey) {
		String[] selectArray = null;
		if ("USR".equals(stepKey)) {
			selectArray = listform.get_selectitem1();
		}
		if ("ACC".equals(stepKey)) {
			selectArray = listform.get_selectitem2();
		}
		if ("CFM".equals(stepKey)) {
			selectArray = listform.get_selectitem3();
		}
		if ("WOF".equals(stepKey)) {
			selectArray = listform.get_selectitem4();
		}
		return selectArray;
	}

	private BlTouchRuleVO getBtrVO(String ruleid, String cityid, User user) {
		try {

			BlTouchRule delegate = (BlTouchRule) BOFactory.build(BlTouchRuleBO.class, user);
			/////2013-12-17
			BlTouchRuleVO btrvo = delegate.doFindByPk(new Long(ruleid),getNewUser(user, cityid));
			return btrvo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	
	
	
	
	public String doAccbill() throws Exception {

		AccountingForm form = (AccountingForm) super.getForm();

//		if (!FEEUtils.chkPurView("ACCOUNTING", user)) {
//			form.setRegiongroup(!user.isProvinceUser() ? AccountingUtils
//					.getCityCompid(user.getCityid()) : null);
//		}
		
		if (null != form.get_ne_validbillcyc() && !"".equals(form.get_ne_validbillcyc())
				&& null != form.get_se_batchnum() && !"".equals(form.get_se_batchnum())
				&& null != form.getRegiongroup() && !"".equals(form.getRegiongroup())) {
			
			try{
				
				AccountingVO listVO = new AccountingVO();
//				setListVO(listVO, form);
				BeanUtils.copyProperties(listVO, form);
				User user = (User) super.getDBAccessUser();
				Accounting delegate = (Accounting) BOFactory.build(AccountingBO.class, super.getDBAccessUser());
//				AccountingDelegate delegate = new AccountingDelegate();	
				
				List list = delegate.doAccBilling(listVO, user);				
				super.getRequest().setAttribute("ACCB_LIST", list);					
				
				setReq(request, delegate.doAccBill(listVO, user));							
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
				super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
			}
		}
		return "list";
	}	
	
	
	private String doAccbilling() throws Exception {
		
		AccountingForm form = (AccountingForm) super.getForm();

//		if (!FEEUtils.chkPurView("ACCOUNTING", user)) {
//			form.setRegiongroup(!user.isProvinceUser() ? AccountingUtils
//					.getCityCompid(user.getCityid()) : null);
//		}

		if (null != form.get_ne_validbillcyc() && !"".equals(form.get_ne_validbillcyc())
				&& null != form.get_se_batchnum() && !"".equals(form.get_se_batchnum())
				&& null != form.getRegiongroup() && !"".equals(form.getRegiongroup())) {
			
			try{
				User user = (User) super.getDBAccessUser();
				AccountingVO listVO = new AccountingVO();
//				setListVO(listVO, form);	
//				AccountingDelegate delegate = new AccountingDelegate();	
				BeanUtils.copyProperties(listVO, form);
				
				Accounting delegate = (Accounting) BOFactory.build(AccountingBO.class, super.getDBAccessUser());
				
				super.getRequest().setAttribute("ACCB_LIST", delegate.doAccBilling(listVO, user));			
				
			} catch (Exception ex) {
				ex.printStackTrace();
				super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
			}
		}		
		return "list";	
	}
	
	public String doAccbillingdet() throws Exception {		

		AccountingForm form = (AccountingForm) super.getForm();
		String forward = super.getRequest().getParameter("_FORWARD");
		
		form.set_ne_validbillcyc(super.getRequest().getParameter("_VALIDBILLCYC"));
		form.set_se_batchnum(super.getRequest().getParameter("_BATCHNUM"));
		form.setRegiongroup(super.getRequest().getParameter("_REGIONGROUP"));	
		form.setIsshowlog(AccountingUtils.startStep2Num(forward));
		
		
		doTjlist();
		
		
		return forward;	
	}
	
	public String doAccbilldet() throws Exception {

		AccountingForm form = (AccountingForm) super.getForm();
		form.set_ne_validbillcyc(super.getRequest().getParameter("_VALIDBILLCYC"));
		if (null != form.get_ne_validbillcyc() && !"".equals(form.get_ne_validbillcyc())) {
			
			try{
				User user = (User) super.getDBAccessUser();
				AccountingVO listVO = new AccountingVO();
//				setListVO(listVO, form);
	
//				AccountingDelegate delegate = new AccountingDelegate();	
				BeanUtils.copyProperties(listVO, form);
				
				Accounting delegate = (Accounting) BOFactory.build(AccountingBO.class, super.getDBAccessUser());
				
				
				
				setReq(super.getRequest(),delegate.doAccBillDet(listVO, user));				
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
				super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
			}
		}
		return "list1";
	}
	
	
	public String doJustset1() throws Exception {

		return doJustset();

	}
	
	
	private void setReq(HttpServletRequest request,Map map){
		if(null != map){			
			Iterator iterItems = map.keySet().iterator();
			while( iterItems.hasNext() ){
				String key = (String) iterItems.next();
				super.getRequest().setAttribute(key, map.get(key));            	
            }
		}
	}

}
