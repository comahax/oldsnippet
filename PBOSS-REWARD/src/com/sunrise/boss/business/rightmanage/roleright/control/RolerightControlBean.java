/**
* auto-generated code
* Thu Oct 19 17:09:08 CST 2006
*/
package com.sunrise.boss.business.rightmanage.roleright.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.rightmanage.roleright.persistent.RolerightDAO;
import com.sunrise.boss.business.rightmanage.roleright.persistent.RolerightListVO;
import com.sunrise.boss.business.rightmanage.roleright.persistent.RolerightVO;

/**
 * <p>Title: RolerightControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/rightmanage/roleright/control/RolerightControlBean"
 name="RolerightControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RolerightControlBean extends AbstractControlBean
    implements RolerightControl {

    public RolerightVO doCreate(RolerightVO vo, User user)
        throws Exception {
        try{
			RolerightDAO dao = (RolerightDAO) DAOFactory.build(RolerightDAO.class, user.getCityid());
            // TODO  set the pk */
            return (RolerightVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RolerightVO vo, User user)
        throws Exception {
        try{
			RolerightDAO dao = (RolerightDAO) DAOFactory.build(RolerightDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RolerightVO doUpdate(RolerightVO vo, User user)
        throws Exception {
        try{
			RolerightDAO dao = (RolerightDAO) DAOFactory.build(RolerightDAO.class, user.getCityid());
            return (RolerightVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RolerightVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RolerightDAO dao = (RolerightDAO) DAOFactory.build(RolerightDAO.class, user.getCityid());
        return (RolerightVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RolerightListVO params, User user)
        throws Exception {
			RolerightDAO dao = (RolerightDAO) DAOFactory.build(RolerightDAO.class, user.getCityid());
        return dao.query(params);
    }
    public void doBatchin(RolerightVO vo,User user)throws Exception{
    	RolerightDAO dao = (RolerightDAO) DAOFactory.build(RolerightDAO.class, user.getCityid());
    	RolerightVO pk = new RolerightVO();
    	pk.setItemid(vo.getItemid());
    	pk.setRightid(vo.getRightid());
    	RolerightVO getvo = (RolerightVO)dao.findByPk(pk);
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
