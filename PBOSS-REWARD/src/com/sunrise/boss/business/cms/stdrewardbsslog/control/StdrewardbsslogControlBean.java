/**
* auto-generated code
* Sat Apr 23 11:54:51 CST 2011
*/
package com.sunrise.boss.business.cms.stdrewardbsslog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdrewardbsslog.persistent.StdrewardbsslogVO;
import com.sunrise.boss.business.cms.stdrewardbsslog.persistent.StdrewardbsslogDAO;
import com.sunrise.boss.business.cms.stdrewardbsslog.persistent.StdrewardbsslogListVO;

/**
 * <p>Title: StdrewardbsslogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/stdrewardbsslog/control/StdrewardbsslogControlBean"
 name="StdrewardbsslogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class StdrewardbsslogControlBean extends AbstractControlBean
    implements StdrewardbsslogControl {

    public StdrewardbsslogVO doCreate(StdrewardbsslogVO vo, User user)
        throws Exception {
        try{
			StdrewardbsslogDAO dao = (StdrewardbsslogDAO) DAOFactory.build(StdrewardbsslogDAO.class, user);
            // TODO  set the pk */
            return (StdrewardbsslogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(StdrewardbsslogVO vo, User user)
        throws Exception {
        try{
			StdrewardbsslogDAO dao = (StdrewardbsslogDAO) DAOFactory.build(StdrewardbsslogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public StdrewardbsslogVO doUpdate(StdrewardbsslogVO vo, User user)
        throws Exception {
        try{
			StdrewardbsslogDAO dao = (StdrewardbsslogDAO) DAOFactory.build(StdrewardbsslogDAO.class, user);
            return (StdrewardbsslogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public StdrewardbsslogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			StdrewardbsslogDAO dao = (StdrewardbsslogDAO) DAOFactory.build(StdrewardbsslogDAO.class, user);
        return (StdrewardbsslogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(StdrewardbsslogListVO params, User user)
        throws Exception {
			StdrewardbsslogDAO dao = (StdrewardbsslogDAO) DAOFactory.build(StdrewardbsslogDAO.class, user);
        return dao.query(params);
    }
}
