package com.gmcc.pboss.BgProcess.sales.bgHandle;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.actAlarmStat.ActAlarmStat;
import com.gmcc.pboss.control.sales.bgcontrol.actAlarmStat.ActAlarmStatBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * 网点激活量预警后台程序
 * 功能描述：统计指定最近几个月的领货量、激活量及激活率
 * 运行方式： 每月1号凌晨05:00运行
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
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		pro.setMyProfilePath("/sales/bgHandle/actAlarmStat.properties");
		// 初始化
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
