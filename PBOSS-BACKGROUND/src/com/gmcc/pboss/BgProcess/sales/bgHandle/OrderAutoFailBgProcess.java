package com.gmcc.pboss.BgProcess.sales.bgHandle;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.sales.bgcontrol.orderAutoFail.OrderAutoFail;
import com.gmcc.pboss.control.sales.bgcontrol.orderAutoFail.OrderAutoFailBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * <pre>
 * 【订单自动作废】后台程序
 * 功能描述：对于预定超过指定确认或配送的订单进行作废
 * </pre>
 * @author wanghua
 *
 */

public class OrderAutoFailBgProcess extends BgBase {

	public static void main(String[] args) throws Exception{
		OrderAutoFailBgProcess pro = new OrderAutoFailBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		pro.setMyProfilePath("/sales/bgHandle/orderAutoFail.properties");
		// 初始化
		pro.init(args);
		pro.orderAutoFail(user);
	}
	
	public void orderAutoFail(User user) throws Exception {
		OrderAutoFail order = (OrderAutoFail) BOFactory.build(
				OrderAutoFailBO.class, user);
		try {
			// 获取确认超时时间
			Sysparam resBO = (Sysparam) BOFactory.build(SysparamBO.class, user);
			String confirmTime = resBO.doFindByID(61L, "pboss_fx");
			if (null == confirmTime) {
				confirmTime = "0";
			}
			// 获取配送超时时间
			String sendTime = resBO.doFindByID(62L, "pboss_fx");
			if (null == sendTime) {
				sendTime = "0";
			}
			// 1） 自动作废确认超时订单
			order.failConfirmOutOrder(confirmTime);

			// 2)自动作废配送超时订单：
			order.failSendOutOrder(sendTime);
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
}
