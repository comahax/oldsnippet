/**
* auto-generated code
* Thu Dec 15 07:12:07 GMT 2011
*/
package com.sunrise.boss.business.cms.cityrecord.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.impl.SessionImpl;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: CityrecordDAO</p>
 * <p>Description: Data Access Object for CityrecordVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CityrecordDAO extends BaseDAO {

    /**
     * default constructor
     */
    public CityrecordDAO(){
        super(CityrecordVO.class);
    }
    
    /*
	 * ��ȡ����2�����뼰�丸����1�������������
	 */
	public DataPackage getOpnlevel2() throws Exception{
		return queryByNamedSqlQuery("com.sunrise.boss.business.cms.cityrecord.getOpnlevel2");
	}
	
	public List getBusistat(String opnid,String wayid,String waylike,String month,String systemflag){
		StringBuilder sb = new StringBuilder();
		sb.append("select to_char(r.rewardtype) rewardtype,d.dictname,to_char(r.oprtime,'yyyymm') oprmonth,r.isflag,");
		sb.append("       sum(r.busivalue) sumbusivalue,sum(r.paymoney) sumpaymoney");
		sb.append("   from ch_adt_cityrecord r,");
		sb.append("      (select o.opnid from ch_pw_operation o");
		sb.append("			where o.opnlevel=5");
		sb.append("			start with o.opnid=:opnid");
		sb.append("			connect by prior o.opnid=o.parentid) o,");
		sb.append("      (select dictid,dictname from CH_ADT_DICTIDNAME");//sa_db_dictitem
		sb.append("			where groupid='CH_REWARDTYPE') d,");
		sb.append("   ch_pw_way w");
		sb.append("   where r.isflag in (0,1) and r.opnid=o.opnid and w.wayid=r.wayid and r.rewardtype=d.dictid(+)");
		if(wayid!=null && !"".equals(wayid.trim())){
			sb.append("   and r.wayid=:wayid");	
		}
		if(waylike!=null && !"".equals(waylike.trim())){
			//sb.append("   and w.wayname like '%:waylike%'");
			sb.append("   and w.wayname like '%"+waylike+"%'");
		}
		if(month!=null && !"".equals(month.trim())){
			sb.append("   and r.rewardmonth=:rewardmonth");	
		}
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sb.append("   and r.systemflag=:systemflag");	
		}
		sb.append("   group by r.rewardtype,d.dictname,to_char(r.oprtime,'yyyymm'),r.isflag");
		sb.append("   order by r.rewardtype,to_char(r.oprtime,'yyyymm'),r.isflag desc");
		Session session = SessionUtil.currentSession(getDbFlag());
		SQLQuery sqlQuery = session.createSQLQuery(sb.toString());
		sqlQuery.setString("opnid", opnid);
		if(wayid!=null && !"".equals(wayid.trim())){
			sqlQuery.setString("wayid", wayid);		
		}
//		if(waylike!=null && !"".equals(waylike.trim())){
//			sqlQuery.setString("waylike", waylike);		
//		}
		if(month!=null && !"".equals(month.trim())){
			sqlQuery.setString("rewardmonth", month);		
		}
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sqlQuery.setString("systemflag", systemflag);		
		}
		sqlQuery.addScalar("rewardtype", Hibernate.STRING);
		sqlQuery.addScalar("dictname", Hibernate.STRING);
		sqlQuery.addScalar("oprmonth", Hibernate.STRING);
		sqlQuery.addScalar("isflag", Hibernate.SHORT);
		sqlQuery.addScalar("sumbusivalue", Hibernate.DOUBLE);
		sqlQuery.addScalar("sumpaymoney", Hibernate.DOUBLE);
		return sqlQuery.list();
	}
	public List getBusistatenhance(String opnid,String wayid,String waylike,String month,String systemflag){
		StringBuilder sb = new StringBuilder();
//		sb.append("select to_char(r.rewardtype) rewardtype,d.dictname,to_char(r.oprtime,'yyyymm') oprmonth,r.isflag,");
		sb.append("select to_char(r.rewardtype) rewardtype,to_char(r.oprtime,'yyyymm') oprmonth,r.isflag,");
		sb.append("       sum(r.busivalue) sumbusivalue,sum(r.paymoney) sumpaymoney");
		sb.append("   from ch_adt_cityrecord r,");
		sb.append("      (select o.opnid from ch_pw_operation o");
		sb.append("			where o.opnlevel=5");
		sb.append("			start with o.opnid=:opnid");
		sb.append("			connect by prior o.opnid=o.parentid) o,");
//		sb.append("      (select dictid,dictname from CH_ADT_DICTIDNAME");//sa_db_dictitem
//		sb.append("			where groupid='CH_REWARDTYPE') d,");
		sb.append("   ch_pw_way w");
//		sb.append("   where r.isflag in (0,1) and r.opnid=o.opnid and w.wayid=r.wayid and r.rewardtype=d.dictid(+)");
		sb.append("   where r.isflag in (0,1) and r.opnid=o.opnid and w.wayid=r.wayid ");
		if(wayid!=null && !"".equals(wayid.trim())){
			sb.append("   and r.wayid=:wayid");	
		}
		if(waylike!=null && !"".equals(waylike.trim())){
			//sb.append("   and w.wayname like '%:waylike%'");
			sb.append("   and w.wayname like '%"+waylike+"%'");
		}
		if(month!=null && !"".equals(month.trim())){
			sb.append("   and r.rewardmonth=:rewardmonth");	
		}
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sb.append("   and r.systemflag=:systemflag");	
		}
//		sb.append("   group by r.rewardtype,d.dictname,to_char(r.oprtime,'yyyymm'),r.isflag");
		sb.append("   group by r.rewardtype,to_char(r.oprtime,'yyyymm'),r.isflag");
		sb.append("   order by r.rewardtype,to_char(r.oprtime,'yyyymm'),r.isflag desc");
		Session session = SessionUtil.currentSession(getDbFlag());
		SQLQuery sqlQuery = session.createSQLQuery(sb.toString());
		sqlQuery.setString("opnid", opnid);
		if(wayid!=null && !"".equals(wayid.trim())){
			sqlQuery.setString("wayid", wayid);		
		}
//		if(waylike!=null && !"".equals(waylike.trim())){
//			sqlQuery.setString("waylike", waylike);		
//		}
		if(month!=null && !"".equals(month.trim())){
			sqlQuery.setString("rewardmonth", month);		
		}
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sqlQuery.setString("systemflag", systemflag);		
		}
		sqlQuery.addScalar("rewardtype", Hibernate.STRING);
//		sqlQuery.addScalar("dictname", Hibernate.STRING);
		sqlQuery.addScalar("oprmonth", Hibernate.STRING);
		sqlQuery.addScalar("isflag", Hibernate.SHORT);
		sqlQuery.addScalar("sumbusivalue", Hibernate.DOUBLE);
		sqlQuery.addScalar("sumpaymoney", Hibernate.DOUBLE);
		return sqlQuery.list();
	}
	
	//ר��Ϊȷ�Ϸ�������
	public List getBusistat2(String opnid,String wayid,String waylike,String month,String systemflag){
		StringBuilder sb = new StringBuilder();
		sb.append("select r.recordid,to_char(r.rewardtype) rewardtype,d.dictname,to_char(r.oprtime,'yyyymm') oprmonth,r.isflag,");
		sb.append("       sum(r.busivalue) sumbusivalue,sum(r.paymoney) sumpaymoney");
		sb.append("   from ch_adt_cityrecord r,");
		sb.append("      (select o.opnid from ch_pw_operation o");
		sb.append("			where o.opnlevel=5");
		sb.append("			start with o.opnid=:opnid");
		sb.append("			connect by prior o.opnid=o.parentid) o,");
		sb.append("      (select dictid,dictname from CH_ADT_DICTIDNAME");//sa_db_dictitem
		sb.append("			where groupid='CH_REWARDTYPE') d,");
		sb.append("   ch_pw_way w");
		sb.append("   where r.isflag in (0,1) and r.opnid=o.opnid and w.wayid=r.wayid and r.rewardtype=d.dictid(+)");
		if(wayid!=null && !"".equals(wayid.trim())){
			sb.append("   and r.wayid=:wayid");	
		}
		if(waylike!=null && !"".equals(waylike.trim())){
			//sb.append("   and w.wayname like '%:waylike%'");
			sb.append("   and w.wayname like '%"+waylike+"%'");
		}
		if(month!=null && !"".equals(month.trim())){
			sb.append("   and r.rewardmonth=:rewardmonth");	
		}
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sb.append("   and r.systemflag=:systemflag");	
		}
		sb.append("   group by r.recordid,r.rewardtype,d.dictname,to_char(r.oprtime,'yyyymm'),r.isflag");
		sb.append("   order by r.recordid,r.rewardtype,to_char(r.oprtime,'yyyymm'),r.isflag desc");
		Session session = SessionUtil.currentSession(getDbFlag());
		SQLQuery sqlQuery = session.createSQLQuery(sb.toString());
		sqlQuery.setString("opnid", opnid);
		if(wayid!=null && !"".equals(wayid.trim())){
			sqlQuery.setString("wayid", wayid);		
		}
//		if(waylike!=null && !"".equals(waylike.trim())){
//			sqlQuery.setString("waylike", waylike);		
//		}
		if(month!=null && !"".equals(month.trim())){
			sqlQuery.setString("rewardmonth", month);		
		}
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sqlQuery.setString("systemflag", systemflag);		
		}
		sqlQuery.addScalar("recordid", Hibernate.LONG);
		sqlQuery.addScalar("rewardtype", Hibernate.STRING);
		sqlQuery.addScalar("dictname", Hibernate.STRING);
		sqlQuery.addScalar("oprmonth", Hibernate.STRING);
		sqlQuery.addScalar("isflag", Hibernate.SHORT);
		sqlQuery.addScalar("sumbusivalue", Hibernate.DOUBLE);
		sqlQuery.addScalar("sumpaymoney", Hibernate.DOUBLE);
		return sqlQuery.list();
	}
	
	//���ϵ������ҳ���ǰҵ����������Ķ�����һ��ҵ�����
	public List getOpnidandParentid(String opnid){
		StringBuilder sb = new StringBuilder();
		sb.append("select o.opnid, o.parentid");
		sb.append("  from ch_pw_operation o");
		sb.append("  where o.opnlevel = 2");
		sb.append("  start with o.opnid = :opnid");
		sb.append("  connect by prior o.parentid = o.opnid");
		Session session = SessionUtil.currentSession(getDbFlag());
		SQLQuery sqlQuery = session.createSQLQuery(sb.toString());
		sqlQuery.addScalar("opnid", Hibernate.STRING);
		sqlQuery.addScalar("parentid", Hibernate.STRING);
		sqlQuery.setString("opnid", opnid);
		return sqlQuery.list();
	}
	
	
	//ר��ͳ�Ʒ����ã�ҵ�����Ϊ�ջ��߱���㼶Ϊ1ʱ��
	//��;�����opnlevelΪ1������������������Ķ�������
	//�������1����Ĭ��ֵΪ0�������������Ϊ������û������opnid�������г�����һ��������������������ѭ��
	public List getOpnidandParentid2(String opnid,Short opnlevel){
		StringBuilder sb = new StringBuilder();
		sb.append("select o1.parentid,o1.opnid");
		sb.append("  from ch_pw_operation o1, ch_pw_operation o2");
		sb.append("  where o1.opnlevel=2 and o1.parentid=o2.opnid");
		if(opnlevel==1){
			sb.append("  and o2.opnid= :opnid");
		}
		sb.append("  order by o1.parentid,o1.opnid");
		Session session = SessionUtil.currentSession(getDbFlag());
		SQLQuery sqlQuery = session.createSQLQuery(sb.toString());
		sqlQuery.addScalar("parentid", Hibernate.STRING);
		sqlQuery.addScalar("opnid", Hibernate.STRING);
		if(opnlevel==1){
			sqlQuery.setString("opnid", opnid);
		}
		return sqlQuery.list();
	}
	
	//��ѯ��ϸ---��  �й�˾��𷢲�ȷ�Ϲ���
	public List getDetail(String opnid,String wayid,String waylike,String month,String systemflag,String rewardtype,String oprmonth){
		StringBuilder sb = new StringBuilder();
		sb.append("select r.recordid,r.isflag,r.systemflag,r.wayid,r.opnid,r.rewardtype,d.dictname,r.mobile,r.rewardmonth,r.oprtime,r.busivalue,r.paymoney,r.paysum");
		sb.append("   from ch_adt_cityrecord r,");
		sb.append("      (select o.opnid from ch_pw_operation o");
		sb.append("			where o.opnlevel=5");
		sb.append("			start with o.opnid=:opnid");
		sb.append("			connect by prior o.opnid=o.parentid) o,");
		sb.append("      (select dictid,dictname from CH_ADT_DICTIDNAME");//sa_db_dictitem
		sb.append("			where groupid='CH_REWARDTYPE') d,");
		sb.append("   ch_pw_way w");
		sb.append("   where r.isflag in (0,1) and r.opnid=o.opnid and w.wayid=r.wayid and r.rewardtype=d.dictid(+)");
		sb.append("    and r.rewardtype =:rewardtype");
		sb.append("    and to_char(r.oprtime, 'yyyyMM') =:oprtime");
		if(wayid!=null && !"".equals(wayid.trim())){
			sb.append("   and r.wayid=:wayid");	
		}
		if(waylike!=null && !"".equals(waylike.trim())){
			sb.append("   and w.wayname like '%"+waylike+"%'");
		}
		if(month!=null && !"".equals(month.trim())){
			sb.append("   and r.rewardmonth=:rewardmonth");	
		}
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sb.append("   and r.systemflag=:systemflag");	
		}
		sb.append("   order by r.oprtime desc");
		Session session = SessionUtil.currentSession(getDbFlag());
		SQLQuery sqlQuery = session.createSQLQuery(sb.toString());
		sqlQuery.setString("opnid", opnid);
		sqlQuery.setString("rewardtype", rewardtype);
		sqlQuery.setString("oprtime", oprmonth);
		if(wayid!=null && !"".equals(wayid.trim())){
			sqlQuery.setString("wayid", wayid);		
		}
//		if(waylike!=null && !"".equals(waylike.trim())){
//			sqlQuery.setString("waylike", waylike);		
//		}
		if(month!=null && !"".equals(month.trim())){
			sqlQuery.setString("rewardmonth", month);		
		}
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sqlQuery.setString("systemflag", systemflag);		
		}
		sqlQuery.addScalar("recordid", Hibernate.LONG);
		sqlQuery.addScalar("isflag", Hibernate.SHORT);
		sqlQuery.addScalar("systemflag", Hibernate.SHORT);
		sqlQuery.addScalar("wayid", Hibernate.STRING);
		sqlQuery.addScalar("opnid", Hibernate.STRING);
		sqlQuery.addScalar("rewardtype", Hibernate.SHORT);
		sqlQuery.addScalar("dictname", Hibernate.STRING);
		sqlQuery.addScalar("mobile", Hibernate.STRING);
		sqlQuery.addScalar("rewardmonth", Hibernate.STRING);
		sqlQuery.addScalar("oprtime", Hibernate.DATE);
		sqlQuery.addScalar("busivalue", Hibernate.DOUBLE);
		sqlQuery.addScalar("paymoney", Hibernate.DOUBLE);
		sqlQuery.addScalar("paysum", Hibernate.DOUBLE);
		return sqlQuery.list();
	}
	
	//��ѯ��ϸ(ר����ȫ��ȷ�ϡ�����ʹ��)
	public List getDetail2(String opnid,String wayid,String waylike,String month,String systemflag){
		StringBuilder sb = new StringBuilder();
		sb.append("select r.recordid,r.isflag,r.systemflag,r.wayid,r.opnid,r.rewardtype,d.dictname,r.mobile,r.rewardmonth,r.oprtime,r.busivalue,r.paymoney");
		sb.append("   from ch_adt_cityrecord r,");
		sb.append("      (select o.opnid from ch_pw_operation o");
		sb.append("			where o.opnlevel=5");
		sb.append("			start with o.opnid=:opnid");
		sb.append("			connect by prior o.opnid=o.parentid) o,");
		sb.append("      (select dictid,dictname from CH_ADT_DICTIDNAME");//sa_db_dictitem
		sb.append("			where groupid='CH_REWARDTYPE') d,");
		sb.append("   ch_pw_way w");
		sb.append("   where r.isflag in (0,1) and r.opnid=o.opnid and w.wayid=r.wayid and r.rewardtype=d.dictid(+)");
		//sb.append("    and r.rewardtype =:rewardtype");
		//sb.append("    and to_char(r.oprtime, 'yyyyMM') =:oprtime");
		if(wayid!=null && !"".equals(wayid.trim())){
			sb.append("   and r.wayid=:wayid");	
		}
		if(waylike!=null && !"".equals(waylike.trim())){
			//sb.append("   and w.wayname like '%:waylike%'");
			sb.append("   and w.wayname like '%"+waylike+"%'");
		}
		if(month!=null && !"".equals(month.trim())){
			sb.append("   and r.rewardmonth=:rewardmonth");	
		}
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sb.append("   and r.systemflag=:systemflag");	
		}
		sb.append("   order by r.oprtime desc");
		Session session = SessionUtil.currentSession(getDbFlag());
		SQLQuery sqlQuery = session.createSQLQuery(sb.toString());
		sqlQuery.setString("opnid", opnid);
//		sqlQuery.setString("rewardtype", rewardtype);
//		sqlQuery.setString("oprtime", oprmonth);
		if(wayid!=null && !"".equals(wayid.trim())){
			sqlQuery.setString("wayid", wayid);		
		}
//		if(waylike!=null && !"".equals(waylike.trim())){
//			sqlQuery.setString("waylike", waylike);		
//		}
		if(month!=null && !"".equals(month.trim())){
			sqlQuery.setString("rewardmonth", month);		
		}
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sqlQuery.setString("systemflag", systemflag);		
		}
		sqlQuery.addScalar("recordid", Hibernate.LONG);
		sqlQuery.addScalar("isflag", Hibernate.SHORT);
		sqlQuery.addScalar("systemflag", Hibernate.SHORT);
		sqlQuery.addScalar("wayid", Hibernate.STRING);
		sqlQuery.addScalar("opnid", Hibernate.STRING);
		sqlQuery.addScalar("rewardtype", Hibernate.SHORT);
		sqlQuery.addScalar("dictname", Hibernate.STRING);
		sqlQuery.addScalar("mobile", Hibernate.STRING);
		sqlQuery.addScalar("rewardmonth", Hibernate.STRING);
		sqlQuery.addScalar("oprtime", Hibernate.DATE);
		sqlQuery.addScalar("busivalue", Hibernate.DOUBLE);
		sqlQuery.addScalar("paymoney", Hibernate.DOUBLE);
		return sqlQuery.list();
	}
	
	public void onlyIssue(CityrecordListVO params,User user) throws Exception{
		String sql = " update CH_ADT_CITYRECORD t set t.isflag=1,t.oprcode='"+user.getOpercode()
				+"',t.optime=sysdate where t.isflag=2 and t.systemflag=1 ";	//2012-8-28�Ż����Ѳ�����isflag=2������	
		if(params.get_se_rewardmonth()!=null && !"".equals(params.get_se_rewardmonth().trim())){
			sql+=" and t.rewardmonth=  '"+params.get_se_rewardmonth().trim()+"'";
		}
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			sql+=" and t.wayid=  '"+params.get_se_wayid().trim()+"'";
		}
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			sql+=" and EXISTS ( SELECT 1 FROM CH_PW_WAY A WHERE A.CHAINHEAD='"+params.get_se_chainhead().trim()+"'  AND t.WAYID=A.WAYID )  ";
		}
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid())){
			sql+=" and EXISTS ( SELECT 1 FROM CH_PW_WAY A WHERE A.countyid='"+params.get_se_countyid().trim()+"'  AND t.WAYID=A.WAYID )  ";
		}
		if(params.get_ne_taskid()!=null && !"".equals(params.get_ne_taskid())){
			sql+=" and t.taskid="+Long.parseLong(params.get_ne_taskid().trim());
		}
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			sql+=" and t.opnid in("+params.get_sin_opnid().trim()+") ";
		}
		if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile())){
			sql+=" and t.mobile='"+params.get_se_mobile().trim()+"'";
		}		

		System.out.println("�������:"+sql);
		Session session = SessionUtil.currentSession(user.getCityid());
		try{
			int num = session.connection().createStatement().executeUpdate(sql);
			System.out.println("��������"+num+"��");
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	public int confirmone(CityrecordListVO params,String opnid,String rewardtype,String oprmonth,User user) throws Exception{
		String sql = " update CH_ADT_CITYRECORD t set t.isflag=0,t.accountoprcode='"+user.getOpercode()
				+"',t.accountoptime=sysdate where t.isflag=1 ";
		sql+=" and t.opnid in ( select o.opnid from ch_pw_operation o where o.opnlevel=5 start with o.opnid='"+opnid+"'";
		sql+=" connect by prior o.opnid=o.parentid )";
		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
			sql+=" and exists (select 1 from ch_pw_way w where t.wayid=w.wayid and w.countyid='"+params.get_se_countyid()+"')";
		}
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			sql+=" and t.wayid=  '"+params.get_se_wayid().trim()+"'";
		}
		if(params.get_se_rewardmonth()!=null && !"".equals(params.get_se_rewardmonth().trim())){
			sql+=" and t.rewardmonth=  '"+params.get_se_rewardmonth().trim()+"'";
		}
		if(!"".equals(rewardtype.trim())){
			sql+=" and t.rewardtype=  "+rewardtype.trim()+" ";
		}
		if(!"".equals(oprmonth.trim())){
			sql+=" and to_char(t.oprtime,'yyyymm')='"+oprmonth.trim()+"'";
		}
		if(params.get_ne_systemflag()!=null && !"".equals(params.get_ne_systemflag().trim())){
			sql+=" and t.systemflag="+params.get_ne_systemflag().trim()+" ";
		}
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			sql+=" and t.opnid in ("+params.get_sin_opnid()+")";
		}
		if(params.get_ne_taskid()!=null && !"".equals(params.get_ne_taskid().trim())){
			sql+=" and t.taskid="+params.get_ne_taskid().trim();
		}		
		
		PreparedStatement  pstat = null;		
		try{
			System.out.println("�������:"+sql);
			Session session = SessionUtil.currentSession(user.getCityid());
			//int num = session.connection().createStatement().executeUpdate(sql);			
			pstat =((SessionImpl)session).getBatcher().prepareStatement(sql);
			int result = pstat.executeUpdate();
			session.flush();//flushʹ�ڴ����ݱ��ͬ�������ݿ�
			System.out.println("��������"+result+"��");
			return result;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public int confirmall(CityrecordListVO params,User user) throws Exception{
		String sql = " update CH_ADT_CITYRECORD t set t.isflag = 0, t.accountoprcode = '"+user.getOpercode()
			+"', t.accountoptime = sysdate where t.isflag = 1 ";
		if (params.get_se_opnid2() != null && !params.get_se_opnid2().trim().equals("")) {
			sql += " and t.opnid in (select o.opnid from ch_pw_operation o where o.opnlevel = 5 " +
					"start with o.opnid = '" + params.get_se_opnid2().trim() + "' connect by prior o.opnid = o.parentid)";
		} else if (params.get_se_opnid() != null && !params.get_se_opnid().trim().equals("")) {
			sql += " and t.opnid in (select o.opnid from ch_pw_operation o where o.opnlevel = 5 " +
					"start with o.opnid = '" + params.get_se_opnid().trim() + "' connect by prior o.opnid = o.parentid)";
		}
		if (params.get_se_countyid() != null && !"".equals(params.get_se_countyid().trim())) {
			sql += " and exists (select 1 from ch_pw_way w where t.wayid = w.wayid and w.countyid = '"
					+ params.get_se_countyid() + "')";
		}
		if (params.get_se_wayid() != null && !"".equals(params.get_se_wayid().trim())) {
			sql += " and t.wayid = '" + params.get_se_wayid().trim() + "'";
		}
		if (params.get_se_rewardmonth() != null && !"".equals(params.get_se_rewardmonth().trim())) {
			sql += " and t.rewardmonth = '" + params.get_se_rewardmonth().trim() + "'";
		}
		if (params.get_ne_systemflag() != null && !"".equals(params.get_ne_systemflag().trim())) {
			sql += " and t.systemflag = " + params.get_ne_systemflag().trim();
		}
		if (params.get_sin_opnid() != null && !"".equals(params.get_sin_opnid().trim())) {
			sql += " and t.opnid in (" + params.get_sin_opnid() + ")";
		}
		if (params.get_ne_taskid() != null && !"".equals(params.get_ne_taskid().trim())) {
			sql += " and t.taskid = " + params.get_ne_taskid().trim();
		}
		
		PreparedStatement pstat = null;
		try {
			Session session = SessionUtil.currentSession(user.getCityid());
			// int num = session.connection().createStatement().executeUpdate(sql);
			pstat = ((SessionImpl) session).getBatcher().prepareStatement(sql);
			System.out.println("�������:" + sql);
			int result = pstat.executeUpdate();
			session.flush();// flushʹ�ڴ����ݱ��ͬ�������ݿ�
			System.out.println("�������� " + result + " ��");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public DataPackage doQueryDetail(CityrecordListVO params,User user) throws Exception{
//		String sql = new String();
		/*select t.wayid,t.opnid,t.rewardmonth,t.rewardtype , sum(busivalue),sum (paysum) , sum(paymoney) from pboss_zs.CH_ADT_CITYRECORD t 
		where 
		--��ѡ����
		--ҵ�����   t.opnid='0701010100001'   
		--������� and t.rewardtype='60' 
		--�������and t.wayid='TDZS1211002'  
		   EXISTS (SELECT WAYID FROM CH_PW_WAY A WHERE A.CHAINHEAD='JFJM00000' AND T.WAYID=A.WAYID) and
		
		 t.rewardmonth='201105' and t.isflag='0' and t.systemflag='1' 
		 group by t.wayid,t.opnid,t.rewardmonth,t.rewardtype;
		*/
		String sql ="select t.wayid,t.opnid,t.rewardmonth,t.rewardtype , sum(busivalue) as busivalue  ,sum (paysum)as paysum  , sum(paymoney) as paymoney from  CH_ADT_CITYRECORD t ";
		if(params.get_ne_isflag()!=null && !"".equals(params.get_ne_isflag().trim())){
			sql+=" where t.isflag=  '"+params.get_ne_isflag().trim()+"'";
		}
		if(params.get_ne_systemflag()!=null && !"".equals(params.get_ne_systemflag().trim())){
			sql+=" and t.systemflag=  '"+params.get_ne_systemflag().trim()+"'";
		}
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			sql+="  and t.wayid=  '"+params.get_se_wayid().trim()+"'";
		}
		if(params.getSqlopnid()!=null && !"".equals(params.getSqlopnid().trim())){
		 sql+=" and t.opnid=  '"+params.getSqlopnid().trim()+"'";
		}
		if(params.get_se_rewardmonth()!=null && !"".equals(params.get_se_rewardmonth().trim())){
		 sql+=" and t.rewardmonth=  '"+params.get_se_rewardmonth().trim()+"'";
		}
		if(params.get_se_approveid()!=null && !"".equals(params.get_se_approveid().trim())){
		 sql+=" and t.approveid=  '"+params.get_se_approveid().trim()+"'";
		}
		if(params.get_ne_rewardtype()!=null && !"".equals(params.get_ne_rewardtype().trim())){
		 sql+=" and t.rewardtype=  '"+params.get_ne_rewardtype().trim()+"'";
		}
		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
			 sql+=" and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.CHAINHEAD='"+params.get_se_chainhead().trim()+"'  AND t.WAYID=A.WAYID )  ";
			}
		sql+=" group by t.wayid,t.opnid,t.rewardmonth,t.rewardtype,t.isflag,t.systemflag ";
		
		DataPackage dp = queryBySql(sql, params);
		
		return dp;
	}
	
	/**
	 * ����ɾ�����÷�������ʹ��
	 * 20120914 ���ù��ܴ�[���г����ϸ�ϴ�����]Ǩ�Ƶ�[�����ϸ���ݲ�ѯ]�˵�
	 */
//	public void deletePart(CityrecordListVO params,User user) throws Exception{
//		
//		String delSQL = " delete from CH_ADT_CITYRECORD t ";
//		delSQL+= " where t.wayid=  '"+params.get_se_wayid()+"' ";
//		delSQL+= " and  t.opnid=  '"+params.get_se_opnid()+"' ";
//		delSQL+= " and  t.rewardtype="+params.get_ne_rewardtype()+" ";
//		delSQL+= " and t.rewardmonth=  '"+params.get_se_rewardmonth()+"' ";
//		delSQL+= " and t.isflag="+params.get_ne_isflag()+" ";
//		delSQL+= " and t.systemflag="+params.get_ne_systemflag();
//		
//		System.out.println("SQL��䣺"+delSQL);
//		
//		Session session = SessionUtil.currentSession(super.getDbFlag());
//		Connection con = session.connection();
////		PreparedStatement stmt = con.prepareStatement(truncateSQL);
//		PreparedStatement stmt = con.prepareStatement(delSQL);
//		//stmt.execute();
//		int num = stmt.executeUpdate();
//		System.out.println("ɾ������"+num+"��");
//		stmt.close();
//		session.flush();		
//	}

	/**
	 * ȫ��ɾ������д�÷���
	 * 20120914 ���ù��ܴ�[���г����ϸ�ϴ�����]Ǩ�Ƶ�[�����ϸ���ݲ�ѯ]�˵�
	 */
//	public void deleteall(CityrecordListVO params,User user) throws Exception{		
//		String delSQL = " delete from CH_ADT_CITYRECORD t ";
//		delSQL+= " where t.isflag=  '"+params.get_ne_isflag()+"' ";
//		delSQL+= " and t.rewardmonth=  '"+params.get_se_rewardmonth()+"' ";		
//		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
//			delSQL+="  and t.wayid=  '"+params.get_se_wayid().trim()+"'";
//			params.set_se_wayid(null);
//		}
//		//ҵ��������
//		if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
//		 delSQL+=" and t.mobile=  '"+params.get_se_mobile().trim()+"'";
//		 params.set_se_mobile(null);
//		}
//		//ҵ��㼶���루��ѡ��
//		if(params.getSqlopnid()!=null && !"".equals(params.getSqlopnid().trim())){
//		 delSQL+=" and t.opnid  in (select o.opnid from ch_pw_operation o where o.opnlevel = 5 and o.opnid=t.opnid start with o.opnid = '"+params.getSqlopnid().trim()+"' connect by prior o.opnid = o.parentid ) ";
//		 params.setSqlopnid(null);
//		}
//		//ҵ����루��ѡ������2���ط��е���
//		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
//		 delSQL+=" and t.opnid  in ("+params.get_sin_opnid().trim()+")";
//		 params.set_sin_opnid(null);
//		}
//		//���ò��û����
////		if(params.get_ne_rewardtype()!=null && !"".equals(params.get_ne_rewardtype().trim())){
////		 delSQL+=" and t.rewardtype=  '"+params.get_ne_rewardtype().trim()+"'";
////		 params.set_ne_rewardtype(null);
////		}
//		if(params.get_ne_systemflag()!=null && !"".equals(params.get_ne_systemflag().trim())){
//			delSQL+=" and t.systemflag=  '"+params.get_ne_systemflag().trim()+"'";
//			params.set_ne_systemflag(null);
//		}
//		if(params.get_ne_taskid()!=null && !"".equals(params.get_ne_taskid().trim())){
//			 delSQL+=" and t.taskid=  '"+params.get_ne_taskid().trim()+"'";
//			 params.set_ne_taskid(null);
//			}
//		if(params.get_se_chainhead()!=null && !"".equals(params.get_se_chainhead().trim())){
//			 delSQL+=" and t.wayid in ( SELECT WAYID FROM CH_PW_WAY A WHERE A.CHAINHEAD='"+params.get_se_chainhead().trim()+"'  AND t.WAYID=A.WAYID )  ";
//			 params.set_se_chainhead(null);
//		}
//		if(params.get_se_countyid()!=null && !"".equals(params.get_se_countyid().trim())){
//			 delSQL+=" and t.wayid in ( SELECT WAYID FROM CH_PW_WAY A WHERE A.countyid='"+params.get_se_countyid().trim()+"'  AND t.WAYID=A.WAYID )  ";
//			 params.set_se_countyid(null);
//		}
//		
//		System.out.println("SQL��䣺"+delSQL);
//		
//		Session session = SessionUtil.currentSession(super.getDbFlag());
//		Connection con = session.connection();
////		PreparedStatement stmt = con.prepareStatement(truncateSQL);
//		PreparedStatement stmt = con.prepareStatement(delSQL);
//		//stmt.execute();
//		int num = stmt.executeUpdate();
//		System.out.println("ɾ������"+num+"��");
//		stmt.close();
//		session.flush();		
//	}	
	public int deleteall(CityrecordListVO params,User user) throws Exception{	
		StringBuilder sb = new StringBuilder();
		//ֻ��ͬ����ch_adt_cityrecord����ߵ����ϴ��Ĵ�ȷ����������ɾ��
		sb.append("delete from CH_ADT_CITYRECORD t where t.isflag=1 ");
		if(params.get_se_countyid()!=null && params.get_se_countyid().trim().length()>0){
			sb.append(" and exists (select 1 from ch_pw_way w where w.countyid='"+params.get_se_countyid().trim()+"' and t.wayid=w.wayid)");
		}
		if(params.get_se_rewardmonth()!=null && !"".equals(params.get_se_rewardmonth().trim())){
			sb.append(" and t.rewardmonth='"+params.get_se_rewardmonth().trim()+"' ");
		}
		if(params.get_se_oprmonth()!=null && !"".equals(params.get_se_oprmonth().trim())){
			sb.append(" and to_char(t.oprtime,'yyyyMM')='"+params.get_se_oprmonth().trim()+"' ");
		}
		if(params.get_se_wayid()!=null && !"".equals(params.get_se_wayid().trim())){
			sb.append(" and t.wayid='"+params.get_se_wayid().trim()+"' ");
		}
		if(params.get_ne_rewardtype()!=null && !"".equals(params.get_ne_rewardtype().trim())){
			sb.append(" and t.rewardtype="+params.get_ne_rewardtype());
		}
		if(params.get_ne_systemflag()!=null && !"".equals(params.get_ne_systemflag().trim())){
			sb.append(" and t.systemflag="+params.get_ne_systemflag());
		}
		if(params.get_se_mobile()!=null && !"".equals(params.get_se_mobile().trim())){
			sb.append(" and t.mobile='"+params.get_se_mobile().trim()+"' ");
		}
		if(params.get_sin_opnid()!=null && !"".equals(params.get_sin_opnid().trim())){
			sb.append(" and t.opnid in("+params.get_sin_opnid()+") ");
		}
		if(params.get_ne_taskid()!=null && !"".equals(params.get_ne_taskid().trim())){
			sb.append(" and t.taskid="+params.get_ne_taskid().trim());
		}
		System.out.println("SQL��䣺"+sb.toString());
		
		PreparedStatement pstat = null;
		try{
			Session session = SessionUtil.currentSession(super.getDbFlag());
//			con = session.connection();
//			stmt = con.prepareStatement(sb.toString());
			pstat =((SessionImpl)session).getBatcher().prepareStatement(sb.toString());
			int num = pstat.executeUpdate();
			System.out.println("ɾ������"+num+"��");
			pstat.close();
			session.flush();		
			return num;
		}finally{
			if(pstat!=null){
				pstat.close();
			}
		}		
	}
	
	public DataPackage doQuerycount(CityrecordListVO params, User user) throws Exception{
		StringBuilder sb = new StringBuilder();
		sb.append("select t.RECORDID,t.OPNID,t.WAYID,t.REWARDTYPE,t.REWARDMONTH,t.MOBILE,t.OPRTIME,t.BUSIVALUE,t.PAYSUM,");
		sb.append("t.APPROVEID,t.ISFLAG,t.OPRCODE,t.OPTIME,t.SYSTEMFLAG,t.REWARDLISTID,t.PAYMONEY,t.TASKID,t.BRAND,");
		sb.append("t.ACCOUNTOPRCODE,t.ACCOUNTOPTIME,t.BATCHNO,t.PAYMENTOPTIME,t.ADJUSTOPTIME,t.ADJUSTOPRCODE,t.PAYMENTOPRCODE");
		sb.append(" from  CH_ADT_CITYRECORD t where 1=1");
		if (params.get_ne_isflag() != null && !"".equals(params.get_ne_isflag().trim())) {
			sb.append(" and t.isflag=" + params.get_ne_isflag().trim());
			params.set_ne_isflag(null);
		}
		if (params.get_ne_systemflag() != null	&& !"".equals(params.get_ne_systemflag().trim())) {
			sb.append(" and t.systemflag=" + params.get_ne_systemflag().trim());
			params.set_ne_systemflag(null);
		}
		if (params.get_ne_taskid() != null	&& !"".equals(params.get_ne_taskid().trim())) {
			sb.append(" and t.taskid=  '" + params.get_ne_taskid().trim()+ "'");
			params.set_ne_taskid(null);
		}
		if (params.get_se_wayid() != null	&& !"".equals(params.get_se_wayid().trim())) {
			sb.append("  and t.wayid=  '" + params.get_se_wayid().trim() + "'");
			params.set_se_wayid(null);
		}
		if (params.get_se_mobile() != null	&& !"".equals(params.get_se_mobile().trim())) {
			sb.append(" and t.mobile=  '" + params.get_se_mobile().trim()+ "'");
			params.set_se_mobile(null);
		}
		if (params.get_sin_opnid() != null	&& !"".equals(params.get_sin_opnid().trim())) {
			sb.append(" and t.opnid in (" + params.get_sin_opnid().trim()+ ")");
			params.set_sin_opnid(null);
		}
		if (params.get_se_rewardmonth() != null	&& !"".equals(params.get_se_rewardmonth().trim())) {
			sb.append(" and t.rewardmonth=  '"+ params.get_se_rewardmonth().trim() + "'");
			params.set_se_rewardmonth(null);
		}
		if (params.get_ne_rewardtype() != null	&& !"".equals(params.get_ne_rewardtype().trim())) {
			sb.append(" and t.rewardtype=  '"+ params.get_ne_rewardtype().trim() + "'");
			params.set_ne_rewardtype(null);
		}
		if (params.get_se_chainhead() != null && !"".equals(params.get_se_chainhead().trim())) {
			sb.append(" and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.CHAINHEAD='"	+ params.get_se_chainhead().trim()+ "'  AND t.WAYID=A.WAYID )  ");
			params.set_se_chainhead(null);
		}
		if (params.get_se_countyid() != null && !"".equals(params.get_se_countyid().trim())) {
			sb.append(" and EXISTS ( SELECT WAYID FROM CH_PW_WAY A WHERE A.countyid='"	+ params.get_se_countyid().trim()+ "'  AND t.WAYID=A.WAYID )  ");
			params.set_se_countyid(null);
		}
		DataPackage dp = queryBySql(sb.toString(), params, QUERY_TYPE_COUNT);
		return dp;
	}
	
	public DataPackage doQuerystatcount(CityrecordListVO params, User user) throws Exception{
		String wayid = params.get_se_wayid();
    	String waylike = params.get_se_waylike();
    	String month = params.get_se_rewardmonth();
    	String systemflag = params.get_ne_systemflag();
    	String opnid = params.get_se_opnid();
    	String opnid2 = params.get_se_opnid2();
    	String sin_opnid = params.get_sin_opnid();
    	String isflag = params.get_ne_isflag();
    	String taskid = params.get_ne_taskid();
    	String countyid = params.get_se_countyid();
		StringBuilder sb = new StringBuilder();
		sb.append("select r.RECORDID,r.OPNID,r.WAYID,r.REWARDTYPE,r.REWARDMONTH,r.MOBILE,r.OPRTIME,r.BUSIVALUE,r.PAYSUM,");
		sb.append(" r.APPROVEID,r.ISFLAG,r.OPRCODE,r.OPTIME,r.SYSTEMFLAG,r.REWARDLISTID,r.PAYMONEY,r.TASKID,r.BRAND,");
		sb.append(" r.ACCOUNTOPRCODE,r.ACCOUNTOPTIME,r.BATCHNO,r.PAYMENTOPTIME,r.ADJUSTOPTIME,r.ADJUSTOPRCODE,r.PAYMENTOPRCODE");
		sb.append(" from (select opnid from ch_pw_operation where opnlevel=5");
		if (opnid2 != null && !opnid2.trim().equals("")) {
			sb.append("       start with opnid=:opnid connect by prior opnid=parentid");
			params.getQueryConditions().put("opnid", opnid2);
	    	params.set_se_opnid(null);
	    	params.set_se_opnid2(null);
		} else if (opnid != null && !opnid.trim().equals("")) {
			sb.append("       start with opnid=:opnid connect by prior opnid=parentid");
			params.getQueryConditions().put("opnid", opnid);
	    	params.set_se_opnid(null);
		}
		sb.append("      ) o,");
		sb.append("      ch_pw_way w,ch_adt_cityrecord r");
		sb.append(" where r.opnid=o.opnid and r.wayid=w.wayid");
		if(sin_opnid!=null && !"".equals(sin_opnid.trim())){
			sb.append(" and r.opnid in (:sinopnid)");
			List<String> sin_opnids = new ArrayList<String>();
			String[] opnids = sin_opnid.split(",");
			for(String op:opnids){
				sin_opnids.add(op.substring(1,op.length()-1));
			}			
			params.getQueryConditions().put("sinopnid", sin_opnids);
			params.set_sin_opnid(null);
		}
		if(waylike!=null && !"".equals(waylike.trim())){
			sb.append("   and w.wayname like :waylike");
			params.getQueryConditions().put("waylike", waylike);
			params.set_se_waylike(null);
		}
		if(countyid!=null && !"".equals(countyid.trim())){
			sb.append("	  and w.countyid=:countyid");
			params.getQueryConditions().put("countyid", countyid);
			params.set_se_countyid(null);
		}
		if(isflag!=null && !"".equals(isflag.trim())){
			sb.append(" and r.isflag=:isflag ");
			params.getQueryConditions().put("isflag", isflag);
			params.set_ne_isflag(null);
		}else{
			sb.append(" and r.isflag in (0, 1)  ");
		}
		if(systemflag!=null && !"".equals(systemflag.trim())){
			sb.append("   and r.systemflag=:systemflag");
			params.getQueryConditions().put("systemflag", systemflag);
			params.set_ne_systemflag(null);
		}
		if(wayid!=null && !"".equals(wayid.trim())){
			sb.append("   and r.wayid=:wayid");	
			params.getQueryConditions().put("wayid", wayid);
			params.set_se_wayid(null);
		}
		if(month!=null && !"".equals(month.trim())){
			sb.append("   and r.rewardmonth=:month");	
			params.getQueryConditions().put("month", month);
			params.set_se_rewardmonth(null);
		}		
		if(taskid!=null && !"".equals(taskid.trim())){
			sb.append("   and r.taskid=:taskid");
			params.getQueryConditions().put("taskid", taskid);
			params.set_ne_taskid(null);
		}
		return this.queryBySql(sb.toString(), params, this.QUERY_TYPE_COUNT);
	}

	public int updateIsflagByDcordid(Short isflag, Long dcordid) throws Exception {
		PreparedStatement statement = null;
		try {
			Session session = SessionUtil.currentSession(getDbFlag());
			String SQL = "UPDATE CH_ADT_CITYRECORD SET ISFLAG = ? WHERE DCORDID = ?";
			statement = ((SessionImpl)session).getBatcher().prepareStatement(SQL);
			statement.setShort(1, isflag);
			statement.setLong(2, dcordid);
			int rows = statement.executeUpdate();
//			System.out.println("������CH_ADT_CITYRECORD��DCORDID�ֶ�Ϊ" + dcordid + "�ļ�¼" + rows + "�������º�isflag״̬Ϊ" + isflag);
			session.flush();
			return rows;
		} catch (Exception e) {
			throw e;
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}
	

    /**
     * �����޸ĵ�CH_ADT_DCORD���¼������CH_ADT_CITYRECORD���޸Ķ�Ӧ���ݵ�isflag״ֵ̬
     * @param isflag
     * @param dcordid
     * @return
     * @throws Exception
     */
	public int updateCityRecordIsflag(Short isflag, String batchno) throws Exception {
		PreparedStatement statement = null;
		try {
			Session session = SessionUtil.currentSession(getDbFlag());
			String SQL = "UPDATE CH_ADT_CITYRECORD C SET ISFLAG = ? WHERE EXISTS " +
					"(SELECT 1 FROM CH_ADT_DCORD D WHERE C.DCORDID = D.ID AND D.BATCHNO = ?)";
			statement = ((SessionImpl)session).getBatcher().prepareStatement(SQL);
			statement.setShort(1, isflag);
			statement.setString(2, batchno);
			int rows = statement.executeUpdate();
			session.flush();
			return rows;
		} catch (Exception e) {
			throw e;
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}
}
