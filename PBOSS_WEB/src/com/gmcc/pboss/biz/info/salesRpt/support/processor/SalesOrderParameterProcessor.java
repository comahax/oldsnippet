package com.gmcc.pboss.biz.info.salesRpt.support.processor;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.info.salesRpt.support.SalesOrderQueryParameter;
import com.gmcc.pboss.common.exception.AssertConditionException;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.Assert;
import com.gmcc.pboss.common.util.DateUtil;

public class SalesOrderParameterProcessor extends DefaultQueryParameterProcessor implements QueryParameterProcessor {

	public void process(Criteria criteria, QueryParameter parameter) {
		SalesOrderQueryParameter param = (SalesOrderQueryParameter) parameter;

		Assert.notBlank(param.getWayid(), ServiceConditionCode.SALES_WAY, "�������벻��Ϊ�գ�");
		
//		Assert.notBlank(param.getComType(), ServiceConditionCode.SALES_COMTYPE, "��Ʒ���಻��Ϊ�գ�");
		
		criteria.add(Restrictions.eq("wayid", param.getWayid()));
		
		if (StringUtils.isNotEmpty(param.getOrderid())){
			criteria.add(Restrictions.like("orderid", param.getOrderid()+"%"));
		}
		
		//��ѯʱ��
		if (StringUtils.isNotBlank(param.getMonth())){
			Date getSet;
			Date nextMouth;
			try{
				getSet = DateUtil.convertStringToDate("yyyyMMdd",param.getMonth()+"01");
				nextMouth = DateUtil.DateDiff("M", getSet, 1);
			}catch (ParseException e){
				throw new AssertConditionException(ServiceConditionCode.REGACT_OPRTIME_FORMAT,"�·ݸ�ʽ����ȷ��");
			}
			criteria.add(Restrictions.ge("createtime", getSet));
			criteria.add(Restrictions.lt("createtime", nextMouth));
		}
		
		//����״̬
		if (StringUtils.isNotBlank(param.getOrderstate())){
			criteria.add(Restrictions.eq("orderstate", param.getOrderstate()));
		}
		
		criteria.addOrder(Order.desc("createtime"));
	}//process

}
