package com.sunrise.boss.business.fee.hangbill.persistent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.SessionUtil;

public class WoffCustDAO extends BaseDAO {

    /**
     * default constructor
     */
    public WoffCustDAO(){
        super(WoffCustVO.class);
    }
    //changed by lwj 
//    public List findByEboxidAndCyc(Long eboxid,Integer validbillcyc) throws Exception {
//    	StringBuffer buf = new StringBuffer("select eboxid from WoffCustVO ")
//    	.append("where eboxid = :eboxid and validbillcyc = :validbillcyc ");
//    	Session session = SessionUtil.currentSession(this.getDbFlag());
//    	try {
//    		Query query = session.createQuery(buf.toString());
//    		
//    		query.setLong("eboxid", eboxid.longValue());
//    		query.setInteger("validbillcyc", validbillcyc.intValue());
//    		return query.list();
//    	} catch (HibernateException ex) {
//    		throw ex;
//    	}
//    }
    //changed by lwj 因为销帐表太大，sql执行过慢 
    
    public List findByEboxidAndCyc(Long eboxid,Integer validbillcyc) throws Exception {
    	List result=new ArrayList();
    	List temp=null;
    	StringBuffer buf = new StringBuffer("select eboxid, validbillcyc from WoffCustVO ")
    	.append("where eboxid = :eboxid");
    	Session session = SessionUtil.currentSession(this.getDbFlag());
    	try {
    		Query query = session.createQuery(buf.toString());
    		
    		query.setLong("eboxid", eboxid.longValue());
//    		query.setInteger("validbillcyc", validbillcyc.intValue());
    		temp=query.list();
    		for (int i=0;i<temp.size();i++) {
				Object[] element = (Object[]) temp.get(i);				
				if(((Integer)element[1]).compareTo(validbillcyc)==0)
					result.add(element[0]);
			}
    		return result;
    	} catch (HibernateException ex) {
    		throw ex;
    	}
    }
    /**按帐务周期统计已完全销帐帐单金额，取得结果集  add by mys***/
    public List doQueryForTotal(WoffCustListVO params) throws Exception {
		
		if (null != params ) {
			Integer validbillcyc = null ;
			Long eboxid = new Long(params.get_ne_eboxid());
			
			if(null != params.get_ne_validbillcyc() && !"".equals(params.get_ne_validbillcyc()))
				validbillcyc = new Integer(Integer.parseInt(params.get_ne_validbillcyc()));
			
			
			if(null != eboxid){
				
				StringBuffer sql = new StringBuffer("select this.eboxid,this.subsid,")
							.append("this.validbillcyc,sum(this.recamt),sum(this.paiclupamt)")
							.append(" from ").append(WoffCustVO.class.getName()).append(" this")
							.append(" where ").append("this.eboxid = :eboxid and ");

				
				if (validbillcyc != null)
					sql.append("this.validbillcyc = :validbillcyc and ");
				
				

				
				sql = sql.delete(sql.length() - 4,sql.length() - 1);
				
				sql.append("group by this.subsid,this.eboxid,this.validbillcyc ")
					.append("order by this.subsid,this.eboxid,this.validbillcyc desc ");

				
				try {
					
					Session session = SessionUtil.currentSession(getDbFlag());
					Query query = session.createQuery(sql.toString());
					query.setLong("eboxid", eboxid.longValue());

					if (validbillcyc != null)
						query.setInteger("validbillcyc", validbillcyc.intValue());

					return query.list();
				} catch (HibernateException ex) {
					if (ex.getCause() != null) {
						throw new Exception(ex.getCause());
					} else {
						throw ex;
					}
				}
			}
		}	
		return null;	
			
		
	}
}
