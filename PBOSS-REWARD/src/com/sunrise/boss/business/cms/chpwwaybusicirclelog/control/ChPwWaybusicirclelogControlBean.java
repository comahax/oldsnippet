/**
* auto-generated code
* Sat Jan 12 11:20:42 CST 2013
*/
package com.sunrise.boss.business.cms.chpwwaybusicirclelog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chpwwaybusicirclelog.persistent.ChPwWaybusicirclelogVO;
import com.sunrise.boss.business.cms.chpwwaybusicirclelog.persistent.ChPwWaybusicirclelogDAO;
import com.sunrise.boss.business.cms.chpwwaybusicirclelog.persistent.ChPwWaybusicirclelogListVO;

/**
 * <p>Title: ChPwWaybusicirclelogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chpwwaybusicirclelog/control/ChPwWaybusicirclelogControlBean"
 name="ChPwWaybusicirclelogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPwWaybusicirclelogControlBean extends AbstractControlBean
    implements ChPwWaybusicirclelogControl {

    public ChPwWaybusicirclelogVO doCreate(ChPwWaybusicirclelogVO vo, User user)
        throws Exception {
        try{
			ChPwWaybusicirclelogDAO dao = (ChPwWaybusicirclelogDAO) DAOFactory.build(ChPwWaybusicirclelogDAO.class, user);
            // TODO  set the pk */
            return (ChPwWaybusicirclelogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPwWaybusicirclelogVO vo, User user)
        throws Exception {
        try{
			ChPwWaybusicirclelogDAO dao = (ChPwWaybusicirclelogDAO) DAOFactory.build(ChPwWaybusicirclelogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPwWaybusicirclelogVO doUpdate(ChPwWaybusicirclelogVO vo, User user)
        throws Exception {
        try{
			ChPwWaybusicirclelogDAO dao = (ChPwWaybusicirclelogDAO) DAOFactory.build(ChPwWaybusicirclelogDAO.class, user);
            return (ChPwWaybusicirclelogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPwWaybusicirclelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPwWaybusicirclelogDAO dao = (ChPwWaybusicirclelogDAO) DAOFactory.build(ChPwWaybusicirclelogDAO.class, user);
        return (ChPwWaybusicirclelogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPwWaybusicirclelogListVO params, User user)
        throws Exception {
			ChPwWaybusicirclelogDAO dao = (ChPwWaybusicirclelogDAO) DAOFactory.build(ChPwWaybusicirclelogDAO.class, user);
        return dao.query(params);
    }
}
