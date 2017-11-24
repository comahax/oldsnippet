package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.biz.info.reward.dao.BbcE100FailDao;
import com.gmcc.pboss.biz.info.reward.model.BbcE100Fail;
import com.gmcc.pboss.biz.info.reward.support.RewardFailQueryParameter;

public class BbcE100FailDaoHibernate extends AbstractFailDaoHibernate implements BbcE100FailDao {

	public BbcE100FailDaoHibernate() {
		super(BbcE100Fail.class);
	}

	final String fields = " seq, cityid, opnid, wayid, oprcode, oprtime, mobile, busivalue, creattime, adtttime, src, calcopnid, calcmonth, ruleid, adtflag, adtcode, adtremark, srcseq, noncyc ";

	final String lsql = "SELECT " + fields + " FROM CH_BBC_E100FAIL " +
			"WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and wayid = :wayid and opnid = :opnid " +
			"UNION SELECT " + fields + " FROM CH_BBC_E100FAILHIS " +
					"WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and wayid = :wayid and opnid = :opnid";
	
	final String ssql = "SELECT " + fields + " FROM CH_BBC_E100FAIL " +
			"WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and wayid = :wayid " +
			"UNION SELECT " + fields + " FROM CH_BBC_E100FAILHIS " +
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
