/**
* auto-generated code
* Wed Feb 24 11:50:56 CST 2010
*/
package com.sunrise.boss.business.cms.waystarcsale.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waystarcsale.persistent.WaystarcsaleVO;
import com.sunrise.boss.business.cms.waystarcsale.persistent.WaystarcsaleDAO;
import com.sunrise.boss.business.cms.waystarcsale.persistent.WaystarcsaleListVO;

/**
 * <p>Title: WaystarcsaleControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/waystarcsale/control/WaystarcsaleControlBean"
 name="WaystarcsaleControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class WaystarcsaleControlBean extends AbstractControlBean
    implements WaystarcsaleControl {

    public WaystarcsaleVO doCreate(WaystarcsaleVO vo, User user)
        throws Exception {
        try{
			WaystarcsaleDAO dao = (WaystarcsaleDAO) DAOFactory.build(WaystarcsaleDAO.class, user);
            // TODO  set the pk */
            return (WaystarcsaleVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(WaystarcsaleVO vo, User user)
        throws Exception {
        try{
			WaystarcsaleDAO dao = (WaystarcsaleDAO) DAOFactory.build(WaystarcsaleDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public WaystarcsaleVO doUpdate(WaystarcsaleVO vo, User user)
        throws Exception {
        try{
			WaystarcsaleDAO dao = (WaystarcsaleDAO) DAOFactory.build(WaystarcsaleDAO.class, user);
            return (WaystarcsaleVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public WaystarcsaleVO doFindByPk(Serializable pk, User user)
        throws Exception {
			WaystarcsaleDAO dao = (WaystarcsaleDAO) DAOFactory.build(WaystarcsaleDAO.class, user);
        return (WaystarcsaleVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(WaystarcsaleListVO params, User user)
        throws Exception {
			WaystarcsaleDAO dao = (WaystarcsaleDAO) DAOFactory.build(WaystarcsaleDAO.class, user);
        return dao.query(params);
    }
}
