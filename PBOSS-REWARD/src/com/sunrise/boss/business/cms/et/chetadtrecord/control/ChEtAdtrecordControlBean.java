/**
* auto-generated code
* Tue Jul 31 17:05:40 CST 2012
*/
package com.sunrise.boss.business.cms.et.chetadtrecord.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.et.chetadtrecord.persistent.ChEtAdtrecordVO;
import com.sunrise.boss.business.cms.et.chetadtrecord.persistent.ChEtAdtrecordDAO;
import com.sunrise.boss.business.cms.et.chetadtrecord.persistent.ChEtAdtrecordListVO;

/**
 * <p>Title: ChEtAdtrecordControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/et/chetadtrecord/control/ChEtAdtrecordControlBean"
 name="ChEtAdtrecordControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChEtAdtrecordControlBean extends AbstractControlBean
    implements ChEtAdtrecordControl {

    public ChEtAdtrecordVO doCreate(ChEtAdtrecordVO vo, User user)
        throws Exception {
        try{
			ChEtAdtrecordDAO dao = (ChEtAdtrecordDAO) DAOFactory.build(ChEtAdtrecordDAO.class, user);
            // TODO  set the pk */
            return (ChEtAdtrecordVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChEtAdtrecordVO vo, User user)
        throws Exception {
        try{
			ChEtAdtrecordDAO dao = (ChEtAdtrecordDAO) DAOFactory.build(ChEtAdtrecordDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChEtAdtrecordVO doUpdate(ChEtAdtrecordVO vo, User user)
        throws Exception {
        try{
			ChEtAdtrecordDAO dao = (ChEtAdtrecordDAO) DAOFactory.build(ChEtAdtrecordDAO.class, user);
            return (ChEtAdtrecordVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChEtAdtrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChEtAdtrecordDAO dao = (ChEtAdtrecordDAO) DAOFactory.build(ChEtAdtrecordDAO.class, user);
        return (ChEtAdtrecordVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChEtAdtrecordListVO params, User user)
        throws Exception {
			ChEtAdtrecordDAO dao = (ChEtAdtrecordDAO) DAOFactory.build(ChEtAdtrecordDAO.class, user);
        return dao.query(params);
    }
}
