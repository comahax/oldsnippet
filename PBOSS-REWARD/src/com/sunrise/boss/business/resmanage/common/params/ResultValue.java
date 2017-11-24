package com.sunrise.boss.business.resmanage.common.params;

/**
 * <p>Title: ResultValue</p>
 * <p>Description: 手机资源返回结果类</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Cao Wei 
 * @version 1.0
 */

public class ResultValue {
	private long successCount;
	private long falseCount;
	
	public long getFalseCount() {
		return falseCount;
	}
	public void setFalseCount(long falseCount) {
		this.falseCount = falseCount;
	}
	public long getSuccessCount() {
		return successCount;
	}
	public void setSuccessCount(long successCount) {
		this.successCount = successCount;
	}
	
}
