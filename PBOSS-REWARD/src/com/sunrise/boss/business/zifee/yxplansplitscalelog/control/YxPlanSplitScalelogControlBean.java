/**
* auto-generated code
* Thu Oct 26 10:38:36 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplansplitscalelog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplansplitscalelog.persistent.YxPlanSplitScalelogVO;
import com.sunrise.boss.business.zifee.yxplansplitscalelog.persistent.YxPlanSplitScalelogDAO;
import com.sunrise.boss.business.zifee.yxplansplitscalelog.persistent.YxPlanSplitScalelogListVO;

/**
 * <p>Title: YxPlanSplitScalelogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/zifee/yxplansplitscalelog/control/YxPlanSplitScalelogControlBean"
 name="YxPlanSplitScalelogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class YxPlanSplitScalelogControlBean extends AbstractControlBean
    implements YxPlanSplitScalelogControl {

    public YxPlanSplitScalelogVO doCreate(YxPlanSplitScalelogVO vo, User user)
        throws Exception {
        try{
			YxPlanSplitScalelogDAO dao = (YxPlanSplitScalelogDAO) DAOFactory.build(YxPlanSplitScalelogDAO.class, user.getCityid());
            // TODO  set the pk */
            return (YxPlanSplitScalelogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(YxPlanSplitScalelogVO vo, User user)
        throws Exception {
        try{
			YxPlanSplitScalelogDAO dao = (YxPlanSplitScalelogDAO) DAOFactory.build(YxPlanSplitScalelogDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanSplitScalelogVO doUpdate(YxPlanSplitScalelogVO vo, User user)
        throws Exception {
        try{
			YxPlanSplitScalelogDAO dao = (YxPlanSplitScalelogDAO) DAOFactory.build(YxPlanSplitScalelogDAO.class, user.getCityid());
            return (YxPlanSplitScalelogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanSplitScalelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			YxPlanSplitScalelogDAO dao = (YxPlanSplitScalelogDAO) DAOFactory.build(YxPlanSplitScalelogDAO.class, user.getCityid());
        return (YxPlanSplitScalelogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(YxPlanSplitScalelogListVO params, User user)
        throws Exception {
			YxPlanSplitScalelogDAO dao = (YxPlanSplitScalelogDAO) DAOFactory.build(YxPlanSplitScalelogDAO.class, user.getCityid());
        return dao.query(params);
    }
}
