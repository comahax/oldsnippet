package com.sunrise.boss.common.utils.init;

import java.text.DateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.sunrise.boss.common.utils.CacheUtil;

public class CacheRefreshJob implements Job {

	private static Log log = LogFactory.getLog(CacheRefreshJob.class);

	private int i = 0;

	/**
	 * Empty constructor for job initilization
	 */
	public CacheRefreshJob() {
	}

	
	/**
	 * @throws JobExecutionException
	 *             if there is an exception while executing the job.
	 */
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		try {
			
			CacheUtil cUtil = new CacheUtil();
//			cUtil.clearData();
			cUtil.refreshDictCache();
			cUtil.refershPurviewData();
			cUtil.refreshComidtree();
			String jobName = context.getJobDetail().getFullName();
			log.info("[" + i + "]:CacheRefreshJob says: " + jobName
					+ " executing at: " + format());
		} catch (Exception ne) {
			log.error(ne);
		}
	}

	private String format(Date d) {
		DateFormat df = DateFormat.getDateTimeInstance();
		return df.format(d);
	}

	private String format() {
		return format(new Date());
	}
}