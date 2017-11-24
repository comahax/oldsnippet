/**
* auto-generated code
* Sat Jan 13 18:51:44 CST 2007
*/
package com.sunrise.boss.business.zifee.yxplancplog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplancplog.persistent.YxplancplogVO;
import com.sunrise.boss.business.zifee.yxplancplog.persistent.YxplancplogDAO;
import com.sunrise.boss.business.zifee.yxplancplog.persistent.YxplancplogListVO;

/**
 * <p>Title: YxplancplogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Cai Jianhui
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/zifee/yxplancplog/control/YxplancplogControlBean"
 name="YxplancplogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class YxplancplogControlBean extends AbstractControlBean
    implements YxplancplogControl {

    public YxplancplogVO doCreate(YxplancplogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         YxplancplogDAO dao = (YxplancplogDAO) DAOFactory.build(YxplancplogDAO.class, user);
            return (YxplancplogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(YxplancplogVO vo, User user)
        throws Exception {
        try{
         YxplancplogDAO dao = (YxplancplogDAO) DAOFactory.build(YxplancplogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxplancplogVO doUpdate(YxplancplogVO vo, User user)
        throws Exception {
        try{
         YxplancplogDAO dao = (YxplancplogDAO) DAOFactory.build(YxplancplogDAO.class, user);
            return (YxplancplogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxplancplogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         YxplancplogDAO dao = (YxplancplogDAO) DAOFactory.build(YxplancplogDAO.class, user);
        return (YxplancplogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(YxplancplogListVO params, User user)
        throws Exception {
         YxplancplogDAO dao = (YxplancplogDAO) DAOFactory.build(YxplancplogDAO.class, user);
        return dao.query(params,user);
    }
}
