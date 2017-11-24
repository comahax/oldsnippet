/**
* auto-generated code
* Thu Oct 23 12:58:00 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtyoperationlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyoperationlog.persistent.ZjtyOperationlogVO;
import com.sunrise.boss.business.cms.zjty.zjtyoperationlog.persistent.ZjtyOperationlogDAO;
import com.sunrise.boss.business.cms.zjty.zjtyoperationlog.persistent.ZjtyOperationlogListVO;

/**
 * <p>Title: ZjtyOperationlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtyoperationlog/control/ZjtyOperationlogControlBean"
 name="ZjtyOperationlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyOperationlogControlBean extends AbstractControlBean
    implements ZjtyOperationlogControl {

    public ZjtyOperationlogVO doCreate(ZjtyOperationlogVO vo, User user)
        throws Exception {
        try{
			ZjtyOperationlogDAO dao = (ZjtyOperationlogDAO) DAOFactory.build(ZjtyOperationlogDAO.class, user);
            // TODO  set the pk */
            return (ZjtyOperationlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ZjtyOperationlogVO vo, User user)
        throws Exception {
        try{
			ZjtyOperationlogDAO dao = (ZjtyOperationlogDAO) DAOFactory.build(ZjtyOperationlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyOperationlogVO doUpdate(ZjtyOperationlogVO vo, User user)
        throws Exception {
        try{
			ZjtyOperationlogDAO dao = (ZjtyOperationlogDAO) DAOFactory.build(ZjtyOperationlogDAO.class, user);
            return (ZjtyOperationlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyOperationlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyOperationlogDAO dao = (ZjtyOperationlogDAO) DAOFactory.build(ZjtyOperationlogDAO.class, user);
        return (ZjtyOperationlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ZjtyOperationlogListVO params, User user)
        throws Exception {
			ZjtyOperationlogDAO dao = (ZjtyOperationlogDAO) DAOFactory.build(ZjtyOperationlogDAO.class, user);
        return dao.query(params);
    }
}
