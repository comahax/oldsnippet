/**
* auto-generated code
* Fri Feb 13 16:59:53 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.chzjtyoprtcost.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyoprtcost.persistent.ChZjtyOprtcostVO;
import com.sunrise.boss.business.cms.zjty.chzjtyoprtcost.persistent.ChZjtyOprtcostDAO;
import com.sunrise.boss.business.cms.zjty.chzjtyoprtcost.persistent.ChZjtyOprtcostListVO;

/**
 * <p>Title: ChZjtyOprtcostControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/chzjtyoprtcost/control/ChZjtyOprtcostControlBean"
 name="ChZjtyOprtcostControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZjtyOprtcostControlBean extends AbstractControlBean
    implements ChZjtyOprtcostControl {

    public ChZjtyOprtcostVO doCreate(ChZjtyOprtcostVO vo, User user)
        throws Exception {
        try{
			ChZjtyOprtcostDAO dao = (ChZjtyOprtcostDAO) DAOFactory.build(ChZjtyOprtcostDAO.class, user);
            // TODO  set the pk */
            return (ChZjtyOprtcostVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ChZjtyOprtcostVO vo, User user)
        throws Exception {
        try{
			ChZjtyOprtcostDAO dao = (ChZjtyOprtcostDAO) DAOFactory.build(ChZjtyOprtcostDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ChZjtyOprtcostVO doUpdate(ChZjtyOprtcostVO vo, User user)
        throws Exception {
        try{
			ChZjtyOprtcostDAO dao = (ChZjtyOprtcostDAO) DAOFactory.build(ChZjtyOprtcostDAO.class, user);
            return (ChZjtyOprtcostVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ChZjtyOprtcostVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChZjtyOprtcostDAO dao = (ChZjtyOprtcostDAO) DAOFactory.build(ChZjtyOprtcostDAO.class, user);
        return (ChZjtyOprtcostVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ChZjtyOprtcostListVO params, User user)
        throws Exception {
			ChZjtyOprtcostDAO dao = (ChZjtyOprtcostDAO) DAOFactory.build(ChZjtyOprtcostDAO.class, user);
        return dao.query(params);
    }
}
