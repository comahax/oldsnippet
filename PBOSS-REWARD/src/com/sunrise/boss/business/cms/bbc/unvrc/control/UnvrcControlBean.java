/**
* auto-generated code
* Wed Sep 02 10:03:26 CST 2009
*/
package com.sunrise.boss.business.cms.bbc.unvrc.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.unvrc.persistent.UnvrcVO;
import com.sunrise.boss.business.cms.bbc.unvrc.persistent.UnvrcDAO;
import com.sunrise.boss.business.cms.bbc.unvrc.persistent.UnvrcListVO;

/**
 * <p>Title: UnvrcControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/unvrc/control/UnvrcControlBean"
 name="UnvrcControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class UnvrcControlBean extends AbstractControlBean
    implements UnvrcControl {

    public UnvrcVO doCreate(UnvrcVO vo, User user)
        throws Exception {
        try{
			UnvrcDAO dao = (UnvrcDAO) DAOFactory.build(UnvrcDAO.class, user);
            // TODO  set the pk */
            return (UnvrcVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(UnvrcVO vo, User user)
        throws Exception {
        try{
			UnvrcDAO dao = (UnvrcDAO) DAOFactory.build(UnvrcDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public UnvrcVO doUpdate(UnvrcVO vo, User user)
        throws Exception {
        try{
			UnvrcDAO dao = (UnvrcDAO) DAOFactory.build(UnvrcDAO.class, user);
            return (UnvrcVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public UnvrcVO doFindByPk(Serializable pk, User user)
        throws Exception {
			UnvrcDAO dao = (UnvrcDAO) DAOFactory.build(UnvrcDAO.class, user);
        return (UnvrcVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(UnvrcListVO params, User user)
        throws Exception {
			UnvrcDAO dao = (UnvrcDAO) DAOFactory.build(UnvrcDAO.class, user);
        return dao.query(params);
    }
}
