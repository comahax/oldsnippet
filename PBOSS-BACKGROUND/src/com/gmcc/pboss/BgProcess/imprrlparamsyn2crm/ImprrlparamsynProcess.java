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
 * PBOSS_IM_004��Դ������ͬ���ӿ�
 * 
 * ҵ���ʶresparamsyn
 * 
 */
public class  ImprrlparamsynProcess extends BgBase {

	private int batch_size = 100;//ÿ���δ�����ϸ��¼����
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ImprrlparamsynProcess chProcess = new ImprrlparamsynProcess();

		/* --����4������ͨ�õķ���������ī�سɹ棬�������������Ļ�����д���漸������
		 * 
		 * ���������ӵ��ǹ�����,���� DB_COMMON �Ϳ�����
		 * 
		 * --------- */
		// ������
		boolean isPass = chProcess.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser,����cityid
		User user = chProcess.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		chProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/imprrlparamsyn2crm/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		chProcess.setMyProfilePath("/ImprrlparamsynProcess.properties");
		// ��ʼ��
		chProcess.init(args);
		/* ------------------------------------------------------------------------------- */

		// ��ʼ����
		try {
			log.info("=========PBOSS_IM_004��Դ������ͬ���ӿ�=====��ʼ����ɣ���ʼ����==========");
			chProcess.process(user);
			log.info("=========PBOSS_IM_004��Դ������ͬ���ӿ�=====������ɣ������˳�============");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("=========PBOSS_IM_004��Դ������ͬ���ӿ�=====�쳣�˳�====================");
		}
	}
	
	@Override
	protected void init(String[] args) throws Exception {
		//super.init(args);
		String cityid = args[0];		
		initProperties();
		// ��ʼ��log
		String logFilename = properties.getProperty(cityid + "_log");
		BasicConfigurator.configure();
		if (logFilename != null) {
			Logger logger = Logger.getRootLogger();
			DailyRollingFileAppender appender = (DailyRollingFileAppender) logger.getAppender("FILE");
			Date today = new Date();
			// ��־�ļ���������classpathͬ����Ŀ¼��; by zhangsiwei
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

		// ��ʼ��hibernate�����Ϣ
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

		registerTypeConvert();//ע������ת����
		
		String batchSize = properties.getProperty("batch_size");
		if(batchSize!=null){
			try{
				this.batch_size = Integer.parseInt(batchSize);
			}catch(Exception ex){
				log.info("�����ļ���batch_size�����֣�ʹ��Ĭ��ֵ"+this.batch_size);
			}
		}
	}
	

	/**
	 * ʹ��spring�������������(�Ƽ�һ�������ʹ��)
	 */
	protected void process(User user)  throws Exception{
		String secondsleep = properties.getProperty("secondsleep");
		if(secondsleep == null || "".equals(secondsleep)){
			log.info("=========PBOSS_IM_004��Դ������ͬ���ӿ�=====secondsleep δ�趨���˳�====================");
			return ;
		}
		Long secondsleepLong = 0L;
		try {
			secondsleepLong = Long.parseLong(secondsleep);
		} catch (Exception e) {
			log.info("=========PBOSS_IM_004��Դ������ͬ���ӿ�=====secondsleep �����֣��˳�====================");
			return ;
		}
		Rlparamsyn bo = (Rlparamsyn) BOFactory.build(RlparamsynBO.class, user);
		//boolean noException = true;
		while(true){
			log.info("=========PBOSS_IM_004��Դ������ͬ���ӿ�=====���ο�ʼ����==========");
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
				log.info("=========PBOSS_IM_004��Դ������ͬ���ӿ�=====�쳣�˳�(����)====================\n"+e.getMessage());
				//noException = false;
				e.printStackTrace();
			}
			log.info("=========PBOSS_IM_004��Դ������ͬ���ӿ�=====���δ������==========");
			
			log.info(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd HH:mm:ss") + 
					"=========PBOSS_IM_004��Դ������ͬ���ӿ�" +
					"========��������=================" + secondsleepLong);
			
			Thread.sleep(secondsleepLong*1000);
		}
	}
}
