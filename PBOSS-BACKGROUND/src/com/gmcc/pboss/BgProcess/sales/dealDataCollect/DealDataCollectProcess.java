package com.gmcc.pboss.BgProcess.sales.dealDataCollect;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.dealDataCollect.DealDataCollect;
import com.gmcc.pboss.control.sales.bgcontrol.dealDataCollect.DealDataCollectBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.User;

/**
 * �������������ݲɼ���̨���򡿺�̨�߼�
 * @author dengxingxin
 *
 */
public class DealDataCollectProcess extends BgBase {
	private static Logger log = Logger.getLogger(DealDataCollectProcess.class);
	
	public static void main(String[] args){
		DealDataCollectProcess ddcProcess = new DealDataCollectProcess();
		
		/* --����4������ͨ�õķ���������ī�سɹ棬�������������Ļ�����д���漸������--------- */
		// ������
		boolean isPass = ddcProcess.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = ddcProcess.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		ddcProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/dealDataCollect/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		ddcProcess.setMyProfilePath("/DealDataCollectProcess.properties");
		// ��ʼ��
		try {
			ddcProcess.init(args);
			
			/* ------------------------------------------------------------------------------- */
			log.info("=========�������ݲɼ���̨����=====��ʼ����ɣ���ʼ����==========");
			// ��ʼ����
			String date = "";
			if(args.length == 2){
				date = args[1];
			}
			
			ddcProcess.process(user,date);
			
			log.info("======�������ݲɼ���̨����========������ɣ������˳�===========");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			log.error("=====�������ݲɼ���̨����=========�쳣�˳�===============");
		}
	}
	
	private void process(DBAccessUser user,String date) throws Exception{
		DealDataCollect dealDataCollectBO = (DealDataCollectBO) BOFactory.build(DealDataCollectBO.class, user);
		dealDataCollectBO.doProcess(date);
	}
	
	
}
