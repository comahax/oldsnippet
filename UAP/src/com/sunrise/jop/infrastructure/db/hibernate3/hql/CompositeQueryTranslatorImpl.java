package com.sunrise.jop.infrastructure.db.hibernate3.hql;

import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.engine.QueryParameters;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.engine.SessionImplementor;

/**
 * 解决org.hibernate.hql.classic.QueryTranslatorImpl不支持executeUpdate()的问题
 * 
 * @author 黄佰明
 *
 */


public class CompositeQueryTranslatorImpl extends org.hibernate.hql.classic.QueryTranslatorImpl {

	org.hibernate.hql.ast.QueryTranslatorImpl astQti;

	public CompositeQueryTranslatorImpl(String queryIdentifier, String queryString, Map filters, SessionFactoryImplementor factory) {
		super( queryIdentifier,  queryString,  filters,  factory);
		this.astQti = new org.hibernate.hql.ast.QueryTranslatorImpl(queryIdentifier,  queryString,  filters,  factory);
	}

	public int executeUpdate(QueryParameters queryParameters, SessionImplementor session) throws HibernateException {
		return astQti.executeUpdate(queryParameters, session);
	}

	

}
