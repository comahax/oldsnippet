package com.gmcc.pboss.BgProcess.promotion;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.promotion.bgcontrol.PromotionsBgManagement.PromotionsBgManagement;
import com.gmcc.pboss.control.promotion.bgcontrol.PromotionsBgManagement.PromotionsBgManagementBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;
/**
 * ��̨������򣨳�פ���̣�
 * @author zhangsiwei
 *
 */
public class PromotionsBgManagementProcess extends BgBase{
	public static void main(String[] args) throws Exception{
		
		PromotionsBgManagementProcess pro = new PromotionsBgManagementProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = pro.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/promotion/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		pro.setMyProfilePath("/promotionBgProcess.properties");
		// ��ʼ��
		pro.init(args);
		pro.bgManagementTask(user);
	}
	
	private void bgManagementTask(final User user) {
		TimerTask task = new TimerTask() {
			@Override
			public void run(){
				try {
					runTask(user);
				}catch(Exception ex) {
					LoggerUtils.error(ex, log);
				}
			}
			
		};
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 2);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date execTime = cal.getTime();
		Timer timer = new Timer();
		timer.schedule(task, execTime, 3600*24*1000);
	}
	
	private void runTask(User user) throws Exception{
		
		PromotionsBgManagement pbmBO = 
			(PromotionsBgManagementBO)BOFactory.build(PromotionsBgManagementBO.class, user);
		pbmBO.doProcess();
	}
}
