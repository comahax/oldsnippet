/**
* auto-generated code
* Fri Aug 11 18:21:13 CST 2006
*/
package com.sunrise.boss.business.common.managelog.control;

import java.io.Serializable;

import com.sunrise.boss.business.common.managelog.persistent.ManageLogDAO;
import com.sunrise.boss.business.common.managelog.persistent.ManageLogDBParam;
import com.sunrise.boss.business.common.managelog.persistent.ManageLogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;


/**
 * <p>Title: ManagelogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xqy
 * @version 1.0
 */

public class ManageLogBO  extends AbstractControlBean
implements ManageLog {

    public ManageLogVO doCreate(ManageLogVO vo, User user)
        throws Exception {
        try{
           ManageLogDAO dao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());
            return (ManageLogVO) dao.create(vo);
        } catch(Exception ex){
           // sessionContext.setRollbackOnly();
            throw ex;
        }
    }
//    public void doRemove(ManageLogVO vo, User user)
//        throws Exception {
//        try{
//            ManageLogDAO dao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());        	
//            dao.remove(vo);
//        } catch(Exception ex){
//            sessionContext.setRollbackOnly();
//            throw ex;
//        }
//    }
//    public ManageLogVO doUpdate(ManageLogVO vo, User user)
//        throws Exception {
//        try{
//            ManageLogDAO dao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());        	
//            return (ManageLogVO) dao.update(vo);
//        } catch(Exception ex){
//            sessionContext.setRollbackOnly();
//            throw ex;
//        }
//    }
    public ManageLogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        ManageLogDAO dao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());    	
        return (ManageLogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ManageLogDBParam params, User user)
        throws Exception {
        ManageLogDAO dao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());   	
        return dao.query(params);
    }
//  /*
//  * manageLog:   记录管理操作日志
//  * 
//  * user			操作员对象
//  * oprtype		操作的表名或者实体名
//  * action		操作类型,OperAction类中有定义
//  * voOld		修改前实体,如果操作类型是新增则填null
//  * voNew		修改后实体,如果操作类型是删除则填null
//  * state		操作状态,OperState类中有定义
//  */
//    public void manageLog(User user, String oprtype, String action,
//            Object voOld, Object voNew, Integer state) throws
//		Exception {
//			ToStringStyle style = ManageLogToStringStyle.MANAGE_LOG_STYLE;
//			
//			ManageLogVO vo = new ManageLogVO();
//			vo.setOprcode(user.getOpercode());
//			vo.setOprtime(new Timestamp(System.currentTimeMillis()));
//			vo.setOprtype(oprtype);
//			vo.setOpraction(action);
//			vo.setOprcon1(voOld == null ? "" :
//			      ReflectionToStringBuilder.toString(voOld, style));
//			vo.setOprcon2(voNew == null ? "" :
//			      ReflectionToStringBuilder.toString(voNew, style));
//			vo.setOprstate(state);
//			
//			doCreate(vo, user);
//		}    
}
