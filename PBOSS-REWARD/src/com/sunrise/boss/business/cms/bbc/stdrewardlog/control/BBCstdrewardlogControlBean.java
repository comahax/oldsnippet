/**
* auto-generated code
* Tue Aug 26 14:34:07 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.stdrewardlog.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.stdrewardlog.persistent.BBCstdrewardlogDAO;
import com.sunrise.boss.business.cms.bbc.stdrewardlog.persistent.BBCstdrewardlogListVO;
import com.sunrise.boss.business.cms.bbc.stdrewardlog.persistent.BBCstdrewardlogVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: StdrewardlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/stdrewardlog/control/BBCstdrewardlogControlBean"
 name="BBCstdrewardlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BBCstdrewardlogControlBean extends AbstractControlBean
    implements BBCstdrewardlogControl {

    public BBCstdrewardlogVO doCreate(BBCstdrewardlogVO vo, User user)
        throws Exception {
        try{
			BBCstdrewardlogDAO dao = (BBCstdrewardlogDAO) DAOFactory.build(BBCstdrewardlogDAO.class, user);
            // TODO  set the pk */
            return (BBCstdrewardlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(BBCstdrewardlogVO vo, User user)
        throws Exception {
        try{
        	BBCstdrewardlogDAO dao = (BBCstdrewardlogDAO) DAOFactory.build(BBCstdrewardlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BBCstdrewardlogVO doUpdate(BBCstdrewardlogVO vo, User user)
        throws Exception {
        try{
        	BBCstdrewardlogDAO dao = (BBCstdrewardlogDAO) DAOFactory.build(BBCstdrewardlogDAO.class, user);
            return (BBCstdrewardlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BBCstdrewardlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
    	BBCstdrewardlogDAO dao = (BBCstdrewardlogDAO) DAOFactory.build(BBCstdrewardlogDAO.class, user);
        return (BBCstdrewardlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(BBCstdrewardlogListVO params, User user)
        throws Exception {
    	BBCstdrewardlogDAO dao = (BBCstdrewardlogDAO) DAOFactory.build(BBCstdrewardlogDAO.class, user);
        return dao.query(params);
    }
}
