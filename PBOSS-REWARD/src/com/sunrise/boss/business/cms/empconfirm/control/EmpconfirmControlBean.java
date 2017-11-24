/**
* auto-generated code
* Thu Mar 03 11:37:46 CST 2011
*/
package com.sunrise.boss.business.cms.empconfirm.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.empconfirm.persistent.EmpconfirmDAO;
import com.sunrise.boss.business.cms.empconfirm.persistent.EmpconfirmListVO;
import com.sunrise.boss.business.cms.empconfirm.persistent.EmpconfirmVO;
import com.sunrise.boss.business.cms.empconfirm.persistent.VempconfirmDAO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: EmpconfirmControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/empconfirm/control/EmpconfirmControlBean"
 name="EmpconfirmControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class EmpconfirmControlBean extends AbstractControlBean
    implements EmpconfirmControl {

    public EmpconfirmVO doCreate(EmpconfirmVO vo, User user)
        throws Exception {
        try{
			EmpconfirmDAO dao = (EmpconfirmDAO) DAOFactory.build(EmpconfirmDAO.class, user);
            // TODO  set the pk */
            return (EmpconfirmVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(EmpconfirmVO vo, User user)
        throws Exception {
        try{
			EmpconfirmDAO dao = (EmpconfirmDAO) DAOFactory.build(EmpconfirmDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public EmpconfirmVO doUpdate(EmpconfirmVO vo, User user)
        throws Exception {
        try{
			EmpconfirmDAO dao = (EmpconfirmDAO) DAOFactory.build(EmpconfirmDAO.class, user);
            return (EmpconfirmVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public EmpconfirmVO doFindByPk(Serializable pk, User user)
        throws Exception {
			EmpconfirmDAO dao = (EmpconfirmDAO) DAOFactory.build(EmpconfirmDAO.class, user);
        return (EmpconfirmVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(EmpconfirmListVO params, User user)
        throws Exception {
    		VempconfirmDAO dao = (VempconfirmDAO) DAOFactory.build(VempconfirmDAO.class, user);
			DataPackage dp=dao.queryByNamedSqlQuery("queryMode", params);
        return  dp;
    }
}
