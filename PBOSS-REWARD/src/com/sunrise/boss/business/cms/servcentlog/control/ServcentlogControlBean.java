/**
* auto-generated code
* Mon Apr 16 17:14:45 CST 2007
*/
package com.sunrise.boss.business.cms.servcentlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.servcentlog.persistent.ServcentlogVO;
import com.sunrise.boss.business.cms.servcentlog.persistent.ServcentlogDAO;
import com.sunrise.boss.business.cms.servcentlog.persistent.ServcentlogListVO;

/**
 * <p>Title: ServcentlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/servcentlog/control/ServcentlogControlBean"
 name="ServcentlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ServcentlogControlBean extends AbstractControlBean
    implements ServcentlogControl {

    public ServcentlogVO doCreate(ServcentlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         ServcentlogDAO dao = (ServcentlogDAO) DAOFactory.build(ServcentlogDAO.class, user);
            return (ServcentlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ServcentlogVO vo, User user)
        throws Exception {
        try{
         ServcentlogDAO dao = (ServcentlogDAO) DAOFactory.build(ServcentlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ServcentlogVO doUpdate(ServcentlogVO vo, User user)
        throws Exception {
        try{
         ServcentlogDAO dao = (ServcentlogDAO) DAOFactory.build(ServcentlogDAO.class, user);
            return (ServcentlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ServcentlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         ServcentlogDAO dao = (ServcentlogDAO) DAOFactory.build(ServcentlogDAO.class, user);
        return (ServcentlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ServcentlogListVO params, User user)
        throws Exception {
         ServcentlogDAO dao = (ServcentlogDAO) DAOFactory.build(ServcentlogDAO.class, user);
        return dao.query(params);
    }
}
