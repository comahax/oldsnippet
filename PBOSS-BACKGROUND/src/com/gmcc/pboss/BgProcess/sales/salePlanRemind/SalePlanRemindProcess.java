package com.gmcc.pboss.BgProcess.sales.salePlanRemind;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.salePlanRemind.SalePlanRemind;
import com.gmcc.pboss.control.sales.bgcontrol.salePlanRemind.SalePlanRemindBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.User;

/**
 * ���������۽������ѡ���̨�߼�
 * @author dengxingxin
 * 
 * ��������·�� ���б�ʶ���Ƿ��Ͷ���(Y��N)
 *
 */
public class SalePlanRemindProcess extends BgBase {
	private static Logger log = Logger.getLogger(SalePlanRemindProcess.class);
	
	public static void main(String[] args){
		SalePlanRemindProcess sprProcess = new SalePlanRemindProcess();
		
		/* --����4������ͨ�õķ���������ī�سɹ棬�������������Ļ�����д���漸������--------- */
		// ������
		boolean isPass = sprProcess.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = sprProcess.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		sprProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/salePlanRemind/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		sprProcess.setMyProfilePath("/SalePlanRemindProcess.properties");
		// ��ʼ��
		try {
			sprProcess.init(args);
			
			if(args.length != 2){
				log.info("=========�����۽������ѡ�=====�������ԣ��˳�==========");
				return;
			}
			
			String sendMsgFlag = args[1];
			
			/* ------------------------------------------------------------------------------- */
			log.info("=========�����۽������ѡ�=====��ʼ����ɣ���ʼ����==========");
			// ��ʼ����
			
			sprProcess.process(user,sendMsgFlag);
			
			log.info("======�����۽������ѡ�========������ɣ������˳�===========");
			
		} catch (Exception e) {e.printStackTrace();
			log.error(e);
			log.error("=====�����۽������ѡ�=========�쳣�˳�===============\n"+e.getMessage());
		}
	}
	
	private void process(DBAccessUser user,String sendMsgFlag) throws Exception{
		String sendDate = properties.getProperty("sendDate");
		SalePlanRemind salePlanRemindBO = (SalePlanRemindBO) BOFactory.build(SalePlanRemindBO.class, user);
		salePlanRemindBO.doProcess(sendMsgFlag,sendDate); 
	}

}
