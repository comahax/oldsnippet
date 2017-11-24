/**
* auto-generated code
* Fri Aug 17 16:14:58 CST 2012
*/
package com.sunrise.boss.business.cms.adjustment.persistent;

import java.sql.PreparedStatement;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.impl.SessionImpl;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: AdjustmentDAO</p>
 * <p>Description: Data Access Object for AdjustmentVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class AdjustmentDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public AdjustmentDAO(){
        super(AdjustmentVO.class);
    }
    
    private String getUpperopnids(VAdjustmentListVO params){
    	StringBuilder sbupperopnids = new StringBuilder(); 
    	if(params.get_sin_upperopnid()!=null && params.get_sin_upperopnid().get(0)!=null){
    		for(Iterator<String> it=params.get_sin_upperopnid().iterator();it.hasNext();){
    			sbupperopnids.append("'");
    			sbupperopnids.append(it.next());
    			sbupperopnids.append("',");
    		}
    	}
    	if(sbupperopnids.length()>0){
    		return sbupperopnids.substring(0, sbupperopnids.length()-1);
    	}else{
    		return null;
    	}
    }
    
    //ȫ������
    public int doSaveAllUnchecked(VAdjustmentListVO params, User user)throws Exception{
    	String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
    	String sql = null;
    	if(!params.suppertUpper()){//�����֧��ҵ�����
    		sql = this.getSQLSaveAllNoUpper(params);
    	}else{//�����֧��ҵ�����
    		sql = this.getSQLSaveAllWithUpper(params);
    	}    	
    	PreparedStatement  pstat = null;
		try{
			Session session = SessionUtil.currentSession(this.getDbFlag());			
			//pstat = session.connection().prepareStatement(sb.toString());
			pstat =((SessionImpl)session).getBatcher().prepareStatement(sql);
			pstat.setString(1, user.getOpercode());
			pstat.setString(2, cityid);
			System.out.println("Insert���:"+sql);
			int result = pstat.executeUpdate();
			session.flush();//flushʹ�ڴ����ݱ��ͬ�������ݿ�
			return result;
		}finally{
			if(pstat!=null){
				pstat.close();
			}
		}
    }
    
    private String getSQLSaveAllNoUpper(VAdjustmentListVO params)throws Exception{
    	//�����֧��ҵ�����
    	StringBuilder sb = new StringBuilder();
    	sb.append("insert into ch_adt_adjustment(id,wayid,rewardmonth,countyid,paysum,confirmoprcode,confirmptime) ");
    	sb.append("select ch_adt_adjustment_seq.nextval,C.wayid,C.rewardmonth,C.countyid,C.paysum,?,sysdate from ");
    	sb.append("(select d.wayid,d.rewardmonth,d.countyid,sum(d.moneysum) paysum ");
    	sb.append("  from ch_adt_dcord d,ch_pw_wayaccount wa,ch_pw_way w ");
    	sb.append("  where not exists(select 1 from ch_adt_adjustment a ");
    	sb.append("      where a.wayid=d.wayid and a.rewardmonth=d.rewardmonth and a.batchno is null) ");
    	sb.append("    and w.wayid=d.wayid and w.wayid=wa.wayid ");//and w.countyid=d.countyid ����ֹ�˾�����������������
    	sb.append("    and ((w.waysubtype!='DIS' and wa.accid=0) or (w.waysubtype='DIS' and wa.accid=1)) ");
    	sb.append("    and d.isflag=0 and w.waytype='AG' and w.cityid=? ");
    	if(params.get_se_countyid()!=null && params.get_se_countyid().trim().length()>0){
    		sb.append("    and d.countyid='"+params.get_se_countyid()+"' ");//and w.countyid=:countyid --��ʹ�ֹ�˾�����������þɵķֹ�˾��Ϣ
    	}
    	if(params.get_se_rewardmonth()!=null && params.get_se_rewardmonth().trim().length()>0){
    		sb.append("    and d.rewardmonth='"+params.get_se_rewardmonth()+"' ");
    	}
    	if(params.get_ne_accttype()!=null && params.get_ne_accttype().trim().length()>0){
    		sb.append("    and wa.accttype="+params.get_ne_accttype());
    	}
    	if(params.get_ne_starlevel()!=null && params.get_ne_starlevel().toString().length()>0){
    		sb.append("    and w.starlevel="+params.get_ne_starlevel());
    	}
    	if(params.get_sk_wayname()!=null && params.get_sk_wayname().trim().length()>0){
    		sb.append("    and w.wayname like '%"+params.get_sk_wayname()+"%' ");
    	}
    	if(params.get_se_chainhead()!=null && params.get_se_chainhead().trim().length()>0){
    		sb.append("    and w.chainhead='"+params.get_se_chainhead()+"' ");
    	}
    	if(params.get_se_wayid()!=null && params.get_se_wayid().trim().length()>0){
    		sb.append("    and w.wayid='"+params.get_se_wayid()+"' ");
    	}    	
    	sb.append("  group by d.countyid,d.rewardmonth,d.wayid ");
    	sb.append("  order by d.countyid,d.rewardmonth,d.wayid) C ");
    	
    	return sb.toString();
    }
    
    private String getSQLSaveAllWithUpper(VAdjustmentListVO params)throws Exception{
    	//�����֧��ҵ�����
    	StringBuilder sb = new StringBuilder();
    	String upperopnids = this.getUpperopnids(params); 
    	sb.append("insert into ch_adt_adjustment(id,wayid,rewardmonth,countyid,upperopnid,paysum,confirmoprcode,confirmptime) ");
    	sb.append("select ch_adt_adjustment_seq.nextval,C.wayid,C.rewardmonth,C.countyid,C.upperopnid,C.paysum,?,sysdate from ");
    	sb.append("(select d.wayid,d.rewardmonth,d.countyid,d.upperopnid,sum(d.moneysum) paysum ");
    	sb.append("  from ch_adt_dcord d,ch_pw_wayaccount wa,ch_pw_way w ");
    	sb.append("  where not exists(select 1 from ch_adt_adjustment a ");
    	sb.append("      where a.wayid=d.wayid and a.rewardmonth=d.rewardmonth and a.upperopnid=d.upperopnid and a.batchno is null) ");
    	sb.append("    and w.wayid=d.wayid and w.wayid=wa.wayid ");//and w.countyid=d.countyid ����ֹ�˾�����������������
    	sb.append("    and ((w.waysubtype!='DIS' and wa.accid=0) or (w.waysubtype='DIS' and wa.accid=1)) ");
    	sb.append("    and d.isflag=0 and w.waytype='AG' and w.cityid=? ");
    	if(upperopnids!=null){
    		sb.append("    and d.upperopnid in("+upperopnids+") ");
    	}
    	if(params.get_se_countyid()!=null && params.get_se_countyid().trim().length()>0){
    		sb.append("    and d.countyid='"+params.get_se_countyid()+"' ");//and w.countyid=:countyid --��ʹ�ֹ�˾�����������þɵķֹ�˾��Ϣ
    	}
    	if(params.get_se_rewardmonth()!=null && params.get_se_rewardmonth().trim().length()>0){
    		sb.append("    and d.rewardmonth='"+params.get_se_rewardmonth()+"' ");
    	}
    	if(params.get_ne_accttype()!=null && params.get_ne_accttype().trim().length()>0){
    		sb.append("    and wa.accttype="+params.get_ne_accttype());
    	}
    	if(params.get_ne_starlevel()!=null && params.get_ne_starlevel().toString().length()>0){
    		sb.append("    and w.starlevel="+params.get_ne_starlevel());
    	}
    	if(params.get_sk_wayname()!=null && params.get_sk_wayname().trim().length()>0){
    		sb.append("    and w.wayname like '%"+params.get_sk_wayname()+"%' ");
    	}
    	if(params.get_se_chainhead()!=null && params.get_se_chainhead().trim().length()>0){
    		sb.append("    and w.chainhead='"+params.get_se_chainhead()+"' ");
    	}
    	if(params.get_se_wayid()!=null && params.get_se_wayid().trim().length()>0){
    		sb.append("    and w.wayid='"+params.get_se_wayid()+"' ");
    	}    	
    	sb.append("  group by d.countyid,d.rewardmonth,d.wayid,d.upperopnid ");
    	sb.append("  order by d.countyid,d.rewardmonth,d.wayid) C ");
    	
    	return sb.toString();
    }
    
    public int doDeleteAllChecked(VAdjustmentListVO params, User user)throws Exception{
    	StringBuilder sb = new StringBuilder();
    	sb.append("DELETE FROM CH_ADT_ADJUSTMENT A");
    	sb.append(" WHERE A.BATCHNO IS NULL ");
    	sb.append("   AND EXISTS (SELECT 1 FROM CH_PW_WAYACCOUNT WA,CH_PW_WAY W");
    	sb.append("     WHERE W.WAYID=A.WAYID AND W.WAYID=WA.WAYID ");//W.COUNTYID=A.COUNTYID AND ����ֹ�˾�����������������
    	sb.append("       AND W.WAYTYPE='AG' AND W.CITYID=?");
    	if(params.get_ne_accttype()!=null && params.get_ne_accttype().trim().length()>0){
    		sb.append("	  AND WA.ACCTTYPE="+params.get_ne_accttype());
    	}
    	if(params.get_ne_starlevel()!=null && params.get_ne_starlevel().toString().length()>0){
    		sb.append("   AND W.STARLEVEL="+params.get_ne_starlevel());
    	}
    	if(params.get_sk_wayname()!=null && params.get_sk_wayname().trim().length()>0){
    		sb.append("   AND W.WAYNAME LIKE '%"+params.get_sk_wayname()+"%'");
    	}
    	if(params.get_se_chainhead()!=null && params.get_se_chainhead().trim().length()>0){
    		sb.append("	  AND W.CHAINHEAD='"+params.get_se_chainhead()+"'");
    	}
    	if(params.get_se_wayid()!=null && params.get_se_wayid().trim().length()>0){
    		sb.append("   AND W.WAYID='"+params.get_se_wayid()+"'");
    	}   	
    	sb.append("  )");
    	if(params.suppertUpper()){//֧�ָ���ҵ��������ɸ����
    		String upperopnids = this.getUpperopnids(params); 
    		if(upperopnids!=null){
    			sb.append("    AND A.UPPEROPNID in("+upperopnids+")");
    		}
    	}
    	if(params.get_se_countyid()!=null && params.get_se_countyid().trim().length()>0){
    		sb.append("   AND A.COUNTYID='"+params.get_se_countyid()+"'");//W.COUNTYID=:countyid --��ʹ�ֹ�˾�����������þɵķֹ�˾��Ϣ
    	}
    	if(params.get_se_rewardmonth()!=null && params.get_se_rewardmonth().trim().length()>0){
    		sb.append("   AND A.REWARDMONTH='"+params.get_se_rewardmonth()+"'");
    	}
    	PreparedStatement  pstat = null;
		try{
			Session session = SessionUtil.currentSession(this.getDbFlag());			
			//pstat = session.connection().prepareStatement(sb.toString());
			pstat =((SessionImpl)session).getBatcher().prepareStatement(sb.toString());
			String cityid=SessionFactoryRouter.conversionCityid(user.getCityid());
			pstat.setString(1, cityid);
			System.out.println("Delete���:"+sb.toString());
			int result = pstat.executeUpdate();
			session.flush();//flushʹ�ڴ����ݱ��ͬ�������ݿ�
			return result;
		}finally{
			if(pstat!=null){
				pstat.close();
			}
		}
    }
    
    public int doUpdatedcord(String batchno, VAdjustmentListVO params, String opercode)throws Exception{   
    	String sql = null;
    	if(!params.suppertUpper()){//��ϸch_adt_dcord����֧�ָ���ҵ��������ɸ����
    		sql = this.getSQLUpdatedcordNoUpper(params);
    	}else{//��ϸch_adt_dcord��֧�ָ���ҵ��������ɸ����
    		sql = this.getSQLUpdatedcordWithUpper(params);
    	}    	
    	PreparedStatement  pstat = null;
		try{
			Session session = SessionUtil.currentSession(this.getDbFlag());			
			//pstat = session.connection().prepareStatement(sb.toString());
			pstat =((SessionImpl)session).getBatcher().prepareStatement(sql);
			pstat.setString(1, batchno);
			pstat.setString(2, opercode);
			if(params.isSupportPaymonth() && StringUtils.isNotEmpty(params.get_paymonth())){//���ݸ����·��������˱���
				pstat.setString(3, params.get_paymonth());
			}else{
				pstat.setString(3, "");
			}
			System.out.println("Update���:"+sql);
			int result = pstat.executeUpdate();
			session.flush();//����ch_adt_payment��ʱ��Ҫ��Щ���º�����ݣ��˴�flushʹ�ڴ����ݱ��ͬ�������ݿ�
			return result;
		}finally{
			if(pstat!=null){
				pstat.close();
			}
		}
    }    
    private String getSQLUpdatedcordNoUpper(VAdjustmentListVO params){
    	//��ϸch_adt_dcord����֧�ָ���ҵ��������ɸ����
    	String countyid = params.get_se_countyid();
    	StringBuilder sb = new StringBuilder();
    	sb.append("update ch_adt_dcord t");
    	sb.append(" set t.batchno=?,t.isflag=5,t.paymentoptime=sysdate,t.paymentoprcode=?,paymonth=? ");
    	sb.append(" where exists(select 1 from CH_ADT_DCORD d,ch_adt_adjustment a ");
    	sb.append("  where d.wayid=a.wayid and d.rewardmonth=a.rewardmonth ");
    	sb.append("  and d.batchno is null and d.isflag=0 and a.batchno is null ");
    	if(countyid!=null && countyid.trim().length()>0){//���зֹ�˾Ȩ��ʱ
			sb.append(" and a.countyid='"+countyid+"' ");
		}
    	sb.append("  and d.id=t.id) ");
    	if(countyid!=null && countyid.trim().length()>0){//���зֹ�˾Ȩ��ʱ
			sb.append(" and t.countyid='"+countyid+"' ");
		}
    	return sb.toString();
    }
    private String getSQLUpdatedcordWithUpper(VAdjustmentListVO params){
    	//��ϸch_adt_dcord��֧�ָ���ҵ��������ɸ����
    	String countyid = params.get_se_countyid();
    	String upperopnids = this.getUpperopnids(params);
    	String rewardmonth = params.get_se_rewardmonth();
    	StringBuilder sb = new StringBuilder();
    	sb.append("update ch_adt_dcord t");
    	sb.append(" set t.batchno=?,t.isflag=5,t.paymentoptime=sysdate,t.paymentoprcode=?,paymonth=? ");
    	sb.append(" where exists(select 1 from CH_ADT_DCORD d,ch_adt_adjustment a ");
    	sb.append("  where d.wayid=a.wayid and d.rewardmonth=a.rewardmonth and d.upperopnid=a.upperopnid");
    	sb.append("  and d.batchno is null and d.isflag=0 and a.batchno is null ");
    	if(countyid!=null && countyid.trim().length()>0){//���зֹ�˾Ȩ��ʱ
			sb.append(" and a.countyid='"+countyid+"' ");
		}
    	if(upperopnids!= null ){//ҵ�����
    		sb.append("    and a.upperopnid in("+upperopnids+")");
    	}
    	if(rewardmonth!=null && rewardmonth.trim().length()>0){//�����·�
    		sb.append("    and a.rewardmonth='"+rewardmonth+"'");
    	}
    	sb.append("  and d.id=t.id) ");
    	if(countyid!=null && countyid.trim().length()>0){//���зֹ�˾Ȩ��ʱ
			sb.append(" and t.countyid='"+countyid+"' ");
		}
    	return sb.toString();
    }
    
    public int doUpdateadjustment(String batchno, VAdjustmentListVO params)throws Exception{
    	String sql = null;
    	if(!params.suppertUpper()){//��ϸch_adt_adjustment����֧�ָ���ҵ��������ɸ����
    		sql = this.getSQLUpdateadjustNoUpper(params);
    	}else{//��ϸch_adt_adjustment��֧�ָ���ҵ��������ɸ����
    		sql = this.getSQLUpdateAdjustWithUpper(params);
    	}
    	PreparedStatement  pstat = null;
		try{
			Session session = SessionUtil.currentSession(this.getDbFlag());			
			//pstat = session.connection().prepareStatement(sb.toString());
			pstat =((SessionImpl)session).getBatcher().prepareStatement(sql);
			pstat.setString(1, batchno);
			System.out.println("Update���:"+sql);
			int result = pstat.executeUpdate();
			session.flush();
			return result;
		}finally{
			if(pstat!=null){
				pstat.close();
			}
		}
    }
    private String getSQLUpdateadjustNoUpper(VAdjustmentListVO params){
    	//��ϸch_adt_adjustment����֧�ָ���ҵ��������ɸ����
    	String countyid = params.get_se_countyid();
    	StringBuilder sb = new StringBuilder();
    	sb.append("update ch_adt_adjustment t set t.batchno=? where t.batchno is null");
    	if(countyid!=null && countyid.trim().length()>0){//���зֹ�˾Ȩ��ʱ
			sb.append(" and t.countyid='"+countyid+"' ");
		}
    	return sb.toString();
    }
    private String getSQLUpdateAdjustWithUpper(VAdjustmentListVO params){
    	//��ϸch_adt_adjustment��֧�ָ���ҵ��������ɸ����
    	String countyid = params.get_se_countyid();
    	String upperopnids = this.getUpperopnids(params);
    	String rewardmonth = params.get_se_rewardmonth();
    	StringBuilder sb = new StringBuilder();
    	sb.append("update ch_adt_adjustment t set t.batchno=? where t.batchno is null");
    	if(upperopnids!=null){
    		sb.append("    and t.upperopnid in("+upperopnids+")");
    	}
    	if(rewardmonth!=null && rewardmonth.trim().length()>0){
    		sb.append("    and t.rewardmonth='"+rewardmonth+"'");
    	}
    	if(countyid!=null && countyid.trim().length()>0){//���зֹ�˾Ȩ��ʱ
			sb.append(" and t.countyid='"+countyid+"' ");
		}
    	return sb.toString();
    }
    
    public int doCreatepayment(String batchno, VAdjustmentListVO params) throws Exception{
    	String sql = null;
    	if(!params.suppertUpper()){//����ch_adt_payment����֧�ָ���ҵ��������ɸ����
    		sql = this.getSQLCreatepaymNoUpper(params);
    	}else{//����ch_adt_payment��֧�ָ���ҵ��������ɸ����
    		sql = this.getSQLCreatepaymWithUpper(params);
    	}
		PreparedStatement  pstat = null;
		try{
			Session session = SessionUtil.currentSession(this.getDbFlag());			
			//pstat = session.connection().prepareStatement(sb.toString());
			pstat =((SessionImpl)session).getBatcher().prepareStatement(sql);
			pstat.setString(1, batchno);
			pstat.setString(2, batchno);
			System.out.println("Insert���:"+sql);
			int result = pstat.executeUpdate();
			session.flush();
			return result;
		}finally{
			if(pstat!=null){
				pstat.close();
			}
		}		
    }
    private String getSQLCreatepaymNoUpper(VAdjustmentListVO params){
    	//����ch_adt_payment����֧�ָ���ҵ��������ɸ����
    	String countyid = params.get_se_countyid();
    	StringBuilder sb = new StringBuilder();
    	if(!params.supportSubopnReport()){//��֧�ָ����ҵ��С��չʾ
    		sb.append("insert into ch_adt_payment(id,rewardmonth,wayid,upperopnid,upperopnmoney,batchno) ");
    		sb.append("select ch_adt_payment_seq.nextval,C.rewardmonth,C.wayid,C.upperopnid,C.paysum,? ");
    		sb.append("from (select d.rewardmonth,d.wayid,d.upperopnid,sum(d.busivaluesum) busisum,sum(d.moneysum) paysum" );
    		sb.append("  from ch_adt_dcord d ");
    		sb.append("  where d.batchno=? ");
    		if(countyid!=null && countyid.trim().length()>0){//���зֹ�˾Ȩ��ʱ
    			sb.append(" and d.countyid='"+countyid+"' ");
    		}
    		sb.append("  group by d.rewardmonth,d.wayid,d.upperopnid) C");	
    	}else{//֧�ָ����ҵ��С��չʾ
    		sb.append("insert into ch_adt_payment(id,rewardmonth,wayid,upperopnid,upperopnmoney,batchno) ");
    		sb.append("select ch_adt_payment_seq.nextval,C.rewardmonth,C.wayid,C.subasupper,C.paysum,? ");
    		sb.append("from (select d.rewardmonth,d.wayid,d.subopnid subasupper,sum(d.busivaluesum) busisum,sum(d.moneysum) paysum" );
    		sb.append("  from ch_adt_dcord d ");
    		sb.append("  where d.batchno=? ");
    		if(countyid!=null && countyid.trim().length()>0){//���зֹ�˾Ȩ��ʱ
    			sb.append(" and d.countyid='"+countyid+"' ");
    		}
    		sb.append("  group by d.rewardmonth,d.wayid,d.subopnid) C");	
    	}
		return sb.toString();
    }
    private String getSQLCreatepaymWithUpper(VAdjustmentListVO params){
    	//����ch_adt_payment��֧�ָ���ҵ��������ɸ����
    	String countyid = params.get_se_countyid();
    	String upperopnids = this.getUpperopnids(params);
    	String rewardmonth = params.get_se_rewardmonth();
    	StringBuilder sb = new StringBuilder();
    	if(!params.supportSubopnReport()){//��֧�ָ����ҵ��С��չʾ
    		sb.append("insert into ch_adt_payment(id,rewardmonth,wayid,upperopnid,upperopnmoney,batchno) ");
    		sb.append("select ch_adt_payment_seq.nextval,C.rewardmonth,C.wayid,C.upperopnid,C.paysum,? ");
    		sb.append("from (select d.rewardmonth,d.wayid,d.upperopnid,sum(d.busivaluesum) busisum,sum(d.moneysum) paysum" );
    		sb.append("  from ch_adt_dcord d ");
    		sb.append("  where d.batchno=? ");
    		if(upperopnids!=null){
    			sb.append("    and d.upperopnid in("+upperopnids+")");
    		}
    		if(rewardmonth!=null && rewardmonth.trim().length()>0){
    			sb.append("    and d.rewardmonth='"+rewardmonth+"'");
    		}
    		if(countyid!=null && countyid.trim().length()>0){//���зֹ�˾Ȩ��ʱ
    			sb.append(" and d.countyid='"+countyid+"' ");
    		}
    		sb.append("  group by d.rewardmonth,d.wayid,d.upperopnid) C");		
    	}else{//֧�ָ����ҵ��С��չʾ
    		sb.append("insert into ch_adt_payment(id,rewardmonth,wayid,upperopnid,upperopnmoney,batchno) ");
    		sb.append("select ch_adt_payment_seq.nextval,C.rewardmonth,C.wayid,C.subasupper,C.paysum,? ");
    		sb.append("from (select d.rewardmonth,d.wayid,d.subopnid subasupper,sum(d.busivaluesum) busisum,sum(d.moneysum) paysum" );
    		sb.append("  from ch_adt_dcord d ");
    		sb.append("  where d.batchno=? ");
    		if(upperopnids!=null){
    			sb.append("    and d.upperopnid in("+upperopnids+")");
    		}
    		if(rewardmonth!=null && rewardmonth.trim().length()>0){
    			sb.append("    and d.rewardmonth='"+rewardmonth+"'");
    		}
    		if(countyid!=null && countyid.trim().length()>0){//���зֹ�˾Ȩ��ʱ
    			sb.append(" and d.countyid='"+countyid+"' ");
    		}
    		sb.append("  group by d.rewardmonth,d.wayid,d.subopnid) C");		
    	}
		return sb.toString();
    }
}
