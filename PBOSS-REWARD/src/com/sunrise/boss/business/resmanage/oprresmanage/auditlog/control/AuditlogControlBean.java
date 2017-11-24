/**
* auto-generated code
* Sat Jun 14 21:14:25 CST 2008
*/
package com.sunrise.boss.business.resmanage.oprresmanage.auditlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.oprresmanage.auditlog.persistent.AuditlogVO;
import com.sunrise.boss.business.resmanage.oprresmanage.auditlog.persistent.AuditlogDAO;
import com.sunrise.boss.business.resmanage.oprresmanage.auditlog.persistent.AuditlogListVO;

/**
 * <p>Title: AuditlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/resmanage/oprresmanage/auditlog/control/AuditlogControlBean"
 name="AuditlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class AuditlogControlBean extends AbstractControlBean
    implements AuditlogControl {

    public AuditlogVO doCreate(AuditlogVO vo, User user)
        throws Exception {
        try{
			AuditlogDAO dao = (AuditlogDAO) DAOFactory.build(AuditlogDAO.class, user.getCityid());
            // TODO  set the pk */
            return (AuditlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(AuditlogVO vo, User user)
        throws Exception {
        try{
			AuditlogDAO dao = (AuditlogDAO) DAOFactory.build(AuditlogDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public AuditlogVO doUpdate(AuditlogVO vo, User user)
        throws Exception {
        try{
			AuditlogDAO dao = (AuditlogDAO) DAOFactory.build(AuditlogDAO.class, user.getCityid());
            return (AuditlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public AuditlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			AuditlogDAO dao = (AuditlogDAO) DAOFactory.build(AuditlogDAO.class, user.getCityid());
        return (AuditlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(AuditlogListVO params, User user)
        throws Exception {
			AuditlogDAO dao = (AuditlogDAO) DAOFactory.build(AuditlogDAO.class, user.getCityid());
        return dao.query(params);
    }
}
