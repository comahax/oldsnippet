package com.sunrise.boss.common.utils.init;

import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import com.sunrise.boss.common.utils.sysinfo.SysInfo;

/**
 * ��������һ�ε�web.xml<br/>
 * &lt;servlet&gt;<br/>
 *	    &lt;servlet-name&gt;ScheduleJobServlet&lt;/servlet-name&gt;<br/>
 *	    &lt;servlet-class&gt;com.sunrise.boss.common.utils.init.ScheduleJobServlet&lt;/servlet-class&gt; <br/>
 *	    &lt;load-on-startup&gt;1&lt;/load-on-startup&gt; <br/>
 *	</servlet&gt;<br/>
 * @author Ge Aiping
 *
 */
public class ScheduleJobServlet extends HttpServlet {

	private static Log log = LogFactory.getLog(ScheduleJobServlet.class);
	public void init(ServletConfig cfg) throws javax.servlet.ServletException {
		schedulerJob(cfg);
		return;
	}

	public void destroy() {
		Scheduler sched = (Scheduler) (getServletConfig().getServletContext()
				.getAttribute(SysInfo.CACHE_JOB_NAME));
		try {
			log.info(" Scheduler shutdown...");
			sched.shutdown(true);
		} catch (Exception e) {
			log.error(e);
		}

		super.destroy();
	}

	protected void schedulerJob(ServletConfig cfg) {
		log.info("Quartz Init Servlet loaded, initializing Scheduler...");
		try {
			log.info("������ҵ���ȳ���:��ʼ");
			System.out.println("������ҵ���ȳ���:��ʼ");
			//���ع�����sa_db_dictitem
			
			log.info("���ع�����sa_db_dictitem��Ehcache����************************************������ҵ���ó��򣺿�ʼ");
			System.out.println("���ع�����sa_db_dictitem��Ehcache����************************************������ҵ���ó��򣺿�ʼ");
			SchedulerFactory sf = new StdSchedulerFactory();
			Scheduler sched = sf.getScheduler();
			cfg.getServletContext().setAttribute(SysInfo.CACHE_JOB_NAME, sched);
			log.info("Scheduler initialized.");
			JobDetail job = new JobDetail("halfHourJob", "cachegroup",
					CacheRefreshJob.class);
			
			CronTrigger cronTrigger = new CronTrigger("halfHourJob", "cachegroup");
			CronExpression cExpress = new CronExpression("0 0/30 * * * ?"); //30��ˢһ��
			cronTrigger.setCronExpression(cExpress);
			sched.scheduleJob(job,cronTrigger);

			sched.start();
			log.info("���ع�����sa_db_dictitem��Ehcache����************************************������ҵ���ó������");
			System.out.println("���ع�����sa_db_dictitem��Ehcache����************************************������ҵ���ó������");
			
			log.info("���ع̶�����CH_REWARDTYPE************************************������ҵ���ó��򣺿�ʼ");
			System.out.println("���ع̶�����CH_REWARDTYPE************************************������ҵ���ó��򣺿�ʼ");
			//���ع̶�����CH_REWARDTYPE��������п�ch_adt_dictitem��ֵ�򸲸�sa_db_dictitem��Ӧֵ���������sa_db_dictitemֵ
			Scheduler schedRewardtype = sf.getScheduler();
			JobDetail loadRewardtypeJob = new JobDetail("CH_REWARDTYPE",schedRewardtype.DEFAULT_GROUP,ChrewardtypeCacheJob.class);
			SimpleTrigger trigger = new SimpleTrigger("CH_REWARDTYPE_Trigger",
					null,//group
                    new Date(),//��ʼʱ��
                    null,//��ֹʱ�䣬null��ʾ����ֹͣ
                    SimpleTrigger.REPEAT_INDEFINITELY,//repeatCount
                    7200L * 1000L);//���ʱ��
			schedRewardtype.scheduleJob(loadRewardtypeJob, trigger);
			schedRewardtype.start();
			log.info("���ع̶�����CH_REWARDTYPE************************************������ҵ���ó������");
			System.out.println("���ع̶�����CH_REWARDTYPE************************************������ҵ���ó������");
			
			log.info("������ҵ���ȳ������");
			System.out.println("������ҵ���ȳ������");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Quartz Init Servlet failed");
		}
	}
}