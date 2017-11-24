/**
* auto-generated code
* Fri Feb 01 18:27:26 CST 2008
*/
package com.sunrise.boss.business.cms.stdrewardbslog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdrewardbslog.persistent.StdrewardbslogVO;
import com.sunrise.boss.business.cms.stdrewardbslog.persistent.StdrewardbslogDAO;
import com.sunrise.boss.business.cms.stdrewardbslog.persistent.StdrewardbslogListVO;

/**
 * <p>Title: StdrewardbslogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/stdrewardbslog/control/StdrewardbslogControlBean"
 name="StdrewardbslogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class StdrewardbslogControlBean extends AbstractControlBean
    implements StdrewardbslogControl {

    public StdrewardbslogVO doCreate(StdrewardbslogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         StdrewardbslogDAO dao = (StdrewardbslogDAO) DAOFactory.build(StdrewardbslogDAO.class, user);
            return (StdrewardbslogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(StdrewardbslogVO vo, User user)
        throws Exception {
        try{
         StdrewardbslogDAO dao = (StdrewardbslogDAO) DAOFactory.build(StdrewardbslogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public StdrewardbslogVO doUpdate(StdrewardbslogVO vo, User user)
        throws Exception {
        try{
         StdrewardbslogDAO dao = (StdrewardbslogDAO) DAOFactory.build(StdrewardbslogDAO.class, user);
            return (StdrewardbslogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public StdrewardbslogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         StdrewardbslogDAO dao = (StdrewardbslogDAO) DAOFactory.build(StdrewardbslogDAO.class, user);
        return (StdrewardbslogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(StdrewardbslogListVO params, User user)
        throws Exception {
         StdrewardbslogDAO dao = (StdrewardbslogDAO) DAOFactory.build(StdrewardbslogDAO.class, user);
        return dao.query(params);
    }
}
