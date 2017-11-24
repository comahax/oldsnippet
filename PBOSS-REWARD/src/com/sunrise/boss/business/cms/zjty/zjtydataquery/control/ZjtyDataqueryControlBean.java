/**
* auto-generated code
* Tue Jan 05 15:32:41 CST 2010
*/
package com.sunrise.boss.business.cms.zjty.zjtydataquery.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtydataquery.persistent.ZjtyDataqueryVO;
import com.sunrise.boss.business.cms.zjty.zjtydataquery.persistent.ZjtyDataqueryDAO;
import com.sunrise.boss.business.cms.zjty.zjtydataquery.persistent.ZjtyDataqueryListVO;

/**
 * <p>Title: ZjtyDataqueryControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtydataquery/control/ZjtyDataqueryControlBean"
 name="ZjtyDataqueryControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyDataqueryControlBean extends AbstractControlBean
    implements ZjtyDataqueryControl {

    public ZjtyDataqueryVO doCreate(ZjtyDataqueryVO vo, User user)
        throws Exception {
        try{
			ZjtyDataqueryDAO dao = (ZjtyDataqueryDAO) DAOFactory.build(ZjtyDataqueryDAO.class, user);
            // TODO  set the pk */
            return (ZjtyDataqueryVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ZjtyDataqueryVO vo, User user)
        throws Exception {
        try{
			ZjtyDataqueryDAO dao = (ZjtyDataqueryDAO) DAOFactory.build(ZjtyDataqueryDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyDataqueryVO doUpdate(ZjtyDataqueryVO vo, User user)
        throws Exception {
        try{
			ZjtyDataqueryDAO dao = (ZjtyDataqueryDAO) DAOFactory.build(ZjtyDataqueryDAO.class, user);
            return (ZjtyDataqueryVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyDataqueryVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyDataqueryDAO dao = (ZjtyDataqueryDAO) DAOFactory.build(ZjtyDataqueryDAO.class, user);
        return (ZjtyDataqueryVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ZjtyDataqueryListVO params, User user)
        throws Exception {
			ZjtyDataqueryDAO dao = (ZjtyDataqueryDAO) DAOFactory.build(ZjtyDataqueryDAO.class, user);
        return dao.query(params);
    }
    
    public DataPackage doQueryBosssucc(ZjtyDataqueryListVO params, User user)
    	throws Exception {
			ZjtyDataqueryDAO dao = (ZjtyDataqueryDAO) DAOFactory.build(ZjtyDataqueryDAO.class, user);
		return dao.queryBosssucc(params);
    }
    
    public DataPackage doQueryBossfail(ZjtyDataqueryListVO params, User user)
		throws Exception {
			ZjtyDataqueryDAO dao = (ZjtyDataqueryDAO) DAOFactory.build(ZjtyDataqueryDAO.class, user);
		return dao.queryBossfail(params);
    }
    
    public DataPackage doQueryBossjlsucc(ZjtyDataqueryListVO params, User user)
		throws Exception {
		ZjtyDataqueryDAO dao = (ZjtyDataqueryDAO) DAOFactory.build(ZjtyDataqueryDAO.class, user);
		return dao.queryBossjlsucc(params);
    }
    
    public DataPackage doQueryBossjlfail(ZjtyDataqueryListVO params, User user)
		throws Exception {
    	ZjtyDataqueryDAO dao = (ZjtyDataqueryDAO) DAOFactory.build(ZjtyDataqueryDAO.class, user);
    	return dao.queryBossjlfail(params);
    }
    
    public DataPackage doQuerySalesucc(ZjtyDataqueryListVO params, User user)
		throws Exception {
    	ZjtyDataqueryDAO dao = (ZjtyDataqueryDAO) DAOFactory.build(ZjtyDataqueryDAO.class, user);
    	return dao.querySalesucc(params);
    }

    public DataPackage doQuerySalefail(ZjtyDataqueryListVO params, User user)
		throws Exception {
    	ZjtyDataqueryDAO dao = (ZjtyDataqueryDAO) DAOFactory.build(ZjtyDataqueryDAO.class, user);
    	return dao.querySalefail(params);
    }
    
    public DataPackage doQueryTmnalsucc(ZjtyDataqueryListVO params, User user)
		throws Exception {
    	ZjtyDataqueryDAO dao = (ZjtyDataqueryDAO) DAOFactory.build(ZjtyDataqueryDAO.class, user);
    	return dao.queryTmnalsucc(params);
    }

    public DataPackage doQueryTmnalfail(ZjtyDataqueryListVO params, User user)
		throws Exception {
    	ZjtyDataqueryDAO dao = (ZjtyDataqueryDAO) DAOFactory.build(ZjtyDataqueryDAO.class, user);
    	return dao.queryTmnalfail(params);
}
}
