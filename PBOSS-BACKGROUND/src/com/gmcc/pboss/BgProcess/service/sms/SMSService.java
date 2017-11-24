/**
 * 
 */
package com.gmcc.pboss.BgProcess.service.sms;

import com.gmcc.pboss.BgProcess.base.MdbgBase;
import com.gmcc.pboss.BgProcess.service.sms.socketserver.SpringContextServer;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;

/**
 * @author hbm
 * �������
 */
public class SMSService extends MdbgBase{
	//���������˿�
	private static final int PORT = Integer.valueOf(CoreConfigInfo.BOSS_SOCKET_SERVER_PORT);

	public static void main(String[] args) throws Exception {

		SMSService service = new SMSService();
		
		/* --����4������ͨ�õķ���������ī�سɹ棬�������������Ļ�����д���漸������--------- */
		// ������
		boolean isPass = service.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ����hibernate�����ļ�·���������class path��·����
		service.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/service/sms/hibernate.cfg.xml");
		service.setHibernateCommonConfigPath("/com/gmcc/pboss/BgProcess/service/sms/hibernate_comm.hbm.xml");
		service.setMyProfilePath("/service/sms/SMSService.properties");
		// ��ʼ��
		
		service.init(args);
		/* ------------------------------------------------------------------------------- */
		service.startSocket();
	}
	
	private void startSocket() throws Exception{
		SpringContextServer server = new SpringContextServer(PORT,"com.gmcc.pboss.BgProcess.service.sms.action");
//		Server server = new Server(PORT,"com.gmcc.pboss.BgProcess.service.sms.action");
		server.run();
	}
}
