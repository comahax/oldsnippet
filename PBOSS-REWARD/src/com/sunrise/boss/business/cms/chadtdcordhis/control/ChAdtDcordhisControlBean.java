/**
* auto-generated code
* Tue Aug 21 12:28:54 CST 2012
*/
package com.sunrise.boss.business.cms.chadtdcordhis.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtdcordhis.persistent.ChAdtDcordhisVO;
import com.sunrise.boss.business.cms.chadtdcordhis.persistent.ChAdtDcordhisDAO;
import com.sunrise.boss.business.cms.chadtdcordhis.persistent.ChAdtDcordhisListVO;

/**
 * <p>Title: ChAdtDcordhisControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chadtdcordhis/control/ChAdtDcordhisControlBean"
 name="ChAdtDcordhisControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChAdtDcordhisControlBean extends AbstractControlBean
    implements ChAdtDcordhisControl {

    public ChAdtDcordhisVO doCreate(ChAdtDcordhisVO vo, User user)
        throws Exception {
        try{
			ChAdtDcordhisDAO dao = (ChAdtDcordhisDAO) DAOFactory.build(ChAdtDcordhisDAO.class, user);
            // TODO  set the pk */
            return (ChAdtDcordhisVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChAdtDcordhisVO vo, User user)
        throws Exception {
        try{
			ChAdtDcordhisDAO dao = (ChAdtDcordhisDAO) DAOFactory.build(ChAdtDcordhisDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtDcordhisVO doUpdate(ChAdtDcordhisVO vo, User user)
        throws Exception {
        try{
			ChAdtDcordhisDAO dao = (ChAdtDcordhisDAO) DAOFactory.build(ChAdtDcordhisDAO.class, user);
            return (ChAdtDcordhisVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtDcordhisVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChAdtDcordhisDAO dao = (ChAdtDcordhisDAO) DAOFactory.build(ChAdtDcordhisDAO.class, user);
        return (ChAdtDcordhisVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChAdtDcordhisListVO params, User user)
        throws Exception {
			ChAdtDcordhisDAO dao = (ChAdtDcordhisDAO) DAOFactory.build(ChAdtDcordhisDAO.class, user);
        return dao.query(params);
    }
}
