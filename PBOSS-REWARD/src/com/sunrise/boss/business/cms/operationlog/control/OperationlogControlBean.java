/**
* auto-generated code
* Tue May 01 15:19:39 CST 2007
*/
package com.sunrise.boss.business.cms.operationlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.operationlog.persistent.OperationlogVO;
import com.sunrise.boss.business.cms.operationlog.persistent.OperationlogDAO;
import com.sunrise.boss.business.cms.operationlog.persistent.OperationlogListVO;

/**
 * <p>Title: OperationlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/operationlog/control/OperationlogControlBean"
 name="OperationlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class OperationlogControlBean extends AbstractControlBean
    implements OperationlogControl {

    public OperationlogVO doCreate(OperationlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         OperationlogDAO dao = (OperationlogDAO) DAOFactory.build(OperationlogDAO.class, user);
            return (OperationlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(OperationlogVO vo, User user)
        throws Exception {
        try{
         OperationlogDAO dao = (OperationlogDAO) DAOFactory.build(OperationlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public OperationlogVO doUpdate(OperationlogVO vo, User user)
        throws Exception {
        try{
         OperationlogDAO dao = (OperationlogDAO) DAOFactory.build(OperationlogDAO.class, user);
            return (OperationlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public OperationlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         OperationlogDAO dao = (OperationlogDAO) DAOFactory.build(OperationlogDAO.class, user);
        return (OperationlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(OperationlogListVO params, User user)
        throws Exception {
         OperationlogDAO dao = (OperationlogDAO) DAOFactory.build(OperationlogDAO.class, user);
        return dao.query(params);
    }
}
