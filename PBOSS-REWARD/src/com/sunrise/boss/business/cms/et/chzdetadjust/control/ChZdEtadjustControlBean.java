/**
* auto-generated code
* Thu May 09 16:24:13 CST 2013
*/
package com.sunrise.boss.business.cms.et.chzdetadjust.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.et.chzdetadjust.persistent.ChZdEtadjustVO;
import com.sunrise.boss.business.cms.et.chzdetadjust.persistent.ChZdEtadjustDAO;
import com.sunrise.boss.business.cms.et.chzdetadjust.persistent.ChZdEtadjustListVO;

/**
 * <p>Title: ChZdEtadjustControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/et/chzdetadjust/control/ChZdEtadjustControlBean"
 name="ChZdEtadjustControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZdEtadjustControlBean extends AbstractControlBean
    implements ChZdEtadjustControl {

    public ChZdEtadjustVO doCreate(ChZdEtadjustVO vo, User user)
        throws Exception {
        try{
			ChZdEtadjustDAO dao = (ChZdEtadjustDAO) DAOFactory.build(ChZdEtadjustDAO.class, user);
            // TODO  set the pk */
            return (ChZdEtadjustVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChZdEtadjustVO vo, User user)
        throws Exception {
        try{
			ChZdEtadjustDAO dao = (ChZdEtadjustDAO) DAOFactory.build(ChZdEtadjustDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZdEtadjustVO doUpdate(ChZdEtadjustVO vo, User user)
        throws Exception {
        try{
			ChZdEtadjustDAO dao = (ChZdEtadjustDAO) DAOFactory.build(ChZdEtadjustDAO.class, user);
            return (ChZdEtadjustVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZdEtadjustVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChZdEtadjustDAO dao = (ChZdEtadjustDAO) DAOFactory.build(ChZdEtadjustDAO.class, user);
        return (ChZdEtadjustVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChZdEtadjustListVO params, User user)
        throws Exception {
			ChZdEtadjustDAO dao = (ChZdEtadjustDAO) DAOFactory.build(ChZdEtadjustDAO.class, user);
        return dao.query(params);
    }
}
