package com.sunrise.boss.business.fee.woff.woffrule.exception;

public class WriteOffException extends Exception {
	private String reason;

	public WriteOffException(String reason) {
		this.reason=reason;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
