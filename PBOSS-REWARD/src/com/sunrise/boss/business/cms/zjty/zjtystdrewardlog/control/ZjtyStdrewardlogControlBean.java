/**
* auto-generated code
* Tue Oct 28 11:33:15 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtystdrewardlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardlog.persistent.ZjtyStdrewardlogVO;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardlog.persistent.ZjtyStdrewardlogDAO;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardlog.persistent.ZjtyStdrewardlogListVO;

/**
 * <p>Title: ZjtyStdrewardlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtystdrewardlog/control/ZjtyStdrewardlogControlBean"
 name="ZjtyStdrewardlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyStdrewardlogControlBean extends AbstractControlBean
    implements ZjtyStdrewardlogControl {

    public ZjtyStdrewardlogVO doCreate(ZjtyStdrewardlogVO vo, User user)
        throws Exception {
        try{
			ZjtyStdrewardlogDAO dao = (ZjtyStdrewardlogDAO) DAOFactory.build(ZjtyStdrewardlogDAO.class, user);
            // TODO  set the pk */
            return (ZjtyStdrewardlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ZjtyStdrewardlogVO vo, User user)
        throws Exception {
        try{
			ZjtyStdrewardlogDAO dao = (ZjtyStdrewardlogDAO) DAOFactory.build(ZjtyStdrewardlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyStdrewardlogVO doUpdate(ZjtyStdrewardlogVO vo, User user)
        throws Exception {
        try{
			ZjtyStdrewardlogDAO dao = (ZjtyStdrewardlogDAO) DAOFactory.build(ZjtyStdrewardlogDAO.class, user);
            return (ZjtyStdrewardlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyStdrewardlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyStdrewardlogDAO dao = (ZjtyStdrewardlogDAO) DAOFactory.build(ZjtyStdrewardlogDAO.class, user);
        return (ZjtyStdrewardlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ZjtyStdrewardlogListVO params, User user)
        throws Exception {
			ZjtyStdrewardlogDAO dao = (ZjtyStdrewardlogDAO) DAOFactory.build(ZjtyStdrewardlogDAO.class, user);
        return dao.query(params);
    }
}
