package com.gmcc.pboss.BgProcess.sales.bgHandle;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.comOrderNotice.ComOrderNotice;
import com.gmcc.pboss.control.sales.bgcontrol.comOrderNotice.ComOrderNoticeBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * <pre>
 * ��Ʒ�������Ѻ�̨����
 * �����������Ե���ɶ�����������ж�������
 * </pre>
 * @author yedaoe
 *
 */
public class ComOrderNoticeProcess extends BgBase {

	public static void main(String[] args) throws Exception{
		ComOrderNoticeProcess pro = new ComOrderNoticeProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = pro.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		pro.setMyProfilePath("/sales/bgHandle/comOrderNotice.properties");
		// ��ʼ��
		pro.init(args);
		pro.comOrderNotice(user);
	}
	
	private void comOrderNotice(User user) throws Exception {
		
		ComOrderNotice comOrderNotice = (ComOrderNotice)BOFactory.build(ComOrderNoticeBO.class, user);
		try {
			log.info("==================��Ʒ�������Ѻ�̨����ʼ==================");
			comOrderNotice.doProcess();
			log.info("==================��Ʒ�������Ѻ�̨�������==================");
		}catch(BusinessException ex) {
			log.info(ex.getMessage());
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
}
