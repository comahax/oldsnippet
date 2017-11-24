package com.gmcc.pboss.control.service.sms.orderquery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.MdbgBase;
import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.resource.nosect.NosectDBParam;
import com.gmcc.pboss.business.resource.nosect.NosectVO;
import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateDBParam;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateVO;
import com.gmcc.pboss.business.sales.orderreq.OrderreqDBParam;
import com.gmcc.pboss.business.sales.reqcomcate.ReqcomcateDBParam;
import com.gmcc.pboss.business.sales.reqcomcate.ReqcomcateVO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.resource.nosect.Nosect;
import com.gmcc.pboss.control.resource.nosect.NosectBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.ordercomcate.Ordercomcate;
import com.gmcc.pboss.control.sales.ordercomcate.OrdercomcateBO;
import com.gmcc.pboss.control.sales.orderreq.Orderreq;
import com.gmcc.pboss.control.sales.orderreq.OrderreqBO;
import com.gmcc.pboss.control.sales.reqcomcate.Reqcomcate;
import com.gmcc.pboss.control.sales.reqcomcate.ReqcomcateBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.ActivityRatioResult;
import com.gmcc.pboss.service.sms.result.ComOrderResult;
import com.gmcc.pboss.service.sms.result.OrderQueryResult;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.InterfaceUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.component.Code2Name;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.infrastructure.db.hibernate3.SessionFactoryContextHolder;
import com.sunrise.jop.infrastructure.dproxy.ProxyFactory;

public class SMSOrderQueryBO extends AbstractControlBean implements SMSOrderQuery{

	private static Logger logger = Logger.getLogger(SMSOrderQueryBO.class);
	
	private String doGetWayid(String mobile) throws Exception{
		//号段表
		logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
				+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
				.getSimpleName());
		//雇员表
		Employee employee = (Employee)BOFactory.build(EmployeeBO.class, user);
		EmployeeDBParam employeeDBParam = new EmployeeDBParam();
		employeeDBParam.set_se_officetel(mobile);
		employeeDBParam.set_ne_empstatus("0");
		DataPackage dp = employee.doQuery(employeeDBParam);
		if(dp.getDatas().size() == 0){
			throw new SMSException("号码未登记",OrderQueryResult.RET_TYPE_FAIL_1);
		}
		EmployeeVO vo = (EmployeeVO)dp.getDatas().get(0);
		if(vo.getIsnet() == null || !"1".equals(vo.getIsnet().toString())){
			throw new SMSException("非店主号码无权限",OrderQueryResult.RET_TYPE_FAIL_2);
		}
		return vo.getWayid();
	}
	
	private String doBuildDataStr(String wayid, String orderid) throws Exception{
		Map<String,Integer> dataMap = new HashMap<String,Integer>();
		String orderState = null;
		Order order = (Order)BOFactory.build(OrderBO.class, user);
		OrderDBParam orderDBParam = new OrderDBParam();
		orderDBParam.set_se_orderid(orderid);
		orderDBParam.set_se_wayid(wayid);
		DataPackage orderDp = order.doQuery(orderDBParam);
		if(orderDp.getDatas().size() != 0){
			orderState = ((OrderVO)orderDp.getDatas().get(0)).getOrderstate();
			Ordercomcate ordercomcate = (Ordercomcate)BOFactory.build(OrdercomcateBO.class, user);
			OrdercomcateDBParam ordercomcateDBParam = new OrdercomcateDBParam();
			ordercomcateDBParam.set_se_orderid(orderid);
			DataPackage ordercomcateDp = ordercomcate.doQuery(ordercomcateDBParam);
			for(int i=0;i<ordercomcateDp.getDatas().size();i++){
				OrdercomcateVO vo = (OrdercomcateVO)ordercomcateDp.getDatas().get(i);
				if(dataMap.get(vo.getComcategory()) == null){
					dataMap.put(vo.getComcategory(), vo.getOrderamt().intValue());
				}else{
					dataMap.put(vo.getComcategory(), dataMap.get(vo.getComcategory()).intValue() + vo.getOrderamt().intValue());
				}
			}
		}else{
			orderState = "待处理";
			Orderreq orderreq = (Orderreq)BOFactory.build(OrderreqBO.class, user);
			OrderreqDBParam orderreqDBParam = new OrderreqDBParam();
			orderreqDBParam.set_se_reqid(orderid);
			orderreqDBParam.set_se_wayid(wayid);
			DataPackage orderreqDp = orderreq.doQuery(orderreqDBParam);
			if(orderreqDp.getDatas().size() == 0){
				throw new SMSException("订单信息不存在",OrderQueryResult.RET_TYPE_FAIL_3);
			}else{
				Reqcomcate reqcomcate = (Reqcomcate)BOFactory.build(ReqcomcateBO.class, user);
				ReqcomcateDBParam reqcomcateDBParam = new ReqcomcateDBParam();
				reqcomcateDBParam.set_se_reqid(orderid);
				DataPackage reqcomcateDp = reqcomcate.doQuery(reqcomcateDBParam);
				for(int i=0;i<reqcomcateDp.getDatas().size();i++){
					ReqcomcateVO vo = (ReqcomcateVO)reqcomcateDp.getDatas().get(i);
					if(dataMap.get(vo.getComcategory()) == null){
						dataMap.put(vo.getComcategory(), vo.getOrderamt().intValue());
					}else{
						dataMap.put(vo.getComcategory(), dataMap.get(vo.getComcategory()).intValue() + vo.getOrderamt().intValue());
					}
				}
			}
		}
		
		//组装dataList 
		StringBuffer sb = new StringBuffer();
		String transState = Code2NameUtils.code2Name("$FX_ORDERFSTATE", orderState, user.getCityid());
		sb.append(orderid).append(SMSProtocol.WORD_SLIT_SYMBOL).append(transState).append(SMSProtocol.WORD_END_SYMBOL);
		for(Iterator<String> itt = dataMap.keySet().iterator(); itt.hasNext();){
			String brand = itt.next();
			Integer orderAmount = dataMap.get(brand);
			String transBrand = Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", brand, user.getCityid());
			sb.append(transBrand).append(SMSProtocol.WORD_SLIT_SYMBOL).append(orderAmount).append(SMSProtocol.WORD_END_SYMBOL);
		}
		return sb.substring(0, sb.length()-1);
	}
	
	private OrderQueryResult doReturnSuccVal(String dataStr) throws Exception{
		OrderQueryResult result = new OrderQueryResult();
		List<String> list = new ArrayList<String>();
		list.add(dataStr);
		result.setRet(ComOrderResult.RET_TYPE_SUCC_0);
		result.setMessage("成功");
		result.setDatas(list);
		return result;
	}
	
	
	public String doResult(String mobile, String orderid) throws Exception{
		try{
			String dataStr = doBuildDataStr(doGetWayid(mobile),orderid);
			return doReturnSuccVal(dataStr).toString();
		}catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
	}

}
