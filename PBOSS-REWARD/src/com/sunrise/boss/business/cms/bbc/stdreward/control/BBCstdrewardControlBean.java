/**
* auto-generated code
* Wed Aug 27 09:24:49 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.stdreward.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.stdreward.persistent.BBCstdrewardDAO;
import com.sunrise.boss.business.cms.bbc.stdreward.persistent.BBCstdrewardListVO;
import com.sunrise.boss.business.cms.bbc.stdreward.persistent.BBCstdrewardVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BBCstdrewardControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/stdreward/control/BBCstdrewardControlBean"
 name="BBCstdrewardControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BBCstdrewardControlBean extends AbstractControlBean
    implements BBCstdrewardControl {

    public BBCstdrewardVO doCreate(BBCstdrewardVO vo, User user)
        throws Exception {
        try{
			BBCstdrewardDAO dao = (BBCstdrewardDAO) DAOFactory.build(BBCstdrewardDAO.class, user);
            // TODO  set the pk */
            return (BBCstdrewardVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(BBCstdrewardVO vo, User user)
        throws Exception {
        try{
			BBCstdrewardDAO dao = (BBCstdrewardDAO) DAOFactory.build(BBCstdrewardDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BBCstdrewardVO doUpdate(BBCstdrewardVO vo, User user)
        throws Exception {
        try{
			BBCstdrewardDAO dao = (BBCstdrewardDAO) DAOFactory.build(BBCstdrewardDAO.class, user);
            return (BBCstdrewardVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BBCstdrewardVO doFindByPk(Serializable pk, User user)
        throws Exception {
			BBCstdrewardDAO dao = (BBCstdrewardDAO) DAOFactory.build(BBCstdrewardDAO.class, user);
        return (BBCstdrewardVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(BBCstdrewardListVO params, User user)
        throws Exception {
			BBCstdrewardDAO dao = (BBCstdrewardDAO) DAOFactory.build(BBCstdrewardDAO.class, user);
        return dao.query(params);
    }
}
