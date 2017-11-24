package com.gmcc.pboss.BgProcess.sales.bgHandle;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.resInfoStat.ResInfoStat;
import com.gmcc.pboss.control.sales.bgcontrol.resInfoStat.ResInfoStatBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * <pre>
 * ������Դ��Ϣͳ�ƺ�̨����
 * ������������ʱͳ���������������������������Ԥ����Ϣ
 * </pre>
 * @author zhangsiwei
 *
 */
public class ResInfoStatBgProcess extends BgBase {

	public static void main(String[] args) throws Exception{
		ResInfoStatBgProcess pro = new ResInfoStatBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = pro.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		pro.setMyProfilePath("/sales/bgHandle/resInfoStat.properties");
		// ��ʼ��
		pro.init(args);
		pro.resInfoStat(user);
	}
	
	private void resInfoStat(User user) throws Exception {
		
		ResInfoStat risBgBO = (ResInfoStat)BOFactory.build(ResInfoStatBO.class, user);
		try {
			risBgBO.doProcess();
		}catch(BusinessException ex) {
			log.info(ex.getMessage());
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
}
