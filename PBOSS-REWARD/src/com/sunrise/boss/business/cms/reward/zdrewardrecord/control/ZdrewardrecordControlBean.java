/**
* auto-generated code
* Thu Jun 06 20:14:18 CST 2013
*/
package com.sunrise.boss.business.cms.reward.zdrewardrecord.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.zdrewardrecord.persistent.ZdrewardrecordVO;
import com.sunrise.boss.business.cms.reward.zdrewardrecord.persistent.ZdrewardrecordDAO;
import com.sunrise.boss.business.cms.reward.zdrewardrecord.persistent.ZdrewardrecordListVO;

/**
 * <p>Title: ZdrewardrecordControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/zdrewardrecord/control/ZdrewardrecordControlBean"
 name="ZdrewardrecordControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZdrewardrecordControlBean extends AbstractControlBean
    implements ZdrewardrecordControl {

    public ZdrewardrecordVO doCreate(ZdrewardrecordVO vo, User user)
        throws Exception {
        try{
			ZdrewardrecordDAO dao = (ZdrewardrecordDAO) DAOFactory.build(ZdrewardrecordDAO.class, user);
            // TODO  set the pk */
            return (ZdrewardrecordVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ZdrewardrecordVO vo, User user)
        throws Exception {
        try{
			ZdrewardrecordDAO dao = (ZdrewardrecordDAO) DAOFactory.build(ZdrewardrecordDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZdrewardrecordVO doUpdate(ZdrewardrecordVO vo, User user)
        throws Exception {
        try{
			ZdrewardrecordDAO dao = (ZdrewardrecordDAO) DAOFactory.build(ZdrewardrecordDAO.class, user);
            return (ZdrewardrecordVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZdrewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZdrewardrecordDAO dao = (ZdrewardrecordDAO) DAOFactory.build(ZdrewardrecordDAO.class, user);
        return (ZdrewardrecordVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ZdrewardrecordListVO params, User user)
        throws Exception {
			ZdrewardrecordDAO dao = (ZdrewardrecordDAO) DAOFactory.build(ZdrewardrecordDAO.class, user);
        return dao.doQuery(params);
    }
}
