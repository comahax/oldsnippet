/**
* auto-generated code
* Mon Aug 21 20:59:07 CST 2006
*/
package com.sunrise.boss.business.zifee.areagroupscale.control;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.delegate.zifee.log.YxPlanFeeLogDelegate;
import com.sunrise.boss.business.zifee.areagroupscale.persistent.AreaGroupScaleVO;
import com.sunrise.boss.business.zifee.areagroupscale.persistent.AreaGroupScaleDAO;
import com.sunrise.boss.business.zifee.areagroupscale.persistent.AreaGroupScaleListVO;
import com.sunrise.boss.ui.commons.User;
/**
 * <p>Title: AreaGroupScaleControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/zifee/areagroupscale/control/AreaGroupScaleControlBean"
*    name="AreaGroupScaleControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class AreaGroupScaleControlBean extends AbstractControlBean
    implements AreaGroupScaleControl {

	private YxPlanFeeLogDelegate logDeltegate;
    
    public AreaGroupScaleVO doCreate(AreaGroupScaleVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
        	AreaGroupScaleDAO dao = (AreaGroupScaleDAO) DAOFactory.build(AreaGroupScaleDAO.class,user );
            vo = (AreaGroupScaleVO) dao.create(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Create","PC_PS_AREAGROUPSCALE","");//记录日志，新增
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemoveByVO(AreaGroupScaleVO vo, User user) throws Exception {
    	AreaGroupScaleDAO dao = (AreaGroupScaleDAO) DAOFactory.build(AreaGroupScaleDAO.class,user );
        try {
        	//vo.setEffdate(new java.util.Date());//测试先设置默认值
        	//vo.setExpdate(new java.util.Date());//测试先设置默认值
        	dao.remove(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Remove","PC_PS_AREAGROUPSCALE","");//记录日志，删除    
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemoveByPK(Serializable pk, User user) throws Exception {
    	AreaGroupScaleDAO dao = (AreaGroupScaleDAO) DAOFactory.build(AreaGroupScaleDAO.class,user );
        try {
        	dao.removeByPk(pk);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Remove","PC_PS_AREAGROUPSCALE","");//记录日志，删除    
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    
    public AreaGroupScaleVO doUpdate(AreaGroupScaleVO vo, User user)
        throws Exception {
        try{
        	AreaGroupScaleDAO dao = (AreaGroupScaleDAO) DAOFactory.build(AreaGroupScaleDAO.class,user );
        	//vo.setEffdate(new java.util.Date());
            vo = (AreaGroupScaleVO) dao.update(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Update","PC_PS_AREAGROUPSCALE","");//记录日志，修改
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    
    public AreaGroupScaleVO doFindByPk(Serializable pk, User user)
        throws Exception {
    	AreaGroupScaleDAO dao = (AreaGroupScaleDAO) DAOFactory.build(AreaGroupScaleDAO.class,user );
        return (AreaGroupScaleVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(AreaGroupScaleListVO params, User user)
        throws Exception {
    	AreaGroupScaleDAO dao = (AreaGroupScaleDAO) DAOFactory.build(AreaGroupScaleDAO.class,user );
        return dao.query(params);
    }
    
    /**
     * 根据组id得到所有的code
     * added by yijianrong
     * @param groupid
     * @param user
     * @return
     * @throws Exception
     */
    public List doFindByGroupid(String groupid, User user)
    throws Exception {
	  AreaGroupScaleDAO dao = (AreaGroupScaleDAO) DAOFactory.build(AreaGroupScaleDAO.class,user );
	  return dao.findByGroupid(groupid,user);
    }
}
