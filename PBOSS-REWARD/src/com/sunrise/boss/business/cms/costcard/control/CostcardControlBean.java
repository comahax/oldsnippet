/**
* auto-generated code
* Fri May 02 07:02:06 CST 2008
*/
package com.sunrise.boss.business.cms.costcard.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.costcard.persistent.CostcardVO;
import com.sunrise.boss.business.cms.costcard.persistent.CostcardDAO;
import com.sunrise.boss.business.cms.costcard.persistent.CostcardListVO;

/**
 * <p>Title: CostcardControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/costcard/control/CostcardControlBean"
 name="CostcardControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CostcardControlBean extends AbstractControlBean
    implements CostcardControl {

    public CostcardVO doCreate(CostcardVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         CostcardDAO dao = (CostcardDAO) DAOFactory.build(CostcardDAO.class, user);
            return (CostcardVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(CostcardVO vo, User user)
        throws Exception {
        try{
         CostcardDAO dao = (CostcardDAO) DAOFactory.build(CostcardDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CostcardVO doUpdate(CostcardVO vo, User user)
        throws Exception {
        try{
         CostcardDAO dao = (CostcardDAO) DAOFactory.build(CostcardDAO.class, user);
            return (CostcardVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CostcardVO doFindByPk(Serializable pk, User user)
        throws Exception {
         CostcardDAO dao = (CostcardDAO) DAOFactory.build(CostcardDAO.class, user);
        return (CostcardVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(CostcardListVO params, User user)
        throws Exception {
         CostcardDAO dao = (CostcardDAO) DAOFactory.build(CostcardDAO.class, user);
        return dao.query(params);
    }
}
