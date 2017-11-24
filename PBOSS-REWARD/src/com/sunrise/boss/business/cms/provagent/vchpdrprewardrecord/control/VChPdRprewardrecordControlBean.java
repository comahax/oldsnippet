/**
* auto-generated code
* Wed Sep 04 21:16:54 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.vchpdrprewardrecord.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.vchpdrprewardrecord.persistent.VChPdRprewardrecordVO;
import com.sunrise.boss.business.cms.provagent.vchpdrprewardrecord.persistent.VChPdRprewardrecordDAO;
import com.sunrise.boss.business.cms.provagent.vchpdrprewardrecord.persistent.VChPdRprewardrecordListVO;

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
public class VChPdRprewardrecordControlBean extends AbstractControlBean
    implements VChPdRprewardrecordControl {

    public VChPdRprewardrecordVO doCreate(VChPdRprewardrecordVO vo, User user)
        throws Exception {
        try{
			VChPdRprewardrecordDAO dao = (VChPdRprewardrecordDAO) DAOFactory.build(VChPdRprewardrecordDAO.class, user);
            // TODO  set the pk */
            return (VChPdRprewardrecordVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(VChPdRprewardrecordVO vo, User user)
        throws Exception {
        try{
			VChPdRprewardrecordDAO dao = (VChPdRprewardrecordDAO) DAOFactory.build(VChPdRprewardrecordDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public VChPdRprewardrecordVO doUpdate(VChPdRprewardrecordVO vo, User user)
        throws Exception {
        try{
			VChPdRprewardrecordDAO dao = (VChPdRprewardrecordDAO) DAOFactory.build(VChPdRprewardrecordDAO.class, user);
            return (VChPdRprewardrecordVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public VChPdRprewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
			VChPdRprewardrecordDAO dao = (VChPdRprewardrecordDAO) DAOFactory.build(VChPdRprewardrecordDAO.class, user);
        return (VChPdRprewardrecordVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(VChPdRprewardrecordListVO params, User user)
        throws Exception {
			VChPdRprewardrecordDAO dao = (VChPdRprewardrecordDAO) DAOFactory.build(VChPdRprewardrecordDAO.class, user);
        return dao.query(params);
    }
}
