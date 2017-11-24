/**
* auto-generated code
* Fri Oct 20 10:53:27 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplanlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplanlog.persistent.YxplanlogVO;
import com.sunrise.boss.business.zifee.yxplanlog.persistent.YxplanlogDAO;
import com.sunrise.boss.business.zifee.yxplanlog.persistent.YxplanlogListVO;

/**
 * <p>Title: YxplanlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/zifee/yxplanlog/control/YxplanlogControlBean"
*    name="YxplanlogControl"
*    view-type="local"
*    type="Stateless"
*    
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"   
*/
public class YxplanlogControlBean extends AbstractControlBean
    implements YxplanlogControl {

    public YxplanlogVO doCreate(YxplanlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         YxplanlogDAO dao = (YxplanlogDAO) DAOFactory.build(YxplanlogDAO.class, user);
            return (YxplanlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(YxplanlogVO vo, User user)
        throws Exception {
        try{
         YxplanlogDAO dao = (YxplanlogDAO) DAOFactory.build(YxplanlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxplanlogVO doUpdate(YxplanlogVO vo, User user)
        throws Exception {
        try{
         YxplanlogDAO dao = (YxplanlogDAO) DAOFactory.build(YxplanlogDAO.class, user);
            return (YxplanlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxplanlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         YxplanlogDAO dao = (YxplanlogDAO) DAOFactory.build(YxplanlogDAO.class, user);
        return (YxplanlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(YxplanlogListVO params, User user)
        throws Exception {
         YxplanlogDAO dao = (YxplanlogDAO) DAOFactory.build(YxplanlogDAO.class, user);
        return dao.query(params);
    }
}
