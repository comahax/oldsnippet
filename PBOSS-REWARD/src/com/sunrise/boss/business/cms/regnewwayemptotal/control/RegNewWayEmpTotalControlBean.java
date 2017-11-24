/**
* auto-generated code
* Thu Feb 24 15:31:21 CST 2011
*/
package com.sunrise.boss.business.cms.regnewwayemptotal.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.regnewwayemptotal.persistent.RegNewWayEmpTotalVO;
import com.sunrise.boss.business.cms.regnewwayemptotal.persistent.RegNewWayEmpTotalDAO;
import com.sunrise.boss.business.cms.regnewwayemptotal.persistent.RegNewWayEmpTotalListVO;

/**
 * <p>Title: RegNewWayEmpTotalControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/regnewwayemptotal/control/RegNewWayEmpTotalControlBean"
 name="RegNewWayEmpTotalControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RegNewWayEmpTotalControlBean extends AbstractControlBean
    implements RegNewWayEmpTotalControl {

    public RegNewWayEmpTotalVO doCreate(RegNewWayEmpTotalVO vo, User user)
        throws Exception {
        try{
			RegNewWayEmpTotalDAO dao = (RegNewWayEmpTotalDAO) DAOFactory.build(RegNewWayEmpTotalDAO.class, user);
            // TODO  set the pk */
            return (RegNewWayEmpTotalVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(RegNewWayEmpTotalVO vo, User user)
        throws Exception {
        try{
			RegNewWayEmpTotalDAO dao = (RegNewWayEmpTotalDAO) DAOFactory.build(RegNewWayEmpTotalDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RegNewWayEmpTotalVO doUpdate(RegNewWayEmpTotalVO vo, User user)
        throws Exception {
        try{
			RegNewWayEmpTotalDAO dao = (RegNewWayEmpTotalDAO) DAOFactory.build(RegNewWayEmpTotalDAO.class, user);
            return (RegNewWayEmpTotalVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RegNewWayEmpTotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RegNewWayEmpTotalDAO dao = (RegNewWayEmpTotalDAO) DAOFactory.build(RegNewWayEmpTotalDAO.class, user);
        return (RegNewWayEmpTotalVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(RegNewWayEmpTotalListVO params, User user)
        throws Exception {
			RegNewWayEmpTotalDAO dao = (RegNewWayEmpTotalDAO) DAOFactory.build(RegNewWayEmpTotalDAO.class, user);
//        return dao.query(params);
        return dao.queryAMT(params);
    }
}
