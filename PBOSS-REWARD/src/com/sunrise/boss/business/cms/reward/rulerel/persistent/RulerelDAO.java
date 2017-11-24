/**
* auto-generated code
* Wed Sep 10 11:22:49 CST 2008
*/
package com.sunrise.boss.business.cms.reward.rulerel.persistent;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: RulerelDAO</p>
 * <p>Description: Data Access Object for RulerelVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RulerelDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public RulerelDAO(){
        super(RulerelVO.class);
    }
    
	/**
	 * ºÏ≤ÈRulerelµƒ“¿¿µÀ≥–Ú,
	 * @throws Exception
	 */
	public List checkRulerelOrder(String ruleid) throws Exception {
		StringBuffer sql = new StringBuffer();
		String region = super.getUser().getCityid();
		sql.append("SELECT DISTINCT A.RULEID as RULEID, B.REWARDTYPE AS REWARDTYPE from CH_PW_STDREWARDBJ A, CH_PW_STDREWARD B ")
			.append("WHERE A.REWARDID = B.REWARDID ")
			.append("AND OPNID IN (SELECT OPNID FROM CH_PW_STDREWARDBJ WHERE RULEID = '"+ruleid+"' AND REGION = '"+region+"') AND REGION = '"+region+"'");
		
		Session session = SessionUtil.currentSession(this.getDbFlag());
		SQLQuery countQuery=session.createSQLQuery(sql.toString());
		countQuery.addScalar("RULEID", Hibernate.STRING);
		countQuery.addScalar("REWARDTYPE", Hibernate.INTEGER);
		List list = countQuery.list();
		return list;
	}
	
	public DataPackage showRulerel(RulerelListVO params1) throws Exception {
		StringBuffer sql = new StringBuffer();
//		sql.append("select  a.isdefault,a.state,a.rulemodeid ,a.cityid,a.ruleid, a.ruleitemid ,b.RULEITEMNAME ,a.paramer from ch_Adt_rulerel a,ch_adt_ruleitem b ")
//			.append(" Where a.ruleitemid=b.ruleitemid ")
//			.append(" And  a.cityid=999 ")
//			.append(" And RULEID='SALEPOINT'");
		String cityid =super.getUser().getCityid();
		sql.append("select distinct  a.isdefault,a.state,a.rulemodeid ,a.cityid,a.ruleid, a.ruleitemid ,b.RULEITEMNAME ,a.paramer ,")
		.append("( select  dd.paramer  from  ch_Adt_rulerel dd where dd.ruleitemid = a.ruleitemid and dd.ruleid = a.ruleid and dd.cityid="+cityid+" )  paramercityvalue")
		.append(" from ch_Adt_rulerel a,ch_adt_ruleitem b ")
		.append(" Where a.ruleitemid=b.ruleitemid ")
		.append(" And  a.cityid=999 ")
		.append(" And RULEID='SALEPOINT'");		
		
		return  queryBySql(sql.toString(), params1);
	}
    
	public DataPackage showRulerel2(RulerelListVO params1) throws Exception {
		StringBuffer sql = new StringBuffer();
//		sql.append("select  a.isdefault,a.state,a.rulemodeid ,a.cityid,a.ruleid, a.ruleitemid ,b.RULEITEMNAME ,a.paramer from ch_Adt_rulerel a,ch_adt_ruleitem b ")
//			.append(" Where a.ruleitemid=b.ruleitemid ")
//			.append(" And  a.cityid=999 ")
//			.append(" And RULEID='SALEPOINT'");
		String cityid =super.getUser().getCityid();
		sql.append("select  a.isdefault,a.state,a.rulemodeid ,a.cityid,a.ruleid, a.ruleitemid ,b.RULEITEMNAME ,a.paramer ,")
		.append("( select  dd.paramer  from  ch_Adt_rulerel dd where dd.ruleitemid = a.ruleitemid and dd.ruleid = a.ruleid and dd.cityid="+cityid+" )  paramercityvalue")
		.append(" from ch_Adt_rulerel a,ch_adt_ruleitem b ")
		.append(" Where a.ruleitemid=b.ruleitemid ")
		.append(" And  a.cityid=999 ")
		.append(" And RULEID='ASSESSPOINT'");		
		
		return  queryBySql(sql.toString(), params1);
	}
	
	public DataPackage showRulerelByRuleid(RulerelListVO params1) throws Exception {
		StringBuffer sql = new StringBuffer();
//		sql.append("select  a.isdefault,a.state,a.rulemodeid ,a.cityid,a.ruleid, a.ruleitemid ,b.RULEITEMNAME ,a.paramer from ch_Adt_rulerel a,ch_adt_ruleitem b ")
//			.append(" Where a.ruleitemid=b.ruleitemid ")
//			.append(" And  a.cityid=999 ")
//			.append(" And RULEID='SALEPOINT'");
		String cityid =super.getUser().getCityid();
		sql.append("select  a.isdefault,a.state,a.rulemodeid ,a.cityid,a.ruleid, a.ruleitemid ,b.RULEITEMNAME ,a.paramer ,")
		.append("( select  dd.paramer  from  ch_Adt_rulerel dd where dd.ruleitemid = a.ruleitemid and dd.ruleid = a.ruleid and dd.cityid="+cityid+" )  paramercityvalue")
		.append(" from ch_Adt_rulerel a,ch_adt_ruleitem b ")
		.append(" Where a.ruleitemid=b.ruleitemid ")
		.append(" And  a.cityid=999 ");
		
		return  queryBySql(sql.toString(), params1);
	}
	
}
