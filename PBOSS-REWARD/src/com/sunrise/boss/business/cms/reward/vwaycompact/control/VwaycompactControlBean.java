/**
* auto-generated code
* Sat Oct 16 21:22:36 CST 2010
*/
package com.sunrise.boss.business.cms.reward.vwaycompact.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.vwaycompact.persistent.VwaycompactVO;
import com.sunrise.boss.business.cms.reward.vwaycompact.persistent.VwaycompactDAO;
import com.sunrise.boss.business.cms.reward.vwaycompact.persistent.VwaycompactListVO;

/**
 * <p>Title: VwaycompactControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/vwaycompact/control/VwaycompactControlBean"
 name="VwaycompactControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class VwaycompactControlBean extends AbstractControlBean
    implements VwaycompactControl {

    public VwaycompactVO doCreate(VwaycompactVO vo, User user)
        throws Exception {
        try{
			VwaycompactDAO dao = (VwaycompactDAO) DAOFactory.build(VwaycompactDAO.class, user);
            // TODO  set the pk */
            return (VwaycompactVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(VwaycompactVO vo, User user)
        throws Exception {
        try{
			VwaycompactDAO dao = (VwaycompactDAO) DAOFactory.build(VwaycompactDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public VwaycompactVO doUpdate(VwaycompactVO vo, User user)
        throws Exception {
        try{
			VwaycompactDAO dao = (VwaycompactDAO) DAOFactory.build(VwaycompactDAO.class, user);
            return (VwaycompactVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public VwaycompactVO doFindByPk(Serializable pk, User user)
        throws Exception {
			VwaycompactDAO dao = (VwaycompactDAO) DAOFactory.build(VwaycompactDAO.class, user);
        return (VwaycompactVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(VwaycompactListVO params, User user)
        throws Exception {
			VwaycompactDAO dao = (VwaycompactDAO) DAOFactory.build(VwaycompactDAO.class, user);
        return dao.query(params);
    }
}
