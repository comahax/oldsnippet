/**
* auto-generated code
* Sat Jan 05 17:17:55 CST 2013
*/
package com.sunrise.boss.business.cms.terminalrewardstd.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.terminalrewardstd.persistent.TerminalrewardstdVO;
import com.sunrise.boss.business.cms.terminalrewardstd.persistent.TerminalrewardstdDAO;
import com.sunrise.boss.business.cms.terminalrewardstd.persistent.TerminalrewardstdListVO;

/**
 * <p>Title: TerminalrewardstdControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lc
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/terminalrewardstd/control/TerminalrewardstdControlBean"
 name="TerminalrewardstdControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class TerminalrewardstdControlBean extends AbstractControlBean
    implements TerminalrewardstdControl {

    public TerminalrewardstdVO doCreate(TerminalrewardstdVO vo, User user)
        throws Exception {
        try{
			TerminalrewardstdDAO dao = (TerminalrewardstdDAO) DAOFactory.build(TerminalrewardstdDAO.class, user);
            // TODO  set the pk */
            return (TerminalrewardstdVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(TerminalrewardstdVO vo, User user)
        throws Exception {
        try{
			TerminalrewardstdDAO dao = (TerminalrewardstdDAO) DAOFactory.build(TerminalrewardstdDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public TerminalrewardstdVO doUpdate(TerminalrewardstdVO vo, User user)
        throws Exception {
        try{
			TerminalrewardstdDAO dao = (TerminalrewardstdDAO) DAOFactory.build(TerminalrewardstdDAO.class, user);
            return (TerminalrewardstdVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public TerminalrewardstdVO doFindByPk(Serializable pk, User user)
        throws Exception {
			TerminalrewardstdDAO dao = (TerminalrewardstdDAO) DAOFactory.build(TerminalrewardstdDAO.class, user);
        return (TerminalrewardstdVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(TerminalrewardstdListVO params, User user)
        throws Exception {
			TerminalrewardstdDAO dao = (TerminalrewardstdDAO) DAOFactory.build(TerminalrewardstdDAO.class, user);
        return dao.query(params);
    }
}
