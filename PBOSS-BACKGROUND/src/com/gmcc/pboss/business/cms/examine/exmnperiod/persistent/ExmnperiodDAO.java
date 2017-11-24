package com.gmcc.pboss.business.cms.examine.exmnperiod.persistent;


import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.jop.infrastructure.db.AbstractDAO;



/**
 * <p>Title: ExmnperiodDAO</p>
 * <p>Description: Data Access Object for ExmnperiodVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnperiodDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public ExmnperiodDAO(){
        super(ExmnperiodVO.class);
    }
//    public boolean doCheckBeingPeriod(ExmnperiodForm form, User user)
//    	throws Exception{
//    	Session session = SessionUtil.currentSession(user.getCityid());
//    	String sql="select 1 from common.CH_PW_EXMNPERIOD  t where "
//    		+"t.exmnid="+form.getExmnid()+"" +
//    				" and ((t.beginmonth >="+form.getBeginmonth()+" and t.beginmonth <="+form.getEndmonth()+") " +
//    						"or (t.endmonth >="+form.getBeginmonth()+" and t.endmonth <="+form.getEndmonth()+") )	";
//    	ResultSet rs = session.connection().createStatement().executeQuery(sql);
//    	while(rs.next()){
//    		return true;
//    	}
//		return false;
//    }
}
