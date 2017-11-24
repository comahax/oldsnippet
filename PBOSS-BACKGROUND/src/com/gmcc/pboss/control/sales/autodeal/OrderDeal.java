package com.gmcc.pboss.control.sales.autodeal;

import com.gmcc.pboss.business.sales.order.OrderVO;
import com.sunrise.jop.infrastructure.db.DBAccessUser;


/**
 * 订单自动处理时用到的接口
 * @author wefrogll
 * @version 1.0 2009-10-22
 */
public interface OrderDeal {
	public boolean doDeal(OrderVO order, DBAccessUser user) throws Exception;
}
