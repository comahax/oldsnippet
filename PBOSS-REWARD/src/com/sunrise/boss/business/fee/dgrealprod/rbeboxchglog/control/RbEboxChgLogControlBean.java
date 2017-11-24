/**
* auto-generated code
* Fri Apr 18 17:19:00 CST 2008
*/
package com.sunrise.boss.business.fee.dgrealprod.rbeboxchglog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.fee.dgrealprod.rbeboxchglog.persistent.RbEboxChgLogVO;
import com.sunrise.boss.business.fee.dgrealprod.rbeboxchglog.persistent.RbEboxChgLogDAO;
import com.sunrise.boss.business.fee.dgrealprod.rbeboxchglog.persistent.RbEboxChgLogListVO;

/**
 * <p>Title: RbEboxChgLogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lmq
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/fee/dgrealprod/rbeboxchglog/control/RbEboxChgLogControlBean"
 name="RbEboxChgLogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RbEboxChgLogControlBean extends AbstractControlBean
    implements RbEboxChgLogControl {

    public RbEboxChgLogVO doCreate(RbEboxChgLogVO vo, User user)
        throws Exception {
        try{
			RbEboxChgLogDAO dao = (RbEboxChgLogDAO) DAOFactory.build(RbEboxChgLogDAO.class, user.getCityid());
            // TODO  set the pk */
            return (RbEboxChgLogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RbEboxChgLogVO vo, User user)
        throws Exception {
        try{
			RbEboxChgLogDAO dao = (RbEboxChgLogDAO) DAOFactory.build(RbEboxChgLogDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RbEboxChgLogVO doUpdate(RbEboxChgLogVO vo, User user)
        throws Exception {
        try{
			RbEboxChgLogDAO dao = (RbEboxChgLogDAO) DAOFactory.build(RbEboxChgLogDAO.class, user.getCityid());
            return (RbEboxChgLogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RbEboxChgLogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RbEboxChgLogDAO dao = (RbEboxChgLogDAO) DAOFactory.build(RbEboxChgLogDAO.class, user.getCityid());
        return (RbEboxChgLogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RbEboxChgLogListVO params, User user)
        throws Exception {
			RbEboxChgLogDAO dao = (RbEboxChgLogDAO) DAOFactory.build(RbEboxChgLogDAO.class, user.getCityid());
        return dao.query(params);
    }
}
