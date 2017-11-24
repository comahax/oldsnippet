/**
* auto-generated code
* Thu Dec 01 14:14:15 CST 2011
*/
package com.sunrise.boss.business.cms.reward.assessinfo.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.assessinfo.persistent.AssessinfoVO;
import com.sunrise.boss.business.cms.reward.assessinfo.persistent.AssessinfoDAO;
import com.sunrise.boss.business.cms.reward.assessinfo.persistent.AssessinfoListVO;

/**
 * <p>Title: AssessinfoControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/assessinfo/control/AssessinfoControlBean"
 name="AssessinfoControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class AssessinfoControlBean extends AbstractControlBean
    implements AssessinfoControl {

    public AssessinfoVO doCreate(AssessinfoVO vo, User user)
        throws Exception {
        try{
			AssessinfoDAO dao = (AssessinfoDAO) DAOFactory.build(AssessinfoDAO.class, user);
            // TODO  set the pk */
            return (AssessinfoVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(AssessinfoVO vo, User user)
        throws Exception {
        try{
			AssessinfoDAO dao = (AssessinfoDAO) DAOFactory.build(AssessinfoDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public AssessinfoVO doUpdate(AssessinfoVO vo, User user)
        throws Exception {
        try{
			AssessinfoDAO dao = (AssessinfoDAO) DAOFactory.build(AssessinfoDAO.class, user);
            return (AssessinfoVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public AssessinfoVO doFindByPk(Serializable pk, User user)
        throws Exception {
			AssessinfoDAO dao = (AssessinfoDAO) DAOFactory.build(AssessinfoDAO.class, user);
        return (AssessinfoVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(AssessinfoListVO params, User user)
        throws Exception {
			AssessinfoDAO dao = (AssessinfoDAO) DAOFactory.build(AssessinfoDAO.class, user);
        return dao.query(params);
    }
}
