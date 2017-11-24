/**
* auto-generated code
* Mon Apr 16 17:13:59 CST 2007
*/
package com.sunrise.boss.business.cms.adimarealog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.adimarealog.persistent.AdimarealogVO;
import com.sunrise.boss.business.cms.adimarealog.persistent.AdimarealogDAO;
import com.sunrise.boss.business.cms.adimarealog.persistent.AdimarealogListVO;

/**
 * <p>Title: AdimarealogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/adimarealog/control/AdimarealogControlBean"
 name="AdimarealogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class AdimarealogControlBean extends AbstractControlBean
    implements AdimarealogControl {

    public AdimarealogVO doCreate(AdimarealogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         AdimarealogDAO dao = (AdimarealogDAO) DAOFactory.build(AdimarealogDAO.class, user);
            return (AdimarealogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(AdimarealogVO vo, User user)
        throws Exception {
        try{
         AdimarealogDAO dao = (AdimarealogDAO) DAOFactory.build(AdimarealogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public AdimarealogVO doUpdate(AdimarealogVO vo, User user)
        throws Exception {
        try{
         AdimarealogDAO dao = (AdimarealogDAO) DAOFactory.build(AdimarealogDAO.class, user);
            return (AdimarealogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public AdimarealogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         AdimarealogDAO dao = (AdimarealogDAO) DAOFactory.build(AdimarealogDAO.class, user);
        return (AdimarealogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(AdimarealogListVO params, User user)
        throws Exception {
         AdimarealogDAO dao = (AdimarealogDAO) DAOFactory.build(AdimarealogDAO.class, user);
        return dao.query(params);
    }
}
