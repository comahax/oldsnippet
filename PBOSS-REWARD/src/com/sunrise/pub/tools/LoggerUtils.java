package com.sunrise.pub.tools;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

/**
 * 该类用于记录抛出异常处理里面的堆栈信息到Log4j或者Logger的日志里面去 
 * 由于info,warn没必要做堆栈打印的处理,因此省去.
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
