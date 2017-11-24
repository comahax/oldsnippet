/**
* auto-generated code
* Sun Nov 29 14:15:38 CST 2009
*/
package com.sunrise.boss.business.cms.examine.coefficient.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.coefficient.persistent.CoefficientVO;
import com.sunrise.boss.business.cms.examine.coefficient.persistent.CoefficientDAO;
import com.sunrise.boss.business.cms.examine.coefficient.persistent.CoefficientListVO;

/**
 * <p>Title: CoefficientControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/coefficient/control/CoefficientControlBean"
 name="CoefficientControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CoefficientControlBean extends AbstractControlBean
    implements CoefficientControl {

    public CoefficientVO doCreate(CoefficientVO vo, User user)
        throws Exception {
        try{
			CoefficientDAO dao = (CoefficientDAO) DAOFactory.build(CoefficientDAO.class, user);
            // TODO  set the pk */
            return (CoefficientVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(CoefficientVO vo, User user)
        throws Exception {
        try{
			CoefficientDAO dao = (CoefficientDAO) DAOFactory.build(CoefficientDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public CoefficientVO doUpdate(CoefficientVO vo, User user)
        throws Exception {
        try{
			CoefficientDAO dao = (CoefficientDAO) DAOFactory.build(CoefficientDAO.class, user);
            return (CoefficientVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public CoefficientVO doFindByPk(Serializable pk, User user)
        throws Exception {
			CoefficientDAO dao = (CoefficientDAO) DAOFactory.build(CoefficientDAO.class, user);
        return (CoefficientVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(CoefficientListVO params, User user)
        throws Exception {
			CoefficientDAO dao = (CoefficientDAO) DAOFactory.build(CoefficientDAO.class, user);
        return dao.query(params);
    }
}
