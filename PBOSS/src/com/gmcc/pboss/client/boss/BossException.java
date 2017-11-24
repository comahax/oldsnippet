/**
 * 
 */
package com.gmcc.pboss.client.boss;


/**
 * @author hbm
 *
 */
public class BossException extends RuntimeException {

	public BossException(Exception e) {
		super(e);
	}

	public BossException(String msg) {
		super(msg);
	}

}
