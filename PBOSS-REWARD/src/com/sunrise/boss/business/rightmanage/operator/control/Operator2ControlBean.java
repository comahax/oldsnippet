/**
* auto-generated code
* Sat Oct 21 10:49:43 CST 2006
*/
package com.sunrise.boss.business.rightmanage.operator.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.rightmanage.operator.persistent.Operator2VO;
import com.sunrise.boss.business.rightmanage.operator.persistent.Operator2DAO;
import com.sunrise.boss.business.rightmanage.operator.persistent.Operator2ListVO;

/**
 * <p>Title: OperatorControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/rightmanage/operator/control/Operator2ControlBean"
 name="Operator2Control"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class Operator2ControlBean extends AbstractControlBean
    implements Operator2Control {

    public Operator2VO doCreate(Operator2VO vo, User user)
        throws Exception {
        try{
			Operator2DAO dao = (Operator2DAO) DAOFactory.build(Operator2DAO.class, user.getCityid());
            // TODO  set the pk */
            return (Operator2VO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(Operator2VO vo, User user)
        throws Exception {
        try{
			Operator2DAO dao = (Operator2DAO) DAOFactory.build(Operator2DAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public Operator2VO doUpdate(Operator2VO vo, User user)
        throws Exception {
        try{
			Operator2DAO dao = (Operator2DAO) DAOFactory.build(Operator2DAO.class, user.getCityid());
            return (Operator2VO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public Operator2VO doFindByPk(Serializable pk, User user)
        throws Exception {
			Operator2DAO dao = (Operator2DAO) DAOFactory.build(Operator2DAO.class, user.getCityid());
        return (Operator2VO) dao.findByPk(pk);
    }
    public DataPackage doQuery(Operator2ListVO params, User user)
        throws Exception {
			Operator2DAO dao = (Operator2DAO) DAOFactory.build(Operator2DAO.class, user.getCityid());
        return dao.query(params);
    }
}
