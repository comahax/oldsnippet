/**
* auto-generated code
* Thu Feb 16 10:30:46 CST 2012
*/
package com.sunrise.boss.business.cms.reward.salepointflag.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.salepointflag.persistent.SalepointflagVO;
import com.sunrise.boss.business.cms.reward.salepointflag.persistent.SalepointflagDAO;
import com.sunrise.boss.business.cms.reward.salepointflag.persistent.SalepointflagListVO;

/**
 * <p>Title: SalepointflagControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/salepointflag/control/SalepointflagControlBean"
 name="SalepointflagControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class SalepointflagControlBean extends AbstractControlBean
    implements SalepointflagControl {

    public SalepointflagVO doCreate(SalepointflagVO vo, User user)
        throws Exception {
        try{
			SalepointflagDAO dao = (SalepointflagDAO) DAOFactory.build(SalepointflagDAO.class, user);
            // TODO  set the pk */
            return (SalepointflagVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(SalepointflagVO vo, User user)
        throws Exception {
        try{
			SalepointflagDAO dao = (SalepointflagDAO) DAOFactory.build(SalepointflagDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public SalepointflagVO doUpdate(SalepointflagVO vo, User user)
        throws Exception {
        try{
			SalepointflagDAO dao = (SalepointflagDAO) DAOFactory.build(SalepointflagDAO.class, user);
            return (SalepointflagVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public SalepointflagVO doFindByPk(Serializable pk, User user)
        throws Exception {
			SalepointflagDAO dao = (SalepointflagDAO) DAOFactory.build(SalepointflagDAO.class, user);
        return (SalepointflagVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(SalepointflagListVO params, User user)
        throws Exception {
			SalepointflagDAO dao = (SalepointflagDAO) DAOFactory.build(SalepointflagDAO.class, user);
        return dao.query(params);
    }
}
