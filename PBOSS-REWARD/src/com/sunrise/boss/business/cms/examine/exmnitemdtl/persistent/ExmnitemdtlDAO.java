/**
* auto-generated code
* Wed Nov 25 11:16:38 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnitemdtl.persistent;

import java.sql.ResultSet;

import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ExmnitemdtlDAO</p>
 * <p>Description: Data Access Object for ExmnitemdtlVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnitemdtlDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public ExmnitemdtlDAO(){
        super(ExmnitemdtlVO.class);
    }
    public boolean doCheckBeingstcrtcl(ExmnitemdtlVO vo, User user)
	throws Exception{
	Session session = SessionUtil.currentSession(user.getCityid());
	String sql=" select * from CH_PW_EXMNITEMDTL  t where "
		+"t.exmnid="+vo.getExmnid()+" and t.exmnstdid=" +vo.getExmnstdid()+" and t.cityid='"+vo.getCityid()+"' "+
				" and ((t.leastcrtcl<"+vo.getLargestcrtcl()+" and t.largestcrtcl >="+vo.getLargestcrtcl()+") " +
						" or (t.leastcrtcl <="+vo.getLeastcrtcl()+" and t.largestcrtcl >"+vo.getLeastcrtcl()+")"+
						" or (t.leastcrtcl >="+vo.getLeastcrtcl()+" and t.largestcrtcl <="+vo.getLargestcrtcl()+") )	";
	if(vo.getSeqid()!=null && !"".equals(vo.getSeqid()))
		sql+=" and t.seqid <>"+vo.getSeqid() +"  and  (t.pseqid is null or t.pseqid<>"+vo.getSeqid() +")";
	ResultSet rs = session.connection().createStatement().executeQuery(sql);
	while(rs.next()){
		return true;
	}
	return false;
}
}
