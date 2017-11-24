package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.biz.info.reward.dao.JmjtFailDao;
import com.gmcc.pboss.biz.info.reward.model.JmjtFail;
import com.gmcc.pboss.biz.info.reward.support.RewardFailQueryParameter;

public class JmjtFailDaoHibernate extends AbstractFailDaoHibernate implements JmjtFailDao {

	public JmjtFailDaoHibernate() {
		super(JmjtFail.class);
	}
	
	final String fields = " seq, oldseq, fileseq, cityid, opnid, wayid, oprcode, oprtime, mobile, brand, location, imei, imsi, creattime, src, calcopnid, ruleid, ruleitemid, adtflag, adtcode, adtremark, calcmonth ";

	final String lsql = "SELECT " + fields + " FROM CH_ADT_JMJTFAIL " +
			"WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and opnid = :opnid and wayid = :wayid " +
			"UNION SELECT " + fields + " FROM CH_ADT_JMJTFAILHIS " +
					"WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and opnid = :opnid and wayid = :wayid";
	
	final String ssql = "SELECT " + fields + " FROM CH_ADT_JMJTFAIL" +
			" WHERE adtflag in (:adtflag,:adtflag2) and calcmonth = :calcmonth and wayid = :wayid " +
			"UNION SELECT " + fields + " FROM CH_ADT_JMJTFAILHIS " +
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
