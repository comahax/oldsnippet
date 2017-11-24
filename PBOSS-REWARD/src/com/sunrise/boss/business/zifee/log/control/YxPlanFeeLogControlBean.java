/**
* auto-generated code
* Sun Aug 20 11:47:03 CST 2006
*/
package com.sunrise.boss.business.zifee.log.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.business.zifee.log.persistent.YxPlanFeeLogVO;
import com.sunrise.boss.business.zifee.log.persistent.YxPlanFeeLogDAO;
import com.sunrise.boss.business.zifee.log.persistent.YxPlanFeeLogListVO;
import com.sunrise.boss.ui.commons.User;
/**
 * <p>Title: YxPlanFeeLogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/zifee/log/control/YxPlanFeeLogControlBean"
*    name="YxPlanFeeLogControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class YxPlanFeeLogControlBean extends AbstractControlBean
    implements YxPlanFeeLogControl {
    
    public YxPlanFeeLogVO doCreate(YxPlanFeeLogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
        	YxPlanFeeLogDAO dao = (YxPlanFeeLogDAO) DAOFactory.build(YxPlanFeeLogDAO.class,user );
            return (YxPlanFeeLogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(YxPlanFeeLogVO vo, User user)
        throws Exception {
        try{
        	YxPlanFeeLogDAO dao = (YxPlanFeeLogDAO) DAOFactory.build(YxPlanFeeLogDAO.class,user );
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanFeeLogVO doUpdate(YxPlanFeeLogVO vo, User user)
        throws Exception {
        try{
        	YxPlanFeeLogDAO dao = (YxPlanFeeLogDAO) DAOFactory.build(YxPlanFeeLogDAO.class,user );
            return (YxPlanFeeLogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanFeeLogVO doFindByPk(Serializable pk, User user)
        throws Exception {
    	YxPlanFeeLogDAO dao = (YxPlanFeeLogDAO) DAOFactory.build(YxPlanFeeLogDAO.class,user );
        return (YxPlanFeeLogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(YxPlanFeeLogListVO params, User user)
        throws Exception {
    	YxPlanFeeLogDAO dao = (YxPlanFeeLogDAO) DAOFactory.build(YxPlanFeeLogDAO.class,user );
        return dao.query(params);
    }
}
