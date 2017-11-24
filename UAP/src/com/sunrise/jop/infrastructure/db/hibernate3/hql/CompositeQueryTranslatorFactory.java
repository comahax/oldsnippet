package com.sunrise.jop.infrastructure.db.hibernate3.hql;

import java.util.Map;

import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.hql.FilterTranslator;
import org.hibernate.hql.QueryTranslator;
import org.hibernate.hql.classic.ClassicQueryTranslatorFactory;

/**
 * 
 * @author 黄佰明
 *
 */
public class CompositeQueryTranslatorFactory extends ClassicQueryTranslatorFactory{
	public QueryTranslator createQueryTranslator(
			String queryIdentifier,
	        String queryString,
	        Map filters,
	        SessionFactoryImplementor factory) {
		return new CompositeQueryTranslatorImpl( queryIdentifier, queryString, filters, factory );
	}

	public FilterTranslator createFilterTranslator(
			String queryIdentifier,
			String queryString,
	        Map filters,
	        SessionFactoryImplementor factory) {
		return new CompositeQueryTranslatorImpl( queryIdentifier, queryString, filters, factory );
	}
}
