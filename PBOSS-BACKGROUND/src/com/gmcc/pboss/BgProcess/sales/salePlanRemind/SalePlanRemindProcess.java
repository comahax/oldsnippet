package com.gmcc.pboss.BgProcess.sales.salePlanRemind;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.salePlanRemind.SalePlanRemind;
import com.gmcc.pboss.control.sales.bgcontrol.salePlanRemind.SalePlanRemindBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.User;

/**
 * 新增【销售进度提醒】后台逻辑
 * @author dengxingxin
 * 
 * 程序运行路径 地市标识，是否发送短信(Y、N)
 *
 */
public class SalePlanRemindProcess extends BgBase {
	private static Logger log = Logger.getLogger(SalePlanRemindProcess.class);
	
	public static void main(String[] args){
		SalePlanRemindProcess sprProcess = new SalePlanRemindProcess();
		
		/* --下面4个基类通用的方法，不用墨守成规，如果不符合需求的话就重写下面几个方法--------- */
		// 检查参数
		boolean isPass = sprProcess.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = sprProcess.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		sprProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/salePlanRemind/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		sprProcess.setMyProfilePath("/SalePlanRemindProcess.properties");
		// 初始化
		try {
			sprProcess.init(args);
			
			if(args.length != 2){
				log.info("=========【销售进度提醒】=====参数不对，退出==========");
				return;
			}
			
			String sendMsgFlag = args[1];
			
			/* ------------------------------------------------------------------------------- */
			log.info("=========【销售进度提醒】=====初始化完成，开始处理==========");
			// 开始处理
			
			sprProcess.process(user,sendMsgFlag);
			
			log.info("======【销售进度提醒】========处理完成，正常退出===========");
			
		} catch (Exception e) {e.printStackTrace();
			log.error(e);
			log.error("=====【销售进度提醒】=========异常退出===============\n"+e.getMessage());
		}
	}
	
	private void process(DBAccessUser user,String sendMsgFlag) throws Exception{
		String sendDate = properties.getProperty("sendDate");
		SalePlanRemind salePlanRemindBO = (SalePlanRemindBO) BOFactory.build(SalePlanRemindBO.class, user);
		salePlanRemindBO.doProcess(sendMsgFlag,sendDate); 
	}

}
