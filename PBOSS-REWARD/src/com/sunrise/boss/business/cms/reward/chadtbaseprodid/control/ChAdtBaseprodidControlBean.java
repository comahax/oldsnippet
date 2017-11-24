/**
* auto-generated code
* Tue Jun 03 20:21:31 CST 2014
*/
package com.sunrise.boss.business.cms.reward.chadtbaseprodid.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.chadtbaseprodid.persistent.ChAdtBaseprodidVO;
import com.sunrise.boss.business.cms.reward.chadtbaseprodid.persistent.ChAdtBaseprodidDAO;
import com.sunrise.boss.business.cms.reward.chadtbaseprodid.persistent.ChAdtBaseprodidListVO;

/**
 * <p>Title: ChAdtBaseprodidControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/chadtbaseprodid/control/ChAdtBaseprodidControlBean"
 name="ChAdtBaseprodidControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChAdtBaseprodidControlBean extends AbstractControlBean
    implements ChAdtBaseprodidControl {

    public ChAdtBaseprodidVO doCreate(ChAdtBaseprodidVO vo, User user)
        throws Exception {
        try{
			ChAdtBaseprodidDAO dao = (ChAdtBaseprodidDAO) DAOFactory.build(ChAdtBaseprodidDAO.class, user);
            // TODO  set the pk */
            return (ChAdtBaseprodidVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChAdtBaseprodidVO vo, User user)
        throws Exception {
        try{
			ChAdtBaseprodidDAO dao = (ChAdtBaseprodidDAO) DAOFactory.build(ChAdtBaseprodidDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtBaseprodidVO doUpdate(ChAdtBaseprodidVO vo, User user)
        throws Exception {
        try{
			ChAdtBaseprodidDAO dao = (ChAdtBaseprodidDAO) DAOFactory.build(ChAdtBaseprodidDAO.class, user);
            return (ChAdtBaseprodidVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtBaseprodidVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChAdtBaseprodidDAO dao = (ChAdtBaseprodidDAO) DAOFactory.build(ChAdtBaseprodidDAO.class, user);
        return (ChAdtBaseprodidVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChAdtBaseprodidListVO params, User user)
        throws Exception {
			ChAdtBaseprodidDAO dao = (ChAdtBaseprodidDAO) DAOFactory.build(ChAdtBaseprodidDAO.class, user);
        return dao.query(params);
    }
}
