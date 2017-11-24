/**
* auto-generated code
* Sat Nov 28 17:48:47 CST 2009
*/
package com.sunrise.boss.business.cms.examine.mapping.persistent;

import java.sql.ResultSet;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.business.cms.examine.examine.persistent.ExamineListVO;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: MappingDAO</p>
 * <p>Description: Data Access Object for MappingVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class MappingDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public MappingDAO(){
        super(MappingVO.class);
    }
    public boolean doCheckBeingMark(MappingVO vo, User user)
	throws Exception{
		Session session = SessionUtil.currentSession(user.getCityid());
		String sql=" select * from CH_PW_MAPPING  t where "
			+"t.exmnid="+vo.getExmnid()+
					" and ((t.markll <"+vo.getMarkul()+" and t.markul >="+vo.getMarkul()+") " +
							"or (t.markll <="+vo.getMarkll()+" and t.markul >"+vo.getMarkll()+") "+
							"or (t.markll >="+vo.getMarkll()+" and t.markul <="+vo.getMarkul()+"))	";
		if(vo.getSeqid()!=null && !"".equals(vo.getSeqid()))
			sql+=" and t.seqid<>"+vo.getSeqid();
		ResultSet rs = session.connection().createStatement().executeQuery(sql);
		while(rs.next()){
			return true;
		}
		return false;
    }
    public DataPackage queryMappingList(MappingListVO params,String cityid)throws Exception  {
		Session session = SessionUtil.currentSession(getDbFlag());

		SQLQuery query = (SQLQuery)session.getNamedQuery("queryMappingList");
		String queryString = query.getQueryString();
		params.getQueryConditions().put("skcityid", "%" +  cityid+ "%");
		params.getQueryConditions().put("cityid", cityid);
		return queryBySql(queryString, params);

	}
}
