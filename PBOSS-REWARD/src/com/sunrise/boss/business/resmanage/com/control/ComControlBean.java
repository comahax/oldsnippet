/**
* auto-generated code
* Sat Aug 12 14:48:47 CST 2006
*/
package com.sunrise.boss.business.resmanage.com.control;

import java.io.Serializable;

import com.sunrise.boss.business.resmanage.com.persistent.ComDAO;
import com.sunrise.boss.business.resmanage.com.persistent.ComListVO;
import com.sunrise.boss.business.resmanage.com.persistent.ComVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ComControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Rodney
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/resmanage/com/control/ComControlBean"
*    name="ComControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ComControlBean extends AbstractControlBean
    implements ComControl {

    public ComVO doCreate(ComVO vo, User user)
        throws Exception {
        try{
        	ComDAO dao = (ComDAO) DAOFactory.build(ComDAO.class,user.getCityid());
            // TODO  set the pk */
            return (ComVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ComVO vo, User user)
        throws Exception {
        try{
        	ComDAO dao = (ComDAO) DAOFactory.build(ComDAO.class,user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ComVO doUpdate(ComVO vo,User user)
        throws Exception {
        try{
        	ComDAO dao = (ComDAO) DAOFactory.build(ComDAO.class,user.getCityid());
            return (ComVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ComVO doFindByPk(Serializable pk, User user)
        throws Exception {
    	ComDAO dao = (ComDAO) DAOFactory.build(ComDAO.class,user.getCityid());
        return (ComVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ComListVO params, User user)
        throws Exception {
    	ComDAO dao = (ComDAO) DAOFactory.build(ComDAO.class,user.getCityid());
        return dao.query(params);
    }
    public int count(ComListVO params,User user)throws Exception{
    	ComDAO dao = (ComDAO) DAOFactory.build(ComDAO.class,user.getCityid());
    	return dao.count(params);
    }
}
