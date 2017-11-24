/**
* auto-generated code
* Sun Feb 03 10:15:39 CST 2008
*/
package com.sunrise.boss.business.cms.reward.rule.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rule.persistent.RuleVO;
import com.sunrise.boss.business.cms.reward.rule.persistent.RuleDAO;
import com.sunrise.boss.business.cms.reward.rule.persistent.RuleListVO;

/**
 * <p>Title: RuleControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/rule/control/RuleControlBean"
 name="RuleControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RuleControlBean extends AbstractControlBean
    implements RuleControl {

    public RuleVO doCreate(RuleVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         RuleDAO dao = (RuleDAO) DAOFactory.build(RuleDAO.class, user);
            return (RuleVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RuleVO vo, User user)
        throws Exception {
        try{
         RuleDAO dao = (RuleDAO) DAOFactory.build(RuleDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RuleVO doUpdate(RuleVO vo, User user)
        throws Exception {
        try{
         RuleDAO dao = (RuleDAO) DAOFactory.build(RuleDAO.class, user);
            return (RuleVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RuleVO doFindByPk(Serializable pk, User user)
        throws Exception {
         RuleDAO dao = (RuleDAO) DAOFactory.build(RuleDAO.class, user);
        return (RuleVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RuleListVO params, User user)
        throws Exception {
         RuleDAO dao = (RuleDAO) DAOFactory.build(RuleDAO.class, user);
        return dao.query(params);
    }
}
