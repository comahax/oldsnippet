/**
* auto-generated code
* Thu Sep 21 16:09:09 CST 2006
*/
package com.sunrise.boss.business.admin.dictitem.control;

import java.io.Serializable;
import java.util.Collection;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemDAO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;

/**
 * <p>Title: DictitemControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/admin/dictitem/control/DictitemControlBean"
*    name="DictitemControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class DictitemControlBean extends AbstractControlBean
    implements DictitemControl {

    public DictitemVO doCreate(DictitemVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         DictitemDAO dao = (DictitemDAO) DAOFactory.build(DictitemDAO.class, user.getCityid());
            return (DictitemVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(DictitemVO vo, User user)
        throws Exception {
        try{
         DictitemDAO dao = (DictitemDAO) DAOFactory.build(DictitemDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public DictitemVO doUpdate(DictitemVO vo, User user)
        throws Exception {
        try{
         DictitemDAO dao = (DictitemDAO) DAOFactory.build(DictitemDAO.class, user);
            return (DictitemVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public DictitemVO doFindByPk(Serializable pk, User user)
        throws Exception {
         DictitemDAO dao = (DictitemDAO) DAOFactory.build(DictitemDAO.class, user);
        return (DictitemVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(DictitemListVO params, User user)
        throws Exception {
         DictitemDAO dao = (DictitemDAO) DAOFactory.build(DictitemDAO.class, user);
        return dao.query(params);
    }

    public Collection doFindAll(User user) throws Exception {
        DictitemDAO dao = (DictitemDAO) DAOFactory.build(DictitemDAO.class, user);
       return dao.findAll();
    }
}
