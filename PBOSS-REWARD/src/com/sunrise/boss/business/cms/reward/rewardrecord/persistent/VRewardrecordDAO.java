/**
 * auto-generated code
 * Sat Feb 02 14:33:50 CST 2008
 */
package com.sunrise.boss.business.cms.reward.rewardrecord.persistent;

import java.util.ArrayList;
import java.util.List;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.ui.commons.User;



/**
 * <p>
 * Title: RewardrecordDAO
 * </p>
 * <p>
 * Description: Data Access Object for RewardrecordVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class VRewardrecordDAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public VRewardrecordDAO() {
		super(VRewardrecordVO.class);
	}
	
	//2012-7-24 shixiaolong 重写
//	public DataPackage doQuerycnt(VRewardrecordListVO params ,User user) throws Exception{
//		String sql="  SELECT ROWNUM AS SEQID,T.* FROM ( ";
//    	sql+=" select t.wayid,t.opnid,t.rewardmonth,t.rewardtype ,  sum(nvl(busivalue,0)) as sumbusivalue  ,sum(nvl(paysum,0))as sumpaysum  ,  ";
//    	sql+=" sum( case when t.paymonth1=t.rewardmonth  then paymoney1  " +
//    			" when t.paymonth2=t.rewardmonth  then paymoney2  " +
//    			" when t.paymonth3=t.rewardmonth  then paymoney3 " +
//    			" else 0 end)  as sumpaymoney  ";
//    	sql+="  from CH_PW_REWARDRECORD t ";
//    	//  isflag,systemflag,approveid 在CH_PW_REWARDRECORD没有这些字段.
////		if(params.get_ne_isflag()!=null && !"".equals(params.get_ne_isflag().trim())){
////			sql+=" where t.isflag=  '"+params.get_ne_isflag().trim()+"'";
////			params.set_ne_isflag(null);
////		}
////		if(params.get_ne_systemflag()!=null && !"".equals(params.get_ne_systemflag().trim())){
////			sql+=" and t.systemflag=  '"+params.get_ne_systemflag().trim()+"'";
////			params.set_ne_systemflag(null);
////		}
////    	if(params.get_se_approveid()!=null && !"".equals(params.get_se_approveid().trim())){
////    		sql+=" and t.approveid=  '"+params.get_se_approveid().trim()+"'";
////    		params.set_se_approveid(null);
////    	}
//    	if(params.get_se_rewardmonth()!=null && !"".equals(params.get_se_rewardmonth().trim())){
//    		sql+=" where  t.rewardmonth=  '"+params.get_se_rewardmonth().trim()+"'";
//    		params.set_se_rewardmonth(null);
//    	}
//		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
//			sql+="  and t.wayid=  '"+params.get_se_wayid().trim()+"'";
//			params.set_se_wayid(null);
//		}
//		//业务发生号码
//		if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
//		 sql+=" and t.mobile=  '"+params.get_se_mobile().trim()+"'";
//		 params.set_se_mobile(null);
//		}
//		//业务层级编码（单选）
//		if(params.getSqlopnid()!=null && !"".equals(params.getSqlopnid().trim())){
//		 sql+=" and exists (select o.opnid from ch_pw_operation o where o.opnlevel = 5 and o.opnid=t.opnid start with o.opnid = '"+params.getSqlopnid().trim()+"' connect by prior o.opnid = o.parentid ) ";
//		 params.setSqlopnid(null);
//		}
//		//业务编码（多选），这2个地方有点像
//		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
//		 sql+=" and t.opnid in ("+params.get_sin_opnid().trim()+")";
//		 params.set_sin_opnid(null);
//		}
//		if(params.get_ne_rewardtype()!=null && !"".equals(params.get_ne_rewardtype().trim())){
//		 sql+=" and t.rewardtype=  '"+params.get_ne_rewardtype().trim()+"'";
//		 params.set_ne_rewardtype(null);
//		}
//		if(params.get_ne_taskid()!=null && !"".equals(params.get_ne_taskid().trim())){
//			 sql+=" and t.taskid=  '"+params.get_ne_taskid().trim()+"'";
//			 params.set_ne_taskid(null);
//			}
//		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
//			 sql+=" and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.CHAINHEAD='"+params.get_se_chainhead().trim()+"'  AND t.WAYID=A.WAYID )  ";
//			 params.set_se_chainhead(null);
//		}
//		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
//			 sql+=" and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.countyid='"+params.get_se_countyid().trim()+"'  AND t.WAYID=A.WAYID )  ";
//			 params.set_se_countyid(null);
//		}
//		sql+=" and t.rewardlistid not in( SELECT nvl(REWARDLISTID,'') from CH_ADT_CITYRECORD where SYSTEMFLAG=2) ";
//		sql+=" group by t.wayid,t.opnid,t.rewardmonth,t.rewardtype ";
//		sql+=" ) T ";//order by t.wayid
//		params.set_orderby("wayid");
//		params.set_desc("0");
//		
//		DataPackage dp = queryBySql(sql, params);
//		
//		return dp;
//    }
	
	//2012-7-24 shixiaolong 重写
	public DataPackage doQuerycnt(VRewardrecordListVO params ,User user) throws Exception{
		if(params.get_se_rewardmonth()==null && "".equals(params.get_se_rewardmonth().trim())){
    		throw new Exception("结算月份不能为空");
    	}
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ROWNUM AS SEQID, T.* ");
		sb.append("  FROM (select t.wayid,t.opnid,t.rewardmonth,t.rewardtype, ");
		sb.append("               sum(nvl(busivalue, 0)) as sumbusivalue,sum(nvl(paysum, 0)) as sumpaysum, ");
		sb.append("               sum(case when t.paymonth1 = :rewardmonth then paymoney1 ");
		sb.append("                     when t.paymonth2 = :rewardmonth then paymoney2 ");
		sb.append("                     when t.paymonth3 = :rewardmonth then paymoney3 ");
		sb.append("                     else 0 end) as sumpaymoney ");
		sb.append("          from CH_PW_REWARDRECORD t ,ch_pw_way w ");
		sb.append("         where t.wayid=w.wayid and not exists (SELECT 1 from CH_ADT_CITYRECORD c ");
		sb.append("                 where t.REWARDLISTID = c.REWARDLISTID and c.SYSTEMFLAG = 2 ");//and c.rewardmonth=:rewardmonth 
		sb.append("                ) ");
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			sb.append("           and EXISTS(SELECT 1 FROM CH_PW_WAY A WHERE A.CHAINHEAD = :chainhead AND t.WAYID = A.WAYID) ");
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			sb.append("           and EXISTS(SELECT 1 FROM CH_PW_WAY A WHERE A.countyid = :countyid AND t.WAYID = A.WAYID) ");
		}		
		//业务编码（多选），这2个地方有点像
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			sb.append("           and t.opnid in (:sinopnid) ");
		}
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			sb.append("           and t.wayid = :wayid ");
		}
		if(params.get_ne_rewardtype()!=null && !"".equals(params.get_ne_rewardtype().trim())){
			sb.append("           and t.rewardtype = :rewardtype ");
		}
		sb.append("           and t.rewardmonth = :rewardmonth ");
		//业务发生号码
		if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
			sb.append("           and t.mobile = :mobile "); 
		}  
		sb.append(" and w.waysubtype<>'ZJTY' and w.waytype='AG' and w.cityid=:cityid ");
		sb.append(" group by t.wayid, t.opnid, t.rewardmonth, t.rewardtype ");
		sb.append(" order by t.wayid, t.opnid, t.rewardmonth, t.rewardtype ) T  ");
		
		params.getQueryConditions().put("rewardmonth", params.get_se_rewardmonth().trim());
		params.getQueryConditions().put("cityid", cityid);
    	params.set_se_rewardmonth(null);
    	if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
    		params.getQueryConditions().put("wayid", params.get_se_wayid().trim());
			params.set_se_wayid(null);
		}
		//业务发生号码
		if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
			params.getQueryConditions().put("mobile", params.get_se_mobile().trim());
			params.set_se_mobile(null);
		}
//		//业务层级编码（单选）
//		if(params.getSqlopnid()!=null && !"".equals(params.getSqlopnid().trim())){
//			params.getQueryConditions().put("opnid", params.getSqlopnid().trim());
//			params.setSqlopnid(null);
//		}
		//业务编码（多选），这2个地方有点像
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = params.get_sin_opnid().trim().split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1,op.length()-1));
			}			
			params.getQueryConditions().put("sinopnid", sin_opnids);
			params.set_sin_opnid(null);
		}
		if(params.get_ne_rewardtype()!=null && !"".equals(params.get_ne_rewardtype().trim())){
			params.getQueryConditions().put("rewardtype", params.get_ne_rewardtype().trim());
			params.set_ne_rewardtype(null);
		}
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			 params.getQueryConditions().put("chainhead", params.get_se_chainhead().trim());
			 params.set_se_chainhead(null);
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			 params.getQueryConditions().put("countyid", params.get_se_countyid().trim());
			 params.set_se_countyid(null);
		}
		
		DataPackage dp = queryBySql(sb.toString(), params);
		
		return dp;
    }
	
}
