/**
* auto-generated code
* Sat Mar 09 12:08:48 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigdetail.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigdetail.persistent.ChZjtyLocalperconfigdetailVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigdetail.persistent.ChZjtyLocalperconfigdetailDAO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigdetail.persistent.ChZjtyLocalperconfigdetailListVO;

/**
 * <p>Title: ChZjtyLocalperconfigdetailControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/chzjtylocalperconfigdetail/control/ChZjtyLocalperconfigdetailControlBean"
 name="ChZjtyLocalperconfigdetailControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZjtyLocalperconfigdetailControlBean extends AbstractControlBean
    implements ChZjtyLocalperconfigdetailControl {

    public ChZjtyLocalperconfigdetailVO doCreate(ChZjtyLocalperconfigdetailVO vo, User user)
        throws Exception {
        try{
			ChZjtyLocalperconfigdetailDAO dao = (ChZjtyLocalperconfigdetailDAO) DAOFactory.build(ChZjtyLocalperconfigdetailDAO.class, user);
            // TODO  set the pk */
            return (ChZjtyLocalperconfigdetailVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChZjtyLocalperconfigdetailVO vo, User user)
        throws Exception {
        try{
			ChZjtyLocalperconfigdetailDAO dao = (ChZjtyLocalperconfigdetailDAO) DAOFactory.build(ChZjtyLocalperconfigdetailDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyLocalperconfigdetailVO doUpdate(ChZjtyLocalperconfigdetailVO vo, User user)
        throws Exception {
        try{
			ChZjtyLocalperconfigdetailDAO dao = (ChZjtyLocalperconfigdetailDAO) DAOFactory.build(ChZjtyLocalperconfigdetailDAO.class, user);
            return (ChZjtyLocalperconfigdetailVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyLocalperconfigdetailVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChZjtyLocalperconfigdetailDAO dao = (ChZjtyLocalperconfigdetailDAO) DAOFactory.build(ChZjtyLocalperconfigdetailDAO.class, user);
        return (ChZjtyLocalperconfigdetailVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChZjtyLocalperconfigdetailListVO params, User user)
        throws Exception {
			ChZjtyLocalperconfigdetailDAO dao = (ChZjtyLocalperconfigdetailDAO) DAOFactory.build(ChZjtyLocalperconfigdetailDAO.class, user);
        return dao.query(params);
    }
}
