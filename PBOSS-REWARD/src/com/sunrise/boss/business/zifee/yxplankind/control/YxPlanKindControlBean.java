/**
* auto-generated code
* Fri Aug 25 10:34:46 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplankind.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.business.zifee.yxplankind.persistent.YxPlanKindVO;
import com.sunrise.boss.business.zifee.yxplankind.persistent.YxPlanKindDAO;
import com.sunrise.boss.business.zifee.yxplankind.persistent.YxPlanKindListVO;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.delegate.zifee.log.YxPlanFeeLogDelegate;
/**
 * <p>Title: YxPlanKindControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/zifee/yxplankind/control/YxPlanKindControlBean"
*    name="YxPlanKindControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class YxPlanKindControlBean extends AbstractControlBean
    implements YxPlanKindControl {

	private YxPlanFeeLogDelegate logDeltegate ;
    public YxPlanKindVO doCreate(YxPlanKindVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
        	YxPlanKindDAO dao = (YxPlanKindDAO) DAOFactory.build(YxPlanKindDAO.class,user );
            vo = (YxPlanKindVO) dao.create(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Create","PC_PS_YXPLANKIND","");//记录日志，新增
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemoveByVO(YxPlanKindVO vo, User user) throws Exception {
    	YxPlanKindDAO dao = (YxPlanKindDAO) DAOFactory.build(YxPlanKindDAO.class,user );
        try {
        	dao.remove(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Remove","PC_PS_YXPLANKIND","");//记录日志，删除    
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemoveByPK(Serializable pk, User user) throws Exception {
    	YxPlanKindDAO dao = (YxPlanKindDAO) DAOFactory.build(YxPlanKindDAO.class,user );
        try {
        	dao.removeByPk(pk);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Remove","PC_PS_YXPLANKIND","");//记录日志，删除    
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanKindVO doUpdate(YxPlanKindVO vo, User user)
        throws Exception {
        try{
        	
        	YxPlanKindDAO dao = (YxPlanKindDAO) DAOFactory.build(YxPlanKindDAO.class,user );
            vo = (YxPlanKindVO) dao.update(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Update","PC_PS_YXPLANKIND","");//记录日志，修改
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanKindVO doFindByPk(Serializable pk, User user)
        throws Exception {
    	YxPlanKindDAO dao = (YxPlanKindDAO) DAOFactory.build(YxPlanKindDAO.class,user );
        return (YxPlanKindVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(YxPlanKindListVO params, User user)
        throws Exception {
    	YxPlanKindDAO dao = (YxPlanKindDAO) DAOFactory.build(YxPlanKindDAO.class,user );
        return dao.query(params);
    }
}
