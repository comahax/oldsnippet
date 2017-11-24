/**
* auto-generated code
* Sat Nov 28 17:50:09 CST 2009
*/
package com.sunrise.boss.business.cms.examine.mappinglog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.mappinglog.persistent.MappinglogVO;
import com.sunrise.boss.business.cms.examine.mappinglog.persistent.MappinglogDAO;
import com.sunrise.boss.business.cms.examine.mappinglog.persistent.MappinglogListVO;

/**
 * <p>Title: MappinglogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/mappinglog/control/MappinglogControlBean"
 name="MappinglogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class MappinglogControlBean extends AbstractControlBean
    implements MappinglogControl {

    public MappinglogVO doCreate(MappinglogVO vo, User user)
        throws Exception {
        try{
			MappinglogDAO dao = (MappinglogDAO) DAOFactory.build(MappinglogDAO.class, user);
            // TODO  set the pk */
            return (MappinglogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(MappinglogVO vo, User user)
        throws Exception {
        try{
			MappinglogDAO dao = (MappinglogDAO) DAOFactory.build(MappinglogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public MappinglogVO doUpdate(MappinglogVO vo, User user)
        throws Exception {
        try{
			MappinglogDAO dao = (MappinglogDAO) DAOFactory.build(MappinglogDAO.class, user);
            return (MappinglogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public MappinglogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			MappinglogDAO dao = (MappinglogDAO) DAOFactory.build(MappinglogDAO.class, user);
        return (MappinglogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(MappinglogListVO params, User user)
        throws Exception {
			MappinglogDAO dao = (MappinglogDAO) DAOFactory.build(MappinglogDAO.class, user);
        return dao.query(params);
    }
}
