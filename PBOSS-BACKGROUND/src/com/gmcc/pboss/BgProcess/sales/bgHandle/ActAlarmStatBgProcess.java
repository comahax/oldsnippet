package com.gmcc.pboss.BgProcess.sales.bgHandle;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.actAlarmStat.ActAlarmStat;
import com.gmcc.pboss.control.sales.bgcontrol.actAlarmStat.ActAlarmStatBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * ���㼤����Ԥ����̨����
 * ����������ͳ��ָ����������µ����������������������
 * ���з�ʽ�� ÿ��1���賿05:00����
 * @author zhangsiwei
 *
 */
public class ActAlarmStatBgProcess extends BgBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ActAlarmStatBgProcess pro = new ActAlarmStatBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = pro.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		pro.setMyProfilePath("/sales/bgHandle/actAlarmStat.properties");
		// ��ʼ��
		pro.init(args);
		pro.actAlarmStat(user);
	}

	private void actAlarmStat(User user) throws Exception {
		try {
			ActAlarmStat aasBO = (ActAlarmStat) BOFactory.build(
					ActAlarmStatBO.class, user);
			aasBO.doProcess();
		}catch(BusinessException ex) {
			log.info(ex.getMessage());
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
}
