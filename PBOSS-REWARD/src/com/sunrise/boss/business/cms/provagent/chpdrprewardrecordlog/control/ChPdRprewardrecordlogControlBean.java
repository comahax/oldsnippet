/**
* auto-generated code
* Sun Sep 08 15:35:41 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdrprewardrecordlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecordlog.persistent.ChPdRprewardrecordlogVO;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecordlog.persistent.ChPdRprewardrecordlogDAO;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecordlog.persistent.ChPdRprewardrecordlogListVO;

/**
 * <p>Title: ChPdRprewardrecordlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/provagent/chpdrprewardrecordlog/control/ChPdRprewardrecordlogControlBean"
 name="ChPdRprewardrecordlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPdRprewardrecordlogControlBean extends AbstractControlBean
    implements ChPdRprewardrecordlogControl {

    public ChPdRprewardrecordlogVO doCreate(ChPdRprewardrecordlogVO vo, User user)
        throws Exception {
        try{
			ChPdRprewardrecordlogDAO dao = (ChPdRprewardrecordlogDAO) DAOFactory.build(ChPdRprewardrecordlogDAO.class, user);
            // TODO  set the pk */
            return (ChPdRprewardrecordlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPdRprewardrecordlogVO vo, User user)
        throws Exception {
        try{
			ChPdRprewardrecordlogDAO dao = (ChPdRprewardrecordlogDAO) DAOFactory.build(ChPdRprewardrecordlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdRprewardrecordlogVO doUpdate(ChPdRprewardrecordlogVO vo, User user)
        throws Exception {
        try{
			ChPdRprewardrecordlogDAO dao = (ChPdRprewardrecordlogDAO) DAOFactory.build(ChPdRprewardrecordlogDAO.class, user);
            return (ChPdRprewardrecordlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdRprewardrecordlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPdRprewardrecordlogDAO dao = (ChPdRprewardrecordlogDAO) DAOFactory.build(ChPdRprewardrecordlogDAO.class, user);
        return (ChPdRprewardrecordlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPdRprewardrecordlogListVO params, User user)
        throws Exception {
			ChPdRprewardrecordlogDAO dao = (ChPdRprewardrecordlogDAO) DAOFactory.build(ChPdRprewardrecordlogDAO.class, user);
        return dao.query(params);
    }
}
