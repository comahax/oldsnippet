/**
* auto-generated code
* Tue Jul 14 09:27:14 CST 2009
*/
package com.sunrise.boss.business.cms.reward.rulemodelog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rulemodelog.persistent.RulemodelogVO;
import com.sunrise.boss.business.cms.reward.rulemodelog.persistent.RulemodelogDAO;

/**
 * <p>Title: RulemodelogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/rulemodelog/control/RulemodelogControlBean"
 name="RulemodelogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RulemodelogControlBean extends AbstractControlBean
    implements RulemodelogControl {

    public RulemodelogVO doCreate(RulemodelogVO vo, User user)
        throws Exception {
        try{
			RulemodelogDAO dao = (RulemodelogDAO) DAOFactory.build(RulemodelogDAO.class, user);
            // TODO  set the pk */
            return (RulemodelogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(RulemodelogVO vo, User user)
        throws Exception {
        try{
			RulemodelogDAO dao = (RulemodelogDAO) DAOFactory.build(RulemodelogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RulemodelogVO doUpdate(RulemodelogVO vo, User user)
        throws Exception {
        try{
			RulemodelogDAO dao = (RulemodelogDAO) DAOFactory.build(RulemodelogDAO.class, user);
            return (RulemodelogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RulemodelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RulemodelogDAO dao = (RulemodelogDAO) DAOFactory.build(RulemodelogDAO.class, user);
        return (RulemodelogVO) dao.findByPk(pk);
    }

}
