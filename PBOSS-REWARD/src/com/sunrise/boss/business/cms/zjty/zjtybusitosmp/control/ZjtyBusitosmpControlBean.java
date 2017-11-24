/**
* auto-generated code
* Thu Dec 24 16:13:49 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtybusitosmp.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmp.persistent.ZjtyBusitosmpVO;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmp.persistent.ZjtyBusitosmpDAO;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmp.persistent.ZjtyBusitosmpListVO;

/**
 * <p>Title: ZjtyBusitosmpControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtybusitosmp/control/ZjtyBusitosmpControlBean"
 name="ZjtyBusitosmpControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyBusitosmpControlBean extends AbstractControlBean
    implements ZjtyBusitosmpControl {

    public ZjtyBusitosmpVO doCreate(ZjtyBusitosmpVO vo, User user)
        throws Exception {
        try{
			ZjtyBusitosmpDAO dao = (ZjtyBusitosmpDAO) DAOFactory.build(ZjtyBusitosmpDAO.class, user);
            // TODO  set the pk */
            return (ZjtyBusitosmpVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ZjtyBusitosmpVO vo, User user)
        throws Exception {
        try{
			ZjtyBusitosmpDAO dao = (ZjtyBusitosmpDAO) DAOFactory.build(ZjtyBusitosmpDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyBusitosmpVO doUpdate(ZjtyBusitosmpVO vo, User user)
        throws Exception {
        try{
			ZjtyBusitosmpDAO dao = (ZjtyBusitosmpDAO) DAOFactory.build(ZjtyBusitosmpDAO.class, user);
            return (ZjtyBusitosmpVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyBusitosmpVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyBusitosmpDAO dao = (ZjtyBusitosmpDAO) DAOFactory.build(ZjtyBusitosmpDAO.class, user);
        return (ZjtyBusitosmpVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ZjtyBusitosmpListVO params, User user)
        throws Exception {
			ZjtyBusitosmpDAO dao = (ZjtyBusitosmpDAO) DAOFactory.build(ZjtyBusitosmpDAO.class, user);
        return dao.query(params);
    }
}
