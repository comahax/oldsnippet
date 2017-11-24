/**
* auto-generated code
* Wed Sep 04 16:18:46 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdreportitem.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdreportitem.persistent.ChPdReportitemVO;
import com.sunrise.boss.business.cms.provagent.chpdreportitem.persistent.ChPdReportitemDAO;
import com.sunrise.boss.business.cms.provagent.chpdreportitem.persistent.ChPdReportitemListVO;

/**
 * <p>Title: ChPdReportitemControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/provagent/chpdreportitem/control/ChPdReportitemControlBean"
 name="ChPdReportitemControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPdReportitemControlBean extends AbstractControlBean
    implements ChPdReportitemControl {

    public ChPdReportitemVO doCreate(ChPdReportitemVO vo, User user)
        throws Exception {
        try{
			ChPdReportitemDAO dao = (ChPdReportitemDAO) DAOFactory.build(ChPdReportitemDAO.class, user);
            // TODO  set the pk */
            return (ChPdReportitemVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPdReportitemVO vo, User user)
        throws Exception {
        try{
			ChPdReportitemDAO dao = (ChPdReportitemDAO) DAOFactory.build(ChPdReportitemDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdReportitemVO doUpdate(ChPdReportitemVO vo, User user)
        throws Exception {
        try{
			ChPdReportitemDAO dao = (ChPdReportitemDAO) DAOFactory.build(ChPdReportitemDAO.class, user);
            return (ChPdReportitemVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdReportitemVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPdReportitemDAO dao = (ChPdReportitemDAO) DAOFactory.build(ChPdReportitemDAO.class, user);
        return (ChPdReportitemVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPdReportitemListVO params, User user)
        throws Exception {
    	params.set_desc("1");
    	params.set_orderby("rewardmonth");
		ChPdReportitemDAO dao = (ChPdReportitemDAO) DAOFactory.build(ChPdReportitemDAO.class, user);
        return dao.query(params);
    }
}
