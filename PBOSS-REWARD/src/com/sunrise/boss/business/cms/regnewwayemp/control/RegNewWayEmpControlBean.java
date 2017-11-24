/**
* auto-generated code
* Mon Feb 21 20:51:42 CST 2011
*/
package com.sunrise.boss.business.cms.regnewwayemp.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.regnewwayemp.persistent.RegNewWayEmpVO;
import com.sunrise.boss.business.cms.regnewwayemp.persistent.RegNewWayEmpDAO;
import com.sunrise.boss.business.cms.regnewwayemp.persistent.RegNewWayEmpListVO;

/**
 * <p>Title: RegNewWayEmpControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/regnewwayemp/control/RegNewWayEmpControlBean"
 name="RegNewWayEmpControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RegNewWayEmpControlBean extends AbstractControlBean
    implements RegNewWayEmpControl {

    public RegNewWayEmpVO doCreate(RegNewWayEmpVO vo, User user)
        throws Exception {
        try{
			RegNewWayEmpDAO dao = (RegNewWayEmpDAO) DAOFactory.build(RegNewWayEmpDAO.class, user);
            // TODO  set the pk */
            return (RegNewWayEmpVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(RegNewWayEmpVO vo, User user)
        throws Exception {
        try{
			RegNewWayEmpDAO dao = (RegNewWayEmpDAO) DAOFactory.build(RegNewWayEmpDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RegNewWayEmpVO doUpdate(RegNewWayEmpVO vo, User user)
        throws Exception {
        try{
			RegNewWayEmpDAO dao = (RegNewWayEmpDAO) DAOFactory.build(RegNewWayEmpDAO.class, user);
            return (RegNewWayEmpVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public RegNewWayEmpVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RegNewWayEmpDAO dao = (RegNewWayEmpDAO) DAOFactory.build(RegNewWayEmpDAO.class, user);
        return (RegNewWayEmpVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(RegNewWayEmpListVO params, User user)
        throws Exception {
			RegNewWayEmpDAO dao = (RegNewWayEmpDAO) DAOFactory.build(RegNewWayEmpDAO.class, user);
//        return dao.query(params);
			return dao.queryByNamedSqlQuery("reward.regnewwayemp.RegNewWayEmpVO", params);
    }
}
