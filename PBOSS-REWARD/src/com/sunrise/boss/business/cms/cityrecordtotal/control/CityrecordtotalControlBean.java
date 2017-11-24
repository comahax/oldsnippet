/**
* auto-generated code
* Tue Mar 13 17:29:11 CST 2012
*/
package com.sunrise.boss.business.cms.cityrecordtotal.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cityrecordtotal.persistent.CityrecordtotalVO;
import com.sunrise.boss.business.cms.cityrecordtotal.persistent.CityrecordtotalDAO;
import com.sunrise.boss.business.cms.cityrecordtotal.persistent.CityrecordtotalListVO;

/**
 * <p>Title: CityrecordtotalControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/cityrecordtotal/control/CityrecordtotalControlBean"
 name="CityrecordtotalControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CityrecordtotalControlBean extends AbstractControlBean
    implements CityrecordtotalControl {

    public CityrecordtotalVO doCreate(CityrecordtotalVO vo, User user)
        throws Exception {
        try{
			CityrecordtotalDAO dao = (CityrecordtotalDAO) DAOFactory.build(CityrecordtotalDAO.class, user);
            // TODO  set the pk */
            return (CityrecordtotalVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(CityrecordtotalVO vo, User user)
        throws Exception {
        try{
			CityrecordtotalDAO dao = (CityrecordtotalDAO) DAOFactory.build(CityrecordtotalDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public CityrecordtotalVO doUpdate(CityrecordtotalVO vo, User user)
        throws Exception {
        try{
			CityrecordtotalDAO dao = (CityrecordtotalDAO) DAOFactory.build(CityrecordtotalDAO.class, user);
            return (CityrecordtotalVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public CityrecordtotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
			CityrecordtotalDAO dao = (CityrecordtotalDAO) DAOFactory.build(CityrecordtotalDAO.class, user);
        return (CityrecordtotalVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(CityrecordtotalListVO params, User user)
        throws Exception {
			CityrecordtotalDAO dao = (CityrecordtotalDAO) DAOFactory.build(CityrecordtotalDAO.class, user);
        return dao.query(params);
    }
    
    public DataPackage doQuerycnt(CityrecordtotalListVO params, User user)
    throws Exception {
		CityrecordtotalDAO dao = (CityrecordtotalDAO) DAOFactory.build(CityrecordtotalDAO.class, user);
    return dao.doQuerycnt(params, user);
}
}
