/**
* auto-generated code
* Tue Sep 18 16:17:01 CST 2007
*/
package com.sunrise.boss.business.zifee.yxplanpstlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplanpstlog.persistent.YxplanpstlogVO;
import com.sunrise.boss.business.zifee.yxplanpstlog.persistent.YxplanpstlogDAO;
import com.sunrise.boss.business.zifee.yxplanpstlog.persistent.YxplanpstlogListVO;

/**
 * <p>Title: YxplanpstlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/zifee/yxplanpstlog/control/YxplanpstlogControlBean"
 name="YxplanpstlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class YxplanpstlogControlBean extends AbstractControlBean
    implements YxplanpstlogControl {

    public YxplanpstlogVO doCreate(YxplanpstlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         YxplanpstlogDAO dao = (YxplanpstlogDAO) DAOFactory.build(YxplanpstlogDAO.class, user);
            return (YxplanpstlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(YxplanpstlogVO vo, User user)
        throws Exception {
        try{
         YxplanpstlogDAO dao = (YxplanpstlogDAO) DAOFactory.build(YxplanpstlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxplanpstlogVO doUpdate(YxplanpstlogVO vo, User user)
        throws Exception {
        try{
         YxplanpstlogDAO dao = (YxplanpstlogDAO) DAOFactory.build(YxplanpstlogDAO.class, user);
            return (YxplanpstlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxplanpstlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         YxplanpstlogDAO dao = (YxplanpstlogDAO) DAOFactory.build(YxplanpstlogDAO.class, user);
        return (YxplanpstlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(YxplanpstlogListVO params, User user)
        throws Exception {
         YxplanpstlogDAO dao = (YxplanpstlogDAO) DAOFactory.build(YxplanpstlogDAO.class, user);
        return dao.query(params);
    }
}
