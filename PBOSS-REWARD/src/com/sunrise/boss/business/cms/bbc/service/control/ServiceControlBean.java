/**
* auto-generated code
* Sat Dec 03 10:12:28 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.service.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.service.persistent.ServiceVO;
import com.sunrise.boss.business.cms.bbc.service.persistent.ServiceDAO;
import com.sunrise.boss.business.cms.bbc.service.persistent.ServiceListVO;

/**
 * <p>Title: ServiceControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/service/control/ServiceControlBean"
 name="ServiceControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ServiceControlBean extends AbstractControlBean
    implements ServiceControl {

    public ServiceVO doCreate(ServiceVO vo, User user)
        throws Exception {
        try{
			ServiceDAO dao = (ServiceDAO) DAOFactory.build(ServiceDAO.class, user);
            // TODO  set the pk */
            return (ServiceVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ServiceVO vo, User user)
        throws Exception {
        try{
			ServiceDAO dao = (ServiceDAO) DAOFactory.build(ServiceDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ServiceVO doUpdate(ServiceVO vo, User user)
        throws Exception {
        try{
			ServiceDAO dao = (ServiceDAO) DAOFactory.build(ServiceDAO.class, user);
            return (ServiceVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ServiceVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ServiceDAO dao = (ServiceDAO) DAOFactory.build(ServiceDAO.class, user);
        return (ServiceVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ServiceListVO params, User user)
        throws Exception {
			ServiceDAO dao = (ServiceDAO) DAOFactory.build(ServiceDAO.class, user);
        return dao.query(params);
    }
}
