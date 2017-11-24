/**
* auto-generated code
* Fri Dec 30 15:15:14 CST 2011
*/
package com.sunrise.boss.business.cms.zjty.zjtystdreward.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtystdreward.persistent.ZjtyStdrewardVO;
import com.sunrise.boss.business.cms.zjty.zjtystdreward.persistent.ZjtyStdrewardDAO;
import com.sunrise.boss.business.cms.zjty.zjtystdreward.persistent.ZjtyStdrewardListVO;

/**
 * <p>Title: ZjtyStdrewardControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtystdreward/control/ZjtyStdrewardControlBean"
 name="ZjtyStdrewardControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyStdrewardControlBean extends AbstractControlBean
    implements ZjtyStdrewardControl {

    public ZjtyStdrewardVO doCreate(ZjtyStdrewardVO vo, User user)
        throws Exception {
        try{
			ZjtyStdrewardDAO dao = (ZjtyStdrewardDAO) DAOFactory.build(ZjtyStdrewardDAO.class, user);
            // TODO  set the pk */
            return (ZjtyStdrewardVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ZjtyStdrewardVO vo, User user)
        throws Exception {
        try{
			ZjtyStdrewardDAO dao = (ZjtyStdrewardDAO) DAOFactory.build(ZjtyStdrewardDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyStdrewardVO doUpdate(ZjtyStdrewardVO vo, User user)
        throws Exception {
        try{
			ZjtyStdrewardDAO dao = (ZjtyStdrewardDAO) DAOFactory.build(ZjtyStdrewardDAO.class, user);
            return (ZjtyStdrewardVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyStdrewardVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyStdrewardDAO dao = (ZjtyStdrewardDAO) DAOFactory.build(ZjtyStdrewardDAO.class, user);
        return (ZjtyStdrewardVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ZjtyStdrewardListVO params, User user)
        throws Exception {
			ZjtyStdrewardDAO dao = (ZjtyStdrewardDAO) DAOFactory.build(ZjtyStdrewardDAO.class, user);
        return dao.query(params);
    }
}
