package com.sunrise.boss.business.cms.cityrecord.persistent;

import java.util.ArrayList;
import java.util.List;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.ui.commons.User;

public class VCityrecord4DAO extends BaseDAO {
	public VCityrecord4DAO(){
		super(VCityrecord4VO.class);
	}
	
	public DataPackage doQuerypw(VCityrecordList4VO params, User user) throws Exception{
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		StringBuilder sb = new StringBuilder();
//		SELECT ROWNUM SEQ,p.WAYID,p.OPNID,
//	 case when p.rewardtype in(1,4,6,54,51) then 2 
//	 when p.rewardtype in(2,53) then 3 
//	 else 1 end rewardtype, 
//	 case when p.OPNID like '0403%' then p.BAKINFO 
//	 else p.MOBILE end MOBILE,
//	 p.REWARDMONTH, p.OPRTIME, p.BUSIVALUE, p.PAYSUM 
//	 FROM CH_PW_REWARDRECORD P,CH_PW_WAY W  
//	 where p.WAYID=W.WAYID   
//	 and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.CHAINHEAD=:chainhead AND p.WAYID=A.WAYID ) 
//	 and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.countyid=:countyid AND p.WAYID=A.WAYID ) 
//	 and ((p.mobile=:mobile) or (p.opnid like '0403%' and p.bakinfo=:mobile)) 
//	 and p.OPNID IN(:opnid)
//	 and p.rewardmonth=:rewardmonth  and p.wayid=:wayid
//	 AND W.WAYSUBTYPE<>'ZJTY' AND W.WAYTYPE='AG' AND W.CITYID=:cityid ;
		sb.append("SELECT ROWNUM SEQ,p.WAYID,p.OPNID, ");//REWARDTYPE,
		sb.append("case ");
		sb.append(" when p.rewardtype in(1,4,6,54,51) then 2 ");
		sb.append(" when p.rewardtype in(2,53) then 3 ");
		sb.append(" else 1 ");//--where t.rewardtype in(0,3,5,7,30,55,52,60) then 1
		sb.append("end rewardtype, ");
		sb.append("  case when p.OPNID like '0403%' then p.BAKINFO "); 
		sb.append("    else p.MOBILE "); 
		sb.append("  end MOBILE, p.REWARDMONTH, p.OPRTIME, p.BUSIVALUE, p.PAYSUM "); 
		sb.append("   FROM CH_PW_REWARDRECORD P,CH_PW_WAY W  "); 
		sb.append("  where p.WAYID=W.WAYID ");
		if(params.get_se_chainhead()!=null && params.get_se_chainhead().trim().length()>0){
			sb.append("    and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.CHAINHEAD=:chainhead AND p.WAYID=A.WAYID ) "); 
			params.getQueryConditions().put("chainhead", params.get_se_chainhead());
			params.set_se_chainhead(null);
		}
		if(params.get_se_countyid()!=null && params.get_se_countyid().trim().length()>0){
			sb.append("    and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.countyid=:countyid AND p.WAYID=A.WAYID ) "); 
			params.getQueryConditions().put("countyid", params.get_se_countyid());
			params.set_se_countyid(null);
		}
		if(params.get_se_mobile()!=null && params.get_se_mobile().trim().length()>0){
			sb.append("    and ((p.mobile=:mobile) or (p.opnid like '0403%' and p.bakinfo=:mobile)) "); 
			params.getQueryConditions().put("mobile", params.get_se_mobile());
			params.set_se_mobile(null);
		}
		if(params.get_sin_opnid()!=null && params.get_sin_opnid().trim().length()>0){
			sb.append("    and P.OPNID IN(:opnid) ");
			List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = params.get_sin_opnid().trim().split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1,op.length()-1));
			}			
			params.getQueryConditions().put("opnid", sin_opnids);
			params.set_sin_opnid(null);
		}
		if(params.get_se_rewardmonth()!=null && params.get_se_rewardmonth().trim().length()>0){
			sb.append("    and p.rewardmonth=:rewardmonth ");
			params.getQueryConditions().put("rewardmonth", params.get_se_rewardmonth());
			params.set_se_rewardmonth(null);
		}
		if(params.get_se_wayid()!=null && params.get_se_wayid().trim().length()>0){
			sb.append("    and p.wayid=:wayid ");
			params.getQueryConditions().put("wayid", params.get_se_wayid());
			params.set_se_wayid(null);
		}
		sb.append(" AND W.WAYSUBTYPE<>'ZJTY' AND W.WAYTYPE='AG' AND W.CITYID=:cityid ");
		params.getQueryConditions().put("cityid", cityid);
		DataPackage dp = this.queryBySql(sb.toString(), params);
		return dp;
	}
	
	public DataPackage doQuerybbc(VCityrecordList4VO params, User user) throws Exception{
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		StringBuilder sb = new StringBuilder();
//		SELECT ROWNUM SEQ,P.WAYID,P.OPNID,
//		CASE WHEN P.REWARDTYPE=10 THEN 2 ELSE 1 END REWARDTYPE, 
//		 P.MOBILE, P.REWARDMONTH, P.OPRTIME, 1 BUSIVALUE,  P.PAYSUM  
//		 FROM CH_BBC_REWARDRECORD P,CH_PW_WAY W 
//		 WHERE W.WAYID=P.WAYID  
//		 AND EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.CHAINHEAD=:chainhead AND P.WAYID=A.WAYID ) 
//		 AND EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.COUNTYID=:countyid AND P.WAYID=A.WAYID ) 
//       AND  P.OSSRC IN (3, 4, 5)
//		 AND P.OPNID IN(:opnid) 
//		 AND W.WAYID!=:u_00000
//		 AND P.REWARDMONTH=:rewardmonth  AND P.WAYID=:wayid AND P.MOBILE=:mobile
//		 AND SUBSTR(P.BATCHNO,7)='00' --只处理正算数据
//		AND W.WAYSUBTYPE<>'ZJTY' AND W.WAYTYPE='AG' AND W.CITYID=:cityid ;
		sb.append("SELECT ROWNUM SEQ,P.WAYID,P.OPNID,");// p.REWARDTYPE,
    	sb.append("CASE WHEN P.REWARDTYPE=10 THEN 2 ELSE 1 END REWARDTYPE, ");
		sb.append(" P.MOBILE, P.REWARDMONTH, P.OPRTIME, 1 BUSIVALUE,  P.PAYSUM  ");
		sb.append("  FROM CH_BBC_REWARDRECORD P,CH_PW_WAY W ");
		sb.append("  WHERE W.WAYID=P.WAYID ");
		if(params.get_se_chainhead()!=null && params.get_se_chainhead().trim().length()>0){
			sb.append("    and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.CHAINHEAD=:chainhead AND p.WAYID=A.WAYID ) ");
			params.getQueryConditions().put("chainhead", params.get_se_chainhead());
			params.set_se_chainhead(null);
		}
		if(params.get_se_countyid()!=null && params.get_se_countyid().trim().length()>0){
			sb.append("    and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.countyid=:countyid AND p.WAYID=A.WAYID ) ");
			params.getQueryConditions().put("countyid", params.get_se_countyid());
			params.set_se_countyid(null);
		}
		sb.append("    AND  P.OSSRC IN (3, 4, 5) ");
		if(params.get_sin_opnid()!=null && params.get_sin_opnid().trim().length()>0){
			sb.append("    and P.OPNID IN(:opnid) ");
			List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = params.get_sin_opnid().trim().split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1,op.length()-1));
			}			
			params.getQueryConditions().put("opnid", sin_opnids);
			params.set_sin_opnid(null);
		}
		sb.append(" AND W.WAYID!=:u_00000 ");
		params.getQueryConditions().put("u_00000", cityid+"U_00000");//个人专员渠道
		if(params.get_se_rewardmonth()!=null && params.get_se_rewardmonth().trim().length()>0){
			sb.append("    and p.rewardmonth=:rewardmonth ");
			params.getQueryConditions().put("rewardmonth", params.get_se_rewardmonth());
			params.set_se_rewardmonth(null);
		}
		if(params.get_se_wayid()!=null && params.get_se_wayid().trim().length()>0){
			sb.append("    and p.wayid=:wayid ");
			params.getQueryConditions().put("wayid", params.get_se_wayid());
			params.set_se_wayid(null);
		}		
		if(params.get_se_mobile()!=null && params.get_se_mobile().trim().length()>0){
			sb.append("    and p.mobile=:mobile ");
			params.getQueryConditions().put("mobile", params.get_se_mobile());
			params.set_se_mobile(null);
		}
		sb.append(" AND SUBSTR(P.BATCHNO,7)='00' AND W.WAYSUBTYPE<>'ZJTY' AND W.WAYTYPE='AG' AND W.CITYID=:cityid ");
		params.getQueryConditions().put("cityid", cityid);
		return this.queryBySql(sb.toString(), params);
	}
}
