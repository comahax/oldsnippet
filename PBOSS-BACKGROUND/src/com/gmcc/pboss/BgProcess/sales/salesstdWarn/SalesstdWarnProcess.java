package com.gmcc.pboss.BgProcess.sales.salesstdWarn;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.salesstdWarn.SalesstdWarn;
import com.gmcc.pboss.control.sales.bgcontrol.salesstdWarn.SalesstdWarnBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.User;

/**
 * 新增【合作商销售提醒】后台逻辑
 * @author dengxingxin
 *
 */
public class SalesstdWarnProcess extends BgBase {
	private static Logger log = Logger.getLogger(SalesstdWarnProcess.class);
	
	public static void main(String[] args){
		SalesstdWarnProcess swProcess = new SalesstdWarnProcess();
		
		/* --下面4个基类通用的方法，不用墨守成规，如果不符合需求的话就重写下面几个方法--------- */
		// 检查参数
		boolean isPass = swProcess.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = swProcess.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		swProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/salesstdWarn/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		swProcess.setMyProfilePath("/SalesstdWarnProcess.properties");
		// 初始化
		try {
			swProcess.init(args);
			
			/* ------------------------------------------------------------------------------- */
			log.info("=========合作商销售提醒=====初始化完成，开始处理==========");
			// 开始处理
			
			swProcess.process(user);
			
			log.info("======合作商销售提醒========处理完成，正常退出===========");
			
		} catch (Exception e) {
			log.error(e);
			log.error("=====合作商销售提醒=========异常退出===============");
		}
	}
	
	private void process(DBAccessUser user) throws Exception{
		SalesstdWarn salesstdWarnBO = (SalesstdWarnBO) BOFactory.build(SalesstdWarnBO.class, user);
		salesstdWarnBO.doProcess(); 
	}

}
