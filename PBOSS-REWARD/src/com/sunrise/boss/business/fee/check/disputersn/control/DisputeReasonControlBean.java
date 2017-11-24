/**
* auto-generated code
* Wed Aug 16 16:27:53 CST 2006
*/
package com.sunrise.boss.business.fee.check.disputersn.control;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.business.fee.check.disputersn.persistent.DisputeReasonDAO;
import com.sunrise.boss.business.fee.check.disputersn.persistent.DisputeReasonListVO;
import com.sunrise.boss.business.fee.check.disputersn.persistent.DisputeReasonVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: DisputeReasonControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author liwenjing
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/fee/check/disputersn/control/DisputeReasonControlBean"
*    name="DisputeReasonControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class DisputeReasonControlBean extends AbstractControlBean
    implements DisputeReasonControl {

   // private static DisputeReasonDAO dao = (DisputeReasonDAO) DAOFactory.build(DisputeReasonDAO.class);
    public DisputeReasonVO doCreate(DisputeReasonVO vo, User user)
        throws Exception {
        try{
        	DisputeReasonDAO dao = (DisputeReasonDAO) DAOFactory.build(DisputeReasonDAO.class,user.getCityid());
            return (DisputeReasonVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(DisputeReasonVO vo, User user)
        throws Exception {
        try{
        	DisputeReasonDAO dao = (DisputeReasonDAO) DAOFactory.build(DisputeReasonDAO.class,user.getCityid());        	
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public DisputeReasonVO doUpdate(DisputeReasonVO vo, User user)
        throws Exception {
        try{
        	DisputeReasonDAO dao = (DisputeReasonDAO) DAOFactory.build(DisputeReasonDAO.class,user.getCityid());
            return (DisputeReasonVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public DisputeReasonVO doFindByPk(Serializable pk, User user)
        throws Exception {
    	DisputeReasonDAO dao = (DisputeReasonDAO) DAOFactory.build(DisputeReasonDAO.class,user.getCityid());
        return (DisputeReasonVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(DisputeReasonListVO params, User user)
        throws Exception {
    	DisputeReasonDAO dao = (DisputeReasonDAO) DAOFactory.build(DisputeReasonDAO.class,user.getCityid());    
        return dao.query(params);
    }
    public List getAllUpperGrade(User user)
    	throws Exception{
    	DisputeReasonDAO dao = (DisputeReasonDAO) DAOFactory.build(DisputeReasonDAO.class,user.getCityid());    
    	return dao.getAllUpperGrade();
    } 
    public List getGrade(int grade,User user) throws Exception {
    	DisputeReasonDAO dao = (DisputeReasonDAO) DAOFactory.build(DisputeReasonDAO.class,user.getCityid());    
    	return dao.getGrade(grade);
    	
    }
    public List getLowByRsncode(String rsncode,User user) throws Exception {
    	DisputeReasonDAO dao = (DisputeReasonDAO) DAOFactory.build(DisputeReasonDAO.class,user.getCityid());
    	return dao.getLowByRsncode(rsncode);
    }
}
