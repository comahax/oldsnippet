/**
* auto-generated code
* Sat Mar 09 12:10:11 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigtotal.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigtotal.persistent.ChZjtyLocalperconfigtotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigtotal.persistent.ChZjtyLocalperconfigtotalDAO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigtotal.persistent.ChZjtyLocalperconfigtotalListVO;

/**
 * <p>Title: ChZjtyLocalperconfigtotalControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/chzjtylocalperconfigtotal/control/ChZjtyLocalperconfigtotalControlBean"
 name="ChZjtyLocalperconfigtotalControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZjtyLocalperconfigtotalControlBean extends AbstractControlBean
    implements ChZjtyLocalperconfigtotalControl {

    public ChZjtyLocalperconfigtotalVO doCreate(ChZjtyLocalperconfigtotalVO vo, User user)
        throws Exception {
        try{
            ChZjtyLocalperconfigtotalDAO dao = (ChZjtyLocalperconfigtotalDAO) DAOFactory.build(ChZjtyLocalperconfigtotalDAO.class, user);
            // TODO  set the pk */
            return (ChZjtyLocalperconfigtotalVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChZjtyLocalperconfigtotalVO vo, User user)
        throws Exception {
        try{
            ChZjtyLocalperconfigtotalDAO dao = (ChZjtyLocalperconfigtotalDAO) DAOFactory.build(ChZjtyLocalperconfigtotalDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyLocalperconfigtotalVO doUpdate(ChZjtyLocalperconfigtotalVO vo, User user)
        throws Exception {
        try{
            ChZjtyLocalperconfigtotalDAO dao = (ChZjtyLocalperconfigtotalDAO) DAOFactory.build(ChZjtyLocalperconfigtotalDAO.class, user);
            return (ChZjtyLocalperconfigtotalVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyLocalperconfigtotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
            ChZjtyLocalperconfigtotalDAO dao = (ChZjtyLocalperconfigtotalDAO) DAOFactory.build(ChZjtyLocalperconfigtotalDAO.class, user);
        return (ChZjtyLocalperconfigtotalVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChZjtyLocalperconfigtotalListVO params, User user)
        throws Exception {
            ChZjtyLocalperconfigtotalDAO dao = (ChZjtyLocalperconfigtotalDAO) DAOFactory.build(ChZjtyLocalperconfigtotalDAO.class, user);
        return dao.query(params);
    }

    public DataPackage doQueryTotal(ChZjtyLocalperconfigtotalListVO params, User user)
        throws Exception {
            ChZjtyLocalperconfigtotalDAO dao = (ChZjtyLocalperconfigtotalDAO) DAOFactory.build(ChZjtyLocalperconfigtotalDAO.class, user);
        return dao.doQueryTotal(params);
    }
}
