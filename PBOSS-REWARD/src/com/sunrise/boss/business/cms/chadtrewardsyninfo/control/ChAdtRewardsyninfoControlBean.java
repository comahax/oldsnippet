/**
* auto-generated code
* Mon Apr 01 16:53:28 CST 2013
*/
package com.sunrise.boss.business.cms.chadtrewardsyninfo.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtrewardsyninfo.persistent.ChAdtRewardsyninfoVO;
import com.sunrise.boss.business.cms.chadtrewardsyninfo.persistent.ChAdtRewardsyninfoDAO;
import com.sunrise.boss.business.cms.chadtrewardsyninfo.persistent.ChAdtRewardsyninfoListVO;

/**
 * <p>Title: ChAdtRewardsyninfoControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chadtrewardsyninfo/control/ChAdtRewardsyninfoControlBean"
 name="ChAdtRewardsyninfoControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChAdtRewardsyninfoControlBean extends AbstractControlBean
    implements ChAdtRewardsyninfoControl {

    public ChAdtRewardsyninfoVO doCreate(ChAdtRewardsyninfoVO vo, User user)
        throws Exception {
        try{
			ChAdtRewardsyninfoDAO dao = (ChAdtRewardsyninfoDAO) DAOFactory.build(ChAdtRewardsyninfoDAO.class, user);
            // TODO  set the pk */
            return (ChAdtRewardsyninfoVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChAdtRewardsyninfoVO vo, User user)
        throws Exception {
        try{
			ChAdtRewardsyninfoDAO dao = (ChAdtRewardsyninfoDAO) DAOFactory.build(ChAdtRewardsyninfoDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtRewardsyninfoVO doUpdate(ChAdtRewardsyninfoVO vo, User user)
        throws Exception {
        try{
			ChAdtRewardsyninfoDAO dao = (ChAdtRewardsyninfoDAO) DAOFactory.build(ChAdtRewardsyninfoDAO.class, user);
            return (ChAdtRewardsyninfoVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtRewardsyninfoVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChAdtRewardsyninfoDAO dao = (ChAdtRewardsyninfoDAO) DAOFactory.build(ChAdtRewardsyninfoDAO.class, user);
        return (ChAdtRewardsyninfoVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChAdtRewardsyninfoListVO params, User user)
        throws Exception {
        params.set_orderby("taskid");
        params.set_desc("1");
        ChAdtRewardsyninfoDAO dao = (ChAdtRewardsyninfoDAO) DAOFactory.build(ChAdtRewardsyninfoDAO.class, user);
        return dao.query(params);
    }
}
