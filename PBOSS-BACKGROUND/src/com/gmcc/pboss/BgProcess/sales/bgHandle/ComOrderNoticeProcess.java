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
 * 商品订购提醒后台程序
 * 功能描述：对当天可订购的网点进行短信提醒
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
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		pro.setMyProfilePath("/sales/bgHandle/comOrderNotice.properties");
		// 初始化
		pro.init(args);
		pro.comOrderNotice(user);
	}
	
	private void comOrderNotice(User user) throws Exception {
		
		ComOrderNotice comOrderNotice = (ComOrderNotice)BOFactory.build(ComOrderNoticeBO.class, user);
		try {
			log.info("==================商品订购提醒后台程序开始==================");
			comOrderNotice.doProcess();
			log.info("==================商品订购提醒后台程序结束==================");
		}catch(BusinessException ex) {
			log.info(ex.getMessage());
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
}
