/**
* auto-generated code
* Fri Oct 20 20:01:29 CST 2006
*/
package com.sunrise.boss.business.rightmanage.operrole.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.rightmanage.operrole.persistent.OperroleDAO;
import com.sunrise.boss.business.rightmanage.operrole.persistent.OperroleListVO;
import com.sunrise.boss.business.rightmanage.operrole.persistent.OperroleVO;

/**
 * <p>Title: OperroleControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/rightmanage/operrole//control/OperroleControlBean"
 name="OperroleControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class OperroleControlBean extends AbstractControlBean
    implements OperroleControl {

    public OperroleVO doCreate(OperroleVO vo, User user)
        throws Exception {
        try{
			OperroleDAO dao = (OperroleDAO) DAOFactory.build(OperroleDAO.class, user.getCityid());
            // TODO  set the pk */
            return (OperroleVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(OperroleVO vo, User user)
        throws Exception {
        try{
			OperroleDAO dao = (OperroleDAO) DAOFactory.build(OperroleDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public OperroleVO doUpdate(OperroleVO vo, User user)
        throws Exception {
        try{
			OperroleDAO dao = (OperroleDAO) DAOFactory.build(OperroleDAO.class, user.getCityid());
            return (OperroleVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public OperroleVO doFindByPk(Serializable pk, User user)
        throws Exception {
			OperroleDAO dao = (OperroleDAO) DAOFactory.build(OperroleDAO.class, user.getCityid());
        return (OperroleVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(OperroleListVO params, User user)
        throws Exception {
			OperroleDAO dao = (OperroleDAO) DAOFactory.build(OperroleDAO.class, user.getCityid());
        return dao.query(params);
    }
    
    public void  doBatchin(OperroleVO vo,User user)throws Exception{
    	OperroleDAO dao = (OperroleDAO) DAOFactory.build(OperroleDAO.class, user.getCityid());
    	OperroleVO pk = new OperroleVO();
    	pk.setOperid(vo.getOperid());
    	pk.setRoleid(vo.getRoleid());
    	pk.setStatus(vo.getStatus());
    	pk.setStatusdate(vo.getStatusdate());
    	OperroleVO getvo = (OperroleVO)dao.findByPk(pk);
    	if (getvo != null){
    		throw new Exception("记录已存在!");
    	}
    	try {
			dao.create(vo);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e.getMessage()+"||"+e.getCause()+"||入库失败");
		}
    }
}
