package com.sunrise.boss.business.fee.common;

import java.sql.PreparedStatement;

import org.hibernate.Session;
import org.hibernate.impl.SessionImpl;

import com.sunrise.jop.common.utils.lang.SessionUtils;


public class SqlUtils {
	
	public static PreparedStatement getSQLStatement( String sql, String DBFlag)
	throws Exception{
		Session session = SessionUtils.currentSession( DBFlag );
		return session.connection().prepareStatement(sql);
	}
	
	public static PreparedStatement getBSQLStatement( String sql, String DBFlag )
	throws Exception{
		Session session = SessionUtils.currentSession( DBFlag );
		return ((SessionImpl)session).getBatcher().prepareStatement(sql);
	}
}
