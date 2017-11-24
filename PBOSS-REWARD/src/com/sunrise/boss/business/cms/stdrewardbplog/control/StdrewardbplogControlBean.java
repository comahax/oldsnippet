/**
* auto-generated code
* Fri Feb 01 18:25:30 CST 2008
*/
package com.sunrise.boss.business.cms.stdrewardbplog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdrewardbplog.persistent.StdrewardbplogVO;
import com.sunrise.boss.business.cms.stdrewardbplog.persistent.StdrewardbplogDAO;
import com.sunrise.boss.business.cms.stdrewardbplog.persistent.StdrewardbplogListVO;

/**
 * <p>Title: StdrewardbplogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/stdrewardbplog/control/StdrewardbplogControlBean"
 name="StdrewardbplogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class StdrewardbplogControlBean extends AbstractControlBean
    implements StdrewardbplogControl {

    public StdrewardbplogVO doCreate(StdrewardbplogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         StdrewardbplogDAO dao = (StdrewardbplogDAO) DAOFactory.build(StdrewardbplogDAO.class, user);
            return (StdrewardbplogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(StdrewardbplogVO vo, User user)
        throws Exception {
        try{
         StdrewardbplogDAO dao = (StdrewardbplogDAO) DAOFactory.build(StdrewardbplogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public StdrewardbplogVO doUpdate(StdrewardbplogVO vo, User user)
        throws Exception {
        try{
         StdrewardbplogDAO dao = (StdrewardbplogDAO) DAOFactory.build(StdrewardbplogDAO.class, user);
            return (StdrewardbplogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public StdrewardbplogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         StdrewardbplogDAO dao = (StdrewardbplogDAO) DAOFactory.build(StdrewardbplogDAO.class, user);
        return (StdrewardbplogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(StdrewardbplogListVO params, User user)
        throws Exception {
         StdrewardbplogDAO dao = (StdrewardbplogDAO) DAOFactory.build(StdrewardbplogDAO.class, user);
        return dao.query(params);
    }
}
