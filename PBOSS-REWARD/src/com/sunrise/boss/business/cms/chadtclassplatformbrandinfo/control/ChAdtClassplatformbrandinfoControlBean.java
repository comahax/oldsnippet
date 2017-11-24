/**
* auto-generated code
* Fri Feb 01 11:50:09 CST 2013
*/
package com.sunrise.boss.business.cms.chadtclassplatformbrandinfo.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtclassplatformbrandinfo.persistent.ChAdtClassplatformbrandinfoVO;
import com.sunrise.boss.business.cms.chadtclassplatformbrandinfo.persistent.ChAdtClassplatformbrandinfoDAO;
import com.sunrise.boss.business.cms.chadtclassplatformbrandinfo.persistent.ChAdtClassplatformbrandinfoListVO;

/**
 * <p>Title: ChAdtClassplatformbrandinfoControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chadtclassplatformbrandinfo/control/ChAdtClassplatformbrandinfoControlBean"
 name="ChAdtClassplatformbrandinfoControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChAdtClassplatformbrandinfoControlBean extends AbstractControlBean
    implements ChAdtClassplatformbrandinfoControl {

    public ChAdtClassplatformbrandinfoVO doCreate(ChAdtClassplatformbrandinfoVO vo, User user)
        throws Exception {
        try{
			ChAdtClassplatformbrandinfoDAO dao = (ChAdtClassplatformbrandinfoDAO) DAOFactory.build(ChAdtClassplatformbrandinfoDAO.class, user);
            // TODO  set the pk */
            return (ChAdtClassplatformbrandinfoVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChAdtClassplatformbrandinfoVO vo, User user)
        throws Exception {
        try{
			ChAdtClassplatformbrandinfoDAO dao = (ChAdtClassplatformbrandinfoDAO) DAOFactory.build(ChAdtClassplatformbrandinfoDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtClassplatformbrandinfoVO doUpdate(ChAdtClassplatformbrandinfoVO vo, User user)
        throws Exception {
        try{
			ChAdtClassplatformbrandinfoDAO dao = (ChAdtClassplatformbrandinfoDAO) DAOFactory.build(ChAdtClassplatformbrandinfoDAO.class, user);
            return (ChAdtClassplatformbrandinfoVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtClassplatformbrandinfoVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChAdtClassplatformbrandinfoDAO dao = (ChAdtClassplatformbrandinfoDAO) DAOFactory.build(ChAdtClassplatformbrandinfoDAO.class, user);
        return (ChAdtClassplatformbrandinfoVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChAdtClassplatformbrandinfoListVO params, User user)
        throws Exception {
			ChAdtClassplatformbrandinfoDAO dao = (ChAdtClassplatformbrandinfoDAO) DAOFactory.build(ChAdtClassplatformbrandinfoDAO.class, user);
        return dao.query(params);
    }
}
