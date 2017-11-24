/**
* auto-generated code
* Wed May 18 15:47:28 CST 2011
*/
package com.sunrise.boss.business.cms.reward.creditstd.persistent;

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
public class VproCreditstdDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public VproCreditstdDAO(){
        super(VproCreditstdVO.class);
//        super.setDbFlag("DB_COMMON", false);
    }
    
    public DataPackage query2(CreditstdListVO params1) throws Exception {
		StringBuffer sql = new StringBuffer();
//		sql.append("select  a.isdefault,a.state,a.rulemodeid ,a.cityid,a.ruleid, a.ruleitemid ,b.RULEITEMNAME ,a.paramer from ch_Adt_rulerel a,ch_adt_ruleitem b ")
//			.append(" Where a.ruleitemid=b.ruleitemid ")
//			.append(" And  a.cityid=999 ")
//			.append(" And RULEID='SALEPOINT'");
//		Session session = SessionUtil.currentSession("DB_COMMON");
		String cityid =super.getUser().getCityid();
		sql.append("Select slv,adtypecode,REWARDTYPE,creditstd,cardstd,rewardstd ")
		.append(" from CH_ADT_CREDITSTD a,CH_PW_STDREWARD b ")
		.append(" Where a.REWARDID=b.REWARDID ")
		.append(" and a.cityid=999" +
				" And b.REWARDTYPE in('61','54')" +
				"group by slv,adtypecode,REWARDTYPE,creditstd,cardstd,rewardstd ");		
		
		return  queryBySql(sql.toString(), params1);
	}
    
    public DataPackage queryStorecount(CreditstdListVO params1) throws Exception {
		StringBuffer sql = new StringBuffer();
//		sql.append("select  a.isdefault,a.state,a.rulemodeid ,a.cityid,a.ruleid, a.ruleitemid ,b.RULEITEMNAME ,a.paramer from ch_Adt_rulerel a,ch_adt_ruleitem b ")
//			.append(" Where a.ruleitemid=b.ruleitemid ")
//			.append(" And  a.cityid=999 ")
//			.append(" And RULEID='SALEPOINT'");
		String cityid =super.getUser().getCityid();
		sql.append("Select  count(*) ")
		.append(" from CH_ADT_CREDITSTD a,CH_PW_STDREWARD b ")
		.append(" Where a.REWARDID=b.REWARDID ")
		.append(" Where a.cityid="+cityid+" ) " +
				" And b.REWARDTYPE in('61') ");		
		
		return  queryBySql(sql.toString(), params1);
	}
    
    public DataPackage queryStarcount(CreditstdListVO params1) throws Exception {
		StringBuffer sql = new StringBuffer();
//		sql.append("select  a.isdefault,a.state,a.rulemodeid ,a.cityid,a.ruleid, a.ruleitemid ,b.RULEITEMNAME ,a.paramer from ch_Adt_rulerel a,ch_adt_ruleitem b ")
//			.append(" Where a.ruleitemid=b.ruleitemid ")
//			.append(" And  a.cityid=999 ")
//			.append(" And RULEID='SALEPOINT'");
		String cityid =super.getUser().getCityid();
		sql.append("Select count(*) ")
		.append(" from CH_ADT_CREDITSTD a,CH_PW_STDREWARD b ")
		.append(" Where a.REWARDID=b.REWARDID ")
		.append(" Where a.cityid="+cityid+" ) " +
				" And b.REWARDTYPE in('54') ");		
		
		return  queryBySql(sql.toString(), params1);
	}
    
}
