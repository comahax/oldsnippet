/**
* auto-generated code
* Mon Feb 16 10:04:47 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.chzjtyoprtcostlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyoprtcostlog.persistent.ChZjtyOprtcostlogVO;
import com.sunrise.boss.business.cms.zjty.chzjtyoprtcostlog.persistent.ChZjtyOprtcostlogDAO;
import com.sunrise.boss.business.cms.zjty.chzjtyoprtcostlog.persistent.ChZjtyOprtcostlogListVO;

/**
 * <p>Title: ChZjtyOprtcostlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/chzjtyoprtcostlog/control/ChZjtyOprtcostlogControlBean"
 name="ChZjtyOprtcostlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZjtyOprtcostlogControlBean extends AbstractControlBean
    implements ChZjtyOprtcostlogControl {

    public ChZjtyOprtcostlogVO doCreate(ChZjtyOprtcostlogVO vo, User user)
        throws Exception {
        try{
			ChZjtyOprtcostlogDAO dao = (ChZjtyOprtcostlogDAO) DAOFactory.build(ChZjtyOprtcostlogDAO.class, user);
            // TODO  set the pk */
            return (ChZjtyOprtcostlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ChZjtyOprtcostlogVO vo, User user)
        throws Exception {
        try{
			ChZjtyOprtcostlogDAO dao = (ChZjtyOprtcostlogDAO) DAOFactory.build(ChZjtyOprtcostlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ChZjtyOprtcostlogVO doUpdate(ChZjtyOprtcostlogVO vo, User user)
        throws Exception {
        try{
			ChZjtyOprtcostlogDAO dao = (ChZjtyOprtcostlogDAO) DAOFactory.build(ChZjtyOprtcostlogDAO.class, user);
            return (ChZjtyOprtcostlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ChZjtyOprtcostlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChZjtyOprtcostlogDAO dao = (ChZjtyOprtcostlogDAO) DAOFactory.build(ChZjtyOprtcostlogDAO.class, user);
        return (ChZjtyOprtcostlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ChZjtyOprtcostlogListVO params, User user)
        throws Exception {
			ChZjtyOprtcostlogDAO dao = (ChZjtyOprtcostlogDAO) DAOFactory.build(ChZjtyOprtcostlogDAO.class, user);
        return dao.query(params);
    }
}
