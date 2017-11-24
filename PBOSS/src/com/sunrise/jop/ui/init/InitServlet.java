package com.sunrise.jop.ui.init;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import ognl.OgnlRuntime;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.ByteConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.SchedulerException;

import com.gmcc.pboss.web.resource.common.quartz.ComidTreeTriggerRunner;
import com.sunrise.jop.common.spring.SpringContextManager;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.ui.init.convert.SqlDateConverter;
import com.sunrise.jop.ui.init.convert.SqlTimestampConverter;
import com.sunrise.jop.ui.init.convert.UtilDateConverter;
import com.sunrise.jop.ui.quartz.MonitorLogTriggerRunner;


/**
 * <p>
 * Title: GDIBOSS
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author sunil
 * @version 1.0
 * @version 1.1 HuangBaiming
 */
public class InitServlet extends HttpServlet {

	private static final Log log = LogFactory.getLog(InitServlet.class);

	public void init() throws ServletException {
		if (log.isInfoEnabled()) { 
			log.info("Entering InitServlet.init().");
		}
		SpringContextManager.init();
		// init commons BeanUtils
		ConvertUtils.register(new SqlTimestampConverter(null), java.sql.Timestamp.class);
		ConvertUtils.register(new UtilDateConverter(null), java.util.Date.class);
		ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);

		// hekun: don't convert null number to 0.
		ConvertUtils.register(new ByteConverter(null), Byte.class);
		ConvertUtils.register(new ShortConverter(null), Short.class);
		ConvertUtils.register(new IntegerConverter(null), Integer.class);
		ConvertUtils.register(new LongConverter(null), Long.class);
		ConvertUtils.register(new FloatConverter(null), Float.class);
		ConvertUtils.register(new DoubleConverter(null), Double.class);

		OgnlRuntime.setSecurityManager(null);
		try {
			//系统监控记录日志调度任务
			MonitorLogTriggerRunner monTrigRun = new MonitorLogTriggerRunner();
			monTrigRun.task();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		if(CoreConfigInfo.USE_CACHE_FLAG){
			try {
				//ComidTree缓存更新调度任务
				ComidTreeTriggerRunner comidtr = new ComidTreeTriggerRunner();
				comidtr.task();
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
		
		log.info("Exiting InitServlet.init()");
	}

	public void destroy() {
		if (log.isInfoEnabled()) {
			log.info("Calling InitServlet.destroy()");
		}
	}

}
