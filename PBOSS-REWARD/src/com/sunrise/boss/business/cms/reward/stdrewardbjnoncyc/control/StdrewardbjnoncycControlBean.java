/**
* auto-generated code
* Tue Sep 18 16:24:42 CST 2012
*/
package com.sunrise.boss.business.cms.reward.stdrewardbjnoncyc.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardbjnoncyc.persistent.StdrewardbjnoncycVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjnoncyc.persistent.StdrewardbjnoncycDAO;
import com.sunrise.boss.business.cms.reward.stdrewardbjnoncyc.persistent.StdrewardbjnoncycListVO;

/**
 * <p>Title: StdrewardbjnoncycControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/stdrewardbjnoncyc/control/StdrewardbjnoncycControlBean"
 name="StdrewardbjnoncycControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class StdrewardbjnoncycControlBean extends AbstractControlBean
    implements StdrewardbjnoncycControl {

    public StdrewardbjnoncycVO doCreate(StdrewardbjnoncycVO vo, User user)
        throws Exception {
        try{
			StdrewardbjnoncycDAO dao = (StdrewardbjnoncycDAO) DAOFactory.build(StdrewardbjnoncycDAO.class, user);
            // TODO  set the pk */
            return (StdrewardbjnoncycVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(StdrewardbjnoncycVO vo, User user)
        throws Exception {
        try{
			StdrewardbjnoncycDAO dao = (StdrewardbjnoncycDAO) DAOFactory.build(StdrewardbjnoncycDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public StdrewardbjnoncycVO doUpdate(StdrewardbjnoncycVO vo, User user)
        throws Exception {
        try{
			StdrewardbjnoncycDAO dao = (StdrewardbjnoncycDAO) DAOFactory.build(StdrewardbjnoncycDAO.class, user);
            return (StdrewardbjnoncycVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public StdrewardbjnoncycVO doFindByPk(Serializable pk, User user)
        throws Exception {
			StdrewardbjnoncycDAO dao = (StdrewardbjnoncycDAO) DAOFactory.build(StdrewardbjnoncycDAO.class, user);
        return (StdrewardbjnoncycVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(StdrewardbjnoncycListVO params, User user)
        throws Exception {
			StdrewardbjnoncycDAO dao = (StdrewardbjnoncycDAO) DAOFactory.build(StdrewardbjnoncycDAO.class, user);
        return dao.query(params);
    }
}
