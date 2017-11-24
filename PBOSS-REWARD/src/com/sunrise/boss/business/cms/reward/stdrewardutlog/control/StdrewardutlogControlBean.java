/**
* auto-generated code
* Fri Oct 08 15:00:14 CST 2010
*/
package com.sunrise.boss.business.cms.reward.stdrewardutlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardutlog.persistent.StdrewardutlogVO;
import com.sunrise.boss.business.cms.reward.stdrewardutlog.persistent.StdrewardutlogDAO;
import com.sunrise.boss.business.cms.reward.stdrewardutlog.persistent.StdrewardutlogListVO;

/**
 * <p>Title: StdrewardutlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/stdrewardutlog/control/StdrewardutlogControlBean"
 name="StdrewardutlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class StdrewardutlogControlBean extends AbstractControlBean
    implements StdrewardutlogControl {

    public StdrewardutlogVO doCreate(StdrewardutlogVO vo, User user)
        throws Exception {
        try{
			StdrewardutlogDAO dao = (StdrewardutlogDAO) DAOFactory.build(StdrewardutlogDAO.class, user);
            // TODO  set the pk */
            return (StdrewardutlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(StdrewardutlogVO vo, User user)
        throws Exception {
        try{
			StdrewardutlogDAO dao = (StdrewardutlogDAO) DAOFactory.build(StdrewardutlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public StdrewardutlogVO doUpdate(StdrewardutlogVO vo, User user)
        throws Exception {
        try{
			StdrewardutlogDAO dao = (StdrewardutlogDAO) DAOFactory.build(StdrewardutlogDAO.class, user);
            return (StdrewardutlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public StdrewardutlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			StdrewardutlogDAO dao = (StdrewardutlogDAO) DAOFactory.build(StdrewardutlogDAO.class, user);
        return (StdrewardutlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(StdrewardutlogListVO params, User user)
        throws Exception {
			StdrewardutlogDAO dao = (StdrewardutlogDAO) DAOFactory.build(StdrewardutlogDAO.class, user);
        return dao.query(params);
    }
}
