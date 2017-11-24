/**
* auto-generated code
* Fri Feb 01 18:28:31 CST 2008
*/
package com.sunrise.boss.business.cms.stdrewardlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdrewardlog.persistent.StdrewardlogVO;
import com.sunrise.boss.business.cms.stdrewardlog.persistent.StdrewardlogDAO;
import com.sunrise.boss.business.cms.stdrewardlog.persistent.StdrewardlogListVO;

/**
 * <p>Title: StdrewardlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/stdrewardlog/control/StdrewardlogControlBean"
 name="StdrewardlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class StdrewardlogControlBean extends AbstractControlBean
    implements StdrewardlogControl {

    public StdrewardlogVO doCreate(StdrewardlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         StdrewardlogDAO dao = (StdrewardlogDAO) DAOFactory.build(StdrewardlogDAO.class, user);
            return (StdrewardlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(StdrewardlogVO vo, User user)
        throws Exception {
        try{
         StdrewardlogDAO dao = (StdrewardlogDAO) DAOFactory.build(StdrewardlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public StdrewardlogVO doUpdate(StdrewardlogVO vo, User user)
        throws Exception {
        try{
         StdrewardlogDAO dao = (StdrewardlogDAO) DAOFactory.build(StdrewardlogDAO.class, user);
            return (StdrewardlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public StdrewardlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         StdrewardlogDAO dao = (StdrewardlogDAO) DAOFactory.build(StdrewardlogDAO.class, user);
        return (StdrewardlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(StdrewardlogListVO params, User user)
        throws Exception {
         StdrewardlogDAO dao = (StdrewardlogDAO) DAOFactory.build(StdrewardlogDAO.class, user);
        return dao.query(params);
    }
}
