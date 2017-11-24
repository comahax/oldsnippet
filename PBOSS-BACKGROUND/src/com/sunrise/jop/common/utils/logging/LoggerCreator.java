package com.sunrise.jop.common.utils.logging;

import java.util.Vector;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;

/**
 * <pre>
 * �������� org.apache.log4j.Logger �ĳ�����,
 * �������ɺ������͵�Logger�ɱ���������������
 * </pre>
 * @author zsw
 *
 */
public abstract class LoggerCreator {
	
	/**
	 * ����Logger��ģ�巽��
	 * @param logname	Logger������
	 * @param params	������Logger����Ҫ�Ĳ���
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
	 * Ϊָ��Logger���һ������Appender����
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
	 * ���ɼ򵥵�Logger,��ʱLogger��û��Appender������,
	 * ���ɺ���Logger������������
	 * </pre>
	 * @param logname
	 * @return
	 */
	abstract Logger getLogger(Object logname);
	/**
	 * �����ͨ���˷����������Զ������
	 * @param params
	 */
	abstract void setParameters(Object[] params);
	/**
	 * �����ͨ���˷�����Ӻ������� (Appender,Layout�ȵ�)
	 * @param appenders
	 */
	abstract void addAppenders(Vector<Appender> appenders);

}
