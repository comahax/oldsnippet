/**
* auto-generated code
* Thu Apr 19 11:41:36 CST 2012
*/
package com.sunrise.boss.business.cms.rewardupload.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardupload.persistent.RewarduploadVO;
import com.sunrise.boss.business.cms.rewardupload.persistent.RewarduploadDAO;
import com.sunrise.boss.business.cms.rewardupload.persistent.RewarduploadListVO;

/**
 * <p>Title: RewarduploadControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/rewardupload/control/RewarduploadControlBean"
 name="RewarduploadControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RewarduploadControlBean extends AbstractControlBean
    implements RewarduploadControl {

    public RewarduploadVO doCreate(RewarduploadVO vo, User user)
        throws Exception {
        try{
			RewarduploadDAO dao = (RewarduploadDAO) DAOFactory.build(RewarduploadDAO.class, user);
            // TODO  set the pk */
            return (RewarduploadVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(RewarduploadVO vo, User user)
        throws Exception {
        try{
			RewarduploadDAO dao = (RewarduploadDAO) DAOFactory.build(RewarduploadDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RewarduploadVO doUpdate(RewarduploadVO vo, User user)
        throws Exception {
        try{
			RewarduploadDAO dao = (RewarduploadDAO) DAOFactory.build(RewarduploadDAO.class, user);
            return (RewarduploadVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RewarduploadVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RewarduploadDAO dao = (RewarduploadDAO) DAOFactory.build(RewarduploadDAO.class, user);
        return (RewarduploadVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(RewarduploadListVO params, User user)
        throws Exception {
			RewarduploadDAO dao = (RewarduploadDAO) DAOFactory.build(RewarduploadDAO.class, user);
        return dao.query(params);
    }
    
    public Long doGetSequence(User user) throws Exception{
    	RewarduploadDAO dao = (RewarduploadDAO) DAOFactory.build(RewarduploadDAO.class, user);
    	return (Long)dao.getSequence("ch_adt_rewardupload_seq");
    }
}
