/**
* auto-generated code
* Wed Sep 10 14:41:39 CST 2008
*/
package com.sunrise.boss.business.cms.reward.ruleitemlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ruleitemlog.persistent.RuleitemlogVO;
import com.sunrise.boss.business.cms.reward.ruleitemlog.persistent.RuleitemlogDAO;
import com.sunrise.boss.business.cms.reward.ruleitemlog.persistent.RuleitemlogListVO;

/**
 * <p>Title: RuleitemlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/ruleitemlog/control/RuleitemlogControlBean"
 name="RuleitemlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RuleitemlogControlBean extends AbstractControlBean
    implements RuleitemlogControl {

    public RuleitemlogVO doCreate(RuleitemlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         RuleitemlogDAO dao = (RuleitemlogDAO) DAOFactory.build(RuleitemlogDAO.class, user);
            return (RuleitemlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RuleitemlogVO vo, User user)
        throws Exception {
        try{
         RuleitemlogDAO dao = (RuleitemlogDAO) DAOFactory.build(RuleitemlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RuleitemlogVO doUpdate(RuleitemlogVO vo, User user)
        throws Exception {
        try{
         RuleitemlogDAO dao = (RuleitemlogDAO) DAOFactory.build(RuleitemlogDAO.class, user);
            return (RuleitemlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RuleitemlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         RuleitemlogDAO dao = (RuleitemlogDAO) DAOFactory.build(RuleitemlogDAO.class, user);
        return (RuleitemlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RuleitemlogListVO params, User user)
        throws Exception {
         RuleitemlogDAO dao = (RuleitemlogDAO) DAOFactory.build(RuleitemlogDAO.class, user);
        return dao.query(params);
    }
}
