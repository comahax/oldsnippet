/**
* auto-generated code
* Thu Dec 24 16:14:35 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtybusitosmplog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmplog.persistent.ZjtyBusitosmplogVO;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmplog.persistent.ZjtyBusitosmplogDAO;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmplog.persistent.ZjtyBusitosmplogListVO;

/**
 * <p>Title: ZjtyBusitosmplogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtybusitosmplog/control/ZjtyBusitosmplogControlBean"
 name="ZjtyBusitosmplogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyBusitosmplogControlBean extends AbstractControlBean
    implements ZjtyBusitosmplogControl {

    public ZjtyBusitosmplogVO doCreate(ZjtyBusitosmplogVO vo, User user)
        throws Exception {
        try{
			ZjtyBusitosmplogDAO dao = (ZjtyBusitosmplogDAO) DAOFactory.build(ZjtyBusitosmplogDAO.class, user);
            // TODO  set the pk */
            return (ZjtyBusitosmplogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ZjtyBusitosmplogVO vo, User user)
        throws Exception {
        try{
			ZjtyBusitosmplogDAO dao = (ZjtyBusitosmplogDAO) DAOFactory.build(ZjtyBusitosmplogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyBusitosmplogVO doUpdate(ZjtyBusitosmplogVO vo, User user)
        throws Exception {
        try{
			ZjtyBusitosmplogDAO dao = (ZjtyBusitosmplogDAO) DAOFactory.build(ZjtyBusitosmplogDAO.class, user);
            return (ZjtyBusitosmplogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyBusitosmplogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyBusitosmplogDAO dao = (ZjtyBusitosmplogDAO) DAOFactory.build(ZjtyBusitosmplogDAO.class, user);
        return (ZjtyBusitosmplogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ZjtyBusitosmplogListVO params, User user)
        throws Exception {
			ZjtyBusitosmplogDAO dao = (ZjtyBusitosmplogDAO) DAOFactory.build(ZjtyBusitosmplogDAO.class, user);
        return dao.query(params);
    }
}
