package com.gmcc.pboss.service;

public class WebsiteCounter {

	private ThreadLocal<Long> threadLocal; //时间计时器
	private int times;                     //次数计时器
	
	public WebsiteCounter(){
		threadLocal = new ThreadLocal<Long>();
		times = 0;
	}
	
	public ThreadLocal<Long> getThreadLocal() {
		return threadLocal;
	}
	public void setThreadLocal(ThreadLocal<Long> threadLocal) {
		this.threadLocal = threadLocal;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	
}
