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
	 * ����ҵ���쳣��Ϣ��ȡ��������
	 * 
	 * @param exception
	 *            ҵ���쳣
	 * @param user
	 * @return
	 */
	public String getBusiSms(Exception exception, DBAccessUser user)
			throws Exception {
		Smstmpl smstmplBO = (SmstmplBO) BOFactory.build(SmstmplBO.class, user);
		if (exception instanceof SaleException) {

			SaleException saleException = (SaleException) exception;
			String errorCode = saleException.getErrorCode();
			// �жϴ������Ƿ�Ϊ��SALE-104006������������쳣��Ϣ���ؼ���
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
			// ��ҵ���쳣������ݶ��ű�ʶ��FX_ORDER_UNKNOWN����ѯ����ģ���CH_SMS_SMSTMPL����ȡģ������
			SmstmplVO smstmplVO = smstmplBO.doFindByPk("FX_ORDER_UNKNOWN");
			if (smstmplVO != null) {
				String scontent = smstmplVO.getScontent();
				return scontent;
			}

		}
		return null;
	}

	/**
	 * ��װ�쳣���еĲ���MAP
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
	 * ��װ�ɹ�ʱ�Ĳ���MAP
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
		// ��ѯ������Ʒ����� (FX_SW_ORDERCOMCATE)�����ն�����Ʒ���͡���Ʒ���������ϣ���ʽ���£�
		// ����(55DG#100 100DG#200 100C#100) ����(55DG#1 100DG#2) ����(55DG#2 100DG#2)
		List<OrdercomcateVO> ordercomcateList = ordercomcateBO.doQuery(params)
				.getDatas();
		String corder = "";// ������Ϣ
		String systiein = "";// ������Ϣ
		String sysgift = "";// ������Ϣ
		for (OrdercomcateVO vo : ordercomcateList) {
			if ("CUSTORDER".equals(vo.getOrdercomtype())) {// ����
				corder += vo.getComcategory() + "#" + vo.getOrderamt() + " ";
			} else if ("SYSTIEIN".equals(vo.getOrdercomtype())) {// ����
				systiein += vo.getComcategory() + "#" + vo.getOrderamt() + " ";
			} else {// ����
				sysgift += vo.getComcategory() + "#" + vo.getOrderamt() + " ";
			}
		}
		String comamt = "";
		if (!"".equals(corder))
			comamt += "����(" + corder + ")";
		if (!"".equals(systiein))
			comamt += "����(" + systiein + ") ";
		if (!"".equals(systiein))
			comamt += "����(" + systiein + ") ";
		map.put("COMAMT", comamt);
		return map;

	}

	/**
	 * ��ȡ�����ɹ�����
	 * 
	 * @param orderid
	 *            �������
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
	 * ֪ͨ�����������
	 * @param wayname ��������
	 * @param orderid �������
	 * @param user ��ǰ��¼�û�
	 * @return ��������
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
	 * ��װ����ȷ��֪ͨ�Ĳ���MAP
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
		emparams.set_ne_isnet("1");// ����
		emparams.set_ne_empstatus("0");// �ڸ�
		String custname = "�ͻ�";
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

		// ���ݶ�����Ų�ѯ������Ʒ�����FX_SW_ORDERCOMCATE����
		// ����Ʒ���������������ϣ���ʽΪ����Ʒ1xx�ף���Ʒ2xx�ף���������ƷNxx�ס�
		List<OrdercomcateVO> ordercomcateList = ordercomcateBO.doQuery(params)
				.getDatas();
		String corder = "";// ������Ϣ
		String unit = "��";// ��λ
		// ����Ʒ������Ϲ�ϵ���ȡ������Ʒ���׿����ǳ�ֵ��,�Ծ�����λ��'��'��'��'
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
				// ��������׿�,��λΪ��
				if (null != restype
						&& !restype.equals(ComorderConstant.RESTYPE_SMP)) {
					unit = "��";
				}
			}
			corder += Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", vo
					.getComcategory(), user.getCityid())
					+ vo.getOrderamt() + unit + ", ";
		}
		if (!"".equals(corder)) {
			corder = corder.substring(0, corder.length() - 2);// ȥ�����һ�����ź����һ���ո�
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
				.length());// ȡ�������ĩβ��λ
		map.put("STREAM", stream);

		return map;
	}

	/**
	 * ��ȡ����ȷ��֪ͨ����
	 * 
	 * @param orderid
	 *            �������
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
	 * �ӹ��������ļ��ж�ȡ����
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
