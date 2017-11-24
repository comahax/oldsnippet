/**
* auto-generated code
* Tue Aug 22 21:42:23 CST 2006
*/
package com.sunrise.boss.business.common.subscriber.control;

import java.io.Serializable;
import java.sql.ResultSet;


import com.sunrise.boss.business.common.subscriber.persistent.SubscriberDAO;
import com.sunrise.boss.business.common.subscriber.persistent.SubscriberListVO;
import com.sunrise.boss.business.common.subscriber.persistent.SubscriberVO;
import com.sunrise.boss.business.fee.realtran.payway.SqlUtils;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: SubscriberControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xqy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/common/subscriber/control/SubscriberControlBean"
*    name="SubscriberControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class SubscriberControlBean extends AbstractControlBean implements SubscriberControl
 {
    public SubscriberVO doFindByPk(Serializable pk, User user)
        throws Exception {
    	SubscriberDAO dao = (SubscriberDAO) DAOFactory.build(SubscriberDAO.class, user.getCityid());    	
        return (SubscriberVO) dao.findByPk(pk);
    }

    /*
     * 根据号码获取帐户标识
     * 
     */
	public String GetServnumByAcctid(Long acctid, User user) throws Exception {
    	SubscriberDAO dao = (SubscriberDAO) DAOFactory.build(SubscriberDAO.class, user.getCityid());    
		return dao.GetServnumByAcctid(acctid);
	}

	/*
	 * 根据号码获取用户标识
	 * 
	 */
	public String GetServnumBySubsid(Long subsid, User user) throws Exception {
    	SubscriberDAO dao = (SubscriberDAO) DAOFactory.build(SubscriberDAO.class, user.getCityid());    
		return dao.GetServnumBySubsid(subsid);
	}
	
	  public String GetServnumByCustid(Long custid, User user) throws Exception {
		  SubscriberDAO dao = (SubscriberDAO) DAOFactory.build(SubscriberDAO.class, user.getCityid());    
			return dao.GetServnumByCustid(custid);
	  }
	
	/*
	 * 根据帐户标识获取用户号码
	 */
    public Long GetAcctidByServnum(java.lang.String servnumber, User user) throws Exception{
    	SubscriberDAO dao = (SubscriberDAO) DAOFactory.build(SubscriberDAO.class, user.getCityid());   
    	return dao.GetAcctidByServnum(servnumber);
    }  
    
    /*
     * 根据号码获取用户标识
     */
    public Long GetSubsidByServnum(java.lang.String servnumber, User user) throws Exception{
    	SubscriberDAO dao = (SubscriberDAO) DAOFactory.build(SubscriberDAO.class, user.getCityid());   
    	return dao.GetSubsidByServnum(servnumber);
    } 
    
    /*     add by xiefufeng      */
    public Long GetCustidByServnum(java.lang.String servnumber, User user) throws Exception{
    	SubscriberDAO dao = (SubscriberDAO) DAOFactory.build(SubscriberDAO.class, user.getCityid());   
    	return dao.GetCustidByServnum(servnumber);
    } 
    
    /*
     * 根据号码查找用户信息
     */
    public SubscriberVO doFindByServnum(java.lang.String servnumber, User user) throws Exception{
    	SubscriberDAO dao = (SubscriberDAO) DAOFactory.build(SubscriberDAO.class, user.getCityid());  
    	return dao.FindByServnum(servnumber);
    }
    
    /*
     * 根据集团号码或者个人号码查找用户信息
     */
    public SubscriberVO doFindByGServnum(java.lang.String servnumber, User user) throws Exception{
    	SubscriberDAO dao = (SubscriberDAO) DAOFactory.build(SubscriberDAO.class, user.getCityid());  
    	return dao.FindByGServnum(servnumber);
    }
    
    public DataPackage doQueryByNo(SubscriberListVO listvo, User user) throws Exception {
    	
    	if(null != listvo && !"".equals(listvo.get_se_servnumber())){
    		SubscriberDAO dao = (SubscriberDAO) DAOFactory.build(SubscriberDAO.class, user.getCityid());  
     		
    		if(listvo.get_orderby() == null || "".equals(listvo.get_orderby())){
    			listvo.set_orderby("status");
    		}

    		
    		DataPackage dp = dao.query(listvo);

    		return dp;
    	}
    	return null;
    }
    
    public Long getValidSusbidByServnumber(Object params ,User user) throws Exception{
    	SubscriberDAO dao = (SubscriberDAO) DAOFactory.build(SubscriberDAO.class, user.getCityid());  
    	return dao.getValidSusbidByServnumber(params, user);
   }
    
    
    public long doQueryMainSubs(SubscriberListVO listvo, User user) throws Exception {
    	
    	long subsid = -1; 
    	
    	if(null != listvo && null != listvo.get_ne_subsid() && !"".equals(listvo.get_ne_subsid())){
    		StringBuffer sqlBuffer = new StringBuffer("select agsm.subsid from cm_group_member agsm, cm_group_subscriber ags ")
	    		.append(" where agsm.groupoid  in ( ")
	    		.append(" select gsm.groupoid from cm_group_subscriber gs, cm_group_member gsm,pc_prod_main pd ")
	    		.append(" where gs.subsid = gsm.groupoid and gs.prodid = pd.prodid ")
	    		.append(" and pd.grouptype = 'GrpPrdHomePlan' and gsm.status = 'stcmNml' ")
	    		.append(" and gs.region = gsm.region and gs.region = pd.region ")
	    		.append(" and gsm.subsid = ").append(listvo.get_ne_subsid())
	    		.append(" ) and ags.subsid = agsm.groupoid and ags.dependsubsid = agsm.subsid ");    		
    		
    		ResultSet rs = null;  
    		
    		System.out.println(sqlBuffer.toString());    		
    		
    		try{					
    			rs = SqlUtils.getBSQLStatement( sqlBuffer.toString(), user.getCityid()).executeQuery();
    			
    			if( rs != null && rs.next() ){
    				subsid = rs.getLong(1);
    			}
    		}catch(Exception ex){
    			throw ex;
    		}finally{
    			if( rs != null ){
    				rs.close();
    			}
    		}

    		return subsid;
    	}
    	return subsid;
    }
    
    
    
}
