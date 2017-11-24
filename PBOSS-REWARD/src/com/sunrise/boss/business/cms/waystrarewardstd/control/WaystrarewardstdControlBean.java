/**
* auto-generated code
* Fri Jul 08 11:36:28 CST 2011
*/
package com.sunrise.boss.business.cms.waystrarewardstd.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waystrarewardstd.persistent.WaystrarewardstdVO;
import com.sunrise.boss.business.cms.waystrarewardstd.persistent.WaystrarewardstdDAO;
import com.sunrise.boss.business.cms.waystrarewardstd.persistent.WaystrarewardstdListVO;

/**
 * <p>Title: WaystrarewardstdControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/waystrarewardstd/control/WaystrarewardstdControlBean"
 name="WaystrarewardstdControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class WaystrarewardstdControlBean extends AbstractControlBean
    implements WaystrarewardstdControl {

    public WaystrarewardstdVO doCreate(WaystrarewardstdVO vo, User user)
        throws Exception {
        try{
			WaystrarewardstdDAO dao = (WaystrarewardstdDAO) DAOFactory.build(WaystrarewardstdDAO.class, user);
            // TODO  set the pk */
            return (WaystrarewardstdVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(WaystrarewardstdVO vo, User user)
        throws Exception {
        try{
			WaystrarewardstdDAO dao = (WaystrarewardstdDAO) DAOFactory.build(WaystrarewardstdDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public WaystrarewardstdVO doUpdate(WaystrarewardstdVO vo, User user)
        throws Exception {
        try{
			WaystrarewardstdDAO dao = (WaystrarewardstdDAO) DAOFactory.build(WaystrarewardstdDAO.class, user);
            return (WaystrarewardstdVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public WaystrarewardstdVO doFindByPk(Serializable pk, User user)
        throws Exception {
			WaystrarewardstdDAO dao = (WaystrarewardstdDAO) DAOFactory.build(WaystrarewardstdDAO.class, user);
        return (WaystrarewardstdVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(WaystrarewardstdListVO params, User user)
        throws Exception {
			WaystrarewardstdDAO dao = (WaystrarewardstdDAO) DAOFactory.build(WaystrarewardstdDAO.class, user);
        return dao.query(params);
    }
}
