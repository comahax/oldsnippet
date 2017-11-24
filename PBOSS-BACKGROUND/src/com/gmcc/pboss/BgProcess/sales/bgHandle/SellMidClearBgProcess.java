package com.gmcc.pboss.BgProcess.sales.bgHandle;

import java.util.Calendar;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.SellMidClear.SellMidClear;
import com.gmcc.pboss.control.sales.bgcontrol.SellMidClear.SellMidClearBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * 功能描述： 对BOSS深圳公共库分销商品销售中间表进行清理，删除创建时间超过指定天数的数据。
 * @author zhangsiwei
 *
 */
public class SellMidClearBgProcess extends BgBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		SellMidClearBgProcess pro = new SellMidClearBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		pro.setMyProfilePath("/sales/bgHandle/sellMidClear.properties");
		// 初始化
		pro.init(args);
		pro.clearSellMid(args[0], user);
		
	}
	
	public void clearSellMid(String arg1,User user) throws Exception {
		try {
			log.info("===========开始清理分销商品销售中间表=========");
			String keepDays = properties.getProperty(arg1+"_keepdays");
			
			if(StringUtils.isEmpty(keepDays)) {
				// 保留天数如无数据则默认为30。
				keepDays = "30";
			}else {
				if(!PublicUtils.isInteger(keepDays) || Integer.parseInt(keepDays) < 0) {
					throw new BusinessException("保留期时间参数："+arg1+"_keepdays 必须为正整数");
				}
			}
			Calendar now = Calendar.getInstance();
			now.set(Calendar.HOUR_OF_DAY, 0);
			now.set(Calendar.MINUTE, 0);
			now.set(Calendar.SECOND, 0);
			now.add(Calendar.DAY_OF_MONTH, -Integer.parseInt(keepDays));
			
			SellMidClear smcBo = (SellMidClear)BOFactory.build(SellMidClearBO.class,user);
			smcBo.doProcess(now.getTime());
			log.info("===========完成清理分销商品销售中间表=========");
		}catch(BusinessException ex) {
			log.info(ex.getMessage());
			log.info("===========出现异常，未完成清理分销商品销售中间表=========");
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
			log.info("===========出现异常，未完成清理分销商品销售中间表=========");
		}
	}

	@Override
	protected boolean checkArgs(String[] args) {
		if (args.length < 1 || !"BOSSCOMMON".equals(args[0])) {
			System.out.println(getHelp());
			return false;
		}
		return true;
	}
	
	protected static String getHelp() {
		StringBuffer sb = new StringBuffer();
		sb.append("Explain of args:").append("\n");
		sb.append("the args number is 1").append("\n");
		sb.append("[cityid] must be [BOSSCOMMON]" ).append("\n");
		return sb.toString();
	} 

}
