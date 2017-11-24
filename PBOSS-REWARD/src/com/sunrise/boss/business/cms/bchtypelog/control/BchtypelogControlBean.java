/**
* auto-generated code
* Tue Oct 17 17:36:16 CST 2006
*/
package com.sunrise.boss.business.cms.bchtypelog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bchtypelog.persistent.BchtypelogVO;
import com.sunrise.boss.business.cms.bchtypelog.persistent.BchtypelogDAO;
import com.sunrise.boss.business.cms.bchtypelog.persistent.BchtypelogListVO;

/**
 * <p>Title: BchtypelogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
 * @ejb.bean
 *    local-jndi-name="com/sunrise/boss/business/cms/bchtypelog/control/BchtypelogControlBean"
 *    name="BchtypelogControl"
 *    view-type="local"
 *    type="Stateless"
 *
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class BchtypelogControlBean extends AbstractControlBean
    implements BchtypelogControl {
	private static final long serialVersionUID = 3371637060079579457L;
	public BchtypelogVO doCreate(BchtypelogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         BchtypelogDAO dao = (BchtypelogDAO) DAOFactory.build(BchtypelogDAO.class, user);
            return (BchtypelogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(BchtypelogVO vo, User user)
        throws Exception {
        try{
         BchtypelogDAO dao = (BchtypelogDAO) DAOFactory.build(BchtypelogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BchtypelogVO doUpdate(BchtypelogVO vo, User user)
        throws Exception {
        try{
         BchtypelogDAO dao = (BchtypelogDAO) DAOFactory.build(BchtypelogDAO.class, user);
            return (BchtypelogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BchtypelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         BchtypelogDAO dao = (BchtypelogDAO) DAOFactory.build(BchtypelogDAO.class, user);
        return (BchtypelogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(BchtypelogListVO params, User user)
        throws Exception {
         BchtypelogDAO dao = (BchtypelogDAO) DAOFactory.build(BchtypelogDAO.class, user);
        return dao.query(params);
    }
}
