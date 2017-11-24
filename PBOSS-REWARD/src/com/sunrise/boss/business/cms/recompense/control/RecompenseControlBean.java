/**
* auto-generated code
* Tue Sep 19 21:22:32 CST 2006
*/
package com.sunrise.boss.business.cms.recompense.control;

import java.io.Serializable;

//import org.apache.commons.lang.builder.ReflectionToStringBuilder;
//import org.apache.commons.lang.builder.ToStringStyle;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

import com.sunrise.boss.business.cms.recompense.persistent.RecompenseDAO;
import com.sunrise.boss.business.cms.recompense.persistent.RecompenseListVO;
import com.sunrise.boss.business.cms.recompense.persistent.RecompenseVO;
//import com.sunrise.boss.business.common.managelog.persistent.ManageLogToStringStyle;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: RecompenseControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/recompense/control/RecompenseControlBean"
*    name="RecompenseControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class RecompenseControlBean extends AbstractControlBean
    implements RecompenseControl {
	
//	private static final Log log = LogFactory.getLog(RecompenseControlBean.class);
	
	private static final long serialVersionUID = -1451755416006755846L;
	
	public RecompenseVO doCreate(RecompenseVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
//         if(log.isInfoEnabled()) {
//        	 ToStringStyle style = ManageLogToStringStyle.MANAGE_LOG_STYLE;
//        	 log.info(" Create RecompenseVO : ");
//        	 log.info(ReflectionToStringBuilder.toString(vo, style));
//         }
         RecompenseDAO dao = (RecompenseDAO) DAOFactory.build(RecompenseDAO.class, user);
            return (RecompenseVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RecompenseVO vo, User user)
        throws Exception {
        try{
         RecompenseDAO dao = (RecompenseDAO) DAOFactory.build(RecompenseDAO.class, user);
         vo = doFindByPk(vo.getRecid(),user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RecompenseVO doUpdate(RecompenseVO vo, User user)
        throws Exception {
        try{
         RecompenseDAO dao = (RecompenseDAO) DAOFactory.build(RecompenseDAO.class, user);
            return (RecompenseVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RecompenseVO doFindByPk(Serializable pk, User user)
        throws Exception {
         RecompenseDAO dao = (RecompenseDAO) DAOFactory.build(RecompenseDAO.class, user);
        return (RecompenseVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RecompenseListVO params, User user)
        throws Exception {
         RecompenseDAO dao = (RecompenseDAO) DAOFactory.build(RecompenseDAO.class, user);
        return dao.query(params);
    }
    
    public static void main(String[] args) throws Exception {
    	RecompenseControlBean bean = new RecompenseControlBean();
    	bean.doCreate(null,null);
    }
}
