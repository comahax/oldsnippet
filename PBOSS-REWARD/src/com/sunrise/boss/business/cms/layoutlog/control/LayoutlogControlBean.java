/**
* auto-generated code
* Fri Dec 21 09:56:55 CST 2007
*/
package com.sunrise.boss.business.cms.layoutlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.layoutlog.persistent.LayoutlogVO;
import com.sunrise.boss.business.cms.layoutlog.persistent.LayoutlogDAO;
import com.sunrise.boss.business.cms.layoutlog.persistent.LayoutlogListVO;

/**
 * <p>Title: LayoutlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/layoutlog/control/LayoutlogControlBean"
 name="LayoutlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class LayoutlogControlBean extends AbstractControlBean
    implements LayoutlogControl {

    public LayoutlogVO doCreate(LayoutlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         LayoutlogDAO dao = (LayoutlogDAO) DAOFactory.build(LayoutlogDAO.class, user);
            return (LayoutlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(LayoutlogVO vo, User user)
        throws Exception {
        try{
         LayoutlogDAO dao = (LayoutlogDAO) DAOFactory.build(LayoutlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public LayoutlogVO doUpdate(LayoutlogVO vo, User user)
        throws Exception {
        try{
         LayoutlogDAO dao = (LayoutlogDAO) DAOFactory.build(LayoutlogDAO.class, user);
            return (LayoutlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public LayoutlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         LayoutlogDAO dao = (LayoutlogDAO) DAOFactory.build(LayoutlogDAO.class, user);
        return (LayoutlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(LayoutlogListVO params, User user)
        throws Exception {
         LayoutlogDAO dao = (LayoutlogDAO) DAOFactory.build(LayoutlogDAO.class, user);
        return dao.query(params);
    }
}
