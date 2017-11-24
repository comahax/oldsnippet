/**
* auto-generated code
* Wed Aug 26 15:42:00 CST 2009
*/
package com.sunrise.boss.business.cms.bbc.bbcadjust.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcadjust.persistent.BbcadjustVO;
import com.sunrise.boss.business.cms.bbc.bbcadjust.persistent.BbcadjustDAO;
import com.sunrise.boss.business.cms.bbc.bbcadjust.persistent.BbcadjustListVO;

/**
 * <p>Title: BbcadjustControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/bbcadjust/control/BbcadjustControlBean"
 name="BbcadjustControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BbcadjustControlBean extends AbstractControlBean
    implements BbcadjustControl {

    public BbcadjustVO doCreate(BbcadjustVO vo, User user)
        throws Exception {
        try{
			BbcadjustDAO dao = (BbcadjustDAO) DAOFactory.build(BbcadjustDAO.class, user);
            // TODO  set the pk */
            return (BbcadjustVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(BbcadjustVO vo, User user)
        throws Exception {
        try{
			BbcadjustDAO dao = (BbcadjustDAO) DAOFactory.build(BbcadjustDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BbcadjustVO doUpdate(BbcadjustVO vo, User user)
        throws Exception {
        try{
			BbcadjustDAO dao = (BbcadjustDAO) DAOFactory.build(BbcadjustDAO.class, user);
            return (BbcadjustVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BbcadjustVO doFindByPk(Serializable pk, User user)
        throws Exception {
			BbcadjustDAO dao = (BbcadjustDAO) DAOFactory.build(BbcadjustDAO.class, user);
        return (BbcadjustVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(BbcadjustListVO params, User user)
        throws Exception {
			BbcadjustDAO dao = (BbcadjustDAO) DAOFactory.build(BbcadjustDAO.class, user);
        return dao.query(params);
    }
}
