package com.gmcc.pboss.biz.info.regactInfo.support;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.exception.AssertConditionException;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.Assert;
import com.gmcc.pboss.common.util.DateUtil;

public class RegactInfoQueryParameterProcessor extends DefaultHqlQueryProcessor implements QueryParameterProcessor {
	/**
	 * 构造函数
	 */
	public RegactInfoQueryParameterProcessor() {
		paramEnclose = true; //使用参数封装
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public void process(Query query, QueryParameter parameter) {
		// TODO Auto-generated method stub

		RegactInfoQueryParameter parm = (RegactInfoQueryParameter)parameter;

		Date getSet;
		Date nextMouth;
		Date now= new Date();
		Assert.notBlank(parm.getWayid(), ServiceConditionCode.REGACTINFO_WAY, "渠道编码不存在!"); 
		query.setString("wayid", parm.getWayid());
		try{
			getSet = DateUtil.convertStringToDate("yyyyMMdd",parm.getMonth()+"01");
			nextMouth = DateUtil.DateDiff("M", getSet, 1);
			if (nextMouth.compareTo(now) > 0 ) {
				//大于当前日期的处理
				nextMouth = now;
				nextMouth.setHours(0);
				nextMouth.setMinutes(0);
				nextMouth.setSeconds(0);
			}
		}catch (ParseException e){
			throw new AssertConditionException(ServiceConditionCode.REGACT_OPRTIME_FORMAT,"月份格式不正确！");
		}
		query.setDate("oprtimeBegin", getSet);
		query.setDate("oprtimeEnd", nextMouth);

		if (!StringUtils.isBlank(parm.getMobile())){
			query.setString("mobile", parm.getMobile()+"%");
		}
	}

	public String[] getParamEncloseName() {
		// TODO Auto-generated method stub
		String [] rtn = {"noactActTime"};
		return rtn;
	}

	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.support.DefaultHqlQueryProcessor#getHql()
	 */
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		RegactInfoQueryParameter parm = (RegactInfoQueryParameter)parameter;
		String hql = "select swPartnerres,fxSnNoactinfo.activedate from FxSwPartnerres swPartnerres, FxSnNoactinfo fxSnNoactinfo " +
		"where swPartnerres.comresid = fxSnNoactinfo.mobileno and swPartnerres.wayid = :wayid " +
		"and swPartnerres.createtime >= :oprtimeBegin and swPartnerres.createtime < :oprtimeEnd";
		if (!StringUtils.isBlank(parm.getMobile())){
			hql += " and swPartnerres.comresid like :mobile";
		}
		return hql;
	}

//	public String getCntHql(QueryParameter parameter) {
//		// TODO Auto-generated method stub
//		RegactInfoQueryParameter parm = (RegactInfoQueryParameter)parameter;
//		String hql = "select count(*) from ChPwRegistedsmp registedsmp, FxSnNoactinfo fxSnNoactinfo " +
//		"where registedsmp.mobile = fxSnNoactinfo.mobileno and registedsmp.wayid = :wayid " +
//		"and registedsmp.oprtime >= :oprtimeBegin and registedsmp.oprtime < :oprtimeEnd";
//		if (!StringUtils.isBlank(parm.getMobile())){
//			hql += " and mobile like :mobile";
//		}
//		return hql;
//	}
}
