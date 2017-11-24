package com.sunrise.jop.common.utils.lang;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

/**
 * �������ڼ�¼�׳��쳣��������Ķ�ջ��Ϣ��Log4j����Logger����־����ȥ 
 * ����info,warnû��Ҫ����ջ��ӡ�Ĵ���,���ʡȥ.
 * @author Canigar
 */
public class LoggerUtils {

	public static void error(Exception e, Logger logger) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		logger.error(sw.toString());
	}
	
	public static void error(Exception e, Log logger) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		logger.error(sw.toString());
	}
	
}
