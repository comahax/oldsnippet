/**
* auto-generated code
* Thu Jul 12 15:24:43 CST 2012
*/
package com.sunrise.boss.business.cms.zjty.chzjtyrewfilenote.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenote.persistent.ChZjtyRewfilenoteVO;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenote.persistent.ChZjtyRewfilenoteDAO;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenote.persistent.ChZjtyRewfilenoteListVO;

/**
 * <p>Title: ChZjtyRewfilenoteControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/chzjtyrewfilenote/control/ChZjtyRewfilenoteControlBean"
 name="ChZjtyRewfilenoteControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZjtyRewfilenoteControlBean extends AbstractControlBean
    implements ChZjtyRewfilenoteControl {

    public ChZjtyRewfilenoteVO doCreate(ChZjtyRewfilenoteVO vo, User user)
        throws Exception {
        try{
			ChZjtyRewfilenoteDAO dao = (ChZjtyRewfilenoteDAO) DAOFactory.build(ChZjtyRewfilenoteDAO.class, user);
            // TODO  set the pk */
            return (ChZjtyRewfilenoteVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChZjtyRewfilenoteVO vo, User user)
        throws Exception {
        try{
			ChZjtyRewfilenoteDAO dao = (ChZjtyRewfilenoteDAO) DAOFactory.build(ChZjtyRewfilenoteDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyRewfilenoteVO doUpdate(ChZjtyRewfilenoteVO vo, User user)
        throws Exception {
        try{
			ChZjtyRewfilenoteDAO dao = (ChZjtyRewfilenoteDAO) DAOFactory.build(ChZjtyRewfilenoteDAO.class, user);
            return (ChZjtyRewfilenoteVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyRewfilenoteVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChZjtyRewfilenoteDAO dao = (ChZjtyRewfilenoteDAO) DAOFactory.build(ChZjtyRewfilenoteDAO.class, user);
        return (ChZjtyRewfilenoteVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChZjtyRewfilenoteListVO params, User user)
        throws Exception {
			ChZjtyRewfilenoteDAO dao = (ChZjtyRewfilenoteDAO) DAOFactory.build(ChZjtyRewfilenoteDAO.class, user);
        return dao.query(params);
    }
}
