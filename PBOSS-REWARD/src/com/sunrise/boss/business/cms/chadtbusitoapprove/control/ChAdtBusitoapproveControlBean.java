/**
* auto-generated code
* Tue Dec 20 12:00:28 CST 2011
*/
package com.sunrise.boss.business.cms.chadtbusitoapprove.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtbusitoapprove.persistent.ChAdtBusitoapproveVO;
import com.sunrise.boss.business.cms.chadtbusitoapprove.persistent.ChAdtBusitoapproveDAO;
import com.sunrise.boss.business.cms.chadtbusitoapprove.persistent.ChAdtBusitoapproveListVO;

/**
 * <p>Title: ChAdtBusitoapproveControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chadtbusitoapprove/control/ChAdtBusitoapproveControlBean"
 name="ChAdtBusitoapproveControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChAdtBusitoapproveControlBean extends AbstractControlBean
    implements ChAdtBusitoapproveControl {

    public ChAdtBusitoapproveVO doCreate(ChAdtBusitoapproveVO vo, User user)
        throws Exception {
        try{
			ChAdtBusitoapproveDAO dao = (ChAdtBusitoapproveDAO) DAOFactory.build(ChAdtBusitoapproveDAO.class, user);
            // TODO  set the pk */
            return (ChAdtBusitoapproveVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChAdtBusitoapproveVO vo, User user)
        throws Exception {
        try{
			ChAdtBusitoapproveDAO dao = (ChAdtBusitoapproveDAO) DAOFactory.build(ChAdtBusitoapproveDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtBusitoapproveVO doUpdate(ChAdtBusitoapproveVO vo, User user)
        throws Exception {
        try{
			ChAdtBusitoapproveDAO dao = (ChAdtBusitoapproveDAO) DAOFactory.build(ChAdtBusitoapproveDAO.class, user);
            return (ChAdtBusitoapproveVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtBusitoapproveVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChAdtBusitoapproveDAO dao = (ChAdtBusitoapproveDAO) DAOFactory.build(ChAdtBusitoapproveDAO.class, user);
        return (ChAdtBusitoapproveVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChAdtBusitoapproveListVO params, User user)
        throws Exception {
			ChAdtBusitoapproveDAO dao = (ChAdtBusitoapproveDAO) DAOFactory.build(ChAdtBusitoapproveDAO.class, user);
        return dao.query(params);
    }
}
