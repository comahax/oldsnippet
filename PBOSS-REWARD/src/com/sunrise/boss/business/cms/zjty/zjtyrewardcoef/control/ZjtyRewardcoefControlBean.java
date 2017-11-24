/**
* auto-generated code
* Fri Oct 24 09:17:11 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.persistent.ZjtyRewardcoefVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.persistent.ZjtyRewardcoefDAO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.persistent.ZjtyRewardcoefListVO;

/**
 * <p>Title: ZjtyRewardcoefControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtyrewardcoef/control/ZjtyRewardcoefControlBean"
 name="ZjtyRewardcoefControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyRewardcoefControlBean extends AbstractControlBean
    implements ZjtyRewardcoefControl {

    public ZjtyRewardcoefVO doSave(ZjtyRewardcoefVO vo, User user)
        throws Exception {
        try{
			ZjtyRewardcoefDAO dao = (ZjtyRewardcoefDAO) DAOFactory.build(ZjtyRewardcoefDAO.class, user);
            // TODO  set the pk */
            return (ZjtyRewardcoefVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ZjtyRewardcoefVO vo, User user)
        throws Exception {
        try{
			ZjtyRewardcoefDAO dao = (ZjtyRewardcoefDAO) DAOFactory.build(ZjtyRewardcoefDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyRewardcoefVO doUpdate(ZjtyRewardcoefVO vo, User user)
        throws Exception {
        try{
			ZjtyRewardcoefDAO dao = (ZjtyRewardcoefDAO) DAOFactory.build(ZjtyRewardcoefDAO.class, user);
            return (ZjtyRewardcoefVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyRewardcoefVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyRewardcoefDAO dao = (ZjtyRewardcoefDAO) DAOFactory.build(ZjtyRewardcoefDAO.class, user);
        return (ZjtyRewardcoefVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ZjtyRewardcoefListVO params, User user)
        throws Exception {
			ZjtyRewardcoefDAO dao = (ZjtyRewardcoefDAO) DAOFactory.build(ZjtyRewardcoefDAO.class, user);
        return dao.query(params);
    }
}
