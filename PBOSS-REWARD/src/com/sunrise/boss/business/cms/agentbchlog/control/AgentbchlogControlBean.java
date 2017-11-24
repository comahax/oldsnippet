/**
* auto-generated code
* Wed Oct 18 14:53:09 CST 2006
*/
package com.sunrise.boss.business.cms.agentbchlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.agentbchlog.persistent.AgentbchlogVO;
import com.sunrise.boss.business.cms.agentbchlog.persistent.AgentbchlogDAO;
import com.sunrise.boss.business.cms.agentbchlog.persistent.AgentbchlogListVO;

/**
 * <p>Title: AgentbchlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
 * @ejb.bean
 *    local-jndi-name="com/sunrise/boss/business/cms/agentbchlog/control/AgentbchlogControlBean"
 *    name="AgentbchlogControl"
 *    view-type="local"
 *    type="Stateless"
 *
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class AgentbchlogControlBean extends AbstractControlBean
    implements AgentbchlogControl {
	private static final long serialVersionUID = -5365431585965478106L;
	public AgentbchlogVO doCreate(AgentbchlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         AgentbchlogDAO dao = (AgentbchlogDAO) DAOFactory.build(AgentbchlogDAO.class, user);
            return (AgentbchlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(AgentbchlogVO vo, User user)
        throws Exception {
        try{
         AgentbchlogDAO dao = (AgentbchlogDAO) DAOFactory.build(AgentbchlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public AgentbchlogVO doUpdate(AgentbchlogVO vo, User user)
        throws Exception {
        try{
         AgentbchlogDAO dao = (AgentbchlogDAO) DAOFactory.build(AgentbchlogDAO.class, user);
            return (AgentbchlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public AgentbchlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         AgentbchlogDAO dao = (AgentbchlogDAO) DAOFactory.build(AgentbchlogDAO.class, user);
        return (AgentbchlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(AgentbchlogListVO params, User user)
        throws Exception {
         AgentbchlogDAO dao = (AgentbchlogDAO) DAOFactory.build(AgentbchlogDAO.class, user);
        return dao.query(params);
    }
}
