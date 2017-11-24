package com.sunrise.boss.business.fee.realtran.payway;

import java.sql.PreparedStatement;

import org.hibernate.Session;
import org.hibernate.impl.SessionImpl;

import com.sunrise.boss.common.base.db.SessionUtil;

public class SqlUtils {
	
	public static PreparedStatement getSQLStatement( String sql, String DBFlag)
	throws Exception{
		Session session = SessionUtil.currentSession( DBFlag );
		return session.connection().prepareStatement(sql);
	}
	
	public static PreparedStatement getBSQLStatement( String sql, String DBFlag )
	throws Exception{
		Session session = SessionUtil.currentSession( DBFlag );
		return ((SessionImpl)session).getBatcher().prepareStatement(sql);
	}
}
