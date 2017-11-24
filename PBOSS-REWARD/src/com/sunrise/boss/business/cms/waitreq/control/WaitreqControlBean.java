/**
* auto-generated code
* Thu Mar 03 10:54:08 CST 2011
*/
package com.sunrise.boss.business.cms.waitreq.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waitreq.persistent.WaitreqVO;
import com.sunrise.boss.business.cms.waitreq.persistent.WaitreqDAO;
import com.sunrise.boss.business.cms.waitreq.persistent.WaitreqListVO;

/**
 * <p>Title: WaitreqControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/waitreq/control/WaitreqControlBean"
 name="WaitreqControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class WaitreqControlBean extends AbstractControlBean
    implements WaitreqControl {

    public WaitreqVO doCreate(WaitreqVO vo, User user)
        throws Exception {
        try{
			WaitreqDAO dao = (WaitreqDAO) DAOFactory.build(WaitreqDAO.class, user);
            // TODO  set the pk */
            return (WaitreqVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(WaitreqVO vo, User user)
        throws Exception {
        try{
			WaitreqDAO dao = (WaitreqDAO) DAOFactory.build(WaitreqDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public WaitreqVO doUpdate(WaitreqVO vo, User user)
        throws Exception {
        try{
			WaitreqDAO dao = (WaitreqDAO) DAOFactory.build(WaitreqDAO.class, user);
            return (WaitreqVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public WaitreqVO doFindByPk(Serializable pk, User user)
        throws Exception {
			WaitreqDAO dao = (WaitreqDAO) DAOFactory.build(WaitreqDAO.class, user);
        return (WaitreqVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(WaitreqListVO params, User user)
        throws Exception {
			WaitreqDAO dao = (WaitreqDAO) DAOFactory.build(WaitreqDAO.class, user);
        return dao.query(params);
    }
}
