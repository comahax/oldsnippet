/**
* auto-generated code
* Tue Sep 18 16:26:16 CST 2012
*/
package com.sunrise.boss.business.cms.reward.stdrewardbjnoncyclog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardbjnoncyclog.persistent.StdrewardbjnoncyclogVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjnoncyclog.persistent.StdrewardbjnoncyclogDAO;
import com.sunrise.boss.business.cms.reward.stdrewardbjnoncyclog.persistent.StdrewardbjnoncyclogListVO;

/**
 * <p>Title: StdrewardbjnoncyclogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/stdrewardbjnoncyclog/control/StdrewardbjnoncyclogControlBean"
 name="StdrewardbjnoncyclogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class StdrewardbjnoncyclogControlBean extends AbstractControlBean
    implements StdrewardbjnoncyclogControl {

    public StdrewardbjnoncyclogVO doCreate(StdrewardbjnoncyclogVO vo, User user)
        throws Exception {
        try{
			StdrewardbjnoncyclogDAO dao = (StdrewardbjnoncyclogDAO) DAOFactory.build(StdrewardbjnoncyclogDAO.class, user);
            // TODO  set the pk */
            return (StdrewardbjnoncyclogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(StdrewardbjnoncyclogVO vo, User user)
        throws Exception {
        try{
			StdrewardbjnoncyclogDAO dao = (StdrewardbjnoncyclogDAO) DAOFactory.build(StdrewardbjnoncyclogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public StdrewardbjnoncyclogVO doUpdate(StdrewardbjnoncyclogVO vo, User user)
        throws Exception {
        try{
			StdrewardbjnoncyclogDAO dao = (StdrewardbjnoncyclogDAO) DAOFactory.build(StdrewardbjnoncyclogDAO.class, user);
            return (StdrewardbjnoncyclogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public StdrewardbjnoncyclogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			StdrewardbjnoncyclogDAO dao = (StdrewardbjnoncyclogDAO) DAOFactory.build(StdrewardbjnoncyclogDAO.class, user);
        return (StdrewardbjnoncyclogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(StdrewardbjnoncyclogListVO params, User user)
        throws Exception {
			StdrewardbjnoncyclogDAO dao = (StdrewardbjnoncyclogDAO) DAOFactory.build(StdrewardbjnoncyclogDAO.class, user);
        return dao.query(params);
    }
}
