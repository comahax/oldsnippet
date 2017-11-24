/**
* auto-generated code
* Wed Feb 29 11:21:27 CST 2012
*/
package com.sunrise.boss.business.cms.zjty.zjtyfailrecord.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyfailrecord.persistent.ZjtyFailrecordVO;
import com.sunrise.boss.business.cms.zjty.zjtyfailrecord.persistent.ZjtyFailrecordDAO;
import com.sunrise.boss.business.cms.zjty.zjtyfailrecord.persistent.ZjtyFailrecordListVO;

/**
 * <p>Title: ZjtyFailrecordControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtyfailrecord/control/ZjtyFailrecordControlBean"
 name="ZjtyFailrecordControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyFailrecordControlBean extends AbstractControlBean
    implements ZjtyFailrecordControl {

    public ZjtyFailrecordVO doCreate(ZjtyFailrecordVO vo, User user)
        throws Exception {
        try{
			ZjtyFailrecordDAO dao = (ZjtyFailrecordDAO) DAOFactory.build(ZjtyFailrecordDAO.class, user);
            // TODO  set the pk */
            return (ZjtyFailrecordVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ZjtyFailrecordVO vo, User user)
        throws Exception {
        try{
			ZjtyFailrecordDAO dao = (ZjtyFailrecordDAO) DAOFactory.build(ZjtyFailrecordDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyFailrecordVO doUpdate(ZjtyFailrecordVO vo, User user)
        throws Exception {
        try{
			ZjtyFailrecordDAO dao = (ZjtyFailrecordDAO) DAOFactory.build(ZjtyFailrecordDAO.class, user);
            return (ZjtyFailrecordVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyFailrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyFailrecordDAO dao = (ZjtyFailrecordDAO) DAOFactory.build(ZjtyFailrecordDAO.class, user);
        return (ZjtyFailrecordVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ZjtyFailrecordListVO params, User user)
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
		ZjtyFailrecordDAO dao = (ZjtyFailrecordDAO) DAOFactory.build(ZjtyFailrecordDAO.class, user);
        return dao.query(params);
    }
}
