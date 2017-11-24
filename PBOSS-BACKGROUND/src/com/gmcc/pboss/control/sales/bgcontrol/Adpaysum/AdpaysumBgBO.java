package com.gmcc.pboss.control.sales.bgcontrol.Adpaysum;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.adpaydet.AdpaydetVO;
import com.gmcc.pboss.business.sales.adpaysum.AdpaysumVO;
import com.gmcc.pboss.business.sales.bgbusiness.Adpaysum.AdpaysumBgDAO;
import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.adpaydet.Adpaydet;
import com.gmcc.pboss.control.sales.adpaydet.AdpaydetBO;
import com.gmcc.pboss.control.sales.adpaysum.Adpaysum;
import com.gmcc.pboss.control.sales.adpaysum.AdpaysumBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * 垫资订单汇总 后台逻辑之业务Bean
 * 
 * @author zsw
 * 
 */
public class AdpaysumBgBO extends AbstractControlBean implements AdpaysumBg {
	
	private static int PAGE_SIZE = 50;
	
	private Logger log = Logger.getLogger(AdpaysumBgBO.class);

	/**
	 * <pre>
	 * 确定目标时段 
	 * 入口参数无指定日期和时段，则根据当前时间和系统设定的时段进行匹配
	 * 支持两个时间段的情况
	 * </pre>
	 * @param periodA  格式为 x-y (example:9-14)
	 * @param periodB  格式为 x-y (example:9-14)
	 * @return String[0]为起始时间，String[1]为终止时间 (格式为yyyy-MM-dd HH:mm:ss)
	 * @throws Exception
	 */
	private String[] confirmPeriodFromDB(String periodA, String periodB)
			throws Exception {

		String[] result = new String[2];
		String[] period_A = StringUtils.split(periodA, "-");
		String[] period_B = StringUtils.split(periodB, "-");
		Date now = new Date();
		String nowDateStr = PublicUtils.formatUtilDate(now, "yyyy-MM-dd");
		String temp_A_BeginStr = nowDateStr + " " + period_A[0] + ":00:00";
		String temp_A_EndStr = nowDateStr + " " + period_A[1] + ":00:00";
		Calendar[] period_A_Date = compare2DateAndChangeOne(temp_A_BeginStr,
				temp_A_EndStr, "0", -1);
		String temp_B_BeginStr = nowDateStr + " " + period_B[0] + ":00:00";
		String temp_B_EndStr = nowDateStr + " " + period_B[1] + ":00:00";
		Calendar[] period_B_Date = compare2DateAndChangeOne(temp_B_BeginStr,
				temp_B_EndStr, "0", -1);

		if (period_A_Date[1].getTime().after(now)
				&& period_B_Date[1].getTime().after(now)) {// 若两个终止时间大于当前时间

			period_A_Date[0].add(Calendar.DAY_OF_MONTH, -1);
			period_A_Date[1].add(Calendar.DAY_OF_MONTH, -1);
			period_B_Date[0].add(Calendar.DAY_OF_MONTH, -1);
			period_B_Date[1].add(Calendar.DAY_OF_MONTH, -1);
		}
		Date period_A_BeginDate = period_A_Date[0].getTime();
		Date period_A_EndDate = period_A_Date[1].getTime();
		Date period_B_BeginDate = period_B_Date[0].getTime();
		Date period_B_EndDate = period_B_Date[1].getTime();

		if (period_A_EndDate.before(now) && period_B_EndDate.after(now)) {

			result[0] = PublicUtils.utilDateToStr(period_A_BeginDate);
			result[1] = PublicUtils.utilDateToStr(period_A_EndDate);

		} else if (period_A_EndDate.after(now) && period_B_EndDate.before(now)) {

			result[0] = PublicUtils.utilDateToStr(period_B_BeginDate);
			result[1] = PublicUtils.utilDateToStr(period_B_EndDate);

		} else if (period_A_EndDate.before(now) && period_B_EndDate.before(now)) {
			long interval_A = now.getTime() - period_A_EndDate.getTime();
			long interval_B = now.getTime() - period_B_EndDate.getTime();
			if (interval_A <= interval_B) {
				result[0] = PublicUtils.utilDateToStr(period_A_BeginDate);
				result[1] = PublicUtils.utilDateToStr(period_A_EndDate);
			} else {
				result[0] = PublicUtils.utilDateToStr(period_B_BeginDate);
				result[1] = PublicUtils.utilDateToStr(period_B_EndDate);
			}
		}
		return result;
	}

	/**
	 * <pre>
	 * 确定目标时段 
	 * 入口参数指定日期和时段，则按照日期加起止时段进行组合
	 * </pre>
	 * @param date
	 * @param period 格式为 x-y (example:9-14)
	 * @return String[0]为起始时间，String[1]为终止时间 (格式为yyyy-MM-dd HH:mm:ss)
	 * @throws Exception
	 */
	private String[] confirmPeriodFromConsole(String date, String period)
			throws Exception {
		String[] per = StringUtils.split(period, "-");
		String tempBeginStr = date + " " + per[0] + ":00:00";
		String tempEndStr = date + " " + per[1] + ":00:00";
		Calendar[] cal = compare2DateAndChangeOne(tempBeginStr, tempEndStr,
				"1", 1);
		String[] result = new String[2];
		result[0] = PublicUtils.utilDateToStr(cal[0].getTime());
		result[1] = PublicUtils.utilDateToStr(cal[1].getTime());
		return result;
	}

	/**
	 * <pre>
	 * 比较 beginDate 和 endDate 两个日期的大小;
	 * 当beginDate 大于 endDate, beChanged为0时改变起始时间的天数，1时改变终止时间的天数
	 * interval 表示增加或减少的天数
	 * </pre>
	 * 
	 * @param beginDate
	 * @param endDate
	 * @param beChanged
	 *            为0时改变起始时间的天数，1时改变终止时间的天数
	 * @param intervel
	 *            正整数时为增加天数，负整数时为减少天数
	 * @return
	 * @throws Exception
	 */
	private Calendar[] compare2DateAndChangeOne(String beginDate,
			String endDate, String beChanged, int intervel) throws Exception {

		Calendar[] result = new Calendar[2];
		Date tempBegin = PublicUtils.UtilStrToDate(beginDate);
		Date temEnd = PublicUtils.UtilStrToDate(endDate);
		Calendar begincal = Calendar.getInstance();
		begincal.setTime(tempBegin);
		Calendar endcal = Calendar.getInstance();
		endcal.setTime(temEnd);
		if (begincal.after(endcal)) {
			if ("0".equals(beChanged)) { // 改变起始时间
				begincal.add(Calendar.DAY_OF_MONTH, intervel);
			} else if ("1".equals(beChanged)) { // 改变终止时间
				endcal.add(Calendar.DAY_OF_MONTH, intervel);
			}
		}
		result[0] = begincal;
		result[1] = endcal;

		return result;
	}

	public Map<String, String> doGetOrdersOfDisCom(String begintime,
			String endtime, String paytype, int pagesize) throws Exception {
		Order orderBO = (OrderBO)BOFactory.build(OrderBO.class,user);
		OrderDBParam param = new OrderDBParam();
		param.set_dnl_createtime(begintime);
		param.set_dnm_createtime(endtime);
		param.set_se_paytype(paytype);
		param.setCountOnly(true);
		DataPackage dp = orderBO.doQuery(param);
		
		AdpaysumBgDAO dao = (AdpaysumBgDAO) DAOFactory.build(
				AdpaysumBgDAO.class, user);
		//总记录数
		int rowCount = dp.getRowCount();
		Map<String,String> result = new HashMap<String,String>();
		
		if(rowCount > 0){
			// 总页数
			int pageCount = new Double(Math.ceil(((double)rowCount/pagesize))).intValue(); 
			for(int pageIndex = 1;pageIndex <= pageCount;pageIndex++) {
				int beginRow = pagesize*(pageIndex-1);
				int endRow = beginRow + pagesize;
				Map<String,String> temp = 
					dao.getOrdersOfDisCom(begintime, endtime, paytype, beginRow, endRow);
				for(Iterator<String> it = temp.keySet().iterator();it.hasNext();) {
					// 配送商
					String disCom = it.next();
					if(!result.containsKey(disCom)) {
						// 若还没含有该配送商的ID信息，则put进map中
						result.put(disCom,temp.get(disCom));
					}else { 
						// 若已经含有该配送商的部分ID信息，则将当前的ID信息与之前的拼接起来
						String orderIds = temp.get(disCom);
						String newOrderIds = result.get(disCom) + orderIds;
						result.put(disCom, newOrderIds);
					}
				}
			}
			
		}
		return result;
	}
	
	public Map<String,String> doStatOrderAndUnsubSum(String begintime,
			String endtime, String paytype) throws Exception {
		AdpaysumBgDAO dao = (AdpaysumBgDAO)DAOFactory.build(AdpaysumBgDAO.class, user);
		return dao.statOrderAndUnsubSum(begintime, endtime, paytype);
	}
	
	public void doProcess(String[] parameters) throws Exception {
		
		String begintime = "";
		String endtime = "";
		String[] beginEndTime = new String[2];
		if(parameters.length == 1) {
			Sysparam spBo = (SysparamBO)BOFactory.build(SysparamBO.class, user);
			String periodValue = spBo.doFindByID(37L, "pboss_fx");
			if(periodValue == null || "".equals(periodValue))
				throw new Exception("系统参数[垫资订单汇总时段]无数据");
			String[] period = StringUtils.split(periodValue, ",");
			beginEndTime = this.confirmPeriodFromDB(period[0], period[1]);
			
			
		}else if(parameters.length == 3) {
			beginEndTime = this.confirmPeriodFromConsole(parameters[1], parameters[2]);
		}
		begintime = beginEndTime[0];
		endtime = beginEndTime[1];
		
		// <配送商,orderid1|orderid2|.....>
		Map<String,String> orderMap = 
			this.doGetOrdersOfDisCom(begintime, endtime, "ADPAY", PAGE_SIZE);
		
		// <配送商,订单金额|退单金额>
		Map<String,String> sumMap = 
			this.doStatOrderAndUnsubSum(begintime, endtime, "ADPAY");
		
		for(Iterator<String> it = sumMap.keySet().iterator();it.hasNext();) {
			
			String disCom = it.next();
			String sumValue = sumMap.get(disCom);
			try {
				AdpaysumBg asBO = (AdpaysumBg)BOFactory.build(AdpaysumBgBO.class,user,BOFactory.PROPAGATION_REQUIRES_NEW);
				asBO.doInsertAdpaySumAndDetail(disCom, sumValue, begintime, endtime, orderMap);
			}catch(Exception ex) {
				LoggerUtils.error(ex, log);
			}
			
		}
	}
	
	public void doInsertAdpaySumAndDetail(String disCom, String sumValue,
			String begintime, String endtime, Map<String, String> orderMap)
			throws Exception {
		
		Adpaysum apsBO = (Adpaysum)BOFactory.build(AdpaysumBO.class, user);
		Adpaydet apdBO = (Adpaydet)BOFactory.build(AdpaydetBO.class, user);
		
		String[] sum = StringUtils.split(sumValue, "|");
		double orderamt = Double.parseDouble(sum[0]);
		double cancelamt = Double.parseDouble(sum[1]);
		double recamt = orderamt - cancelamt;
		AdpaysumVO apsVO = new AdpaysumVO();
		apsVO.setDiscomcode(disCom);
		apsVO.setBegintime(PublicUtils.UtilStrToDate(begintime));
		apsVO.setEndtime(PublicUtils.UtilStrToDate(endtime));
		apsVO.setState("WAITSUBMIT");  // 待提交
		apsVO.setOrderamt(orderamt);   // 订单金额
		apsVO.setCancelamt(cancelamt); // 退单金额
		apsVO.setRecamt(recamt);	   // 应收金额
		apsVO.setCreatetime(new Date());
		
		apsVO = apsBO.doCreate(apsVO);
		
		Long sumid = apsVO.getSumid(); // 汇总单号
		
		if(orderMap.containsKey(disCom)) {
			String orderids = orderMap.get(disCom);
			if(orderids!=null && orderids.startsWith("|")) {
				orderids = orderids.substring(1);
			}
			String[] orderidArr = StringUtils.split(orderids, "|");
			for(String orderid : orderidArr) {
				AdpaydetVO apdVO = new AdpaydetVO();
				apdVO.setSumid(sumid);
				apdVO.setOrderid(orderid);
				apdBO.doCreate(apdVO);
			}
		}
	
	}
	
	public void doProcess2(String[] parameters) throws Exception {
		
		String begintime = "";
		String endtime = "";
		String[] beginEndTime = new String[2];
		Sysparam spBo = (SysparamBO)BOFactory.build(SysparamBO.class, user);
		if(parameters.length == 1) {			
			String periodValue = spBo.doFindByID(37L, "pboss_fx");
			if(periodValue == null || "".equals(periodValue))
				throw new Exception("系统参数[垫资订单汇总时段]无数据");
			String[] period = StringUtils.split(periodValue, ",");
			beginEndTime = this.confirmPeriodFromDB(period[0], period[1]);
			
		}else if(parameters.length == 3) {
			beginEndTime = this.confirmPeriodFromConsole(parameters[1], parameters[2]);
		}
		begintime = beginEndTime[0];
		endtime = beginEndTime[1];
		log.info("起始时间: "+begintime+"\t终止时间: "+endtime);
		
		Order orderBO = (OrderBO)BOFactory.build(OrderBO.class,user);
		OrderDBParam param = new OrderDBParam();
		param.set_dnl_createtime(begintime);
		param.set_dnm_createtime(endtime);
		param.set_se_paytype("ADPAY");
		param.setDataOnly(true);
		param.set_pagesize("0");
		DataPackage dp = orderBO.doQuery(param);
		List list = dp.getDatas();
		if(list != null && list.size() > 0) {
			
			// <配送商,订单金额>
			Map<String,Double> orderamtMap = new HashMap<String,Double>();
			// <配送商,退单金额>
			Map<String,Double> cancelamtMap = new HashMap<String,Double>();
			// <配送商,订单号1|订单号2|...>
			Map<String,String> orderidsMap = new HashMap<String,String>();
			for(int i=0;i<list.size();i++) {
				OrderVO vo = (OrderVO)list.get(i);
				// 配送商
				String disCom = vo.getDiscomcode();
				if(!orderidsMap.containsKey(disCom)) {
					orderidsMap.put(disCom, vo.getOrderid());
				}else {
					String oldOrderidStr = orderidsMap.get(disCom);
					String newOrderidStr = oldOrderidStr + "|" + vo.getOrderid();
					orderidsMap.put(disCom, newOrderidStr);
				}
				// 累计订单金额
				if(!orderamtMap.containsKey(disCom)) {
					orderamtMap.put(disCom, vo.getRecamt());
				}else {
					double oldrecamt = orderamtMap.get(disCom);
					double newrecamt = oldrecamt + vo.getRecamt();
					orderamtMap.put(disCom, newrecamt);
				}
				// 累计退单金额
				if("CANCEL".equalsIgnoreCase(vo.getOrderstate())) { // 退单
					if(!cancelamtMap.containsKey(disCom)) {
						cancelamtMap.put(disCom, vo.getRecamt());
					}else {
						double oldrecamt = cancelamtMap.get(disCom);
						double newrecamt = oldrecamt + vo.getRecamt();
						cancelamtMap.put(disCom, newrecamt);
					}
				}
				
			}
//20111230 Shi Xiaolong 注释掉此部分代码，添加后面部分代码
//			for(Iterator<String> it = orderamtMap.keySet().iterator();it.hasNext();) {
//				String disCom = it.next();
//				log.info("进行垫资订单汇总的配送商编码: "+disCom);
//				// 订单金额
//				double orderamt = orderamtMap.get(disCom);
//				// 退单金额
//				double cancelamt = 0;
//				if(cancelamtMap.containsKey(disCom)) {
//					cancelamt = cancelamtMap.get(disCom);
//				}
//				String orderidsStr = orderidsMap.get(disCom);
//				try {
//					AdpaysumBg asBO = (AdpaysumBg)BOFactory.build(AdpaysumBgBO.class,user,BOFactory.PROPAGATION_REQUIRES_NEW);
//					asBO.doInsertAdpaySumAndDetail2(disCom, orderamt, cancelamt, begintime, endtime,orderidsStr);
//				}catch(Exception ex) {
//					LoggerUtils.error(ex, log);
//				}				
//			}
			String smsmark = spBo.doFindByID(74L, "pboss_fx");
			String sendNO = spBo.doFindByID(42L, "pboss_fx");
			if("1".equals(smsmark) && !StringUtils.isEmpty(sendNO)){//发送随机短信且发送号码不为空
				//创建汇总单及其明细，并发送短息
				Calendar c = Calendar.getInstance();
				c.setTime(new Date());
				int year = c.get(Calendar.YEAR);
				int month = c.get(Calendar.MONTH)+1;
				int day = c.get(Calendar.DAY_OF_MONTH);
				String date = year+"年"+month+"月"+day+"日";
				for(Iterator<String> it = orderamtMap.keySet().iterator();it.hasNext();) {
					String disCom = it.next();
					// 订单金额
					double orderamt = orderamtMap.get(disCom);
					// 退单金额
					double cancelamt = 0;
					if(cancelamtMap.containsKey(disCom)) {
						cancelamt = cancelamtMap.get(disCom);
					}
					String orderidsStr = orderidsMap.get(disCom);
					//创建汇总单及其明细
					try {
						this.doInsertAdpaySumAndDetail2(disCom, orderamt, cancelamt, begintime, endtime, orderidsStr);
					}catch(Exception ex) {
						LoggerUtils.error(ex, log);
					}
					//发送短信
					double recamt = orderamt - cancelamt;
					this.doSendSMS(disCom,sendNO,date,recamt);
				}
			}else{//不发送短信或者发送号码为空
				if(StringUtils.isEmpty(sendNO)){//发送号码为空，输出日志信息
					log.info("发送号码为空，不能发送短信");
				}
				//创建汇总单及其明细
				for(Iterator<String> it = orderamtMap.keySet().iterator();it.hasNext();) {
					String disCom = it.next();
					log.info("进行垫资订单汇总的配送商编码: "+disCom);
					// 订单金额
					double orderamt = orderamtMap.get(disCom);
					// 退单金额
					double cancelamt = 0;
					if(cancelamtMap.containsKey(disCom)) {
						cancelamt = cancelamtMap.get(disCom);
					}
					String orderidsStr = orderidsMap.get(disCom);
					try {
						this.doInsertAdpaySumAndDetail2(disCom, orderamt, cancelamt, begintime, endtime, orderidsStr);
					}catch(Exception ex) {
						LoggerUtils.error(ex, log);
					}					
				}
			}
//20111230 Shi Xiaolong
		}
		
	}
	
	/**
	 * 发送短信 20111230 Shi Xiaolong
	 * @param discomcode 配送商编码
	 * @param sendNO 发送号码
	 * @param date 日期 yyyy年MM月dd日
	 * @param recamt 应付金额
	 * @throws Exception
	 */
	private void doSendSMS(String discomcode, String sendNO, String date, Double recamt) throws Exception {
		//获取配送商信息
		Way way = (Way)BOFactory.build(WayBO.class, user);
		WayVO wayVO = way.doFindByPk(discomcode);
		if(wayVO==null){
			log.info("配送商["+discomcode+"]渠道信息不存在");
			return;
		}
		//获取人员信息
		Employee  employee = (EmployeeBO) BOFactory.build(EmployeeBO.class, user);
		EmployeeDBParam employeeDBParam=new EmployeeDBParam();
		employeeDBParam.set_se_wayid(discomcode);
		employeeDBParam.set_ne_empstatus("0");
		employeeDBParam.set_ne_isnet("3");
		employeeDBParam.setDataOnly(true);
		employeeDBParam.set_pagesize("0");
		DataPackage employeeDp= employee.doQuery(employeeDBParam);
		//客户名称
		String empname = "客户";
		//接收号码
		String receiveNO = null;
		if(employeeDp.getDatas().size()>0){
			EmployeeVO employeeVO = (EmployeeVO)employeeDp.getDatas().get(0);
			empname = employeeVO.getEmployeename();//客户名称
			receiveNO = employeeVO.getOfficetel();//接收号码
			if(receiveNO==null){
				log.info("配送商["+discomcode+"]接受号码为空，不发送短信");
				return;
			}
		}else{
			log.info("配送商["+discomcode+"]人员信息不存在，无法获取接受号码，不发送短信");
			return;
		}
		
		//获取短信内容
		Map<String,String> map = new HashMap<String,String>();
		map.put("CUSTNAME", empname);
		map.put("DATE", date);
		String countyname=Code2NameUtils.code2Name("#CNTYCOMPANY", wayVO.getCountyid(), user.getCityid());
		String cityname=Code2NameUtils.code2Name("#CITYCOMPANY", wayVO.getCityid(), user.getCityid());
		map.put("COUNTYNAME", countyname);
		map.put("RECAMT", recamt.toString());		
		map.put("CITYNAME", cityname);
		Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
		String content = smstmplBO.doGenSMS("FX_ORDER_ADPAYMENT", map);
		if(content==null || "".equals(content)){
			log.info("配送商["+discomcode+"]构造短信内容为空，不发送短信");
			return;
		}
		
		WaitreqBO waitreqBO = (WaitreqBO)BOFactory.build(WaitreqBO.class,user);
		waitreqBO.doInsert2(new Short("3"), content, sendNO, receiveNO);
	}
	
	public void doInsertAdpaySumAndDetail2(String disCom, double orderamt,
			double cancelamt, String begintime, String endtime,
			String orderidsStr) throws Exception {

		// 应收金额
		double recamt = orderamt - cancelamt;
		Adpaysum apsBO = (Adpaysum)BOFactory.build(AdpaysumBO.class, user);
		Adpaydet apdBO = (Adpaydet)BOFactory.build(AdpaydetBO.class, user);
		AdpaysumVO apsVO = new AdpaysumVO();
		apsVO.setDiscomcode(disCom);
		apsVO.setBegintime(PublicUtils.UtilStrToDate(begintime));
		apsVO.setEndtime(PublicUtils.UtilStrToDate(endtime));
		apsVO.setState("WAITSUBMIT");  // 待提交
		apsVO.setOrderamt(orderamt);   // 订单金额
		apsVO.setCancelamt(cancelamt); // 退单金额
		apsVO.setRecamt(recamt);	   // 应收金额
		apsVO.setCreatetime(new Date());
		
		apsVO = apsBO.doCreate(apsVO);
		
		Long sumid = apsVO.getSumid(); // 汇总单号
		log.info("汇总单号: "+sumid);
		
		
		String[] orderidsArr = orderidsStr.split("\\|");
		for(String orderid : orderidsArr) {
			AdpaydetVO apdVO = new AdpaydetVO();
			apdVO.setSumid(sumid);
			apdVO.setOrderid(orderid);
			apdBO.doCreate(apdVO);
		}
	}

	public static void main(String[] args) throws Exception {
		AdpaysumBgBO bo = new AdpaysumBgBO();
		// String[] result = bo.confirmPeriodFromConsole("2010-04-22","5-1");

		String[] result1 = bo.confirmPeriodFromDB("10-5", "12-10");
		System.out.println(result1[0] + " " + result1[1]);
	}

}
