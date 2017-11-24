package com.sunrise.jop.ui.init;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.xml.parsers.FactoryConfigurationError;

import ognl.OgnlRuntime;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.ByteConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.sunrise.boss.common.webservice.ServiceLaunch;
import com.sunrise.jop.common.spring.SpringContextManager;
import com.sunrise.jop.ui.init.convert.SqlDateConverter;
import com.sunrise.jop.ui.init.convert.SqlTimestampConverter;
import com.sunrise.jop.ui.init.convert.UtilDateConverter;


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

	private static final Logger log = LoggerFactory.getLogger(InitServlet.class);

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
		
		//发布WEBSERVICE服务
//    	ServiceLaunch sutb = new ServiceLaunch();
		log.info("Exiting InitServlet.init()");
	}

	public void destroy() {
		if (log.isInfoEnabled()) {
			log.info("Calling InitServlet.destroy()");
		}
	}

}
