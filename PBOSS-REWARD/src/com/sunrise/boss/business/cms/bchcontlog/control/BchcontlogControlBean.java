/**
* auto-generated code
* Wed Oct 18 14:52:06 CST 2006
*/
package com.sunrise.boss.business.cms.bchcontlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bchcontlog.persistent.BchcontlogVO;
import com.sunrise.boss.business.cms.bchcontlog.persistent.BchcontlogDAO;
import com.sunrise.boss.business.cms.bchcontlog.persistent.BchcontlogListVO;

/**
 * <p>Title: BchcontlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
 * @ejb.bean
 *    local-jndi-name="com/sunrise/boss/business/cms/bchcontlog/control/BchcontlogControlBean"
 *    name="BchcontlogControl"
 *    view-type="local"
 *    type="Stateless"
 *
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class BchcontlogControlBean extends AbstractControlBean
    implements BchcontlogControl {
	private static final long serialVersionUID = 2454066117200382175L;
	public BchcontlogVO doCreate(BchcontlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         BchcontlogDAO dao = (BchcontlogDAO) DAOFactory.build(BchcontlogDAO.class, user);
            return (BchcontlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(BchcontlogVO vo, User user)
        throws Exception {
        try{
         BchcontlogDAO dao = (BchcontlogDAO) DAOFactory.build(BchcontlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BchcontlogVO doUpdate(BchcontlogVO vo, User user)
        throws Exception {
        try{
         BchcontlogDAO dao = (BchcontlogDAO) DAOFactory.build(BchcontlogDAO.class, user);
            return (BchcontlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BchcontlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         BchcontlogDAO dao = (BchcontlogDAO) DAOFactory.build(BchcontlogDAO.class, user);
        return (BchcontlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(BchcontlogListVO params, User user)
        throws Exception {
         BchcontlogDAO dao = (BchcontlogDAO) DAOFactory.build(BchcontlogDAO.class, user);
        return dao.query(params);
    }
}
