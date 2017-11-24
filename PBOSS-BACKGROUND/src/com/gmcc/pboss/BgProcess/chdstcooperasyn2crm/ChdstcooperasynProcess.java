package com.gmcc.pboss.BgProcess.chdstcooperasyn2crm;

import java.util.Date;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.business.chdstcooperasyn2crm.cooperasyn.Cooperasyn;
import com.gmcc.pboss.business.chdstcooperasyn2crm.cooperasyn.CooperasynBO;
import com.gmcc.pboss.business.chdstcooperasyn2crm.cooperasyn.CooperasynDBParam;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * @author hbm
 * 
 * PBOSS_IM_012PBOSS合作商资料更新
 * 
 * 
 * 
 */
public class  ChdstcooperasynProcess extends BgBase {
	
	private int batch_size = 100;//每批次处理明细记录条数

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ChdstcooperasynProcess chProcess = new ChdstcooperasynProcess();

		/* --下面4个基类通用的方法，不用墨守成规，如果不符合需求的话就重写下面几个方法--------- 
		 * 
		 * 本程序连接的是公共库,输入 DB_COMMON 就可以了
		 * 
		 * 
		 * */
		// 检查参数
		boolean isPass = chProcess.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User,包含cityid
		User user = chProcess.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		chProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/chdstcooperasyn2crm/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		chProcess.setMyProfilePath("/ChdstcooperasynProcess.properties");
		// 初始化
		chProcess.init(args);
		/* ------------------------------------------------------------------------------- */

		// 开始处理
		try {
			log.info("=========PBOSS_IM_012PBOSS合作商资料更新=====初始化完成，开始处理==========");
			chProcess.process(user);
			log.info("=========PBOSS_IM_012PBOSS合作商资料更新=====处理完成，正常退出============");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("=========PBOSS_IM_012PBOSS合作商资料更新=====异常退出====================");
		}
	}
	
	protected void init(String[] args) throws Exception {
		super.init(args);
		String batchSize = properties.getProperty("batch_size");
		if(batchSize!=null){
			try{
				this.batch_size = Integer.parseInt(batchSize);
			}catch(Exception ex){
				log.info("配置文件中batch_size非数字，使用默认值"+this.batch_size);
			}
		}
	}
	
	/**
	 * 使用spring管理事务的例子(推荐一般情况下使用)
	 */
	protected void process(User user) throws Exception {
		String secondsleep = properties.getProperty("secondsleep");
		if(secondsleep == null || "".equals(secondsleep)){
			log.info("=========PBOSS_IM_012PBOSS合作商资料更新=====secondsleep 未设定，退出====================");
			return ;
		}
		Long secondsleepLong = 0L;
		try {
			secondsleepLong = Long.parseLong(secondsleep);
		} catch (Exception e) {
			log.info("=========PBOSS_IM_012PBOSS合作商资料更新=====secondsleep 非数字，退出====================");
			return ;
		}
		Cooperasyn bo = (Cooperasyn) BOFactory.build(CooperasynBO.class, user);
		//boolean noException = true;
		while(true){//程序运行无异常
			log.info("=========PBOSS_IM_012PBOSS合作商资料更新=====单次开始处理==========");
			try {
				CooperasynDBParam param=new CooperasynDBParam();
				param.set_ne_opract("0");
				param.setCountOnly(true);
				DataPackage dp = bo.doQuery(param);
				if(dp.getRowCount()>0){
					int rowcount = dp.getRowCount();
					while(rowcount>0){
						bo.doProcess(user.getCityid(), this.batch_size);
						rowcount -= this.batch_size;
					}
				}
			}catch (Exception e) {
				log.info("=========PBOSS_IM_012PBOSS合作商资料更新=====异常退出(单次)====================\n"+e.getMessage());
				//noException = false;//程序运行遇到异常
				e.printStackTrace();
			}
			log.info("=========PBOSS_IM_012PBOSS合作商资料更新=====单次处理结束==========");
			
			log.info(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd HH:mm:ss") + 
					"=========PBOSS_IM_012PBOSS合作商资料更新" +
					"========休眠秒数=================" + secondsleepLong);
			Thread.sleep(secondsleepLong*1000);
		}
	}


}
