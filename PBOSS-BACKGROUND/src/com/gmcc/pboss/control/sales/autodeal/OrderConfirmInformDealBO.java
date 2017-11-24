package com.gmcc.pboss.control.sales.autodeal;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoDAO;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoVO;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.common.sms.ComOrderSms;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.communication.advinfo.Advinfo;
import com.gmcc.pboss.control.communication.advinfo.AdvinfoBO;
import com.gmcc.pboss.control.communication.rcvobj.Rcvobj;
import com.gmcc.pboss.control.communication.rcvobj.RcvobjBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * 订购确认通知
 * @author yedaoe
 * @version 1.0 2009-10-22
 */
public class OrderConfirmInformDealBO extends AbstractControlBean implements
		OrderDeal {

	public boolean doDeal(OrderVO orderVO, DBAccessUser user) throws Exception {
		try {
			Order order = (Order)BOFactory.build(OrderBO.class, user);
			Sysparam sys = (Sysparam) BOFactory.build(SysparamBO.class, user);
			String sendmobile = sys.doFindByID("42", "pboss_fx");
			if (StringUtils.isBlank(sendmobile)) {
				orderVO.setMemo("获取短信发送号码失败");
				order.doUpdate(orderVO);
				return false;
			}
			Employee emp = (Employee) BOFactory.build(EmployeeBO.class, user);
			EmployeeDBParam emparam = new EmployeeDBParam();
			emparam.set_se_wayid(orderVO.getWayid());
			emparam.set_ne_empstatus("0");
			emparam.set_ne_isnet("1");
			DataPackage dp = emp.doQuery(emparam);
			String receivemobile = "";
			String employeeid = "";
			if (null != dp && dp.getRowCount() > 0) {
				EmployeeVO evo = (EmployeeVO) dp.getDatas().get(0);
				receivemobile = evo.getOfficetel();
				employeeid = evo.getEmployeeid();
			}
			if(StringUtils.isBlank(receivemobile)){
				orderVO.setMemo("获取接收手机号码失败");
				order.doUpdate(orderVO);
				return false;
			}
			SmsconfirmVO smsconvo=new SmsconfirmVO();
			smsconvo.setType("ORDERCON");//类型取订购二次确认
			smsconvo.setStream(orderVO.getOrderid().substring(orderVO.getOrderid().length()-4, orderVO.getOrderid().length()));//确认流水号取订单末尾4位
			smsconvo.setOrderid(orderVO.getOrderid());//关联订单号取订单编号
			smsconvo.setState("WAITREP");//状态取待回复
			smsconvo.setSendtime(new Date());//通知时间取当前时间
			smsconvo.setMobileno(receivemobile);
			Smsconfirm  smsconfirmBO=(Smsconfirm) BOFactory.build(SmsconfirmBO.class,user);
			smsconfirmBO.doCreate(smsconvo);
			
			Advinfo advinfo = (Advinfo)BOFactory.build(AdvinfoBO.class, user);
			AdvinfoDAO aidao = (AdvinfoDAO)DAOFactory.build(AdvinfoDAO.class,user);
			AdvinfoVO aivo = new AdvinfoVO();
			Long advinfoid = (Long)aidao.getSequence("CH_PW_ADVINFO_SEQ");
			aivo.setAdvinfoid(advinfoid);
			aivo.setTitle("商品订购确认("+orderVO.getOrderid()+")");
			
			aivo.setType(new Short("5"));
			aivo.setReleasetime(new Date());
			java.util.Calendar c1 = java.util.Calendar.getInstance();
			c1.setTime(new Date());
			c1.add(java.util.Calendar.DAY_OF_MONTH, 7);
			java.util.Date newdate= c1.getTime();
			aivo.setPlantime(newdate);
			aivo.setEnddate(newdate);
			aivo.setDesttype(new Short("4"));
			aivo.setSmsnotify(new Short("0"));
			aivo.setNdapproval(new Short("0"));
			aivo.setOprcode("PBOSS-BG");
			aivo.setState(new Short("3"));
			advinfo.doCreate(aivo);
			aivo.setContent("/salesOrder/advDetail.do?orderid="+orderVO.getOrderid()+"&advId="+aivo.getAdvinfoid());
			advinfo.doUpdate(aivo);
			
			Rcvobj rcv = (Rcvobj)BOFactory.build(RcvobjBO.class, user);
//			RcvobjDAO rcvdao = (RcvobjDAO)DAOFactory.build(RcvobjDAO.class,user);
			RcvobjVO rcvvo = new RcvobjVO();
//			Long rvcobjid = (Long)rcvdao.getSequence("CH_PW_RCVOBJ_SEQ");
//			rcvvo.setRvcobjid(rvcobjid);
			rcvvo.setAdvinfoid(aivo.getAdvinfoid());
			rcvvo.setObjid(employeeid);
			rcvvo.setState(new Short("1"));
			rcvvo.setStatetime(new Date());
			rcv.doCreate(rcvvo);
			
			
			ComOrderSms comOrderSms = new ComOrderSms();
			Waitreq  waitreqBO=(Waitreq)BOFactory.build(WaitreqBO.class,user);
			//待pboss代码打包过来之后,放开下面的代码
			waitreqBO.doInsert2(Short.valueOf("3"), comOrderSms.getConfirmSms(orderVO.getOrderid(), user), sendmobile, receivemobile);
			
			orderVO.setOrderstate("WAITCON");//更新订单表中的订单状态为“待确认”
			orderVO.setStatechgtime(new Date());
			order.doUpdate(orderVO);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
