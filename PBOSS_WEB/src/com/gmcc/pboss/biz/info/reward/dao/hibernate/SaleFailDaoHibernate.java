package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.biz.info.reward.dao.SaleFailDao;
import com.gmcc.pboss.biz.info.reward.model.SaleFail;
import com.gmcc.pboss.biz.info.reward.support.RewardFailQueryParameter;

public class SaleFailDaoHibernate extends AbstractFailDaoHibernate implements SaleFailDao {

	public SaleFailDaoHibernate() {
		super(SaleFail.class);
	}
	
	final String fields = " seq, srcseq, cityid, opnid, wayid, oprcode, oprtime, mobile, brand, creattime, src, calcopnid, calcmonth, ruleid, ruleitemid, adtflag, adtcode, adtremark ";

	final String lsql = "SELECT " + fields + " FROM CH_ADT_SALEFAIL " +
			"WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and opnid = :opnid and wayid = :wayid " +
			"UNION SELECT " + fields + " FROM CH_ADT_SALEFAILHIS " +
			"WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and opnid = :opnid and wayid = :wayid";
	
	final String ssql = "SELECT " + fields + " FROM CH_ADT_SALEFAIL " +
			"WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and wayid = :wayid " +
			"UNION SELECT " + fields + " FROM CH_ADT_SALEFAILHIS " +
			"WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and wayid = :wayid";

	public String getSQL(RewardFailQueryParameter parameter) {
		if (StringUtils.isBlank(parameter.getOpnid())) {
			return ssql;
		}
		return lsql;
	}

	public String[] getFields() {
		// TODO Auto-generated method stub
		return fields.split(",");
	}
}
