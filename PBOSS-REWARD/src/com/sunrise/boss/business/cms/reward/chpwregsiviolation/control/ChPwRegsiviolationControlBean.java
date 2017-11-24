/**
* auto-generated code
* Fri Oct 18 14:59:15 CST 2013
*/
package com.sunrise.boss.business.cms.reward.chpwregsiviolation.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.chpwregsiviolation.persistent.ChPwRegsiviolationVO;
import com.sunrise.boss.business.cms.reward.chpwregsiviolation.persistent.ChPwRegsiviolationDAO;
import com.sunrise.boss.business.cms.reward.chpwregsiviolation.persistent.ChPwRegsiviolationListVO;

/**
 * <p>Title: ChPwRegsiviolationControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/chpwregsiviolation/control/ChPwRegsiviolationControlBean"
 name="ChPwRegsiviolationControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPwRegsiviolationControlBean extends AbstractControlBean
    implements ChPwRegsiviolationControl {

    public ChPwRegsiviolationVO doCreate(ChPwRegsiviolationVO vo, User user)
        throws Exception {
        try{
			ChPwRegsiviolationDAO dao = (ChPwRegsiviolationDAO) DAOFactory.build(ChPwRegsiviolationDAO.class, user);
            // TODO  set the pk */
            return (ChPwRegsiviolationVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPwRegsiviolationVO vo, User user)
        throws Exception {
        try{
			ChPwRegsiviolationDAO dao = (ChPwRegsiviolationDAO) DAOFactory.build(ChPwRegsiviolationDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPwRegsiviolationVO doUpdate(ChPwRegsiviolationVO vo, User user)
        throws Exception {
        try{
			ChPwRegsiviolationDAO dao = (ChPwRegsiviolationDAO) DAOFactory.build(ChPwRegsiviolationDAO.class, user);
            return (ChPwRegsiviolationVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPwRegsiviolationVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPwRegsiviolationDAO dao = (ChPwRegsiviolationDAO) DAOFactory.build(ChPwRegsiviolationDAO.class, user);
        return (ChPwRegsiviolationVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPwRegsiviolationListVO params, User user)
        throws Exception {
			ChPwRegsiviolationDAO dao = (ChPwRegsiviolationDAO) DAOFactory.build(ChPwRegsiviolationDAO.class, user);
        return dao.query(params);
    }
}
