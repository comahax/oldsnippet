/**
* auto-generated code
* Tue Dec 11 12:11:57 CST 2012
*/
package com.sunrise.boss.business.cms.reward.salecreditstd3glog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.salecreditstd3glog.persistent.Salecreditstd3glogVO;
import com.sunrise.boss.business.cms.reward.salecreditstd3glog.persistent.Salecreditstd3glogDAO;
import com.sunrise.boss.business.cms.reward.salecreditstd3glog.persistent.Salecreditstd3glogListVO;

/**
 * <p>Title: Salecreditstd3glogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/salecreditstd3glog/control/Salecreditstd3glogControlBean"
 name="Salecreditstd3glogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class Salecreditstd3glogControlBean extends AbstractControlBean
    implements Salecreditstd3glogControl {

    public Salecreditstd3glogVO doCreate(Salecreditstd3glogVO vo, User user)
        throws Exception {
        try{
			Salecreditstd3glogDAO dao = (Salecreditstd3glogDAO) DAOFactory.build(Salecreditstd3glogDAO.class, user);
            // TODO  set the pk */
            return (Salecreditstd3glogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(Salecreditstd3glogVO vo, User user)
        throws Exception {
        try{
			Salecreditstd3glogDAO dao = (Salecreditstd3glogDAO) DAOFactory.build(Salecreditstd3glogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public Salecreditstd3glogVO doUpdate(Salecreditstd3glogVO vo, User user)
        throws Exception {
        try{
			Salecreditstd3glogDAO dao = (Salecreditstd3glogDAO) DAOFactory.build(Salecreditstd3glogDAO.class, user);
            return (Salecreditstd3glogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public Salecreditstd3glogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			Salecreditstd3glogDAO dao = (Salecreditstd3glogDAO) DAOFactory.build(Salecreditstd3glogDAO.class, user);
        return (Salecreditstd3glogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(Salecreditstd3glogListVO params, User user)
        throws Exception {
			Salecreditstd3glogDAO dao = (Salecreditstd3glogDAO) DAOFactory.build(Salecreditstd3glogDAO.class, user);
        return dao.query(params);
    }
}
