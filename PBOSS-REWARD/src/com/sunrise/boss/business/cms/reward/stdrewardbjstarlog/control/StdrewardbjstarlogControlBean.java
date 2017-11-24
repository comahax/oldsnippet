/**
* auto-generated code
* Sat Oct 10 09:27:09 CST 2009
*/
package com.sunrise.boss.business.cms.reward.stdrewardbjstarlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardbjstarlog.persistent.StdrewardbjstarlogVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjstarlog.persistent.StdrewardbjstarlogDAO;
import com.sunrise.boss.business.cms.reward.stdrewardbjstarlog.persistent.StdrewardbjstarlogListVO;

/**
 * <p>Title: StdrewardbjstarlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/stdrewardbjstarlog/control/StdrewardbjstarlogControlBean"
 name="StdrewardbjstarlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class StdrewardbjstarlogControlBean extends AbstractControlBean
    implements StdrewardbjstarlogControl {

    public StdrewardbjstarlogVO doCreate(StdrewardbjstarlogVO vo, User user)
        throws Exception {
        try{
			StdrewardbjstarlogDAO dao = (StdrewardbjstarlogDAO) DAOFactory.build(StdrewardbjstarlogDAO.class, user);
            // TODO  set the pk */
            return (StdrewardbjstarlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(StdrewardbjstarlogVO vo, User user)
        throws Exception {
        try{
			StdrewardbjstarlogDAO dao = (StdrewardbjstarlogDAO) DAOFactory.build(StdrewardbjstarlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public StdrewardbjstarlogVO doUpdate(StdrewardbjstarlogVO vo, User user)
        throws Exception {
        try{
			StdrewardbjstarlogDAO dao = (StdrewardbjstarlogDAO) DAOFactory.build(StdrewardbjstarlogDAO.class, user);
            return (StdrewardbjstarlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public StdrewardbjstarlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			StdrewardbjstarlogDAO dao = (StdrewardbjstarlogDAO) DAOFactory.build(StdrewardbjstarlogDAO.class, user);
        return (StdrewardbjstarlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(StdrewardbjstarlogListVO params, User user)
        throws Exception {
			StdrewardbjstarlogDAO dao = (StdrewardbjstarlogDAO) DAOFactory.build(StdrewardbjstarlogDAO.class, user);
        return dao.query(params);
    }
}
