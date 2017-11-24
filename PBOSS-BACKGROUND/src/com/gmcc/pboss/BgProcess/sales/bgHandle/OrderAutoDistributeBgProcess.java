package com.gmcc.pboss.BgProcess.sales.bgHandle;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.orderAutoDistribute.OrderAutoDistribute;
import com.gmcc.pboss.control.sales.bgcontrol.orderAutoDistribute.OrderAutoDistributeBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class OrderAutoDistributeBgProcess extends BgBase {

	public static void main(String[] args) throws Exception{
		OrderAutoDistributeBgProcess pro = new OrderAutoDistributeBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		pro.setMyProfilePath("/sales/bgHandle/orderAutoDis.properties");
		// 初始化
		pro.init(args);
		pro.orderAutoDistribute(user);
	}
	
	public void orderAutoDistribute(User user) throws Exception {
		OrderAutoDistribute oadBO = (OrderAutoDistribute) BOFactory.build(
				OrderAutoDistributeBO.class, user);
		try {
			oadBO.doProcess();
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
}
