/**
* auto-generated code
* Sat Jun 25 17:13:50 CST 2011
*/
package com.sunrise.boss.business.cms.reward.assess.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.assess.persistent.AssessVO;
import com.sunrise.boss.business.cms.reward.assess.persistent.AssessDAO;
import com.sunrise.boss.business.cms.reward.assess.persistent.AssessListVO;

/**
 * <p>Title: AssessControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/assess/control/AssessControlBean"
 name="AssessControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class AssessControlBean extends AbstractControlBean
    implements AssessControl {

    public AssessVO doCreate(AssessVO vo, User user)
        throws Exception {
        try{
			AssessDAO dao = (AssessDAO) DAOFactory.build(AssessDAO.class, user);
            // TODO  set the pk */
            return (AssessVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(AssessVO vo, User user)
        throws Exception {
        try{
			AssessDAO dao = (AssessDAO) DAOFactory.build(AssessDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public AssessVO doUpdate(AssessVO vo, User user)
        throws Exception {
        try{
			AssessDAO dao = (AssessDAO) DAOFactory.build(AssessDAO.class, user);
            return (AssessVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public AssessVO doFindByPk(Serializable pk, User user)
        throws Exception {
			AssessDAO dao = (AssessDAO) DAOFactory.build(AssessDAO.class, user);
        return (AssessVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(AssessListVO params, User user)
        throws Exception {
			AssessDAO dao = (AssessDAO) DAOFactory.build(AssessDAO.class, user);
        return dao.query(params);
    }
}
