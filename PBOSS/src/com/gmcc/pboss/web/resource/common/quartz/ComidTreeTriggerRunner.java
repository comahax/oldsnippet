package com.gmcc.pboss.web.resource.common.quartz;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class ComidTreeTriggerRunner {
	
	public void task() throws SchedulerException{
		//通过SchedulerFactory获取一个调度器实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDetail jobDetail = new JobDetail("comidTreeJobDetail", "comidTreeJobDetail_Group", ComidTreeJob.class);
        SimpleTrigger simpleTrigger = new SimpleTrigger("comidTreeJobTrigger","comidTreeJobTriggerGroup");
        //通过SimpleTrigger 定义调度规则，马上启动
        simpleTrigger.setStartTime(new Date());
        //设定间隔时间  
        simpleTrigger.setRepeatInterval(1000 * 60 * 30); //半个钟头刷新一次
        //无限循环
        simpleTrigger.setRepeatCount(simpleTrigger.REPEAT_INDEFINITELY);
        scheduler.scheduleJob(jobDetail, simpleTrigger);  
        scheduler.start();
    }
	
}
