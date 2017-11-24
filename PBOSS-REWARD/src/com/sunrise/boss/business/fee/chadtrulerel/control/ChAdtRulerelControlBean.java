/**
* auto-generated code
* Wed Feb 06 14:54:24 CST 2013
*/
package com.sunrise.boss.business.fee.chadtrulerel.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.fee.chadtrulerel.persistent.ChAdtRulerelVO;
import com.sunrise.boss.business.fee.chadtrulerel.persistent.ChAdtRulerelDAO;
import com.sunrise.boss.business.fee.chadtrulerel.persistent.ChAdtRulerelListVO;

/**
 * <p>Title: ChAdtRulerelControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lc
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/fee/chadtrulerel/control/ChAdtRulerelControlBean"
 name="ChAdtRulerelControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChAdtRulerelControlBean extends AbstractControlBean
    implements ChAdtRulerelControl {

    public ChAdtRulerelVO doCreate(ChAdtRulerelVO vo, User user)
        throws Exception {
        try{
			ChAdtRulerelDAO dao = (ChAdtRulerelDAO) DAOFactory.build(ChAdtRulerelDAO.class, user);
            // TODO  set the pk */
            return (ChAdtRulerelVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChAdtRulerelVO vo, User user)
        throws Exception {
        try{
			ChAdtRulerelDAO dao = (ChAdtRulerelDAO) DAOFactory.build(ChAdtRulerelDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtRulerelVO doUpdate(ChAdtRulerelVO vo, User user)
        throws Exception {
        try{
			ChAdtRulerelDAO dao = (ChAdtRulerelDAO) DAOFactory.build(ChAdtRulerelDAO.class, user);
            return (ChAdtRulerelVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtRulerelVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChAdtRulerelDAO dao = (ChAdtRulerelDAO) DAOFactory.build(ChAdtRulerelDAO.class, user);
        return (ChAdtRulerelVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChAdtRulerelListVO params, User user)
        throws Exception {
			ChAdtRulerelDAO dao = (ChAdtRulerelDAO) DAOFactory.build(ChAdtRulerelDAO.class, user);
        return dao.query(params);
    }
}
