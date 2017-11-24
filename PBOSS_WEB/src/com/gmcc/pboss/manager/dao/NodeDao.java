package com.gmcc.pboss.manager.dao;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryResult;

public interface NodeDao extends BaseDao {
	public int getAllRowsSQL(QueryParameterProcessor processor, QueryParameter parameter);
	public QueryResult getAllSQL(QueryParameterProcessor processor, QueryParameter parameter);
	//public Object getOneSQL(QueryParameterProcessor processor, QueryParameter parameter);
}
