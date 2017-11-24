package com.gmcc.pboss.BgProcess.sales.orderOvertimeArm;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.User;

/**
 * ���͵���ʱԤ��
 * @author dengxingxin
 *
 */
public class OrderOvertimeArmProcess extends BgBase {
	private static Logger log = Logger.getLogger(OrderOvertimeArmProcess.class);
	
	public static void main(String[] args){
		OrderOvertimeArmProcess ooWarn = new OrderOvertimeArmProcess();
		
		/* --����4������ͨ�õķ���������ī�سɹ棬�������������Ļ�����д���漸������--------- */
		// ������
		boolean isPass = ooWarn.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = ooWarn.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		ooWarn.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/orderOvertimeArm/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		ooWarn.setMyProfilePath("/OrderOvertimeArmProcess.properties");
		// ��ʼ��
		try {
			ooWarn.init(args);
			
			/* ------------------------------------------------------------------------------- */
			log.info("=========���͵���ʱԤ��=====��ʼ����ɣ���ʼ����==========");
			// ��ʼ����
			
			ooWarn.process(user);
			
			log.info("======���͵���ʱԤ��========������ɣ������˳�===========");
			
		} catch (Exception e) {
			log.error(e);
			log.error("=====���͵���ʱԤ��=========�쳣�˳�===============");
		}
	}
	
	private void process(DBAccessUser user) throws Exception{
		Order orderBO = (OrderBO) BOFactory.build(OrderBO.class, user);
		orderBO.doProcess(user);
	}
	
	
}
