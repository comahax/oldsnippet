/**
* auto-generated code
* Fri Jul 08 09:50:15 CST 2011
*/
package com.sunrise.boss.business.cms.salereward.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.salereward.persistent.SalerewardVO;
import com.sunrise.boss.business.cms.salereward.persistent.SalerewardDAO;
import com.sunrise.boss.business.cms.salereward.persistent.SalerewardListVO;

/**
 * <p>Title: SalerewardControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/salereward/control/SalerewardControlBean"
 name="SalerewardControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class SalerewardControlBean extends AbstractControlBean
    implements SalerewardControl {

    public SalerewardVO doCreate(SalerewardVO vo, User user)
        throws Exception {
        try{
			SalerewardDAO dao = (SalerewardDAO) DAOFactory.build(SalerewardDAO.class, user);
            // TODO  set the pk */
            return (SalerewardVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(SalerewardVO vo, User user)
        throws Exception {
        try{
			SalerewardDAO dao = (SalerewardDAO) DAOFactory.build(SalerewardDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public SalerewardVO doUpdate(SalerewardVO vo, User user)
        throws Exception {
        try{
			SalerewardDAO dao = (SalerewardDAO) DAOFactory.build(SalerewardDAO.class, user);
            return (SalerewardVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public SalerewardVO doFindByPk(Serializable pk, User user)
        throws Exception {
			SalerewardDAO dao = (SalerewardDAO) DAOFactory.build(SalerewardDAO.class, user);
        return (SalerewardVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(SalerewardListVO params, User user)
        throws Exception {
			SalerewardDAO dao = (SalerewardDAO) DAOFactory.build(SalerewardDAO.class, user);
        return dao.query(params);
    }
}
