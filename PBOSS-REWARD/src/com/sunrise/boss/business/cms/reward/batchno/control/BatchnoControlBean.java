/**
* auto-generated code
* Wed Nov 11 16:19:50 CST 2009
*/
package com.sunrise.boss.business.cms.reward.batchno.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.batchno.persistent.BatchnoVO;
import com.sunrise.boss.business.cms.reward.batchno.persistent.BatchnoDAO;
import com.sunrise.boss.business.cms.reward.batchno.persistent.BatchnoListVO;

/**
 * <p>Title: BatchnoControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/batchno/control/BatchnoControlBean"
 name="BatchnoControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BatchnoControlBean extends AbstractControlBean
    implements BatchnoControl {

    public BatchnoVO doCreate(BatchnoVO vo, User user)
        throws Exception {
        try{
			BatchnoDAO dao = (BatchnoDAO) DAOFactory.build(BatchnoDAO.class, user);
            // TODO  set the pk */
            return (BatchnoVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(BatchnoVO vo, User user)
        throws Exception {
        try{
			BatchnoDAO dao = (BatchnoDAO) DAOFactory.build(BatchnoDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BatchnoVO doUpdate(BatchnoVO vo, User user)
        throws Exception {
        try{
			BatchnoDAO dao = (BatchnoDAO) DAOFactory.build(BatchnoDAO.class, user);
            return (BatchnoVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BatchnoVO doFindByPk(Serializable pk, User user)
        throws Exception {
			BatchnoDAO dao = (BatchnoDAO) DAOFactory.build(BatchnoDAO.class, user);
        return (BatchnoVO) dao.findByPk(pk);
    }
    
    public DataPackage doQuery(BatchnoListVO params, User user)
        throws Exception {
			BatchnoDAO dao = (BatchnoDAO) DAOFactory.build(BatchnoDAO.class, user);
        return dao.query(params);
    }
    
    public DataPackage doQueryBySelectBatchno(BatchnoListVO param ,User user) throws Exception{
    	BatchnoDAO dao = (BatchnoDAO) DAOFactory.build(BatchnoDAO.class, user);
    	param.getQueryConditions().put("cityid", user.getCityid());
    	param.getQueryConditions().put("rewardmonth", param.get_rewardmonth());
    	return dao.queryByNamedSqlQuery("SelectBatchno",param);
    }
}
