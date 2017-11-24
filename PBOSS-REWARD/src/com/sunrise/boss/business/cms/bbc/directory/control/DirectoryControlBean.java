/**
* auto-generated code
* Tue Mar 12 15:11:57 CST 2013
*/
package com.sunrise.boss.business.cms.bbc.directory.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.directory.persistent.DirectoryVO;
import com.sunrise.boss.business.cms.bbc.directory.persistent.DirectoryDAO;
import com.sunrise.boss.business.cms.bbc.directory.persistent.DirectoryListVO;

/**
 * <p>Title: DirectoryControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/directory/control/DirectoryControlBean"
 name="DirectoryControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class DirectoryControlBean extends AbstractControlBean
    implements DirectoryControl {

    public DirectoryVO doCreate(DirectoryVO vo, User user)
        throws Exception {
        try{
			DirectoryDAO dao = (DirectoryDAO) DAOFactory.build(DirectoryDAO.class, user);
            // TODO  set the pk */
            return (DirectoryVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(DirectoryVO vo, User user)
        throws Exception {
        try{
			DirectoryDAO dao = (DirectoryDAO) DAOFactory.build(DirectoryDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public DirectoryVO doUpdate(DirectoryVO vo, User user)
        throws Exception {
        try{
			DirectoryDAO dao = (DirectoryDAO) DAOFactory.build(DirectoryDAO.class, user);
            return (DirectoryVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public DirectoryVO doFindByPk(Serializable pk, User user)
        throws Exception {
			DirectoryDAO dao = (DirectoryDAO) DAOFactory.build(DirectoryDAO.class, user);
        return (DirectoryVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(DirectoryListVO params, User user)
        throws Exception {
			DirectoryDAO dao = (DirectoryDAO) DAOFactory.build(DirectoryDAO.class, user);
        return dao.query(params);
    }
}
