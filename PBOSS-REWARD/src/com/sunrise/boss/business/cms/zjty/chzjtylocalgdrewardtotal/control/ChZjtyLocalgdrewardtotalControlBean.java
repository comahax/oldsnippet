/**
* auto-generated code
* Sat Mar 09 12:02:30 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocalgdrewardtotal.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocalgdrewardtotal.persistent.ChZjtyLocalgdrewardtotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalgdrewardtotal.persistent.ChZjtyLocalgdrewardtotalDAO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalgdrewardtotal.persistent.ChZjtyLocalgdrewardtotalListVO;

/**
 * <p>Title: ChZjtyLocalgdrewardtotalControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/chzjtylocalgdrewardtotal/control/ChZjtyLocalgdrewardtotalControlBean"
 name="ChZjtyLocalgdrewardtotalControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZjtyLocalgdrewardtotalControlBean extends AbstractControlBean
    implements ChZjtyLocalgdrewardtotalControl {

    public ChZjtyLocalgdrewardtotalVO doCreate(ChZjtyLocalgdrewardtotalVO vo, User user)
        throws Exception {
        try{
			ChZjtyLocalgdrewardtotalDAO dao = (ChZjtyLocalgdrewardtotalDAO) DAOFactory.build(ChZjtyLocalgdrewardtotalDAO.class, user);
            // TODO  set the pk */
            return (ChZjtyLocalgdrewardtotalVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChZjtyLocalgdrewardtotalVO vo, User user)
        throws Exception {
        try{
			ChZjtyLocalgdrewardtotalDAO dao = (ChZjtyLocalgdrewardtotalDAO) DAOFactory.build(ChZjtyLocalgdrewardtotalDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyLocalgdrewardtotalVO doUpdate(ChZjtyLocalgdrewardtotalVO vo, User user)
        throws Exception {
        try{
			ChZjtyLocalgdrewardtotalDAO dao = (ChZjtyLocalgdrewardtotalDAO) DAOFactory.build(ChZjtyLocalgdrewardtotalDAO.class, user);
            return (ChZjtyLocalgdrewardtotalVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyLocalgdrewardtotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChZjtyLocalgdrewardtotalDAO dao = (ChZjtyLocalgdrewardtotalDAO) DAOFactory.build(ChZjtyLocalgdrewardtotalDAO.class, user);
        return (ChZjtyLocalgdrewardtotalVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChZjtyLocalgdrewardtotalListVO params, User user)
        throws Exception {
			ChZjtyLocalgdrewardtotalDAO dao = (ChZjtyLocalgdrewardtotalDAO) DAOFactory.build(ChZjtyLocalgdrewardtotalDAO.class, user);
        return dao.query(params);
    }

    public DataPackage doQueryTotal(ChZjtyLocalgdrewardtotalListVO params, User user)
        throws Exception {
			ChZjtyLocalgdrewardtotalDAO dao = (ChZjtyLocalgdrewardtotalDAO) DAOFactory.build(ChZjtyLocalgdrewardtotalDAO.class, user);
        return dao.doQueryTotal(params);
    }
}
