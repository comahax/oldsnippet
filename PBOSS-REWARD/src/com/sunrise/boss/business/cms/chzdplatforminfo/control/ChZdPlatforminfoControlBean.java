/**
* auto-generated code
* Sat May 11 16:40:18 CST 2013
*/
package com.sunrise.boss.business.cms.chzdplatforminfo.control;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.business.cms.chzdplatforminfo.persistent.ChZdPlatforminfoDAO;
import com.sunrise.boss.business.cms.chzdplatforminfo.persistent.ChZdPlatforminfoListVO;
import com.sunrise.boss.business.cms.chzdplatforminfo.persistent.ChZdPlatforminfoVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ChZdPlatforminfoControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chzdplatforminfo/control/ChZdPlatforminfoControlBean"
 name="ChZdPlatforminfoControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZdPlatforminfoControlBean extends AbstractControlBean
    implements ChZdPlatforminfoControl {

    public ChZdPlatforminfoVO doCreate(ChZdPlatforminfoVO vo, User user)
        throws Exception {
        try{
			ChZdPlatforminfoDAO dao = (ChZdPlatforminfoDAO) DAOFactory.build(ChZdPlatforminfoDAO.class, user);
            // TODO  set the pk */
            return (ChZdPlatforminfoVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChZdPlatforminfoVO vo, User user)
        throws Exception {
        try{
			ChZdPlatforminfoDAO dao = (ChZdPlatforminfoDAO) DAOFactory.build(ChZdPlatforminfoDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZdPlatforminfoVO doUpdate(ChZdPlatforminfoVO vo, User user)
        throws Exception {
        try{
			ChZdPlatforminfoDAO dao = (ChZdPlatforminfoDAO) DAOFactory.build(ChZdPlatforminfoDAO.class, user);
            return (ChZdPlatforminfoVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZdPlatforminfoVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChZdPlatforminfoDAO dao = (ChZdPlatforminfoDAO) DAOFactory.build(ChZdPlatforminfoDAO.class, user);
        return (ChZdPlatforminfoVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChZdPlatforminfoListVO params, User user)
        throws Exception {
			ChZdPlatforminfoDAO dao = (ChZdPlatforminfoDAO) DAOFactory.build(ChZdPlatforminfoDAO.class, user);
        return dao.query(params);
    }
    
//    public DataPackage doQueryForZdplatform(ChZdPlatforminfoListVO params, User user)
//    throws Exception {
//		ChZdPlatforminfoDAO dao = (ChZdPlatforminfoDAO) DAOFactory.build(ChZdPlatforminfoDAO.class, user);
//	    return dao.queryforzdplatform(params);
//	}

    public DataPackage doQueryForZdplatform(ChZdPlatforminfoListVO params, User user)
        throws Exception {
		ChZdPlatforminfoDAO dao = (ChZdPlatforminfoDAO) DAOFactory.build(ChZdPlatforminfoDAO.class, user);
    	return dao.queryforzdplatform(params);
    }
    
    public DataPackage doQueryForProducttype(ChZdPlatforminfoListVO params, User user)
    	throws Exception {
			ChZdPlatforminfoDAO dao = (ChZdPlatforminfoDAO) DAOFactory.build(ChZdPlatforminfoDAO.class, user);
		return dao.queryforproducttype(params);
    }
}
