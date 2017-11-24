package com.gmcc.pboss.BgProcess.sales.bgHandle;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.SMPOrderUpperLimitUpdate.SMPOrderUpperLimitUpdate;
import com.gmcc.pboss.control.sales.bgcontrol.SMPOrderUpperLimitUpdate.SMPOrderUpperLimitUpdateBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;
/**
 * <pre>
 * 【网点套卡订购上限更新后台程序】
 * 功能描述：根据网点前N个月的激活平均量，自动更新网点套卡订购上限
 * （不满足N个月或者手工更新的网点则不需要更新）
 * </pre>
 * @author zhangsiwei,yedaoe
 *
 */
public class SMPOrderUpperLimitUpdateBgProcess extends BgBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		SMPOrderUpperLimitUpdateBgProcess pro = new SMPOrderUpperLimitUpdateBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		pro.setMyProfilePath("/sales/bgHandle/orderupperlimitUpdate.properties");
		// 初始化
		pro.init(args);
		pro.orderupperlimitUpdate(user);
	}
	
	private void orderupperlimitUpdate(User user) throws Exception {
		
		SMPOrderUpperLimitUpdate bo = (SMPOrderUpperLimitUpdate) BOFactory
				.build(SMPOrderUpperLimitUpdateBO.class, user);
		try {
			//Map<String,Double> alarmValue = this.getAlarmValueScale();
			bo.doProcess();
		}catch(BusinessException ex) {
			log.info(ex.getMessage());
		}catch(Exception ex) {
			LoggerUtils.error(ex,log);
		}
	}
	
//	private Map<String,Double> getAlarmValueScale() throws Exception {
//		Map<String,Double> result = new HashMap<String,Double>();
//		for(Enumeration elementNames = properties.propertyNames();elementNames.hasMoreElements();) {
//			String eleName = (String)elementNames.nextElement();
//			if(eleName.indexOf("_SCALE") > -1) {
//				result.put(eleName, Double.parseDouble(properties.getProperty(eleName)));
//			}
//		}
//		return result;
//	}

}
