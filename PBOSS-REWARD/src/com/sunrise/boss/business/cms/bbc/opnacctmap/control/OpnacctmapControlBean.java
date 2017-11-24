/**
* auto-generated code
* Thu Sep 04 10:43:57 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.opnacctmap.control;

import java.io.Serializable;

import org.hibernate.FlushMode;
import org.hibernate.Session;

import com.sunrise.boss.business.cms.bbc.opnacctmap.persistent.OpnacctmapDAO;
import com.sunrise.boss.business.cms.bbc.opnacctmap.persistent.OpnacctmapListVO;
import com.sunrise.boss.business.cms.bbc.opnacctmap.persistent.OpnacctmapVO;
import com.sunrise.boss.business.cms.bbc.opnacctmap.persistent.VisualOpnacctmapVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: OpnacctmapControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/opnacctmap/control/OpnacctmapControlBean"
 name="OpnacctmapControl"
 view-type="local"
 type="Stateless"
 
 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class OpnacctmapControlBean extends AbstractControlBean
    implements OpnacctmapControl {

    public OpnacctmapVO doCreate(OpnacctmapVO vo, User user)
        throws Exception {
        try{
			OpnacctmapDAO dao = (OpnacctmapDAO) DAOFactory.build(OpnacctmapDAO.class, user);
            // TODO  set the pk */
            return (OpnacctmapVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(OpnacctmapVO vo, User user)
        throws Exception {
        try{
        	OpnacctmapDAO dao = (OpnacctmapDAO) DAOFactory.build(OpnacctmapDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public OpnacctmapVO doUpdate(OpnacctmapVO vo, User user)
        throws Exception {
        try{
        	OpnacctmapDAO dao = (OpnacctmapDAO) DAOFactory.build(OpnacctmapDAO.class, user);
            return (OpnacctmapVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public OpnacctmapVO doFindByPk(Serializable pk, User user)
        throws Exception {
    		OpnacctmapDAO dao = (OpnacctmapDAO) DAOFactory.build(OpnacctmapDAO.class, user);
        return (OpnacctmapVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(OpnacctmapListVO params, User user)
        throws Exception {
    		OpnacctmapDAO dao = (OpnacctmapDAO) DAOFactory.build(OpnacctmapDAO.class, user);
    		dao.setVoClass(VisualOpnacctmapVO.class);
        return dao.doQuery(params);
    }
}
