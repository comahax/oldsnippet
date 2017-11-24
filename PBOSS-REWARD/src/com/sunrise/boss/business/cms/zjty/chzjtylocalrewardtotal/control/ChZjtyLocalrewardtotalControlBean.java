/**
* auto-generated code
* Sat Mar 09 12:11:47 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocalrewardtotal.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardtotal.persistent.ChZjtyLocalrewardtotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardtotal.persistent.ChZjtyLocalrewardtotalDAO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardtotal.persistent.ChZjtyLocalrewardtotalListVO;

/**
 * <p>Title: ChZjtyLocalrewardtotalControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/chzjtylocalrewardtotal/control/ChZjtyLocalrewardtotalControlBean"
 name="ChZjtyLocalrewardtotalControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZjtyLocalrewardtotalControlBean extends AbstractControlBean
    implements ChZjtyLocalrewardtotalControl {

    public ChZjtyLocalrewardtotalVO doCreate(ChZjtyLocalrewardtotalVO vo, User user)
        throws Exception {
        try{
			ChZjtyLocalrewardtotalDAO dao = (ChZjtyLocalrewardtotalDAO) DAOFactory.build(ChZjtyLocalrewardtotalDAO.class, user);
            // TODO  set the pk */
            return (ChZjtyLocalrewardtotalVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChZjtyLocalrewardtotalVO vo, User user)
        throws Exception {
        try{
			ChZjtyLocalrewardtotalDAO dao = (ChZjtyLocalrewardtotalDAO) DAOFactory.build(ChZjtyLocalrewardtotalDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyLocalrewardtotalVO doUpdate(ChZjtyLocalrewardtotalVO vo, User user)
        throws Exception {
        try{
			ChZjtyLocalrewardtotalDAO dao = (ChZjtyLocalrewardtotalDAO) DAOFactory.build(ChZjtyLocalrewardtotalDAO.class, user);
            return (ChZjtyLocalrewardtotalVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyLocalrewardtotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChZjtyLocalrewardtotalDAO dao = (ChZjtyLocalrewardtotalDAO) DAOFactory.build(ChZjtyLocalrewardtotalDAO.class, user);
        return (ChZjtyLocalrewardtotalVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChZjtyLocalrewardtotalListVO params, User user)
        throws Exception {
			ChZjtyLocalrewardtotalDAO dao = (ChZjtyLocalrewardtotalDAO) DAOFactory.build(ChZjtyLocalrewardtotalDAO.class, user);
        return dao.query(params);
    }

    public DataPackage doQueryTotal(ChZjtyLocalrewardtotalListVO params, User user)
        throws Exception {
			ChZjtyLocalrewardtotalDAO dao = (ChZjtyLocalrewardtotalDAO) DAOFactory.build(ChZjtyLocalrewardtotalDAO.class, user);
        return dao.doQueryTotal(params);
    }
}
