package com.gmcc.pboss.BgProcess.communication;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.communication.Communication;
import com.gmcc.pboss.control.communication.CommunicationBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * �����Զ�����
 * @author wefrogll
 * @version 1.0 2009-11-14
 */
public class CommunicationBgProcess extends BgBase {
	public static void main(String[] args){
		CommunicationBgProcess bgProcess = new CommunicationBgProcess();

		/* --����4������ͨ�õķ���������ī�سɹ棬�������������Ļ�����д���漸������--------- */
		// ������
		boolean isPass = bgProcess.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = bgProcess.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		bgProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/communication/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		bgProcess.setMyProfilePath("/CommunicationBgProcess.properties");
		// ��ʼ��
		try {
			bgProcess.init(args);
			/* ------------------------------------------------------------------------------- */

			// ��ʼ����
			while(true){
				String propName = args[0]+ "_intervalMin";
				int intervalMin = bgProcess.properties.getProperty(propName) == null ? 10:Integer.parseInt(bgProcess.properties.getProperty(propName));
				
				Communication communication = (Communication)BOFactory.build(CommunicationBO.class, user);
				communication.doProcess();
				System.out.println("==============���� "+intervalMin+" ����=====================");
				Thread.sleep(intervalMin*60000);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtils.error(e, log);
		}
	}
}
