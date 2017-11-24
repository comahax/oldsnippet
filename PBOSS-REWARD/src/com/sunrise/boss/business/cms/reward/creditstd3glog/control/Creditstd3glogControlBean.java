/**
* auto-generated code
* Sat Dec 08 15:03:27 CST 2012
*/
package com.sunrise.boss.business.cms.reward.creditstd3glog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.creditstd3glog.persistent.Creditstd3glogVO;
import com.sunrise.boss.business.cms.reward.creditstd3glog.persistent.Creditstd3glogDAO;
import com.sunrise.boss.business.cms.reward.creditstd3glog.persistent.Creditstd3glogListVO;

/**
 * <p>Title: Creditstd3glogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/creditstd3glog/control/Creditstd3glogControlBean"
 name="Creditstd3glogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class Creditstd3glogControlBean extends AbstractControlBean
    implements Creditstd3glogControl {

    public Creditstd3glogVO doCreate(Creditstd3glogVO vo, User user)
        throws Exception {
        try{
			Creditstd3glogDAO dao = (Creditstd3glogDAO) DAOFactory.build(Creditstd3glogDAO.class, user);
            // TODO  set the pk */
            return (Creditstd3glogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(Creditstd3glogVO vo, User user)
        throws Exception {
        try{
			Creditstd3glogDAO dao = (Creditstd3glogDAO) DAOFactory.build(Creditstd3glogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public Creditstd3glogVO doUpdate(Creditstd3glogVO vo, User user)
        throws Exception {
        try{
			Creditstd3glogDAO dao = (Creditstd3glogDAO) DAOFactory.build(Creditstd3glogDAO.class, user);
            return (Creditstd3glogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public Creditstd3glogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			Creditstd3glogDAO dao = (Creditstd3glogDAO) DAOFactory.build(Creditstd3glogDAO.class, user);
        return (Creditstd3glogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(Creditstd3glogListVO params, User user)
        throws Exception {
			Creditstd3glogDAO dao = (Creditstd3glogDAO) DAOFactory.build(Creditstd3glogDAO.class, user);
        return dao.query(params);
    }
}
