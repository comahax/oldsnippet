/**
 * 
 */
package com.gmcc.pboss.BgProcess.service.sms;

import com.gmcc.pboss.BgProcess.base.MdbgBase;
import com.gmcc.pboss.BgProcess.service.sms.socketserver.SpringContextServer;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;

/**
 * @author hbm
 * 程序入口
 */
public class SMSService extends MdbgBase{
	//服务启动端口
	private static final int PORT = Integer.valueOf(CoreConfigInfo.BOSS_SOCKET_SERVER_PORT);

	public static void main(String[] args) throws Exception {

		SMSService service = new SMSService();
		
		/* --下面4个基类通用的方法，不用墨守成规，如果不符合需求的话就重写下面几个方法--------- */
		// 检查参数
		boolean isPass = service.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 设置hibernate配置文件路径（相对于class path的路径）
		service.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/service/sms/hibernate.cfg.xml");
		service.setHibernateCommonConfigPath("/com/gmcc/pboss/BgProcess/service/sms/hibernate_comm.hbm.xml");
		service.setMyProfilePath("/service/sms/SMSService.properties");
		// 初始化
		
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
