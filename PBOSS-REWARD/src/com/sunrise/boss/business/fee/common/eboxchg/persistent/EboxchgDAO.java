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
	 * ����ʱ�������֧��¼,�����ؼ�¼id
	 * @param vo �ʱ�������֧��¼
	 * @return �ʱ�������֧��¼id
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
	 * ����ʱ�������֧��¼,�����ؼ�¼id
	 * @param vo �ʱ�������֧��¼
	 * @return �ʱ�������֧��¼id
	 * @throws Exception
	 */
	public Long createEboxchgLog( EboxchgVO vo ) 
	throws Exception{
		Long logid = vo.getLogid();
		if( logid==null ){
			//��ȡsequence id
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
		
		//��������е�vo
		evict();
		return logid;
	}
	
	/**
	 * ƴװ�����ʱ�������֧��¼��sql���
	 * @param vo
	 * @return
	 */
	public String buildExeInsertSQL( EboxchgVO vo )
	throws Exception{
		StringBuffer sql = new StringBuffer("insert into ib_wl_eboxchglog (");
		StringBuffer sqlValues = new StringBuffer(" ) values ( ");
		
		//�ʻ������־��ʶ
		Long logid = vo.getLogid();
		if( logid!=null ){
			sql.append( "logid" );
			sqlValues.append( logid );
		}
		
		//�ʻ���ʶ
		Long eboxid = vo.getEboxid();
		if( eboxid!=null ){
			sql.append(",").append( "eboxid" );
			sqlValues.append(",").append(eboxid);
		}
		
		//�ʱ���Ŀ��ʶ
		Long eboxunitid = vo.getEboxunitid();
		if( eboxunitid!=null ){
			sql.append(",").append( "eboxunitid" );
			sqlValues.append(",").append(eboxunitid);
		}
		
		//�ʱ���Ŀ��ϸ��ʶ
		Long eboxunitdetid = vo.getEboxunitdetid();
		if( eboxunitdetid!=null ){
			sql.append(",").append( "eboxunitdetid" );
			sqlValues.append(",").append(eboxunitdetid);
		}
		
		//��ǰ���
		Double beforechgamt = vo.getBeforechgamt();
		if( beforechgamt!=null ){
			sql.append(",").append( "beforechgamt" );
			sqlValues.append(",").append( beforechgamt );
		}
		
		//�����
		Double afterchgamt = vo.getAfterchgamt();
		if( afterchgamt!=null ){
			sql.append(",").append("afterchgamt");
			sqlValues.append(",").append(afterchgamt);
		}
		
		//����Ա����
		String opercode = vo.getOpercode();
		if( opercode!=null ){
			sql.append(",").append("opercode");
			sqlValues.append(",'").append(opercode).append("'");
		}
		
		//���ԭ��
		String reason = vo.getReason();
		if( reason!=null ){
			sql.append(",").append("reason");
			sqlValues.append(",'").append(reason).append("'");
		}
		//���ԭ��2
		String reason2 = vo.getReason2();
		if( reason2!=null ){
			sql.append(",").append("reason2");
			sqlValues.append(",'").append(reason2).append("'");
		}
		
		//����ʱ��
		sql.append(",").append("chgtime");
		sqlValues.append(",").append("sysdate");
		
		//�����Դ
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
	 * ��ȡ�ʱ�������֧��¼��sequence
	 * @return
	 * @throws Exception
	 */
	public Long getEboxChgLodID()
	throws Exception{
		String sql = "select ib_wl_eboxchglog_seq.nextval from dual";
		PreparedStatement ptmt = null;
		Long logid = null; //�ʻ������־��ʶ
		
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
	 * ��Hibernate��Sessionת����JDBC�е�PreparedStatement
	 * @param sql  ��Ҫִ�е�sql���
	 * @param DBFlag �������
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
	 * ���ڴ��б��޸ĵ�voд�����ݿ�
	 * @param DBFlag
	 */
	public void flushSQL( String DBFlag ){
		Session session = SessionUtil.currentSession( DBFlag );
		session.flush();
	}
}
