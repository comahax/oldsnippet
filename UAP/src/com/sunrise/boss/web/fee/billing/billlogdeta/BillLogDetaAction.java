package com.sunrise.boss.web.fee.billing.billlogdeta;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sunrise.boss.business.fee.billing.billlogdeta.control.BillLogDeta;
import com.sunrise.boss.business.fee.billing.billlogdeta.control.BillLogDetaBO;
import com.sunrise.boss.business.fee.billing.billlogdeta.persistent.BillLogDetaDBParam;
import com.sunrise.boss.business.fee.billing.billlogdeta.persistent.BillLogDetaVO;
import com.sunrise.jop.business.base.dictitem.DictitemDBParam;
import com.sunrise.jop.business.base.dictitem.DictitemVO;
import com.sunrise.jop.common.commoncontrol.CommonBO;
import com.sunrise.jop.common.utils.i18n.Message;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

public class BillLogDetaAction extends BaseAction{
	public static final String BILLLOGDETA_FEE_PROPERTIES = "/com/sunrise/boss/web/fee/billing/billlogdeta/BillLogDetaAction_zh_CN.properties";
	public static String expr = "";
	public BillLogDetaAction(){
		setForm(new BillLogDetaForm());
		setParam(new BillLogDetaDBParam());
		
		setClsVO(BillLogDetaVO.class);
		this.pkNameArray = new String[]{"logid","validbillcyc","subphase","acctid"};
		
		setClsControl(BillLogDeta.class);
		setClsQueryParam(BillLogDetaDBParam.class);
		setDbFlag(DBConstant.DB_FLAG_BILL);

	}
	
	public String doList() throws Exception {
		
		User user = (User)super.getDBAccessUser();
		
		BillLogDetaForm form = (BillLogDetaForm)super.getForm();
		
		//获取查询条件
		BillLogDetaDBParam params = (BillLogDetaDBParam)super.getParam();
		params.set_ne_validbillcyc(form.get_ne_validbillcyc());
		params.set_sk_subphase(form.get_sk_subphase());
		
		//执行查询
		BillLogDeta bdc = (BillLogDeta)BOFactory.build(BillLogDetaBO.class, user);
		DataPackage dp = bdc.doQuery(params, user);
		setDp(dp);
		super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		
		return "list";
	}

	/**
	 * 判断是否为往月账期
	 * @param region 地市
	 * @param validbillcyc 账期
	 * @return
	 * @throws Exception
	 */
	private boolean validHisValidbillcyc(Long region,Long validbillcyc)throws Exception{
		User user = (User)super.getDBAccessUser();
		BillLogDeta bdc = (BillLogDeta)BOFactory.build(BillLogDetaBO.class, user);
		return bdc.doValidBillValidbillcyc(region,validbillcyc,user);
	}
	
	/**
	 * 统计临时应收
	 * @param dp
	 * @return
	 * @throws Exception
	 */
	private Double getBillLogDetaAmt(Long validbillcyc) throws Exception
	{	
		User user = (User)super.getDBAccessUser();

		Map<String, StringBuffer> map =  getSubPhase();
		
		BillLogDeta bdc = (BillLogDeta)BOFactory.build(BillLogDetaBO.class, user);

		Double rv1 = bdc.getBillLogDetaAmt(map.get("pkey").toString(),validbillcyc, user);

		Double rv2 = bdc.getBillLogDetaAmt(map.get("mkey").toString(),validbillcyc, user);
		
		expr = map.get("vkey").toString();
		
		return rv1 - rv2;
	}
	
	public Double getRHUNWFACCTRecvAmt(Long validbillcyc) throws Exception 
	{
		User user = (User)super.getDBAccessUser();
		
		BillLogDeta bdc = (BillLogDeta)BOFactory.build(BillLogDetaBO.class, user);
		
		Double result = bdc.getRHUNWFACCTRecvAmt(user,validbillcyc);
		
		return result;
	}
	
	public String doView() throws Exception
	{
		HttpServletRequest request = this.getRequest();
		
		Map<String, StringBuffer> map =  getSubPhase();
		expr = map.get("vkey").toString();
		request.setAttribute("expr", expr);
//		
//		Long rBillLogDeta = getBillLogDetaAmt();
//		Long rRecvAmt = getRHUNWFACCTRecvAmt();
//		
//		request.setAttribute("rBillLogDeta", rBillLogDeta);
//		request.setAttribute("rRecvAmt", rRecvAmt);
//		
//		boolean isBalance = rBillLogDeta == rRecvAmt;//是否平衡
//		request.setAttribute("isBalance", isBalance);
		// add by yangdaren start
		// 初始化公式左边和右边的金额
		request.setAttribute("rBillLogDeta", 0L);
		request.setAttribute("rRecvAmt", 0L);
		request.setAttribute("isBalance", true);
		// add by yangdaren end
		
		return "index";
	}
	
	public String doList1() throws Exception
	{
		User user = (User)super.getDBAccessUser();
		HttpServletRequest request = this.getRequest();
		BillLogDetaDBParam param = (BillLogDetaDBParam)super.getParam();
		
		//判断是否为往月账期
		boolean isHis = validHisValidbillcyc(Long.valueOf(user.getCityid()),new Long(param.get_ne_validbillcyc()));
		
		Double rBillLogDeta =  getBillLogDetaAmt(new Long(param.get_ne_validbillcyc()));
		Double rRecvAmt = 0D;
		
		
		if(!isHis){//不是往月账期，则从临时应收表获取
			rRecvAmt = getRHUNWFACCTRecvAmt(new Long(param.get_ne_validbillcyc()));
		}else{//将出账处理明细金额累计赋值给公式公式左边
			rRecvAmt = rBillLogDeta;
		}
		
		rBillLogDeta = DoubleFormat(rBillLogDeta,2);
		rRecvAmt = DoubleFormat(rRecvAmt,2);
		
		// 公式右边金额
		request.setAttribute("rBillLogDeta", rBillLogDeta);
		// 公式左边金额
		request.setAttribute("rRecvAmt", rRecvAmt);
		//updata by yangdaren start
		//boolean isBalance = rBillLogDeta == rRecvAmt;//是否平衡
		boolean isBalance = rBillLogDeta.equals(rRecvAmt);//是否平衡
		//update by yangdaren end
		request.setAttribute("isBalance", isBalance);
		
		param.getQueryConditions().put("_ne_validbillcyc", param.get_ne_validbillcyc());
		
		BillLogDeta bdc = (BillLogDeta)BOFactory.build(BillLogDetaBO.class, user);
		DataPackage dp = bdc.doQueryBillLogDeta(param, user);
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		setDp(dp);

		request.setAttribute("expr", expr);

		return "index";
	}
	public String doExcel() throws Exception
	{
		User user = (User)super.getDBAccessUser();
		HttpServletRequest request = super.getRequest();
		
		BillLogDetaDBParam param = (BillLogDetaDBParam)super.getParam();
		
		ExcelOutBillLogDeta export = new ExcelOutBillLogDeta(user);
		export.setFileName(Message.getString(BILLLOGDETA_FEE_PROPERTIES, "title"));
		
		request.setAttribute("creator", export);
		request.setAttribute("LISTVO", param);
		request.setAttribute("queryVO", request);
		
		return "excelout";
	}
	
	public String doExcel1() throws Exception
	{
		User user = (User)super.getDBAccessUser();
		HttpServletRequest request = super.getRequest();
		
		BillLogDetaDBParam param = (BillLogDetaDBParam)super.getParam();
		
		ExcelOutBillLogDetaCollect export = new ExcelOutBillLogDetaCollect(user);
		export.setFileName(Message.getString(BILLLOGDETA_FEE_PROPERTIES, "title"));
		
		request.setAttribute("creator", export);
		request.setAttribute("LISTVO", param);
		request.setAttribute("queryVO", request);
		
		return "excelout";
	}
	
	public Map<String, StringBuffer> getSubPhase() throws Exception
	{
		User user = (User)super.getDBAccessUser();
		
		DictitemDBParam param = new DictitemDBParam();
		param.set_se_groupid("ACCT_BALANCE");
		param.set_ssw_dictid("G");
		param.set_pagesize("0");
		CommonBO bo = (CommonBO)BOFactory.build(CommonBO.class, user);
		bo.setVoClass(DictitemVO.class);
		param.set_orderby("sortorder");
		DataPackage dp = bo.doQuery(param);
		
		List list = dp.toList(DictitemVO.class);
		
		Map<String, StringBuffer> map = new HashMap<String,StringBuffer>();
		StringBuffer pStr  = new StringBuffer();
		StringBuffer mStr  = new StringBuffer();
		StringBuffer vStr = new StringBuffer();
		for(int i = 0;i < list.size();i++)
		{
			DictitemVO dvo = (DictitemVO)list.get(i);
			if("+".equals(dvo.getDescription())){
				pStr.append("'"+dvo.getDictid()+"',");
			}
			
			if("-".equals(dvo.getDescription())){
				mStr.append("'"+dvo.getDictid()+"',");
			}
			vStr.append(dvo.getDescription());
			vStr.append(dvo.getDictid());
			vStr.append("(");
			vStr.append(dvo.getDictname());
			vStr.append(")");
		}
		
		pStr = pStr.replace(pStr.lastIndexOf(","), pStr.length(), "");
		map.put("pkey", pStr);
		
		mStr = mStr.replace(mStr.lastIndexOf(","), mStr.length(), "");
		map.put("mkey", mStr);

		if(String.valueOf(vStr).startsWith("+")){
			vStr = vStr.replace(vStr.indexOf("+"), vStr.indexOf("+") + 1, "");
		}
		else if(String.valueOf(vStr).startsWith("-")){
			vStr = vStr.replace(vStr.indexOf("-"), vStr.indexOf("+") + 1, "");
		}
		else{
			throw new Exception("字典参数[ACCT_BALANCE]设置有误,请检查!");
		}
		map.put("vkey", vStr);
		
		return map;
	}
	
	/**
	 * 转换double小数位数
	 * 
	 * @param doub
	 *            需要转换的数字
	 * @param num
	 *            需要精确到小数位后多少位 如为0则原样返回doub
	 * @return
	 */
	public static double DoubleFormat(double doub, int num) {
		if (num == 0) {
			return doub;
		}
		String formatstr = "#######.";
		for (int i = 0; i < num; i++) {
			formatstr = formatstr + "#";
		}
		DecimalFormat df = new DecimalFormat(formatstr);
		return Double.valueOf(df.format(doub)).doubleValue();
	}
}
