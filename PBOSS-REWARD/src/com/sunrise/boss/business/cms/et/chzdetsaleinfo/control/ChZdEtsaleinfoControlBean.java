/**
* auto-generated code
* Wed May 15 11:11:32 CST 2013
*/
package com.sunrise.boss.business.cms.et.chzdetsaleinfo.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.et.chzdetsaleinfo.persistent.ChZdEtsaleinfoVO;
import com.sunrise.boss.business.cms.et.chzdetsaleinfo.persistent.ChZdEtsaleinfoDAO;
import com.sunrise.boss.business.cms.et.chzdetsaleinfo.persistent.ChZdEtsaleinfoListVO;

/**
 * <p>Title: ChZdEtsaleinfoControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/et/chzdetsaleinfo/control/ChZdEtsaleinfoControlBean"
 name="ChZdEtsaleinfoControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZdEtsaleinfoControlBean extends AbstractControlBean
    implements ChZdEtsaleinfoControl {

    public ChZdEtsaleinfoVO doCreate(ChZdEtsaleinfoVO vo, User user)
        throws Exception {
        try{
			ChZdEtsaleinfoDAO dao = (ChZdEtsaleinfoDAO) DAOFactory.build(ChZdEtsaleinfoDAO.class, user);
            // TODO  set the pk */
            return (ChZdEtsaleinfoVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChZdEtsaleinfoVO vo, User user)
        throws Exception {
        try{
			ChZdEtsaleinfoDAO dao = (ChZdEtsaleinfoDAO) DAOFactory.build(ChZdEtsaleinfoDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZdEtsaleinfoVO doUpdate(ChZdEtsaleinfoVO vo, User user)
        throws Exception {
        try{
			ChZdEtsaleinfoDAO dao = (ChZdEtsaleinfoDAO) DAOFactory.build(ChZdEtsaleinfoDAO.class, user);
            return (ChZdEtsaleinfoVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZdEtsaleinfoVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChZdEtsaleinfoDAO dao = (ChZdEtsaleinfoDAO) DAOFactory.build(ChZdEtsaleinfoDAO.class, user);
        return (ChZdEtsaleinfoVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChZdEtsaleinfoListVO params, User user)
        throws Exception {
			ChZdEtsaleinfoDAO dao = (ChZdEtsaleinfoDAO) DAOFactory.build(ChZdEtsaleinfoDAO.class, user);
        return dao.query(params);
    }
}
