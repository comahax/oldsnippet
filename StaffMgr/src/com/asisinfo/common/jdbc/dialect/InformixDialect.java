package com.asisinfo.common.jdbc.dialect;



/**
 * Informix dialect.<br>
 * <br>
 * Seems to work with Informix Dynamic Server Version 7.31.UD3,
 * Informix JDBC driver version 2.21JC3.
 * @author Steve Molitor
 */
public class InformixDialect extends Dialect {
	/**
	 * Creates new <code>InformixDialect</code> instance. Sets up the JDBC /
	 * Informix type mappings.
	 */
	public InformixDialect() {
		super();
	}
}