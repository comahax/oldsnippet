/**
* auto-generated code
* Wed Sep 02 10:14:50 CST 2009
*/
package com.sunrise.boss.business.cms.bbc.unvrewardtotal.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.unvrewardtotal.persistent.UnvRewardtotalVO;
import com.sunrise.boss.business.cms.bbc.unvrewardtotal.persistent.UnvRewardtotalDAO;
import com.sunrise.boss.business.cms.bbc.unvrewardtotal.persistent.UnvRewardtotalListVO;

/**
 * <p>Title: UnvRewardtotalControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/unvrewardtotal/control/UnvRewardtotalControlBean"
 name="UnvRewardtotalControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class UnvRewardtotalControlBean extends AbstractControlBean
    implements UnvRewardtotalControl {

    public UnvRewardtotalVO doCreate(UnvRewardtotalVO vo, User user)
        throws Exception {
        try{
			UnvRewardtotalDAO dao = (UnvRewardtotalDAO) DAOFactory.build(UnvRewardtotalDAO.class, user);
            // TODO  set the pk */
            return (UnvRewardtotalVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(UnvRewardtotalVO vo, User user)
        throws Exception {
        try{
			UnvRewardtotalDAO dao = (UnvRewardtotalDAO) DAOFactory.build(UnvRewardtotalDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public UnvRewardtotalVO doUpdate(UnvRewardtotalVO vo, User user)
        throws Exception {
        try{
			UnvRewardtotalDAO dao = (UnvRewardtotalDAO) DAOFactory.build(UnvRewardtotalDAO.class, user);
            return (UnvRewardtotalVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public UnvRewardtotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
			UnvRewardtotalDAO dao = (UnvRewardtotalDAO) DAOFactory.build(UnvRewardtotalDAO.class, user);
        return (UnvRewardtotalVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(UnvRewardtotalListVO params, User user)
        throws Exception {
			UnvRewardtotalDAO dao = (UnvRewardtotalDAO) DAOFactory.build(UnvRewardtotalDAO.class, user);
        return dao.queryByNamedSqlQuery("unvrewardTotalQuery",params);
    }
}
