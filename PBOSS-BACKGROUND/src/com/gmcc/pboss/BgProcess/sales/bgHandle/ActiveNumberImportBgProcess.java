package com.gmcc.pboss.BgProcess.sales.bgHandle;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.ActiveNumberImport.ActiveNumberImport;
import com.gmcc.pboss.control.sales.bgcontrol.ActiveNumberImport.ActiveNumberImportBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * <pre>
 * [������뵼��]��̨����
 * ���������� ��ָ����ʽ�ļ��������ļ����Ʒ��·���BAMϵͳ���˴������뵽���뼤���¼��
 * </pre>
 * @author zhangsiwei
 *
 */
public class ActiveNumberImportBgProcess extends BgBase {

	/**��������ļ����·��*/
	private String srcpath;
	/**���߼����(����)*/
	private static String intervalMin;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		ActiveNumberImportBgProcess pro = new ActiveNumberImportBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = pro.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		pro.setMyProfilePath("/sales/bgHandle/activeimport.properties");
		// ��ʼ��
		pro.init(args);
//		pro.runTask(user,intervalMin);
		pro.activePhoneNoImport(user);
	}
	
	
	@Override
	protected void init(String[] args) throws Exception {
		super.init(args);
		srcpath = properties.getProperty("srcpath");
		intervalMin = properties.getProperty(args[0]+"_intervalMin");
	}
	
	public void runTask(final User user,final String intervalMin) throws Exception {
		TimerTask task = new TimerTask() {
			@Override
			public void run(){
				try {
					activePhoneNoImport(user);
					log.info("����  "+intervalMin+"����");
				} catch (Exception e) {
					LoggerUtils.error(e, log);
				}
			}
			
		};
		try {
			String cityid = user.getCityid();
			// ���߼����(����)
			if(intervalMin == null) {
				throw new RuntimeException("�����ļ��в��������ԣ�"+cityid+"_intervalMin, ���ʵ��");
			}
			if("".equals(intervalMin)) {
				throw new RuntimeException("�����ļ�������Ϊ"+cityid+"_intervalMin�����Ե�ֵΪ��, ���ʵ��");
			}
			float intervalMinFloat = Float.parseFloat(intervalMin);
			Timer timer = new Timer();
			timer.schedule(task, new Date(), (long)(intervalMinFloat*60*1000));
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}

	public void activePhoneNoImport(User user) throws Exception {
		ActiveNumberImport aniBo = (ActiveNumberImportBO)BOFactory.build(ActiveNumberImportBO.class, user);
		try {
			aniBo.doProcess(user.getCityid(),srcpath);
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}

	
}
