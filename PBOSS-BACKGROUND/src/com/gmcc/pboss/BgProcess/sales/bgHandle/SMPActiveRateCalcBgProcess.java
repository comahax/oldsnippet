package com.gmcc.pboss.BgProcess.sales.bgHandle;



import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.SMPActiveRateCalc;
import com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.SMPActiveRateCalcBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * <pre>
 * [�׿������ʼ���]��̨�����߼�
 * ���������� �Ժ������׿������ʽ��м���
 * </pre>
 * @author zhangsiwei
 *
 */
public class SMPActiveRateCalcBgProcess extends BgBase{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		SMPActiveRateCalcBgProcess pro = new SMPActiveRateCalcBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = pro.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		pro.setMyProfilePath("/sales/bgHandle/activeCalc.properties");
		// ��ʼ��
		pro.init(args);
		pro.activeRateCalculate(user);
	}	
	
	public void activeRateCalculate(User user) throws Exception {
		SMPActiveRateCalc arcBo = (SMPActiveRateCalcBO)BOFactory.build(SMPActiveRateCalcBO.class,user);
		try {
			arcBo.doProcess();
		}catch(BusinessException ex) {
			log.info(ex.getMessage());
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
	
}
