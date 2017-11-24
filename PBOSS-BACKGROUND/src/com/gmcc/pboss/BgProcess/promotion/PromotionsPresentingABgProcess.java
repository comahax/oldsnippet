package com.gmcc.pboss.BgProcess.promotion;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.promotion.bgcontrol.PromotionsPresentingA.PromotionsPresentingA;
import com.gmcc.pboss.control.promotion.bgcontrol.PromotionsPresentingA.PromotionsPresentingABO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.ui.User;
/**
 * 赠送（事后）促销方案模块
 * @author zhangsiwei
 *
 */
public class PromotionsPresentingABgProcess extends BgBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		PromotionsPresentingABgProcess pro = new PromotionsPresentingABgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/promotion/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		pro.setMyProfilePath("/promotionBgProcess.properties");
		// 初始化
		pro.init(args);
		pro.presentingAProcess(Long.parseLong(args[1]), user);
	}

	public void presentingAProcess(long pid, User user) throws Exception {
		PromotionsPresentingA ppaBo = 
			(PromotionsPresentingABO)BOFactory.build(PromotionsPresentingABO.class,user);
		try {
			ppaBo.doProcess(pid);
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}

	protected boolean checkArgs(String[] args) {
		if (args.length < 2) {
			System.out.println(getHelp());
			return false;
		}
		if (!CityMappingUtil.contain(args[0])) {
			System.out.println("cityid is not exist");
			return false;
		}
		return true;
	}
	
	protected static String getHelp() {
		StringBuffer sb = new StringBuffer();
		sb.append("Explain of args:").append("\n");
		sb.append("the args number is 2").append("\n");
		sb.append("[cityid][pid]").append("\n");
		sb.append("e.g. [ZS][2601]");
		return sb.toString();
	}


}
