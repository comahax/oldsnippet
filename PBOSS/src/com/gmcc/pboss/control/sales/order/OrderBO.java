/**
 * aut code
 * Mon Oct 12 14:56:43 CST 2009
 */
package com.gmcc.pboss.control.sales.order;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.gmcc.ngcrm.GDProdPort;
import net.gmcc.ngcrm.Msgreqheader;
import net.gmcc.ngcrm.Orderinreq;
import net.gmcc.ngcrm.Orderinreq.Msgbody;
import net.gmcc.ngcrm.Orderinreq.Msgbody.Orderdetlist;
import net.gmcc.ngcrm.Orderinreq.Msgbody.Paytypeinfolist;
import net.gmcc.ngcrm.Orderinreq.Msgbody.Orderdetlist.Orderdet;
import net.gmcc.ngcrm.Orderinreq.Msgbody.Paytypeinfolist.Paytypeinfo;
import net.sf.json.JSONArray;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.base.smsobject.SmsobjectDBParam;
import com.gmcc.pboss.business.base.smsobject.SmsobjectVO;
import com.gmcc.pboss.business.base.smstmpl.SmstmplDBParam;
import com.gmcc.pboss.business.base.smstmpl.SmstmplVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.waitreq.WaitreqVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.com.ComVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.resource.compack.CompackDBParam;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.comrescard.ComrescardVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.resource.emptysim.EmptysimVO;
import com.gmcc.pboss.business.sales.audit.AuditDBParam;
import com.gmcc.pboss.business.sales.audit.AuditVO;
import com.gmcc.pboss.business.sales.comsellmid.ComsellmidVO;
import com.gmcc.pboss.business.sales.disform.DisformDBParam;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.disoverdetail.DisoverdetailVO;
import com.gmcc.pboss.business.sales.disoverstat.DisoverstatVO;
import com.gmcc.pboss.business.sales.order.AuxiliaryInfoVO;
import com.gmcc.pboss.business.sales.order.NextProcessResult;
import com.gmcc.pboss.business.sales.order.OrderDAO;
import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.order.StockInfoVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateDBParam;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateStocksVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateVO;
import com.gmcc.pboss.business.sales.orderlog.OrderlogDBParam;
import com.gmcc.pboss.business.sales.orderpackdet.OrderpackdetDBParam;
import com.gmcc.pboss.business.sales.orderpackdet.OrderpackdetVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDAO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetVO;
import com.gmcc.pboss.business.sales.ordertask.OrdertaskDBParam;
import com.gmcc.pboss.business.sales.ordertask.OrdertaskVO;
import com.gmcc.pboss.business.sales.partnerres.PartnerresVO;
import com.gmcc.pboss.business.sales.process.ProcessVO;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtDBParam;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtVO;
import com.gmcc.pboss.business.sales.simrealtimeamt.SimrealtimeamtDBParam;
import com.gmcc.pboss.business.sales.simrealtimeamt.SimrealtimeamtVO;
import com.gmcc.pboss.client.boss.BossIAO;
import com.gmcc.pboss.client.boss.result.IncomeAccountResult;
import com.gmcc.pboss.client.boss.send.ChargeData;
import com.gmcc.pboss.client.boss.send.IncomeAccountDataPack;
import com.gmcc.pboss.common.sms.ComOrderSms;
import com.gmcc.pboss.common.utils.Object2String;
import com.gmcc.pboss.control.base.smsobject.Smsobject;
import com.gmcc.pboss.control.base.smsobject.SmsobjectBO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.com.Com;
import com.gmcc.pboss.control.resource.com.ComBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.comrescard.Comrescard;
import com.gmcc.pboss.control.resource.comrescard.ComrescardBO;
import com.gmcc.pboss.control.resource.comressmp.Comressmp;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.control.resource.emptysim.Emptysim;
import com.gmcc.pboss.control.resource.emptysim.EmptysimBO;
import com.gmcc.pboss.control.sales.audit.Audit;
import com.gmcc.pboss.control.sales.audit.AuditBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.gmcc.pboss.control.sales.comsellmid.Comsellmid;
import com.gmcc.pboss.control.sales.comsellmid.ComsellmidBO;
import com.gmcc.pboss.control.sales.disform.Disform;
import com.gmcc.pboss.control.sales.disform.DisformBO;
import com.gmcc.pboss.control.sales.disoverdetail.Disoverdetail;
import com.gmcc.pboss.control.sales.disoverdetail.DisoverdetailBO;
import com.gmcc.pboss.control.sales.disoverstat.Disoverstat;
import com.gmcc.pboss.control.sales.disoverstat.DisoverstatBO;
import com.gmcc.pboss.control.sales.ordercomcate.Ordercomcate;
import com.gmcc.pboss.control.sales.ordercomcate.OrdercomcateBO;
import com.gmcc.pboss.control.sales.orderlog.Orderlog;
import com.gmcc.pboss.control.sales.orderlog.OrderlogBO;
import com.gmcc.pboss.control.sales.orderpackdet.Orderpackdet;
import com.gmcc.pboss.control.sales.orderpackdet.OrderpackdetBO;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.gmcc.pboss.control.sales.orderresdet.Orderresdet;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO;
import com.gmcc.pboss.control.sales.ordertask.Ordertask;
import com.gmcc.pboss.control.sales.ordertask.OrdertaskBO;
import com.gmcc.pboss.control.sales.partnerres.Partnerres;
import com.gmcc.pboss.control.sales.partnerres.PartnerresBO;
import com.gmcc.pboss.control.sales.process.ProcessBO;
import com.gmcc.pboss.control.sales.realtimeamt.Realtimeamt;
import com.gmcc.pboss.control.sales.realtimeamt.RealtimeamtBO;
import com.gmcc.pboss.control.sales.simrealtimeamt.Simrealtimeamt;
import com.gmcc.pboss.control.sales.simrealtimeamt.SimrealtimeamtBO;
import com.gmcc.pboss.web.common.webservice.CRMService;
import com.gmcc.pboss.web.common.webservice.CRMServiceUtil;
import com.gmcc.pboss.web.common.webservice.ICRMService;
import com.gmcc.pboss.web.sales.stockalarm.AlarmUtils;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.common.utils.lang.TimeUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: OrderBO
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author wefrogll
 * @version 1.0
 */
public class OrderBO extends AbstractControlBean implements Order {
	private static Logger log = Logger.getLogger(OrderBO.class);

	public OrderVO doCreate(OrderVO vo) throws Exception {
		try {
			OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
			// TODO set the pk */
			return (OrderVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderVO vo) throws Exception {
		try {
			OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderVO doUpdate(OrderVO vo) throws Exception {
		try {
			OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
			return (OrderVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderVO doFindByPk(Serializable pk) throws Exception {
		OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
		return (OrderVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderDBParam params) throws Exception {
		OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
		return dao.query(params);
	}
	
	public DataPackage doList(OrderDBParam params) throws Exception {
		OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
		//����װ�ز�ѯ�Ľ��
		DataPackage dp=null;
		if (params.get_se_comcategory() != null
				&& params.get_se_comcategory().length() > 0) {
			 dp=dao.queryByNamedSqlQuery("queryOrderWithComcategory",params);
		}else
		{
			 dp = dao.query(params);
		}
		if (null != dp && null != dp.getDatas()) {
			//get comcategory and brand
			//get comcategory map $IM_FXCOMCATEGORY
			DBQueryParam dBQueryParam = new DBQueryParam();
			dBQueryParam.set_pagesize("999");
			Map comcategoryMap = Code2NameUtils.valueList("$IM_FXCOMCATEGORY", null, dBQueryParam, user.getCityid());			
			//get brand map $FX_SMPBRAND
			Map brandMap = Code2NameUtils.valueList("$FX_SMPBRAND", user.getCityid());
			
			List<OrderVO> list = dp.getDatas();
			for (OrderVO vo : list) {
				//get comcategory+sum
				OrderDAO orderdao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
				OrderDBParam param = new OrderDBParam();
				Map<String, String> queryConditions = new HashMap<String, String>();
				queryConditions.put("ORDERID", vo.getOrderid());
				param.setQueryConditions(queryConditions);
				param.setSelectFieldsString("COMCATEGORY,NUM");
				param.setDataOnly(true);
				param.setQueryAll(true);
				DataPackage orderdp = orderdao.queryByNamedSqlQuery(
						"com.gmcc.pboss.business.sales.order.GETORDERINFO", param);
				
				vo.setOrderInfo(doGetOrderInfo(orderdp,comcategoryMap));				
				vo.setBrandInfo(doGetBrandInfo(orderdp,brandMap));
			}
		}
		
		return dp;
	}

	/**
	 * ������Ϣ�����ݶ�����Ų�ѯ������Ʒ���� (FX_SW_ORDERCOMCATE)��
	 * ��ͬ��Ʒ����(�Ѿ���������ĵ�)�Ķ������������ۼӣ������ա���Ʒ����A���������� ��Ʒ����B����������������ϡ�
	 * 
	 * @param orderID
	 *            �������
	 */
	public String doGetOrderInfo(String orderID) throws Exception {
		StringBuilder result = new StringBuilder(50);
		OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
		OrderDBParam param = new OrderDBParam();
		Map<String, String> queryConditions = new HashMap<String, String>();
		queryConditions.put("ORDERID", orderID);
		param.setQueryConditions(queryConditions);
		param.setSelectFieldsString("COMCATEGORY,NUM");
		param.setDataOnly(true);
		param.setQueryAll(true);
		DataPackage dp = dao.queryByNamedSqlQuery(
				"com.gmcc.pboss.business.sales.order.GETORDERINFO", param);
		if (null != dp && null != dp.getDatas()) {
			List<Map<String, String>> list = dp.getDatas();
			for (Map<String, String> map : list) {
				result.append(",");
				result.append(Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", map
						.get("COMCATEGORY"), user.getCityid()));
				result.append("(").append(map.get("NUM")).append(")");
			}
		}
		return result.toString().replaceFirst(",", "");
	}
	/**
	 * ������Ϣ�����ݶ�����Ų�ѯ������Ʒ���� (FX_SW_ORDERCOMCATE)��
	 * ��ͬ��Ʒ����(�Ѿ���������ĵ�)�Ķ������������ۼӣ������ա���Ʒ����A���������� ��Ʒ����B����������������ϡ�
	 * 
	 * @param dp
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public String doGetOrderInfo(DataPackage dp,Map comcategoryMap) throws Exception {
		StringBuilder result = new StringBuilder(50);
		
		if (null != dp && null != dp.getDatas()) {
			List<Map<String, String>> list = dp.getDatas();
			for (Map<String, String> map : list) {
				result.append(",");
				result.append(comcategoryMap.get(map.get("COMCATEGORY")));
				result.append("(").append(map.get("NUM")).append(")");
			}
		}
		return result.toString().replaceFirst(",", "");
	}
	
	
	/**
	 * Ʒ����Ϣ�����ݶ�����Ų�ѯ������Ʒ���� (FX_SW_ORDERCOMCATE)����Ʒ������Ϲ�ϵ�� (IM_PR_COMCATEGORYRELA)������ѯ�õ���Ӧ��Ʒ����Ϣ��
	 * Ȼ�����ͬƷ�ƵĶ������������ۼӣ������ա�Ʒ��A����������Ʒ��B�����������������,��ֵ������
	 * @param orderID �������
	 */
	private String doGetBrandInfo(String orderID) throws Exception {
		StringBuilder result = new StringBuilder(50);
		OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
		OrderDBParam param = new OrderDBParam();
		Map<String, String> queryConditions = new HashMap<String, String>();
		queryConditions.put("ORDERID", orderID);
		param.setQueryConditions(queryConditions);
		param.setSelectFieldsString("COMCATEGORY,NUM");
		param.setDataOnly(true);
		param.setQueryAll(true);
		DataPackage dp = dao.queryByNamedSqlQuery(
				"com.gmcc.pboss.business.sales.order.GETORDERINFO", param);
		if (null != dp && null != dp.getDatas()) {
			List<Map<String, String>> list = dp.getDatas();
			Map<String, Long> brandAndNumMap = new HashMap<String, Long>();// Ʒ��������map
			for (Map<String, String> map : list) {
				String brandTemp = this.getBrand(map.get("COMCATEGORY"));// Ʒ��
				if(StringUtils.isNotBlank(brandTemp)){
					Long numTemp = new Long(map.get("NUM"));
					if (!brandAndNumMap.containsKey(brandTemp)) {
						brandAndNumMap.put(brandTemp, numTemp);
					} else {
						Long oldnum = brandAndNumMap.get(brandTemp);
						brandAndNumMap.put(brandTemp, (oldnum + new Long(map
								.get("NUM"))));
					}
				}
			}
			Set<String> brandSet = brandAndNumMap.keySet();
			Iterator it = brandSet.iterator();
			for (int i = 0; i < brandSet.size(); i++) {
				String brand = it.next().toString();
				result.append(",");
				result.append(Code2NameUtils.code2Name("$FX_SMPBRAND", brand, user.getCityid()));
				result.append("(").append( brandAndNumMap.get(brand)).append(")");
			}
		}
		return result.toString().replaceFirst(",", "");
	}
	/**
	 * Ʒ����Ϣ�����ݶ�����Ų�ѯ������Ʒ���� (FX_SW_ORDERCOMCATE)����Ʒ������Ϲ�ϵ�� (IM_PR_COMCATEGORYRELA)������ѯ�õ���Ӧ��Ʒ����Ϣ��
	 * Ȼ�����ͬƷ�ƵĶ������������ۼӣ������ա�Ʒ��A����������Ʒ��B�����������������,��ֵ������
	 * @param dp
	 * @param brandMap
	 * @return
	 * @throws Exception
	 */
	private String doGetBrandInfo(DataPackage dp,Map brandMap) throws Exception {
		StringBuilder result = new StringBuilder(50);
		
		if (null != dp && null != dp.getDatas()) {
			List<Map<String, String>> list = dp.getDatas();
			Map<String, Long> brandAndNumMap = new HashMap<String, Long>();// Ʒ��������map
			for (Map<String, String> map : list) {
				String brandTemp = this.getBrand(map.get("COMCATEGORY"));// Ʒ��
				if(StringUtils.isNotBlank(brandTemp)){
					Long numTemp = new Long(map.get("NUM"));
					if (!brandAndNumMap.containsKey(brandTemp)) {
						brandAndNumMap.put(brandTemp, numTemp);
					} else {
						Long oldnum = brandAndNumMap.get(brandTemp);
						brandAndNumMap.put(brandTemp, (oldnum + new Long(map
								.get("NUM"))));
					}
				}
			}
			Set<String> brandSet = brandAndNumMap.keySet();
			Iterator it = brandSet.iterator();
			for (int i = 0; i < brandSet.size(); i++) {
				String brand = it.next().toString();
				result.append(",");
				result.append(brandMap.get(brand));
				result.append("(").append( brandAndNumMap.get(brand)).append(")");
			}
		}
		return result.toString().replaceFirst(",", "");
	}
	/**
	 * ��ȡƷ��
	 * @param comcategory ��������
	 * @return
	 * @throws Exception
	 */
	private String getBrand(String comcategory) throws Exception {
		try {
			String brand = "";
			Comcategoryrela comcategoryrela = (Comcategoryrela) BOFactory
					.build(ComcategoryrelaBO.class, user);
			ComcategoryrelaDBParam comcategoryrelaDBParam = new ComcategoryrelaDBParam();
			comcategoryrelaDBParam.set_se_comcategory(comcategory);
			DataPackage dp = comcategoryrela.doQuery(comcategoryrelaDBParam);
			ComcategoryrelaVO vo = null;
			if (dp != null && dp.getDatas().size() != 0) {
				vo = (ComcategoryrelaVO) dp.getDatas().get(0);
				brand = vo.getBrand();
			}
			return brand;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	/**
	 * ���¶���״̬
	 * 
	 * @param pkItem
	 *            ������(��)
	 * @param state
	 *            ����Ϊ����״̬
	 * @throws Exception
	 */
	public void setOrderState(String[] pkItem, String state) throws Exception {
		Order bo = (OrderBO) BOFactory.build(OrderBO.class, user);
		for (String pk : pkItem) {
			OrderVO vo = this.doFindByPk(pk);
			if (null != vo) {
				vo.setOrderstate(state);
				bo.doUpdate(vo);
			}
		}
	}

	/**
	 * ������һ������
	 * 
	 * @param orderid
	 *            �������
	 * @return String[2] ʧ�ܷ���NULL
	 * @throws Exception
	 */
	public String[] doNextProcess(String orderid) throws Exception {
		String[] result = null;
		// ���ݶ�����Ų�ѯ������FX_SW_ORDER��������������򷵻ؽ����ǡ�2������ʾ��Ϣ���������ݲ����ڡ���
		OrderVO orderVO = this.doFindByPk(orderid);
		if (orderVO == null) {
			result = new String[2];
			result[0] = "2";
			result[1] = "�������ݲ�����";
			return result;
		}
		// ��ȡ�������̱�źͶ���״̬����ѯ�������̲����FX_RU_ORDERPROCE����
		// ƥ�����״̬Ϊ��ǰ����״̬������������򷵻ؽ����ǡ�2������ʾ��Ϣ����ǰ��������һ�������������������
		Orderproce orderProceBO = (OrderproceBO) BOFactory.build(
				OrderproceBO.class, user);
		OrderproceDBParam orderproceParam = new OrderproceDBParam();
		orderproceParam.set_ne_flowid(orderVO.getFlowid() + "");
		orderproceParam.set_se_instate(orderVO.getOrderstate());
		DataPackage orderproceDP = orderProceBO.doQuery(orderproceParam);
		if (null == orderproceDP || orderproceDP.getDatas() == null
				|| orderproceDP.getDatas().size() == 0) {
			result = new String[2];
			result[0] = "2";
			result[1] = "��ǰ��������һ������";
			return result;
		}
		OrderproceVO orderproceVO = (OrderproceVO) orderproceDP.getDatas().get(
				0);// ���ж�������ȡ��һ��

		com.gmcc.pboss.control.sales.process.Process processBO = (ProcessBO) BOFactory
				.build(ProcessBO.class, user);
		ProcessVO processVO = processBO.doFindByPk(orderproceVO.getProcessid());
		// ���ݲ����Ų�ѯ���������
		// (FX_RU_PROCESS)��������������ݣ��򷵻ؽ����ǡ�2������ʾ��Ϣ����������[������]���ݲ����ڡ���
		if (null == processVO) {
			result = new String[2];
			result[0] = "2";
			result[1] = "��������[" + orderproceVO.getProcessid() + "]���ݲ�����";
			return result;
		}

		if ("MANUAL".equals(orderproceVO.getDismode())) {
			// 2) �˹�����ģʽ
			// ����������账��ģʽΪ�˹����򷵻ؽ����ǡ�0��������·��Ϊ���������д������·�����������
			result = new String[2];
			result[0] = "0";
			result[1] = processVO.getUipath();
			return result;
		}

		if ("AUTO".equals(orderproceVO.getDismode())) {
			// 3) �Զ�����ģʽ
			// ����������账��ģʽΪ�Զ������ݶ�����š����б�ʶ����ǰ���У�����Ч�ԣ���Ч����ѯ���������FX_SW_ORDERTASK����
			// ������������򲻴��������������ݵ�������������ȡSEQ�����б�ʶȡ��ǰ���У�
			// �������ȡ��ǰ������ţ���Ч��ȡ1��Ч������ʱ��ȡ��ǰʱ�䡣
			// ���ؽ����ǡ�1������ʾ��Ϣ���ö����ѽ���[������������]��̨�Զ�������
			Ordertask ordertaskBO = (OrdertaskBO) BOFactory.build(
					OrdertaskBO.class, user);
			OrdertaskDBParam ordertaskParam = new OrdertaskDBParam();
			ordertaskParam.set_se_cityid(user.getCityid());
			ordertaskParam.set_se_orderid(orderid);
			ordertaskParam.set_ne_effective("1");
			DataPackage ordertaskDP = ordertaskBO.doQuery(ordertaskParam);
			if (null == ordertaskDP || null == ordertaskDP.getDatas()
					|| 0 == ordertaskDP.getDatas().size()) {
				OrdertaskVO ordertaskVO = new OrdertaskVO();
				ordertaskVO.setOrderid(orderid);
				ordertaskVO.setCityid(user.getCityid());
				ordertaskVO.setEffective(new Short("1"));
				ordertaskVO.setCreatetime(new Date());
				ordertaskBO.doCreate(ordertaskVO);
			}
			result = new String[2];
			result[0] = "1";
			result[1] = "�ö����ѽ���[" + processVO.getProcessname() + "]��̨�Զ�����";
			return result;
		}

		return result;

	}
	
	/**
	 * ������һ������-����һ������
	 * @param orderids �����������
	 * @return
	 * @throws Exception
	 */
	public List<NextProcessResult> doNextProcess(String[] orderids) throws Exception{
		List<NextProcessResult> results = new ArrayList<NextProcessResult>();
		for(int i=0; i<orderids.length;i++){
			String result[] = this.doNextProcess(orderids[i]);
			if("0".equals(result[0])){
				result[1]="��ǰ����Ϊ�˹�������";
			}
			NextProcessResult r = new NextProcessResult(Integer.parseInt(result[0]), orderids[i], result[1]);
			results.add(r);
		}
		return results;
	}

	/**
	 * �����շ�
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void doPay(OrderVO vo) throws Exception {
		// ����ͻ���ʽ���ǡ������������ǩ��״̬���ͨ����
		// ����ͻ���ʽΪ�������������ǩ��״̬Ϊ����ǩ�ա���ǩ��״̬���ͨ�������򷵻���ʾ���ͻ���ʽΪ�������ǩ��״̬����Ϊ��ǩ��ʱ��������ִ���շѲ���������
		if ("ARRIVEPAY".equals(vo.getDelitype())
				&& !"SIGNED".equals(vo.getSignstate())) {
			throw new JOPException(" �ͻ���ʽΪ�������ǩ��״̬����Ϊ��ǩ��ʱ��������ִ���շѲ����� ");
		}

		// ���ȶ��ύ�Ķ���״̬��飺���ݶ������̱�źͳ���״̬�����շѣ���ѯ�������̲����FX_RU_ORDERPROCE����������״̬�����ڵ�ǰ����״̬����ʾ������״̬����ȷ�������أ����������
		Orderproce orderProceBO = (OrderproceBO) BOFactory.build(
				OrderproceBO.class, user);
		OrderproceDBParam orderproceParam = new OrderproceDBParam();
		orderproceParam.set_ne_flowid("" + vo.getFlowid());
		orderproceParam.set_se_outstate("CHARGED");
		DataPackage orderproceDP = orderProceBO.doQuery(orderproceParam);
		if (null == orderproceDP
				|| null == orderproceDP.getDatas()
				|| 0 == orderproceDP.getDatas().size()
				|| !vo.getOrderstate().equalsIgnoreCase(
						((OrderproceVO) orderproceDP.getDatas().get(0))
								.getInstate())) {
			throw new JOPException(" ����״̬����ȷ ");
		}

		// ���ݽ����շѽ����¶������е�ʵ�ս���POS��ˮ�š� ���¶���״̬Ϊ���շ�,����״̬���ʱ��Ϊ��ǰʱ�䡣��
		Order orderBO = (OrderBO) BOFactory.build(OrderBO.class, user);

		OrderVO orderVO = this.doFindByPk(vo.getOrderid());

		orderVO.setPaytype(vo.getPaytype());
		orderVO.setPosstream(vo.getPosstream());
		orderVO.setActamt(vo.getActamt());
		orderVO.setOrderstate("CHARGED");
		Date nowDate = new Date();
		orderVO.setStatechgtime(nowDate);
		orderVO.setPaytime(nowDate);
		orderBO.doUpdate(orderVO);
		this.doNextProcess(vo.getOrderid());
	}

	/** ��������
	 * 
	 * @param orderid
	 *            �������
	 * @throws Exception
	 */
	public OrderVO doRecorded(String orderid,String bossworkid) throws Exception {
		Order orderBO = (OrderBO) BOFactory.build(OrderBO.class, user);
		OrderVO orderVO = orderBO.doFindByPk(orderid);
		try {
			// ���ȶ��ύ�Ķ���״̬��飺���ݶ������̱�ź����״̬������״̬����ѯ�������̲����FX_RU_ORDERPROCE����
			// �������״̬�ǡ�����ɡ�������ʾ������״̬����ȷ�������أ����������
			log.info("����["+orderid+"]COMS���˿�ʼ");
			if (null == orderVO){
				log.info("����["+orderid+"]�Ҳ�����صĶ���");
				throw new JOPException("�Ҳ��� [" + orderid + "] ��صĶ���");
			}				
			Orderproce orderProceBO = (OrderproceBO) BOFactory.build(
					OrderproceBO.class, user);
			OrderproceDBParam orderproceParam = new OrderproceDBParam();
			orderproceParam.setDataOnly(true);
			orderproceParam.set_ne_flowid("" + orderVO.getFlowid());
			orderproceParam.set_se_instate(orderVO.getOrderstate());
			DataPackage orderproceDP = orderProceBO.doQuery(orderproceParam);
			if (null == orderproceDP || null == orderproceDP.getDatas()
					|| 0 == orderproceDP.getDatas().size()) {
				log.info("����["+orderid+"]����״̬����ȷ");
				throw new JOPException(" ����״̬����ȷ ");
			}
			OrderproceVO orderproceVO = (OrderproceVO) orderproceDP.getDatas()
					.get(0);
			if (!"FINISHED".equals(orderproceVO.getOutstate())){
				log.info("����["+orderid+"]����״̬����ȷ");
				throw new JOPException(" ����״̬����ȷ ");
			}				
			// 1) ��Ʒ��״̬���£����ݶ�����Ų�ѯ������Ʒ����ϸ��FX_SW_ORDERPACKDET����
			// ���ݲ�ѯ����е���Ʒ���κͰ��ţ�����Ʒ����IM_PR_COMPACK���е���Ʒ��״̬����Ϊ����(2)��
			log.info("����["+orderid+"]��Ʒ��״̬���¿�ʼ");
			Orderpackdet orderpackdetBO = (OrderpackdetBO) BOFactory.build(
					OrderpackdetBO.class, user);
			OrderpackdetDBParam orderpackdetParam = new OrderpackdetDBParam();
			orderpackdetParam.setQueryAll(true);
			orderpackdetParam.setDataOnly(true);
			orderpackdetParam.set_se_orderid(orderid);
			DataPackage orderpackdetDP = orderpackdetBO
					.doQuery(orderpackdetParam);
			log.info("���ݶ�����Ų�ѯ������Ʒ����ϸ��FX_SW_ORDERPACKDET��,���鵽["+orderpackdetDP.getDatas().size()+"]������");
			if (null != orderpackdetDP && null != orderpackdetDP.getDatas()
					&& 0 < orderpackdetDP.getDatas().size()) {
				for (int k = 0; k < orderpackdetDP.getDatas().size(); k++) {
					OrderpackdetVO orderpackdetVO = (OrderpackdetVO) orderpackdetDP
							.getDatas().get(k);
					Compack compackBO = (CompackBO) BOFactory.build(
							CompackBO.class, user);
					CompackVO compackVO = new CompackVO();
					compackVO.setBatchno(orderpackdetVO.getBatchno());
					compackVO.setBoxnum(orderpackdetVO.getBoxnum());
					compackVO = compackBO.doFindByPk(compackVO);
					if (null == compackVO){
						log.info(" ��Ʒ��������  boxnum ��"+ orderpackdetVO.getBoxnum() + " batchno:"+ orderpackdetVO.getBatchno());
						throw new JOPException(" ��Ʒ��������  boxnum ��"
								+ orderpackdetVO.getBoxnum() + " batchno:"
								+ orderpackdetVO.getBatchno());
					}
					compackVO.setPackstate("2");
					compackBO.doUpdate(compackVO);
				}

			}
			log.info("����["+orderid+"]��Ʒ��״̬���½���");
			// 2) ��Ʒ��Դ��ϸ״̬���£����ݶ�����Ų�ѯ������Դ��ϸ��FX_SW_ORDERRESDET����
			// ������Դ����׿�(COMRESSMP)���ֵ��(COMRESCARD)������Ʒ��ʶ����Ʒ��Դ��ţ����׿���Դ��IM_FX_COMRESSMP��
			// ���ֵ����Դ��IM_FX_COMRESCARD���е���Ʒ״̬����Ϊ���ۡ�
			log.info("����["+orderid+"]��Ʒ��Դ��ϸ״̬���¿�ʼ");
			Orderresdet orderresdetBO = (OrderresdetBO) BOFactory.build(
					OrderresdetBO.class, user);
			OrderresdetDBParam orderresdetParam = new OrderresdetDBParam();
			orderresdetParam.setQueryAll(true);
			orderresdetParam.setDataOnly(true);
			orderresdetParam.set_se_orderid(orderid);
			DataPackage orderresdetDP = orderresdetBO.doQuery(orderresdetParam);
			if (null != orderresdetDP && null != orderresdetDP.getDatas()
					&& 0 < orderresdetDP.getDatas().size()) {
				for (int i = 0; i < orderresdetDP.getDatas().size(); i++) {
					OrderresdetVO orderresdetVO = (OrderresdetVO) orderresdetDP
							.getDatas().get(i);
					if ("COMRESSMP".equals(orderresdetVO.getRestype())) {// �׿�
						Comressmp comressmpBO = (ComressmpBO) BOFactory.build(
								ComressmpBO.class, user);
						ComressmpVO comressmpVO = new ComressmpVO();
						comressmpVO.setComid(orderresdetVO.getComid());
						comressmpVO.setComresid(orderresdetVO.getComresid());
						comressmpVO = comressmpBO.doFindByPk(comressmpVO);
						if (null == comressmpVO)
							throw new JOPException(" �׿����ݲ����� ��"
									+ orderresdetVO.getComresid());

						comressmpVO.setComstate(new Short("2"));
						comressmpVO.setSaletime(new Date());
						comressmpBO.doUpdate(comressmpVO);

					} else if ("COMRESCARD".equals(orderresdetVO.getRestype())) {// ��ֵ��
						Comrescard comrescardBO = (ComrescardBO) BOFactory
								.build(ComrescardBO.class, user);
						ComrescardVO comrescardVO = new ComrescardVO();
						comrescardVO.setComid(orderresdetVO.getComid());
						comrescardVO.setComresid(orderresdetVO.getComresid());
						comrescardVO = comrescardBO.doFindByPk(comrescardVO);
						if (null == comrescardVO)
							throw new JOPException(" ��ֵ�����ݲ����� ��"
									+ orderresdetVO.getComresid());
						comrescardVO.setComstate(new Short("2"));
						// ����ʱ�����Ϊ��ǰʱ�䡣
						comrescardVO.setSaletime(new Date());
						comrescardBO.doUpdate(comrescardVO);
					} else if ("EMPTYSIM".equals(orderresdetVO.getRestype())) {// �հ�SIM��
						Emptysim emptysimBO = (EmptysimBO) BOFactory.build(
								EmptysimBO.class, user);
						EmptysimVO emptysimVO = new EmptysimVO();
						emptysimVO.setEmptyno(orderresdetVO.getEmptyno());
						emptysimVO = emptysimBO.doFindByPk(emptysimVO.getEmptyno());
						if (null == emptysimVO)
							throw new JOPException(" �հ�SIM�����ݲ����� ��"
									+ orderresdetVO.getComresid());
						emptysimVO.setUsestate(new Short("2"));
						// ����ʱ�����Ϊ��ǰʱ�䡣
						//emptysimVO.setBegintime(new Date());
						emptysimBO.doUpdate(emptysimVO);
					}
				}
			}
			log.info("����["+orderid+"]��Ʒ��Դ��ϸ״̬���½���");
			// 4) ������������Դ���������ݵ���������Դ��FX_SW_PARTNERRES��������ʱ��ȡ��ǰʱ�䣬
			// �Ƿ񼤻���񣬼���ʱ�����գ������ֶ�ȡ������Դ��ϸ��
			log.info("����["+orderid+"]������������Դ��ʼ");
			Partnerres partnerresBO = (PartnerresBO) BOFactory.build(
					PartnerresBO.class, user);
			if (null != orderresdetDP && null != orderresdetDP.getDatas()
					&& 0 < orderresdetDP.getDatas().size()) {
				for (int i = 0; i < orderresdetDP.getDatas().size(); i++) {
					OrderresdetVO orderresdetVO = (OrderresdetVO) orderresdetDP
							.getDatas().get(i);
					PartnerresVO partnerresVO = new PartnerresVO();

					partnerresVO.setWayid(orderVO.getWayid());
					partnerresVO.setCreatetime(new Date());
					partnerresVO.setIsactive(new Short("0"));
					partnerresVO.setBatchno(orderresdetVO.getBatchno());
					partnerresVO.setBrand(orderresdetVO.getBrand());
					partnerresVO.setComcategory(orderresdetVO.getComcategory());
					partnerresVO.setComid(orderresdetVO.getComid());
					partnerresVO.setRestype(orderresdetVO.getRestype());
					partnerresVO.setComresid(orderresdetVO.getComresid());
					partnerresVO.setEmptyno(orderresdetVO.getEmptyno());
					partnerresBO.doCreate(partnerresVO);
				}
			}
			log.info("����["+orderid+"]������������Դ����");
			ICRMService crmService = new CRMService();
			// ����õ��в��ǵ���CRM�ӿڵĻ���Ҫ������Ʒ�����м��
			if (!crmService.isCRMCityPort(user.getCityid())) {
				// 6) ������Ʒ�����м�����ݶ�����Ų�ѯ������Դ��ϸ��FX_SW_ORDERRESDET����
				// ������������Ʒ�����м��FX_SW_COMSELLMID���������������ȡ������ţ���Ŵ�1������
				// ���б�ʶȡ��ǰ���б�ʶ����Ʒ��Դ��š���Ʒ��ʶ����Ʒ����ȡ�Զ�����Դ��ϸ��
				// ��Դʹ������ȡ������Դ��ϸ����������ʶ�ֶΣ�������Ʒ��ʶ��ѯ��Ʒ���ݱ�IM_PR_COM����ȡ��Ʒԭ��
				// ������Ʒ�����ֶΣ������ݶ�����š�������Ʒ���ͺ���Ʒ�����ѯ������Ʒ�����FX_SW_ORDERCOMCATE��
				// ��ȡʵ���ۼۣ�����Ʒ�����ֶΣ�������ʱ��ȡ��ǰʱ�䡣
				log.info("����["+orderid+"]��CRM���ˣ�������Ʒ�����м��");
				Map<Long, Long> comMap = new HashMap<Long, Long>();
				if (null != orderresdetDP && null != orderresdetDP.getDatas()
						&& orderresdetDP.getDatas().size() > 0) {
					Comsellmid comsellmidBO = (ComsellmidBO) BOFactory.build(
							ComsellmidBO.class, user);
					Com comBO = (ComBO) BOFactory.build(ComBO.class, user);
					Ordercomcate ordercomcateBO = (OrdercomcateBO) BOFactory
							.build(OrdercomcateBO.class, user);

					OrdercomcateDBParam ordercomcateParam = new OrdercomcateDBParam();
					ordercomcateParam.setQueryAll(true);
					ordercomcateParam.setDataOnly(true);
					ordercomcateParam.set_se_orderid(orderid);
					DataPackage ordercomcateDP = ordercomcateBO
							.doQuery(ordercomcateParam);

					List<OrderresdetVO> list = orderresdetDP.getDatas();
					int i = 1;
					for (OrderresdetVO orderresdetVO : list) {
						// �����Ʒ���Ϊ�հ�SIM����������
						if (orderresdetVO.getRestype() != null
								&& orderresdetVO.getRestype()
										.equals("EMPTYSIM"))
							continue;

						ComsellmidVO comsellmidVO = new ComsellmidVO();
						comsellmidVO.setOrderid(orderid);
						comsellmidVO.setRecid(i++);
						comsellmidVO.setCityid(user.getCityid());
						comsellmidVO.setComresid(orderresdetVO.getComresid());
						comsellmidVO.setBatchno(orderresdetVO.getBatchno());
						comsellmidVO.setWayid(orderresdetVO.getWayid());
						comsellmidVO.setComid("W3" + orderresdetVO.getComid());

						if (null == comMap.get(orderresdetVO.getComid())) {
							ComVO comVO = comBO.doFindByPk(orderresdetVO
									.getComid());
							comMap.put(orderresdetVO.getComid(), comVO
									.getComprice());
						}
						comsellmidVO.setComprice(new Double(comMap.get(
								orderresdetVO.getComid()).longValue() / 100));

						OrdercomcateVO tempOrdercomcateVO = null;
						if (null != ordercomcateDP
								&& null != ordercomcateDP.getDatas()
								&& 0 < ordercomcateDP.getDatas().size()) {
							for (OrdercomcateVO ordercomcateVO : (List<OrdercomcateVO>) ordercomcateDP
									.getDatas()) {
								if (orderresdetVO.getOrdercomtype().equals(
										ordercomcateVO.getOrdercomtype())
										&& orderresdetVO
												.getComcategory()
												.equals(
														ordercomcateVO
																.getComcategory())) {
									tempOrdercomcateVO = ordercomcateVO;
									break;
								}
							}
						}
						if (null == tempOrdercomcateVO)
							throw new JOPException(" �޷���ȡ�ۼ�   "
									+ orderresdetVO.getOrdercomtype() + " : "
									+ orderresdetVO.getComcategory());
						comsellmidVO.setActprice(tempOrdercomcateVO
								.getUnitprice());
						comsellmidVO.setCreatetime(new Date());
						comsellmidBO.doCreate(comsellmidVO);
					}
				}
				log.info("����["+orderid+"]��CRM���ˣ�������Ʒ�����м�����");
			}
			// 7) ����״̬���£��޸Ķ���״̬Ϊ�����,����״̬���ʱ��Ϊ��ǰʱ�䡣
			log.info("����["+orderid+"]����״̬���¿�ʼ");
			orderVO.setOrderstate("FINISHED");
			orderVO.setStatechgtime(new Date());
			// ���û�Ϊ�ӿ�ǰ�Ȱ�wordfid��Ϊ-1
			Object objService = crmService.getServicePort(user.getCityid());
			if (objService == null) {// ����BOSS�ӿ�
				log.info("����["+orderid+"]BOSS���ˣ����ù�����Ϊ��"+bossworkid);
				orderVO.setBossworkfid(bossworkid);
			} else {// ����CRM�ӿ�
				if (GDProdPort.class.isInstance(objService)) {// ��ΪCRM
					log.info("����["+orderid+"]��ΪCRM���ˣ����ù�����Ϊ��1");
					orderVO.setBossworkfid("1");
				} else {
					log.info("����["+orderid+"]����CRM���ˣ����ù�����Ϊ��-1");
					orderVO.setBossworkfid("-1");
				}
			}
			
			// ��������ʱ����£���ʱϵͳʱ��
			orderVO.setRecordtime(new Date());
			log.info("����["+orderid+"]����״̬���½���");
			return orderBO.doUpdate(orderVO);
			// sale message
			// doSmsForSale(orderVO);
		} catch (Exception e) {
			e.printStackTrace();
			if (null != e.getCause()){
				log.error("===========recorded()����===========��������ʧ�ܣ� "+e.getCause().getMessage());
				throw new JOPException(e.getCause().getMessage());
			}else{
				log.error("===========recorded()����===========��������ʧ�ܣ� "+e.getMessage());
				throw new JOPException(e.getMessage());
			}
		}

	}

	/**
	 * ����
	 * 
	 * @param orderid
	 *            �����ɣ�
	 * @param wayid
	 *            ����Ա����ID
	 * @param bossworkid
	 *            boss������
	 * bossworkid��0��-1.  ��̨�������������Ϊ0.�����ĵ���Ϊ-1
	 * CRM���ʵ�ʱ��0 ��ʾCRM�����У�BOSS���ʵ�ʱ��0��ʾͨ���Զ�����������-1����ʾ����ʧ��           
	 *            
	 */
	public OrderVO recorded(String orderid, String wayid,String bossworkid) throws Exception {
		try {
			OrderBO bo = (OrderBO) BOFactory.build(OrderBO.class, user);
			return bo.doRecorded(orderid,bossworkid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("����ʧ�ܣ�" + e.getMessage());
		}
	}

	
	/**
	 * ʷ������2012��5��26�գ����������������޸ģ����������BOSS���˺�CRM���ˣ������Ժ�д���벻Ҫ��ʹ�ã�
	 * BOSS����recordByBoss2(String orderid, String wayid)��recordByBoss(String orderid, String wayid ,String operid)��
	 * CRM����recordByCRM(String orderid, String wayid)��recordByCRM(String orderid, String wayid, String operid)
	 * ����(���ã£ϣӣӡ�CRM�ӿ�)
	 * 
	 * @param orderid
	 *            �����ɣ�
	 * @param wayid
	 *            ����Ա����ID
	 */
	@Deprecated
	public OrderVO recordByBoss(String orderid, String wayid) throws Exception {
		// ���ýӿ�
		// ������Ʒ����BOSS����ʵʱ�ӿڣ��ӿ�Э����ա��½�8.2.1��������Ʒ����BOSS���ˡ�ʵʱ�ӿڡ���
		// ��������ȡ��ǰ����Ա��������������ȡ��ǰ����Ա���ţ��շѷ�ʽȡ�������нɷѷ�ʽ�ֶΣ�
		// ���ȡ��������ʵ�ս���ֶΡ����BOSS���سɹ������ݶ�����Ÿ��¶������е�BOSS�������Ϊ�ӿڷ���ֵ��
		// ���BOSS����ʧ�ܣ����ݶ�����Ÿ��¶������е�BOSS�������Ϊ��-1������עΪ��BOSS����ʧ�ܡ���
		OrderBO bo = (OrderBO) BOFactory.build(OrderBO.class, user);
		OrderVO orderVO = null;
		String portname = "BOSS";
		log.info("recordByBoss()��ʼ");
		try {
			orderVO = bo.doFindByPk(orderid);
			// ��ֹ���ݱ���ѧ������ addby yde
			String actamt = "";
			DecimalFormat df = new DecimalFormat("0");
			if (orderVO.getActamt() != null) {
				actamt = df.format(orderVO.getActamt() * 100);
			}

			ICRMService crmService = new CRMService();
			Object objService = crmService.getServicePort(user.getCityid());
			IncomeAccountResult result1 = null;

			int retcode = -1;
			String retMsg = "";
			if (objService == null) {// ����BOSS�ӿ�
				BossIAO bossIAO = new BossIAO();
				IncomeAccountDataPack data1 = new IncomeAccountDataPack();
				data1.setWayid(wayid);
				data1.setPbossNo(orderid);
				data1.setOprcode(user.getOprcode());

				data1.setFeeStr(actamt);// ���͵ĵ�λ�ǣ��֣�
				ChargeData cd = new ChargeData();

				cd.setChargeType(orderVO.getPaytype());
				cd.setMoney(actamt);
				cd.setPosNo(ChargeData.CHARGE_TYPE_POS.equals(orderVO
						.getPaytype()) ? orderVO.getPosstream() : "");
				data1.setChargeData(cd);
				log.info("bossIAO.incomeAccount()��ʼ");
				result1 = bossIAO.incomeAccount(data1, user.getCityid());
				log.info("bossIAO.incomeAccount()����");
				if (IncomeAccountResult.RET_TYPE_SUSS.equals(result1.getRet())) {
					orderVO.setBossworkfid(result1.getBossNo());
					orderVO.setMemo(portname + "���ʳɹ�");
					return bo.doUpdate(orderVO);
					// sale for message .
					// doSmsForSale(orderVO);
				} else {
					log.error("���� :" + orderid + "����ʱ" + portname + "����û�з��سɹ�");
					String msg = result1.getRet() + "-" + result1.getExplain();
					if (IncomeAccountResult.RET_TYPE_NO_EXIST.equals(result1
							.getRet()))
						msg = result1.getRet() + "-" + result1.getExplain()
								+ "[δ�ҵ�������Ӧ����Ʒ��Դ]";
					if (IncomeAccountResult.RET_TYPE_FAIL.equals(result1
							.getRet()))
						msg = result1.getRet() + "-" + result1.getExplain();
//					�ӿڵ���ʧ�ܺ����������������
					bo.doSendFailInfo(orderid,orderVO.getCountyid());
					throw new Exception(msg);
				}
			} else {// ����CRM�ӿ�
				if (GDProdPort.class.isInstance(objService)) {// ��ΪCRM
					log.info("===============��Ϊ���˿�ʼ================");
					GDProdPort service = (GDProdPort) objService;
					portname = "CRM";
					Orderinreq orderinreq = new Orderinreq();// ��������

					// д��Ϣͷ
					log.info("����["+orderid+"] д��Ϣͷ��ʼ");
					Msgreqheader msgreqheader = new Msgreqheader();
					String processCode = "orderin";
					String reqTime = PublicUtils.formatUtilDate(new Date(),
							"yyyyMMddHHmmss");
					String reqSeq = ""+System.currentTimeMillis();
					String routeType = "0";
					String routeValue = CityMappingUtil.getCityNo(user
							.getCityid());
					String menuid = "PBOSS";
					String perifyCode = "";
					String unicontact = "";
					String testflag = "0";
					String operatorid = user.getOprcode();
					String channelid = "bsacComs";
					String unitid = channelid;
					msgreqheader = CRMServiceUtil.getMsgreqheader(menuid,
							processCode, perifyCode, reqTime, reqSeq,
							unicontact, testflag, routeType, routeValue,
							operatorid, channelid, unitid);
					orderinreq.setMsgreqheader(msgreqheader);
					log.info("����["+orderid+"] д��Ϣͷ���");
					Msgbody msgboby = new Msgbody();// ��Ϣ��
					Orderdetlist orderdetlist = new Orderdetlist();
					Orderdet orderdet = null;
					// ��װ��������
					log.info("����["+orderid+"] ��װ�������ݿ�ʼ");
					Orderresdet orderresdetBO = (OrderresdetBO) BOFactory
							.build(OrderresdetBO.class, user);
					OrderresdetDBParam orderresParam = new OrderresdetDBParam();
					orderresParam.setDataOnly(true);
					orderresParam.set_pagesize("0");
					orderresParam.set_se_orderid(orderid);
					List<OrderresdetVO> orderreList = orderresdetBO.doQuery(
							orderresParam).getDatas();// ��ȡ������Դ��ϸ
					for (OrderresdetVO vo : orderreList) {
						 if(!"EMPTYSIM".equals(vo.getRestype())){
							 orderdet = new Orderdet();
								BeanUtils.copyProperties(orderdet, vo);
								// orderdet.setComid("W3"+orderdet.getComid());
								orderdet.setComid("" + orderdet.getComid());
								if (vo.getComprice() != null) {
									orderdet.setComprice(df
											.format(vo.getComprice() * 100));
								}
								if (vo.getActprice() != null) {
									orderdet.setActprice(df
											.format(vo.getActprice() * 100));
								}
								orderdetlist.getOrderdet().add(orderdet);
						 }
					}
					log.info("=======�����ţ�" + orderid + "========��ϸ������"
							+ orderdetlist.getOrderdet().size()
							+ "================");
					msgboby.setOrderdetlist(orderdetlist);// ��������

					msgboby.setOrderid(orderid);// �������
					msgboby.setSumamt(actamt);// �����ܷ���
					log.info("����["+orderid+"] �����ܷ��ã�"+actamt);
					// ��װ�շѷ�ʽ��Ϣ�б�
					Paytypeinfolist paytypeinfolist = new Paytypeinfolist();// �շѷ�ʽ��Ϣ�б�
					Paytypeinfo paytypeinfo = new Paytypeinfo();// �շѷ�ʽ��
					paytypeinfo.setPaytype(orderVO.getPaytype());// �շѷ�ʽ
					paytypeinfo.setActamt(actamt);// ʵ�ս��
					paytypeinfo.setPosstream(ChargeData.CHARGE_TYPE_POS
							.equals(orderVO.getPaytype()) ? orderVO
							.getPosstream() : "");// POS������ˮ��
					paytypeinfolist.getPaytypeinfo().add(paytypeinfo);
					msgboby.setPaytypeinfolist(paytypeinfolist);

					orderinreq.setMsgbody(msgboby);
					log.info("����["+orderid+"] ��װ�����������");
					// �첽��������Ҫ��������
					log.info("����["+orderid+"] ����CRM���˽ӿ���������Ϣ");
					log.info(Object2String.complexObject2Str(orderinreq));
					net.gmcc.ngcrm.Orderinrsp orderinrsp = service.orderin(orderinreq);// ����CRM���˽ӿڣ�������Ϣ
					log.info("����["+orderid+"] ��Ӧ������Ϣ");
					log.info(Object2String.complexObject2Str(orderinrsp));
					retcode = orderinrsp.getMsgrspheader().getRetinfo().getRetcode();
					retMsg = orderinrsp.getMsgrspheader().getRetinfo().getRetmsg();
					log.info("����["+orderid+"] ����CRM���˽ӿڣ������룺"+retcode);
					log.info("����["+orderid+"] ����CRM���˽ӿڣ�������Ϣ:"+retMsg);
					if (0 == retcode) {
						log.info("����["+orderid+"] ����CRM���˽ӿڣ��ɹ�");
						orderVO.setBossworkfid("0");
						bo.doUpdate(orderVO);
					} else {
						log.info("����["+orderid+"] ����CRM���˽ӿڣ�ʧ��");
						throw new Exception(retcode + "-" + retMsg);
					}
					log.info("===============��Ϊ���˽���================");
				} else {// ����CRM
					log.info("---------------�������˿�ʼ----------------");
					net.gmcc.ngcrm.pboss.GDProdPort service = (net.gmcc.ngcrm.pboss.GDProdPort) objService;
					portname = "CRM";
					net.gmcc.ngcrm.pboss.Orderinreq orderinreq = new net.gmcc.ngcrm.pboss.Orderinreq();// ��������

					// д��Ϣͷ
					log.info("����["+orderid+"] д��Ϣͷ��ʼ");
					net.gmcc.ngcrm.pboss.Msgreqheader msgreqheader = new net.gmcc.ngcrm.pboss.Msgreqheader();
					String processCode = "orderin";
					String reqTime = PublicUtils.formatUtilDate(new Date(),
							"yyyyMMddHHmmss");
					String reqSeq = "" + System.currentTimeMillis();
					String routeType = "0";
					String routeValue = CityMappingUtil.getCityNo(user
							.getCityid());
					String menuid = "PBOSS";
					String perifyCode = "";
					String unicontact = "";
					String testflag = "0";
					String operatorid = user.getOprcode();
					String channelid = "bsacComs";
					String unitid = channelid;
					msgreqheader = CRMServiceUtil.getMsgreqheader_CX(menuid,
							processCode, perifyCode, reqTime, reqSeq,
							unicontact, testflag, routeType, routeValue,
							operatorid, channelid, unitid);
					orderinreq.setMsgreqheader(msgreqheader);
					log.info("����["+orderid+"] д��Ϣͷ���");
					net.gmcc.ngcrm.pboss.Orderinreq.Msgbody msgboby = new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody();// ��Ϣ��
					net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist orderdetlist = new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist();
					net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist.Orderdet orderdet = null;
					// ��װ��������
					log.info("����["+orderid+"] ��װ�������ݿ�ʼ");
					Orderresdet orderresdetBO = (OrderresdetBO) BOFactory
							.build(OrderresdetBO.class, user);
					OrderresdetDBParam orderresParam = new OrderresdetDBParam();
					orderresParam.setDataOnly(true);
					orderresParam.set_pagesize("0");
					orderresParam.set_se_orderid(orderid);
					List<OrderresdetVO> orderreList = orderresdetBO.doQuery(
							orderresParam).getDatas();// ��ȡ������Դ��ϸ
					for (OrderresdetVO vo : orderreList) {
						 if(!"EMPTYSIM".equals(vo.getRestype())){
							 orderdet = new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist.Orderdet();
								BeanUtils.copyProperties(orderdet, vo);
								// orderdet.setComid("W3"+orderdet.getComid());
								orderdet.setComid("" + orderdet.getComid());
								if (vo.getComprice() != null) {
									orderdet.setComprice(df
											.format(vo.getComprice() * 100));
								}
								if (vo.getActprice() != null) {
									orderdet.setActprice(df
											.format(vo.getActprice() * 100));
								}
								orderdetlist.getOrderdet().add(orderdet);
						 }
					}
					log.info("=======�����ţ�" + orderid + "========��ϸ������"
							+ orderdetlist.getOrderdet().size()
							+ "================");
					msgboby.setOrderdetlist(orderdetlist);// ��������

					msgboby.setOrderid(orderid);// �������
					msgboby.setSumamt(actamt);// �����ܷ���
					log.info("����["+orderid+"] �����ܷ��ã�"+actamt);
					// ��װ�շѷ�ʽ��Ϣ�б�
					net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist paytypeinfolist = new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist();// �շѷ�ʽ��Ϣ�б�
					net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist.Paytypeinfo paytypeinfo = new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist.Paytypeinfo();// �շѷ�ʽ��
					paytypeinfo.setPaytype(orderVO.getPaytype());// �շѷ�ʽ
					paytypeinfo.setActamt(actamt);// ʵ�ս��
					paytypeinfo.setPosstream(ChargeData.CHARGE_TYPE_POS
							.equals(orderVO.getPaytype()) ? orderVO
							.getPosstream() : "");// POS������ˮ��
					paytypeinfolist.getPaytypeinfo().add(paytypeinfo);
					msgboby.setPaytypeinfolist(paytypeinfolist);

					orderinreq.setMsgbody(msgboby);
					log.info("����["+orderid+"] ��װ�����������");
					// �첽��������Ҫ��������
					log.info("����["+orderid+"] ����CRM���˽ӿ���������Ϣ");
					log.info(Object2String.complexObject2Str(orderinreq));
					net.gmcc.ngcrm.pboss.Orderinrsp orderinrsp = service.orderin(orderinreq);// ����CRM���˽ӿڣ�������Ϣ
					log.info("����["+orderid+"] ��Ӧ������Ϣ");
					log.info(Object2String.complexObject2Str(orderinrsp));
					retcode = orderinrsp.getMsgrspheader().getRetinfo().getRetcode();
					retMsg = orderinrsp.getMsgrspheader().getRetinfo().getRetmsg();
					log.info("����["+orderid+"] ����CRM���˽ӿڣ������룺"+retcode);
					log.info("����["+orderid+"] ����CRM���˽ӿڣ�������Ϣ:"+retMsg);
					if (0 == retcode) {
						log.info("����["+orderid+"] ����CRM���˽ӿڣ��ɹ�");
						orderVO.setBossworkfid("0");
						bo.doUpdate(orderVO);
					} else {
						log.info("����["+orderid+"] ����CRM���˽ӿڣ�ʧ��");
						throw new Exception(retcode + "-" + retMsg);
					}
					log.info("---------------�������˽���----------------");
				}
			}

			log.info("recordByBoss()����");
			// successOrders = tmp;
			return orderVO;

		} catch (Exception e) {
			LoggerUtils.error(e, log);
			orderVO.setBossworkfid("-1");
			String errMsg = e.getMessage();
			if (errMsg.length() >= 200)
				errMsg = errMsg.substring(0, 200);
			orderVO.setMemo(portname + "����ʧ��(" + errMsg + ")");
			bo.doUpdate(orderVO);

			throw new BusinessException(portname + "���ʴ���ʧ�ܣ�" + e.getMessage(),
					e);
		}
	}
	
	/**
	 * BOSS����
	 */
	public OrderVO recordByBoss2(String orderid, String wayid) throws Exception{
		return this.recordByBoss(orderid, wayid , null);
	}
	
	//��BOSS����
	public OrderVO recordByBoss(String orderid, String wayid ,String operid) throws Exception{
		// ���ýӿ�
		// ������Ʒ����BOSS����ʵʱ�ӿڣ��ӿ�Э����ա��½�8.2.1��������Ʒ����BOSS���ˡ�ʵʱ�ӿڡ���
		// ��������ȡ��ǰ����Ա��������������ȡ��ǰ����Ա���ţ��շѷ�ʽȡ�������нɷѷ�ʽ�ֶΣ�
		// ���ȡ��������ʵ�ս���ֶΡ����BOSS���سɹ������ݶ�����Ÿ��¶������е�BOSS�������Ϊ�ӿڷ���ֵ��
		// ���BOSS����ʧ�ܣ����ݶ�����Ÿ��¶������е�BOSS�������Ϊ��-1������עΪ��BOSS����ʧ�ܡ���
		OrderBO bo = (OrderBO) BOFactory.build(OrderBO.class, user);
		OrderVO orderVO = null;
		String portname = "BOSS";
		log.info("recordByBoss()��ʼ");
		try {
			orderVO = bo.doFindByPk(orderid);
			// ��ֹ���ݱ���ѧ������ addby yde
			String actamt = "";
			DecimalFormat df = new DecimalFormat("0");
			if (orderVO.getActamt() != null) {
				actamt = df.format(orderVO.getActamt() * 100);
			}
			IncomeAccountResult result1 = null;

			// ����BOSS�ӿ�
			BossIAO bossIAO = new BossIAO();
			IncomeAccountDataPack data1 = new IncomeAccountDataPack();
			data1.setWayid(wayid);
			data1.setPbossNo(orderid);
			if(operid!=null && !"".equals(operid.trim())){
				data1.setOprcode(operid);
			}else{
				data1.setOprcode(user.getOprcode());
			}

			data1.setFeeStr(actamt);// ���͵ĵ�λ�ǣ��֣�
			ChargeData cd = new ChargeData();

			cd.setChargeType(orderVO.getPaytype());
			cd.setMoney(actamt);
			cd.setPosNo(ChargeData.CHARGE_TYPE_POS.equals(orderVO.getPaytype()) ? orderVO.getPosstream() : "");
			data1.setChargeData(cd);
			log.info("bossIAO.incomeAccount()��ʼ");
			result1 = bossIAO.incomeAccount(data1, user.getCityid());
			log.info("bossIAO.incomeAccount()����");
			if (IncomeAccountResult.RET_TYPE_SUSS.equals(result1.getRet())) {
				orderVO.setBossworkfid(result1.getBossNo());
				orderVO.setMemo(portname + "���ʳɹ�");
				bo.doUpdate(orderVO);
				// sale for message .
				// doSmsForSale(orderVO);
			} else {
				log.error("���� :" + orderid + "����ʱ" + portname + "����û�з��سɹ�");
				String msg = result1.getRet() + "-" + result1.getExplain();
				if (IncomeAccountResult.RET_TYPE_NO_EXIST.equals(result1
						.getRet()))
					msg = result1.getRet() + "-" + result1.getExplain()
							+ "[δ�ҵ�������Ӧ����Ʒ��Դ]";
				if (IncomeAccountResult.RET_TYPE_FAIL.equals(result1.getRet()))
					msg = result1.getRet() + "-" + result1.getExplain();
				// �ӿڵ���ʧ�ܺ����������������
				bo.doSendFailInfo(orderid, orderVO.getCountyid());
				throw new Exception(msg);
			}

			log.info("recordByBoss()����");
			return orderVO;
		} catch (Exception e) {
			LoggerUtils.error(e, log);
			orderVO.setBossworkfid("-1");
			String errMsg = e.getMessage();
			if (errMsg.length() >= 200)
				errMsg = errMsg.substring(0, 200);
			orderVO.setMemo(portname + "����ʧ��(" + errMsg + ")");
			bo.doUpdate(orderVO);

			throw new BusinessException(portname + "���ʴ���ʧ�ܣ�" + e.getMessage(),e);
		}
	}
	
	/**
	 * CRM����
	 * @param orderid
	 * @param wayid
	 * @return
	 * @throws Exception
	 */
	public OrderVO recordByCRM(String orderid, String wayid) throws Exception {
		return recordByCRM(orderid, wayid, null);
	}
	
	public OrderVO recordByCRM(String orderid, String wayid, String operid) throws Exception{
		OrderBO bo = (OrderBO) BOFactory.build(OrderBO.class, user);
		OrderVO orderVO = null;
		String portname = "CRM";
		log.info("����["+orderid+"]recordByCRM()��ʼ");
		try {
			orderVO = bo.doFindByPk(orderid);
			log.info("����["+orderid+"] ���ݶ����Ż�ȡ��������¼");
			// ��ֹ���ݱ���ѧ������ addby yde
			String actamt = "";
			DecimalFormat df = new DecimalFormat("0");
			if (orderVO.getActamt() != null) {
				actamt = df.format(orderVO.getActamt() * 100);
			}

			ICRMService crmService = new CRMService();
			Object objService = crmService.getServicePort(user.getCityid());
			int retcode = -1;
			String retMsg = "";
			 // ����CRM�ӿ�
			if (GDProdPort.class.isInstance(objService)) {// ��ΪCRM
				log.info("����["+orderid+"]===============��Ϊ���˿�ʼ================");
				
				GDProdPort service = (GDProdPort) objService;
				Orderinreq orderinreq = new Orderinreq();// ��������

				// д��Ϣͷ
				log.info("����["+orderid+"] д��Ϣͷ��ʼ");
				Msgreqheader msgreqheader = new Msgreqheader();
				String processCode = "orderin";
				String reqTime = PublicUtils.formatUtilDate(new Date(),
						"yyyyMMddHHmmss");
				String reqSeq = "" + System.currentTimeMillis();
				String routeType = "0";
				String routeValue = CityMappingUtil.getCityNo(user.getCityid());
				String menuid = "PBOSS";
				String perifyCode = "";
				String unicontact = "";
				String testflag = "0";
				String operatorid = null;
				if(operid!=null && !"".equals(operid.trim())){
					operatorid = operid;
				}else{
					operatorid = user.getOprcode();
				}
				String channelid = "bsacComs";
				String unitid = channelid;
				msgreqheader = CRMServiceUtil.getMsgreqheader(menuid,
						processCode, perifyCode, reqTime, reqSeq, unicontact,
						testflag, routeType, routeValue, operatorid, channelid,
						unitid);
				orderinreq.setMsgreqheader(msgreqheader);
				log.info("����["+orderid+"] д��Ϣͷ���");
				Msgbody msgboby = new Msgbody();// ��Ϣ��
				Orderdetlist orderdetlist = new Orderdetlist();
				Orderdet orderdet = null;
				// ��װ��������
				log.info("����["+orderid+"] ��װ�������ݿ�ʼ");
				Orderresdet orderresdetBO = (OrderresdetBO) BOFactory.build(
						OrderresdetBO.class, user);
				OrderresdetDBParam orderresParam = new OrderresdetDBParam();
				orderresParam.setDataOnly(true);
				orderresParam.set_pagesize("0");
				orderresParam.set_se_orderid(orderid);
				List<OrderresdetVO> orderreList = orderresdetBO.doQuery(
						orderresParam).getDatas();// ��ȡ������Դ��ϸ
				for (OrderresdetVO vo : orderreList) {
					if (!"EMPTYSIM".equals(vo.getRestype())) {
						orderdet = new Orderdet();
						BeanUtils.copyProperties(orderdet, vo);
						// orderdet.setComid("W3"+orderdet.getComid());
						orderdet.setComid("" + orderdet.getComid());
						if (vo.getComprice() != null) {
							orderdet.setComprice(df
									.format(vo.getComprice() * 100));
						}
						if (vo.getActprice() != null) {
							orderdet.setActprice(df
									.format(vo.getActprice() * 100));
						}
						orderdetlist.getOrderdet().add(orderdet);
					}else{
						orderdet = new Orderdet();
						BeanUtils.copyProperties(orderdet, vo);
						// orderdet.setComid("W3"+orderdet.getComid());
						orderdet.setComid("" + orderdet.getComid());
						orderdet.setComresid(vo.getEmptyno());//����ǿհ�SIM�����ѿտ����кŷ�װ����Ʒ��Դ���						
						if (vo.getComprice() != null) {
							orderdet.setComprice(df
									.format(vo.getComprice() * 100));
						}
						if (vo.getActprice() != null) {
							orderdet.setActprice(df
									.format(vo.getActprice() * 100));
						}
						orderdetlist.getOrderdet().add(orderdet);
					}
				}
				log.info("=======�����ţ�" + orderid + "========��ϸ������"
						+ orderdetlist.getOrderdet().size()
						+ "================");
				msgboby.setOrderdetlist(orderdetlist);// ��������

				msgboby.setOrderid(orderid);// �������
				msgboby.setSumamt(actamt);// �����ܷ���
				log.info("����["+orderid+"] �����ܷ��ã�"+actamt);

				// ��װ�շѷ�ʽ��Ϣ�б�
				Paytypeinfolist paytypeinfolist = new Paytypeinfolist();// �շѷ�ʽ��Ϣ�б�
				Paytypeinfo paytypeinfo = new Paytypeinfo();// �շѷ�ʽ��
				paytypeinfo.setPaytype(orderVO.getPaytype());// �շѷ�ʽ
				paytypeinfo.setActamt(actamt);// ʵ�ս��
				paytypeinfo.setPosstream(ChargeData.CHARGE_TYPE_POS
						.equals(orderVO.getPaytype()) ? orderVO.getPosstream()
						: "");// POS������ˮ��
				paytypeinfolist.getPaytypeinfo().add(paytypeinfo);
				msgboby.setPaytypeinfolist(paytypeinfolist);

				orderinreq.setMsgbody(msgboby);
				log.info("����["+orderid+"] ��װ�����������");
				// �첽��������Ҫ��������
				log.info("����["+orderid+"] ����CRM���˽ӿ���������Ϣ");
				log.info(Object2String.complexObject2Str(orderinreq));
				net.gmcc.ngcrm.Orderinrsp orderinrsp = service.orderin(orderinreq);// ����CRM���˽ӿڣ�������Ϣ
				log.info("����["+orderid+"] ��Ӧ������Ϣ");
				log.info(Object2String.complexObject2Str(orderinrsp));
				retcode = orderinrsp.getMsgrspheader().getRetinfo().getRetcode();
				retMsg = orderinrsp.getMsgrspheader().getRetinfo().getRetmsg();
				log.info("����["+orderid+"] ����CRM���˽ӿڣ������룺"+retcode);
				log.info("����["+orderid+"] ����CRM���˽ӿڣ�������Ϣ:"+retMsg);
				if (0 == retcode) {
					log.info("����["+orderid+"] ����CRM���˽ӿڣ��ɹ�");
					orderVO.setBossworkfid("0");
					bo.doUpdate(orderVO);
				} else {
					log.info("����["+orderid+"] ����CRM���˽ӿڣ�ʧ��");
					throw new Exception(retcode + "-" + retMsg);
				}
				log.info("===============��Ϊ���˽���================");
			} else {// ����CRM
				log.info("---------------�������˿�ʼ----------------");
				net.gmcc.ngcrm.pboss.GDProdPort service = (net.gmcc.ngcrm.pboss.GDProdPort) objService;
				portname = "CRM";
				net.gmcc.ngcrm.pboss.Orderinreq orderinreq = new net.gmcc.ngcrm.pboss.Orderinreq();// ��������

				// д��Ϣͷ
				log.info("����["+orderid+"] д��Ϣͷ��ʼ");
				net.gmcc.ngcrm.pboss.Msgreqheader msgreqheader = new net.gmcc.ngcrm.pboss.Msgreqheader();
				String processCode = "orderin";
				String reqTime = PublicUtils.formatUtilDate(new Date(),
						"yyyyMMddHHmmss");
				String reqSeq = "" + System.currentTimeMillis();
				String routeType = "0";
				String routeValue = CityMappingUtil.getCityNo(user
						.getCityid());
				String menuid = "PBOSS";
				String perifyCode = "";
				String unicontact = "";
				String testflag = "0";
				String operatorid = user.getOprcode();
				String channelid = "bsacComs";
				String unitid = channelid;
				msgreqheader = CRMServiceUtil.getMsgreqheader_CX(menuid,
						processCode, perifyCode, reqTime, reqSeq,
						unicontact, testflag, routeType, routeValue,
						operatorid, channelid, unitid);
				orderinreq.setMsgreqheader(msgreqheader);
				log.info("����["+orderid+"] д��Ϣͷ���");
				
				net.gmcc.ngcrm.pboss.Orderinreq.Msgbody msgboby = new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody();// ��Ϣ��
				net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist orderdetlist = new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist();
				net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist.Orderdet orderdet = null;
				// ��װ��������
				log.info("����["+orderid+"] ��װ�������ݿ�ʼ");
				Orderresdet orderresdetBO = (OrderresdetBO) BOFactory
						.build(OrderresdetBO.class, user);
				OrderresdetDBParam orderresParam = new OrderresdetDBParam();
				orderresParam.setDataOnly(true);
				orderresParam.set_pagesize("0");
				orderresParam.set_se_orderid(orderid);
				List<OrderresdetVO> orderreList = orderresdetBO.doQuery(
						orderresParam).getDatas();// ��ȡ������Դ��ϸ
				for (OrderresdetVO vo : orderreList) {
					 if(!"EMPTYSIM".equals(vo.getRestype())){
						 orderdet = new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist.Orderdet();
							BeanUtils.copyProperties(orderdet, vo);
							// orderdet.setComid("W3"+orderdet.getComid());
							orderdet.setComid("" + orderdet.getComid());
							if (vo.getComprice() != null) {
								orderdet.setComprice(df
										.format(vo.getComprice() * 100));
							}
							if (vo.getActprice() != null) {
								orderdet.setActprice(df
										.format(vo.getActprice() * 100));
							}
							orderdetlist.getOrderdet().add(orderdet);
					 }
				}
				log.info("=======�����ţ�" + orderid + "========��ϸ������"
						+ orderdetlist.getOrderdet().size()
						+ "================");
				msgboby.setOrderdetlist(orderdetlist);// ��������

				msgboby.setOrderid(orderid);// �������
				msgboby.setSumamt(actamt);// �����ܷ���
				log.info("����["+orderid+"] �����ܷ��ã�"+actamt);
				// ��װ�շѷ�ʽ��Ϣ�б�
				net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist paytypeinfolist = new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist();// �շѷ�ʽ��Ϣ�б�
				net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist.Paytypeinfo paytypeinfo = new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist.Paytypeinfo();// �շѷ�ʽ��
				paytypeinfo.setPaytype(orderVO.getPaytype());// �շѷ�ʽ
				paytypeinfo.setActamt(actamt);// ʵ�ս��
				paytypeinfo.setPosstream(ChargeData.CHARGE_TYPE_POS
						.equals(orderVO.getPaytype()) ? orderVO
						.getPosstream() : "");// POS������ˮ��
				paytypeinfolist.getPaytypeinfo().add(paytypeinfo);
				msgboby.setPaytypeinfolist(paytypeinfolist);

				orderinreq.setMsgbody(msgboby);
				log.info("����["+orderid+"] ��װ�����������");
				// �첽��������Ҫ��������
				log.info("����["+orderid+"] ����CRM���˽ӿ���������Ϣ");
				log.info(Object2String.complexObject2Str(orderinreq));
				net.gmcc.ngcrm.pboss.Orderinrsp orderinrsp = service.orderin(orderinreq);// ����CRM���˽ӿڣ�������Ϣ
				log.info("����["+orderid+"] ��Ӧ������Ϣ");
				log.info(Object2String.complexObject2Str(orderinrsp));
				retcode = orderinrsp.getMsgrspheader().getRetinfo().getRetcode();
				retMsg = orderinrsp.getMsgrspheader().getRetinfo().getRetmsg();
				log.info("����["+orderid+"] ����CRM���˽ӿڣ������룺"+retcode);
				log.info("����["+orderid+"] ����CRM���˽ӿڣ�������Ϣ:"+retMsg);
				if (0 == retcode) {
					log.info("����["+orderid+"] ����CRM���˽ӿڣ��ɹ�");
					orderVO.setBossworkfid("0");
					bo.doUpdate(orderVO);
				} else {
					log.info("����["+orderid+"] ����CRM���˽ӿڣ�ʧ��");
					throw new Exception(retcode + "-" + retMsg);
				}
				log.info("---------------�������˽���----------------");
			}			

			log.info("recordByCRM()����");
			return orderVO;
		} catch (Exception e) {
			LoggerUtils.error(e, log);
			orderVO.setBossworkfid("-1");
			String errMsg = e.getMessage();
			if (errMsg.length() >= 200)
				errMsg = errMsg.substring(0, 200);
			orderVO.setMemo(portname + "����ʧ��(" + errMsg + ")");
			bo.doUpdate(orderVO);
			log.info(portname +"����["+orderid+"] ���ʴ���ʧ�ܣ�"+ e.getMessage());
			throw new BusinessException(portname + "���ʴ���ʧ�ܣ�" + e.getMessage(),e);
		}
	}
	
	public void doSmsForSale(OrderVO orderVO) throws Exception {
//		���BOSS���سɹ����Ҷ�����Դ��ϸFX_SW_ORDERRESDET�����׿����ݣ���Դ���Ϊ�׿����������ۿ�֪ͨ���ţ����򲻴���
		Orderresdet  orderdet = (OrderresdetBO) BOFactory.build(OrderresdetBO.class, user);
		OrderresdetDBParam orderdetList=new OrderresdetDBParam();
		orderdetList.set_se_orderid(orderVO.getOrderid());
		orderdetList.set_se_restype("COMRESSMP");
		
		
		if(orderdet.doQuery(orderdetList).getRowCount()>0)
		{
			//����
			String desc=null;
			//�ֻ�����
			String officetel=null;
			//��ѯ����ģ���
			Smstmpl  smstmpl = (SmstmplBO) BOFactory.build(SmstmplBO.class, user);
			SmstmplVO smstmplVO=null;
			smstmplVO=smstmpl.doFindByPk("FX_SALE_NOTICE");
			if(smstmplVO!=null && "1".equals(smstmplVO.getSstate()))
			{
				//��ѯ�ֻ�����
				Employee  employee = (EmployeeBO) BOFactory.build(EmployeeBO.class, user);
				EmployeeDBParam employeeList=new EmployeeDBParam();
				employeeList.set_se_wayid(orderVO.getWayid());
				employeeList.set_ne_empstatus("0");
				employeeList.set_ne_isnet("1");
				DataPackage dp= employee.doQuery(employeeList);
				if(dp.getRowCount()>0)
				{
					Iterator it=dp.getDatas().iterator();
					if(it.hasNext())
					{
						EmployeeVO empVO=(EmployeeVO)it.next();
						if(empVO.getOfficetel()!=null)
						{
							officetel=empVO.getOfficetel();
							OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class, user);
							OrderresdetDBParam queryParam=new OrderresdetDBParam();
							//ͳ����Ʒ����
							desc= dao.groupbyDet(queryParam,orderVO.getOrderid(),user);
							//�滻����ģ��
							String content=smstmplVO.getScontent();
							Date creTime=orderVO.getCreatetime();
							SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
							String sTime=sm.format(creTime);
							String time[]=StringUtils.splitPreserveAllTokens(sTime,"-");
							content=replace(content,time[0]);
							content=replace(content,time[1]);
							content=replace(content,time[2]);
							content=replace(content,desc);
							//�������ݵ����Ŵ����ͱ�(CH_SMS_WAITREQ)����������ȡ3���������ݺͽ��պ���ȡ�ѻ�ȡ�����ݡ�
							Waitreq  waitreq = (WaitreqBO) BOFactory.build(WaitreqBO.class, user);
							WaitreqVO waitreqVO=new WaitreqVO();
							Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
							String sysparamvalue42=sysparamBO.doFindByID("42", "pboss_fx");
							waitreqVO.setSmstype((short)3);
							waitreqVO.setAreacode(user.getCityid());
							waitreqVO.setCreattime(new java.util.Date());
							waitreqVO.setSendno(sysparamvalue42);
							waitreqVO.setDealcount(new Short("0"));
							waitreqVO.setIssuccess(new Short("0"));
							waitreqVO.setMessage(content);
							waitreqVO.setRecno(officetel);
							waitreq.doCreate(waitreqVO);
						}
					}
				}
			}
			
		}
	}
	/**
	 * boss ��������
	 * 
	 * @param orders
	 *            �����༭��֧�ֶ����
	 * @param wayid
	 *            ��������
	 * @return String[0]:���ͳɹ��Ķ����༭ �����֮���ö���[��]�ֿ�����String[1]����ʧ�ܵĶ����༭
	 *         �����֮���ö���[��]�ֿ���
	 */
	public String[] bossSupplyRecorded(String[] orders, String wayid)
			throws Exception {
		String[] result = new String[2];
		String successOrders = "";
		String failOrders = "";
		OrderBO bo = (OrderBO) BOFactory.build(OrderBO.class, user);
		IncomeAccountResult result1 = null;
		String portname="BOSS";

		log.info("bossSupplyRecorded()��ʼ");
		for (String orderid : orders) {
			OrderVO orderVO = null;
			
			try {
				result1 = null;
				orderVO = bo.doFindByPk(orderid);
				//��ֹ���ݱ���ѧ������ addby yde
				String actamt = "";
				DecimalFormat df = new DecimalFormat("0");
				if(orderVO.getActamt()!=null){
					actamt = df.format(orderVO.getActamt() * 100);
				}
				
				ICRMService crmService=new CRMService();
				Object objService=crmService.getServicePort(user.getCityid());
				int retcode = -1;
				String retMsg = "";
				if(objService==null){//����BOSS�ӿ�
					portname="BOSS";
					BossIAO bossIAO = new BossIAO();
					IncomeAccountDataPack data1 = new IncomeAccountDataPack();
					data1.setWayid(wayid);
					data1.setPbossNo(orderid);
					data1.setOprcode(user.getOprcode());
					
					
					data1.setFeeStr(actamt);// ���͵ĵ�λ�ǣ��֣�
					ChargeData cd = new ChargeData();
	
					cd.setChargeType(orderVO.getPaytype());
					cd.setMoney(actamt);
					cd.setPosNo(ChargeData.CHARGE_TYPE_POS.equals(orderVO
							.getPaytype()) ? orderVO.getPosstream() : "");
					data1.setChargeData(cd);
					
					log.info("bossIAO.incomeAccount()��ʼ");
					result1 = bossIAO.incomeAccount(data1, user.getCityid());
					log.info("bossIAO.incomeAccount()����");
					if (IncomeAccountResult.RET_TYPE_SUSS.equals(result1.getRet())) {
						successOrders += "," + orderid;
						orderVO.setBossworkfid(result1.getBossNo());
						orderVO.setMemo("����"+portname+"�ɹ�");
						bo.doUpdate(orderVO);
					} else {
						log.error(" ���� :" + orderid + "����"+portname+" ����ʱ"+portname+"����û�з��سɹ�");
						String msg = result1.getRet() + "-" + result1.getExplain();
						if (IncomeAccountResult.RET_TYPE_NO_EXIST.equals(result1
								.getRet()))
							msg += result1.getRet() + "-" + result1.getExplain()
									+ "[δ�ҵ�������Ӧ����Ʒ��Դ]";
						if (IncomeAccountResult.RET_TYPE_FAIL.equals(result1
								.getRet()))
							msg += result1.getRet() + "-" + result1.getExplain();
						throw new Exception(msg);
					}
				}else{//����CRM�ӿ�
					if(GDProdPort.class.isInstance(objService)){//��ΪCRM
						log.info("===============��Ϊ�������˿�ʼ================");
						GDProdPort service = (GDProdPort)objService;
						portname="CRM";
						Orderinreq orderinreq=new Orderinreq();//��������
						
						//д��Ϣͷ
						log.info("����["+orderid+"] д��Ϣͷ��ʼ");
						Msgreqheader msgreqheader = new Msgreqheader();
						String processCode = "orderin";
						String reqTime = PublicUtils.formatUtilDate(new Date(),"yyyyMMddHHmmss");
						String reqSeq = "" + System.currentTimeMillis();
						String routeType = "0";
						String routeValue = CityMappingUtil.getCityNo(user.getCityid());
						String menuid = "PBOSS";
						String perifyCode = "";
						String unicontact = "";
						String testflag = "0";
						String operatorid = user.getOprcode();
						String channelid = "bsacComs";	
						String unitid = channelid;
						msgreqheader = CRMServiceUtil.getMsgreqheader(menuid, processCode, perifyCode, 
								reqTime, reqSeq, unicontact, testflag, routeType, 
								routeValue, operatorid, channelid, unitid);
						orderinreq.setMsgreqheader(msgreqheader);
						log.info("����["+orderid+"] д��Ϣͷ���");
						Msgbody msgboby=new Msgbody();//��Ϣ��
						Orderdetlist orderdetlist=new Orderdetlist();
						Orderdet orderdet=null;
						//��װ��������
						log.info("����["+orderid+"] ��װ�������ݿ�ʼ");
						Orderresdet orderresdetBO = (OrderresdetBO) BOFactory.build(OrderresdetBO.class, user);
						 OrderresdetDBParam  orderresParam=new OrderresdetDBParam();
						 orderresParam.setDataOnly(true);
						 orderresParam.set_pagesize("0");
						 orderresParam.set_se_orderid(orderid);
						 List<OrderresdetVO> orderreList=orderresdetBO.doQuery(orderresParam).getDatas();//��ȡ������Դ��ϸ
						 for(OrderresdetVO vo:orderreList){
							 if(!"EMPTYSIM".equals(vo.getRestype())){
							 orderdet=new Orderdet();
							 BeanUtils.copyProperties(orderdet, vo);
							 //orderdet.setComid("W3"+orderdet.getComid());
							 orderdet.setComid(""+orderdet.getComid());
							 if(vo.getComprice()!=null){
								 orderdet.setComprice(df.format(vo.getComprice() * 100));
							 }
							 if(vo.getActprice()!=null){
								 orderdet.setActprice(df.format(vo.getActprice() * 100));
							 }
							 orderdetlist.getOrderdet().add(orderdet);
							 }
						 }
						 log.info("=======�����ţ�"+orderid+"========��ϸ������"+orderdetlist.getOrderdet().size()+"================");
						 msgboby.setOrderdetlist(orderdetlist);//��������
						 
						msgboby.setOrderid(orderid);//�������
						msgboby.setSumamt(actamt);//�����ܷ���
						log.info("����["+orderid+"] �����ܷ��ã�"+actamt);
						//��װ�շѷ�ʽ��Ϣ�б�
						Paytypeinfolist paytypeinfolist=new Paytypeinfolist();//�շѷ�ʽ��Ϣ�б�
						Paytypeinfo paytypeinfo=new Paytypeinfo();//�շѷ�ʽ��
						paytypeinfo.setPaytype(orderVO.getPaytype());//�շѷ�ʽ
						paytypeinfo.setActamt(actamt);//ʵ�ս��
						paytypeinfo.setPosstream(ChargeData.CHARGE_TYPE_POS.equals(orderVO
								.getPaytype()) ? orderVO.getPosstream() : "");//POS������ˮ��
						paytypeinfolist.getPaytypeinfo().add(paytypeinfo);
						msgboby.setPaytypeinfolist(paytypeinfolist);
						
						orderinreq.setMsgbody(msgboby);
						log.info("����["+orderid+"] ��װ�����������");
						// �첽��������Ҫ��������
						log.info("����["+orderid+"] ����CRM���˽ӿ���������Ϣ");
						log.info(Object2String.complexObject2Str(orderinreq));
						net.gmcc.ngcrm.Orderinrsp orderinrsp = service.orderin(orderinreq);//����CRM���˽ӿڣ�������Ϣ
						log.info("����["+orderid+"] ��Ӧ������Ϣ");
						log.info(Object2String.complexObject2Str(orderinrsp));
						retcode = orderinrsp.getMsgrspheader().getRetinfo().getRetcode();
						retMsg = orderinrsp.getMsgrspheader().getRetinfo().getRetmsg();
						log.info("����["+orderid+"] ����CRM���˽ӿڣ������룺"+retcode);
						log.info("����["+orderid+"] ����CRM���˽ӿڣ�������Ϣ:"+retMsg);
						if(0 == retcode){
							log.info("����["+orderid+"] ����CRM���˽ӿڣ��ɹ�");
							successOrders += "," + orderid;
							orderVO.setBossworkfid("0");
							orderVO.setMemo(null);
							bo.doUpdate(orderVO);
						}else{
							log.error(" ���� :" + orderid + "����"+portname+" ����ʱ"+portname+"����û�з��سɹ�");
							throw new Exception(retcode+"-"+retMsg);
						}
						log.info("===============��Ϊ�������˽���================");
					}else{//���� CRM
						log.info("---------------���˲������˿�ʼ----------------");
						net.gmcc.ngcrm.pboss.GDProdPort service = (net.gmcc.ngcrm.pboss.GDProdPort)objService;
						portname="CRM";
						net.gmcc.ngcrm.pboss.Orderinreq orderinreq=new net.gmcc.ngcrm.pboss.Orderinreq();//��������
						
						//д��Ϣͷ
						log.info("����["+orderid+"] д��Ϣͷ��ʼ");
						net.gmcc.ngcrm.pboss.Msgreqheader msgreqheader = new net.gmcc.ngcrm.pboss.Msgreqheader();
						String processCode = "orderin";
						String reqTime = PublicUtils.formatUtilDate(new Date(),"yyyyMMddHHmmss");
						String reqSeq = "" + System.currentTimeMillis();
						String routeType = "0";
						String routeValue = CityMappingUtil.getCityNo(user.getCityid());
						String menuid = "PBOSS";
						String perifyCode = "";
						String unicontact = "";
						String testflag = "0";
						String operatorid = user.getOprcode();
						String channelid = "bsacComs";	
						String unitid = channelid;
						msgreqheader = CRMServiceUtil.getMsgreqheader_CX(menuid, processCode, perifyCode, 
								reqTime, reqSeq, unicontact, testflag, routeType, 
								routeValue, operatorid, channelid, unitid);
						orderinreq.setMsgreqheader(msgreqheader);
						log.info("����["+orderid+"] д��Ϣͷ���");
						net.gmcc.ngcrm.pboss.Orderinreq.Msgbody msgboby=new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody();//��Ϣ��
						net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist orderdetlist=new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist();
						net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist.Orderdet orderdet=null;
						//��װ��������
						log.info("����["+orderid+"] ��װ�������ݿ�ʼ");
						Orderresdet orderresdetBO = (OrderresdetBO) BOFactory.build(OrderresdetBO.class, user);
						 OrderresdetDBParam  orderresParam=new OrderresdetDBParam();
						 orderresParam.setDataOnly(true);
						 orderresParam.set_pagesize("0");
						 orderresParam.set_se_orderid(orderid);
						 List<OrderresdetVO> orderreList=orderresdetBO.doQuery(orderresParam).getDatas();//��ȡ������Դ��ϸ
						 for(OrderresdetVO vo:orderreList){
							 if(!"EMPTYSIM".equals(vo.getRestype())){
							 orderdet=new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist.Orderdet();
							 BeanUtils.copyProperties(orderdet, vo);
							 //orderdet.setComid("W3"+orderdet.getComid());
							 orderdet.setComid(""+orderdet.getComid());
							 if(vo.getComprice()!=null){
								 orderdet.setComprice(df.format(vo.getComprice() * 100));
							 }
							 if(vo.getActprice()!=null){
								 orderdet.setActprice(df.format(vo.getActprice() * 100));
							 }
							 orderdetlist.getOrderdet().add(orderdet);
							 
							 }
						 }
						 log.info("=======�����ţ�"+orderid+"========��ϸ������"+orderdetlist.getOrderdet().size()+"================");
						 msgboby.setOrderdetlist(orderdetlist);//��������
						 
						msgboby.setOrderid(orderid);//�������
						msgboby.setSumamt(actamt);//�����ܷ���
						log.info("����["+orderid+"] �����ܷ��ã�"+actamt);
						//��װ�շѷ�ʽ��Ϣ�б�
						net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist paytypeinfolist=new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist();//�շѷ�ʽ��Ϣ�б�
						net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist.Paytypeinfo paytypeinfo=new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist.Paytypeinfo();//�շѷ�ʽ��
						paytypeinfo.setPaytype(orderVO.getPaytype());//�շѷ�ʽ
						paytypeinfo.setActamt(actamt);//ʵ�ս��
						paytypeinfo.setPosstream(ChargeData.CHARGE_TYPE_POS.equals(orderVO
								.getPaytype()) ? orderVO.getPosstream() : "");//POS������ˮ��
						paytypeinfolist.getPaytypeinfo().add(paytypeinfo);
						msgboby.setPaytypeinfolist(paytypeinfolist);
						
						orderinreq.setMsgbody(msgboby);
						log.info("����["+orderid+"] ��װ�����������");
						// �첽��������Ҫ��������
						log.info("����["+orderid+"] ����CRM���˽ӿ���������Ϣ");
						log.info(Object2String.complexObject2Str(orderinreq));
						net.gmcc.ngcrm.pboss.Orderinrsp orderinrsp = service.orderin(orderinreq);//����CRM���˽ӿڣ�������Ϣ
						log.info("����["+orderid+"] ��Ӧ������Ϣ");
						log.info(Object2String.complexObject2Str(orderinrsp));
						retcode = orderinrsp.getMsgrspheader().getRetinfo().getRetcode();
						retMsg = orderinrsp.getMsgrspheader().getRetinfo().getRetmsg();				
						if(0 == retcode){
							log.info("����["+orderid+"] ����CRM���˽ӿڣ��ɹ�");
							successOrders += "," + orderid;
							orderVO.setBossworkfid("0");
							orderVO.setMemo(null);
							bo.doUpdate(orderVO);
						}else{
							log.error(" ���� :" + orderid + "����"+portname+" ����ʱ"+portname+"����û�з��سɹ�");
							throw new Exception(retcode+"-"+retMsg);
						}
						 log.info("---------------���˲������˽���----------------");
					}
					
				}
			} catch (Exception e) {
				failOrders += "," + orderid;
				log.error(" ���� :" + orderid + "����"+portname+" ���˴���ʧ��");
				//e.printStackTrace();
				//ʧ���Ժ��ٲ�ѯһ��,���Ƿ�״̬�Ծ���-1�������-1�����¼���,���򲻶�orderVO��������
				OrderVO pkVO=bo.doFindByPk(orderVO.getOrderid());
				if(pkVO==null)
				{
					throw new Exception("orderid="+orderVO.getOrderid()+"û�в�ѯ����Ӧ��¼");
				}
				try {
					if (orderVO != null) {
						if(pkVO!=null && "-1".equals(pkVO.getBossworkfid()))
						{
						//����������ͬʱ������������,Ϊ-1��ʾû�д���ɹ�,�����һ�˴���ɹ�,�������ٴ�������������¼.
						String errMsg = e.getMessage();
						if (errMsg.length() >= 200)
							errMsg = errMsg.substring(0, 200);
						orderVO.setMemo("����"+portname+"����ʧ��(" + errMsg + ")");
						bo.doUpdate(orderVO);
						}
					}
				} catch (Exception ex) {
					log.error(ex.getMessage());
				}
			}
		}
		log.info("bossSupplyRecorded()����");
		result[0] = successOrders.replaceFirst(",", "");
		result[1] = failOrders.replaceFirst(",", "");
		return result;
	}

	public static void main(String []args)throws Exception{
		String content="���ã�����{YEAR}��{MONTH}��{DAY}�ն�����Ʒ[{COMDESC}]����������׿�����׼�����������Զ������ۡ�";
		String ss="2010$11$01$��Ʒ0 150Ԫ�׿�20��,��Ʒ1 20Ԫ50Ԫ��ֵ��30��,";
		ss=ss.substring(0,ss.length()-1);
		Date dt=new java.util.Date();
		SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
		String sdt=sm.format(dt);
		
		String st[]=StringUtils.splitPreserveAllTokens(ss, "$");
		content=new OrderBO().replace(content,st[0]);
		content=new OrderBO().replace(content,st[1]);
		content=new OrderBO().replace(content,st[2]);
		content=new OrderBO().replace(content,st[3]);
		
	}
	public  String replace(String org,String str)
	{
		
		int start=org.indexOf("{");
		int end=org.indexOf("}");
		org=org.substring(0,start)+str+org.substring(end+1);
		return org;
	}
	// /**2010-03-30 ȥ�� ��ԭ������ǰ̨������������̨���������� Ϊ���еط�������ʱע�ͣ�
	// * �����Զ�����
	// * @param sleepMin ������ʱ�����߷�����
	// * @throws Exception
	// */
	// public void autoProcess(int sleepMin) throws Exception{
	// // ��ѯ���������FX_SW_ORDERTASK����ƥ����Ч��Ϊ��Ч�������������������ߣ�����Խ��������������
	// Ordertask ordertaskBO =
	// (OrdertaskBO)BOFactory.build(OrdertaskBO.class,user);
	// Orderproce orderProceBO =
	// (OrderproceBO)BOFactory.build(OrderproceBO.class,user);
	// ProcessBO processBO = (ProcessBO)BOFactory.build(ProcessBO.class,user);
	// Order orderBO = (OrderBO)BOFactory.build(OrderBO.class,user);
	// OrdertaskDBParam ordertaskParam = new OrdertaskDBParam();
	// ordertaskParam.set_ne_effective("1");
	// DataPackage ordertaskDP = ordertaskBO.doQuery(ordertaskParam);
	// if( null != ordertaskDP && null != ordertaskDP.getDatas() &&
	// 0<ordertaskDP.getDatas().size()){
	// try{
	// for(int i = 0;i<ordertaskDP.getDatas().size();i++){
	// OrdertaskVO ordertaskVO = (OrdertaskVO)ordertaskDP.getDatas().get(i);
	// // 1) ���ݶ�����Ų�ѯ������FX_SW_ORDER������������ݣ����޸Ķ������������Ч��Ϊ��Ч��
	// // ��עΪ��������Ϣ�����ڡ������ش�����һ�����ݣ����������
	// OrderVO orderVO = orderBO.doFindByPk(ordertaskVO.getOrderid());
	// if( null != orderVO){
	// // 2) ���ݶ������̱�źͶ���״̬��ѯ�������̲����FX_RU_ORDERPROCE����ƥ�����״̬Ϊ��ǰ����״̬����������ݣ�
	// // ���޸Ķ������������Ч��Ϊ��Ч����עΪ����ǰ��������һ�������������ش�����һ�����ݣ����������
	// OrderproceDBParam orderproceParam = new OrderproceDBParam();
	// orderproceParam.set_ne_flowid(""+orderVO.getFlowid());
	// orderproceParam.set_se_instate(orderVO.getOrderstate());
	// DataPackage orderproceDP = orderProceBO.doQuery(orderproceParam);
	// if(null != orderproceDP && null != orderproceDP.getDatas() && 0 <
	// orderproceDP.getDatas().size()){
	// try{
	// for(int j = 0;j<orderproceDP.getDatas().size();j++){
	// OrderproceVO orderproceVO = (OrderproceVO)orderproceDP.getDatas().get(j);
	// // 3) ����������账��ģʽΪ�˹������޸Ķ������������Ч��Ϊ��Ч����עΪ����һ���˹������衱�����ش�����һ�����ݣ����������
	// if("MANUAL".equals(orderproceVO.getDismode())){
	// ordertaskVO.setEffective(new Short("0"));
	// ordertaskVO.setMemo("��һ���˹�������");
	// ordertaskBO.doUpdate(ordertaskVO);
	// }else if("AUTO".equals(orderproceVO.getDismode())){
	// // 4) ����������账��ģʽΪ�Զ������ô�����Ըö������д����������ʧ�ܣ����޸Ķ������������Ч��Ϊ��Ч��
	// // ��עΪ��[������������]����ʧ�ܡ����������ɹ����������һ����¼����
	// ProcessVO processVO = processBO.doFindByPk(orderproceVO.getProcessid());
	// try{
	// OrderDeal orderDeal = (OrderDeal)
	// Class.forName(processVO.getClasspath()).newInstance();
	//											
	// boolean result = orderDeal.deal(orderVO,user);
	// if(!result){
	// ordertaskVO.setEffective(new Short("0"));
	// ordertaskVO.setMemo("["+processVO.getProcessname() +"] ����ʧ��");
	// ordertaskBO.doUpdate(ordertaskVO);
	// }
	// }catch(Exception e){
	// ordertaskVO.setEffective(new Short("0"));
	// ordertaskVO.setMemo("["+processVO.getProcessname() +"] ����ʧ��");
	// ordertaskBO.doUpdate(ordertaskVO);
	// log.error(e);
	// }
	// }
	// }
	// }catch(Exception e){
	// log.error(e);
	// }
	//
	// }else{
	// ordertaskVO.setEffective(new Short("0"));
	// ordertaskVO.setMemo("��ǰ��������һ������");
	// ordertaskBO.doUpdate(ordertaskVO);
	// }
	// }else{
	// ordertaskVO.setEffective(new Short("0"));
	// ordertaskVO.setMemo("������Ϣ������");
	// ordertaskBO.doUpdate(ordertaskVO);
	// }
	// }
	// }catch(Exception e){
	// log.error(e);
	// }
	// }else{
	// Thread.sleep(sleepMin*60000);
	// }
	// }

	/**
	 * ��ȡ�������
	 */
	public String doGetOrderId(Date date) throws Exception {
		// TODO Auto-generated method stub
		try {
			OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
			String cityid = user.getCityid();
			String datestr = PublicUtils.formatUtilDate(date, "yyyyMMdd");

			StringBuffer sequence = new StringBuffer(dao.getSequence(
					"FX_SW_ORDER_SEQ").toString());
			int j = sequence.length();
			for (int i = 4; i > j; i--) {
				sequence.insert(0, "0");
			}
			return cityid + datestr + sequence;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
	
	public String doDeletebosssupply(String[] pkItem) throws Exception {
		Order bo = (OrderBO) BOFactory.build(OrderBO.class, user);
		for (int i = 0; i < pkItem.length; i++) {
			OrderVO vo = bo.doFindByPk(pkItem[i]);
			vo.setBossworkfid("0");
			vo.setMemo("�˹�ȷ�������");
			bo.doUpdate(vo);
		}
		return null;
	}

	/**
	 * ��������
	 */
	public String cancleOrder(String[] pkItem, String cancelReason, String cancelDes) throws Exception {
		Order bo = (OrderBO) BOFactory.build(OrderBO.class, user);
		StringBuilder message = new StringBuilder(200);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//����ԭ��[XXX] ʱ��[yyyy-MM-dd HH24:MI:SS]
		//String memo = "["+cancelReason+"] ˵����"+sdf.format(new Date())+cancelDes;
		String memo = "����ԭ��["+cancelReason+"] ʱ��["+sdf.format(new Date())+"]";
		for (int i = 0; i < pkItem.length; i++) {
			try {
				OrderVO vo = bo.doFindByPk(pkItem[i]);
				if(null == vo.getConfirmflag() || "".equals(vo.getConfirmflag())){
					if("��������".equals(cancelReason)){
						vo.setConfirmflag(0);
					}else{
						vo.setConfirmflag(1);
					}
				}
				vo.setMemo(memo);
				bo.doCancle(vo);
			} catch (Exception e) {
				message.append("����[").append(pkItem[i]).append("]").append(
						e.getMessage()).append("\n");
				throw new JOPException(e);
			}
		}
		return message.toString();
	}

	/**
	 * ��������
	 */
	public void doCancle(OrderVO vo) throws Exception {
		try {
			Order bo = (OrderBO) BOFactory.build(OrderBO.class, user);
			if ("CANCEL".equals(vo.getOrderstate()))
				throw new JOPException(" ���� [" + vo.getOrderid()
						+ "] ״̬��Ϊ[����] ���ܽ������ϲ���");
			if ("FINISHED".equals(vo.getOrderstate()))
				throw new JOPException(" ���� [" + vo.getOrderid()
						+ "] ״̬��Ϊ[�����] ���ܽ������ϲ���");
			vo.setOrderstate("CANCEL");

			// ʵʱ���������£����ݶ������еĺ����̱����ѯ������ʵʱ��¼��FX_SW_REALTIMEAMT�����������򲻴�������������������
			Realtimeamt realtimeamtBO = (RealtimeamtBO) BOFactory.build(
					RealtimeamtBO.class, user);
			RealtimeamtDBParam realtimeamtParam = new RealtimeamtDBParam();
			realtimeamtParam.setQueryAll(true);
			realtimeamtParam.setDataOnly(true);
			realtimeamtParam.set_se_wayid(vo.getWayid());
			DataPackage realtimeamtDP = realtimeamtBO.doQuery(realtimeamtParam);
			if (null != realtimeamtDP && null != realtimeamtDP.getDatas()
					&& 0 < realtimeamtDP.getDatas().size()) {
				for (RealtimeamtVO realtimeamtVO : (List<RealtimeamtVO>) realtimeamtDP
						.getDatas()) {
					doOrderRealtimeamtUpdate(vo, realtimeamtVO);
				}
			}
			
			//	�հ�SIM��ʵʱ����������
			//���ݶ������еĺ����̱����ѯ�հ�SIM��������ʵʱ��¼��FX_SW_SIMREALTIMEAMT�����������򲻴���
			//doOrderSimrealtimeamtUpdate
			Simrealtimeamt simrealtimeamtBO = (SimrealtimeamtBO) BOFactory.build(
					SimrealtimeamtBO.class, user);
			SimrealtimeamtDBParam simrealtimeamtParam = new SimrealtimeamtDBParam();
			simrealtimeamtParam.setQueryAll(true);
			simrealtimeamtParam.setDataOnly(true);
			simrealtimeamtParam.set_se_wayid(vo.getWayid());
			DataPackage simrealtimeamtDP = simrealtimeamtBO.doQuery(simrealtimeamtParam);
			if (null != simrealtimeamtDP && null != simrealtimeamtDP.getDatas()
					&& 0 < simrealtimeamtDP.getDatas().size()) {
				for (SimrealtimeamtVO simrealtimeamtVO : (List<SimrealtimeamtVO>) simrealtimeamtDP
						.getDatas()) {
					doOrderSimrealtimeamtUpdate(vo, simrealtimeamtVO);
				}
			}
			
			bo.doUpdate(vo);
			doOrderResRelease(vo.getOrderid());//������Դ�ͷ�
			doDisformCancle(vo.getOrderid());// ���͵�����
		} catch (Exception e) {
			e.printStackTrace();
			throw new JOPException(e);
		}
	}

	/**
	 * ��������--���͵�����
	 */
	private void doDisformCancle(String orderid) throws Exception {
		Disform disformBO = (DisformBO) BOFactory.build(DisformBO.class, user);
		DisformDBParam disformDBParam = new DisformDBParam();
		disformDBParam.set_se_orderid(orderid);
		List<DisformVO> disformList = disformBO.doQuery(disformDBParam)
				.getDatas();
		if (disformList != null) {
			for (DisformVO vo : disformList) {
				// �����͵�״̬�޸�Ϊ�����ϡ���
				vo.setDisstate("CANCEL");
				disformBO.doUpdate(vo);
			}
		}

	}

	/**
	 * ��������ʱ��ȥ����Ӧ��ʵʱ�������������
	 * 
	 * @param orderid
	 *            �������
	 * @param realtimeamtVOʵʱ����
	 * @throws Exception
	 */
	private void doOrderRealtimeamtUpdate(OrderVO orderVO,
			RealtimeamtVO realtimeamtVO) throws Exception {
		Realtimeamt realtimeamtBO = (RealtimeamtBO) BOFactory.build(
				RealtimeamtBO.class, user);
		//Order orderBO = (OrderBO) BOFactory.build(
		//		OrderBO.class, user);
		//OrderVO orderVo = orderBO.doFindByPk(orderid);
		try {
			long num = 0;// ��������
			Ordercomcate ordercomcateBO = (OrdercomcateBO) BOFactory.build(
					OrdercomcateBO.class, user);
			String sqlName = null;
			OrdercomcateDBParam ordercomcateParam = new OrdercomcateDBParam();
			ordercomcateParam.setDataOnly(true);
			ordercomcateParam.setSelectFieldsString("orderamt");
			Map conditionMap = new HashMap();
			conditionMap.put("orderid", orderVO.getOrderid());

			if ("AllBrand".equals(realtimeamtVO.getBrand())) {
				// �����߼�Ϊ������׿�Ʒ��Ϊ����Ʒ�ƣ���BRAND=AllBrand������ͳ�ƶ�����Ʒ�����FX_SW_ORDERCOMCATE���пͻ������׿�����
				sqlName = "queryOrderamtByAllBrand";
			} else {
				// ����׿�Ʒ�Ʒ�����Ʒ�ƣ���BRAND<>AllBrand������ͳ�ƶ�����Ʒ�����FX_SW_ORDERCOMCATE���ж�ӦƷ�ƵĿͻ������׿�������
				sqlName = "queryOrderamtByBrand";
				conditionMap.put("brand", realtimeamtVO.getBrand());
			}
			ordercomcateParam.setQueryConditions(conditionMap);
			DataPackage ordercomcateDP = ordercomcateBO.doQueryByNameSql(
					sqlName, ordercomcateParam);
			if (null != ordercomcateDP && null != ordercomcateDP.getDatas()
					&& 0 < ordercomcateDP.getDatas().size()
					&& null != ordercomcateDP.getDatas().get(0)) {
				num = (Long) ordercomcateDP.getDatas().get(0);

				// �Ե����Ѷ���������������ʱ��Ϊ����ʱ���£��������Ѷ���������������ʱ��Ϊ����ʱ���£�����ǰ��������еݼ�������ʱ��Ϊ��ǰʱ�䣻
				// ��������Ѷ�����/�����Ѷ�����/��ǰ�����Ϊ�գ��򲻸��¶�Ӧֵ������ݼ������ֵС��0����¶�ӦֵΪ0��
				// ���¶�����
				if (0 == PublicUtils.compareMonth(new Date(),orderVO.getCreatetime())) {
					if (null != realtimeamtVO.getMonordered()) {
						realtimeamtVO.setMonordered((realtimeamtVO
								.getMonordered() - num) > 0 ? (realtimeamtVO
								.getMonordered() - num) : 0);
					}
				}
				// ���충����
				if (0 == PublicUtils.compareDate(new Date(), orderVO.getCreatetime())) {
					if (null != realtimeamtVO.getDayordered()) {
						realtimeamtVO.setDayordered((realtimeamtVO
								.getDayordered() - num) > 0 ? (realtimeamtVO
								.getDayordered() - num) : 0);
					}
				}
				// ��ǰ�����
				if (null != realtimeamtVO.getNowstock()) {
					realtimeamtVO
							.setNowstock((realtimeamtVO.getNowstock() - num) > 0 ? (realtimeamtVO
									.getNowstock() - num)
									: 0);
				}
				realtimeamtVO.setUptime(new Date());
				realtimeamtBO.doUpdate(realtimeamtVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new JOPException(e);
		}
	}
	
	/**
	 * ��������ʱ��ȥ����Ӧ��
	 * �հ�SIM��ʵʱ����������
	 * 
	 * @param orderid
	 *            �������
	 * @param simrealtimeamtVOʵʱ����
	 * @throws Exception
	 */
	private void doOrderSimrealtimeamtUpdate(OrderVO orderVO,
			SimrealtimeamtVO simrealtimeamtVO) throws Exception {
		SimrealtimeamtBO simrealtimeamtBO = (SimrealtimeamtBO) BOFactory.build(
				SimrealtimeamtBO.class, user);
		//Order orderBO = (OrderBO) BOFactory.build(
		//		OrderBO.class, user);
		//OrderVO orderVo = orderBO.doFindByPk(orderid);
		try {
			long num = 0;// ��������
			Ordercomcate ordercomcateBO = (OrdercomcateBO) BOFactory.build(
					OrdercomcateBO.class, user);
			String sqlName = "querySimOrderamtByAllBrand";
			OrdercomcateDBParam ordercomcateParam = new OrdercomcateDBParam();
			ordercomcateParam.setDataOnly(true);
			ordercomcateParam.setSelectFieldsString("orderamt");
			Map conditionMap = new HashMap();
			conditionMap.put("orderid", orderVO.getOrderid());
			
			ordercomcateParam.setQueryConditions(conditionMap);
			DataPackage ordercomcateDP = ordercomcateBO.doQueryByNameSql(
					sqlName, ordercomcateParam);
			if (null != ordercomcateDP && null != ordercomcateDP.getDatas()
					&& 0 < ordercomcateDP.getDatas().size()
					&& null != ordercomcateDP.getDatas().get(0)) {
				num = (Long) ordercomcateDP.getDatas().get(0);
				
				// �Ե����Ѷ���������������ʱ��Ϊ����ʱ���£��������Ѷ���������������ʱ��Ϊ����ʱ���£�����ǰ��������еݼ�������ʱ��Ϊ��ǰʱ�䣻
				// ��������Ѷ�����/�����Ѷ�����/��ǰ�����Ϊ�գ��򲻸��¶�Ӧֵ������ݼ������ֵС��0����¶�ӦֵΪ0��
				// ���¶�����
				if (0 == PublicUtils.compareMonth(new Date(), orderVO.getCreatetime())) {
					if (null != simrealtimeamtVO.getMonordered()) {
						simrealtimeamtVO.setMonordered((simrealtimeamtVO
								.getMonordered() - num) > 0 ? (simrealtimeamtVO
								.getMonordered() - num) : 0);
					}
				}
				// ���충����
				if (0 == PublicUtils.compareDate(new Date(), orderVO.getCreatetime())) {
					if (null != simrealtimeamtVO.getDayordered()) {
						simrealtimeamtVO.setDayordered((simrealtimeamtVO
								.getDayordered() - num) > 0 ? (simrealtimeamtVO
								.getDayordered() - num) : 0);
					}
				}
				// ��ǰ�����
				if (null != simrealtimeamtVO.getNowstock()) {
					simrealtimeamtVO
							.setNowstock((simrealtimeamtVO.getNowstock() - num) > 0 ? (simrealtimeamtVO
									.getNowstock() - num)
									: 0);
				}
				simrealtimeamtVO.setUptime(new Date());
				simrealtimeamtBO.doUpdate(simrealtimeamtVO);				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new JOPException(e);
		}
	}

	// ������Դ�ͷ�
	private void doOrderResRelease(String orderID) throws Exception {
		try {
			doUpdatePackdetStateByOrderid(orderID);
			doResourceUpdateByOrderId(orderID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ���ݶ�����Ų�ѯ������Ʒ����ϸ��(FX_SW_ORDERPACKDET)���Խ��������������
	// �������κͰ��Ÿ�����Ʒ����(IM_PR_COMPACK)��Ӧ��¼�İ�״̬Ϊ�����ۡ���
	private void doUpdatePackdetStateByOrderid(String orderID) throws Exception {
		Orderpackdet orderpackdetBO = (OrderpackdetBO) BOFactory.build(
				OrderpackdetBO.class, user);
		OrderpackdetDBParam param = new OrderpackdetDBParam();
		param.set_se_orderid(orderID);
		param.setQueryAll(true);
		DataPackage dp = orderpackdetBO.doQuery(param);
		if (null != dp && null != dp.getDatas()) {
			Compack compackBO = (CompackBO) BOFactory.build(CompackBO.class,
					user);
			CompackDBParam compackParam = new CompackDBParam();
			for (OrderpackdetVO vo : (List<OrderpackdetVO>) dp.getDatas()) {
				compackParam.set_se_batchno(vo.getBatchno());
				compackParam.set_se_boxnum(vo.getBoxnum());
				DataPackage compackDP = compackBO.doQuery(compackParam);
				if (null != compackDP && null != compackDP.getDatas()) {
					for (CompackVO compackVO : (List<CompackVO>) compackDP
							.getDatas()) {
						if (!"1".equals(compackVO.getPackstate())) {
							compackVO.setPackstate("1");
							compackBO.doUpdate(compackVO);
						}
					}
				}
			}
		}
	}

	private void doResourceUpdateByOrderId(String orderID) throws Exception {
		// ���ݶ�����Ų�ѯ������Դ��ϸ�� (FX_SW_ORDERRESDET)���Խ��������������
		// �����Դ���Ϊ��ֵ������RESTYPE=��COMRESCARD�������������Ʒ��Դ��ź���Ʒ��ʶ
		// ���³�ֵ����Դ��(IM_FX_COMRESCARD)��Ӧ��¼����Ʒ״̬Ϊ�����ۡ��������Դ���Ϊ�׿�����RESTYPE=��COMRESSMP������
		// ������Դ��ź���Ʒ��ʶ�����׿���Դ�� (IM_FX_COMRESSMP)��Ӧ��¼����Ʒ״̬Ϊ�����ۡ���
		// �������Ρ������ò��ظ��ļ��ϣ�MAP��Set�����б��档
		Orderresdet orderresdetBO = (OrderresdetBO) BOFactory.build(
				OrderresdetBO.class, user);
		OrderresdetDBParam param = new OrderresdetDBParam();
		param.set_se_orderid(orderID);
		param.setQueryAll(true);
		DataPackage dp = orderresdetBO.doQuery(param);
		if (null != dp && null != dp.getDatas()) {
			Set<String> batchNum = new HashSet<String>();
			Comrescard comrescardBO = (ComrescardBO) BOFactory.build(
					ComrescardBO.class, user);
			Comressmp comressmpBO = (ComressmpBO) BOFactory.build(
					ComressmpBO.class, user);
			Emptysim emptysimBO = (EmptysimBO) BOFactory.build(
					EmptysimBO.class, user);
			for (OrderresdetVO vo : (List<OrderresdetVO>) dp.getDatas()) {
				if ("COMRESCARD".equals(vo.getRestype())) {
					ComrescardVO comrescardVO = new ComrescardVO();
					comrescardVO.setComid(vo.getComid());
					comrescardVO.setComresid(vo.getComresid());
					comrescardVO = comrescardBO.doFindByPk(comrescardVO);
					if (null != comrescardVO
							&& !"1".equals("" + comrescardVO.getComstate())) {
						comrescardVO.setComstate(new Short("1"));
						comrescardBO.doUpdate(comrescardVO);
					}
				} else if ("COMRESSMP".equals(vo.getRestype())) {
					ComressmpVO comressmpVO = new ComressmpVO();
					comressmpVO.setComid(vo.getComid());
					comressmpVO.setComresid(vo.getComresid());
					comressmpVO = comressmpBO.doFindByPk(comressmpVO);
					if (null != comressmpVO) {
						if (!"1".equals("" + comressmpVO.getComstate())) {
							comressmpVO.setComstate(new Short("1"));
							comressmpBO.doUpdate(comressmpVO);
						}
						batchNum.add(comressmpVO.getBoxnum() + "|"
								+ comressmpVO.getBatchno());
					}
				} else if("EMPTYSIM".equals(vo.getRestype())){
					//�������Ʒ��Դ��źͿտ����кŸ��¿հ�SIM����Դ��(IM_FX_EMPTYSIM)��Ӧ��¼����Ʒ״̬Ϊ�����ۡ���
					EmptysimVO emptysimVO = new EmptysimVO();
					emptysimVO.setEmptyno(vo.getEmptyno());
					emptysimVO = emptysimBO.doFindByPk(emptysimVO.getEmptyno());
					
					if (null != emptysimVO
							&& !"1".equals("" + emptysimVO.getUsestate())) {
						emptysimVO.setUsestate(new Short("1"));
						emptysimBO.doUpdate(emptysimVO);
					}
				}else {
					continue;
				}
			}
			//			
			// ������һ����ȡ�����ΰ��ż��ϣ��������κͰ��Ų�ѯ��Ʒ����(IM_PR_COMPACK)��
			// ��������Ұ�״̬Ϊ���ۣ���������Ρ����š���Ʒ״̬�����ۣ����׿���Դ�� (IM_FX_COMRESSMP)����ͳ�ƣ�
			// ��ͳ��ֵ������Ʒ������Ʒ�����ֶΣ���������Ұ�״̬�ǿ��ۣ�����°�״̬Ϊ���ۣ�Ȼ������ͳ����Ʒ������ͬ�ϣ���
			Compack compackBO = (CompackBO) BOFactory.build(CompackBO.class,
					user);
			ComressmpDBParam comressmpParam = new ComressmpDBParam();
			CompackVO compackVO = null;
			DataPackage comresDP;
			for (String key : batchNum) {
				String[] temp = key.split("\\|");
				compackVO = new CompackVO();
				compackVO.setBatchno(temp[1]);
				compackVO.setBoxnum(temp[0]);
				compackVO = compackBO.doFindByPk(compackVO);
				if (null != compackVO) {
					if (!"1".equals(compackVO.getPackstate())) {
						compackVO.setPackstate("1");
						compackBO.doUpdate(compackVO);
					}
					comressmpParam.set_se_batchno(temp[1]);
					comressmpParam.set_se_boxnum(temp[0]);
					comressmpParam.set_ne_comstate(new Short("1"));
					comressmpParam.setQueryAll(true);
					comressmpParam.setCountOnly(true);
					comresDP = comressmpBO.doQuery(comressmpParam);
					if (null != comresDP) {
						compackVO.setAmount(new Short(""
								+ comresDP.getRowCount()));
						compackBO.doUpdate(compackVO);
					}
				}
			}

		}
	}

	// ��ѯ���ʶ�����ϸ
	public DataPackage doQueryAdpaydet(String _ne_sumid) throws Exception {
		OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
		OrderDBParam params = new OrderDBParam();
		params.getQueryConditions().put("sumid", _ne_sumid);
		return dao.queryByNamedSqlQuery(
				"com.gmcc.pboss.business.sales.adpaydet", params, 0);
	}
	/**
	 * �������ͨ��
	 */
   public void doBatchAudit(String[] orderids) throws Exception{
	   try {
		   	Orderproce orderproceBO = (Orderproce)BOFactory.build(OrderproceBO.class,user);
			OrderproceDBParam orderproceDBParam=new OrderproceDBParam();
			Audit auditBO = (Audit)BOFactory.build(AuditBO.class,user);
			AuditDBParam auditDBParam=new AuditDBParam();
			for(String orderid:orderids){
				OrderVO vo = this.doFindByPk(orderid);
				
				orderproceDBParam.set_ne_flowid(String.valueOf(vo.getFlowid()));
				orderproceDBParam.set_se_instate(vo.getOrderstate());
				DataPackage data=orderproceBO.doQuery(orderproceDBParam);
				List<OrderproceVO> list=data.getDatas();
				String outstate=null;
				for(OrderproceVO obj:list){
					outstate=obj.getOutstate();
					break;
				}
				if(!"AUDITED".equals(outstate))
					throw new Exception("����["+orderid+"]״̬����ȷ");
					//throw new Exception("��ѡ�Ķ����д���[�������̲���ĳ���״̬��Ϊ�����]�Ķ�����");
				auditDBParam.set_se_orderid(orderid);
				auditDBParam.set_orderby("smsntime");
				auditDBParam.set_desc("1");
				//List<AuditVO> auditlist=auditBO.doQuery(auditDBParam).getDatas();
				List<AuditVO> auditlist=auditBO.doGetAuditInfo(auditDBParam).getDatas();
				for(AuditVO auditVO:auditlist){
					if(!"1".equals(auditVO.getState())){
						//throw new Exception("����δ������������δͨ���Ķ�����¼");
						throw new Exception("����["+orderid+"]δ������������δͨ����������ִ�����ͨ������");
					}
					break;
				}
				this.doAudit(orderid);
			 }
		} catch (Exception e) {
			throw new JOPException(e.getMessage());
		}
   }
	public void doAudit(String orderid) throws Exception {
		OrderVO vo = this.doFindByPk(orderid);
		// ��ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����
		// ������ʶΪ��44��������������Ҳ���ֵ����1����зֹ�˾����飬����������鲽�衣
		Sysparam sysBO = (Sysparam) BOFactory.build(SysparamBO.class, user);
		String paramValue = sysBO.doFindByID("44", "pboss_fx");
		/*if ("1".equals(paramValue)) {
			// ���ݶ�����ŴӶ�����Ʒ���� (FX_SW_ORDERCOMCATE)��ȡ�øö�������Ʒ����
			Ordercomcate ordercomcateBO = (Ordercomcate) BOFactory.build(
					OrdercomcateBO.class, user);
			OrdercomcateDBParam ordercomcateParam = new OrdercomcateDBParam();
			ordercomcateParam.set_se_orderid(orderid);
			DataPackage ordercomcateDP = ordercomcateBO
					.doQuery(ordercomcateParam);
			if (null != ordercomcateDP && null != ordercomcateDP.getDatas()
					&& !ordercomcateDP.getDatas().isEmpty()) {

				Comcategoryrela comcategoryrelaBO = (Comcategoryrela) BOFactory
						.build(ComcategoryrelaBO.class, user);
				ComcategoryrelaDBParam comcategoryrelaParam = new ComcategoryrelaDBParam();
				for (OrdercomcateVO ordercomcateVO : (List<OrdercomcateVO>) ordercomcateDP
						.getDatas()) {
					// ���ȸ�����Ʒ�����ѯ��Ʒ������Ϲ�ϵ��IM_PR_COMCATEGORYRELA����ȡ��Դ���
					comcategoryrelaParam.set_se_comcategory(ordercomcateVO
							.getComcategory());
					DataPackage comcategoryrelaDP = comcategoryrelaBO
							.doQuery(comcategoryrelaParam);
					if (null != comcategoryrelaDP
							&& null != comcategoryrelaDP.getDatas()
							&& !comcategoryrelaDP.getDatas().isEmpty()) {
						ComcategoryrelaVO comcategoryrelaVO = (ComcategoryrelaVO) comcategoryrelaDP
								.getDatas().get(0);
						// ���׿��ͳ�ֵ�����п����ͳ�ơ�
						long stocks = 0; // �����Դ����
						long auditeds = 0; // �������Դ����
						if ("COMRESSMP".equals(comcategoryrelaVO.getRestype())) {
							CompackBO compackBO = (CompackBO) BOFactory.build(
									CompackBO.class, user);
							CompackDBParam compackParam = new CompackDBParam();
							compackParam.setDataOnly(true);
							compackParam.setQueryAll(true);
							compackParam.setSelectFieldsString("num");
							compackParam.getQueryConditions().put("COUNTYID",
									vo.getCountyid());
							compackParam.getQueryConditions().put("RESUSE", 
									this.queryOrdercomtype(ordercomcateVO.getOrdercomtype()));
							compackParam.getQueryConditions().put(
									"COMCATEGORY",
									comcategoryrelaVO.getComcategory());
							DataPackage dp = compackBO.doQueryBynameSql("com.gmcc.pboss.business.resource.compack.doCommresmpStocksQuery",compackParam);
							if (null != dp && null != dp.getDatas()
									&& !dp.getDatas().isEmpty()) {
								stocks = dp.getDatas().get(0) == null? 0 : Long.parseLong((String) dp
										.getDatas().get(0));
							}
							
							CompackDBParam compackParam1 = new CompackDBParam();
							compackParam1.setDataOnly(true);
							compackParam1.setQueryAll(true);
							compackParam1.setSelectFieldsString("num");
							compackParam1.getQueryConditions().put("COUNTYID",
									vo.getCountyid());
							compackParam1.getQueryConditions().put("RESUSE", 
									ordercomcateVO.getOrdercomtype());
							compackParam1.getQueryConditions().put(
									"COMCATEGORY",
									comcategoryrelaVO.getComcategory());
							dp = compackBO.doQueryBynameSql("com.gmcc.pboss.business.resource.compack.doCommresmpAuditedsQuery",compackParam1);
							if (null != dp && null != dp.getDatas()
									&& !dp.getDatas().isEmpty()) {
								auditeds = dp.getDatas().get(0) == null? 0 : Long.parseLong((String) dp
										.getDatas().get(0));
							}

						} else if ("COMRESCARD".equals(comcategoryrelaVO
								.getRestype())) {
							CompackBO compackBO = (CompackBO) BOFactory.build(
									CompackBO.class, user);
							CompackDBParam compackParam = new CompackDBParam();
							compackParam.setDataOnly(true);
							compackParam.setQueryAll(true);
							compackParam.setSelectFieldsString("num");
							compackParam.getQueryConditions().put("COUNTYID",
									vo.getCountyid());
							compackParam.getQueryConditions().put(
									"COMCATEGORY",
									comcategoryrelaVO.getComcategory());
							DataPackage dp = compackBO
									.doQueryBynameSql(
											"com.gmcc.pboss.business.resource.compack.doComrescardStocksQuery",
											compackParam);
							if (null != dp && null != dp.getDatas()
									&& !dp.getDatas().isEmpty()) {
								stocks = Long.parseLong((String) dp.getDatas()
										.get(0));
							}

							dp = compackBO
									.doQueryBynameSql(
											"com.gmcc.pboss.business.resource.compack.doComrescardAuditedsQuery",
											compackParam);
							if (null != dp && null != dp.getDatas()
									&& !dp.getDatas().isEmpty()) {
								auditeds = (dp.getDatas().get(0) == null? 0 : Long.parseLong((String) dp
										.getDatas().get(0)));
							}
						}
						//Ȼ�󣬶Կ�����Ƿ��������жϡ���������������-�������Դ������>=��ǰ��Ʒ���ඩ����������ͨ����
						//���򷵻���ʾ����Ʒ����[��Ʒ��������]�����������ֹ�˾�������[�������-�������Դ����]����
						if (!((stocks - auditeds) >= ordercomcateVO
								.getOrderamt())) {
							throw new JOPException("��Ʒ����["
									+ Code2NameUtils.code2Name(
											"$IM_FXCOMCATEGORY", ordercomcateVO
													.getComcategory(), user
													.getCityid())
									+ "]�����������ֹ�˾�������[" + (stocks - auditeds)
									+ "]");
							Way wayBO = (Way) BOFactory.build(WayBO.class, user);
							WayVO wayVo=wayBO.doFindByPk(vo.getWayid());
							throw new JOPException("�����������ֹ�˾�������["+
									Code2NameUtils.code2Name("#CNTYCOMPANY", vo.getCountyid(), user.getCityid())+"��"+
									Code2NameUtils.code2Name("#SERVCENT", wayVo.getSvccode(), user.getCityid())+"��"+
								Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", ordercomcateVO.getComcategory(), user.getCityid())
								+ "��"+stocks+"��"+(stocks - auditeds)+"��"+ordercomcateVO.getOrderamt()+ "]");
						}
					}
				}
			}
		}*/

		vo.setOrderstate("AUDITED");
		vo.setStatechgtime(new Date());
		Order orderBO = (Order) BOFactory.build(OrderBO.class, user);
		orderBO.doUpdate(vo);
	}
	public Map doFindStockInfo(String[] orderids) throws Exception {
			Map<Object,Object> map=new HashMap<Object,Object>();
			// ���ݶ�����ŴӶ�����Ʒ���� (FX_SW_ORDERCOMCATE)��ȡ�øö�������Ʒ����
			Ordercomcate ordercomcateBO = (Ordercomcate) BOFactory.build(
					OrdercomcateBO.class, user);
			DataPackage ordercomcateDP=new DataPackage();
			List<OrdercomcateStocksVO> ordercomcateStocksList=ordercomcateBO.doOrdercomcateStocksQuery(orderids);
			List<StockInfoVO>  stockInfoList=new ArrayList<StockInfoVO>();
			boolean isAppPass=true;
			if(ordercomcateStocksList.size()>0){
				Comcategoryrela comcategoryrelaBO = (Comcategoryrela) BOFactory
						.build(ComcategoryrelaBO.class, user);
				ComcategoryrelaDBParam comcategoryrelaParam = new ComcategoryrelaDBParam();
				StockInfoVO stockInfoVo=null;
				
				for(OrdercomcateStocksVO ordercomcateStocksVO:ordercomcateStocksList){
					// ���ȸ�����Ʒ�����ѯ��Ʒ������Ϲ�ϵ��IM_PR_COMCATEGORYRELA����ȡ��Դ���
					comcategoryrelaParam.set_se_comcategory(ordercomcateStocksVO
							.getComcategory());
					DataPackage comcategoryrelaDP = comcategoryrelaBO
							.doQuery(comcategoryrelaParam);
					if (null != comcategoryrelaDP
							&& null != comcategoryrelaDP.getDatas()
							&& !comcategoryrelaDP.getDatas().isEmpty()) {
						ComcategoryrelaVO comcategoryrelaVO = (ComcategoryrelaVO) comcategoryrelaDP
								.getDatas().get(0);
						// ���׿��ͳ�ֵ�����п����ͳ�ơ�
						long stocks = 0; // �����Դ����
						long auditeds = 0; // �������Դ����
						if ("COMRESSMP".equals(comcategoryrelaVO.getRestype())) {
							CompackBO compackBO = (CompackBO) BOFactory.build(
									CompackBO.class, user);
							CompackDBParam compackParam = new CompackDBParam();
							compackParam.setDataOnly(true);
							compackParam.setQueryAll(true);
							compackParam.setSelectFieldsString("num");
							compackParam.getQueryConditions().put("SVCCODE",ordercomcateStocksVO.getSvccode()==null?"":ordercomcateStocksVO.getSvccode());
							compackParam.getQueryConditions().put("RESUSE", 
									this.queryOrdercomtype(ordercomcateStocksVO.getOrdercomtype()));
							compackParam.getQueryConditions().put(
									"COMCATEGORY",
									comcategoryrelaVO.getComcategory());
							DataPackage dp = compackBO.doQueryBynameSql("com.gmcc.pboss.business.resource.compack.doCommresmpStocksQueryByAudit",compackParam);
							if (null != dp && null != dp.getDatas()
									&& !dp.getDatas().isEmpty()) {
								stocks = dp.getDatas().get(0) == null? 0 : Long.parseLong((String) dp
										.getDatas().get(0));
							}
							
							CompackDBParam compackParam1 = new CompackDBParam();
							compackParam1.setDataOnly(true);
							compackParam1.setQueryAll(true);
							compackParam1.setSelectFieldsString("num");
							compackParam1.getQueryConditions().put("SVCCODE",ordercomcateStocksVO.getSvccode()==null?"":ordercomcateStocksVO.getSvccode());
							compackParam1.getQueryConditions().put("RESUSE", 
									ordercomcateStocksVO.getOrdercomtype());
							compackParam1.getQueryConditions().put(
									"COMCATEGORY",
									comcategoryrelaVO.getComcategory());
							dp = compackBO.doQueryBynameSql("com.gmcc.pboss.business.resource.compack.doCommresmpAuditedsQuery",compackParam1);
							if (null != dp && null != dp.getDatas()
									&& !dp.getDatas().isEmpty()) {
								auditeds = dp.getDatas().get(0) == null? 0 : Long.parseLong((String) dp
										.getDatas().get(0));
							}

						} else if ("COMRESCARD".equals(comcategoryrelaVO
								.getRestype())) {
							CompackBO compackBO = (CompackBO) BOFactory.build(
									CompackBO.class, user);
							CompackDBParam compackParam = new CompackDBParam();
							compackParam.setDataOnly(true);
							compackParam.setQueryAll(true);
							compackParam.setSelectFieldsString("num");
							compackParam.getQueryConditions().put("SVCCODE",ordercomcateStocksVO.getSvccode()==null?"":ordercomcateStocksVO.getSvccode());
							compackParam.getQueryConditions().put(
									"COMCATEGORY",
									comcategoryrelaVO.getComcategory());
							DataPackage dp = compackBO
									.doQueryBynameSql(
											"com.gmcc.pboss.business.resource.compack.doComrescardStocksQueryByAudit",
											compackParam);
							if (null != dp && null != dp.getDatas()
									&& !dp.getDatas().isEmpty()) {
								stocks = Long.parseLong((String) dp.getDatas()
										.get(0));
							}

							dp = compackBO
									.doQueryBynameSql(
											"com.gmcc.pboss.business.resource.compack.doComrescardAuditedsQuery",
											compackParam);
							if (null != dp && null != dp.getDatas()
									&& !dp.getDatas().isEmpty()) {
								auditeds = (dp.getDatas().get(0) == null? 0 : Long.parseLong((String) dp
										.getDatas().get(0)));
							}
						}
						
						stockInfoVo=new StockInfoVO();
						stockInfoVo.setCountyid(ordercomcateStocksVO.getCountyid());
						stockInfoVo.setSvccode(ordercomcateStocksVO.getSvccode());
						stockInfoVo.setOrdercomtype(ordercomcateStocksVO.getOrdercomtype());
						stockInfoVo.setComcategory(ordercomcateStocksVO.getComcategory());
						stockInfoVo.setStocks(stocks);
						stockInfoVo.setAssignStocks((stocks - auditeds));
						stockInfoVo.setOrderamt(ordercomcateStocksVO.getOrderamt());
						stockInfoList.add(stockInfoVo);
						//Ȼ�󣬶Կ�����Ƿ��������жϡ���������������-�������Դ������>=��ǰ��Ʒ���ඩ����������ͨ����
						//���򷵻���ʾ����Ʒ����[��Ʒ��������]�����������ֹ�˾�������[�������-�������Դ����]����
						if (!((stocks - auditeds) >= ordercomcateStocksVO
								.getOrderamt())) {
							isAppPass=false;
						}
					}
				}
			}
			ordercomcateDP.setPageNo(1);
			ordercomcateDP.setRowCount(stockInfoList.size());
			ordercomcateDP.setDatas(stockInfoList);
			map.put("DP", ordercomcateDP);
			map.put("isAppPass", isAppPass);
			return map;
	
	}
	
	public String queryOrdercomtype(String ordercomtype) throws Exception{
		String result="";
		if("CUSTORDER".equals(ordercomtype)){
			result="NORMAL";
		}else if("SYSTIEIN".equals(ordercomtype)){
			result="TIEIN";
		}else if("SYSGIFT".equals(ordercomtype)){
			result="PRESENT";
		}
		return result;
	}
	
	//��ѯĳһ��Ʒ����ĵ����Ѷ�����
	public Long doQueryOrderedToday(OrderDBParam params,String wayid,String comcategory) throws Exception {
		OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
		String today = PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd");
		params.getQueryConditions().put("wayid",wayid);
		params.getQueryConditions().put("begintime",today+" 00:00:00");
		params.getQueryConditions().put("endtime",today+" 23:59:59");
		params.getQueryConditions().put("comcategory",comcategory);
		Long amt = 0L;
		Long amt2 = (Long)dao.queryUniqueByNamedSqlQuery("sales.comorder.queryOrderedToday", params,Long.class);
		if(null!=amt2)
			amt = amt2;
		return amt;
	}
	
	//��ѯĳһ��Ʒ����ĵ����Ѷ�����
	public Long doQueryOrderedMonth(OrderDBParam params,String wayid,String comcategory) throws Exception {
		OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
		String thismoth = PublicUtils.formatUtilDate(new Date(), "yyyy-MM");
		String today = PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd");
		String monthbegin = thismoth + "-01";
		params.getQueryConditions().put("wayid",wayid);
		params.getQueryConditions().put("begintime",monthbegin+" 00:00:00");
		params.getQueryConditions().put("endtime",today+" 23:59:59");
		params.getQueryConditions().put("comcategory",comcategory);
		Long amt = 0L;
		Long amt2 = (Long)dao.queryUniqueByNamedSqlQuery("sales.comorder.queryOrderedToday", params,Long.class);
		if(null!=amt2)
			amt = amt2;
		return amt;
	}
	 /**
     * ��ȡ����������
     * @param wayid
     * @param monthParam
     * @return
     * @throws Exception
     */
    public Long doGetGiveCount(String wayid,String monthParam)throws Exception{
    	OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
    	return dao.doGetGiveCount(wayid, monthParam);
    }
    /**
     * ��ѯ��װ��˸�����Ϣ����
     * @param orderVO
     * @throws Exception
     */
    public List<AuxiliaryInfoVO> doGetAuxiliaryInfo(OrderVO orderVO)throws Exception{
    	OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
    	return dao.doGetAuxiliaryInfo(orderVO);
    }

	public Long doGetOrderingStockAmountWithBrand(String wayid, String brand)
			throws Exception {
		OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
		OrderDBParam param = new OrderDBParam();
		param.getQueryConditions().put("wayid", wayid);
		param.getQueryConditions().put("brand", brand);
		Long stkAmount = (Long)dao.queryUniqueByNamedSqlQuery("com.gmcc.pboss.business.sales.order.doGetOrderingStockAmountWithBrand", param,Long.class);
		return stkAmount;
	}

	public Long doGetOrderingStockAmountNotWithBrand(String wayid)
			throws Exception {
		OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
		OrderDBParam param = new OrderDBParam();
		param.getQueryConditions().put("wayid", wayid);
		Long stkAmount = (Long)dao.queryUniqueByNamedSqlQuery("com.gmcc.pboss.business.sales.order.doGetOrderingStockAmountNotWithBrand", param,Long.class);
		return stkAmount;
	}
	
	//���ڶ༶���
	public DataPackage doListForAudit(OrderDBParam params) throws Exception {
		OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
		//����װ�ز�ѯ�Ľ��
		DataPackage dp=null;
		if (params.get_se_comcategory() != null
				&& params.get_se_comcategory().length() > 0) {
			 dp=dao.queryByNamedSqlQuery("queryOrderWithComcategory",params);
		}else
		{
			 dp = dao.query(params);
		}
		WayVO wayvo = new WayVO();
		Way waybo = (Way)BOFactory.build(WayBO.class, user);
		if (null != dp && null != dp.getDatas()) {
			List<OrderVO> list = dp.getDatas();
			for (OrderVO vo : list) {
				wayvo = waybo.doFindByPk(vo.getWayid());
				vo.setSvccode(wayvo.getSvccode());
				vo.setOrderInfo(doGetOrderInfo(vo.getOrderid()));
				vo.setBrandInfo(doGetBrandInfo(vo.getOrderid()));
			}
		}
		return dp;
	}

	public void doProcess(DBAccessUser user) throws Exception{
		//================��������CR_ZQ_20110323_1410123���޸�=============
		// T1�����ͳ�ʱԤ��ʱ��T1������ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����������ʶΪ��66����
		//��������ݻ�����Ϊ�գ�����ʾ���˳���
		// T2�����ͳ�ʱԤ��ʱ��T2������ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����������ʶΪ��67����
		//��������ݻ�����Ϊ�գ�����ʾ���˳���
		Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
		String t1 = sysparamBO.doFindByID("66", "pboss_fx");
		String t2 = sysparamBO.doFindByID("67", "pboss_fx");
		if(t1 == null || "".equals(t1)){
			log.error("���ͳ�ʱԤ��ʱ��T1�������ݻ�����Ϊ�ջ����ֵС���㣬�˳�");
			return ;
		}else{
			Long l = 0L;
			try {
				l = Long.parseLong(t1);
			} catch (Exception e) {
				log.error("���ͳ�ʱԤ��ʱ��T1�������֣��˳�");
				return ;
			}
			if(l<0){
				log.error("���ͳ�ʱԤ��ʱ��T1�������ݻ�����Ϊ�ջ����ֵС����");
				return ;
			}else{
				
			}
		}
		if(t2 == null || "".equals(t2)){
			log.error("���ͳ�ʱԤ��ʱ��T2�������ݻ�����Ϊ�գ��˳�");
			return ;
		}else{
			Long l = 0L;
			try {
				l = Long.parseLong(t2);
			} catch (Exception e) {
				log.error("���ͳ�ʱԤ��ʱ��T2�������֣��˳�");
				return ;
			}
			if(l<0){
				log.error("���ͳ�ʱԤ��ʱ��T2�������ݻ�����Ϊ�ջ����ֵС����");
				return ;
			}else{
				
			}
		}
				
		
		String sContentString = getSmsContent();
		if(sContentString == null || "".equals(sContentString)){
			log.error("����ģ�������ݻ�����Ϊ�գ��˳�");
			return ;
		}
		
		/*
		 * ��ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����������ʶΪ��42����
		 * ���ͺ���ȡ����ֵ����������ݻ�����Ϊ�գ�����ʾ���˳���
		 */
		String sendNum = sysparamBO.doFindByID("42", "pboss_fx");
		if(sendNum == null || "".equals(sendNum)){
			log.error("���ŷ��ͺ��������ݻ�����Ϊ�գ��˳�");
			return ;
		}
		
		/*
		 * ��ȡ�г��������ֻ���
		 * ��ѯ����֪ͨ�����(FX_SW_SMSOBJECT),ƥ��ֹ�˾Ϊ�˶����ķֹ�˾��
		 * ֪ͨ��������Ϊ���г�����������ȡ�ֻ����루�����ֻһ�������ÿһ���ֻ����뷢�Ͷ��ţ���
		 * 
		 * WAYMANAGER	�ֹ�˾��������
		 * MARKETMANAGER	�ֹ�˾�г�������
		 */
		Map<String,List> wmMap = getObject("WAYMANAGER");
		Map<String,List> mmMap = getObject("MARKETMANAGER");
		
		/*
		 * ���ֹ�˾��΢�������ͳ�Ƴ���ʱʱ��ֱ����T1�ʹ���T2�����͵���Ŀ
		 * ������ (FX_SW_ORDER)
		 * ������־�� (FX_SW_ORDERLOG)
		 * ���͵���������Դ���͵�:FX_SW_DISFORM��
		 * 
		 * 	ƥ�����������ϲ�ѯ������������־�����͵���ƥ�����͵�״̬Ϊδ��ɣ���������������ɻ����ϣ���
		 *  ��������ʱ��Ϊǰ30�������죬����״̬Ϊ��ȷ�ϣ�������־���������Ϊ���£���ȡ��־����������ֶε�ֵ��Ϊ����ȷ��ʱ�䡣 
		 * 	��ʱʱ��=ϵͳʱ��-����ȷ��ʱ��
		 */
		/*
		 * ���ͳ�ʱԤ��ʱ��T1
		 */
		Order orderBO = (OrderBO)BOFactory.build(OrderBO.class,user);
		OrderDBParam o_params = new OrderDBParam();
		o_params.setDataOnly(true);
		o_params.setSelectFieldsString("countyid,mareacode,optime,orderid");
		//o_params_t1.setT1Start(Integer.parseInt(t1));
		//o_params_t1.setT1End(Integer.parseInt(t2));
		DataPackage dp_t1 = orderBO.doQueryOrderDisform(o_params);
		Map orderidT1Map = new HashMap();//t1��orderid
		Map<String,List> t1_map = getTtime(dp_t1,true,t1,t2,orderidT1Map);
		
		/*
		 * ���ͳ�ʱԤ��ʱ��T2
		 */
		//DataPackage dp_t2 = orderBO.doQueryOrderDisform(o_params);
		Map orderidT2Map = new HashMap();//t2��orderid
		Map<String,List> t2_map = getTtime(dp_t1,false,t1,t2,orderidT2Map);
		
		//д���͵���ʱԤ��ͳ�Ʊ� (FX_SW_DISOVERSTAT)�����͵���ʱԤ��ͳ����ϸ�� (FX_SW_DISOVERDETAIL)
		doWriteSt(t1_map,t2_map,orderidT1Map,orderidT2Map);
		
		/*
		 * ������֪ͨ�ֹ�˾����������ʱʱ�䳬��T1�����ͳ�ʱԤ��ʱ��T1�������͵���
		 * 
		 */
		doSendMsg(t1_map,null,wmMap,null,sContentString,true,user,sendNum);
		
		/*
		 * ������֪ͨ�ֹ�˾���������г���������ʱʱ�䳬��T2�����ͳ�ʱԤ��ʱ��T2�������͵���
		 * 
		 */
		doSendMsg(t1_map,t2_map,wmMap,mmMap,sContentString,false,user,sendNum);
		
	}
	/**
	 * 
	 * @param t1_map
	 * @param t2_map
	 * @param orderidT1Map	
	 * @param orderidT2Map
	 * @throws Exception
	 */
	private void doWriteSt(Map t1_map,Map t2_map,Map orderidT1Map,Map orderidT2Map) throws Exception{
		Disoverstat disoverstatBO = (DisoverstatBO)BOFactory.build(DisoverstatBO.class,user);
		Disoverdetail disoverdetailBO = (DisoverdetailBO)BOFactory.build(DisoverdetailBO.class,user);
		if(t1_map != null && !"".equals(t1_map)){
			Iterator iter = t1_map.entrySet().iterator();
			while (iter.hasNext()) {
			    Map.Entry entry = (Map.Entry) iter.next();
			    String key = (String)entry.getKey();
			    List val = (List)entry.getValue();
			    
			    for (int i = 0; i < val.size(); i++) {
	    			HashMap sVO = (HashMap)val.get(i);
	    			String countyidTmp = (String)sVO.get("countyid");
	    			String mareacodeTmp = (String)sVO.get("mareacode");
	    			String orderIdTmp = (String)sVO.get("orderId");
	    			String counTmp = (String)sVO.get("coun");
	    			
	    			DisoverstatVO disoverstatVO = new DisoverstatVO();
		    		disoverstatVO.setCountyid(countyidTmp);
		    		disoverstatVO.setMareacode(mareacodeTmp);
		    		disoverstatVO.setStatdate(new Date());
		    		if(counTmp != null && !"".equals(counTmp)){
		    			disoverstatVO.setCountt1(Long.parseLong(counTmp));
		    		}
		    		
		    		disoverstatVO = disoverstatBO.doCreate(disoverstatVO);
		    		
		    		//д���͵���ʱԤ��ͳ����ϸ�� (FX_SW_DISOVERDETAIL)
		    		Iterator iter1 = orderidT1Map.entrySet().iterator();
					while (iter1.hasNext()) {
					    Map.Entry entry1 = (Map.Entry) iter1.next();
					    String key1 = (String)entry1.getKey();
					    HashMap val1 = (HashMap)entry1.getValue();
					    String countyidTmp1 = (String)val1.get("countyid");
		    			String mareacodeTmp1 = (String)val1.get("mareacode");
		    			String optimeStr = (String)val1.get("optime");
		    			if(countyidTmp1 == null)
		    				countyidTmp1 = "";
		    			if(mareacodeTmp1 == null)
		    				mareacodeTmp1 = "";
		    			
		    			if(countyidTmp1.equals(countyidTmp) 
		    					&& mareacodeTmp1.equals(mareacodeTmp)){
		    				//�ֹ�˾��΢������ͬ�ģ�����Ҫд����ϸ��
		    				DisoverdetailVO disoverdetailVO = new DisoverdetailVO();
		    				disoverdetailVO.setStatseqid(disoverstatVO.getSeqid());
		    				disoverdetailVO.setOvertype("OVERT1");
		    				disoverdetailVO.setOrderid(key1);
		    				//��ʱʱ��ȡ��ϵͳʱ��-����ȷ��ʱ�䡱����λΪСʱ		    				
		    				Date optime = PublicUtils.UtilStrToDate(optimeStr,"yyyy-MM-dd HH:mm:ss");
		    				long bt = TimeUtils.getWorkdayTimeInMillis(optime.getTime(),new Date().getTime());
							long btHour = bt/1000/60/60;//����--��Сʱ
							disoverdetailVO.setOverhour(btHour);
		    				
		    				disoverdetailBO.doCreate(disoverdetailVO);
		    			}
					}
			    }
			}
		}
		if(t2_map != null && !"".equals(t2_map)){
			Iterator iter = t2_map.entrySet().iterator();
			while (iter.hasNext()) {
			    Map.Entry entry = (Map.Entry) iter.next();
			    String key = (String)entry.getKey();
			    List val = (List)entry.getValue();
			    
			    for (int i = 0; i < val.size(); i++) {
	    			HashMap sVO = (HashMap)val.get(i);
	    			String countyidTmp = (String)sVO.get("countyid");
	    			String mareacodeTmp = (String)sVO.get("mareacode");
	    			String orderIdTmp = (String)sVO.get("orderId");
	    			String counTmp = (String)sVO.get("coun");
	    			
	    			DisoverstatVO disoverstatVO = new DisoverstatVO();
		    		disoverstatVO.setCountyid(countyidTmp);
		    		disoverstatVO.setMareacode(mareacodeTmp);
		    		disoverstatVO.setStatdate(new Date());
		    		if(counTmp != null && !"".equals(counTmp)){
		    			disoverstatVO.setCountt2(Long.parseLong(counTmp));
		    		}
		    		
		    		disoverstatVO = disoverstatBO.doCreate(disoverstatVO);		
		    		
		    		//д���͵���ʱԤ��ͳ����ϸ�� (FX_SW_DISOVERDETAIL)
		    		Iterator iter1 = orderidT2Map.entrySet().iterator();
					while (iter1.hasNext()) {
					    Map.Entry entry1 = (Map.Entry) iter1.next();
					    String key1 = (String)entry1.getKey();
					    HashMap val1 = (HashMap)entry1.getValue();
					    String countyidTmp1 = (String)val1.get("countyid");
		    			String mareacodeTmp1 = (String)val1.get("mareacode");		    			
		    			String optimeStr = (String)val1.get("optime");
		    			if(countyidTmp1 == null)
		    				countyidTmp1 = "";
		    			if(mareacodeTmp1 == null)
		    				mareacodeTmp1 = "";
		    			
		    			if(countyidTmp1.equals(countyidTmp) 
		    					&& mareacodeTmp1.equals(mareacodeTmp)){
		    				//�ֹ�˾��΢������ͬ�ģ�����Ҫд����ϸ��
		    				DisoverdetailVO disoverdetailVO = new DisoverdetailVO();
		    				disoverdetailVO.setStatseqid(disoverstatVO.getSeqid());
		    				disoverdetailVO.setOvertype("OVERT2");
		    				disoverdetailVO.setOrderid(key1);
		    				//��ʱʱ��ȡ��ϵͳʱ��-����ȷ��ʱ�䡱����λΪСʱ		    				
		    				Date optime = PublicUtils.UtilStrToDate(optimeStr,"yyyy-MM-dd HH:mm:ss");
		    				long bt = TimeUtils.getWorkdayTimeInMillis(optime.getTime(),new Date().getTime());
							long btHour = bt/1000/60/60;//����--��Сʱ
							disoverdetailVO.setOverhour(btHour);
		    				
		    				disoverdetailBO.doCreate(disoverdetailVO);
		    			}
					}
			    }
			}
		}
		
	}
	
	/**
	 * ��t1_map��t2_map�ֱ�����Ų������ţ�t1_map��ͳ�����ݸ������������ţ�t2_map��ͳ�����ݸ��г�����������<br>
	 * 
	 * @param t1_map	���ֹ�˾�ϲ����ͳ������t1�����ͳ�ʱԤ��ʱ��T1��<BR>
	 * @param t2_map	���ֹ�˾�ϲ����ͳ������t2�����ͳ�ʱԤ��ʱ��T2��<BR>
	 * @param wmMap		����������Ա��<BR>
	 * @param mmMap		�г���������Ա��<BR>
	 * @param sContentString	��������<BR>
	 * @param flag		trueΪt1ͳ�ƣ�falseΪt2ͳ��<BR>
	 * @sendNum			���ŷ��ͺ���<BR>
	 * @throws Exception <BR>
	 */
	public void doSendMsg(Map t1_map,
			Map t2_map,Map wmMap,Map mmMap,
			String sContentString,boolean flag,
			DBAccessUser user,String sendNum) throws Exception{
		if(flag){
			if(t1_map != null && !"".equals(t1_map)){
				Iterator iter = t1_map.entrySet().iterator();
				while (iter.hasNext()) {
				    Map.Entry entry = (Map.Entry) iter.next();
				    String key = (String)entry.getKey();
				    //��������
				    if(wmMap.containsKey(key)){
				    	List val = (List)entry.getValue();
				    	doDeal(val,sContentString,wmMap,key,user,sendNum);
				    }else{
				    	String compName = Code2NameUtils.code2Name("#CNTYCOMPANY", key, user.getCityid());
				    	log.info(compName + "�ֹ�˾û�����������ֻ���");
				    }
				} 
			}
		}else{
			if(t2_map != null && !"".equals(t2_map)){
				Iterator iter = t2_map.entrySet().iterator();
				while (iter.hasNext()) {
				    Map.Entry entry = (Map.Entry) iter.next();
				    String key = (String)entry.getKey();
				    String compName = Code2NameUtils.code2Name("#CNTYCOMPANY", key, user.getCityid());
				    //��������
				    if(wmMap.containsKey(key)){
				    	List val = (List)entry.getValue();
				    	doDeal(val,sContentString,wmMap,key,user,sendNum);
				    }else{
				    	log.info(compName + "�ֹ�˾û�����������ֻ���");
				    }
				    //�г�������
				    if(mmMap.containsKey(key)){
				    	List val = (List)entry.getValue();
				    	doDeal(val,sContentString,mmMap,key,user,sendNum);
				    }else{
				    	log.info(compName + "�ֹ�˾û���г��������ֻ���");
				    }
				} 
			}
		}
	}
	
	/**
	 * ���������г��������������������<br>
	 * 
	 * @param val				���ֹ�˾�ϲ����ͳ������,t1��t2
	 * @param sContentString	����ģ��
	 * @param map				��Ա��:���������г�������
	 * @param key				�ֹ�˾���
	 * @user					�û���Ϣ
	 * @sendNum					���ŷ��ͺ���
	 * @throws Exception 
	 */
	public void doDeal(List val,String sContentString,Map map,
			String key,DBAccessUser user,String sendNum) throws Exception{    	
    	if(val != null && !"".equals(val) && val.size()>0){
    		StringBuffer content = new StringBuffer();
    		for (int i = 0; i < val.size(); i++) {
    			HashMap sVO = (HashMap)val.get(i);
    			String mirName = Code2NameUtils.code2Name("#MICROAREA", 
						(String)sVO.get("mareacode"), user.getCityid());
    			if(i == (val.size() - 1)){    				
    				content.append(mirName + "-" + sVO.get("coun") + "��");
    			}else{
    				content.append(mirName + "-" + sVO.get("coun") + "�ţ�");
    			}
			}
    		//�滻����ģ���еķֹ�˾��{COUNTYID}�������ݣ�OVERTIMEDESC}��
    		String tmp = new String(sContentString);
    		String compName = Code2NameUtils.code2Name("#CNTYCOMPANY", key, user.getCityid());
    		tmp = tmp.toString()
    			.replaceAll("\\{OVERTIMEDESC\\}", content.toString())
    			.replaceAll("\\{COUNTYID\\}", compName);
    		
    		List ll = (List)map.get(key);
    		if(ll != null && !"".equals(ll) && ll.size()>0){
    			for (int j=0 ; j<ll.size() ; j++) {
    				SmsobjectVO wmVO = (SmsobjectVO)ll.get(j);
    				//ÿ���û����Ͷ�������
    				String smsMessageString = new String(tmp);
    				//��ÿ���ֻ����滻����ģ���еĿͻ����ƣ�{CUSTNAME}��
    				smsMessageString = smsMessageString.replaceAll("\\{CUSTNAME\\}", wmVO.getName());
    				
    				/*
		    		 * �˴����Ͷ���
		    		 * smsMessageString����������
		    		 * sendNum�����ŷ��ͺ���
		    		 * wmVO.getMobile()�������ֻ���
		    		 * date������ʱ��
		    		 * 	    		 
    				 * ϵͳ������ʱ�������sendDateStr
    				 */
    				Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
    				String sendDateStr = sysparamBO.doFindByID("58", "pboss_fx");    				
    				SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
    				SimpleDateFormat dateTimeFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    				Calendar calendar = Calendar.getInstance();
    				Date sendDate = dateTimeFormat2.parse(
							dateTimeFormat.format(calendar.getTime()) + " " + sendDateStr);
    				if(wmVO.getMobile() != null 
    						&& !"".equals(wmVO.getMobile())){
    					WaitreqBO waitreqBO = (WaitreqBO)BOFactory.build(WaitreqBO.class,user);    				    				
    					waitreqBO.doInsert3(new Short("3"), smsMessageString, sendNum, wmVO.getMobile(),sendDate);
    				}
				}
    		}			    		
    	}
    }
	
	/**
	 * ���ص�Map��keyΪ�ֹ�˾ID��valueΪHashMap��List��<BR>
	 * ��List��HashMap���ְ���countyid���ֹ�˾��mareacode��΢����coun��ͳ�����͵���Ŀ <BR>
	 * @param dp
	 * @param flag true�����ͳ�ʱԤ��ʱ��T1����false�����ͳ�ʱԤ��ʱ��T2<br>
	 * @param t1�����ͳ�ʱԤ��ʱ��T1<br>
	 * @param t2�����ͳ�ʱԤ��ʱ��T2<br>
	 * @return
	 * @throws Exception 
	 */
	public Map getTtime(DataPackage dp,boolean flag,String t1,String t2,Map orderIdMap) throws Exception{
		Map<String,List> map = new HashMap<String,List>();
		if (null == dp
				|| null == dp.getDatas()
				|| dp.getDatas().size() < 1){
			//������
		}else{
			for(int i=0; i<dp.getDatas().size(); i++){
				HashMap ooaVO = (HashMap)dp.getDatas().get(i);
				String m_cid = (String)ooaVO.get("countyid");
				String mareacodeId = (String)ooaVO.get("mareacode");
				String orderid = (String)ooaVO.get("orderid");
				if(null == mareacodeId){
					mareacodeId = "";
				}
				String optimeStr = (String)ooaVO.get("optime");
				Date optime = PublicUtils.UtilStrToDate(optimeStr,"yyyy-MM-dd HH:mm:ss");
				if(m_cid != null && !"".equals(m_cid)){
					//��ʱʱ��ͳ����ܿ���ĩʱ�䣬����ͳ����ĩʱ��
					long bt = TimeUtils.getWorkdayTimeInMillis(optime.getTime(),new Date().getTime());
					long btHour = bt/1000/60/60;//����--��Сʱ
					
					if(flag){//t1
						if(btHour>=Long.parseLong(t1)
								&& btHour<Long.parseLong(t2)){
							if(!orderIdMap.containsKey(orderid)){//����ͬ�������ţ���־���ж�����¼ʱ��ֻͳ������һ��
								
								statData(map,m_cid,mareacodeId,orderid);
								orderIdMap.put(orderid, ooaVO);
							}
						}							
					}else{//t2
						if(btHour>=Long.parseLong(t2)){
							if(!orderIdMap.containsKey(orderid)){//����ͬ�������ţ���־���ж�����¼ʱ��ֻͳ������һ��
								
								statData(map,m_cid,mareacodeId,orderid);
								orderIdMap.put(orderid, ooaVO);
							}
						}							
					}
					
				}
				
			}
		}
		return map;
	}
	
	/**
	 * 
	 * @param map	���ص�Map��keyΪ�ֹ�˾ID��valueΪHashMap��List��<BR>
	 * 				��List��HashMap���ְ���countyid���ֹ�˾��mareacode��΢����coun��ͳ�����͵���Ŀ <BR>
	 * @param m_cid	�ֹ�˾<br>
	 * @param mareacodeId	΢����<br>
	 */
	public void statData(Map<String,List> map,String m_cid,String mareacodeId,String orderId){		
		if(map.containsKey(m_cid)){//���ڷֹ�˾���Դ��ڡ�������΢�����ۼӡ�����
			List<Map> list = (List)map.get(m_cid);
			List<Map> listTmp = new ArrayList<Map>();
			boolean extFlag = false;//��ǰ�Ƕ�һ����¼�Ĵ������ԣ�ֻ�ܼ�һ�ε�map����
			for (Map map2 : list) {
				if(map2.get("countyid").equals(m_cid)){
					if(map2.get("mareacode").equals(mareacodeId)){//���ڵ�΢�����ۼ�
						extFlag = true;
						break;
					}else{//�����ڵ�΢�����¼����б�
						extFlag = false;						
					}
				}
			}
			if(extFlag){//���ڵ�΢�����ۼ�
				for (Map map3 : list) {
					if(map3.get("countyid").equals(m_cid)){
						if(map3.get("mareacode").equals(mareacodeId)){//���ڵ�΢�����ۼ�
							String coun = (String)map3.get("coun");
							int count = Integer.parseInt(coun)+1;
							map3.remove("coun");
							map3.put("coun", ""+count);
							break;
						}
					}
				}
			}else{//�����ڵ�΢�����¼����б�
				Map<String,String> mapTmp = new HashMap<String,String>();
				mapTmp.put("countyid", m_cid);
				mapTmp.put("mareacode", mareacodeId);
				mapTmp.put("orderId", orderId);
				mapTmp.put("coun", ""+1);
				list.add(mapTmp);
			}			
		}else{//�����ڷֹ�˾�������б�
			List<Map> list = new ArrayList<Map>();
			Map<String,String> mapTmp = new HashMap<String,String>();
			mapTmp.put("countyid", m_cid);
			mapTmp.put("mareacode", mareacodeId);
			mapTmp.put("orderId", orderId);
			mapTmp.put("coun", ""+1);
			list.add(mapTmp);
			
			map.put(m_cid, list);
		}
	}
	
	/**
	 * ���ص�Map��keyΪ�ֹ�˾ID��valueΪSmsobjectVO���List <BR>
	 * 
	 * ��ȡ���������ֻ���<BR>
	 * ��ѯ����֪ͨ�����(FX_SW_SMSOBJECT),ƥ��ֹ�˾Ϊ�˶����ķֹ�˾��<BR>
	 * ֪ͨ��������Ϊ��������������ȡ�ֻ����루�����ֻһ�������ÿһ���ֻ����뷢�Ͷ��ţ�<BR>
	 * @type
	 * WAYMANAGER	�ֹ�˾��������
	 * MARKETMANAGER	�ֹ�˾�г�������
	 * @throws Exception 
	 */
	public Map getObject(String type) throws Exception{
		Map map = new HashMap();
		Smsobject smsobjectBO = (SmsobjectBO)BOFactory.build(SmsobjectBO.class,user);
		SmsobjectDBParam params_wm = new SmsobjectDBParam();
		params_wm.set_se_objecttype(type);
		params_wm.set_pagesize("0");
		params_wm.set_se_busitype("DISOVERTIMEALARM");
		DataPackage dp_wm = smsobjectBO.doQuery(params_wm);
		
		if (null == dp_wm
				|| null == dp_wm.getDatas()
				|| dp_wm.getDatas().size() < 1){
			//������
		}else{
			for(int i=0; i<dp_wm.getDatas().size(); i++){
				SmsobjectVO wmVO = (SmsobjectVO)dp_wm.getDatas().get(i);
				String m_cid = (String)wmVO.getCountyid();
				if(m_cid != null && !"".equals(m_cid)){
					if(map.containsKey(m_cid)){
						List list = (List)map.get(m_cid);
						list.add(wmVO);
						
						map.remove(m_cid);
						map.put(m_cid, list);
					}else{
						List<SmsobjectVO> list = new ArrayList<SmsobjectVO>();
						list.add(wmVO);
						
						map.put(m_cid, list);
					}
				}
			}
		}
		return map;
	}
	
	/**
	 * ���ݱ�ʶ��FX_ORDER_DISOVERALARM������Ч״̬��1����ѯ����ģ���
	 * ��CH_SMS_SMSTMPL������ȡģ�����ݣ���������ݻ�����Ϊ�գ�����ʾ���˳�
	 */	
	public String getSmsContent() throws Exception{
			
		Smstmpl smstmplBO = (SmstmplBO) BOFactory.build(SmstmplBO.class, user);
		SmstmplDBParam param = new SmstmplDBParam();
		param.setDataOnly(true);
		param.set_se_sid("FX_ORDER_DISOVERALARM");
		param.set_se_sstate("1");
		DataPackage dp = smstmplBO.doQuery(param);
		if (null == dp
				|| null == dp.getDatas()
				|| dp.getDatas().size() < 1){
			log.error("����ģ�������ݻ�����Ϊ�գ��˳�");
			return "";
		}
			
		SmstmplVO smstmplVO = (SmstmplVO) dp.getDatas().get(0);
		
		return smstmplVO.getScontent();
	}
	
	public DataPackage doQueryOrderDisform(OrderDBParam params)
			throws Exception {
		OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);

		return dao.doQueryOrderDisform(params);
	}

	public void doSmsAfterCancel(String[] pkItem, String cancelReason,
			String cancelDes) throws Exception{
		//try{
			if(pkItem != null && !"".equals(pkItem) && pkItem.length>0){
				//��ȡ����֪ͨ���أ����������Ƿ����֪ͨ���� 0-�ر� 1-����
				Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
				String param70 = sysparamBO.doFindByID("70", "pboss_fx");
				
				//��ȡ���ŷ��ͺ���
				String param7 = sysparamBO.doFindByID("7", "pboss");
				if(param7 == null || "".equals(param7)){
					param7 = "10086";
				}
				
				//��ȡ����ʱ��
				String param58 = sysparamBO.doFindByID("58", "pboss_fx");
				if(param58 == null || "".equals(param58)){
					param58 = "08:30";
				}
				
				if("1".equals(param70)){
					Order bo = (OrderBO) BOFactory.build(OrderBO.class, user);
					
					DBQueryParam dBQueryParam = new DBQueryParam();
					dBQueryParam.set_pagesize("999");
					Map comcategoryMap = Code2NameUtils.valueList("$IM_FXCOMCATEGORY", null, dBQueryParam, user.getCityid());
					
					String sysparam79 = sysparamBO.doFindByID("79", "pboss_fx");
					String sysparam80 = sysparamBO.doFindByID("80", "pboss_fx");
					
					for (int i = 0; i < pkItem.length; i++) {
						OrderVO vo = bo.doFindByPk(pkItem[i]);
						String orderave = vo.getOrderave();//����;��
						
						if("1".equals(sysparam80)){
							if(sysparam79 == null || "".equals(sysparam79)){
								//	���ϵͳ����Ϊ�գ�����ʾ���Զ����䶩������֪ͨϵͳ����δ���á���
								log.info("�Զ����䶩������֪ͨϵͳ����δ����");
								throw new Exception("�Զ����䶩������֪ͨϵͳ����δ����");
							}
							
							//����������Ҳ���ֵ����1�����Ҵ˶����Ķ���;��Ϊ �Զ����䣨AUTO����
							//���ԣ������ţ�ORDERID���Ͷ���״̬Ϊ ����ˣ�AUDITED�� 
							//��ѯ������־��FX_SW_ORDERLOG��������޼�¼�򲻷��Ͷ��š�
							//��֮���Ͷ���֪ͨ
							if("1".equals(sysparam79) && "AUTO".equals(orderave)){
								Orderlog orderlogBO = (OrderlogBO)BOFactory.build(OrderlogBO.class, user);
								OrderlogDBParam orderlogDBParam = new OrderlogDBParam();
								orderlogDBParam.set_se_orderid(pkItem[i]);//�����ţ�ORDERID��
								orderlogDBParam.set_se_orderstate("AUDITED");//����ˣ�AUDITED�� 
								DataPackage orderlogDP = orderlogBO.doQuery(orderlogDBParam);
								
								if(orderlogDP.getRowCount() > 0)
									sms4Cancel(vo, comcategoryMap, cancelReason, param58, param7);
							}
							
							//�˶����Ķ���;����Ϊ �Զ����䣨AUTO������ֱ�ӷ��Ͷ��š�
							if(!"AUTO".equals(orderave) || !("1").equals(sysparam79)){
								sms4Cancel(vo, comcategoryMap, cancelReason, param58, param7);
							}
						}else{
							sms4Cancel(vo, comcategoryMap, cancelReason, param58, param7);
						}
					}
				}
			}
		//}catch (Exception e) {
			//e.printStackTrace();
		//}
	}
	
	private void sms4Cancel(OrderVO vo, Map comcategoryMap, String cancelReason, 
			String param58, String param7) throws Exception{
		Ordercomcate ordercomcateBO = (OrdercomcateBO)BOFactory.build(OrdercomcateBO.class, user);
		String orderid = vo.getOrderid();
		
		//String content = new String(sContentString);
		/*
		 * �𾴵Ŀͻ���{YEAR}��{MONTH}��{DAY}�ս����Ķ��������ϣ�������{ORDERID}��
		 * ��Ʒ[{COMDESC}]������ԭ��[{REASON}]��
		 * �������������ϵ��������򲦴�������ߡ��㶫�ƶ�
		 */
		SimpleDateFormat smYear = new SimpleDateFormat("yyyy");
		SimpleDateFormat smMonth = new SimpleDateFormat("MM");
		SimpleDateFormat smDay = new SimpleDateFormat("dd");
		Date createTime = vo.getCreatetime();
		
		OrdercomcateDBParam ocDBParam = new OrdercomcateDBParam();
		ocDBParam.setDataOnly(true);
		ocDBParam.set_se_orderid(orderid);
		DataPackage ocDp = ordercomcateBO.doQuery(ocDBParam);
		String comDesc = "";
		if (null == ocDp
				|| null == ocDp.getDatas()
				|| ocDp.getDatas().size() < 1){
			
		}else{
			List<OrdercomcateVO> ocList = ocDp.getDatas();
			for (OrdercomcateVO ocVO : ocList) {
				String comcategory = ocVO.getComcategory();
				Long orderamt = ocVO.getOrderamt();
				if(comcategory.indexOf("CZ")>=0){//��ֵ��
					comDesc=comDesc+comcategoryMap.get(comcategory)+""+orderamt+"��"+",";
				}else{//�׿�
					comDesc=comDesc+comcategoryMap.get(comcategory)+""+orderamt+"��"+",";
				}
			}
		}
		if(comDesc != null && !"".equals(comDesc)){
			comDesc=comDesc.substring(0, comDesc.length()-1);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("YEAR", smYear.format(createTime));
		map.put("MONTH", ""+smMonth.format(createTime));
		map.put("DAY", smDay.format(createTime));
		map.put("ORDERID", orderid);
		map.put("REASON", ""+cancelReason);
		map.put("COMDESC", comDesc);
		Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
		String content = smstmplBO.doGenSMS("FX_ORDER_CANCELNOTICE", map);
		
		if(content != null && !"".equals(content)){
			//���ŷ���
			//��ѯ�ֻ�����
			Employee  employee = (EmployeeBO) BOFactory.build(EmployeeBO.class, user);
			EmployeeDBParam employeeList=new EmployeeDBParam();
			employeeList.set_se_wayid(vo.getWayid());
			employeeList.set_ne_empstatus("0");
			employeeList.set_ne_isnet("1");
			DataPackage employeeDp= employee.doQuery(employeeList);
			if(employeeDp.getRowCount()>0){
				Iterator it=employeeDp.getDatas().iterator();
				if(it.hasNext()){
					EmployeeVO empVO=(EmployeeVO)it.next();
					String officetel=empVO.getOfficetel();
					
					if(officetel != null && !"".equals(officetel) && officetel.length() == 11){
						//���ŷ���
						
	    				SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
	    				SimpleDateFormat dateTimeFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    				Calendar calendar = Calendar.getInstance();
	    				Date sendDate = dateTimeFormat2.parse(
								dateTimeFormat.format(calendar.getTime()) + " " + param58);
	    				WaitreqBO waitreqBO = (WaitreqBO)BOFactory.build(WaitreqBO.class,user);
	    				
	    				waitreqBO.doInsert3(new Short("3"), content, param7, officetel,sendDate);
					}
				}
			}
		}
	}
	
	public List doExcelRes(OrderDBParam orderDBParam) throws Exception {
		OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
		return dao.doExcelRes(orderDBParam);
	}

	public void doReview(String orderid) throws Exception {
		OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
		OrderDBParam param = new OrderDBParam();
		param.set_se_orderid(orderid);
		DataPackage dp = dao.query(param);
		if(dp.getRowCount() > 0){
			OrderVO orderVO = (OrderVO)dp.getDatas().get(0);
			orderVO.setReviewstate(Integer.parseInt("1"));
			
			dao.update(orderVO);
		}
	}
	/**
	 * �ӿڵ��óɹ���֪ͨ����������ۡ�
	 * 
	 * @param orderid
	 *            �������
	 * @throws Exception
	 */
	public void doSendSucInfo(String orderid) throws Exception {

		// �ӿڵ��óɹ���֪ͨ����������ۡ�
		// �������ݵ����Ŵ����ͱ�(CH_SMS_WAITREQ)���ֶ�ȡֵ���£�
		// ��������ȡ3��
		// ���ͺ��룺��ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����������ʶΪ��42�������ͺ���ȡ����ֵ��
		// ���պ��룺���ݶ��������������ȡ����ϵ��ʽ��
		// �������ݣ�������Ʒ�������Ź��÷��������������֪ͨ����ȡ��
		// �ͻ�����ȡ�������ƣ�������ֶ�Ϊ����Ĭ��ȡ���ͻ����������ţ�
		Sysparam sysparamBO = (Sysparam) BOFactory
				.build(SysparamBO.class, user);
		Waitreq waitreqBO = (Waitreq) BOFactory.build(WaitreqBO.class, user);
		ComOrderSms comOrderSms = new ComOrderSms();
		// ��ȡ���ŷ��ͺ���
		String sysparamvalue42 = sysparamBO.doFindByID("42", "pboss_fx");
		WaitreqVO waitreqVO = new WaitreqVO();
		waitreqVO.setSmstype((short) 3);
		waitreqVO.setAreacode(user.getCityid());
		waitreqVO.setCreattime(new java.util.Date());
		waitreqVO.setSendno(sysparamvalue42);

		// ��ѯ���������
		EmployeeBO employeeBO = (EmployeeBO) BOFactory.build(EmployeeBO.class,
				user);
		EmployeeDBParam employeeDBParam = new EmployeeDBParam();
		employeeDBParam.set_se_wayid(orderid);
		employeeDBParam.set_se_empstatus(Short.parseShort("0"));
		DataPackage dp = employeeBO.doQuery(employeeDBParam);
		if (dp.getDatas() != null && dp.getDatas().size() > 0) {
			EmployeeVO employeeVO = (EmployeeVO) dp.getDatas().get(0);
			waitreqVO.setRecno(employeeVO.getOfficetel());
		}

		// ��װ��������
		// ��ѯ������Ϣ
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayVO vo = way.doFindByPk(orderid);
		String wayname = "";
		if (vo != null && vo.getWayname() != null
				&& !vo.getWayname().equals("")) {
			wayname = vo.getWayname();
		} else {
			wayname = "�ͻ�";
		}
		waitreqVO.setMessage(comOrderSms.getCanSaleNotice(wayname, orderid,
				user));
		waitreqBO.doCreate(waitreqVO);

	}
	
	
     /** �ӿڵ���ʧ�ܺ����������������
	 * 
	 * @param orderid
	 *            �������
	 * @param countyid
	 *           	�ֹ�˾
	 * @throws Exception
	 */
	public void doSendFailInfo(String orderid, String countyid)
			throws Exception {

		// �ӿڵ���ʧ�ܺ����������������
		// �������ݵ����Ŵ����ͱ�(CH_SMS_WAITREQ)���ֶ�ȡֵ���£�
		// ��������ȡ3��
		// ���ͺ��룺��ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����������ʶΪ��42�������ͺ���ȡ����ֵ��
		// ���պ��룺�ֹ�˾��������
		// �������ݣ�������Ʒ�������Ź��÷��������������֪ͨ����ȡ��
		// �ͻ�����ȡ�ֹ�˾�����������ƣ�������ֶ�Ϊ����Ĭ��ȡ�����������������ţ�

		Smsobject smsobjectBO = (SmsobjectBO) BOFactory.build(
				SmsobjectBO.class, user);

		SmsobjectDBParam smsobjectDBParam = new SmsobjectDBParam();
		smsobjectDBParam.set_se_countyid(countyid);
		smsobjectDBParam.set_se_objecttype("WAYMANAGER");
		smsobjectDBParam.set_se_busitype("OTHERS");
		DataPackage smsobjectdp = smsobjectBO.doQuery(smsobjectDBParam);

		if (smsobjectdp != null && smsobjectdp.getDatas() != null
				&& smsobjectdp.getDatas().size() > 0) {

			Sysparam sysparamBO = (Sysparam) BOFactory.build(SysparamBO.class,
					user);
			Waitreq waitreqBO = (Waitreq) BOFactory
					.build(WaitreqBO.class, user);
			ComOrderSms comOrderSms = new ComOrderSms();
			// ��ȡ���ŷ��ͺ���
			String sysparamvalue42 = sysparamBO.doFindByID("42", "pboss_fx");
			WaitreqVO waitreqVO = new WaitreqVO();
			waitreqVO.setSmstype((short) 3);
			waitreqVO.setAreacode(user.getCityid());
			waitreqVO.setCreattime(new java.util.Date());
			waitreqVO.setSendno(sysparamvalue42);

			String wayname = "";

			// ��ȡ���������ֻ��ţ�
			// ��ѯ����֪ͨ�����(FX_SW_SMSOBJECT),ƥ��ֹ�˾Ϊ�˶����ķֹ�˾��֪ͨ��������Ϊ������������888
			// ҵ������Ϊ������������ȡ�ֻ����루�����ֻһ�������ÿһ���ֻ����뷢�Ͷ��ţ���
			for (Iterator<SmsobjectVO> it = smsobjectdp.getDatas().iterator(); it
					.hasNext();) {
				SmsobjectVO smsobjectVO = it.next();
				waitreqVO.setRecno(smsobjectVO.getMobile());
				if (smsobjectVO.getName() != null
						&& smsobjectVO.getName() != null
						&& !smsobjectVO.getName().equals("")) {
					wayname = smsobjectVO.getName();
				} else {
					wayname = "��������";
				}
				waitreqVO.setMessage(comOrderSms.getCanSaleNotice(wayname,
						orderid, user));
				
				if(waitreqVO.getMessage() != null && waitreqVO.getRecno() != null && waitreqVO.getSendno() != null){					
					waitreqBO.doCreate(waitreqVO);	
				}else{
					log.info("���ͺ������պ��������Ϣδ���ã�");
				}
				
			}

		} else {

			log.info("δ���÷ֹ�˾����������ϵ�绰!");

		}

	}
	
	
	//����ʵ�ս��Ļ�����Ϣ
	public Double getAllActAmt(DataPackage dp) throws Exception{
		Double dou = 0d;
		if(dp != null && dp.getDatas() != null && dp.getDatas().size()>0){
			for(Iterator<OrderVO> it = dp.getDatas().iterator();it.hasNext();){
				OrderVO orderVO = it.next();
				dou+=orderVO.getActamt();
			}
		}
		return dou;
	}
	
	
	//�������Ʒ�ƵĻ�����Ϣ
	public String getAllBrandInfo(DataPackage dp) throws Exception{
		StringBuffer str = new StringBuffer("��Դ����Ϣ��");
		
		if(dp != null && dp.getDatas() != null && dp.getDatas().size()>0){
			
			Map map = new HashMap<String,Integer>();
			
			for(Iterator<OrderVO> it = dp.getDatas().iterator();it.hasNext();){
				OrderVO orderVO = it.next();
				String orderinfo = orderVO.getOrderInfo();
				//���ԡ������ָ���Ʒ��
				String [] brands = orderinfo.split(",");
				//���ԡ������ָ�һ��Ʒ�Ƶõ�����
				if(brands != null && brands.length>0){
					for(int i = 0; i < brands.length; i++){
						String brand = brands[i];
						int indexQ = brand.indexOf("(");
						int indexH = brand.indexOf(")");
						
						String brandname = brand.substring(0, indexQ);
						Integer count = Integer.parseInt(brand.substring(indexQ+1, indexH));
						
						Integer Ycount = (Integer) map.get(brandname);
						if(Ycount == null || Ycount == 0){
							map.put(brandname,count);
						}
						else{
							map.put(brandname, Ycount+count);
						}
					}
					
				}
			}
			
			boolean bo = true;
			for(Iterator<String> itt = map.keySet().iterator();itt.hasNext();){
				String ittkey = itt.next();
				Integer brandcount = (Integer) map.get(ittkey);
				
				if(bo){
					str.append(ittkey+"("+brandcount+")");
					bo = false;
				}else{
					str.append(","+ittkey+"("+brandcount+")");
				}
			}
			
			
		}
		return str.toString();
		
		
	}
	
	public void doDeductSendMsg(OrderVO orderVo, String optype, String result, String reason) throws Exception {
		Sysparam sysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,
				user);
		Way wayBO = (WayBO) BOFactory.build(WayBO.class, user);
		String param42 = sysparamBO.doFindByID("42", "pboss_fx");// ���ͺ���
		if (param42 != null && !"".equals(param42)) {

		} else if (null == param42 || "".equals(param42)) {
			throw new Exception("���ͺ���Ϊ��");

		} else {// ������һ��
			return;
		}
		// �ͻ�
		String username = null;
		// ���պ���
		Employee employeeBO = (Employee) BOFactory
				.build(EmployeeBO.class, user);
		EmployeeDBParam employeeDBParam = new EmployeeDBParam();
		employeeDBParam.set_se_wayid(orderVo.getWayid());
		employeeDBParam.set_ne_isnet("1");// ����
		employeeDBParam.set_ne_empstatus("0");// �ڸ�
		String receTel = null;
		DataPackage dp1 = employeeBO.doQuery(employeeDBParam);
		if (null != dp1 && dp1.getDatas().size() > 0) {
			EmployeeVO vo = (EmployeeVO) dp1.getDatas().get(0);
			receTel = vo.getOfficetel();
			username = vo.getEmployeename(); 
		} 
		if (null == receTel || ("").equals(receTel)) {
			throw new Exception("�����ֻ�����Ϊ��");
		}
		if (null == username || ("").equals(username)) {
			username = "�ͻ�";
		}
		// ��Ʒ��Ϣ
		Ordercomcate ordercomcate = (OrdercomcateBO) BOFactory.build(
				OrdercomcateBO.class, user);
		OrdercomcateVO ordercomcateVO = null;
		DataPackage dp = ordercomcate
				.doQueryDataByOrderId(orderVo.getOrderid());
		String comdesc = "";
		if (dp.getDatas().size() > 0) {
			for (int i = 0; i < dp.getDatas().size(); i++) {
				ordercomcateVO = (OrdercomcateVO) dp.getDatas().get(i);
				comdesc += Code2NameUtils.code2Name("$IM_FXCOMCATEGORY",
								ordercomcateVO.getComcategory(), user
										.getCityid())
						+ "("+ordercomcateVO.getOrderamt()+"),";
			}
		}
		if (!("").equals(comdesc)) {
			comdesc = comdesc.substring(0, comdesc.length() - 1);
		}
		if (null == comdesc || ("").equals(comdesc)) {
			throw new Exception("��Ʒ��ϢΪ��");
		}

		// Ӧ�ս��
		double price = orderVo.getRecamt();

		// ��������
		// �𾴵�{CUSTNAME}��������������Ʒ[{COMDESC}]��Ӧ�ս��{ RECAMT
		// }Ԫ��������{ORDERID}���۷ѳɹ����㶫�ƶ���
		Map<String, String> map = new HashMap<String, String>();
		map.put("CUSTNAME", username);
		map.put("COMDESC", comdesc);
		map.put("RECAMT", price + "");
		map.put("ORDERID", orderVo.getOrderid());
		Smstmpl smstmplBO = (SmstmplBO) BOFactory.build(SmstmplBO.class, user);
		String smsContent = null;
		
		if("BATCHDEDUCT".equals(optype)){//���л���
			if (("SUCCESS").equals(orderVo.getDeductstate())) {
				smsContent = smstmplBO.doGenSMS("FX_ORDER_DEDDUCTSUCCESS", map);
			} else if (("FAIL").equals(orderVo.getDeductstate())) {
				smsContent = smstmplBO.doGenSMS("FX_ORDER_DEDDUCTFAILURE", map);
			}
		}else if("CASH".equals(optype)){//�ֽ�
			if ("�ɹ�".equals(result)) {
				smsContent = smstmplBO.doGenSMS("FX_ORDER_DEDDUCTSUCCESS", map);
			} else{
				map.put("REASON", reason);
				smsContent = smstmplBO.doGenSMS("FX_ORDER_CASHFAILURE", map);
			}
		}
		
		if (null == smsContent || "".equals(smsContent.trim())) {// ������һ��
			throw new Exception("��������Ϊ��");
		}
		
		Waitreq waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class, user);
		waitreqBO.doInsert2(new Short("3"), smsContent, param42, receTel);
	}

	// ����������Ҫ����������
	public boolean doDealAllocateData(String[] items) throws Exception {
		boolean result = true;
		// ��Դ��ϸ
		Order order = (OrderBO) BOFactory.build(OrderBO.class, user);
		OrderVO orderVo = new OrderVO();
		orderVo = order.doFindByPk(items[0]);
		Orderresdet orderresdet = (OrderresdetBO) BOFactory.build(
				OrderresdetBO.class, user);
		OrderresdetVO orderresdetVO = null;
		if (null == orderVo || ("").equals(orderVo)) { // ������Ϣ���
			result = false;
			throw new Exception("����������");
		} else {
			OrderresdetDBParam params = new OrderresdetDBParam();
			params.set_se_orderid(orderVo.getOrderid());
			DataPackage dp = orderresdet.doQuery(params);
			if (dp != null && dp.getDatas().size() > 0) {
				orderresdetVO = (OrderresdetVO) dp.getDatas().get(0);
			}
		}
		if(("CHARGED").equals(orderVo.getOrderstate()) || ("DEDUCTING").equals(orderVo.getOrderstate())){  //��������״̬���
			result = false;
			throw new Exception("�����ѽ����շ����̣����ܵ�������");
		}
		if (null != orderresdetVO && !("").equals(orderresdetVO)) { // ������Դ��ϸ���
			result = false;
			throw new Exception("������Դ�ѳ�ȡ");
		}
		if (("CANCEL").equals(orderVo.getOrderstate())) { // ������Դ��ϸ���
			result = false;
			throw new Exception("����������");
		}
		OrdercomcateVO ordercomcateVO = new OrdercomcateVO();
		// �������ݼ��
		Ordercomcate ordercomcate = (OrdercomcateBO) BOFactory.build(
				OrdercomcateBO.class, user);
		OrdercomcateDBParam ordercomcateDBParam = new OrdercomcateDBParam();
		ordercomcateDBParam.set_se_orderid(items[0]);
		String[] allocatedata = items[1].split("\\,");
		double recamt = 0d;
		OrdercomcateVO flag = null;
		DataPackage ordercomcatedp = ordercomcate.doQuery(ordercomcateDBParam);
		if (ordercomcatedp != null && ordercomcatedp.getDatas().size() > 0) {
			flag = (OrdercomcateVO) ordercomcatedp.getDatas().get(0);
		}
		OrdercomcateVO vo1 = null;
		for (int i = 0; i < allocatedata.length; i++) {
			String[] data = allocatedata[i].split("\\#");
			String meno = "";
			if (data.length == 3) {
				meno = data[2];
			}
			String unitage = "";
			if (null != flag && !("").equals(flag)) {
				vo1 = ordercomcate.doFindByPk(flag.getRecid());
				Comorder comorderBO = (Comorder) BOFactory.build(
						ComorderBO.class, user);
				unitage = comorderBO.doGetUnitage(user.getCityid(), vo1
						.getComcategory());
			}
			ordercomcateDBParam.set_se_comcategory(data[0]);
			DataPackage dp = ordercomcate.doQuery(ordercomcateDBParam);
			if (null == dp || dp.getDatas().size() == 0) {
				result = false;
				throw new Exception("�ö�����������Ʒ����[" + data[0] + "]������");
			}
			if (null == data[1] || ("").equals(data[1])) {
				result = false;
				throw new Exception("�ö�����������Ʒ���࣬��������Ϊ��");
			} else if (null != vo1) {
				if (Double.valueOf(data[1]) % Double.valueOf(unitage) > 0) {
					result = false;
					throw new Exception("��������[" + data[1] + "]�Ķ�������Ϊ����������������");
				}
			}
		}
		return result;
	}

	
	/**
	 * ��Ʊ��ӡ
	 */
	public JSONArray doAjaxPrint(String orderid) throws Exception {
		Orderresdet orderresdet = (OrderresdetBO) BOFactory.build(
				OrderresdetBO.class, user);
		DecimalFormat df = new DecimalFormat("#.00");
		DecimalFormat dff = new DecimalFormat("0.##");
		OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class, user);
		OrderresdetDBParam params=new OrderresdetDBParam();
		Map hashmap = new HashMap();
		hashmap.put("oprcode", user.getOprcode());
		double actprice = 0L;//����Ʒ�Ƶ��ܽ��
		StringBuffer sb = new StringBuffer();//������ϸ
		StringBuffer leftstr = new StringBuffer();
		String rightstr = new String();
		
		Map<String,String> hsmap = new HashMap<String,String>();
		hsmap.put("COMRESCARD", "�ο���");
		hsmap.put("COMRESSMP", "SIM��");
		hsmap.put("EMPTYSIM", "�հ׿�");
		
		String unit = "";
		
		//��¼tr���ַ����г��ֵĴ���
		int trcount = 0;

		//�õ������Ļ�����Ϣ
		DataPackage dp = dao.groupbyordercomtype(params, orderid);
		if(dp != null && dp.getDatas() != null && dp.getDatas().size() > 0){
			for(Iterator<Map> it = dp.getDatas().iterator();it.hasNext();){
				//������Ϣ
				Map map = it.next();
				String restype = map.get("restype")+"";
				unit = restype.equals("COMRESCARD")?"��":"��";
				double aprice = map.get("actprice") != null? Double.parseDouble(map.get("actprice")+""):0d;
				actprice += aprice;
				leftstr.append(
						"<tr width='100%'>" +
						"<td width='160px'><font size ='2.5'>"+hsmap.get(restype)+"</font></td>" +
						"<td width='60px'><font size ='2.5'>"+df.format(aprice)+"</font></td>" +
						"<td width='80px'></td>" +
						"</tr>"
		               	);
				trcount++;
				if(trcount == 9){					
					leftstr.append("~");
				}
				
				// ��ϸ���׿�����ֵ����
				if(!restype.equals("EMPTYSIM"))
				{					
					DataPackage dpDetail  = dao.groupbyordercomtypeDetail(params, orderid, restype);
					if(dpDetail != null && dpDetail.getDatas() != null && dpDetail.getDatas().size() > 0){
							for(Iterator<Map> itDetail = dpDetail.getDatas().iterator();itDetail.hasNext();){
								 Map mapdetail = itDetail.next();
								 String comcategory = mapdetail.get("comcategory")+"";
								 String brandname = Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", comcategory, user.getCityid());//����
								 int count = mapdetail.get("statistic") != null ?Integer.parseInt(mapdetail.get("statistic")+""):0;//��������
								 double dou = mapdetail.get("actprice") != null ? Double.parseDouble(mapdetail.get("actprice")+""):0d;
								 String singleactprice = df.format(dou);//�ܽ��
								 
								 //ƴ�����й���Ʒ��
								 leftstr.append(
											"<tr width='100%'>" +
											"<td width='160px'><font size ='2.5'>"+brandname+"</font></td>" +
											"<td width='60px'><font size ='2.5'>"+count+unit+"</font></td>" +
											"<td width='80px'><font size ='2.5'>"+singleactprice+"</font></td>" +
											"</tr>"
							               	);
								 trcount++;
									if(trcount == 9){					
										leftstr.append("~");
									}
							}
					}
				}else{
						//��ϸ���հ׿���
						DataPackage KBSIMDetail  = dao.groupbyordercomtypeKBSIMDetail(params, orderid, restype);
						if(KBSIMDetail != null && KBSIMDetail.getDatas() != null && KBSIMDetail.getDatas().size() > 0){
							for(Iterator<Map> itKBSIMDetail = KBSIMDetail.getDatas().iterator();itKBSIMDetail.hasNext();){
								 Map mapdetail = itKBSIMDetail.next();
								 int count = Integer.parseInt(mapdetail.get("statistic")+"");//��������
								 double dou = mapdetail.get("actprice") != null ? Double.parseDouble(mapdetail.get("actprice")+""):0d;
								 String singleactprice = df.format(dou);//�ܽ��
								 //ƴ�����й���Ʒ��
								 leftstr.append(
											"<tr width='100%'>" +
											"<td width='160px'><font size ='2.5'>�հ�SIM��</font></td>" +
											"<td width='60px'><font size ='2.5'>"+count+"��</font></td>" +
											"<td width='80px'><font size ='2.5'>"+singleactprice+"</font></td>" +
											"</tr>"
							               	);
								 trcount++;
									if(trcount == 9){					
										leftstr.append("~");
									}
							}
					}
				}
			}
	         String leftstr3 = new String();
	         int count = leftstr.toString().indexOf("~");
	          if(count == -1){
	        	  leftstr3 = leftstr.toString();  
	          }else{
	        	  leftstr3 = leftstr.toString().substring(0, count);
	        	  rightstr = leftstr.toString().substring(count+1);
	          }
	          
	  		sb.append("<table width='600px'>" +
					"<tr>" +
					"<td width='50%' valign='top'><table valign='top'>"+leftstr3+"</table></td>" +
					"<td width='50%' valign='top'><table valign='top'>"+rightstr+"</table></td>" +
					"</tr>" +
					"</table>");
			String upperstr = AlarmUtils.NumberToChinese(dff.format(actprice));
			hashmap.put("content", sb.toString());
			hashmap.put("upperstr", upperstr);
			hashmap.put("actprice", df.format(actprice));
		}
		
		JSONArray jsonarray = JSONArray.fromObject(hashmap);
		return jsonarray;
	}

	/**
	 * ҵ�񵥴�ӡ
	 */
	public JSONArray doAjaxPrintBusiness(String orderid, OrderVO orderVO)
			throws Exception {
	//		�������룺�����ĺ����̱���
	//		�������ƣ�����������
	//		�ܼ�Сд������Ӧ�ս��
	//		�ܼƴ�д��������Ӧ�ս��ת���ɴ�д���Ӧ���롣��ʱ��㡰��
	//		�������ݣ����ݶ�����ȡ������Ʒ����������ݡ���Ʒ����Ϊ��Ʒ���ࣻ
	//		��λΪ�ף�����Ϊ�����������г��۸�Ϊԭ��Ʒ�۸��ۿ۵���Ϊ��Ʒ���ۣ�Ӧ�ս��Ϊ��Ʒ�ܼۡ�
		DecimalFormat df = new DecimalFormat("#.00");
		DecimalFormat dff = new DecimalFormat("0.##");
		Com comBO=(Com)BOFactory.build(ComBO.class,user);//��Ʒ����BO
		String wayname = Code2NameUtils.code2Name("#WAYIDINFO", orderVO.getWayid(), user.getCityid());		
		OrdercomcateBO ordercomcateBO = (OrdercomcateBO)BOFactory.build(OrdercomcateBO.class,user);
		Map hashmap = new HashMap();
		OrdercomcateDBParam ordercomcateDBParam = new OrdercomcateDBParam();
		ordercomcateDBParam.set_se_orderid(orderVO.getOrderid());
		DataPackage dp = ordercomcateBO.doQuery(ordercomcateDBParam);
		OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class, user);
		OrderresdetDBParam params=new OrderresdetDBParam();
		
		Comcategoryrela comcategoryrelaBO = (ComcategoryrelaBO) BOFactory.build(ComcategoryrelaBO.class,user);
		ComcategoryrelaDBParam comcategoryrelaDBParam = new ComcategoryrelaDBParam();
		
		
		
		double dou = 0d;
		StringBuffer sb = new StringBuffer();
		sb.append("<table width='600px'  valign='top'>");
		
		if(dp != null && dp.getDatas() != null && dp.getDatas().size() > 0){
			for(Iterator<OrdercomcateVO> it = dp.getDatas().iterator();it.hasNext();){
				OrdercomcateVO ordercomcateVO =	it.next();
				
				//��Ʒԭʼ����
				double comprice = 0D;
				DataPackage business  = dao.groupbyordercomtypeBusiness(params, ordercomcateVO.getOrderid(), ordercomcateVO.getComcategory());
				if(business != null && business.getDatas() != null && business.getDatas().size() > 0){
					for(Iterator<Double> businessit = business.getDatas().iterator();businessit.hasNext();){
						 Double mapdetail = businessit.next();
						 comprice = mapdetail==null?0D:mapdetail/100;
						 break;
					}
				}
				sb.append("<tr  valign='top'>" +
						"<td width='20%'><font size ='2.5'>"+Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", ordercomcateVO.getComcategory(), user.getCityid())+"</font></td>" +//����
						"<td width='7%'><font size ='2.5'>��</font></td>" +//��λ
						"<td width='13%'><font size ='2.5'>"+ordercomcateVO.getOrderamt()+"</font></td>" +//����
						"<td width='10%'><font size ='2.5'>"+(df.format(comprice).equals(".00")?"0.00":df.format(comprice))+"</font></td>" +//�г��۸�
						"<td width='18%'><font size ='2.5'>"+(df.format(ordercomcateVO.getUnitprice()).equals(".00")?"0.00":df.format(ordercomcateVO.getUnitprice())).toString()+"</font></td>" +//�ۿۼ۸�
						"<td width='12%'><font size ='2.5'>"+(df.format(ordercomcateVO.getTotalprice()).equals(".00")?"0.00":df.format(ordercomcateVO.getTotalprice())).toString()+"</font></td>" +//Ӧ�����(Ԫ)
						"<td width='20%'><font size ='2.5'></font></td>" +//��ע
						"</tr>");
				dou += ordercomcateVO.getTotalprice();
			}		
		}
		sb.append("</table>");
		hashmap.put("wayid", orderVO.getWayid());
		hashmap.put("wayname", wayname);
		hashmap.put("lowerprice", df.format(dou));

		String upperprice = dff.format(dou);
		String upperstr = AlarmUtils.NumberToChinese2(upperprice);
		char upperstrarr [] = upperstr.toCharArray();
		int uplen = upperstrarr.length;
		if(upperprice.indexOf(".") == -1)
		{
			hashmap.put("fen", "��");
			hashmap.put("jiao", "��");
			hashmap.put("yuan", 0>=uplen?"��":upperstrarr[uplen-1]);
			hashmap.put("shiyuan", 1>=uplen?"��":upperstrarr[uplen-2]);
			hashmap.put("bai", 2>=uplen?"��":upperstrarr[uplen-3]);
			hashmap.put("qian",3>=uplen?"��":upperstrarr[uplen-4]);
			hashmap.put("wan", 4>=uplen?"��":upperstrarr[uplen-5]);
			hashmap.put("shiwan",5>=uplen?"��":upperstrarr[uplen-6]);
		}else if((upperprice.length() - (upperprice.indexOf(".")+1)) == 1 ){
			hashmap.put("fen", "��");
			hashmap.put("jiao", 0>=uplen?"��":upperstrarr[uplen-1]);
			hashmap.put("yuan", 1>=uplen?"��":upperstrarr[uplen-2]);
			hashmap.put("shiyuan", 2>=uplen?"��":upperstrarr[uplen-3]);
			hashmap.put("bai", 3>=uplen?"��":upperstrarr[uplen-4]);
			hashmap.put("qian",4>=uplen?"��":upperstrarr[uplen-5]);
			hashmap.put("wan", 5>=uplen?"��":upperstrarr[uplen-6]);
			hashmap.put("shiwan",6>=uplen?"��":upperstrarr[uplen-7]);
		}else if((upperprice.length() - (upperprice.indexOf(".")+1)) == 2 ){
			hashmap.put("fen", 0>=uplen?"��":upperstrarr[uplen-1]);
			hashmap.put("jiao",1>=uplen?"��":upperstrarr[uplen-2]);
			hashmap.put("yuan", 2>=uplen?"��":upperstrarr[uplen-3]);
			hashmap.put("shiyuan", 3>=uplen?"��":upperstrarr[uplen-4]);
			hashmap.put("bai", 4>=uplen?"��":upperstrarr[uplen-5]);
			hashmap.put("qian",5>=uplen?"��":upperstrarr[uplen-6]);
			hashmap.put("wan", 6>=uplen?"��":upperstrarr[uplen-7]);
			hashmap.put("shiwan",7>=uplen?"��":upperstrarr[uplen-8]);
		}
		hashmap.put("content", sb.toString());
		JSONArray jsonarray = JSONArray.fromObject(hashmap);
		return jsonarray;
	} 
}
