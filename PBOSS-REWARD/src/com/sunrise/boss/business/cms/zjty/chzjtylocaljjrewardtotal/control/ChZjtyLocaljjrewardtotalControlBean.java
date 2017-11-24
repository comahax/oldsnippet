/**
* auto-generated code
* Sat Mar 09 12:07:52 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocaljjrewardtotal.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocaljjrewardtotal.persistent.ChZjtyLocaljjrewardtotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocaljjrewardtotal.persistent.ChZjtyLocaljjrewardtotalDAO;
import com.sunrise.boss.business.cms.zjty.chzjtylocaljjrewardtotal.persistent.ChZjtyLocaljjrewardtotalListVO;

/**
 * <p>Title: ChZjtyLocaljjrewardtotalControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/chzjtylocaljjrewardtotal/control/ChZjtyLocaljjrewardtotalControlBean"
 name="ChZjtyLocaljjrewardtotalControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZjtyLocaljjrewardtotalControlBean extends AbstractControlBean
    implements ChZjtyLocaljjrewardtotalControl {

    public ChZjtyLocaljjrewardtotalVO doCreate(ChZjtyLocaljjrewardtotalVO vo, User user)
        throws Exception {
        try{
            ChZjtyLocaljjrewardtotalDAO dao = (ChZjtyLocaljjrewardtotalDAO) DAOFactory.build(ChZjtyLocaljjrewardtotalDAO.class, user);
            // TODO  set the pk */
            return (ChZjtyLocaljjrewardtotalVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChZjtyLocaljjrewardtotalVO vo, User user)
        throws Exception {
        try{
            ChZjtyLocaljjrewardtotalDAO dao = (ChZjtyLocaljjrewardtotalDAO) DAOFactory.build(ChZjtyLocaljjrewardtotalDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyLocaljjrewardtotalVO doUpdate(ChZjtyLocaljjrewardtotalVO vo, User user)
        throws Exception {
        try{
            ChZjtyLocaljjrewardtotalDAO dao = (ChZjtyLocaljjrewardtotalDAO) DAOFactory.build(ChZjtyLocaljjrewardtotalDAO.class, user);
            return (ChZjtyLocaljjrewardtotalVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyLocaljjrewardtotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
            ChZjtyLocaljjrewardtotalDAO dao = (ChZjtyLocaljjrewardtotalDAO) DAOFactory.build(ChZjtyLocaljjrewardtotalDAO.class, user);
        return (ChZjtyLocaljjrewardtotalVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChZjtyLocaljjrewardtotalListVO params, User user)
        throws Exception {
            ChZjtyLocaljjrewardtotalDAO dao = (ChZjtyLocaljjrewardtotalDAO) DAOFactory.build(ChZjtyLocaljjrewardtotalDAO.class, user);
        return dao.query(params);
    }

    public DataPackage doQueryTotal(ChZjtyLocaljjrewardtotalListVO params, User user)
        throws Exception {
            ChZjtyLocaljjrewardtotalDAO dao = (ChZjtyLocaljjrewardtotalDAO) DAOFactory.build(ChZjtyLocaljjrewardtotalDAO.class, user);
        return dao.doQueryTotal(params);
    }
}
