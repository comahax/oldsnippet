/**
* auto-generated code
* Fri Jun 24 11:00:35 CST 2011
*/
package com.sunrise.boss.business.cms.reward.chadtimportrecord.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.chadtimportrecord.persistent.ChadtimportrecordDAO;
import com.sunrise.boss.business.cms.reward.chadtimportrecord.persistent.ChadtimportrecordListVO;
import com.sunrise.boss.business.cms.reward.chadtimportrecord.persistent.ChadtimportrecordVO;

/**
 * <p>Title: ChAdtImportrecordControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/chadtimportrecord/control/ChAdtImportrecordControlBean"
 name="ChAdtImportrecordControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChadtimportrecordControlBean extends AbstractControlBean
    implements ChadtimportrecordControl {

    public ChadtimportrecordVO doCreate(ChadtimportrecordVO vo, User user)
        throws Exception {
        try{
			ChadtimportrecordDAO dao = (ChadtimportrecordDAO) DAOFactory.build(ChadtimportrecordDAO.class, user);
            // TODO  set the pk */
            return (ChadtimportrecordVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChadtimportrecordVO vo, User user)
        throws Exception {
        try{
			ChadtimportrecordDAO dao = (ChadtimportrecordDAO) DAOFactory.build(ChadtimportrecordDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChadtimportrecordVO doUpdate(ChadtimportrecordVO vo, User user)
        throws Exception {
        try{
			ChadtimportrecordDAO dao = (ChadtimportrecordDAO) DAOFactory.build(ChadtimportrecordDAO.class, user);
            return (ChadtimportrecordVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChadtimportrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChadtimportrecordDAO dao = (ChadtimportrecordDAO) DAOFactory.build(ChadtimportrecordDAO.class, user);
        return (ChadtimportrecordVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChadtimportrecordListVO params, User user)
        throws Exception {
			ChadtimportrecordDAO dao = (ChadtimportrecordDAO) DAOFactory.build(ChadtimportrecordDAO.class, user);
        return dao.query(params);
    }
}
