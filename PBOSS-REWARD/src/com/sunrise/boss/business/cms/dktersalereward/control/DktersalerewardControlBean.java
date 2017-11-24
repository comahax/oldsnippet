/**
* auto-generated code
* Fri May 03 16:45:00 CST 2013
*/
package com.sunrise.boss.business.cms.dktersalereward.control;

import java.io.Serializable;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.dktersalereward.persistent.DktersalerewardVO;
import com.sunrise.boss.business.cms.dktersalereward.persistent.DktersalerewardDAO;
import com.sunrise.boss.business.cms.dktersalereward.persistent.DktersalerewardListVO;

/**
 * <p>Title: DktersalerewardControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/dktersalereward/control/DktersalerewardControlBean"
 name="DktersalerewardControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class DktersalerewardControlBean extends AbstractControlBean
    implements DktersalerewardControl {

    public DktersalerewardVO doCreate(DktersalerewardVO vo, User user)
        throws Exception {
        try{
			DktersalerewardDAO dao = (DktersalerewardDAO) DAOFactory.build(DktersalerewardDAO.class, user);
            // TODO  set the pk */
            return (DktersalerewardVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(DktersalerewardVO vo, User user)
        throws Exception {
        try{
			DktersalerewardDAO dao = (DktersalerewardDAO) DAOFactory.build(DktersalerewardDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public DktersalerewardVO doUpdate(DktersalerewardVO vo, User user)
        throws Exception {
        try{
			DktersalerewardDAO dao = (DktersalerewardDAO) DAOFactory.build(DktersalerewardDAO.class, user);
            return (DktersalerewardVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public DktersalerewardVO doFindByPk(Serializable pk, User user)
        throws Exception {
			DktersalerewardDAO dao = (DktersalerewardDAO) DAOFactory.build(DktersalerewardDAO.class, user);
        return (DktersalerewardVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(DktersalerewardListVO params, User user)
        throws Exception {
			DktersalerewardDAO dao = (DktersalerewardDAO) DAOFactory.build(DktersalerewardDAO.class, user);
        return dao.query(params);
    }

    public DataPackage doQueryRewardTotal(DktersalerewardListVO params, User user)
        throws Exception {
            DktersalerewardDAO dao = (DktersalerewardDAO) DAOFactory.build(DktersalerewardDAO.class, user);
        return dao.doQueryRewardTotal(params);
    }
}
