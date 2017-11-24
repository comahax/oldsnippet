/**
* auto-generated code
* Fri Apr 18 10:45:38 CST 2008
*/
package com.sunrise.boss.business.fee.dgrealprod.balancetype.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.fee.dgrealprod.balancetype.persistent.BalanceTypeVO;
import com.sunrise.boss.business.fee.dgrealprod.balancetype.persistent.BalanceTypeDAO;
import com.sunrise.boss.business.fee.dgrealprod.balancetype.persistent.BalanceTypeListVO;

/**
 * <p>Title: BalanceTypeControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lmq
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/fee/dgrealprod/balancetype/control/BalanceTypeControlBean"
 name="BalanceTypeControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BalanceTypeControlBean extends AbstractControlBean
    implements BalanceTypeControl {

    public BalanceTypeVO doCreate(BalanceTypeVO vo, User user)
        throws Exception {
        try{
			BalanceTypeDAO dao = (BalanceTypeDAO) DAOFactory.build(BalanceTypeDAO.class, user.getCityid());
            // TODO  set the pk */
            return (BalanceTypeVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(BalanceTypeVO vo, User user)
        throws Exception {
        try{
			BalanceTypeDAO dao = (BalanceTypeDAO) DAOFactory.build(BalanceTypeDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BalanceTypeVO doUpdate(BalanceTypeVO vo, User user)
        throws Exception {
        try{
			BalanceTypeDAO dao = (BalanceTypeDAO) DAOFactory.build(BalanceTypeDAO.class, user.getCityid());
            return (BalanceTypeVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BalanceTypeVO doFindByPk(Serializable pk, User user)
        throws Exception {
			BalanceTypeDAO dao = (BalanceTypeDAO) DAOFactory.build(BalanceTypeDAO.class, user.getCityid());
        return (BalanceTypeVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(BalanceTypeListVO params, User user)
        throws Exception {
			BalanceTypeDAO dao = (BalanceTypeDAO) DAOFactory.build(BalanceTypeDAO.class, user.getCityid());
        return dao.query(params);
    }
}
