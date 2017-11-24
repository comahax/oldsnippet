/**
* auto-generated code
* Wed Sep 02 15:01:47 CST 2009
*/
package com.sunrise.boss.business.cms.bbc.unvrewardrecord.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.unvrewardrecord.persistent.UnvRewardrecordVO;
import com.sunrise.boss.business.cms.bbc.unvrewardrecord.persistent.UnvRewardrecordDAO;
import com.sunrise.boss.business.cms.bbc.unvrewardrecord.persistent.UnvRewardrecordListVO;

/**
 * <p>Title: UnvRewardrecordControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/unvrewardrecord/control/UnvRewardrecordControlBean"
 name="UnvRewardrecordControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class UnvRewardrecordControlBean extends AbstractControlBean
    implements UnvRewardrecordControl {

    public UnvRewardrecordVO doCreate(UnvRewardrecordVO vo, User user)
        throws Exception {
        try{
			UnvRewardrecordDAO dao = (UnvRewardrecordDAO) DAOFactory.build(UnvRewardrecordDAO.class, user);
            // TODO  set the pk */
            return (UnvRewardrecordVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(UnvRewardrecordVO vo, User user)
        throws Exception {
        try{
			UnvRewardrecordDAO dao = (UnvRewardrecordDAO) DAOFactory.build(UnvRewardrecordDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public UnvRewardrecordVO doUpdate(UnvRewardrecordVO vo, User user)
        throws Exception {
        try{
			UnvRewardrecordDAO dao = (UnvRewardrecordDAO) DAOFactory.build(UnvRewardrecordDAO.class, user);
            return (UnvRewardrecordVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public UnvRewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
			UnvRewardrecordDAO dao = (UnvRewardrecordDAO) DAOFactory.build(UnvRewardrecordDAO.class, user);
        return (UnvRewardrecordVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(UnvRewardrecordListVO params, User user)
        throws Exception {
			UnvRewardrecordDAO dao = (UnvRewardrecordDAO) DAOFactory.build(UnvRewardrecordDAO.class, user);
        return dao.queryByNamedSqlQuery("unvrewardRecordQuery", params);
    }
    
    public DataPackage doQueryWayName(UnvRewardrecordListVO params, User user)
    throws Exception {
		UnvRewardrecordDAO dao = (UnvRewardrecordDAO) DAOFactory.build(UnvRewardrecordDAO.class, user);
    return dao.doQueryWayIdName(params, user);
    }

}
