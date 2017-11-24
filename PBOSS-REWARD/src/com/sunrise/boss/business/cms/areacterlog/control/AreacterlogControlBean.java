/**
* auto-generated code
* Tue Oct 17 17:36:53 CST 2006
*/
package com.sunrise.boss.business.cms.areacterlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.areacterlog.persistent.AreacterlogVO;
import com.sunrise.boss.business.cms.areacterlog.persistent.AreacterlogDAO;
import com.sunrise.boss.business.cms.areacterlog.persistent.AreacterlogListVO;

/**
 * <p>Title: AreacterlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
 * @ejb.bean
 *    local-jndi-name="com/sunrise/boss/business/cms/areacterlog/control/AreacterlogControlBean"
 *    name="AreacterlogControl"
 *    view-type="local"
 *    type="Stateless"
 *
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class AreacterlogControlBean extends AbstractControlBean
    implements AreacterlogControl {
	private static final long serialVersionUID = -2374688407179976845L;
	public AreacterlogVO doCreate(AreacterlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         AreacterlogDAO dao = (AreacterlogDAO) DAOFactory.build(AreacterlogDAO.class, user);
            return (AreacterlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(AreacterlogVO vo, User user)
        throws Exception {
        try{
         AreacterlogDAO dao = (AreacterlogDAO) DAOFactory.build(AreacterlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public AreacterlogVO doUpdate(AreacterlogVO vo, User user)
        throws Exception {
        try{
         AreacterlogDAO dao = (AreacterlogDAO) DAOFactory.build(AreacterlogDAO.class, user);
            return (AreacterlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public AreacterlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         AreacterlogDAO dao = (AreacterlogDAO) DAOFactory.build(AreacterlogDAO.class, user);
        return (AreacterlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(AreacterlogListVO params, User user)
        throws Exception {
         AreacterlogDAO dao = (AreacterlogDAO) DAOFactory.build(AreacterlogDAO.class, user);
        return dao.query(params);
    }
}
