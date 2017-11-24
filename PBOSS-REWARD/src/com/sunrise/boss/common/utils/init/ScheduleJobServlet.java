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
 * 增加下面一段到web.xml<br/>
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
			log.info("启动作业调度程序:开始");
			System.out.println("启动作业调度程序:开始");
			//加载公共库sa_db_dictitem
			
			log.info("加载公共库sa_db_dictitem到Ehcache缓存************************************启动作业调用程序：开始");
			System.out.println("加载公共库sa_db_dictitem到Ehcache缓存************************************启动作业调用程序：开始");
			SchedulerFactory sf = new StdSchedulerFactory();
			Scheduler sched = sf.getScheduler();
			cfg.getServletContext().setAttribute(SysInfo.CACHE_JOB_NAME, sched);
			log.info("Scheduler initialized.");
			JobDetail job = new JobDetail("halfHourJob", "cachegroup",
					CacheRefreshJob.class);
			
			CronTrigger cronTrigger = new CronTrigger("halfHourJob", "cachegroup");
			CronExpression cExpress = new CronExpression("0 0/30 * * * ?"); //30分刷一次
			cronTrigger.setCronExpression(cExpress);
			sched.scheduleJob(job,cronTrigger);

			sched.start();
			log.info("加载公共库sa_db_dictitem到Ehcache缓存************************************启动作业调用程序：完成");
			System.out.println("加载公共库sa_db_dictitem到Ehcache缓存************************************启动作业调用程序：完成");
			
			log.info("加载固定参数CH_REWARDTYPE************************************启动作业调用程序：开始");
			System.out.println("加载固定参数CH_REWARDTYPE************************************启动作业调用程序：开始");
			//加载固定参数CH_REWARDTYPE，如果地市库ch_adt_dictitem有值则覆盖sa_db_dictitem对应值，否则加载sa_db_dictitem值
			Scheduler schedRewardtype = sf.getScheduler();
			JobDetail loadRewardtypeJob = new JobDetail("CH_REWARDTYPE",schedRewardtype.DEFAULT_GROUP,ChrewardtypeCacheJob.class);
			SimpleTrigger trigger = new SimpleTrigger("CH_REWARDTYPE_Trigger",
					null,//group
                    new Date(),//起始时间
                    null,//截止时间，null表示永不停止
                    SimpleTrigger.REPEAT_INDEFINITELY,//repeatCount
                    7200L * 1000L);//间隔时间
			schedRewardtype.scheduleJob(loadRewardtypeJob, trigger);
			schedRewardtype.start();
			log.info("加载固定参数CH_REWARDTYPE************************************启动作业调用程序：完成");
			System.out.println("加载固定参数CH_REWARDTYPE************************************启动作业调用程序：完成");
			
			log.info("启动作业调度程序：完成");
			System.out.println("启动作业调度程序：完成");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Quartz Init Servlet failed");
		}
	}
}