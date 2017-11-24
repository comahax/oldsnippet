/**
* auto-generated code
* Fri Dec 08 17:16:19 CST 2006
*/
package com.sunrise.boss.business.cms.fee.bail.control;

import java.io.Serializable;

import com.sunrise.boss.business.admin.operator.control.OperatorControlBean;
import com.sunrise.boss.business.admin.operator.persistent.OperatorVO;
import com.sunrise.boss.business.cms.fee.bail.persistent.BailDAO;
import com.sunrise.boss.business.cms.fee.bail.persistent.BailListVO;
import com.sunrise.boss.business.cms.fee.bail.persistent.BailVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BailControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/fee/bail/control/BailControlBean"
 name="BailControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BailControlBean extends AbstractControlBean
    implements BailControl {

    public BailVO doCreate(BailVO vo, User user)
        throws Exception {
        try{
			BailDAO dao = (BailDAO) DAOFactory.build(BailDAO.class, user);
            // TODO  set the pk */		
            return (BailVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(BailVO vo, User user)
        throws Exception {
        try{
			BailDAO dao = (BailDAO) DAOFactory.build(BailDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BailVO doUpdate(BailVO vo, User user)
        throws Exception {
        try{
			BailDAO dao = (BailDAO) DAOFactory.build(BailDAO.class, user);
            return (BailVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BailVO doFindByPk(Serializable pk, User user)
        throws Exception {
			BailDAO dao = (BailDAO) DAOFactory.build(BailDAO.class, user);
        return (BailVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(BailListVO params, User user)
        throws Exception {
			BailDAO dao = (BailDAO) DAOFactory.build(BailDAO.class, user);
        return dao.query(params);
    }
    
    public OperatorVO doOperatorFindByPk(Serializable pk, User user) 
    throws Exception {
    	OperatorVO operatorVO = new OperatorVO();
    	OperatorControlBean operatorControlBean = new OperatorControlBean();
    	operatorVO = operatorControlBean.doFindByPk(pk, user);
    	return operatorVO;
    }
    
}
