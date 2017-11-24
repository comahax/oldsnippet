/**
* auto-generated code
* Thu Dec 24 14:22:12 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtycompcoef.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtycompcoef.persistent.ZjtyCompcoefVO;
import com.sunrise.boss.business.cms.zjty.zjtycompcoef.persistent.ZjtyCompcoefDAO;
import com.sunrise.boss.business.cms.zjty.zjtycompcoef.persistent.ZjtyCompcoefListVO;

/**
 * <p>Title: ZjtyCompcoefControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtycompcoef/control/ZjtyCompcoefControlBean"
 name="ZjtyCompcoefControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyCompcoefControlBean extends AbstractControlBean
    implements ZjtyCompcoefControl {

    public ZjtyCompcoefVO doCreate(ZjtyCompcoefVO vo, User user)
        throws Exception {
        try{
			ZjtyCompcoefDAO dao = (ZjtyCompcoefDAO) DAOFactory.build(ZjtyCompcoefDAO.class, user);
            // TODO  set the pk */
            return (ZjtyCompcoefVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ZjtyCompcoefVO vo, User user)
        throws Exception {
        try{
			ZjtyCompcoefDAO dao = (ZjtyCompcoefDAO) DAOFactory.build(ZjtyCompcoefDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyCompcoefVO doUpdate(ZjtyCompcoefVO vo, User user)
        throws Exception {
        try{
			ZjtyCompcoefDAO dao = (ZjtyCompcoefDAO) DAOFactory.build(ZjtyCompcoefDAO.class, user);
            return (ZjtyCompcoefVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyCompcoefVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyCompcoefDAO dao = (ZjtyCompcoefDAO) DAOFactory.build(ZjtyCompcoefDAO.class, user);
        return (ZjtyCompcoefVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ZjtyCompcoefListVO params, User user)
        throws Exception {
			ZjtyCompcoefDAO dao = (ZjtyCompcoefDAO) DAOFactory.build(ZjtyCompcoefDAO.class, user);
        return dao.query(params);
    }
}
