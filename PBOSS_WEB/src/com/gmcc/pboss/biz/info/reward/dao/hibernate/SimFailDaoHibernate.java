package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.biz.info.reward.dao.SimFailDao;
import com.gmcc.pboss.biz.info.reward.model.SimFail;
import com.gmcc.pboss.biz.info.reward.support.RewardFailQueryParameter;

public class SimFailDaoHibernate extends AbstractFailDaoHibernate implements SimFailDao {

	public SimFailDaoHibernate() {
		super(SimFail.class);
	}
	
	private String fields = "seq, fileseq, cityid, opnid, wayid, oprcode, oprtime, " +
			"mobile, brand, location, imei, imsi, creattime, src, calcopnid, ruleid, ruleitemid, adtflag, adtcode, adtremark, calcmonth ";

	final String lsql = "SELECT " + fields + " FROM CH_ADT_SIMFAIL " +
			"WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and opnid = :opnid and wayid = :wayid " +
			"UNION SELECT " + fields + " FROM CH_ADT_SIMFAILHIS " +
			"WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and opnid = :opnid and wayid = :wayid";
	
	final String ssql ="SELECT " + fields + " FROM CH_ADT_SIMFAIL " +
			"WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and wayid = :wayid UNION"+
			" SELECT " + fields + " FROM CH_ADT_SIMFAILHIS " +
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
