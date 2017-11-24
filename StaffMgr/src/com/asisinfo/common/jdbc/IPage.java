package com.asisinfo.common.jdbc;

import java.sql.ResultSetMetaData;
import java.util.List;

public interface IPage {

	/**
	 * <p>
	 * 是否为第一页
	 * 
	 * @return
	 */
	public boolean isFirstPage();

	/**
	 * <p>
	 * 是否为最后一页
	 * 
	 * @return
	 */
	public boolean isLastPage();

	/**
	 * <p>
	 * 有没有下一页
	 * 
	 * @return
	 */
	public boolean hasNextPage();

	/**
	 * <p>
	 * 有没有前一页
	 * 
	 * @return
	 */
	public boolean hasPreviousPage();

	/**
	 * <p>
	 * 得到设定的页大小,留给子类实现以便判断是否
	 * 
	 * @return
	 */
	public int getPageSize();

	/**
	 * <p>
	 * 得到最后一页的页号
	 * 
	 * @return
	 */
	public int getLastPageNumber();

	/**
	 * <p>
	 * 得到下一页的页号
	 * 
	 * @return
	 */
	public int getNextPageNumber();

	/**
	 * <p>
	 * 得到前一页的页号
	 * 
	 * @return
	 */
	public int getPreviousPageNubmer();

	/**
	 * <p>
	 * 得到此页的页号
	 * 
	 * @return
	 */
	public int getThisPageNumber();

	/**
	 * <p>
	 * 得到此页第一个元素在整个元素中的编号
	 * 
	 * @return
	 */
	public int getThisPageFirstElementNumber();

	/**
	 * <p>
	 * 得到此页最后一个元素在整个元素中的编号
	 * 
	 * @return
	 */
	public int getThisPageLastElementNumber();

	/**
	 * <p>
	 * 得到所有元素个数
	 * 
	 * @return
	 */
	public int getTotalNumberOfElements();

	/**
	 * <p>
	 * 得到此页中包含的元素
	 * 
	 * @return
	 */
	public List getThisPageElements();
	
	/**
	 * 设置此页包含的元素
	 */
	public void setThisPageElements(List list);
	
	/**
	 * 是否抽取结果集的元数据，默认不抽取
	 * @param extractMetaData
	 */
	public void setExtractMetaData(boolean extractMetaData);
	
	/**
	 * 获取结果集的元数据
	 * @return
	 */
	public ResultSetMetaData getMetaData();
}
