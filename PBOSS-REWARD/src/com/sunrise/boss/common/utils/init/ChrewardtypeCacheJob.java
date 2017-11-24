package com.sunrise.boss.common.utils.init;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.sunrise.boss.common.utils.ChrewardtypeCacheUtil;

public class ChrewardtypeCacheJob implements Job {
	private static Log log = LogFactory.getLog(ChrewardtypeCacheJob.class);
	
	/**
	 * 
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		ChrewardtypeCacheUtil.refresh();
	}

}
