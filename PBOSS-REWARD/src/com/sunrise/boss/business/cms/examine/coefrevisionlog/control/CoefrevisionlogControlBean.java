/**
* auto-generated code
* Sun Nov 29 14:17:13 CST 2009
*/
package com.sunrise.boss.business.cms.examine.coefrevisionlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.coefrevisionlog.persistent.CoefrevisionlogVO;
import com.sunrise.boss.business.cms.examine.coefrevisionlog.persistent.CoefrevisionlogDAO;
import com.sunrise.boss.business.cms.examine.coefrevisionlog.persistent.CoefrevisionlogListVO;

/**
 * <p>Title: CoefrevisionlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/coefrevisionlog/control/CoefrevisionlogControlBean"
 name="CoefrevisionlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CoefrevisionlogControlBean extends AbstractControlBean
    implements CoefrevisionlogControl {

    public CoefrevisionlogVO doCreate(CoefrevisionlogVO vo, User user)
        throws Exception {
        try{
			CoefrevisionlogDAO dao = (CoefrevisionlogDAO) DAOFactory.build(CoefrevisionlogDAO.class, user);
            // TODO  set the pk */
            return (CoefrevisionlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(CoefrevisionlogVO vo, User user)
        throws Exception {
        try{
			CoefrevisionlogDAO dao = (CoefrevisionlogDAO) DAOFactory.build(CoefrevisionlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public CoefrevisionlogVO doUpdate(CoefrevisionlogVO vo, User user)
        throws Exception {
        try{
			CoefrevisionlogDAO dao = (CoefrevisionlogDAO) DAOFactory.build(CoefrevisionlogDAO.class, user);
            return (CoefrevisionlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public CoefrevisionlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			CoefrevisionlogDAO dao = (CoefrevisionlogDAO) DAOFactory.build(CoefrevisionlogDAO.class, user);
        return (CoefrevisionlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(CoefrevisionlogListVO params, User user)
        throws Exception {
			CoefrevisionlogDAO dao = (CoefrevisionlogDAO) DAOFactory.build(CoefrevisionlogDAO.class, user);
        return dao.query(params);
    }
}
