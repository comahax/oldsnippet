package com.gmcc.pboss.common.support;

import org.hibernate.Criteria;
import org.hibernate.Query;

public class DefaultQueryParameterProcessor implements QueryParameterProcessor {

	public void process(Criteria criteria, QueryParameter parameter) {
		throw new UnsupportedOperationException();
	}

	public void process(Query query, QueryParameter parameter) {
	}

}
