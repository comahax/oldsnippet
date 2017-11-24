/**
* auto-generated code
* Tue Mar 13 17:29:11 CST 2012
*/
package com.sunrise.boss.business.cms.cityrecordtotal.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: CityrecordtotalDAO</p>
 * <p>Description: Data Access Object for CityrecordtotalVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class CityrecordtotalDAO extends BaseDAO {

    /**
     * default constructor
     */
    public CityrecordtotalDAO(){
        super(CityrecordtotalVO.class);
    }
    
    public DataPackage doQuerycnt(CityrecordtotalListVO params, User user)throws Exception{
    	String sql="  SELECT ROWNUM AS SEQID,T.* FROM ( ";
    	sql+="select t.wayid,t.opnid,t.rewardmonth,t.rewardtype , sum(busivalue) as sumbusivalue  ,sum (paysum)as sumpaysum  , " 
    		+"sum(paymoney) as sumpaymoney from  CH_ADT_CITYRECORD t where 1=1";
    	if(params.get_ne_isflag()!=null && !"".equals(params.get_ne_isflag().trim())){
			sql+=" and t.isflag="+params.get_ne_isflag().trim()+" ";
			params.set_ne_isflag(null);
		}
		if(params.get_ne_systemflag()!=null && !"".equals(params.get_ne_systemflag().trim())){
			sql+=" and t.systemflag="+params.get_ne_systemflag().trim()+" ";
			params.set_ne_systemflag(null);
		}
		if(params.get_ne_taskid()!=null && !"".equals(params.get_ne_taskid().trim())){
			 sql+=" and t.taskid=  '"+params.get_ne_taskid().trim()+"'";
			 params.set_ne_taskid(null);
		}
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			sql+="  and t.wayid=  '"+params.get_se_wayid().trim()+"'";
			params.set_se_wayid(null);
		}
		if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
		 sql+=" and t.mobile=  '"+params.get_se_mobile().trim()+"'";
		 params.set_se_mobile(null);
		}
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
		 sql+=" and t.opnid in ("+params.get_sin_opnid().trim()+")";
		 params.set_sin_opnid(null);
		}
		if(params.get_se_rewardmonth()!=null && !"".equals(params.get_se_rewardmonth().trim())){
		 sql+=" and t.rewardmonth=  '"+params.get_se_rewardmonth().trim()+"'";
		 params.set_se_rewardmonth(null);
		}
		if(params.get_ne_rewardtype()!=null && !"".equals(params.get_ne_rewardtype().trim())){
		 sql+=" and t.rewardtype=  '"+params.get_ne_rewardtype().trim()+"'";
		 params.set_ne_rewardtype(null);
		}
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			 sql+=" and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.CHAINHEAD='"+params.get_se_chainhead().trim()+"'  AND t.WAYID=A.WAYID )  ";
			 params.set_se_chainhead(null);
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			 sql+=" and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.countyid='"+params.get_se_countyid().trim()+"'  AND t.WAYID=A.WAYID )  ";
			 params.set_se_countyid(null);
		}
		sql+=" group by t.wayid,t.opnid,t.rewardmonth,t.rewardtype ";
		sql+=" order by t.wayid) T ";
		
		DataPackage dp = queryBySql(sql, params);
		
		return dp;
    }
    
}
