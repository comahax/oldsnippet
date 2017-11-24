/**
* auto-generated code
* Tue Feb 05 10:15:16 CST 2008
*/
package com.sunrise.boss.business.cms.bcityloadlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bcityloadlog.persistent.BcityloadlogVO;
import com.sunrise.boss.business.cms.bcityloadlog.persistent.BcityloadlogDAO;
import com.sunrise.boss.business.cms.bcityloadlog.persistent.BcityloadlogListVO;

/**
 * <p>Title: BcityloadlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bcityloadlog/control/BcityloadlogControlBean"
 name="BcityloadlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BcityloadlogControlBean extends AbstractControlBean
    implements BcityloadlogControl {

    public BcityloadlogVO doCreate(BcityloadlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         BcityloadlogDAO dao = (BcityloadlogDAO) DAOFactory.build(BcityloadlogDAO.class, user);
            return (BcityloadlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(BcityloadlogVO vo, User user)
        throws Exception {
        try{
         BcityloadlogDAO dao = (BcityloadlogDAO) DAOFactory.build(BcityloadlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BcityloadlogVO doUpdate(BcityloadlogVO vo, User user)
        throws Exception {
        try{
         BcityloadlogDAO dao = (BcityloadlogDAO) DAOFactory.build(BcityloadlogDAO.class, user);
            return (BcityloadlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BcityloadlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         BcityloadlogDAO dao = (BcityloadlogDAO) DAOFactory.build(BcityloadlogDAO.class, user);
        return (BcityloadlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(BcityloadlogListVO params, User user)
        throws Exception {
         BcityloadlogDAO dao = (BcityloadlogDAO) DAOFactory.build(BcityloadlogDAO.class, user);
        return dao.query(params);
    }
}
