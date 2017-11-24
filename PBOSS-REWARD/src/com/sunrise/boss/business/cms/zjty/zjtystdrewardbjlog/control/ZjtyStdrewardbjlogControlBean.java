/**
* auto-generated code
* Tue Oct 28 11:36:29 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtystdrewardbjlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbjlog.persistent.ZjtyStdrewardbjlogVO;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbjlog.persistent.ZjtyStdrewardbjlogDAO;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbjlog.persistent.ZjtyStdrewardbjlogListVO;

/**
 * <p>Title: ZjtyStdrewardbjlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtystdrewardbjlog/control/ZjtyStdrewardbjlogControlBean"
 name="ZjtyStdrewardbjlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyStdrewardbjlogControlBean extends AbstractControlBean
    implements ZjtyStdrewardbjlogControl {

    public ZjtyStdrewardbjlogVO doCreate(ZjtyStdrewardbjlogVO vo, User user)
        throws Exception {
        try{
			ZjtyStdrewardbjlogDAO dao = (ZjtyStdrewardbjlogDAO) DAOFactory.build(ZjtyStdrewardbjlogDAO.class, user);
            // TODO  set the pk */
            return (ZjtyStdrewardbjlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ZjtyStdrewardbjlogVO vo, User user)
        throws Exception {
        try{
			ZjtyStdrewardbjlogDAO dao = (ZjtyStdrewardbjlogDAO) DAOFactory.build(ZjtyStdrewardbjlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyStdrewardbjlogVO doUpdate(ZjtyStdrewardbjlogVO vo, User user)
        throws Exception {
        try{
			ZjtyStdrewardbjlogDAO dao = (ZjtyStdrewardbjlogDAO) DAOFactory.build(ZjtyStdrewardbjlogDAO.class, user);
            return (ZjtyStdrewardbjlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyStdrewardbjlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyStdrewardbjlogDAO dao = (ZjtyStdrewardbjlogDAO) DAOFactory.build(ZjtyStdrewardbjlogDAO.class, user);
        return (ZjtyStdrewardbjlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ZjtyStdrewardbjlogListVO params, User user)
        throws Exception {
			ZjtyStdrewardbjlogDAO dao = (ZjtyStdrewardbjlogDAO) DAOFactory.build(ZjtyStdrewardbjlogDAO.class, user);
        return dao.query(params);
    }
}
