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
		//ͨ��SchedulerFactory��ȡһ��������ʵ��
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDetail jobDetail = new JobDetail("comidTreeJobDetail", "comidTreeJobDetail_Group", ComidTreeJob.class);
        SimpleTrigger simpleTrigger = new SimpleTrigger("comidTreeJobTrigger","comidTreeJobTriggerGroup");
        //ͨ��SimpleTrigger ������ȹ�����������
        simpleTrigger.setStartTime(new Date());
        //�趨���ʱ��  
        simpleTrigger.setRepeatInterval(1000 * 60 * 30); //�����ͷˢ��һ��
        //����ѭ��
        simpleTrigger.setRepeatCount(simpleTrigger.REPEAT_INDEFINITELY);
        scheduler.scheduleJob(jobDetail, simpleTrigger);  
        scheduler.start();
    }
	
}
