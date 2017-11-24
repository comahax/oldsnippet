/**
* auto-generated code
* Tue Mar 18 11:36:17 CST 2008
*/
package com.sunrise.boss.business.fee.billing.rhruledeta.control;

import java.io.Serializable;


import com.sunrise.boss.business.fee.billing.rhruledeta.persistent.RhRuleDetaDBParam;
import com.sunrise.boss.business.fee.billing.rhruledeta.persistent.RhRuleDetaVO;
import com.sunrise.boss.business.fee.billing.rhruledeta.persistent.RhRuleDetaDAO;

import com.sunrise.jop.ui.User;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RhRuleDetaControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wkx
 * @version 1.0
 */

public class RhRuleDetaBO extends AbstractControlBean
    implements RhRuleDeta {

    public RhRuleDetaVO doCreate(RhRuleDetaVO vo, User user)
        throws Exception {
        try{
			RhRuleDetaDAO dao = (RhRuleDetaDAO) DAOFactory.build(RhRuleDetaDAO.class, user.getCityid());
            // TODO  set the pk */
            return (RhRuleDetaVO) dao.create(vo);
        } catch(Exception ex){
//            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RhRuleDetaVO vo, User user)
        throws Exception {
        try{
			RhRuleDetaDAO dao = (RhRuleDetaDAO) DAOFactory.build(RhRuleDetaDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
//            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RhRuleDetaVO doUpdate(RhRuleDetaVO vo, User user)
        throws Exception {
        try{
			RhRuleDetaDAO dao = (RhRuleDetaDAO) DAOFactory.build(RhRuleDetaDAO.class, user.getCityid());
            return (RhRuleDetaVO) dao.update(vo);
        } catch(Exception ex){
//            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RhRuleDetaVO doFindByPk(Serializable pk, User user)
        throws Exception {
			RhRuleDetaDAO dao = (RhRuleDetaDAO) DAOFactory.build(RhRuleDetaDAO.class, user.getCityid());
        return (RhRuleDetaVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RhRuleDetaDBParam params, User user)
        throws Exception {
			RhRuleDetaDAO dao = (RhRuleDetaDAO) DAOFactory.build(RhRuleDetaDAO.class, user.getCityid());
        return dao.query(params);
    }
}
