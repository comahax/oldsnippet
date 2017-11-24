package com.gmcc.pboss.BgProcess.sales.hisactivetol;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.hisactivetol.Hisactivetol;
import com.gmcc.pboss.control.sales.hisactivetol.HisactivetolBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.User;

/**
 * ��������ʷ��������ͳ�ơ���̨�߼�
 * @author ctu
 *
 */
public class HisactivetolProcess extends BgBase {
	private static Logger log = Logger.getLogger(HisactivetolProcess.class);
	
	public static void main(String[] args){
		HisactivetolProcess hp = new HisactivetolProcess();
		
		/* --����4������ͨ�õķ���������ī�سɹ棬�������������Ļ�����д���漸������--------- */
		// ������
		boolean isPass = hp.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = hp.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		hp.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/hisactivetol/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		hp.setMyProfilePath("/HisactivetolProcess.properties");
		// ��ʼ��
		try {
			hp.init(args);
			
			/* ------------------------------------------------------------------------------- */
			log.info("=========��ʷ��������ͳ��=====��ʼ����ɣ���ʼ����==========");
			// ��ʼ����
			
			hp.process(user);
			
			log.info("======��ʷ��������ͳ��========������ɣ������˳�===========");
			
		} catch (Exception e) {
			log.error(e);
			log.error("=====��ʷ��������ͳ��=========�쳣�˳�===============");
		}
	}
	
	private void process(DBAccessUser user) throws Exception{
		Hisactivetol hisactivetolBO = (HisactivetolBO) BOFactory.build(HisactivetolBO.class, user);
		hisactivetolBO.doProcess(user);
	}
	
	
}
