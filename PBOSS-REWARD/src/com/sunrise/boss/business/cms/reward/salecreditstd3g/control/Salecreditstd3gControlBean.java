/**
* auto-generated code
* Tue Dec 11 09:30:18 CST 2012
*/
package com.sunrise.boss.business.cms.reward.salecreditstd3g.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.salecreditstd3g.persistent.Salecreditstd3gVO;
import com.sunrise.boss.business.cms.reward.salecreditstd3g.persistent.Salecreditstd3gDAO;
import com.sunrise.boss.business.cms.reward.salecreditstd3g.persistent.Salecreditstd3gListVO;

/**
 * <p>Title: Salecreditstd3gControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/salecreditstd3g/control/Salecreditstd3gControlBean"
 name="Salecreditstd3gControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class Salecreditstd3gControlBean extends AbstractControlBean
    implements Salecreditstd3gControl {

    public Salecreditstd3gVO doCreate(Salecreditstd3gVO vo, User user)
        throws Exception {
        try{
			Salecreditstd3gDAO dao = (Salecreditstd3gDAO) DAOFactory.build(Salecreditstd3gDAO.class, user);
            // TODO  set the pk */
            return (Salecreditstd3gVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(Salecreditstd3gVO vo, User user)
        throws Exception {
        try{
			Salecreditstd3gDAO dao = (Salecreditstd3gDAO) DAOFactory.build(Salecreditstd3gDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    
    public void doRemoveByPk(Serializable pk, User user)throws Exception {
	    try{
			Salecreditstd3gDAO dao = (Salecreditstd3gDAO) DAOFactory.build(Salecreditstd3gDAO.class, user);
	        dao.removeByPk(pk);
	    } catch(Exception ex){
	        sessionContext.setRollbackOnly();
	        throw ex;
	    }
    }

    public Salecreditstd3gVO doUpdate(Salecreditstd3gVO vo, User user)
        throws Exception {
        try{
			Salecreditstd3gDAO dao = (Salecreditstd3gDAO) DAOFactory.build(Salecreditstd3gDAO.class, user);
            return (Salecreditstd3gVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public Salecreditstd3gVO doFindByPk(Serializable pk, User user)
        throws Exception {
			Salecreditstd3gDAO dao = (Salecreditstd3gDAO) DAOFactory.build(Salecreditstd3gDAO.class, user);
        return (Salecreditstd3gVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(Salecreditstd3gListVO params, User user)
        throws Exception {
			Salecreditstd3gDAO dao = (Salecreditstd3gDAO) DAOFactory.build(Salecreditstd3gDAO.class, user);
        return dao.query(params);
    }
}
