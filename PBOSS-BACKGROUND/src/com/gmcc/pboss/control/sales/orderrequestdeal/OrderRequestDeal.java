/**
 * auto-generated code
 * Wed Nov 18 17:19:05 CST 2009
 */
package com.gmcc.pboss.control.sales.orderrequestdeal;

import com.gmcc.pboss.business.sales.orderreq.OrderreqVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * <p>Title: Orderreq </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface OrderRequestDeal extends AbstractControl {
    public void doProcess(OrderreqVO orderreqVO) throws Exception;
}
