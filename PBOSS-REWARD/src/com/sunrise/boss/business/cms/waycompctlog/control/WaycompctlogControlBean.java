/**
* auto-generated code
* Wed Oct 18 14:54:55 CST 2006
*/
package com.sunrise.boss.business.cms.waycompctlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waycompctlog.persistent.WaycompctlogVO;
import com.sunrise.boss.business.cms.waycompctlog.persistent.WaycompctlogDAO;
import com.sunrise.boss.business.cms.waycompctlog.persistent.WaycompctlogListVO;

/**
 * <p>Title: WaycompctlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/waycompctlog/control/WaycompctlogControlBean"
*    name="WaycompctlogControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class WaycompctlogControlBean extends AbstractControlBean
    implements WaycompctlogControl {
	private static final long serialVersionUID = -1364659419274725375L;
	public WaycompctlogVO doCreate(WaycompctlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         WaycompctlogDAO dao = (WaycompctlogDAO) DAOFactory.build(WaycompctlogDAO.class, user);
            return (WaycompctlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(WaycompctlogVO vo, User user)
        throws Exception {
        try{
         WaycompctlogDAO dao = (WaycompctlogDAO) DAOFactory.build(WaycompctlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WaycompctlogVO doUpdate(WaycompctlogVO vo, User user)
        throws Exception {
        try{
         WaycompctlogDAO dao = (WaycompctlogDAO) DAOFactory.build(WaycompctlogDAO.class, user);
            return (WaycompctlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WaycompctlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         WaycompctlogDAO dao = (WaycompctlogDAO) DAOFactory.build(WaycompctlogDAO.class, user);
        return (WaycompctlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(WaycompctlogListVO params, User user)
        throws Exception {
         WaycompctlogDAO dao = (WaycompctlogDAO) DAOFactory.build(WaycompctlogDAO.class, user);
        return dao.query(params);
    }
}
