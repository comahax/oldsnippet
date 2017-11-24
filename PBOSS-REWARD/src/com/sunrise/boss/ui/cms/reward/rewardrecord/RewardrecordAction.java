/**
 * auto-generated code
 * Sat Feb 02 14:33:50 CST 2008
 */
package com.sunrise.boss.ui.cms.reward.rewardrecord;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamListVO;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightListVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.business.cms.reward.rewardconf.persistent.RewardconfListVO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordListVO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.cms.chadtdictparam.ChAdtDictparamDelegate;
import com.sunrise.boss.delegate.cms.reward.rewardconf.RewardconfDelegate;
import com.sunrise.boss.delegate.cms.reward.rewardrecord.RewardrecordDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpBusUtils;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.resmanage.common.ResPubUtil;

/**
 * <p>
 * Title: RewardrecordAction
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
public class RewardrecordAction extends BaseDelegateAction {
	
	private CommonDelegate delegate;

	private String purview = null;

	private static final String PROVINCE_PURVIEW_A = "CH_PW_REWARD_PROVINCIAL";

	private static final String PROVINCE_PURVIEW_A2 = "CH_PW_REWARD";

	private static final String CITY_PURVIEW_B= "CH_PW_REWARD_CIVICEXPOT";
	
	private static final String COUNTY_PURVIEW_C= "CH_PW_REWARD_COUNTY"; 
	
	public RewardrecordAction() throws Exception {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(RewardrecordVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "rewardlistid";
		delegate = new CommonDelegate(ProvincialrightVO.class);
	}
	
	/**
	 * 增加对查询条件的"结算月"是否已出帐确认判断,所有ActionForword都要经过这个判断
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @单号 CR_AA200901091_551119 
	 */
	public boolean doCheckRewardMonth(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		RewardrecordForm form = (RewardrecordForm) actionForm;
		
		RewardconfListVO listvo = new RewardconfListVO();
		listvo.set_se_rewardkind("AG");
		listvo.set_se_rewardmonth(form.get_se_rewardmonth().trim());
		listvo.set_se_cityid(user.getCityid());
		listvo.set_se_state("1");
		listvo.set_pagesize("0");
		RewardconfDelegate confdelegate = new RewardconfDelegate();
		DataPackage dp  = confdelegate.doQuery(listvo, user);
		if(dp != null && dp.getDatas().size() != 0){
			return true;
		}
		
		ProvincialrightVO rightvo = new ProvincialrightVO();
		rightvo.setProopr(user.getOpercode());
		rightvo.setRightid("CH_PW_REWARDCONF");
		rightvo = (ProvincialrightVO) delegate.doFindByPk(rightvo, user);
		if(rightvo == null){
			return false;
		}else{
			return true;
		}
	}
	

	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		if(!this.doCheckRewardMonth(actionMapping, actionForm, request, response, user)){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "当前结算月酬金未出帐确认或非省级出帐确认操作工号，暂不能查询(导出)!");
			return actionMapping.findForward("list");
		}
		
		CommonExportBean export = new CommonExportBean(user);
		RewardrecordForm form = (RewardrecordForm) actionForm;
		String zdcj = form.getChecked();
		if (zdcj == null || "".equals(zdcj)) {
			export.setFileName("酬金计算结果明细查询");
		} else {
			String rewardmonth = form.get_se_rewardmonth();
			String rewardtype = form.get_ne_rewardtype();
			String noncyc = form.get_ne_noncyc();
			if (zdcj.equals("mango") && noncyc.equals("1")) {
				export.setFileName(rewardmonth + "合约终端服务业务基本酬金");
			} else if (zdcj.equals("mango") && noncyc.equals("2")) {
				export.setFileName(rewardmonth + "合约终端服务业务奖励酬金");
			} else if (zdcj.equals("apple") && noncyc.equals("1")) {
				export.setFileName(rewardmonth + "零合约终端服务业务一期酬金");
			} else if (zdcj.equals("apple") && noncyc.equals("2")) {
				export.setFileName(rewardmonth + "零合约终端服务业务二期酬金");
			} else if (zdcj.equals("apple") && noncyc.equals("3")) {
				export.setFileName(rewardmonth + "零合约终端服务业务三期酬金");
			} else if (zdcj.equals("orange") && noncyc.equals("1")) {
				export.setFileName(rewardmonth + "裸机终端服务业务基本酬金");
			} else if (zdcj.equals("orange") && noncyc.equals("2")) {
				export.setFileName(rewardmonth + "裸机终端服务业务考核酬金");
			} else if (zdcj.equals("banana") && noncyc.equals("1")) {
				export.setFileName(rewardmonth + "类平台裸机终端服务业务基本酬金");
			} else if (zdcj.equals("banana") && noncyc.equals("2")) {
				export.setFileName(rewardmonth + "类平台裸机终端服务业务考核酬金");
			} else if (zdcj.equals("lemon") && noncyc.equals("1")) {
				export.setFileName(rewardmonth + "裸机流量套餐一期销售酬金");
			} else if (zdcj.equals("lemon") && noncyc.equals("2")) {
				export.setFileName(rewardmonth + "裸机流量套餐二期销售酬金");
			} else if (zdcj.equals("lemon") && noncyc.equals("3")) {
				export.setFileName(rewardmonth + "裸机流量套餐三期销售酬金");
			} else if (zdcj.equals("newtd") && noncyc.equals("1")){
				export.setFileName(rewardmonth + "2014年新终端酬金T、T+1、T+2一期酬金60%");
			} else if (zdcj.equals("newtd") && noncyc.equals("2")){
				export.setFileName(rewardmonth + "2014年新终端酬金T+2优质客户预发二期酬金40%");
			} else if (zdcj.equals("newtd") && noncyc.equals("3")){
				export.setFileName(rewardmonth + "2014年新终端酬金T+3二期酬金40%");
			} else if (zdcj.equals("newtd") && noncyc.equals("4")){
				export.setFileName(rewardmonth + "2014年新终端酬金T+3低价值扣罚酬金");
			} else if (zdcj.equals("newtd") && noncyc.equals("5")){
				export.setFileName(rewardmonth + "2014年新终端酬金T+4IVR外呼补发酬金");
			} 
			else {
				export.setFileName("酬金计算结果明细查询");
			}
		}
		export.addOutputProperty("rewardlistid");
		export.addOutputProperty("operseq");
		export.addOutputProperty("opnid");
		export.addOutputProperty("opnid", CommonExportBean.CODE2NAME, "#OPERATION");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayid", CommonExportBean.CODE2NAME, "$WAY");
		export.addOutputProperty("wayoprcode");
		export.addOutputProperty("slv", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("rewardid");
		export.addOutputProperty("rewardtype", CommonExportBean.CODE2NAME, "$CH_REWARDTYPE");
		export.addOutputProperty("rewardmonth");
		export.addOutputProperty("isbudget", CommonExportBean.CODE2NAME, "#CH_ISBUDGET");

		export.addOutputProperty("mobile");
		export.addOutputProperty("oprtime");
		export.addOutputProperty("acctype", CommonExportBean.CODE2NAME, "$CH_ACCTYPE");
		export.addOutputProperty("rewardstdnew");

		export.addOutputProperty("totalsum");
		export.addOutputProperty("paysum");
		export.addOutputProperty("paymonth1");
		export.addOutputProperty("paymoney1");
		export.addOutputProperty("paymonth2");
		export.addOutputProperty("paymoney2");
		export.addOutputProperty("paymonth3");
		export.addOutputProperty("paymoney3");
		export.addOutputProperty("runtime");
		export.addOutputProperty("assegrade");
		export.addOutputProperty("opermobile");
		
		export.addOutputProperty("batchno");
		export.addOutputProperty("rewardflag", CommonExportBean.CODE2NAME, "$CH_REWARDFLAG");
		export.addOutputProperty("repairmonth");
		export.addOutputProperty("noncyc");
		export.addOutputProperty("bakinfo");
		export.addOutputProperty("bakinfo2");
		export.addOutputProperty("bakinfo3");
		export.addOutputProperty("wrapfee");
		export.addOutputProperty("adjustkind", CommonExportBean.CODE2NAME, "$CH_ADJUSTKIND");
		export.addOutputProperty("adtflag");
		export.addOutputProperty("assegrade2");
		export.addOutputProperty("bakinfo2", CommonExportBean.CODE2NAME, "#IM_PR_COM");
		export.addOutputProperty("prodid");
		export.addOutputProperty("bakinfo4");
		export.addOutputProperty("bakinfo5");
		export.addOutputProperty("bakinfo6",CommonExportBean.CODE2NAME, "$ZD_SYSTEM"); 
		export.addOutputProperty("bakinfo7");
		export.addOutputProperty("bakinfo8");
		export.addOutputProperty("bakinfo9");
		export.addOutputProperty("bakinfo10" ,CommonExportBean.CODE2NAME, "$ZD_TYPE");
		

		export.voClassArray = new Class[] { RewardrecordVO.class };
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] {
				"酬金明细标识", "业务流水", "业务代码", "业务名称", "渠道标识", "渠道名称", "人员工号",
				"星级", "酬金标识", "酬金类型", "结算月份", "预估标志", "业务发生号码", "业务发生时间",
				"计酬方式", "酬金标准", "计算金额", "应发金额", "一期发放月份", "一期应发金额",
				"二期发放月份", "二期应发金额", "三期发放月份", "三期应发金额", "计算时间", "考核系数",
				"人员手机号码", "批次号", "计算标识", "补算月", "结算期数(第n期)", "附加属性(IMEI)",
				"商品ID", "商品协议价", "承诺低消", "调整类型", "稽核结果标识", "考核系数2", "商品名称",
				"产品ID","基准价" ,"酬金点数","终端制式","流量","ARPU值","优质客户","终端类型"});
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
	}

	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		RewardrecordForm form = (RewardrecordForm) actionForm;

//		if (form.getChecked() != null) {
		if (form.getChecked() != null) {
//			form.set_ne_rewardtype("5");
//			request.setAttribute("ischeck", "true");
			if ("mango".equals(form.getChecked())) 
				request.setAttribute("ischeck", "mango");
			if ("apple".equals(form.getChecked())) 
				request.setAttribute("ischeck", "apple");
			if ("orange".equals(form.getChecked())) 
				request.setAttribute("ischeck", "orange");
			if ("banana".equals(form.getChecked())) 
				request.setAttribute("ischeck", "banana");
			if ("lemon".equals(form.getChecked())) 
				request.setAttribute("ischeck", "lemon");
			if ("newtd".equals(form.getChecked())) 
				request.setAttribute("ischeck", "newtd");
		} else if ("TRUE".equals(request.getParameter("UNCHECK"))) {
		} else {
			form.set_se_rewardmonth(format.format(this.getDefaultDate(-1)));
		}
		form.set_ne_isbudget("1");
		getPurview(user);
		request.setAttribute("purview", purview);
		return actionMapping.findForward("list");
	}
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		RewardrecordForm form=(RewardrecordForm)actionForm;
		form.set_ne_isbudget("1");
		getPurview(user);
		request.setAttribute("purview", purview);
		if(form.getChecked()!=null){
//			form.set_ne_rewardtype("5");
//			request.setAttribute("ischeck", "true");
			if ("mango".equals(form.getChecked())) 
				request.setAttribute("ischeck", "mango");
			if ("apple".equals(form.getChecked())) 
				request.setAttribute("ischeck", "apple");
			if ("orange".equals(form.getChecked())) 
				request.setAttribute("ischeck", "orange");
			if ("banana".equals(form.getChecked())) 
				request.setAttribute("ischeck", "banana");
			if ("lemon".equals(form.getChecked())) 
				request.setAttribute("ischeck", "lemon");
			if ("newtd".equals(form.getChecked())) 
				request.setAttribute("ischeck", "newtd");
		}
		if(!this.doCheckRewardMonth(actionMapping, actionForm, request, response, user)){
			this.doShow(actionMapping, form, request, response, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "当前结算月酬金未出帐确认或非省级出帐确认操作工号，暂不能查询(导出)!");
			return actionMapping.findForward("list");
		}
		
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			RewardrecordListVO listVO = new RewardrecordListVO();
			setListVO(listVO, actionForm); // 设置好listVO，作为查询条件
			RewardrecordDelegate delegate = new RewardrecordDelegate();
			DataPackage pack=null;
			if ("C".equals(purview)) {
				WayVO vo = (WayVO) new WayDelegate().doFindByPk(
						user.getWayid(), user);
				if (vo != null) {
					if (vo.getCountyid() == null) {
						throw new Exception("此登录渠道县公司数据异常");
					} else {
						pack = delegate.doQuery(listVO, user, purview, vo
								.getCountyid());
					}
				} else {
					throw new Exception("登录渠道异常");
				}
			} else {
//				if(form.getChecked()!=null)
				if(form.getChecked()!=null)
				{
					StringBuffer sql=new StringBuffer("");
//					经过 林燕生 确认来的把之前的改掉
//					sql.append("(opnid like '0403%' or opnid in ('0405040100001','0405040200001','0405040300001','0405040400001','0405040500001','0405040600001') )");
					if ("mango".equals(form.getChecked())){ 
						//v13.5.0版本修改
						//sql.append("(opnid like '0403%' or opnid in ('0405040100001','0405040200001') )");
						sql.append("( opnid like '0403%' or opnid like '04050401%' or opnid like '04050402%' )");
						listVO.set_sql_condintion(sql.toString());
					}
					if ("apple".equals(form.getChecked())){
						sql.append("( opnid in ('0405040300001','0405040400001') )");
						listVO.set_sql_condintion(sql.toString());
					}
					if ("orange".equals(form.getChecked())){
						sql.append("( opnid in ('0405040500001','0405040600001','0405040500101','0405040600101','0405040500004','0405040600004','0405040500102','0405040600102') )");
						listVO.set_sql_condintion(sql.toString());
					}
					if ("banana".equals(form.getChecked())){
						sql.append("( opnid in ('0405040500002','0405040600002','0405040500003','0405040600003') )");
						listVO.set_sql_condintion(sql.toString());
					}
					if ("lemon".equals(form.getChecked())){
						sql.append("( opnid like '0405040501%' )");
						listVO.set_sql_condintion(sql.toString());
					}
					if ("newtd".equals(form.getChecked())){ 
						sql.append("( opnid like '0407%' )");
					    listVO.set_sql_condintion(sql.toString());
					    if("2".equals(form.get_ne_noncyc())){
					    	//T+2优质客户预发二期酬金40%：
					    	//限制规则ruleid like ‘ZDRW%’ 并且期数 NONCYC=2.
					    	sql.append(" and ( ruleid like 'ZDRW%' and noncyc='2' )");
					    	listVO.set_ne_noncyc(null);
					    	listVO.set_sql_condintion(sql.toString());
					    }
					    if( "3".equals(form.get_ne_noncyc())){
					    	//T+3二期酬金40%
					    	//如果规则ruleid like ‘ZDRW%’ and noncyc=3； ruleid like ‘ZDNRW%’ and noncyc=2.
					    	sql.append(" and ( (ruleid like 'ZDRW%' and noncyc='3') Or (ruleid like 'ZDNRW%' and noncyc='2') )");
					    	listVO.set_ne_noncyc(null);
					    	listVO.set_sql_condintion(sql.toString());
					    }
					    if("4".equals(form.get_ne_noncyc())){
					    	//T+3低价值扣罚酬金
					    	//如果规则ruleid like ‘ZDRW%’，noncyc=4；如果规则ruleid like ‘ZDNRW%’，noncyc=3.
					    	sql.append(" and ( (ruleid like 'ZDRW%' and noncyc='4') or (ruleid like 'ZDNRW%' and noncyc='3'))");
					    	listVO.set_ne_noncyc(null);
					    	listVO.set_sql_condintion(sql.toString());
					    }
					    if("5".equals(form.get_ne_noncyc())){
					    		//T+4IVR外呼补发酬金:
					    		//如果规则ruleid like ‘ZDRW%’，noncyc=5； 如果规则ruleid like ‘ZDNRW%’，noncyc=4.
					    	sql.append(" and ( (ruleid like 'ZDRW%' and noncyc='5') or (ruleid like 'ZDNRW%' and noncyc='4'))");
					    	listVO.set_ne_noncyc(null);
					    	listVO.set_sql_condintion(sql.toString());
					    }
					    
					}
//					sql.append("(opnid like '0403%' or opnid in ('0405040100001','0405040200001','0405040300001','0405040400001','0405040500001','0405040600001') )");
//					listVO.set_sql_condintion(sql.toString());
				}
				pack = delegate.doQuery(listVO, user, purview, null);
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("list"));
	}
	// 处理默认日期方法,正数为延后i个月,负数为提前i个月
	private Date getDefaultDate(int i) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, i);
		return c.getTime();
	}

	/*
	 *后台文件导出
	 */
	public ActionForward doDownload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		if(!this.doCheckRewardMonth(actionMapping, actionForm, request, response, user)){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "当前结算月酬金未出帐确认或非省级出帐确认操作工号，暂不能查询(导出)!");
			return actionMapping.findForward("list");
		}
		
		try {
//			SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
//			RewardrecordForm form = (RewardrecordForm) actionForm;
//			if (form.get_se_rewardmonth() == null
//					|| "".equals(form.get_se_rewardmonth())) {
//				form.set_se_rewardmonth(format.format(this.getDefaultDate(-1)));
//			}
			String chCityid = SessionFactoryRouter.conversionCityid(user
					.getCityid());
			if (chCityid == null || "".equals(chCityid)) {
				throw new Exception("该工号不属于任何地市！");
			}
			String filename = getFilePath(actionForm, user, request);
			// filename = request.getParameter("down");
			if (filename == null || "".equals(filename.trim())) {
				throw new Exception("文件路径为空！");
			}
			FtpInfo ftpInfo =null;
			if("A".equals(purview))
			{
				User user2=new User();
				BeanUtils.copyProperties(user2, user);
				String cityid2=request.getParameter("CITY")==null||"".equals(request.getParameter("CITY"))?SessionFactoryRouter.conversionCityid(user
						.getCityid()):request.getParameter("CITY");
				if(cityid2!=null)
				{
					user2.setCityid(SessionFactoryRouter.conversionCityid2Num(cityid2));
				}
				 ftpInfo = ResPubUtil.getFtpInfo(user2);
			}else
			{
				 ftpInfo = ResPubUtil.getFtpInfo(user);
			}
			FtpAccess ftp = new FtpAccess(ftpInfo);
			String localPath = FtpBusUtils.getDownloadRealPath(servlet);
			ftp.ftp.setFileType(ftp.ftp.BINARY_FILE_TYPE);
			localPath = ftp.downloadFile(localPath, filename);
			if (localPath == null) {
				throw new Exception("服务器文件不存在，下载失败！" + ftp.ftp.getReplyString());
			}
			request.setAttribute("filename", FtpBusUtils.getDownloadFilename(
					servlet, filename.trim()));
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return doShow(actionMapping, actionForm, request, response, user);
		}
		return (actionMapping.findForward("down"));
	}

	/**
	 * A-省级权限，B-地市权限,C-分公司权限
	 * 
	 * @param user
	 */
	private void getPurview(User user) throws Exception {
		ProvincialrightListVO listVO = new ProvincialrightListVO();
		listVO.set_se_proopr(user.getOpercode());
		listVO.set_se_rightid(PROVINCE_PURVIEW_A);
		listVO.set_pagesize("0");

		if (delegate.doQuery(listVO, user).getDatas().size() > 0) {
			purview = "A";
			return;
		}
		listVO.set_se_rightid(PROVINCE_PURVIEW_A2);
		if (delegate.doQuery(listVO, user).getDatas().size() > 0) {
			purview = "A";
			return;
		}
		ACLDelegate delegate2 = new ACLDelegate();
		if (delegate2.checkPermission(user.getOpercode(), CITY_PURVIEW_B)) {
			purview = "B";
			return;
		}
		if (delegate2.checkPermission(user.getOpercode(), COUNTY_PURVIEW_C)) {
			purview = "C";
			return;
		}
		purview="";
	}
	private String getFilePath(ActionForm actionForm,User user,
			HttpServletRequest request)throws Exception
	{
		StringBuffer filepath=new StringBuffer("");
		if(purview==null)
		{
			purview=request.getParameter("PURVIEW")==null?"":request.getParameter("PURVIEW");
			if(purview==null)
			{
				getPurview(user);
			}
		}
		String filetype=request.getParameter("FILETYPE")==null?"":request.getParameter("FILETYPE");
		String chCityid=request.getParameter("CITY")==null||"".equals(request.getParameter("CITY"))?SessionFactoryRouter.conversionCityid(user
				.getCityid()):request.getParameter("CITY");
		if("".equals(filetype))
		{
			throw new Exception("文件类型不正确!");
		}
//		String chCityid = SessionFactoryRouter.conversionCityid(user
//				.getCityid());
//		小写地市编码/出酬年月/ALL_分公司编码_地市编码_出酬年月.txt.gz
		RewardrecordForm form = (RewardrecordForm) actionForm;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String month=form.get_se_rewardmonth()==null?format.format(this.getDefaultDate(-1)):form.get_se_rewardmonth();
		
		SysparamDelegate sysparamDelegate = new SysparamDelegate();
		SysparamListVO listvo= new SysparamListVO();
		listvo.set_ne_systemid("66");
		listvo.set_se_paramtype("channel");
		DataPackage dp = sysparamDelegate.doQuery(listvo, user);
		if(dp.getRowCount()==0)
		{
			throw new Exception("服务器路径系统参数不存在，请核对！");
		}
		
		String path = ((SysparamVO)((List)dp.getDatas()).get(0)).getParamvalue();
		filepath.append(path);
		
		filepath.append(chCityid.toLowerCase()).append("/");
		filepath.append(month).append("/");
		String countyid=null;
		if("C".equals(purview))
		{
			WayDelegate delegate=new WayDelegate();
			WayVO vo=(WayVO)delegate.doFindByPk(user.getWayid(), user);
			if(vo==null || vo.getCountyid()==null)
			{
				throw new Exception("登录渠道异常或登录渠道的分公司为空!");
			}else
			{
				countyid=vo.getCountyid();
			}
		}
		if("total".equals(filetype))
		{
			filepath.append("ALL_");
			if("C".equals(purview))
			{
					filepath.append(countyid).append("_");
			}
		}else
		{
			filepath.append("NET_");
			if("C".equals(purview))
			{
					filepath.append(countyid).append("_");
			}
		}
		filepath.append(chCityid.toUpperCase()).append("_");
		filepath.append(month);
		if("total".equals(filetype))
		{
			filepath.append(".txt");
		}else
		{
			filepath.append(".tar");	
		}
		filepath.append(".gz");
		return filepath.toString();
	}
	
	public ActionForward doDownload2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		RewardrecordForm form = (RewardrecordForm) actionForm;
		
		if(!this.doCheckRewardMonth(actionMapping, actionForm, request, response, user)){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "当前结算月酬金未出帐确认或非省级出帐确认操作工号，暂不能查询(导出)!");
			return actionMapping.findForward("list");
		}
		
		String filename = null;
		try {
			String chCityid = SessionFactoryRouter.conversionCityid(user.getCityid());
			if (chCityid == null || "".equals(chCityid)) {
				throw new Exception("该工号不属于任何地市！");
			}
			filename = getFilePath2(actionForm, user, request);
			if (filename == null || "".equals(filename.trim())) {
				throw new Exception("文件路径为空！");
			}
			FtpInfo ftpInfo =null;
//			if("A".equals(purview))
//			{
//				User user2=new User();
//				BeanUtils.copyProperties(user2, user);
//				String cityid2=form.getCityid();
//				if(cityid2!=null)
//				{
//					user2.setCityid(SessionFactoryRouter.conversionCityid2Num(cityid2));
//				}
//				 ftpInfo = ResPubUtil.getFtpInfo(user2);
//			}else
//			{
//				 ftpInfo = ResPubUtil.getFtpInfo(user);
//			}
			ftpInfo = ResPubUtil.getFtpInfo(user);
			
			FtpAccess ftp = new FtpAccess(ftpInfo);
			String localPath = FtpBusUtils.getDownloadRealPath(servlet);
			ftp.ftp.setFileType(ftp.ftp.BINARY_FILE_TYPE);
			localPath = ftp.downloadFile(localPath, filename);
			if (localPath == null) {
				throw new Exception("服务器文件不存在，下载失败！" + ftp.ftp.getReplyString());
			}
			
			
			request.setAttribute("filename", FtpBusUtils.getDownloadFilename(
					servlet, filename.trim()));
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			
			return doShow(actionMapping, actionForm, request, response, user);
		}
		return (actionMapping.findForward("down"));
	}
	
	private String getFilePath2(ActionForm actionForm,User user,
			HttpServletRequest request)throws Exception{
//		@filebasepath@/adt/@cityid@/src/collect/boss/statements/statements_@cityid@_@yyyymm@.gz
//		参数说明：@filebasepath@是动态参数，可以查参数表ch_adt_dictparam；@cityid@是地市标识，例如江门的cityid是JM；@yyyymm@是结算月份，可供选择。

		
		StringBuffer filepath=new StringBuffer("");
		RewardrecordForm form = (RewardrecordForm) actionForm;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String month=form.get_se_rewardmonth()==null?format.format(this.getDefaultDate(-1)):form.get_se_rewardmonth();
		String chCityid=SessionFactoryRouter.conversionCityid(user.getCityid());
		
//		SysparamDelegate sysparamDelegate = new SysparamDelegate();
//		SysparamListVO listvo= new SysparamListVO();
//		listvo.set_ne_systemid("66");
//		listvo.set_se_paramtype("channel");
//		DataPackage dp = sysparamDelegate.doQuery(listvo, user);
//		if(dp.getRowCount()==0)
//		{
//			throw new Exception("服务器路径系统参数不存在，请核对！");
//		}
//		
//		String path = ((SysparamVO)((List)dp.getDatas()).get(0)).getParamvalue();
//		filepath.append(path);
		ChAdtDictparamDelegate chAdtdictparamDelegate = new ChAdtDictparamDelegate();
		ChAdtDictparamListVO listvo = new ChAdtDictparamListVO();
		listvo.set_se_dkey("filebasepath");
		DataPackage dp = chAdtdictparamDelegate.doQuery(listvo, user);
		if(dp.getRowCount()==0)
		{
			throw new Exception("服务器路径系统参数不存在，请核对！");
		}
		String path = ((ChAdtDictparamVO)((List)dp.getDatas()).get(0)).getDvalue();
		filepath.append(path);
		
		filepath.append("/adt/");
		filepath.append(chCityid.toLowerCase()).append("/");
		filepath.append("src/collect/boss/statements/statements_");
		filepath.append(chCityid.toLowerCase()).append("_");
		filepath.append(month);
		filepath.append(".gz");
		return filepath.toString();
		
	}
	
}
