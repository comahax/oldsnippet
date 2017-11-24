/**
* auto-generated code
* Sun Feb 03 10:16:15 CST 2008
*/
package com.sunrise.boss.business.cms.reward.rulelog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rulelog.persistent.RulelogVO;
import com.sunrise.boss.business.cms.reward.rulelog.persistent.RulelogDAO;
import com.sunrise.boss.business.cms.reward.rulelog.persistent.RulelogListVO;

/**
 * <p>Title: RulelogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/rulelog/control/RulelogControlBean"
 name="RulelogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RulelogControlBean extends AbstractControlBean
    implements RulelogControl {

    public RulelogVO doCreate(RulelogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         RulelogDAO dao = (RulelogDAO) DAOFactory.build(RulelogDAO.class, user);
            return (RulelogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RulelogVO vo, User user)
        throws Exception {
        try{
         RulelogDAO dao = (RulelogDAO) DAOFactory.build(RulelogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RulelogVO doUpdate(RulelogVO vo, User user)
        throws Exception {
        try{
         RulelogDAO dao = (RulelogDAO) DAOFactory.build(RulelogDAO.class, user);
            return (RulelogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RulelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         RulelogDAO dao = (RulelogDAO) DAOFactory.build(RulelogDAO.class, user);
        return (RulelogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RulelogListVO params, User user)
        throws Exception {
         RulelogDAO dao = (RulelogDAO) DAOFactory.build(RulelogDAO.class, user);
        return dao.query(params);
    }
}
