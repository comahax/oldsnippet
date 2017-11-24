package com.gmcc.pboss.common.sms;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.gmcc.pboss.business.base.smstmpl.SmstmplVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.sales.comorder.ComorderConstant;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateDBParam;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateVO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.ordercomcate.Ordercomcate;
import com.gmcc.pboss.control.sales.ordercomcate.OrdercomcateBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.business.SaleException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class ComOrderSms {
	private Properties property = null;

	/**
	 * 根据业务异常信息获取短信内容
	 * 
	 * @param exception
	 *            业务异常
	 * @param user
	 * @return
	 */
	public String getBusiSms(Exception exception, DBAccessUser user)
			throws Exception {
		Smstmpl smstmplBO = (SmstmplBO) BOFactory.build(SmstmplBO.class, user);
		if (exception instanceof SaleException) {

			SaleException saleException = (SaleException) exception;
			String errorCode = saleException.getErrorCode();
			// 判断错误码是否为“SALE-104006”，如果是则将异常信息返回即可
			if ("SALE-104006".equals(errorCode)) {
				return saleException.getMessage();
			}
			String smsCode = getRuleProperty(errorCode);
			if (smsCode == null || "".equals(smsCode)) {
				smsCode = "FX_ORDER_UNKNOWN";
			}
			SmstmplVO smstmplVO = smstmplBO.doFindByPk(smsCode);
			if (smstmplVO != null) {
				String sid = smstmplVO.getSid();
				Map<String, String> keyAndValueMap = setSmsstmplValueMap(saleException);
				return smstmplBO.doGenSMS(sid, keyAndValueMap);
			}
		} else {
			// 非业务异常，则根据短信标识（FX_ORDER_UNKNOWN）查询短信模板表（CH_SMS_SMSTMPL）获取模板内容
			SmstmplVO smstmplVO = smstmplBO.doFindByPk("FX_ORDER_UNKNOWN");
			if (smstmplVO != null) {
				String scontent = smstmplVO.getScontent();
				return scontent;
			}

		}
		return null;
	}

	/**
	 * 封装异常类中的参数MAP
	 * 
	 * @param se
	 * @return
	 */
	public Map<String, String> setSmsstmplValueMap(SaleException se) {
		Map<String, String> map = new HashMap<String, String>();
		if (se.getComcode() != null)
			map.put("COMCODE", se.getComcode());
		if (se.getUnitage() != null)
			map.put("UNITAGE", se.getUnitage().toString());
		if (se.getOrderamt() != null)
			map.put("ORDERAMT", se.getOrderamt().toString());
		if (se.getTimesect() != null)
			map.put("TIMESECT", se.getTimesect().toString());
		if (se.getBrandname() != null)
			map.put("BRANDNAME", se.getBrandname());
		if (se.getMaxamt() != null) {
			map.put("BASEAMT", se.getMaxamt().toString());
			map.put("MONMAX", se.getMaxamt().toString());
			map.put("DAYUP", se.getMaxamt().toString());
			map.put("MONMAX", se.getMaxamt().toString());
			map.put("STOCKMAX", se.getMaxamt().toString());
		}
		if (se.getMontimes() != null) {
			map.put("MONTIMES", se.getMontimes().toString());
		}
		if (se.getMonmaxtimes() != null) {
			map.put("MONMAXTIMES", se.getMonmaxtimes().toString());
		}
		return map;
	}

	/**
	 * 封装成功时的参数MAP
	 * 
	 * @param orderid
	 * @param user
	 * @return
	 */
	public Map<String, String> setSmsstmplValueMap(String orderid,
			DBAccessUser user) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ORDERID", orderid);
		Ordercomcate ordercomcateBO = (Ordercomcate) BOFactory.build(
				OrdercomcateBO.class, user);
		OrdercomcateDBParam params = new OrdercomcateDBParam();
		params.set_se_orderid(orderid);
		// 查询订单商品种类表 (FX_SW_ORDERCOMCATE)，按照订单商品类型、商品种类进行组合，格式如下：
		// 订购(55DG#100 100DG#200 100C#100) 搭售(55DG#1 100DG#2) 赠送(55DG#2 100DG#2)
		List<OrdercomcateVO> ordercomcateList = ordercomcateBO.doQuery(params)
				.getDatas();
		String corder = "";// 订购信息
		String systiein = "";// 搭售信息
		String sysgift = "";// 赠送信息
		for (OrdercomcateVO vo : ordercomcateList) {
			if ("CUSTORDER".equals(vo.getOrdercomtype())) {// 订购
				corder += vo.getComcategory() + "#" + vo.getOrderamt() + " ";
			} else if ("SYSTIEIN".equals(vo.getOrdercomtype())) {// 搭售
				systiein += vo.getComcategory() + "#" + vo.getOrderamt() + " ";
			} else {// 赠送
				sysgift += vo.getComcategory() + "#" + vo.getOrderamt() + " ";
			}
		}
		String comamt = "";
		if (!"".equals(corder))
			comamt += "订购(" + corder + ")";
		if (!"".equals(systiein))
			comamt += "搭售(" + systiein + ") ";
		if (!"".equals(systiein))
			comamt += "赠送(" + systiein + ") ";
		map.put("COMAMT", comamt);
		return map;

	}

	/**
	 * 获取订购成功短信
	 * 
	 * @param orderid
	 *            订单编号
	 * @param user
	 * @return
	 */
	public String getSuccessSms(String orderid, DBAccessUser user)
			throws Exception {
		Smstmpl smstmplBO = (Smstmpl) BOFactory.build(SmstmplBO.class, user);
		SmstmplVO smstmplVO = smstmplBO.doFindByPk("FX_ORDER_SUCCESS");
		if (smstmplVO != null) {
			String sid = smstmplVO.getSid();
			Map<String, String> keyAndValueMap = setSmsstmplValueMap(orderid,
					user);
			return smstmplBO.doGenSMS(sid, keyAndValueMap);
		}
		return orderid;
	}

	/**
	 * 
	 * 通知网店可以销售
	 * @param wayname 渠道名称
	 * @param orderid 订单编号
	 * @param user 当前登录用户
	 * @return 短信内容
	 * @throws Exception
	 */
	
	public String getCanSaleNotice(String wayname,String orderid,DBAccessUser user) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("CUSTNAME",wayname);
		map.put("ORDERID",orderid);
		Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
		String smsContent = smstmplBO.doGenSMS("FX_ORDER_WAYSALEY", map);
		
		return smsContent;
	}
	
	
	/**
	 * 封装订购确认通知的参数MAP
	 * 
	 * @param orderid
	 * @param user
	 * @return
	 */
	public Map<String, String> setConfirmSmsValueMap(String orderid,
			DBAccessUser user) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		Order orderbo = (Order) BOFactory.build(OrderBO.class, user);
		OrderVO odvo = (OrderVO) orderbo.doFindByPk(orderid);
		String wayid = odvo.getWayid();
		Employee employeeBO = (Employee) BOFactory
				.build(EmployeeBO.class, user);
		EmployeeDBParam emparams = new EmployeeDBParam();
		emparams.set_se_wayid(wayid);
		emparams.set_ne_isnet("1");// 店主
		emparams.set_ne_empstatus("0");// 在岗
		String custname = "客户";
		DataPackage dp1 = employeeBO.doQuery(emparams);
		if (null != dp1 && dp1.getDatas().size() > 0) {
			EmployeeVO vo = (EmployeeVO) dp1.getDatas().get(0);
			if (!StringUtils.isBlank(vo.getEmployeename())) {
				custname = vo.getEmployeename();
			}
		}
		map.put("CUSTNAME", custname);
		Ordercomcate ordercomcateBO = (Ordercomcate) BOFactory.build(
				OrdercomcateBO.class, user);
		OrdercomcateDBParam params = new OrdercomcateDBParam();
		params.set_se_orderid(orderid);

		// 根据订单编号查询订单商品种类表（FX_SW_ORDERCOMCATE），
		// 对商品种类和数量进行组合，格式为“商品1xx套，商品2xx套，……，商品Nxx套”
		List<OrdercomcateVO> ordercomcateList = ordercomcateBO.doQuery(params)
				.getDatas();
		String corder = "";// 订购信息
		String unit = "套";// 单位
		// 从商品种类组合关系表获取此类商品是套卡还是充值卡,以决定单位是'套'或'张'
		Comcategoryrela comcategoryrela = (Comcategoryrela) BOFactory.build(
				ComcategoryrelaBO.class, user);
		for (OrdercomcateVO vo : ordercomcateList) {
			ComcategoryrelaDBParam param = new ComcategoryrelaDBParam();
			param.set_se_comcategory(vo.getComcategory());
			DataPackage dp = comcategoryrela.doQuery(param);
			if (null != dp.getDatas() && dp.getDatas().size() > 0) {
				ComcategoryrelaVO comcategoryrelaVO = (ComcategoryrelaVO) dp
						.getDatas().get(0);
				String restype = comcategoryrelaVO.getRestype();
				// 如果不是套卡,单位为张
				if (null != restype
						&& !restype.equals(ComorderConstant.RESTYPE_SMP)) {
					unit = "张";
				}
			}
			corder += Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", vo
					.getComcategory(), user.getCityid())
					+ vo.getOrderamt() + unit + ", ";
		}
		if (!"".equals(corder)) {
			corder = corder.substring(0, corder.length() - 2);// 去掉最后一个逗号和最后一个空格
		}
		map.put("COMDESC", corder);
		map.put("ORDERSUM", odvo.getRecamt().toString());
		map.put("ORDERID", orderid);
		Sysparam sysbo = (Sysparam) BOFactory.build(SysparamBO.class, user);
		String overtime = "20";
		if (StringUtils.isNotBlank(sysbo.doFindByID("41", "pboss_fx"))) {
			overtime = sysbo.doFindByID("41", "pboss_fx");
		}
		map.put("OVERTIME", overtime);
		String stream = orderid.substring(orderid.length() - 4, orderid
				.length());// 取订单编号末尾四位
		map.put("STREAM", stream);

		return map;
	}

	/**
	 * 获取订购确认通知短信
	 * 
	 * @param orderid
	 *            订单编号
	 * @param user
	 * @return
	 */
	public String getConfirmSms(String orderid, DBAccessUser user)
			throws Exception {
		Smstmpl smstmplBO = (Smstmpl) BOFactory.build(SmstmplBO.class, user);
		SmstmplVO smstmplVO = smstmplBO.doFindByPk("FX_ORDER_CONFIRM");
		
		if (smstmplVO != null) {
			String sid = smstmplVO.getSid();
			Map<String, String> keyAndValueMap = setConfirmSmsValueMap(orderid,
					user);
			return smstmplBO.doGenSMS(sid, keyAndValueMap);
		}
		return orderid;
	}

	/**
	 * 从规则配置文件中读取内容
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	private String getRuleProperty(String content) throws Exception {
		if (property == null) {
			property = new Properties();
		}
		if (property.isEmpty()) {
			InputStream in = ComOrderSms.class
					.getResourceAsStream("/data/ComOrderSms.properties");
			property.load(in);
			/*
			 * URL url = ComOrderSms.class.getClassLoader()
			 * .getResource("data/ComOrderSms.properties"); File file=new
			 * File(url.getFile()); property.load(new FileInputStream(file));
			 */
		}
		return property.getProperty(content);
	}
}
