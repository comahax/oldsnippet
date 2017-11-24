/**
* auto-generated code
* Wed Feb 23 10:33:30 CST 2011
*/
package com.sunrise.boss.business.cms.dictparam.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.dictparam.persistent.DictparamVO;
import com.sunrise.boss.business.cms.dictparam.persistent.DictparamDAO;
import com.sunrise.boss.business.cms.dictparam.persistent.DictparamListVO;

/**
 * <p>Title: DictparamControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/dictparam/control/DictparamControlBean"
 name="DictparamControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class DictparamControlBean extends AbstractControlBean
    implements DictparamControl {

    public DictparamVO doCreate(DictparamVO vo, User user)
        throws Exception {
        try{
			DictparamDAO dao = (DictparamDAO) DAOFactory.build(DictparamDAO.class, user);
            // TODO  set the pk */
            return (DictparamVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(DictparamVO vo, User user)
        throws Exception {
        try{
			DictparamDAO dao = (DictparamDAO) DAOFactory.build(DictparamDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public DictparamVO doUpdate(DictparamVO vo, User user)
        throws Exception {
        try{
			DictparamDAO dao = (DictparamDAO) DAOFactory.build(DictparamDAO.class, user);
            return (DictparamVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public DictparamVO doFindByPk(Serializable pk, User user)
        throws Exception {
			DictparamDAO dao = (DictparamDAO) DAOFactory.build(DictparamDAO.class, user);
        return (DictparamVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(DictparamListVO params, User user)
        throws Exception {
			DictparamDAO dao = (DictparamDAO) DAOFactory.build(DictparamDAO.class, user);
        return dao.query(params);
    }
}
