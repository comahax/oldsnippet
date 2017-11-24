package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.biz.info.reward.dao.BossJlFailDao;
import com.gmcc.pboss.biz.info.reward.model.BossJlFail;
import com.gmcc.pboss.biz.info.reward.support.RewardFailQueryParameter;

public class BossJlFailDaoHibernate extends AbstractFailDaoHibernate implements BossJlFailDao {

	public BossJlFailDaoHibernate() {
		super(BossJlFail.class);
	}

	final String fields = " seq, srcseq, ruleid, ruleitemid, opnid, calcopnid, wayid, oprcode, oprtime, mobile, busivalue, wrapfee, noncyc, rewardtype, calcmonth, datasource, calcflag, calcremark, createtime, wadttime, updatetime, adtflag, adtcode, adtremark, oid ";

	final String lsql = "SELECT " + fields + " FROM CH_ADT_BOSSJLFAIL " +
			"WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and opnid = :opnid and wayid = :wayid " +
			"UNION SELECT " + fields + " FROM CH_ADT_BOSSJLFAILHIS " +
					"WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and opnid = :opnid and wayid = :wayid";
	
	final String ssql = "SELECT " + fields + " FROM CH_ADT_BOSSJLFAIL " +
			"WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and wayid = :wayid " +
			"UNION SELECT " + fields + " FROM CH_ADT_BOSSJLFAILHIS " +
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
