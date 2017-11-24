/**
* auto-generated code
* Wed Oct 18 14:48:22 CST 2006
*/
package com.sunrise.boss.business.cms.waylog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waylog.persistent.WaylogVO;
import com.sunrise.boss.business.cms.waylog.persistent.WaylogDAO;
import com.sunrise.boss.business.cms.waylog.persistent.WaylogListVO;

/**
 * <p>Title: WaylogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
 * @ejb.bean
 *    local-jndi-name="com/sunrise/boss/business/cms/waylog/control/WaylogControlBean"
 *    name="WaylogControl"
 *    view-type="local"
 *    type="Stateless"
 *
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class WaylogControlBean extends AbstractControlBean
    implements WaylogControl {
	private static final long serialVersionUID = -4063396310081388973L;
	public WaylogVO doCreate(WaylogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         WaylogDAO dao = (WaylogDAO) DAOFactory.build(WaylogDAO.class, user);
            return (WaylogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(WaylogVO vo, User user)
        throws Exception {
        try{
         WaylogDAO dao = (WaylogDAO) DAOFactory.build(WaylogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WaylogVO doUpdate(WaylogVO vo, User user)
        throws Exception {
        try{
         WaylogDAO dao = (WaylogDAO) DAOFactory.build(WaylogDAO.class, user);
            return (WaylogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WaylogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         WaylogDAO dao = (WaylogDAO) DAOFactory.build(WaylogDAO.class, user);
        return (WaylogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(WaylogListVO params, User user)
        throws Exception {
         WaylogDAO dao = (WaylogDAO) DAOFactory.build(WaylogDAO.class, user);
        return dao.query(params);
    }
}
