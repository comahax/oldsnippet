/**
* auto-generated code
* Tue Sep 18 14:59:25 CST 2012
*/
package com.sunrise.boss.business.kdkhzld.chpwbroadlist.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.kdkhzld.chpwbroadlist.persistent.ChPwBroadlistVO;
import com.sunrise.boss.business.kdkhzld.chpwbroadlist.persistent.ChPwBroadlistDAO;
import com.sunrise.boss.business.kdkhzld.chpwbroadlist.persistent.ChPwBroadlistListVO;

/**
 * <p>Title: ChPwBroadlistControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/kdkhzld/chpwbroadlist/control/ChPwBroadlistControlBean"
 name="ChPwBroadlistControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPwBroadlistControlBean extends AbstractControlBean
    implements ChPwBroadlistControl {

    public ChPwBroadlistVO doCreate(ChPwBroadlistVO vo, User user)
        throws Exception {
        try{
			ChPwBroadlistDAO dao = (ChPwBroadlistDAO) DAOFactory.build(ChPwBroadlistDAO.class, user);
            // TODO  set the pk */
            return (ChPwBroadlistVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPwBroadlistVO vo, User user)
        throws Exception {
        try{
			ChPwBroadlistDAO dao = (ChPwBroadlistDAO) DAOFactory.build(ChPwBroadlistDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPwBroadlistVO doUpdate(ChPwBroadlistVO vo, User user)
        throws Exception {
        try{
			ChPwBroadlistDAO dao = (ChPwBroadlistDAO) DAOFactory.build(ChPwBroadlistDAO.class, user);
            return (ChPwBroadlistVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPwBroadlistVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPwBroadlistDAO dao = (ChPwBroadlistDAO) DAOFactory.build(ChPwBroadlistDAO.class, user);
        return (ChPwBroadlistVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPwBroadlistListVO params, User user)
        throws Exception {
			ChPwBroadlistDAO dao = (ChPwBroadlistDAO) DAOFactory.build(ChPwBroadlistDAO.class, user);
        return dao.query(params);
    }
}
