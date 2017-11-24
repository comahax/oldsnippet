/**
* auto-generated code
* Sun Nov 29 14:16:41 CST 2009
*/
package com.sunrise.boss.business.cms.examine.coefrevision.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.coefrevision.persistent.CoefrevisionVO;
import com.sunrise.boss.business.cms.examine.coefrevision.persistent.CoefrevisionDAO;
import com.sunrise.boss.business.cms.examine.coefrevision.persistent.CoefrevisionListVO;

/**
 * <p>Title: CoefrevisionControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/coefrevision/control/CoefrevisionControlBean"
 name="CoefrevisionControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CoefrevisionControlBean extends AbstractControlBean
    implements CoefrevisionControl {

    public CoefrevisionVO doCreate(CoefrevisionVO vo, User user)
        throws Exception {
        try{
			CoefrevisionDAO dao = (CoefrevisionDAO) DAOFactory.build(CoefrevisionDAO.class, user);
            // TODO  set the pk */
            return (CoefrevisionVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(CoefrevisionVO vo, User user)
        throws Exception {
        try{
			CoefrevisionDAO dao = (CoefrevisionDAO) DAOFactory.build(CoefrevisionDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public CoefrevisionVO doUpdate(CoefrevisionVO vo, User user)
        throws Exception {
        try{
			CoefrevisionDAO dao = (CoefrevisionDAO) DAOFactory.build(CoefrevisionDAO.class, user);
            return (CoefrevisionVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public CoefrevisionVO doFindByPk(Serializable pk, User user)
        throws Exception {
			CoefrevisionDAO dao = (CoefrevisionDAO) DAOFactory.build(CoefrevisionDAO.class, user);
        return (CoefrevisionVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(CoefrevisionListVO params, User user)
        throws Exception {
			CoefrevisionDAO dao = (CoefrevisionDAO) DAOFactory.build(CoefrevisionDAO.class, user);
        return dao.query(params);
    }
}
