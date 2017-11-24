/**
* auto-generated code
* Tue Apr 17 11:01:07 CST 2007
*/
package com.sunrise.boss.business.cms.microarealog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.microarealog.persistent.MicroarealogVO;
import com.sunrise.boss.business.cms.microarealog.persistent.MicroarealogDAO;
import com.sunrise.boss.business.cms.microarealog.persistent.MicroarealogListVO;

/**
 * <p>Title: MicroarealogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/microarealog/control/MicroarealogControlBean"
 name="MicroarealogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class MicroarealogControlBean extends AbstractControlBean
    implements MicroarealogControl {

    public MicroarealogVO doCreate(MicroarealogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         MicroarealogDAO dao = (MicroarealogDAO) DAOFactory.build(MicroarealogDAO.class, user);
            return (MicroarealogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(MicroarealogVO vo, User user)
        throws Exception {
        try{
         MicroarealogDAO dao = (MicroarealogDAO) DAOFactory.build(MicroarealogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public MicroarealogVO doUpdate(MicroarealogVO vo, User user)
        throws Exception {
        try{
         MicroarealogDAO dao = (MicroarealogDAO) DAOFactory.build(MicroarealogDAO.class, user);
            return (MicroarealogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public MicroarealogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         MicroarealogDAO dao = (MicroarealogDAO) DAOFactory.build(MicroarealogDAO.class, user);
        return (MicroarealogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(MicroarealogListVO params, User user)
        throws Exception {
         MicroarealogDAO dao = (MicroarealogDAO) DAOFactory.build(MicroarealogDAO.class, user);
        return dao.query(params);
    }
}
