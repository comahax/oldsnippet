/**
* auto-generated code
* Wed Sep 04 21:22:46 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdrewardadc.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdrewardadc.persistent.ChPdRewardadcVO;
import com.sunrise.boss.business.cms.provagent.chpdrewardadc.persistent.ChPdRewardadcDAO;
import com.sunrise.boss.business.cms.provagent.chpdrewardadc.persistent.ChPdRewardadcListVO;

/**
 * <p>Title: ChPdRewardadcControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/provagent/chpdrewardadc/control/ChPdRewardadcControlBean"
 name="ChPdRewardadcControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPdRewardadcControlBean extends AbstractControlBean
    implements ChPdRewardadcControl {

    public ChPdRewardadcVO doCreate(ChPdRewardadcVO vo, User user)
        throws Exception {
        try{
			ChPdRewardadcDAO dao = (ChPdRewardadcDAO) DAOFactory.build(ChPdRewardadcDAO.class, user);
            // TODO  set the pk */
            return (ChPdRewardadcVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPdRewardadcVO vo, User user)
        throws Exception {
        try{
			ChPdRewardadcDAO dao = (ChPdRewardadcDAO) DAOFactory.build(ChPdRewardadcDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdRewardadcVO doUpdate(ChPdRewardadcVO vo, User user)
        throws Exception {
        try{
			ChPdRewardadcDAO dao = (ChPdRewardadcDAO) DAOFactory.build(ChPdRewardadcDAO.class, user);
            return (ChPdRewardadcVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdRewardadcVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPdRewardadcDAO dao = (ChPdRewardadcDAO) DAOFactory.build(ChPdRewardadcDAO.class, user);
        return (ChPdRewardadcVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPdRewardadcListVO params, User user)
        throws Exception {
			ChPdRewardadcDAO dao = (ChPdRewardadcDAO) DAOFactory.build(ChPdRewardadcDAO.class, user);
        return dao.query(params);
    }
}
