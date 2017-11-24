package com.gmcc.pboss.BgProcess.communication;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.communication.Communication;
import com.gmcc.pboss.control.communication.CommunicationBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * 订单自动处理
 * @author wefrogll
 * @version 1.0 2009-11-14
 */
public class CommunicationBgProcess extends BgBase {
	public static void main(String[] args){
		CommunicationBgProcess bgProcess = new CommunicationBgProcess();

		/* --下面4个基类通用的方法，不用墨守成规，如果不符合需求的话就重写下面几个方法--------- */
		// 检查参数
		boolean isPass = bgProcess.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = bgProcess.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		bgProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/communication/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		bgProcess.setMyProfilePath("/CommunicationBgProcess.properties");
		// 初始化
		try {
			bgProcess.init(args);
			/* ------------------------------------------------------------------------------- */

			// 开始处理
			while(true){
				String propName = args[0]+ "_intervalMin";
				int intervalMin = bgProcess.properties.getProperty(propName) == null ? 10:Integer.parseInt(bgProcess.properties.getProperty(propName));
				
				Communication communication = (Communication)BOFactory.build(CommunicationBO.class, user);
				communication.doProcess();
				System.out.println("==============休眠 "+intervalMin+" 分钟=====================");
				Thread.sleep(intervalMin*60000);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtils.error(e, log);
		}
	}
}
