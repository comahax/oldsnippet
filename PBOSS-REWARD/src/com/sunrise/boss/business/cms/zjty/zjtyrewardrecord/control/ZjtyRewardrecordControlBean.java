/**
* auto-generated code
* Tue Feb 28 17:21:47 CST 2012
*/
package com.sunrise.boss.business.cms.zjty.zjtyrewardrecord.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyrewardrecord.persistent.ZjtyRewardrecordVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardrecord.persistent.ZjtyRewardrecordDAO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardrecord.persistent.ZjtyRewardrecordListVO;

/**
 * <p>Title: ZjtyRewardrecordControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtyrewardrecord/control/ZjtyRewardrecordControlBean"
 name="ZjtyRewardrecordControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyRewardrecordControlBean extends AbstractControlBean
    implements ZjtyRewardrecordControl {

    public ZjtyRewardrecordVO doCreate(ZjtyRewardrecordVO vo, User user)
        throws Exception {
        try{
			ZjtyRewardrecordDAO dao = (ZjtyRewardrecordDAO) DAOFactory.build(ZjtyRewardrecordDAO.class, user);
            // TODO  set the pk */
            return (ZjtyRewardrecordVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ZjtyRewardrecordVO vo, User user)
        throws Exception {
        try{
			ZjtyRewardrecordDAO dao = (ZjtyRewardrecordDAO) DAOFactory.build(ZjtyRewardrecordDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyRewardrecordVO doUpdate(ZjtyRewardrecordVO vo, User user)
        throws Exception {
        try{
			ZjtyRewardrecordDAO dao = (ZjtyRewardrecordDAO) DAOFactory.build(ZjtyRewardrecordDAO.class, user);
            return (ZjtyRewardrecordVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyRewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyRewardrecordDAO dao = (ZjtyRewardrecordDAO) DAOFactory.build(ZjtyRewardrecordDAO.class, user);
        return (ZjtyRewardrecordVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ZjtyRewardrecordListVO params, User user)
        throws Exception {
    	if (params.get_ne_rewardtype() != null && params.get_ne_rewardtype().equals("0")) {
    		params.set_sql_rewardtype(" (rewardtype = 0 or rewardtype is null) ");
    		params.set_ne_rewardtype(null);
    	}
//    	if (params.get_ne_noncyc() != null && params.get_ne_noncyc().equals("1")) {
//    		params.set_sql_noncyc(" (noncyc = 1 or noncyc is null) ");
//    		params.set_ne_noncyc(null);
//    	}
    	if (params.get_ne_noncyc() != null && params.get_ne_noncyc().equals("0")) {
    		params.set_sql_noncyc(" nvl(noncyc,0) = 0 ");
    		params.set_ne_noncyc(null);
    	}
		ZjtyRewardrecordDAO dao = (ZjtyRewardrecordDAO) DAOFactory.build(ZjtyRewardrecordDAO.class, user);
        return dao.query(params);
    }
}
