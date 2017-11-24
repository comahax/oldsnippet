package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.biz.info.reward.dao.BbcSellFailDao;
import com.gmcc.pboss.biz.info.reward.model.BbcSellFail;
import com.gmcc.pboss.biz.info.reward.support.RewardFailQueryParameter;

public class BbcSellFailDaoHibernate extends AbstractFailDaoHibernate implements BbcSellFailDao {

	public BbcSellFailDaoHibernate() {
		super(BbcSellFail.class);
	}

	final String fields = " seq, cityid, opnid, wayid, oprcode, oprtime, mobile, busivalue, creattime, adtttime, src, calcopnid, calcmonth, ruleid, adtflag, adtcode, adtremark, srcseq, noncyc ";

	final String lsql = "SELECT " + fields + " FROM CH_BBC_SELLFAIL " +
			"WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and wayid = :wayid and opnid = :opnid " +
			"UNION SELECT " + fields + " FROM CH_BBC_SELLFAILHIS " +
					"WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and wayid = :wayid and opnid = :opnid";

	final String ssql = "SELECT " + fields + " FROM CH_BBC_SELLFAIL " +
			"WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and wayid = :wayid " +
			"UNION SELECT "+ fields + " FROM CH_BBC_SELLFAILHIS " +
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
