package com.sunrise.jop.common.utils.logging;

import java.util.Vector;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;

/**
 * DailyRollingFileLogger Éú³ÉÆ÷
 * @author zsw
 *
 */
public class DailyRollingFileLoggerCreator extends LoggerCreator {

	private String datePattern;
	private String conversionPattern;
	private String filename;
	private boolean appender;
	private String target;
	private Priority threshold;
	

	public DailyRollingFileLoggerCreator() {}
	
	public DailyRollingFileLoggerCreator(String datePattern,
			String conversionPattern, String filename,boolean appender) {

		this.datePattern = datePattern;
		this.conversionPattern = conversionPattern;
		this.filename = filename;
		this.appender = appender;
	}

	void addAppenders(Vector<Appender> appenders) {
		PatternLayout layout = new PatternLayout();
		layout.setConversionPattern(conversionPattern);

		DailyRollingFileAppender drfAppender = new DailyRollingFileAppender();
		drfAppender.setName("File");
		drfAppender.setLayout(layout);
		drfAppender.setFile(filename);
		drfAppender.setAppend(appender);
		drfAppender.setDatePattern(datePattern);
		drfAppender.activateOptions();
		
		PatternLayout cLayout = new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN);
		ConsoleAppender cAppender = new ConsoleAppender();
		cAppender.setLayout(cLayout);
		cAppender.setTarget(target);
		cAppender.setThreshold(threshold);
		cAppender.activateOptions();

		appenders.add(drfAppender);
		appenders.add(cAppender);

	}

	Logger getLogger(Object logname) {
		return Logger.getLogger((String)logname);
	}
	
	void setParameters(Object[] params) {
		this.setDatePattern((String)params[0]);
		this.setConversionPattern((String)params[1]);
		this.setFilename((String)params[2]);
		this.setAppender((Boolean)params[3]);
		this.setTarget((String)params[4]);
		this.setThreshold((Level)params[5]);
	}
	public String getDatePattern() {
		return datePattern;
	}
	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}
	public String getConversionPattern() {
		return conversionPattern;
	}
	public void setConversionPattern(String conversionPattern) {
		this.conversionPattern = conversionPattern;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public boolean isAppender() {
		return appender;
	}
	public void setAppender(boolean appender) {
		this.appender = appender;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public Priority getThreshold() {
		return threshold;
	}
	public void setThreshold(Priority threshold) {
		this.threshold = threshold;
	}
	
}
