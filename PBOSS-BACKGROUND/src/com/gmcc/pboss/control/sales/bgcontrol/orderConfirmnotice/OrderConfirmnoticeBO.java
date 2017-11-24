package com.gmcc.pboss.control.sales.bgcontrol.orderConfirmnotice;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.base.smstmpl.SmstmplDBParam;
import com.gmcc.pboss.business.base.smstmpl.SmstmplVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateDBParam;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmDBParam;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.ordercomcate.Ordercomcate;
import com.gmcc.pboss.control.sales.ordercomcate.OrdercomcateBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class OrderConfirmnoticeBO extends AbstractControlBean implements OrderConfirmnotice {
	
	private Logger log = Logger.getLogger(OrderConfirmnoticeBO.class);
	
	public void doProcess() throws Exception {
		log.info("==================================订单确认提醒 Begin==================================");
		//获取订单确认提醒短信连发天数
		/**
		 * 订单确认提醒短信连发天数,单位为天,要求整数类型,大于零时启动,否则不启动
		 */
		Sysparam resBO = (Sysparam) BOFactory.build(SysparamBO.class, user);
		String confirmTime = resBO.doFindByID(64L, "pboss_fx");
		if (StringUtils.isEmpty(confirmTime)) {//modify by panyonghui
			confirmTime = "0";
		}
		try {
			if(Integer.parseInt(confirmTime) <= 0){
				log.info("订单确认提醒短信连发天数设置为未启动");
				return;
			}
		} catch (Exception e) {
			log.info("订单确认提醒短信连发天数为非数字");
			return;
		}
		//获取短信模板
		SmstmplVO smstmplVO = this.doGetSmsTemplete();
		if(smstmplVO == null){
			log.info("无符合条件的模板数据");
			return ;
		}
		//订单确认提醒,查询订单表（FX_SW_ORDER），匹配订单状态为待确认，是否确认为否，创建时间的日期与当前日期不同的数据
		Order orderBO = (Order) BOFactory.build(OrderBO.class, user);
		OrderDBParam orderParam = new OrderDBParam();
		orderParam.set_se_orderstate("WAITCON");//订单状态为待确认
		orderParam.set_nne_confirmflag("1");//是否确认为否,因为数据库中只保存confirmflag的值为“1”-表示是，其他均为否，所以此处用“是否确认不等于1”
		Date currDate = new Date();
		orderParam.set_dne_createtime(PublicUtils.utilDateToStr(currDate));//创建时间的日期与当前日期不同
		orderParam.setDataOnly(true);
		orderParam.set_pagesize("0");
		DataPackage dPackage = orderBO.doQuery(orderParam);
		//首先判断是否下发短信
		List<OrderVO> orderList = dPackage.getDatas();
		if(!orderList.isEmpty()){
			Smsconfirm smsconfirmBO = (Smsconfirm) BOFactory.build(SmsconfirmBO.class, user);//短信确认
			//Cooperator cooperatorBO = (Cooperator) BOFactory.build(CooperatorBO.class, user);//分销合作商资料
			Employee employeeBO = (Employee) BOFactory.build(EmployeeBO.class, user);//渠道人员基本信息
			Ordercomcate ordercomcateBO = (Ordercomcate) BOFactory.build(OrdercomcateBO.class, user);//订单商品种类
			Comcategoryrela comcategoryrelaBO = (Comcategoryrela) BOFactory.build(ComcategoryrelaBO.class, user);//商品种类组合关系
			Waitreq waitreqBO = (Waitreq) BOFactory.build(WaitreqBO.class, user);//短信待发送
			
			ComcategoryrelaDBParam cDBParm = new ComcategoryrelaDBParam();
			cDBParm.setSelectFieldsString("comcategory,restype");//种类、资源类别
			cDBParm.setDataOnly(true);
			cDBParm.set_pagesize("0");
			//根据种类、资源类别分组进行统计
			DataPackage  comcategorDP = comcategoryrelaBO.doLoadComCateAndResType(cDBParm);
			
			String noteNo = resBO.doFindByID(42L, "pboss_fx");//短信发送号码
			
			String sendTimeParam = resBO.doFindByID("58", "pboss_fx");//发送时间点参数，时间格式为hh:mi；默认为8:30
			if(StringUtils.isEmpty(sendTimeParam)){
				sendTimeParam = "08:30";
			}
			String timePoint = sendTimeParam + ":00";
			
			Calendar calendar = Calendar.getInstance();
			//短信发送时间，从系统参数中取某个时间点，然后组装成系统当前日期的这个时间点.//取当前时间的取早上9点，如果运行时间超过9点，则发送日期取第二天上午的9点
			Date senttime = PublicUtils.UtilStrToDate(PublicUtils.getMonthSomeTime(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, timePoint));
			/*if(currDate.after(senttime)){
				senttime = PublicUtils.getPreOrAfterDate(currDate, -1, 9);//获取第二天的9点
			}*/
			for (OrderVO orderVO : orderList) {
				Date createDate = orderVO.getCreatetime();
				String orderid = orderVO.getOrderid();
				int dates = PublicUtils.compareDate(createDate, currDate);
				//系统当前日期与订单创建日期相隔小于等于“订单确认提醒短信连发天数”，则继续下一步
				if(createDate.after(currDate) || Integer.parseInt(confirmTime) < dates){
					log.info("订单[" + orderid + "]已经超过提醒短信连发天数");
					continue;
				}else{
					//更新分销短信确认表中的通知时间
					/**
					 * 根据订单编号、类型（订购确认）、状态（待回复）查询分销短信确认表（FX_SW_SMSCONFIRM）；
					 * 如果有数据，修改通知时间为当前时间；如果无数据，新增一条数据分销短信确认表（编号取库表序列；类型取订购确认；
					 * 确认流水号取订单末尾4位；根据合作商编码查询分销合作商资料表（CH_DST_COOPERATOR），手机号码取收货联系号码；
					 * 关联订单号取订单编号；状态取待回复；通知时间取当前时间；回复时间和回复描述留空）
					 */
					SmsconfirmDBParam smsParams = new SmsconfirmDBParam();
					smsParams.set_se_orderid(orderid);
					smsParams.set_se_type("ORDERCON");//订购确认
					smsParams.set_se_state("WAITREP");//待回复
					smsParams.setDataOnly(true);
					smsParams.set_pagesize("0");
					DataPackage smsDPackage = smsconfirmBO.doQuery(smsParams);
					List<SmsconfirmVO> smsconfirmList = smsDPackage.getDatas();
					
					//查找人员表
					EmployeeDBParam empParams = new EmployeeDBParam();
					empParams.set_se_wayid(orderVO.getWayid());
					empParams.set_ne_isnet("1");//是否店主为是
					empParams.set_ne_empstatus("0");//用工状态为在岗
					empParams.setDataOnly(true);
					DataPackage empDPackage = employeeBO.doQuery(empParams);
					List<EmployeeVO> empList = empDPackage.getDatas();
					EmployeeVO employeeVO = null;
					if(!empList.isEmpty()){
						employeeVO = empList.get(0);
					}else{
						employeeVO = new EmployeeVO();
						employeeVO.setWayid(orderVO.getWayid());
					}
					//获取接收号码
					String recno = employeeVO.getOfficetel();//接收号码
					if(StringUtils.isEmpty(recno) || recno.length() != 11){
						log.info("渠道[" + employeeVO.getWayid() + "]无法取得店主的公务机号码,或者公务机号码长度错误.");
						continue;
					}
					
					if(!smsconfirmList.isEmpty()){
						for (SmsconfirmVO smsconfirmVO : smsconfirmList) {
							smsconfirmVO.setSendtime(currDate);
							smsconfirmBO.doUpdate(smsconfirmVO);
						}
					}else{
						SmsconfirmVO smsvo = new SmsconfirmVO();
						smsvo.setType("ORDERCON");
						smsvo.setStream(orderid.substring(orderid.length() - 4));
						//CooperatorVO cooperatorVO = cooperatorBO.doFindByPk(orderVO.getWayid());
						smsvo.setMobileno(recno);//手机号码取公务机号码
						smsvo.setOrderid(orderid);
						smsvo.setState("WAITREP");
						smsvo.setSendtime(currDate);
						smsconfirmBO.doCreate(smsvo);
					}
					
					//短信内容替换
					String employeeName = employeeVO.getEmployeename();
					if(StringUtils.isEmpty(employeeName)){
						employeeName = "客户";
					}
					String noteDate = PublicUtils.formatUtilDate(createDate, "yyyyMMdd");//订单创建日期，格式化为YYYYMMDD格式
					OrdercomcateDBParam orderceDBParam = new OrdercomcateDBParam();
					orderceDBParam.set_se_orderid(orderid);
					orderceDBParam.setDataOnly(true);
					orderceDBParam.set_pagesize("0");
					DataPackage ordercDPackage = ordercomcateBO.doQuery(orderceDBParam);
					List<OrdercomcateVO> ordercList = ordercDPackage.getDatas();
					StringBuffer orderDesc = new StringBuffer("");//订单商品描述
					List<Map<String, String>> comcategorList = comcategorDP.getDatas();
					if(!ordercList.isEmpty()){
						for (OrdercomcateVO ordercomcateVO : ordercList) {
							String category = ordercomcateVO.getComcategory();
							String categoryName = Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", category, user.getCityid());
							Long orderamt = ordercomcateVO.getOrderamt();
							String unitStr = "";//根据商品种类查询商品种类组合关系表（IM_PR_COMCATEGORYRELA）获取资源类别，套卡单位为套，充值卡单位为张
							for (Map<String, String> map : comcategorList) {
								String category_ = map.get("comcategory");
								if(StringUtils.isNotEmpty(category_) && category_.equals(category)){
									String resType = map.get("restype");
									unitStr = "COMRESSMP".equals(resType) ? "套" : "张";
									break;
								}
							}
							orderDesc.append("," + categoryName + orderamt + unitStr);
						}
					}else{
						log.info("订单[" + orderid + "]无订单商品种类信息");
						continue;
					}
					Double ordersum = orderVO.getRecamt();//合计金额
					String stream = orderid.substring(orderid.length() - 4);//流水号
					
					//获取短信发送号码
					if(StringUtils.isEmpty(noteNo)){
						log.info("获取短信发送号码失败，订单编号[" + orderid + "]");
						return;
					}
					
					//发送短信通知
					String [] contentinfos = {
							employeeName, noteDate, orderDesc.substring(1), String.valueOf(ordersum), stream
					};
					//String content = replaceSyscontent(smstmplVO,contentinfos);
					Map<String,String> keyAndValue = new HashMap<String,String>();
					keyAndValue.put("CUSTNAME", contentinfos[0]);
					keyAndValue.put("YYYYMMDD", contentinfos[1]);
					keyAndValue.put("COMDESC", contentinfos[2]);
					keyAndValue.put("ORDERSUM", contentinfos[3]);
					keyAndValue.put("STREAM", contentinfos[4]);
					Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
					String sContent = smstmplVO.getScontent();
					String content = smstmplBO.doGenSMS("FX_ORDER_CONFIRMNOTICE",sContent,keyAndValue);
					
					//String content = "温馨提示：尊敬的" + employeeName + ",您于" + noteDate + "订购的商品[" + orderDesc.substring(1) + "]，合计金额" + ordersum + "元，请及时回复\"Y" + stream + "\"确认订购。";
					waitreqBO.doInsert3(new Short("3"), content, noteNo, recno,senttime);
				}
			}
		}
		log.info("==================================订单确认提醒 End==================================");
	}
	
	/**
	 * 短信内容替换
	 * @param smstmplVO
	 * @param contentinfos
	 * @return
	 * @throws Exception
	 */
	private String replaceSyscontent(SmstmplVO smstmplVO ,String [] contentinfos) throws Exception {
		String syscontent = smstmplVO.getScontent();
		if(StringUtils.isEmpty(syscontent)){
			return "";
		}
		return syscontent.replaceAll("\\{CUSTNAME\\}", contentinfos[0])
						 .replaceAll("\\{YYYYMMDD\\}", contentinfos[1])
						 .replaceAll("\\{COMDESC\\}", contentinfos[2])
						 .replaceAll("\\{ORDERSUM\\}", contentinfos[3])
						 .replaceAll("\\{STREAM\\}", contentinfos[4]);
	}
	
	/*
	 * 获取短信模板
	 * 根据标识（FX_ORDER_CONFIRMNOTICE）、生效状态（1）
	 * 查询短信模板表（CH_SMS_SMSTMPL），获取模板内容，如果无数据或内容为空，则提示并退出
	 */
	private SmstmplVO doGetSmsTemplete() throws Exception {
		Smstmpl smstmplBO = (SmstmplBO) BOFactory.build(SmstmplBO.class, user);
		SmstmplDBParam param = new SmstmplDBParam();
		param.setDataOnly(true);
		param.set_se_sid("FX_ORDER_CONFIRMNOTICE");
		param.set_se_sstate("1");
		DataPackage dp = smstmplBO.doQuery(param);
		if (null == dp
				|| null == dp.getDatas()
				|| dp.getDatas().size() < 1
				|| ((SmstmplVO) dp.getDatas().get(0)).getScontent() == null
				|| "".equals(((SmstmplVO) dp.getDatas().get(0)).getScontent())){
			return null;
		}
		return (SmstmplVO) dp.getDatas().get(0);
	}
}
