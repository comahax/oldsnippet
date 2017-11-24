/**
* auto-generated code
* Fri Apr 20 16:55:21 CST 2012
*/
package com.sunrise.boss.business.cms.bbc.subtract.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.subtract.persistent.SubtractVO;
import com.sunrise.boss.business.cms.bbc.subtract.persistent.SubtractDAO;
import com.sunrise.boss.business.cms.bbc.subtract.persistent.SubtractListVO;

/**
 * <p>Title: SubtractControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/subtract/control/SubtractControlBean"
 name="SubtractControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class SubtractControlBean extends AbstractControlBean
    implements SubtractControl {

    public SubtractVO doCreate(SubtractVO vo, User user)
        throws Exception {
        try{
			SubtractDAO dao = (SubtractDAO) DAOFactory.build(SubtractDAO.class, user);
            // TODO  set the pk */
            return (SubtractVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(SubtractVO vo, User user)
        throws Exception {
        try{
			SubtractDAO dao = (SubtractDAO) DAOFactory.build(SubtractDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public SubtractVO doUpdate(SubtractVO vo, User user)
        throws Exception {
        try{
			SubtractDAO dao = (SubtractDAO) DAOFactory.build(SubtractDAO.class, user);
            return (SubtractVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public SubtractVO doFindByPk(Serializable pk, User user)
        throws Exception {
			SubtractDAO dao = (SubtractDAO) DAOFactory.build(SubtractDAO.class, user);
        return (SubtractVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(SubtractListVO params, User user)
        throws Exception {
			SubtractDAO dao = (SubtractDAO) DAOFactory.build(SubtractDAO.class, user);
        return dao.query(params);
    }
}
