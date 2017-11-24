/**
* auto-generated code
* Mon Jan 14 11:41:04 CST 2013
*/
package com.sunrise.boss.business.cms.chadtsaleslog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtsaleslog.persistent.ChAdtSaleslogVO;
import com.sunrise.boss.business.cms.chadtsaleslog.persistent.ChAdtSaleslogDAO;
import com.sunrise.boss.business.cms.chadtsaleslog.persistent.ChAdtSaleslogListVO;

/**
 * <p>Title: ChAdtSaleslogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chadtsaleslog/control/ChAdtSaleslogControlBean"
 name="ChAdtSaleslogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChAdtSaleslogControlBean extends AbstractControlBean
    implements ChAdtSaleslogControl {

    public ChAdtSaleslogVO doCreate(ChAdtSaleslogVO vo, User user)
        throws Exception {
        try{
			ChAdtSaleslogDAO dao = (ChAdtSaleslogDAO) DAOFactory.build(ChAdtSaleslogDAO.class, user);
            // TODO  set the pk */
            return (ChAdtSaleslogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChAdtSaleslogVO vo, User user)
        throws Exception {
        try{
			ChAdtSaleslogDAO dao = (ChAdtSaleslogDAO) DAOFactory.build(ChAdtSaleslogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtSaleslogVO doUpdate(ChAdtSaleslogVO vo, User user)
        throws Exception {
        try{
			ChAdtSaleslogDAO dao = (ChAdtSaleslogDAO) DAOFactory.build(ChAdtSaleslogDAO.class, user);
            return (ChAdtSaleslogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtSaleslogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChAdtSaleslogDAO dao = (ChAdtSaleslogDAO) DAOFactory.build(ChAdtSaleslogDAO.class, user);
        return (ChAdtSaleslogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChAdtSaleslogListVO params, User user)
        throws Exception {
			ChAdtSaleslogDAO dao = (ChAdtSaleslogDAO) DAOFactory.build(ChAdtSaleslogDAO.class, user);
        return dao.query(params);
    }
}
