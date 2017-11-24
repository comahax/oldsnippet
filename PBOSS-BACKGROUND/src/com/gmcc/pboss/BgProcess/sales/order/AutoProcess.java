package com.gmcc.pboss.BgProcess.sales.order;


import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.order.OrderProcess;
import com.gmcc.pboss.control.sales.order.OrderProcessBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;


/**
 * 订单自动处理
 * @author wefrogll
 * @version 1.0 2009-11-14
 */
public class AutoProcess extends BgBase {

	public static void main(String[] args){
		try{
			AutoProcess autoProcess = new AutoProcess();
			boolean isPass = autoProcess.checkArgs(args);
			if (!isPass) {
				return;
			}
			User user = autoProcess.getUser(args[0]);
			autoProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/order/hibernate.cfg.xml");
			autoProcess.setMyProfilePath("/sales_orderautoprocess.properties");
			autoProcess.init(args);
			log.info("============== 初始化已完成 订单自动处理 开始 =====================");
			int intervalMin = autoProcess.properties.getProperty(args[0]+"_intervalMin") == null ? 10:Integer.parseInt(autoProcess.properties.getProperty(args[0]+"_intervalMin"));
			try{
				OrderProcess process = (OrderProcessBO)BOFactory.build(OrderProcessBO.class,user);
				process.process(intervalMin);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
			LoggerUtils.error(e, log);
		}
	}
	

}
