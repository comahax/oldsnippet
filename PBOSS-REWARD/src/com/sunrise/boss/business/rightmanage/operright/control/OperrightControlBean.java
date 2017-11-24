/**
* auto-generated code
* Fri Oct 20 01:01:43 CST 2006
*/
package com.sunrise.boss.business.rightmanage.operright.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.rightmanage.operright.persistent.OperrightDAO;
import com.sunrise.boss.business.rightmanage.operright.persistent.OperrightListVO;
import com.sunrise.boss.business.rightmanage.operright.persistent.OperrightVO;

/**
 * <p>Title: OperrightControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/rightmanage/operright/control/OperrightControlBean"
 name="OperrightControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class OperrightControlBean extends AbstractControlBean
    implements OperrightControl {

    public OperrightVO doCreate(OperrightVO vo, User user)
        throws Exception {
        try{
			OperrightDAO dao = (OperrightDAO) DAOFactory.build(OperrightDAO.class, user.getCityid());
            // TODO  set the pk */
            return (OperrightVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(OperrightVO vo, User user)
        throws Exception {
        try{
			OperrightDAO dao = (OperrightDAO) DAOFactory.build(OperrightDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public OperrightVO doUpdate(OperrightVO vo, User user)
        throws Exception {
        try{
			OperrightDAO dao = (OperrightDAO) DAOFactory.build(OperrightDAO.class, user.getCityid());
            return (OperrightVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public OperrightVO doFindByPk(Serializable pk, User user)
        throws Exception {
			OperrightDAO dao = (OperrightDAO) DAOFactory.build(OperrightDAO.class, user.getCityid());
        return (OperrightVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(OperrightListVO params, User user)
        throws Exception {
			OperrightDAO dao = (OperrightDAO) DAOFactory.build(OperrightDAO.class, user.getCityid());
        return dao.query(params);
    }
    public void doBatchin(OperrightVO vo,User user)throws Exception{
    	OperrightDAO dao = (OperrightDAO) DAOFactory.build(OperrightDAO.class, user.getCityid());
    	OperrightVO pk = new OperrightVO();
    	pk.setOperid(vo.getOperid());
    	pk.setRightid(vo.getRightid());
    	pk.setCreatedate(vo.getCreatedate());
    	pk.setStatus(vo.getStatus());
    	OperrightVO newvo =(OperrightVO) dao.findByPk(pk);
    	if (newvo != null){
    		throw new Exception("¼ÇÂ¼ÒÑ´æÔÚ");
    	}
		try {
			vo.setFlag(new Byte("1"));
			vo.setSortorder(new Short("1"));
			dao.create(vo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}    	
    }
}
