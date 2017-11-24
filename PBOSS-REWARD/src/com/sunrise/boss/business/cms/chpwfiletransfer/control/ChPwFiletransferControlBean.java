/**
* auto-generated code
* Thu Jul 03 15:10:27 CST 2014
*/
package com.sunrise.boss.business.cms.chpwfiletransfer.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.chpwfiletransfer.persistent.ChPwFiletransferDAO;
import com.sunrise.boss.business.cms.chpwfiletransfer.persistent.ChPwFiletransferListVO;
import com.sunrise.boss.business.cms.chpwfiletransfer.persistent.ChPwFiletransferVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;


/**
 * <p>Title: ChPwFiletransferControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chpwfiletransfer/control/ChPwFiletransferControlBean"
 name="ChPwFiletransferControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPwFiletransferControlBean extends AbstractControlBean
    implements ChPwFiletransferControl {

    public ChPwFiletransferVO doCreate(ChPwFiletransferVO vo, User user)
        throws Exception {
        try{
			ChPwFiletransferDAO dao = (ChPwFiletransferDAO) DAOFactory.build(ChPwFiletransferDAO.class, user);
            // TODO  set the pk */
            return (ChPwFiletransferVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPwFiletransferVO vo, User user)
        throws Exception {
        try{
			ChPwFiletransferDAO dao = (ChPwFiletransferDAO) DAOFactory.build(ChPwFiletransferDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPwFiletransferVO doUpdate(ChPwFiletransferVO vo, User user)
        throws Exception {
        try{
			ChPwFiletransferDAO dao = (ChPwFiletransferDAO) DAOFactory.build(ChPwFiletransferDAO.class, user);
            return (ChPwFiletransferVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPwFiletransferVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPwFiletransferDAO dao = (ChPwFiletransferDAO) DAOFactory.build(ChPwFiletransferDAO.class, user);
        return (ChPwFiletransferVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPwFiletransferListVO params, User user)
        throws Exception {
			ChPwFiletransferDAO dao = (ChPwFiletransferDAO) DAOFactory.build(ChPwFiletransferDAO.class, user);
        return dao.query(params);
    }
}
