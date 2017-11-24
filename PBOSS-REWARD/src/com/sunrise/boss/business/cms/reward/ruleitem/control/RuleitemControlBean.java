/**
* auto-generated code
* Wed Sep 10 11:29:44 CST 2008
*/
package com.sunrise.boss.business.cms.reward.ruleitem.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemVO;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemDAO;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemListVO;

/**
 * <p>Title: RuleitemControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/ruleitem/control/RuleitemControlBean"
 name="RuleitemControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RuleitemControlBean extends AbstractControlBean
    implements RuleitemControl {

    public RuleitemVO doCreate(RuleitemVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         RuleitemDAO dao = (RuleitemDAO) DAOFactory.build(RuleitemDAO.class, user);
            return (RuleitemVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RuleitemVO vo, User user)
        throws Exception {
        try{
         RuleitemDAO dao = (RuleitemDAO) DAOFactory.build(RuleitemDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RuleitemVO doUpdate(RuleitemVO vo, User user)
        throws Exception {
        try{
         RuleitemDAO dao = (RuleitemDAO) DAOFactory.build(RuleitemDAO.class, user);
            return (RuleitemVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RuleitemVO doFindByPk(Serializable pk, User user)
        throws Exception {
         RuleitemDAO dao = (RuleitemDAO) DAOFactory.build(RuleitemDAO.class, user);
        return (RuleitemVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RuleitemListVO params, User user)
        throws Exception {
         RuleitemDAO dao = (RuleitemDAO) DAOFactory.build(RuleitemDAO.class, user);
        return dao.query(params);
    }
}
