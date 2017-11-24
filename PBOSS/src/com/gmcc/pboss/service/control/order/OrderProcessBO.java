package com.gmcc.pboss.service.control.order;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.service.result.RetResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;

public class OrderProcessBO extends AbstractControlBean implements OrderProcess{

	private static Logger log = Logger.getLogger(OrderProcessBO.class);
	public RetResult doNextProcess(String wayid, String orderid) {
		// TODO Auto-generated method stub
		RetResult result = new RetResult();
		try{
			Way wayBO = (Way)BOFactory.build(WayBO.class, DBAccessUser.getInnerUser());
			WayVO wayVO = wayBO.doFindByPk(wayid);
			if( null == wayVO ){
				result.setRetCode(2);
				result.setMessage("该合作商["+wayid+"]基本信息不存在");
			}else{
				user.setCityid(wayVO.getCityid());
				Order orderBO = (Order)BOFactory.build(OrderBO.class,user) ;
				String[] processResult = orderBO.doNextProcess(orderid);
				if("0".equals(processResult[0]) || "1".equals(processResult[0]) || "2".equals(processResult[0])){
					result.setRetCode(Integer.parseInt(processResult[0]));
					result.setMessage(processResult[1]);
				}else{
					result.setRetCode(2);
					result.setMessage("订单["+orderid+"]下一步处理失败");
				}
			}
			return result;	
		}catch(Exception e){
			LoggerUtils.error(e, log);
			result.setRetCode(2);
			result.setMessage(e.getMessage());
		}
		return result;
	}

}
