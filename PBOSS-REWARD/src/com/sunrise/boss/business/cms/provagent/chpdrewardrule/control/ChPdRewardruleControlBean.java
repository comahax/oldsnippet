/**
* auto-generated code
* Wed Sep 04 16:35:49 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdrewardrule.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdrewardrule.persistent.ChPdRewardruleVO;
import com.sunrise.boss.business.cms.provagent.chpdrewardrule.persistent.ChPdRewardruleDAO;
import com.sunrise.boss.business.cms.provagent.chpdrewardrule.persistent.ChPdRewardruleListVO;

/**
 * <p>Title: ChPdRewardruleControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/provagent/chpdrewardrule/control/ChPdRewardruleControlBean"
 name="ChPdRewardruleControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPdRewardruleControlBean extends AbstractControlBean
    implements ChPdRewardruleControl {

    public ChPdRewardruleVO doCreate(ChPdRewardruleVO vo, User user)
        throws Exception {
        try{
			ChPdRewardruleDAO dao = (ChPdRewardruleDAO) DAOFactory.build(ChPdRewardruleDAO.class, user);
            // TODO  set the pk */
            return (ChPdRewardruleVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPdRewardruleVO vo, User user)
        throws Exception {
        try{
			ChPdRewardruleDAO dao = (ChPdRewardruleDAO) DAOFactory.build(ChPdRewardruleDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdRewardruleVO doUpdate(ChPdRewardruleVO vo, User user)
        throws Exception {
        try{
			ChPdRewardruleDAO dao = (ChPdRewardruleDAO) DAOFactory.build(ChPdRewardruleDAO.class, user);
            return (ChPdRewardruleVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdRewardruleVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPdRewardruleDAO dao = (ChPdRewardruleDAO) DAOFactory.build(ChPdRewardruleDAO.class, user);
        return (ChPdRewardruleVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPdRewardruleListVO params, User user)
        throws Exception {
    	params.set_orderby("ruleid");
    	params.set_desc("1");
		ChPdRewardruleDAO dao = (ChPdRewardruleDAO) DAOFactory.build(ChPdRewardruleDAO.class, user);
        return dao.query(params);
    }
}
