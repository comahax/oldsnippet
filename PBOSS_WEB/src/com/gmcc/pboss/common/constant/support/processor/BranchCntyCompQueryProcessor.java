package com.gmcc.pboss.common.constant.support.processor;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.common.constant.support.BranchCntyCompQueryParameter;
import com.gmcc.pboss.common.constant.support.ConstantQueryParameter;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class BranchCntyCompQueryProcessor extends DefaultQueryParameterProcessor implements QueryParameterProcessor {
	
	/**
	 * 处理过程
	 */
	public void process(Criteria criteria, QueryParameter parameter) {
		BranchCntyCompQueryParameter param = (BranchCntyCompQueryParameter)parameter;
		
		criteria.add(Restrictions.eq("citycompid", param.getCitycompid()));
		criteria.addOrder( Property.forName("countycompid").asc()); //按Groupid排序
	}
}
