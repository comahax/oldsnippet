package com.gmcc.pboss.service;

public class WebsiteCounter {

	private ThreadLocal<Long> threadLocal; //ʱ���ʱ��
	private int times;                     //������ʱ��
	
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
