/**
* auto-generated code
* Wed Dec 24 15:55:56 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.persistent.ZjtyRewarddetailVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.persistent.ZjtyRewarddetailDAO;
import com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.persistent.ZjtyRewarddetailListVO;

/**
 * <p>Title: ZjtyRewarddetailControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtyrewarddetail/control/ZjtyRewarddetailControlBean"
 name="ZjtyRewarddetailControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyRewarddetailControlBean extends AbstractControlBean
    implements ZjtyRewarddetailControl {

    public ZjtyRewarddetailVO doCreate(ZjtyRewarddetailVO vo, User user)
        throws Exception {
        try{
			ZjtyRewarddetailDAO dao = (ZjtyRewarddetailDAO) DAOFactory.build(ZjtyRewarddetailDAO.class, user);
            // TODO  set the pk */
            return (ZjtyRewarddetailVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ZjtyRewarddetailVO vo, User user)
        throws Exception {
        try{
			ZjtyRewarddetailDAO dao = (ZjtyRewarddetailDAO) DAOFactory.build(ZjtyRewarddetailDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyRewarddetailVO doUpdate(ZjtyRewarddetailVO vo, User user)
        throws Exception {
        try{
			ZjtyRewarddetailDAO dao = (ZjtyRewarddetailDAO) DAOFactory.build(ZjtyRewarddetailDAO.class, user);
            return (ZjtyRewarddetailVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyRewarddetailVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyRewarddetailDAO dao = (ZjtyRewarddetailDAO) DAOFactory.build(ZjtyRewarddetailDAO.class, user);
        return (ZjtyRewarddetailVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ZjtyRewarddetailListVO params, User user)
        throws Exception {
			ZjtyRewarddetailDAO dao = (ZjtyRewarddetailDAO) DAOFactory.build(ZjtyRewarddetailDAO.class, user);
        return dao.query(params);
    }
    public DataPackage doQuerybyType(ZjtyRewarddetailListVO params, User user)
    throws Exception {
		ZjtyRewarddetailDAO dao = (ZjtyRewarddetailDAO) DAOFactory.build(ZjtyRewarddetailDAO.class, user);
	    return dao.querybyType(params);
	}
}
