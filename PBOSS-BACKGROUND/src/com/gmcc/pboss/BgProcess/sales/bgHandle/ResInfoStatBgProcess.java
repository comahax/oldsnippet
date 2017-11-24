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
 * 网点资源信息统计后台程序
 * 功能描述：定时统计网点库存量、领货量、激活量及预警信息
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
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		pro.setMyProfilePath("/sales/bgHandle/resInfoStat.properties");
		// 初始化
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
