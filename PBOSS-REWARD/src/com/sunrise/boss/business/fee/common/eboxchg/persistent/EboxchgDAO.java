package com.sunrise.boss.business.fee.common.eboxchg.persistent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Session;
import org.hibernate.impl.SessionImpl;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.SessionUtil;

public class EboxchgDAO extends BaseDAO {
	public EboxchgDAO() {
		super(EboxchgVO.class);
	}
	
	/**
	 * add by xiefufeng
	 * 添加帐本来往收支记录,并返回记录id
	 * @param vo 帐本来往收支记录
	 * @return 帐本来往收支记录id
	 * @throws Exception
	 */
	public Long createEboxchgLog1( EboxchgVO vo ) throws Exception{
		EboxchgVO chgvo = null;
		try{
			chgvo = (EboxchgVO)create(vo);
		}catch(Exception ex){
			if (ex.getCause() != null) {
                throw new Exception(ex.getCause());
            }else{
                throw ex;
            }
		}
		
		if(chgvo!=null) return chgvo.getLogid();
		else return new Long(-1);
	}
	
	/**
	 * add by xiefufeng
	 * 添加帐本来往收支记录,并返回记录id
	 * @param vo 帐本来往收支记录
	 * @return 帐本来往收支记录id
	 * @throws Exception
	 */
	public Long createEboxchgLog( EboxchgVO vo ) 
	throws Exception{
		Long logid = vo.getLogid();
		if( logid==null ){
			//获取sequence id
			logid = getEboxChgLodID();
			vo.setLogid( logid );
		}
		
		String sql = buildExeInsertSQL( vo );
		PreparedStatement ptmt = null;
		try{
			ptmt = getSQLStatement( sql, getDbFlag() );
			ptmt.execute( sql );
		}finally{
			if(ptmt!=null){
				ptmt.close();
			}
		}
		
		//清除缓存中的vo
		evict();
		return logid;
	}
	
	/**
	 * 拼装插入帐本来往收支记录的sql语句
	 * @param vo
	 * @return
	 */
	public String buildExeInsertSQL( EboxchgVO vo )
	throws Exception{
		StringBuffer sql = new StringBuffer("insert into ib_wl_eboxchglog (");
		StringBuffer sqlValues = new StringBuffer(" ) values ( ");
		
		//帐户变更日志标识
		Long logid = vo.getLogid();
		if( logid!=null ){
			sql.append( "logid" );
			sqlValues.append( logid );
		}
		
		//帐户标识
		Long eboxid = vo.getEboxid();
		if( eboxid!=null ){
			sql.append(",").append( "eboxid" );
			sqlValues.append(",").append(eboxid);
		}
		
		//帐本科目标识
		Long eboxunitid = vo.getEboxunitid();
		if( eboxunitid!=null ){
			sql.append(",").append( "eboxunitid" );
			sqlValues.append(",").append(eboxunitid);
		}
		
		//帐本科目明细标识
		Long eboxunitdetid = vo.getEboxunitdetid();
		if( eboxunitdetid!=null ){
			sql.append(",").append( "eboxunitdetid" );
			sqlValues.append(",").append(eboxunitdetid);
		}
		
		//变前金额
		Double beforechgamt = vo.getBeforechgamt();
		if( beforechgamt!=null ){
			sql.append(",").append( "beforechgamt" );
			sqlValues.append(",").append( beforechgamt );
		}
		
		//变后金额
		Double afterchgamt = vo.getAfterchgamt();
		if( afterchgamt!=null ){
			sql.append(",").append("afterchgamt");
			sqlValues.append(",").append(afterchgamt);
		}
		
		//操作员工号
		String opercode = vo.getOpercode();
		if( opercode!=null ){
			sql.append(",").append("opercode");
			sqlValues.append(",'").append(opercode).append("'");
		}
		
		//变更原因
		String reason = vo.getReason();
		if( reason!=null ){
			sql.append(",").append("reason");
			sqlValues.append(",'").append(reason).append("'");
		}
		//变更原因2
		String reason2 = vo.getReason2();
		if( reason2!=null ){
			sql.append(",").append("reason2");
			sqlValues.append(",'").append(reason2).append("'");
		}
		
		//操作时间
		sql.append(",").append("chgtime");
		sqlValues.append(",").append("sysdate");
		
		//变更来源
		String source = vo.getSource();
		if( source!=null ){
			sql.append(",").append("source");
			sqlValues.append(",'").append(source).append("'");
		}
		
		sqlValues.append(")");
		sql.append( sqlValues.toString() );
		
		return sql.toString();
	}
	
	/**
	 * 获取帐本来往收支记录的sequence
	 * @return
	 * @throws Exception
	 */
	public Long getEboxChgLodID()
	throws Exception{
		String sql = "select ib_wl_eboxchglog_seq.nextval from dual";
		PreparedStatement ptmt = null;
		Long logid = null; //帐户变更日志标识
		
		ResultSet rs = null;
		try{
			ptmt = getSQLStatement( sql, getDbFlag() );
			rs = ptmt.executeQuery();
			if( rs!=null && rs.next() ){
				logid = new Long(rs.getLong(1));
			}
		}finally{
			if( rs!=null ){
				rs.close();
			}
			if( ptmt!=null ){
				ptmt.close();
			}
		}
		
		if( logid==null ){
			throw new Exception("sequence is null");
		}
		
		return logid;
	}
	
	/**
	 * add by xiefufeng
	 * 将Hibernate的Session转换成JDBC中的PreparedStatement
	 * @param sql  需要执行的sql语句
	 * @param DBFlag 区域代码
	 * @return
	 * @throws Exception
	 */
	public PreparedStatement getSQLStatement( String sql, String DBFlag)
	throws Exception{
		Session session = SessionUtil.currentSession( DBFlag );
		return ((SessionImpl)session).getBatcher().prepareStatement(sql);
	}
	
	/**
	 * add by xiefufeng
	 * 将内存中被修改的vo写入数据库
	 * @param DBFlag
	 */
	public void flushSQL( String DBFlag ){
		Session session = SessionUtil.currentSession( DBFlag );
		session.flush();
	}
}
