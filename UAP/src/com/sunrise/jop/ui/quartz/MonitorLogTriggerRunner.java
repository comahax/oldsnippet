package com.sunrise.jop.ui.quartz;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
/**
 * 添加监控记录日志调度任务
 * @author ljx
 *
 */
public class MonitorLogTriggerRunner {
	 public void task() throws SchedulerException{
	        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
	        Scheduler scheduler = schedulerFactory.getScheduler();
	        JobDetail jobDetail = new JobDetail("monitorLogJobDetail", "monitorLogJobDetailGroup", MonitorLogJob.class);
	        CronTrigger cronTrigger = new CronTrigger("monitorLogJobTrigger", "monitorLogJobTtriggerGroup");
	        try {
	        	//逢整点执行
	            CronExpression cexp = new CronExpression("0 0 * * * ?");
	            cronTrigger.setCronExpression(cexp);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        scheduler.scheduleJob(jobDetail, cronTrigger);
	        scheduler.start();
	    }
}
