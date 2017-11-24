/**
* auto-generated code
* Thu Dec 12 20:04:12 CST 2013
*/
package com.sunrise.boss.business.cms.crmpcppproduct.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.crmpcppproduct.persistent.CrmPcPpProductVO;
import com.sunrise.boss.business.cms.crmpcppproduct.persistent.CrmPcPpProductDAO;
import com.sunrise.boss.business.cms.crmpcppproduct.persistent.CrmPcPpProductListVO;

/**
 * <p>Title: CrmPcPpProductControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/crmpcppproduct/control/CrmPcPpProductControlBean"
 name="CrmPcPpProductControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CrmPcPpProductControlBean extends AbstractControlBean
    implements CrmPcPpProductControl {

    public CrmPcPpProductVO doCreate(CrmPcPpProductVO vo, User user)
        throws Exception {
        try{
			CrmPcPpProductDAO dao = (CrmPcPpProductDAO) DAOFactory.build(CrmPcPpProductDAO.class, user);
            // TODO  set the pk */
            return (CrmPcPpProductVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(CrmPcPpProductVO vo, User user)
        throws Exception {
        try{
			CrmPcPpProductDAO dao = (CrmPcPpProductDAO) DAOFactory.build(CrmPcPpProductDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public CrmPcPpProductVO doUpdate(CrmPcPpProductVO vo, User user)
        throws Exception {
        try{
			CrmPcPpProductDAO dao = (CrmPcPpProductDAO) DAOFactory.build(CrmPcPpProductDAO.class, user);
            return (CrmPcPpProductVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public CrmPcPpProductVO doFindByPk(Serializable pk, User user)
        throws Exception {
			CrmPcPpProductDAO dao = (CrmPcPpProductDAO) DAOFactory.build(CrmPcPpProductDAO.class, user);
        return (CrmPcPpProductVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(CrmPcPpProductListVO params, User user)
        throws Exception {
			CrmPcPpProductDAO dao = (CrmPcPpProductDAO) DAOFactory.build(CrmPcPpProductDAO.class, user);
        return dao.query(params);
    }
}
