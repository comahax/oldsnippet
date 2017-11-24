/**
* auto-generated code
* Sat Apr 23 11:54:03 CST 2011
*/
package com.sunrise.boss.business.cms.stdrewardbss.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdrewardbss.persistent.StdrewardbssVO;
import com.sunrise.boss.business.cms.stdrewardbss.persistent.StdrewardbssDAO;
import com.sunrise.boss.business.cms.stdrewardbss.persistent.StdrewardbssListVO;

/**
 * <p>Title: StdrewardbssControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/stdrewardbss/control/StdrewardbssControlBean"
 name="StdrewardbssControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class StdrewardbssControlBean extends AbstractControlBean
    implements StdrewardbssControl {

    public StdrewardbssVO doCreate(StdrewardbssVO vo, User user)
        throws Exception {
        try{
			StdrewardbssDAO dao = (StdrewardbssDAO) DAOFactory.build(StdrewardbssDAO.class, user);
            // TODO  set the pk */
            return (StdrewardbssVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(StdrewardbssVO vo, User user)
        throws Exception {
        try{
			StdrewardbssDAO dao = (StdrewardbssDAO) DAOFactory.build(StdrewardbssDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public StdrewardbssVO doUpdate(StdrewardbssVO vo, User user)
        throws Exception {
        try{
			StdrewardbssDAO dao = (StdrewardbssDAO) DAOFactory.build(StdrewardbssDAO.class, user);
            return (StdrewardbssVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public StdrewardbssVO doFindByPk(Serializable pk, User user)
        throws Exception {
			StdrewardbssDAO dao = (StdrewardbssDAO) DAOFactory.build(StdrewardbssDAO.class, user);
        return (StdrewardbssVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(StdrewardbssListVO params, User user)
        throws Exception {
			StdrewardbssDAO dao = (StdrewardbssDAO) DAOFactory.build(StdrewardbssDAO.class, user);
        return dao.query(params);
    }
}
