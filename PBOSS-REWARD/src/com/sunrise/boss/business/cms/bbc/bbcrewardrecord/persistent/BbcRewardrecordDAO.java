/**
* auto-generated code
* Mon Dec 08 10:50:04 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.bbcrewardrecord.persistent;

import com.sunrise.boss.business.cms.bbc.bbcrewardrecord.persistent.BbcRewardrecordListVO;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: WayintegraltransruleDAO</p>
 * <p>Description: Data Access Object for WayintegraltransruleVO</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: SUNRISE Tech Ltd.</p>
 * @author Zhang Fengchao
 * @version 1.0
 */
public class BbcRewardrecordDAO extends BaseDAO {

    /**
     * default constructor
     */
    public BbcRewardrecordDAO(){
        super(BbcRewardrecordVO.class);
    }
    
    public DataPackage query(BbcRewardrecordListVO params) throws Exception{
    	return queryByNamedSqlQuery("bbcRewardrecordQuery", params);
    }
    
    public DataPackage doQuerycount(BbcRewardrecordListVO params, User user) throws Exception{
    	StringBuilder sb = new StringBuilder();
    	sb.append("select t.REWARDLISTID,t.OPERSEQ,t.DATASRC,t.OPNID,t.WAYID,t.WAYOPRCODE,t.REWARDTYPE,t.REWARDSTD,t.REWARDMONTH,");
    	sb.append("t.TOTALSUM,t.PAYSUM,t.RUNTIME,t.OPRTIME,t.NONCYC,t.OSSRC,t.MOBILE,t.BATCHNO,t.REWARDID");
    	sb.append("  from CH_BBC_REWARDRECORD t ");
    	if(params.get_se_rewardmonth()!=null && !"".equals(params.get_se_rewardmonth().trim())){
    		sb.append(" where  t.rewardmonth=  '"+params.get_se_rewardmonth().trim()+"'");
    		params.set_se_rewardmonth(null);
    	}
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			sb.append("  and t.wayid=  '"+params.get_se_wayid().trim()+"'");
			params.set_se_wayid(null);
		}
		//业务发生号码
		if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
			sb.append(" and t.mobile=  '"+params.get_se_mobile().trim()+"'");
			params.set_se_mobile(null);
		}
		//业务编码（多选）
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			sb.append(" and t.opnid in ("+params.get_sin_opnid().trim()+")");
			params.set_sin_opnid(null);
		}
		if(params.get_ne_rewardtype()!=null && !"".equals(params.get_ne_rewardtype().trim())){
			sb.append(" and t.rewardtype=  '"+params.get_ne_rewardtype().trim()+"'");
			 params.set_ne_rewardtype(null);
		}
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			sb.append(" and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.CHAINHEAD='"+params.get_se_chainhead().trim()+"'  AND t.WAYID=A.WAYID )  ");
			 params.set_se_chainhead(null);
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			sb.append(" and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.countyid='"+params.get_se_countyid().trim()+"'  AND t.WAYID=A.WAYID )  ");
			 params.set_se_countyid(null);
		}
		sb.append(" and  t.ossrc in (3,4,5)  ");
		sb.append(" and t.rewardlistid not in( SELECT nvl(REWARDLISTID,'') from CH_ADT_CITYRECORD where SYSTEMFLAG=3) ");
		
		DataPackage dp = queryBySql(sb.toString(), params, this.QUERY_TYPE_COUNT);
		
		return dp;
    }
}
