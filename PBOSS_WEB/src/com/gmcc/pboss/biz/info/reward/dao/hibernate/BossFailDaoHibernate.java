package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.biz.info.reward.dao.BossFailDao;
import com.gmcc.pboss.biz.info.reward.model.BossFail;
import com.gmcc.pboss.biz.info.reward.support.RewardFailQueryParameter;

public class BossFailDaoHibernate extends AbstractFailDaoHibernate implements BossFailDao {

	public BossFailDaoHibernate() {
		super(BossFail.class);
	}

	final String fields = " seq, cityid, opnid, wayid, oprcode, oprtime, mobile, busivalue, brand, creattime, adtttime, src, calcopnid, calcmonth, ruleid, ruleitemid, adtflag, adtcode, adtremark, oid, srcseq ";

	final String lsql = "SELECT " + fields + " FROM CH_ADT_BOSSFAIL " +
			"WHERE adtflag in (:adtflag,:adtflag2)  and calcmonth = :calcmonth and opnid = :opnid and wayid = :wayid " +
			"UNION SELECT " + fields + " FROM CH_ADT_BOSSFAILHIS " +
			"WHERE adtflag in (:adtflag,:adtflag2)  and calcmonth = :calcmonth and opnid = :opnid and wayid = :wayid";
	final String ssql = "SELECT " + fields + " FROM CH_ADT_BOSSFAIL " +
			"WHERE adtflag in (:adtflag,:adtflag2)  and calcmonth = :calcmonth and wayid = :wayid " +
			"UNION SELECT " + fields + " FROM CH_ADT_BOSSFAILHIS " +
			"WHERE adtflag in (:adtflag,:adtflag2)  and calcmonth = :calcmonth and wayid = :wayid";

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
