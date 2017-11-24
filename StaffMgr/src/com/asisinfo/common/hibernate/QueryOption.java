package com.asisinfo.common.hibernate;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.asisinfo.common.pager.IPage;

/**
 * 封装查询选项，作为分页查询的选项使用
 * @author johnson
 */
public class QueryOption {
	
	/** 分页方式：内存分页，通过list.size()计算记录数*/
	public static final String PAGE_LIST = "PAGE_LIST";
	
	/**分页方式：数据库分页，通过select count(*) from (sql)的形式来计算记录数，目前只支持informix10和oracle*/
	public static final String PAGE_NEST = "PAGE_NEST";
	
	/**分页方式：数据库分页，通过 将from前的语句换成select count(*)来计算记录数*/
	public static final String PAGE_AUTO = "PAGE_AUTO";
	
	/** 不分页，查询所有记录*/
	public static final String PAGE_NONE = "PAGE_NONE";
	
	/** 需要查询的页码 */
	private int pageNo = 1;
	
	/** 每页的记录数*/
	private int pageSize = 20;
	
	/** 分页类型，默认为PAGE_AUTO*/
	private String pagingType = PAGE_AUTO;
	
	private Map dynamicBeanConfig;
	
	public int getPageNo() {
		return pageNo;
	}
	/**
	 * 设置查询的页码
	 * @param pageNo
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * 设置每页记录数
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getPagingType() {
		return pagingType;
	}
	/**
	 * 设置查询的分页类型
	 * @param pagingType
	 * @see QueryOption#PAGE_AUTO
	 * @see QueryOption#PAGE_NEST
	 * @see QueryOption#PAGE_LIST
	 * @see QueryOption#PAGE_NONE
	 */
	public void setPagingType(String pagingType) {
		this.pagingType = pagingType;
	}

	/**
	 * 获取默认的查询选项
	 * @return 默认的QueryOption对象
	 */
	public static QueryOption getInstance(){
		return new QueryOption();
	}

	/**
	 * 通过request构造默认的查询选项，该方法从请求中获取当前查询对应的页码pageNo以及每页大小pageSize
	 * @param request
	 * @return 默认的QueryOption对象
	 */
	public static QueryOption getInstance(HttpServletRequest request){
		QueryOption opt = new QueryOption();
		String pageNoStr = request.getParameter(IPage.PAGE_NO);
		String pageSizeStr = request.getParameter(IPage.PAGE_SIZE);
		if(StringUtils.isEmpty(pageNoStr)||StringUtils.isEmpty(pageSizeStr))
			return opt;
		try {
			opt.setPageNo(Integer.parseInt(pageNoStr));
			opt.setPageSize(Integer.parseInt(pageSizeStr));
		} catch (NumberFormatException e) {
		}
		return opt;
	}
	public Map getDynamicBeanConfig() {
		return dynamicBeanConfig;
	}
	public void setDynamicBeanConfig(Map dynamicBeanConfig) {
		this.dynamicBeanConfig = dynamicBeanConfig;
	}
	
}	
