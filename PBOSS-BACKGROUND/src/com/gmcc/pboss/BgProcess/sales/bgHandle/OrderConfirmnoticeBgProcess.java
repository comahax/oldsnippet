package com.gmcc.pboss.BgProcess.sales.bgHandle;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.orderConfirmnotice.OrderConfirmnotice;
import com.gmcc.pboss.control.sales.bgcontrol.orderConfirmnotice.OrderConfirmnoticeBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * <pre>
 * ������ȷ�����ѡ���̨�߼�
 * ������������ʱ�Դ�ȷ�϶���δ��ʱ�ظ�ȷ�ϵĸ����������
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
		// ��ȡUser
		User user = pro.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		pro.setMyProfilePath("/sales/bgHandle/orderConfirmnotice.properties");
		// ��ʼ��
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
