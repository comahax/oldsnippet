/**
* auto-generated code
* Wed Sep 04 20:56:32 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.vchpdaccountcharge.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.vchpdaccountcharge.persistent.VChPdAccountchargeVO;
import com.sunrise.boss.business.cms.provagent.vchpdaccountcharge.persistent.VChPdAccountchargeDAO;
import com.sunrise.boss.business.cms.provagent.vchpdaccountcharge.persistent.VChPdAccountchargeListVO;

/**
 * <p>Title: VChPdAccountchargeControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/provagent/vchpdaccountcharge/control/VChPdAccountchargeControlBean"
 name="VChPdAccountchargeControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class VChPdAccountchargeControlBean extends AbstractControlBean
    implements VChPdAccountchargeControl {

    public VChPdAccountchargeVO doCreate(VChPdAccountchargeVO vo, User user)
        throws Exception {
        try{
			VChPdAccountchargeDAO dao = (VChPdAccountchargeDAO) DAOFactory.build(VChPdAccountchargeDAO.class, user);
            // TODO  set the pk */
            return (VChPdAccountchargeVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(VChPdAccountchargeVO vo, User user)
        throws Exception {
        try{
			VChPdAccountchargeDAO dao = (VChPdAccountchargeDAO) DAOFactory.build(VChPdAccountchargeDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public VChPdAccountchargeVO doUpdate(VChPdAccountchargeVO vo, User user)
        throws Exception {
        try{
			VChPdAccountchargeDAO dao = (VChPdAccountchargeDAO) DAOFactory.build(VChPdAccountchargeDAO.class, user);
            return (VChPdAccountchargeVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public VChPdAccountchargeVO doFindByPk(Serializable pk, User user)
        throws Exception {
			VChPdAccountchargeDAO dao = (VChPdAccountchargeDAO) DAOFactory.build(VChPdAccountchargeDAO.class, user);
        return (VChPdAccountchargeVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(VChPdAccountchargeListVO params, User user)
        throws Exception {
			VChPdAccountchargeDAO dao = (VChPdAccountchargeDAO) DAOFactory.build(VChPdAccountchargeDAO.class, user);
        return dao.query(params);
    }
}
