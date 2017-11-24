/**
* auto-generated code
* Thu Jul 03 15:10:27 CST 2014
*/
package com.sunrise.boss.business.cms.chpwstatreports.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chpwstatreports.persistent.ChPwStatreportsVO;
import com.sunrise.boss.business.cms.chpwstatreports.persistent.ChPwStatreportsDAO;
import com.sunrise.boss.business.cms.chpwstatreports.persistent.ChPwStatreportsListVO;

/**
 * <p>Title: ChPwStatreportsControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chpwstatreports/control/ChPwStatreportsControlBean"
 name="ChPwStatreportsControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPwStatreportsControlBean extends AbstractControlBean
    implements ChPwStatreportsControl {

    public ChPwStatreportsVO doCreate(ChPwStatreportsVO vo, User user)
        throws Exception {
        try{
			ChPwStatreportsDAO dao = (ChPwStatreportsDAO) DAOFactory.build(ChPwStatreportsDAO.class, user);
            // TODO  set the pk */
            return (ChPwStatreportsVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPwStatreportsVO vo, User user)
        throws Exception {
        try{
			ChPwStatreportsDAO dao = (ChPwStatreportsDAO) DAOFactory.build(ChPwStatreportsDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPwStatreportsVO doUpdate(ChPwStatreportsVO vo, User user)
        throws Exception {
        try{
			ChPwStatreportsDAO dao = (ChPwStatreportsDAO) DAOFactory.build(ChPwStatreportsDAO.class, user);
            return (ChPwStatreportsVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPwStatreportsVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPwStatreportsDAO dao = (ChPwStatreportsDAO) DAOFactory.build(ChPwStatreportsDAO.class, user);
        return (ChPwStatreportsVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPwStatreportsListVO params, User user)
        throws Exception {
			ChPwStatreportsDAO dao = (ChPwStatreportsDAO) DAOFactory.build(ChPwStatreportsDAO.class, user);
        return dao.query(params);
    }
}
