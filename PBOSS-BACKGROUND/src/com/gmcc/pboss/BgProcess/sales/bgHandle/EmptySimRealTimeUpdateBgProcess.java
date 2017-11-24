package com.gmcc.pboss.BgProcess.sales.bgHandle;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.emptysimrealtimeupdate.EmptySimRealTimeUpdate;
import com.gmcc.pboss.control.sales.bgcontrol.emptysimrealtimeupdate.EmptySimRealTimeUpdateBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class EmptySimRealTimeUpdateBgProcess extends BgBase {

	/**
	 * 空白SIM卡实时订购量更新
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
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro
				.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		// pro.setMyProfilePath("/sales/bgHandle/realtimereceive.properties");
		pro
				.setMyProfilePath("/sales/bgHandle/emptySimRealTimeUpdate.properties");
		// 初始化
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
