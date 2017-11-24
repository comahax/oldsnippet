package com.sunrise.jop.ui.quartz;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sunrise.jop.ui.interceptor.MonitorInterceptor;

/**
 * 执行监控日志记录
 * @author ljx
 *
 */
public class MonitorLogJob implements Job{
	public static final Logger log = LoggerFactory.getLogger(MonitorLogJob.class);
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
		String nowDate=format.format(new Date());
		log.info("-------------监控信息日志记录-"+nowDate+"-------------------begin-----");
		HashMap<String, Integer> countMap = MonitorInterceptor.countMap;
		MonitorInterceptor.countMap = new HashMap<String, Integer>();
		log.info("访问次数:");
		for (String key : countMap.keySet()) {
			Integer value = countMap.get(key);
			log.info(key+"                    "+value);
		}
		HashMap<String, Long> timeMap = MonitorInterceptor.timeMap;
		MonitorInterceptor.timeMap = new HashMap<String, Long>();
		log.info("请求消耗最大时间（单位：毫秒）:");
		for (String key : timeMap.keySet()) {
			Long value = timeMap.get(key);
			log.info(key+"                    "+value);
		}
		log.info("-------------监控信息日志记录-"+nowDate+"--------------------end----");
	}
}

