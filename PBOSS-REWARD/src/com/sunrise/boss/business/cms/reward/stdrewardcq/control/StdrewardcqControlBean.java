/**
* auto-generated code
* Thu Dec 22 09:33:15 CST 2011
*/
package com.sunrise.boss.business.cms.reward.stdrewardcq.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardcq.persistent.StdrewardcqVO;
import com.sunrise.boss.business.cms.reward.stdrewardcq.persistent.StdrewardcqDAO;
import com.sunrise.boss.business.cms.reward.stdrewardcq.persistent.StdrewardcqListVO;

/**
 * <p>Title: StdrewardcqControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/stdrewardcq/control/StdrewardcqControlBean"
 name="StdrewardcqControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class StdrewardcqControlBean extends AbstractControlBean
    implements StdrewardcqControl {

    public StdrewardcqVO doCreate(StdrewardcqVO vo, User user)
        throws Exception {
        try{
			StdrewardcqDAO dao = (StdrewardcqDAO) DAOFactory.build(StdrewardcqDAO.class, user);
            // TODO  set the pk */
            return (StdrewardcqVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(StdrewardcqVO vo, User user)
        throws Exception {
        try{
			StdrewardcqDAO dao = (StdrewardcqDAO) DAOFactory.build(StdrewardcqDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public StdrewardcqVO doUpdate(StdrewardcqVO vo, User user)
        throws Exception {
        try{
			StdrewardcqDAO dao = (StdrewardcqDAO) DAOFactory.build(StdrewardcqDAO.class, user);
            return (StdrewardcqVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public StdrewardcqVO doFindByPk(Serializable pk, User user)
        throws Exception {
			StdrewardcqDAO dao = (StdrewardcqDAO) DAOFactory.build(StdrewardcqDAO.class, user);
        return (StdrewardcqVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(StdrewardcqListVO params, User user)
        throws Exception {
			StdrewardcqDAO dao = (StdrewardcqDAO) DAOFactory.build(StdrewardcqDAO.class, user);
        return dao.query(params);
    }
    public DataPackage doQuery2(StdrewardcqListVO params, User user)
    throws Exception {
		StdrewardcqDAO dao = (StdrewardcqDAO) DAOFactory.build(StdrewardcqDAO.class, user);
    return dao.query22(params);
}
}
