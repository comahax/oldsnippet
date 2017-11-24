/**
* auto-generated code
* Wed Dec 27 11:34:25 CST 2006
*/
package com.sunrise.boss.business.cms.distribute.cpright.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.distribute.cpright.persistent.CprightVO;
import com.sunrise.boss.business.cms.distribute.cpright.persistent.CprightDAO;
import com.sunrise.boss.business.cms.distribute.cpright.persistent.CprightListVO;

/**
 * <p>Title: CprightControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/distribute/cpright/control/CprightControlBean"
 name="CprightControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CprightControlBean extends AbstractControlBean
    implements CprightControl {

    public CprightVO doCreate(CprightVO vo, User user)
        throws Exception {
        try{
			CprightDAO dao = (CprightDAO) DAOFactory.build(CprightDAO.class, user);
            // TODO  set the pk */
            return (CprightVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(CprightVO vo, User user)
        throws Exception {
        try{
			CprightDAO dao = (CprightDAO) DAOFactory.build(CprightDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CprightVO doUpdate(CprightVO vo, User user)
        throws Exception {
        try{
			CprightDAO dao = (CprightDAO) DAOFactory.build(CprightDAO.class, user);
            return (CprightVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CprightVO doFindByPk(Serializable pk, User user)
        throws Exception {
			CprightDAO dao = (CprightDAO) DAOFactory.build(CprightDAO.class, user);
        return (CprightVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(CprightListVO params, User user)
        throws Exception {
			CprightDAO dao = (CprightDAO) DAOFactory.build(CprightDAO.class, user);
        return dao.query(params);
    }
}
