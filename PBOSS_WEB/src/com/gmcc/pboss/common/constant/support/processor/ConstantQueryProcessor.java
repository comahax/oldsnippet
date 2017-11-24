package com.gmcc.pboss.common.constant.support.processor;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.common.constant.support.ConstantQueryParameter;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class ConstantQueryProcessor extends DefaultQueryParameterProcessor implements QueryParameterProcessor {
	
	/**
	 * �������
	 */
	public void process(Criteria criteria, QueryParameter parameter) {
		ConstantQueryParameter param = (ConstantQueryParameter)parameter;
		
		criteria.add(Restrictions.in("id.groupid", param.getGroupid()));
		criteria.addOrder( Property.forName("id.groupid").asc()); //��Groupid����
		criteria.addOrder( Property.forName("id.dictid").asc()); //��dictid����

	}
}
