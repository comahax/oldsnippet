/**
* auto-generated code
* Tue Sep 10 14:37:33 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdrprewardrecord.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecord.persistent.ChPdRprewardrecordVO;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecord.persistent.ChPdRprewardrecordDAO;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecord.persistent.ChPdRprewardrecordListVO;

/**
 * <p>Title: ChPdRprewardrecordControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/provagent/chpdrprewardrecord/control/ChPdRprewardrecordControlBean"
 name="ChPdRprewardrecordControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPdRprewardrecordControlBean extends AbstractControlBean
    implements ChPdRprewardrecordControl {

    public ChPdRprewardrecordVO doCreate(ChPdRprewardrecordVO vo, User user)
        throws Exception {
        try{
			ChPdRprewardrecordDAO dao = (ChPdRprewardrecordDAO) DAOFactory.build(ChPdRprewardrecordDAO.class, user);
            // TODO  set the pk */
            return (ChPdRprewardrecordVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPdRprewardrecordVO vo, User user)
        throws Exception {
        try{
			ChPdRprewardrecordDAO dao = (ChPdRprewardrecordDAO) DAOFactory.build(ChPdRprewardrecordDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdRprewardrecordVO doUpdate(ChPdRprewardrecordVO vo, User user)
        throws Exception {
        try{
			ChPdRprewardrecordDAO dao = (ChPdRprewardrecordDAO) DAOFactory.build(ChPdRprewardrecordDAO.class, user);
            return (ChPdRprewardrecordVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdRprewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPdRprewardrecordDAO dao = (ChPdRprewardrecordDAO) DAOFactory.build(ChPdRprewardrecordDAO.class, user);
        return (ChPdRprewardrecordVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPdRprewardrecordListVO params, User user)
        throws Exception {
			ChPdRprewardrecordDAO dao = (ChPdRprewardrecordDAO) DAOFactory.build(ChPdRprewardrecordDAO.class, user);
        return dao.query(params);
    }
}
