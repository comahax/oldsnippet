/**
* auto-generated code
* Thu Jun 06 20:14:18 CST 2013
*/
package com.sunrise.boss.ui.cms.reward.zdrewardrecord;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamListVO;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.business.cms.reward.rewardconf.persistent.RewardconfListVO;
import com.sunrise.boss.business.cms.reward.zdrewardrecord.persistent.ZdrewardrecordListVO;
import com.sunrise.boss.business.cms.reward.zdrewardrecord.persistent.ZdrewardrecordVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.chadtdictparam.ChAdtDictparamDelegate;
import com.sunrise.boss.delegate.cms.reward.rewardconf.RewardconfDelegate;
import com.sunrise.boss.delegate.cms.reward.zdrewardrecord.ZdrewardrecordDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpBusUtils;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.commons.taglib.code2name.Node;
import com.sunrise.boss.ui.resmanage.common.ResPubUtil;

/**
 * <p>Title: ZdrewardrecordAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ZdrewardrecordAction extends BaseAction {
    public ZdrewardrecordAction() {
            setVoClass(ZdrewardrecordVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }

	@Override
	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZdrewardrecordForm zdrewardrecordForm = (ZdrewardrecordForm) actionForm;
		setTypeList(zdrewardrecordForm, request);
		
		if (!zdrewardrecordForm.isQuery()) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
			zdrewardrecordForm.set_se_calcmonth(format.format(this.getDefaultDate(-1)));
			zdrewardrecordForm.set_ne_noncyc(null);
			return actionMapping.findForward("list");
		}
		
		if(!this.doCheckRewardMonth(actionMapping, actionForm, request, response, user)){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "当前结算月酬金未出帐确认或非省级出帐确认操作工号，暂不能查询(导出)!");
			return actionMapping.findForward("list");
		}
		
		Page.setPageSize(request, (BaseActionForm) actionForm);
		ZdrewardrecordListVO listVO = new ZdrewardrecordListVO();
		setListVO(listVO, actionForm);
		ZdrewardrecordDelegate delegate = new ZdrewardrecordDelegate();
		DataPackage dp = delegate.doQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return actionMapping.findForward("list");
	}

	@Override
	protected ActionForward doTxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("终端酬金结果查询");
		export.addOutputProperty("seq");
		export.addOutputProperty("calcmonth");
		export.addOutputProperty("opnid");
		export.addOutputProperty("name");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayname");
		export.addOutputProperty("oprcode");
		export.addOutputProperty("mobile");
		export.addOutputProperty("oprtime", CommonExportBean.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("runtime", CommonExportBean.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("ruleid");
		export.addOutputProperty("resultflag");
		export.addOutputProperty("adtflag");
		export.addOutputProperty("adtcode");
		export.addOutputProperty("adtremark");
		export.addOutputProperty("rewardtype");
		export.addOutputProperty("rewardflag");
		export.addOutputProperty("repairmonth");
		export.addOutputProperty("batchno");
		export.addOutputProperty("bakinfo");
		export.addOutputProperty("bakinfo2");
		export.addOutputProperty("bakinfo2", CommonExportBean.CODE2NAME, "#IM_PR_COM");
		export.addOutputProperty("bakinfo3");
		export.addOutputProperty("wrapfee");
		export.addOutputProperty("noncyc");
		export.addOutputProperty("totalsum");
		export.addOutputProperty("paysum");
		export.addOutputProperty("paymoney1");
		export.addOutputProperty("assegrade2");
		export.addOutputProperty("prodid");
		export.addOutputProperty("bakinfo4");
		export.addOutputProperty("bakinfo5");
		export.addOutputProperty("bakinfo6",CommonExportBean.CODE2NAME, "$ZD_SYSTEM"); 
		export.addOutputProperty("bakinfo7");
		export.addOutputProperty("bakinfo8");
		export.addOutputProperty("bakinfo9");
		export.addOutputProperty("bakinfo10" ,CommonExportBean.CODE2NAME, "$ZD_TYPE");
		
		export.voClassArray = new Class[] { ZdrewardrecordVO.class };
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] { "流水号",
				"结算月份", "全省业务编码", "业务名称", "渠道编码", "渠道名称", "业务发生工号", "业务发生号码",
				"业务发生时间", "校验时间", "校验规则编码", "成功失败结果标识", "稽核结果标识", "校验结果编码",
				"校验结果描述", "酬金类型", "计算标识", "补算月份", "批次号", "IMEI", "商品ID", "商品名称",
				"商品协议价", "承诺低消", "酬金期数", "应发酬金", "计算酬金", "实发酬金","考核系数2","产品ID","基准价",
				"酬金点数","终端制式","流量","ARPU值","优质客户","终端类型"});
		super.ExportQuery(actionMapping, actionForm, request, response, user, export);
		return actionMapping.findForward(null);
	}
	
	public ActionForward doDownload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
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
			filename = getFilePath(actionForm, user, request);
			if (filename == null || "".equals(filename.trim())) {
				throw new Exception("文件路径为空！");
			}
			FtpInfo ftpInfo =null;
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
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			return doList(actionMapping, actionForm, request, response, user);
		}
		return actionMapping.findForward("down");
	}
	
	private String getFilePath(ActionForm actionForm, User user,
			HttpServletRequest request) throws Exception {
		StringBuffer filepath = new StringBuffer("");
		ZdrewardrecordForm form = (ZdrewardrecordForm) actionForm;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		String month = form.get_se_calcmonth() == null ? format.format(calendar.getTime()) : form.get_se_calcmonth();
		String chCityid = SessionFactoryRouter.conversionCityid(user.getCityid());

		ChAdtDictparamDelegate chAdtdictparamDelegate = new ChAdtDictparamDelegate();
		ChAdtDictparamListVO listvo = new ChAdtDictparamListVO();
		listvo.set_se_dkey("filebasepath");
		DataPackage dp = chAdtdictparamDelegate.doQuery(listvo, user);
		if (dp.getRowCount() == 0) {
			throw new Exception("服务器路径系统参数不存在，请核对！");
		}
		String path = ((ChAdtDictparamVO) ((List) dp.getDatas()).get(0)).getDvalue();
		filepath.append(path);

		filepath.append("/adt/");
		filepath.append(chCityid.toLowerCase()).append("/");
		filepath.append("src/collect/boss/onekey/onekey_");
		filepath.append(chCityid.toLowerCase()).append("_");
		filepath.append(month);
		filepath.append(".gz");
		return filepath.toString();
	}
	
	private void setTypeList(ZdrewardrecordForm zdrewardrecordForm, HttpServletRequest request) {
		LinkedList<Node> zdrewardList = new LinkedList<Node>();
		Node allzd = new Node();
		allzd.setCode("allzd");
		allzd.setName(" ");
		zdrewardList.add(allzd);
		Node hyzd = new Node();
		hyzd.setCode("hyzd");
		hyzd.setName("合约终端");
		zdrewardList.add(hyzd);
		Node lhyzd = new Node();
		lhyzd.setCode("lhyzd");
		lhyzd.setName("零合约终端");
		zdrewardList.add(lhyzd);
		Node ljzd = new Node();
		ljzd.setCode("ljzd");
		ljzd.setName("裸机终端");
		zdrewardList.add(ljzd);
		Node lptzd = new Node();
		lptzd.setCode("lptzd");
		lptzd.setName("类平台终端");
		zdrewardList.add(lptzd);
		//2014-06-09 a-biao add
		Node newzd = new Node();
		newzd.setCode("newzd");
		newzd.setName("2014年新终端酬金");
		zdrewardList.add(newzd);
		
		Node zdyzq = new Node();
		zdyzq.setCode("zdyzq");
		zdyzq.setName("终端优质渠道半月预发酬金");
		zdrewardList.add(zdyzq);
		
		Node jdljarpu = new Node();
		jdljarpu.setCode("jdljarpu");
		jdljarpu.setName("京东商城裸机终端ARPU分成酬金");
		zdrewardList.add(jdljarpu);
		
		Node jdljstd = new Node();
		jdljstd.setCode("jdljstd");
		jdljstd.setName("京东商城裸机终端基准价分成酬金");
		zdrewardList.add(jdljstd);
		
		Node g3timefisrt = new Node();
		g3timefisrt.setCode("g3timefisrt");
		g3timefisrt.setName("3GTIMES机首期酬金");
		zdrewardList.add(g3timefisrt);
		
		Node g3timearpu = new Node();
		g3timearpu.setCode("g3timearpu");
		g3timearpu.setName("3GTIMES机ARPU分成酬金");
		zdrewardList.add(g3timearpu);
		
		Node g4timezh = new Node();
		g4timezh.setCode("g4timezh");
		g4timezh.setName("4GTIMES机转化酬金");
		zdrewardList.add(g4timezh);
		
		Node g4timeph = new Node();
		g4timeph.setCode("g4timeph");
		g4timeph.setName("4GTIMES机普惠办理酬金");
		zdrewardList.add(g4timeph);
		
		Node g4notimeph = new Node();
		g4notimeph.setCode("g4notimeph");
		g4notimeph.setName("4G非TIMES机普惠办理酬金");
		zdrewardList.add(g4notimeph);
		
		Node g4notime3in1 = new Node();
		g4notime3in1.setCode("g4notime3in1");
		g4notime3in1.setName("4G非TIMES机三合一升级酬金");
		zdrewardList.add(g4notime3in1);
		
		//2015年2月 	BR201501120007 关于2015年优化合作渠道终端酬金的通知 添加 a-biao
		//终端类型:库内机转化酬金opnid like '04110501%'
		Node kuneijizhuanhua = new Node();
		kuneijizhuanhua.setCode("kuneijizhuanhua");
		kuneijizhuanhua.setName("库内机转化酬金");
		zdrewardList.add(kuneijizhuanhua);
		
		//库内机分成酬金      opnid like '04110502%'
		Node kuneijifencheng = new Node();
		kuneijifencheng.setCode("kuneijifencheng");
		kuneijifencheng.setName("库内机分成酬金");
		zdrewardList.add(kuneijifencheng);
		//	自带机转化酬金      opnid like '04111501%'
		Node zidaijizhuanhua = new Node();
		zidaijizhuanhua.setCode("zidaijizhuanhua");
		zidaijizhuanhua.setName("自带机转化酬金");
		zdrewardList.add(zidaijizhuanhua);
		//	自带机分成酬金      opnid like '04111502%'
		Node zidaijifencheng = new Node();
		zidaijifencheng.setCode("zidaijifencheng");
		zidaijifencheng.setName("自带机分成酬金");
		zdrewardList.add(zidaijifencheng);

		
		request.setAttribute("zdrewardList", zdrewardList);
		
		LinkedList<Node> noncycList = new LinkedList<Node>();
		Node jbqs0 = new Node();
		jbqs0.setCode("0");
		jbqs0.setName(" ");
		noncycList.add(jbqs0);
		Node jbqs1 = new Node();
		jbqs1.setCode("1");
		jbqs1.setName("一期");
		noncycList.add(jbqs1);
		Node jbqs2 = new Node();
		jbqs2.setCode("2");
		jbqs2.setName("二期");
		noncycList.add(jbqs2);
		Node jbqs3 = new Node();
		jbqs3.setCode("3");
		jbqs3.setName("三期");
		noncycList.add(jbqs3);
		Node jbqs4 = new Node();
		jbqs4.setCode("4");
		jbqs4.setName("四期");
		noncycList.add(jbqs4);
		Node jbqs5 = new Node();
		jbqs5.setCode("5");
		jbqs5.setName("五期");
		noncycList.add(jbqs5);
		Node jbqs6 = new Node();
		jbqs6.setCode("6");
		jbqs6.setName("六期");
		noncycList.add(jbqs6);
		Node jbqs7 = new Node();
		jbqs7.setCode("7");
		jbqs7.setName("七期");
		noncycList.add(jbqs7);
		Node jbqs8 = new Node();
		jbqs8.setCode("8");
		jbqs8.setName("八期");
		noncycList.add(jbqs8);
		Node jbqs9 = new Node();
		jbqs9.setCode("9");
		jbqs9.setName("九期");
		noncycList.add(jbqs9);
		Node jbqs10 = new Node();
		jbqs10.setCode("10");
		jbqs10.setName("十期");
		noncycList.add(jbqs10);
		Node jbqs11 = new Node();
		jbqs11.setCode("11");
		jbqs11.setName("十一期");
		noncycList.add(jbqs11);
		Node jbqs12 = new Node();
		jbqs12.setCode("12");
		jbqs12.setName("十二期");
		noncycList.add(jbqs12);		
		request.setAttribute("noncycList", noncycList);
		
//		if (zdrewardrecordForm.get_se_zdreward() == null
//				|| "".equals(zdrewardrecordForm.get_se_zdreward())
//				|| "hyzd".equals(zdrewardrecordForm.get_se_zdreward())) {
//			LinkedList<Node> noncycList = new LinkedList<Node>();
//			Node jbcj = new Node();
//			jbcj.setCode("1");
//			jbcj.setName("服务业务基本酬金");
//			noncycList.add(jbcj);
//			Node jlcj = new Node();
//			jlcj.setCode("2");
//			jlcj.setName("服务业务奖励酬金");
//			noncycList.add(jlcj);
//			request.setAttribute("noncycList", noncycList);
//		} else if ("lhyzd".equals(zdrewardrecordForm.get_se_zdreward())) {
//			LinkedList<Node> noncycList = new LinkedList<Node>();
//			Node yqcj = new Node();
//			yqcj.setCode("1");
//			yqcj.setName("服务业务一期酬金");
//			noncycList.add(yqcj);
//			Node eqcj = new Node();
//			eqcj.setCode("2");
//			eqcj.setName("服务业务二期酬金");
//			noncycList.add(eqcj);
//			Node sqcj = new Node();
//			sqcj.setCode("3");
//			sqcj.setName("服务业务三期酬金");
//			noncycList.add(sqcj);
//			request.setAttribute("noncycList", noncycList);
//		} else if ("ljzd".equals(zdrewardrecordForm.get_se_zdreward())) {
//			LinkedList<Node> noncycList = new LinkedList<Node>();
//			Node jbcj = new Node();
//			jbcj.setCode("1");
//			jbcj.setName("服务业务基本酬金");
//			noncycList.add(jbcj);
//			Node khcj = new Node();
//			khcj.setCode("2");
//			khcj.setName("服务业务考核酬金");
//			noncycList.add(khcj);
//			request.setAttribute("noncycList", noncycList);
//		} else if ("lptzd".equals(zdrewardrecordForm.get_se_zdreward())) {
//			LinkedList<Node> noncycList = new LinkedList<Node>();
//			Node jbcj = new Node();
//			jbcj.setCode("1");
//			jbcj.setName("服务业务基本酬金");
//			noncycList.add(jbcj);
//			Node khcj = new Node();
//			khcj.setCode("2");
//			khcj.setName("服务业务考核酬金");
//			noncycList.add(khcj);
//			request.setAttribute("noncycList", noncycList);
//		}else if (zdrewardrecordForm.get_se_zdreward() == null
//				|| "".equals(zdrewardrecordForm.get_se_zdreward())
//				|| "newzd".equals(zdrewardrecordForm.get_se_zdreward())) {
//			//2014-06-09 a-biao add
//			LinkedList<Node> noncycList = new LinkedList<Node>();
//			Node jbcj = new Node();
//			jbcj.setCode("1");
//			jbcj.setName("T、T+1、T+2一期酬金");
//			noncycList.add(jbcj);
//			Node jlcj = new Node();
//			jlcj.setCode("2");
//			jlcj.setName("T+2优质客户预发二期酬金");
//			noncycList.add(jlcj);
//			Node t3eqcj = new Node();
//			t3eqcj.setCode("3");
//			t3eqcj.setName("T+3二期酬金");
//			noncycList.add(t3eqcj);
//			Node t3djz = new Node();
//			t3djz.setCode("4");
//			t3djz.setName("T+3低价值扣罚酬金");
//			noncycList.add(t3djz);
//			Node t4ivr = new Node();
//			t4ivr.setCode("5");
//			t4ivr.setName("T+4IVR外呼补发酬金");
//			noncycList.add(t4ivr);
//			request.setAttribute("noncycList", noncycList);
//		}else if (zdrewardrecordForm.get_se_zdreward() == null
//				|| "".equals(zdrewardrecordForm.get_se_zdreward())
//				|| "zdyzq".equals(zdrewardrecordForm.get_se_zdreward())) {
//			//2014-06-09 a-biao add
//			//对应酬金类型下拉框隐藏，NONCYC默认为1
//			LinkedList<Node> noncycList = new LinkedList<Node>();
//			Node jbcj = new Node();
//			jbcj.setCode("1");
//			jbcj.setName(" ");
//			noncycList.add(jbcj);
//			request.setAttribute("noncycList", noncycList);
//		}else if (zdrewardrecordForm.get_se_zdreward() == null
//				|| "".equals(zdrewardrecordForm.get_se_zdreward())
//				|| "jdlj".equals(zdrewardrecordForm.get_se_zdreward())) {
//			//2014-06-09 a-biao add
//			LinkedList<Node> noncycList = new LinkedList<Node>();
//			Node jbcj = new Node();
//			jbcj.setCode("1");
//			jbcj.setName("ARPU分成酬金");
//			noncycList.add(jbcj);
//			Node jlcj = new Node();
//			jlcj.setCode("2");
//			jlcj.setName("基准价分成酬金");
//			noncycList.add(jlcj);
//			request.setAttribute("noncycList", noncycList);
//		}
	}
	
	public boolean doCheckRewardMonth(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZdrewardrecordForm form = (ZdrewardrecordForm) actionForm;
		
		RewardconfListVO listvo = new RewardconfListVO();
		listvo.set_se_rewardkind("AG");
		listvo.set_se_rewardmonth(form.get_se_calcmonth().trim());
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
		CommonDelegate delegate = new CommonDelegate(ProvincialrightVO.class);
		rightvo = (ProvincialrightVO) delegate.doFindByPk(rightvo, user);
		if(rightvo == null){
			return false;
		}else{
			return true;
		}
	}
	
	// 处理默认日期方法,正数为延后i个月,负数为提前i个月
	private Date getDefaultDate(int i) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, i);
		return c.getTime();
	}
}
