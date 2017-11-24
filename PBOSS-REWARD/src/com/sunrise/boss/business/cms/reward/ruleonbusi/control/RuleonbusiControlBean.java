/**
* auto-generated code
* Fri Apr 18 17:02:15 CST 2008
*/
package com.sunrise.boss.business.cms.reward.ruleonbusi.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ruleonbusi.persistent.RuleonbusiVO;
import com.sunrise.boss.business.cms.reward.ruleonbusi.persistent.RuleonbusiDAO;
import com.sunrise.boss.business.cms.reward.ruleonbusi.persistent.RuleonbusiListVO;

/**
 * <p>Title: RuleonbusiControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: SUNRISE Tech Ltd.</p>
 * @author Zhang Fengchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/ruleonbusi/control/RuleonbusiControlBean"
 name="RuleonbusiControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RuleonbusiControlBean extends AbstractControlBean
    implements RuleonbusiControl {

    public RuleonbusiVO doCreate(RuleonbusiVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         RuleonbusiDAO dao = (RuleonbusiDAO) DAOFactory.build(RuleonbusiDAO.class, user);
            return (RuleonbusiVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RuleonbusiVO vo, User user)
        throws Exception {
        try{
         RuleonbusiDAO dao = (RuleonbusiDAO) DAOFactory.build(RuleonbusiDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RuleonbusiVO doUpdate(RuleonbusiVO vo, User user)
        throws Exception {
        try{
         RuleonbusiDAO dao = (RuleonbusiDAO) DAOFactory.build(RuleonbusiDAO.class, user);
            return (RuleonbusiVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RuleonbusiVO doFindByPk(Serializable pk, User user)
        throws Exception {
         RuleonbusiDAO dao = (RuleonbusiDAO) DAOFactory.build(RuleonbusiDAO.class, user);
        return (RuleonbusiVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RuleonbusiListVO params, User user)
        throws Exception {
         RuleonbusiDAO dao = (RuleonbusiDAO) DAOFactory.build(RuleonbusiDAO.class, user);
        return dao.query(params);
    }
    public DataPackage doQuery1(RuleonbusiListVO params, User user)
    throws Exception {
     RuleonbusiDAO dao = (RuleonbusiDAO) DAOFactory.build(RuleonbusiDAO.class, user);
    return dao.ruleonbusiQuery(params);
}
}
