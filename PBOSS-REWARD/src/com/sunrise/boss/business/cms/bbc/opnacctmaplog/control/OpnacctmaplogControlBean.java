/**
* auto-generated code
* Sun Sep 14 16:17:54 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.opnacctmaplog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.opnacctmaplog.persistent.OpnacctmaplogVO;
import com.sunrise.boss.business.cms.bbc.opnacctmaplog.persistent.OpnacctmaplogDAO;
import com.sunrise.boss.business.cms.bbc.opnacctmaplog.persistent.OpnacctmaplogListVO;

/**
 * <p>Title: OpnacctmaplogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/opnacctmaplog/control/OpnacctmaplogControlBean"
 name="OpnacctmaplogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class OpnacctmaplogControlBean extends AbstractControlBean
    implements OpnacctmaplogControl {

    public OpnacctmaplogVO doCreate(OpnacctmaplogVO vo, User user)
        throws Exception {
        try{
			OpnacctmaplogDAO dao = (OpnacctmaplogDAO) DAOFactory.build(OpnacctmaplogDAO.class, user);
            // TODO  set the pk */
            return (OpnacctmaplogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(OpnacctmaplogVO vo, User user)
        throws Exception {
        try{
			OpnacctmaplogDAO dao = (OpnacctmaplogDAO) DAOFactory.build(OpnacctmaplogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public OpnacctmaplogVO doUpdate(OpnacctmaplogVO vo, User user)
        throws Exception {
        try{
			OpnacctmaplogDAO dao = (OpnacctmaplogDAO) DAOFactory.build(OpnacctmaplogDAO.class, user);
            return (OpnacctmaplogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public OpnacctmaplogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			OpnacctmaplogDAO dao = (OpnacctmaplogDAO) DAOFactory.build(OpnacctmaplogDAO.class, user);
        return (OpnacctmaplogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(OpnacctmaplogListVO params, User user)
        throws Exception {
			OpnacctmaplogDAO dao = (OpnacctmaplogDAO) DAOFactory.build(OpnacctmaplogDAO.class, user);
        return dao.query(params);
    }
}
