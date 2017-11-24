/**
* auto-generated code
* Fri Jul 17 11:20:44 CST 2009
*/
package com.sunrise.boss.business.cms.reward.ruleexp.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ruleexp.persistent.RuleexpVO;
import com.sunrise.boss.business.cms.reward.ruleexp.persistent.RuleexpDAO;
import com.sunrise.boss.business.cms.reward.ruleexp.persistent.RuleexpListVO;

/**
 * <p>Title: RuleexpControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/ruleexp/control/RuleexpControlBean"
 name="RuleexpControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RuleexpControlBean extends AbstractControlBean
    implements RuleexpControl {

    public RuleexpVO doCreate(RuleexpVO vo, User user)
        throws Exception {
        try{
			RuleexpDAO dao = (RuleexpDAO) DAOFactory.build(RuleexpDAO.class, user);
            // TODO  set the pk */
            return (RuleexpVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(RuleexpVO vo, User user)
        throws Exception {
        try{
			RuleexpDAO dao = (RuleexpDAO) DAOFactory.build(RuleexpDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RuleexpVO doUpdate(RuleexpVO vo, User user)
        throws Exception {
        try{
			RuleexpDAO dao = (RuleexpDAO) DAOFactory.build(RuleexpDAO.class, user);
            return (RuleexpVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RuleexpVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RuleexpDAO dao = (RuleexpDAO) DAOFactory.build(RuleexpDAO.class, user);
        return (RuleexpVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(RuleexpListVO params, User user)
        throws Exception {
			RuleexpDAO dao = (RuleexpDAO) DAOFactory.build(RuleexpDAO.class, user);
        return dao.query(params);
    }
}
