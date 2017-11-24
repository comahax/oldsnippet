package com.gmcc.pboss.BgProcess.imprrlparamsyn2crm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.BgProcess.base.SecurityPass;
import com.gmcc.pboss.business.imprrlparamsyn2crm.rlparamsyn.Rlparamsyn;
import com.gmcc.pboss.business.imprrlparamsyn2crm.rlparamsyn.RlparamsynBO;
import com.gmcc.pboss.business.imprrlparamsyn2crm.rlparamsyn.RlparamsynDBParam;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * @author hbm
 * PBOSS_IM_004资源入库参数同步接口
 * 
 * 业务标识resparamsyn
 * 
 */
public class  ImprrlparamsynProcess extends BgBase {

	private int batch_size = 100;//每批次处理明细记录条数
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ImprrlparamsynProcess chProcess = new ImprrlparamsynProcess();

		/* --下面4个基类通用的方法，不用墨守成规，如果不符合需求的话就重写下面几个方法
		 * 
		 * 本程序连接的是公共库,输入 DB_COMMON 就可以了
		 * 
		 * --------- */
		// 检查参数
		boolean isPass = chProcess.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User,包含cityid
		User user = chProcess.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		chProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/imprrlparamsyn2crm/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		chProcess.setMyProfilePath("/ImprrlparamsynProcess.properties");
		// 初始化
		chProcess.init(args);
		/* ------------------------------------------------------------------------------- */

		// 开始处理
		try {
			log.info("=========PBOSS_IM_004资源入库参数同步接口=====初始化完成，开始处理==========");
			chProcess.process(user);
			log.info("=========PBOSS_IM_004资源入库参数同步接口=====处理完成，正常退出============");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("=========PBOSS_IM_004资源入库参数同步接口=====异常退出====================");
		}
	}
	
	@Override
	protected void init(String[] args) throws Exception {
		//super.init(args);
		String cityid = args[0];		
		initProperties();
		// 初始化log
		String logFilename = properties.getProperty(cityid + "_log");
		BasicConfigurator.configure();
		if (logFilename != null) {
			Logger logger = Logger.getRootLogger();
			DailyRollingFileAppender appender = (DailyRollingFileAppender) logger.getAppender("FILE");
			Date today = new Date();
			// 日志文件生成在与classpath同级的目录下; by zhangsiwei
			appender.setFile(BgBase.class.getResource("/").getPath()+"../"+(logFilename + "." + (new SimpleDateFormat("yyMMdd")).format(today)));
			appender.activateOptions();

			logger.info("------log file changed to " + logFilename + " ---------------");
			StringBuffer sb = new StringBuffer();
			for (String arg : args) {
				sb.append("[").append(arg).append("] ");
			}
			logger.info(sb);
			log = logger;
		} else {
			log = Logger.getLogger(this.getClass());
		}

		// 初始化hibernate相关信息
		String url = properties.getProperty("DB_COMMON_db_url");
		String username = properties.getProperty("DB_COMMON_db_user");
		String tempPoolsize = properties.getProperty("DB_COMMON_db_poolsize");
		String poolsize = "5";
		if (tempPoolsize != null) {
			poolsize = tempPoolsize;
		}
		String password = properties.getProperty("DB_COMMON_db_password");
		password = new String(SecurityPass.decode(SecurityPass.hex2byte(password), SecurityPass.hex2byte(mkey)));

		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.connection.url", url);
		hibernateProperties.setProperty("hibernate.connection.username", username);
		hibernateProperties.setProperty("hibernate.connection.password", password);
		hibernateProperties.setProperty("hibernate.connection.pool_size", poolsize);
		this.registerSessionFactoryBean(hibernateProperties);

		registerTypeConvert();//注册类型转换器
		
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
	protected void process(User user)  throws Exception{
		String secondsleep = properties.getProperty("secondsleep");
		if(secondsleep == null || "".equals(secondsleep)){
			log.info("=========PBOSS_IM_004资源入库参数同步接口=====secondsleep 未设定，退出====================");
			return ;
		}
		Long secondsleepLong = 0L;
		try {
			secondsleepLong = Long.parseLong(secondsleep);
		} catch (Exception e) {
			log.info("=========PBOSS_IM_004资源入库参数同步接口=====secondsleep 非数字，退出====================");
			return ;
		}
		Rlparamsyn bo = (Rlparamsyn) BOFactory.build(RlparamsynBO.class, user);
		//boolean noException = true;
		while(true){
			log.info("=========PBOSS_IM_004资源入库参数同步接口=====单次开始处理==========");
			try {
				RlparamsynDBParam param=new RlparamsynDBParam();
				param.set_ne_opract("0");
				param.set_se_cityid(user.getCityid());
				param.setCountOnly(true);
				DataPackage dp = bo.doQuery(param);
				if(dp.getRowCount()>0){
					int rowcount = dp.getRowCount();
					while(rowcount>0){
						bo.doProcess(user.getCityid(),this.batch_size);
						rowcount -= this.batch_size;
					}
				}
			} catch (Exception e) {
				log.info("=========PBOSS_IM_004资源入库参数同步接口=====异常退出(单次)====================\n"+e.getMessage());
				//noException = false;
				e.printStackTrace();
			}
			log.info("=========PBOSS_IM_004资源入库参数同步接口=====单次处理结束==========");
			
			log.info(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd HH:mm:ss") + 
					"=========PBOSS_IM_004资源入库参数同步接口" +
					"========休眠秒数=================" + secondsleepLong);
			
			Thread.sleep(secondsleepLong*1000);
		}
	}
}
