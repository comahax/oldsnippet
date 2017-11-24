/**
* auto-generated code
* Thu Mar 03 20:02:58 CST 2011
*/
package com.sunrise.boss.business.cms.emodconfirm.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.emodconfirm.persistent.EmodconfirmVO;
import com.sunrise.boss.business.cms.emodconfirm.persistent.EmodconfirmDAO;
import com.sunrise.boss.business.cms.emodconfirm.persistent.EmodconfirmListVO;

/**
 * <p>Title: EmodconfirmControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/emodconfirm/control/EmodconfirmControlBean"
 name="EmodconfirmControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class EmodconfirmControlBean extends AbstractControlBean
    implements EmodconfirmControl {

    public EmodconfirmVO doCreate(EmodconfirmVO vo, User user)
        throws Exception {
        try{
			EmodconfirmDAO dao = (EmodconfirmDAO) DAOFactory.build(EmodconfirmDAO.class, user);
            // TODO  set the pk */
            return (EmodconfirmVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(EmodconfirmVO vo, User user)
        throws Exception {
        try{
			EmodconfirmDAO dao = (EmodconfirmDAO) DAOFactory.build(EmodconfirmDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public EmodconfirmVO doUpdate(EmodconfirmVO vo, User user)
        throws Exception {
        try{
			EmodconfirmDAO dao = (EmodconfirmDAO) DAOFactory.build(EmodconfirmDAO.class, user);
            return (EmodconfirmVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public EmodconfirmVO doFindByPk(Serializable pk, User user)
        throws Exception {
			EmodconfirmDAO dao = (EmodconfirmDAO) DAOFactory.build(EmodconfirmDAO.class, user);
        return (EmodconfirmVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(EmodconfirmListVO params, User user)
        throws Exception {
			EmodconfirmDAO dao = (EmodconfirmDAO) DAOFactory.build(EmodconfirmDAO.class, user);
        return dao.query(params);
    }
}
