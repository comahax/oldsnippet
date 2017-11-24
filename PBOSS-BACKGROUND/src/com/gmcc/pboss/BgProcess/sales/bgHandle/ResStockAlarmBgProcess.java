package com.gmcc.pboss.BgProcess.sales.bgHandle;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.ResStockAlarm.ResStockAlarm;
import com.gmcc.pboss.control.sales.bgcontrol.ResStockAlarm.ResStockAlarmBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;
/**
 * <pre>
 * ��Դ���Ԥ��
 * ���������� �Էֹ�˾��Դ������������������Ѽ���������Ϣ����ͳ�ƣ�
 * �����Դ���Ԥ����������Ԥ����Ϣ���ݣ���ɫԤ��ʱ���Ͷ���֪ͨ��
 * <pre>
 * @author zhangsiwei
 *
 */
public class ResStockAlarmBgProcess extends BgBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		ResStockAlarmBgProcess pro = new ResStockAlarmBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = pro.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		pro.setMyProfilePath("/sales/bgHandle/resStockAlarm.properties");
		// ��ʼ��
		pro.init(args);
		pro.resStockAlarm(user);
	}
	
	private void resStockAlarm(User user) throws Exception {
		ResStockAlarm rsaBO = (ResStockAlarm)BOFactory.build(ResStockAlarmBO.class, user);
		try {
			rsaBO.doProcess();
		}catch(BusinessException ex) {
			log.info(ex.getMessage());
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}

}
