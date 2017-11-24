package com.gmcc.pboss.BgProcess.sales.salesstdWarn;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.salesstdWarn.SalesstdWarn;
import com.gmcc.pboss.control.sales.bgcontrol.salesstdWarn.SalesstdWarnBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.User;

/**
 * �������������������ѡ���̨�߼�
 * @author dengxingxin
 *
 */
public class SalesstdWarnProcess extends BgBase {
	private static Logger log = Logger.getLogger(SalesstdWarnProcess.class);
	
	public static void main(String[] args){
		SalesstdWarnProcess swProcess = new SalesstdWarnProcess();
		
		/* --����4������ͨ�õķ���������ī�سɹ棬�������������Ļ�����д���漸������--------- */
		// ������
		boolean isPass = swProcess.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = swProcess.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		swProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/salesstdWarn/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		swProcess.setMyProfilePath("/SalesstdWarnProcess.properties");
		// ��ʼ��
		try {
			swProcess.init(args);
			
			/* ------------------------------------------------------------------------------- */
			log.info("=========��������������=====��ʼ����ɣ���ʼ����==========");
			// ��ʼ����
			
			swProcess.process(user);
			
			log.info("======��������������========������ɣ������˳�===========");
			
		} catch (Exception e) {
			log.error(e);
			log.error("=====��������������=========�쳣�˳�===============");
		}
	}
	
	private void process(DBAccessUser user) throws Exception{
		SalesstdWarn salesstdWarnBO = (SalesstdWarnBO) BOFactory.build(SalesstdWarnBO.class, user);
		salesstdWarnBO.doProcess(); 
	}

}
