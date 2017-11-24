/**
* auto-generated code
* Mon Aug 28 09:56:50 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplansplitscale.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.business.zifee.yxplansplitscale.persistent.YxPlanSplitScaleVO;
import com.sunrise.boss.business.zifee.yxplansplitscale.persistent.YxPlanSplitScaleDAO;
import com.sunrise.boss.business.zifee.yxplansplitscale.persistent.YxPlanSplitScaleListVO;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.delegate.zifee.log.YxPlanFeeLogDelegate;

/**
 * <p>Title: YxPlanSplitScaleControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/zifee/yxplansplitscale/control/YxPlanSplitScaleControlBean"
*    name="YxPlanSplitScaleControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class YxPlanSplitScaleControlBean extends AbstractControlBean
    implements YxPlanSplitScaleControl {

	private YxPlanFeeLogDelegate logDeltegate ;
	
    public YxPlanSplitScaleVO doCreate(YxPlanSplitScaleVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
        	YxPlanSplitScaleDAO dao = (YxPlanSplitScaleDAO) DAOFactory.build(YxPlanSplitScaleDAO.class,user );
            vo = (YxPlanSplitScaleVO) dao.create(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Create","PC_PS_YXPLANSPLITSCALE","");//记录日志，新增
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemoveByVO(YxPlanSplitScaleVO vo, User user) throws Exception {
    	YxPlanSplitScaleDAO dao = (YxPlanSplitScaleDAO) DAOFactory.build(YxPlanSplitScaleDAO.class,user );
        try {
        	//vo.setScale(Float.valueOf("0.00"));//设置默认值
        	dao.remove(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Remove","PC_PS_YXPLANSPLITSCALE","");//记录日志，删除    
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemoveByPK(Serializable pk, User user) throws Exception {
    	YxPlanSplitScaleDAO dao = (YxPlanSplitScaleDAO) DAOFactory.build(YxPlanSplitScaleDAO.class,user );
        try {
        	dao.removeByPk(pk);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Remove","PC_PS_YXPLANSPLITSCALE","");//记录日志，删除    
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanSplitScaleVO doUpdate(YxPlanSplitScaleVO vo, User user)
        throws Exception {
        try{
        	YxPlanSplitScaleDAO dao = (YxPlanSplitScaleDAO) DAOFactory.build(YxPlanSplitScaleDAO.class,user );
        	vo = (YxPlanSplitScaleVO) dao.update(vo);
        	//logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Update","PC_PS_YXPLANSPLITSCALE","");//记录日志，修改
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanSplitScaleVO doFindByPk(Serializable pk, User user)
        throws Exception {
    	YxPlanSplitScaleDAO dao = (YxPlanSplitScaleDAO) DAOFactory.build(YxPlanSplitScaleDAO.class,user );
        return (YxPlanSplitScaleVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(YxPlanSplitScaleListVO params, User user)
        throws Exception {
    	YxPlanSplitScaleDAO dao = (YxPlanSplitScaleDAO) DAOFactory.build(YxPlanSplitScaleDAO.class,user );
        return dao.query(params);
    }
}
