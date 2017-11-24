/**
* auto-generated code
* Wed Dec 27 14:04:18 CST 2006
*/
package com.sunrise.boss.business.cms.distribute.cpbusfeeway.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.distribute.cpbusfeeway.persistent.CpbusfeewayVO;
import com.sunrise.boss.business.cms.distribute.cpbusfeeway.persistent.CpbusfeewayDAO;
import com.sunrise.boss.business.cms.distribute.cpbusfeeway.persistent.CpbusfeewayListVO;

/**
 * <p>Title: CpbusfeewayControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/distribute/cpbusfeeway/control/CpbusfeewayControlBean"
 name="CpbusfeewayControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CpbusfeewayControlBean extends AbstractControlBean
    implements CpbusfeewayControl {

    public CpbusfeewayVO doCreate(CpbusfeewayVO vo, User user)
        throws Exception {
        try{
			CpbusfeewayDAO dao = (CpbusfeewayDAO) DAOFactory.build(CpbusfeewayDAO.class, user);
            // TODO  set the pk */
            return (CpbusfeewayVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(CpbusfeewayVO vo, User user)
        throws Exception {
        try{
			CpbusfeewayDAO dao = (CpbusfeewayDAO) DAOFactory.build(CpbusfeewayDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CpbusfeewayVO doUpdate(CpbusfeewayVO vo, User user)
        throws Exception {
        try{
			CpbusfeewayDAO dao = (CpbusfeewayDAO) DAOFactory.build(CpbusfeewayDAO.class, user);
            return (CpbusfeewayVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CpbusfeewayVO doFindByPk(Serializable pk, User user)
        throws Exception {
			CpbusfeewayDAO dao = (CpbusfeewayDAO) DAOFactory.build(CpbusfeewayDAO.class, user);
        return (CpbusfeewayVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(CpbusfeewayListVO params, User user)
        throws Exception {
			CpbusfeewayDAO dao = (CpbusfeewayDAO) DAOFactory.build(CpbusfeewayDAO.class, user);
        return dao.query(params);
    }
}
