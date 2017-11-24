/**
* auto-generated code
* Tue Nov 24 10:57:58 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnperiodlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnperiodlog.persistent.ExmnperiodlogVO;
import com.sunrise.boss.business.cms.examine.exmnperiodlog.persistent.ExmnperiodlogDAO;
import com.sunrise.boss.business.cms.examine.exmnperiodlog.persistent.ExmnperiodlogListVO;

/**
 * <p>Title: ExmnperiodlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/exmnperiodlog/control/ExmnperiodlogControlBean"
 name="ExmnperiodlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExmnperiodlogControlBean extends AbstractControlBean
    implements ExmnperiodlogControl {

    public ExmnperiodlogVO doCreate(ExmnperiodlogVO vo, User user)
        throws Exception {
        try{
			ExmnperiodlogDAO dao = (ExmnperiodlogDAO) DAOFactory.build(ExmnperiodlogDAO.class, user);
            // TODO  set the pk */
            return (ExmnperiodlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ExmnperiodlogVO vo, User user)
        throws Exception {
        try{
			ExmnperiodlogDAO dao = (ExmnperiodlogDAO) DAOFactory.build(ExmnperiodlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnperiodlogVO doUpdate(ExmnperiodlogVO vo, User user)
        throws Exception {
        try{
			ExmnperiodlogDAO dao = (ExmnperiodlogDAO) DAOFactory.build(ExmnperiodlogDAO.class, user);
            return (ExmnperiodlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnperiodlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ExmnperiodlogDAO dao = (ExmnperiodlogDAO) DAOFactory.build(ExmnperiodlogDAO.class, user);
        return (ExmnperiodlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnperiodlogListVO params, User user)
        throws Exception {
			ExmnperiodlogDAO dao = (ExmnperiodlogDAO) DAOFactory.build(ExmnperiodlogDAO.class, user);
        return dao.query(params);
    }
}
