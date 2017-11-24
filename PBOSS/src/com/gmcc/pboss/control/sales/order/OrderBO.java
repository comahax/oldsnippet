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
		//用来装载查询的结果
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
	 * 订单信息：根据订单编号查询订单商品种类 (FX_SW_ORDERCOMCATE)，
	 * 将同商品种类(已经翻译成中文的)的订购数量进行累加，并按照“商品种类A（数量）， 商品种类B（数量）”进行组合。
	 * 
	 * @param orderID
	 *            订单编号
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
	 * 订单信息：根据订单编号查询订单商品种类 (FX_SW_ORDERCOMCATE)，
	 * 将同商品种类(已经翻译成中文的)的订购数量进行累加，并按照“商品种类A（数量）， 商品种类B（数量）”进行组合。
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
	 * 品牌信息：根据订单编号查询订单商品种类 (FX_SW_ORDERCOMCATE)与商品种类组合关系表 (IM_PR_COMCATEGORYRELA)关联查询得到相应的品牌信息，
	 * 然后对相同品牌的订购数量进行累加，并按照“品牌A（数量），品牌B（数量）”进行组合,充值卡忽略
	 * @param orderID 订单编号
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
			Map<String, Long> brandAndNumMap = new HashMap<String, Long>();// 品牌与数量map
			for (Map<String, String> map : list) {
				String brandTemp = this.getBrand(map.get("COMCATEGORY"));// 品牌
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
	 * 品牌信息：根据订单编号查询订单商品种类 (FX_SW_ORDERCOMCATE)与商品种类组合关系表 (IM_PR_COMCATEGORYRELA)关联查询得到相应的品牌信息，
	 * 然后对相同品牌的订购数量进行累加，并按照“品牌A（数量），品牌B（数量）”进行组合,充值卡忽略
	 * @param dp
	 * @param brandMap
	 * @return
	 * @throws Exception
	 */
	private String doGetBrandInfo(DataPackage dp,Map brandMap) throws Exception {
		StringBuilder result = new StringBuilder(50);
		
		if (null != dp && null != dp.getDatas()) {
			List<Map<String, String>> list = dp.getDatas();
			Map<String, Long> brandAndNumMap = new HashMap<String, Long>();// 品牌与数量map
			for (Map<String, String> map : list) {
				String brandTemp = this.getBrand(map.get("COMCATEGORY"));// 品牌
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
	 * 获取品牌
	 * @param comcategory 订购种类
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
	 * 更新订单状态
	 * 
	 * @param pkItem
	 *            订单号(组)
	 * @param state
	 *            更新为的新状态
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
	 * 订单下一步处理
	 * 
	 * @param orderid
	 *            订单编号
	 * @return String[2] 失败返回NULL
	 * @throws Exception
	 */
	public String[] doNextProcess(String orderid) throws Exception {
		String[] result = null;
		// 根据订单编号查询订单表（FX_SW_ORDER），如果无数据则返回结果标记“2”，提示信息“订单数据不存在”；
		OrderVO orderVO = this.doFindByPk(orderid);
		if (orderVO == null) {
			result = new String[2];
			result[0] = "2";
			result[1] = "订单数据不存在";
			return result;
		}
		// 获取订单流程编号和订单状态，查询订单流程步骤表（FX_RU_ORDERPROCE），
		// 匹配入口状态为当前订单状态，如果无数据则返回结果标记“2”，提示信息“当前订单无下一步操作”；否则继续。
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
			result[1] = "当前订单无下一步操作";
			return result;
		}
		OrderproceVO orderproceVO = (OrderproceVO) orderproceDP.getDatas().get(
				0);// 如有多条数据取第一条

		com.gmcc.pboss.control.sales.process.Process processBO = (ProcessBO) BOFactory
				.build(ProcessBO.class, user);
		ProcessVO processVO = processBO.doFindByPk(orderproceVO.getProcessid());
		// 根据步骤编号查询订单步骤表
		// (FX_RU_PROCESS)，如果不存在数据，则返回结果标记“2”，提示信息“订单步骤[步骤编号]数据不存在”；
		if (null == processVO) {
			result = new String[2];
			result[0] = "2";
			result[1] = "订单步骤[" + orderproceVO.getProcessid() + "]数据不存在";
			return result;
		}

		if ("MANUAL".equals(orderproceVO.getDismode())) {
			// 2) 人工处理模式
			// 如果订单步骤处理模式为人工，则返回结果标记“0”，界面路径为订单步骤中处理界面路径；否则继续
			result = new String[2];
			result[0] = "0";
			result[1] = processVO.getUipath();
			return result;
		}

		if ("AUTO".equals(orderproceVO.getDismode())) {
			// 3) 自动处理模式
			// 如果订单步骤处理模式为自动，根据订单编号、地市标识（当前地市）、有效性（有效）查询订单任务表（FX_SW_ORDERTASK），
			// 如果存在数据则不处理，否则新增数据到订单任务表，编号取SEQ，地市标识取当前地市，
			// 订单编号取当前订单编号，有效性取1有效；创建时间取当前时间。
			// 返回结果标记“1”，提示信息“该订单已进入[订单步骤名称]后台自动处理”。
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
			result[1] = "该订单已进入[" + processVO.getProcessname() + "]后台自动处理";
			return result;
		}

		return result;

	}
	
	/**
	 * 订单下一步处理-处理一批数据
	 * @param orderids 订单编号数组
	 * @return
	 * @throws Exception
	 */
	public List<NextProcessResult> doNextProcess(String[] orderids) throws Exception{
		List<NextProcessResult> results = new ArrayList<NextProcessResult>();
		for(int i=0; i<orderids.length;i++){
			String result[] = this.doNextProcess(orderids[i]);
			if("0".equals(result[0])){
				result[1]="当前订单为人工处理订单";
			}
			NextProcessResult r = new NextProcessResult(Integer.parseInt(result[0]), orderids[i], result[1]);
			results.add(r);
		}
		return results;
	}

	/**
	 * 订单收费
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void doPay(OrderVO vo) throws Exception {
		// 如果送货方式不是“货到付款”，则签收状态检查通过。
		// 如果送货方式为“货到付款”，且签收状态为“已签收”，签收状态检查通过，否则返回提示“送货方式为货到付款，签收状态必须为已签收时，才允许执行收费操作。”。
		if ("ARRIVEPAY".equals(vo.getDelitype())
				&& !"SIGNED".equals(vo.getSignstate())) {
			throw new JOPException(" 送货方式为货到付款，签收状态必须为已签收时，才允许执行收费操作。 ");
		}

		// 首先对提交的订单状态检查：根据订单流程编号和出口状态（已收费）查询订单流程步骤表（FX_RU_ORDERPROCE），如果入口状态不等于当前订单状态则提示“订单状态不正确”并返回，否则继续。
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
			throw new JOPException(" 订单状态不正确 ");
		}

		// 根据界面收费金额更新订单表中的实收金额和POS流水号。 更新订单状态为已收费,更新状态变更时间为当前时间。。
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

	/** 订单入帐
	 * 
	 * @param orderid
	 *            订单编号
	 * @throws Exception
	 */
	public OrderVO doRecorded(String orderid,String bossworkid) throws Exception {
		Order orderBO = (OrderBO) BOFactory.build(OrderBO.class, user);
		OrderVO orderVO = orderBO.doFindByPk(orderid);
		try {
			// 首先对提交的订单状态检查：根据订单流程编号和入口状态（订单状态）查询订单流程步骤表（FX_RU_ORDERPROCE），
			// 如果出口状态非“已完成”，则提示“订单状态不正确”并返回，否则继续。
			log.info("订单["+orderid+"]COMS入账开始");
			if (null == orderVO){
				log.info("订单["+orderid+"]找不到相关的订单");
				throw new JOPException("找不到 [" + orderid + "] 相关的订单");
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
				log.info("订单["+orderid+"]订单状态不正确");
				throw new JOPException(" 订单状态不正确 ");
			}
			OrderproceVO orderproceVO = (OrderproceVO) orderproceDP.getDatas()
					.get(0);
			if (!"FINISHED".equals(orderproceVO.getOutstate())){
				log.info("订单["+orderid+"]订单状态不正确");
				throw new JOPException(" 订单状态不正确 ");
			}				
			// 1) 商品包状态更新：根据订单编号查询订单商品包明细表（FX_SW_ORDERPACKDET），
			// 根据查询结果中的商品批次和包号，将商品包表（IM_PR_COMPACK）中的商品包状态更新为已售(2)。
			log.info("订单["+orderid+"]商品包状态更新开始");
			Orderpackdet orderpackdetBO = (OrderpackdetBO) BOFactory.build(
					OrderpackdetBO.class, user);
			OrderpackdetDBParam orderpackdetParam = new OrderpackdetDBParam();
			orderpackdetParam.setQueryAll(true);
			orderpackdetParam.setDataOnly(true);
			orderpackdetParam.set_se_orderid(orderid);
			DataPackage orderpackdetDP = orderpackdetBO
					.doQuery(orderpackdetParam);
			log.info("根据订单编号查询订单商品包明细表（FX_SW_ORDERPACKDET）,共查到["+orderpackdetDP.getDatas().size()+"]条数据");
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
						log.info(" 商品包不存在  boxnum ："+ orderpackdetVO.getBoxnum() + " batchno:"+ orderpackdetVO.getBatchno());
						throw new JOPException(" 商品包不存在  boxnum ："
								+ orderpackdetVO.getBoxnum() + " batchno:"
								+ orderpackdetVO.getBatchno());
					}
					compackVO.setPackstate("2");
					compackBO.doUpdate(compackVO);
				}

			}
			log.info("订单["+orderid+"]商品包状态更新结束");
			// 2) 商品资源明细状态更新：根据订单编号查询订单资源明细表（FX_SW_ORDERRESDET），
			// 根据资源类别（套卡(COMRESSMP)或充值卡(COMRESCARD)）、商品标识、商品资源编号，将套卡资源表（IM_FX_COMRESSMP）
			// 或充值卡资源表（IM_FX_COMRESCARD）中的商品状态更新为已售。
			log.info("订单["+orderid+"]商品资源明细状态更新开始");
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
					if ("COMRESSMP".equals(orderresdetVO.getRestype())) {// 套卡
						Comressmp comressmpBO = (ComressmpBO) BOFactory.build(
								ComressmpBO.class, user);
						ComressmpVO comressmpVO = new ComressmpVO();
						comressmpVO.setComid(orderresdetVO.getComid());
						comressmpVO.setComresid(orderresdetVO.getComresid());
						comressmpVO = comressmpBO.doFindByPk(comressmpVO);
						if (null == comressmpVO)
							throw new JOPException(" 套卡数据不存在 ："
									+ orderresdetVO.getComresid());

						comressmpVO.setComstate(new Short("2"));
						comressmpVO.setSaletime(new Date());
						comressmpBO.doUpdate(comressmpVO);

					} else if ("COMRESCARD".equals(orderresdetVO.getRestype())) {// 充值卡
						Comrescard comrescardBO = (ComrescardBO) BOFactory
								.build(ComrescardBO.class, user);
						ComrescardVO comrescardVO = new ComrescardVO();
						comrescardVO.setComid(orderresdetVO.getComid());
						comrescardVO.setComresid(orderresdetVO.getComresid());
						comrescardVO = comrescardBO.doFindByPk(comrescardVO);
						if (null == comrescardVO)
							throw new JOPException(" 充值卡数据不存在 ："
									+ orderresdetVO.getComresid());
						comrescardVO.setComstate(new Short("2"));
						// 销售时间更新为当前时间。
						comrescardVO.setSaletime(new Date());
						comrescardBO.doUpdate(comrescardVO);
					} else if ("EMPTYSIM".equals(orderresdetVO.getRestype())) {// 空白SIM卡
						Emptysim emptysimBO = (EmptysimBO) BOFactory.build(
								EmptysimBO.class, user);
						EmptysimVO emptysimVO = new EmptysimVO();
						emptysimVO.setEmptyno(orderresdetVO.getEmptyno());
						emptysimVO = emptysimBO.doFindByPk(emptysimVO.getEmptyno());
						if (null == emptysimVO)
							throw new JOPException(" 空白SIM卡数据不存在 ："
									+ orderresdetVO.getComresid());
						emptysimVO.setUsestate(new Short("2"));
						// 销售时间更新为当前时间。
						//emptysimVO.setBegintime(new Date());
						emptysimBO.doUpdate(emptysimVO);
					}
				}
			}
			log.info("订单["+orderid+"]商品资源明细状态更新结束");
			// 4) 新增合作商资源：新增数据到合作商资源表（FX_SW_PARTNERRES），创建时间取当前时间，
			// 是否激活填否，激活时间留空，其他字段取订单资源明细。
			log.info("订单["+orderid+"]新增合作商资源开始");
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
			log.info("订单["+orderid+"]新增合作商资源结束");
			ICRMService crmService = new CRMService();
			// 如果该地市不是调用CRM接口的话需要新增商品销售中间表。
			if (!crmService.isCRMCityPort(user.getCityid())) {
				// 6) 新增商品销售中间表：根据订单编号查询订单资源明细表（FX_SW_ORDERRESDET），
				// 逐条新增到商品销售中间表（FX_SW_COMSELLMID）。分销订单编号取订单编号；序号从1递增；
				// 地市标识取当前地市标识；商品资源编号、商品标识和商品批次取自订单资源明细表；
				// 资源使用渠道取订单资源明细表中渠道标识字段；根据商品标识查询商品数据表（IM_PR_COM）获取商品原价
				// （即商品单价字段）；根据订单编号、订单商品类型和商品种类查询订单商品种类表（FX_SW_ORDERCOMCATE）
				// 获取实际售价（即商品单价字段）；创建时间取当前时间。
				log.info("订单["+orderid+"]非CRM入账，新增商品销售中间表");
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
						// 如果商品类别为空白SIM卡则跳过。
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
							throw new JOPException(" 无法获取售价   "
									+ orderresdetVO.getOrdercomtype() + " : "
									+ orderresdetVO.getComcategory());
						comsellmidVO.setActprice(tempOrdercomcateVO
								.getUnitprice());
						comsellmidVO.setCreatetime(new Date());
						comsellmidBO.doCreate(comsellmidVO);
					}
				}
				log.info("订单["+orderid+"]非CRM入账，新增商品销售中间表结束");
			}
			// 7) 订单状态更新：修改订单状态为已完成,更新状态变更时间为当前时间。
			log.info("订单["+orderid+"]订单状态更新开始");
			orderVO.setOrderstate("FINISHED");
			orderVO.setStatechgtime(new Date());
			// 调用华为接口前先把wordfid置为-1
			Object objService = crmService.getServicePort(user.getCityid());
			if (objService == null) {// 调用BOSS接口
				log.info("订单["+orderid+"]BOSS入账，设置工单号为："+bossworkid);
				orderVO.setBossworkfid(bossworkid);
			} else {// 调用CRM接口
				if (GDProdPort.class.isInstance(objService)) {// 华为CRM
					log.info("订单["+orderid+"]华为CRM入账，设置工单号为：1");
					orderVO.setBossworkfid("1");
				} else {
					log.info("订单["+orderid+"]从兴CRM入账，设置工单号为：-1");
					orderVO.setBossworkfid("-1");
				}
			}
			
			// 订单入账时间更新：当时系统时间
			orderVO.setRecordtime(new Date());
			log.info("订单["+orderid+"]订单状态更新结束");
			return orderBO.doUpdate(orderVO);
			// sale message
			// doSmsForSale(orderVO);
		} catch (Exception e) {
			e.printStackTrace();
			if (null != e.getCause()){
				log.error("===========recorded()方法===========订单入账失败： "+e.getCause().getMessage());
				throw new JOPException(e.getCause().getMessage());
			}else{
				log.error("===========recorded()方法===========订单入账失败： "+e.getMessage());
				throw new JOPException(e.getMessage());
			}
		}

	}

	/**
	 * 入帐
	 * 
	 * @param orderid
	 *            订单ＩＤ
	 * @param wayid
	 *            操作员渠道ID
	 * @param bossworkid
	 *            boss工单号
	 * bossworkid：0或-1.  后台订单处理类调用为0.其他的调用为-1
	 * CRM入帐的时候0 表示CRM入帐中；BOSS入帐的时候0表示通过自动入帐来处理；-1都表示入帐失败           
	 *            
	 */
	public OrderVO recorded(String orderid, String wayid,String bossworkid) throws Exception {
		try {
			OrderBO bo = (OrderBO) BOFactory.build(OrderBO.class, user);
			return bo.doRecorded(orderid,bossworkid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("入账失败：" + e.getMessage());
		}
	}

	
	/**
	 * 史晓龙：2012年5月26日，这个方法进过多次修改，里面混杂了BOSS入账和CRM入账，建议以后写代码不要再使用，
	 * BOSS改用recordByBoss2(String orderid, String wayid)、recordByBoss(String orderid, String wayid ,String operid)；
	 * CRM改用recordByCRM(String orderid, String wayid)、recordByCRM(String orderid, String wayid, String operid)
	 * 入帐(调用ＢＯＳＳ、CRM接口)
	 * 
	 * @param orderid
	 *            订单ＩＤ
	 * @param wayid
	 *            操作员渠道ID
	 */
	@Deprecated
	public OrderVO recordByBoss(String orderid, String wayid) throws Exception {
		// 调用接口
		// 调用商品销售BOSS入账实时接口，接口协议参照“章节8.2.1新增【商品销售BOSS入账】实时接口”。
		// 操作渠道取当前操作员渠道；操作工号取当前操作员工号；收费方式取订单表中缴费方式字段；
		// 金额取订单表中实收金额字段。如果BOSS返回成功，根据订单编号更新订单表中的BOSS工单编号为接口返回值；
		// 如果BOSS返回失败，根据订单编号更新订单表中的BOSS工单编号为“-1”、备注为“BOSS入账失败”。
		OrderBO bo = (OrderBO) BOFactory.build(OrderBO.class, user);
		OrderVO orderVO = null;
		String portname = "BOSS";
		log.info("recordByBoss()开始");
		try {
			orderVO = bo.doFindByPk(orderid);
			// 防止数据被科学计数法 addby yde
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
			if (objService == null) {// 调用BOSS接口
				BossIAO bossIAO = new BossIAO();
				IncomeAccountDataPack data1 = new IncomeAccountDataPack();
				data1.setWayid(wayid);
				data1.setPbossNo(orderid);
				data1.setOprcode(user.getOprcode());

				data1.setFeeStr(actamt);// 发送的单位是（分）
				ChargeData cd = new ChargeData();

				cd.setChargeType(orderVO.getPaytype());
				cd.setMoney(actamt);
				cd.setPosNo(ChargeData.CHARGE_TYPE_POS.equals(orderVO
						.getPaytype()) ? orderVO.getPosstream() : "");
				data1.setChargeData(cd);
				log.info("bossIAO.incomeAccount()开始");
				result1 = bossIAO.incomeAccount(data1, user.getCityid());
				log.info("bossIAO.incomeAccount()结束");
				if (IncomeAccountResult.RET_TYPE_SUSS.equals(result1.getRet())) {
					orderVO.setBossworkfid(result1.getBossNo());
					orderVO.setMemo(portname + "入帐成功");
					return bo.doUpdate(orderVO);
					// sale for message .
					// doSmsForSale(orderVO);
				} else {
					log.error("订单 :" + orderid + "入帐时" + portname + "处理没有返回成功");
					String msg = result1.getRet() + "-" + result1.getExplain();
					if (IncomeAccountResult.RET_TYPE_NO_EXIST.equals(result1
							.getRet()))
						msg = result1.getRet() + "-" + result1.getExplain()
								+ "[未找到订单对应的商品资源]";
					if (IncomeAccountResult.RET_TYPE_FAIL.equals(result1
							.getRet()))
						msg = result1.getRet() + "-" + result1.getExplain();
//					接口调用失败后短信提醒渠道主管
					bo.doSendFailInfo(orderid,orderVO.getCountyid());
					throw new Exception(msg);
				}
			} else {// 调用CRM接口
				if (GDProdPort.class.isInstance(objService)) {// 华为CRM
					log.info("===============华为入账开始================");
					GDProdPort service = (GDProdPort) objService;
					portname = "CRM";
					Orderinreq orderinreq = new Orderinreq();// 请求内容

					// 写消息头
					log.info("订单["+orderid+"] 写消息头开始");
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
					log.info("订单["+orderid+"] 写消息头完成");
					Msgbody msgboby = new Msgbody();// 消息体
					Orderdetlist orderdetlist = new Orderdetlist();
					Orderdet orderdet = null;
					// 封装订单内容
					log.info("订单["+orderid+"] 封装订单内容开始");
					Orderresdet orderresdetBO = (OrderresdetBO) BOFactory
							.build(OrderresdetBO.class, user);
					OrderresdetDBParam orderresParam = new OrderresdetDBParam();
					orderresParam.setDataOnly(true);
					orderresParam.set_pagesize("0");
					orderresParam.set_se_orderid(orderid);
					List<OrderresdetVO> orderreList = orderresdetBO.doQuery(
							orderresParam).getDatas();// 获取订单资源明细
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
					log.info("=======订单号：" + orderid + "========明细数量："
							+ orderdetlist.getOrderdet().size()
							+ "================");
					msgboby.setOrderdetlist(orderdetlist);// 订单内容

					msgboby.setOrderid(orderid);// 订单编号
					msgboby.setSumamt(actamt);// 订单总费用
					log.info("订单["+orderid+"] 订单总费用："+actamt);
					// 封装收费方式信息列表
					Paytypeinfolist paytypeinfolist = new Paytypeinfolist();// 收费方式信息列表
					Paytypeinfo paytypeinfo = new Paytypeinfo();// 收费方式串
					paytypeinfo.setPaytype(orderVO.getPaytype());// 收费方式
					paytypeinfo.setActamt(actamt);// 实收金额
					paytypeinfo.setPosstream(ChargeData.CHARGE_TYPE_POS
							.equals(orderVO.getPaytype()) ? orderVO
							.getPosstream() : "");// POS交易流水号
					paytypeinfolist.getPaytypeinfo().add(paytypeinfo);
					msgboby.setPaytypeinfolist(paytypeinfolist);

					orderinreq.setMsgbody(msgboby);
					log.info("订单["+orderid+"] 封装订单内容完成");
					// 异步处理，不需要后续处理
					log.info("订单["+orderid+"] 调用CRM入账接口请求报文信息");
					log.info(Object2String.complexObject2Str(orderinreq));
					net.gmcc.ngcrm.Orderinrsp orderinrsp = service.orderin(orderinreq);// 调用CRM入账接口，返回信息
					log.info("订单["+orderid+"] 响应报文信息");
					log.info(Object2String.complexObject2Str(orderinrsp));
					retcode = orderinrsp.getMsgrspheader().getRetinfo().getRetcode();
					retMsg = orderinrsp.getMsgrspheader().getRetinfo().getRetmsg();
					log.info("订单["+orderid+"] 调用CRM入账接口，返回码："+retcode);
					log.info("订单["+orderid+"] 调用CRM入账接口，返回信息:"+retMsg);
					if (0 == retcode) {
						log.info("订单["+orderid+"] 调用CRM入账接口，成功");
						orderVO.setBossworkfid("0");
						bo.doUpdate(orderVO);
					} else {
						log.info("订单["+orderid+"] 调用CRM入账接口，失败");
						throw new Exception(retcode + "-" + retMsg);
					}
					log.info("===============华为入账结束================");
				} else {// 从兴CRM
					log.info("---------------从兴入账开始----------------");
					net.gmcc.ngcrm.pboss.GDProdPort service = (net.gmcc.ngcrm.pboss.GDProdPort) objService;
					portname = "CRM";
					net.gmcc.ngcrm.pboss.Orderinreq orderinreq = new net.gmcc.ngcrm.pboss.Orderinreq();// 请求内容

					// 写消息头
					log.info("订单["+orderid+"] 写消息头开始");
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
					log.info("订单["+orderid+"] 写消息头完成");
					net.gmcc.ngcrm.pboss.Orderinreq.Msgbody msgboby = new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody();// 消息体
					net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist orderdetlist = new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist();
					net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist.Orderdet orderdet = null;
					// 封装订单内容
					log.info("订单["+orderid+"] 封装订单内容开始");
					Orderresdet orderresdetBO = (OrderresdetBO) BOFactory
							.build(OrderresdetBO.class, user);
					OrderresdetDBParam orderresParam = new OrderresdetDBParam();
					orderresParam.setDataOnly(true);
					orderresParam.set_pagesize("0");
					orderresParam.set_se_orderid(orderid);
					List<OrderresdetVO> orderreList = orderresdetBO.doQuery(
							orderresParam).getDatas();// 获取订单资源明细
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
					log.info("=======订单号：" + orderid + "========明细数量："
							+ orderdetlist.getOrderdet().size()
							+ "================");
					msgboby.setOrderdetlist(orderdetlist);// 订单内容

					msgboby.setOrderid(orderid);// 订单编号
					msgboby.setSumamt(actamt);// 订单总费用
					log.info("订单["+orderid+"] 订单总费用："+actamt);
					// 封装收费方式信息列表
					net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist paytypeinfolist = new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist();// 收费方式信息列表
					net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist.Paytypeinfo paytypeinfo = new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist.Paytypeinfo();// 收费方式串
					paytypeinfo.setPaytype(orderVO.getPaytype());// 收费方式
					paytypeinfo.setActamt(actamt);// 实收金额
					paytypeinfo.setPosstream(ChargeData.CHARGE_TYPE_POS
							.equals(orderVO.getPaytype()) ? orderVO
							.getPosstream() : "");// POS交易流水号
					paytypeinfolist.getPaytypeinfo().add(paytypeinfo);
					msgboby.setPaytypeinfolist(paytypeinfolist);

					orderinreq.setMsgbody(msgboby);
					log.info("订单["+orderid+"] 封装订单内容完成");
					// 异步处理，不需要后续处理
					log.info("订单["+orderid+"] 调用CRM入账接口请求报文信息");
					log.info(Object2String.complexObject2Str(orderinreq));
					net.gmcc.ngcrm.pboss.Orderinrsp orderinrsp = service.orderin(orderinreq);// 调用CRM入账接口，返回信息
					log.info("订单["+orderid+"] 响应报文信息");
					log.info(Object2String.complexObject2Str(orderinrsp));
					retcode = orderinrsp.getMsgrspheader().getRetinfo().getRetcode();
					retMsg = orderinrsp.getMsgrspheader().getRetinfo().getRetmsg();
					log.info("订单["+orderid+"] 调用CRM入账接口，返回码："+retcode);
					log.info("订单["+orderid+"] 调用CRM入账接口，返回信息:"+retMsg);
					if (0 == retcode) {
						log.info("订单["+orderid+"] 调用CRM入账接口，成功");
						orderVO.setBossworkfid("0");
						bo.doUpdate(orderVO);
					} else {
						log.info("订单["+orderid+"] 调用CRM入账接口，失败");
						throw new Exception(retcode + "-" + retMsg);
					}
					log.info("---------------从兴入账结束----------------");
				}
			}

			log.info("recordByBoss()结束");
			// successOrders = tmp;
			return orderVO;

		} catch (Exception e) {
			LoggerUtils.error(e, log);
			orderVO.setBossworkfid("-1");
			String errMsg = e.getMessage();
			if (errMsg.length() >= 200)
				errMsg = errMsg.substring(0, 200);
			orderVO.setMemo(portname + "入账失败(" + errMsg + ")");
			bo.doUpdate(orderVO);

			throw new BusinessException(portname + "入帐处理失败：" + e.getMessage(),
					e);
		}
	}
	
	/**
	 * BOSS入账
	 */
	public OrderVO recordByBoss2(String orderid, String wayid) throws Exception{
		return this.recordByBoss(orderid, wayid , null);
	}
	
	//纯BOSS入账
	public OrderVO recordByBoss(String orderid, String wayid ,String operid) throws Exception{
		// 调用接口
		// 调用商品销售BOSS入账实时接口，接口协议参照“章节8.2.1新增【商品销售BOSS入账】实时接口”。
		// 操作渠道取当前操作员渠道；操作工号取当前操作员工号；收费方式取订单表中缴费方式字段；
		// 金额取订单表中实收金额字段。如果BOSS返回成功，根据订单编号更新订单表中的BOSS工单编号为接口返回值；
		// 如果BOSS返回失败，根据订单编号更新订单表中的BOSS工单编号为“-1”、备注为“BOSS入账失败”。
		OrderBO bo = (OrderBO) BOFactory.build(OrderBO.class, user);
		OrderVO orderVO = null;
		String portname = "BOSS";
		log.info("recordByBoss()开始");
		try {
			orderVO = bo.doFindByPk(orderid);
			// 防止数据被科学计数法 addby yde
			String actamt = "";
			DecimalFormat df = new DecimalFormat("0");
			if (orderVO.getActamt() != null) {
				actamt = df.format(orderVO.getActamt() * 100);
			}
			IncomeAccountResult result1 = null;

			// 调用BOSS接口
			BossIAO bossIAO = new BossIAO();
			IncomeAccountDataPack data1 = new IncomeAccountDataPack();
			data1.setWayid(wayid);
			data1.setPbossNo(orderid);
			if(operid!=null && !"".equals(operid.trim())){
				data1.setOprcode(operid);
			}else{
				data1.setOprcode(user.getOprcode());
			}

			data1.setFeeStr(actamt);// 发送的单位是（分）
			ChargeData cd = new ChargeData();

			cd.setChargeType(orderVO.getPaytype());
			cd.setMoney(actamt);
			cd.setPosNo(ChargeData.CHARGE_TYPE_POS.equals(orderVO.getPaytype()) ? orderVO.getPosstream() : "");
			data1.setChargeData(cd);
			log.info("bossIAO.incomeAccount()开始");
			result1 = bossIAO.incomeAccount(data1, user.getCityid());
			log.info("bossIAO.incomeAccount()结束");
			if (IncomeAccountResult.RET_TYPE_SUSS.equals(result1.getRet())) {
				orderVO.setBossworkfid(result1.getBossNo());
				orderVO.setMemo(portname + "入帐成功");
				bo.doUpdate(orderVO);
				// sale for message .
				// doSmsForSale(orderVO);
			} else {
				log.error("订单 :" + orderid + "入帐时" + portname + "处理没有返回成功");
				String msg = result1.getRet() + "-" + result1.getExplain();
				if (IncomeAccountResult.RET_TYPE_NO_EXIST.equals(result1
						.getRet()))
					msg = result1.getRet() + "-" + result1.getExplain()
							+ "[未找到订单对应的商品资源]";
				if (IncomeAccountResult.RET_TYPE_FAIL.equals(result1.getRet()))
					msg = result1.getRet() + "-" + result1.getExplain();
				// 接口调用失败后短信提醒渠道主管
				bo.doSendFailInfo(orderid, orderVO.getCountyid());
				throw new Exception(msg);
			}

			log.info("recordByBoss()结束");
			return orderVO;
		} catch (Exception e) {
			LoggerUtils.error(e, log);
			orderVO.setBossworkfid("-1");
			String errMsg = e.getMessage();
			if (errMsg.length() >= 200)
				errMsg = errMsg.substring(0, 200);
			orderVO.setMemo(portname + "入账失败(" + errMsg + ")");
			bo.doUpdate(orderVO);

			throw new BusinessException(portname + "入帐处理失败：" + e.getMessage(),e);
		}
	}
	
	/**
	 * CRM入账
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
		log.info("订单["+orderid+"]recordByCRM()开始");
		try {
			orderVO = bo.doFindByPk(orderid);
			log.info("订单["+orderid+"] 根据订单号获取到订单记录");
			// 防止数据被科学计数法 addby yde
			String actamt = "";
			DecimalFormat df = new DecimalFormat("0");
			if (orderVO.getActamt() != null) {
				actamt = df.format(orderVO.getActamt() * 100);
			}

			ICRMService crmService = new CRMService();
			Object objService = crmService.getServicePort(user.getCityid());
			int retcode = -1;
			String retMsg = "";
			 // 调用CRM接口
			if (GDProdPort.class.isInstance(objService)) {// 华为CRM
				log.info("订单["+orderid+"]===============华为入账开始================");
				
				GDProdPort service = (GDProdPort) objService;
				Orderinreq orderinreq = new Orderinreq();// 请求内容

				// 写消息头
				log.info("订单["+orderid+"] 写消息头开始");
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
				log.info("订单["+orderid+"] 写消息头完成");
				Msgbody msgboby = new Msgbody();// 消息体
				Orderdetlist orderdetlist = new Orderdetlist();
				Orderdet orderdet = null;
				// 封装订单内容
				log.info("订单["+orderid+"] 封装订单内容开始");
				Orderresdet orderresdetBO = (OrderresdetBO) BOFactory.build(
						OrderresdetBO.class, user);
				OrderresdetDBParam orderresParam = new OrderresdetDBParam();
				orderresParam.setDataOnly(true);
				orderresParam.set_pagesize("0");
				orderresParam.set_se_orderid(orderid);
				List<OrderresdetVO> orderreList = orderresdetBO.doQuery(
						orderresParam).getDatas();// 获取订单资源明细
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
						orderdet.setComresid(vo.getEmptyno());//如果是空白SIM卡，把空卡序列号封装进商品资源编号						
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
				log.info("=======订单号：" + orderid + "========明细数量："
						+ orderdetlist.getOrderdet().size()
						+ "================");
				msgboby.setOrderdetlist(orderdetlist);// 订单内容

				msgboby.setOrderid(orderid);// 订单编号
				msgboby.setSumamt(actamt);// 订单总费用
				log.info("订单["+orderid+"] 订单总费用："+actamt);

				// 封装收费方式信息列表
				Paytypeinfolist paytypeinfolist = new Paytypeinfolist();// 收费方式信息列表
				Paytypeinfo paytypeinfo = new Paytypeinfo();// 收费方式串
				paytypeinfo.setPaytype(orderVO.getPaytype());// 收费方式
				paytypeinfo.setActamt(actamt);// 实收金额
				paytypeinfo.setPosstream(ChargeData.CHARGE_TYPE_POS
						.equals(orderVO.getPaytype()) ? orderVO.getPosstream()
						: "");// POS交易流水号
				paytypeinfolist.getPaytypeinfo().add(paytypeinfo);
				msgboby.setPaytypeinfolist(paytypeinfolist);

				orderinreq.setMsgbody(msgboby);
				log.info("订单["+orderid+"] 封装订单内容完成");
				// 异步处理，不需要后续处理
				log.info("订单["+orderid+"] 调用CRM入账接口请求报文信息");
				log.info(Object2String.complexObject2Str(orderinreq));
				net.gmcc.ngcrm.Orderinrsp orderinrsp = service.orderin(orderinreq);// 调用CRM入账接口，返回信息
				log.info("订单["+orderid+"] 响应报文信息");
				log.info(Object2String.complexObject2Str(orderinrsp));
				retcode = orderinrsp.getMsgrspheader().getRetinfo().getRetcode();
				retMsg = orderinrsp.getMsgrspheader().getRetinfo().getRetmsg();
				log.info("订单["+orderid+"] 调用CRM入账接口，返回码："+retcode);
				log.info("订单["+orderid+"] 调用CRM入账接口，返回信息:"+retMsg);
				if (0 == retcode) {
					log.info("订单["+orderid+"] 调用CRM入账接口，成功");
					orderVO.setBossworkfid("0");
					bo.doUpdate(orderVO);
				} else {
					log.info("订单["+orderid+"] 调用CRM入账接口，失败");
					throw new Exception(retcode + "-" + retMsg);
				}
				log.info("===============华为入账结束================");
			} else {// 从兴CRM
				log.info("---------------从兴入账开始----------------");
				net.gmcc.ngcrm.pboss.GDProdPort service = (net.gmcc.ngcrm.pboss.GDProdPort) objService;
				portname = "CRM";
				net.gmcc.ngcrm.pboss.Orderinreq orderinreq = new net.gmcc.ngcrm.pboss.Orderinreq();// 请求内容

				// 写消息头
				log.info("订单["+orderid+"] 写消息头开始");
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
				log.info("订单["+orderid+"] 写消息头完成");
				
				net.gmcc.ngcrm.pboss.Orderinreq.Msgbody msgboby = new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody();// 消息体
				net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist orderdetlist = new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist();
				net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist.Orderdet orderdet = null;
				// 封装订单内容
				log.info("订单["+orderid+"] 封装订单内容开始");
				Orderresdet orderresdetBO = (OrderresdetBO) BOFactory
						.build(OrderresdetBO.class, user);
				OrderresdetDBParam orderresParam = new OrderresdetDBParam();
				orderresParam.setDataOnly(true);
				orderresParam.set_pagesize("0");
				orderresParam.set_se_orderid(orderid);
				List<OrderresdetVO> orderreList = orderresdetBO.doQuery(
						orderresParam).getDatas();// 获取订单资源明细
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
				log.info("=======订单号：" + orderid + "========明细数量："
						+ orderdetlist.getOrderdet().size()
						+ "================");
				msgboby.setOrderdetlist(orderdetlist);// 订单内容

				msgboby.setOrderid(orderid);// 订单编号
				msgboby.setSumamt(actamt);// 订单总费用
				log.info("订单["+orderid+"] 订单总费用："+actamt);
				// 封装收费方式信息列表
				net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist paytypeinfolist = new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist();// 收费方式信息列表
				net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist.Paytypeinfo paytypeinfo = new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist.Paytypeinfo();// 收费方式串
				paytypeinfo.setPaytype(orderVO.getPaytype());// 收费方式
				paytypeinfo.setActamt(actamt);// 实收金额
				paytypeinfo.setPosstream(ChargeData.CHARGE_TYPE_POS
						.equals(orderVO.getPaytype()) ? orderVO
						.getPosstream() : "");// POS交易流水号
				paytypeinfolist.getPaytypeinfo().add(paytypeinfo);
				msgboby.setPaytypeinfolist(paytypeinfolist);

				orderinreq.setMsgbody(msgboby);
				log.info("订单["+orderid+"] 封装订单内容完成");
				// 异步处理，不需要后续处理
				log.info("订单["+orderid+"] 调用CRM入账接口请求报文信息");
				log.info(Object2String.complexObject2Str(orderinreq));
				net.gmcc.ngcrm.pboss.Orderinrsp orderinrsp = service.orderin(orderinreq);// 调用CRM入账接口，返回信息
				log.info("订单["+orderid+"] 响应报文信息");
				log.info(Object2String.complexObject2Str(orderinrsp));
				retcode = orderinrsp.getMsgrspheader().getRetinfo().getRetcode();
				retMsg = orderinrsp.getMsgrspheader().getRetinfo().getRetmsg();
				log.info("订单["+orderid+"] 调用CRM入账接口，返回码："+retcode);
				log.info("订单["+orderid+"] 调用CRM入账接口，返回信息:"+retMsg);
				if (0 == retcode) {
					log.info("订单["+orderid+"] 调用CRM入账接口，成功");
					orderVO.setBossworkfid("0");
					bo.doUpdate(orderVO);
				} else {
					log.info("订单["+orderid+"] 调用CRM入账接口，失败");
					throw new Exception(retcode + "-" + retMsg);
				}
				log.info("---------------从兴入账结束----------------");
			}			

			log.info("recordByCRM()结束");
			return orderVO;
		} catch (Exception e) {
			LoggerUtils.error(e, log);
			orderVO.setBossworkfid("-1");
			String errMsg = e.getMessage();
			if (errMsg.length() >= 200)
				errMsg = errMsg.substring(0, 200);
			orderVO.setMemo(portname + "入账失败(" + errMsg + ")");
			bo.doUpdate(orderVO);
			log.info(portname +"订单["+orderid+"] 入帐处理失败："+ e.getMessage());
			throw new BusinessException(portname + "入帐处理失败：" + e.getMessage(),e);
		}
	}
	
	public void doSmsForSale(OrderVO orderVO) throws Exception {
//		如果BOSS返回成功，且订单资源明细FX_SW_ORDERRESDET存在套卡数据（资源类别为套卡），则发送售卡通知短信，否则不处理。
		Orderresdet  orderdet = (OrderresdetBO) BOFactory.build(OrderresdetBO.class, user);
		OrderresdetDBParam orderdetList=new OrderresdetDBParam();
		orderdetList.set_se_orderid(orderVO.getOrderid());
		orderdetList.set_se_restype("COMRESSMP");
		
		
		if(orderdet.doQuery(orderdetList).getRowCount()>0)
		{
			//描述
			String desc=null;
			//手机号码
			String officetel=null;
			//查询短信模板表
			Smstmpl  smstmpl = (SmstmplBO) BOFactory.build(SmstmplBO.class, user);
			SmstmplVO smstmplVO=null;
			smstmplVO=smstmpl.doFindByPk("FX_SALE_NOTICE");
			if(smstmplVO!=null && "1".equals(smstmplVO.getSstate()))
			{
				//查询手机号码
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
							//统计商品种类
							desc= dao.groupbyDet(queryParam,orderVO.getOrderid(),user);
							//替换短信模板
							String content=smstmplVO.getScontent();
							Date creTime=orderVO.getCreatetime();
							SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
							String sTime=sm.format(creTime);
							String time[]=StringUtils.splitPreserveAllTokens(sTime,"-");
							content=replace(content,time[0]);
							content=replace(content,time[1]);
							content=replace(content,time[2]);
							content=replace(content,desc);
							//新增数据到短信待发送表(CH_SMS_WAITREQ)，短信类型取3，短信内容和接收号码取已获取的数据。
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
	 * boss 补送入账
	 * 
	 * @param orders
	 *            订单编辑（支持多个）
	 * @param wayid
	 *            操作渠道
	 * @return String[0]:补送成功的订单编辑 （多个之间用豆号[，]分开）；String[1]补送失败的订单编辑
	 *         （多个之间用豆号[，]分开）
	 */
	public String[] bossSupplyRecorded(String[] orders, String wayid)
			throws Exception {
		String[] result = new String[2];
		String successOrders = "";
		String failOrders = "";
		OrderBO bo = (OrderBO) BOFactory.build(OrderBO.class, user);
		IncomeAccountResult result1 = null;
		String portname="BOSS";

		log.info("bossSupplyRecorded()开始");
		for (String orderid : orders) {
			OrderVO orderVO = null;
			
			try {
				result1 = null;
				orderVO = bo.doFindByPk(orderid);
				//防止数据被科学计数法 addby yde
				String actamt = "";
				DecimalFormat df = new DecimalFormat("0");
				if(orderVO.getActamt()!=null){
					actamt = df.format(orderVO.getActamt() * 100);
				}
				
				ICRMService crmService=new CRMService();
				Object objService=crmService.getServicePort(user.getCityid());
				int retcode = -1;
				String retMsg = "";
				if(objService==null){//调用BOSS接口
					portname="BOSS";
					BossIAO bossIAO = new BossIAO();
					IncomeAccountDataPack data1 = new IncomeAccountDataPack();
					data1.setWayid(wayid);
					data1.setPbossNo(orderid);
					data1.setOprcode(user.getOprcode());
					
					
					data1.setFeeStr(actamt);// 发送的单位是（分）
					ChargeData cd = new ChargeData();
	
					cd.setChargeType(orderVO.getPaytype());
					cd.setMoney(actamt);
					cd.setPosNo(ChargeData.CHARGE_TYPE_POS.equals(orderVO
							.getPaytype()) ? orderVO.getPosstream() : "");
					data1.setChargeData(cd);
					
					log.info("bossIAO.incomeAccount()开始");
					result1 = bossIAO.incomeAccount(data1, user.getCityid());
					log.info("bossIAO.incomeAccount()结束");
					if (IncomeAccountResult.RET_TYPE_SUSS.equals(result1.getRet())) {
						successOrders += "," + orderid;
						orderVO.setBossworkfid(result1.getBossNo());
						orderVO.setMemo("补送"+portname+"成功");
						bo.doUpdate(orderVO);
					} else {
						log.error(" 订单 :" + orderid + "补送"+portname+" 入账时"+portname+"处理没有返回成功");
						String msg = result1.getRet() + "-" + result1.getExplain();
						if (IncomeAccountResult.RET_TYPE_NO_EXIST.equals(result1
								.getRet()))
							msg += result1.getRet() + "-" + result1.getExplain()
									+ "[未找到订单对应的商品资源]";
						if (IncomeAccountResult.RET_TYPE_FAIL.equals(result1
								.getRet()))
							msg += result1.getRet() + "-" + result1.getExplain();
						throw new Exception(msg);
					}
				}else{//调用CRM接口
					if(GDProdPort.class.isInstance(objService)){//华为CRM
						log.info("===============华为补送入账开始================");
						GDProdPort service = (GDProdPort)objService;
						portname="CRM";
						Orderinreq orderinreq=new Orderinreq();//请求内容
						
						//写消息头
						log.info("订单["+orderid+"] 写消息头开始");
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
						log.info("订单["+orderid+"] 写消息头完成");
						Msgbody msgboby=new Msgbody();//消息体
						Orderdetlist orderdetlist=new Orderdetlist();
						Orderdet orderdet=null;
						//封装订单内容
						log.info("订单["+orderid+"] 封装订单内容开始");
						Orderresdet orderresdetBO = (OrderresdetBO) BOFactory.build(OrderresdetBO.class, user);
						 OrderresdetDBParam  orderresParam=new OrderresdetDBParam();
						 orderresParam.setDataOnly(true);
						 orderresParam.set_pagesize("0");
						 orderresParam.set_se_orderid(orderid);
						 List<OrderresdetVO> orderreList=orderresdetBO.doQuery(orderresParam).getDatas();//获取订单资源明细
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
						 log.info("=======订单号："+orderid+"========明细数量："+orderdetlist.getOrderdet().size()+"================");
						 msgboby.setOrderdetlist(orderdetlist);//订单内容
						 
						msgboby.setOrderid(orderid);//订单编号
						msgboby.setSumamt(actamt);//订单总费用
						log.info("订单["+orderid+"] 订单总费用："+actamt);
						//封装收费方式信息列表
						Paytypeinfolist paytypeinfolist=new Paytypeinfolist();//收费方式信息列表
						Paytypeinfo paytypeinfo=new Paytypeinfo();//收费方式串
						paytypeinfo.setPaytype(orderVO.getPaytype());//收费方式
						paytypeinfo.setActamt(actamt);//实收金额
						paytypeinfo.setPosstream(ChargeData.CHARGE_TYPE_POS.equals(orderVO
								.getPaytype()) ? orderVO.getPosstream() : "");//POS交易流水号
						paytypeinfolist.getPaytypeinfo().add(paytypeinfo);
						msgboby.setPaytypeinfolist(paytypeinfolist);
						
						orderinreq.setMsgbody(msgboby);
						log.info("订单["+orderid+"] 封装订单内容完成");
						// 异步处理，不需要后续处理
						log.info("订单["+orderid+"] 调用CRM入账接口请求报文信息");
						log.info(Object2String.complexObject2Str(orderinreq));
						net.gmcc.ngcrm.Orderinrsp orderinrsp = service.orderin(orderinreq);//调用CRM入账接口，返回信息
						log.info("订单["+orderid+"] 响应报文信息");
						log.info(Object2String.complexObject2Str(orderinrsp));
						retcode = orderinrsp.getMsgrspheader().getRetinfo().getRetcode();
						retMsg = orderinrsp.getMsgrspheader().getRetinfo().getRetmsg();
						log.info("订单["+orderid+"] 调用CRM入账接口，返回码："+retcode);
						log.info("订单["+orderid+"] 调用CRM入账接口，返回信息:"+retMsg);
						if(0 == retcode){
							log.info("订单["+orderid+"] 调用CRM入账接口，成功");
							successOrders += "," + orderid;
							orderVO.setBossworkfid("0");
							orderVO.setMemo(null);
							bo.doUpdate(orderVO);
						}else{
							log.error(" 订单 :" + orderid + "补送"+portname+" 入账时"+portname+"处理没有返回成功");
							throw new Exception(retcode+"-"+retMsg);
						}
						log.info("===============华为补送入账结束================");
					}else{//从兴 CRM
						log.info("---------------从兴补送入账开始----------------");
						net.gmcc.ngcrm.pboss.GDProdPort service = (net.gmcc.ngcrm.pboss.GDProdPort)objService;
						portname="CRM";
						net.gmcc.ngcrm.pboss.Orderinreq orderinreq=new net.gmcc.ngcrm.pboss.Orderinreq();//请求内容
						
						//写消息头
						log.info("订单["+orderid+"] 写消息头开始");
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
						log.info("订单["+orderid+"] 写消息头完成");
						net.gmcc.ngcrm.pboss.Orderinreq.Msgbody msgboby=new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody();//消息体
						net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist orderdetlist=new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist();
						net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Orderdetlist.Orderdet orderdet=null;
						//封装订单内容
						log.info("订单["+orderid+"] 封装订单内容开始");
						Orderresdet orderresdetBO = (OrderresdetBO) BOFactory.build(OrderresdetBO.class, user);
						 OrderresdetDBParam  orderresParam=new OrderresdetDBParam();
						 orderresParam.setDataOnly(true);
						 orderresParam.set_pagesize("0");
						 orderresParam.set_se_orderid(orderid);
						 List<OrderresdetVO> orderreList=orderresdetBO.doQuery(orderresParam).getDatas();//获取订单资源明细
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
						 log.info("=======订单号："+orderid+"========明细数量："+orderdetlist.getOrderdet().size()+"================");
						 msgboby.setOrderdetlist(orderdetlist);//订单内容
						 
						msgboby.setOrderid(orderid);//订单编号
						msgboby.setSumamt(actamt);//订单总费用
						log.info("订单["+orderid+"] 订单总费用："+actamt);
						//封装收费方式信息列表
						net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist paytypeinfolist=new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist();//收费方式信息列表
						net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist.Paytypeinfo paytypeinfo=new net.gmcc.ngcrm.pboss.Orderinreq.Msgbody.Paytypeinfolist.Paytypeinfo();//收费方式串
						paytypeinfo.setPaytype(orderVO.getPaytype());//收费方式
						paytypeinfo.setActamt(actamt);//实收金额
						paytypeinfo.setPosstream(ChargeData.CHARGE_TYPE_POS.equals(orderVO
								.getPaytype()) ? orderVO.getPosstream() : "");//POS交易流水号
						paytypeinfolist.getPaytypeinfo().add(paytypeinfo);
						msgboby.setPaytypeinfolist(paytypeinfolist);
						
						orderinreq.setMsgbody(msgboby);
						log.info("订单["+orderid+"] 封装订单内容完成");
						// 异步处理，不需要后续处理
						log.info("订单["+orderid+"] 调用CRM入账接口请求报文信息");
						log.info(Object2String.complexObject2Str(orderinreq));
						net.gmcc.ngcrm.pboss.Orderinrsp orderinrsp = service.orderin(orderinreq);//调用CRM入账接口，返回信息
						log.info("订单["+orderid+"] 响应报文信息");
						log.info(Object2String.complexObject2Str(orderinrsp));
						retcode = orderinrsp.getMsgrspheader().getRetinfo().getRetcode();
						retMsg = orderinrsp.getMsgrspheader().getRetinfo().getRetmsg();				
						if(0 == retcode){
							log.info("订单["+orderid+"] 调用CRM入账接口，成功");
							successOrders += "," + orderid;
							orderVO.setBossworkfid("0");
							orderVO.setMemo(null);
							bo.doUpdate(orderVO);
						}else{
							log.error(" 订单 :" + orderid + "补送"+portname+" 入账时"+portname+"处理没有返回成功");
							throw new Exception(retcode+"-"+retMsg);
						}
						 log.info("---------------从兴补送入账结束----------------");
					}
					
				}
			} catch (Exception e) {
				failOrders += "," + orderid;
				log.error(" 订单 :" + orderid + "补送"+portname+" 入账处理失败");
				//e.printStackTrace();
				//失败以后再查询一把,看是否状态仍旧是-1，如果是-1，则记录情况,否则不对orderVO再作更新
				OrderVO pkVO=bo.doFindByPk(orderVO.getOrderid());
				if(pkVO==null)
				{
					throw new Exception("orderid="+orderVO.getOrderid()+"没有查询到相应记录");
				}
				try {
					if (orderVO != null) {
						if(pkVO!=null && "-1".equals(pkVO.getBossworkfid()))
						{
						//如有两个人同时处理这条订单,为-1表示没有处理成功,如果另一人处理成功,则无须再处理这条订单记录.
						String errMsg = e.getMessage();
						if (errMsg.length() >= 200)
							errMsg = errMsg.substring(0, 200);
						orderVO.setMemo("补送"+portname+"入账失败(" + errMsg + ")");
						bo.doUpdate(orderVO);
						}
					}
				} catch (Exception ex) {
					log.error(ex.getMessage());
				}
			}
		}
		log.info("bossSupplyRecorded()结束");
		result[0] = successOrders.replaceFirst(",", "");
		result[1] = failOrders.replaceFirst(",", "");
		return result;
	}

	public static void main(String []args)throws Exception{
		String content="您好！您在{YEAR}年{MONTH}月{DAY}日订购商品[{COMDESC}]，现已完成套卡激活准备工作，可以对外销售。";
		String ss="2010$11$01$商品0 150元套卡20套,商品1 20元50元充值卡30张,";
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
	// /**2010-03-30 去除 （原本用于前台处理，后移至后台独立程序处理 为免有地方引用暂时注释）
	// * 订单自动处理
	// * @param sleepMin 无数据时的休眠分钟数
	// * @throws Exception
	// */
	// public void autoProcess(int sleepMin) throws Exception{
	// // 查询订单任务表（FX_SW_ORDERTASK），匹配有效性为有效，如果无数据则进入休眠，否则对结果数据逐条处理
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
	// // 1) 根据订单编号查询订单表（FX_SW_ORDER），如果无数据，则修改订单任务表中有效性为无效，
	// // 备注为“订单信息不存在”，返回处理下一条数据；否则继续。
	// OrderVO orderVO = orderBO.doFindByPk(ordertaskVO.getOrderid());
	// if( null != orderVO){
	// // 2) 根据订单流程编号和订单状态查询订单流程步骤表（FX_RU_ORDERPROCE），匹配入口状态为当前订单状态，如果无数据，
	// // 则修改订单任务表中有效性为无效，备注为“当前订单无下一步操作”，返回处理下一条数据；否则继续。
	// OrderproceDBParam orderproceParam = new OrderproceDBParam();
	// orderproceParam.set_ne_flowid(""+orderVO.getFlowid());
	// orderproceParam.set_se_instate(orderVO.getOrderstate());
	// DataPackage orderproceDP = orderProceBO.doQuery(orderproceParam);
	// if(null != orderproceDP && null != orderproceDP.getDatas() && 0 <
	// orderproceDP.getDatas().size()){
	// try{
	// for(int j = 0;j<orderproceDP.getDatas().size();j++){
	// OrderproceVO orderproceVO = (OrderproceVO)orderproceDP.getDatas().get(j);
	// // 3) 如果订单步骤处理模式为人工，则修改订单任务表中有效性为无效，备注为“下一步人工处理步骤”，返回处理下一条数据；否则继续。
	// if("MANUAL".equals(orderproceVO.getDismode())){
	// ordertaskVO.setEffective(new Short("0"));
	// ordertaskVO.setMemo("下一步人工处理步骤");
	// ordertaskBO.doUpdate(ordertaskVO);
	// }else if("AUTO".equals(orderproceVO.getDismode())){
	// // 4) 如果订单步骤处理模式为自动，调用处理类对该订单进行处理，如果处理失败，则修改订单任务表中有效性为无效，
	// // 备注为“[订单步骤名称]处理失败”；如果处理成功，则继续下一条记录处理。
	// ProcessVO processVO = processBO.doFindByPk(orderproceVO.getProcessid());
	// try{
	// OrderDeal orderDeal = (OrderDeal)
	// Class.forName(processVO.getClasspath()).newInstance();
	//											
	// boolean result = orderDeal.deal(orderVO,user);
	// if(!result){
	// ordertaskVO.setEffective(new Short("0"));
	// ordertaskVO.setMemo("["+processVO.getProcessname() +"] 处理失败");
	// ordertaskBO.doUpdate(ordertaskVO);
	// }
	// }catch(Exception e){
	// ordertaskVO.setEffective(new Short("0"));
	// ordertaskVO.setMemo("["+processVO.getProcessname() +"] 处理失败");
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
	// ordertaskVO.setMemo("当前订单无下一步操作");
	// ordertaskBO.doUpdate(ordertaskVO);
	// }
	// }else{
	// ordertaskVO.setEffective(new Short("0"));
	// ordertaskVO.setMemo("订单信息不存在");
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
	 * 获取订单编号
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
			vo.setMemo("人工确认已完成");
			bo.doUpdate(vo);
		}
		return null;
	}

	/**
	 * 订单作废
	 */
	public String cancleOrder(String[] pkItem, String cancelReason, String cancelDes) throws Exception {
		Order bo = (OrderBO) BOFactory.build(OrderBO.class, user);
		StringBuilder message = new StringBuilder(200);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//作废原因[XXX] 时间[yyyy-MM-dd HH24:MI:SS]
		//String memo = "["+cancelReason+"] 说明："+sdf.format(new Date())+cancelDes;
		String memo = "作废原因["+cancelReason+"] 时间["+sdf.format(new Date())+"]";
		for (int i = 0; i < pkItem.length; i++) {
			try {
				OrderVO vo = bo.doFindByPk(pkItem[i]);
				if(null == vo.getConfirmflag() || "".equals(vo.getConfirmflag())){
					if("主动放弃".equals(cancelReason)){
						vo.setConfirmflag(0);
					}else{
						vo.setConfirmflag(1);
					}
				}
				vo.setMemo(memo);
				bo.doCancle(vo);
			} catch (Exception e) {
				message.append("订单[").append(pkItem[i]).append("]").append(
						e.getMessage()).append("\n");
				throw new JOPException(e);
			}
		}
		return message.toString();
	}

	/**
	 * 订单作废
	 */
	public void doCancle(OrderVO vo) throws Exception {
		try {
			Order bo = (OrderBO) BOFactory.build(OrderBO.class, user);
			if ("CANCEL".equals(vo.getOrderstate()))
				throw new JOPException(" 订单 [" + vo.getOrderid()
						+ "] 状态已为[作废] 不能进行作废操作");
			if ("FINISHED".equals(vo.getOrderstate()))
				throw new JOPException(" 订单 [" + vo.getOrderid()
						+ "] 状态已为[已完成] 不能进行作废操作");
			vo.setOrderstate("CANCEL");

			// 实时订购量更新：根据订单表中的合作商编码查询订购量实时记录表（FX_SW_REALTIMEAMT），无数据则不处理，有数据则逐条处理，
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
			
			//	空白SIM卡实时订购量更新
			//根据订单表中的合作商编码查询空白SIM卡订购量实时记录表（FX_SW_SIMREALTIMEAMT），无数据则不处理，
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
			doOrderResRelease(vo.getOrderid());//订单资源释放
			doDisformCancle(vo.getOrderid());// 配送单作废
		} catch (Exception e) {
			e.printStackTrace();
			throw new JOPException(e);
		}
	}

	/**
	 * 订单作废--配送单作废
	 */
	private void doDisformCancle(String orderid) throws Exception {
		Disform disformBO = (DisformBO) BOFactory.build(DisformBO.class, user);
		DisformDBParam disformDBParam = new DisformDBParam();
		disformDBParam.set_se_orderid(orderid);
		List<DisformVO> disformList = disformBO.doQuery(disformDBParam)
				.getDatas();
		if (disformList != null) {
			for (DisformVO vo : disformList) {
				// 将配送单状态修改为“作废”。
				vo.setDisstate("CANCEL");
				disformBO.doUpdate(vo);
			}
		}

	}

	/**
	 * 订单作废时减去其相应的实时订购量及库存量
	 * 
	 * @param orderid
	 *            订单编号
	 * @param realtimeamtVO实时订购
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
			long num = 0;// 订购数量
			Ordercomcate ordercomcateBO = (OrdercomcateBO) BOFactory.build(
					OrdercomcateBO.class, user);
			String sqlName = null;
			OrdercomcateDBParam ordercomcateParam = new OrdercomcateDBParam();
			ordercomcateParam.setDataOnly(true);
			ordercomcateParam.setSelectFieldsString("orderamt");
			Map conditionMap = new HashMap();
			conditionMap.put("orderid", orderVO.getOrderid());

			if ("AllBrand".equals(realtimeamtVO.getBrand())) {
				// 处理逻辑为：如果套卡品牌为所有品牌（即BRAND=AllBrand），则统计订单商品种类表（FX_SW_ORDERCOMCATE）中客户订购套卡数量
				sqlName = "queryOrderamtByAllBrand";
			} else {
				// 如果套卡品牌非所有品牌（即BRAND<>AllBrand），则统计订单商品种类表（FX_SW_ORDERCOMCATE）中对应品牌的客户订购套卡数量，
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

				// 对当月已订购量（订单创建时间为本月时更新）、当天已订购量（订单创建时间为当天时更新）、当前库存量进行递减，更新时间为当前时间；
				// 如果当月已订购量/当天已订购量/当前库存量为空，则不更新对应值；如果递减后的数值小于0则更新对应值为0。
				// 当月订购量
				if (0 == PublicUtils.compareMonth(new Date(),orderVO.getCreatetime())) {
					if (null != realtimeamtVO.getMonordered()) {
						realtimeamtVO.setMonordered((realtimeamtVO
								.getMonordered() - num) > 0 ? (realtimeamtVO
								.getMonordered() - num) : 0);
					}
				}
				// 当天订购量
				if (0 == PublicUtils.compareDate(new Date(), orderVO.getCreatetime())) {
					if (null != realtimeamtVO.getDayordered()) {
						realtimeamtVO.setDayordered((realtimeamtVO
								.getDayordered() - num) > 0 ? (realtimeamtVO
								.getDayordered() - num) : 0);
					}
				}
				// 当前库存量
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
	 * 订单作废时减去其相应的
	 * 空白SIM卡实时订购量更新
	 * 
	 * @param orderid
	 *            订单编号
	 * @param simrealtimeamtVO实时订购
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
			long num = 0;// 订购数量
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
				
				// 对当月已订购量（订单创建时间为本月时更新）、当天已订购量（订单创建时间为当天时更新）、当前库存量进行递减，更新时间为当前时间；
				// 如果当月已订购量/当天已订购量/当前库存量为空，则不更新对应值；如果递减后的数值小于0则更新对应值为0。
				// 当月订购量
				if (0 == PublicUtils.compareMonth(new Date(), orderVO.getCreatetime())) {
					if (null != simrealtimeamtVO.getMonordered()) {
						simrealtimeamtVO.setMonordered((simrealtimeamtVO
								.getMonordered() - num) > 0 ? (simrealtimeamtVO
								.getMonordered() - num) : 0);
					}
				}
				// 当天订购量
				if (0 == PublicUtils.compareDate(new Date(), orderVO.getCreatetime())) {
					if (null != simrealtimeamtVO.getDayordered()) {
						simrealtimeamtVO.setDayordered((simrealtimeamtVO
								.getDayordered() - num) > 0 ? (simrealtimeamtVO
								.getDayordered() - num) : 0);
					}
				}
				// 当前库存量
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

	// 订单资源释放
	private void doOrderResRelease(String orderID) throws Exception {
		try {
			doUpdatePackdetStateByOrderid(orderID);
			doResourceUpdateByOrderId(orderID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 根据订单编号查询订单商品包明细表(FX_SW_ORDERPACKDET)，对结果数据逐条处理：
	// 根据批次和包号更新商品包表(IM_PR_COMPACK)对应记录的包状态为“可售”。
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
		// 根据订单编号查询订单资源明细表 (FX_SW_ORDERRESDET)，对结果数据逐条处理：
		// 如果资源类别为充值卡（即RESTYPE=“COMRESCARD”），则根据商品资源编号和商品标识
		// 更新充值卡资源表(IM_FX_COMRESCARD)对应记录的商品状态为“可售”；如果资源类别为套卡（即RESTYPE=“COMRESSMP”），
		// 根据资源编号和商品标识更新套卡资源表 (IM_FX_COMRESSMP)对应记录的商品状态为“可售”，
		// 并将批次、包号用不重复的集合（MAP或Set）进行保存。
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
					//则根据商品资源编号和空卡序列号更新空白SIM卡资源表(IM_FX_EMPTYSIM)对应记录的商品状态为“可售”；
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
			// 遍历上一步获取的批次包号集合，根据批次和包号查询商品包表(IM_PR_COMPACK)，
			// 如果存在且包状态为可售，则根据批次、包号、商品状态（可售）对套卡资源表 (IM_FX_COMRESSMP)进行统计，
			// 用统计值更新商品包的商品数量字段；如果存在且包状态非可售，则更新包状态为可售，然后重新统计商品数量（同上）。
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

	// 查询垫资订单明细
	public DataPackage doQueryAdpaydet(String _ne_sumid) throws Exception {
		OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
		OrderDBParam params = new OrderDBParam();
		params.getQueryConditions().put("sumid", _ne_sumid);
		return dao.queryByNamedSqlQuery(
				"com.gmcc.pboss.business.sales.adpaydet", params, 0);
	}
	/**
	 * 批量审核通过
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
					throw new Exception("订单["+orderid+"]状态不正确");
					//throw new Exception("所选的订单中存在[订单流程步骤的出口状态不为已审核]的订单。");
				auditDBParam.set_se_orderid(orderid);
				auditDBParam.set_orderby("smsntime");
				auditDBParam.set_desc("1");
				//List<AuditVO> auditlist=auditBO.doQuery(auditDBParam).getDatas();
				List<AuditVO> auditlist=auditBO.doGetAuditInfo(auditDBParam).getDatas();
				for(AuditVO auditVO:auditlist){
					if(!"1".equals(auditVO.getState())){
						//throw new Exception("存在未审批或者审批未通过的订单记录");
						throw new Exception("订单["+orderid+"]未审批或者审批未通过，不允许执行审核通过操作");
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
		// 查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，
		// 参数标识为“44”，如果有数据且参数值等于1则进行分公司库存检查，否则跳过检查步骤。
		Sysparam sysBO = (Sysparam) BOFactory.build(SysparamBO.class, user);
		String paramValue = sysBO.doFindByID("44", "pboss_fx");
		/*if ("1".equals(paramValue)) {
			// 根据订单编号从订单商品种类 (FX_SW_ORDERCOMCATE)表取得该订单的商品种类
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
					// 首先根据商品种类查询商品种类组合关系表（IM_PR_COMCATEGORYRELA）获取资源类别，
					comcategoryrelaParam.set_se_comcategory(ordercomcateVO
							.getComcategory());
					DataPackage comcategoryrelaDP = comcategoryrelaBO
							.doQuery(comcategoryrelaParam);
					if (null != comcategoryrelaDP
							&& null != comcategoryrelaDP.getDatas()
							&& !comcategoryrelaDP.getDatas().isEmpty()) {
						ComcategoryrelaVO comcategoryrelaVO = (ComcategoryrelaVO) comcategoryrelaDP
								.getDatas().get(0);
						// 按套卡和充值卡进行库存量统计。
						long stocks = 0; // 库存资源数量
						long auditeds = 0; // 已审核资源数量
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
						//然后，对库存量是否充足进行判断。如果“（库存数量-已审核资源数量）>=当前商品种类订购量”则检查通过，
						//否则返回提示“商品种类[商品种类名称]订购量超出分公司库存数量[库存数量-已审核资源数量]。”
						if (!((stocks - auditeds) >= ordercomcateVO
								.getOrderamt())) {
							throw new JOPException("商品种类["
									+ Code2NameUtils.code2Name(
											"$IM_FXCOMCATEGORY", ordercomcateVO
													.getComcategory(), user
													.getCityid())
									+ "]订购量超出分公司库存数量[" + (stocks - auditeds)
									+ "]");
							Way wayBO = (Way) BOFactory.build(WayBO.class, user);
							WayVO wayVo=wayBO.doFindByPk(vo.getWayid());
							throw new JOPException("订购量超出分公司库存数量["+
									Code2NameUtils.code2Name("#CNTYCOMPANY", vo.getCountyid(), user.getCityid())+"、"+
									Code2NameUtils.code2Name("#SERVCENT", wayVo.getSvccode(), user.getCityid())+"、"+
								Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", ordercomcateVO.getComcategory(), user.getCityid())
								+ "、"+stocks+"、"+(stocks - auditeds)+"、"+ordercomcateVO.getOrderamt()+ "]");
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
			// 根据订单编号从订单商品种类 (FX_SW_ORDERCOMCATE)表取得该订单的商品种类
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
					// 首先根据商品种类查询商品种类组合关系表（IM_PR_COMCATEGORYRELA）获取资源类别，
					comcategoryrelaParam.set_se_comcategory(ordercomcateStocksVO
							.getComcategory());
					DataPackage comcategoryrelaDP = comcategoryrelaBO
							.doQuery(comcategoryrelaParam);
					if (null != comcategoryrelaDP
							&& null != comcategoryrelaDP.getDatas()
							&& !comcategoryrelaDP.getDatas().isEmpty()) {
						ComcategoryrelaVO comcategoryrelaVO = (ComcategoryrelaVO) comcategoryrelaDP
								.getDatas().get(0);
						// 按套卡和充值卡进行库存量统计。
						long stocks = 0; // 库存资源数量
						long auditeds = 0; // 已审核资源数量
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
						//然后，对库存量是否充足进行判断。如果“（库存数量-已审核资源数量）>=当前商品种类订购量”则检查通过，
						//否则返回提示“商品种类[商品种类名称]订购量超出分公司库存数量[库存数量-已审核资源数量]。”
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
	
	//查询某一商品种类的当天已订购量
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
	
	//查询某一商品种类的当月已订购量
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
     * 获取主动放弃数
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
     * 查询封装审核辅助信息集合
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
	
	//用于多级审核
	public DataPackage doListForAudit(OrderDBParam params) throws Exception {
		OrderDAO dao = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
		//用来装载查询的结果
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
		//================根据需求单CR_ZQ_20110323_1410123的修改=============
		// T1（配送超时预警时限T1）：查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“66”，
		//如果无数据或内容为空，则提示并退出。
		// T2（配送超时预警时限T2）：查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“67”，
		//如果无数据或内容为空，则提示并退出。
		Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
		String t1 = sysparamBO.doFindByID("66", "pboss_fx");
		String t2 = sysparamBO.doFindByID("67", "pboss_fx");
		if(t1 == null || "".equals(t1)){
			log.error("配送超时预警时限T1，无数据或内容为空或参数值小于零，退出");
			return ;
		}else{
			Long l = 0L;
			try {
				l = Long.parseLong(t1);
			} catch (Exception e) {
				log.error("配送超时预警时限T1，非数字，退出");
				return ;
			}
			if(l<0){
				log.error("配送超时预警时限T1，无数据或内容为空或参数值小于零");
				return ;
			}else{
				
			}
		}
		if(t2 == null || "".equals(t2)){
			log.error("配送超时预警时限T2，无数据或内容为空，退出");
			return ;
		}else{
			Long l = 0L;
			try {
				l = Long.parseLong(t2);
			} catch (Exception e) {
				log.error("配送超时预警时限T2，非数字，退出");
				return ;
			}
			if(l<0){
				log.error("配送超时预警时限T2，无数据或内容为空或参数值小于零");
				return ;
			}else{
				
			}
		}
				
		
		String sContentString = getSmsContent();
		if(sContentString == null || "".equals(sContentString)){
			log.error("短信模板无数据或内容为空，退出");
			return ;
		}
		
		/*
		 * 查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“42”，
		 * 发送号码取参数值。如果无数据或内容为空，则提示并退出。
		 */
		String sendNum = sysparamBO.doFindByID("42", "pboss_fx");
		if(sendNum == null || "".equals(sendNum)){
			log.error("短信发送号码无数据或内容为空，退出");
			return ;
		}
		
		/*
		 * 获取市场部经理手机号
		 * 查询短信通知对象表(FX_SW_SMSOBJECT),匹配分公司为此订单的分公司，
		 * 通知对象类型为‘市场部经理’，获取手机号码（如果不只一条，需对每一条手机号码发送短信）。
		 * 
		 * WAYMANAGER	分公司渠道经理
		 * MARKETMANAGER	分公司市场部经理
		 */
		Map<String,List> wmMap = getObject("WAYMANAGER");
		Map<String,List> mmMap = getObject("MARKETMANAGER");
		
		/*
		 * 按分公司，微区域分组统计出超时时间分别大于T1和大于T2的配送单数目
		 * 订单表 (FX_SW_ORDER)
		 * 订单日志表 (FX_SW_ORDERLOG)
		 * 配送单表（分销资源配送单:FX_SW_DISFORM）
		 * 
		 * 	匹配条件：联合查询订单表，订单日志表，配送单表：匹配配送单状态为未完成（即不等于配送完成或作废），
		 *  订单创建时间为前30日至今天，订单状态为已确认，订单日志表操作类型为更新，获取日志表操作日期字段的值做为订单确认时间。 
		 * 	超时时间=系统时间-订单确认时间
		 */
		/*
		 * 配送超时预警时限T1
		 */
		Order orderBO = (OrderBO)BOFactory.build(OrderBO.class,user);
		OrderDBParam o_params = new OrderDBParam();
		o_params.setDataOnly(true);
		o_params.setSelectFieldsString("countyid,mareacode,optime,orderid");
		//o_params_t1.setT1Start(Integer.parseInt(t1));
		//o_params_t1.setT1End(Integer.parseInt(t2));
		DataPackage dp_t1 = orderBO.doQueryOrderDisform(o_params);
		Map orderidT1Map = new HashMap();//t1的orderid
		Map<String,List> t1_map = getTtime(dp_t1,true,t1,t2,orderidT1Map);
		
		/*
		 * 配送超时预警时限T2
		 */
		//DataPackage dp_t2 = orderBO.doQueryOrderDisform(o_params);
		Map orderidT2Map = new HashMap();//t2的orderid
		Map<String,List> t2_map = getTtime(dp_t1,false,t1,t2,orderidT2Map);
		
		//写配送单超时预警统计表 (FX_SW_DISOVERSTAT)、配送单超时预警统计明细表 (FX_SW_DISOVERDETAIL)
		doWriteSt(t1_map,t2_map,orderidT1Map,orderidT2Map);
		
		/*
		 * 发短信通知分公司渠道经理，超时时间超过T1（配送超时预警时限T1）的配送单数
		 * 
		 */
		doSendMsg(t1_map,null,wmMap,null,sContentString,true,user,sendNum);
		
		/*
		 * 发短信通知分公司渠道经理、市场部经理，超时时间超过T2（配送超时预警时限T2）的配送单数
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
		    		
		    		//写配送单超时预警统计明细表 (FX_SW_DISOVERDETAIL)
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
		    				//分公司、微区域相同的，都需要写到明细表
		    				DisoverdetailVO disoverdetailVO = new DisoverdetailVO();
		    				disoverdetailVO.setStatseqid(disoverstatVO.getSeqid());
		    				disoverdetailVO.setOvertype("OVERT1");
		    				disoverdetailVO.setOrderid(key1);
		    				//超时时间取“系统时间-订单确认时间”，单位为小时		    				
		    				Date optime = PublicUtils.UtilStrToDate(optimeStr,"yyyy-MM-dd HH:mm:ss");
		    				long bt = TimeUtils.getWorkdayTimeInMillis(optime.getTime(),new Date().getTime());
							long btHour = bt/1000/60/60;//毫秒--》小时
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
		    		
		    		//写配送单超时预警统计明细表 (FX_SW_DISOVERDETAIL)
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
		    				//分公司、微区域相同的，都需要写到明细表
		    				DisoverdetailVO disoverdetailVO = new DisoverdetailVO();
		    				disoverdetailVO.setStatseqid(disoverstatVO.getSeqid());
		    				disoverdetailVO.setOvertype("OVERT2");
		    				disoverdetailVO.setOrderid(key1);
		    				//超时时间取“系统时间-订单确认时间”，单位为小时		    				
		    				Date optime = PublicUtils.UtilStrToDate(optimeStr,"yyyy-MM-dd HH:mm:ss");
		    				long bt = TimeUtils.getWorkdayTimeInMillis(optime.getTime(),new Date().getTime());
							long btHour = bt/1000/60/60;//毫秒--》小时
							disoverdetailVO.setOverhour(btHour);
		    				
		    				disoverdetailBO.doCreate(disoverdetailVO);
		    			}
					}
			    }
			}
		}
		
	}
	
	/**
	 * 对t1_map、t2_map分别构造短信并发短信：t1_map的统计数据给渠道经理发短信，t2_map的统计数据给市场部经理发短信<br>
	 * 
	 * @param t1_map	按分公司合并后的统计数据t1（配送超时预警时限T1）<BR>
	 * @param t2_map	按分公司合并后的统计数据t2（配送超时预警时限T2）<BR>
	 * @param wmMap		渠道经理人员表<BR>
	 * @param mmMap		市场部经理人员表<BR>
	 * @param sContentString	短信内容<BR>
	 * @param flag		true为t1统计，false为t2统计<BR>
	 * @sendNum			短信发送号码<BR>
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
				    //渠道经理
				    if(wmMap.containsKey(key)){
				    	List val = (List)entry.getValue();
				    	doDeal(val,sContentString,wmMap,key,user,sendNum);
				    }else{
				    	String compName = Code2NameUtils.code2Name("#CNTYCOMPANY", key, user.getCityid());
				    	log.info(compName + "分公司没有渠道经理手机号");
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
				    //渠道经理
				    if(wmMap.containsKey(key)){
				    	List val = (List)entry.getValue();
				    	doDeal(val,sContentString,wmMap,key,user,sendNum);
				    }else{
				    	log.info(compName + "分公司没有渠道经理手机号");
				    }
				    //市场部经理
				    if(mmMap.containsKey(key)){
				    	List val = (List)entry.getValue();
				    	doDeal(val,sContentString,mmMap,key,user,sendNum);
				    }else{
				    	log.info(compName + "分公司没有市场部经理手机号");
				    }
				} 
			}
		}
	}
	
	/**
	 * 给分组后的市场部经理或渠道经理发短信<br>
	 * 
	 * @param val				按分公司合并后的统计数据,t1或t2
	 * @param sContentString	短信模板
	 * @param map				人员表:渠道经理、市场部经理
	 * @param key				分公司编号
	 * @user					用户信息
	 * @sendNum					短信发送号码
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
    				content.append(mirName + "-" + sVO.get("coun") + "张");
    			}else{
    				content.append(mirName + "-" + sVO.get("coun") + "张，");
    			}
			}
    		//替换短信模板中的分公司（{COUNTYID}）、内容（OVERTIMEDESC}）
    		String tmp = new String(sContentString);
    		String compName = Code2NameUtils.code2Name("#CNTYCOMPANY", key, user.getCityid());
    		tmp = tmp.toString()
    			.replaceAll("\\{OVERTIMEDESC\\}", content.toString())
    			.replaceAll("\\{COUNTYID\\}", compName);
    		
    		List ll = (List)map.get(key);
    		if(ll != null && !"".equals(ll) && ll.size()>0){
    			for (int j=0 ; j<ll.size() ; j++) {
    				SmsobjectVO wmVO = (SmsobjectVO)ll.get(j);
    				//每个用户发送短信内容
    				String smsMessageString = new String(tmp);
    				//对每个手机号替换短信模板中的客户名称（{CUSTNAME}）
    				smsMessageString = smsMessageString.replaceAll("\\{CUSTNAME\\}", wmVO.getName());
    				
    				/*
		    		 * 此处发送短信
		    		 * smsMessageString：短信内容
		    		 * sendNum：短信发送号码
		    		 * wmVO.getMobile()：接收手机号
		    		 * date：发送时间
		    		 * 	    		 
    				 * 系统发短信时间参数：sendDateStr
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
	 * 返回的Map中key为分公司ID，value为HashMap的List，<BR>
	 * 而List中HashMap中又包含countyid：分公司，mareacode：微区域，coun：统计配送单数目 <BR>
	 * @param dp
	 * @param flag true：配送超时预警时限T1处理；false：配送超时预警时限T2<br>
	 * @param t1：配送超时预警时限T1<br>
	 * @param t2：配送超时预警时限T2<br>
	 * @return
	 * @throws Exception 
	 */
	public Map getTtime(DataPackage dp,boolean flag,String t1,String t2,Map orderIdMap) throws Exception{
		Map<String,List> map = new HashMap<String,List>();
		if (null == dp
				|| null == dp.getDatas()
				|| dp.getDatas().size() < 1){
			//不处理
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
					//超时时间统计需避开周末时间，即不统计周末时间
					long bt = TimeUtils.getWorkdayTimeInMillis(optime.getTime(),new Date().getTime());
					long btHour = bt/1000/60/60;//毫秒--》小时
					
					if(flag){//t1
						if(btHour>=Long.parseLong(t1)
								&& btHour<Long.parseLong(t2)){
							if(!orderIdMap.containsKey(orderid)){//对于同个订单号，日志表有多条记录时，只统计其中一条
								
								statData(map,m_cid,mareacodeId,orderid);
								orderIdMap.put(orderid, ooaVO);
							}
						}							
					}else{//t2
						if(btHour>=Long.parseLong(t2)){
							if(!orderIdMap.containsKey(orderid)){//对于同个订单号，日志表有多条记录时，只统计其中一条
								
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
	 * @param map	返回的Map中key为分公司ID，value为HashMap的List，<BR>
	 * 				而List中HashMap中又包含countyid：分公司，mareacode：微区域，coun：统计配送单数目 <BR>
	 * @param m_cid	分公司<br>
	 * @param mareacodeId	微区域<br>
	 */
	public void statData(Map<String,List> map,String m_cid,String mareacodeId,String orderId){		
		if(map.containsKey(m_cid)){//存在分公司，对存在、不存在微区域，累加、新增
			List<Map> list = (List)map.get(m_cid);
			List<Map> listTmp = new ArrayList<Map>();
			boolean extFlag = false;//当前是对一条记录的处理，所以，只能加一次到map里面
			for (Map map2 : list) {
				if(map2.get("countyid").equals(m_cid)){
					if(map2.get("mareacode").equals(mareacodeId)){//存在的微区域，累加
						extFlag = true;
						break;
					}else{//不存在的微区域，新加入列表
						extFlag = false;						
					}
				}
			}
			if(extFlag){//存在的微区域，累加
				for (Map map3 : list) {
					if(map3.get("countyid").equals(m_cid)){
						if(map3.get("mareacode").equals(mareacodeId)){//存在的微区域，累加
							String coun = (String)map3.get("coun");
							int count = Integer.parseInt(coun)+1;
							map3.remove("coun");
							map3.put("coun", ""+count);
							break;
						}
					}
				}
			}else{//不存在的微区域，新加入列表
				Map<String,String> mapTmp = new HashMap<String,String>();
				mapTmp.put("countyid", m_cid);
				mapTmp.put("mareacode", mareacodeId);
				mapTmp.put("orderId", orderId);
				mapTmp.put("coun", ""+1);
				list.add(mapTmp);
			}			
		}else{//不存在分公司，新增列表
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
	 * 返回的Map中key为分公司ID，value为SmsobjectVO类的List <BR>
	 * 
	 * 获取渠道经理手机号<BR>
	 * 查询短信通知对象表(FX_SW_SMSOBJECT),匹配分公司为此订单的分公司，<BR>
	 * 通知对象类型为‘渠道经理’，获取手机号码（如果不只一条，需对每一条手机号码发送短信）<BR>
	 * @type
	 * WAYMANAGER	分公司渠道经理
	 * MARKETMANAGER	分公司市场部经理
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
			//不处理
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
	 * 根据标识（FX_ORDER_DISOVERALARM）、生效状态（1）查询短信模板表
	 * （CH_SMS_SMSTMPL），获取模板内容，如果无数据或内容为空，则提示并退出
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
			log.error("短信模板无数据或内容为空，退出");
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
				//获取作废通知开关：订单作废是否短信通知网点 0-关闭 1-开启
				Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
				String param70 = sysparamBO.doFindByID("70", "pboss_fx");
				
				//获取短信发送号码
				String param7 = sysparamBO.doFindByID("7", "pboss");
				if(param7 == null || "".equals(param7)){
					param7 = "10086";
				}
				
				//获取发送时间
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
						String orderave = vo.getOrderave();//订单途径
						
						if("1".equals(sysparam80)){
							if(sysparam79 == null || "".equals(sysparam79)){
								//	如果系统参数为空，则提示“自动分配订单作废通知系统参数未设置”；
								log.info("自动分配订单作废通知系统参数未设置");
								throw new Exception("自动分配订单作废通知系统参数未设置");
							}
							
							//如果有数据且参数值等于1，并且此订单的订购途径为 自动分配（AUTO），
							//则以：订单号（ORDERID）和订单状态为 已审核（AUDITED） 
							//查询订单日志表（FX_SW_ORDERLOG）。如果无记录则不发送短信。
							//反之发送短信通知
							if("1".equals(sysparam79) && "AUTO".equals(orderave)){
								Orderlog orderlogBO = (OrderlogBO)BOFactory.build(OrderlogBO.class, user);
								OrderlogDBParam orderlogDBParam = new OrderlogDBParam();
								orderlogDBParam.set_se_orderid(pkItem[i]);//订单号（ORDERID）
								orderlogDBParam.set_se_orderstate("AUDITED");//已审核（AUDITED） 
								DataPackage orderlogDP = orderlogBO.doQuery(orderlogDBParam);
								
								if(orderlogDP.getRowCount() > 0)
									sms4Cancel(vo, comcategoryMap, cancelReason, param58, param7);
							}
							
							//此订单的订购途径不为 自动分配（AUTO），则直接发送短信。
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
		 * 尊敬的客户，{YEAR}年{MONTH}月{DAY}日建立的订单已作废，订单号{ORDERID}，
		 * 商品[{COMDESC}]，作废原因[{REASON}]。
		 * 如需帮助，请联系渠道经理或拨打服务热线。广东移动
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
				if(comcategory.indexOf("CZ")>=0){//充值卡
					comDesc=comDesc+comcategoryMap.get(comcategory)+""+orderamt+"张"+",";
				}else{//套卡
					comDesc=comDesc+comcategoryMap.get(comcategory)+""+orderamt+"套"+",";
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
			//短信发送
			//查询手机号码
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
						//短信发送
						
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
	 * 接口调用成功后通知网店可以销售。
	 * 
	 * @param orderid
	 *            订单编号
	 * @throws Exception
	 */
	public void doSendSucInfo(String orderid) throws Exception {

		// 接口调用成功后通知网店可以销售。
		// 新增数据到短信待发送表(CH_SMS_WAITREQ)，字段取值如下：
		// 短信类型取3；
		// 发送号码：查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“42”，发送号码取参数值。
		// 接收号码：根据订单中渠道编码获取起联系方式；
		// 短信内容：调用商品订购短信公用方法（网店可销售通知）获取。
		// 客户名称取网店名称，如果该字段为空则默认取“客户”；订单号；
		Sysparam sysparamBO = (Sysparam) BOFactory
				.build(SysparamBO.class, user);
		Waitreq waitreqBO = (Waitreq) BOFactory.build(WaitreqBO.class, user);
		ComOrderSms comOrderSms = new ComOrderSms();
		// 获取短信发送号码
		String sysparamvalue42 = sysparamBO.doFindByID("42", "pboss_fx");
		WaitreqVO waitreqVO = new WaitreqVO();
		waitreqVO.setSmstype((short) 3);
		waitreqVO.setAreacode(user.getCityid());
		waitreqVO.setCreattime(new java.util.Date());
		waitreqVO.setSendno(sysparamvalue42);

		// 查询公务机号码
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

		// 封装短信内容
		// 查询渠道信息
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayVO vo = way.doFindByPk(orderid);
		String wayname = "";
		if (vo != null && vo.getWayname() != null
				&& !vo.getWayname().equals("")) {
			wayname = vo.getWayname();
		} else {
			wayname = "客户";
		}
		waitreqVO.setMessage(comOrderSms.getCanSaleNotice(wayname, orderid,
				user));
		waitreqBO.doCreate(waitreqVO);

	}
	
	
     /** 接口调用失败后短信提醒渠道主管
	 * 
	 * @param orderid
	 *            订单编号
	 * @param countyid
	 *           	分公司
	 * @throws Exception
	 */
	public void doSendFailInfo(String orderid, String countyid)
			throws Exception {

		// 接口调用失败后短信提醒渠道主管
		// 新增数据到短信待发送表(CH_SMS_WAITREQ)，字段取值如下：
		// 短信类型取3；
		// 发送号码：查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“42”，发送号码取参数值。
		// 接收号码：分公司渠道经理；
		// 短信内容：调用商品订购短信公用方法（网店可销售通知）获取。
		// 客户名称取分公司渠道经理名称，如果该字段为空则默认取“渠道经理”；订单号；

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
			// 获取短信发送号码
			String sysparamvalue42 = sysparamBO.doFindByID("42", "pboss_fx");
			WaitreqVO waitreqVO = new WaitreqVO();
			waitreqVO.setSmstype((short) 3);
			waitreqVO.setAreacode(user.getCityid());
			waitreqVO.setCreattime(new java.util.Date());
			waitreqVO.setSendno(sysparamvalue42);

			String wayname = "";

			// 获取渠道经理手机号：
			// 查询短信通知对象表(FX_SW_SMSOBJECT),匹配分公司为此订单的分公司，通知对象类型为‘渠道经理’，888
			// 业务类型为‘其他’，获取手机号码（如果不只一条，需对每一条手机号码发送短信）。
			for (Iterator<SmsobjectVO> it = smsobjectdp.getDatas().iterator(); it
					.hasNext();) {
				SmsobjectVO smsobjectVO = it.next();
				waitreqVO.setRecno(smsobjectVO.getMobile());
				if (smsobjectVO.getName() != null
						&& smsobjectVO.getName() != null
						&& !smsobjectVO.getName().equals("")) {
					wayname = smsobjectVO.getName();
				} else {
					wayname = "渠道经理";
				}
				waitreqVO.setMessage(comOrderSms.getCanSaleNotice(wayname,
						orderid, user));
				
				if(waitreqVO.getMessage() != null && waitreqVO.getRecno() != null && waitreqVO.getSendno() != null){					
					waitreqBO.doCreate(waitreqVO);	
				}else{
					log.info("发送号码或接收号码或发送信息未设置！");
				}
				
			}

		} else {

			log.info("未设置分公司渠道经理联系电话!");

		}

	}
	
	
	//计算实收金额的汇总信息
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
	
	
	//计算各个品牌的汇总信息
	public String getAllBrandInfo(DataPackage dp) throws Exception{
		StringBuffer str = new StringBuffer("资源总信息：");
		
		if(dp != null && dp.getDatas() != null && dp.getDatas().size()>0){
			
			Map map = new HashMap<String,Integer>();
			
			for(Iterator<OrderVO> it = dp.getDatas().iterator();it.hasNext();){
				OrderVO orderVO = it.next();
				String orderinfo = orderVO.getOrderInfo();
				//先以“，”分割多个品牌
				String [] brands = orderinfo.split(",");
				//再以“（”分割一个品牌得到数量
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
		String param42 = sysparamBO.doFindByID("42", "pboss_fx");// 发送号码
		if (param42 != null && !"".equals(param42)) {

		} else if (null == param42 || "".equals(param42)) {
			throw new Exception("发送号码为空");

		} else {// 处理下一条
			return;
		}
		// 客户
		String username = null;
		// 接收号码
		Employee employeeBO = (Employee) BOFactory
				.build(EmployeeBO.class, user);
		EmployeeDBParam employeeDBParam = new EmployeeDBParam();
		employeeDBParam.set_se_wayid(orderVo.getWayid());
		employeeDBParam.set_ne_isnet("1");// 店主
		employeeDBParam.set_ne_empstatus("0");// 在岗
		String receTel = null;
		DataPackage dp1 = employeeBO.doQuery(employeeDBParam);
		if (null != dp1 && dp1.getDatas().size() > 0) {
			EmployeeVO vo = (EmployeeVO) dp1.getDatas().get(0);
			receTel = vo.getOfficetel();
			username = vo.getEmployeename(); 
		} 
		if (null == receTel || ("").equals(receTel)) {
			throw new Exception("店主手机号码为空");
		}
		if (null == username || ("").equals(username)) {
			username = "客户";
		}
		// 商品信息
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
			throw new Exception("商品信息为空");
		}

		// 应收金额
		double price = orderVo.getRecamt();

		// 短信内容
		// 尊敬的{CUSTNAME}，您所订购的商品[{COMDESC}]，应收金额{ RECAMT
		// }元，订单号{ORDERID}，扣费成功！广东移动。
		Map<String, String> map = new HashMap<String, String>();
		map.put("CUSTNAME", username);
		map.put("COMDESC", comdesc);
		map.put("RECAMT", price + "");
		map.put("ORDERID", orderVo.getOrderid());
		Smstmpl smstmplBO = (SmstmplBO) BOFactory.build(SmstmplBO.class, user);
		String smsContent = null;
		
		if("BATCHDEDUCT".equals(optype)){//银行划扣
			if (("SUCCESS").equals(orderVo.getDeductstate())) {
				smsContent = smstmplBO.doGenSMS("FX_ORDER_DEDDUCTSUCCESS", map);
			} else if (("FAIL").equals(orderVo.getDeductstate())) {
				smsContent = smstmplBO.doGenSMS("FX_ORDER_DEDDUCTFAILURE", map);
			}
		}else if("CASH".equals(optype)){//现金
			if ("成功".equals(result)) {
				smsContent = smstmplBO.doGenSMS("FX_ORDER_DEDDUCTSUCCESS", map);
			} else{
				map.put("REASON", reason);
				smsContent = smstmplBO.doGenSMS("FX_ORDER_CASHFAILURE", map);
			}
		}
		
		if (null == smsContent || "".equals(smsContent.trim())) {// 处理下一条
			throw new Exception("短信内容为空");
		}
		
		Waitreq waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class, user);
		waitreqBO.doInsert2(new Short("3"), smsContent, param42, receTel);
	}

	// 批量处理需要调整的数据
	public boolean doDealAllocateData(String[] items) throws Exception {
		boolean result = true;
		// 资源明细
		Order order = (OrderBO) BOFactory.build(OrderBO.class, user);
		OrderVO orderVo = new OrderVO();
		orderVo = order.doFindByPk(items[0]);
		Orderresdet orderresdet = (OrderresdetBO) BOFactory.build(
				OrderresdetBO.class, user);
		OrderresdetVO orderresdetVO = null;
		if (null == orderVo || ("").equals(orderVo)) { // 订单信息检查
			result = false;
			throw new Exception("订单不存在");
		} else {
			OrderresdetDBParam params = new OrderresdetDBParam();
			params.set_se_orderid(orderVo.getOrderid());
			DataPackage dp = orderresdet.doQuery(params);
			if (dp != null && dp.getDatas().size() > 0) {
				orderresdetVO = (OrderresdetVO) dp.getDatas().get(0);
			}
		}
		if(("CHARGED").equals(orderVo.getOrderstate()) || ("DEDUCTING").equals(orderVo.getOrderstate())){  //订单发扣状态检查
			result = false;
			throw new Exception("订单已进入收费流程，不能调整数量");
		}
		if (null != orderresdetVO && !("").equals(orderresdetVO)) { // 订单资源明细检查
			result = false;
			throw new Exception("订单资源已抽取");
		}
		if (("CANCEL").equals(orderVo.getOrderstate())) { // 订单资源明细检查
			result = false;
			throw new Exception("订单已作废");
		}
		OrdercomcateVO ordercomcateVO = new OrdercomcateVO();
		// 调整数据检查
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
				throw new Exception("该订单订购的商品种类[" + data[0] + "]不存在");
			}
			if (null == data[1] || ("").equals(data[1])) {
				result = false;
				throw new Exception("该订单订购的商品种类，订购数量为空");
			} else if (null != vo1) {
				if (Double.valueOf(data[1]) % Double.valueOf(unitage) > 0) {
					result = false;
					throw new Exception("订购数量[" + data[1] + "]的订购量不为订购基数的整数倍");
				}
			}
		}
		return result;
	}

	
	/**
	 * 发票打印
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
		double actprice = 0L;//所有品牌的总金额
		StringBuffer sb = new StringBuffer();//购买明细
		StringBuffer leftstr = new StringBuffer();
		String rightstr = new String();
		
		Map<String,String> hsmap = new HashMap<String,String>();
		hsmap.put("COMRESCARD", "刮卡类");
		hsmap.put("COMRESSMP", "SIM类");
		hsmap.put("EMPTYSIM", "空白卡");
		
		String unit = "";
		
		//记录tr在字符串中出现的次数
		int trcount = 0;

		//得到订购的汇总信息
		DataPackage dp = dao.groupbyordercomtype(params, orderid);
		if(dp != null && dp.getDatas() != null && dp.getDatas().size() > 0){
			for(Iterator<Map> it = dp.getDatas().iterator();it.hasNext();){
				//汇总信息
				Map map = it.next();
				String restype = map.get("restype")+"";
				unit = restype.equals("COMRESCARD")?"张":"套";
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
				
				// 明细（套卡，充值卡）
				if(!restype.equals("EMPTYSIM"))
				{					
					DataPackage dpDetail  = dao.groupbyordercomtypeDetail(params, orderid, restype);
					if(dpDetail != null && dpDetail.getDatas() != null && dpDetail.getDatas().size() > 0){
							for(Iterator<Map> itDetail = dpDetail.getDatas().iterator();itDetail.hasNext();){
								 Map mapdetail = itDetail.next();
								 String comcategory = mapdetail.get("comcategory")+"";
								 String brandname = Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", comcategory, user.getCityid());//数量
								 int count = mapdetail.get("statistic") != null ?Integer.parseInt(mapdetail.get("statistic")+""):0;//购买数量
								 double dou = mapdetail.get("actprice") != null ? Double.parseDouble(mapdetail.get("actprice")+""):0d;
								 String singleactprice = df.format(dou);//总金额
								 
								 //拼接所有购买品牌
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
						//明细（空白卡）
						DataPackage KBSIMDetail  = dao.groupbyordercomtypeKBSIMDetail(params, orderid, restype);
						if(KBSIMDetail != null && KBSIMDetail.getDatas() != null && KBSIMDetail.getDatas().size() > 0){
							for(Iterator<Map> itKBSIMDetail = KBSIMDetail.getDatas().iterator();itKBSIMDetail.hasNext();){
								 Map mapdetail = itKBSIMDetail.next();
								 int count = Integer.parseInt(mapdetail.get("statistic")+"");//购买数量
								 double dou = mapdetail.get("actprice") != null ? Double.parseDouble(mapdetail.get("actprice")+""):0d;
								 String singleactprice = df.format(dou);//总金额
								 //拼接所有购买品牌
								 leftstr.append(
											"<tr width='100%'>" +
											"<td width='160px'><font size ='2.5'>空白SIM卡</font></td>" +
											"<td width='60px'><font size ='2.5'>"+count+"张</font></td>" +
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
	 * 业务单打印
	 */
	public JSONArray doAjaxPrintBusiness(String orderid, OrderVO orderVO)
			throws Exception {
	//		渠道编码：订单的合作商编码
	//		渠道名称：合作商名称
	//		总计小写：订单应收金额
	//		总计大写：将订单应收金额转换成大写后对应填入。空时填“零“。
	//		销售数据：根据订单号取订单商品种类表中数据。产品名称为商品种类；
	//		单位为套；数量为订购数量；市场价格为原商品价格；折扣单价为商品单价；应收金额为商品总价。
		DecimalFormat df = new DecimalFormat("#.00");
		DecimalFormat dff = new DecimalFormat("0.##");
		Com comBO=(Com)BOFactory.build(ComBO.class,user);//商品数据BO
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
				
				//商品原始单价
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
						"<td width='20%'><font size ='2.5'>"+Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", ordercomcateVO.getComcategory(), user.getCityid())+"</font></td>" +//名称
						"<td width='7%'><font size ='2.5'>套</font></td>" +//单位
						"<td width='13%'><font size ='2.5'>"+ordercomcateVO.getOrderamt()+"</font></td>" +//数量
						"<td width='10%'><font size ='2.5'>"+(df.format(comprice).equals(".00")?"0.00":df.format(comprice))+"</font></td>" +//市场价格
						"<td width='18%'><font size ='2.5'>"+(df.format(ordercomcateVO.getUnitprice()).equals(".00")?"0.00":df.format(ordercomcateVO.getUnitprice())).toString()+"</font></td>" +//折扣价格
						"<td width='12%'><font size ='2.5'>"+(df.format(ordercomcateVO.getTotalprice()).equals(".00")?"0.00":df.format(ordercomcateVO.getTotalprice())).toString()+"</font></td>" +//应付金额(元)
						"<td width='20%'><font size ='2.5'></font></td>" +//备注
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
			hashmap.put("fen", "零");
			hashmap.put("jiao", "零");
			hashmap.put("yuan", 0>=uplen?"零":upperstrarr[uplen-1]);
			hashmap.put("shiyuan", 1>=uplen?"零":upperstrarr[uplen-2]);
			hashmap.put("bai", 2>=uplen?"零":upperstrarr[uplen-3]);
			hashmap.put("qian",3>=uplen?"零":upperstrarr[uplen-4]);
			hashmap.put("wan", 4>=uplen?"零":upperstrarr[uplen-5]);
			hashmap.put("shiwan",5>=uplen?"零":upperstrarr[uplen-6]);
		}else if((upperprice.length() - (upperprice.indexOf(".")+1)) == 1 ){
			hashmap.put("fen", "零");
			hashmap.put("jiao", 0>=uplen?"零":upperstrarr[uplen-1]);
			hashmap.put("yuan", 1>=uplen?"零":upperstrarr[uplen-2]);
			hashmap.put("shiyuan", 2>=uplen?"零":upperstrarr[uplen-3]);
			hashmap.put("bai", 3>=uplen?"零":upperstrarr[uplen-4]);
			hashmap.put("qian",4>=uplen?"零":upperstrarr[uplen-5]);
			hashmap.put("wan", 5>=uplen?"零":upperstrarr[uplen-6]);
			hashmap.put("shiwan",6>=uplen?"零":upperstrarr[uplen-7]);
		}else if((upperprice.length() - (upperprice.indexOf(".")+1)) == 2 ){
			hashmap.put("fen", 0>=uplen?"零":upperstrarr[uplen-1]);
			hashmap.put("jiao",1>=uplen?"零":upperstrarr[uplen-2]);
			hashmap.put("yuan", 2>=uplen?"零":upperstrarr[uplen-3]);
			hashmap.put("shiyuan", 3>=uplen?"零":upperstrarr[uplen-4]);
			hashmap.put("bai", 4>=uplen?"零":upperstrarr[uplen-5]);
			hashmap.put("qian",5>=uplen?"零":upperstrarr[uplen-6]);
			hashmap.put("wan", 6>=uplen?"零":upperstrarr[uplen-7]);
			hashmap.put("shiwan",7>=uplen?"零":upperstrarr[uplen-8]);
		}
		hashmap.put("content", sb.toString());
		JSONArray jsonarray = JSONArray.fromObject(hashmap);
		return jsonarray;
	} 
}
