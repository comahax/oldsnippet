package com.gmcc.pboss.BgProcess.chpwwaysyn22crm;

import java.util.Date;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.business.chpwwaysyn22crm.waysyn2.Waysyn2;
import com.gmcc.pboss.business.chpwwaysyn22crm.waysyn2.Waysyn2BO;
import com.gmcc.pboss.business.chpwwaysyn22crm.waysyn2.Waysyn2DBParam;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * @author hbm
 * 
 * PBOSS_IM_006PBOSS�������ϸ��£�ȫ���ֶ�ͬ����
 * 
 * ҵ���ʶwaysyn
 * 
 */
public class  Chpwwaysyn2Process extends BgBase {

	private int batch_size = 100;//ÿ���δ�����ϸ��¼����
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Chpwwaysyn2Process chProcess = new Chpwwaysyn2Process();

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
		chProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/chpwwaysyn22crm/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		chProcess.setMyProfilePath("/Chpwwaysyn2Process.properties");
		// ��ʼ��
		chProcess.init(args);
		/* ------------------------------------------------------------------------------- */

		// ��ʼ����
		try {
			log.info("=========PBOSS_IM_006PBOSS�������ϸ��£�ȫ���ֶ�ͬ����=====��ʼ����ɣ���ʼ����==========");
			chProcess.process(user);
			log.info("=========PBOSS_IM_006PBOSS�������ϸ��£�ȫ���ֶ�ͬ����=====������ɣ������˳�============");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("=========PBOSS_IM_006PBOSS�������ϸ��£�ȫ���ֶ�ͬ����=====�쳣�˳�====================");
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
			log.info("=========PBOSS_IM_006PBOSS�������ϸ��£�ȫ���ֶ�ͬ����=====secondsleep δ�趨���˳�====================");
			return ;
		}
		Long secondsleepLong = 0L;
		try {
			secondsleepLong = Long.parseLong(secondsleep);
		} catch (Exception e) {
			log.info("=========PBOSS_IM_006PBOSS�������ϸ��£�ȫ���ֶ�ͬ����=====secondsleep �����֣��˳�====================");
			return ;
		}
		Waysyn2 bo = (Waysyn2) BOFactory.build(Waysyn2BO.class, user);
		//boolean noException = true;
		while(true){
			log.info("=========PBOSS_IM_006PBOSS�������ϸ��£�ȫ���ֶ�ͬ����=====���ο�ʼ����==========");
			try {
				Waysyn2DBParam param=new Waysyn2DBParam();
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
			} catch (Exception e) {
				log.info("=========PBOSS_IM_006PBOSS�������ϸ��£�ȫ���ֶ�ͬ����=====�쳣�˳�(����)====================\n"+e.getMessage());
				//noException = false;
				e.printStackTrace();
			}
			log.info("=========PBOSS_IM_006PBOSS�������ϸ��£�ȫ���ֶ�ͬ����=====���δ������==========");
			
			log.info(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd HH:mm:ss") + 
					"=========PBOSS_IM_006PBOSS�������ϸ��£�ȫ���ֶ�ͬ����" +
					"========��������=================" + secondsleepLong);
			
			Thread.sleep(secondsleepLong*1000);
		}
	}

}
