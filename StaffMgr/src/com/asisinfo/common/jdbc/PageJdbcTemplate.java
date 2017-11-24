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
 * @created 2007-3-21 ����09:39:49
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
			// ͨ��DatabaseMetaData.supportsResultSetType()�����ж������Ƿ�֧�ֹ����Ľ������(����ֻ�趨�����У�
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
	 * ����sequence�Ĳ�ѯ���������ݿ�Ĳ���
	 * 
	 * @param sequence sequence����
	 * @return sequence����һ��ֵ
	 */
	public int querySequence(String sequence) {
		return queryForInt("select " + sequence+ ".NEXTVAL from dual");
	}

	/**
	 * ���ط��������ĵ�һ���������Ӧ������queryForObject��������
	 * ��ֱ��ʹ��queryForObject����Ϊ�����ݿ�û�м�¼��ʱ��queryForObject���׳�DataAccessException
	 * �÷������ȡ��������������������ڿ��ܷ��ش�������Ĳ�ѯ��
	 * 
	 * @param sql SQL
	 * @param args ������������
	 * @param argTypes ������������
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
	 * ʹ��iBatis��SQLƴװ��ѯ
	 * 
	 * @param id SqlMap��SQL����id
	 * @param param ��������
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
	 * ʹ�� {@link com.asisinfo.common.jdbc.RowMapperFactory }����Ĭ�ϵ�RowMapper
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
	 * ����String�õĽ϶࣬�ڴ��ṩһ����ݷ�ʽ �����Ҫ���ض��е���ʹ��queryForList(id, param, String.class)
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
	 * ���������пն����ʱ��ʹ�ô��в������͵Ĳ�ѯ����������ʹ�ò����������͵Ĳ�ѯ������<br>
	 * ������Ա�֤����һ���ǿգ������ڱ�дSqlMap��ʱ���ʵ�͵��
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
	 * �������ÿһ�ж�ӦList��һ������<br>
	 * Note:���ڻ�������������ʹ�� {@link #queryForList(String, Object, Class)} ����.
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
	 * ���ڷ��ؽ���һ�е���������е�������requiredTypeָ��<br>
	 * �ο� {@link org.springframework.jdbc.core.SingleColumnRowMapper} ��ʵ��
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
	 * update������ע��sqlMap����Ҫ��#intId:INTEGER#����ʽָ����������
	 * 
	 * @param id
	 * @param param
	 * @return ��Ӱ��ļ�¼����
	 */
	public int update(String id, Object param) {
		SqlGetter getter = IbatisSqlMapConfigHelper.getSqlGetter(id, param);
		return update(getter.getSql(), getter.getValue(), getter.getType());
	}

	/**
	 * �����ļ���execute��������Ӧ�ñ�ֱ�ӵ��ã������޷���¼ִ�е�sql
	 * 
	 * @see JdbcTemplate#execute(String)
	 */
	public void execute(final String sql) throws DataAccessException {
		super.execute(sql);
	}




	/**
	 * ���ڸ���ķ��������ӣ��ڴ˸���һ��
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
	 * ����JdbcTemplate�еķ�����ʵ�ֶ��������µ�SQL��¼
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
