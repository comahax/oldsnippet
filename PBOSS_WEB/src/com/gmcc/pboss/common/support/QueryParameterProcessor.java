package com.gmcc.pboss.common.support;

import org.hibernate.Criteria;
import org.hibernate.Query;

/**
 * 
 * 查询参数处理器
 * 
 */
public interface QueryParameterProcessor {

	/**
	 * 
	 * @param criteria
	 * @param parameter
	 */
	public void process(Criteria criteria, QueryParameter parameter);
	/**
	 * 
	 * @param query
	 * @param parameter
	 */
	public void process(Query query, QueryParameter parameter);

}
