/**
* auto-generated code
* Tue Sep 03 17:48:46 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdentproduct.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdentproduct.persistent.ChPdEntproductDAO;
import com.sunrise.boss.business.cms.provagent.chpdentproduct.persistent.ChPdEntproductListVO;
import com.sunrise.boss.business.cms.provagent.chpdentproduct.persistent.ChPdEntproductVO;

/**
 * <p>Title: ChPdEntproductControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/proagent/chpdentproduct/control/ChPdEntproductControlBean"
 name="ChPdEntproductControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPdEntproductControlBean extends AbstractControlBean
    implements ChPdEntproductControl {

    public ChPdEntproductVO doCreate(ChPdEntproductVO vo, User user)
        throws Exception {
        try{
			ChPdEntproductDAO dao = (ChPdEntproductDAO) DAOFactory.build(ChPdEntproductDAO.class, user);
            // TODO  set the pk */
            return (ChPdEntproductVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPdEntproductVO vo, User user)
        throws Exception {
        try{
			ChPdEntproductDAO dao = (ChPdEntproductDAO) DAOFactory.build(ChPdEntproductDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdEntproductVO doUpdate(ChPdEntproductVO vo, User user)
        throws Exception {
        try{
			ChPdEntproductDAO dao = (ChPdEntproductDAO) DAOFactory.build(ChPdEntproductDAO.class, user);
            return (ChPdEntproductVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdEntproductVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPdEntproductDAO dao = (ChPdEntproductDAO) DAOFactory.build(ChPdEntproductDAO.class, user);
        return (ChPdEntproductVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPdEntproductListVO params, User user)
        throws Exception {
			ChPdEntproductDAO dao = (ChPdEntproductDAO) DAOFactory.build(ChPdEntproductDAO.class, user);
        return dao.query(params);
    }
}
