package com.gmcc.pboss.BgProcess.sales.bgHandle;



import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.SMPActiveRateCalc;
import com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.SMPActiveRateCalcBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * <pre>
 * [套卡激活率计算]后台处理逻辑
 * 功能描述： 对合作商套卡激活率进行计算
 * </pre>
 * @author zhangsiwei
 *
 */
public class SMPActiveRateCalcBgProcess extends BgBase{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		SMPActiveRateCalcBgProcess pro = new SMPActiveRateCalcBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		pro.setMyProfilePath("/sales/bgHandle/activeCalc.properties");
		// 初始化
		pro.init(args);
		pro.activeRateCalculate(user);
	}	
	
	public void activeRateCalculate(User user) throws Exception {
		SMPActiveRateCalc arcBo = (SMPActiveRateCalcBO)BOFactory.build(SMPActiveRateCalcBO.class,user);
		try {
			arcBo.doProcess();
		}catch(BusinessException ex) {
			log.info(ex.getMessage());
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
	
}
