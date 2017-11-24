package com.gmcc.pboss.BgProcess.chpwempsyn2crm;

import java.util.Date;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.business.chpwempsyn2crm.empsyn.Empsyn;
import com.gmcc.pboss.business.chpwempsyn2crm.empsyn.EmpsynBO;
import com.gmcc.pboss.business.chpwempsyn2crm.empsyn.EmpsynDBParam;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * @author hbm
 * 
 * PBOSS_IM_005��Ա���ϸ���
 * 
 * ҵ���ʶempsyn
 * 
 */
public class  ChpwempsynProcess extends BgBase {
	
	private int batch_size = 100;//ÿ���δ�����ϸ��¼����

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ChpwempsynProcess chProcess = new ChpwempsynProcess();

		/* --����4������ͨ�õķ���������ī�سɹ棬�������������Ļ�����д���漸������--------- 
		 * 
		 * ���������ӵ��ǹ�����,���� DB_COMMON �Ϳ�����
		 * 
		 * 
		 * */
		// ������
		boolean isPass = chProcess.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser,����cityid
		User user = chProcess.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		chProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/chpwempsyn2crm/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		chProcess.setMyProfilePath("/ChpwempsynProcess.properties");
		// ��ʼ��
		chProcess.init(args);
		/* ------------------------------------------------------------------------------- */

		// ��ʼ����
		try {
			log.info("=========PBOSS_IM_005��Ա���ϸ���=====��ʼ����ɣ���ʼ����==========");
			chProcess.process(user);
			log.info("=========PBOSS_IM_005��Ա���ϸ���=====������ɣ������˳�============");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("=========PBOSS_IM_005��Ա���ϸ���=====�쳣�˳�====================");
		}
	}
	
	protected void init(String[] args) throws Exception {
		super.init(args);
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
	protected void process(User user) throws Exception {
		String secondsleep = properties.getProperty("secondsleep");
		if(secondsleep == null || "".equals(secondsleep)){
			log.info("=========PBOSS_IM_005��Ա���ϸ���=====secondsleep δ�趨���˳�====================");
			return ;
		}
		Long secondsleepLong = 0L;
		try {
			secondsleepLong = Long.parseLong(secondsleep);
		} catch (Exception e) {
			log.info("=========PBOSS_IM_005��Ա���ϸ���=====secondsleep �����֣��˳�====================");
			return ;
		}
		Empsyn bo = (Empsyn) BOFactory.build(EmpsynBO.class, user);
		//boolean noException = true;
		while(true){
			log.info("=========PBOSS_IM_005��Ա���ϸ���=====���ο�ʼ����==========");
			try {
				EmpsynDBParam param=new EmpsynDBParam();
				param.set_ne_opract("0");
				param.setCountOnly(true);
				DataPackage dp = bo.doQuery(param);
				if(dp.getRowCount()>0){
					int rowcount = dp.getRowCount();
					while(rowcount>0){
						bo.doProcess(user.getCityid(),this.batch_size);//ÿ�δ���һ��������������ݶѻ�ʱ������������һ��������ͬ�������Ч���½���ʱ
						rowcount -= this.batch_size;
					}
				}				
			} catch (Exception e) {
				log.info("=========PBOSS_IM_005��Ա���ϸ���=====�쳣�˳�(����)====================\n"+e.getMessage());
				//noException = false;
				e.printStackTrace();
			}
			log.info("=========PBOSS_IM_005��Ա���ϸ���=====���δ������==========");
			
			log.info(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd HH:mm:ss") + 
					"=========PBOSS_IM_005��Ա���ϸ���" +
					"========��������=================" + secondsleepLong);
			Thread.sleep(secondsleepLong*1000);
		}
	}


}
