/**
* auto-generated code
* Sat Mar 09 12:12:34 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocalzdsalereward.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocalzdsalereward.persistent.ChZjtyLocalzdsalerewardVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalzdsalereward.persistent.ChZjtyLocalzdsalerewardDAO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalzdsalereward.persistent.ChZjtyLocalzdsalerewardListVO;

/**
 * <p>Title: ChZjtyLocalzdsalerewardControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/chzjtylocalzdsalereward/control/ChZjtyLocalzdsalerewardControlBean"
 name="ChZjtyLocalzdsalerewardControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZjtyLocalzdsalerewardControlBean extends AbstractControlBean
    implements ChZjtyLocalzdsalerewardControl {

    public ChZjtyLocalzdsalerewardVO doCreate(ChZjtyLocalzdsalerewardVO vo, User user)
        throws Exception {
        try{
			ChZjtyLocalzdsalerewardDAO dao = (ChZjtyLocalzdsalerewardDAO) DAOFactory.build(ChZjtyLocalzdsalerewardDAO.class, user);
            // TODO  set the pk */
            return (ChZjtyLocalzdsalerewardVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChZjtyLocalzdsalerewardVO vo, User user)
        throws Exception {
        try{
			ChZjtyLocalzdsalerewardDAO dao = (ChZjtyLocalzdsalerewardDAO) DAOFactory.build(ChZjtyLocalzdsalerewardDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyLocalzdsalerewardVO doUpdate(ChZjtyLocalzdsalerewardVO vo, User user)
        throws Exception {
        try{
			ChZjtyLocalzdsalerewardDAO dao = (ChZjtyLocalzdsalerewardDAO) DAOFactory.build(ChZjtyLocalzdsalerewardDAO.class, user);
            return (ChZjtyLocalzdsalerewardVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyLocalzdsalerewardVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChZjtyLocalzdsalerewardDAO dao = (ChZjtyLocalzdsalerewardDAO) DAOFactory.build(ChZjtyLocalzdsalerewardDAO.class, user);
        return (ChZjtyLocalzdsalerewardVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChZjtyLocalzdsalerewardListVO params, User user)
        throws Exception {
			ChZjtyLocalzdsalerewardDAO dao = (ChZjtyLocalzdsalerewardDAO) DAOFactory.build(ChZjtyLocalzdsalerewardDAO.class, user);
        return dao.query(params);
    }

    public DataPackage doQueryTotal(ChZjtyLocalzdsalerewardListVO params, User user)
        throws Exception {
    	ChZjtyLocalzdsalerewardDAO dao = (ChZjtyLocalzdsalerewardDAO) DAOFactory.build(ChZjtyLocalzdsalerewardDAO.class, user);
        return dao.doQueryTotal(params);
    }
}
