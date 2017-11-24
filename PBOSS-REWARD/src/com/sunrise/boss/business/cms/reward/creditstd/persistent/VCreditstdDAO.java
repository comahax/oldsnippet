/**
* auto-generated code
* Wed May 18 15:47:28 CST 2011
*/
package com.sunrise.boss.business.cms.reward.creditstd.persistent;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: CreditstdDAO</p>
 * <p>Description: Data Access Object for CreditstdVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class VCreditstdDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public VCreditstdDAO(){
        super(VCreditstdVO.class);
    }
    
    public DataPackage query2(CreditstdListVO params1) throws Exception {
		StringBuffer sql = new StringBuffer();
//		sql.append("select  a.isdefault,a.state,a.rulemodeid ,a.cityid,a.ruleid, a.ruleitemid ,b.RULEITEMNAME ,a.paramer from ch_Adt_rulerel a,ch_adt_ruleitem b ")
//			.append(" Where a.ruleitemid=b.ruleitemid ")
//			.append(" And  a.cityid=999 ")
//			.append(" And RULEID='SALEPOINT'");
		String cityid =super.getUser().getCityid();
//		sql.append("Select slv,slvlev,adtypecode,REWARDTYPE,count(*) as nums ")
//		.append(" from CH_ADT_CREDITSTD a,CH_PW_STDREWARD b ")
//		.append(" Where a.REWARDID=b.REWARDID ")
//		.append(" and a.cityid="+cityid+" " +
//				" And b.REWARDTYPE in('55','54')" +
//				"group by slv,slvlev,adtypecode,REWARDTYPE ");		
		
//		sql.append("select slv,slvlev,adtypecode,REWARDTYPE,nums,(select REWARDTYPE from " +
//				"(Select slv,slvlev,adtypecode,REWARDTYPE,count(*) as nums " +
//				"from CH_ADT_CREDITSTD a,CH_PW_STDREWARD b " +
//				"Where a.REWARDID=b.REWARDID " +
//				"and a.cityid="+cityid+"" +
//				"And b.REWARDTYPE in('55','54')" +
//				"group by slv,slvlev,adtypecode,REWARDTYPE) dd where dd.slv=t.slv and dd.slvlev=t.slvlev and dd.adtypecode=t.adtypecode and dd.REWARDTYPE='54') rewardtype1 " +
//				",(select nums from " +
//				"(Select slv,slvlev,adtypecode,REWARDTYPE,count(*) as nums " +
//				"from CH_ADT_CREDITSTD a,CH_PW_STDREWARD b " +
//				"Where a.REWARDID=b.REWARDID " +
//				"and a.cityid="+cityid+"" +
//				"And b.REWARDTYPE in('55','54')" +
//				"group by slv,slvlev,adtypecode,REWARDTYPE) dd where dd.slv=t.slv and dd.slvlev=t.slvlev and dd.adtypecode=t.adtypecode and dd.REWARDTYPE='54') nums1 " +
//				"from (Select slv,slvlev,adtypecode,REWARDTYPE,count(*) as nums " +
//				"from CH_ADT_CREDITSTD a,CH_PW_STDREWARD b " +
//				"Where a.REWARDID=b.REWARDID " +
//				"and a.cityid="+cityid+"" +
//				"And b.REWARDTYPE in('55','54')" +
//				"group by slv,slvlev,adtypecode,REWARDTYPE) t  ");
		sql.append(" select slv,slvlev,adtypecode,rewardtype1,nums1 ,rewardtype,nums  from   (" +
				" select nvl(jf.slv,md.slv) slv,nvl(jf.slvlev,md.slvlev) slvlev,nvl(jf.adtypecode,md.adtypecode) adtypecode,nvl(md.rewardtype,54) rewardtype1 ,nvl(md.nums,0) nums1 ," +
				" nvl(jf.rewardtype,55)  rewardtype ,nvl(jf.nums,0) nums from" +
				" (Select slv,slvlev,adtypecode,REWARDTYPE,count(*) as nums" +
				" from CH_ADT_CREDITSTD a,CH_PW_STDREWARD b " +
				" Where a.REWARDID=b.REWARDID " +
				" and a.cityid="+cityid+"" +
				" And b.REWARDTYPE =55" +
				" group by slv,slvlev,adtypecode,REWARDTYPE) jf full outer join " +
				" (Select slv,slvlev,adtypecode,REWARDTYPE,count(*) as nums" +
				" from CH_ADT_CREDITSTD a,CH_PW_STDREWARD b " +
				" Where a.REWARDID=b.REWARDID " +
				" and a.cityid="+cityid+"" +
				" And b.REWARDTYPE =54" +
				" group by slv,slvlev,adtypecode,REWARDTYPE) md on" +
				" (jf.slv = md.slv and jf.slvlev = md.slvlev and jf.adtypecode=md.adtypecode) " +
				" ) order by   slv,slvlev,adtypecode,rewardtype1,nums1 ,rewardtype,nums");
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
