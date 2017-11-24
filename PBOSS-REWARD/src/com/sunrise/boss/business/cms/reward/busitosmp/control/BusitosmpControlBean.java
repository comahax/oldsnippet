/**
* auto-generated code
* Mon Jan 04 11:40:46 CST 2010
*/
package com.sunrise.boss.business.cms.reward.busitosmp.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busitosmp.persistent.BusitosmpVO;
import com.sunrise.boss.business.cms.reward.busitosmp.persistent.BusitosmpDAO;
import com.sunrise.boss.business.cms.reward.busitosmp.persistent.BusitosmpListVO;

/**
 * <p>Title: BusitosmpControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/busitosmp/control/BusitosmpControlBean"
 name="BusitosmpControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BusitosmpControlBean extends AbstractControlBean
    implements BusitosmpControl {

    public BusitosmpVO doCreate(BusitosmpVO vo, User user)
        throws Exception {
        try{
			BusitosmpDAO dao = (BusitosmpDAO) DAOFactory.build(BusitosmpDAO.class, user);
            // TODO  set the pk */
            return (BusitosmpVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(BusitosmpVO vo, User user)
        throws Exception {
        try{
			BusitosmpDAO dao = (BusitosmpDAO) DAOFactory.build(BusitosmpDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BusitosmpVO doUpdate(BusitosmpVO vo, User user)
        throws Exception {
        try{
			BusitosmpDAO dao = (BusitosmpDAO) DAOFactory.build(BusitosmpDAO.class, user);
            return (BusitosmpVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BusitosmpVO doFindByPk(Serializable pk, User user)
        throws Exception {
			BusitosmpDAO dao = (BusitosmpDAO) DAOFactory.build(BusitosmpDAO.class, user);
        return (BusitosmpVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(BusitosmpListVO params, User user)
        throws Exception {
			BusitosmpDAO dao = (BusitosmpDAO) DAOFactory.build(BusitosmpDAO.class, user);
        return dao.query(params);
    }
}
