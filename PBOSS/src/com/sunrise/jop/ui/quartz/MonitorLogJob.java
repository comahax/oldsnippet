package com.sunrise.jop.ui.quartz;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.sunrise.jop.ui.interceptor.MonitorInterceptor;

/**
 * ִ�м����־��¼
 * @author ljx
 *
 */
public class MonitorLogJob implements Job{
	public static final Logger log = Logger.getLogger(MonitorLogJob.class);
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
		String nowDate=format.format(new Date());
		log.info("-------------�����Ϣ��־��¼-"+nowDate+"-------------------begin-----");
		HashMap<String, Integer> countMap = MonitorInterceptor.countMap;
		MonitorInterceptor.countMap = new HashMap<String, Integer>();
		log.info("���ʴ���:");
		for (String key : countMap.keySet()) {
			Integer value = countMap.get(key);
			log.info(key+"                    "+value);
		}
		HashMap<String, Long> timeMap = MonitorInterceptor.timeMap;
		MonitorInterceptor.timeMap = new HashMap<String, Long>();
		log.info("�����������ʱ�䣨��λ�����룩:");
		for (String key : timeMap.keySet()) {
			Long value = timeMap.get(key);
			log.info(key+"                    "+value);
		}
		log.info("-------------�����Ϣ��־��¼-"+nowDate+"--------------------end----");
	}
}

