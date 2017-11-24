/**
* auto-generated code
* Fri Aug 25 10:29:42 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplantype.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.business.zifee.yxplantype.persistent.YxPlanTypeVO;
import com.sunrise.boss.business.zifee.yxplantype.persistent.YxPlanTypeDAO;
import com.sunrise.boss.business.zifee.yxplantype.persistent.YxPlanTypeListVO;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.delegate.zifee.log.YxPlanFeeLogDelegate;

/**
 * <p>Title: YxPlanTypeControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/zifee/yxplantype/control/YxPlanTypeControlBean"
*    name="YxPlanTypeControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class YxPlanTypeControlBean extends AbstractControlBean
    implements YxPlanTypeControl {

	private YxPlanFeeLogDelegate logDeltegate ;
    public YxPlanTypeVO doCreate(YxPlanTypeVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
        	YxPlanTypeDAO dao = (YxPlanTypeDAO) DAOFactory.build(YxPlanTypeDAO.class,user );
            vo = (YxPlanTypeVO) dao.create(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Create","PC_PS_YXPLANTYPE","");//记录日志，新增
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemoveByVO(YxPlanTypeVO vo, User user) throws Exception {
    	YxPlanTypeDAO dao = (YxPlanTypeDAO) DAOFactory.build(YxPlanTypeDAO.class,user );
        try {
        	dao.remove(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Remove","PC_PS_YXPLANTYPE","");//记录日志，删除    
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemoveByPK(Serializable pk, User user) throws Exception {
    	YxPlanTypeDAO dao = (YxPlanTypeDAO) DAOFactory.build(YxPlanTypeDAO.class,user );
        try {
        	dao.removeByPk(pk);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Remove","PC_PS_YXPLANTYPE","");//记录日志，删除    
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanTypeVO doUpdate(YxPlanTypeVO vo, User user)
        throws Exception {
        try{
        	YxPlanTypeDAO dao = (YxPlanTypeDAO) DAOFactory.build(YxPlanTypeDAO.class,user );
            vo = (YxPlanTypeVO) dao.update(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Update","PC_PS_YXPLANTYPE","");//记录日志，修改
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanTypeVO doFindByPk(Serializable pk, User user)
        throws Exception {
    	YxPlanTypeDAO dao = (YxPlanTypeDAO) DAOFactory.build(YxPlanTypeDAO.class,user );
        return (YxPlanTypeVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(YxPlanTypeListVO params, User user)
        throws Exception {
    	YxPlanTypeDAO dao = (YxPlanTypeDAO) DAOFactory.build(YxPlanTypeDAO.class,user );
        return dao.query(params);
    }
}
