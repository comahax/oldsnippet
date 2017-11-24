/**
* auto-generated code
* Mon Jun 29 11:25:27 CST 2009
*/
package com.sunrise.boss.business.cms.nasrwdtotal.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.nasrwdtotal.persistent.NasrwdtotalVO;
import com.sunrise.boss.business.cms.nasrwdtotal.persistent.NasrwdtotalDAO;
import com.sunrise.boss.business.cms.nasrwdtotal.persistent.NasrwdtotalListVO;


/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/nasrwdtotal/control/NasrwdtotalControlBean"
 *           name="NasrwdtotalControl"  view-type="local"  type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */

public class NasrwdtotalControlBean extends AbstractControlBean
    implements NasrwdtotalControl {

    public NasrwdtotalVO doCreate(NasrwdtotalVO vo, User user)
        throws Exception {
        try{
			NasrwdtotalDAO dao = (NasrwdtotalDAO) DAOFactory.build(NasrwdtotalDAO.class, user.getCityid());
            // TODO  set the pk */
            return (NasrwdtotalVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(NasrwdtotalVO vo, User user)
        throws Exception {
        try{
			NasrwdtotalDAO dao = (NasrwdtotalDAO) DAOFactory.build(NasrwdtotalDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public NasrwdtotalVO doUpdate(NasrwdtotalVO vo, User user)
        throws Exception {
        try{
			NasrwdtotalDAO dao = (NasrwdtotalDAO) DAOFactory.build(NasrwdtotalDAO.class, user.getCityid());
            return (NasrwdtotalVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public NasrwdtotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
			NasrwdtotalDAO dao = (NasrwdtotalDAO) DAOFactory.build(NasrwdtotalDAO.class, user.getCityid());
        return (NasrwdtotalVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(NasrwdtotalListVO params, User user)
        throws Exception {
			NasrwdtotalDAO dao = (NasrwdtotalDAO) DAOFactory.build(NasrwdtotalDAO.class, user.getCityid());
        return dao.query(params);
    }
}
