package com.gmcc.pboss.BgProcess.sales.bgHandle;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.orderConfirmnotice.OrderConfirmnotice;
import com.gmcc.pboss.control.sales.bgcontrol.orderConfirmnotice.OrderConfirmnoticeBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * <pre>
 * 【订单确认提醒】后台逻辑
 * 功能描述：定时对待确认订单未及时回复确认的给予短信提醒
 * </pre>
 * @author panyonghui
 *
 */

public class OrderConfirmnoticeBgProcess extends BgBase {

	public static void main(String[] args) throws Exception{
		OrderConfirmnoticeBgProcess pro = new OrderConfirmnoticeBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		pro.setMyProfilePath("/sales/bgHandle/orderConfirmnotice.properties");
		// 初始化
		pro.init(args);
		pro.orderConfirmnotice(user);
	}
	
	public void orderConfirmnotice(User user) throws Exception {
		OrderConfirmnotice order = (OrderConfirmnotice) BOFactory.build(OrderConfirmnoticeBO.class, user);
		try {
			order.doProcess();
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
}
