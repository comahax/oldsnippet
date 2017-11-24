/**
* auto-generated code
* Sat Dec 03 10:15:10 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.servicelog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.servicelog.persistent.ServicelogVO;
import com.sunrise.boss.business.cms.bbc.servicelog.persistent.ServicelogDAO;
import com.sunrise.boss.business.cms.bbc.servicelog.persistent.ServicelogListVO;

/**
 * <p>Title: ServicelogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/servicelog/control/ServicelogControlBean"
 name="ServicelogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ServicelogControlBean extends AbstractControlBean
    implements ServicelogControl {

    public ServicelogVO doCreate(ServicelogVO vo, User user)
        throws Exception {
        try{
			ServicelogDAO dao = (ServicelogDAO) DAOFactory.build(ServicelogDAO.class, user);
            // TODO  set the pk */
            return (ServicelogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ServicelogVO vo, User user)
        throws Exception {
        try{
			ServicelogDAO dao = (ServicelogDAO) DAOFactory.build(ServicelogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ServicelogVO doUpdate(ServicelogVO vo, User user)
        throws Exception {
        try{
			ServicelogDAO dao = (ServicelogDAO) DAOFactory.build(ServicelogDAO.class, user);
            return (ServicelogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ServicelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ServicelogDAO dao = (ServicelogDAO) DAOFactory.build(ServicelogDAO.class, user);
        return (ServicelogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ServicelogListVO params, User user)
        throws Exception {
			ServicelogDAO dao = (ServicelogDAO) DAOFactory.build(ServicelogDAO.class, user);
        return dao.query(params);
    }
}
