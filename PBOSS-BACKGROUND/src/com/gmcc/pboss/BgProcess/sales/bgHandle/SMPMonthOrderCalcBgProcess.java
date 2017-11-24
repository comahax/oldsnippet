package com.gmcc.pboss.BgProcess.sales.bgHandle;



import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.SMPMonthOrderCalc.SMPMonthOrderCalc;
import com.gmcc.pboss.control.sales.bgcontrol.SMPMonthOrderCalc.SMPMonthOrderCalcBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.ui.User;
/**
 * <pre>
 * [合作商套卡月订购量计算]后台处理逻辑
 * 功能描述： 按照套卡订购浮动规则对合作商月订购量进行计算。
 * </pre>
 * @author zhangsiwei
 *
 */
public class SMPMonthOrderCalcBgProcess extends BgBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		SMPMonthOrderCalcBgProcess pro = new SMPMonthOrderCalcBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		pro.setMyProfilePath("/sales/bgHandle/monOrderCalc.properties");
		// 初始化
		pro.init(args);
		// 不指定目标月份
		if(args.length < 2) {
			pro.monthOrderCalculate(null, user);
		}else {
			// 若指定目标月份，可设置第二个参数为目标月份的值 ，格式为"yyyyMM"
			pro.monthOrderCalculate(args[1], user);
		}
	}
	
	public void monthOrderCalculate(String destMonth,User user) throws Exception {
		
		SMPMonthOrderCalc mocBo = (SMPMonthOrderCalcBO)BOFactory.build(SMPMonthOrderCalcBO.class,user);
		try {
			mocBo.doProcess(destMonth);
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}

	@Override
	protected boolean checkArgs(String[] args) {
		
		if (args.length < 1) {
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
		sb.append("the args number is 1 or 2").append("\n");
		sb.append("[cityid] or [cityid][destmonth] (the format of \"destMonth\" is yyyyMM)").append("\n");
		sb.append("e.g. [ZS] or [ZS][200910]");
		return sb.toString();
	}


}
