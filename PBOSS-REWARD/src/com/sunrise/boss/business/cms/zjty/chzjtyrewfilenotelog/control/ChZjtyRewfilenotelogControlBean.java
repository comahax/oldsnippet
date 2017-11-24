/**
* auto-generated code
* Thu Jul 12 15:25:29 CST 2012
*/
package com.sunrise.boss.business.cms.zjty.chzjtyrewfilenotelog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenotelog.persistent.ChZjtyRewfilenotelogVO;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenotelog.persistent.ChZjtyRewfilenotelogDAO;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenotelog.persistent.ChZjtyRewfilenotelogListVO;

/**
 * <p>Title: ChZjtyRewfilenotelogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/chzjtyrewfilenotelog/control/ChZjtyRewfilenotelogControlBean"
 name="ChZjtyRewfilenotelogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZjtyRewfilenotelogControlBean extends AbstractControlBean
    implements ChZjtyRewfilenotelogControl {

    public ChZjtyRewfilenotelogVO doCreate(ChZjtyRewfilenotelogVO vo, User user)
        throws Exception {
        try{
			ChZjtyRewfilenotelogDAO dao = (ChZjtyRewfilenotelogDAO) DAOFactory.build(ChZjtyRewfilenotelogDAO.class, user);
            // TODO  set the pk */
            return (ChZjtyRewfilenotelogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChZjtyRewfilenotelogVO vo, User user)
        throws Exception {
        try{
			ChZjtyRewfilenotelogDAO dao = (ChZjtyRewfilenotelogDAO) DAOFactory.build(ChZjtyRewfilenotelogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyRewfilenotelogVO doUpdate(ChZjtyRewfilenotelogVO vo, User user)
        throws Exception {
        try{
			ChZjtyRewfilenotelogDAO dao = (ChZjtyRewfilenotelogDAO) DAOFactory.build(ChZjtyRewfilenotelogDAO.class, user);
            return (ChZjtyRewfilenotelogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChZjtyRewfilenotelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChZjtyRewfilenotelogDAO dao = (ChZjtyRewfilenotelogDAO) DAOFactory.build(ChZjtyRewfilenotelogDAO.class, user);
        return (ChZjtyRewfilenotelogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChZjtyRewfilenotelogListVO params, User user)
        throws Exception {
			ChZjtyRewfilenotelogDAO dao = (ChZjtyRewfilenotelogDAO) DAOFactory.build(ChZjtyRewfilenotelogDAO.class, user);
        return dao.query(params);
    }
}
