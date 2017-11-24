/**
 * Copyright(c)2006 SRE. All rights reserved. Use is subject to license terms.
 */
package com.asisinfo.common.jdbc;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.dao.support.DaoSupport;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.SQLExceptionTranslator;

import com.asisinfo.common.jdbc.*;

/**
 * @author chenhm
 * @created 2007-3-21 ÏÂÎç04:09:38
 * @version 1.0
 */
public abstract class PageJdbcDaoSupport extends DaoSupport {

	private PageJdbcTemplate jdbcTemplate;

	/**
	 * Set the JDBC DataSource to be used by this DAO.
	 */
	public final void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = createJdbcTemplate(dataSource);
		initTemplateConfig();
	}

	/**
	 * Create a JdbcTemplate for the given DataSource. Only invoked if
	 * populating the DAO with a DataSource reference!
	 * <p>
	 * Can be overridden in subclasses to provide a JdbcTemplate instance with
	 * different configuration, or a custom JdbcTemplate subclass.
	 * 
	 * @param dataSource the JDBC DataSource to create a JdbcTemplate for
	 * @return the new JdbcTemplate instance
	 * @see #setDataSource
	 */
	protected PageJdbcTemplate createJdbcTemplate(DataSource dataSource) {
		return new PageJdbcTemplate(dataSource);
	}

	/**
	 * Return the JDBC DataSource used by this DAO.
	 */
	public final DataSource getDataSource() {
		return (this.jdbcTemplate != null ? this.jdbcTemplate.getDataSource()
				: null);
	}

	/**
	 * Set the JdbcTemplate for this DAO explicitly, as an alternative to
	 * specifying a DataSource.
	 */
	public final void setJdbcTemplate(PageJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		initTemplateConfig();
	}

	/**
	 * Return the JdbcTemplate for this DAO, pre-initialized with the DataSource
	 * or set explicitly.
	 */
	public final PageJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * Initialize the template-based configuration of this DAO. Called after a
	 * new JdbcTemplate has been set, either directly or through a DataSource.
	 * <p>
	 * This implementation is empty. Subclasses may override this to configure
	 * further objects based on the JdbcTemplate.
	 * 
	 * @see #getJdbcTemplate()
	 */
	protected void initTemplateConfig() {
	}

	protected void checkDaoConfig() {
		if (this.jdbcTemplate == null) {
			throw new IllegalArgumentException(
					"dataSource or jdbcTemplate is required");
		}
	}

	/**
	 * Get a JDBC Connection, either from the current transaction or a new one.
	 * 
	 * @return the JDBC Connection
	 * @throws org.springframework.jdbc.CannotGetJdbcConnectionException if the
	 *             attempt to get a Connection failed
	 * @see org.springframework.jdbc.datasource.DataSourceUtils#getConnection(javax.sql.DataSource)
	 */
	protected final Connection getConnection()
			throws CannotGetJdbcConnectionException {
		return DataSourceUtils.getConnection(getDataSource());
	}

	/**
	 * Return the SQLExceptionTranslator of this DAO's JdbcTemplate, for
	 * translating SQLExceptions in custom JDBC access code.
	 * 
	 * @see org.springframework.jdbc.core.JdbcTemplate#getExceptionTranslator
	 */
	protected final SQLExceptionTranslator getExceptionTranslator() {
		return this.jdbcTemplate.getExceptionTranslator();
	}

	/**
	 * Close the given JDBC Connection, created via this DAO's DataSource, if it
	 * isn't bound to the thread.
	 * 
	 * @param con Connection to close
	 * @see org.springframework.jdbc.datasource.DataSourceUtils#releaseConnection
	 */
	protected final void releaseConnection(Connection con) {
		DataSourceUtils.releaseConnection(con, getDataSource());
	}
}
