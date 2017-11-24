package com.sunrise.boss.common.utils.init;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.ByteConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.common.utils.CacheUtil;
import com.sunrise.boss.common.utils.init.converter.SqlDateConverter;
import com.sunrise.boss.common.utils.init.converter.SqlTimestampConverter;
import com.sunrise.boss.common.utils.init.converter.UtilDateConverter;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;

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

		String log4jFile = "/log4j.properties";
		java.net.URL cfgPath = this.getClass().getResource("/");
		System.out.println("root = " + cfgPath);
		if (cfgPath.toString().indexOf("WEB-INF") >= 0) {
			PropertyConfigurator.configure(this.getClass().getResource(log4jFile));
		} else {
			PropertyConfigurator.configure(log4jFile);
		}

		if (log.isInfoEnabled()) {
			log.info("Entering InitServlet.init()");
		}
		// init hibernate
		try {
			SessionUtil sessionUtil = new SessionUtil();
		} catch (Exception e) {
			log.fatal("Error in configuring SessionFactory", e);
		}

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

		if (SysInfo.USE_CACHE_FLAG) {
			CacheUtil cUtil = new CacheUtil();
			cUtil.refreshDictCache();
		}

		log.info("Exiting InitServlet.init()");
	}

	public void destroy() {
		if (log.isInfoEnabled()) {
			log.info("Calling InitServlet.destroy()");
		}
	}

}
