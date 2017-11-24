/**
 * auto-generated code
 * Tue Sep 01 14:28:15 CST 2009
 */
package com.gmcc.pboss.business.resource.comressmp;

import java.util.List;

import com.sunrise.jop.common.utils.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

/**
 * <p>Title: ComressmpDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ComressmpDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public ComressmpDAO(){
        super(ComressmpVO.class);
    }
    
    public List doQueryTrunksOrBoxesForPrint(ComressmpDBParam param) throws Exception {
    	StringBuffer hqlSb = new StringBuffer();
    	hqlSb.append("select crs.boxnum,max(crs.comid),max(crs.wayid),max(crs.comactive),count(crs.boxnum) from ComressmpVO crs ");
    	hqlSb.append("where crs.batchno = :batchno ");
    	if(param.get_ne_comid() != null 
    			&& !"".equals(param.get_ne_comid().toString())) {
    		
    		hqlSb.append("and crs.comid = :comid ");
    	}
    	if(!StringUtils.isEmpty(param.get_se_wayid())) {
    		hqlSb.append("and crs.wayid = :wayid ");
    	}
    	if(!StringUtils.isEmpty(param.get_ssw_boxnum())) {
    		hqlSb.append("and crs.boxnum like :boxnum ");
    	}
    	hqlSb.append("group by crs.boxnum order by crs.boxnum asc");
    	
    	Session session = null;
    	try {
	    	session = SessionUtils.currentSession(getDbFlag());
	    	Query query = session.createQuery(hqlSb.toString());
	    	query.setString("batchno",param.get_se_batchno());
	    	if(param.get_ne_comid() != null 
	    			&& !"".equals(param.get_ne_comid().toString())) {
	    		query.setLong("comid", param.get_ne_comid());
	    	}
	    	if(!StringUtils.isEmpty(param.get_se_wayid())) {
	    		query.setString("wayid",param.get_se_wayid());
	    	}
	    	if(!StringUtils.isEmpty(param.get_ssw_boxnum())) {
	    		query.setString("boxnum",param.get_ssw_boxnum()+"-%");
	    	}
	    	List list = query.list();
	    	return list;
    	} catch (HibernateException ex) {
    		
	        if (ex.getCause() != null) {
	            throw new Exception(ex.getCause());
	        }
	        else {
	            throw ex;
	        }
	    }
    }
    /**
     * 根据批次和包号查询套卡资源表获取最大包内序号
     * @param param
     * @return
     * @throws Exception
     */
    public Integer doMaxInsideseq(ComressmpDBParam param) throws Exception {
    	StringBuffer hqlSb = new StringBuffer();
    	hqlSb.append("select max(c.insideseq) from ComressmpVO c ");
    	hqlSb.append("where c.batchno = :batchno ");
    	hqlSb.append("and c.boxnum = :boxnum ");
    	
    	Session session = null;
    	try {
	    	session = SessionUtils.currentSession(getDbFlag());
	    	Query query = session.createQuery(hqlSb.toString());
	    	if(!StringUtils.isEmpty(param.get_se_batchno())) {
	    		query.setString("batchno",param.get_se_batchno());
	    	}
	    	
	    	if(!StringUtils.isEmpty(param.get_se_boxnum())) {
	    		query.setString("boxnum",param.get_se_boxnum());
	    	}
	    	List list = query.list();
	    	if(list!=null && list.size()>0)
	    		return list.get(0)==null?0:(Integer)list.get(0);
	    	else
	    		return 0;
    	} catch (HibernateException ex) {
    		
	        if (ex.getCause() != null) {
	            throw new Exception(ex.getCause());
	        }
	        else {
	            throw ex;
	        }
	    }
    }
    public Long queryBuyresource(String countyid,String comcategory) throws Exception {
    	
    	Session session = SessionUtils.currentSession(getDbFlag());
		Query query = session.getNamedQuery("com.gmcc.pboss.business.resource.comcategoryrela.buyresource");
		query.setString("COUNTYID1", countyid);
		query.setString("COMCATEGORY1", comcategory);
		query.setString("COUNTYID2", countyid);
		query.setString("COMCATEGORY2", comcategory);
		List<Long> list = query.list();
		if(list.size()==0){
			return 0l;
		}
		return list.get(0);
    }
}
