package com.gmcc.pboss.BgProcess.sales.realtimemt;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.realtimemt.RealTimeOrder;
import com.gmcc.pboss.control.sales.realtimemt.RealTimeOrderBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 */
public class UpdateRealTimeOrder extends BgBase{

	public static void main(String[] args){
		try{
			UpdateRealTimeOrder realTimeOrder = new UpdateRealTimeOrder();
			boolean isPass = realTimeOrder.checkArgs(args);
			if (!isPass) {
				return;
			}
			User user = realTimeOrder.getUser(args[0]);
			realTimeOrder.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/order/hibernate.cfg.xml");
			realTimeOrder.setMyProfilePath("/sales_realtimeorder.properties");
			realTimeOrder.init(args);
			RealTimeOrder realTimeOrderBO = (RealTimeOrderBO)BOFactory.build(RealTimeOrderBO.class,user);
			log.info("=========�׿�ʵʱ����������=====��ʼ����ɣ���ʼ����==========");
			realTimeOrderBO.process();
			log.info("=========�׿�ʵʱ����������=====������ɣ������˳�============");
			
		}catch(Exception e){
			log.error(e);
			log.error("=====�׿�ʵʱ����������=========�쳣�˳�===============");
		}
		
	}
}
