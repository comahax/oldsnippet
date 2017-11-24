
package com.sunrise.boss.web.fee.billing.rhtouchrule;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;


import com.sunrise.boss.business.fee.acccounting.control.Accounting;
import com.sunrise.boss.business.fee.acccounting.control.AccountingBO;
import com.sunrise.boss.business.fee.acccounting.control.AccountingUtils;
import com.sunrise.boss.business.fee.acccounting.persistent.AccountingVO;

import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogDBParam;
import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogVO;

import com.sunrise.boss.business.fee.billing.billstartlog.persistent.BillStartLogDBParam;
import com.sunrise.boss.business.fee.billing.billstartlog.persistent.BillStartLogVO;
import com.sunrise.boss.business.fee.billing.billstatus.control.BillStatusBO;
import com.sunrise.boss.business.fee.billing.billstatus.persistent.BillStatusDBParam;
import com.sunrise.boss.business.fee.billing.billstatus.persistent.BillStatusVO;
import com.sunrise.boss.business.fee.billing.billstepstatus.persistent.BillStepStatusVO;
import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleVO;

import com.sunrise.boss.business.fee.billing.rhtouchrule.control.RhTouchRuleBO;
import com.sunrise.boss.business.fee.billing.rhtouchrule.control.RhTouchRule;
import com.sunrise.boss.business.fee.billing.rhtouchrule.persistent.ResultVO;
import com.sunrise.boss.business.fee.billing.rhtouchrule.persistent.RhTouchRuleDBParam;

import com.sunrise.boss.business.fee.billing.rhtouchrule.persistent.RhTouchRuleVO;
import com.sunrise.boss.business.fee.common.FEEUtils;
import com.sunrise.boss.web.fee.accounting.AccountingForm;
import com.sunrise.boss.web.fee.billing.billstatus.BillStatusForm;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.common.commoncontrol.CommonBO;
import com.sunrise.jop.common.commoncontrol.CommonControl;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;


/**
 * Title: RhTouchRuleAction Description: Copyright: Copyright (c) 2006 Company:
 * sunrise Tech Ltd.
 * 
 * @author wkx,mys
 * @version 1.0
 */
public class RhTouchRuleAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(RhTouchRuleAction.class) ;

	public RhTouchRuleAction() {
		
		super.setForm(new RhTouchRuleForm());
		super.setParam(new RhTouchRuleDBParam());
		
		super.setClsVO(RhTouchRuleVO.class);
		super.setClsControl(RhTouchRule.class);
		
		super.pkNameArray = new String[] { "ruleid" };
		setDbFlag(DBConstant.DB_FLAG_BILL);
	}

	public String doSet() throws Exception {

		RhTouchRuleForm form = (RhTouchRuleForm) super.getForm();
		User user = (User) super.getDBAccessUser();
//		if (user.getCityid().equals("999")) {
//			if (FEEUtils.chkPurView("ACCOUNTING_HIGH", user)
//					|| FEEUtils.chkPurView("ACCOUNTING_LOW", user)) {
//				;
//			} else {
//				form.setRegiongroup("");
////				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
////						"您的工号没有权限查看！");
//				super.setActionMessage("您的工号没有权限查看！");
//			}
//		} else {
//			if (FEEUtils.chkPurView("ACCOUNTING_HIGH", user)
//					|| FEEUtils.chkPurView("ACCOUNTING_LOW", user)) {
//				;
//			} else {
//				form.setRegiongroup(AccountingUtils.getCityCompid(user
//						.getCityid()));
//			}
//		}

		super.getRequest().setAttribute("_ne_validbillcyc", form.get_ne_validbillcyc());
		super.getRequest().setAttribute("regiongroup", form.getRegiongroup());

		return "set";
	}

	/**
	 * 计费账务融合监控 总控界面
	 */
	public String doShow() throws Exception {

		RhTouchRuleForm form = (RhTouchRuleForm) super.getForm();
		User user = (User) super.getDBAccessUser();
		if (form.get_ne_validbillcyc() != null
				&& form.get_ne_validbillcyc().trim().length() == 8
				&& form.getRegiongroup() != null
				&& form.getRegiongroup().trim().length() > 0) {

			try {
				super.getRequest().setAttribute("simple", AccountingUtils.isSimple(form
						.getRegiongroup()));

				RhTouchRuleDBParam listvo = new RhTouchRuleDBParam();
//				setListVO(listvo, actionForm);	
//				RhTouchRuleDelegate delegate = new RhTouchRuleDelegate();
				RhTouchRule delegate = (RhTouchRule) BOFactory.build(RhTouchRuleBO.class, user);
				
				String[] result = delegate.doShow(listvo, user);// 监控总流程实时累帐部分

				super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, result);

//				AccountingDelegate delegate1 = new AccountingDelegate();
				Accounting delegate1 = (Accounting) BOFactory.build(AccountingBO.class, user);

				AccountingVO listVO = new AccountingVO();
//				setListVO(listVO, actionForm);
				listVO.set_se_batchnum("01");
				
				List list = delegate1.doAccBilling(listVO, user);//营帐出账全省进度
				super.getRequest().setAttribute("ACCB_LIST", list);

			} catch (Exception ex) {
				ex.printStackTrace();
//				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
//						.getMessage());
				super.setActionMessage(ex.getMessage());
			}
		}

		return "show";
	}

	/**
	 * 显示地市状态
	 */
	public String doCity() throws Exception {

		RhTouchRuleForm form = (RhTouchRuleForm) super.getForm();
		User user = (User) super.getDBAccessUser();
		if (form.get_ne_validbillcyc() != null
				&& form.get_ne_validbillcyc().trim().length() == 8
				&& form.getRegiongroup() != null
				&& form.getRegiongroup().trim().length() > 0) {
			try {
				RhTouchRuleDBParam listvo = new RhTouchRuleDBParam();
//				setListVO(listvo, actionForm);

				RhTouchRule delegate = (RhTouchRule) BOFactory.build(RhTouchRuleBO.class, user);
				List result = delegate.doCity(listvo);
				ResultVO vo = new ResultVO();//delegate.getFlResu(listvo, user);  //分流状态，暂注释，201205

				super.getRequest().setAttribute("FLFLAG", vo);
				super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, result);				
				
			} catch (Exception ex) {
				ex.printStackTrace();
//				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
//						.getMessage());
				super.setActionMessage(ex.getMessage());
			}
		}

		return "city";
	}

	// 显示多个地市营帐出账
	public String doAccbillingdet() throws Exception {

		RhTouchRuleForm form = (RhTouchRuleForm) super.getForm();
		User user = (User) super.getDBAccessUser();
		String step = super.getRequest().getParameter("_STEP");
		String validbillcyc = super.getRequest().getParameter("_VALIDBILLCYC");
		String regiongroup = super.getRequest().getParameter("_REGIONGROUP");

		if (null != step && !"".equals(step)) {
			form.setStep(step);
		}
		if (null != validbillcyc && !"".equals(validbillcyc)) {
			form.set_ne_validbillcyc(validbillcyc);
		}
		if (null != regiongroup && !"".equals(regiongroup)) {
			form.setRegiongroup(regiongroup);
		}
		String batchnum = "01";

		if (null != form.get_ne_validbillcyc()
				&& !"".equals(form.get_ne_validbillcyc())
				&& null != form.getRegiongroup()
				&& !"".equals(form.getRegiongroup())) {
			try {
				
				AccountingVO listVO = new AccountingVO();				
				BeanUtils.copyProperties(listVO, form);
				listVO.setIsshowlog(form.getStep());
				listVO.set_se_batchnum(batchnum);

				Accounting  delegate = (Accounting) BOFactory.build(AccountingBO.class, user);				
				List list = delegate.doTJAccounting(listVO, user);

				if (null != list && list.size() > 0) {
					super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, list);
				}
				super.getRequest().setAttribute("BILLINGPHASE", form.getStep());
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
				super.setActionMessage(ex.getMessage());
			}
		}

		return "usrlist";
	}

	// 单个地市显示内容--出账部分
	public String doSimpleinfo() throws Exception {
		User user = (User) super.getDBAccessUser();
		RhTouchRuleForm rtform = (RhTouchRuleForm) super.getForm();
		AccountingForm form = new AccountingForm();
		String step = super.getRequest().getParameter("_STEP");
		String validbillcyc = super.getRequest().getParameter("_VALIDBILLCYC");
		String regiongroup = super.getRequest().getParameter("_REGIONGROUP");
		if (null != step && !"".equals(step)) {
			rtform.setStep(step);
		}
		if (null != validbillcyc && !"".equals(validbillcyc)) {
			rtform.set_ne_validbillcyc(validbillcyc);
		}
		if (null != regiongroup && !"".equals(regiongroup)) {
			rtform.setRegiongroup(regiongroup);
		}
		form.set_ne_validbillcyc(rtform.get_ne_validbillcyc());
//		form.set_se_batchnum("01");
		form.setRegiongroup(rtform.getRegiongroup());
		form.setIsshowlog(rtform.getStep());
		form.set_se_billingphase(rtform.getStep());

		if (null != form.get_ne_validbillcyc()
				&& !"".equals(form.get_ne_validbillcyc())
				&& null != form.getRegiongroup()
				&& !"".equals(form.getRegiongroup())) {

			try {
				user = getNewUser(user, form.getRegiongroup()); // 重置数据源为当前操作的地市
				AccountingVO listVO = new AccountingVO();
//				setListVO(listVO, form);
				BeanUtils.copyProperties(listVO, form);
				super.getRequest().setAttribute("BILLINGPHASE", rtform.getStep());
				super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST,getBillingLog(listVO, user));
						
				super.getRequest().setAttribute("LIST2", getBillStartLog(listVO, user));
				
				super.getRequest().setAttribute("_BRTVO", getBlTouchRule(listVO, user));
				//BeanUtils.copyProperties(form, listVO);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return "simple";
	}
	

	// 单个地市显示内容 - 实时累帐部分
	public String doSimpleinfo1() throws Exception {

		RhTouchRuleForm form = (RhTouchRuleForm) super.getForm();
		form.set_ne_validbillcyc(super.getRequest().getParameter("_VALIDBILLCYC"));
		form.setRegiongroup(super.getRequest().getParameter("_REGIONGROUP"));
		doCity();

		return "simple1";
	}

	// 单个出账启动 _STARTRSN、_KEY、_REGIONGROUP、_ne_validbillcyc 这个4个必须填值
	public String doStartup() throws Exception {
		User user = (User) super.getDBAccessUser();
		RhTouchRuleForm form = (RhTouchRuleForm) super.getForm();
		AccountingVO listVO = new AccountingVO();
//		setListVO(listVO, form);
		BeanUtils.copyProperties(listVO, form);
		listVO.setStartrsn(super.getRequest().getParameter("_STARTRSN"));
		listVO.setStepKey(super.getRequest().getParameter("_KEY"));
		String[] cityid = AccountingUtils.getcitys(form.getRegiongroup());
		
		// 2009-07-16 增加，判断用户权限。如果是省工号并且有高权限，可以启全省，否则不可以启。
		// 如果是地市工号：如果有高权限，可以启全省；有低权限，可以启本地市；没有权限，不可以启动
		// -----------------------------start-------------------------------------
//		if (user.getCityid().equals("999")) {
//			if (FEEUtils.chkPurView("ACCOUNTING_HIGH", user)) {
//				;
//			} else if (FEEUtils.chkPurView("ACCOUNTING_LOW", user)) {
//				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//						"该工号只有低权限，不可以启动！");
//				return doSimpleinfo(actionMapping, actionForm, request,
//						response, user);
//			} else {
//				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//						"该工号没有权限，不可以启动！");
//				return doSimpleinfo(actionMapping, actionForm, request,
//						response, user);
//			}
//		} else {
//			if (FEEUtils.chkPurView("ACCOUNTING_HIGH", user)) {
//				;
//			} else if (FEEUtils.chkPurView("ACCOUNTING_LOW", user)) {
//				if (!cityid[0].equals(user.getCity())) {
//					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//							"该工号只可以启动本地市的出帐步骤！！！");
//					return doSimpleinfo(actionMapping, actionForm, request,
//							response, user);
//				}
//			} else {
//				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//						"该工号没有权限，不可以启动！");
//				return doSimpleinfo(actionMapping, actionForm, request,
//						response, user);
//			}
//		}
		// --------------------------------end--------------------------------------------------

		try {
			listVO.setCityid(AccountingUtils.regionmap.get(cityid[0]).toString()); //新增地市，201311
			user = getNewUser(user, cityid[0]); // 重置数据源为当前操作的地市
			// 获取地市的出账触发规则
			BlTouchRuleVO btrvo = AccountingUtils.getBlTouchRule(listVO
					.get_ne_validbillcyc(), listVO.getCityid(), user);
			if (null == btrvo) {
				throw new Exception(" 找不到出帐触发规则!");
			}
			listVO.setBtrvo(btrvo);
	
//			//获取前置任务编号在出帐步骤状态表(IB_ACCT_BILLSTEPSTATUS)中已完成状态的最大时间，然后再增加1秒，作为下一任务的开始时间
//			Date enddate = new Date(System.currentTimeMillis());
//			Date enddate1 = new Date(System.currentTimeMillis());
//			if ("PRMC".equals(listVO.getStepKey())) {
//				enddate = getEnddate(listVO ,new Integer("203103"),user);
//				enddate1 = getEnddate(listVO ,new Integer("203212"),user);
//			}else if ("FIXC".equals(listVO.getStepKey())) {
//				enddate = getEnddate(listVO ,new Integer("202221"),user);
//				enddate1 = getEnddate(listVO ,new Integer("202103"),user);
//			}			

			Accounting delegate = (Accounting) BOFactory.build(AccountingBO.class, user);
			delegate.doBatchStartUp(listVO, user); // 启动相关步骤

//			if ("PRMC".equals(listVO.getStepKey())) {
//				doStatusLog(new Long("203103"), new Short("3"), null, new Long(listVO.get_ne_validbillcyc()), listVO.getCityid(),enddate);
//				doStatusLog(new Long("203212"), new Short("3"), null, new Long(listVO.get_ne_validbillcyc()), listVO.getCityid(),enddate1);
//			} else if ("FIXC".equals(listVO.getStepKey())) {
//				doStatusLog(new Long("202221"), new Short("3"), null, new Long(listVO.get_ne_validbillcyc()), listVO.getCityid(),enddate);
//				doStatusLog(new Long("202103"), new Short("3"), null, new Long(listVO.get_ne_validbillcyc()), listVO.getCityid(),enddate1);
//			}

		} catch (Exception ex) {
			ex.printStackTrace();

//			if ("PRMC".equals(listVO.getStepKey())) {
//				doStatusLog(new Long("203103"), new Short("4"),ex.getMessage(),new Long(listVO.get_ne_validbillcyc()), listVO.getCityid(), new Date(System.currentTimeMillis()));
//				doStatusLog(new Long("203212"), new Short("4"),ex.getMessage(),new Long(listVO.get_ne_validbillcyc()), listVO.getCityid(), new Date(System.currentTimeMillis()));
//			} else if ("FIXC".equals(listVO.getStepKey())) {
//				doStatusLog(new Long("202221"), new Short("4"),ex.getMessage(),new Long(listVO.get_ne_validbillcyc()), listVO.getCityid(), new Date(System.currentTimeMillis()));
//				doStatusLog(new Long("202103"), new Short("4"),ex.getMessage(),new Long(listVO.get_ne_validbillcyc()), listVO.getCityid(), new Date(System.currentTimeMillis()));
//			}
			super.addActionMessage("启动失败："+ex.getMessage());
					
		}

		return doSimpleinfo();
	}

	/** ************* private *************** */

	private List getBillStartLog(AccountingVO listVO, User user)
			throws Exception {
		
		CommonControl cdelegate = (CommonControl) BOFactory.build(CommonBO.class, user);
		cdelegate.setVoClass(BillStartLogVO.class);

		BillStartLogDBParam listvo = new BillStartLogDBParam();
		BeanUtils.copyProperties(listvo, listVO);
		listvo.set_se_startstep(listVO.getIsshowlog());
//		if ("51".equals(listvo.get_se_startstep())
//				|| listvo.get_se_startstep() == "51") {
//			listvo.set_se_startstep("100");
//		}
//		if ("50".equals(listvo.get_se_startstep())
//				|| listvo.get_se_startstep() == "50") {
//			listvo.set_se_startstep("1011");
//		}

		String[] city = listVO.getCitygroup();
		
		listvo.set_ne_region(AccountingUtils.regionmap.get(city[0]).toString());  //新增地市，201205

		DataPackage dp = cdelegate.doQuery(listvo);

		return (List) dp.getDatas();
	}

	private List getBillingLog(AccountingVO listVO, User user) throws Exception {

		CommonControl cdelegate = (CommonControl) BOFactory.build(CommonBO.class, user);
		cdelegate.setVoClass(BillingLogVO.class);
		BillingLogDBParam listvo = new BillingLogDBParam();
		BeanUtils.copyProperties(listvo, listVO);
		if ("1010".equals(listVO.get_se_billingphase())) {
			listvo.set_se_billingphase("101");
		}

		String[] city = listVO.getCitygroup();	
		listvo.set_ne_region(AccountingUtils.regionmap.get(city[0]).toString());  //新增地市，201205		

		DataPackage dp = cdelegate.doQuery(listvo);
		return (List) dp.getDatas();
	}

	private BlTouchRuleVO getBlTouchRule(AccountingVO listVO, User user)
			throws Exception {

		String[] city = listVO.getCitygroup();		
		return AccountingUtils.getBlTouchRule(listVO.get_ne_validbillcyc(),AccountingUtils.regionmap.get(city[0]).toString(),
				user);

	}

	// 出账批量启动 _STARTRSN、_KEY、_REGIONGROUP、_ne_validbillcyc 这个4个必须填值
	public String doBatchstartup() throws Exception {
		User user = (User) super.getDBAccessUser();
		RhTouchRuleForm form = (RhTouchRuleForm) super.getForm();
		AccountingVO listVO = new AccountingVO();
//		setListVO(listVO, form);
		BeanUtils.copyProperties(listVO, form);
		String stepKey = super.getRequest().getParameter("_KEY");
		String startrsn = super.getRequest().getParameter("_STARTRSN");
		String[] selectArray = super.getParam().get_selectitem();

		// 2009-07-16 增加，判断用户权限。如果是省工号并且有高权限，可以启全省，否则不可以启。
		// 如果是地市工号：如果有高权限，可以启全省；有低权限，可以启本地市；没有权限，不可以启动
		// -----------------------------start-------------------------------------
//		ExcelCodeToName et = new ExcelCodeToName();
		String msg = "";
//		if (user.getCityid().equals("999")) {
//			if (FEEUtils.chkPurView("ACCOUNTING_HIGH", user)) {
//				;
//			} else if (FEEUtils.chkPurView("ACCOUNTING_LOW", user)) {
//				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//						"该工号只有低权限，不可以启动!");
//				return doAccbillingdet(actionMapping, actionForm, request,
//						response, user);
//			} else {
//				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//						"该工号没有权限，不可以启动!");
//				return doAccbillingdet(actionMapping, actionForm, request,
//						response, user);
//			}
//		} else {
//			if (FEEUtils.chkPurView("ACCOUNTING_HIGH", user)) {
//				;
//			} else if (FEEUtils.chkPurView("ACCOUNTING_LOW", user)) {
//				for (int i = 0; i < selectArray.length; i++) {
//					if (selectArray[i].equals(user.getCityid())) {
//						selectArray = new String[] { user.getCityid() };
//						String cityname = et.codeToName("#CITYIDNUM2NMAME",
//								user.getCityid(), user);
//						msg = "该工号只可以启动本地市[" + cityname + "]的出帐步骤!";
//						break;
//					}
//					if (i == selectArray.length - 1
//							&& !selectArray[i].equals(user.getCityid())) {
//						String cityname = et.codeToName("#CITYIDNUM2NMAME",
//								user.getCityid(), user);
//						request.setAttribute(
//								WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//								"该工号只可以启动本地市[" + cityname + "]的出帐步骤!");
//						return doAccbillingdet(actionMapping, actionForm,
//								request, response, user);
//					}
//				}
//			} else {
//				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//						"该工号没有权限，不可以启动!");
//				return doAccbillingdet(actionMapping, actionForm, request,
//						response, user);
//			}
//		}
		// --------------------------------end--------------------------------------------------

		listVO.setStartrsn(startrsn);
		listVO.setStepKey(stepKey);

		Accounting delegate = (Accounting) BOFactory.build(AccountingBO.class, user);		
		Map errmap = new HashMap();

		for (int i = 0; i < selectArray.length; i++) {

			try {
				listVO.setCityid(AccountingUtils.getCityid(selectArray[i]));

				// 获取地市的出账触发规则
				BlTouchRuleVO btrvo = AccountingUtils.getBlTouchRule(listVO
						.get_ne_validbillcyc(), listVO.getCityid(), user);
				if (null == btrvo) {
					putValue(errmap, "启动失败：找不到出帐触发规则!", selectArray[i]);
					continue;
				}

				listVO.setBtrvo(btrvo);				
				//获取前置任务编号在出帐步骤状态表(IB_ACCT_BILLSTEPSTATUS)中已完成状态的最大时间，然后再增加1秒，作为下一任务的开始时间
				Date enddate = new Date(System.currentTimeMillis());
				Date enddate1 = new Date(System.currentTimeMillis());
				if ("PRMC".equals(listVO.getStepKey())) {
					enddate = getEnddate(listVO ,new Integer("203103"),user);
					enddate1 = getEnddate(listVO ,new Integer("203212"),user);
				}else if ("FIXC".equals(listVO.getStepKey())) {
					enddate = getEnddate(listVO ,new Integer("202221"),user);
					enddate1 = getEnddate(listVO ,new Integer("202103"),user);
				}
				
				delegate.doBatchStartUp(listVO, user); // 启动相关步骤
				putValue(errmap, "启动成功!", selectArray[i]);
				if ("PRMC".equals(listVO.getStepKey())) {
					doStatusLog(new Long("203103"), new Short("3"), null,new Long(listVO.get_ne_validbillcyc()), listVO.getCityid(), enddate);
					doStatusLog(new Long("203212"), new Short("3"), null,new Long(listVO.get_ne_validbillcyc()), listVO.getCityid(), enddate1);
				} else if ("FIXC".equals(listVO.getStepKey())) {
					doStatusLog(new Long("202221"), new Short("3"), null,new Long(listVO.get_ne_validbillcyc()), listVO.getCityid(),enddate);
					doStatusLog(new Long("202103"), new Short("3"), null,new Long(listVO.get_ne_validbillcyc()), listVO.getCityid(), enddate1);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				if ("PRMC".equals(listVO.getStepKey())) {
					doStatusLog(new Long("203103"), new Short("4"), ex.getMessage(), new Long(listVO.get_ne_validbillcyc()), listVO.getCityid(), new Date(System.currentTimeMillis()));
					doStatusLog(new Long("203212"), new Short("4"), ex.getMessage(), new Long(listVO.get_ne_validbillcyc()), listVO.getCityid(), new Date(System.currentTimeMillis()));
				} else if ("FIXC".equals(listVO.getStepKey())) {
					doStatusLog(new Long("202221"), new Short("4"), ex.getMessage(), new Long(listVO.get_ne_validbillcyc()), listVO.getCityid(), new Date(System.currentTimeMillis()));
					doStatusLog(new Long("202103"), new Short("4"), ex.getMessage(), new Long(listVO.get_ne_validbillcyc()), listVO.getCityid(), new Date(System.currentTimeMillis()));
				}
				putValue(errmap, ex.getMessage(), selectArray[i]);
			}
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
				getKeyValue(errmap));

		return doAccbillingdet();
	}

	private void putValue(Map errmap, String key, String value) {
		value = AccountingUtils.getCityName(value);
		if (null != errmap && errmap.containsKey(key)) {
			String _value = errmap.get(key) + "," + value;
			errmap.put(key, _value);
		} else {
			errmap.put(key, value);
		}
	}

	private String getKeyValue(Map errmap) {
		if (null != errmap) {
			StringBuffer message = new StringBuffer();
			for (Iterator iter = errmap.keySet().iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				String value = (String) errmap.get(key);
				message.append(value).append(" ").append(key).append("<br>");
			}
			return message.toString();
		}
		return "";
	}

	private void doStatusLog(Long stepno, Short status, String errorinfo,
			Long validbillcyc, String cityid, Date enddate) throws Exception {
		User user = (User) super.getDBAccessUser();
		user.setCityid(cityid);
		BillStepStatusVO pkVO = new BillStepStatusVO();
		pkVO.setStepno(stepno);
		pkVO.setValidbillcyc(validbillcyc);
		CommonControl delegate = (CommonControl) BOFactory.build(CommonBO.class, user);
		delegate.setVoClass(BillStepStatusVO.class);
		BillStepStatusVO tmpvo = (BillStepStatusVO) delegate.doFindByPk(pkVO);

		if (tmpvo != null) {
			if (tmpvo.getTaskstatus().intValue() == 3) {
				return;
			}
			tmpvo.setTaskstatus(status);
			tmpvo.setErrorreason(errorinfo);
			tmpvo.setStartdate(enddate);//上一任务编号的完成时间作为下一任务编号的开始时间
			tmpvo.setEnddate(new Date(System.currentTimeMillis()));
			tmpvo.setUpttime(new Date(System.currentTimeMillis()));
			delegate.doUpdate(tmpvo);
		} else {
			pkVO.setTaskstatus(status);
			pkVO.setStartdate(enddate);//上一任务编号的完成时间作为下一任务编号的开始时间
			pkVO.setEnddate(new Date(System.currentTimeMillis()));
			pkVO.setUpttime(new Date(System.currentTimeMillis()));
			//-- 增加地市 			
			if (status.intValue() == 4) {
				pkVO.setErrorreason(errorinfo);
			}
			delegate.doCreate(pkVO);
		}
	}
	
	/**
	 * 获取前置任务编号在出帐步骤状态表(IB_ACCT_BILLSTEPSTATUS)中已完成状态的最大时间，然后再增加1秒，作为下一任务的开始时间
	 * @param listVO
	 * @param i
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private Date getEnddate(AccountingVO listVO, Integer i, User user) throws Exception{		
		Date enddate = new Date(System.currentTimeMillis());		
		Accounting delegate = (Accounting) BOFactory.build(AccountingBO.class, user);		
		listVO.set_ne_region(listVO.getCityid());//-- 增加地市 		
		listVO.setEndstepno(i);				
		Date date = delegate.getStartdate(listVO, user);		
		if(date != null){
			enddate = date;
			enddate.setTime(enddate.getTime()+1000);
		}

		return enddate;
	}
	private User getNewUser(User user, String city) {
		User newUser = new User();
		try {
			BeanUtils.copyProperties(newUser, user);
			String dbFlag = city + DBConstant.DB_FLAG_BILL;
			newUser.setDbFlag(dbFlag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newUser;
	}
	
	
	
	/**
	 * 预付费出账过程监控  — 预付费低消确认日志
	 * @return
	 * @throws Exception
	 */
	public String doBillinglogList() throws Exception {
		User user = (User) super.getDBAccessUser();
		RhTouchRuleForm rtform = (RhTouchRuleForm) super.getForm();
		AccountingForm form = new AccountingForm();
		String step = super.getRequest().getParameter("_STEP");
		String validbillcyc = super.getRequest().getParameter("_VALIDBILLCYC");
		String regiongroup = super.getRequest().getParameter("_REGIONGROUP");
		String status = super.getRequest().getParameter("_STATUS");
		if (null != step && !"".equals(step)) {
			rtform.setStep(step);
		}
		if (null != validbillcyc && !"".equals(validbillcyc)) {
			rtform.set_ne_validbillcyc(validbillcyc);
		}
		if (null != regiongroup && !"".equals(regiongroup)) {
			rtform.setRegiongroup(regiongroup);
		}
		form.set_ne_validbillcyc(rtform.get_ne_validbillcyc());
		form.setRegiongroup(rtform.getRegiongroup());
		form.set_se_billingphase(rtform.getStep());

		if (null != form.get_ne_validbillcyc() && !"".equals(form.get_ne_validbillcyc()) && null != form.getRegiongroup() && !"".equals(form.getRegiongroup())) {
			try {
				user = getNewUser(user, form.getRegiongroup()); // 重置数据源为当前操作的地市
				AccountingVO listVO = new AccountingVO();
				BeanUtils.copyProperties(listVO, form);
				super.getRequest().setAttribute("BILLSTATUS", status);
				super.getRequest().setAttribute("BILLINGPHASE", rtform.getStep());
				super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST,getBillingLog(listVO, user));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return "billingloglist";
	}
	
	/**
	 * 低消确认
	 * @return
	 * @throws Exception
	 */
	public String doUpdateStatus() throws Exception {
		User user = (User) super.getDBAccessUser();
		RhTouchRuleForm form = (RhTouchRuleForm) super.getForm();
		doUpdateStatus(form.getRegiongroup(),form.get_ne_validbillcyc(),form.getStep(),"3");
		doUpdateStatus(form.getRegiongroup(),form.get_ne_validbillcyc(),"I100","1");
		return null;
	}
	
	public void doUpdateStatus(String region,String validbillcyc,String phase, String state) throws Exception {
		User user = (User) super.getDBAccessUser();
		CommonControl delegate = (CommonControl) BOFactory.build(CommonBO.class, user);
		delegate.setVoClass(BillStatusVO.class);
		BillStatusDBParam params = new BillStatusDBParam();
		params.set_se_phase(phase);
		params.set_ne_region(CityMappingUtil.getCityid(region));
		params.set_ne_validbillcyc(validbillcyc);
		DataPackage dp = delegate.doQuery(params);
		if(dp != null && dp.getDatas() != null && dp.getDatas().size() > 0){
			BillStatusVO vo = (BillStatusVO) dp.getDatas().get(0);
			vo.setState(Short.valueOf(state));
			if("I100".equals(phase)){
				delegate.doUpdate(vo);
				log.info("低消确认成功，修改低消入ABM库状态为1：可启动");
			}else{
				delegate.doUpdate(vo);
				log.info("低消确认成功，修改低消确认状态为3：已完成");
			}
		}
	}

}
