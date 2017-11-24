/**
* auto-generated code
* Tue Dec 18 19:10:45 CST 2007
*/
package com.sunrise.boss.business.cms.layout.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.layout.persistent.LayoutVO;
import com.sunrise.boss.business.cms.layout.persistent.LayoutDAO;
import com.sunrise.boss.business.cms.layout.persistent.LayoutListVO;

/**
 * <p>Title: LayoutControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/layout/control/LayoutControlBean"
 name="LayoutControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class LayoutControlBean extends AbstractControlBean
    implements LayoutControl {

    public LayoutVO doCreate(LayoutVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         LayoutDAO dao = (LayoutDAO) DAOFactory.build(LayoutDAO.class, user);
            return (LayoutVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(LayoutVO vo, User user)
        throws Exception {
        try{
         LayoutDAO dao = (LayoutDAO) DAOFactory.build(LayoutDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public LayoutVO doUpdate(LayoutVO vo, User user)
        throws Exception {
        try{
         LayoutDAO dao = (LayoutDAO) DAOFactory.build(LayoutDAO.class, user);
            return (LayoutVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public LayoutVO doFindByPk(Serializable pk, User user)
        throws Exception {
         LayoutDAO dao = (LayoutDAO) DAOFactory.build(LayoutDAO.class, user);
        return (LayoutVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(LayoutListVO params, User user)
        throws Exception {
         LayoutDAO dao = (LayoutDAO) DAOFactory.build(LayoutDAO.class, user);
        return dao.query(params);
    }
}
