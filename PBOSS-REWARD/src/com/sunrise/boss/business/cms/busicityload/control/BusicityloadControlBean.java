/**
* auto-generated code
* Tue Feb 05 10:11:13 CST 2008
*/
package com.sunrise.boss.business.cms.busicityload.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.busicityload.persistent.BusicityloadVO;
import com.sunrise.boss.business.cms.busicityload.persistent.BusicityloadDAO;
import com.sunrise.boss.business.cms.busicityload.persistent.BusicityloadListVO;

/**
 * <p>Title: BusicityloadControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/busicityload/control/BusicityloadControlBean"
 name="BusicityloadControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BusicityloadControlBean extends AbstractControlBean
    implements BusicityloadControl {

    public BusicityloadVO doCreate(BusicityloadVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         BusicityloadDAO dao = (BusicityloadDAO) DAOFactory.build(BusicityloadDAO.class, user);
            return (BusicityloadVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(BusicityloadVO vo, User user)
        throws Exception {
        try{
         BusicityloadDAO dao = (BusicityloadDAO) DAOFactory.build(BusicityloadDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BusicityloadVO doUpdate(BusicityloadVO vo, User user)
        throws Exception {
        try{
         BusicityloadDAO dao = (BusicityloadDAO) DAOFactory.build(BusicityloadDAO.class, user);
            return (BusicityloadVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BusicityloadVO doFindByPk(Serializable pk, User user)
        throws Exception {
         BusicityloadDAO dao = (BusicityloadDAO) DAOFactory.build(BusicityloadDAO.class, user);
        return (BusicityloadVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(BusicityloadListVO params, User user)
        throws Exception {
         BusicityloadDAO dao = (BusicityloadDAO) DAOFactory.build(BusicityloadDAO.class, user);
        return dao.query(params);
    }
}
