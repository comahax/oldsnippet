/**
* auto-generated code
* Sun Feb 03 10:40:37 CST 2008
*/
package com.sunrise.boss.business.cms.reward.citydata.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: CitydataDAO</p>
 * <p>Description: Data Access Object for CitydataVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Cai Jianhui
 * @version 1.0
 * 
 * modify by Zhang Fengchao 2008-03-17: Add the method clearAll()
 */
public class CitydataDAO extends BaseDAO {
    public CitydataDAO(){
        super(CitydataVO.class);
    }
	
	/**
	 * 删除库表数据，并记录日志
	 * @throws Exception
	 * 
	 * add by Zhang Fengchao 2007-03-17
	 */
	public void clearAll(User user) throws Exception {
//		StringBuffer insertSQL = new StringBuffer(
//				"insert into CH_ADT_CITYDATAHIS ")
//				.append("(")
//				.append(" select SEQ, CALCMONTH, OPNID, WAYID, OPRTIME,")
//				.append(" OPRCODE, MOBILE, BUSIVALUE, BRAND, DATASOURCE,")
//				.append(" VALIDFLAG, REMARK, REWARDTYPE, CITYID, CREATETIME,")
//				.append(" CREATECODE, BATCHNO, FILEINFO, -2, ADTCODE, ADTREMARK")
//				.append(" from CH_ADT_CITYDATA")
//				.append(")");
//		String delSQL = "delete from CH_ADT_CITYDATA";
		
//		String truncateSQL = "truncate table CH_ADT_CITYDATA";
		String delSQL = "delete from CH_ADT_CITYDATA";
		
		Session session = SessionUtil.currentSession(super.getDbFlag());
		Connection con = session.connection();
//		PreparedStatement stmt = con.prepareStatement(truncateSQL);
		PreparedStatement stmt = con.prepareStatement(delSQL);
		stmt.execute();
		stmt.close();
		session.flush();
	}
}
