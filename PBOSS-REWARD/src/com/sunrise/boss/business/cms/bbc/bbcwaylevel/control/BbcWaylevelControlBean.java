/**
* auto-generated code
* Mon Aug 02 10:12:57 CST 2010
*/
package com.sunrise.boss.business.cms.bbc.bbcwaylevel.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcwaylevel.persistent.BbcWaylevelVO;
import com.sunrise.boss.business.cms.bbc.bbcwaylevel.persistent.BbcWaylevelDAO;
import com.sunrise.boss.business.cms.bbc.bbcwaylevel.persistent.BbcWaylevelListVO;

/**
 * <p>Title: BbcWaylevelControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/bbcwaylevel/control/BbcWaylevelControlBean"
 name="BbcWaylevelControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BbcWaylevelControlBean extends AbstractControlBean
    implements BbcWaylevelControl {

    public BbcWaylevelVO doCreate(BbcWaylevelVO vo, User user)
        throws Exception {
        try{
			BbcWaylevelDAO dao = (BbcWaylevelDAO) DAOFactory.build(BbcWaylevelDAO.class, user);
            // TODO  set the pk */
            return (BbcWaylevelVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(BbcWaylevelVO vo, User user)
        throws Exception {
        try{
			BbcWaylevelDAO dao = (BbcWaylevelDAO) DAOFactory.build(BbcWaylevelDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BbcWaylevelVO doUpdate(BbcWaylevelVO vo, User user)
        throws Exception {
        try{
			BbcWaylevelDAO dao = (BbcWaylevelDAO) DAOFactory.build(BbcWaylevelDAO.class, user);
            return (BbcWaylevelVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BbcWaylevelVO doFindByPk(Serializable pk, User user)
        throws Exception {
			BbcWaylevelDAO dao = (BbcWaylevelDAO) DAOFactory.build(BbcWaylevelDAO.class, user);
        return (BbcWaylevelVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(BbcWaylevelListVO params, User user)
        throws Exception {
			BbcWaylevelDAO dao = (BbcWaylevelDAO) DAOFactory.build(BbcWaylevelDAO.class, user);
        return dao.query(params);
    }
}
