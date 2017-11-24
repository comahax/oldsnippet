package com.gmcc.pboss.BgProcess.sales.bgHandle;

import java.util.Date;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.common.utils.tools.DateUtil.DateOperationType;
import com.gmcc.pboss.common.utils.tools.DateUtil.TimeFormatType;
import com.gmcc.pboss.control.sales.bgcontrol.wayStockSnpt.WayStockSnapShort;
import com.gmcc.pboss.control.sales.bgcontrol.wayStockSnpt.WayStockSnapShortBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.User;

/**
 * 【网点库存快照】后台逻辑
 * 功能描述： 对于配送商垫资的订单进行统计汇总。
 * @author zhangsiwei
 *
 */
public class WayStockSnapShortBgProcess extends BgBase {

	/**
	 * @param args 
	 */
	public static void main(String[] args) throws Exception{

		WayStockSnapShortBgProcess pro = new WayStockSnapShortBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		pro.setMyProfilePath("/sales/bgHandle/wayStockSnpt.properties");
		// 初始化
		pro.init(args);
		
		String starttime = null;
		String endtime = null;
		
		// 开始处理
		if(args.length == 3){
			starttime = args[1];
//			log.info("starttime = "+starttime);
			endtime = args[2]; 
//			log.info("endtime = "+endtime);
		}else{
			Date Afdate = DateUtil.operationDateOfDay(DateUtil.getCurrentDate(),1,DateOperationType.DIFF);
			int year = DateUtil.getTime(Afdate,TimeFormatType.YEAR);
			int month = DateUtil.getTime(Afdate,TimeFormatType.MONTH);
			int day = DateUtil.getTime(Afdate,TimeFormatType.DAY);
			
			starttime = year+"-"+month+"-"+day+" 00:00:00";
			endtime = year+"-"+month+"-"+day+" 23:59:59";
		}
		
		pro.wayStockSnpt(user,starttime,endtime);
		
	}
	
	private void wayStockSnpt(User user,String starttime,String endtime) throws Exception {
		try {
			log.info("==================网点库存快照开始==================");
			WayStockSnapShort wssBO = (WayStockSnapShort)BOFactory.build(WayStockSnapShortBO.class, user);
			wssBO.doProcess(starttime, endtime);
			log.info("==================网点库存快照结束==================");
		}catch(BusinessException ex) {
			log.info(ex.getMessage());
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
	

	protected boolean checkArgs(String[] args) {
		
		if(args.length != 1 && args.length != 3){
			System.out.println("传入参数个数错误！");
			return false;
		}
		if(args.length == 3){
			try {
				PublicUtils.UtilStrToDate(args[1]);
				PublicUtils.UtilStrToDate(args[2]);
			} catch (Exception e) {
				System.out.println("传入日期格式错误！");
				return false;
			}
		}
		
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

}
