/**
* auto-generated code
* Tue Sep 03 20:54:50 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdauditdispute.control;

import java.io.Serializable;
import org.apache.commons.beanutils.BeanUtils;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdauditdispute.persistent.ChPdAuditdisputeVO;
import com.sunrise.boss.business.cms.provagent.chpdauditdispute.persistent.ChPdAuditdisputeDAO;
import com.sunrise.boss.business.cms.provagent.chpdauditdispute.persistent.ChPdAuditdisputeListVO;
import com.sunrise.boss.business.cms.provagent.chpdauditdispute.persistent.VChPdAuditdisputeDAO;
import com.sunrise.boss.business.cms.provagent.chpdauditdispute.persistent.VChPdAuditdisputeListVO;

/**
 * <p>Title: ChPdAuditdisputeControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/proagent/chpdauditdispute/control/ChPdAuditdisputeControlBean"
 name="ChPdAuditdisputeControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPdAuditdisputeControlBean extends AbstractControlBean
    implements ChPdAuditdisputeControl {

    public ChPdAuditdisputeVO doCreate(ChPdAuditdisputeVO vo, User user)
        throws Exception {
        try{
			ChPdAuditdisputeDAO dao = (ChPdAuditdisputeDAO) DAOFactory.build(ChPdAuditdisputeDAO.class, user);
            // TODO  set the pk */
            return (ChPdAuditdisputeVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPdAuditdisputeVO vo, User user)
        throws Exception {
        try{
			ChPdAuditdisputeDAO dao = (ChPdAuditdisputeDAO) DAOFactory.build(ChPdAuditdisputeDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdAuditdisputeVO doUpdate(ChPdAuditdisputeVO vo, User user)
        throws Exception {
        try{
			ChPdAuditdisputeDAO dao = (ChPdAuditdisputeDAO) DAOFactory.build(ChPdAuditdisputeDAO.class, user);
            return (ChPdAuditdisputeVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdAuditdisputeVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPdAuditdisputeDAO dao = (ChPdAuditdisputeDAO) DAOFactory.build(ChPdAuditdisputeDAO.class, user);
        return (ChPdAuditdisputeVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPdAuditdisputeListVO params, User user)
        throws Exception {
    	VChPdAuditdisputeListVO listVO = new VChPdAuditdisputeListVO();
    	BeanUtils.copyProperties(listVO, params);
		VChPdAuditdisputeDAO dao = (VChPdAuditdisputeDAO) DAOFactory.build(VChPdAuditdisputeDAO.class, user);
        return dao.queryByNamedSqlQuery("cms.provagent.QueryAuditdispute", listVO);
    }
}
