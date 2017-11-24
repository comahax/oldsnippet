/**
* auto-generated code
* Wed Oct 18 14:53:55 CST 2006
*/
package com.sunrise.boss.business.cms.entitybchlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.entitybchlog.persistent.EntitybchlogVO;
import com.sunrise.boss.business.cms.entitybchlog.persistent.EntitybchlogDAO;
import com.sunrise.boss.business.cms.entitybchlog.persistent.EntitybchlogListVO;

/**
 * <p>Title: EntitybchlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
 * @ejb.bean
 *    local-jndi-name="com/sunrise/boss/business/cms/entitybchlog/control/EntitybchlogControlBean"
 *    name="EntitybchlogControl"
 *    view-type="local"
 *    type="Stateless"
 *
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class EntitybchlogControlBean extends AbstractControlBean
    implements EntitybchlogControl {
	private static final long serialVersionUID = 5386983326521403713L;
	public EntitybchlogVO doCreate(EntitybchlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         EntitybchlogDAO dao = (EntitybchlogDAO) DAOFactory.build(EntitybchlogDAO.class, user);
            return (EntitybchlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(EntitybchlogVO vo, User user)
        throws Exception {
        try{
         EntitybchlogDAO dao = (EntitybchlogDAO) DAOFactory.build(EntitybchlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public EntitybchlogVO doUpdate(EntitybchlogVO vo, User user)
        throws Exception {
        try{
         EntitybchlogDAO dao = (EntitybchlogDAO) DAOFactory.build(EntitybchlogDAO.class, user);
            return (EntitybchlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public EntitybchlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         EntitybchlogDAO dao = (EntitybchlogDAO) DAOFactory.build(EntitybchlogDAO.class, user);
        return (EntitybchlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(EntitybchlogListVO params, User user)
        throws Exception {
         EntitybchlogDAO dao = (EntitybchlogDAO) DAOFactory.build(EntitybchlogDAO.class, user);
        return dao.query(params);
    }
}
