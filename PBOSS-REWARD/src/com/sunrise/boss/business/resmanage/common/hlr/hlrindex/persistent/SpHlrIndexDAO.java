package com.sunrise.boss.business.resmanage.common.hlr.hlrindex.persistent;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.SessionUtil;

public class SpHlrIndexDAO extends BaseDAO {

	public SpHlrIndexDAO(){
		super(SpHlrIndexVO.class);
	}
	
	
	public Long getMaxSeqByStreamno(Long streamno)throws Exception{
		if(streamno != null){
			String sql = "SELECT max(this.seq) FROM SpHlrIndexVO this where this.streamno = "
				+ streamno.toString();
			Session session = null;
			try{
				session = SessionUtil.currentSession(getDbFlag());
				Query query = session.createQuery(sql);
                Iterator iter = query.iterate();
                if (iter != null && iter.hasNext()) {
                    return (Long) iter.next();
                }
			}catch(Exception ex){
				if (ex.getCause() != null) {
                    throw new Exception(ex.getCause());
                }
                else {
                    throw ex;
                }
			}
		}
		return null;
	}
}
