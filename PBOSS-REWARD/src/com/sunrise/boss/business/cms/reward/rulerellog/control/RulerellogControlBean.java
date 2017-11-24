/**
* auto-generated code
* Wed Sep 10 14:39:49 CST 2008
*/
package com.sunrise.boss.business.cms.reward.rulerellog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rulerellog.persistent.RulerellogVO;
import com.sunrise.boss.business.cms.reward.rulerellog.persistent.RulerellogDAO;
import com.sunrise.boss.business.cms.reward.rulerellog.persistent.RulerellogListVO;

/**
 * <p>Title: RulerellogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/rulerellog/control/RulerellogControlBean"
 name="RulerellogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RulerellogControlBean extends AbstractControlBean
    implements RulerellogControl {

    public RulerellogVO doCreate(RulerellogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         RulerellogDAO dao = (RulerellogDAO) DAOFactory.build(RulerellogDAO.class, user);
            return (RulerellogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RulerellogVO vo, User user)
        throws Exception {
        try{
         RulerellogDAO dao = (RulerellogDAO) DAOFactory.build(RulerellogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RulerellogVO doUpdate(RulerellogVO vo, User user)
        throws Exception {
        try{
         RulerellogDAO dao = (RulerellogDAO) DAOFactory.build(RulerellogDAO.class, user);
            return (RulerellogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RulerellogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         RulerellogDAO dao = (RulerellogDAO) DAOFactory.build(RulerellogDAO.class, user);
        return (RulerellogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RulerellogListVO params, User user)
        throws Exception {
         RulerellogDAO dao = (RulerellogDAO) DAOFactory.build(RulerellogDAO.class, user);
        return dao.query(params);
    }
}
