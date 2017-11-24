/**
* auto-generated code
* Mon Apr 30 16:49:59 CST 2007
*/
package com.sunrise.boss.business.admin.logincase.control;

import java.io.Serializable;
import java.util.*;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.admin.logincase.persistent.LogincaseVO;
import com.sunrise.boss.business.admin.logincase.persistent.LogincaseDAO;
import com.sunrise.boss.business.admin.logincase.persistent.LogincaseListVO;

/**
 * <p>Title: LogincaseControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/admin/logincase/control/LogincaseControlBean"
 name="LogincaseControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class LogincaseControlBean extends AbstractControlBean
    implements LogincaseControl {

    public LogincaseVO doCreate(LogincaseVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         LogincaseDAO dao = (LogincaseDAO) DAOFactory.build(LogincaseDAO.class, user);
         
         vo.setCreatetime(new Date());
            return (LogincaseVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(LogincaseVO vo, User user)
        throws Exception {
        try{
         LogincaseDAO dao = (LogincaseDAO) DAOFactory.build(LogincaseDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public LogincaseVO doUpdate(LogincaseVO vo, User user)
        throws Exception {
        try{
         LogincaseDAO dao = (LogincaseDAO) DAOFactory.build(LogincaseDAO.class, user);
            return (LogincaseVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public LogincaseVO doFindByPk(Serializable pk, User user)
        throws Exception {
         LogincaseDAO dao = (LogincaseDAO) DAOFactory.build(LogincaseDAO.class, user);
        return (LogincaseVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(LogincaseListVO params, User user)
        throws Exception {
         LogincaseDAO dao = (LogincaseDAO) DAOFactory.build(LogincaseDAO.class, user);
        return dao.query(params);
    }
}
