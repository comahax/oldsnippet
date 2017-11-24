/**
* auto-generated code
* Tue Oct 17 17:46:15 CST 2006
*/
package com.sunrise.boss.business.cms.cntycomlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cntycomlog.persistent.CntycomlogVO;
import com.sunrise.boss.business.cms.cntycomlog.persistent.CntycomlogDAO;
import com.sunrise.boss.business.cms.cntycomlog.persistent.CntycomlogListVO;

/**
 * <p>Title: CntycomlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
 * @ejb.bean
 *    local-jndi-name="com/sunrise/boss/business/cms/cntycomlog/control/CntycomlogControlBean"
 *    name="CntycomlogControl"
 *    view-type="local"
 *    type="Stateless"
 *
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class CntycomlogControlBean extends AbstractControlBean
    implements CntycomlogControl {
	private static final long serialVersionUID = -6766588304016518558L;
	public CntycomlogVO doCreate(CntycomlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         CntycomlogDAO dao = (CntycomlogDAO) DAOFactory.build(CntycomlogDAO.class, user);
            return (CntycomlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(CntycomlogVO vo, User user)
        throws Exception {
        try{
         CntycomlogDAO dao = (CntycomlogDAO) DAOFactory.build(CntycomlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CntycomlogVO doUpdate(CntycomlogVO vo, User user)
        throws Exception {
        try{
         CntycomlogDAO dao = (CntycomlogDAO) DAOFactory.build(CntycomlogDAO.class, user);
            return (CntycomlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CntycomlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         CntycomlogDAO dao = (CntycomlogDAO) DAOFactory.build(CntycomlogDAO.class, user);
        return (CntycomlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(CntycomlogListVO params, User user)
        throws Exception {
         CntycomlogDAO dao = (CntycomlogDAO) DAOFactory.build(CntycomlogDAO.class, user);
        return dao.query(params);
    }
}
