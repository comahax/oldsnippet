/**
* auto-generated code
* Tue Oct 17 17:31:29 CST 2006
*/
package com.sunrise.boss.business.cms.waytypelog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waytypelog.persistent.WaytypelogVO;
import com.sunrise.boss.business.cms.waytypelog.persistent.WaytypelogDAO;
import com.sunrise.boss.business.cms.waytypelog.persistent.WaytypelogListVO;

/**
 * <p>Title: WaytypelogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
 * @ejb.bean
 *    local-jndi-name="com/sunrise/boss/business/cms/waytypelog/control/WaytypelogControlBean"
 *    name="WaytypelogControl"
 *    view-type="local"
 *    type="Stateless"
 *
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class WaytypelogControlBean extends AbstractControlBean
    implements WaytypelogControl {
	private static final long serialVersionUID = 3798697676933307078L;
	public WaytypelogVO doCreate(WaytypelogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         WaytypelogDAO dao = (WaytypelogDAO) DAOFactory.build(WaytypelogDAO.class, user);
            return (WaytypelogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(WaytypelogVO vo, User user)
        throws Exception {
        try{
         WaytypelogDAO dao = (WaytypelogDAO) DAOFactory.build(WaytypelogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WaytypelogVO doUpdate(WaytypelogVO vo, User user)
        throws Exception {
        try{
         WaytypelogDAO dao = (WaytypelogDAO) DAOFactory.build(WaytypelogDAO.class, user);
            return (WaytypelogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WaytypelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         WaytypelogDAO dao = (WaytypelogDAO) DAOFactory.build(WaytypelogDAO.class, user);
        return (WaytypelogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(WaytypelogListVO params, User user)
        throws Exception {
         WaytypelogDAO dao = (WaytypelogDAO) DAOFactory.build(WaytypelogDAO.class, user);
        return dao.query(params);
    }
}
