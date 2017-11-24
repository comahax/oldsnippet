/**
* auto-generated code
* Mon Dec 19 14:58:11 CST 2011
*/
package com.sunrise.boss.business.cms.chadtdictidname.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemDAO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.cms.chadtdictidname.persistent.ChAdtDictidnameVO;
import com.sunrise.boss.business.cms.chadtdictidname.persistent.ChAdtDictidnameDAO;
import com.sunrise.boss.business.cms.chadtdictidname.persistent.ChAdtDictidnameListVO;

/**
 * <p>Title: ChAdtDictidnameControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chadtdictidname/control/ChAdtDictidnameControlBean"
 name="ChAdtDictidnameControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChAdtDictidnameControlBean extends AbstractControlBean
    implements ChAdtDictidnameControl {

    public ChAdtDictidnameVO doCreate(ChAdtDictidnameVO vo, User user)
        throws Exception {
        try{
			ChAdtDictidnameDAO dao = (ChAdtDictidnameDAO) DAOFactory.build(ChAdtDictidnameDAO.class, user);
            // TODO  set the pk */
            return (ChAdtDictidnameVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChAdtDictidnameVO vo, User user)
        throws Exception {
        try{
			ChAdtDictidnameDAO dao = (ChAdtDictidnameDAO) DAOFactory.build(ChAdtDictidnameDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtDictidnameVO doUpdate(ChAdtDictidnameVO vo, User user)
        throws Exception {
        try{
			ChAdtDictidnameDAO dao = (ChAdtDictidnameDAO) DAOFactory.build(ChAdtDictidnameDAO.class, user);
            return (ChAdtDictidnameVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtDictidnameVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChAdtDictidnameDAO dao = (ChAdtDictidnameDAO) DAOFactory.build(ChAdtDictidnameDAO.class, user);
        return (ChAdtDictidnameVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChAdtDictidnameListVO params, User user)
        throws Exception {
    	
    	ChAdtDictidnameDAO chAdtDictidnameDAO = (ChAdtDictidnameDAO) DAOFactory.build(ChAdtDictidnameDAO.class, user);
    	DataPackage dp = chAdtDictidnameDAO.query(params);   	
        
    	return dp;
    }

	public DataPackage doQuerySelf(ChAdtDictidnameListVO params, User user)
			throws Exception {
		ChAdtDictidnameDAO dao = (ChAdtDictidnameDAO) DAOFactory.build(ChAdtDictidnameDAO.class, user);
        return dao.querySelf(params);
	}
}
