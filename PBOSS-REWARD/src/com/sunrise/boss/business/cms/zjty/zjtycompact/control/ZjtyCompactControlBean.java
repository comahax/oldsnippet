/**
* auto-generated code
* Wed Dec 28 14:39:42 CST 2011
*/
package com.sunrise.boss.business.cms.zjty.zjtycompact.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtycompact.persistent.ZjtyCompactVO;
import com.sunrise.boss.business.cms.zjty.zjtycompact.persistent.ZjtyCompactDAO;
import com.sunrise.boss.business.cms.zjty.zjtycompact.persistent.ZjtyCompactListVO;

/**
 * <p>Title: ZjtyCompactControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtycompact/control/ZjtyCompactControlBean"
 name="ZjtyCompactControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyCompactControlBean extends AbstractControlBean
    implements ZjtyCompactControl {

    public ZjtyCompactVO doCreate(ZjtyCompactVO vo, User user)
        throws Exception {
        try{
			ZjtyCompactDAO dao = (ZjtyCompactDAO) DAOFactory.build(ZjtyCompactDAO.class, user);
            // TODO  set the pk */
            return (ZjtyCompactVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ZjtyCompactVO vo, User user)
        throws Exception {
        try{
			ZjtyCompactDAO dao = (ZjtyCompactDAO) DAOFactory.build(ZjtyCompactDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyCompactVO doUpdate(ZjtyCompactVO vo, User user)
        throws Exception {
        try{
			ZjtyCompactDAO dao = (ZjtyCompactDAO) DAOFactory.build(ZjtyCompactDAO.class, user);
            return (ZjtyCompactVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyCompactVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyCompactDAO dao = (ZjtyCompactDAO) DAOFactory.build(ZjtyCompactDAO.class, user);
        return (ZjtyCompactVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ZjtyCompactListVO params, User user)
        throws Exception {
			ZjtyCompactDAO dao = (ZjtyCompactDAO) DAOFactory.build(ZjtyCompactDAO.class, user);
        return dao.query(params);
    }
}
