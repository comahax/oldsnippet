package com.gmcc.pboss.BgProcess.sales.orderOvertimeArm;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.User;

/**
 * 配送单超时预警
 * @author dengxingxin
 *
 */
public class OrderOvertimeArmProcess extends BgBase {
	private static Logger log = Logger.getLogger(OrderOvertimeArmProcess.class);
	
	public static void main(String[] args){
		OrderOvertimeArmProcess ooWarn = new OrderOvertimeArmProcess();
		
		/* --下面4个基类通用的方法，不用墨守成规，如果不符合需求的话就重写下面几个方法--------- */
		// 检查参数
		boolean isPass = ooWarn.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = ooWarn.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		ooWarn.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/orderOvertimeArm/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		ooWarn.setMyProfilePath("/OrderOvertimeArmProcess.properties");
		// 初始化
		try {
			ooWarn.init(args);
			
			/* ------------------------------------------------------------------------------- */
			log.info("=========配送单超时预警=====初始化完成，开始处理==========");
			// 开始处理
			
			ooWarn.process(user);
			
			log.info("======配送单超时预警========处理完成，正常退出===========");
			
		} catch (Exception e) {
			log.error(e);
			log.error("=====配送单超时预警=========异常退出===============");
		}
	}
	
	private void process(DBAccessUser user) throws Exception{
		Order orderBO = (OrderBO) BOFactory.build(OrderBO.class, user);
		orderBO.doProcess(user);
	}
	
	
}
