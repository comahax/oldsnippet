/**
* auto-generated code
* Sat Feb 02 15:15:28 CST 2008
*/
package com.sunrise.boss.business.cms.reward.busyxplanlog.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.reward.busyxplanlog.persistent.BusyxplanlogDAO;
import com.sunrise.boss.business.cms.reward.busyxplanlog.persistent.BusyxplanlogListVO;
import com.sunrise.boss.business.cms.reward.busyxplanlog.persistent.BusyxplanlogVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BusyxplanlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/busyxplanlog/control/BusyxplanlogControlBean"
 name="BusyxplanlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BusyxplanlogControlBean extends AbstractControlBean
    implements BusyxplanlogControl {

    public BusyxplanlogVO doCreate(BusyxplanlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         BusyxplanlogDAO dao = (BusyxplanlogDAO) DAOFactory.build(BusyxplanlogDAO.class, user);
            return (BusyxplanlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(BusyxplanlogVO vo, User user)
        throws Exception {
        try{
         BusyxplanlogDAO dao = (BusyxplanlogDAO) DAOFactory.build(BusyxplanlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BusyxplanlogVO doUpdate(BusyxplanlogVO vo, User user)
        throws Exception {
        try{
         BusyxplanlogDAO dao = (BusyxplanlogDAO) DAOFactory.build(BusyxplanlogDAO.class, user);
            return (BusyxplanlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BusyxplanlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         BusyxplanlogDAO dao = (BusyxplanlogDAO) DAOFactory.build(BusyxplanlogDAO.class, user);
        return (BusyxplanlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(BusyxplanlogListVO params, User user)
        throws Exception {
         BusyxplanlogDAO dao = (BusyxplanlogDAO) DAOFactory.build(BusyxplanlogDAO.class, user);
        return dao.query(params);
    }
}
