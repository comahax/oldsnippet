/**
* auto-generated code
* Mon Aug 11 11:30:37 CST 2014
*/
package com.sunrise.boss.business.cms.chbbcmarketact.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chbbcmarketact.persistent.ChBbcMarketactVO;
import com.sunrise.boss.business.cms.chbbcmarketact.persistent.ChBbcMarketactDAO;
import com.sunrise.boss.business.cms.chbbcmarketact.persistent.ChBbcMarketactListVO;

/**
 * <p>Title: ChBbcMarketactControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chbbcmarketact/control/ChBbcMarketactControlBean"
 name="ChBbcMarketactControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChBbcMarketactControlBean extends AbstractControlBean
    implements ChBbcMarketactControl {

    public ChBbcMarketactVO doCreate(ChBbcMarketactVO vo, User user)
        throws Exception {
        try{
			ChBbcMarketactDAO dao = (ChBbcMarketactDAO) DAOFactory.build(ChBbcMarketactDAO.class, user);
            // TODO  set the pk */
            return (ChBbcMarketactVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChBbcMarketactVO vo, User user)
        throws Exception {
        try{
			ChBbcMarketactDAO dao = (ChBbcMarketactDAO) DAOFactory.build(ChBbcMarketactDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChBbcMarketactVO doUpdate(ChBbcMarketactVO vo, User user)
        throws Exception {
        try{
			ChBbcMarketactDAO dao = (ChBbcMarketactDAO) DAOFactory.build(ChBbcMarketactDAO.class, user);
            return (ChBbcMarketactVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChBbcMarketactVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChBbcMarketactDAO dao = (ChBbcMarketactDAO) DAOFactory.build(ChBbcMarketactDAO.class, user);
        return (ChBbcMarketactVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChBbcMarketactListVO params, User user)
        throws Exception {
			ChBbcMarketactDAO dao = (ChBbcMarketactDAO) DAOFactory.build(ChBbcMarketactDAO.class, user);
        return dao.query(params);
    }
}
