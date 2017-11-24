/**
* auto-generated code
* Wed Sep 04 21:04:55 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdrewardrecord.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdrewardrecord.persistent.ChPdRewardrecordVO;
import com.sunrise.boss.business.cms.provagent.chpdrewardrecord.persistent.ChPdRewardrecordDAO;
import com.sunrise.boss.business.cms.provagent.chpdrewardrecord.persistent.ChPdRewardrecordListVO;

/**
 * <p>Title: ChPdRewardrecordControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/provagent/chpdrewardrecord/control/ChPdRewardrecordControlBean"
 name="ChPdRewardrecordControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPdRewardrecordControlBean extends AbstractControlBean
    implements ChPdRewardrecordControl {

    public ChPdRewardrecordVO doCreate(ChPdRewardrecordVO vo, User user)
        throws Exception {
        try{
			ChPdRewardrecordDAO dao = (ChPdRewardrecordDAO) DAOFactory.build(ChPdRewardrecordDAO.class, user);
            // TODO  set the pk */
            return (ChPdRewardrecordVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPdRewardrecordVO vo, User user)
        throws Exception {
        try{
			ChPdRewardrecordDAO dao = (ChPdRewardrecordDAO) DAOFactory.build(ChPdRewardrecordDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdRewardrecordVO doUpdate(ChPdRewardrecordVO vo, User user)
        throws Exception {
        try{
			ChPdRewardrecordDAO dao = (ChPdRewardrecordDAO) DAOFactory.build(ChPdRewardrecordDAO.class, user);
            return (ChPdRewardrecordVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdRewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPdRewardrecordDAO dao = (ChPdRewardrecordDAO) DAOFactory.build(ChPdRewardrecordDAO.class, user);
        return (ChPdRewardrecordVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPdRewardrecordListVO params, User user)
        throws Exception {
			ChPdRewardrecordDAO dao = (ChPdRewardrecordDAO) DAOFactory.build(ChPdRewardrecordDAO.class, user);
        return dao.query(params);
    }
}
