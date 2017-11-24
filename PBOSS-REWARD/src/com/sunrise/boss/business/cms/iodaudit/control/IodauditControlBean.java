/**
* auto-generated code
* Thu Oct 09 13:08:46 CST 2008
*/
package com.sunrise.boss.business.cms.iodaudit.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.iodaudit.persistent.IodauditVO;
import com.sunrise.boss.business.cms.iodaudit.persistent.IodauditDAO;
import com.sunrise.boss.business.cms.iodaudit.persistent.IodauditListVO;

/**
 * <p>Title: IodauditControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/iodaudit/control/IodauditControlBean"
 name="IodauditControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class IodauditControlBean extends AbstractControlBean
    implements IodauditControl {

    public IodauditVO doCreate(IodauditVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         IodauditDAO dao = (IodauditDAO) DAOFactory.build(IodauditDAO.class, user);
            return (IodauditVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(IodauditVO vo, User user)
        throws Exception {
        try{
         IodauditDAO dao = (IodauditDAO) DAOFactory.build(IodauditDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public IodauditVO doUpdate(IodauditVO vo, User user)
        throws Exception {
        try{
         IodauditDAO dao = (IodauditDAO) DAOFactory.build(IodauditDAO.class, user);
            return (IodauditVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public IodauditVO doFindByPk(Serializable pk, User user)
        throws Exception {
         IodauditDAO dao = (IodauditDAO) DAOFactory.build(IodauditDAO.class, user);
        return (IodauditVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(IodauditListVO params, User user)
        throws Exception {
         IodauditDAO dao = (IodauditDAO) DAOFactory.build(IodauditDAO.class, user);
        return dao.query(params);
    }
}
