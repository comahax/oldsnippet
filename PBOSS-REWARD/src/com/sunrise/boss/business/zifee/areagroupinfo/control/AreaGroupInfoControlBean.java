/**
* auto-generated code
* Mon Aug 21 16:04:22 CST 2006
*/
package com.sunrise.boss.business.zifee.areagroupinfo.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.business.zifee.areagroupinfo.persistent.AreaGroupInfoVO;
import com.sunrise.boss.business.zifee.areagroupinfo.persistent.AreaGroupInfoDAO;
import com.sunrise.boss.business.zifee.areagroupinfo.persistent.AreaGroupInfoListVO;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.delegate.zifee.log.YxPlanFeeLogDelegate;

/**
 * <p>Title: AreaGroupInfoControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/zifee/areagroupinfo/control/AreaGroupInfoControlBean"
*    name="AreaGroupInfoControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class AreaGroupInfoControlBean extends AbstractControlBean
    implements AreaGroupInfoControl {
	private YxPlanFeeLogDelegate logDeltegate ;
    public AreaGroupInfoVO doCreate(AreaGroupInfoVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
        	AreaGroupInfoDAO dao = (AreaGroupInfoDAO) DAOFactory.build(AreaGroupInfoDAO.class,user );
            vo = (AreaGroupInfoVO) dao.create(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Create","PC_PS_AREAGROUPINFO","");//记录日志，新增
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemoveByVO(AreaGroupInfoVO vo, User user) throws Exception {
    	AreaGroupInfoDAO dao = (AreaGroupInfoDAO) DAOFactory.build(AreaGroupInfoDAO.class,user );
        try {
        	dao.remove(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Remove","PC_PS_AREAGROUPINFO","");//记录日志，删除    
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemoveByPK(Serializable pk, User user) throws Exception {
    	AreaGroupInfoDAO dao = (AreaGroupInfoDAO) DAOFactory.build(AreaGroupInfoDAO.class,user );
        try {
        	dao.removeByPk(pk);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Remove","PC_PS_AREAGROUPINFO","");//记录日志，删除    
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public AreaGroupInfoVO doUpdate(AreaGroupInfoVO vo, User user)
        throws Exception {
        try{
        	AreaGroupInfoDAO dao = (AreaGroupInfoDAO) DAOFactory.build(AreaGroupInfoDAO.class,user );
            vo = (AreaGroupInfoVO) dao.update(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Update","PC_PS_AREAGROUPINFO","");//记录日志，修改
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public AreaGroupInfoVO doFindByPk(Serializable pk, User user)
        throws Exception {
    	AreaGroupInfoDAO dao = (AreaGroupInfoDAO) DAOFactory.build(AreaGroupInfoDAO.class,user );
        return (AreaGroupInfoVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(AreaGroupInfoListVO params, User user)
        throws Exception {
    	AreaGroupInfoDAO dao = (AreaGroupInfoDAO) DAOFactory.build(AreaGroupInfoDAO.class,user );
        return dao.query(params);
    }
}
