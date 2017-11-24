package com.gmcc.pboss.BgProcess.sales.hisactivetol;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.hisactivetol.Hisactivetol;
import com.gmcc.pboss.control.sales.hisactivetol.HisactivetolBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.User;

/**
 * 新增【历史激活数据统计】后台逻辑
 * @author ctu
 *
 */
public class HisactivetolProcess extends BgBase {
	private static Logger log = Logger.getLogger(HisactivetolProcess.class);
	
	public static void main(String[] args){
		HisactivetolProcess hp = new HisactivetolProcess();
		
		/* --下面4个基类通用的方法，不用墨守成规，如果不符合需求的话就重写下面几个方法--------- */
		// 检查参数
		boolean isPass = hp.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = hp.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		hp.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/hisactivetol/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		hp.setMyProfilePath("/HisactivetolProcess.properties");
		// 初始化
		try {
			hp.init(args);
			
			/* ------------------------------------------------------------------------------- */
			log.info("=========历史激活数据统计=====初始化完成，开始处理==========");
			// 开始处理
			
			hp.process(user);
			
			log.info("======历史激活数据统计========处理完成，正常退出===========");
			
		} catch (Exception e) {
			log.error(e);
			log.error("=====历史激活数据统计=========异常退出===============");
		}
	}
	
	private void process(DBAccessUser user) throws Exception{
		Hisactivetol hisactivetolBO = (HisactivetolBO) BOFactory.build(HisactivetolBO.class, user);
		hisactivetolBO.doProcess(user);
	}
	
	
}
