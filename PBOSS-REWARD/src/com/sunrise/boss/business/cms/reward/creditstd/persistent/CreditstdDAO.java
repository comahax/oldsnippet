/**
* auto-generated code
* Wed May 18 15:47:28 CST 2011
*/
package com.sunrise.boss.business.cms.reward.creditstd.persistent;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: CreditstdDAO</p>
 * <p>Description: Data Access Object for CreditstdVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class CreditstdDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public CreditstdDAO(){
        super(CreditstdVO.class);
    }
    
    public DataPackage query2(CreditstdListVO params1) throws Exception {
		StringBuffer sql = new StringBuffer();
//		sql.append("select  a.isdefault,a.state,a.rulemodeid ,a.cityid,a.ruleid, a.ruleitemid ,b.RULEITEMNAME ,a.paramer from ch_Adt_rulerel a,ch_adt_ruleitem b ")
//			.append(" Where a.ruleitemid=b.ruleitemid ")
//			.append(" And  a.cityid=999 ")
//			.append(" And RULEID='SALEPOINT'");
		String cityid =super.getUser().getCityid();
		sql.append("Select seq,cityid,slv,creditstd,cardstd,adtypecode,slvlev,coreward,subsidy,accoutreward,rewardstd,rewardid,ruleid,intvmonth,islimit ")
		.append(" from CH_ADT_CREDITSTD a,CH_PW_STDREWARD b ")
		.append(" Where a.REWARDID=b.REWARDID ")
		.append(" and a.cityid="+cityid+" " +
				" And b.REWARDTYPE in('55','54')" +
				"group by slv,slvlev,adtypecode,REWARDTYPE ");		
		
		return  queryBySql(sql.toString(), params1);
	}
    
    //查询积分标准补贴：
    public DataPackage queryStar(CreditstdListVO params1) throws Exception {
		StringBuffer sql = new StringBuffer();
//		sql.append("select  a.isdefault,a.state,a.rulemodeid ,a.cityid,a.ruleid, a.ruleitemid ,b.RULEITEMNAME ,a.paramer from ch_Adt_rulerel a,ch_adt_ruleitem b ")
//			.append(" Where a.ruleitemid=b.ruleitemid ")
//			.append(" And  a.cityid=999 ")
//			.append(" And RULEID='SALEPOINT'");
		String cityid =super.getUser().getCityid();
		sql.append("Select seq,cityid,slv,creditstd,cardstd,adtypecode,slvlev,coreward,subsidy,accoutreward,rewardstd,a.rewardid,ruleid,intvmonth,islimit ")
		.append(" from CH_ADT_CREDITSTD a,CH_PW_STDREWARD b ")
		.append(" Where a.REWARDID=b.REWARDID ")
		.append(" and a.cityid="+cityid+" " +
				" And b.REWARDTYPE in('55') ");		
		
		return  queryBySql(sql.toString(), params1);
	}
    
    //查询门店补贴：
    public DataPackage queryStore(CreditstdListVO params1) throws Exception {
		StringBuffer sql = new StringBuffer();
//		sql.append("select  a.isdefault,a.state,a.rulemodeid ,a.cityid,a.ruleid, a.ruleitemid ,b.RULEITEMNAME ,a.paramer from ch_Adt_rulerel a,ch_adt_ruleitem b ")
//			.append(" Where a.ruleitemid=b.ruleitemid ")
//			.append(" And  a.cityid=999 ")
//			.append(" And RULEID='SALEPOINT'");
		String cityid =super.getUser().getCityid();
		sql.append("Select seq,cityid,slv,creditstd,cardstd,adtypecode,slvlev,coreward,subsidy,accoutreward,rewardstd,a.rewardid,ruleid,intvmonth,islimit ")
		.append(" from CH_ADT_CREDITSTD a,CH_PW_STDREWARD b ")
		.append(" Where a.REWARDID=b.REWARDID ")
		.append(" and a.cityid="+cityid+"  " +
				" And b.REWARDTYPE in('54') ");		
		
		return  queryBySql(sql.toString(), params1);
	}
    
    public DataPackage queryPro(CreditstdListVO params1) throws Exception {
    	return null;
    }
    
    
    public Double sumOpprewardtype(CreditstdListVO params1) throws Exception {
    	Session session = SessionUtil.currentSession(getDbFlag());
		Query query = session.getNamedQuery("sumopprewardtype");
		query.setShort("rewardtype", Short.valueOf(params1.get_ne_rewardtype()));
		query.setLong("slv", Long.valueOf(params1.get_ne_slv()));
		query.setLong("slvlev",Long.valueOf(params1.get_ne_slvlev()) );
		query.setLong("adtypecode",Long.valueOf(params1.get_ne_adtypecode()) );
		query.setLong("cityid",Long.valueOf(params1.get_ne_cityid()) );
		return (Double)query.uniqueResult();
    }
    public Double sumOpprewardtype4singlton(CreditstdListVO params1) throws Exception {
    	Session session = SessionUtil.currentSession(getDbFlag());
		Query query = session.getNamedQuery("sumopprewardtype4singlton");
//		query.setShort("rewardtype", Short.valueOf(params1.get_ne_rewardtype()));
		query.setLong("slv", Long.valueOf(params1.get_ne_slv()));
		query.setLong("slvlev",Long.valueOf(params1.get_ne_slvlev()) );
		query.setLong("adtypecode",Long.valueOf(params1.get_ne_adtypecode()) );
		query.setLong("cityid",Long.valueOf(params1.get_ne_cityid()) );
		query.setString("ruleid",params1.get_nne_ruleid() );
		query.setLong("intvmonth",Long.valueOf(params1.get_nne_intvmonth()) );
		return (Double)query.uniqueResult();
    }
    
    public boolean checkhasALevel(CreditstdListVO params1) throws Exception {
    	Session session = SessionUtil.currentSession(getDbFlag());
		Query query = session.getNamedQuery("checkalevel");
		query.setShort("rewardtype", Short.valueOf(params1.get_ne_rewardtype()));
		query.setLong("slv", Long.valueOf(params1.get_ne_slv()));
		query.setLong("slvlev",Long.valueOf(params1.get_ne_slvlev()) );
		query.setLong("adtypecode",Long.valueOf(params1.get_ne_adtypecode()) );
		query.setLong("cityid",Long.valueOf(params1.get_ne_cityid()) );
		List list=query.list();
		if(list.size()>0){
			return true;
		}
		return false;
    }
    
    public DataPackage doQuery4cqjl(CreditstdListVO params1) throws Exception {
		StringBuffer sql = new StringBuffer();
		String cityid =super.getUser().getCityid();
//		sql.append(" select SLV, INTVMONTH, rewardstd ")
		sql.append(" select a.* ")
		.append("   from ch_adt_creditstd a, ch_pw_stdreward b ")
		.append(" Where a.cityid = "+ cityid +" ")
		.append("  And a.REWARDID = b. REWARDID ")
		.append(" and b. REWARDTYPE = 60 ");		
		
		return  queryBySql(sql.toString(), params1);
    }
}
