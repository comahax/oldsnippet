/**
* auto-generated code
* Tue Jan 05 10:01:34 CST 2010
*/
package com.sunrise.boss.business.cms.reward.stdrewardbjway.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardbjway.persistent.StdrewardbjwayVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjway.persistent.StdrewardbjwayDAO;
import com.sunrise.boss.business.cms.reward.stdrewardbjway.persistent.StdrewardbjwayListVO;

/**
 * <p>Title: StdrewardbjwayControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/stdrewardbjway/control/StdrewardbjwayControlBean"
 name="StdrewardbjwayControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class StdrewardbjwayControlBean extends AbstractControlBean
    implements StdrewardbjwayControl {

    public StdrewardbjwayVO doCreate(StdrewardbjwayVO vo, User user)
        throws Exception {
        try{
			StdrewardbjwayDAO dao = (StdrewardbjwayDAO) DAOFactory.build(StdrewardbjwayDAO.class, user);
            // TODO  set the pk */
            return (StdrewardbjwayVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(StdrewardbjwayVO vo, User user)
        throws Exception {
        try{
			StdrewardbjwayDAO dao = (StdrewardbjwayDAO) DAOFactory.build(StdrewardbjwayDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public StdrewardbjwayVO doUpdate(StdrewardbjwayVO vo, User user)
        throws Exception {
        try{
			StdrewardbjwayDAO dao = (StdrewardbjwayDAO) DAOFactory.build(StdrewardbjwayDAO.class, user);
            return (StdrewardbjwayVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public StdrewardbjwayVO doFindByPk(Serializable pk, User user)
        throws Exception {
			StdrewardbjwayDAO dao = (StdrewardbjwayDAO) DAOFactory.build(StdrewardbjwayDAO.class, user);
        return (StdrewardbjwayVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(StdrewardbjwayListVO params, User user)
        throws Exception {
			StdrewardbjwayDAO dao = (StdrewardbjwayDAO) DAOFactory.build(StdrewardbjwayDAO.class, user);
        return dao.query(params);
    }
}
