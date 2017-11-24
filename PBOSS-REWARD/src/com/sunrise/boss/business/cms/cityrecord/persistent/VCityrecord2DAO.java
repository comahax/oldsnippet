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
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: CityrecordDAO</p>
 * <p>Description: Data Access Object for CityrecordVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class VCityrecord2DAO extends BaseDAO {

    /**
     * default constructor
     */
    public VCityrecord2DAO(){
        super(VCityrecord2VO.class);
    }
    
    public DataPackage onlysum(VCityrecordList2VO params,User user) throws Exception{
    	
		String wayid = params.get_se_wayid();
    	String waylike = params.get_se_waylike();
    	String month = params.get_se_rewardmonth();
    	String systemflag = params.get_ne_systemflag();
//    	String opnid=params.get_se_opnid();
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ROWNUM AS SEQID,T.* FROM ( ");
		sb.append("  select sum(r.paymoney) sumpaymoney,sum(case when r.isflag=1 then r.paymoney else 0 end)  sumnotconfirmmoney," +
				" sum(case when r.isflag=0 then r.paymoney else 0 end)  sumconfirmmoney " +
				" from ch_adt_cityrecord r , ch_pw_way w" );
		if(params.get_se_opnid()==null){
			sb.append(" , ch_pw_operation o ");
		}
		if(month!=null && !"".equals(month.trim())){
			sb.append("   where  r.rewardmonth='"+month.trim()+"'");	
			params.set_se_rewardmonth(null);
		}
		//业务编码（多选）
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			sb.append(" and r.opnid in ("+params.get_sin_opnid().trim()+")");
		 params.set_sin_opnid(null);
		}
		if(wayid!=null && !"".equals(wayid.trim())){
			sb.append("   and r.wayid='"+wayid.trim()+"'");	
			params.set_se_wayid(null);
		}
		if(waylike!=null && !"".equals(waylike.trim())){
			//sb.append("   and w.wayname like '%:waylike%'");
			sb.append("   and w.wayname like '%"+waylike+"%'");
			params.set_se_waylike(null);
		}
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sb.append("   and r.systemflag='"+systemflag.trim()+"'");
			params.set_ne_systemflag(null);
		}
		if(params.get_se_opnid()==null){
			sb.append(" and r.isflag in (0,1)  AND r.wayid=w.wayid and r.opnid=o.opnid and o.opnlevel=5 ");
		}
		if(params.get_se_opnid()!=null && !"".equals(params.get_se_opnid().trim())){
			sb.append(" and r.isflag in (0,1)  AND r.wayid=w.wayid  and r.opnid in ( select o.opnid from ch_pw_operation o where o.opnlevel=5 start with o.opnid='"+params.get_se_opnid().trim()+"'");
			sb.append(" connect by prior o.opnid=o.parentid )");
			params.set_se_opnid(null);
		}
		sb.append(" and to_char(r.rewardtype) in (select DICTID from CH_ADT_DICTIDNAME WHERE groupid='CH_REWARDTYPE' " +
				"UNION all select DICTID from sa_db_dictitem WHERE groupid='CH_REWARDTYPE') )T ");
		return this.queryBySql(sb.toString(), params, this.QUERY_TYPE_DATA);
		//return queryBySql(sb.toString(), params);
		
	}
	
}
