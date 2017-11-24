/**
* auto-generated code
* Tue Jul 17 16:46:57 CST 2012
*/
package com.sunrise.boss.business.cms.et.chetstdreward.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.et.chetstdreward.persistent.ChEtStdrewardVO;
import com.sunrise.boss.business.cms.et.chetstdreward.persistent.ChEtStdrewardDAO;
import com.sunrise.boss.business.cms.et.chetstdreward.persistent.ChEtStdrewardListVO;

/**
 * <p>Title: ChEtStdrewardControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/et/chetstdreward/control/ChEtStdrewardControlBean"
 name="ChEtStdrewardControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChEtStdrewardControlBean extends AbstractControlBean
    implements ChEtStdrewardControl {

    public ChEtStdrewardVO doCreate(ChEtStdrewardVO vo, User user)
        throws Exception {
        try{
			ChEtStdrewardDAO dao = (ChEtStdrewardDAO) DAOFactory.build(ChEtStdrewardDAO.class, user);
            // TODO  set the pk */
            return (ChEtStdrewardVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChEtStdrewardVO vo, User user)
        throws Exception {
        try{
			ChEtStdrewardDAO dao = (ChEtStdrewardDAO) DAOFactory.build(ChEtStdrewardDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChEtStdrewardVO doUpdate(ChEtStdrewardVO vo, User user)
        throws Exception {
        try{
			ChEtStdrewardDAO dao = (ChEtStdrewardDAO) DAOFactory.build(ChEtStdrewardDAO.class, user);
            return (ChEtStdrewardVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChEtStdrewardVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChEtStdrewardDAO dao = (ChEtStdrewardDAO) DAOFactory.build(ChEtStdrewardDAO.class, user);
        return (ChEtStdrewardVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChEtStdrewardListVO params, User user)
        throws Exception {
			ChEtStdrewardDAO dao = (ChEtStdrewardDAO) DAOFactory.build(ChEtStdrewardDAO.class, user);
        return dao.query(params);
    }
}
