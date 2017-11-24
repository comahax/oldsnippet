package com.asisinfo.common.jdbc.dialect;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.util.ClassUtils;

/**
 * 用于对不同数据库执行分页查询
 * 
 * @author chenhm
 * @created 2007-3-21 下午03:58:29
 * @version 1.0
 */
public abstract class Dialect {
	private static final Logger log = Logger.getLogger(Dialect.class);

	private static final String DIALECT = "jdbc.dialect";

	protected Dialect() {
		log.info("Using dialect: " + this);
	}

	public String toString() {
		return getClass().getName();
	}

	private static Dialect inner_dialect;

	/**
	 * Get the <tt>Dialect</tt> specified by the current <tt>System</tt>
	 * properties.
	 * 
	 * @return Dialect
	 * @throws DataAccessResourceFailureException
	 * @todo 需要改为从spring的context中拿dialectName
	 */
	public static Dialect getDialect()
			throws DataAccessResourceFailureException {
		if (inner_dialect != null)
			return inner_dialect;

		String dialectName = "com.sunrise.common.jdbc.dialect.Oracle9Dialect";

		if (dialectName == null)
			throw new DataAccessResourceFailureException(
					"The dialect was not set. Set the property hibernate.dialect.");
		try {
			inner_dialect = (Dialect) ClassUtils.forName(dialectName).newInstance();
			return inner_dialect;
		}
		catch (ClassNotFoundException cnfe) {
			throw new DataAccessResourceFailureException(
					"Dialect class not found: " + dialectName);
		}
		catch (Exception e) {
			throw new DataAccessResourceFailureException(
					"Could not instantiate dialect class", e);
		}
	}

	/**
	 * Get the <tt>Dialect</tt> specified by the given properties or system
	 * properties.
	 * 
	 * @param props
	 * @return Dialect
	 * @throws DataAccessResourceFailureException
	 */
	public static Dialect getDialect(Properties props)
			throws DataAccessResourceFailureException {
		String dialectName = props.getProperty(DIALECT);
		if (dialectName == null)
			return getDialect();
		try {
			return (Dialect) ClassUtils.forName(dialectName).newInstance();
		}
		catch (ClassNotFoundException cnfe) {
			throw new DataAccessResourceFailureException(
					"Dialect class not found: " + dialectName);
		}
		catch (Exception e) {
			throw new DataAccessResourceFailureException(
					"Could not instantiate dialect class", e);
		}
	}

	/**
	 * Does this <tt>Dialect</tt> have some kind of <tt>LIMIT</tt> syntax?
	 */
	public boolean supportsLimit() {
		return false;
	}

	public String getLimitString(String querySelect) {
		throw new UnsupportedOperationException("paged queries not supported");
	}

	public String getCountString(String sql) {
		throw new UnsupportedOperationException("count queries not supported");
	}

	static int getAfterSelectInsertPoint(String sql) {
		final int selectDistinctIndex = sql.indexOf("select distinct");
		if (selectDistinctIndex >= 0) {
			return selectDistinctIndex + 15;
		}
		else {
			return sql.indexOf("select") + 6;
		}
	}

}
