/**
* auto-generated code
* Wed Dec 14 10:29:07 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.hpolregistersucc.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.hpolregistersucc.persistent.HpolregistersuccVO;
import com.sunrise.boss.business.cms.bbc.hpolregistersucc.persistent.HpolregistersuccDAO;
import com.sunrise.boss.business.cms.bbc.hpolregistersucc.persistent.HpolregistersuccListVO;

/**
 * <p>Title: HpolregistersuccControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/hpolregistersucc/control/HpolregistersuccControlBean"
 name="HpolregistersuccControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class HpolregistersuccControlBean extends AbstractControlBean
    implements HpolregistersuccControl {

    public HpolregistersuccVO doCreate(HpolregistersuccVO vo, User user)
        throws Exception {
        try{
			HpolregistersuccDAO dao = (HpolregistersuccDAO) DAOFactory.build(HpolregistersuccDAO.class, user);
            // TODO  set the pk */
            return (HpolregistersuccVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(HpolregistersuccVO vo, User user)
        throws Exception {
        try{
			HpolregistersuccDAO dao = (HpolregistersuccDAO) DAOFactory.build(HpolregistersuccDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public HpolregistersuccVO doUpdate(HpolregistersuccVO vo, User user)
        throws Exception {
        try{
			HpolregistersuccDAO dao = (HpolregistersuccDAO) DAOFactory.build(HpolregistersuccDAO.class, user);
            return (HpolregistersuccVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public HpolregistersuccVO doFindByPk(Serializable pk, User user)
        throws Exception {
			HpolregistersuccDAO dao = (HpolregistersuccDAO) DAOFactory.build(HpolregistersuccDAO.class, user);
        return (HpolregistersuccVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(HpolregistersuccListVO params, User user)
        throws Exception {
			HpolregistersuccDAO dao = (HpolregistersuccDAO) DAOFactory.build(HpolregistersuccDAO.class, user);
        return dao.query(params);
    }
}
