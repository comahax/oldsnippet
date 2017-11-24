/**
* auto-generated code
* Fri Jan 04 16:05:28 CST 2008
*/
package com.sunrise.boss.business.cms.resalelog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.resalelog.persistent.ResalelogVO;
import com.sunrise.boss.business.cms.resalelog.persistent.ResalelogDAO;
import com.sunrise.boss.business.cms.resalelog.persistent.ResalelogListVO;

/**
 * <p>Title: ResalelogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/resalelog/control/ResalelogControlBean"
 name="ResalelogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ResalelogControlBean extends AbstractControlBean
    implements ResalelogControl {

    public ResalelogVO doCreate(ResalelogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         ResalelogDAO dao = (ResalelogDAO) DAOFactory.build(ResalelogDAO.class, user);
            return (ResalelogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ResalelogVO vo, User user)
        throws Exception {
        try{
         ResalelogDAO dao = (ResalelogDAO) DAOFactory.build(ResalelogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ResalelogVO doUpdate(ResalelogVO vo, User user)
        throws Exception {
        try{
         ResalelogDAO dao = (ResalelogDAO) DAOFactory.build(ResalelogDAO.class, user);
            return (ResalelogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ResalelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         ResalelogDAO dao = (ResalelogDAO) DAOFactory.build(ResalelogDAO.class, user);
        return (ResalelogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ResalelogListVO params, User user)
        throws Exception {
         ResalelogDAO dao = (ResalelogDAO) DAOFactory.build(ResalelogDAO.class, user);
        return dao.query(params);
    }
}
