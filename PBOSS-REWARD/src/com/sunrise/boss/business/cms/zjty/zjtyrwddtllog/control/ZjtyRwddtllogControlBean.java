/**
* auto-generated code
* Tue Dec 29 15:07:40 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtyrwddtllog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyrwddtllog.persistent.ZjtyRwddtllogVO;
import com.sunrise.boss.business.cms.zjty.zjtyrwddtllog.persistent.ZjtyRwddtllogDAO;
import com.sunrise.boss.business.cms.zjty.zjtyrwddtllog.persistent.ZjtyRwddtllogListVO;

/**
 * <p>Title: ZjtyRwddtllogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtyrwddtllog/control/ZjtyRwddtllogControlBean"
 name="ZjtyRwddtllogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyRwddtllogControlBean extends AbstractControlBean
    implements ZjtyRwddtllogControl {

    public ZjtyRwddtllogVO doCreate(ZjtyRwddtllogVO vo, User user)
        throws Exception {
        try{
			ZjtyRwddtllogDAO dao = (ZjtyRwddtllogDAO) DAOFactory.build(ZjtyRwddtllogDAO.class, user);
            // TODO  set the pk */
            return (ZjtyRwddtllogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ZjtyRwddtllogVO vo, User user)
        throws Exception {
        try{
			ZjtyRwddtllogDAO dao = (ZjtyRwddtllogDAO) DAOFactory.build(ZjtyRwddtllogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyRwddtllogVO doUpdate(ZjtyRwddtllogVO vo, User user)
        throws Exception {
        try{
			ZjtyRwddtllogDAO dao = (ZjtyRwddtllogDAO) DAOFactory.build(ZjtyRwddtllogDAO.class, user);
            return (ZjtyRwddtllogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyRwddtllogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyRwddtllogDAO dao = (ZjtyRwddtllogDAO) DAOFactory.build(ZjtyRwddtllogDAO.class, user);
        return (ZjtyRwddtllogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ZjtyRwddtllogListVO params, User user)
        throws Exception {
			ZjtyRwddtllogDAO dao = (ZjtyRwddtllogDAO) DAOFactory.build(ZjtyRwddtllogDAO.class, user);
        return dao.query(params);
    }
}
