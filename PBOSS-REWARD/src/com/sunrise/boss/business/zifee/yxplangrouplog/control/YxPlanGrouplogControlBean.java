/**
* auto-generated code
* Thu Oct 26 17:56:48 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplangrouplog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplangrouplog.persistent.YxPlanGrouplogVO;
import com.sunrise.boss.business.zifee.yxplangrouplog.persistent.YxPlanGrouplogDAO;
import com.sunrise.boss.business.zifee.yxplangrouplog.persistent.YxPlanGrouplogListVO;

/**
 * <p>Title: YxPlanGrouplogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/zifee/yxplangrouplog/control/YxPlanGrouplogControlBean"
 name="YxPlanGrouplogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class YxPlanGrouplogControlBean extends AbstractControlBean
    implements YxPlanGrouplogControl {

    public YxPlanGrouplogVO doCreate(YxPlanGrouplogVO vo, User user)
        throws Exception {
        try{
			YxPlanGrouplogDAO dao = (YxPlanGrouplogDAO) DAOFactory.build(YxPlanGrouplogDAO.class, user.getCityid());
            // TODO  set the pk */
            return (YxPlanGrouplogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(YxPlanGrouplogVO vo, User user)
        throws Exception {
        try{
			YxPlanGrouplogDAO dao = (YxPlanGrouplogDAO) DAOFactory.build(YxPlanGrouplogDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanGrouplogVO doUpdate(YxPlanGrouplogVO vo, User user)
        throws Exception {
        try{
			YxPlanGrouplogDAO dao = (YxPlanGrouplogDAO) DAOFactory.build(YxPlanGrouplogDAO.class, user.getCityid());
            return (YxPlanGrouplogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanGrouplogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			YxPlanGrouplogDAO dao = (YxPlanGrouplogDAO) DAOFactory.build(YxPlanGrouplogDAO.class, user.getCityid());
        return (YxPlanGrouplogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(YxPlanGrouplogListVO params, User user)
        throws Exception {
			YxPlanGrouplogDAO dao = (YxPlanGrouplogDAO) DAOFactory.build(YxPlanGrouplogDAO.class, user.getCityid());
        return dao.query(params);
    }
}
