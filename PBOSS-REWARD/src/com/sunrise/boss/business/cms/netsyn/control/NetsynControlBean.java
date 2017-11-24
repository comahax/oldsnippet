/**
* auto-generated code
* Tue Jan 08 15:44:14 CST 2008
*/
package com.sunrise.boss.business.cms.netsyn.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.netsyn.persistent.NetsynVO;
import com.sunrise.boss.business.cms.netsyn.persistent.NetsynDAO;
import com.sunrise.boss.business.cms.netsyn.persistent.NetsynListVO;

/**
 * <p>Title: NetsynControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Cai Jianhui
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/netsyn/control/NetsynControlBean"
 name="NetsynControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class NetsynControlBean extends AbstractControlBean
    implements NetsynControl {

    public NetsynVO doCreate(NetsynVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         NetsynDAO dao = (NetsynDAO) DAOFactory.build(NetsynDAO.class, user);
            return (NetsynVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(NetsynVO vo, User user)
        throws Exception {
        try{
         NetsynDAO dao = (NetsynDAO) DAOFactory.build(NetsynDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public NetsynVO doUpdate(NetsynVO vo, User user)
        throws Exception {
        try{
         NetsynDAO dao = (NetsynDAO) DAOFactory.build(NetsynDAO.class, user);
            return (NetsynVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public NetsynVO doFindByPk(Serializable pk, User user)
        throws Exception {
         NetsynDAO dao = (NetsynDAO) DAOFactory.build(NetsynDAO.class, user);
        return (NetsynVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(NetsynListVO params, User user)
        throws Exception {
         NetsynDAO dao = (NetsynDAO) DAOFactory.build(NetsynDAO.class, user);
        return dao.query(params);
    }
}
