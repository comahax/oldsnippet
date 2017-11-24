package com.gmcc.pboss.business.cms.examine.mapping.persistent;


import java.sql.ResultSet;

import org.hibernate.Session;

import com.sunrise.jop.infrastructure.db.AbstractDAO;


/**
 * <p>Title: MappingDAO</p>
 * <p>Description: Data Access Object for MappingVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class MappingDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public MappingDAO(){
        super(MappingVO.class);
    }
//    public boolean doCheckBeingMark(MappingForm form, User user)
//	throws Exception{
//	Session session = SessionUtil.currentSession(user.getCityid());
//	String sql=" select * from common.CH_PW_MAPPING  t where "
//		+"t.exmnid="+form.getExmnid()+
//				" and ((t.markul >="+form.getMarkll()+" and t.markul <="+form.getMarkul()+") " +
//						"or (t.markll >="+form.getMarkll()+" and t.markll <="+form.getMarkul()+") )	";
//	ResultSet rs = session.connection().createStatement().executeQuery(sql);
//	while(rs.next()){
//		return true;
//	}
//	return false;
//}
}
