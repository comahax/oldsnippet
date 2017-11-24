/**
* auto-generated code
* Thu Dec 15 07:12:07 GMT 2011
*/
package com.sunrise.boss.business.cms.cityrecord.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.cms.cityrecord.CityrecordAction;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: CityrecordDAO</p>
 * <p>Description: Data Access Object for CityrecordVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class VCityrecord3DAO extends BaseDAO {

    /**
     * default constructor
     */
    public VCityrecord3DAO(){
        super(VCityrecord3VO.class);
    }
    
    public DataPackage listissueconfirmdetail(VCityrecordList3VO params,User user) throws Exception{    	
		String wayid = params.get_se_wayid();
    	String rewardmonth = params.get_se_rewardmonth();
    	String systemflag = params.get_ne_systemflag();
    	String sin_opnid=params.get_sin_opnid();
    	String isflag=params.get_ne_isflag();
    	String taskid=params.get_ne_taskid();    	
		String paymonth = params.get_se_paymonth();
		String countyid = params.get_se_countyid();
		
		StringBuilder sb = new StringBuilder();
		sb.append(" select r.recordid,r.isflag,r.systemflag,r.wayid,r.opnid,r.rewardtype,r.mobile,r.rewardmonth,r.oprtime,r.busivalue,r.paymoney,r.paysum ");
		sb.append("  from ch_pw_way w," +
				" (select o.opnid from ch_pw_operation o" +
				" where o.opnlevel=5 " +
				" start with o.opnid='"+params.get_se_opnid().trim()+
				"' connect by prior o.opnid=o.parentid) o, " +
				" ch_adt_cityrecord r" +
				" where r.opnid=o.opnid and w.wayid=r.wayid " +
				"and r.isflag=" + isflag+
				" and r.rewardtype ='"+params.get_ne_rewardtype().trim()+
				"' and to_char(r.oprtime, 'yyyyMM') ='"+params.get_de_oprtime().trim()+"'");
	
		 //明细确认opnid2，rewardtype，oprmonth，isflag是由那一条明细数据带进来的。前台查询条件需提出，结算状态、业务大类、业务小类
		params.set_se_opnid(null);
		params.set_ne_rewardtype(null);
		params.set_de_oprtime(null);
		params.set_ne_isflag(null);
//		if(isflag!=null && isflag.trim().length()>0){    
//			sb.append(" and r.isflag="+isflag);
//			params.set_ne_isflag(null);
//		}else{			sb.append(" and r.isflag in (0,1) ");		}//isflag 只有0和1两个取值，2已删除
		if(wayid!=null && !"".equals(wayid.trim())){
			sb.append("   and r.wayid='"+wayid.trim()+"'");	
			params.set_se_wayid(null);
		}
		if(rewardmonth!=null && !"".equals(rewardmonth.trim())){
			sb.append("   and r.rewardmonth='"+rewardmonth.trim()+"'");	
			params.set_se_rewardmonth(null);
		}
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sb.append("   and r.systemflag='"+systemflag.trim()+"'");
			params.set_ne_systemflag(null);
		} 
		if(taskid!=null && !"".equals(taskid.trim())){
			sb.append("   and r.taskid="+taskid);
			params.set_ne_taskid(null);
		}
		if(sin_opnid!=null && !"".equals(sin_opnid.trim())){
			sb.append("   and r.opnid="+sin_opnid);
			params.set_sin_opnid(null);
		}
		if(countyid!=null && !"".equals(countyid.trim())){
			sb.append("   and r.countyid="+countyid);
			params.set_se_countyid(null);
		}
		//新增付款月份
		if (new CityrecordAction().isSupportPaymonth(user)){
			if(paymonth!=null && !"".equals(paymonth.trim())){
				sb.append("       and r.paymonth ="+paymonth); 
    			params.set_se_paymonth(null);
			}
		}
		sb.append("   order by r.oprtime desc");
		return queryBySql(sb.toString(), params);
		
	}

}
