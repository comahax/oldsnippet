package com.gmcc.pboss.BgProcess.sales.bgHandle;



import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.BookResRelease.BookResRelease;
import com.gmcc.pboss.control.sales.bgcontrol.BookResRelease.BookResReleaseBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * [Ԥ����Դ�ͷ�]��̨����
 * ���������� ����Ԥ������ָ��ʱ����׿���Դ�����ͷ�
 * @author zhangsiwei
 *
 */
public class BookResReleaseBgProcess extends BgBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		BookResReleaseBgProcess pro = new BookResReleaseBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = pro.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		pro.setMyProfilePath("/sales/bgHandle/bookResRelease.properties");
		// ��ʼ��
		pro.init(args);
		pro.runTask(user);
	}
	
	public void runTask(final User user) throws Exception {
		TimerTask task = new TimerTask() {
			@Override
			public void run(){
				try {
					smpResRelease(user);
				} catch (Exception e) {
					LoggerUtils.error(e, log);
				}
			}
			
		};
		try {
			String cityid = user.getCityid();
			// ���߼����(����)
			String intervalMin = properties.getProperty(cityid+"_intervalMin");
			if(intervalMin == null) {
				throw new RuntimeException("�����ļ��в��������ԣ�"+cityid+"_intervalMin, ���ʵ��");
			}
			if("".equals(intervalMin)) {
				throw new RuntimeException("�����ļ�������Ϊ"+cityid+"_intervalMin�����Ե�ֵΪ��, ���ʵ��");
			}
			float intervalMinLong = Float.parseFloat(intervalMin);
			Timer timer = new Timer();
			timer.schedule(task, new Date(), (long)(intervalMinLong*60*1000));
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
	
	public void smpResRelease(User user) throws Exception {
		BookResRelease brrBo = (BookResReleaseBO)BOFactory.build(BookResReleaseBO.class, user);
		try {
			brrBo.doProcess();
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
	
}
