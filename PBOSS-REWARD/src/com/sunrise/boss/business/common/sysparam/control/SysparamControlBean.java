package com.sunrise.boss.business.common.sysparam.control;

/**
* auto-generated code
* Fri Aug 11 16:47:18 CST 2006
*/

import java.io.Serializable;

import com.sunrise.boss.business.common.managelog.persistent.ManageLogDAO;
import com.sunrise.boss.business.common.managelog.persistent.OperAction;
import com.sunrise.boss.business.common.managelog.persistent.OperState;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamDAO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;


/**
 * <p>Title: SysparamControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xqy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/common/sysparam/control/SysparamControlBean"
*    name="SysparamControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class SysparamControlBean  extends AbstractControlBean
implements SysparamControl
 {
	static final private String  TABLENAME = "ib_gl_sysparam";
    public SysparamVO doCreate(SysparamVO vo, User user)
        throws Exception {
        try{
            SysparamDAO dao = (SysparamDAO) DAOFactory.build(SysparamDAO.class, user.getCityid());
            ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());            
            SysparamVO newvo = (SysparamVO)dao.create(vo);
			// 写管理操作日志
			mdao.manageLog(user, TABLENAME, OperAction.INSERT, null,
            				  			newvo, OperState.SUCCESS);    
			return newvo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(SysparamVO vo, User user)
        throws Exception {
        try{
            SysparamDAO dao = (SysparamDAO) DAOFactory.build(SysparamDAO.class, user.getCityid());        	
            ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());            
            dao.remove(vo);

			// 写管理操作日志
			mdao.manageLog(user, TABLENAME, OperAction.DELETE, null,
            				  			vo, OperState.SUCCESS); 
			
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public SysparamVO doUpdate(SysparamVO vo, User user)
        throws Exception {
        try{
            SysparamDAO dao = (SysparamDAO) DAOFactory.build(SysparamDAO.class, user.getCityid());        	

            ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());            
            vo = (SysparamVO)dao.update(vo);

			// 写管理操作日志
//			mdao.manageLog(user, TABLENAME, OperAction.UPDATE, null,
//            				  			vo, OperState.SUCCESS); 
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    
    public SysparamVO doUpdate2(SysparamVO vo, User user)
	    throws Exception {
	    try{
	        SysparamDAO dao = (SysparamDAO) DAOFactory.build(SysparamDAO.class, user.getCityid());        	
	        vo = (SysparamVO)dao.update(vo);
	        return vo;
	    } catch(Exception ex){
	        sessionContext.setRollbackOnly();
	        throw ex;
	    }
	}
    
    public SysparamVO doFindByPk(Serializable pk,User user)
        throws Exception {
        SysparamDAO dao = (SysparamDAO) DAOFactory.build(SysparamDAO.class, user.getCityid());         	
        return (SysparamVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(SysparamListVO params,User user)
        throws Exception {
        SysparamDAO dao = (SysparamDAO) DAOFactory.build(SysparamDAO.class, user.getCityid());         	
        return dao.query(params);
    }
    
    public String doFindByID(Long systemid, String paramtype, User user)
    	throws Exception {
        	SysparamDAO dao = (SysparamDAO) DAOFactory.build(SysparamDAO.class, user.getCityid());    
        return dao.doFindByID(systemid, paramtype);
}    
}
