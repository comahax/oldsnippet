package com.asisinfo.common.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.Assert;

import com.asisinfo.common.jdbc.dialect.Dialect;

/**
 * 
 * @author chenhm
 * @created 2007-3-21 上午11:03:53
 * @version 1.0
 */
public class PageResultSet implements ResultSetExtractor, IPage {
	private final RowMapper rowMapper;

	private final int rowsExpected;

	private int resultSetType = ResultSet.TYPE_FORWARD_ONLY;

	public int getResultSetType() {
		return resultSetType;
	}

	/**
	 * Set whether to use prepared statements that return a specific type of
	 * ResultSet.
	 * 
	 * @param resultSetType the ResultSet type
	 * @see java.sql.ResultSet#TYPE_FORWARD_ONLY
	 * @see java.sql.ResultSet#TYPE_SCROLL_INSENSITIVE
	 * @see java.sql.ResultSet#TYPE_SCROLL_SENSITIVE
	 */
	public void setResultSetType(int resultSetType) {
		this.resultSetType = resultSetType;
	}

	public PageResultSet(RowMapper rowMapper) {
		this(rowMapper, 0);
	}

	public PageResultSet(RowMapper rowMapper, int rowsExpected) {
		Assert.notNull(rowMapper, "RowMapper is required");
		this.rowMapper = rowMapper;
		this.rowsExpected = rowsExpected;
	}

	protected int pageNumber = 1;

	protected int pageSize = 10;

	private int total = -1;

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * <p>
	 * 是否为第一页
	 * 
	 * @return
	 */
	public boolean isFirstPage() {
		return getThisPageNumber() == 1;
	}

	/**
	 * <p>
	 * 是否为最后一页
	 * 
	 * @return
	 */
	public boolean isLastPage() {
		return getThisPageNumber() >= getLastPageNumber();
	}

	/**
	 * <p>
	 * 有没有下一页
	 * 
	 * @return
	 */
	public boolean hasNextPage() {
		return getLastPageNumber() > getThisPageNumber();
	}

	/**
	 * <p>
	 * 有没有前一页
	 * 
	 * @return
	 */
	public boolean hasPreviousPage() {
		return getThisPageNumber() > 1;
	}

	/**
	 * <p>
	 * 得到设定的页大小
	 * 
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * <p>
	 * 得到最后一页的页号
	 * 
	 * @return
	 */
	public int getLastPageNumber() {
		if (getTotalNumberOfElements() == 0)
			return 1;
		else
			return getTotalNumberOfElements() % getPageSize() == 0 ? getTotalNumberOfElements()
					/ getPageSize()
					: getTotalNumberOfElements() / getPageSize() + 1;
	}

	/**
	 * <p>
	 * 得到下一页的页号
	 * 
	 * @return
	 */
	public int getNextPageNumber() {
		return getThisPageNumber() + 1;
	}

	/**
	 * <p>
	 * 得到前一页的页号
	 * 
	 * @return
	 */
	public int getPreviousPageNubmer() {
		return getThisPageNumber() - 1;
	}

	/**
	 * <p>
	 * 得到此页的页号
	 * 
	 * @return
	 */
	public int getThisPageNumber() {
		if (pageNumber > getLastPageNumber()) {
			pageNumber = getLastPageNumber();
		}
		return pageNumber;
	}

	/**
	 * <p>
	 * 得到此页第一个元素在整个元素中的编号
	 * 
	 * @return
	 */
	public int getThisPageFirstElementNumber() {
		return (getThisPageNumber() - 1) * getPageSize() + 1;
	}

	/**
	 * <p>
	 * 得到此页最后一个元素在整个元素中的编号
	 * 
	 * @return
	 */
	public int getThisPageLastElementNumber() {
		int fullPage = getThisPageFirstElementNumber() + getPageSize() - 1;
		return getTotalNumberOfElements() < fullPage ? getTotalNumberOfElements()
				: fullPage;
	}

	/**
	 * <p>
	 * 得到所有元素个数
	 * 
	 * @return
	 */
	public int getTotalNumberOfElements() {
		return total;
	}

	/**
	 * <p>
	 * 得到此页中包含的元素
	 * 
	 * @return
	 */
	public List getThisPageElements() {
		return results;
	}

	public void setThisPageElements(List list) {
		this.results = list;
	}

	protected List results;

	protected boolean extractMetaData = false;

	public void setExtractMetaData(boolean extractMetaData) {
		this.extractMetaData = extractMetaData;
	}

	protected javax.sql.RowSetMetaData resultSetMetaData = new javax.sql.rowset.RowSetMetaDataImpl();

	public ResultSetMetaData getMetaData() {
		return resultSetMetaData;
	}

	public Object extractData(ResultSet rs) throws SQLException {
		results = (this.rowsExpected > 0) ? (List) new ArrayList(this.rowsExpected)
				: (List) new LinkedList();
		int rowNum = 0;

		Dialect dialect = Dialect.getDialect();

		if (extractMetaData) {
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();
			int col = rsmd.getColumnCount();
			resultSetMetaData.setColumnCount(col);
			for (int i = 1; i <= col; i++) {
				resultSetMetaData.setAutoIncrement(i, rsmd.isAutoIncrement(i));
				resultSetMetaData.setCaseSensitive(i, rsmd.isCaseSensitive(i));
				resultSetMetaData.setCatalogName(i, rsmd.getCatalogName(i));
				resultSetMetaData.setColumnDisplaySize(i, rsmd.getColumnDisplaySize(i));
				resultSetMetaData.setColumnLabel(i, rsmd.getColumnLabel(i));
				resultSetMetaData.setColumnName(i, rsmd.getColumnName(i));
				resultSetMetaData.setColumnType(i, rsmd.getColumnType(i));
				resultSetMetaData.setColumnTypeName(i, rsmd.getColumnTypeName(i));
				resultSetMetaData.setCurrency(i, rsmd.isCurrency(i));
				resultSetMetaData.setNullable(i, rsmd.isNullable(i));
				
				if(rsmd.getPrecision(i)<0)
					resultSetMetaData.setPrecision(i,0);
				else
					resultSetMetaData.setPrecision(i, rsmd.getPrecision(i));
				
				if(rsmd.getScale(i)<0)
					resultSetMetaData.setScale(i,0);
				else
					resultSetMetaData.setScale(i, rsmd.getScale(i));
				resultSetMetaData.setSchemaName(i, rsmd.getSchemaName(i));
				resultSetMetaData.setSigned(i, rsmd.isSigned(i));
				resultSetMetaData.setTableName(i, rsmd.getTableName(i));
			}
		}

		if (dialect.supportsLimit()) {
			while (rs.next()) {
				results.add(this.rowMapper.mapRow(rs, rowNum++));
			}
		}
		else if (resultSetType == ResultSet.TYPE_FORWARD_ONLY) {
			if (rs.next()) {
				int current = getThisPageFirstElementNumber();
				int last = current + getPageSize();
				while(rs.getRow() < current){
					rs.next();
				}
				results.add(rowMapper.mapRow(rs, current));
				while (rs.next() && ++current < last) {
					results.add(rowMapper.mapRow(rs, current));
				}				
				
				while(rs.next());
				total = rs.getRow();
			}
			else {
				total = 0;
			}
		}
		else {
			if (rs.next()) {
				rs.last();
				total = rs.getRow();
				int current = getThisPageFirstElementNumber();
				int last = current + getPageSize();

				rs.absolute(current);
				results.add(rowMapper.mapRow(rs, current));
				while (rs.next() && ++current < last) {
					results.add(rowMapper.mapRow(rs, current));
				}
			}
			else {
				total = 0;
			}
		}
		return this;
	}
}
