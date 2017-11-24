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
 * �������Զ����ϡ���̨����
 * ��������������Ԥ������ָ��ȷ�ϻ����͵Ķ�����������
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
		// ��ȡUser
		User user = pro.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		pro.setMyProfilePath("/sales/bgHandle/orderAutoFail.properties");
		// ��ʼ��
		pro.init(args);
		pro.orderAutoFail(user);
	}
	
	public void orderAutoFail(User user) throws Exception {
		OrderAutoFail order = (OrderAutoFail) BOFactory.build(
				OrderAutoFailBO.class, user);
		try {
			// ��ȡȷ�ϳ�ʱʱ��
			Sysparam resBO = (Sysparam) BOFactory.build(SysparamBO.class, user);
			String confirmTime = resBO.doFindByID(61L, "pboss_fx");
			if (null == confirmTime) {
				confirmTime = "0";
			}
			// ��ȡ���ͳ�ʱʱ��
			String sendTime = resBO.doFindByID(62L, "pboss_fx");
			if (null == sendTime) {
				sendTime = "0";
			}
			// 1�� �Զ�����ȷ�ϳ�ʱ����
			order.failConfirmOutOrder(confirmTime);

			// 2)�Զ��������ͳ�ʱ������
			order.failSendOutOrder(sendTime);
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
}
