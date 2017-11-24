/**
* auto-generated code
* Thu Aug 20 16:16:59 CST 2009
*/
package com.sunrise.boss.business.cms.reward.montask.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.montask.persistent.MontaskVO;
import com.sunrise.boss.business.cms.reward.montask.persistent.MontaskDAO;
import com.sunrise.boss.business.cms.reward.montask.persistent.MontaskListVO;

/**
 * <p>Title: MontaskControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/montask/control/MontaskControlBean"
 name="MontaskControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class MontaskControlBean extends AbstractControlBean
    implements MontaskControl {

    public MontaskVO doCreate(MontaskVO vo, User user)
        throws Exception {
        try{
			MontaskDAO dao = (MontaskDAO) DAOFactory.build(MontaskDAO.class, user);
            // TODO  set the pk */
            return (MontaskVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(MontaskVO vo, User user)
        throws Exception {
        try{
			MontaskDAO dao = (MontaskDAO) DAOFactory.build(MontaskDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public MontaskVO doUpdate(MontaskVO vo, User user)
        throws Exception {
        try{
			MontaskDAO dao = (MontaskDAO) DAOFactory.build(MontaskDAO.class, user);
            return (MontaskVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public MontaskVO doFindByPk(Serializable pk, User user)
        throws Exception {
			MontaskDAO dao = (MontaskDAO) DAOFactory.build(MontaskDAO.class, user);
        return (MontaskVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(MontaskListVO params, User user)
    throws Exception {
    	MontaskDAO dao = (MontaskDAO) DAOFactory.build(MontaskDAO.class, user);
    return dao.queryTaskid(params);
    }
    
    public DataPackage doQuery2(MontaskListVO params, String value, String value0, User user)
    throws Exception {
    	MontaskDAO dao = (MontaskDAO) DAOFactory.build(MontaskDAO.class, user);
    return dao.queryTaskid2(params, value, value0);
    }
}
