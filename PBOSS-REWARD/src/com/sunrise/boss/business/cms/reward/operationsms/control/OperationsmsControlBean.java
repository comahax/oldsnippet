/**
* auto-generated code
* Mon Feb 21 10:31:26 CST 2011
*/
package com.sunrise.boss.business.cms.reward.operationsms.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.operationsms.persistent.OperationsmsVO;
import com.sunrise.boss.business.cms.reward.operationsms.persistent.OperationsmsDAO;
import com.sunrise.boss.business.cms.reward.operationsms.persistent.OperationsmsListVO;

/**
 * <p>Title: OperationsmsControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/operationsms/control/OperationsmsControlBean"
 name="OperationsmsControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class OperationsmsControlBean extends AbstractControlBean
    implements OperationsmsControl {

    public OperationsmsVO doCreate(OperationsmsVO vo, User user)
        throws Exception {
        try{
			OperationsmsDAO dao = (OperationsmsDAO) DAOFactory.build(OperationsmsDAO.class, user);
            // TODO  set the pk */
            return (OperationsmsVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(OperationsmsVO vo, User user)
        throws Exception {
        try{
			OperationsmsDAO dao = (OperationsmsDAO) DAOFactory.build(OperationsmsDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public OperationsmsVO doUpdate(OperationsmsVO vo, User user)
        throws Exception {
        try{
			OperationsmsDAO dao = (OperationsmsDAO) DAOFactory.build(OperationsmsDAO.class, user);
            return (OperationsmsVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public OperationsmsVO doFindByPk(Serializable pk, User user)
        throws Exception {
			OperationsmsDAO dao = (OperationsmsDAO) DAOFactory.build(OperationsmsDAO.class, user);
        return (OperationsmsVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(OperationsmsListVO params, User user)
        throws Exception {
			OperationsmsDAO dao = (OperationsmsDAO) DAOFactory.build(OperationsmsDAO.class, user);
        return dao.query(params);
    }
}
