/**
* auto-generated code
* Wed Aug 27 09:37:44 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.stdrewardbjlog.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.stdrewardbjlog.persistent.BBCstdrewardbjlogDAO;
import com.sunrise.boss.business.cms.bbc.stdrewardbjlog.persistent.BBCstdrewardbjlogListVO;
import com.sunrise.boss.business.cms.bbc.stdrewardbjlog.persistent.BBCstdrewardbjlogVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BBCstdrewardbjlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/stdrewardbjlog/control/BBCstdrewardbjlogControlBean"
 name="BBCstdrewardbjlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BBCstdrewardbjlogControlBean extends AbstractControlBean
    implements BBCstdrewardbjlogControl {

    public BBCstdrewardbjlogVO doCreate(BBCstdrewardbjlogVO vo, User user)
        throws Exception {
        try{
			BBCstdrewardbjlogDAO dao = (BBCstdrewardbjlogDAO) DAOFactory.build(BBCstdrewardbjlogDAO.class, user);
            // TODO  set the pk */
            return (BBCstdrewardbjlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(BBCstdrewardbjlogVO vo, User user)
        throws Exception {
        try{
			BBCstdrewardbjlogDAO dao = (BBCstdrewardbjlogDAO) DAOFactory.build(BBCstdrewardbjlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BBCstdrewardbjlogVO doUpdate(BBCstdrewardbjlogVO vo, User user)
        throws Exception {
        try{
			BBCstdrewardbjlogDAO dao = (BBCstdrewardbjlogDAO) DAOFactory.build(BBCstdrewardbjlogDAO.class, user);
            return (BBCstdrewardbjlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BBCstdrewardbjlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			BBCstdrewardbjlogDAO dao = (BBCstdrewardbjlogDAO) DAOFactory.build(BBCstdrewardbjlogDAO.class, user);
        return (BBCstdrewardbjlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(BBCstdrewardbjlogListVO params, User user)
        throws Exception {
			BBCstdrewardbjlogDAO dao = (BBCstdrewardbjlogDAO) DAOFactory.build(BBCstdrewardbjlogDAO.class, user);
        return dao.query(params);
    }
}
