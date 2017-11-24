/**
* auto-generated code
* Wed Aug 04 11:46:50 CST 2010
*/
package com.sunrise.boss.business.cms.bbc.bbcemplevel.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcemplevel.persistent.BbcEmplevelVO;
import com.sunrise.boss.business.cms.bbc.bbcemplevel.persistent.BbcEmplevelDAO;
import com.sunrise.boss.business.cms.bbc.bbcemplevel.persistent.BbcEmplevelListVO;

/**
 * <p>Title: BbcEmplevelControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/bbcemplevel/control/BbcEmplevelControlBean"
 name="BbcEmplevelControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BbcEmplevelControlBean extends AbstractControlBean
    implements BbcEmplevelControl {

    public BbcEmplevelVO doCreate(BbcEmplevelVO vo, User user)
        throws Exception {
        try{
			BbcEmplevelDAO dao = (BbcEmplevelDAO) DAOFactory.build(BbcEmplevelDAO.class, user);
            // TODO  set the pk */
            return (BbcEmplevelVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(BbcEmplevelVO vo, User user)
        throws Exception {
        try{
			BbcEmplevelDAO dao = (BbcEmplevelDAO) DAOFactory.build(BbcEmplevelDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BbcEmplevelVO doUpdate(BbcEmplevelVO vo, User user)
        throws Exception {
        try{
			BbcEmplevelDAO dao = (BbcEmplevelDAO) DAOFactory.build(BbcEmplevelDAO.class, user);
            return (BbcEmplevelVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BbcEmplevelVO doFindByPk(Serializable pk, User user)
        throws Exception {
			BbcEmplevelDAO dao = (BbcEmplevelDAO) DAOFactory.build(BbcEmplevelDAO.class, user);
        return (BbcEmplevelVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(BbcEmplevelListVO params, User user)
        throws Exception {
			BbcEmplevelDAO dao = (BbcEmplevelDAO) DAOFactory.build(BbcEmplevelDAO.class, user);
        return dao.query(params);
    }
}
