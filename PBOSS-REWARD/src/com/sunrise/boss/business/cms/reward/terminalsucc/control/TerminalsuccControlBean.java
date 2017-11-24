/**
* auto-generated code
* Fri Apr 09 12:40:50 CST 2010
*/
package com.sunrise.boss.business.cms.reward.terminalsucc.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.terminalsucc.persistent.TerminalsuccVO;
import com.sunrise.boss.business.cms.reward.terminalsucc.persistent.TerminalsuccDAO;
import com.sunrise.boss.business.cms.reward.terminalsucc.persistent.TerminalsuccListVO;

/**
 * <p>Title: TerminalsuccControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/terminalsucc/control/TerminalsuccControlBean"
 name="TerminalsuccControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class TerminalsuccControlBean extends AbstractControlBean
    implements TerminalsuccControl {

    public TerminalsuccVO doCreate(TerminalsuccVO vo, User user)
        throws Exception {
        try{
			TerminalsuccDAO dao = (TerminalsuccDAO) DAOFactory.build(TerminalsuccDAO.class, user);
            // TODO  set the pk */
            return (TerminalsuccVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(TerminalsuccVO vo, User user)
        throws Exception {
        try{
			TerminalsuccDAO dao = (TerminalsuccDAO) DAOFactory.build(TerminalsuccDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public TerminalsuccVO doUpdate(TerminalsuccVO vo, User user)
        throws Exception {
        try{
			TerminalsuccDAO dao = (TerminalsuccDAO) DAOFactory.build(TerminalsuccDAO.class, user);
            return (TerminalsuccVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public TerminalsuccVO doFindByPk(Serializable pk, User user)
        throws Exception {
			TerminalsuccDAO dao = (TerminalsuccDAO) DAOFactory.build(TerminalsuccDAO.class, user);
        return (TerminalsuccVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(TerminalsuccListVO params, User user)
        throws Exception {
			TerminalsuccDAO dao = (TerminalsuccDAO) DAOFactory.build(TerminalsuccDAO.class, user);
        return dao.doQueryTerminalsucc(params, user);
    }
}
