/**
* auto-generated code
* Tue Jul 07 16:26:52 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtyddtreward.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyddtreward.persistent.ZjtyDdtrewardVO;
import com.sunrise.boss.business.cms.zjty.zjtyddtreward.persistent.ZjtyDdtrewardDAO;
import com.sunrise.boss.business.cms.zjty.zjtyddtreward.persistent.ZjtyDdtrewardListVO;

/**
 * <p>Title: ZjtyDdtrewardControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtyddtreward/control/ZjtyDdtrewardControlBean"
 name="ZjtyDdtrewardControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyDdtrewardControlBean extends AbstractControlBean
    implements ZjtyDdtrewardControl {

    public ZjtyDdtrewardVO doCreate(ZjtyDdtrewardVO vo, User user)
        throws Exception {
        try{
			ZjtyDdtrewardDAO dao = (ZjtyDdtrewardDAO) DAOFactory.build(ZjtyDdtrewardDAO.class, user);
            // TODO  set the pk */
            return (ZjtyDdtrewardVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ZjtyDdtrewardVO vo, User user)
        throws Exception {
        try{
			ZjtyDdtrewardDAO dao = (ZjtyDdtrewardDAO) DAOFactory.build(ZjtyDdtrewardDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyDdtrewardVO doUpdate(ZjtyDdtrewardVO vo, User user)
        throws Exception {
        try{
			ZjtyDdtrewardDAO dao = (ZjtyDdtrewardDAO) DAOFactory.build(ZjtyDdtrewardDAO.class, user);
            return (ZjtyDdtrewardVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyDdtrewardVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyDdtrewardDAO dao = (ZjtyDdtrewardDAO) DAOFactory.build(ZjtyDdtrewardDAO.class, user);
        return (ZjtyDdtrewardVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ZjtyDdtrewardListVO params, User user)
        throws Exception {
			ZjtyDdtrewardDAO dao = (ZjtyDdtrewardDAO) DAOFactory.build(ZjtyDdtrewardDAO.class, user);
        return dao.query(params);
    }
}
