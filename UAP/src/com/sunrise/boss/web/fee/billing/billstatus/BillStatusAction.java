package com.sunrise.boss.web.fee.billing.billstatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunrise.boss.business.fee.acccounting.control.Accounting;
import com.sunrise.boss.business.fee.acccounting.control.AccountingBO;
import com.sunrise.boss.business.fee.acccounting.control.AccountingUtils;
import com.sunrise.boss.business.fee.acccounting.persistent.AccountingVO;
import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogDBParam;
import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogVO;
import com.sunrise.boss.business.fee.billing.billresult.persistent.BillResultDBParam;
import com.sunrise.boss.business.fee.billing.billresult.persistent.BillResultVO;
import com.sunrise.boss.business.fee.billing.billstatus.control.BillStatus;
import com.sunrise.boss.business.fee.billing.billstatus.control.BillStatusBO;
import com.sunrise.boss.business.fee.billing.billstatus.persistent.BillStatusDBParam;
import com.sunrise.boss.business.fee.billing.billstatus.persistent.BillStatusVO;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycVO;
import com.sunrise.boss.common.client.menutoken.PublicService;
import com.sunrise.jop.common.commoncontrol.CommonBO;
import com.sunrise.jop.common.commoncontrol.CommonControl;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;


public class BillStatusAction extends BaseAction {
	public List voList = new ArrayList();
	
	public BillStatusAction(){
		super();
		
		this.setForm(new BillStatusForm());
		this.setParam(new BillStatusWebParam());
		
        setClsVO(BillStatusVO.class);
        this.pkNameArray = new String[4];
        pkNameArray[0] = "phase";	
        pkNameArray[1] = "subphase";
        pkNameArray[2] = "validbillcyc";
        pkNameArray[3] = "region";
       
		this.setClsControl(BillStatus.class);
		this.setClsQueryParam(BillStatusDBParam.class);
		
		setDbFlag(DBConstant.DB_FLAG_BILL);
	}
	
	
	public String doSet() throws Exception {
		BillStatusForm form = (BillStatusForm) super.getForm();
		
		User user = (User) super.getDBAccessUser();
		String usercity = AccountingUtils.getCityCompid(user.getCityid());
		
		if(null == form.getRegiongroup()){
			form.setRegiongroup(usercity);
		}
		//判断工号权限
		int perm = checkPerm(user);
		if(perm == 0){
			if(!usercity.equals(form.getRegiongroup())){
				this.setActionMessage("您的工号只可以查看本地市！");
			}
			form.setRegiongroup(usercity);
		}else if(perm == -1){
			form.setRegiongroup("");
			this.setActionMessage("您的工号没有权限查看！");
		}
		
		if(null == form.get_ne_validbillcyc()){
			
			String _ne_validbillcyc = PublicUtils.formatUtilDate(new Date(),"yyyyMM00");	
			BillStatus delegate = (BillStatus) BOFactory.build(BillStatusBO.class, super.getDBAccessUser());
			ValidBillCycVO vo = delegate.getValidBillCyc(user.getCityid());
			
			if(null != vo) {
				_ne_validbillcyc = vo.getValidbillcyc().toString();
			}
			form.set_ne_validbillcyc(_ne_validbillcyc);
			
		}
		super.getRequest().setAttribute("_ne_validbillcyc", form.get_ne_validbillcyc()!=null?form.get_ne_validbillcyc():"");
		super.getRequest().setAttribute("regiongroup", form.getRegiongroup()!=null?form.getRegiongroup():"");
		return "set";
	}
	
	
	public String doShow() throws Exception {
		BillStatusForm form = (BillStatusForm) super.getForm();
		
		String validbillcyc = form.get_ne_validbillcyc();

		String regiongroup = form.getRegiongroup();	
		if (!"".equals(validbillcyc)				
				&& regiongroup != null
				&& regiongroup.trim().length() > 0) {
			try {
 
				BillStatusDBParam listVO = new BillStatusDBParam();	
				listVO.set_ne_validbillcyc(validbillcyc);				
				listVO.setRegiongroup(regiongroup);
				BillStatus delegate = (BillStatus) BOFactory.build(BillStatusBO.class, super.getDBAccessUser());
				//获取出账进度各步骤状态信息
				String[] result = delegate.doShow(listVO);				
				
				super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, result);
				// 获取区域出账阶段状态信息,新整合的监控图需求暂无启用
//				super.getRequest().setAttribute("_CONFIRMBILL", delegate.doQueryConfirmBill(listVO));			
//				super.getRequest().setAttribute("_YUEQIE", delegate.doQueryYueqie(form.get_ne_validbillcyc()));// 月切
				//查询月切状态
//				super.getRequest().setAttribute("_YUEQIE", delegate.doQueryYueqie(validbillcyc));
				super.getRequest().setAttribute("_REGIONGROUP", regiongroup);				
				User user = (User) super.getDBAccessUser();	
				
				//begin 获取出账监控各步骤状态信息
				String simple ="";
				if(AccountingUtils.getcitys(regiongroup).length <= 1){
					simple = "simple";
				}
				super.getRequest().setAttribute("simple", simple);
				Accounting delegate1 = (Accounting) BOFactory.build(AccountingBO.class, super.getDBAccessUser());
				AccountingVO avo = new AccountingVO();
				BeanUtils.copyProperties(avo, listVO);
				avo.set_se_batchnum("01");
				List list = delegate1.doAccBilling(avo, user);//				
				super.getRequest().setAttribute("ACCB", list);	
				// end 				
				
			} catch (Exception e) {
				super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());						
				e.printStackTrace();
			}
		}
		
		return "show";
	}
	/**
	 * 显示出账监控各阶段运行状态
	 * @return
	 * @throws Exception
	 */
	public String doShowproc() throws Exception {
		BillStatusForm form = (BillStatusForm) super.getForm();
		BillStatusDBParam listVO = new BillStatusDBParam();
		BeanUtils.copyProperties(listVO, form);
		String phase = super.getRequest().getParameter("_PHASE");
		
		String validbillcyc = super.getRequest().getParameter("_VALIDBILLCYC");
		String regiongroup = super.getRequest().getParameter("_REGIONGROUP");		
		if(null != phase && !"".equals(phase)){
			form.setPhase(phase);
			listVO.set_se_phase(phase);//这里的phase要在controlbean中做拆分
		}else{
			listVO.set_se_phase(form.getPhase());
		}
		if(null != validbillcyc && !"".equals(validbillcyc)){
			form.set_ne_validbillcyc(validbillcyc);
			listVO.set_ne_validbillcyc(validbillcyc);
		}else{
			listVO.set_ne_validbillcyc(form.get_ne_validbillcyc());
		}
		if(null != regiongroup && !"".equals(regiongroup)){
			form.setRegiongroup(regiongroup);
			listVO.setRegiongroup(regiongroup);
		}else{
			listVO.setRegiongroup(form.getRegiongroup());
		}		

		BillStatus delegate =  (BillStatus) BOFactory.build(BillStatusBO.class,super.getDBAccessUser());		
		

		List list = delegate.doShowProc(listVO);
		
		super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, list);
		super.getRequest().setAttribute("_BIGPHASE",form.getPhase().split(",")[0]);
	
		return "proc";
	}
	//显示出账监控日志
	public String doShowlog() throws Exception {
		try {
			User user = (User) super.getDBAccessUser();
			String phase = super.getRequest().getParameter("_PHASE");
			if(phase !=null && phase !=""){}
//			E10112
			String bigphase = phase.substring(0, 4);
			String subphase = phase.substring(4);
			
			String region = super.getRequest().getParameter("_REGIONGROUP");
			String validbillcyc = super.getRequest().getParameter("_VALIDBILLCYC");
			//判断工号权限
			int perm = checkPerm(user);
			if(perm == 0){
				if(!region.equals(user.getCityid())){
					this.setActionMessage("您的工号只可以查看本地市！");
					return "log";
				}
			}else if(perm == -1){
				this.setActionMessage("您的工号没有权限查看！");
				return "log";
			}
			//重定向数据源
			if(null != region && !"".equals(region)){
				String dbFlag = CityMappingUtil.getCity(region) + DBConstant.DB_FLAG_BILL;
				user.setDbFlag(dbFlag);
			}
			
			CommonControl delegate = (CommonControl) BOFactory.build(CommonBO.class, user);
			delegate.setVoClass(BillResultVO.class);
			
			BillResultDBParam listVO = new BillResultDBParam();
			listVO.set_pageno(super.param.get_pageno());
			listVO.set_pagesize(super.param.get_pagesize());
			listVO.set_se_phase(bigphase);
			// 点第一个步骤时展示所有子步骤 add by pmf 2014-03-06 
			if(!subphase.equals("0")){
				listVO.set_ne_subphase(subphase);
			}
			listVO.set_ne_validbillcyc(validbillcyc);
			listVO.set_orderby("logid");
			listVO.set_desc("1");
			//定位到单个地市
			listVO.set_ne_region(region);
			DataPackage dp = delegate.doQuery(listVO);
			
			// modify by 2013-12-10			
//			if(null !=phase && phase !="" ) phase = phase.split(",")[0]+"0";
			//end
			super.getRequest().setAttribute("_STEPNAME", phase);
	
//			super.getRequest().setAttribute("simple", "simple");			
			
			BillStatus dele = (BillStatus) BOFactory.build(BillStatusBO.class, user);
			
			
			BillStatusVO vo = dele.doQueryVO(bigphase, subphase, validbillcyc, region);			
			super.getRequest().setAttribute("_STARTTIME", PublicUtils.utilDateToStr(vo!=null ?vo.getStarttime():null));
			super.getRequest().setAttribute("_ENDTIME", PublicUtils.utilDateToStr(vo!=null ?vo.getEndtime():null));	
			super.setDp(dp);
			//  add by 2013-11-19
			super.getRequest().setAttribute("_PHASE", phase);
			super.getRequest().setAttribute("_REGIONGROUP", region);
			super.getRequest().setAttribute("_VALIDBILLCYC", validbillcyc);	
			super.getRequest().setAttribute("_CITYID", AccountingUtils.getCityid(region));	
			
		} catch (Exception e) {
			e.printStackTrace();			
			super.setActionMessage(e.getMessage());
		}
		
		return "log";
	}

	public String doBatchstartup() throws Exception {
		BillStatusForm form = (BillStatusForm) super.getForm();
		try {			
			User user = (User) super.getRequest().getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
			String[] phases = form.getPhase().split(",");
			BillStatusDBParam listVO = new BillStatusDBParam();
			listVO.set_se_phase(phases[0]);
			listVO.set_ne_validbillcyc(form.get_ne_validbillcyc());
			listVO.set_ne_subphase(phases[1]);
			
			String step = phases[0] + phases[1];
			
			String stepname = Code2NameUtils.code2Name("#SUBPHASENAME", step, user.getDbFlag());
			
			CommonControl delegate = (CommonControl) BOFactory.build(CommonBO.class, super.getDBAccessUser());
			delegate.setVoClass(BillStatusBO.class);
			
			String[] selectArray = super.getParam().get_selectitem();
//			2009-07-16 增加，判断用户权限。
//			如果是地市工号：如果有高权限，可以启全省；有低权限，可以启本地市；没有权限，不可以启动
//			-----------------------------start-------------------------------------
			String msg = "";
			
			//判断工号权限
			int perm = checkPerm(user);
			if(perm == 0){
				for (int i = 0; i < selectArray.length; i++) {
					if(selectArray[i].equals(user.getCityid())){
						selectArray = new String[]{user.getCityid()};
						String cityname = Code2NameUtils.code2Name("#CITYIDNUM2NMAME", user.getCityid(), user.getDbFlag());
						msg = "该工号只可以启动本地市[" + cityname +"]的出帐步骤!";
						break;
					}
					if(i == selectArray.length - 1 && !selectArray[i].equals(user.getCityid())){
						String cityname = Code2NameUtils.code2Name("#CITYIDNUM2NMAME", user.getCityid(), user.getDbFlag());
						super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "该工号只可以启动本地市[" + cityname +"]的出帐步骤!)");
						return doShowproc();
					}
				}
				
			}else if(perm == -1){
				super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "该工号没有权限，不可以启动!");
				return doShowproc();
			}
			
//			--------------------------------end--------------------------------------------------
			for (int i = 0; i < selectArray.length; i++) {
				
				listVO.set_ne_region(selectArray[i]); //新增地市，201205
				
				DataPackage dp = delegate.doQuery(listVO);
				if(dp == null || dp.getDatas() == null || dp.getDatas().size() == 0){
					
					BillStatus billdele = (BillStatus) BOFactory.build(BillStatusBO.class, user);
					
					BillStatusVO vo = new BillStatusVO();
					vo.setPhase(phases[0]);
					vo.setSubphase(new Short(phases[1]));
					vo.setValidbillcyc(new Long(form.get_ne_validbillcyc()));
					vo.setStarttime(new Date(System.currentTimeMillis()));
					vo.setState(new Short("1"));
					vo.setRegion(Integer.valueOf(selectArray[i]));   
					
					billdele.doStart(0,vo, user);
				}else{
					BillStatusVO stvo = (BillStatusVO) dp.toList(BillStatusVO.class).get(0);
					if(stvo.getState().intValue() <= 0 || stvo.getState().intValue() >= 4){
						stvo.setState(new Short("1"));
						stvo.setRegion(Integer.valueOf(selectArray[i]));  						

						BillStatus billdele = (BillStatus) BOFactory.build(BillStatusBO.class, user);
						billdele.doStart(1,stvo, user);
					}else{
						String errstatus = Code2NameUtils.code2Name("$IB_BACKSTATE", stvo.getState().toString(), user.getDbFlag());
						throw new Exception(stepname + "状态为" + errstatus + ",不可以做启动操作!!");					
					}
				}
			}
			
			super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, msg + stepname + "前台启动成功!");
			
		} catch (Exception e) {
			super.setActionMessage(e.getMessage());
			e.printStackTrace();
		}
		return doShowproc();
	}
	/**
	 * 判断工号权限
	 * @return 1高权限，0低权限，-1无权限
	 * @throws Exception
	 */
	public int checkPerm(User user) throws Exception {
		//改用账务系统参数279来设置出账监控高权限工号
		if(AccountingUtils.isHighMonitor(user)){
			return 1;  //高权限
		}else if(PublicService.checkToken(user, "MONITORSTATUS_LOW")){
			return 0;  //低权限
		}else{
			return -1; //无权限
		}
	}
	
	
	
	/**
	 * 预付费出账过程监控
	 * @return
	 * @throws Exception
	 */
	public String doSetPrepaidFee() throws Exception {
		BillStatusForm form = (BillStatusForm) super.getForm();
		User user = (User) super.getDBAccessUser();
		String usercity = AccountingUtils.getCityCompid(user.getCityid());
		if(null == form.getRegiongroup()){
			form.setRegiongroup(usercity);
		}
		//判断工号权限
		int perm = checkPerm(user);
		if(perm == 0){
			if(!usercity.equals(form.getRegiongroup())){
				this.setActionMessage("您的工号只可以查看本地市！");
			}
			form.setRegiongroup(usercity);
		}else if(perm == -1){
			form.setRegiongroup("");
			this.setActionMessage("您的工号没有权限查看！");
		}
		if(null == form.get_ne_validbillcyc()){
			String _ne_validbillcyc = PublicUtils.formatUtilDate(new Date(),"yyyyMM00");	
			BillStatus delegate = (BillStatus) BOFactory.build(BillStatusBO.class, super.getDBAccessUser());
			ValidBillCycVO vo = delegate.getValidBillCyc(user.getCityid());
			
			if(null != vo) {
				_ne_validbillcyc = vo.getValidbillcyc().toString();
			}
			form.set_ne_validbillcyc(_ne_validbillcyc);
		}
		super.getRequest().setAttribute("_ne_validbillcyc", form.get_ne_validbillcyc()!=null?form.get_ne_validbillcyc():"");
		super.getRequest().setAttribute("regiongroup", form.getRegiongroup()!=null?form.getRegiongroup():"");
		return "setprepaidFee";
	}
	
	/**
	 * 预付费出账过程监控首页各步骤运行状态信息
	 * @return
	 * @throws Exception
	 */
	public String doShowPrepaidFee() throws Exception {
		BillStatusForm form = (BillStatusForm) super.getForm();
		//有效账务周期
		String validbillcyc = form.get_ne_validbillcyc();
		//地市
		String regiongroup = form.getRegiongroup();	
		if (!"".equals(validbillcyc) && regiongroup != null	&& regiongroup.trim().length() > 0) {
			try {
				BillStatusDBParam listVO = new BillStatusDBParam();
				listVO.set_ne_validbillcyc(validbillcyc);				
				listVO.setRegiongroup(regiongroup);
				BillStatus delegate = (BillStatus) BOFactory.build(BillStatusBO.class, super.getDBAccessUser());
				//获取预付费出账的各状态
				String[] result = delegate.doShowPrepaidFee(listVO);				
				super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, result);
				super.getRequest().setAttribute("_REGIONGROUP", regiongroup);				
			} catch (Exception e) {
				super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());						
				e.printStackTrace();
			}
		}
		return "showPrepaidFee";
	}
	
	/**
	 * 预付费出账过程监控 各子步骤状态信息
	 * @return
	 * @throws Exception
	 */
	public String doShowprocFee() throws Exception {
		BillStatusForm form = (BillStatusForm) super.getForm();
		BillStatusDBParam listVO = new BillStatusDBParam();
		BeanUtils.copyProperties(listVO, form);
		String phase = super.getRequest().getParameter("_PHASE");
		String validbillcyc = super.getRequest().getParameter("_VALIDBILLCYC");
		String regiongroup = super.getRequest().getParameter("_REGIONGROUP");		
		if(null != phase && !"".equals(phase)){
			form.setPhase(phase);
			listVO.set_se_phase(phase);//这里的phase要在controlbean中做拆分
		}else{
			listVO.set_se_phase(form.getPhase());
		}
		if(null != validbillcyc && !"".equals(validbillcyc)){
			form.set_ne_validbillcyc(validbillcyc);
			listVO.set_ne_validbillcyc(validbillcyc);
		}else{
			listVO.set_ne_validbillcyc(form.get_ne_validbillcyc());
		}
		if(null != regiongroup && !"".equals(regiongroup)){
			form.setRegiongroup(regiongroup);
			listVO.setRegiongroup(regiongroup);
		}else{
			listVO.setRegiongroup(form.getRegiongroup());
		}		
		BillStatus delegate =  (BillStatus) BOFactory.build(BillStatusBO.class,super.getDBAccessUser());		
		List list = delegate.doShowProc(listVO);
		super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, list);
		super.getRequest().setAttribute("_BIGPHASE",form.getPhase().split(",")[0]);
		return "procFee";
	}
}
