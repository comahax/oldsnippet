/**
* auto-generated code
* Tue Jul 09 08:59:10 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtygotonedetail.persistent;

import java.sql.PreparedStatement;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.impl.SessionImpl;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: VChZjtyGotonedetailDAO</p>
 * <p>Description: Data Access Object for VChZjtyGotonedetailVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class VChZjtyGotonedetailDAO extends BaseDAO {

    /**
     * default constructor
     */
    public VChZjtyGotonedetailDAO(){
        super(VChZjtyGotonedetailVO.class);
    }

	public void delete(ChZjtyGotonedetailListVO params) throws Exception {
		PreparedStatement statement = null;
		try {
			String querySQL = "select mark, city, rewardreporttime from (select mark, " +
			"max(decode(type, 'city', datacontent, '')) as city, max(decode(type, " +
			"'rewardreporttime', datacontent, '')) as rewardreporttime from " +
			"CH_ZJTY_GOTONEDETAIL group by mark) t where t.city like '%" + params.get_sk_city() 
			+ "%' and t.rewardreporttime = '" + params.get_se_rewardreporttime() + "'";

			Session session = SessionUtil.currentSession(getDbFlag());
			SQLQuery query = session.createSQLQuery(querySQL)
				.addScalar("mark", Hibernate.LONG)
				.addScalar("city", Hibernate.STRING)
				.addScalar("rewardreporttime", Hibernate.STRING);
			
			List<Object[]> list = query.list();
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < list.size(); i++) {
				Object[] obj = (Object[]) list.get(i);
				stringBuffer.append(obj[0]).append(",");
			}
			
			String marks = stringBuffer.toString().substring(0, stringBuffer.length()-1);
			String deleteSQL = "delete CH_ZJTY_GOTONEDETAIL where mark in (" + marks + ")";
			statement = ((SessionImpl)session).getBatcher().prepareStatement(deleteSQL);
			statement.executeUpdate();
			session.flush();
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}

    public long doFindMaxMark() throws Exception {
    	long maxmark = 0;
		try {
			String querySQL = "select nvl(max(mark), 0) maxmark from CH_ZJTY_GOTONEDETAIL";
			Session session = SessionUtil.currentSession(getDbFlag());
			SQLQuery query = session.createSQLQuery(querySQL)
				.addScalar("maxmark", Hibernate.LONG);
			Object obj = query.uniqueResult();
			maxmark = Long.parseLong(obj.toString());
		} catch (RuntimeException e) {
			return 9999999999l;
		}
    	return maxmark;
    }
}
