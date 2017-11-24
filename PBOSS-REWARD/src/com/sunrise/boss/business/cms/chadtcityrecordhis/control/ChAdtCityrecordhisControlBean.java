/**
* auto-generated code
* Mon Sep 03 20:43:09 CST 2012
*/
package com.sunrise.boss.business.cms.chadtcityrecordhis.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtcityrecordhis.persistent.ChAdtCityrecordhisVO;
import com.sunrise.boss.business.cms.chadtcityrecordhis.persistent.ChAdtCityrecordhisDAO;
import com.sunrise.boss.business.cms.chadtcityrecordhis.persistent.ChAdtCityrecordhisListVO;

/**
 * <p>Title: ChAdtCityrecordhisControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chadtcityrecordhis/control/ChAdtCityrecordhisControlBean"
 name="ChAdtCityrecordhisControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChAdtCityrecordhisControlBean extends AbstractControlBean
    implements ChAdtCityrecordhisControl {

    public ChAdtCityrecordhisVO doCreate(ChAdtCityrecordhisVO vo, User user)
        throws Exception {
        try{
			ChAdtCityrecordhisDAO dao = (ChAdtCityrecordhisDAO) DAOFactory.build(ChAdtCityrecordhisDAO.class, user);
            // TODO  set the pk */
            return (ChAdtCityrecordhisVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChAdtCityrecordhisVO vo, User user)
        throws Exception {
        try{
			ChAdtCityrecordhisDAO dao = (ChAdtCityrecordhisDAO) DAOFactory.build(ChAdtCityrecordhisDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtCityrecordhisVO doUpdate(ChAdtCityrecordhisVO vo, User user)
        throws Exception {
        try{
			ChAdtCityrecordhisDAO dao = (ChAdtCityrecordhisDAO) DAOFactory.build(ChAdtCityrecordhisDAO.class, user);
            return (ChAdtCityrecordhisVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtCityrecordhisVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChAdtCityrecordhisDAO dao = (ChAdtCityrecordhisDAO) DAOFactory.build(ChAdtCityrecordhisDAO.class, user);
        return (ChAdtCityrecordhisVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChAdtCityrecordhisListVO params, User user)throws Exception {
    	ChAdtCityrecordhisDAO dao = (ChAdtCityrecordhisDAO) DAOFactory.build(ChAdtCityrecordhisDAO.class, user);
    	String countyid = params.get_se_countyid();
    	if(countyid!=null && countyid.trim().length()>0){//分公司数据查询呢
    		params.getQueryConditions().put("countyid", countyid);
    		params.set_se_countyid(null);
    		return dao.queryByNamedSqlQuery("com.sunrise.boss.business.cms.chadtcityrecordhis.persistent.ChAdtCityrecordhis.doQuerylistcounty", params);
    	}else{
    		return dao.queryByNamedSqlQuery("com.sunrise.boss.business.cms.chadtcityrecordhis.persistent.ChAdtCityrecordhis.doQuerylist", params);
    	}
    }
}
