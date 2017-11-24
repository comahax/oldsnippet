/**
* auto-generated code
* Wed May 18 10:32:19 CST 2011
*/
package com.sunrise.boss.business.cms.reward.salecreditstd.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.salecreditstd.persistent.SalecreditstdVO;
import com.sunrise.boss.business.cms.reward.salecreditstd.persistent.SalecreditstdDAO;
import com.sunrise.boss.business.cms.reward.salecreditstd.persistent.SalecreditstdListVO;

/**
 * <p>Title: SalecreditstdControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/salecreditstd/control/SalecreditstdControlBean"
 name="SalecreditstdControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class SalecreditstdControlBean extends AbstractControlBean
    implements SalecreditstdControl {

    public SalecreditstdVO doCreate(SalecreditstdVO vo, User user)
        throws Exception {
        try{
			SalecreditstdDAO dao = (SalecreditstdDAO) DAOFactory.build(SalecreditstdDAO.class, user);
            // TODO  set the pk */
            return (SalecreditstdVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(SalecreditstdVO vo, User user)
        throws Exception {
        try{
			SalecreditstdDAO dao = (SalecreditstdDAO) DAOFactory.build(SalecreditstdDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public SalecreditstdVO doUpdate(SalecreditstdVO vo, User user)
        throws Exception {
        try{
			SalecreditstdDAO dao = (SalecreditstdDAO) DAOFactory.build(SalecreditstdDAO.class, user);
            return (SalecreditstdVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public SalecreditstdVO doFindByPk(Serializable pk, User user)
        throws Exception {
			SalecreditstdDAO dao = (SalecreditstdDAO) DAOFactory.build(SalecreditstdDAO.class, user);
        return (SalecreditstdVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(SalecreditstdListVO params, User user)
        throws Exception {
			SalecreditstdDAO dao = (SalecreditstdDAO) DAOFactory.build(SalecreditstdDAO.class, user);
        return dao.query(params);
    }
}
