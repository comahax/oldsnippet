/**
* auto-generated code
* Wed Sep 04 16:27:47 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdreportfile.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdreportfile.persistent.ChPdReportfileVO;
import com.sunrise.boss.business.cms.provagent.chpdreportfile.persistent.ChPdReportfileDAO;
import com.sunrise.boss.business.cms.provagent.chpdreportfile.persistent.ChPdReportfileListVO;

/**
 * <p>Title: ChPdReportfileControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/provagent/chpdreportfile/control/ChPdReportfileControlBean"
 name="ChPdReportfileControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChPdReportfileControlBean extends AbstractControlBean
    implements ChPdReportfileControl {

    public ChPdReportfileVO doCreate(ChPdReportfileVO vo, User user)
        throws Exception {
        try{
			ChPdReportfileDAO dao = (ChPdReportfileDAO) DAOFactory.build(ChPdReportfileDAO.class, user);
            // TODO  set the pk */
            return (ChPdReportfileVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChPdReportfileVO vo, User user)
        throws Exception {
        try{
			ChPdReportfileDAO dao = (ChPdReportfileDAO) DAOFactory.build(ChPdReportfileDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdReportfileVO doUpdate(ChPdReportfileVO vo, User user)
        throws Exception {
        try{
			ChPdReportfileDAO dao = (ChPdReportfileDAO) DAOFactory.build(ChPdReportfileDAO.class, user);
            return (ChPdReportfileVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChPdReportfileVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChPdReportfileDAO dao = (ChPdReportfileDAO) DAOFactory.build(ChPdReportfileDAO.class, user);
        return (ChPdReportfileVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChPdReportfileListVO params, User user)
        throws Exception {
			ChPdReportfileDAO dao = (ChPdReportfileDAO) DAOFactory.build(ChPdReportfileDAO.class, user);
        return dao.query(params);
    }
}
