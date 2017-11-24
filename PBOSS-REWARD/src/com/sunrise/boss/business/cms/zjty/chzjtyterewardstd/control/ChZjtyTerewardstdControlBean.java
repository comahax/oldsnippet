/**
* auto-generated code
* Mon Apr 08 15:52:02 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtyterewardstd.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyterewardstd.persistent.ChZjtyTerewardstdVO;
import com.sunrise.boss.business.cms.zjty.chzjtyterewardstd.persistent.ChZjtyTerewardstdDAO;
import com.sunrise.boss.business.cms.zjty.chzjtyterewardstd.persistent.ChZjtyTerewardstdListVO;

/**
 * <p>Title: ChZjtyTerewardstdControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/chzjtyterewardstd/control/ChZjtyTerewardstdControlBean"
 name="ChZjtyTerewardstdControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZjtyTerewardstdControlBean extends AbstractControlBean
    implements ChZjtyTerewardstdControl {

    public ChZjtyTerewardstdVO doCreate(ChZjtyTerewardstdVO vo, User user)
        throws Exception {
        try{
			ChZjtyTerewardstdDAO dao = (ChZjtyTerewardstdDAO) DAOFactory.build(ChZjtyTerewardstdDAO.class, user);
            // TODO  set the pk */
            return (ChZjtyTerewardstdVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChZjtyTerewardstdVO vo, User user)
        throws Exception {
        try{
			ChZjtyTerewardstdDAO dao = (ChZjtyTerewardstdDAO) DAOFactory.build(ChZjtyTerewardstdDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyTerewardstdVO doUpdate(ChZjtyTerewardstdVO vo, User user)
        throws Exception {
        try{
			ChZjtyTerewardstdDAO dao = (ChZjtyTerewardstdDAO) DAOFactory.build(ChZjtyTerewardstdDAO.class, user);
            return (ChZjtyTerewardstdVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyTerewardstdVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChZjtyTerewardstdDAO dao = (ChZjtyTerewardstdDAO) DAOFactory.build(ChZjtyTerewardstdDAO.class, user);
        return (ChZjtyTerewardstdVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChZjtyTerewardstdListVO params, User user)
        throws Exception {
			ChZjtyTerewardstdDAO dao = (ChZjtyTerewardstdDAO) DAOFactory.build(ChZjtyTerewardstdDAO.class, user);
        return dao.query(params);
    }
}
