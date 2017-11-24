/**
* auto-generated code
* Fri Feb 13 09:03:29 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtyemployeedetail.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyemployeedetail.persistent.ZjtyEmployeedetailVO;
import com.sunrise.boss.business.cms.zjty.zjtyemployeedetail.persistent.ZjtyEmployeedetailDAO;
import com.sunrise.boss.business.cms.zjty.zjtyemployeedetail.persistent.ZjtyEmployeedetailListVO;

/**
 * <p>Title: ZjtyEmployeedetailControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtyemployeedetail/control/ZjtyEmployeedetailControlBean"
 name="ZjtyEmployeedetailControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyEmployeedetailControlBean extends AbstractControlBean
    implements ZjtyEmployeedetailControl {

    public ZjtyEmployeedetailVO doCreate(ZjtyEmployeedetailVO vo, User user)
        throws Exception {
        try{
			ZjtyEmployeedetailDAO dao = (ZjtyEmployeedetailDAO) DAOFactory.build(ZjtyEmployeedetailDAO.class, user);
            // TODO  set the pk */
            return (ZjtyEmployeedetailVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ZjtyEmployeedetailVO vo, User user)
        throws Exception {
        try{
			ZjtyEmployeedetailDAO dao = (ZjtyEmployeedetailDAO) DAOFactory.build(ZjtyEmployeedetailDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyEmployeedetailVO doUpdate(ZjtyEmployeedetailVO vo, User user)
        throws Exception {
        try{
			ZjtyEmployeedetailDAO dao = (ZjtyEmployeedetailDAO) DAOFactory.build(ZjtyEmployeedetailDAO.class, user.getCityid());
            return (ZjtyEmployeedetailVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyEmployeedetailVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyEmployeedetailDAO dao = (ZjtyEmployeedetailDAO) DAOFactory.build(ZjtyEmployeedetailDAO.class, user.getCityid());
        return (ZjtyEmployeedetailVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ZjtyEmployeedetailListVO params, User user)
        throws Exception {
			ZjtyEmployeedetailDAO dao = (ZjtyEmployeedetailDAO) DAOFactory.build(ZjtyEmployeedetailDAO.class, user.getCityid());
        return dao.query(params);
    }
}
