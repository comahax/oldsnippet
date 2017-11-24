/**
* auto-generated code
* Tue Nov 24 10:54:37 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnperiod.persistent;

import java.sql.ResultSet;

import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.xtree.StringUtils;


/**
 * <p>Title: ExmnperiodDAO</p>
 * <p>Description: Data Access Object for ExmnperiodVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnperiodDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public ExmnperiodDAO(){
        super(ExmnperiodVO.class);
    }
    public boolean doCheckBeingPeriod(ExmnperiodVO vo, User user)
    	throws Exception{
    	Session session = SessionUtil.currentSession(user.getCityid());
    	StringBuffer sql=new StringBuffer();
    		sql.append("select 1 from CH_PW_EXMNPERIOD  t where t.exmnid="+vo.getExmnid() );
    		sql.append(" and t.endmonth>=t.beginmonth ")
	    		.append(" and ((t.beginmonth <="+vo.getEndmonth()+" and t.endmonth >="+vo.getEndmonth()+") " )
	    		.append(" or (t.beginmonth <="+vo.getBeginmonth()+" and t.endmonth >="+vo.getBeginmonth()+") ")
	    		.append(" or (t.beginmonth >="+vo.getBeginmonth()+" and t.endmonth <="+vo.getEndmonth()+") ) ");
    		if(vo.getSeqid()!=null && !"".equals(vo.getSeqid()))
        		sql.append(" and t.seqid <>"+vo.getSeqid() );
	    	sql.append(" union ");
	    	sql.append("select 1 from CH_PW_EXMNPERIOD  t2 where t2.exmnid="+vo.getExmnid() )
	    		.append(" and t2.endmonth<t2.beginmonth ")
	    		.append(" and ((t2.beginmonth <="+vo.getEndmonth()+" and 12>="+vo.getEndmonth()+") ")
	    		.append(" or (t2.beginmonth <="+vo.getBeginmonth()+" and 12>="+vo.getBeginmonth()+") ")
	    		.append(" or (0 <="+vo.getEndmonth()+" and t2.endmonth >="+vo.getEndmonth()+") ")
	    		.append(" or (0 <="+vo.getBeginmonth()+" and t2.endmonth >="+vo.getBeginmonth()+") ) ");
    	if(vo.getSeqid()!=null && !"".equals(vo.getSeqid()))
    		sql.append(" and t2.seqid <>"+vo.getSeqid() );
    	ResultSet rs = session.connection().createStatement().executeQuery(sql.toString());
    	while(rs.next()){
    		return true;
    	}
		return false;
    }
}
