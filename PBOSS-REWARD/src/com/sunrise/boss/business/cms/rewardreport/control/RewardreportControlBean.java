/**
* auto-generated code
* Thu May 19 16:35:37 CST 2011
*/
package com.sunrise.boss.business.cms.rewardreport.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardreport.persistent.RewardreportVO;
import com.sunrise.boss.business.cms.rewardreport.persistent.RewardreportDAO;
import com.sunrise.boss.business.cms.rewardreport.persistent.RewardreportListVO;
import com.sunrise.boss.business.cms.rewardreport.persistent.V_RewardreportDAO;

/**
 * <p>Title: RewardreportControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/rewardreport/control/RewardreportControlBean"
 name="RewardreportControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RewardreportControlBean extends AbstractControlBean
    implements RewardreportControl {

    public RewardreportVO doCreate(RewardreportVO vo, User user)
        throws Exception {
        try{
			RewardreportDAO dao = (RewardreportDAO) DAOFactory.build(RewardreportDAO.class, user);
            // TODO  set the pk */
            return (RewardreportVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(RewardreportVO vo, User user)
        throws Exception {
        try{
			RewardreportDAO dao = (RewardreportDAO) DAOFactory.build(RewardreportDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RewardreportVO doUpdate(RewardreportVO vo, User user)
        throws Exception {
        try{
			RewardreportDAO dao = (RewardreportDAO) DAOFactory.build(RewardreportDAO.class, user);
            return (RewardreportVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RewardreportVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RewardreportDAO dao = (RewardreportDAO) DAOFactory.build(RewardreportDAO.class, user);
        return (RewardreportVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(RewardreportListVO params, User user)
        throws Exception {
			RewardreportDAO dao = (RewardreportDAO) DAOFactory.build(RewardreportDAO.class, user);
			DataPackage dp = null;
			// 保存发送时间
	    	String date = params.get_de_sendtime();
	    	params.set_de_sendtime(null);
	    	// 保存分公司
	    	String countyid = params.get_se_countyid();
	    	params.set_se_countyid(null);
	    	if (countyid!=null && !"".equals(countyid.trim())) {
	    		params.getQueryConditions().put("COUNTYID", countyid.trim());
	    		dp = dao.queryByNamedSqlQuery("cms.rewardreport", params);
	    	} else {
	    		dp = dao.query(params);
	    	}
	    	// 还原发送时间
	    	params.set_de_sendtime(date);
	    	// 还原分公司
	    	params.set_se_countyid(countyid);
	    	
        return dp;
    }
    
    public DataPackage doQuery2(RewardreportListVO params, User user)
	    throws Exception {
    	V_RewardreportDAO dao = (V_RewardreportDAO) DAOFactory.build(V_RewardreportDAO.class, user);
			DataPackage dp = null;
	    	// 保存分公司
	    	String countyid = params.get_se_countyid();
	    	params.set_se_countyid(null);
	    	if (countyid!=null && !"".equals(countyid.trim())) {
	    		params.getQueryConditions().put("COUNTYID", countyid.trim());
	    		if ("1".equals(params.getAudittype())) {
	    			dp = dao.queryByNamedSqlQuery("cms.vrewardreport.countyid", params);
	    		} else {
	    			dp = dao.queryByNamedSqlQuery("cms.vrewardreportall.countyid", params);
	    		}
	    	} else {
	    		if ("1".equals(params.getAudittype())) {
	    			dp = dao.queryByNamedSqlQuery("cms.vrewardreport", params);
	    		} else {
	    			dp = dao.queryByNamedSqlQuery("cms.vrewardreportall", params);
	    		}
	    	}
	    	// 还原分公司
	    	params.set_se_countyid(countyid);
	    	
	    return dp;
	}
}
