/**
* auto-generated code
* Mon Sep 22 09:03:07 CST 2008
*/
package com.sunrise.boss.business.cms.reward.cbopnacctmaplog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.cbopnacctmaplog.persistent.CbopnacctmaplogVO;
import com.sunrise.boss.business.cms.reward.cbopnacctmaplog.persistent.CbopnacctmaplogDAO;
import com.sunrise.boss.business.cms.reward.cbopnacctmaplog.persistent.CbopnacctmaplogListVO;

/**
 * <p>Title: CbopnacctmaplogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/cbopnacctmaplog/control/CbopnacctmaplogControlBean"
 name="CbopnacctmaplogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CbopnacctmaplogControlBean extends AbstractControlBean
    implements CbopnacctmaplogControl {

    public CbopnacctmaplogVO doCreate(CbopnacctmaplogVO vo, User user)
        throws Exception {
        try{
			CbopnacctmaplogDAO dao = (CbopnacctmaplogDAO) DAOFactory.build(CbopnacctmaplogDAO.class, user);
            // TODO  set the pk */
            return (CbopnacctmaplogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(CbopnacctmaplogVO vo, User user)
        throws Exception {
        try{
			CbopnacctmaplogDAO dao = (CbopnacctmaplogDAO) DAOFactory.build(CbopnacctmaplogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CbopnacctmaplogVO doUpdate(CbopnacctmaplogVO vo, User user)
        throws Exception {
        try{
			CbopnacctmaplogDAO dao = (CbopnacctmaplogDAO) DAOFactory.build(CbopnacctmaplogDAO.class, user);
            return (CbopnacctmaplogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CbopnacctmaplogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			CbopnacctmaplogDAO dao = (CbopnacctmaplogDAO) DAOFactory.build(CbopnacctmaplogDAO.class, user);
        return (CbopnacctmaplogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(CbopnacctmaplogListVO params, User user)
        throws Exception {
			CbopnacctmaplogDAO dao = (CbopnacctmaplogDAO) DAOFactory.build(CbopnacctmaplogDAO.class, user);
        return dao.query(params);
    }
}
