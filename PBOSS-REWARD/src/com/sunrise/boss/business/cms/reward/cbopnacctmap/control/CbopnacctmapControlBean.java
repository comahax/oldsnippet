/**
* auto-generated code
* Mon Sep 22 09:01:03 CST 2008
*/
package com.sunrise.boss.business.cms.reward.cbopnacctmap.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.reward.cbopnacctmap.persistent.CbopnacctmapDAO;
import com.sunrise.boss.business.cms.reward.cbopnacctmap.persistent.CbopnacctmapListVO;
import com.sunrise.boss.business.cms.reward.cbopnacctmap.persistent.CbopnacctmapVO;
import com.sunrise.boss.business.cms.reward.cbopnacctmap.persistent.VisualCbopnacctmapVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: CbopnacctmapControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/cbopnacctmap/control/CbopnacctmapControlBean"
 name="CbopnacctmapControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CbopnacctmapControlBean extends AbstractControlBean
    implements CbopnacctmapControl {

    public CbopnacctmapVO doCreate(CbopnacctmapVO vo, User user)
        throws Exception {
        try{
			CbopnacctmapDAO dao = (CbopnacctmapDAO) DAOFactory.build(CbopnacctmapDAO.class, user);
            // TODO  set the pk */
            return (CbopnacctmapVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(CbopnacctmapVO vo, User user)
        throws Exception {
        try{
			CbopnacctmapDAO dao = (CbopnacctmapDAO) DAOFactory.build(CbopnacctmapDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CbopnacctmapVO doUpdate(CbopnacctmapVO vo, User user)
        throws Exception {
        try{
			CbopnacctmapDAO dao = (CbopnacctmapDAO) DAOFactory.build(CbopnacctmapDAO.class, user);
            return (CbopnacctmapVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CbopnacctmapVO doFindByPk(Serializable pk, User user)
        throws Exception {
			CbopnacctmapDAO dao = (CbopnacctmapDAO) DAOFactory.build(CbopnacctmapDAO.class, user);
        return (CbopnacctmapVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(CbopnacctmapListVO params, User user)
        throws Exception {
    		CbopnacctmapDAO dao = (CbopnacctmapDAO) DAOFactory.build(CbopnacctmapDAO.class, user);
			dao.setVoClass(VisualCbopnacctmapVO.class);
    return dao.doQuery(params);
    }
}
