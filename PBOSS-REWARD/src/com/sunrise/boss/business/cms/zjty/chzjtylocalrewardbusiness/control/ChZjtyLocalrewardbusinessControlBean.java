/**
* auto-generated code
* Sat Mar 09 12:10:59 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocalrewardbusiness.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardbusiness.persistent.ChZjtyLocalrewardbusinessVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardbusiness.persistent.ChZjtyLocalrewardbusinessDAO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardbusiness.persistent.ChZjtyLocalrewardbusinessListVO;

/**
 * <p>Title: ChZjtyLocalrewardbusinessControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/chzjtylocalrewardbusiness/control/ChZjtyLocalrewardbusinessControlBean"
 name="ChZjtyLocalrewardbusinessControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZjtyLocalrewardbusinessControlBean extends AbstractControlBean
    implements ChZjtyLocalrewardbusinessControl {

    public ChZjtyLocalrewardbusinessVO doCreate(ChZjtyLocalrewardbusinessVO vo, User user)
        throws Exception {
        try{
            ChZjtyLocalrewardbusinessDAO dao = (ChZjtyLocalrewardbusinessDAO) DAOFactory.build(ChZjtyLocalrewardbusinessDAO.class, user);
            // TODO  set the pk */
            return (ChZjtyLocalrewardbusinessVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChZjtyLocalrewardbusinessVO vo, User user)
        throws Exception {
        try{
            ChZjtyLocalrewardbusinessDAO dao = (ChZjtyLocalrewardbusinessDAO) DAOFactory.build(ChZjtyLocalrewardbusinessDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyLocalrewardbusinessVO doUpdate(ChZjtyLocalrewardbusinessVO vo, User user)
        throws Exception {
        try{
            ChZjtyLocalrewardbusinessDAO dao = (ChZjtyLocalrewardbusinessDAO) DAOFactory.build(ChZjtyLocalrewardbusinessDAO.class, user);
            return (ChZjtyLocalrewardbusinessVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyLocalrewardbusinessVO doFindByPk(Serializable pk, User user)
        throws Exception {
            ChZjtyLocalrewardbusinessDAO dao = (ChZjtyLocalrewardbusinessDAO) DAOFactory.build(ChZjtyLocalrewardbusinessDAO.class, user);
        return (ChZjtyLocalrewardbusinessVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChZjtyLocalrewardbusinessListVO params, User user)
        throws Exception {
            ChZjtyLocalrewardbusinessDAO dao = (ChZjtyLocalrewardbusinessDAO) DAOFactory.build(ChZjtyLocalrewardbusinessDAO.class, user);
        return dao.query(params);
    }

    public DataPackage doQueryTotal(ChZjtyLocalrewardbusinessListVO params, User user)
        throws Exception {
            ChZjtyLocalrewardbusinessDAO dao = (ChZjtyLocalrewardbusinessDAO) DAOFactory.build(ChZjtyLocalrewardbusinessDAO.class, user);
        return dao.doQueryTotal(params);
    }
}
