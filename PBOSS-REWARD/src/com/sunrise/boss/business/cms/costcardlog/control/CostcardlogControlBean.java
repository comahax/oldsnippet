/**
* auto-generated code
* Fri May 02 07:00:08 CST 2008
*/
package com.sunrise.boss.business.cms.costcardlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.costcardlog.persistent.CostcardlogVO;
import com.sunrise.boss.business.cms.costcardlog.persistent.CostcardlogDAO;
import com.sunrise.boss.business.cms.costcardlog.persistent.CostcardlogListVO;

/**
 * <p>Title: CostcardlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/costcardlog/control/CostcardlogControlBean"
 name="CostcardlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CostcardlogControlBean extends AbstractControlBean
    implements CostcardlogControl {

    public CostcardlogVO doCreate(CostcardlogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         CostcardlogDAO dao = (CostcardlogDAO) DAOFactory.build(CostcardlogDAO.class, user);
            return (CostcardlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(CostcardlogVO vo, User user)
        throws Exception {
        try{
         CostcardlogDAO dao = (CostcardlogDAO) DAOFactory.build(CostcardlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CostcardlogVO doUpdate(CostcardlogVO vo, User user)
        throws Exception {
        try{
         CostcardlogDAO dao = (CostcardlogDAO) DAOFactory.build(CostcardlogDAO.class, user);
            return (CostcardlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CostcardlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         CostcardlogDAO dao = (CostcardlogDAO) DAOFactory.build(CostcardlogDAO.class, user);
        return (CostcardlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(CostcardlogListVO params, User user)
        throws Exception {
         CostcardlogDAO dao = (CostcardlogDAO) DAOFactory.build(CostcardlogDAO.class, user);
        return dao.query(params);
    }
}
