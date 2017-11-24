/**
* auto-generated code
* Wed Oct 18 14:55:37 CST 2006
*/
package com.sunrise.boss.business.cms.wayacctlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.wayacctlog.persistent.WayacctlogVO;
import com.sunrise.boss.business.cms.wayacctlog.persistent.WayacctlogDAO;
import com.sunrise.boss.business.cms.wayacctlog.persistent.WayacctlogListVO;

/**
 * <p>Title: WayacctlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
 * @ejb.bean
 *    local-jndi-name="com/sunrise/boss/business/cms/wayacctlog/control/WayacctlogControlBean"
 *    name="WayacctlogControl"
 *    view-type="local"
 *    type="Stateless"
 *
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class WayacctlogControlBean extends AbstractControlBean
    implements WayacctlogControl {
	private static final long serialVersionUID = -522165031446534117L;
	public WayacctlogVO doCreate(WayacctlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         WayacctlogDAO dao = (WayacctlogDAO) DAOFactory.build(WayacctlogDAO.class, user);
            return (WayacctlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(WayacctlogVO vo, User user)
        throws Exception {
        try{
         WayacctlogDAO dao = (WayacctlogDAO) DAOFactory.build(WayacctlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WayacctlogVO doUpdate(WayacctlogVO vo, User user)
        throws Exception {
        try{
         WayacctlogDAO dao = (WayacctlogDAO) DAOFactory.build(WayacctlogDAO.class, user);
            return (WayacctlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WayacctlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         WayacctlogDAO dao = (WayacctlogDAO) DAOFactory.build(WayacctlogDAO.class, user);
        return (WayacctlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(WayacctlogListVO params, User user)
        throws Exception {
         WayacctlogDAO dao = (WayacctlogDAO) DAOFactory.build(WayacctlogDAO.class, user);
        return dao.query(params);
    }
}
