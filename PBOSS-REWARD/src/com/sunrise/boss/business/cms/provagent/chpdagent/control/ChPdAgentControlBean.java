/**
* auto-generated code
* Mon Sep 02 12:21:21 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdagent.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdagent.persistent.ChPdAgentDAO;
import com.sunrise.boss.business.cms.provagent.chpdagent.persistent.ChPdAgentListVO;
import com.sunrise.boss.business.cms.provagent.chpdagent.persistent.ChPdAgentVO;

/**
 * <p>Title: ChPdAgentControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/proagent/chpdagent/control/ChPdAgentControlBean"
 name="ChPdAgentControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPdAgentControlBean extends AbstractControlBean
    implements ChPdAgentControl {

    public ChPdAgentVO doCreate(ChPdAgentVO vo, User user)
        throws Exception {
        try{
			ChPdAgentDAO dao = (ChPdAgentDAO) DAOFactory.build(ChPdAgentDAO.class, user);
            // TODO  set the pk */
            return (ChPdAgentVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPdAgentVO vo, User user)
        throws Exception {
        try{
			ChPdAgentDAO dao = (ChPdAgentDAO) DAOFactory.build(ChPdAgentDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdAgentVO doUpdate(ChPdAgentVO vo, User user)
        throws Exception {
        try{
			ChPdAgentDAO dao = (ChPdAgentDAO) DAOFactory.build(ChPdAgentDAO.class, user);
            return (ChPdAgentVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdAgentVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPdAgentDAO dao = (ChPdAgentDAO) DAOFactory.build(ChPdAgentDAO.class, user);
        return (ChPdAgentVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPdAgentListVO params, User user)
        throws Exception {
			ChPdAgentDAO dao = (ChPdAgentDAO) DAOFactory.build(ChPdAgentDAO.class, user);
        return dao.query(params);
    }
}
