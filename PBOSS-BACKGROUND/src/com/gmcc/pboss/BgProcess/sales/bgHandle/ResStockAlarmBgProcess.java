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
 * 资源库存预警
 * 功能描述： 对分公司资源库存量、已销售量、已激活量等信息进行统计，
 * 结合资源库存预警规则，生成预警信息数据，红色预警时发送短信通知。
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
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		pro.setMyProfilePath("/sales/bgHandle/resStockAlarm.properties");
		// 初始化
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
