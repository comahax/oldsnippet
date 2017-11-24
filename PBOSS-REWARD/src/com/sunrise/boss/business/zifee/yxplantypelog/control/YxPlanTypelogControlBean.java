/**
* auto-generated code
* Thu Oct 26 21:47:46 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplantypelog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplantypelog.persistent.YxPlanTypelogVO;
import com.sunrise.boss.business.zifee.yxplantypelog.persistent.YxPlanTypelogDAO;
import com.sunrise.boss.business.zifee.yxplantypelog.persistent.YxPlanTypelogListVO;

/**
 * <p>Title: YxPlanTypelogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/zifee/yxplantypelog/control/YxPlanTypelogControlBean"
 name="YxPlanTypelogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class YxPlanTypelogControlBean extends AbstractControlBean
    implements YxPlanTypelogControl {

    public YxPlanTypelogVO doCreate(YxPlanTypelogVO vo, User user)
        throws Exception {
        try{
			YxPlanTypelogDAO dao = (YxPlanTypelogDAO) DAOFactory.build(YxPlanTypelogDAO.class, user.getCityid());
            // TODO  set the pk */
            return (YxPlanTypelogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(YxPlanTypelogVO vo, User user)
        throws Exception {
        try{
			YxPlanTypelogDAO dao = (YxPlanTypelogDAO) DAOFactory.build(YxPlanTypelogDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanTypelogVO doUpdate(YxPlanTypelogVO vo, User user)
        throws Exception {
        try{
			YxPlanTypelogDAO dao = (YxPlanTypelogDAO) DAOFactory.build(YxPlanTypelogDAO.class, user.getCityid());
            return (YxPlanTypelogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanTypelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			YxPlanTypelogDAO dao = (YxPlanTypelogDAO) DAOFactory.build(YxPlanTypelogDAO.class, user.getCityid());
        return (YxPlanTypelogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(YxPlanTypelogListVO params, User user)
        throws Exception {
			YxPlanTypelogDAO dao = (YxPlanTypelogDAO) DAOFactory.build(YxPlanTypelogDAO.class, user.getCityid());
        return dao.query(params);
    }
}
