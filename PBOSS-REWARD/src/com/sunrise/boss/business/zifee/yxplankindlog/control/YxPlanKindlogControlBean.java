/**
* auto-generated code
* Thu Oct 26 21:50:00 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplankindlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplankindlog.persistent.YxPlanKindlogVO;
import com.sunrise.boss.business.zifee.yxplankindlog.persistent.YxPlanKindlogDAO;
import com.sunrise.boss.business.zifee.yxplankindlog.persistent.YxPlanKindlogListVO;

/**
 * <p>Title: YxPlanKindlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/zifee/yxplankindlog/control/YxPlanKindlogControlBean"
 name="YxPlanKindlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class YxPlanKindlogControlBean extends AbstractControlBean
    implements YxPlanKindlogControl {

    public YxPlanKindlogVO doCreate(YxPlanKindlogVO vo, User user)
        throws Exception {
        try{
			YxPlanKindlogDAO dao = (YxPlanKindlogDAO) DAOFactory.build(YxPlanKindlogDAO.class, user.getCityid());
            // TODO  set the pk */
            return (YxPlanKindlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(YxPlanKindlogVO vo, User user)
        throws Exception {
        try{
			YxPlanKindlogDAO dao = (YxPlanKindlogDAO) DAOFactory.build(YxPlanKindlogDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanKindlogVO doUpdate(YxPlanKindlogVO vo, User user)
        throws Exception {
        try{
			YxPlanKindlogDAO dao = (YxPlanKindlogDAO) DAOFactory.build(YxPlanKindlogDAO.class, user.getCityid());
            return (YxPlanKindlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanKindlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			YxPlanKindlogDAO dao = (YxPlanKindlogDAO) DAOFactory.build(YxPlanKindlogDAO.class, user.getCityid());
        return (YxPlanKindlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(YxPlanKindlogListVO params, User user)
        throws Exception {
			YxPlanKindlogDAO dao = (YxPlanKindlogDAO) DAOFactory.build(YxPlanKindlogDAO.class, user.getCityid());
        return dao.query(params);
    }
}
