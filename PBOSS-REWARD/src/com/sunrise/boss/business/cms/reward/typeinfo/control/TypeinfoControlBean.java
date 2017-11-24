/**
* auto-generated code
* Tue Apr 10 15:46:57 CST 2012
*/
package com.sunrise.boss.business.cms.reward.typeinfo.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.typeinfo.persistent.TypeinfoVO;
import com.sunrise.boss.business.cms.reward.typeinfo.persistent.TypeinfoDAO;
import com.sunrise.boss.business.cms.reward.typeinfo.persistent.TypeinfoListVO;

/**
 * <p>Title: TypeinfoControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/typeinfo/control/TypeinfoControlBean"
 name="TypeinfoControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class TypeinfoControlBean extends AbstractControlBean
    implements TypeinfoControl {

    public TypeinfoVO doCreate(TypeinfoVO vo, User user)
        throws Exception {
        try{
			TypeinfoDAO dao = (TypeinfoDAO) DAOFactory.build(TypeinfoDAO.class, user);
            // TODO  set the pk */
            return (TypeinfoVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(TypeinfoVO vo, User user)
        throws Exception {
        try{
			TypeinfoDAO dao = (TypeinfoDAO) DAOFactory.build(TypeinfoDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public TypeinfoVO doUpdate(TypeinfoVO vo, User user)
        throws Exception {
        try{
			TypeinfoDAO dao = (TypeinfoDAO) DAOFactory.build(TypeinfoDAO.class, user);
            return (TypeinfoVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public TypeinfoVO doFindByPk(Serializable pk, User user)
        throws Exception {
			TypeinfoDAO dao = (TypeinfoDAO) DAOFactory.build(TypeinfoDAO.class, user);
        return (TypeinfoVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(TypeinfoListVO params, User user)
        throws Exception {
			TypeinfoDAO dao = (TypeinfoDAO) DAOFactory.build(TypeinfoDAO.class, user);
        return dao.query(params);
    }
}
