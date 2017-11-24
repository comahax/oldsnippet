package com.sunrise.jop.common.utils.logging;

import java.util.Vector;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;

/**
 * <pre>
 * 用于生成 org.apache.log4j.Logger 的抽象类,
 * 具体生成何种类型的Logger由本抽象类的子类决定
 * </pre>
 * @author zsw
 *
 */
public abstract class LoggerCreator {
	
	/**
	 * 生成Logger的模板方法
	 * @param logname	Logger的名称
	 * @param params	构建该Logger所需要的参数
	 * @return
	 */
	public final Logger createLogger(Object logname,Object[] params) {
		
		Vector<Appender> appenders = new Vector<Appender>();
		
		Logger logger;
		logger = getLogger(logname);
		setParameters(params);
		addAppenders(appenders);
		setAppendersForLogger(logger,appenders);
		return logger;
	}
	/**
	 * 为指定Logger添加一个或多个Appender属性
	 * @param logger
	 * @param appenders
	 */
	protected void setAppendersForLogger(Logger logger,Vector<Appender> appenders) {
		for(Appender appender : appenders) {
			logger.addAppender(appender);
		}
	}
	/**
	 * <pre>
	 * 生成简单的Logger,此时Logger还没有Appender等属性,
	 * 生成何种Logger由子类具体决定
	 * </pre>
	 * @param logname
	 * @return
	 */
	abstract Logger getLogger(Object logname);
	/**
	 * 子类可通过此方法设置其自定义参数
	 * @param params
	 */
	abstract void setParameters(Object[] params);
	/**
	 * 子类可通过此方法添加核心属性 (Appender,Layout等等)
	 * @param appenders
	 */
	abstract void addAppenders(Vector<Appender> appenders);

}
