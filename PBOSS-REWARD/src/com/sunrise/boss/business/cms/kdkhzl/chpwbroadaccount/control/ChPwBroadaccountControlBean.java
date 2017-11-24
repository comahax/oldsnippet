/**
* auto-generated code
* Tue Aug 21 10:45:16 CST 2012
*/
package com.sunrise.boss.business.cms.kdkhzl.chpwbroadaccount.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.kdkhzl.chpwbroadaccount.persistent.ChPwBroadaccountVO;
import com.sunrise.boss.business.cms.kdkhzl.chpwbroadaccount.persistent.ChPwBroadaccountDAO;
import com.sunrise.boss.business.cms.kdkhzl.chpwbroadaccount.persistent.ChPwBroadaccountListVO;

/**
 * <p>Title: ChPwBroadaccountControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/kdkhzl/chpwbroadaccount/control/ChPwBroadaccountControlBean"
 name="ChPwBroadaccountControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPwBroadaccountControlBean extends AbstractControlBean
    implements ChPwBroadaccountControl {

    public ChPwBroadaccountVO doCreate(ChPwBroadaccountVO vo, User user)
        throws Exception {
        try{
			ChPwBroadaccountDAO dao = (ChPwBroadaccountDAO) DAOFactory.build(ChPwBroadaccountDAO.class, user);
            // TODO  set the pk */
            return (ChPwBroadaccountVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPwBroadaccountVO vo, User user)
        throws Exception {
        try{
			ChPwBroadaccountDAO dao = (ChPwBroadaccountDAO) DAOFactory.build(ChPwBroadaccountDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPwBroadaccountVO doUpdate(ChPwBroadaccountVO vo, User user)
        throws Exception {
        try{
			ChPwBroadaccountDAO dao = (ChPwBroadaccountDAO) DAOFactory.build(ChPwBroadaccountDAO.class, user);
            return (ChPwBroadaccountVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPwBroadaccountVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPwBroadaccountDAO dao = (ChPwBroadaccountDAO) DAOFactory.build(ChPwBroadaccountDAO.class, user);
        return (ChPwBroadaccountVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPwBroadaccountListVO params, User user)
        throws Exception {
			ChPwBroadaccountDAO dao = (ChPwBroadaccountDAO) DAOFactory.build(ChPwBroadaccountDAO.class, user);
        return dao.query(params);
    }
}
