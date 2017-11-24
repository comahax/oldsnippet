/**
* auto-generated code
* Mon Jan 09 12:05:49 CST 2012
*/
package com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BbcRewardrecord2DAO</p>
 * <p>Description: Data Access Object for BbcRewardrecord2VO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class VBbcRewardrecord2DAO extends BaseDAO {

    /**
     * default constructor
     */
    public VBbcRewardrecord2DAO(){
        super(VBbcRewardrecord2VO.class);
    }
    
    public DataPackage doQuerycnt(VBbcRewardrecord2ListVO params ,User user) throws Exception{
    	String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
//    	SELECT ROWNUM AS SEQID, T.*
//    	  FROM (select t.wayid,t.opnid,t.rewardmonth,t.rewardtype,count(*) as sumbusivalue,
//    	               sum(nvl(paysum, 0)) as sumpaysum,sum(nvl(paysum, 0)) as sumpaymoney
//    	          from CH_BBC_REWARDRECORD t,ch_pw_way w
//    	         where t.wayid=w.wayid            
//    	           and t.opnid in (:opnid)           
//    	           and EXISTS (SELECT WAYID FROM CH_PW_WAY A WHERE A.CHAINHEAD = :chainhead AND t.WAYID = A.WAYID)
//    	           and EXISTS (SELECT WAYID FROM CH_PW_WAY A WHERE A.countyid = :countyid AND t.WAYID = A.WAYID)
//    	           and t.ossrc in (3, 4, 5)
//    	           --and t.rewardlistid not in(SELECT nvl(REWARDLISTID, '') from CH_ADT_CITYRECORD where SYSTEMFLAG = 3)
//    	           and not exists (select 1 from CH_ADT_CITYRECORD cr where cr.SYSTEMFLAG = 3 and cr.REWARDLISTID=t.rewardlistid)
//                 and substr(t.batchno,7)='00'
//    	           and t.rewardtype = :rewardtype
//    	           and t.rewardmonth = :rewardmonth
//    	           and t.wayid = :wayid
//    	           and t.mobile = :mobile
//    	           and w.wayid<>'ZSU_00000' and w.waysubtype<>'ZJTY' and w.waytype='AG' and w.cityid=:cityid
//    	         group by t.wayid, t.opnid, t.rewardmonth, t.rewardtype
//    	         order by t.wayid, t.opnid, t.rewardmonth, t.rewardtype) T ;
    	StringBuilder sb = new StringBuilder();
    	sb.append("SELECT ROWNUM AS SEQID, T.*");
    	sb.append("  FROM (select t.wayid,t.opnid,t.rewardmonth,t.rewardtype,count(*) as sumbusivalue,");
    	sb.append("               sum(nvl(paysum, 0)) as sumpaysum,sum(nvl(paysum, 0)) as sumpaymoney");
    	sb.append("          from CH_BBC_REWARDRECORD t,ch_pw_way w");
    	sb.append("         where t.wayid=w.wayid");
    	//业务编码（多选）
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			 sb.append(" and t.opnid in ("+params.get_sin_opnid().trim()+")");
			 params.set_sin_opnid(null);
		}
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			 sb.append(" and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.CHAINHEAD=:chainhead AND t.WAYID=A.WAYID )  ");
			 params.getQueryConditions().put("chainhead", params.get_se_chainhead().trim());
			 params.set_se_chainhead(null);
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			 sb.append(" and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.countyid=:countyid AND t.WAYID=A.WAYID )  ");
			 params.getQueryConditions().put("countyid", params.get_se_countyid().trim());
			 params.set_se_countyid(null);
		}
    	sb.append(" and  t.ossrc in (3,4,5)  ");
    	//sql+=" and t.rewardlistid not in( SELECT nvl(REWARDLISTID,'') from CH_ADT_CITYRECORD where SYSTEMFLAG=3) ";
    	sb.append(" and not exists (select 1 from CH_ADT_CITYRECORD cr where cr.SYSTEMFLAG = 3 and cr.REWARDLISTID=t.rewardlistid) ");
    	sb.append(" and substr(t.batchno,7)='00' ");//只处理正算数据
    	if(params.get_ne_rewardtype()!=null && !"".equals(params.get_ne_rewardtype().trim())){
	   		sb.append(" and t.rewardtype=:rewardtype ");
	   		params.getQueryConditions().put("rewardtype", params.get_ne_rewardtype().trim());
	   		params.set_ne_rewardtype(null);
   		}  
    	if(params.get_se_rewardmonth()!=null && !"".equals(params.get_se_rewardmonth().trim())){
    		sb.append(" and t.rewardmonth=:rewardmonth ");
    		params.getQueryConditions().put("rewardmonth", params.get_se_rewardmonth().trim());
    		params.set_se_rewardmonth(null);
    	}
    	if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			sb.append("  and t.wayid=:wayid ");
			params.getQueryConditions().put("wayid", params.get_se_wayid().trim());
			params.set_se_wayid(null);
		}
		//业务发生号码
		if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
			sb.append(" and t.mobile=:mobile ");
			params.getQueryConditions().put("mobile", params.get_se_mobile().trim());
			params.set_se_mobile(null);
		}    	
    	sb.append("           and w.wayid<>:u_00000 and w.waysubtype<>'ZJTY' and w.waytype='AG' and w.cityid=:cityid ");
    	params.getQueryConditions().put("cityid", cityid);
    	params.getQueryConditions().put("u_00000", cityid+"U_00000");//个人专员渠道
    	sb.append("         group by t.wayid, t.opnid, t.rewardmonth, t.rewardtype ");
    	sb.append("         order by t.wayid, t.opnid, t.rewardmonth, t.rewardtype) T ");
		
		DataPackage dp = queryBySql(sb.toString(), params);		
		return dp;
    }
    
}
