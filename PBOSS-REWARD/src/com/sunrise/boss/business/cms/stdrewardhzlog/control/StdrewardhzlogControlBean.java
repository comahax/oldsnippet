/**
* auto-generated code
* Sun Feb 01 11:20:05 CST 2009
*/
package com.sunrise.boss.business.cms.stdrewardhzlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdrewardhzlog.persistent.StdrewardhzlogVO;
import com.sunrise.boss.business.cms.stdrewardhzlog.persistent.StdrewardhzlogDAO;
import com.sunrise.boss.business.cms.stdrewardhzlog.persistent.StdrewardhzlogListVO;

/**
 * <p>Title: StdrewardhzlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/stdrewardhzlog/control/StdrewardhzlogControlBean"
 name="StdrewardhzlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class StdrewardhzlogControlBean extends AbstractControlBean
    implements StdrewardhzlogControl {

    public StdrewardhzlogVO doCreate(StdrewardhzlogVO vo, User user)
        throws Exception {
        try{
			StdrewardhzlogDAO dao = (StdrewardhzlogDAO) DAOFactory.build(StdrewardhzlogDAO.class, user);
            // TODO  set the pk */
            return (StdrewardhzlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(StdrewardhzlogVO vo, User user)
        throws Exception {
        try{
			StdrewardhzlogDAO dao = (StdrewardhzlogDAO) DAOFactory.build(StdrewardhzlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public StdrewardhzlogVO doUpdate(StdrewardhzlogVO vo, User user)
        throws Exception {
        try{
			StdrewardhzlogDAO dao = (StdrewardhzlogDAO) DAOFactory.build(StdrewardhzlogDAO.class, user);
            return (StdrewardhzlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public StdrewardhzlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			StdrewardhzlogDAO dao = (StdrewardhzlogDAO) DAOFactory.build(StdrewardhzlogDAO.class, user);
        return (StdrewardhzlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(StdrewardhzlogListVO params, User user)
        throws Exception {
			StdrewardhzlogDAO dao = (StdrewardhzlogDAO) DAOFactory.build(StdrewardhzlogDAO.class, user);
        return dao.query(params);
    }
}
