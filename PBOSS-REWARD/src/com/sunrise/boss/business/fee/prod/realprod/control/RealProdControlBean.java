/**
* auto-generated code
* Tue Jan 08 15:32:44 CST 2008
*/
package com.sunrise.boss.business.fee.prod.realprod.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.fee.prod.realprod.persistent.RealProdVO;
import com.sunrise.boss.business.fee.prod.realprod.persistent.RealProdDAO;
import com.sunrise.boss.business.fee.prod.realprod.persistent.RealProdListVO;

/**
 * <p>Title: RealProdControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wkx
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/fee/prod/realprod/control/RealProdControlBean"
 name="RealProdControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RealProdControlBean extends AbstractControlBean
    implements RealProdControl {

    public RealProdVO doCreate(RealProdVO vo, User user)
        throws Exception {
        try{
			RealProdDAO dao = (RealProdDAO) DAOFactory.build(RealProdDAO.class, user.getCityid());
            // TODO  set the pk */
            return (RealProdVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RealProdVO vo, User user)
        throws Exception {
        try{
			RealProdDAO dao = (RealProdDAO) DAOFactory.build(RealProdDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RealProdVO doUpdate(RealProdVO vo, User user)
        throws Exception {
        try{
			RealProdDAO dao = (RealProdDAO) DAOFactory.build(RealProdDAO.class, user.getCityid());
            return (RealProdVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RealProdVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RealProdDAO dao = (RealProdDAO) DAOFactory.build(RealProdDAO.class, user.getCityid());
        return (RealProdVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RealProdListVO params, User user)
        throws Exception {
			RealProdDAO dao = (RealProdDAO) DAOFactory.build(RealProdDAO.class, user.getCityid());
        return dao.query(params);
    }
}
