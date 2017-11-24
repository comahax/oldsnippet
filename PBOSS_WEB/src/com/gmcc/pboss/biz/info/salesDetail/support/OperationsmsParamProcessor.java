package com.gmcc.pboss.biz.info.salesDetail.support;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class OperationsmsParamProcessor implements QueryParameterProcessor {

	public void process(Criteria criteria, QueryParameter parameter) {
		// TODO Auto-generated method stub
		OperationsmsParameter p = (OperationsmsParameter)parameter;
		criteria.add(Property.forName("id.cityid").eq(p.getCityid()));
		//short opntype = 2;
		String smsno = "10086111";
		criteria.add(Property.forName("id.opntype").eq(p.getOpntype()));
		criteria.add(Property.forName("id.smsno").eq(smsno));
		if(StringUtils.isNotEmpty(p.getOpnid())){
			criteria.add(Property.forName("id.opnid").like(p.getOpnid().trim(),MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotEmpty(p.getOpnname())){
			criteria.add(Property.forName("opnname").like(p.getOpnname().trim(),MatchMode.ANYWHERE));
		}
	}

	public void process(Query query, QueryParameter parameter) {
		// TODO Auto-generated method stub

	}

}
