/**
* auto-generated code
* Fri Feb 01 18:05:53 CST 2008
*/
package com.sunrise.boss.business.cms.stdreward.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardDAO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardListVO;

/**
 * <p>Title: StdrewardControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/stdreward/control/StdrewardControlBean"
 name="StdrewardControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class StdrewardControlBean extends AbstractControlBean
    implements StdrewardControl {

    public StdrewardVO doCreate(StdrewardVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         StdrewardDAO dao = (StdrewardDAO) DAOFactory.build(StdrewardDAO.class, user);
            return (StdrewardVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(StdrewardVO vo, User user)
        throws Exception {
        try{
         StdrewardDAO dao = (StdrewardDAO) DAOFactory.build(StdrewardDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public StdrewardVO doUpdate(StdrewardVO vo, User user)
        throws Exception {
        try{
         StdrewardDAO dao = (StdrewardDAO) DAOFactory.build(StdrewardDAO.class, user);
            return (StdrewardVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public StdrewardVO doFindByPk(Serializable pk, User user)
        throws Exception {
         StdrewardDAO dao = (StdrewardDAO) DAOFactory.build(StdrewardDAO.class, user);
        return (StdrewardVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(StdrewardListVO params, User user)
        throws Exception {
         StdrewardDAO dao = (StdrewardDAO) DAOFactory.build(StdrewardDAO.class, user);
        return dao.query(params);
    }
    public DataPackage doQueryfor5455(StdrewardListVO params, User user)
    throws Exception {
     StdrewardDAO dao = (StdrewardDAO) DAOFactory.build(StdrewardDAO.class, user);
    return dao.queryfor5455(params);
}
}
