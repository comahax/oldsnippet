/**
* auto-generated code
* Fri Jan 11 10:41:27 CST 2013
*/
package com.sunrise.boss.business.cms.chadtwaymodlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtwaymodlog.persistent.ChAdtWaymodlogVO;
import com.sunrise.boss.business.cms.chadtwaymodlog.persistent.ChAdtWaymodlogDAO;
import com.sunrise.boss.business.cms.chadtwaymodlog.persistent.ChAdtWaymodlogListVO;

/**
 * <p>Title: ChAdtWaymodlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chadtwaymodlog/control/ChAdtWaymodlogControlBean"
 name="ChAdtWaymodlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChAdtWaymodlogControlBean extends AbstractControlBean
    implements ChAdtWaymodlogControl {

    public ChAdtWaymodlogVO doCreate(ChAdtWaymodlogVO vo, User user)
        throws Exception {
        try{
			ChAdtWaymodlogDAO dao = (ChAdtWaymodlogDAO) DAOFactory.build(ChAdtWaymodlogDAO.class, user);
            // TODO  set the pk */
            return (ChAdtWaymodlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChAdtWaymodlogVO vo, User user)
        throws Exception {
        try{
			ChAdtWaymodlogDAO dao = (ChAdtWaymodlogDAO) DAOFactory.build(ChAdtWaymodlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtWaymodlogVO doUpdate(ChAdtWaymodlogVO vo, User user)
        throws Exception {
        try{
			ChAdtWaymodlogDAO dao = (ChAdtWaymodlogDAO) DAOFactory.build(ChAdtWaymodlogDAO.class, user);
            return (ChAdtWaymodlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtWaymodlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChAdtWaymodlogDAO dao = (ChAdtWaymodlogDAO) DAOFactory.build(ChAdtWaymodlogDAO.class, user);
        return (ChAdtWaymodlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChAdtWaymodlogListVO params, User user)
        throws Exception {
			ChAdtWaymodlogDAO dao = (ChAdtWaymodlogDAO) DAOFactory.build(ChAdtWaymodlogDAO.class, user);
        return dao.query(params);
    }
}
