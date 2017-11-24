package com.gmcc.pboss.common.support;

import org.hibernate.Criteria;
import org.hibernate.Query;

/**
 * 
 * ��ѯ����������
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
