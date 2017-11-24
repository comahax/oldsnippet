/**
* auto-generated code
* Sat Oct 10 09:26:17 CST 2009
*/
package com.sunrise.boss.business.cms.reward.stdrewardbjstar.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardbjstar.persistent.StdrewardbjstarVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjstar.persistent.StdrewardbjstarDAO;
import com.sunrise.boss.business.cms.reward.stdrewardbjstar.persistent.StdrewardbjstarListVO;

/**
 * <p>Title: StdrewardbjstarControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/stdrewardbjstar/control/StdrewardbjstarControlBean"
 name="StdrewardbjstarControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class StdrewardbjstarControlBean extends AbstractControlBean
    implements StdrewardbjstarControl {

    public StdrewardbjstarVO doCreate(StdrewardbjstarVO vo, User user)
        throws Exception {
        try{
			StdrewardbjstarDAO dao = (StdrewardbjstarDAO) DAOFactory.build(StdrewardbjstarDAO.class, user);
            // TODO  set the pk */
            return (StdrewardbjstarVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(StdrewardbjstarVO vo, User user)
        throws Exception {
        try{
			StdrewardbjstarDAO dao = (StdrewardbjstarDAO) DAOFactory.build(StdrewardbjstarDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public StdrewardbjstarVO doUpdate(StdrewardbjstarVO vo, User user)
        throws Exception {
        try{
			StdrewardbjstarDAO dao = (StdrewardbjstarDAO) DAOFactory.build(StdrewardbjstarDAO.class, user);
            return (StdrewardbjstarVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public StdrewardbjstarVO doFindByPk(Serializable pk, User user)
        throws Exception {
			StdrewardbjstarDAO dao = (StdrewardbjstarDAO) DAOFactory.build(StdrewardbjstarDAO.class, user);
        return (StdrewardbjstarVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(StdrewardbjstarListVO params, User user)
        throws Exception {
			StdrewardbjstarDAO dao = (StdrewardbjstarDAO) DAOFactory.build(StdrewardbjstarDAO.class, user);
        return dao.query(params);
    }
}
