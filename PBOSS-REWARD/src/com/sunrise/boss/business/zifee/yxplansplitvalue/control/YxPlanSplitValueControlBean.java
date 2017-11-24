/**
* auto-generated code
* Thu Aug 31 16:01:07 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplansplitvalue.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.business.zifee.yxplansplitvalue.persistent.YxPlanSplitValueVO;
import com.sunrise.boss.business.zifee.yxplansplitvalue.persistent.YxPlanSplitValueDAO;
import com.sunrise.boss.business.zifee.yxplansplitvalue.persistent.YxPlanSplitValueListVO;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.delegate.zifee.log.YxPlanFeeLogDelegate;

/**
 * <p>Title: YxPlanSplitValueControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/zifee/yxplansplitvalue/control/YxPlanSplitValueControlBean"
*    name="YxPlanSplitValueControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class YxPlanSplitValueControlBean extends AbstractControlBean
    implements YxPlanSplitValueControl {
	
	private YxPlanFeeLogDelegate logDeltegate ;
    
    public YxPlanSplitValueVO doCreate(YxPlanSplitValueVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
        	YxPlanSplitValueDAO dao = (YxPlanSplitValueDAO) DAOFactory.build(YxPlanSplitValueDAO.class,user );
            vo = (YxPlanSplitValueVO) dao.create(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Create","PC_PS_YXPLANSPLITVALUE","");//记录日志，新增
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemoveByVO(YxPlanSplitValueVO vo, User user) throws Exception {
    	YxPlanSplitValueDAO dao = (YxPlanSplitValueDAO) DAOFactory.build(YxPlanSplitValueDAO.class,user );
        try {        	
        	dao.remove(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Remove","PC_PS_YXPLANSPLITVALUE","");//记录日志，删除    
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemoveByPK(Serializable pk, User user) throws Exception {
    	YxPlanSplitValueDAO dao = (YxPlanSplitValueDAO) DAOFactory.build(YxPlanSplitValueDAO.class,user );
        try {
        	dao.removeByPk(pk);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Remove","PC_PS_YXPLANSPLITVALUE","");//记录日志，删除    
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanSplitValueVO doUpdate(YxPlanSplitValueVO vo, User user)
        throws Exception {
        try{
        	YxPlanSplitValueDAO dao = (YxPlanSplitValueDAO) DAOFactory.build(YxPlanSplitValueDAO.class,user );
            vo = (YxPlanSplitValueVO) dao.update(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Update","PC_PS_YXPLANSPLITVALUE","");//记录日志，修改
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanSplitValueVO doFindByPk(Serializable pk, User user)
        throws Exception {
    	YxPlanSplitValueDAO dao = (YxPlanSplitValueDAO) DAOFactory.build(YxPlanSplitValueDAO.class,user );
        return (YxPlanSplitValueVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(YxPlanSplitValueListVO params, User user)
        throws Exception {
    	YxPlanSplitValueDAO dao = (YxPlanSplitValueDAO) DAOFactory.build(YxPlanSplitValueDAO.class,user );
        return dao.query(params);
    }
}
