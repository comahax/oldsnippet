package com.gmcc.pboss.BgProcess.sales.saleactivestatistics;

import java.util.Date;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.common.utils.tools.DateUtil.DateFormatType;
import com.gmcc.pboss.common.utils.tools.DateUtil.DateOperationType;
import com.gmcc.pboss.common.utils.tools.DateUtil.TimeFormatType;
import com.gmcc.pboss.control.sales.bgcontrol.saleactivestatistics.SaleActiveStatistics;
import com.gmcc.pboss.control.sales.bgcontrol.saleactivestatistics.SaleActiveStatisticsBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.User;

public class SaleComrescardProcess extends BgBase {

private static Logger log = Logger.getLogger(SaleComrescardProcess.class);
	
	public static void main(String[] args){
		SaleComrescardProcess saleActiveStatisticsProcess = new SaleComrescardProcess();
		
		/* --下面4个基类通用的方法，不用墨守成规，如果不符合需求的话就重写下面几个方法--------- */
		// 检查参数
		boolean isPass = saleActiveStatisticsProcess.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = saleActiveStatisticsProcess.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		saleActiveStatisticsProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/saleactivestatistics/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		saleActiveStatisticsProcess.setMyProfilePath("/sales/bgHandle/salecomrescard.properties");
		// 初始化
		try {
			saleActiveStatisticsProcess.init(args);
			
			/* ------------------------------------------------------------------------------- */
			log.info("=========【充值卡收集数据收集程序】=====初始化完成，开始处理==========");
			
			String starttime = null;
			String endtime = null;
			
			// 开始处理
			if(args.length == 3){
				starttime = args[1];
//				log.info("starttime = "+starttime);
				endtime = args[2]; 
//				log.info("endtime = "+endtime);
			}else{
				Date Afdate = DateUtil.operationDateOfDay(DateUtil.getCurrentDate(),1,DateOperationType.DIFF);
				int year = DateUtil.getTime(Afdate,TimeFormatType.YEAR);
				int month = DateUtil.getTime(Afdate,TimeFormatType.MONTH);
				int day = DateUtil.getTime(Afdate,TimeFormatType.DAY);
				
				starttime = year+"-"+month+"-"+day+" 00:00:00";
				endtime = year+"-"+month+"-"+day+" 23:59:59";
			}
			saleActiveStatisticsProcess.process(user,starttime,endtime);
			
			log.info("======【充值卡收集数据收集程序】========处理完成，正常退出===========");
			
		} catch (Exception e) {e.printStackTrace();
			log.error(e);
			log.error("=====【充值卡收集数据收集程序】=========异常退出===============\n"+e.getMessage());
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
	
	private void process(DBAccessUser user,String starttime,String endtime) throws Exception{
		SaleActiveStatistics saleActiveStatistics = (SaleActiveStatisticsBO) BOFactory.build(SaleActiveStatisticsBO.class, user);
//		//套卡收集
//		try{
//			//同步之前先删除同一天的数据，防止数据重复
//			saleActiveStatistics.doDelComressProcess(starttime,endtime);
//			
//			saleActiveStatistics.doComressProcess(starttime,endtime);
//			//ZS "2014-06-07 00:00:00" "2014-06-10 23:59:59"
//		} catch(Exception e){
//			log.error(e.getMessage());
//		}
		
		
		//充值卡收集
		try{
			//同步之前先删除同一天的数据，防止数据重复
			saleActiveStatistics.doDelComrescardProcess(starttime, endtime);
			
			saleActiveStatistics.doComrescardProcess(starttime, endtime);
			//ZS "2014-06-27 00:00:00" "2014-06-27 23:59:59"
		} catch(Exception e){
			log.error(e.getMessage());
		}
		
		
//		//激活数据收集
//		try{
//			//同步之前先删除同一天的数据，防止数据重复
//			saleActiveStatistics.doDelActiveProcess(starttime, endtime);
//			
//			saleActiveStatistics.doActiveProcess(starttime, endtime);
//			//ZS "2014-04-25 00:00:00" "2014-04-25 23:59:59"
//		} catch(Exception e){
//			log.error(e.getMessage());
//		}
	}

}
