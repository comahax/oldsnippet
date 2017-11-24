/**
* auto-generated code
* Tue Oct 17 17:34:18 CST 2006
*/
package com.sunrise.boss.business.cms.custwtypelog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.custwtypelog.persistent.CustwtypelogVO;
import com.sunrise.boss.business.cms.custwtypelog.persistent.CustwtypelogDAO;
import com.sunrise.boss.business.cms.custwtypelog.persistent.CustwtypelogListVO;

/**
 * <p>Title: CustwtypelogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
 * @ejb.bean
 *    local-jndi-name="com/sunrise/boss/business/cms/custwtypelog/control/CustwtypelogControlBean"
 *    name="CustwtypelogControl"
 *    view-type="local"
 *    type="Stateless"
 *
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class CustwtypelogControlBean extends AbstractControlBean
    implements CustwtypelogControl {
	private static final long serialVersionUID = -5484293124091853312L;
	public CustwtypelogVO doCreate(CustwtypelogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         CustwtypelogDAO dao = (CustwtypelogDAO) DAOFactory.build(CustwtypelogDAO.class, user);
            return (CustwtypelogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(CustwtypelogVO vo, User user)
        throws Exception {
        try{
         CustwtypelogDAO dao = (CustwtypelogDAO) DAOFactory.build(CustwtypelogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CustwtypelogVO doUpdate(CustwtypelogVO vo, User user)
        throws Exception {
        try{
         CustwtypelogDAO dao = (CustwtypelogDAO) DAOFactory.build(CustwtypelogDAO.class, user);
            return (CustwtypelogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    
    public CustwtypelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         CustwtypelogDAO dao = (CustwtypelogDAO) DAOFactory.build(CustwtypelogDAO.class, user);
        return (CustwtypelogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(CustwtypelogListVO params, User user)
        throws Exception {
         CustwtypelogDAO dao = (CustwtypelogDAO) DAOFactory.build(CustwtypelogDAO.class, user);
        return dao.query(params);
    }
}
