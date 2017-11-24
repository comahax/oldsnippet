/**
* auto-generated code
* Tue Jan 12 09:53:03 CST 2010
*/
package com.sunrise.boss.business.cms.zjty.zjtybusyxplanlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplanlog.persistent.ZjtyBusyxplanlogVO;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplanlog.persistent.ZjtyBusyxplanlogDAO;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplanlog.persistent.ZjtyBusyxplanlogListVO;

/**
 * <p>Title: ZjtyBusyxplanlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtybusyxplanlog/control/ZjtyBusyxplanlogControlBean"
 name="ZjtyBusyxplanlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyBusyxplanlogControlBean extends AbstractControlBean
    implements ZjtyBusyxplanlogControl {

    public ZjtyBusyxplanlogVO doCreate(ZjtyBusyxplanlogVO vo, User user)
        throws Exception {
        try{
			ZjtyBusyxplanlogDAO dao = (ZjtyBusyxplanlogDAO) DAOFactory.build(ZjtyBusyxplanlogDAO.class, user);
            // TODO  set the pk */
            return (ZjtyBusyxplanlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ZjtyBusyxplanlogVO vo, User user)
        throws Exception {
        try{
			ZjtyBusyxplanlogDAO dao = (ZjtyBusyxplanlogDAO) DAOFactory.build(ZjtyBusyxplanlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyBusyxplanlogVO doUpdate(ZjtyBusyxplanlogVO vo, User user)
        throws Exception {
        try{
			ZjtyBusyxplanlogDAO dao = (ZjtyBusyxplanlogDAO) DAOFactory.build(ZjtyBusyxplanlogDAO.class, user);
            return (ZjtyBusyxplanlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyBusyxplanlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyBusyxplanlogDAO dao = (ZjtyBusyxplanlogDAO) DAOFactory.build(ZjtyBusyxplanlogDAO.class, user);
        return (ZjtyBusyxplanlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ZjtyBusyxplanlogListVO params, User user)
        throws Exception {
			ZjtyBusyxplanlogDAO dao = (ZjtyBusyxplanlogDAO) DAOFactory.build(ZjtyBusyxplanlogDAO.class, user);
        return dao.query(params);
    }
}
