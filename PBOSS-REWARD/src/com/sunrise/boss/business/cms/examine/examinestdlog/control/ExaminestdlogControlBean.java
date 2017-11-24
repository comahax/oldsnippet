/**
* auto-generated code
* Wed Nov 18 09:26:48 CST 2009
*/
package com.sunrise.boss.business.cms.examine.examinestdlog.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.examine.examinestdlog.persistent.ExaminestdlogDAO;
import com.sunrise.boss.business.cms.examine.examinestdlog.persistent.ExaminestdlogListVO;
import com.sunrise.boss.business.cms.examine.examinestdlog.persistent.ExaminestdlogVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ExaminestdlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examinestdlog/control/ExaminestdlogControlBean"
 name="ExaminestdlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExaminestdlogControlBean extends AbstractControlBean
    implements ExaminestdlogControl {

    public ExaminestdlogVO doCreate(ExaminestdlogVO vo, User user)
        throws Exception {
        try{
			ExaminestdlogDAO dao = (ExaminestdlogDAO) DAOFactory.build(ExaminestdlogDAO.class, user);
            // TODO  set the pk */
            return (ExaminestdlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ExaminestdlogVO vo, User user)
        throws Exception {
        try{
			ExaminestdlogDAO dao = (ExaminestdlogDAO) DAOFactory.build(ExaminestdlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExaminestdlogVO doUpdate(ExaminestdlogVO vo, User user)
        throws Exception {
        try{
			ExaminestdlogDAO dao = (ExaminestdlogDAO) DAOFactory.build(ExaminestdlogDAO.class, user);
            return (ExaminestdlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExaminestdlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ExaminestdlogDAO dao = (ExaminestdlogDAO) DAOFactory.build(ExaminestdlogDAO.class, user);
        return (ExaminestdlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExaminestdlogListVO params, User user)
        throws Exception {
			ExaminestdlogDAO dao = (ExaminestdlogDAO) DAOFactory.build(ExaminestdlogDAO.class, user);
        return dao.query(params);
    }
}
