/**
* auto-generated code
* Mon Dec 28 10:41:51 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtybusyxplan.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplan.persistent.ZjtyBusyxplanVO;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplan.persistent.ZjtyBusyxplanDAO;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplan.persistent.ZjtyBusyxplanListVO;

/**
 * <p>Title: ZjtyBusyxplanControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtybusyxplan/control/ZjtyBusyxplanControlBean"
 name="ZjtyBusyxplanControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyBusyxplanControlBean extends AbstractControlBean
    implements ZjtyBusyxplanControl {

    public ZjtyBusyxplanVO doCreate(ZjtyBusyxplanVO vo, User user)
        throws Exception {
        try{
			ZjtyBusyxplanDAO dao = (ZjtyBusyxplanDAO) DAOFactory.build(ZjtyBusyxplanDAO.class, user);
            // TODO  set the pk */
			//vo.setCityid(user.getCityid());
			//vo.setPlanbusitype("HAPPYONLINE");
			//vo.setWrapfee(new Double("0"));
            return (ZjtyBusyxplanVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ZjtyBusyxplanVO vo, User user)
        throws Exception {
        try{
			ZjtyBusyxplanDAO dao = (ZjtyBusyxplanDAO) DAOFactory.build(ZjtyBusyxplanDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyBusyxplanVO doUpdate(ZjtyBusyxplanVO vo, User user)
        throws Exception {
        try{
			ZjtyBusyxplanDAO dao = (ZjtyBusyxplanDAO) DAOFactory.build(ZjtyBusyxplanDAO.class, user);
            return (ZjtyBusyxplanVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyBusyxplanVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyBusyxplanDAO dao = (ZjtyBusyxplanDAO) DAOFactory.build(ZjtyBusyxplanDAO.class, user);
        return (ZjtyBusyxplanVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ZjtyBusyxplanListVO params, User user)
        throws Exception {
			ZjtyBusyxplanDAO dao = (ZjtyBusyxplanDAO) DAOFactory.build(ZjtyBusyxplanDAO.class, user);
        return dao.query(params);
    }
}
