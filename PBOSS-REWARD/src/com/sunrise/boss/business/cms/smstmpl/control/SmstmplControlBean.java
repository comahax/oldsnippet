/**
* auto-generated code
* Thu May 19 20:47:27 CST 2011
*/
package com.sunrise.boss.business.cms.smstmpl.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.smstmpl.persistent.SmstmplVO;
import com.sunrise.boss.business.cms.smstmpl.persistent.SmstmplDAO;
import com.sunrise.boss.business.cms.smstmpl.persistent.SmstmplListVO;

/**
 * <p>Title: SmstmplControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/smstmpl/control/SmstmplControlBean"
 name="SmstmplControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class SmstmplControlBean extends AbstractControlBean
    implements SmstmplControl {

    public SmstmplVO doCreate(SmstmplVO vo, User user)
        throws Exception {
        try{
			SmstmplDAO dao = (SmstmplDAO) DAOFactory.build(SmstmplDAO.class, user);
            // TODO  set the pk */
            return (SmstmplVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(SmstmplVO vo, User user)
        throws Exception {
        try{
			SmstmplDAO dao = (SmstmplDAO) DAOFactory.build(SmstmplDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public SmstmplVO doUpdate(SmstmplVO vo, User user)
        throws Exception {
        try{
			SmstmplDAO dao = (SmstmplDAO) DAOFactory.build(SmstmplDAO.class, user);
            return (SmstmplVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public SmstmplVO doFindByPk(Serializable pk, User user)
        throws Exception {
			SmstmplDAO dao = (SmstmplDAO) DAOFactory.build(SmstmplDAO.class, user);
        return (SmstmplVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(SmstmplListVO params, User user)
        throws Exception {
			SmstmplDAO dao = (SmstmplDAO) DAOFactory.build(SmstmplDAO.class, user);
        return dao.query(params);
    }
}
