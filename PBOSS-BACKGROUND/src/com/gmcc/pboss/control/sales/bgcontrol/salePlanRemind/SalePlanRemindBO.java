package com.gmcc.pboss.control.sales.bgcontrol.salePlanRemind;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.base.smsobject.SmsobjectDBParam;
import com.gmcc.pboss.business.base.smsobject.SmsobjectVO;
import com.gmcc.pboss.business.base.smstmpl.SmstmplDBParam;
import com.gmcc.pboss.business.base.smstmpl.SmstmplVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.sales.partnerres.PartnerresDAO;
import com.gmcc.pboss.business.sales.partnerres.PartnerresDBParam;
import com.gmcc.pboss.business.sales.salesstd.SalesstdDBParam;
import com.gmcc.pboss.business.sales.salesstd.SalesstdVO;
import com.gmcc.pboss.business.sales.sellnotice.SellnoticeDBParam;
import com.gmcc.pboss.business.sales.sellnotice.SellnoticeVO;
import com.gmcc.pboss.control.base.smsobject.SmsobjectBO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.sales.salesstd.Salesstd;
import com.gmcc.pboss.control.sales.salesstd.SalesstdBO;
import com.gmcc.pboss.control.sales.sellnotice.Sellnotice;
import com.gmcc.pboss.control.sales.sellnotice.SellnoticeBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SalePlanRemindBO extends AbstractControlBean implements SalePlanRemind {
	private static Logger log = Logger.getLogger(SalePlanRemindBO.class);
	
	public void doProcess(String sendMsgFlag,String sendDate) throws Exception {
		String queryStrName = "com.gmcc.pboss.business.sales.partnerres.doSalePlanRemind";
		String selectFields = "wayid,waymagcode,mareacode,countyid,starlevel,salecount";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
		String sysparamvalue42 = "";
		String sysparamvalue58 = "";
		
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
		sysparamvalue42=sysparamBO.doFindByID("42", "pboss_fx");//发送号码
		sysparamvalue58 = sysparamBO.doFindByID("58", "pboss_fx");//获取发送时间
		
		PartnerresDBParam partnerresDBParam = new PartnerresDBParam();
		
		partnerresDBParam.setSelectFieldsString(selectFields);
		partnerresDBParam.setDataOnly(true);
		partnerresDBParam.set_pagesize("0");
		
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM");
		String month = dateTimeFormat.format(new Date());//当月
		String beginDate = dateTimeFormat.format(new Date()) + "-01";//本月1号
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, +1);
		String endDate = dateTimeFormat.format(calendar.getTime()) + "-01";//下月1号
		
		partnerresDBParam.getQueryConditions().put("beginDate",beginDate);
		partnerresDBParam.getQueryConditions().put("endDate",endDate);
		partnerresDBParam.getQueryConditions().put("cityid",user.getCityid());
		
		PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(PartnerresDAO.class,user);
		DataPackage partnerreDp = dao.queryByNamedSqlQuery(queryStrName,partnerresDBParam);
		
		Iterator it=partnerreDp.getDatas().iterator();
		
		//合作商销售记录入库
		dealStat(it, month);
		
		//短信发送
		/*if(isSend){
			dealSendMsg(sysparamvalue42, sysparamvalue58, month);
		}*/
		
		if("Y".equals(sendMsgFlag) && sendDate != null){
			String[] days = sendDate.split("\\|");
			for(int i=0 ; i<days.length ; i++){
				if(dateFormat.format(new Date()).equals(days[i])){
					dealSendMsg(sysparamvalue42, sysparamvalue58, month);
				}
			}
		}
		
	}
	
	private void dealSendMsg(String sysparamvalue42,String sysparamvalue58, String month) throws Exception{
		if(sysparamvalue42 == null || "".equals(sysparamvalue42)){
			log.info("--------------短信发送号码为空--------------------");
			return ;
		}
		if(sysparamvalue58 == null || "".equals(sysparamvalue58)){
			sysparamvalue58 = "8:30";
		}
		
		Sellnotice sellnoticeBO = (SellnoticeBO)BOFactory.build(SellnoticeBO.class,user);
		SellnoticeDBParam sellnoticeDBParam = new SellnoticeDBParam();
		sellnoticeDBParam.set_se_selltime(month);//当月
		sellnoticeDBParam.set_pagesize("0");
		DataPackage sellnoticeDp = sellnoticeBO.doQuery(sellnoticeDBParam);
		
		//发送网点信息
		String waySid = "FX_SELLNOTICEWAY";
		String sContentString = getSmsContent(waySid);
		if(sContentString == null || "".equals(sContentString)){
			log.error("(发送网点信息)短信模板无数据或内容为空，(发送网点信息)退出");				
		}else{
			log.info("--------------发送网点信息------------开始--------");
			sendByWay(sellnoticeDp, waySid, sysparamvalue42, sysparamvalue58);
			log.info("--------------发送网点信息------------结束--------");
		}
		
		//发送渠道经理
		waySid = "FX_SELLNOTICEWAYMAG";
		sContentString = getSmsContent(waySid);
		if(sContentString == null || "".equals(sContentString)){
			log.error("(发送渠道经理)短信模板无数据或内容为空，(发送渠道经理)退出");				
		}else{
			log.info("--------------发送渠道经理------------开始--------");
			sendByWayMag(sellnoticeDp, waySid, sysparamvalue42, sysparamvalue58);
			log.info("--------------发送渠道经理------------结束--------");
		}			
		
		//发送分公司主管
		waySid = "FX_SELLNOTICEMAREACODE";
		sContentString = getSmsContent(waySid);
		if(sContentString == null || "".equals(sContentString)){
			log.error("(发送分公司主管)短信模板无数据或内容为空，(发送分公司主管)退出");				
		}else{
			log.info("--------------发送分公司主管------------开始--------");
			sendByWayMareacode(month, waySid, sysparamvalue42, sysparamvalue58,sContentString);
			log.info("--------------发送分公司主管------------结束--------");
		}			
		
		//发送市公司主管
		waySid = "FX_SELLNOTICECOUNTYID";
		sContentString = getSmsContent(waySid);
		if(sContentString == null || "".equals(sContentString)){
			log.error("(发送市公司主管)短信模板无数据或内容为空，(发送市公司主管)退出");				
		}else{
			log.info("--------------发送市公司主管------------开始--------");
			sendByWayCounty(month, waySid, sysparamvalue42, sysparamvalue58,sContentString);
			log.info("--------------发送市公司主管------------结束--------");
		}	
	}
	
	private void sendByWayCounty(String month, String sid
			, String sysparamvalue42, String sysparamvalue58
			, String sContentString) throws Exception{
		SimpleDateFormat dateTimeFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Date sendDate = dateTimeFormat2.parse(
				dateTimeFormat.format(calendar.getTime()) + " " + sysparamvalue58);
		
		NumberFormat nf = NumberFormat.getIntegerInstance();
		nf.setMinimumFractionDigits(2);//指定小数位数
		
		//模板处理
		String sc[] = sContentString.split("&");
		
		Long aSellcount = 0L;
		Long aSalesstd = 0L;
		
		List<String> countyList = new ArrayList<String>();
		
		Sellnotice sellnoticeBO = (SellnoticeBO)BOFactory.build(SellnoticeBO.class,user);
		String queryStrName = "com.gmcc.pboss.business.sales.sellnotice.getCountyidStat";
		SellnoticeDBParam sellnoticeDBParam = new SellnoticeDBParam();
		sellnoticeDBParam.setDataOnly(true);
		sellnoticeDBParam.set_pagesize("0");
	    String selectFields = "countyid,sellcount,salesstd";				
	    sellnoticeDBParam.setSelectFieldsString(selectFields);
	    sellnoticeDBParam.getQueryConditions().put("selltime", month);	//当前月
		DataPackage countyidDP = sellnoticeBO.doQueryByNamedSqlQuery(queryStrName, sellnoticeDBParam);
		Iterator countyidIt = countyidDP.getDatas().iterator();
		while(countyidIt.hasNext()){
			try {
				Map countyidTmp = (Map) countyidIt.next();
				String countyid = (String) countyidTmp.get("countyid");
				Long sellcount = (Long) countyidTmp.get("sellcount");
				Long salesstd = (Long) countyidTmp.get("salesstd");
				if (countyid != null && !"".equals(countyid)) {
					String countySms = new String(sc[1]);
					aSellcount = aSellcount + sellcount;
					aSalesstd = aSalesstd + salesstd;

					Double comrate = 0D;
					if (salesstd != 0)
						comrate = 1.0 * sellcount / salesstd * 100;
					comrate = Double.parseDouble(nf.format(comrate));

					String compname = Code2NameUtils.code2Name("#CNTYCOMPANY",
							countyid, user.getCityid());

					countySms = countySms
							.replaceAll("\\{COUNTYID\\}", compname);
					countySms = countySms.replaceAll("\\{SALESSTD\\}", ""
							+ salesstd);
					countySms = countySms.replaceAll("\\{SELLCOUNT\\}", ""
							+ sellcount);
					countySms = countySms.replaceAll("\\{COMRATE\\}", ""
							+ comrate + "%");

					countyList.add(countySms);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				log.info("--------sendByWayCounty方法的错误信息："+e.getMessage());
			}
		}
		
		Double aComrate = 0D;
		if(aSalesstd != 0 )
			aComrate = 1.0 * aSellcount/aSalesstd*100;
		aComrate =Double.parseDouble(nf.format(aComrate));
		String citySms = new String(sc[0]);
		
		String cityname = Code2NameUtils.code2Name("#CITYCOMPANY",user.getCityid(), user.getCityid());
		
		citySms = citySms.replaceAll("\\{CUSTNAME\\}", cityname);
		citySms = citySms.replaceAll("\\{SALESSTD\\}", ""+aSalesstd);
		citySms = citySms.replaceAll("\\{SELLCOUNT\\}", ""+aSellcount);
		citySms = citySms.replaceAll("\\{COMRATE\\}", ""+aComrate + "%");
		
		//合并市公司、县公司短信内容
		String allSms = citySms;
		Iterator<String> countyListIt = countyList.iterator();
		while(countyListIt.hasNext()){
			String countySms = countyListIt.next();
			allSms = allSms + "&" + countySms;
		}
		
		//短信发送
		WaitreqBO waitreqBO = (WaitreqBO)BOFactory.build(WaitreqBO.class,user);
		
		SmsobjectBO smsobjectBO = (SmsobjectBO)BOFactory.build(SmsobjectBO.class,user);
		SmsobjectDBParam smsobjectDBParam = new SmsobjectDBParam();
		smsobjectDBParam.set_se_objecttype("CITYDIRECTOR");//对象类型为‘CITYDIRECTOR（市公司主管）’
		DataPackage smsobjectDp = smsobjectBO.doQuery(smsobjectDBParam);
		if(smsobjectDp.getRowCount() > 0){
			Iterator smsobjectIt = smsobjectDp.getDatas().iterator();
			while(smsobjectIt.hasNext()){
				SmsobjectVO smsobjectVO = (SmsobjectVO)smsobjectIt.next();
				String officetel = smsobjectVO.getMobile();
				if(officetel != null && !"".equals(officetel)){
					waitreqBO.doInsert3(new Short("3"), allSms, sysparamvalue42, officetel,sendDate);
				}
			}
		}else{
			log.info(cityname + "市公司主管手机号码未设置");
		}
		
	}
	
	private void sendByWayMareacode(String month, String sid
			, String sysparamvalue42, String sysparamvalue58, String sContentString) throws Exception{
		SimpleDateFormat dateTimeFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Date sendDate = dateTimeFormat2.parse(
				dateTimeFormat.format(calendar.getTime()) + " " + sysparamvalue58);
		
		NumberFormat nf = NumberFormat.getIntegerInstance();
		nf.setMinimumFractionDigits(2);//指定小数位数
		
		//模板处理
		String sc[] = sContentString.split("&");
		
		Sellnotice sellnoticeBO = (SellnoticeBO)BOFactory.build(SellnoticeBO.class,user);
		String queryStrName = "com.gmcc.pboss.business.sales.sellnotice.getCountyidStat";
		SellnoticeDBParam sellnoticeDBParam = new SellnoticeDBParam();
		sellnoticeDBParam.setDataOnly(true);
		sellnoticeDBParam.set_pagesize("0");
	    String selectFields = "countyid,sellcount,salesstd";				
	    sellnoticeDBParam.setSelectFieldsString(selectFields);
	    sellnoticeDBParam.getQueryConditions().put("selltime", month);	//当前月
		DataPackage countyidDP = sellnoticeBO.doQueryByNamedSqlQuery(queryStrName, sellnoticeDBParam);
		Iterator countyidIt = countyidDP.getDatas().iterator();
		while(countyidIt.hasNext()){
			
			try {
				Map countyidTmp = (Map) countyidIt.next();
				String countyid = (String) countyidTmp.get("countyid");
				Long sellcount = (Long) countyidTmp.get("sellcount");
				Long salesstd = (Long) countyidTmp.get("salesstd");
				if (countyid != null && !"".equals(countyid)) {
					String countySms = new String(sc[0]);

					Double comrate = 0D;
					if (salesstd != 0)
						comrate = 1.0 * sellcount / salesstd * 100;
					comrate = Double.parseDouble(nf.format(comrate));

					String compname = Code2NameUtils.code2Name("#CNTYCOMPANY",
							countyid, user.getCityid());

					countySms = countySms
							.replaceAll("\\{CUSTNAME\\}", compname);
					countySms = countySms.replaceAll("\\{SALESSTD\\}", ""
							+ salesstd);
					countySms = countySms.replaceAll("\\{SELLCOUNT\\}", ""
							+ sellcount);
					countySms = countySms.replaceAll("\\{COMRATE\\}", ""
							+ comrate + "%");

					//微区域
					sellnoticeDBParam = new SellnoticeDBParam();
					sellnoticeDBParam.setDataOnly(true);
					sellnoticeDBParam.set_pagesize("0");
					queryStrName = "com.gmcc.pboss.business.sales.sellnotice.getMareacodeStat";
					selectFields = "mareacode,sellcount,salesstd";
					sellnoticeDBParam.setSelectFieldsString(selectFields);
					sellnoticeDBParam.getQueryConditions().put("selltime",
							month); //当前月
					sellnoticeDBParam.getQueryConditions().put("countyid",
							countyid); //当前分公司
					DataPackage mareacodeDP = sellnoticeBO
							.doQueryByNamedSqlQuery(queryStrName,
									sellnoticeDBParam);

					Map<String, String> mar2sms = new HashMap<String, String>();
					Map<String, Double> mar2comrate = new HashMap<String, Double>();

					Iterator mareacodeIt = mareacodeDP.getDatas().iterator();
					while (mareacodeIt.hasNext()) {

						try {
							Map mareacodeTmp = (Map) mareacodeIt.next();
							String mareacode = (String) mareacodeTmp
									.get("mareacode");
							Long eSellcount = (Long) mareacodeTmp
									.get("sellcount");
							Long nSalesstd = (Long) mareacodeTmp
									.get("salesstd");
							if (mareacode != null && !"".equals(mareacode)) {
								String mareacodeSms = new String(sc[1]);

								Double aComrate = 0D;
								if (nSalesstd != 0)
									aComrate = 1.0 * eSellcount / nSalesstd
											* 100;
								comrate = Double
										.parseDouble(nf.format(comrate));

								String mareacodeName = Code2NameUtils
										.code2Name("#MICROAREA", mareacode,
												user.getCityid());

								mareacodeSms = mareacodeSms.replaceAll(
										"\\{MAREACODE\\}", mareacodeName);
								mareacodeSms = mareacodeSms.replaceAll(
										"\\{SALESSTD\\}", "" + nSalesstd);
								mareacodeSms = mareacodeSms.replaceAll(
										"\\{SELLCOUNT\\}", "" + eSellcount);
								mareacodeSms = mareacodeSms.replaceAll(
										"\\{COMRATE\\}", "" + aComrate + "%");

								mar2sms.put(mareacode, mareacodeSms);
								mar2comrate.put(mareacode, comrate);

							}
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
							log.info("-----------微区域错误信息：" + e.getMessage());
						}
					}
					//并对完成率按降序排列
					String ms[] = new String[mar2comrate.size()];
					Double mc[] = new Double[mar2comrate.size()];
					Iterator iter = mar2comrate.entrySet().iterator();
					int location = 0;
					while (iter.hasNext()) {
						Map.Entry entry = (Map.Entry) iter.next();
						String key = (String) entry.getKey();
						Double val = (Double) entry.getValue();
						ms[location] = key;
						mc[location] = val;
						location++;
					}
					for (int i = 0; i < mc.length; i++) {
						for (int j = i; j < mc.length; j++) {
							if (mc[i] < mc[j]) {
								Double dT = mc[i];
								mc[i] = mc[j];
								mc[j] = dT;

								String sT = ms[i];
								ms[i] = ms[j];
								ms[j] = sT;
							}
						}
					}

					//分公司、微区域短信内容合并
					String aSmsCon = countySms;
					for (int i = 0; i < ms.length; i++) {
						aSmsCon = aSmsCon + "&" + mar2sms.get(ms[i]);
					}

					//短信发送
					WaitreqBO waitreqBO = (WaitreqBO) BOFactory.build(
							WaitreqBO.class, user);

					SmsobjectBO smsobjectBO = (SmsobjectBO) BOFactory.build(
							SmsobjectBO.class, user);
					SmsobjectDBParam smsobjectDBParam = new SmsobjectDBParam();
					smsobjectDBParam.set_se_objecttype("DIRECTOR");//通知对象类型为‘DIRECTOR（分公司主管）
					smsobjectDBParam.set_se_countyid(countyid);
					DataPackage smsobjectDp = smsobjectBO
							.doQuery(smsobjectDBParam);
					if (smsobjectDp.getRowCount() > 0) {
						Iterator smsobjectIt = smsobjectDp.getDatas()
								.iterator();
						while (smsobjectIt.hasNext()) {

							try {
								SmsobjectVO smsobjectVO = (SmsobjectVO) smsobjectIt
										.next();
								String officetel = smsobjectVO.getMobile();
								if (officetel != null && !"".equals(officetel)) {
									waitreqBO.doInsert3(new Short("3"),
											aSmsCon, sysparamvalue42,
											officetel, sendDate);
								}
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
								log.info("------短信发送：" + e.getMessage());
							}
						}
					} else {
						log.info(compname + "分公司主管手机号码未设置");
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				log.info("-----sendByWayMareacode方法的错误信息："+e.getMessage());
			}
		}
	}
	
	private void sendByWayMag(DataPackage sellnoticeDp, String sid
			, String sysparamvalue42, String sysparamvalue58) throws Exception{
		SimpleDateFormat dateTimeFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Date sendDate = dateTimeFormat2.parse(
				dateTimeFormat.format(calendar.getTime()) + " " + sysparamvalue58);
		
		Sellnotice sellnoticeBO = (SellnoticeBO)BOFactory.build(SellnoticeBO.class,user);
		DataPackage tmp = sellnoticeBO.doWayMagList(sellnoticeDp);
		Iterator itSell=tmp.getDatas().iterator();
		while(itSell.hasNext()){
			
			try {
				SellnoticeVO sellnoticeVO = (SellnoticeVO) itSell.next();
				String waymagcode = sellnoticeVO.getWaymagcode();
				EmployeeDBParam employeeList = new EmployeeDBParam();
				employeeList.set_se_employeeid(waymagcode);//已前面渠道经理为条件查询渠道人员基本信息表
				EmployeeVO empVO = getEmp(employeeList);
				if (empVO != null) {
					String officetel = empVO.getOfficetel();
					if (officetel != null && !"".equals(officetel)) {
						//短信发送					
						Map<String, String> map = new HashMap<String, String>();
						map.put("CUSTNAME", empVO.getEmployeename());
						map.put("SALESSTD", "" + sellnoticeVO.getSalesstd());
						map.put("SELLCOUNT", "" + sellnoticeVO.getSellcount());
						map
								.put("COMRATE", "" + sellnoticeVO.getComrate()
										+ "%");
						Smstmpl smstmplBO = (SmstmplBO) BOFactory.build(
								SmstmplBO.class, user);
						String content = smstmplBO.doGenSMS(sid, map);

						WaitreqBO waitreqBO = (WaitreqBO) BOFactory.build(
								WaitreqBO.class, user);

						waitreqBO.doInsert3(new Short("3"), content,
								sysparamvalue42, officetel, sendDate);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				log.info("-----sendByWayMag方法的错误信息："+e.getMessage());
			}
		}
	}
	
	private void sendByWay(DataPackage sellnoticeDp, String sid
			, String sysparamvalue42, String sysparamvalue58) throws Exception{
		Sellnotice sellnoticeBO = (SellnoticeBO)BOFactory.build(SellnoticeBO.class,user);
		DataPackage tmp = sellnoticeBO.doWayList(sellnoticeDp);
		Iterator itSell=tmp.getDatas().iterator();
		SimpleDateFormat dateTimeFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Date sendDate = dateTimeFormat2.parse(
				dateTimeFormat.format(calendar.getTime()) + " " + sysparamvalue58);
		String wayid ="";
		while(itSell.hasNext()){
			try { 
			SellnoticeVO sellnoticeVO = (SellnoticeVO)itSell.next();
			 wayid =sellnoticeVO.getWayid();
			
			EmployeeDBParam employeeList=new EmployeeDBParam();
			employeeList.set_se_wayid(wayid);
			
			EmployeeVO empVO=getEmp(employeeList);
			if(empVO != null){
				String officetel=empVO.getOfficetel();					
				if(officetel != null && !"".equals(officetel)){
					//短信发送					
					Map<String,String> map = new HashMap<String,String>();
					map.put("CUSTNAME", empVO.getEmployeename());
					map.put("SALESSTD", "" + sellnoticeVO.getSalesstd());
					map.put("SELLCOUNT", "" + sellnoticeVO.getSellcount());
					map.put("COMRATE", "" + sellnoticeVO.getComrate() + "%");
					Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
					String content = smstmplBO.doGenSMS(sid, map);
					
					WaitreqBO waitreqBO = (WaitreqBO)BOFactory.build(WaitreqBO.class,user);
    				
    				waitreqBO.doInsert3(new Short("3"), content, sysparamvalue42, officetel,sendDate);
				}
			}
			} catch (Exception e) {
				e.printStackTrace();
				log.info("---------------处理：" + wayid + "，异常---------------------\n"+e.getMessage());
			}
			
		}
	}
	
	private EmployeeVO getEmp(EmployeeDBParam employeeList) throws Exception{
		EmployeeVO empVO = null;
		Employee  employee = (EmployeeBO) BOFactory.build(EmployeeBO.class, user);		
		employeeList.set_ne_empstatus("0");
		employeeList.set_ne_isnet("1");
		DataPackage employeeDp= employee.doQuery(employeeList);
		if(employeeDp.getRowCount()>0){
			Iterator it=employeeDp.getDatas().iterator();
			if(it.hasNext()){
				empVO=(EmployeeVO)it.next();
			}
		}
		
		return empVO;
	}
	
	private String getSmsContent(String sid) throws Exception{
		Smstmpl smstmplBO = (SmstmplBO) BOFactory.build(SmstmplBO.class, user);
		SmstmplDBParam param = new SmstmplDBParam();
		param.setDataOnly(true);
		param.set_se_sid(sid);
		param.set_se_sstate("1");
		DataPackage dp = smstmplBO.doQuery(param);
		if (null == dp
				|| null == dp.getDatas()
				|| dp.getDatas().size() < 1){
			log.error("短信模板无数据或内容为空，退出");
			return "";
		}
			
		SmstmplVO smstmplVO = (SmstmplVO) dp.getDatas().get(0);
		
		return smstmplVO.getScontent();
	}
	
	private void dealStat(Iterator it,String month) throws Exception{
		Sellnotice sellnoticeBO = (SellnoticeBO)BOFactory.build(SellnoticeBO.class,user);
		Salesstd salesstdBO = (SalesstdBO)BOFactory.build(SalesstdBO.class,user);
		
		String wayid = "";
		while(it.hasNext()){
			try { 
			Map ooVO=(Map)it.next();
			wayid = (String)ooVO.get("wayid");
			String waymagcode = (String)ooVO.get("waymagcode");
			String mareacode = (String)ooVO.get("mareacode");
			String countyid = (String)ooVO.get("countyid");
			String starlevel = (String)ooVO.get("starlevel");
			String salecount = (String)ooVO.get("salecount");
			
			log.info("---------------处理：" + wayid + "，开始---------------------");
			
			SellnoticeDBParam sellnoticeDBParam = new SellnoticeDBParam();
			sellnoticeDBParam.set_se_wayid(wayid);
			sellnoticeDBParam.set_se_selltime(month);
			DataPackage sellnoticeDp = sellnoticeBO.doQuery(sellnoticeDBParam);
			
			SalesstdDBParam salesstdDBParam = new SalesstdDBParam();
			salesstdDBParam.set_se_countyid(countyid);//分公司
			salesstdDBParam.set_se_mareacode(mareacode);//微区域
			salesstdDBParam.set_ne_starlevel(starlevel);//星级
			DataPackage salesstdDp = salesstdBO.doQuery(salesstdDBParam);
			Double comrate = 0D;//完成率
			Long salesstd = 0L;//销售阀值
			if(salesstdDp.getRowCount() > 0){
				SalesstdVO salesstdVO = (SalesstdVO)salesstdDp.getDatas().get(0);
				salesstd = salesstdVO.getSalesstd();
				if(salecount != null && !"".equals(salecount)
						&& salesstd != null && !"".equals(salesstd) && salesstd > 0){
					comrate = (1.0*Long.parseLong(salecount)/salesstd);
				}
			}
			
			if(sellnoticeDp.getRowCount() > 0){
				//修改
				SellnoticeVO sellnoticeVO = (SellnoticeVO)sellnoticeDp.getDatas().get(0);
				if(salecount != null && !"".equals(salecount)){
					sellnoticeVO.setSellcount(Long.parseLong(salecount));//销售量
				}else{
					sellnoticeVO.setSellcount(0L);//销售量
				}
				sellnoticeVO.setComrate(comrate);//完成率
				sellnoticeVO.setSalesstd(salesstd);//销售阀值
				
				sellnoticeBO.doUpdate(sellnoticeVO);
			}else{
				//新增
				SellnoticeVO sellnoticeVO = new SellnoticeVO();
				sellnoticeVO.setWayid(wayid);//合作商编码
				sellnoticeVO.setCountyid(countyid);//分公司
				sellnoticeVO.setMareacode(mareacode);//微区域
				if(starlevel != null && !"".equals(starlevel))
					sellnoticeVO.setStarlevel(Short.parseShort(starlevel));//星级
				if(salecount != null && !"".equals(salecount)){
					sellnoticeVO.setSellcount(Long.parseLong(salecount));//销售量
				}else{
					sellnoticeVO.setSellcount(0L);//销售量
				}
				sellnoticeVO.setSalesstd(salesstd);//销售阀值
				sellnoticeVO.setComrate(comrate);//完成率
				sellnoticeVO.setSelltime(month);//销售月份
				sellnoticeVO.setWaymagcode(waymagcode);//渠道经理工号
				
				sellnoticeBO.doCreate(sellnoticeVO);
			}
			
			log.info("---------------处理：" + wayid + "，结束---------------------");
			} catch (Exception e) {
				e.printStackTrace();
				log.info("---------------处理：" + wayid + "，异常---------------------\n"+e.getMessage());
			}
		}
	}
}
