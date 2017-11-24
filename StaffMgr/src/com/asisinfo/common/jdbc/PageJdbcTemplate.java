/**
 * Copyright(c)2006 SRE. All rights reserved. Use is subject to license terms.
 */
package com.asisinfo.common.jdbc;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.InterruptibleBatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterDisposer;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlProvider;
import org.springframework.jdbc.support.DatabaseMetaDataCallback;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.MetaDataAccessException;

import com.asisinfo.common.ibatis.IbatisSqlMapConfigHelper;
import com.asisinfo.common.ibatis.SqlGetter;
import com.asisinfo.common.jdbc.dialect.Dialect;

/**
 * 
 * 
 * @author chenhm
 * @created 2007-3-21 上午09:39:49
 * @version 1.0
 */
public class PageJdbcTemplate extends JdbcTemplate {



	/**
	 * @see JdbcTemplate#JdbcTemplate()
	 */
	public PageJdbcTemplate() {
	}

	/**
	 * @see JdbcTemplate#JdbcTemplate(DataSource)
	 */
	public PageJdbcTemplate(DataSource dataSource) {
		super(dataSource);
	}

	/**
	 * @see JdbcTemplate#JdbcTemplate(DataSource, boolean)
	 */
	public PageJdbcTemplate(DataSource dataSource, boolean lazyInit) {
		super(dataSource, lazyInit);
	}

	public IPage query(String id, Object param, Class T, int pageNo,
			int pageSize) {
		SqlGetter getter = IbatisSqlMapConfigHelper.getSqlGetter(id, param);
		return query(getter.getSql(), getter.getValue(), getter.getType(),
			RowMapperFactory.createObjectRowMapper(T), pageNo, pageSize, false);
	}
	
	public IPage query(String id, Object param, RowMapper rowMapper, int pageNo,
			int pageSize) {
		SqlGetter getter = IbatisSqlMapConfigHelper.getSqlGetter(id, param);
		return query(getter.getSql(), getter.getValue(), getter.getType(),
			rowMapper, pageNo, pageSize, false);
	}

	public IPage query(String sql, Object[] args, int[] argTypes,
			RowMapper rowMapper, int pageNo, int pageSize) {
		return query(sql, args, argTypes, rowMapper, pageNo, pageSize, false);
	}

	public IPage query(String sql, Object[] args, int[] argTypes,
			RowMapper rowMapper, int pageNo, int pageSize,
			boolean extractMetaData) throws DataAccessException {
		PageResultSet pageResultSet = new PageResultSet(rowMapper);
		pageResultSet.setPageNumber(pageNo);
		pageResultSet.setPageSize(pageSize);
		pageResultSet.setExtractMetaData(extractMetaData);

		Dialect dialect = Dialect.getDialect();
		if (dialect.supportsLimit()) {
			int total = queryForInt(dialect.getCountString(sql), args, argTypes);
			pageResultSet.setTotal(total);

			args = ArrayUtils.addAll(
				args,
				new Object[] {
						new Integer(
								pageResultSet.getThisPageLastElementNumber()),
						new Integer(
								pageResultSet.getThisPageFirstElementNumber() - 1) });
			argTypes = ArrayUtils.addAll(argTypes, new int[] { Types.INTEGER,
					Types.INTEGER });

			sql = dialect.getLimitString(sql);

		}

		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
				sql, argTypes);
		if (isSupportScroll()) {
			pscf.setResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE);
			pageResultSet.setResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE);
		}

		return (IPage) super.query(pscf.newPreparedStatementCreator(args),
			null, pageResultSet);

	}

	public IPage query(String sql, Object[] args, RowMapper rowMapper,
			int pageNo, int pageSize) throws DataAccessException {
		return query(sql, args, null, rowMapper, pageNo, pageSize);
	}

	protected boolean isSupportScroll() {
		try {
			// 通过DatabaseMetaData.supportsResultSetType()方法判断驱动是否支持滚动的结果集合(这里只设定不敏感）
			return ((Boolean) JdbcUtils.extractDatabaseMetaData(
				getDataSource(), new DatabaseMetaDataCallback() {
					public Object processMetaData(DatabaseMetaData dbmd)
							throws SQLException, MetaDataAccessException {
						return new Boolean(
								dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
					}
				})).booleanValue();
		}
		catch (MetaDataAccessException e) {
		}
		return false;
	}

	/**
	 * 处理sequence的查询以屏蔽数据库的差异
	 * 
	 * @param sequence sequence名称
	 * @return sequence的下一个值
	 */
	public int querySequence(String sequence) {
		return queryForInt("select " + sequence+ ".NEXTVAL from dual");
	}

	/**
	 * 返回符合条件的第一个对象，与对应参数的queryForObject方法相似
	 * 不直接使用queryForObject是因为当数据库没有记录的时候queryForObject会抛出DataAccessException
	 * 该方法会获取整个结果集，不建议用在可能返回大量结果的查询上
	 * 
	 * @param sql SQL
	 * @param args 参数对象数组
	 * @param argTypes 参数类型数组
	 * @param rowMapper rowMapper
	 * @return
	 * @throws DataAccessException
	 */
	public Object queryObject(String sql, Object[] args, int[] argTypes,
			RowMapper rowMapper) throws DataAccessException {
		List result = query(sql, args, argTypes, rowMapper);
		if (result.size() > 0) {
			return result.get(0);
		}
		else {
			return null;
		}
	}

	/**
	 * 使用iBatis的SQL拼装查询
	 * 
	 * @param id SqlMap中SQL语句的id
	 * @param param 参数对象
	 * @param rowMapper rowMapper
	 * @return
	 * @throws DataAccessException
	 */

	public Object queryObject(String id, Object param, RowMapper rowMapper)
			throws DataAccessException {
		List result = query(id, param, rowMapper);
		if (result.size() > 0) {
			return result.get(0);
		}
		else {
			return null;
		}
	}

	/**
	 * 使用 {@link com.asisinfo.common.jdbc.RowMapperFactory }创建默认的RowMapper
	 * 
	 * @see #queryObject(String, Object, RowMapper)
	 * @param id
	 * @param param
	 * @param T
	 * @return
	 * @throws DataAccessException
	 */
	public Object queryObject(String id, Object param, Class T)
			throws DataAccessException {
		return queryObject(id, param, RowMapperFactory.createObjectRowMapper(T));
	}

	/**
	 * 由于String用的较多，在此提供一个快捷方式 如果需要返回多列的请使用queryForList(id, param, String.class)
	 * 
	 * @param id
	 * @param param
	 * @return
	 * @throws DataAccessException
	 */
	public String queryString(String id, Object param)
			throws DataAccessException {
		return (String) queryObject(id, param, new RowMapper() {
			public java.lang.Object mapRow(java.sql.ResultSet rs, int rowNum)
					throws java.sql.SQLException {
				return rs.getString(1);
			}
		});
	}

	public int queryInt(String id, Object param) throws DataAccessException {
		SqlGetter getter = IbatisSqlMapConfigHelper.getSqlGetter(id, param);
		return queryForInt(getter.getSql(), getter.getValue());
	}

	/**
	 * 当参数中有空对象的时候使用带有参数类型的查询方法，否则使用不带参数类型的查询方法。<br>
	 * 如果可以保证参数一定非空，可以在编写SqlMap的时候适当偷懒
	 * 
	 * @param id
	 * @param param
	 * @param rowMapper
	 * @return
	 */
	public List query(String id, Object param, RowMapper rowMapper) {
		SqlGetter getter = IbatisSqlMapConfigHelper.getSqlGetter(id, param);
		Object[] pm = getter.getValue();
		for (int i = 0; i < pm.length; i++) {
			if (pm[i] == null) {
				return query(getter.getSql(), getter.getValue(),
					getter.getType(), rowMapper);
			}
		}
		return query(getter.getSql(), getter.getValue(), rowMapper);
	}

	/**
	 * 结果集的每一行对应List中一个对象。<br>
	 * Note:对于基础数据类型请使用 {@link #queryForList(String, Object, Class)} 方法.
	 * 
	 * @param id
	 * @param param
	 * @param requiredType
	 * @return
	 */

	public List query(String id, Object param, Class requiredType) {
		return query(id, param,
			RowMapperFactory.createObjectRowMapper(requiredType));
	}

	/**
	 * 用于返回仅有一列的情况，该列的类型由requiredType指定<br>
	 * 参考 {@link org.springframework.jdbc.core.SingleColumnRowMapper} 的实现
	 * 
	 * @param id
	 * @param param
	 * @param requiredType
	 * @return
	 */
	public List queryForList(String id, Object param, Class requiredType) {
		SqlGetter getter = IbatisSqlMapConfigHelper.getSqlGetter(id, param);
		return queryForList(getter.getSql(), getter.getValue(),
			getter.getType(), requiredType);
	}

	/**
	 * update方法，注意sqlMap中需要以#intId:INTEGER#的形式指定参数类型
	 * 
	 * @param id
	 * @param param
	 * @return 所影响的记录行数
	 */
	public int update(String id, Object param) {
		SqlGetter getter = IbatisSqlMapConfigHelper.getSqlGetter(id, param);
		return update(getter.getSql(), getter.getValue(), getter.getType());
	}

	/**
	 * 其他的几个execute方法都不应该被直接调用，否则无法记录执行的sql
	 * 
	 * @see JdbcTemplate#execute(String)
	 */
	public void execute(final String sql) throws DataAccessException {
		super.execute(sql);
	}




	/**
	 * 由于父类的方法不可视，在此复制一份
	 * 
	 * @param sqlProvider
	 * @return
	 */
	private static String getSql(Object sqlProvider) {
		if (sqlProvider instanceof SqlProvider) {
			return ((SqlProvider) sqlProvider).getSql();
		}
		else {
			return null;
		}
	}

	public Object query(PreparedStatementCreator psc,
			final PreparedStatementSetter pss, final ResultSetExtractor rse)
			throws DataAccessException {
		final String sql = getSql(psc);
		if (logger.isDebugEnabled()) {
			logger.debug("Executing SQL query"
					+ (sql != null ? " [" + sql + "]" : ""));
		}

		return execute(psc, new PreparedStatementCallback() {
			public Object doInPreparedStatement(PreparedStatement ps)
					throws SQLException {
				ResultSet rs = null;
				try {
					SqlPreparedStatement sqlps = new SqlPreparedStatement(sql);
					if (pss != null) {
						pss.setValues(ps);
						pss.setValues(sqlps);
					}
					rs = ps.executeQuery();
					sqlps.executeQuery();
					ResultSet rsToUse = rs;
					if (getNativeJdbcExtractor() != null) {
						rsToUse = getNativeJdbcExtractor().getNativeResultSet(
							rs);
					}

					return rse.extractData(rsToUse);
				}
				finally {
					JdbcUtils.closeResultSet(rs);
					if (pss instanceof ParameterDisposer) {
						((ParameterDisposer) pss).cleanupParameters();
					}
				}
			}
		});
	}

	protected int update(final PreparedStatementCreator psc,
			final PreparedStatementSetter pss) throws DataAccessException {
		final String sql = getSql(psc);
		if (logger.isDebugEnabled()) {
			logger.debug("Executing SQL update"
					+ (sql != null ? " [" + sql + "]" : ""));
		}

		Integer result = (Integer) execute(psc,
			new PreparedStatementCallback() {
				public Object doInPreparedStatement(PreparedStatement ps)
						throws SQLException {
					try {
						SqlPreparedStatement sqlps = new SqlPreparedStatement(
								sql);
						if (pss != null) {
							pss.setValues(ps);
							pss.setValues(sqlps);
						}
						int rows = ps.executeUpdate();
						sqlps.executeQuery();
						if (logger.isDebugEnabled()) {
							logger.debug("SQL update affected " + rows
									+ " rows");
						}
						return new Integer(rows);
					}
					finally {
						if (pss instanceof ParameterDisposer) {
							((ParameterDisposer) pss).cleanupParameters();
						}
					}
				}
			});
		return result.intValue();

	}

	public int update(final PreparedStatementCreator psc,
			final KeyHolder generatedKeyHolder) throws DataAccessException {
		logger.info("This method don't log sql");
		return super.update(psc, generatedKeyHolder);
	}

	/**
	 * 覆盖JdbcTemplate中的方法，实现对批量更新的SQL记录
	 */
	public int[] batchUpdate(String sql, final BatchPreparedStatementSetter pss)
			throws DataAccessException {
		return batchUpdate(sql, pss, true);
	}

	public int[] batchUpdate(String sql,
			final BatchPreparedStatementSetter pss, boolean isLog)
			throws DataAccessException {
		if (logger.isDebugEnabled()) {
			logger.debug("Executing SQL batch update [" + sql + "]");
		}
		final String sqlFinal = sql;
		if (isLog) {
			return (int[]) execute(sql, new PreparedStatementCallback() {
				public Object doInPreparedStatement(PreparedStatement ps)
						throws SQLException {
					try {
						int batchSize = pss.getBatchSize();
						boolean interruptible = pss instanceof InterruptibleBatchPreparedStatementSetter;

						SqlPreparedStatement sqlps = new SqlPreparedStatement(
								sqlFinal);

						if (JdbcUtils.supportsBatchUpdates(ps.getConnection())) {
							for (int i = 0; i < batchSize; i++) {
								pss.setValues(ps, i);
								pss.setValues(sqlps, i);
								if (interruptible
										&& ((InterruptibleBatchPreparedStatementSetter) pss).isBatchExhausted(i)) {
									break;
								}
								else {
									ps.addBatch();
									sqlps.addBatch();
								}
							}
							sqlps.executeBatch();

							return ps.executeBatch();
						}
						else {
							int[] rowsAffected = new int[batchSize];
							for (int i = 0; i < batchSize; i++) {
								pss.setValues(ps, i);
								rowsAffected[i] = ps.executeUpdate();
								pss.setValues(sqlps, i);
								sqlps.executeQuery();
							}

							return rowsAffected;
						}
					}
					finally {
						if (pss instanceof ParameterDisposer) {
							((ParameterDisposer) pss).cleanupParameters();
						}
					}
				}
			});
		}
		else {
			return (int[]) execute(sql, new PreparedStatementCallback() {
				public Object doInPreparedStatement(PreparedStatement ps)
						throws SQLException {
					try {
						int batchSize = pss.getBatchSize();
						boolean interruptible = pss instanceof InterruptibleBatchPreparedStatementSetter;

						if (JdbcUtils.supportsBatchUpdates(ps.getConnection())) {
							for (int i = 0; i < batchSize; i++) {
								pss.setValues(ps, i);
								if (interruptible
										&& ((InterruptibleBatchPreparedStatementSetter) pss).isBatchExhausted(i)) {
									break;
								}
								else {
									ps.addBatch();
								}
							}
							return ps.executeBatch();
						}
						else {
							int[] rowsAffected = new int[batchSize];
							for (int i = 0; i < batchSize; i++) {
								pss.setValues(ps, i);
								rowsAffected[i] = ps.executeUpdate();
							}
							return rowsAffected;
						}
					}
					finally {
						if (pss instanceof ParameterDisposer) {
							((ParameterDisposer) pss).cleanupParameters();
						}
					}
				}
			});
		}
	}
}
