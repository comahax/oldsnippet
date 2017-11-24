package com.gmcc.pboss.BgProcess.sales.dealDataCollect;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.dealDataCollect.DealDataCollect;
import com.gmcc.pboss.control.sales.bgcontrol.dealDataCollect.DealDataCollectBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.User;

/**
 * 新增【交易数据采集后台程序】后台逻辑
 * @author dengxingxin
 *
 */
public class DealDataCollectProcess extends BgBase {
	private static Logger log = Logger.getLogger(DealDataCollectProcess.class);
	
	public static void main(String[] args){
		DealDataCollectProcess ddcProcess = new DealDataCollectProcess();
		
		/* --下面4个基类通用的方法，不用墨守成规，如果不符合需求的话就重写下面几个方法--------- */
		// 检查参数
		boolean isPass = ddcProcess.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = ddcProcess.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		ddcProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/dealDataCollect/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		ddcProcess.setMyProfilePath("/DealDataCollectProcess.properties");
		// 初始化
		try {
			ddcProcess.init(args);
			
			/* ------------------------------------------------------------------------------- */
			log.info("=========交易数据采集后台程序=====初始化完成，开始处理==========");
			// 开始处理
			String date = "";
			if(args.length == 2){
				date = args[1];
			}
			
			ddcProcess.process(user,date);
			
			log.info("======交易数据采集后台程序========处理完成，正常退出===========");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			log.error("=====交易数据采集后台程序=========异常退出===============");
		}
	}
	
	private void process(DBAccessUser user,String date) throws Exception{
		DealDataCollect dealDataCollectBO = (DealDataCollectBO) BOFactory.build(DealDataCollectBO.class, user);
		dealDataCollectBO.doProcess(date);
	}
	
	
}
