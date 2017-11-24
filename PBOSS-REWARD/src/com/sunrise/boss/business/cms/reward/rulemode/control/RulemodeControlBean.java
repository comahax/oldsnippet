/**
* auto-generated code
* Tue Jul 14 09:24:12 CST 2009
*/
package com.sunrise.boss.business.cms.reward.rulemode.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rulemode.persistent.RulemodeVO;
import com.sunrise.boss.business.cms.reward.rulemode.persistent.RulemodeDAO;
import com.sunrise.boss.business.cms.reward.rulemode.persistent.RulemodeListVO;

/**
 * <p>Title: RulemodeControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/rulemode/control/RulemodeControlBean"
 name="RulemodeControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RulemodeControlBean extends AbstractControlBean
    implements RulemodeControl {

    public RulemodeVO doCreate(RulemodeVO vo, User user)
        throws Exception {
        try{
			RulemodeDAO dao = (RulemodeDAO) DAOFactory.build(RulemodeDAO.class, user);
            // TODO  set the pk */
            return (RulemodeVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(RulemodeVO vo, User user)
        throws Exception {
        try{
			RulemodeDAO dao = (RulemodeDAO) DAOFactory.build(RulemodeDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RulemodeVO doUpdate(RulemodeVO vo, User user)
        throws Exception {
        try{
			RulemodeDAO dao = (RulemodeDAO) DAOFactory.build(RulemodeDAO.class, user);
            return (RulemodeVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RulemodeVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RulemodeDAO dao = (RulemodeDAO) DAOFactory.build(RulemodeDAO.class, user);
        return (RulemodeVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(RulemodeListVO params, User user)
        throws Exception {
			RulemodeDAO dao = (RulemodeDAO) DAOFactory.build(RulemodeDAO.class, user);
        return dao.query(params);
    }
}
