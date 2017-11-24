/**
* auto-generated code
* Tue Sep 18 15:04:18 CST 2012
*/
package com.sunrise.boss.business.kdkhzld.chpwbroadlistlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.kdkhzld.chpwbroadlistlog.persistent.ChPwBroadlistlogVO;
import com.sunrise.boss.business.kdkhzld.chpwbroadlistlog.persistent.ChPwBroadlistlogDAO;
import com.sunrise.boss.business.kdkhzld.chpwbroadlistlog.persistent.ChPwBroadlistlogListVO;

/**
 * <p>Title: ChPwBroadlistlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/kdkhzld/chpwbroadlistlog/control/ChPwBroadlistlogControlBean"
 name="ChPwBroadlistlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPwBroadlistlogControlBean extends AbstractControlBean
    implements ChPwBroadlistlogControl {

    public ChPwBroadlistlogVO doCreate(ChPwBroadlistlogVO vo, User user)
        throws Exception {
        try{
			ChPwBroadlistlogDAO dao = (ChPwBroadlistlogDAO) DAOFactory.build(ChPwBroadlistlogDAO.class, user);
            // TODO  set the pk */
            return (ChPwBroadlistlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPwBroadlistlogVO vo, User user)
        throws Exception {
        try{
			ChPwBroadlistlogDAO dao = (ChPwBroadlistlogDAO) DAOFactory.build(ChPwBroadlistlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPwBroadlistlogVO doUpdate(ChPwBroadlistlogVO vo, User user)
        throws Exception {
        try{
			ChPwBroadlistlogDAO dao = (ChPwBroadlistlogDAO) DAOFactory.build(ChPwBroadlistlogDAO.class, user);
            return (ChPwBroadlistlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPwBroadlistlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPwBroadlistlogDAO dao = (ChPwBroadlistlogDAO) DAOFactory.build(ChPwBroadlistlogDAO.class, user);
        return (ChPwBroadlistlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPwBroadlistlogListVO params, User user)
        throws Exception {
			ChPwBroadlistlogDAO dao = (ChPwBroadlistlogDAO) DAOFactory.build(ChPwBroadlistlogDAO.class, user);
        return dao.query(params);
    }
}
