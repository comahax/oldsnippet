/**
* auto-generated code
* Tue Feb 22 09:29:17 CST 2011
*/
package com.sunrise.boss.business.cms.chadtdictparam.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamVO;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamDAO;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamListVO;

/**
 * <p>Title: ChAdtDictparamControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chadtdictparam/control/ChAdtDictparamControlBean"
 name="ChAdtDictparamControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChAdtDictparamControlBean extends AbstractControlBean
    implements ChAdtDictparamControl {

    public ChAdtDictparamVO doCreate(ChAdtDictparamVO vo, User user)
        throws Exception {
        try{
			ChAdtDictparamDAO dao = (ChAdtDictparamDAO) DAOFactory.build(ChAdtDictparamDAO.class, user);
            // TODO  set the pk */
            return (ChAdtDictparamVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChAdtDictparamVO vo, User user)
        throws Exception {
        try{
			ChAdtDictparamDAO dao = (ChAdtDictparamDAO) DAOFactory.build(ChAdtDictparamDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtDictparamVO doUpdate(ChAdtDictparamVO vo, User user)
        throws Exception {
        try{
			ChAdtDictparamDAO dao = (ChAdtDictparamDAO) DAOFactory.build(ChAdtDictparamDAO.class, user);
            return (ChAdtDictparamVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtDictparamVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChAdtDictparamDAO dao = (ChAdtDictparamDAO) DAOFactory.build(ChAdtDictparamDAO.class, user);
        return (ChAdtDictparamVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChAdtDictparamListVO params, User user)
        throws Exception {
			ChAdtDictparamDAO dao = (ChAdtDictparamDAO) DAOFactory.build(ChAdtDictparamDAO.class, user);
        return dao.query(params);
    }
}
