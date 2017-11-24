package com.gmcc.pboss.BgProcess.sales.bgHandle;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.emptysimrealtimeupdate.EmptySimRealTimeUpdate;
import com.gmcc.pboss.control.sales.bgcontrol.emptysimrealtimeupdate.EmptySimRealTimeUpdateBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class EmptySimRealTimeUpdateBgProcess extends BgBase {

	/**
	 * �հ�SIM��ʵʱ����������
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		EmptySimRealTimeUpdateBgProcess pro = new EmptySimRealTimeUpdateBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = pro.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		pro
				.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		// pro.setMyProfilePath("/sales/bgHandle/realtimereceive.properties");
		pro
				.setMyProfilePath("/sales/bgHandle/emptySimRealTimeUpdate.properties");
		// ��ʼ��
		pro.init(args);
		pro.dodeal(user);

	}

	public void dodeal(User user)
			throws Exception {
		EmptySimRealTimeUpdate emptySimRealTimeUpdate = (EmptySimRealTimeUpdate) BOFactory.build(
				EmptySimRealTimeUpdateBO.class, user);
		log.info("************************emptySimRealTimeUpdate    start*****************************");
		emptySimRealTimeUpdate.process();
		log.info("************************emptySimRealTimeUpdate    end*****************************");
		
	}

}
