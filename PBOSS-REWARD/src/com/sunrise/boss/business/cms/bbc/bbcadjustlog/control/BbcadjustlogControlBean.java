/**
* auto-generated code
* Wed Aug 26 15:55:18 CST 2009
*/
package com.sunrise.boss.business.cms.bbc.bbcadjustlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcadjustlog.persistent.BbcadjustlogVO;
import com.sunrise.boss.business.cms.bbc.bbcadjustlog.persistent.BbcadjustlogDAO;
import com.sunrise.boss.business.cms.bbc.bbcadjustlog.persistent.BbcadjustlogListVO;

/**
 * <p>Title: BbcadjustlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/bbcadjustlog/control/BbcadjustlogControlBean"
 name="BbcadjustlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BbcadjustlogControlBean extends AbstractControlBean
    implements BbcadjustlogControl {

    public BbcadjustlogVO doCreate(BbcadjustlogVO vo, User user)
        throws Exception {
        try{
			BbcadjustlogDAO dao = (BbcadjustlogDAO) DAOFactory.build(BbcadjustlogDAO.class, user);
            // TODO  set the pk */
            return (BbcadjustlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(BbcadjustlogVO vo, User user)
        throws Exception {
        try{
			BbcadjustlogDAO dao = (BbcadjustlogDAO) DAOFactory.build(BbcadjustlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BbcadjustlogVO doUpdate(BbcadjustlogVO vo, User user)
        throws Exception {
        try{
			BbcadjustlogDAO dao = (BbcadjustlogDAO) DAOFactory.build(BbcadjustlogDAO.class, user);
            return (BbcadjustlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BbcadjustlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			BbcadjustlogDAO dao = (BbcadjustlogDAO) DAOFactory.build(BbcadjustlogDAO.class, user);
        return (BbcadjustlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(BbcadjustlogListVO params, User user)
        throws Exception {
			BbcadjustlogDAO dao = (BbcadjustlogDAO) DAOFactory.build(BbcadjustlogDAO.class, user);
        return dao.query(params);
    }
}
