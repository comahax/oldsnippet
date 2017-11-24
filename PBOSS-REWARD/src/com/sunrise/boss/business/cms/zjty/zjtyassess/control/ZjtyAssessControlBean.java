/**
* auto-generated code
* Thu Dec 29 14:47:31 CST 2011
*/
package com.sunrise.boss.business.cms.zjty.zjtyassess.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyassess.persistent.ZjtyAssessVO;
import com.sunrise.boss.business.cms.zjty.zjtyassess.persistent.ZjtyAssessDAO;
import com.sunrise.boss.business.cms.zjty.zjtyassess.persistent.ZjtyAssessListVO;

/**
 * <p>Title: ZjtyAssessControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtyassess/control/ZjtyAssessControlBean"
 name="ZjtyAssessControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyAssessControlBean extends AbstractControlBean
    implements ZjtyAssessControl {

    public ZjtyAssessVO doCreate(ZjtyAssessVO vo, User user)
        throws Exception {
        try{
			ZjtyAssessDAO dao = (ZjtyAssessDAO) DAOFactory.build(ZjtyAssessDAO.class, user);
            // TODO  set the pk */
            return (ZjtyAssessVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ZjtyAssessVO vo, User user)
        throws Exception {
        try{
			ZjtyAssessDAO dao = (ZjtyAssessDAO) DAOFactory.build(ZjtyAssessDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyAssessVO doUpdate(ZjtyAssessVO vo, User user)
        throws Exception {
        try{
			ZjtyAssessDAO dao = (ZjtyAssessDAO) DAOFactory.build(ZjtyAssessDAO.class, user);
            return (ZjtyAssessVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyAssessVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyAssessDAO dao = (ZjtyAssessDAO) DAOFactory.build(ZjtyAssessDAO.class, user);
        return (ZjtyAssessVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ZjtyAssessListVO params, User user)
        throws Exception {
			ZjtyAssessDAO dao = (ZjtyAssessDAO) DAOFactory.build(ZjtyAssessDAO.class, user);
        return dao.query(params);
    }
}
