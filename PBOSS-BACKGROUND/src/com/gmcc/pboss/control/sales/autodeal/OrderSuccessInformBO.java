package com.gmcc.pboss.control.sales.autodeal;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.common.sms.ComOrderSms;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;


/**
 * 订购成功通知
 * @author yedaoe
 * @version 1.0 2009-10-22
 */
public class OrderSuccessInformBO extends AbstractControlBean implements
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
			if (null != dp && dp.getRowCount() > 0) {
				EmployeeVO evo = (EmployeeVO) dp.getDatas().get(0);
				receivemobile = evo.getOfficetel();
			}
			if(StringUtils.isBlank(receivemobile)){
				orderVO.setMemo("获取接收手机号码失败");
				order.doUpdate(orderVO);
				return false;
			}
			ComOrderSms comOrderSms = new ComOrderSms();
			Waitreq  waitreqBO=(Waitreq)BOFactory.build(WaitreqBO.class,user);
			//待pboss代码打包过来之后,放开下面的代码
			waitreqBO.doInsert2(Short.valueOf("3"), comOrderSms.getSuccessSms(orderVO.getOrderid(), user), sendmobile, receivemobile);
			
			orderVO.setOrderstate("CONFIRMED");//更新订单表中的订单状态为“已确认”
			orderVO.setStatechgtime(new Date());
			order.doUpdate(orderVO);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}