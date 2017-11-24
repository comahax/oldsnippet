package com.gmcc.pboss.control.sales.autodeal;

import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderresdet.Orderresdet;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;





/**
 * <p>Title: OrderresdetBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderresdetDealBO extends AbstractControlBean implements
			OrderDeal {

	public boolean doDeal(OrderVO orderVO, DBAccessUser user) throws Exception {
		Orderresdet orderresdet = (Orderresdet)BOFactory.build(OrderresdetBO.class, user,BOFactory.PROPAGATION_REQUIRES_NEW);
		OrderresdetDBParam orderresdetDBParam=new OrderresdetDBParam();
		orderresdetDBParam.set_se_orderid(orderVO.getOrderid());
		try{
			orderresdet.doResdraw(orderresdetDBParam,true);//≥È»°∑Ω∑®
			return true;
		}catch(Exception e){
			e.printStackTrace();
			Order order = (Order)BOFactory.build(OrderBO.class, user,BOFactory.PROPAGATION_REQUIRES_NEW);
			orderVO.setMemo(e.getMessage());
			order.doUpdate(orderVO);
			return false;
		}
	}
	
}
